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

import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.ISyncMapping;

/**
 * Adapter for an {@link IMapping} that happens to satisfy the contract of the
 * {@link ISyncMapping} but does not implement that interface.
 */
public final class SyncMappingAdapter<E> implements ISyncMapping<E> {
	private final IMapping<E, E> delegate;

	@Inject
	public SyncMappingAdapter(IMapping<E, E> delegate) {
		super();

		this.delegate = delegate;
	}

	@Override
	public Instance<E, E> map(E from, E to) {
		return delegate.map(from, to);
	}
}
