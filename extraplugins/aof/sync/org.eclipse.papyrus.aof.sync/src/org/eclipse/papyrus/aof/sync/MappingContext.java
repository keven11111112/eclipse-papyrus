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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.papyrus.aof.core.ObserverTracker;

/**
 * Default implementation of the mapping context protocol.
 */
public class MappingContext implements IMappingContext {

	private final List<ObserverTracker> observerTrackers = new ArrayList<>();

	private final AtomicInteger openDepth = new AtomicInteger();

	public MappingContext() {
		super();
	}

	@Override
	public void addObserverTracker(ObserverTracker tracker) {
		if (!isOpen()) {
			throw new IllegalStateException("not open"); //$NON-NLS-1$
		}

		observerTrackers.add(tracker);
	}

	@Override
	public Collection<ObserverTracker> getObserverTrackers() {
		return Collections.unmodifiableList(observerTrackers);
	}

	@Override
	public Collection<ObserverTracker> detachObserverTrackers() {
		List<ObserverTracker> result = Collections.unmodifiableList(new ArrayList<>(observerTrackers));
		observerTrackers.clear();
		return result;
	}

	@Override
	public void open() {
		openDepth.incrementAndGet();
	}

	@Override
	public boolean isOpen() {
		return openDepth.get() > 0;
	}

	@Override
	public void close() {
		if (openDepth.decrementAndGet() < 0) {
			// Undo
			openDepth.incrementAndGet();
			throw new IllegalStateException("already closed"); //$NON-NLS-1$
		}
	}

}
