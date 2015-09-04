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

package org.eclipse.papyrus.aof.sync.gmf.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IPair;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.gmf.DiagramMappingModule;
import org.eclipse.papyrus.aof.sync.tests.AbstractTest;
import org.eclipse.papyrus.aof.sync.tests.runners.InjectWith;
import org.junit.Before;

/**
 * @author damus
 *
 */
@InjectWith({ DiagramMappingModule.class, GenericFixtureModule.class })
public abstract class AbstractMappingTest<T extends EObject> extends AbstractTest {

	@Inject
	private IFactory aof;

	@Inject
	private IMapping<T> fixture;

	protected IPair<IBox<T>, IBox<T>> mapped;

	@Inject
	@From
	private T from;

	@Inject
	@To
	private T to;

	//
	// Test framework
	//

	@Before
	public void performMapping() {
		mapped = fixture.map(from, to);
	}

	protected final IFactory getAOF() {
		return aof;
	}

	protected final T getFrom() {
		return from;
	}

	protected final T getTo() {
		return to;
	}

	protected final IBox<T> getFromBox() {
		return mapped.getLeft();
	}

	protected final IBox<T> getToBox() {
		return mapped.getRight();
	}

	protected void assertFeature(EStructuralFeature feature, Object forwardValue, Object reverseValue) {
		assertFeature(getFrom(), getTo(), feature, forwardValue, reverseValue);
	}

	protected void assertFeature(EObject from, EObject to, EStructuralFeature feature, Object forwardValue, Object reverseValue) {
		assumeThat(from.eGet(feature), not(forwardValue));
		assumeThat(to.eGet(feature), is(from.eGet(feature)));

		from.eSet(feature, forwardValue);

		assertThat(to.eGet(feature), is(forwardValue));

		// The reverse direction does not sync

		to.eSet(feature, reverseValue);

		assertThat(from.eGet(feature), not(reverseValue));
		assertThat(from.eGet(feature), is(forwardValue));
	}

}
