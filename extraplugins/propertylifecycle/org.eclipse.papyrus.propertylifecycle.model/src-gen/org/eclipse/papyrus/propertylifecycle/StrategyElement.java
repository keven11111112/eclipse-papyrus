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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Strategy Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The element affected by this strategy
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.StrategyElement#getElementContainers <em>Element Containers</em>}</li>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.StrategyElement#getElementProperties <em>Element Properties</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage#getStrategyElement()
 * @model
 * @generated
 */
public interface StrategyElement extends ElementTemplate, StrategyTemplate {
	/**
	 * Returns the value of the '<em><b>Element Containers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.propertylifecycle.ElementContainer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Containers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Element Containers</em>' containment reference list.
	 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage#getStrategyElement_ElementContainers()
	 * @model containment="true"
	 * @generated
	 */
	EList<ElementContainer> getElementContainers();

	/**
	 * Returns the value of the '<em><b>Element Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.propertylifecycle.ElementProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Element Properties</em>' containment reference list.
	 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage#getStrategyElement_ElementProperties()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ElementProperty> getElementProperties();

} // StrategyElement
