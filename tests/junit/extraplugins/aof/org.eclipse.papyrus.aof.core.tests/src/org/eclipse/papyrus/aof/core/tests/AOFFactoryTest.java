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
package org.eclipse.papyrus.aof.core.tests;

import static org.eclipse.papyrus.aof.core.tests.matchers.BoxMatchers.matches;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IConstraints;
import org.eclipse.papyrus.aof.core.tests.population.Person;
import org.eclipse.papyrus.aof.core.tests.population.Person2;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AOFFactoryTest extends FactoryTest {

	// Meta-class access

	@Test
	public void testFactoryForGetMetaClassOnPerson() {
		testFactoryForGetMetaClass(Person.class);
	}

	@Test
	public void testFactoryForGetMetaClassOnPojoPerson() {
		testFactoryForGetMetaClass(Person2.class);
	}

	// Property box access

	@Test
	public void testCreatePropertyBoxOnPersonNameProperty() {
		Person person = new Person();
		IBox<Integer> box = factory.createPropertyBox(person, "name");
		person.getName().set("John");
		assertEquals(IConstraints.ONE, box.getConstraints());
		assertEquals(person.getName(), box);
	}

	@Test
	public void testCreatePropertyBoxOnPersonParentProperty() {
		Person parent = new Person();
		Person person = new Person();
		IBox<Integer> box = factory.createPropertyBox(person, "parent");
		person.getParent().set(parent);
		person.getName().set("John");
		parent.getName().set("Jack");
		assertEquals(IConstraints.OPTION, box.getConstraints());
		assertEquals(person.getParent(), box);
	}

	@Test
	public void testCreatePropertyBoxOnPersonChildrenProperty() {
		Person parent = new Person();
		Person person = new Person();
		IBox<Integer> box = factory.createPropertyBox(person, "children");
		parent.getChildren().add(person);
		person.getName().set("John");
		parent.getName().set("Jack");
		assertEquals(IConstraints.SET, box.getConstraints());
		assertEquals(person.getChildren(), box);
	}

	// POJO Property box access

	@Test
	public void testCreatePropertyBoxOnPojoPersonNameProperty() {
		Person2 person = new Person2();
		IBox<String> box = factory.<Person2, String> createPropertyBox(person, "name");
		assertThat(box, matches(IConstraints.ONE));
		box.assign("John");
		assertEquals(person.getName(), "John");
	}

	@Test
	public void testCreatePropertyBoxOnPojoPersonParentProperty() {
		Person2 parent = new Person2("John");
		Person2 person = new Person2("Jane");
		IBox<Person2> box = factory.createPropertyBox(person, "parent");
		assertThat(box, matches(IConstraints.ONE));
		box.assign(parent);
		assertThat(person.getParent(), is(parent));
	}

	@Test
	public void testCreatePropertyBoxOnPojoPersonChildrenProperty() {
		Person2 parent = new Person2("John");
		Person2 person = new Person2("Jane");
		IBox<Person2> box = factory.createPropertyBox(parent, "children");
		assertThat(box, matches(IConstraints.SET));
		box.add(person);
		assertThat(parent.getChildren(), hasItem(person));
	}

}
