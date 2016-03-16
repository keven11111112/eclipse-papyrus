/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and Implementation
 *****************************************************************************/

package org.eclipse.papyrus.uml.profile.index;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.emf.resource.index.IWorkspaceModelIndexListener;
import org.eclipse.papyrus.infra.emf.resource.index.IWorkspaceModelIndexProvider;
import org.eclipse.papyrus.infra.emf.resource.index.WorkspaceModelIndex;
import org.eclipse.papyrus.infra.emf.resource.index.WorkspaceModelIndex.IndexHandler;
import org.eclipse.papyrus.uml.profile.Activator;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * {@link WorkspaceModelIndex} for {@link Profile} model.
 *
 */
public class ProfileWorkspaceModelIndex {

	/** The workspace model index */
	private WorkspaceModelIndex<URI> index;

	/** The instance. */
	private static final ProfileWorkspaceModelIndex INSTANCE = new ProfileWorkspaceModelIndex();

	String[] profileExtension = { "profile.uml" };//$NON-NLS-1$

	/**
	 * Constructor.
	 */
	private ProfileWorkspaceModelIndex() {
		index = new WorkspaceModelIndex<URI>("PapyrusWorkspaceProfiles", UMLPackage.eCONTENT_TYPE, indexer()); //$NON-NLS-1$
	}

	/**
	 * @return the indexer.
	 */
	protected IndexHandler<URI> indexer() {
		return new IndexHandler<URI>() {

			@Override
			public URI index(final IFile file) {
				return URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			}

			@Override
			public void unindex(final IFile file) {
				// DO nothing
			}

			@Override
			public boolean shouldIndex(IFile file) {
				return file.getFullPath().lastSegment().contains(".profile.uml"); //$NON-NLS-1$
			};

		};
	}

	/**
	 * Gets the instance of {@link ProfileWorkspaceModelIndex}.
	 */
	public static ProfileWorkspaceModelIndex getInstance() {
		return INSTANCE;
	}

	/**
	 * Gets all {@link Profile}s available in eclipse workspace.
	 */
	public Collection<URI> getWorkspaceProfilesURIs() {
		Collection<URI> profiles = new ArrayList<URI>();
		try {
			profiles = index.getIndex().get().values();
		} catch (InterruptedException | ExecutionException e) {
			Activator.log.error(e);
		}
		return profiles;
	}

	/**
	 * dispose index and loaded resources.
	 */
	public void dispose() {
		index.dispose();
	}

	/**
	 * @return The index.
	 */
	public WorkspaceModelIndex<URI> getIndex() {
		return index;
	}

	/**
	 * Adds listener to the index.
	 */
	public void addListener(final IWorkspaceModelIndexListener listener) {
		index.addListener(listener);
	}

	/**
	 * Removes listener to the index.
	 */
	public void removeListener(final IWorkspaceModelIndexListener listener) {
		index.removeListener(listener);
	}

	/**
	 * Index provider on the extension point.
	 */
	public static final class IndexProvider implements IWorkspaceModelIndexProvider {
		@Override
		public WorkspaceModelIndex<?> get() {
			return ProfileWorkspaceModelIndex.INSTANCE.index;
		}
	}
}
