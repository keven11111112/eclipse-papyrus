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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage
 * @generated
 */
public interface PropertylifecycleFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	PropertylifecycleFactory eINSTANCE = org.eclipse.papyrus.propertylifecycle.impl.PropertylifecycleFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Strategy Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Strategy Set</em>'.
	 * @generated
	 */
	StrategySet createStrategySet();

	/**
	 * Returns a new object of class '<em>Strategy Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Strategy Element</em>'.
	 * @generated
	 */
	StrategyElement createStrategyElement();

	/**
	 * Returns a new object of class '<em>Element Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Element Container</em>'.
	 * @generated
	 */
	ElementContainer createElementContainer();

	/**
	 * Returns a new object of class '<em>Element Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Element Property</em>'.
	 * @generated
	 */
	ElementProperty createElementProperty();

	/**
	 * Returns a new object of class '<em>Java Processor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Java Processor</em>'.
	 * @generated
	 */
	JavaProcessor createJavaProcessor();

	/**
	 * Returns a new object of class '<em>Basic Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Basic Trigger</em>'.
	 * @generated
	 */
	BasicTrigger createBasicTrigger();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the package supported by this factory.
	 * @generated
	 */
	PropertylifecyclePackage getPropertylifecyclePackage();

} // PropertylifecycleFactory
