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
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeThat;
import java.util.ArrayList;

import org.eclipse.papyrus.aof.core.IMetaClass;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IConstraints;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.IOrderedSet;
import org.eclipse.papyrus.aof.core.ISequence;
import org.eclipse.papyrus.aof.core.ISet;
import org.eclipse.papyrus.aof.core.tests.matchers.BoxMatchers;
import org.eclipse.papyrus.aof.core.tests.population.Person;
import org.eclipse.papyrus.aof.core.tests.population.Person2;
import org.eclipse.papyrus.aof.core.utils.Boxes;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AOFMetaClassTest extends MetaClassTest {

	// Is instance of

	@Test
	public void testBaseIsInstanceOfPerson() {
		testIsInstanceOfMetaClass(new Person(), Person.class, true);
	}

	// Get default instance

	@Test
	public void testGetDefaultInstanceOfPerson() {
		testGetDefaultInstanceOfMetaClass(Person.class);
	}

	// Set default instance

	@Test
	public void testSetDefaultInstanceOfPerson() {
		testSetDefaultInstanceOfMetaClass(Person.class, new Person());
	}

	// Property accessor

	@Test
	public void testGetPropertyAccessorForInvalidPropertyType() {
		thrown.expect(IllegalArgumentException.class);
		testGetPropertyAccessorOfMetaClass(Person.class, new Object(), null);
	}

	@Test
	public void testGetPropertyAccessorForPersonNameProperty() {
		testGetPropertyAccessorOfMetaClass(Person.class, "name", new Person(), "Name");
	}

	@Test
	public void testGetPropertyAccessorForPersonAgeProperty() {
		testGetPropertyAccessorOfMetaClass(Person.class, "age", new Person());
	}

	@Test
	public void testGetPropertyAccessorForPersonParentProperty() {
		testGetPropertyAccessorOfMetaClass(Person.class, "parent", new Person());
	}

	@Test
	public void testGetPropertyAccessorForPersonChildrenProperty() {
		testGetPropertyAccessorOfMetaClass(Person.class, "children", new Person());
	}

	//
	// Subclass queries
	//

	@Override
	public void testIsSubclassOtherPlatform() {
		// Skip this test, because this is not a different platform
	}

	@Override
	protected IMetaClass<?> getAnyPlatformMetaclass() {
		return factory.getMetaClass(Person.class);
	}

	//
	// POJO property accessors
	//

	<E> IBox<E> getProperty(Object object, String name) {
		return factory.getMetaClass(object.getClass()).<E> getPropertyAccessor(name).apply(object);
	}

	@Test
	public void testPojoOnePropertyObjectType() {
		Person2 joe = new Person2();

		IBox<String> box = getProperty(joe, "name");
		assertThat(box, matches(IConstraints.ONE));
		IOne<String> name = (IOne<String>) box;

		assertThat(name.isDefault(), is(true));

		name.set("Joe");

		assertThat(joe.getName(), is("Joe"));
		assertThat(name.isDefault(), is(false));

		name.removeAt(0);

		assertThat(joe.getName(), nullValue());
		assertThat(name.isDefault(), is(true));

		name.add("Joe");

		assertThat(joe.getName(), is("Joe"));
		assertThat(name.isDefault(), is(false));

		name.clear();

		assertThat(joe.getName(), nullValue());
		assertThat(name.isDefault(), is(true));
	}

	@Test
	public void testPojoOnePropertyPrimitiveType() {
		Person2 joe = new Person2("Joe");

		IBox<Integer> box = getProperty(joe, "age");
		assertThat(box, matches(IConstraints.ONE));
		IOne<Integer> age = (IOne<Integer>) box;

		assertThat(age.isDefault(), is(true));
		assertThat(age.get(), is(0));

		age.set(42);

		assertThat(joe.getAge(), is(42));
		assertThat(age.isDefault(), is(false));

		age.clear();

		assertThat(joe.getAge(), is(0));
		assertThat(age.isDefault(), is(true));
	}

	@Test
	public void testPojoSequenceProperty() {
		Person2 joe = new Person2("Joe");

		IBox<Integer> box = getProperty(joe, "lockerCombination");
		assertThat(box, matches(IConstraints.SEQUENCE));
		ISequence<Integer> combo = (ISequence<Integer>) box;

		assertThat(combo.length(), is(0));
		combo.assign(1, 2, 3);
		assertThat(joe.getLockerCombination(), is(array(1, 2, 3)));

		combo.add(2, 4);
		assertThat(joe.getLockerCombination(), is(array(1, 2, 4, 3)));

		combo.move(2, 3);
		assertThat(joe.getLockerCombination(), is(array(1, 2, 3, 4)));

		combo.removeAt(1);
		assertThat(joe.getLockerCombination(), is(array(1, 3, 4)));

		combo.set(1, 2);
		assertThat(joe.getLockerCombination(), is(array(1, 2, 4)));

		combo.remove(4);
		assertThat(joe.getLockerCombination(), is(array(1, 2)));

		combo.clear();
		assertThat(joe.getLockerCombination(), is(Collections.EMPTY_LIST));
	}

	@Test
	public void testPojoSetProperty() {
		Person2 joe = new Person2("Joe");
		Person2 alice = new Person2("Alice");
		Person2 betty = new Person2("Betty");
		Person2 caroline = new Person2("Caroline");
		Person2 daphne = new Person2("Daphne");

		IBox<Person2> box = getProperty(joe, "children");
		assertThat(box, matches(IConstraints.SET));
		ISet<Person2> children = (ISet<Person2>) box;

		assertThat(children.length(), is(0));
		children.assign(alice, betty);
		assertThat(joe.getChildren(), is(set(alice, betty)));

		children.add(1, daphne);
		assertThat(joe.getChildren(), is(set(alice, betty, daphne)));

		children.removeAt(1);
		assertThat(joe.getChildren(), not(set(alice, betty, daphne)));

		children.set(1, caroline);
		assertThat(joe.getChildren(), hasItem(caroline));

		children.clear();
		assertThat(joe.getChildren(), is(Collections.EMPTY_SET));
	}

	@Test
	public void testPojoOrderedSetProperty() {
		Person2 joe = new Person2("Joe");
		String email1 = "joe@example.com";
		String email2 = "joe@example.net";
		String email3 = "joe@example.org";
		String email4 = "joe@example.edu";

		IBox<String> box = getProperty(joe, "emails");
		assertThat(box, matches(IConstraints.ORDERED_SET));
		IOrderedSet<String> emails = (IOrderedSet<String>) box;

		assertThat(emails.length(), is(0));
		emails.assign(email1, email3);
		assertThat(array(joe.getEmails()), is(array(email1, email3)));

		// Can't actually add at an index, as such
		emails.add(1, email4);
		emails.add(1, email2);
		assertThat(array(joe.getEmails()), is(array(email1, email3, email4, email2)));

		emails.removeAt(2);
		assertThat(array(joe.getEmails()), is(array(email1, email3, email2)));

		emails.set(1, email4);
		assertThat(array(joe.getEmails()), is(array(email1, email2, email4)));

		emails.clear();
		assertThat(joe.getEmails(), is(Collections.EMPTY_SET));
	}

	@Test
	public void testPojoReadOnlyProperty() {
		Person2 joe = new Person2("Joe");
		String email = "joe@example.com";
		joe.getEmails().add(email);

		IBox<Boolean> box = getProperty(joe, "addressable");
		assertThat(box, matches(IConstraints.ONE));
		IOne<Boolean> addressable = (IOne<Boolean>) box;

		assertThat(addressable, BoxMatchers.sameAs(Boxes.TRUE));

		joe.getEmails().clear();

		assertThat(addressable, BoxMatchers.sameAs(Boxes.FALSE));

		try {
			addressable.set(true);
			fail("Should have thrown IllegalStateException");
		} catch (IllegalStateException e) {
			// Success
		}
	}

	//
	// Use bindings to test POJO box observability
	//

	@Test
	public void testPojoOnePropertyObservation() {
		Person2 joe = new Person2("Joe");
		Person2 jane = new Person2("Jane");

		IBox<Integer> joesAge = getProperty(joe, "age");
		IBox<Integer> janesAge = getProperty(jane, "age");

		janesAge.bind(joesAge);
		
		assumeThat(joesAge.get(0), is(0));
		assumeThat(janesAge.get(0), is(0));

		joesAge.add(42);
		assertThat(jane.getAge(), is(42));

		joesAge.clear();
		assertThat(jane.getAge(), is(0));
	}

	@Test
	public void testPojoSequencePropertyObservation() {
		Person2 joe = new Person2("Joe");
		Person2 jane = new Person2("Jane");

		IBox<Integer> joesCombo = getProperty(joe, "lockerCombination");
		IBox<Integer> janesCombo = getProperty(jane, "lockerCombination");

		janesCombo.bind(joesCombo);
		
		assumeThat(joesCombo.length(), is(0));
		assumeThat(janesCombo.length(), is(0));
		
		joesCombo.assign(1, 2, 3);
		assertThat(jane.getLockerCombination(), is(array(1, 2, 3)));

		joesCombo.add(2, 4);
		assertThat(jane.getLockerCombination(), is(array(1, 2, 4, 3)));

		joesCombo.move(2, 3);
		assertThat(jane.getLockerCombination(), is(array(1, 2, 3, 4)));

		joesCombo.removeAt(1);
		assertThat(jane.getLockerCombination(), is(array(1, 3, 4)));

		joesCombo.set(1, 2);
		assertThat(jane.getLockerCombination(), is(array(1, 2, 4)));

		joesCombo.remove(4);
		assertThat(jane.getLockerCombination(), is(array(1, 2)));

		joesCombo.clear();
		assertThat(jane.getLockerCombination(), is(Collections.EMPTY_LIST));
	}

	@Test
	public void testPojoSetPropertyObservation() {
		Person2 joe = new Person2("Joe");
		Person2 jane = new Person2("Jane");
		Person2 alice = new Person2("Alice");
		Person2 betty = new Person2("Betty");
		Person2 caroline = new Person2("Caroline");
		Person2 daphne = new Person2("Daphne");

		IBox<Person2> joesChildren = getProperty(joe, "children");
		IBox<Person2> janesChildren = getProperty(jane, "children");

		janesChildren.bind(joesChildren);
		
		assumeThat(joesChildren.length(), is(0));
		assumeThat(janesChildren.length(), is(0));
		
		joesChildren.assign(alice, betty);
		assertThat(jane.getChildren(), is(set(alice, betty)));

		joesChildren.add(1, daphne);
		assertThat(jane.getChildren(), is(set(alice, betty, daphne)));

		joesChildren.removeAt(1);
		assertThat(jane.getChildren(), not(set(alice, betty, daphne)));

		joesChildren.set(1, caroline);
		assertThat(jane.getChildren(), hasItem(caroline));

		joesChildren.clear();
		assertThat(jane.getChildren(), is(Collections.EMPTY_SET));
	}

	@Test
	public void testPojoOrderedSetPropertyObservation() {
		Person2 joe = new Person2("Joe");
		Person2 jane = new Person2("Jane");
		String email1 = "joe@example.com";
		String email2 = "joe@example.net";
		String email3 = "joe@example.org";
		String email4 = "joe@example.edu";

		IBox<String> joesEmails = getProperty(joe, "emails");
		IBox<String> janesEmails = getProperty(jane, "emails");

		janesEmails.bind(joesEmails);
		
		assumeThat(joesEmails.length(), is(0));
		assumeThat(janesEmails.length(), is(0));
		
		joesEmails.assign(email1, email3);
		assertThat(array(jane.getEmails()), is(array(email1, email3)));

		// Can't actually add at an index, as such
		joesEmails.add(1, email4);
		joesEmails.add(1, email2);
		assertThat(array(jane.getEmails()), is(array(email1, email3, email4, email2)));

		joesEmails.removeAt(2);
		assertThat(array(jane.getEmails()), is(array(email1, email3, email2)));

		joesEmails.set(1, email4);
		assertThat(array(jane.getEmails()), is(array(email1, email2, email4)));

		joesEmails.clear();
		assertThat(jane.getEmails(), is(Collections.EMPTY_SET));
	}

	//
	// Test framework
	//

	@SafeVarargs
	static <E> List<E> array(E... elements) {
		return Arrays.asList(elements);
	}

	static <E> List<E> array(Collection<? extends E> elements) {
		return new ArrayList<E>(elements);
	}

	@SafeVarargs
	static <E> Set<E> set(E... elements) {
		return new LinkedHashSet<E>(array(elements));
	}

}
