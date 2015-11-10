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

package org.eclipse.papyrus.aof.core.utils;

import org.eclipse.papyrus.aof.core.IObservable;
import org.eclipse.papyrus.aof.core.IObserver;
import org.eclipse.papyrus.aof.core.IUnaryFunction;

/**
 * Static utilities for interaction with observables and observers in the AOF.
 */
public class Observers {

	private static final ObserverIntercept ROOT = new ObserverIntercept();

	private static final ThreadLocal<ObserverIntercept> observerIntercept = new ThreadLocal<ObserverIntercept>() {
		@Override
		protected ObserverIntercept initialValue() {
			return ROOT;
		}
	};

	private Observers() {
		super();
	}

	/**
	 * Pushes a function that intercepts, and optionally transforms, an
	 * {@linkplain IObserver observer} that is about to be added to or removed
	 * from an {@linkplain IObservable observable}. Every such push must later
	 * be balanced by a matching {@linkplain #popObserverIntercept() pop}.
	 * 
	 * @param interceptFunction
	 *            the observer intercept function to push
	 * 
	 * @see #popObserverIntercept()
	 */
	public static void pushObserverIntercept(
			final IUnaryFunction<? super IObserver<?>, ? extends IObserver<?>> interceptFunction) {

		observerIntercept.set(new ObserverIntercept() {
			@Override
			public IObserver<?> apply(IObserver<?> input) {
				return interceptFunction.apply(input);
			}
		});
	}

	/**
	 * Pops an observer intercept function that was previously
	 * {@linkplain #pushObserverIntercept(IUnaryFunction) pushed}.
	 * 
	 * @see #pushObserverIntercept(IUnaryFunction)
	 */
	public static void popObserverIntercept() {
		observerIntercept.set(observerIntercept.get().getParent());
	}

	/**
	 * A safe convenience for running a {@code block} of code under the
	 * operation of the specified observer intercept.
	 * 
	 * @param interceptFunction
	 *            an intercept function to push before running the {@code block}
	 *            . It is guaranteed to be popped afterwards, regardless of what
	 *            happens in the {@code block}
	 * @param block
	 *            a block of code to run under intercept
	 * 
	 * @see #pushObserverIntercept(IUnaryFunction)
	 * @see #popObserverIntercept()
	 */
	public static void runWithObserverIntercept(
			IUnaryFunction<? super IObserver<?>, ? extends IObserver<?>> interceptFunction, Runnable block) {

		pushObserverIntercept(interceptFunction);

		try {
			block.run();
		} finally {
			popObserverIntercept();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static <E> IUnaryFunction<IObserver<E>, IObserver<? super E>> interceptFunction() {
		return (IUnaryFunction) observerIntercept.get();
	}

	/**
	 * Hook for {@link IObservable}s to use to intercept/transform an
	 * {@code observer} that is being
	 * {@linkplain IObservable#addObserver(IObserver) added} to or
	 * {@linkplain IObservable#removeObserver(IObserver) removed} from them.
	 * This call is always safe. It may just return the {@code observer}
	 * unchanged.
	 * 
	 * @param observer
	 *            an observer to intercept
	 */
	public static <E> IObserver<? super E> intercept(IObserver<E> observer) {
		return Observers.<E> interceptFunction().apply(observer);
	}

	//
	// Nested types
	//

	private static class ObserverIntercept implements IUnaryFunction<IObserver<?>, IObserver<?>> {
		private final ObserverIntercept parent;

		ObserverIntercept() {
			super();

			if (ROOT == null) {
				// We're creating the root
				parent = null;
			} else {
				parent = observerIntercept.get();
			}
		}

		@Override
		public IObserver<?> apply(IObserver<?> input) {
			return input;
		}

		ObserverIntercept getParent() {
			return parent;
		}
	}
}
