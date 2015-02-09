/**
 * Copyright (c) 2014 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 */
package org.eclipse.papyrus.infra.gmfdiag.assistant.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>assistant</b></em>' package.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class AssistantTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new AssistantTests("assistant Tests"); //$NON-NLS-1$
		suite.addTestSuite(AssistedElementTypeFilterTest.class);
		suite.addTestSuite(ModelingAssistantProviderTest.class);
		suite.addTestSuite(PopupAssistantTest.class);
		suite.addTestSuite(ConnectionAssistantTest.class);
		suite.addTestSuite(ElementTypeFilterTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public AssistantTests(String name) {
		super(name);
	}

} // AssistantTests
