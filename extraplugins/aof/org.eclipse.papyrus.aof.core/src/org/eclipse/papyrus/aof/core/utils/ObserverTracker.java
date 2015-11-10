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

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.papyrus.aof.core.IObservable;
import org.eclipse.papyrus.aof.core.IObserver;
import org.eclipse.papyrus.aof.core.IPair;
import org.eclipse.papyrus.aof.core.impl.Pair;

/**
 * An utility that automatically captures the attachment of {@link IObserver}s
 * to {@link IObservable}s (as long as the particular observable implementations
 * coöperate).
 */
public final class ObserverTracker implements AutoCloseable {

	private static ThreadLocal<ObserverTracker> currentTracker = new ThreadLocal<ObserverTracker>();

	private final ObserverTracker parent;

	private final List<IPair<? extends Reference<IObservable<?>>, ? extends Reference<IObserver<?>>>> records = new ArrayList<>();

	/**
	 * Not instantiable by clients.
	 */
	private ObserverTracker(ObserverTracker parent) {
		super();

		this.parent = parent;
	}

	/**
	 * If there is a currently active observer tracker, records the addition of
	 * an {@code observer} to an {@code observable}. Otherwise, does nothing.
	 * 
	 * @param observable
	 *            an observable
	 * @param observer
	 *            an observer that was added to the {@code observable}
	 */
	public static void observerAdded(IObservable<?> observable, IObserver<?> observer) {
		ObserverTracker tracker = currentTracker.get();

		if (tracker != null) {
			tracker.add(observable, observer);
		}
	}

	private void add(IObservable<?> observable, IObserver<?> observer) {
		IPair<? extends Reference<IObservable<?>>, ? extends Reference<IObserver<?>>> record = Pair
				.of(new WeakReference<IObservable<?>>(observable), new WeakReference<IObserver<?>>(observer));

		add(record);
	}

	private void add(IPair<? extends Reference<IObservable<?>>, ? extends Reference<IObserver<?>>> record) {
		if (records.add(record) && (parent != null)) {
			parent.add(record);
		}
	}

	/**
	 * If there is a currently active observer tracker, removes the record of an
	 * {@code observer} having been added to an {@code observable}. Otherwise,
	 * does nothing. This is simply a courtesy; it is not strictly necessary, as
	 * attempting to remove the observer again later will have no effect anyways
	 * and the tracker does not maintain strong references to neither observers
	 * nor observables.
	 * 
	 * @param observable
	 *            an observable
	 * @param observer
	 *            an observer that was removed from the {@code observable}
	 */
	public static void observerRemoved(IObservable<?> observable, IObserver<?> observer) {
		ObserverTracker tracker = currentTracker.get();

		if (tracker != null) {
			tracker.remove(observable, observer);
		}
	}

	private void remove(IObservable<?> observable, IObserver<?> observer) {
		for (Iterator<IPair<? extends Reference<IObservable<?>>, ? extends Reference<IObserver<?>>>> iter = records
				.iterator(); iter.hasNext();) {

			IPair<? extends Reference<IObservable<?>>, ? extends Reference<IObserver<?>>> next = iter.next();
			IObservable<?> nextObservable = next.getLeft().get();
			IObserver<?> nextObserver = next.getRight().get();

			if ((nextObservable == observable) && (nextObserver == observer)) {
				iter.remove();

				if (parent != null) {
					parent.remove(next);
				}
			}
		}
	}

	private void remove(IPair<? extends Reference<IObservable<?>>, ? extends Reference<IObserver<?>>> record) {
		if (records.remove(record) && (parent != null)) {
			parent.remove(record);
		}
	}

	/**
	 * Opens a new observer-tracking context. Trackers provide nested contexts:
	 * opening a tracker while the current thread already has one open results
	 * in a nested tracker that records its local observer registrations. A
	 * parent tracker aggregates all of its nested trackers: when a parent is
	 * disposed, all of its children implicitly are disposed also. When a child
	 * is disposed, the observers that it recorded are removed from the recorded
	 * observables, which removes those also from the parent context, but other
	 * observers in the parent context remain unaffected.
	 * 
	 * @return the new tracker
	 */
	public static ObserverTracker open() {
		ObserverTracker result = new ObserverTracker(currentTracker.get());
		currentTracker.set(result);
		return result;
	}

	/**
	 * Queries whether I am currently open. I can only record observers while I
	 * am open.
	 * 
	 * @return whether I am open
	 */
	public boolean isOpen() {
		return currentTracker.get() == this;
	}

	/**
	 * Closes the observer-tracking context. It no longer records observers and,
	 * if it is a nested context, its parent context becomes active again to
	 * recording subsequent observers (until it, too, is closed).
	 * 
	 * @throws IllegalStateException
	 *             if I am not open
	 */
	@Override
	public void close() {
		if (!isOpen()) {
			throw new IllegalStateException("not open"); //$NON-NLS-1$
		}

		if (parent == null) {
			currentTracker.remove();
		} else {
			currentTracker.set(parent);
		}
	}

	/**
	 * Disposes of all of the observers that I have recorded. For all records of
	 * an observer being added to an observable, that observer is removed from
	 * it if both the observer and the observable still exist.
	 * 
	 * @throws IllegalStateException
	 *             if I am still {@linkplain open}
	 */
	public void dispose() {
		if (isOpen()) {
			throw new IllegalStateException("open"); //$NON-NLS-1$
		}

		try {
			for (IPair<? extends Reference<IObservable<?>>, ? extends Reference<IObserver<?>>> next : records) {
				dispose(next);
			}
		} finally {
			clear();
		}
	}

	private void dispose(IPair<? extends Reference<IObservable<?>>, ? extends Reference<IObserver<?>>> record) {
		IObservable<?> observable = record.getLeft().get();
		IObserver<?> observer = record.getRight().get();

		if ((observable != null) && (observer != null)) {
			observable.removeObserver(observer);
		}
	}

	private void clear() {
		try {
			if (parent != null) {
				for (IPair<? extends Reference<IObservable<?>>, ? extends Reference<IObserver<?>>> next : records) {
					parent.remove(next);
				}
			}
		} finally {
			records.clear();
		}
	}

	/**
	 * Queries whether I have not recorded any attachments of observers to
	 * observables.
	 * 
	 * @return whether I have nothing to {@linkplain #dispose() dispose}
	 */
	public boolean isEmpty() {
		return records.isEmpty();
	}

	/**
	 * Observes the addition of {@linkplain IObserver observers} to
	 * {@linkplain IObservable observables} automatically during the execution
	 * of a {@code block}.
	 * 
	 * @param block
	 *            a block of code that may or may not add observers to
	 *            observables
	 * 
	 * @return an encapsulation of the registrations of observers
	 */
	public static ObserverTracker observeWhile(Runnable block) {
		ObserverTracker result;

		try (ObserverTracker tracker = open()) {
			result = tracker;
			block.run();
		}

		return result;
	}
}
