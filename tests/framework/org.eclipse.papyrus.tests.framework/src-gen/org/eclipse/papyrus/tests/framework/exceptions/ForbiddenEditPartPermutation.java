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

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Forbidden Edit Part Permutation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation#getReasonKind <em>Reason Kind</em>}</li>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation#getReason <em>Reason</em>}</li>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation#getTestClasses <em>Test Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation#getEditParts <em>Edit Part</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage#getForbiddenEditPartPermutation()
 * @model
 * @generated
 */
public interface ForbiddenEditPartPermutation extends TestConstraint {
	/**
	 * Returns the value of the '<em><b>Edit Part</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edit Part</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Edit Part</em>' containment reference list.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage#getForbiddenEditPartPermutation_EditPart()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<EditPartSpec> getEditParts();

	/**
	 * Creates a new {@link org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec} and appends it to the '<em><b>Edit Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param eClass
	 *            The Ecore class of the {@link org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec} to create.
	 * @return The new {@link org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec}.
	 * @see #getEditParts()
	 * @generated
	 */
	EditPartSpec createEditPart(EClass eClass);

	/**
	 * Returns the value of the '<em><b>Reason Kind</b></em>' attribute.
	 * The default value is <code>"invalid"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenReasonKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reason Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Reason Kind</em>' attribute.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ForbiddenReasonKind
	 * @see #setReasonKind(ForbiddenReasonKind)
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage#getForbiddenEditPartPermutation_ReasonKind()
	 * @model default="invalid" required="true" ordered="false"
	 * @generated
	 */
	ForbiddenReasonKind getReasonKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation#getReasonKind <em>Reason Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Reason Kind</em>' attribute.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ForbiddenReasonKind
	 * @see #getReasonKind()
	 * @generated
	 */
	void setReasonKind(ForbiddenReasonKind value);

	/**
	 * Returns the value of the '<em><b>Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reason</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Reason</em>' attribute.
	 * @see #setReason(String)
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage#getForbiddenEditPartPermutation_Reason()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getReason();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation#getReason <em>Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Reason</em>' attribute.
	 * @see #getReason()
	 * @generated
	 */
	void setReason(String value);

	/**
	 * Returns the value of the '<em><b>Test Class</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Class</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Test Class</em>' reference list.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage#getForbiddenEditPartPermutation_TestClass()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<org.eclipse.uml2.uml.Class> getTestClasses();

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Class} with the specified '<em><b>Name</b></em>' from the '<em><b>Test Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param name
	 *            The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Class} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.Class} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getTestClasses()
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getTestClass(String name);

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Class} with the specified '<em><b>Name</b></em>' from the '<em><b>Test Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param name
	 *            The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Class} to retrieve, or <code>null</code>.
	 * @param ignoreCase
	 *            Whether to ignore case in {@link java.lang.String} comparisons.
	 * @param eClass
	 *            The Ecore class of the {@link org.eclipse.uml2.uml.Class} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.Class} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getTestClasses()
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getTestClass(String name, boolean ignoreCase, EClass eClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * testClass->forAll(conformsTo(_'org.eclipse.papyrus.uml.diagram.tests'::AbstractPapyrusTestCase.oclAsType(UML::Type)))
	 *
	 * @param diagnostics
	 *            The chain of diagnostics to which problems are to be appended.
	 * @param context
	 *            The cache of context-specific information.
	 *            <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='testClass->forAll(conformsTo(_\'org.eclipse.papyrus.uml.diagram.tests\'::AbstractPapyrusTestCase.oclAsType(UML::Type)))'"
	 * @generated
	 */
	boolean test_classes(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ForbiddenEditPartPermutation
