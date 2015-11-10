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

import static org.eclipse.papyrus.aof.core.tests.matchers.BoxMatchers.sameAs;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

import org.eclipse.papyrus.aof.core.AOFFactory;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.utils.ObserverTracker;
import org.junit.Test;

/**
 * Test cases for the {@link ObserverTracker} API.
 */
public class ObserverTrackerTest {
	private final IFactory factory = AOFFactory.INSTANCE;

	public ObserverTrackerTest() {
		super();
	}

	@Test
	public void trackObservers() {
		IBox<String> fromBox = factory.createBag("a", "b", "b", "c");
		IBox<String> toBox = factory.createBag();

		ObserverTracker tracker = ObserverTracker.observeWhile(() -> {
			toBox.bind(fromBox);
		});

		assumeThat(fromBox.isObserved(), is(true));
		assumeThat(toBox.isObserved(), is(true));
		assumeThat(toBox, sameAs(fromBox));

		tracker.dispose();

		assertThat(fromBox.isObserved(), is(false));
		assertThat(toBox.isObserved(), is(false));

		fromBox.add("d");
		assertThat(toBox, not(hasItem("d")));
	}

	@Test
	public void nestedTracking() {
		IBox<String> fromBox = factory.createBag("a", "b", "b", "c");
		IBox<String> toBox = factory.createBag();

		IBox<Integer> fromBox1 = factory.createBag(1, 2, 2, 3);
		IBox<Integer> toBox1 = factory.createBag();

		ObserverTracker[] innerTracker = { null };
		ObserverTracker tracker = ObserverTracker.observeWhile(() -> {
			toBox.bind(fromBox);

			innerTracker[0] = ObserverTracker.observeWhile(() -> {
				toBox1.bind(fromBox1);
			});
		});

		assumeThat(fromBox.isObserved(), is(true));
		assumeThat(toBox.isObserved(), is(true));
		assumeThat(toBox, sameAs(fromBox));

		assumeThat(fromBox1.isObserved(), is(true));
		assumeThat(toBox1.isObserved(), is(true));
		assumeThat(toBox1, sameAs(fromBox1));

		innerTracker[0].dispose();

		assertThat(fromBox1.isObserved(), is(false));
		assertThat(toBox1.isObserved(), is(false));

		fromBox1.add(4);
		assertThat(toBox1, not(hasItem(4)));

		assertThat(fromBox.isObserved(), is(true));
		assertThat(toBox.isObserved(), is(true));

		fromBox.add("d");
		assertThat(toBox, hasItem("d"));

		tracker.dispose();

		assertThat(fromBox.isObserved(), is(false));
		assertThat(toBox.isObserved(), is(false));

		fromBox.add("e");
		assertThat(toBox, not(hasItem("e")));
	}
}
