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
package org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InvariantContainerRuleConfigurationFactoryImpl extends EFactoryImpl implements InvariantContainerRuleConfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InvariantContainerRuleConfigurationFactory init() {
		try {
			InvariantContainerRuleConfigurationFactory theInvariantContainerRuleConfigurationFactory = (InvariantContainerRuleConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory(InvariantContainerRuleConfigurationPackage.eNS_URI);
			if (theInvariantContainerRuleConfigurationFactory != null) {
				return theInvariantContainerRuleConfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new InvariantContainerRuleConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantContainerRuleConfigurationFactoryImpl() {
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
			case InvariantContainerRuleConfigurationPackage.INVARIANT_CONTAINER_RULE_CONFIGURATION: return createInvariantContainerRuleConfiguration();
			case InvariantContainerRuleConfigurationPackage.HIERARCHY_PERMISSION: return createHierarchyPermission();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantContainerRuleConfiguration createInvariantContainerRuleConfiguration() {
		InvariantContainerRuleConfigurationImpl invariantContainerRuleConfiguration = new InvariantContainerRuleConfigurationImpl();
		return invariantContainerRuleConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HierarchyPermission createHierarchyPermission() {
		HierarchyPermissionImpl hierarchyPermission = new HierarchyPermissionImpl();
		return hierarchyPermission;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantContainerRuleConfigurationPackage getInvariantContainerRuleConfigurationPackage() {
		return (InvariantContainerRuleConfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static InvariantContainerRuleConfigurationPackage getPackage() {
		return InvariantContainerRuleConfigurationPackage.eINSTANCE;
	}

} //InvariantContainerRuleConfigurationFactoryImpl
