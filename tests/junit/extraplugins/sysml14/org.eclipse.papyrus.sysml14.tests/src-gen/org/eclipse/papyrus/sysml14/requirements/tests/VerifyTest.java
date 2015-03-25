/**
 * Copyright (c) 2015 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.sysml14.requirements.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.sysml14.requirements.RequirementsFactory;
import org.eclipse.papyrus.sysml14.requirements.Verify;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Verify</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.sysml14.requirements.Verify#getVerifies(org.eclipse.uml2.uml.NamedElement) <em>Get Verifies</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class VerifyTest extends TraceTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(VerifyTest.class);
	}

	/**
	 * Constructs a new Verify test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VerifyTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Verify test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Verify getFixture() {
		return (Verify)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RequirementsFactory.eINSTANCE.createVerify());
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

	/**
	 * Tests the '{@link org.eclipse.papyrus.sysml14.requirements.Verify#getVerifies(org.eclipse.uml2.uml.NamedElement) <em>Get Verifies</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.sysml14.requirements.Verify#getVerifies(org.eclipse.uml2.uml.NamedElement)
	 * @generated
	 */
	public void testGetVerifies__NamedElement() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //VerifyTest
