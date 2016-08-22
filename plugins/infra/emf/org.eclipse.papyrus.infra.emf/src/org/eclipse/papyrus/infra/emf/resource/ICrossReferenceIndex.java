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

package org.eclipse.papyrus.infra.emf.resource;

import static org.eclipse.papyrus.infra.emf.internal.resource.InternalIndexUtil.getSemanticModelFileExtensions;

import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.emf.internal.resource.CrossReferenceIndex;
import org.eclipse.papyrus.infra.emf.internal.resource.OnDemandCrossReferenceIndex;

import com.google.common.collect.SetMultimap;
import com.google.common.util.concurrent.ListenableFuture;


/**
 * API for an index of cross-resource proxy references in the workspace, especially
 * containment proxies of the "shard" variety: controlled units that are not openable
 * in their own editors but must be opened from the root resource of the controlled unit
 * graph.
 * 
 * @since 2.1
 */
public interface ICrossReferenceIndex {

	/**
	 * Obtains the cross-reference index for the given resource set.
	 * 
	 * @param resourceSet
	 *            a resource-set in which resources are managed on which
	 *            cross-reference queries are to be applied, or {@code null}
	 *            if there is no contextual resource set, in which case
	 *            the default heuristic- or otherwise-determined kinds of
	 *            resources will be indexed
	 */
	static ICrossReferenceIndex getInstance(ResourceSet resourceSet) {
		ICrossReferenceIndex result;

		if (!EcorePlugin.IS_ECLIPSE_RUNNING || Job.getJobManager().isSuspended()) {
			// We cannot rely on jobs and the workspace to calculate the index
			// in the background
			result = new OnDemandCrossReferenceIndex(getSemanticModelFileExtensions(resourceSet));
		} else {
			result = CrossReferenceIndex.getInstance();
		}

		return result;
	}

	/**
	 * Obtains an index to use as a back-up in operations such as
	 * {@link #getRoots(URI, ICrossReferenceIndex)}. Some indices do not require
	 * back-ups because they are always available, in which case the alternate
	 * is just {@code null}. In this case, the intended operation can usually
	 * just be invoked with this {@code null} alternate for correct behaviour.
	 * 
	 * @param index
	 *            an index
	 * @param resourceSet
	 *            a resource-set in which resources are managed on which
	 *            cross-reference queries are to be applied, or {@code null}
	 *            if there is no contextual resource set, in which case
	 *            the default heuristic- or otherwise-determined kinds of
	 *            resources will be indexed
	 * 
	 * @return the best alternate in case the {@code index} is not ready to
	 *         provide a result, or {@code null} if the {@code index} is expected
	 *         always to be ready (thus not needing an alternate)
	 */
	static ICrossReferenceIndex getAlternate(ICrossReferenceIndex index, ResourceSet resourceSet) {
		return (index instanceof OnDemandCrossReferenceIndex)
				? null
				: new OnDemandCrossReferenceIndex(resourceSet);
	}

	/**
	 * Asynchronously queries the mapping of URIs of resources to URIs of others
	 * that they cross-reference to.
	 * 
	 * @return a future result of the mapping of resource URIs to cross-referenced URIs
	 */
	ListenableFuture<SetMultimap<URI, URI>> getOutgoingCrossReferencesAsync();

	/**
	 * Queries the mapping of URIs of resources to URIs of others
	 * that they cross-reference to.
	 * 
	 * @return the mapping of resource URIs to cross-referenced URIs URIs
	 * 
	 * @throws CoreException
	 *             if the index either fails to compute the cross-references or if
	 *             the calling thread is interrupted in waiting for the result
	 */
	SetMultimap<URI, URI> getOutgoingCrossReferences() throws CoreException;

	/**
	 * Asynchronously queries the URIs of other resources that a given resource
	 * cross-references to.
	 * 
	 * @param resourceURI
	 *            the URI of a resource
	 * @return a future result of the resource URIs that it cross-references to
	 */
	ListenableFuture<Set<URI>> getOutgoingCrossReferencesAsync(URI resourceURI);

	/**
	 * Queries the URIs of other resources that a given resource
	 * cross-references to.
	 * 
	 * @param resourceURI
	 *            the URI of a resource
	 * @return the resource URIs that it cross-references to
	 * 
	 * @throws CoreException
	 *             if the index either fails to compute the cross-references or if
	 *             the calling thread is interrupted in waiting for the result
	 */
	Set<URI> getOutgoingCrossReferences(URI resourceURI) throws CoreException;

	/**
	 * Asynchronously queries the mapping of URIs of resources to URIs of others
	 * from which they are cross-referenced.
	 * 
	 * @return a future result of the mapping of resource URIs to cross-referencing URIs
	 */
	ListenableFuture<SetMultimap<URI, URI>> getIncomingCrossReferencesAsync();

	/**
	 * Queries the mapping of URIs of resources to URIs of others
	 * from which they are cross-referenced.
	 * 
	 * @return the mapping of resource URIs to cross-referencing URIs
	 * 
	 * @throws CoreException
	 *             if the index either fails to compute the cross-references or if
	 *             the calling thread is interrupted in waiting for the result
	 */
	SetMultimap<URI, URI> getIncomingCrossReferences() throws CoreException;

	/**
	 * Asynchronously queries the URIs of other resources that cross-reference to
	 * a given resource.
	 * 
	 * @param resourceURI
	 *            the URI of a resource
	 * @return a future result of the resource URIs that cross-reference to it
	 */
	ListenableFuture<Set<URI>> getIncomingCrossReferencesAsync(URI resourceURI);

	/**
	 * Queries the URIs of other resources that cross-reference to
	 * a given resource.
	 * 
	 * @param resourceURI
	 *            the URI of a resource
	 * @return the resource URIs that cross-reference to it
	 * 
	 * @throws CoreException
	 *             if the index either fails to compute the cross-references or if
	 *             the calling thread is interrupted in waiting for the result
	 */
	Set<URI> getIncomingCrossReferences(URI resourceURI) throws CoreException;

	/**
	 * Asynchronously queries whether a resource is a "shard".
	 * 
	 * @param resourceURI
	 *            the URI of a resource
	 * @return a future result of whether the resource is a "shard"
	 */
	ListenableFuture<Boolean> isShardAsync(URI resourceURI);

	/**
	 * Queries whether a resource is a "shard".
	 * 
	 * @param resourceURI
	 *            the URI of a resource
	 * @return whether the resource is a "shard"
	 * 
	 * @throws CoreException
	 *             if the index either fails to compute the shard-ness or if
	 *             the calling thread is interrupted in waiting for the result
	 */
	boolean isShard(URI resourceURI) throws CoreException;

	/**
	 * Asynchronously queries the mapping of URIs of resources to URIs of shards that are their immediate
	 * children.
	 * 
	 * @return a future result of the mapping of resource URIs to shard URIs
	 */
	ListenableFuture<SetMultimap<URI, URI>> getShardsAsync();

	/**
	 * Queries the mapping of URIs of resources to URIs of shards that are their immediate
	 * children.
	 * 
	 * @return the mapping of resource URIs to shard URIs
	 * 
	 * @throws CoreException
	 *             if the index either fails to compute the shards or if
	 *             the calling thread is interrupted in waiting for the result
	 */
	SetMultimap<URI, URI> getShards() throws CoreException;

	/**
	 * Asynchronously queries the URIs of resources that are immediate shards of a
	 * given resource.
	 * 
	 * @param resourceURI
	 *            the URI of a resource
	 * @return a future result of the URIs of shards that are its immediate children
	 */
	ListenableFuture<Set<URI>> getShardsAsync(URI resourceURI);

	/**
	 * Queries the URIs of resources that are immediate shards of a
	 * given resource.
	 * 
	 * @param resourceURI
	 *            the URI of a resource
	 * @return the URIs of shards that are its immediate children
	 * 
	 * @throws CoreException
	 *             if the index either fails to compute the shards or if
	 *             the calling thread is interrupted in waiting for the result
	 */
	Set<URI> getShards(URI resourceURI) throws CoreException;

	/**
	 * Asynchronously queries URIs of resources that are immediate parents of a given
	 * (potential) shard resource.
	 * 
	 * @param shardURI
	 *            the URI of a potential shard resource. It needs not necessarily actually
	 *            be a shard, in which case it trivially wouldn't have any parents
	 * @return the future result of the URIs of resources that are immediate parents of
	 *         the shard
	 */
	ListenableFuture<Set<URI>> getParentsAsync(URI shardURI);

	/**
	 * Queries URIs of resources that are immediate parents of a given
	 * (potential) shard resource.
	 * 
	 * @param shardURI
	 *            the URI of a potential shard resource. It needs not necessarily actually
	 *            be a shard, in which case it trivially wouldn't have any parents
	 * @return the URIs of resources that are immediate parents of
	 *         the shard
	 * 
	 * @throws CoreException
	 *             if the index either fails to compute the parents or if
	 *             the calling thread is interrupted in waiting for the result
	 */
	Set<URI> getParents(URI shardURI) throws CoreException;

	/**
	 * Asynchronously queries URIs of resources that are roots (ultimate parents) of a given
	 * (potential) shard resource.
	 * 
	 * @param shardURI
	 *            the URI of a potential shard resource. It needs not necessarily actually
	 *            be a shard, in which case it trivially wouldn't have any parents
	 * @return the future result of the URIs of resources that are roots of its parent graph
	 */
	ListenableFuture<Set<URI>> getRootsAsync(URI shardURI);

	/**
	 * Queries URIs of resources that are roots (ultimate parents) of a given
	 * (potential) shard resource.
	 * 
	 * @param shardURI
	 *            the URI of a potential shard resource. It needs not necessarily actually
	 *            be a shard, in which case it trivially wouldn't have any parents
	 * @return the URIs of resources that are roots of its parent graph
	 * 
	 * @throws CoreException
	 *             if the index either fails to compute the roots or if
	 *             the calling thread is interrupted in waiting for the result
	 */
	Set<URI> getRoots(URI shardURI) throws CoreException;

	/**
	 * Attempts to queries URIs of resources that are roots (ultimate parents) of a given
	 * (potential) shard resource. If the receiver is not ready to provide a complete
	 * and/or correct result, then fall back to an {@code alternate}, if any.
	 * 
	 * @param shardURI
	 *            the URI of a potential shard resource. It needs not necessarily actually
	 *            be a shard, in which case it trivially wouldn't have any parents
	 * @param alternate
	 *            a fall-back index from which to get the roots if I am not ready
	 *            to provide them, or {@code null} if not required
	 * @return the URIs of resources that are roots of its parent graph, or {@code null}
	 *         if the receiver cannot provide a result and there is no {@code alternate}.
	 *         Note that {@code null} is only returned in this failure case; any successful
	 *         result is at least an empty set
	 * 
	 * @throws CoreException
	 *             if the index is not available and the {@code alternate} fails
	 * @throws IllegalArgumentException
	 *             if the {@code alternate} is myself (attempted recursion)
	 */
	Set<URI> getRoots(URI shardURI, ICrossReferenceIndex alternate) throws CoreException;
}
