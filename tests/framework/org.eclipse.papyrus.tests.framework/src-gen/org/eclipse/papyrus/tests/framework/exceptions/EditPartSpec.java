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

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edit Part Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec#getComposite <em>Composite</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage#getEditPartSpec()
 * @model abstract="true"
 * @generated
 */
public interface EditPartSpec extends EObject {
	/**
	 * Returns the value of the '<em><b>Composite</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.tests.framework.exceptions.CompositeEditPartSpec#getOperands <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Composite</em>' container reference.
	 * @see #setComposite(CompositeEditPartSpec)
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage#getEditPartSpec_Composite()
	 * @see org.eclipse.papyrus.tests.framework.exceptions.CompositeEditPartSpec#getOperands
	 * @model opposite="operand" transient="false" ordered="false"
	 * @generated
	 */
	CompositeEditPartSpec getComposite();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec#getComposite <em>Composite</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Composite</em>' container reference.
	 * @see #getComposite()
	 * @generated
	 */
	void setComposite(CompositeEditPartSpec value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false" editPartRequired="true" editPartOrdered="false"
	 * @generated
	 */
	boolean matches(InstanceSpecification editPart);

} // EditPartSpec
