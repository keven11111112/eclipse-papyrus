/**
 * Copyright (c) 2015 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 */
package org.eclipse.papyrus.aof.sync.gmf.syncstyles.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.gmf.runtime.notation.NotationPackage;

import org.eclipse.papyrus.aof.sync.emf.syncmapping.SyncMappingPackage;

import org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncExclusion;
import org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncStyle;
import org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncStylesFactory;
import org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncStylesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SyncStylesPackageImpl extends EPackageImpl implements SyncStylesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass syncStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass syncExclusionEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncStylesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SyncStylesPackageImpl() {
		super(eNS_URI, SyncStylesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>
	 * This method is used to initialize {@link SyncStylesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SyncStylesPackage init() {
		if (isInited) {
			return (SyncStylesPackage) EPackage.Registry.INSTANCE.getEPackage(SyncStylesPackage.eNS_URI);
		}

		// Obtain or create and register package
		SyncStylesPackageImpl theSyncStylesPackage = (SyncStylesPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SyncStylesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SyncStylesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		NotationPackage.eINSTANCE.eClass();
		SyncMappingPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSyncStylesPackage.createPackageContents();

		// Initialize created meta-data
		theSyncStylesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSyncStylesPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SyncStylesPackage.eNS_URI, theSyncStylesPackage);
		return theSyncStylesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getSyncStyle() {
		return syncStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getSyncExclusion() {
		return syncExclusionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getSyncExclusion_ExcludedTypes() {
		return (EAttribute) syncExclusionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public SyncStylesFactory getSyncStylesFactory() {
		return (SyncStylesFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) {
			return;
		}
		isCreated = true;

		// Create classes and their features
		syncStyleEClass = createEClass(SYNC_STYLE);

		syncExclusionEClass = createEClass(SYNC_EXCLUSION);
		createEAttribute(syncExclusionEClass, SYNC_EXCLUSION__EXCLUDED_TYPES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) {
			return;
		}
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		NotationPackage theNotationPackage = (NotationPackage) EPackage.Registry.INSTANCE.getEPackage(NotationPackage.eNS_URI);
		SyncMappingPackage theSyncMappingPackage = (SyncMappingPackage) EPackage.Registry.INSTANCE.getEPackage(SyncMappingPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		syncStyleEClass.getESuperTypes().add(theNotationPackage.getStyle());
		syncExclusionEClass.getESuperTypes().add(this.getSyncStyle());

		// Initialize classes and features; add operations and parameters
		initEClass(syncStyleEClass, SyncStyle.class, "SyncStyle", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		EOperation op = addEOperation(syncStyleEClass, ecorePackage.getEBoolean(), "isEnabled", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		EGenericType g1 = createEGenericType(theSyncMappingPackage.getMapping());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "mapping", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theSyncMappingPackage.getMappingContext(), "context", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(syncExclusionEClass, SyncExclusion.class, "SyncExclusion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEAttribute(getSyncExclusion_ExcludedTypes(), g1, "excludedTypes", null, 0, -1, SyncExclusion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} // SyncStylesPackageImpl
