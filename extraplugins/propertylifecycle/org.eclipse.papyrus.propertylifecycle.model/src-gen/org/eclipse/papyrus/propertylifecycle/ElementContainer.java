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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The informations defining the required immediate possible container(s) of the element
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.ElementContainer#getContainersContainer <em>Containers Container</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage#getElementContainer()
 * @model
 * @generated
 */
public interface ElementContainer extends ElementTemplate {
	/**
	 * Returns the value of the '<em><b>Containers Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containers Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Containers Container</em>' containment reference.
	 * @see #setContainersContainer(ElementContainer)
	 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage#getElementContainer_ContainersContainer()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	ElementContainer getContainersContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.propertylifecycle.ElementContainer#getContainersContainer <em>Containers Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Containers Container</em>' containment reference.
	 * @see #getContainersContainer()
	 * @generated
	 */
	void setContainersContainer(ElementContainer value);

} // ElementContainer
