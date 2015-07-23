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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Exceptions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.TestExceptions#getConstraints <em>Constraint</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage#getTestExceptions()
 * @model
 * @generated
 */
public interface TestExceptions extends EObject {
	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.tests.framework.exceptions.TestConstraint}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.tests.framework.exceptions.TestConstraint#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Constraint</em>' containment reference list.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage#getTestExceptions_Constraint()
	 * @see org.eclipse.papyrus.tests.framework.exceptions.TestConstraint#getContainer
	 * @model opposite="container" containment="true" ordered="false"
	 * @generated
	 */
	EList<TestConstraint> getConstraints();

	/**
	 * Creates a new {@link org.eclipse.papyrus.tests.framework.exceptions.TestConstraint} and appends it to the '<em><b>Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param eClass
	 *            The Ecore class of the {@link org.eclipse.papyrus.tests.framework.exceptions.TestConstraint} to create.
	 * @return The new {@link org.eclipse.papyrus.tests.framework.exceptions.TestConstraint}.
	 * @see #getConstraints()
	 * @generated
	 */
	TestConstraint createConstraint(EClass eClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false" editPartUnique="false" editPartRequired="true" editPartMany="true" testClassRequired="true" testClassOrdered="false" diagnosticsRequired="true" diagnosticsOrdered="false"
	 * @generated
	 */
	boolean validate(EList<InstanceSpecification> editPart, org.eclipse.uml2.uml.Class testClass, DiagnosticChain diagnostics);

} // TestExceptions
