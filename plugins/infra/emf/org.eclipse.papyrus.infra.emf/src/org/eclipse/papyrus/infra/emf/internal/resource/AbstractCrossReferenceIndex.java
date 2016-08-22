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

import java.util.Collections;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.emf.resource.ICrossReferenceIndex;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;

/**
 * Common implementation of a cross-reference index in the workspace.
 */
public abstract class AbstractCrossReferenceIndex implements ICrossReferenceIndex {

	public static final String SHARD_ANNOTATION_SOURCE = "http://www.eclipse.org/papyrus/2016/resource/shard"; //$NON-NLS-1$

	static final int MAX_INDEX_JOBS = 5;

	final Object sync = new Object();

	final SetMultimap<URI, URI> outgoingReferences = HashMultimap.create();
	final SetMultimap<URI, URI> incomingReferences = HashMultimap.create();

	final SetMultimap<URI, URI> resourceToShards = HashMultimap.create();
	final SetMultimap<URI, URI> shardToParents = HashMultimap.create();

	// These are abstracted as URIs without extension
	SetMultimap<URI, URI> aggregateOutgoingReferences;
	SetMultimap<URI, URI> aggregateIncomingReferences;
	SetMultimap<URI, URI> aggregateResourceToShards;
	SetMultimap<URI, URI> aggregateShardToParents;
	final SetMultimap<URI, String> shards = HashMultimap.create();

	/**
	 * Initializes me.
	 */
	AbstractCrossReferenceIndex() {
		super();
	}

	//
	// Queries
	//

	@Override
	public ListenableFuture<SetMultimap<URI, URI>> getOutgoingCrossReferencesAsync() {
		return afterIndex(getOutgoingCrossReferencesCallable());
	}

	@Override
	public SetMultimap<URI, URI> getOutgoingCrossReferences() throws CoreException {
		return sync(afterIndex(getOutgoingCrossReferencesCallable()));
	}

	Callable<SetMultimap<URI, URI>> getOutgoingCrossReferencesCallable() {
		return sync(() -> ImmutableSetMultimap.copyOf(outgoingReferences));
	}

	@Override
	public ListenableFuture<Set<URI>> getOutgoingCrossReferencesAsync(URI resourceURI) {
		return afterIndex(getOutgoingCrossReferencesCallable(resourceURI));
	}

	@Override
	public Set<URI> getOutgoingCrossReferences(URI resourceURI) throws CoreException {
		return sync(afterIndex(getOutgoingCrossReferencesCallable(resourceURI)));
	}

	Callable<Set<URI>> getOutgoingCrossReferencesCallable(URI resourceURI) {
		return sync(() -> {
			String ext = resourceURI.fileExtension();
			URI withoutExt = resourceURI.trimFileExtension();
			Set<URI> result = getAggregateOutgoingCrossReferences().get(withoutExt).stream()
					.map(uri -> uri.appendFileExtension(ext))
					.collect(Collectors.toSet());

			return Collections.unmodifiableSet(result);
		});
	}

	SetMultimap<URI, URI> getAggregateOutgoingCrossReferences() {
		SetMultimap<URI, URI> result;

		synchronized (sync) {
			if (aggregateOutgoingReferences == null) {
				// Compute the aggregate now
				aggregateOutgoingReferences = HashMultimap.create();
				for (Map.Entry<URI, URI> next : outgoingReferences.entries()) {
					aggregateOutgoingReferences.put(next.getKey().trimFileExtension(),
							next.getValue().trimFileExtension());
				}
			}

			result = aggregateOutgoingReferences;
		}

		return result;
	}

	@Override
	public ListenableFuture<SetMultimap<URI, URI>> getIncomingCrossReferencesAsync() {
		return afterIndex(getIncomingCrossReferencesCallable());
	}

	@Override
	public SetMultimap<URI, URI> getIncomingCrossReferences() throws CoreException {
		return sync(afterIndex(getIncomingCrossReferencesCallable()));
	}

	Callable<SetMultimap<URI, URI>> getIncomingCrossReferencesCallable() {
		return sync(() -> ImmutableSetMultimap.copyOf(incomingReferences));
	}

	@Override
	public ListenableFuture<Set<URI>> getIncomingCrossReferencesAsync(URI resourceURI) {
		return afterIndex(getIncomingCrossReferencesCallable(resourceURI));
	}

	@Override
	public Set<URI> getIncomingCrossReferences(URI resourceURI) throws CoreException {
		return sync(afterIndex(getIncomingCrossReferencesCallable(resourceURI)));
	}

	Callable<Set<URI>> getIncomingCrossReferencesCallable(URI resourceURI) {
		return sync(() -> {
			String ext = resourceURI.fileExtension();
			URI withoutExt = resourceURI.trimFileExtension();
			Set<URI> result = getAggregateIncomingCrossReferences().get(withoutExt).stream()
					.map(uri -> uri.appendFileExtension(ext))
					.collect(Collectors.toSet());

			return Collections.unmodifiableSet(result);
		});
	}

	SetMultimap<URI, URI> getAggregateIncomingCrossReferences() {
		SetMultimap<URI, URI> result;

		synchronized (sync) {
			if (aggregateIncomingReferences == null) {
				// Compute the aggregate now
				aggregateIncomingReferences = HashMultimap.create();
				for (Map.Entry<URI, URI> next : incomingReferences.entries()) {
					aggregateIncomingReferences.put(next.getKey().trimFileExtension(),
							next.getValue().trimFileExtension());
				}
			}

			result = aggregateIncomingReferences;
		}

		return result;
	}

	@Override
	public ListenableFuture<Boolean> isShardAsync(URI resourceURI) {
		return afterIndex(getIsShardCallable(resourceURI));
	}

	@Override
	public boolean isShard(URI resourceURI) throws CoreException {
		return sync(afterIndex(getIsShardCallable(resourceURI)));
	}

	final <V> V sync(Future<V> future) throws CoreException {
		try {
			return future.get();
		} catch (InterruptedException e) {
			throw new CoreException(Status.CANCEL_STATUS);
		} catch (ExecutionException e) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Failed to access the resource shard index", e));
		}
	}

	Callable<Boolean> getIsShardCallable(URI shardURI) {
		return sync(() -> isShard0(shardURI.trimFileExtension()));
	}

	boolean isShard0(URI uriWithoutExtension) {
		return !shards.get(uriWithoutExtension).isEmpty();
	}

	void setShard(URI resourceURI, boolean isShard) {
		if (isShard) {
			shards.put(resourceURI.trimFileExtension(), resourceURI.fileExtension());
		} else {
			shards.remove(resourceURI.trimFileExtension(), resourceURI.fileExtension());
		}
	}

	@Override
	public ListenableFuture<SetMultimap<URI, URI>> getShardsAsync() {
		return afterIndex(getShardsCallable());
	}

	@Override
	public SetMultimap<URI, URI> getShards() throws CoreException {
		return sync(afterIndex(getShardsCallable()));
	}

	Callable<SetMultimap<URI, URI>> getShardsCallable() {
		return sync(() -> ImmutableSetMultimap.copyOf(resourceToShards));
	}

	@Override
	public ListenableFuture<Set<URI>> getShardsAsync(URI resourceURI) {
		return afterIndex(getShardsCallable(resourceURI));
	}

	@Override
	public Set<URI> getShards(URI resourceURI) throws CoreException {
		return sync(afterIndex(getShardsCallable(resourceURI)));
	}

	Callable<Set<URI>> getShardsCallable(URI shardURI) {
		return sync(() -> {
			String ext = shardURI.fileExtension();
			URI withoutExt = shardURI.trimFileExtension();
			Set<URI> result = getAggregateShards().get(withoutExt).stream()
					// Only those that actually are shards
					.filter(AbstractCrossReferenceIndex.this::isShard0)
					.map(uri -> uri.appendFileExtension(ext))
					.collect(Collectors.toSet());

			return Collections.unmodifiableSet(result);
		});
	}

	SetMultimap<URI, URI> getAggregateShards() {
		SetMultimap<URI, URI> result;

		synchronized (sync) {
			if (aggregateResourceToShards == null) {
				// Compute the aggregate now
				aggregateResourceToShards = HashMultimap.create();
				for (Map.Entry<URI, URI> next : resourceToShards.entries()) {
					aggregateResourceToShards.put(next.getKey().trimFileExtension(),
							next.getValue().trimFileExtension());
				}
			}

			result = aggregateResourceToShards;
		}

		return result;
	}

	@Override
	public ListenableFuture<Set<URI>> getParentsAsync(URI shardURI) {
		return afterIndex(getParentsCallable(shardURI));
	}

	@Override
	public Set<URI> getParents(URI shardURI) throws CoreException {
		return sync(afterIndex(getParentsCallable(shardURI)));
	}

	Callable<Set<URI>> getParentsCallable(URI shardURI) {
		return sync(() -> {
			Set<URI> result;
			URI withoutExt = shardURI.trimFileExtension();

			// If it's not a shard, it has no parents, by definition
			if (!isShard0(withoutExt)) {
				result = Collections.emptySet();
			} else {
				String ext = shardURI.fileExtension();
				result = getAggregateShardToParents().get(withoutExt).stream()
						.map(uri -> uri.appendFileExtension(ext))
						.collect(Collectors.toSet());
				result = Collections.unmodifiableSet(result);
			}

			return result;
		});
	}

	SetMultimap<URI, URI> getAggregateShardToParents() {
		SetMultimap<URI, URI> result;

		synchronized (sync) {
			if (aggregateShardToParents == null) {
				// Compute the aggregate now
				aggregateShardToParents = HashMultimap.create();
				for (Map.Entry<URI, URI> next : shardToParents.entries()) {
					aggregateShardToParents.put(next.getKey().trimFileExtension(),
							next.getValue().trimFileExtension());
				}
			}

			result = aggregateShardToParents;
		}

		return result;
	}

	@Override
	public ListenableFuture<Set<URI>> getRootsAsync(URI shardURI) {
		return afterIndex(getRootsCallable(shardURI));
	}

	@Override
	public Set<URI> getRoots(URI shardURI) throws CoreException {
		return sync(afterIndex(getRootsCallable(shardURI)));
	}

	@Override
	public Set<URI> getRoots(URI shardURI, ICrossReferenceIndex alternate) throws CoreException {
		if (alternate == this) {
			throw new IllegalArgumentException("self alternate"); //$NON-NLS-1$
		}

		Callable<Set<URI>> elseCallable = (alternate == null)
				? null
				: () -> alternate.getRoots(shardURI);

		return ifAvailable(getRootsCallable(shardURI), elseCallable);
	}

	Callable<Set<URI>> getRootsCallable(URI shardURI) {
		return sync(() -> {
			Set<URI> result;
			URI withoutExt = shardURI.trimFileExtension();

			// If it's not a shard, it has no roots, by definition
			if (!isShard0(withoutExt)) {
				result = Collections.emptySet();
			} else {
				// TODO: Cache this?
				ImmutableSet.Builder<URI> resultBuilder = ImmutableSet.builder();

				SetMultimap<URI, URI> shardToParents = getAggregateShardToParents();

				// Breadth-first search of the parent graph
				Queue<URI> queue = Lists.newLinkedList();
				Set<URI> cycleDetect = Sets.newHashSet();
				String ext = shardURI.fileExtension();
				queue.add(withoutExt);

				for (URI next = queue.poll(); next != null; next = queue.poll()) {
					if (cycleDetect.add(next)) {
						if (shardToParents.containsKey(next)) {
							queue.addAll(shardToParents.get(next));
						} else {
							// It's a root
							resultBuilder.add(next.appendFileExtension(ext));
						}
					}
				}

				result = resultBuilder.build();
			}

			return result;
		});
	}

	final <V> Callable<V> sync(Callable<V> callable) {
		return (callable instanceof SyncCallable)
				? callable // Don't re-wrap for sync
				: new SyncCallable<V>() {
					@Override
					protected V doCall() throws Exception {
						return callable.call();
					}
				};
	}

	//
	// Indexing
	//

	abstract <V> ListenableFuture<V> afterIndex(Callable<V> callable);

	abstract <V> V ifAvailable(Callable<V> callable, Callable<? extends V> elseCallable) throws CoreException;

	//
	// Nested types
	//

	private abstract class SyncCallable<V> implements Callable<V> {
		@Override
		public final V call() throws Exception {
			synchronized (sync) {
				return doCall();
			}
		}

		protected abstract V doCall() throws Exception;
	}
}
