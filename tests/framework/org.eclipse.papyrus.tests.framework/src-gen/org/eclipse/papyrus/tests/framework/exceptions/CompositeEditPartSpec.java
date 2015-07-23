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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Edit Part Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.CompositeEditPartSpec#getOperator <em>Operator</em>}</li>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.CompositeEditPartSpec#getOperands <em>Operand</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage#getCompositeEditPartSpec()
 * @model
 * @generated
 */
public interface CompositeEditPartSpec extends EditPartSpec {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.tests.framework.exceptions.OperatorKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.OperatorKind
	 * @see #setOperator(OperatorKind)
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage#getCompositeEditPartSpec_Operator()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	OperatorKind getOperator();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.tests.framework.exceptions.CompositeEditPartSpec#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Operator</em>' attribute.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.OperatorKind
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(OperatorKind value);

	/**
	 * Returns the value of the '<em><b>Operand</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec#getComposite <em>Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operand</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Operand</em>' containment reference list.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage#getCompositeEditPartSpec_Operand()
	 * @see org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec#getComposite
	 * @model opposite="composite" containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<EditPartSpec> getOperands();

	/**
	 * Creates a new {@link org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec} and appends it to the '<em><b>Operand</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param eClass
	 *            The Ecore class of the {@link org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec} to create.
	 * @return The new {@link org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec}.
	 * @see #getOperands()
	 * @generated
	 */
	EditPartSpec createOperand(EClass eClass);

} // CompositeEditPartSpec
