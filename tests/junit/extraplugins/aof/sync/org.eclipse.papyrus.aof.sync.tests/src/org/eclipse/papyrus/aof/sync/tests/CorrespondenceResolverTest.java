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

import static org.eclipse.papyrus.junit.matchers.MoreMatchers.greaterThan;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

import javax.inject.Inject;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.aof.sync.From;
import org.eclipse.papyrus.aof.sync.ICorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.To;
import org.eclipse.papyrus.aof.sync.tests.runners.InjectWith;
import org.eclipse.papyrus.junit.matchers.MoreMatchers;
import org.eclipse.papyrus.junit.utils.rules.HouseKeeper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Test cases for the {@link ICorrespondenceResolver} interface's concrete methods.
 */
@InjectWith(TestModelModule.class)
public class CorrespondenceResolverTest extends AbstractTest {

	@Rule
	public final HouseKeeper houseKeeper = new HouseKeeper();

	@Inject
	private EClass eClass;

	@Inject
	private EReference reference;

	@Inject
	private ICorrespondenceResolver<EObject, EObject, EObject> fixture;

	@Inject
	@From
	private EObject from;

	@Inject
	@To
	private EObject to;

	private EAttribute name;

	@Test(expected = IllegalStateException.class)
	public void notInvertible() {
		fixture.inverse();
	}

	@Test
	public void getCorrespondent() {
		@SuppressWarnings("unchecked")
		EList<EObject> fromRef = (EList<EObject>) from.eGet(reference);
		assumeThat(fromRef.size(), greaterThan(1));

		EObject alice = fromRef.get(0);
		EObject betty = fromRef.get(1);

		@SuppressWarnings("unchecked")
		EList<EObject> toRef = (EList<EObject>) to.eGet(reference);
		assumeThat(toRef, MoreMatchers.emptyIterable());
		EObject newAlice = EcoreUtil.copy(alice);
		toRef.add(newAlice);

		EObject resolved = fixture.getCorrespondent(alice, to);
		assertThat(resolved, sameInstance(newAlice));

		resolved = fixture.getCorrespondent(betty, to);
		assertThat(resolved, notNullValue());
		assertThat(resolved, not(sameInstance(betty)));
		assertThat(resolved.eGet(name), is("Betty"));
	}

	@Test
	public void cached() {
		fixture = fixture.cached();

		@SuppressWarnings("unchecked")
		EList<EObject> fromRef = (EList<EObject>) from.eGet(reference);
		assumeThat(fromRef.size(), greaterThan(1));

		EObject alice = fromRef.get(0);
		EObject betty = fromRef.get(1);

		@SuppressWarnings("unchecked")
		EList<EObject> toRef = (EList<EObject>) to.eGet(reference);
		assumeThat(toRef, MoreMatchers.emptyIterable());
		EObject newAlice = EcoreUtil.copy(alice);
		toRef.add(newAlice);

		EObject resolved = fixture.getCorrespondent(alice, to);
		assertThat(resolved, sameInstance(newAlice));

		resolved = fixture.getCorrespondent(betty, to);
		assertThat(resolved, notNullValue());
		assertThat(resolved, not(sameInstance(betty)));
		assertThat(resolved.eGet(name), is("Betty"));

		EObject newBetty = resolved;

		resolved = fixture.getCorrespondent(alice, to);
		assertThat(resolved, sameInstance(newAlice));

		// This one is not created again but retrieved from the cache
		resolved = fixture.getCorrespondent(betty, to);
		assertThat(resolved, sameInstance(newBetty));
	}

	@Test
	public void invertible() {
		fixture = fixture.cached();

		@SuppressWarnings("unchecked")
		EList<EObject> fromRef = (EList<EObject>) from.eGet(reference);
		assumeThat(fromRef.size(), greaterThan(1));

		EObject alice = fromRef.get(0);
		EObject betty = fromRef.get(1);

		@SuppressWarnings("unchecked")
		EList<EObject> toRef = (EList<EObject>) to.eGet(reference);
		assumeThat(toRef, MoreMatchers.emptyIterable());
		EObject newAlice = EcoreUtil.copy(alice);
		toRef.add(newAlice);

		EObject resolved = fixture.getCorrespondent(alice, to);
		assertThat(resolved, sameInstance(newAlice));

		resolved = fixture.getCorrespondent(betty, to);
		assertThat(resolved, notNullValue());
		assertThat(resolved, not(sameInstance(betty)));
		assertThat(resolved.eGet(name), is("Betty"));

		EObject newBetty = resolved;

		ICorrespondenceResolver<EObject, EObject, EObject> inverse = fixture.inverse();

		resolved = inverse.getCorrespondent(newAlice, to);
		assertThat(resolved, sameInstance(alice));

		resolved = inverse.getCorrespondent(newBetty, to);
		assertThat(resolved, sameInstance(betty));
	}

	@Test
	public void reinvertible() {
		ICorrespondenceResolver<EObject, EObject, EObject> cached = fixture.cached();
		ICorrespondenceResolver<EObject, EObject, EObject> inverse = cached.inverse();

		assertThat(inverse.inverse(), sameInstance(cached));
	}

	@Test
	public void recached() {
		ICorrespondenceResolver<EObject, EObject, EObject> cached = fixture.cached();

		assertThat(cached.cached(), sameInstance(cached));
	}

	//
	// Test framework
	//

	@Before
	public void getMetadata() {
		name = (EAttribute) eClass.getEStructuralFeature("name");
	}
}
