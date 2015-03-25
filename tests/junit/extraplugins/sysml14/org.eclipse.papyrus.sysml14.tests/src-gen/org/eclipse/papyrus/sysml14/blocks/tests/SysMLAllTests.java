/**
 * Copyright (c) 2015 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.sysml14.blocks.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

import org.eclipse.papyrus.sysml14.allocations.tests.AllocationsTests;

import org.eclipse.papyrus.sysml14.deprecatedelements.tests.DeprecatedelementsTests;

import org.eclipse.papyrus.sysml14.modelelements.tests.ModelelementsTests;

import org.eclipse.papyrus.sysml14.requirements.tests.RequirementsTests;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>SysML</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class SysMLAllTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new SysMLAllTests("SysML Tests"); //$NON-NLS-1$
		suite.addTest(BlocksTests.suite());
		suite.addTest(ModelelementsTests.suite());
		suite.addTest(AllocationsTests.suite());
		suite.addTest(RequirementsTests.suite());
		suite.addTest(DeprecatedelementsTests.suite());
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SysMLAllTests(String name) {
		super(name);
	}

} //SysMLAllTests
