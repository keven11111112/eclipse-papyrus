/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.emf.internal.resource;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.emf.resource.index.IWorkspaceModelIndexProvider;
import org.eclipse.papyrus.infra.emf.resource.index.WorkspaceModelIndex;
import org.eclipse.papyrus.infra.emf.resource.index.WorkspaceModelIndex.PersistentIndexHandler;
import org.xml.sax.helpers.DefaultHandler;

import com.google.common.util.concurrent.ListenableFuture;

/**
 * An index of cross-resource references in the workspace.
 */
public class CrossReferenceIndex extends AbstractCrossReferenceIndex {

	private static final CrossReferenceIndex INSTANCE = new CrossReferenceIndex();

	private final WorkspaceModelIndex<CrossReferencedFile> index;

	/**
	 * Not instantiable by clients.
	 */
	private CrossReferenceIndex() {
		super();

		// TODO: Is there a constant somewhere for the XMI content-type?
		index = new WorkspaceModelIndex<>(
				"papyrusCrossRefs", //$NON-NLS-1$
				"org.eclipse.emf.ecore.xmi", //$NON-NLS-1$
				null, indexer(), MAX_INDEX_JOBS);
	}

	public void dispose() {
		index.dispose();
	}

	public static CrossReferenceIndex getInstance() {
		return INSTANCE;
	}

	//
	// Indexing
	//

	@Override
	<V> ListenableFuture<V> afterIndex(Callable<V> callable) {
		return index.afterIndex(callable);
	}

	<V> V ifAvailable(Callable<V> callable, Callable<? extends V> elseCallable) throws CoreException {
		V result = null;

		// if available, need nonetheless to be synchronized on our internal lock
		result = index.ifAvailable(sync(callable));

		if ((result == null) && (elseCallable != null)) {
			try {
				result = elseCallable.call();
			} catch (CoreException e) {
				throw e;
			} catch (Exception e) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
			}
		}

		return result;
	}

	private void runIndexHandler(IFile file, URI resourceURI, DefaultHandler handler) {
		try (InputStream input = file.getContents()) {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(false);
			factory.setNamespaceAware(true);
			SAXParser parser = factory.newSAXParser();

			parser.parse(input, handler, resourceURI.toString());
		} catch (Exception e) {
			Activator.log.error("Exception in indexing resource", e); //$NON-NLS-1$
		}
	}

	private boolean indexResource(IFile file, CrossReferencedFile index) {
		boolean result = true;

		final URI resourceURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);

		synchronized (sync) {
			// unindex the resource
			unindexResource(file);

			// update the forward mapping
			resourceToShards.putAll(resourceURI, index.getShards());
			outgoingReferences.putAll(resourceURI, index.getCrossReferences());

			// and the reverse mapping
			for (URI next : index.getShards()) {
				shardToParents.put(next, resourceURI);
			}
			for (URI next : index.getCrossReferences()) {
				incomingReferences.put(next, resourceURI);
			}

			// Is it actually a shard style? (we index all cross-resource containment)
			setShard(resourceURI, index.isShard());
		}

		return result;
	}

	private CrossReferencedFile indexResource(IFile file) {
		final URI resourceURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);

		CrossReferenceIndexHandler handler = new CrossReferenceIndexHandler(resourceURI);
		runIndexHandler(file, resourceURI, handler);

		CrossReferencedFile result = new CrossReferencedFile(handler);
		indexResource(file, result);

		return result;
	}

	private void unindexResource(IFile file) {
		final URI resourceURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);

		synchronized (sync) {
			// purge the aggregates (for model-set "resource without URI")
			aggregateResourceToShards = null;
			aggregateShardToParents = null;
			aggregateOutgoingReferences = null;
			aggregateIncomingReferences = null;
			setShard(resourceURI, false);

			// And remove all traces of this resource
			resourceToShards.removeAll(resourceURI);
			outgoingReferences.removeAll(resourceURI);

			// the multimap's entry collection that underlies the key-set
			// is modified as we go, so take a safe copy of the keys
			for (URI next : new ArrayList<>(shardToParents.keySet())) {
				shardToParents.remove(next, resourceURI);
			}
			for (URI next : new ArrayList<>(incomingReferences.keySet())) {
				incomingReferences.remove(next, resourceURI);
			}
		}
	}

	private PersistentIndexHandler<CrossReferencedFile> indexer() {
		return new PersistentIndexHandler<CrossReferencedFile>() {
			@Override
			public CrossReferencedFile index(IFile file) {
				return indexResource(file);
			}

			@Override
			public void unindex(IFile file) {
				CrossReferenceIndex.this.unindexResource(file);
			}

			@Override
			public boolean load(IFile file, CrossReferencedFile index) {
				return CrossReferenceIndex.this.indexResource(file, index);
			}
		};
	}

	//
	// Nested types
	//

	static final class CrossReferencedFile implements Serializable {
		private static final long serialVersionUID = 1L;

		private boolean isShard;
		private Set<String> crossReferences;
		private Set<String> shards;

		private transient Set<URI> crossReferenceURIs;
		private transient Set<URI> shardURIs;

		CrossReferencedFile(CrossReferenceIndexHandler handler) {
			super();

			this.isShard = handler.isShard();
			this.crossReferences = handler.getCrossReferences();
			this.shards = handler.getShards();
		}

		boolean isShard() {
			return isShard;
		}

		Set<URI> getCrossReferences() {
			if (crossReferenceURIs == null) {
				crossReferenceURIs = crossReferences.stream()
						.map(URI::createURI)
						.collect(Collectors.toSet());
			}
			return crossReferenceURIs;
		}

		Set<URI> getShards() {
			if (shardURIs == null) {
				shardURIs = shards.stream()
						.map(URI::createURI)
						.collect(Collectors.toSet());
			}
			return shardURIs;
		}
	}

	/**
	 * Index provider on the extension point.
	 */
	public static final class IndexProvider implements IWorkspaceModelIndexProvider {
		@Override
		public WorkspaceModelIndex<?> get() {
			return CrossReferenceIndex.INSTANCE.index;
		}
	}
}
