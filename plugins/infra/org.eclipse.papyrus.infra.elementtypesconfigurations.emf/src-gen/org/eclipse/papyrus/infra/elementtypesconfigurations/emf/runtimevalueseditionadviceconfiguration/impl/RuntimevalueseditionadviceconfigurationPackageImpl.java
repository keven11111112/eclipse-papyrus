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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage;

import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.runtimevalueseditionadviceconfiguration.RuntimeValuesEditionAdviceConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.runtimevalueseditionadviceconfiguration.RuntimevalueseditionadviceconfigurationFactory;
import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.runtimevalueseditionadviceconfiguration.RuntimevalueseditionadviceconfigurationPackage;
import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.runtimevalueseditionadviceconfiguration.ViewToDisplay;
import org.eclipse.papyrus.infra.properties.contexts.ContextsPackage;
import org.eclipse.papyrus.infra.properties.environment.EnvironmentPackage;
import org.eclipse.papyrus.infra.properties.ui.UiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RuntimevalueseditionadviceconfigurationPackageImpl extends EPackageImpl implements RuntimevalueseditionadviceconfigurationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass runtimeValuesEditionAdviceConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewToDisplayEClass = null;

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
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.runtimevalueseditionadviceconfiguration.RuntimevalueseditionadviceconfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RuntimevalueseditionadviceconfigurationPackageImpl() {
		super(eNS_URI, RuntimevalueseditionadviceconfigurationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RuntimevalueseditionadviceconfigurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RuntimevalueseditionadviceconfigurationPackage init() {
		if (isInited) return (RuntimevalueseditionadviceconfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(RuntimevalueseditionadviceconfigurationPackage.eNS_URI);

		// Obtain or create and register package
		RuntimevalueseditionadviceconfigurationPackageImpl theRuntimevalueseditionadviceconfigurationPackage = (RuntimevalueseditionadviceconfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RuntimevalueseditionadviceconfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RuntimevalueseditionadviceconfigurationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ElementtypesconfigurationsPackage.eINSTANCE.eClass();
		EnvironmentPackage.eINSTANCE.eClass();
		ContextsPackage.eINSTANCE.eClass();
		UiPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRuntimevalueseditionadviceconfigurationPackage.createPackageContents();

		// Initialize created meta-data
		theRuntimevalueseditionadviceconfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRuntimevalueseditionadviceconfigurationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RuntimevalueseditionadviceconfigurationPackage.eNS_URI, theRuntimevalueseditionadviceconfigurationPackage);
		return theRuntimevalueseditionadviceconfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuntimeValuesEditionAdviceConfiguration() {
		return runtimeValuesEditionAdviceConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuntimeValuesEditionAdviceConfiguration_ViewsToDisplay() {
		return (EReference)runtimeValuesEditionAdviceConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViewToDisplay() {
		return viewToDisplayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewToDisplay_View() {
		return (EReference)viewToDisplayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimevalueseditionadviceconfigurationFactory getRuntimevalueseditionadviceconfigurationFactory() {
		return (RuntimevalueseditionadviceconfigurationFactory)getEFactoryInstance();
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
		runtimeValuesEditionAdviceConfigurationEClass = createEClass(RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION);
		createEReference(runtimeValuesEditionAdviceConfigurationEClass, RUNTIME_VALUES_EDITION_ADVICE_CONFIGURATION__VIEWS_TO_DISPLAY);

		viewToDisplayEClass = createEClass(VIEW_TO_DISPLAY);
		createEReference(viewToDisplayEClass, VIEW_TO_DISPLAY__VIEW);
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
		ContextsPackage theContextsPackage = (ContextsPackage)EPackage.Registry.INSTANCE.getEPackage(ContextsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		runtimeValuesEditionAdviceConfigurationEClass.getESuperTypes().add(theElementtypesconfigurationsPackage.getAdviceBindingConfiguration());

		// Initialize classes and features; add operations and parameters
		initEClass(runtimeValuesEditionAdviceConfigurationEClass, RuntimeValuesEditionAdviceConfiguration.class, "RuntimeValuesEditionAdviceConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRuntimeValuesEditionAdviceConfiguration_ViewsToDisplay(), this.getViewToDisplay(), null, "viewsToDisplay", null, 0, -1, RuntimeValuesEditionAdviceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewToDisplayEClass, ViewToDisplay.class, "ViewToDisplay", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getViewToDisplay_View(), theContextsPackage.getView(), null, "view", null, 1, 1, ViewToDisplay.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //RuntimevalueseditionadviceconfigurationPackageImpl
