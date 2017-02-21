/**
 * Copyright (c) 2017 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Maged Elaasar - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.nattable.representation.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.nattable.representation.PapyrusSyncTable;
import org.eclipse.papyrus.infra.nattable.representation.PapyrusTable;
import org.eclipse.papyrus.infra.nattable.representation.RepresentationFactory;
import org.eclipse.papyrus.infra.nattable.representation.RepresentationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RepresentationPackageImpl extends EPackageImpl implements RepresentationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass papyrusSyncTableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass papyrusTableEClass = null;

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
	 * @see org.eclipse.papyrus.infra.nattable.representation.RepresentationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RepresentationPackageImpl() {
		super(eNS_URI, RepresentationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RepresentationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RepresentationPackage init() {
		if (isInited) return (RepresentationPackage)EPackage.Registry.INSTANCE.getEPackage(RepresentationPackage.eNS_URI);

		// Obtain or create and register package
		RepresentationPackageImpl theRepresentationPackage = (RepresentationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RepresentationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RepresentationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		org.eclipse.papyrus.infra.architecture.representation.RepresentationPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRepresentationPackage.createPackageContents();

		// Initialize created meta-data
		theRepresentationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRepresentationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RepresentationPackage.eNS_URI, theRepresentationPackage);
		return theRepresentationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPapyrusSyncTable() {
		return papyrusSyncTableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPapyrusTable() {
		return papyrusTableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPapyrusTable_Configuration() {
		return (EAttribute)papyrusTableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepresentationFactory getRepresentationFactory() {
		return (RepresentationFactory)getEFactoryInstance();
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
		papyrusSyncTableEClass = createEClass(PAPYRUS_SYNC_TABLE);

		papyrusTableEClass = createEClass(PAPYRUS_TABLE);
		createEAttribute(papyrusTableEClass, PAPYRUS_TABLE__CONFIGURATION);
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
		org.eclipse.papyrus.infra.architecture.representation.RepresentationPackage theRepresentationPackage_1 = (org.eclipse.papyrus.infra.architecture.representation.RepresentationPackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.papyrus.infra.architecture.representation.RepresentationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		papyrusSyncTableEClass.getESuperTypes().add(theRepresentationPackage_1.getPapyrusRepresentationKind());
		papyrusTableEClass.getESuperTypes().add(theRepresentationPackage_1.getPapyrusRepresentationKind());

		// Initialize classes, features, and operations; add parameters
		initEClass(papyrusSyncTableEClass, PapyrusSyncTable.class, "PapyrusSyncTable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(papyrusTableEClass, PapyrusTable.class, "PapyrusTable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPapyrusTable_Configuration(), ecorePackage.getEString(), "configuration", null, 1, 1, PapyrusTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //RepresentationPackageImpl
