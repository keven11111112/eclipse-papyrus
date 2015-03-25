/**
 * Copyright (c) 2015 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.sysml14.blocks.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.sysml14.blocks.BlocksFactory;
import org.eclipse.papyrus.sysml14.blocks.BoundReference;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Bound Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.sysml14.blocks.BoundReference#getBindingPath() <em>Binding Path</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class BoundReferenceTest extends EndPathMultiplicityTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(BoundReferenceTest.class);
	}

	/**
	 * Constructs a new Bound Reference test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundReferenceTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Bound Reference test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected BoundReference getFixture() {
		return (BoundReference)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(BlocksFactory.eINSTANCE.createBoundReference());
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
	 * Tests the '{@link org.eclipse.papyrus.sysml14.blocks.BoundReference#getBindingPath() <em>Binding Path</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.sysml14.blocks.BoundReference#getBindingPath()
	 * @generated
	 */
	public void testGetBindingPath() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //BoundReferenceTest
