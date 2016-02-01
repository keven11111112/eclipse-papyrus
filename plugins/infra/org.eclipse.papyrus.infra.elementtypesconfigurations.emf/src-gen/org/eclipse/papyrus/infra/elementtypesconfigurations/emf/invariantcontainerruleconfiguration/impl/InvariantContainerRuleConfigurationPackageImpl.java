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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.HierarchyPermission;
import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.InvariantContainerRuleConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.InvariantContainerRuleConfigurationFactory;
import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.InvariantContainerRuleConfigurationPackage;

import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InvariantContainerRuleConfigurationPackageImpl extends EPackageImpl implements InvariantContainerRuleConfigurationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invariantContainerRuleConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hierarchyPermissionEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.InvariantContainerRuleConfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private InvariantContainerRuleConfigurationPackageImpl() {
		super(eNS_URI, InvariantContainerRuleConfigurationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link InvariantContainerRuleConfigurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static InvariantContainerRuleConfigurationPackage init() {
		if (isInited) return (InvariantContainerRuleConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(InvariantContainerRuleConfigurationPackage.eNS_URI);

		// Obtain or create and register package
		InvariantContainerRuleConfigurationPackageImpl theInvariantContainerRuleConfigurationPackage = (InvariantContainerRuleConfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof InvariantContainerRuleConfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new InvariantContainerRuleConfigurationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		InvariantTypeConfigurationPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theInvariantContainerRuleConfigurationPackage.createPackageContents();

		// Initialize created meta-data
		theInvariantContainerRuleConfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theInvariantContainerRuleConfigurationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(InvariantContainerRuleConfigurationPackage.eNS_URI, theInvariantContainerRuleConfigurationPackage);
		return theInvariantContainerRuleConfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvariantContainerRuleConfiguration() {
		return invariantContainerRuleConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvariantContainerRuleConfiguration_Permissions() {
		return (EReference)invariantContainerRuleConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHierarchyPermission() {
		return hierarchyPermissionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHierarchyPermission_ContainerType() {
		return (EAttribute)hierarchyPermissionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHierarchyPermission_Permitted() {
		return (EAttribute)hierarchyPermissionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHierarchyPermission_Strict() {
		return (EAttribute)hierarchyPermissionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantContainerRuleConfigurationFactory getInvariantContainerRuleConfigurationFactory() {
		return (InvariantContainerRuleConfigurationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		invariantContainerRuleConfigurationEClass = createEClass(INVARIANT_CONTAINER_RULE_CONFIGURATION);
		createEReference(invariantContainerRuleConfigurationEClass, INVARIANT_CONTAINER_RULE_CONFIGURATION__PERMISSIONS);

		hierarchyPermissionEClass = createEClass(HIERARCHY_PERMISSION);
		createEAttribute(hierarchyPermissionEClass, HIERARCHY_PERMISSION__CONTAINER_TYPE);
		createEAttribute(hierarchyPermissionEClass, HIERARCHY_PERMISSION__PERMITTED);
		createEAttribute(hierarchyPermissionEClass, HIERARCHY_PERMISSION__STRICT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		InvariantTypeConfigurationPackage theInvariantTypeConfigurationPackage = (InvariantTypeConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(InvariantTypeConfigurationPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		invariantContainerRuleConfigurationEClass.getESuperTypes().add(theInvariantTypeConfigurationPackage.getInvariantRuleConfiguration());

		// Initialize classes, features, and operations; add parameters
		initEClass(invariantContainerRuleConfigurationEClass, InvariantContainerRuleConfiguration.class, "InvariantContainerRuleConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInvariantContainerRuleConfiguration_Permissions(), this.getHierarchyPermission(), null, "permissions", null, 0, -1, InvariantContainerRuleConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hierarchyPermissionEClass, HierarchyPermission.class, "HierarchyPermission", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHierarchyPermission_ContainerType(), theEcorePackage.getEString(), "containerType", null, 1, 1, HierarchyPermission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHierarchyPermission_Permitted(), theEcorePackage.getEBoolean(), "permitted", null, 1, 1, HierarchyPermission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHierarchyPermission_Strict(), theEcorePackage.getEBoolean(), "strict", null, 1, 1, HierarchyPermission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //InvariantContainerRuleConfigurationPackageImpl
