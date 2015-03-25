/**
 * Copyright (c) 2015 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.sysml14.portandflows.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.papyrus.sysml14.portandflows.DirectedFeature;
import org.eclipse.papyrus.sysml14.portandflows.PortandflowsFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Directed Feature</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DirectedFeatureTest extends TestCase {

	/**
	 * The fixture for this Directed Feature test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DirectedFeature fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DirectedFeatureTest.class);
	}

	/**
	 * Constructs a new Directed Feature test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectedFeatureTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Directed Feature test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(DirectedFeature fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Directed Feature test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DirectedFeature getFixture() {
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
		setFixture(PortandflowsFactory.eINSTANCE.createDirectedFeature());
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

} //DirectedFeatureTest
