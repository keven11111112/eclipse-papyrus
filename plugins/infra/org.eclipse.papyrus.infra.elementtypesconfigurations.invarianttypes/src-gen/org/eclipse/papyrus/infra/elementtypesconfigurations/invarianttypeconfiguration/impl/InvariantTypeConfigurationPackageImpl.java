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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage;

import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.AndInvariantRuleConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.CompositeInvariantRuleConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantRuleConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfigurationFactory;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfigurationPackage;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.NotInvariantRuleConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.OrInvariantRuleConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InvariantTypeConfigurationPackageImpl extends EPackageImpl implements InvariantTypeConfigurationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invariantTypeConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invariantRuleConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeInvariantRuleConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notInvariantRuleConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andInvariantRuleConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orInvariantRuleConfigurationEClass = null;

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
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private InvariantTypeConfigurationPackageImpl() {
		super(eNS_URI, InvariantTypeConfigurationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link InvariantTypeConfigurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static InvariantTypeConfigurationPackage init() {
		if (isInited) return (InvariantTypeConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(InvariantTypeConfigurationPackage.eNS_URI);

		// Obtain or create and register package
		InvariantTypeConfigurationPackageImpl theInvariantTypeConfigurationPackage = (InvariantTypeConfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof InvariantTypeConfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new InvariantTypeConfigurationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		ElementtypesconfigurationsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theInvariantTypeConfigurationPackage.createPackageContents();

		// Initialize created meta-data
		theInvariantTypeConfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theInvariantTypeConfigurationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(InvariantTypeConfigurationPackage.eNS_URI, theInvariantTypeConfigurationPackage);
		return theInvariantTypeConfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvariantTypeConfiguration() {
		return invariantTypeConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvariantTypeConfiguration_InvariantRuleConfiguration() {
		return (EReference)invariantTypeConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvariantRuleConfiguration() {
		return invariantRuleConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeInvariantRuleConfiguration() {
		return compositeInvariantRuleConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeInvariantRuleConfiguration_ComposedRules() {
		return (EReference)compositeInvariantRuleConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotInvariantRuleConfiguration() {
		return notInvariantRuleConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNotInvariantRuleConfiguration_ComposedRule() {
		return (EReference)notInvariantRuleConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAndInvariantRuleConfiguration() {
		return andInvariantRuleConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrInvariantRuleConfiguration() {
		return orInvariantRuleConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantTypeConfigurationFactory getInvariantTypeConfigurationFactory() {
		return (InvariantTypeConfigurationFactory)getEFactoryInstance();
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
		invariantTypeConfigurationEClass = createEClass(INVARIANT_TYPE_CONFIGURATION);
		createEReference(invariantTypeConfigurationEClass, INVARIANT_TYPE_CONFIGURATION__INVARIANT_RULE_CONFIGURATION);

		invariantRuleConfigurationEClass = createEClass(INVARIANT_RULE_CONFIGURATION);

		compositeInvariantRuleConfigurationEClass = createEClass(COMPOSITE_INVARIANT_RULE_CONFIGURATION);
		createEReference(compositeInvariantRuleConfigurationEClass, COMPOSITE_INVARIANT_RULE_CONFIGURATION__COMPOSED_RULES);

		notInvariantRuleConfigurationEClass = createEClass(NOT_INVARIANT_RULE_CONFIGURATION);
		createEReference(notInvariantRuleConfigurationEClass, NOT_INVARIANT_RULE_CONFIGURATION__COMPOSED_RULE);

		andInvariantRuleConfigurationEClass = createEClass(AND_INVARIANT_RULE_CONFIGURATION);

		orInvariantRuleConfigurationEClass = createEClass(OR_INVARIANT_RULE_CONFIGURATION);
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
		ElementtypesconfigurationsPackage theElementtypesconfigurationsPackage = (ElementtypesconfigurationsPackage)EPackage.Registry.INSTANCE.getEPackage(ElementtypesconfigurationsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		invariantTypeConfigurationEClass.getESuperTypes().add(theElementtypesconfigurationsPackage.getSpecializationTypeConfiguration());
		compositeInvariantRuleConfigurationEClass.getESuperTypes().add(this.getInvariantRuleConfiguration());
		notInvariantRuleConfigurationEClass.getESuperTypes().add(this.getInvariantRuleConfiguration());
		andInvariantRuleConfigurationEClass.getESuperTypes().add(this.getCompositeInvariantRuleConfiguration());
		orInvariantRuleConfigurationEClass.getESuperTypes().add(this.getCompositeInvariantRuleConfiguration());

		// Initialize classes, features, and operations; add parameters
		initEClass(invariantTypeConfigurationEClass, InvariantTypeConfiguration.class, "InvariantTypeConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInvariantTypeConfiguration_InvariantRuleConfiguration(), this.getInvariantRuleConfiguration(), null, "invariantRuleConfiguration", null, 1, 1, InvariantTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(invariantRuleConfigurationEClass, InvariantRuleConfiguration.class, "InvariantRuleConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compositeInvariantRuleConfigurationEClass, CompositeInvariantRuleConfiguration.class, "CompositeInvariantRuleConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeInvariantRuleConfiguration_ComposedRules(), this.getInvariantRuleConfiguration(), null, "composedRules", null, 2, -1, CompositeInvariantRuleConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(notInvariantRuleConfigurationEClass, NotInvariantRuleConfiguration.class, "NotInvariantRuleConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNotInvariantRuleConfiguration_ComposedRule(), this.getInvariantRuleConfiguration(), null, "composedRule", null, 1, 1, NotInvariantRuleConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(andInvariantRuleConfigurationEClass, AndInvariantRuleConfiguration.class, "AndInvariantRuleConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orInvariantRuleConfigurationEClass, OrInvariantRuleConfiguration.class, "OrInvariantRuleConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //InvariantTypeConfigurationPackageImpl
