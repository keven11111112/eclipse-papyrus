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

import org.eclipse.papyrus.aof.core.impl.utils.cache.IBinaryCache;
import org.eclipse.papyrus.aof.core.impl.utils.cache.WeakKeysWeakValuesBinaryCache;

/**
 * A protocol for resolution of bijective correspondence between elements in a
 * {@linkplain IMapping mapping}, within parent contexts that are similarly correspondent.
 */
@FunctionalInterface
public interface ICorrespondenceResolver<E, C> {
	/**
	 * Get the element corresponding to the specified {@code element} in its
	 * similarly corresponding parent context. Implementations may find
	 * existing elements or create new ones as necessary.
	 * 
	 * @param element
	 *            the element for which we see a correspondent
	 * @param parentContext
	 *            the correspondence context of the element that we seek
	 * 
	 * @return the corresponding element in the {@code parentContext}, or {@code null}
	 *         if none exists nor can be created
	 */
	E getCorrespondent(E element, C parentContext);

	/**
	 * Obtains the inverse resolver, which provides the original object from a correspondent
	 * {@linkplain #getCorrespondent(Object, Object) originally obtained} from me.
	 * 
	 * @return my inverse
	 * 
	 * @throws IllegalStateException
	 *             if I am not invertible
	 */
	default ICorrespondenceResolver<E, C> inverse() {
		throw new IllegalStateException("not invertible"); //$NON-NLS-1$
	}

	/**
	 * Obtains a cached wrapper for myself, which is {@linkplain #inverse() invertible}.
	 * 
	 * @return an invertaible cached wrapper of myself
	 */
	@CacheProvider
	default ICorrespondenceResolver<E, C> cached() {
		return new Cached<>(this);
	}
	//
	// Nested types
	//

	/**
	 * An {@linkplain ICorrespondenceResolver#inverse() invertible} correspondence resolver
	 * that does inversion using a cache of resolutions provided by a delegate.
	 */
	class Cached<E, C> implements ICorrespondenceResolver<E, C> {
		private final IBinaryCache<C, E, E> cache = new WeakKeysWeakValuesBinaryCache<>();
		private final IBinaryCache<C, E, E> inverse = new WeakKeysWeakValuesBinaryCache<>();
		private final ICorrespondenceResolver<E, C> delegate;

		Cached(ICorrespondenceResolver<E, C> delegate) {
			super();

			this.delegate = delegate;
		}

		@Override
		public E getCorrespondent(E element, C parentContext) {
			E result = cache.get(parentContext, element);
			if (result == null) {
				result = delegate.getCorrespondent(element, parentContext);
				cache.put(parentContext, element, result);
				inverse.put(parentContext, result, element);
			}

			return result;
		}

		@Override
		public ICorrespondenceResolver<E, C> inverse() {
			return new ICorrespondenceResolver<E, C>() {
				@Override
				public E getCorrespondent(E element, C parentContext) {
					return inverse.get(parentContext, element);
				}

				@Override
				public ICorrespondenceResolver<E, C> inverse() {
					// My inverse is just the original that I inverted
					return Cached.this;
				}
			};
		}

		@Override
		public ICorrespondenceResolver<E, C> cached() {
			return this; // I am already cached
		}
	}
}
