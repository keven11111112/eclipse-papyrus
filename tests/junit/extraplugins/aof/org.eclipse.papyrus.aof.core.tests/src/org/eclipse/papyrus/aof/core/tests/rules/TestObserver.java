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

package org.eclipse.papyrus.aof.core.tests.rules;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayDeque;
import java.util.Deque;

import org.eclipse.papyrus.aof.core.IObservable;
import org.eclipse.papyrus.aof.core.IPair;
import org.eclipse.papyrus.aof.core.impl.Pair;
import org.eclipse.papyrus.aof.core.impl.utils.DefaultObserver;

/**
 * An observer that simply logs observations and provides assertions on them.
 */
public class TestObserver<E> extends DefaultObserver<E> {
	private final Deque<IPair<TestObserver.ObservationKind, IPair<Integer, E>>> observations = new ArrayDeque<>();

	private void record(TestObserver.ObservationKind kind, int index, E element) {
		observations.addLast(Pair.of(kind, Pair.of(index, element)));
	}

	public void reset() {
		observations.clear();
	}

	/**
	 * Dequeues the oldest observation and asserts its details. Fails the test if there is
	 * no such observation.
	 */
	public void assertObservation(TestObserver.ObservationKind kind, int index, E element) {
		IPair<TestObserver.ObservationKind, IPair<Integer, E>> observation = observations.pollFirst();
		assertThat("Nothing was observed", observation, notNullValue());

		assertThat("Wrong kind of observation", observation.getLeft(), is(kind));
		assertThat("Wrong index of observation", observation.getRight().getLeft(), is(index));
		assertThat("Wrong element of observation", observation.getRight().getRight(), is(element));
	}

	/**
	 * Asserts that nothing has been observed.
	 */
	public void assertNoObservation() {
		assertThat("A change was observed", observations.peekFirst(), nullValue());
	}

	public static <E> TestObserver<E> observe(IObservable<? extends E> observable) {
		TestObserver<E> result = new TestObserver<E>();
		observable.addObserver(result);
		return result;
	}

	@Override
	public void added(int index, E element) {
		record(ObservationKind.ADD, index, element);
	}

	@Override
	public void removed(int index, E element) {
		record(ObservationKind.REMOVE, index, element);
	}

	@Override
	public void replaced(int index, E newElement, E oldElement) {
		record(ObservationKind.REPLACE, index, newElement);
	}

	@Override
	public void moved(int newIndex, int oldIndex, E element) {
		record(ObservationKind.MOVE, newIndex, element);
	}

	//
	// Nested types
	//

	public enum ObservationKind {
		ADD, REMOVE, REPLACE, MOVE;
	}

}
