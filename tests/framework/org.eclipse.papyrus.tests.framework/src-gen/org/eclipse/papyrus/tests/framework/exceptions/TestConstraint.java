/**
 * Copyright (c) 2015 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 */
package org.eclipse.papyrus.tests.framework.exceptions;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.TestConstraint#getContainer <em>Container</em>}</li>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.TestConstraint#isOmitOnFailure <em>Omit On Failure</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage#getTestConstraint()
 * @model abstract="true"
 * @generated
 */
public interface TestConstraint extends EObject {
	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.tests.framework.exceptions.TestExceptions#getConstraints <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(TestExceptions)
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage#getTestConstraint_Container()
	 * @see org.eclipse.papyrus.tests.framework.exceptions.TestExceptions#getConstraints
	 * @model opposite="constraint" required="true" transient="false" ordered="false"
	 * @generated
	 */
	TestExceptions getContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.tests.framework.exceptions.TestConstraint#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(TestExceptions value);

	/**
	 * Returns the value of the '<em><b>Omit On Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Omit On Failure</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Omit On Failure</em>' attribute.
	 * @see #setOmitOnFailure(boolean)
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage#getTestConstraint_OmitOnFailure()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isOmitOnFailure();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.tests.framework.exceptions.TestConstraint#isOmitOnFailure <em>Omit On Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Omit On Failure</em>' attribute.
	 * @see #isOmitOnFailure()
	 * @generated
	 */
	void setOmitOnFailure(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false" editPartUnique="false" editPartRequired="true" editPartMany="true" testClassRequired="true" testClassOrdered="false" diagnosticsRequired="true" diagnosticsOrdered="false"
	 * @generated
	 */
	boolean validate(EList<InstanceSpecification> editPart, org.eclipse.uml2.uml.Class testClass, DiagnosticChain diagnostics);

} // TestConstraint
