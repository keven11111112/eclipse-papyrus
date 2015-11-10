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
 *******************************************************************************/
package org.eclipse.papyrus.aof.emf.tests;

import static org.eclipse.papyrus.aof.core.tests.matchers.BoxMatchers.sameAs;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assume.assumeThat;

import java.util.Arrays;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IMetaClass;
import org.eclipse.papyrus.aof.core.tests.operation.CollectBoxTest;
import org.eclipse.papyrus.aof.core.utils.Boxes;
import org.eclipse.papyrus.aof.emf.EMFFactory;
import org.eclipse.papyrus.aof.emf.tests.population.Person;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Test cases for the handling of EMF {@link EAttribute}s, especially those that
 * are scalar and primitive-valued.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EMFAttributesTest extends CollectBoxTest implements EMFTest {

	private IMetaClass<Person> personClass;

	@Test
	public void testBindPrimitiveAttribute() {
		Person fred = createPerson("Fred");
		Person joe = createPerson("Joe");

		fred.setAge(41);
		joe.setAge(21);

		assumeThat(fred.getAge(), is(41));
		assumeThat(joe.getAge(), is(21));

		IBox<Integer> fredsAge = factory.createPropertyBox(fred, epackage.getPerson_Age());
		IBox<Integer> joesAge = personClass.<Integer> getPropertyAccessor(epackage.getPerson_Age()).apply(joe);

		joesAge.bind(fredsAge);

		assertThat(fred.getAge(), is(41)); // binding didn't change this one
		assertThat(joe.getAge(), is(41)); // but this one

		fred.setAge(50);
		assertThat(joe.getAge(), is(50));

		joe.setAge(21);
		assertThat(fred.getAge(), is(21));
	}

	@Test
	public void testClearPrimitiveAttribute() {
		Person fred = createPerson("Fred");

		fred.setAge(41);

		assumeThat(fred.getAge(), is(41));

		IBox<Integer> fredsAge = factory.createPropertyBox(fred, epackage.getPerson_Age());

		assertThat(fredsAge.get(0), is(41));

		fredsAge.clear();

		assertThat(fred.getAge(), is(0));
	}

	@Test
	public void testAddMany() {
		Person fred = createPerson("Fred");
		Person jane = createPerson("Jane");

		ECollections.setEList(fred.getLockerCombination(), Arrays.asList(1, 2, 6));
		IBox<Integer> fredsCombo = factory.createPropertyBox(fred, epackage.getPerson_LockerCombination());
		IBox<Integer> janesCombo = personClass.<Integer> getPropertyAccessor(epackage.getPerson_LockerCombination())
				.apply(jane);

		janesCombo.bind(fredsCombo);

		assertThat(janesCombo, sameAs(Boxes.with().immutableSequence(1, 2, 6)));

		fred.getLockerCombination().addAll(2, Arrays.asList(3, 4, 5));

		IBox<Integer> expected = Boxes.with().immutableSequence(1, 2, 3, 4, 5, 6);
		assumeThat(fredsCombo, sameAs(expected));
		assertThat(janesCombo, sameAs(expected));
	}

	@Test
	public void testRemoveMany() {
		Person fred = createPerson("Fred");
		Person jane = createPerson("Jane");

		ECollections.setEList(fred.getLockerCombination(), Arrays.asList(1, 2, 3, 4, 5, 6));
		IBox<Integer> fredsCombo = factory.createPropertyBox(fred, epackage.getPerson_LockerCombination());
		IBox<Integer> janesCombo = personClass.<Integer> getPropertyAccessor(epackage.getPerson_LockerCombination())
				.apply(jane);

		janesCombo.bind(fredsCombo);

		assertThat(janesCombo, sameAs(Boxes.with().immutableSequence(1, 2, 3, 4, 5, 6)));

		fred.getLockerCombination().removeAll(Arrays.asList(3, 4, 5));

		IBox<Integer> expected = Boxes.with().immutableSequence(1, 2, 6);
		assumeThat(fredsCombo, sameAs(expected));
		assertThat(janesCombo, sameAs(expected));
	}

	@Test
	public void testClearList() {
		Person fred = createPerson("Fred");
		Person jane = createPerson("Jane");

		ECollections.setEList(fred.getLockerCombination(), Arrays.asList(1, 2, 6));
		IBox<Integer> fredsCombo = factory.createPropertyBox(fred, epackage.getPerson_LockerCombination());
		IBox<Integer> janesCombo = personClass.<Integer> getPropertyAccessor(epackage.getPerson_LockerCombination())
				.apply(jane);

		janesCombo.bind(fredsCombo);

		assertThat(janesCombo, sameAs(Boxes.with().immutableSequence(1, 2, 6)));

		fred.getLockerCombination().clear();

		IBox<Integer> expected = Boxes.emptySequence();
		assumeThat(fredsCombo, sameAs(expected));
		assertThat(janesCombo, sameAs(expected));
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

}
