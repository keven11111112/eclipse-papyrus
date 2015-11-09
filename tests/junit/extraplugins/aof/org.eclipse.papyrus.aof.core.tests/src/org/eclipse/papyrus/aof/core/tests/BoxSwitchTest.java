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

import static org.eclipse.papyrus.aof.core.ConstraintsKind.BAG;
import static org.eclipse.papyrus.aof.core.ConstraintsKind.ONE;
import static org.eclipse.papyrus.aof.core.ConstraintsKind.OPTION;
import static org.eclipse.papyrus.aof.core.ConstraintsKind.ORDERED_SET;
import static org.eclipse.papyrus.aof.core.ConstraintsKind.SEQUENCE;
import static org.eclipse.papyrus.aof.core.ConstraintsKind.SET;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.eclipse.papyrus.aof.core.AOFFactory;
import org.eclipse.papyrus.aof.core.ConstraintsKind;
import org.eclipse.papyrus.aof.core.IBag;
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.ICollection;
import org.eclipse.papyrus.aof.core.IConstraints;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.core.IOption;
import org.eclipse.papyrus.aof.core.IOrderedSet;
import org.eclipse.papyrus.aof.core.ISequence;
import org.eclipse.papyrus.aof.core.ISet;
import org.eclipse.papyrus.aof.core.ISingleton;
import org.eclipse.papyrus.aof.core.tests.rules.BoxKind;
import org.eclipse.papyrus.aof.core.utils.BoxSwitch;
import org.eclipse.papyrus.junit.utils.rules.AnnotationRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * Test cases for the {@link BoxSwitch} class.
 */
public class BoxSwitchTest {
	static final String RESULT = "Called the right case method";

	@Rule
	public final AnnotationRule<ConstraintsKind> boxKind = AnnotationRule.create(BoxKind.class);

	//
	// Generic (in terms of IBox API) switch tests
	//

	@Test
	@BoxKind(OPTION)
	public void testSwitchOptionBoxGeneric() {
		assertBoxSwitch(new GenericFixture());
	}

	@Test
	@BoxKind(ONE)
	public void testSwitchOneBoxGeneric() {
		assertBoxSwitch(new GenericFixture());
	}

	@Test
	@BoxKind(SET)
	public void testSwitchSetBoxGeneric() {
		assertBoxSwitch(new GenericFixture());
	}

	@Test
	@BoxKind(ORDERED_SET)
	public void testSwitchOrderedSetBoxGeneric() {
		assertBoxSwitch(new GenericFixture());
	}

	@Test
	@BoxKind(SEQUENCE)
	public void testSwitchSequenceBoxGeneric() {
		assertBoxSwitch(new GenericFixture());
	}

	@Test
	@BoxKind(BAG)
	public void testSwitchBagBoxGeneric() {
		assertBoxSwitch(new GenericFixture());
	}

	//
	// Specific (in terms of subtypes of IBox interface) switch tests
	//

	@Test
	@BoxKind(OPTION)
	public void testSwitchOptionBoxSpecific() {
		assertBoxSwitch(new SpecificFixture());
	}

	@Test
	@BoxKind(ONE)
	public void testSwitchOneBoxSpecific() {
		assertBoxSwitch(new SpecificFixture());
	}

	@Test
	@BoxKind(SET)
	public void testSwitchSetBoxSpecific() {
		assertBoxSwitch(new SpecificFixture());
	}

	@Test
	@BoxKind(ORDERED_SET)
	public void testSwitchOrderedSetBoxSpecific() {
		assertBoxSwitch(new SpecificFixture());
	}

	@Test
	@BoxKind(SEQUENCE)
	public void testSwitchSequenceBoxSpecific() {
		assertBoxSwitch(new SpecificFixture());
	}

	@Test
	@BoxKind(BAG)
	public void testSwitchBagBoxSpecific() {
		assertBoxSwitch(new SpecificFixture());
	}

	//
	// Generic (in terms of IBox API) switch tests for the abstract singleton
	// case
	//

	@Test
	@BoxKind(OPTION)
	public void testSwitchOptionBoxGenericSingleton() {
		assertBoxSwitch(new GenericSingletonFixture());
	}

	@Test
	@BoxKind(ONE)
	public void testSwitchOneBoxGenericSingleton() {
		assertBoxSwitch(new GenericSingletonFixture());
	}

	@Test
	@BoxKind(SET)
	public void testSwitchSetBoxGenericSingleton() {
		assertNotBoxSwitch(new GenericSingletonFixture());
	}

	@Test
	@BoxKind(ORDERED_SET)
	public void testSwitchOrderedSetBoxGenericSingleton() {
		assertNotBoxSwitch(new GenericSingletonFixture());
	}

	@Test
	@BoxKind(SEQUENCE)
	public void testSwitchSequenceBoxGenericSingleton() {
		assertNotBoxSwitch(new GenericSingletonFixture());
	}

	@Test
	@BoxKind(BAG)
	public void testSwitchBagBoxGenericSingleton() {
		assertNotBoxSwitch(new GenericSingletonFixture());
	}

	//
	// Specific (in terms of subtypes of IBox interface) switch tests
	// for the abstract singleton case
	//

	@Test
	@BoxKind(OPTION)
	public void testSwitchOptionBoxSpecificSingleton() {
		assertBoxSwitch(new SpecificSingletonFixture());
	}

	@Test
	@BoxKind(ONE)
	public void testSwitchOneBoxSpecificSingleton() {
		assertBoxSwitch(new SpecificSingletonFixture());
	}

	@Test
	@BoxKind(SET)
	public void testSwitchSetBoxSpecificSingleton() {
		assertNotBoxSwitch(new SpecificSingletonFixture());
	}

	@Test
	@BoxKind(ORDERED_SET)
	public void testSwitchOrderedSetBoxSpecificSingleton() {
		assertNotBoxSwitch(new SpecificSingletonFixture());
	}

	@Test
	@BoxKind(SEQUENCE)
	public void testSwitchSequenceBoxSpecificSingleton() {
		assertNotBoxSwitch(new SpecificSingletonFixture());
	}

	@Test
	@BoxKind(BAG)
	public void testSwitchBagBoxSpecificSingleton() {
		assertNotBoxSwitch(new SpecificSingletonFixture());
	}

	//
	// Generic (in terms of IBox API) switch tests for the abstract collection
	// case
	//

	@Test
	@BoxKind(OPTION)
	public void testSwitchOptionBoxGenericCollection() {
		assertNotBoxSwitch(new GenericCollectionFixture());
	}

	@Test
	@BoxKind(ONE)
	public void testSwitchOneBoxGenericCollection() {
		assertNotBoxSwitch(new GenericCollectionFixture());
	}

	@Test
	@BoxKind(SET)
	public void testSwitchSetBoxGenericCollection() {
		assertBoxSwitch(new GenericCollectionFixture());
	}

	@Test
	@BoxKind(ORDERED_SET)
	public void testSwitchOrderedSetBoxGenericCollection() {
		assertBoxSwitch(new GenericCollectionFixture());
	}

	@Test
	@BoxKind(SEQUENCE)
	public void testSwitchSequenceBoxGenericCollection() {
		assertBoxSwitch(new GenericCollectionFixture());
	}

	@Test
	@BoxKind(BAG)
	public void testSwitchBagBoxGenericCollection() {
		assertBoxSwitch(new GenericCollectionFixture());
	}

	//
	// Specific (in terms of subtypes of IBox interface) switch tests
	// for the abstract collection case
	//

	@Test
	@BoxKind(OPTION)
	public void testSwitchOptionBoxSpecificCollection() {
		assertNotBoxSwitch(new SpecificCollectionFixture());
	}

	@Test
	@BoxKind(ONE)
	public void testSwitchOneBoxSpecificCollection() {
		assertNotBoxSwitch(new SpecificCollectionFixture());
	}

	@Test
	@BoxKind(SET)
	public void testSwitchSetBoxSpecificCollection() {
		assertBoxSwitch(new SpecificCollectionFixture());
	}

	@Test
	@BoxKind(ORDERED_SET)
	public void testSwitchOrderedSetBoxSpecificCollection() {
		assertBoxSwitch(new SpecificCollectionFixture());
	}

	@Test
	@BoxKind(SEQUENCE)
	public void testSwitchSequenceBoxSpecificCollection() {
		assertBoxSwitch(new SpecificCollectionFixture());
	}

	@Test
	@BoxKind(BAG)
	public void testSwitchBagBoxSpecificCollection() {
		assertBoxSwitch(new SpecificCollectionFixture());
	}

	//
	// Test framework
	//

	void assertBoxSwitch(BoxSwitch<String, String> switch_) {
		IBox<String> box = boxKind.get().createBox(AOFFactory.INSTANCE, "Hello");
		assertThat(switch_.doSwitch(box), is(RESULT));
	}

	void assertNotBoxSwitch(BoxSwitch<String, String> switch_) {
		IBox<String> box = boxKind.get().createBox(AOFFactory.INSTANCE, "Hello");
		assertThat(switch_.doSwitch(box), nullValue());
	}

	class SpecificFixture extends BoxSwitch<String, String> {

		@Override
		public String caseOption(IOption<String> option) {
			if (IConstraints.OPTION.matches(option)) {
				return RESULT;
			}
			return super.caseOption(option);
		}

		@Override
		public String caseOne(IOne<String> one) {
			if (IConstraints.ONE.matches(one)) {
				return RESULT;
			}
			return super.caseOne(one);
		}

		@Override
		public String caseSet(ISet<String> set) {
			if (IConstraints.SET.matches(set)) {
				return RESULT;
			}
			return super.caseSet(set);
		}

		@Override
		public String caseOrderedSet(IOrderedSet<String> orderedSet) {
			if (IConstraints.ORDERED_SET.matches(orderedSet)) {
				return RESULT;
			}
			return super.caseOrderedSet(orderedSet);
		}

		@Override
		public String caseSequence(ISequence<String> sequence) {
			if (IConstraints.SEQUENCE.matches(sequence)) {
				return RESULT;
			}
			return super.caseSequence(sequence);
		}

		@Override
		public String caseBag(IBag<String> bag) {
			if (IConstraints.BAG.matches(bag)) {
				return RESULT;
			}
			return super.caseBag(bag);
		}
	}

	class GenericFixture extends BoxSwitch<String, String> {

		@Override
		public String caseOption(IBox<String> box) {
			if (IConstraints.OPTION.matches(box)) {
				return RESULT;
			}
			return super.caseOption(box);
		}

		@Override
		public String caseOne(IBox<String> box) {
			if (IConstraints.ONE.matches(box)) {
				return RESULT;
			}
			return super.caseOne(box);
		}

		@Override
		public String caseSet(IBox<String> box) {
			if (IConstraints.SET.matches(box)) {
				return RESULT;
			}
			return super.caseSet(box);
		}

		@Override
		public String caseOrderedSet(IBox<String> box) {
			if (IConstraints.ORDERED_SET.matches(box)) {
				return RESULT;
			}
			return super.caseOrderedSet(box);
		}

		@Override
		public String caseSequence(IBox<String> box) {
			if (IConstraints.SEQUENCE.matches(box)) {
				return RESULT;
			}
			return super.caseSequence(box);
		}

		@Override
		public String caseBag(IBox<String> box) {
			if (IConstraints.BAG.matches(box)) {
				return RESULT;
			}
			return super.caseBag(box);
		}
	}

	class SpecificSingletonFixture extends BoxSwitch<String, String> {

		@Override
		public String caseSingleton(ISingleton<String> singleton) {
			return RESULT;
		}
	}

	class GenericSingletonFixture extends BoxSwitch<String, String> {

		@Override
		public String caseSingleton(IBox<String> box) {
			return RESULT;
		}
	}

	class SpecificCollectionFixture extends BoxSwitch<String, String> {

		@Override
		public String caseCollection(ICollection<String> collection) {
			return RESULT;
		}
	}

	class GenericCollectionFixture extends BoxSwitch<String, String> {

		@Override
		public String caseCollection(IBox<String> box) {
			return RESULT;
		}
	}
}
