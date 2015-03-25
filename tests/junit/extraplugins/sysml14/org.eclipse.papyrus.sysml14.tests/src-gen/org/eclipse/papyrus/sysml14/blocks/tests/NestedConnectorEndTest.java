/**
 * Copyright (c) 2015 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.sysml14.blocks.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.sysml14.blocks.BlocksFactory;
import org.eclipse.papyrus.sysml14.blocks.NestedConnectorEnd;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Nested Connector End</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NestedConnectorEndTest extends ElementPropertyPathTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(NestedConnectorEndTest.class);
	}

	/**
	 * Constructs a new Nested Connector End test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedConnectorEndTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Nested Connector End test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected NestedConnectorEnd getFixture() {
		return (NestedConnectorEnd)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(BlocksFactory.eINSTANCE.createNestedConnectorEnd());
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

} //NestedConnectorEndTest
