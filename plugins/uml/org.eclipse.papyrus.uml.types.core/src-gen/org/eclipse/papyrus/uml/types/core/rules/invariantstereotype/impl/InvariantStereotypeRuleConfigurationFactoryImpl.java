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
package org.eclipse.papyrus.uml.types.core.rules.invariantstereotype.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.uml.types.core.rules.invariantstereotype.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InvariantStereotypeRuleConfigurationFactoryImpl extends EFactoryImpl implements InvariantStereotypeRuleConfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InvariantStereotypeRuleConfigurationFactory init() {
		try {
			InvariantStereotypeRuleConfigurationFactory theInvariantStereotypeRuleConfigurationFactory = (InvariantStereotypeRuleConfigurationFactory) EPackage.Registry.INSTANCE.getEFactory(InvariantStereotypeRuleConfigurationPackage.eNS_URI);
			if (theInvariantStereotypeRuleConfigurationFactory != null) {
				return theInvariantStereotypeRuleConfigurationFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new InvariantStereotypeRuleConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantStereotypeRuleConfigurationFactoryImpl() {
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
		case InvariantStereotypeRuleConfigurationPackage.INVARIANT_STEREOTYPE_RULE_CONFIGURATION:
			return createInvariantStereotypeRuleConfiguration();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantStereotypeRuleConfiguration createInvariantStereotypeRuleConfiguration() {
		InvariantStereotypeRuleConfigurationImpl invariantStereotypeRuleConfiguration = new InvariantStereotypeRuleConfigurationImpl();
		return invariantStereotypeRuleConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantStereotypeRuleConfigurationPackage getInvariantStereotypeRuleConfigurationPackage() {
		return (InvariantStereotypeRuleConfigurationPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static InvariantStereotypeRuleConfigurationPackage getPackage() {
		return InvariantStereotypeRuleConfigurationPackage.eINSTANCE;
	}

} //InvariantStereotypeRuleConfigurationFactoryImpl
