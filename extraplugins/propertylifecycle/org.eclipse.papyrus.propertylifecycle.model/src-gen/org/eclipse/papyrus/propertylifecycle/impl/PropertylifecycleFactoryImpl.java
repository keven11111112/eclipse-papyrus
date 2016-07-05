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
package org.eclipse.papyrus.propertylifecycle.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.propertylifecycle.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PropertylifecycleFactoryImpl extends EFactoryImpl implements PropertylifecycleFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static PropertylifecycleFactory init() {
		try {
			PropertylifecycleFactory thePropertylifecycleFactory = (PropertylifecycleFactory) EPackage.Registry.INSTANCE.getEFactory(PropertylifecyclePackage.eNS_URI);
			if (thePropertylifecycleFactory != null) {
				return thePropertylifecycleFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PropertylifecycleFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public PropertylifecycleFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case PropertylifecyclePackage.STRATEGY_SET:
			return createStrategySet();
		case PropertylifecyclePackage.STRATEGY_ELEMENT:
			return createStrategyElement();
		case PropertylifecyclePackage.ELEMENT_CONTAINER:
			return createElementContainer();
		case PropertylifecyclePackage.ELEMENT_PROPERTY:
			return createElementProperty();
		case PropertylifecyclePackage.JAVA_PROCESSOR:
			return createJavaProcessor();
		case PropertylifecyclePackage.BASIC_TRIGGER:
			return createBasicTrigger();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public StrategySet createStrategySet() {
		StrategySetImpl strategySet = new StrategySetImpl();
		return strategySet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public StrategyElement createStrategyElement() {
		StrategyElementImpl strategyElement = new StrategyElementImpl();
		return strategyElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ElementContainer createElementContainer() {
		ElementContainerImpl elementContainer = new ElementContainerImpl();
		return elementContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ElementProperty createElementProperty() {
		ElementPropertyImpl elementProperty = new ElementPropertyImpl();
		return elementProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public JavaProcessor createJavaProcessor() {
		JavaProcessorImpl javaProcessor = new JavaProcessorImpl();
		return javaProcessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public BasicTrigger createBasicTrigger() {
		BasicTriggerImpl basicTrigger = new BasicTriggerImpl();
		return basicTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public PropertylifecyclePackage getPropertylifecyclePackage() {
		return (PropertylifecyclePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PropertylifecyclePackage getPackage() {
		return PropertylifecyclePackage.eINSTANCE;
	}

} // PropertylifecycleFactoryImpl
