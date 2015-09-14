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

package org.eclipse.papyrus.aof.sync;

/**
 * A simple correspondence resolver in which the source and target types are the same,
 * which is particularly useful for synchronizing two models of the same kind.
 *
 * @param <E>
 *            the source and target type of the correspondence
 * @param <C>
 *            the type of the context in which the target element is resolved (the "to" context)
 */
public interface ISyncCorrespondenceResolver<E, C> extends ICorrespondenceResolver<E, E, C> {

	/**
	 * An {@linkplain ICorrespondenceResolver#inverse() invertible} correspondence resolver
	 * for synchronization use cases that does inversion using a cache of resolutions provided
	 * by a delegate.
	 */
	class Cached<E, C> extends ICorrespondenceResolver.Cached<E, E, C>implements ISyncCorrespondenceResolver<E, C> {

		Cached(ICorrespondenceResolver<E, E, C> delegate) {
			super(delegate);
		}

		@Override
		public ISyncCorrespondenceResolver<E, C> inverse() {
			return new ISyncCorrespondenceResolver<E, C>() {
				@Override
				public E getCorrespondent(E element, C parentContext) {
					return inverseGet(element, parentContext);
				}

				@Override
				public ISyncCorrespondenceResolver<E, C> inverse() {
					// My inverse is just the original that I inverted
					return Cached.this;
				}
			};
		}

		@Override
		public ISyncCorrespondenceResolver<E, C> cached() {
			return this;
		}
	}

	@Override
	default ISyncCorrespondenceResolver<E, C> inverse() {
		throw new IllegalStateException("not invertible"); //$NON-NLS-1$
	}

	@Override
	@CacheProvider
	default ISyncCorrespondenceResolver<E, C> cached() {
		return new Cached<>(this);
	}

}
