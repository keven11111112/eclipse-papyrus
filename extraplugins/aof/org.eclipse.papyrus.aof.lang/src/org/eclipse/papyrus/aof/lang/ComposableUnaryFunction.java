/*******************************************************************************
 *  Copyright (c) 2015 ESEO.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Frederic Jouault - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.aof.lang;

import org.eclipse.papyrus.aof.core.IBinaryFunction;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.IUnaryFunction;
import org.eclipse.papyrus.aof.core.impl.utils.cache.IUnaryCache;
import org.eclipse.papyrus.aof.core.impl.utils.cache.StrongKeysStrongValuesUnaryCache;
import org.eclipse.papyrus.aof.core.impl.utils.cache.WeakKeysWeakValuesUnaryCache;

/**
 * A {@link ComposableUnaryFunction} is a unary function (and therefore implements {@link IUnaryFunction}) with additional
 * capabilities including functional composition.
 *
 * @author Frederic Jouault
 *
 * @param
 * 			<P>
 *            type of the parameter of this unary function.
 * @param <R>
 *            return type of this unary function.
 */
public abstract class ComposableUnaryFunction<P, R> implements IUnaryFunction<P, R> {

	/**
	 * Composes this unary function with the given unary function.
	 *
	 * The resulting unary function will apply this function on the result of calling the provided
	 * function on its argument.
	 *
	 * <pre>
	 * returnedFunction(x) = thisFunction(before(x))
	 * </pre>
	 *
	 * @param before
	 *            the unary function to first call on the argument of the returned function.
	 * @return the unary function composed with before.
	 */
	public <V> ComposableUnaryFunction<V, R> compose(final IUnaryFunction<? super V, ? extends P> before) {
		return new ComposableUnaryFunction<V, R>() {
			@Override
			public R apply(V a) {
				return ComposableUnaryFunction.this.apply(before.apply(a));
			}

			@Override
			public String toString() {
				return ComposableUnaryFunction.this + ".compose(" + before + ")";
			}
		};
	}

	/**
	 * Composes this function with the given binary function.
	 *
	 * The resulting binary function will apply this function on the result of calling the provided
	 * function on its arguments.
	 *
	 * <pre>
	 * returnedFunction(x, y) = thisFunction(before(x, y))
	 * </pre>
	 *
	 * @param before
	 *            the unary function to first call on the arguments of the returned function.
	 * @return the unary function composed with before.
	 */
	public <V1, V2> ComposableBinaryFunction<V1, V2, R> compose(final IBinaryFunction<V1, V2, P> before) {
		return new ComposableBinaryFunction<V1, V2, R>() {
			@Override
			public R apply(V1 a, V2 b) {
				return ComposableUnaryFunction.this.apply(before.apply(a, b));
			}

			@Override
			public String toString() {
				return ComposableUnaryFunction.this + ".compose(" + before + ")";
			}
		};
	}

	/**
	 * Boxes the value returned by this unary function.
	 *
	 * The resulting unary function takes a value as parameter, and returns a box. It
	 * applies this function to its parameter, and then wraps it in a {@link ConstantOne}.
	 *
	 * This method is especially useful when composing with mutable predicates for
	 * {@link IBox#collectMutable(IUnaryFunction)}. It can turn a regular predicate into a seemingly
	 * mutable one that can then be composed with actual mutable predicates.
	 *
	 * @return the function boxing the values returned by this function.
	 */
	// Remark: although constant ones are returned, the cache is necessary to make sure that if the result is
	// further processed by calling other operations (e.g., MutablePredicate.not()) their cache will work.
	// Alternatively, we could override equals and hashCode in ConstantOne.
	public ComposableUnaryFunction<P, IOne<R>> boxOutput() {
		return new ComposableUnaryFunction<P, IOne<R>>() {
			@Override
			public IOne<R> apply(P a) {
				return new ConstantOne<R>(ComposableUnaryFunction.this.apply(a));
			}

			@Override
			public String toString() {
				return ComposableUnaryFunction.this + ".boxOutput()";
			}
		}.cache(new StrongKeysStrongValuesUnaryCache<P, IOne<R>>());
	}

	/**
	 * Turns this unary function operating on values into a function operating on boxes.
	 *
	 * The resulting unary function takes a box as parameter, and returns a box. It
	 * applies this function to each element from its parameter boxes to
	 * produce a corresponding element in its returned box.
	 *
	 * This method is based on {@link IBox#collect(IUnaryFunction)}.
	 *
	 * Remark: since the unidirectional version of {@link IBox#collect(IUnaryFunction)} is used, this returned function does
	 * not preserve the type of its parameter box. Its returned box may be of a different type.
	 *
	 * @return the function operating on boxes.
	 */
	public ComposableUnaryFunction<IBox<P>, IBox<R>> lift() {
		return new ComposableUnaryFunction<IBox<P>, IBox<R>>() {
			@Override
			public IBox<R> apply(IBox<P> a) {
				return a.collect(ComposableUnaryFunction.this);
			}

			@Override
			public String toString() {
				return ComposableUnaryFunction.this + ".lift()";
			}
		}.cache(new WeakKeysWeakValuesUnaryCache<IBox<P>, IBox<R>>()); // weak keys and references
	}

	/**
	 * Turns this unary function into a caching unary function.
	 *
	 * The resulting unary function caches the results computed by this function to avoid
	 * recomputing them. To do so, it uses the provided cache, which lets client code choose
	 * the appropriate kind of cache.
	 *
	 * This method is especially useful with {@link IBox#collectMutable(IUnaryFunction)}, which
	 * relies on the fact that its collector returns the same box for a given argument.
	 *
	 * @return the function applying a cache on this function.
	 */
	public ComposableUnaryFunction<P, R> cache(final IUnaryCache<P, R> cache) {
		return new ComposableUnaryFunction<P, R>() {
			@Override
			public R apply(P a) {
				return cachedApply(ComposableUnaryFunction.this, cache, a);
			}

			@Override
			public String toString() {
				return ComposableUnaryFunction.this + ".cache()";
			}
		};
	}

	// utilitary method separating the caching algorithm from cache method to enable reuse in specific overrides
	// in subclasses
	protected static <A, B> B cachedApply(ComposableUnaryFunction<A, B> f, IUnaryCache<A, B> cache, A a) {
		B ret = cache.get(a);
		if (ret == null) {
			ret = f.apply(a);
			cache.put(a, ret);
		}
		return ret;
	}
}