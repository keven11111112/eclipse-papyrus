/**
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 * Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.propertylifecycle;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Contains the standard informations needed to identify the elements affected by this strategy
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.ElementTemplate#getBaseType <em>Base Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.ElementTemplate#getSpecializedType <em>Specialized Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage#getElementTemplate()
 * @model abstract="true"
 * @generated
 */
public interface ElementTemplate extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Base Type</em>' attribute.
	 * @see #setBaseType(String)
	 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage#getElementTemplate_BaseType()
	 * @model required="true"
	 * @generated
	 */
	String getBaseType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.propertylifecycle.ElementTemplate#getBaseType <em>Base Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Base Type</em>' attribute.
	 * @see #getBaseType()
	 * @generated
	 */
	void setBaseType(String value);

	/**
	 * Returns the value of the '<em><b>Specialized Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specialized Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Specialized Type</em>' attribute.
	 * @see #setSpecializedType(String)
	 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage#getElementTemplate_SpecializedType()
	 * @model
	 * @generated
	 */
	String getSpecializedType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.propertylifecycle.ElementTemplate#getSpecializedType <em>Specialized Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Specialized Type</em>' attribute.
	 * @see #getSpecializedType()
	 * @generated
	 */
	void setSpecializedType(String value);

} // ElementTemplate
