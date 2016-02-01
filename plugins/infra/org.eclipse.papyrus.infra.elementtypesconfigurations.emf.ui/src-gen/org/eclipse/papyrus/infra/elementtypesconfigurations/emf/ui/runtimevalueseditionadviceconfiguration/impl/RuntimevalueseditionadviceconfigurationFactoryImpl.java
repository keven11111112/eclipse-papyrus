/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.ui.runtimevalueseditionadviceconfiguration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RuntimevalueseditionadviceconfigurationFactoryImpl extends EFactoryImpl implements RuntimevalueseditionadviceconfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RuntimevalueseditionadviceconfigurationFactory init() {
		try {
			RuntimevalueseditionadviceconfigurationFactory theRuntimevalueseditionadviceconfigurationFactory = (RuntimevalueseditionadviceconfigurationFactory)EPackage.Registry.INSTANCE.getEFactory(RuntimevalueseditionadviceconfigurationPackage.eNS_URI);
			if (theRuntimevalueseditionadviceconfigurationFactory != null) {
				return theRuntimevalueseditionadviceconfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RuntimevalueseditionadviceconfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimevalueseditionadviceconfigurationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case RuntimevalueseditionadviceconfigurationPackage.RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION: return createRuntimeValuesEditionAdviceConfiguration();
			case RuntimevalueseditionadviceconfigurationPackage.VIEW_TO_DISPLAY: return createViewToDisplay();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeValuesEditionAdviceConfiguration createRuntimeValuesEditionAdviceConfiguration() {
		RuntimeValuesEditionAdviceConfigurationImpl runtimeValuesEditionAdviceConfiguration = new RuntimeValuesEditionAdviceConfigurationImpl();
		return runtimeValuesEditionAdviceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewToDisplay createViewToDisplay() {
		ViewToDisplayImpl viewToDisplay = new ViewToDisplayImpl();
		return viewToDisplay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimevalueseditionadviceconfigurationPackage getRuntimevalueseditionadviceconfigurationPackage() {
		return (RuntimevalueseditionadviceconfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RuntimevalueseditionadviceconfigurationPackage getPackage() {
		return RuntimevalueseditionadviceconfigurationPackage.eINSTANCE;
	}

} //RuntimevalueseditionadviceconfigurationFactoryImpl
