/**
 * Copyright (c) 2015 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.sysml14.modelelements.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.papyrus.sysml14.modelelements.Expose;
import org.eclipse.papyrus.sysml14.modelelements.ModelelementsFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Expose</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExposeTest extends TestCase {

	/**
	 * The fixture for this Expose test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Expose fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ExposeTest.class);
	}

	/**
	 * Constructs a new Expose test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExposeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Expose test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Expose fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Expose test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Expose getFixture() {
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
		setFixture(ModelelementsFactory.eINSTANCE.createExpose());
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

} //ExposeTest
