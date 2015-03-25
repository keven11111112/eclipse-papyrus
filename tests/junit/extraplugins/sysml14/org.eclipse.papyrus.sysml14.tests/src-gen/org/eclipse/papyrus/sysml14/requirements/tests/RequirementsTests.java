/**
 * Copyright (c) 2015 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.sysml14.requirements.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>requirements</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class RequirementsTests extends TestSuite {

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
		TestSuite suite = new RequirementsTests("requirements Tests"); //$NON-NLS-1$
		suite.addTestSuite(DeriveReqtTest.class);
		suite.addTestSuite(TraceTest.class);
		suite.addTestSuite(RequirementTest.class);
		suite.addTestSuite(CopyTest.class);
		suite.addTestSuite(SatisfyTest.class);
		suite.addTestSuite(VerifyTest.class);
		suite.addTestSuite(RefineTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementsTests(String name) {
		super(name);
	}

} //RequirementsTests
