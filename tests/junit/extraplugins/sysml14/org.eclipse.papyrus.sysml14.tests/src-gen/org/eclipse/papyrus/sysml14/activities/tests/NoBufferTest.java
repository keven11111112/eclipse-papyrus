/**
 * Copyright (c) 2015 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.sysml14.activities.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.papyrus.sysml14.activities.ActivitiesFactory;
import org.eclipse.papyrus.sysml14.activities.NoBuffer;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>No Buffer</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NoBufferTest extends TestCase {

	/**
	 * The fixture for this No Buffer test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NoBuffer fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(NoBufferTest.class);
	}

	/**
	 * Constructs a new No Buffer test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NoBufferTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this No Buffer test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(NoBuffer fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this No Buffer test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NoBuffer getFixture() {
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
		setFixture(ActivitiesFactory.eINSTANCE.createNoBuffer());
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

} //NoBufferTest
