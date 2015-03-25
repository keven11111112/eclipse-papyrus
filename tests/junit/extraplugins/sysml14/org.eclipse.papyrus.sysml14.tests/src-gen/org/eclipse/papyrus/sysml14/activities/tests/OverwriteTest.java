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
import org.eclipse.papyrus.sysml14.activities.Overwrite;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Overwrite</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OverwriteTest extends TestCase {

	/**
	 * The fixture for this Overwrite test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Overwrite fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OverwriteTest.class);
	}

	/**
	 * Constructs a new Overwrite test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OverwriteTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Overwrite test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Overwrite fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Overwrite test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Overwrite getFixture() {
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
		setFixture(ActivitiesFactory.eINSTANCE.createOverwrite());
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

} //OverwriteTest
