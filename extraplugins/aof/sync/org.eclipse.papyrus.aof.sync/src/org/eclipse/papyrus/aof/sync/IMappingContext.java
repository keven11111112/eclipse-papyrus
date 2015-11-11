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

import java.lang.reflect.UndeclaredThrowableException;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.papyrus.aof.core.IBinding;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.IPair;
import org.eclipse.papyrus.aof.core.impl.Pair;
import org.eclipse.papyrus.aof.core.utils.ObserverTracker;

import com.google.inject.ImplementedBy;

/**
 * A context in which {@linkplain IMapping mappings} are created, destroyed, and
 * otherwise managed. Mappings should inject one of these to record the
 * {@linkplain IBinding bindings} and other active operations that they attach
 * to objects so that they may later be reviewed and/or removed.
 */
@ImplementedBy(MappingContext.class)
public interface IMappingContext {
	/**
	 * Opens me, to start tracking side-effects of mapping operations.
	 * Opening is recursive: as many times as I am recursively opened, I must be
	 * closed.
	 */
	void open();

	/**
	 * Queries whether I am currently (possibly recursively) {@linkplain #open() open}.
	 * 
	 * @return whether I am open
	 */
	boolean isOpen();

	/**
	 * Closes me, to stop tracking side-effects of mapping operations.
	 */
	void close();

	/**
	 * Obtains a provider of mappings in this context.
	 * 
	 * @return the mapping provider
	 */
	IMappingProvider getMappingProvider();

	/**
	 * Runs the given {@code instance} of a {@linkplain IMapping mapping} in context.
	 * Nested mappings (consequents) that are run recursively are captured in this {@code instance}.
	 * 
	 * @param instance
	 *            an instance of a mapping to run
	 * @param block
	 *            the mapping algorithm to run
	 * 
	 * @return a record of observers added during the progress of the {@code mapping}
	 */
	<F, T> ObserverTracker run(IMappingInstance<F, T> instance, BiConsumer<? super IOne<F>, ? super IOne<T>> block);

	/**
	 * Runs a {@code block} of code that manipulates mappings, during which
	 * time it is watched for {@linkplain ObserverTracker observers} and
	 * possibly other side-effects that may need to be reverted later.
	 * 
	 * @param block
	 *            a block of code that manipulates mappings
	 */
	default ObserverTracker run(Runnable block) {
		ObserverTracker result;

		try {
			open();

			result = ObserverTracker.observeWhile(block);
		} finally {
			close();
		}

		return result;
	}

	default <T> ObserverTracker run(T input, Consumer<? super T> block) {
		return run(() -> block.accept(input));
	}

	default <T, U> ObserverTracker run(T input1, U input2, BiConsumer<? super T, ? super U> block) {
		return run(() -> block.accept(input1, input2));
	}

	default <V, X extends Exception> IPair<V, ObserverTracker> call(Class<X> expected, Callable<V> block) throws X {
		Objects.requireNonNull(expected, "expected");

		Object[] result = { null };
		ObserverTracker tracker;

		try {
			tracker = run(() -> {
				try {
					result[0] = block.call();
				} catch (Exception e) {
					throw new WrappedException(e);
				}
			});
		} catch (WrappedException e) {
			Exception wrapped = e.exception();

			if (expected.isInstance(wrapped)) {
				throw expected.cast(wrapped);
			} else if (wrapped instanceof RuntimeException) {
				throw (RuntimeException) wrapped;
			} else {
				throw new UndeclaredThrowableException(wrapped);
			}
		}

		@SuppressWarnings("unchecked")
		V vResult = (V) result[0];
		return Pair.of(vResult, tracker);
	}

	default <V> IPair<V, ObserverTracker> call(Callable<V> block) {
		return call(RuntimeException.class, block);
	}

	default <F, T> IPair<T, ObserverTracker> call(F input, Function<? super F, ? extends T> function) {
		return call(() -> function.apply(input));
	}

	default <F, G, T> IPair<T, ObserverTracker> call(F input1, G input2, BiFunction<? super F, ? super G, ? extends T> function) {
		return call(() -> function.apply(input1, input2));
	}

	/**
	 * Obtains all of the mapping instances in this context map something to the given
	 * {@code target} object.
	 * 
	 * @param target
	 *            the target of one or more mappings (hopefully not more than one of the
	 *            same {@linkplain IMappingInstance#getType() type})
	 * 
	 * @return an immutable iteration of the mappings targeting the object
	 */
	<T> Iterable<IMappingInstance<?, ? super T>> getMappingInstances(T target);

	/**
	 * Queries whether {@linkplain AutoDisableHook auto-disable hooks} should not
	 * be allowed to fire.
	 * 
	 * @return whether auto-disable processing is suppressed
	 */
	boolean isSuppressAutoDisableHooks();
}
