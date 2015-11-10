/*******************************************************************************
 *  Copyright (c) 2015 ESEO, Christian W. Damus, and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     Olivier Beaudoux - JUnit testing of apply operation on all box types
 *     Christian W. Damus - bug 476683
 *******************************************************************************/
package org.eclipse.papyrus.aof.core.tests.operation;

import org.eclipse.papyrus.aof.core.IBox;
import org.eclipse.papyrus.aof.core.IConditionalBinding;
import org.eclipse.papyrus.aof.core.IConstraints;
import org.eclipse.papyrus.aof.core.tests.BaseTest;
import org.eclipse.papyrus.aof.core.utils.Functions;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BindConditionallyTest extends BaseTest {

	// Binding conditionally to a box that already has some initial contents

	@Test
	public void testBindConditionallyNonEmptyOnBagSeq() {
		thrown.expect(IllegalArgumentException.class);
		testBindConditionallyToNonEmptyBox(IConstraints.BAG, IConstraints.SEQUENCE);
	}

	@Test
	public void testBindConditionallyNonEmptyOnSetOne() {
		thrown.expect(IllegalArgumentException.class);
		testBindConditionallyToNonEmptyBox(IConstraints.SET, IConstraints.ONE);
	}

	@Test
	public void testBindConditionallyNonEmptyOnSeqSeq() {
		testBindConditionallyToNonEmptyBox(IConstraints.SEQUENCE, IConstraints.SEQUENCE);
	}

	@Test
	public void testBindConditionallyNonEmptyOnBagBag() {
		testBindConditionallyToNonEmptyBox(IConstraints.BAG, IConstraints.BAG);
	}

	@Test
	public void testBindConditionallyNonEmptyOnOSetOSet() {
		testBindConditionallyToNonEmptyBox(IConstraints.ORDERED_SET, IConstraints.ORDERED_SET);
	}

	@Test
	public void testBindConditionallyNonEmptyOnSetSet() {
		testBindConditionallyToNonEmptyBox(IConstraints.SET, IConstraints.SET);
	}

	@Test
	public void testBindConditionallyNonEmptyOnOptOpt() {
		testBindConditionallyToNonEmptyBox(IConstraints.OPTION, IConstraints.OPTION);
	}

	@Test
	public void testBindConditionallyNonEmptyOnOneOne() {
		testBindConditionallyToNonEmptyBox(IConstraints.ONE, IConstraints.ONE);
	}

	// Case of binding to an initially non-empty box (immediate initialization)
	public void testBindConditionallyToNonEmptyBox(IConstraints leftType, IConstraints rightType) {
		IBox<Integer> leftBox = factory.createBox(leftType);
		IBox<Integer> rightBox = factory.createBox(rightType, 42);
		IBox<Integer> expected = factory.createBox(leftType, 42);

		leftBox.bindConditionally(rightBox, Functions.emptyOrNull());

		assertEquals(expected, leftBox);

		rightBox.set(0, 196);

		// The condition no longer holds
		assertEquals(expected, leftBox);

		leftBox.set(0, 17);

		expected = factory.createBox(rightType, 196);

		// And it's a one-way binding
		assertEquals(expected, rightBox);
	}

	// Binding conditionally to a box that does not yet have any contents

	@Test
	public void testBindConditionallyEmptyOnBagSeq() {
		thrown.expect(IllegalArgumentException.class);
		testBindConditionallyToEmptyBox(IConstraints.BAG, IConstraints.SEQUENCE);
	}

	@Test
	public void testBindConditionallyEmptyOnSetOne() {
		thrown.expect(IllegalArgumentException.class);
		testBindConditionallyToEmptyBox(IConstraints.SET, IConstraints.ONE);
	}

	@Test
	public void testBindConditionallyEmptyOnSeqSeq() {
		testBindConditionallyToEmptyBox(IConstraints.SEQUENCE, IConstraints.SEQUENCE);
	}

	@Test
	public void testBindConditionallyEmptyOnBagBag() {
		testBindConditionallyToEmptyBox(IConstraints.BAG, IConstraints.BAG);
	}

	@Test
	public void testBindConditionallyEmptyOnOSetOSet() {
		testBindConditionallyToEmptyBox(IConstraints.ORDERED_SET, IConstraints.ORDERED_SET);
	}

	@Test
	public void testBindConditionallyEmptyOnSetSet() {
		testBindConditionallyToEmptyBox(IConstraints.SET, IConstraints.SET);
	}

	@Test
	public void testBindConditionallyEmptyOnOptOpt() {
		testBindConditionallyToEmptyBox(IConstraints.OPTION, IConstraints.OPTION);
	}

	@Test
	public void testBindConditionallyEmptyOnOneOne() {
		testBindConditionallyToEmptyBox(IConstraints.ONE, IConstraints.ONE);
	}

	// Case of binding to an initially non-empty box (immediate initialization
	public void testBindConditionallyToEmptyBox(IConstraints leftType, IConstraints rightType) {
		IBox<Integer> leftBox = factory.createBox(leftType);
		IBox<Integer> rightBox = factory.createBox(rightType);
		IBox<Integer> expected = factory.createBox(leftType, 42);

		leftBox.bindConditionally(rightBox, Functions.emptyOrNull());

		assertEquals(rightBox, leftBox);

		rightBox.add(42);

		// Propagate the initial value into the left box
		assertEquals(expected, leftBox);

		rightBox.set(0, 196);

		// The condition no longer holds
		assertEquals(expected, leftBox);

		leftBox.set(0, 17);

		expected = factory.createBox(rightType, 196);

		// And it's a one-way binding
		assertEquals(expected, rightBox);
	}

	// Override the conditional binding to disable it

	@Test
	public void testBindConditionallyOverrideOnBagSeq() {
		thrown.expect(IllegalArgumentException.class);
		testBindConditionallyToOverrideBox(IConstraints.BAG, IConstraints.SEQUENCE);
	}

	@Test
	public void testBindConditionallyOverrideOnSetOne() {
		thrown.expect(IllegalArgumentException.class);
		testBindConditionallyToOverrideBox(IConstraints.SET, IConstraints.ONE);
	}

	@Test
	public void testBindConditionallyOverrideOnSeqSeq() {
		testBindConditionallyToOverrideBox(IConstraints.SEQUENCE, IConstraints.SEQUENCE);
	}

	@Test
	public void testBindConditionallyOverrideOnBagBag() {
		testBindConditionallyToOverrideBox(IConstraints.BAG, IConstraints.BAG);
	}

	@Test
	public void testBindConditionallyOverrideOnOSetOSet() {
		testBindConditionallyToOverrideBox(IConstraints.ORDERED_SET, IConstraints.ORDERED_SET);
	}

	@Test
	public void testBindConditionallyOverrideOnSetSet() {
		testBindConditionallyToOverrideBox(IConstraints.SET, IConstraints.SET);
	}

	@Test
	public void testBindConditionallyOverrideOnOptOpt() {
		testBindConditionallyToOverrideBox(IConstraints.OPTION, IConstraints.OPTION);
	}

	@Test
	public void testBindConditionallyOverrideOnOneOne() {
		testBindConditionallyToOverrideBox(IConstraints.ONE, IConstraints.ONE);
	}

	// Case of binding to an initially non-empty box (immediate initialization
	public void testBindConditionallyToOverrideBox(IConstraints leftType, IConstraints rightType) {
		IBox<Integer> leftBox = factory.createBox(leftType);
		IBox<Integer> rightBox = factory.createBox(rightType);

		IConditionalBinding<Integer, Integer> binding = leftBox.bindConditionally(rightBox, Functions.emptyOrNull());

		assertEquals(rightBox, leftBox);

		binding.setOverrideDisabled(true);

		rightBox.add(42);

		// Overridden: no propagation of the value
		IBox<Integer> expected = factory.createBox(leftType);
		assertEquals(expected, leftBox);

		// Remove the override
		binding.setOverrideDisabled(false);

		// No longer overridden: initial value propagated
		expected = factory.createBox(leftType, 42);
		assertEquals(expected, leftBox);
	}

}
