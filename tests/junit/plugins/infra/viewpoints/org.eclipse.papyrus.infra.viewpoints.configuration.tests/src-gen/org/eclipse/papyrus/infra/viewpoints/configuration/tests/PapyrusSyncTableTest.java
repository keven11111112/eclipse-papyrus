/**
 * Copyright (c) 2015 Christian W. Damus and others.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  Christian W. Damus - Initial API and implementation
 *
 *
 */
package org.eclipse.papyrus.infra.viewpoints.configuration.tests;

import junit.textui.TestRunner;

import org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationFactory;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusSyncTable;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Papyrus Sync Table</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PapyrusSyncTableTest extends PapyrusViewTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PapyrusSyncTableTest.class);
	}

	/**
	 * Constructs a new Papyrus Sync Table test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrusSyncTableTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Papyrus Sync Table test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected PapyrusSyncTable getFixture() {
		return (PapyrusSyncTable)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ConfigurationFactory.eINSTANCE.createPapyrusSyncTable());
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

} //PapyrusSyncTableTest
