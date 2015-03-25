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

import org.eclipse.papyrus.sysml14.blocks.tests.DirectedRelationshipPropertyPathTest;

import org.eclipse.papyrus.sysml14.requirements.Refine;
import org.eclipse.papyrus.sysml14.requirements.RequirementsFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Refine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.sysml14.requirements.Refine#getRefines(org.eclipse.uml2.uml.NamedElement) <em>Get Refines</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class RefineTest extends DirectedRelationshipPropertyPathTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RefineTest.class);
	}

	/**
	 * Constructs a new Refine test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefineTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Refine test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Refine getFixture() {
		return (Refine)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RequirementsFactory.eINSTANCE.createRefine());
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
	 * Tests the '{@link org.eclipse.papyrus.sysml14.requirements.Refine#getRefines(org.eclipse.uml2.uml.NamedElement) <em>Get Refines</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.sysml14.requirements.Refine#getRefines(org.eclipse.uml2.uml.NamedElement)
	 * @generated
	 */
	public void testGetRefines__NamedElement() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //RefineTest
