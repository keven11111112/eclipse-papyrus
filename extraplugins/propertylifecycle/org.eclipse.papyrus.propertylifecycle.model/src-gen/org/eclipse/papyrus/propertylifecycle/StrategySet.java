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
 * A representation of the model object '<em><b>Strategy Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Root set containing the defined strategies
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.StrategySet#getStrategies <em>Strategies</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage#getStrategySet()
 * @model
 * @generated
 */
public interface StrategySet extends StrategyTemplate {
	/**
	 * Returns the value of the '<em><b>Strategies</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.propertylifecycle.StrategyElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strategies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Strategies</em>' containment reference list.
	 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage#getStrategySet_Strategies()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<StrategyElement> getStrategies();

} // StrategySet
