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
package org.eclipse.papyrus.uml.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.uml.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StereotypeApplicationMatcherConfigurationFactoryImpl extends EFactoryImpl implements StereotypeApplicationMatcherConfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StereotypeApplicationMatcherConfigurationFactory init() {
		try {
			StereotypeApplicationMatcherConfigurationFactory theStereotypeApplicationMatcherConfigurationFactory = (StereotypeApplicationMatcherConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory(StereotypeApplicationMatcherConfigurationPackage.eNS_URI);
			if (theStereotypeApplicationMatcherConfigurationFactory != null) {
				return theStereotypeApplicationMatcherConfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StereotypeApplicationMatcherConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StereotypeApplicationMatcherConfigurationFactoryImpl() {
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
			case StereotypeApplicationMatcherConfigurationPackage.STEREOTYPE_APPLICATION_MATCHER_CONFIGURATION: return createStereotypeApplicationMatcherConfiguration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StereotypeApplicationMatcherConfiguration createStereotypeApplicationMatcherConfiguration() {
		StereotypeApplicationMatcherConfigurationImpl stereotypeApplicationMatcherConfiguration = new StereotypeApplicationMatcherConfigurationImpl();
		return stereotypeApplicationMatcherConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StereotypeApplicationMatcherConfigurationPackage getStereotypeApplicationMatcherConfigurationPackage() {
		return (StereotypeApplicationMatcherConfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StereotypeApplicationMatcherConfigurationPackage getPackage() {
		return StereotypeApplicationMatcherConfigurationPackage.eINSTANCE;
	}

} //StereotypeApplicationMatcherConfigurationFactoryImpl
