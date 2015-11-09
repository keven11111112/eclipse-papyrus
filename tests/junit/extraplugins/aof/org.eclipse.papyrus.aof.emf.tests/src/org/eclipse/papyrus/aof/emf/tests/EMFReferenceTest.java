/*******************************************************************************
 *  Copyright (c) 2015 ESEO, Christian W. Damus, and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Olivier Beaudoux - initial API and implementation
 *     Christian W. Damus - add support for "unsettable" features
 *     
 *******************************************************************************/
package org.eclipse.papyrus.aof.emf.tests;

import static org.eclipse.papyrus.aof.core.tests.matchers.BoxMatchers.sameAs;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IUnaryFunction;
import org.eclipse.papyrus.aof.core.tests.matchers.BoxMatchers;
import org.eclipse.papyrus.aof.core.tests.operation.CollectBoxTest;
import org.eclipse.papyrus.aof.core.utils.Boxes;
import org.eclipse.papyrus.aof.emf.EMFFactory;
import org.eclipse.papyrus.aof.emf.tests.population.Person;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Test cases for the handling of EMF {@link EReference}s, especially those that
 * are scalar and {@link EStructuralFeature#isUnsettable() unsettable}.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EMFReferenceTest extends CollectBoxTest implements EMFTest {

	@Test
	public void testRemovalInReferenceListBinding() {
		// Can't directly bind containments or references that have opposites:
		// that results in concurrent modifications (see
		// testBindReferencesWithOpposites)
		Person fred = createPerson("Fred");
		Person alice = createPerson("Alice");
		Person betty = createPerson("Betty");
		Person caroline = createPerson("Caroline");
		fred.getAcquaintances().addAll(Arrays.asList(alice, betty, caroline));

		Person jane = createPerson("Jane");

		IBox<Person> fredsPeeps = factory.createPropertyBox(fred, epackage.getPerson_Acquaintances());
		IBox<Person> janesPeeps = factory.createPropertyBox(jane, epackage.getPerson_Acquaintances());

		janesPeeps.bind(fredsPeeps);

		assumeThat(janesPeeps, sameAs(fredsPeeps));
		assumeThat(jane.getAcquaintances(), is(fred.getAcquaintances())); // The model is correct, too!

		fredsPeeps.remove(betty);

		IBox<Person> expectedBox = Boxes.immutableOrderedSet(alice, caroline);
		List<Person> expectedList = Arrays.asList(alice, caroline);

		assumeThat(fredsPeeps, sameAs(expectedBox));
		assumeThat(fred.getAcquaintances(), is(expectedList));

		assertThat(janesPeeps, sameAs(expectedBox));
		assertThat(jane.getAcquaintances(), is(expectedList));
	}

	/**
	 * A correct implementation of the EMF integration must fail to bind
	 * directly references with opposites, because the opposite constraint
	 * prevents the bound properties from ever having the same value (unless
	 * that value be empty/null).
	 */
	@Test
	public void testBindReferencesWithOpposites() {
		Person fred = createPerson("Fred", "Alice", "Betty", "Caroline");
		Person jane = createPerson("Jane");

		IBox<Person> fredsChildren = factory.createPropertyBox(fred, epackage.getPerson_Children());
		IBox<Person> janesChildren = factory.createPropertyBox(jane, epackage.getPerson_Children());

		try {
			janesChildren.bind(fredsChildren);

			// Either the bound lists must not be equal, or must both be empty,
			// or ...
			assertThat(jane.getChildren(), either(not(fred.getChildren())).or(is(Collections.emptyList())));
			assertThat(janesChildren, either(not(sameAs(fredsChildren))).or(sameAs(Boxes.emptyOrderedSet())));
		} catch (RuntimeException e) {
			// ... we got some exception, such as concurrent modification
			System.out.printf("Got expected %s: %s%n", e.getClass().getSimpleName(), e.getMessage());
		}
	}

	@Test
	public void obsoleteListFeatureDelegateNotReused() {
		Person fred = createPerson("Fred", "Alice", "Betty", "Caroline");
		Person alice = fred.getChildren().get(0);
		Person betty = fred.getChildren().get(1);
		Person caroline = fred.getChildren().get(2);

		IUnaryFunction<Person, String> nameFunction = Person::getName;
		IBox<Person> fredsChildren = factory.createPropertyBox(fred, epackage.getPerson_Children());

		// Grab the adapters involved in boxes up to this point
		Set<Adapter> originalAdapters = new HashSet<>();
		originalAdapters.addAll(fred.eAdapters());

		IBox<String> childNames = fredsChildren.collectTo(nameFunction);

		assumeThat(childNames, BoxMatchers.sameAs(factory.createOrderedSet("Alice", "Betty", "Caroline")));

		// Now, destroy the collectTo operation by detaching its source box
		fred.eAdapters().retainAll(originalAdapters);

		Person donna = createPerson("Donna");
		fred.getChildren().add(1, donna);

		// And build a new collectTo operation on the same property
		fredsChildren = factory.createPropertyBox(fred, epackage.getPerson_Children());

		// This should be consistent with the new Fred state
		assertThat(fredsChildren, BoxMatchers.sameAs(factory.createOrderedSet(alice, donna, betty, caroline)));

		childNames = fredsChildren.collectTo(nameFunction);

		// This should be consistent with the new Fred state
		assertThat(childNames, BoxMatchers.sameAs(factory.createOrderedSet("Alice", "Donna", "Betty", "Caroline")));
	}

	//
	// Test framework
	//

	@Override
	protected IFactory createFactory() {
		IFactory factory = new EMFFactory();
		return factory;
	}

	private Person createPerson(String name) {
		Person person = efactory.createPerson();
		person.setName(name);
		person.getEmails().add(name.toLowerCase() + "@hip.com");
		person.getEmails().add(name.toLowerCase() + "@hop.fr");
		return person;
	}

	private Person createPerson(String parentName, String childName, String... moreChildNames) {
		Person result = createPerson(parentName);

		result.getChildren().add(createPerson(childName));
		for (String next : moreChildNames) {
			result.getChildren().add(createPerson(next));
		}

		return result;
	}

}
