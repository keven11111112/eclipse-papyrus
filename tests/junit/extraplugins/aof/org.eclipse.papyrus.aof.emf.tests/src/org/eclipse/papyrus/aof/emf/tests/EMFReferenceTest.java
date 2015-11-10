/*******************************************************************************
 *  Copyright (c) 2015 ESEO, Christian W. Damus, and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Olivier Beaudoux - initial API and implementation
 *     Christian W. Damus - bug 476683
 *     
 *******************************************************************************/
package org.eclipse.papyrus.aof.emf.tests;

import static org.eclipse.papyrus.aof.core.tests.matchers.BoxMatchers.sameAs;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IMetaClass;
import org.eclipse.papyrus.aof.core.IUnaryFunction;
import org.eclipse.papyrus.aof.core.tests.matchers.BoxMatchers;
import org.eclipse.papyrus.aof.core.tests.operation.CollectBoxTest;
import org.eclipse.papyrus.aof.core.utils.Boxes;
import org.eclipse.papyrus.aof.core.utils.ObserverTracker;
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

	private IMetaClass<Person> personClass;

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

		IBox<Person> expectedBox = Boxes.with().immutableOrderedSet(alice, caroline);
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

		AtomicReference<IBox<Person>> fredsChildren = new AtomicReference<>();
		AtomicReference<IBox<String>> childNames = new AtomicReference<>();
		final IUnaryFunction<Person, String> nameFunction = Person::getName;

		ObserverTracker tracker = ObserverTracker.observeWhile(() -> {
			fredsChildren.set(factory.createPropertyBox(fred, epackage.getPerson_Children()));
			childNames.set(fredsChildren.get().collectTo(nameFunction));
		});

		assumeThat(childNames.get(), BoxMatchers.matches(factory.createOrderedSet("Alice", "Betty", "Caroline")));

		// Now, destroy the collectTo operation
		tracker.dispose();

		Person donna = createPerson("Donna");
		fred.getChildren().add(1, donna);

		// And build a new collectTo operation on the same property
		fredsChildren.set(factory.createPropertyBox(fred, epackage.getPerson_Children()));

		// This should be consistent with the new Fred state
		assertThat(fredsChildren.get(), BoxMatchers.sameAs(factory.createOrderedSet(alice, donna, betty, caroline)));

		childNames.set(fredsChildren.get().collectTo(nameFunction));

		// This should be consistent with the new Fred state
		assertThat(childNames.get(),
				BoxMatchers.sameAs(factory.createOrderedSet("Alice", "Donna", "Betty", "Caroline")));
	}

	@Test
	public void testBindUnsettableReferenceDifferentDefault() {
		Person fred = createPerson("Fred", "Alice", "Betty", "Caroline");
		Person alice = fred.getChildren().get(0);
		Person betty = fred.getChildren().get(1);
		Person caroline = fred.getChildren().get(2);

		Person jane = createPerson("Jane");

		assumeThat(fred.isSetFavorite(), is(false));
		assumeThat(fred.getFavorite(), is(alice)); // The default when unset

		IBox<Person> fredsFave = factory.createPropertyBox(fred, epackage.getPerson_Favorite());
		IBox<Person> janesFave = personClass.<Person> getPropertyAccessor(epackage.getPerson_Favorite()).apply(jane);

		janesFave.bind(fredsFave);

		// The value in fred must be sent to jane
		assertThat(jane.isSetFavorite(), is(true));
		assertThat(jane.getFavorite(), is(alice));

		fred.setFavorite(caroline);

		assertThat(jane.isSetFavorite(), is(true));
		assertThat(jane.getFavorite(), is(caroline));

		fred.unsetFavorite();

		assertThat(fred.getFavorite(), is(alice));

		assertThat(jane.isSetFavorite(), is(true)); // Unset state does not propagate
		assertThat(jane.getFavorite(), is(alice));

		// And backwards

		jane.setFavorite(betty);
		assertThat(fred.isSetFavorite(), is(true));
		assertThat(fred.getFavorite(), is(betty));

		jane.unsetFavorite(); // Must propagate the actual value
		assertThat(fred.isSetFavorite(), is(true));
		assertThat(fred.getFavorite(), nullValue());
	}

	@Test
	public void testBindUnsettableReferenceSameDefault() {
		Person gran = createPerson("Dorothy", "Alice", "Betty", "Caroline", "Fred", "Gilda");
		Person alice = gran.getChildren().get(0);
		Person caroline = gran.getChildren().get(2);
		Person fred = gran.getChildren().get(3);
		Person jane = gran.getChildren().get(4);

		assumeThat(fred.isSetFavorite(), is(false));
		assumeThat(fred.getFavorite(), is(alice)); // The inherited default when unset

		assumeThat(jane.isSetFavorite(), is(false));
		assumeThat(jane.getFavorite(), is(alice)); // The inherited default when unset

		IBox<Person> fredsFave = factory.createPropertyBox(fred, epackage.getPerson_Favorite());
		IBox<Person> janesFave = personClass.<Person> getPropertyAccessor(epackage.getPerson_Favorite()).apply(jane);

		janesFave.bind(fredsFave);

		assertThat(jane.isSetFavorite(), is(false));
		assertThat(jane.getFavorite(), is(alice));

		fred.setFavorite(caroline);

		assertThat(jane.isSetFavorite(), is(true));
		assertThat(jane.getFavorite(), is(caroline));

		fred.unsetFavorite();

		assertThat(fred.getFavorite(), is(alice));

		assertThat(jane.isSetFavorite(), is(true)); // Default-ness is not propagated, only the value
		assertThat(jane.getFavorite(), is(alice));
	}

	//
	// Test framework
	//

	@Override
	protected IFactory createFactory() {
		IFactory factory = new EMFFactory();
		personClass = factory.getMetaClass(epackage.getPerson());
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
