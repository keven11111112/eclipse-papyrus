/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
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

package org.eclipse.papyrus.aof.sync.internal;

import javax.inject.Inject;

import org.eclipse.papyrus.aof.sync.ICorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.ISyncCorrespondenceResolver;

/**
 * Adapter for an {@link ICorrespondenceResolver} that happens to satisfy the contract of the
 * {@link ISyncCorrespondenceResolver} but does not implement that interface.
 */
public final class SyncCorrespondenceResolverAdapter<E, C> implements ISyncCorrespondenceResolver<E, C> {
	private final ICorrespondenceResolver<E, E, C> delegate;

	@Inject
	public SyncCorrespondenceResolverAdapter(ICorrespondenceResolver<E, E, C> delegate) {
		super();

		this.delegate = delegate;
	}

	@Override
	public E getCorrespondent(E element, C parentContext) {
		return delegate.getCorrespondent(element, parentContext);
	}
}
