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

package org.eclipse.papyrus.aof.sync.tests;

import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.aof.core.ObserverTracker;
import org.eclipse.papyrus.aof.sync.From;
import org.eclipse.papyrus.aof.sync.IMappingContext;
import org.eclipse.papyrus.aof.sync.MappingContext;
import org.eclipse.papyrus.aof.sync.To;
import org.eclipse.papyrus.aof.sync.tests.AbstractMappingTest.TestMapping;
import org.eclipse.papyrus.aof.sync.tests.runners.InjectWith;
import org.junit.Test;

/**
 * Test cases for the {@link MappingContext} class.
 */
@InjectWith(TestModelModule.class)
public class MappingContextTest extends AbstractTest {

	@Inject
	private TestMapping fixture;

	@Inject
	@From
	private EObject from;

	@Inject
	@To
	private EObject to;

	@Inject
	private EAttribute age;

	@Inject
	private IMappingContext context;

	@Test
	public void unmap() {
		context.run(() -> {
			fixture.map(from, to);
		});

		assumeThat(from.eAdapters(), hasItem(anything()));
		assumeThat(to.eAdapters(), hasItem(anything()));

		// Mapping is active
		from.eSet(age, 42);
		assumeThat(to.eGet(age), is(42));

		assertThat(context.getObserverTrackers(), hasItem(anything()));
		context.detachObserverTrackers().forEach(ObserverTracker::dispose);

		// Mapping is now inactive
		from.eSet(age, 17);
		assumeThat(to.eGet(age), is(42));

		assertThat(from.eAdapters(), not(hasItem(anything())));
		assertThat(to.eAdapters(), not(hasItem(anything())));
	}

}
