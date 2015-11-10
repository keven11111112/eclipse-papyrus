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

package org.eclipse.papyrus.aof.core.tests;

import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.aof.core.AOFFactory;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IObserver;
import org.eclipse.papyrus.aof.core.IUnaryFunction;
import org.eclipse.papyrus.aof.core.tests.matchers.BoxMatchers;
import org.eclipse.papyrus.aof.core.utils.Boxes;
import org.eclipse.papyrus.aof.core.utils.Observers;
import org.junit.Test;

/**
 * Test cases for the {@link Observers} class.
 */
public class ObserversTest {

	private final List<TraceKind> trace = new ArrayList<>();

	public ObserversTest() {
		super();
	}

	@Test
	public void traceCollectOperation() {
		@SuppressWarnings("unchecked")
		IUnaryFunction<IObserver<?>, IObserver<?>> interceptFunction = TracingObserver::new;

		Observers.runWithObserverIntercept(interceptFunction, () -> {
			IBox<String> source = AOFFactory.INSTANCE.createSequence("one", "two", "three", "four");
			IBox<Integer> target = source.collect(s -> s.length());

			assertThat(trace, hasItem(anything()));
			System.out.println("Got trace: " + trace);

			// Observer intercept doesn't interfere
			assertThat(target, BoxMatchers.sameAs(Boxes.with().immutableSequence(3, 3, 5, 4)));

			trace.clear();

			source.add("five");
			source.add("six");
			source.remove("one");
			source.set(0, "zwei");

			assertThat(trace, hasItem(anything()));
			System.out.println("Cont'd trace: " + trace);

			assertThat(target, BoxMatchers.sameAs(Boxes.with().immutableSequence(4, 5, 4, 4, 3)));
		});
	}

	//
	// Nested types
	//

	enum TraceKind {
		OBSERVER, ADD, REMOVE, REPLACE, MOVE;
	}

	class TracingObserver<E> implements IObserver<E> {
		private final IObserver<E> delegate;

		TracingObserver(IObserver<E> delegate) {
			super();

			this.delegate = delegate;

			trace.add(TraceKind.OBSERVER);
		}

		@Override
		public boolean isDisabled() {
			return delegate.isDisabled();
		}

		@Override
		public void setDisabled(boolean disabled) {
			delegate.setDisabled(disabled);
		}

		@Override
		public void added(int index, E element) {
			trace.add(TraceKind.ADD);
			delegate.added(index, element);
		}

		@Override
		public void removed(int index, E element) {
			trace.add(TraceKind.REMOVE);
			delegate.removed(index, element);
		}

		@Override
		public void replaced(int index, E newElement, E oldElement) {
			trace.add(TraceKind.REPLACE);
			delegate.replaced(index, newElement, oldElement);
		}

		@Override
		public void moved(int newIndex, int oldIndex, E element) {
			trace.add(TraceKind.MOVE);
			delegate.moved(newIndex, oldIndex, element);
		}

	}
}
