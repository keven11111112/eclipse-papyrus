/**
 * Copyright (c) 2015 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.sysml14.portandflows.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.sysml14.blocks.tests.BlockTest;

import org.eclipse.papyrus.sysml14.portandflows.InterfaceBlock;
import org.eclipse.papyrus.sysml14.portandflows.PortandflowsFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Interface Block</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class InterfaceBlockTest extends BlockTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(InterfaceBlockTest.class);
	}

	/**
	 * Constructs a new Interface Block test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceBlockTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Interface Block test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected InterfaceBlock getFixture() {
		return (InterfaceBlock)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(PortandflowsFactory.eINSTANCE.createInterfaceBlock());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //InterfaceBlockTest
