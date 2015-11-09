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

import org.eclipse.papyrus.aof.core.IMetaClass;
import org.eclipse.papyrus.aof.core.tests.population.Person;
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

}
