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

package org.eclipse.papyrus.aof.core.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import java.util.Iterator;

import org.eclipse.papyrus.aof.core.AOFFactory;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IConstraints;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.ISingleton;
import org.eclipse.papyrus.aof.core.utils.BoxSwitch;
import org.eclipse.papyrus.aof.core.utils.Boxes;
import org.junit.Test;

/**
 * Test cases for the {@link Boxes} class.
 */
public class BoxesTest {

	//
	// Empty box constants
	//

	@Test
	public void testEmptyOption() {
		testEmptyBox(IConstraints.OPTION, Boxes.<String> emptyOption());
	}

	@Test
	public void testEmptyOne() {
		testEmptyBox(IConstraints.ONE, Boxes.<String> emptyOne());
	}

	@Test
	public void testEmptySet() {
		testEmptyBox(IConstraints.SET, Boxes.<String> emptySet());
	}

	@Test
	public void testEmptyOrderedSet() {
		testEmptyBox(IConstraints.ORDERED_SET, Boxes.<String> emptyOrderedSet());
	}

	@Test
	public void testEmptySequence() {
		testEmptyBox(IConstraints.SEQUENCE, Boxes.<String> emptySequence());
	}

	@Test
	public void testEmptyBag() {
		testEmptyBox(IConstraints.BAG, Boxes.<String> emptyBag());
	}

	void testEmptyBox(IConstraints type, IBox<String> box) {
		assertThat("Wrong box type", box.getConstraints(), is(type));
		if (type.matches(IConstraints.ONE)) {
			// Even the empty one has an element, but it's always null,
			// because of the default feature
			assertThat(box.length(), is(1));
			assertThat(box.get(0), nullValue());

			Iterator<String> iter = box.iterator();
			assertThat(iter.hasNext(), is(true));
			assertThat(iter.next(), nullValue());
			assertThat(iter.hasNext(), is(false));

			IOne<String> one = (IOne<String>) box;
			assertThat(one.getDefaultElement(), nullValue());

			assertThrows(() -> one.clear("foo"));
		} else {
			assertThat(box.length(), is(0));
			assertThat(box.iterator().hasNext(), is(false));

			assertThrows(() -> box.get(0));

			if (box.isSingleton()) {
				ISingleton<String> singleton = (ISingleton<String>) box;
				assertThrows(singleton::get);
				assertThrows(() -> singleton.set("foo"));
			}
		}

		assertThrows(box::clear);
		assertThrows(() -> box.add("Hello"));
		assertThrows(() -> box.add(0, "Hello"));
		assertThrows(() -> box.remove("Hello"));
		assertThrows(() -> box.removeAt(0));
		assertThrows(() -> box.set(0, "Hello"));
		assertThrows(() -> box.move(0, 0));
		assertThrows(() -> box.assign("Hello", "Good-bye"));
		assertThrows(() -> box.assign(AOFFactory.INSTANCE.createOne("Hello")));
	}

	//
	// Immutable boxes
	//

	@Test
	public void testImmutableOption() {
		testImmutableBox(Boxes.immutableOption("a"));
	}

	@Test
	public void testImmutableOne() {
		testImmutableBox(Boxes.immutableOne("a"));
	}

	@Test
	public void testImmutableSet() {
		testImmutableBox(Boxes.immutableSet("a", "b", "b", "c"));
	}

	@Test
	public void testImmutableOrderedSet() {
		testImmutableBox(Boxes.immutableOrderedSet("a", "b", "b", "c"));
	}

	@Test
	public void testImmutableSequence() {
		testImmutableBox(Boxes.immutableSequence("a", "b", "b", "c"));
	}

	@Test
	public void testImmutableBag() {
		testImmutableBox(Boxes.immutableBag("a", "b", "b", "c"));
	}

	void testImmutableBox(IBox<String> box) {
		new BoxSwitch<String, Boolean>() {
			@Override
			public Boolean caseOption(IBox<String> box) {
				assertThat(box.sameAs(AOFFactory.INSTANCE.createOption("a")), is(true));
				return true;
			}

			@Override
			public Boolean caseOne(IBox<String> box) {
				assertThat(box.sameAs(AOFFactory.INSTANCE.createOne("a")), is(true));
				return true;
			}

			@Override
			public Boolean caseSet(IBox<String> box) {
				assertThat(box.sameAs(AOFFactory.INSTANCE.createSet("a", "b", "b", "c")), is(true));
				return true;
			}

			@Override
			public Boolean caseOrderedSet(IBox<String> box) {
				assertThat(box.sameAs(AOFFactory.INSTANCE.createOrderedSet("a", "b", "b", "c")), is(true));
				return true;
			}

			@Override
			public Boolean caseSequence(IBox<String> box) {
				assertThat(box.sameAs(AOFFactory.INSTANCE.createSequence("a", "b", "b", "c")), is(true));
				return true;
			}

			@Override
			public Boolean caseBag(IBox<String> box) {
				assertThat(box.sameAs(AOFFactory.INSTANCE.createBag("a", "b", "b", "c")), is(true));
				return true;
			}

			@Override
			public Boolean defaultCase(IBox<String> box) {
				fail("Invalid box type");
				return false; // unreachable
			}
		}.doSwitch(box);

		if (box.matches(IConstraints.ONE)) {
			IOne<String> one = (IOne<String>) box;

			assertThrows(() -> one.clear("foo"));
		} else {
			if (box.isSingleton()) {
				ISingleton<String> singleton = (ISingleton<String>) box;
				assertThrows(() -> singleton.set("foo"));
			}
		}

		assertThrows(box::clear);
		assertThrows(() -> box.add("Hello"));
		assertThrows(() -> box.add(0, "Hello"));
		assertThrows(() -> box.remove("Hello"));
		assertThrows(() -> box.removeAt(0));
		assertThrows(() -> box.set(0, "Hello"));
		assertThrows(() -> box.move(0, 0));
		assertThrows(() -> box.assign("Hello", "Good-bye"));
		assertThrows(() -> box.assign(AOFFactory.INSTANCE.createOne("Hello")));
	}

	//
	// Test framework
	//

	void assertThrows(Runnable test) {
		assertThrows(test, RuntimeException.class);
	}

	void assertThrows(Runnable test, Class<? extends Exception> exceptionType) {
		try {
			test.run();
			fail("Should have thrown");
		} catch (Exception e) {
			if (exceptionType.isInstance(e)) {
				System.out.printf("Got expected %s: %s%n", e.getClass().getSimpleName(), e.getMessage());
			} else {
				fail("Unexpected exception type thrown: " + e.getClass().getSimpleName());
			}
		}
	}
}
