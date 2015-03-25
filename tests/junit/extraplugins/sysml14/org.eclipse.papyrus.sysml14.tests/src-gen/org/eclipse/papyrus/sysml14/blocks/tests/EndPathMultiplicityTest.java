/**
 * Copyright (c) 2015 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.sysml14.blocks.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.papyrus.sysml14.blocks.BlocksFactory;
import org.eclipse.papyrus.sysml14.blocks.EndPathMultiplicity;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>End Path Multiplicity</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EndPathMultiplicityTest extends TestCase {

	/**
	 * The fixture for this End Path Multiplicity test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EndPathMultiplicity fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EndPathMultiplicityTest.class);
	}

	/**
	 * Constructs a new End Path Multiplicity test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndPathMultiplicityTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this End Path Multiplicity test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(EndPathMultiplicity fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this End Path Multiplicity test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EndPathMultiplicity getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(BlocksFactory.eINSTANCE.createEndPathMultiplicity());
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

} //EndPathMultiplicityTest
