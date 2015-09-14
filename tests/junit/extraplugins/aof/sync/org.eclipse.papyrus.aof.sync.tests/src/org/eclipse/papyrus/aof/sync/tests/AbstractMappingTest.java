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

import static org.eclipse.papyrus.aof.core.tests.matchers.BoxMatchers.matches;
import static org.eclipse.papyrus.junit.matchers.MoreMatchers.greaterThan;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

import java.util.Iterator;

import javax.inject.Inject;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IConstraints;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.IPair;
import org.eclipse.papyrus.aof.core.utils.Boxes;
import org.eclipse.papyrus.aof.sync.AbstractMapping;
import org.eclipse.papyrus.aof.sync.From;
import org.eclipse.papyrus.aof.sync.ICorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.SyncMapping;
import org.eclipse.papyrus.aof.sync.To;
import org.eclipse.papyrus.aof.sync.tests.runners.InjectWith;
import org.eclipse.papyrus.junit.matchers.MoreMatchers;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for the {@link AbstractMapping} class.
 */
@InjectWith(TestModelModule.class)
public class AbstractMappingTest extends AbstractTest {

	@Inject
	private IFactory aof;

	@Inject
	private TestMapping fixture;

	@Inject
	private EClass eClass;

	@Inject
	private EReference reference;

	@Inject
	private EAttribute attribute;

	@Inject
	private ICorrespondenceResolver<EObject, EObject, EObject> correspondence;

	@Inject
	@From
	private EObject from;

	@Inject
	@To
	private EObject to;

	private EAttribute name;

	@Test
	public void getFactory() {
		assertThat(fixture.getFactory0(), is(aof));
	}

	@Test
	public void map() {
		IPair<IBox<EObject>, IBox<EObject>> pair = fixture.map(from, to);
		assertThat(pair.getLeft(), matches(IConstraints.ONE));
		assertThat(pair.getRight(), matches(IConstraints.ONE));

		@SuppressWarnings("unchecked")
		EList<? extends EObject> fromRef = (EList<? extends EObject>) from.eGet(reference);
		@SuppressWarnings("unchecked")
		EList<? extends EObject> toRef = (EList<? extends EObject>) to.eGet(reference);

		assertThat(fromRef.size(), greaterThan(0));
		assertThat(toRef.size(), is(fromRef.size()));

		Iterator<? extends EObject> toIter = toRef.iterator();
		fromRef.iterator().forEachRemaining(f -> assertThat(EcoreUtil.equals(f, toIter.next()), is(true)));
	}

	@Test
	public void mapBoxes() {
		IOne<EObject> left = Boxes.with(aof).immutableOne(from);
		IOne<EObject> right = Boxes.with(aof).immutableOne(to);

		IBox<IPair<IBox<EObject>, IBox<EObject>>> pairBox = fixture.map(left, right);

		assertThat(pairBox, matches(IConstraints.ONE));

		IPair<IBox<EObject>, IBox<EObject>> pair = pairBox.get(0);

		assertThat(pair.getLeft(), matches(IConstraints.ONE));
		assertThat(pair.getRight(), matches(IConstraints.ONE));

		@SuppressWarnings("unchecked")
		EList<? extends EObject> fromRef = (EList<? extends EObject>) from.eGet(reference);
		@SuppressWarnings("unchecked")
		EList<? extends EObject> toRef = (EList<? extends EObject>) to.eGet(reference);

		assertThat(fromRef.size(), greaterThan(0));
		assertThat(toRef.size(), is(fromRef.size()));

		Iterator<? extends EObject> toIter = toRef.iterator();
		fromRef.iterator().forEachRemaining(f -> assertThat(EcoreUtil.equals(f, toIter.next()), is(true)));
	}

	@Test
	public void property() {
		IBox<EObject> box = Boxes.with(aof).immutableOne(from);
		IBox<String> name = fixture.property(box, this.name);

		assertThat(name, matches(IConstraints.ONE));
		assertThat(name.get(0), is("From"));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.aof.sync.AbstractMapping#mapProperty(org.eclipse.papyrus.aof.core.IBox, org.eclipse.papyrus.aof.core.IBox, java.lang.Object, org.eclipse.papyrus.aof.sync.IMapping)}.
	 */
	@Test
	public void mapProperty() {
		IOne<EObject> left = Boxes.with(aof).immutableOne(from);
		IOne<EObject> right = Boxes.with(aof).immutableOne(to);

		@SuppressWarnings("unchecked")
		EList<EObject> fromRef = (EList<EObject>) from.eGet(reference);
		assumeThat(fromRef.size(), is(3));

		@SuppressWarnings("unchecked")
		EList<EObject> toRef = (EList<EObject>) to.eGet(reference);
		assumeThat(toRef, MoreMatchers.emptyIterable());
		toRef.addAll(EcoreUtil.copyAll(fromRef));

		EObject leftAlice = fromRef.get(0);
		leftAlice.eSet(attribute, 42);
		EObject leftBetty = fromRef.get(1);
		leftBetty.eSet(attribute, 17);
		EObject leftCaroline = fromRef.get(2);
		leftCaroline.eSet(attribute, 3);

		fixture.mapProperty(left, right, reference, fixture);

		assertThat(toRef.size(), is(3));
		assertThat(toRef.get(0).eGet(attribute), is(42));
		assertThat(toRef.get(1).eGet(attribute), is(17));
		assertThat(toRef.get(2).eGet(attribute), is(3));
	}

	@Test
	public void bindProperty() {
		IOne<EObject> left = Boxes.with(aof).immutableOne(from);
		IOne<EObject> right = Boxes.with(aof).immutableOne(to);

		assumeThat(from.eGet(attribute), is(0));
		assumeThat(to.eGet(attribute), is(0));

		fixture.bindProperty(left, right, attribute);

		from.eSet(attribute, 42);
		assertThat(to.eGet(attribute), is(42));

		// Binding is one-way
		to.eSet(attribute, 17);
		assertThat(from.eGet(attribute), is(42));
	}

	@Test
	public void bindPropertyValue() {
		IOne<Integer> left = aof.createOne(42);
		IOne<EObject> right = Boxes.with(aof).immutableOne(to);

		assumeThat(to.eGet(attribute), is(0));

		fixture.bindPropertyValue(left, right, attribute);

		assertThat(to.eGet(attribute), is(42));

		left.set(3);
		assertThat(to.eGet(attribute), is(3));

		// Binding is one-way
		to.eSet(attribute, 17);
		assertThat(left.get(), is(3));
	}

	@Test
	public void mapCorresponding() {
		IOne<EObject> left = Boxes.with(aof).immutableOne(from);
		IOne<EObject> right = Boxes.with(aof).immutableOne(to);

		@SuppressWarnings("unchecked")
		EList<EObject> fromRef = (EList<EObject>) from.eGet(reference);
		assumeThat(fromRef.size(), is(3));

		@SuppressWarnings("unchecked")
		EList<EObject> toRef = (EList<EObject>) to.eGet(reference);
		assumeThat(toRef, MoreMatchers.emptyIterable());

		EObject leftAlice = fromRef.get(0);
		leftAlice.eSet(attribute, 42);
		EObject leftBetty = fromRef.get(1);
		leftBetty.eSet(attribute, 17);
		EObject leftCaroline = fromRef.get(2);
		leftCaroline.eSet(attribute, 3);

		fixture.mapCorresponding(left, right, reference, correspondence);

		assertThat(toRef.size(), is(3));
		assertThat(toRef.get(0).eGet(name), is("Alice"));
		assertThat(toRef.get(0).eGet(attribute), not(42));
		assertThat(toRef.get(1).eGet(name), is("Betty"));
		assertThat(toRef.get(1).eGet(attribute), not(17));
		assertThat(toRef.get(2).eGet(name), is("Caroline"));
		assertThat(toRef.get(2).eGet(attribute), not(3));
	}

	@Test
	public void mapCorresponding_mapRecursive() {
		IOne<EObject> left = Boxes.with(aof).immutableOne(from);
		IOne<EObject> right = Boxes.with(aof).immutableOne(to);

		@SuppressWarnings("unchecked")
		EList<EObject> fromRef = (EList<EObject>) from.eGet(reference);
		assumeThat(fromRef.size(), is(3));

		@SuppressWarnings("unchecked")
		EList<EObject> toRef = (EList<EObject>) to.eGet(reference);
		assumeThat(toRef, MoreMatchers.emptyIterable());

		EObject leftAlice = fromRef.get(0);
		leftAlice.eSet(attribute, 42);
		EObject leftBetty = fromRef.get(1);
		leftBetty.eSet(attribute, 17);
		EObject leftCaroline = fromRef.get(2);
		leftCaroline.eSet(attribute, 3);

		fixture.mapCorresponding(left, right, reference, correspondence, fixture);

		assertThat(toRef.size(), is(3));
		assertThat(toRef.get(0).eGet(name), is("Alice"));
		assertThat(toRef.get(0).eGet(attribute), is(42));
		assertThat(toRef.get(1).eGet(name), is("Betty"));
		assertThat(toRef.get(1).eGet(attribute), is(17));
		assertThat(toRef.get(2).eGet(name), is("Caroline"));
		assertThat(toRef.get(2).eGet(attribute), is(3));
	}

	@Test
	public void getCorresponding() {
		@SuppressWarnings("unchecked")
		EList<EObject> fromRef = (EList<EObject>) from.eGet(reference);
		assumeThat(fromRef.size(), greaterThan(1));

		EObject alice = fromRef.get(0);
		alice.eSet(attribute, 42);
		EObject betty = fromRef.get(1);
		betty.eSet(attribute, 17);

		@SuppressWarnings("unchecked")
		EList<EObject> toRef = (EList<EObject>) to.eGet(reference);
		assumeThat(toRef, MoreMatchers.emptyIterable());
		EObject newAlice = EcoreUtil.copy(alice);
		toRef.add(newAlice);

		EObject resolved = fixture.getCorresponding(alice, to, correspondence);
		assertThat(resolved, sameInstance(newAlice));

		resolved = fixture.getCorresponding(betty, to, correspondence);
		assertThat(resolved, notNullValue());
		assertThat(resolved, not(sameInstance(betty)));
		assertThat(resolved.eGet(name), is("Betty"));
		assertThat(resolved.eGet(attribute), not(17)); // Not recursively mapped
		assertThat(toRef.size(), not(greaterThan(1)));
		assertThat(toRef, not(hasItem(resolved)));
	}

	@Test
	public void getCorresponding_mapRecursive() {
		@SuppressWarnings("unchecked")
		EList<EObject> fromRef = (EList<EObject>) from.eGet(reference);
		assumeThat(fromRef.size(), greaterThan(1));

		EObject alice = fromRef.get(0);
		alice.eSet(attribute, 42);
		EObject betty = fromRef.get(1);
		betty.eSet(attribute, 17);

		@SuppressWarnings("unchecked")
		EList<EObject> toRef = (EList<EObject>) to.eGet(reference);
		assumeThat(toRef, MoreMatchers.emptyIterable());
		EObject newAlice = EcoreUtil.copy(alice);
		toRef.add(newAlice);

		EObject resolved = fixture.getCorresponding(alice, to, correspondence, fixture);
		assertThat(resolved, sameInstance(newAlice));

		resolved = fixture.getCorresponding(betty, to, correspondence, fixture);
		assertThat(resolved, notNullValue());
		assertThat(resolved, not(sameInstance(betty)));
		assertThat(resolved.eGet(name), is("Betty"));
		assertThat(resolved.eGet(attribute), is(17)); // Recursively mapped
		assertThat(toRef.size(), not(greaterThan(1)));
		assertThat(toRef, not(hasItem(resolved)));
	}

	//
	// Test framework
	//

	@Before
	public void getMetadata() {
		name = (EAttribute) eClass.getEStructuralFeature("name");
	}

	static class TestMapping extends SyncMapping<EObject> {

		@Inject
		private EReference reference;

		@Inject
		private EAttribute attribute;

		@Inject
		private ICorrespondenceResolver<EObject, EObject, EObject> correspondence;

		@Inject
		public TestMapping(EClass type, IFactory factory) {
			super(type, factory);
		}

		@Override
		protected void mapProperties(IOne<EObject> from, IOne<EObject> to) {
			bindProperty(from, to, attribute);

			mapCorresponding(from, to, reference, correspondence, this);
		}

		//
		// Make protected API locally visible
		//

		IFactory getFactory0() {
			return getFactory();
		}

		@Override
		protected <P> IBox<P> property(IBox<? extends EObject> ofBox, Object identifiedBy) {
			return super.property(ofBox, identifiedBy);
		}

		@Override
		protected <P, E> IBox<P> property(IBox<E> ofBox, Object ofType, Object identifiedBy) {
			return super.property(ofBox, ofType, identifiedBy);
		}

		@Override
		protected <P, R> IPair<IBox<P>, IBox<R>> mapProperty(IBox<? extends EObject> fromBox, IBox<? extends EObject> toBox, Object identifiedBy, IMapping<? super P, ? super R> using) {
			return super.mapProperty(fromBox, toBox, identifiedBy, using);
		}

		@Override
		protected <P> IPair<IBox<P>, IBox<P>> bindProperty(IBox<? extends EObject> fromBox, IBox<? extends EObject> toBox, Object identifiedBy) {
			return super.bindProperty(fromBox, toBox, identifiedBy);
		}

		@Override
		protected <P> IPair<IBox<P>, IBox<P>> bindPropertyValue(IBox<P> fromBox, IBox<? extends EObject> toBox, Object identifiedBy) {
			return super.bindPropertyValue(fromBox, toBox, identifiedBy);
		}

		@Override
		protected <P> IPair<IBox<P>, IBox<P>> bindPropertyValue(IBox<P> fromBox, IBox<? extends EObject> toBox, Object ofType, Object identifiedBy) {
			return super.bindPropertyValue(fromBox, toBox, ofType, identifiedBy);
		}

		@Override
		protected <D, E, G extends EObject, U extends EObject> IPair<IBox<D>, IBox<E>> mapCorresponding(IOne<G> fromContext, IOne<U> toContext, Object property, ICorrespondenceResolver<D, E, ? super U> resolvedWith) {
			return super.mapCorresponding(fromContext, toContext, property, resolvedWith);
		}

		@Override
		protected <D, E, G extends EObject, U extends EObject> IPair<IBox<D>, IBox<E>> mapCorresponding(IOne<G> fromContext, IOne<U> toContext, Object property, ICorrespondenceResolver<D, E, ? super U> resolvedWith, IMapping<? super D, ? super E> mappedWith) {
			return super.mapCorresponding(fromContext, toContext, property, resolvedWith, mappedWith);
		}

		@Override
		protected <D, E, C> E getCorresponding(D from, C toContext, ICorrespondenceResolver<D, E, ? super C> resolvedWith) {
			return super.getCorresponding(from, toContext, resolvedWith);
		}

		@Override
		protected <D, E, C> E getCorresponding(D from, C toContext, ICorrespondenceResolver<D, E, ? super C> resolvedWith, IMapping<? super D, ? super E> mappedWith) {
			return super.getCorresponding(from, toContext, resolvedWith, mappedWith);
		}

	}
}
