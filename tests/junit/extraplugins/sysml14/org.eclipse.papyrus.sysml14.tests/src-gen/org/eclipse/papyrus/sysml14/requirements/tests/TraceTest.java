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

import org.eclipse.papyrus.sysml14.requirements.RequirementsFactory;
import org.eclipse.papyrus.sysml14.requirements.Trace;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Trace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.sysml14.requirements.Trace#getTracedFrom(org.eclipse.uml2.uml.NamedElement) <em>Get Traced From</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class TraceTest extends DirectedRelationshipPropertyPathTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TraceTest.class);
	}

	/**
	 * Constructs a new Trace test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Trace test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Trace getFixture() {
		return (Trace)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RequirementsFactory.eINSTANCE.createTrace());
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
	 * Tests the '{@link org.eclipse.papyrus.sysml14.requirements.Trace#getTracedFrom(org.eclipse.uml2.uml.NamedElement) <em>Get Traced From</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.sysml14.requirements.Trace#getTracedFrom(org.eclipse.uml2.uml.NamedElement)
	 * @generated
	 */
	public void testGetTracedFrom__NamedElement() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //TraceTest
