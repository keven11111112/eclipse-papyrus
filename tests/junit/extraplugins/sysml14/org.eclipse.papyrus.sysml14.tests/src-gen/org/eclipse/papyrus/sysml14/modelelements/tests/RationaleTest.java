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

import org.eclipse.papyrus.sysml14.modelelements.ModelelementsFactory;
import org.eclipse.papyrus.sysml14.modelelements.Rationale;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Rationale</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RationaleTest extends TestCase {

	/**
	 * The fixture for this Rationale test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Rationale fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RationaleTest.class);
	}

	/**
	 * Constructs a new Rationale test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RationaleTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Rationale test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Rationale fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Rationale test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Rationale getFixture() {
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
		setFixture(ModelelementsFactory.eINSTANCE.createRationale());
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

} //RationaleTest
