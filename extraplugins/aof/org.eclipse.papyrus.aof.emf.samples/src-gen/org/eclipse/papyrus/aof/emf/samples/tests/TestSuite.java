/**
 * Copyright (c) 2015 ESEO.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Olivier Beaudoux - code generated from model Test.ecore
 * 
 */
package org.eclipse.papyrus.aof.emf.samples.tests;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Suite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.aof.emf.samples.tests.TestSuite#getTests <em>Tests</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.aof.emf.samples.tests.TestsPackage#getTestSuite()
 * @model
 * @generated
 */
public interface TestSuite extends EObject {
	/**
	 * Returns the value of the '<em><b>Tests</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.aof.emf.samples.tests.Test}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tests</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tests</em>' containment reference list.
	 * @see org.eclipse.papyrus.aof.emf.samples.tests.TestsPackage#getTestSuite_Tests()
	 * @model containment="true"
	 * @generated
	 */
	EList<Test> getTests();

} // TestSuite
