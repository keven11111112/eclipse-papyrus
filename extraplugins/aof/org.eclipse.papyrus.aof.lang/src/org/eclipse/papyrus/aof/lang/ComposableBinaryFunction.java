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
import org.eclipse.papyrus.aof.core.IUnaryFunction;
import org.eclipse.papyrus.aof.core.impl.utils.cache.IBinaryCache;
import org.eclipse.papyrus.aof.core.impl.utils.cache.WeakKeysWeakValuesBinaryCache;

/**
 * A {@link ComposableBinaryFunction} is a binary function (and therefore implements {@link IBinaryFunction}) with additional
 * capabilities including functional composition.
 *
 * @author Frederic Jouault
 *
 * @param <F>
 *            type of first parameter to the function.
 * @param <S>
 *            type of second parameter to the function.
 * @param <R>
 *            return type of the function.
 */
public abstract class ComposableBinaryFunction<F, S, R> implements IBinaryFunction<F, S, R> {

	/**
	 * Composes this function with two unary functions: one for each of its parameters.
	 *
	 * The resulting binary function will apply this binary function on the result of calling the two provided
	 * unary functions on its two arguments.
	 *
	 * <pre>
	 * returnedFunction(x, y) = thisFunction(beforeFirst(x), beforeSecond(y))
	 * </pre>
	 *
	 * @param beforeFirst
	 *            the unary function to call on the first argument of the returned function.
	 * @param beforeSecond
	 *            the unary function to call on the first argument of the returned function.
	 * @return the binary function composed with beforeFirst and beforeSecond.
	 */
	public <V1, V2> ComposableBinaryFunction<V1, V2, R> compose(final IUnaryFunction<? super V1, ? extends F> beforeFirst, final IUnaryFunction<? super V2, ? extends S> beforeSecond) {
		return new ComposableBinaryFunction<V1, V2, R>() {
			@Override
			public R apply(V1 a, V2 b) {
				return ComposableBinaryFunction.this.apply(beforeFirst.apply(a), beforeSecond.apply(b));
			}

			@Override
			public String toString() {
				return beforeFirst + " " + ComposableBinaryFunction.this + " " + beforeSecond;
			}
		};
	}

	/**
	 * Merges inputs of this binary function to create a binary function.
	 *
	 * <pre>
	 * returnedFunction(x) = thisFunction(x, x)
	 * </pre>
	 *
	 * @return a {@link ComposableUnaryFunction} that passes its argument as both the first and the
	 *         second argument of this {@link ComposableBinaryFunction}.
	 */
	public static <D, C> ComposableUnaryFunction<D, C> mergeInputs(final ComposableBinaryFunction<? super D, ? super D, C> f) {
		return new ComposableUnaryFunction<D, C>() {
			@Override
			public C apply(D a) {
				return f.apply(a, a);
			}

			@Override
			public String toString() {
				return f + ".mergeInputs()";
			}
		};
	}

	/**
	 * Turns this binary function operating on values into a function operating on boxes.
	 *
	 * The resulting binary function takes two boxes as parameters, and returns a box. It
	 * applies this function to corresponding elements from both parameter boxes to
	 * produce a corresponding element in its returned box.
	 *
	 * This method is based on {@link IBox#zipWith(IBox, IBinaryFunction)} and behaves similarly with respect to
	 * box sizes and alignment.
	 *
	 * @return the function operating on boxes.
	 */
	// cache handling could be extracted from this method as for ComposableUnaryFunction
	// However, this would only be useful if there were other uses of a ComposableBinaryFunction.cache method.
	public ComposableBinaryFunction<IBox<F>, IBox<S>, IBox<R>> lift() {
		return new ComposableBinaryFunction<IBox<F>, IBox<S>, IBox<R>>() {
			private IBinaryCache<IBox<F>, IBox<S>, IBox<R>> cache = new WeakKeysWeakValuesBinaryCache<IBox<F>, IBox<S>, IBox<R>>();

			@Override
			public IBox<R> apply(IBox<F> a, IBox<S> b) {
				IBox<R> ret = cache.get(a, b);
				if (ret == null) {
					ret = a.zipWith(b, ComposableBinaryFunction.this);
					cache.put(a, b, ret);
				}
				return ret;
			}

			@Override
			public String toString() {
				return ComposableBinaryFunction.this + ".lift()";
			}
		};
	}
}