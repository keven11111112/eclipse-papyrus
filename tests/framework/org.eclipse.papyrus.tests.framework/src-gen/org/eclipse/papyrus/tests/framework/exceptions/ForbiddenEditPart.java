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

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Forbidden Edit Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPart#getEditPart <em>Edit Part</em>}</li>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPart#getReason <em>Reason</em>}</li>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPart#getReasonKind <em>Reason Kind</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage#getForbiddenEditPart()
 * @model
 * @generated
 */
public interface ForbiddenEditPart extends TestConstraint {
	/**
	 * Returns the value of the '<em><b>Edit Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edit Part</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Edit Part</em>' containment reference.
	 * @see #setEditPart(EditPartSpec)
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage#getForbiddenEditPart_EditPart()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EditPartSpec getEditPart();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPart#getEditPart <em>Edit Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Edit Part</em>' containment reference.
	 * @see #getEditPart()
	 * @generated
	 */
	void setEditPart(EditPartSpec value);

	/**
	 * Creates a new {@link org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec} and sets the '<em><b>Edit Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param eClass
	 *            The Ecore class of the {@link org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec} to create.
	 * @return The new {@link org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec}.
	 * @see #getEditPart()
	 * @generated
	 */
	EditPartSpec createEditPart(EClass eClass);

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
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage#getForbiddenEditPart_Reason()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getReason();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPart#getReason <em>Reason</em>}' attribute.
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
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage#getForbiddenEditPart_ReasonKind()
	 * @model default="invalid" required="true" ordered="false"
	 * @generated
	 */
	ForbiddenReasonKind getReasonKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPart#getReasonKind <em>Reason Kind</em>}' attribute.
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

} // ForbiddenEditPart
