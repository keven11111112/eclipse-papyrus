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
 * 
 * @param <F>
 *            the kind of element in the from context for which to resolve an element in the to context
 * @param <T>
 *            the kind of element in the to context corresponding to an element in the from context
 * @param <C>
 *            the type of "to" context
 */
@FunctionalInterface
public interface ICorrespondenceResolver<F, T, C> {
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
	T getCorrespondent(F element, C parentContext);

	/**
	 * Obtains the inverse resolver, which provides the original object from a correspondent
	 * {@linkplain #getCorrespondent(Object, Object) originally obtained} from me.
	 * 
	 * @return my inverse
	 * 
	 * @throws IllegalStateException
	 *             if I am not invertible
	 */
	default ICorrespondenceResolver<T, F, C> inverse() {
		throw new IllegalStateException("not invertible"); //$NON-NLS-1$
	}

	/**
	 * Obtains a cached wrapper for myself, which is {@linkplain #inverse() invertible}.
	 * 
	 * @return an invertible cached wrapper of myself
	 */
	@CacheProvider
	default ICorrespondenceResolver<F, T, C> cached() {
		return new Cached<>(this);
	}

	//
	// Nested types
	//

	/**
	 * An {@linkplain ICorrespondenceResolver#inverse() invertible} correspondence resolver
	 * that does inversion using a cache of resolutions provided by a delegate.
	 */
	class Cached<F, T, C> implements ICorrespondenceResolver<F, T, C> {
		private final IBinaryCache<C, F, T> cache = new WeakKeysWeakValuesBinaryCache<>();
		private final IBinaryCache<C, T, F> inverse = new WeakKeysWeakValuesBinaryCache<>();
		private final ICorrespondenceResolver<F, T, C> delegate;

		Cached(ICorrespondenceResolver<F, T, C> delegate) {
			super();

			this.delegate = delegate;
		}

		@Override
		public T getCorrespondent(F element, C parentContext) {
			T result = cache.get(parentContext, element);
			if (result == null) {
				result = delegate.getCorrespondent(element, parentContext);
				cache.put(parentContext, element, result);
				inverse.put(parentContext, result, element);
			}

			return result;
		}

		final F inverseGet(T element, C parentContext) {
			return inverse.get(parentContext, element);
		}

		@Override
		public ICorrespondenceResolver<T, F, C> inverse() {
			return new ICorrespondenceResolver<T, F, C>() {
				@Override
				public F getCorrespondent(T element, C parentContext) {
					return inverseGet(element, parentContext);
				}

				@Override
				public ICorrespondenceResolver<F, T, C> inverse() {
					// My inverse is just the original that I inverted
					return Cached.this;
				}
			};
		}

		@Override
		public ICorrespondenceResolver<F, T, C> cached() {
			return this; // I am already cached
		}
	}
}
