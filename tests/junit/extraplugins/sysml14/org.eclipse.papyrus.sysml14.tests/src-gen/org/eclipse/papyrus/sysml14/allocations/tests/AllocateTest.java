/**
 * Copyright (c) 2015 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.sysml14.allocations.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.sysml14.allocations.Allocate;
import org.eclipse.papyrus.sysml14.allocations.AllocationsFactory;

import org.eclipse.papyrus.sysml14.blocks.tests.DirectedRelationshipPropertyPathTest;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Allocate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.sysml14.allocations.Allocate#getAllocatedFrom(org.eclipse.uml2.uml.NamedElement) <em>Get Allocated From</em>}</li>
 *   <li>{@link org.eclipse.papyrus.sysml14.allocations.Allocate#getAllocatedTo(org.eclipse.uml2.uml.NamedElement) <em>Get Allocated To</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class AllocateTest extends DirectedRelationshipPropertyPathTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AllocateTest.class);
	}

	/**
	 * Constructs a new Allocate test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocateTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Allocate test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Allocate getFixture() {
		return (Allocate)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(AllocationsFactory.eINSTANCE.createAllocate());
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
	 * Tests the '{@link org.eclipse.papyrus.sysml14.allocations.Allocate#getAllocatedFrom(org.eclipse.uml2.uml.NamedElement) <em>Get Allocated From</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.sysml14.allocations.Allocate#getAllocatedFrom(org.eclipse.uml2.uml.NamedElement)
	 * @generated
	 */
	public void testGetAllocatedFrom__NamedElement() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.papyrus.sysml14.allocations.Allocate#getAllocatedTo(org.eclipse.uml2.uml.NamedElement) <em>Get Allocated To</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.sysml14.allocations.Allocate#getAllocatedTo(org.eclipse.uml2.uml.NamedElement)
	 * @generated
	 */
	public void testGetAllocatedTo__NamedElement() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //AllocateTest
