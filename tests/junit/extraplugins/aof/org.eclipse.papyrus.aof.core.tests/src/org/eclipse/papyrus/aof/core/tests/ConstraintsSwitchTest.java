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
import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IConstraints;
import org.eclipse.papyrus.aof.core.tests.rules.BoxKind;
import org.eclipse.papyrus.aof.core.utils.ConstraintsSwitch;
import org.eclipse.papyrus.junit.utils.rules.AnnotationRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * Test cases for the {@link ConstraintsSwitch} class.
 */
public class ConstraintsSwitchTest {
	static final String RESULT = "Called the right case method";

	@Rule
	public final AnnotationRule<ConstraintsKind> constraintsKind = AnnotationRule.create(BoxKind.class);

	//
	// Switch tests for specific constraints types
	//

	@Test
	@BoxKind(OPTION)
	public void testSwitchOptionConstraints() {
		assertConstraintsSwitch(new Fixture());
	}

	@Test
	@BoxKind(ONE)
	public void testSwitchOneConstraints() {
		assertConstraintsSwitch(new Fixture());
	}

	@Test
	@BoxKind(SET)
	public void testSwitchSetConstraints() {
		assertConstraintsSwitch(new Fixture());
	}

	@Test
	@BoxKind(ORDERED_SET)
	public void testSwitchOrderedSetConstraints() {
		assertConstraintsSwitch(new Fixture());
	}

	@Test
	@BoxKind(SEQUENCE)
	public void testSwitchSequenceConstraints() {
		assertConstraintsSwitch(new Fixture());
	}

	@Test
	@BoxKind(BAG)
	public void testSwitchBagConstraints() {
		assertConstraintsSwitch(new Fixture());
	}

	//
	// Switch tests for the abstract singleton case
	//

	@Test
	@BoxKind(OPTION)
	public void testSwitchOptionConstraintsSingleton() {
		assertConstraintsSwitch(new SingletonFixture());
	}

	@Test
	@BoxKind(ONE)
	public void testSwitchOneConstraintsSingleton() {
		assertConstraintsSwitch(new SingletonFixture());
	}

	@Test
	@BoxKind(SET)
	public void testSwitchSetConstraintsSingleton() {
		assertNotConstraintsSwitch(new SingletonFixture());
	}

	@Test
	@BoxKind(ORDERED_SET)
	public void testSwitchOrderedSetConstraintsSingleton() {
		assertNotConstraintsSwitch(new SingletonFixture());
	}

	@Test
	@BoxKind(SEQUENCE)
	public void testSwitchSequenceConstraintsSingleton() {
		assertNotConstraintsSwitch(new SingletonFixture());
	}

	@Test
	@BoxKind(BAG)
	public void testSwitchBagConstraintsSingleton() {
		assertNotConstraintsSwitch(new SingletonFixture());
	}

	//
	// Switch tests for the abstract collection case
	//

	@Test
	@BoxKind(OPTION)
	public void testSwitchOptionConstraintsCollection() {
		assertNotConstraintsSwitch(new CollectionFixture());
	}

	@Test
	@BoxKind(ONE)
	public void testSwitchOneConstraintsCollection() {
		assertNotConstraintsSwitch(new CollectionFixture());
	}

	@Test
	@BoxKind(SET)
	public void testSwitchSetConstraintsCollection() {
		assertConstraintsSwitch(new CollectionFixture());
	}

	@Test
	@BoxKind(ORDERED_SET)
	public void testSwitchOrderedSetConstraintsCollection() {
		assertConstraintsSwitch(new CollectionFixture());
	}

	@Test
	@BoxKind(SEQUENCE)
	public void testSwitchSequenceConstraintsCollection() {
		assertConstraintsSwitch(new CollectionFixture());
	}

	@Test
	@BoxKind(BAG)
	public void testSwitchBagConstraintsCollection() {
		assertConstraintsSwitch(new CollectionFixture());
	}

	//
	// Test framework
	//

	void assertConstraintsSwitch(ConstraintsSwitch<String> switch_) {
		IBox<String> box = constraintsKind.get().createBox(AOFFactory.INSTANCE, "Hello");
		assertThat(switch_.doSwitch(box), is(RESULT));
	}

	void assertNotConstraintsSwitch(ConstraintsSwitch<String> switch_) {
		IBox<String> box = constraintsKind.get().createBox(AOFFactory.INSTANCE, "Hello");
		assertThat(switch_.doSwitch(box), nullValue());
	}

	class Fixture extends ConstraintsSwitch<String> {

		@Override
		public String caseOption(IConstraints constraints) {
			if (IConstraints.OPTION.matches(constraints)) {
				return RESULT;
			}
			return super.caseOption(constraints);
		}

		@Override
		public String caseOne(IConstraints constraints) {
			if (IConstraints.ONE.matches(constraints)) {
				return RESULT;
			}
			return super.caseOne(constraints);
		}

		@Override
		public String caseSet(IConstraints constraints) {
			if (IConstraints.SET.matches(constraints)) {
				return RESULT;
			}
			return super.caseSet(constraints);
		}

		@Override
		public String caseOrderedSet(IConstraints constraints) {
			if (IConstraints.ORDERED_SET.matches(constraints)) {
				return RESULT;
			}
			return super.caseOrderedSet(constraints);
		}

		@Override
		public String caseSequence(IConstraints constraints) {
			if (IConstraints.SEQUENCE.matches(constraints)) {
				return RESULT;
			}
			return super.caseSequence(constraints);
		}

		@Override
		public String caseBag(IConstraints constraints) {
			if (IConstraints.BAG.matches(constraints)) {
				return RESULT;
			}
			return super.caseBag(constraints);
		}
	}

	class SingletonFixture extends ConstraintsSwitch<String> {

		@Override
		public String caseSingleton(IConstraints constraints) {
			return RESULT;
		}
	}

	class CollectionFixture extends ConstraintsSwitch<String> {

		@Override
		public String caseCollection(IConstraints constraints) {
			return RESULT;
		}
	}
}
