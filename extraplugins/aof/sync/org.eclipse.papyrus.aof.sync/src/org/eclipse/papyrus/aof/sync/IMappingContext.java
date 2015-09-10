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

import java.util.Collection;

import org.eclipse.papyrus.aof.core.IBinding;
import org.eclipse.papyrus.aof.core.ObserverTracker;

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
	 * Adds an observer-tracker that has recorded the attachment of observers
	 * for potential future disposal. Observers may only be added while I am
	 * {@linkplain #isOpen() open}.
	 * 
	 * @param tracker
	 *            an observer tracker to add
	 * 
	 * @throws IllegalStateException
	 *             if I am not open
	 */
	void addObserverTracker(ObserverTracker tracker);

	/**
	 * Obtains an unmodifiable view on the observer-trackers that I have collected.
	 * 
	 * @return my observer-trackers
	 */
	Collection<ObserverTracker> getObserverTrackers();

	/**
	 * Obtains an immutable copy of the observer-trackers that I have collected and
	 * resets me to start collecting trackers again from nil.
	 * 
	 * @return a snapshot of my current observer-trackers
	 */
	Collection<ObserverTracker> detachObserverTrackers();

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
	 * Runs a {@code block} of code that manipulates mappings, during which
	 * time it is watched for {@linkplain ObserverTracker observers} and
	 * possibly other side-effects that may need to be reverted later.
	 * 
	 * @param block
	 *            a block of code that manipulates mappings
	 */
	default void run(Runnable block) {
		try {
			open();

			ObserverTracker tracker = ObserverTracker.observeWhile(block);
			if (!tracker.isEmpty()) {
				addObserverTracker(tracker);
			}
		} finally {
			close();
		}
	}
}
