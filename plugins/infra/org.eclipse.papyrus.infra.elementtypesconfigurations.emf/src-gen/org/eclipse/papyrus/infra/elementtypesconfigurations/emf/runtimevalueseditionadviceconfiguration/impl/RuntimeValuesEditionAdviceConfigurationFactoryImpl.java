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
package org.eclipse.papyrus.infra.elementtypesconfigurations.emf.runtimevalueseditionadviceconfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.runtimevalueseditionadviceconfiguration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RuntimeValuesEditionAdviceConfigurationFactoryImpl extends EFactoryImpl implements RuntimeValuesEditionAdviceConfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RuntimeValuesEditionAdviceConfigurationFactory init() {
		try {
			RuntimeValuesEditionAdviceConfigurationFactory theRuntimeValuesEditionAdviceConfigurationFactory = (RuntimeValuesEditionAdviceConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory(RuntimeValuesEditionAdviceConfigurationPackage.eNS_URI);
			if (theRuntimeValuesEditionAdviceConfigurationFactory != null) {
				return theRuntimeValuesEditionAdviceConfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RuntimeValuesEditionAdviceConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeValuesEditionAdviceConfigurationFactoryImpl() {
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
			case RuntimeValuesEditionAdviceConfigurationPackage.RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION: return createRuntimeValuesEditionAdviceConfiguration();
			case RuntimeValuesEditionAdviceConfigurationPackage.VIEW_TO_DISPLAY: return createViewToDisplay();
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
	public RuntimeValuesEditionAdviceConfigurationPackage getRuntimeValuesEditionAdviceConfigurationPackage() {
		return (RuntimeValuesEditionAdviceConfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RuntimeValuesEditionAdviceConfigurationPackage getPackage() {
		return RuntimeValuesEditionAdviceConfigurationPackage.eINSTANCE;
	}

} //RuntimeValuesEditionAdviceConfigurationFactoryImpl
