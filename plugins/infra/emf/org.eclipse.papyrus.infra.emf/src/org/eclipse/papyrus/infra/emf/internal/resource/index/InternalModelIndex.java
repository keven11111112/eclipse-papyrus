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

package org.eclipse.papyrus.infra.emf.internal.resource.index;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.concurrent.Callable;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.papyrus.infra.emf.resource.index.WorkspaceModelIndex;

import com.google.common.util.concurrent.ListenableFuture;

/**
 * Internal implementation details of a {@link WorkspaceModelIndex}.
 */
public abstract class InternalModelIndex {

	private final QualifiedName indexKey;
	private final int maxIndexJobs;

	/** My manager. */
	private IndexManager manager;

	/** A class loader that knows the classes of the owner (bundle) context. */
	private ClassLoader ownerClassLoader;

	/**
	 * Initializes me.
	 */
	public InternalModelIndex(QualifiedName indexKey, int maxIndexJobs) {
		super();

		this.indexKey = indexKey;
		this.maxIndexJobs = maxIndexJobs;
	}

	/**
	 * Initializes me.
	 */
	public InternalModelIndex(QualifiedName indexKey) {
		this(indexKey, 0);
	}

	public final QualifiedName getIndexKey() {
		return indexKey;
	}

	public final int getMaxIndexJobs() {
		return maxIndexJobs;
	}

	protected final IContentType[] getContentTypes(IFile file) {
		return manager.getContentTypes(file);
	}

	/**
	 * Obtains an asynchronous future result that is scheduled to run after
	 * any pending indexing work has completed.
	 * 
	 * @param callable
	 *            the operation to schedule
	 * 
	 * @return the future result of the operation
	 */
	protected <V> ListenableFuture<V> afterIndex(final Callable<V> callable) {
		return manager.afterIndex(this, callable);
	}

	void setOwnerClassLoader(ClassLoader ownerClassLoader) {
		this.ownerClassLoader = ownerClassLoader;
	}

	protected final ObjectInputStream createObjectInput(InputStream underlying) throws IOException {
		return (ownerClassLoader == null)
				? new ObjectInputStream(underlying)
				: new ObjectInputStream(underlying) {
					@Override
					protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
						return Class.forName(desc.getName(), true, ownerClassLoader);
					}
				};
	}

	protected abstract void dispose();

	void start(IndexManager manager) {
		this.manager = manager;
		start();
	}

	protected abstract void start();

	protected abstract boolean match(IFile file);

	protected abstract void process(IFile file) throws CoreException;

	protected abstract void remove(IProject project, IFile file) throws CoreException;

	protected abstract void remove(IProject project) throws CoreException;
}
