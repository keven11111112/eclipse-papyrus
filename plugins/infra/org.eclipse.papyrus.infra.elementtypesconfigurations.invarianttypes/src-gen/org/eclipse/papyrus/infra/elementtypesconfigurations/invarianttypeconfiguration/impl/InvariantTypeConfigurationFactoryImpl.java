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
package org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InvariantTypeConfigurationFactoryImpl extends EFactoryImpl implements InvariantTypeConfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InvariantTypeConfigurationFactory init() {
		try {
			InvariantTypeConfigurationFactory theInvariantTypeConfigurationFactory = (InvariantTypeConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory(InvariantTypeConfigurationPackage.eNS_URI);
			if (theInvariantTypeConfigurationFactory != null) {
				return theInvariantTypeConfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new InvariantTypeConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantTypeConfigurationFactoryImpl() {
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
			case InvariantTypeConfigurationPackage.INVARIANT_TYPE_CONFIGURATION: return createInvariantTypeConfiguration();
			case InvariantTypeConfigurationPackage.AND_INVARIANT_RULE_CONFIGURATION: return createAndInvariantRuleConfiguration();
			case InvariantTypeConfigurationPackage.OR_INVARIANT_RULE_CONFIGURATION: return createOrInvariantRuleConfiguration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantTypeConfiguration createInvariantTypeConfiguration() {
		InvariantTypeConfigurationImpl invariantTypeConfiguration = new InvariantTypeConfigurationImpl();
		return invariantTypeConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AndInvariantRuleConfiguration createAndInvariantRuleConfiguration() {
		AndInvariantRuleConfigurationImpl andInvariantRuleConfiguration = new AndInvariantRuleConfigurationImpl();
		return andInvariantRuleConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrInvariantRuleConfiguration createOrInvariantRuleConfiguration() {
		OrInvariantRuleConfigurationImpl orInvariantRuleConfiguration = new OrInvariantRuleConfigurationImpl();
		return orInvariantRuleConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantTypeConfigurationPackage getInvariantTypeConfigurationPackage() {
		return (InvariantTypeConfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static InvariantTypeConfigurationPackage getPackage() {
		return InvariantTypeConfigurationPackage.eINSTANCE;
	}

} //InvariantTypeConfigurationFactoryImpl
