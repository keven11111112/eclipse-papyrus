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
package org.eclipse.papyrus.aof.sync.emf.syncmapping.impl;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.aof.core.IOne;

import org.eclipse.papyrus.aof.core.utils.ObserverTracker;

import org.eclipse.papyrus.aof.sync.AbstractMapping;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.IMappingContext;
import org.eclipse.papyrus.aof.sync.IMappingInstance;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingModel;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.SyncMappingFactory;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.SyncMappingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SyncMappingPackageImpl extends EPackageImpl implements SyncMappingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass mappingInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass iMappingInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass internalInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass internalEObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass mappingModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EDataType oneEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EDataType mappingEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EDataType observerTrackerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EDataType iteratorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EDataType mappingContextEDataType = null;

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
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.SyncMappingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SyncMappingPackageImpl() {
		super(eNS_URI, SyncMappingFactory.eINSTANCE);
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
	 * This method is used to initialize {@link SyncMappingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SyncMappingPackage init() {
		if (isInited) {
			return (SyncMappingPackage) EPackage.Registry.INSTANCE.getEPackage(SyncMappingPackage.eNS_URI);
		}

		// Obtain or create and register package
		SyncMappingPackageImpl theSyncMappingPackage = (SyncMappingPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SyncMappingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SyncMappingPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theSyncMappingPackage.createPackageContents();

		// Initialize created meta-data
		theSyncMappingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSyncMappingPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SyncMappingPackage.eNS_URI, theSyncMappingPackage);
		return theSyncMappingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getMappingInstance() {
		return mappingInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMappingInstance_Type() {
		return (EAttribute) mappingInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMappingInstance_Left() {
		return (EAttribute) mappingInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMappingInstance_Right() {
		return (EAttribute) mappingInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getMappingInstance_Consequent() {
		return (EReference) mappingInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getMappingInstance_Tracker() {
		return (EAttribute) mappingInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getIMappingInstance() {
		return iMappingInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getInternalInstance() {
		return internalInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getInternalEObject() {
		return internalEObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getMappingModel() {
		return mappingModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getMappingModel_Instance() {
		return (EReference) mappingModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EDataType getOne() {
		return oneEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EDataType getMapping() {
		return mappingEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EDataType getObserverTracker() {
		return observerTrackerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EDataType getIterator() {
		return iteratorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EDataType getMappingContext() {
		return mappingContextEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public SyncMappingFactory getSyncMappingFactory() {
		return (SyncMappingFactory) getEFactoryInstance();
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
		mappingInstanceEClass = createEClass(MAPPING_INSTANCE);
		createEAttribute(mappingInstanceEClass, MAPPING_INSTANCE__TYPE);
		createEAttribute(mappingInstanceEClass, MAPPING_INSTANCE__LEFT);
		createEAttribute(mappingInstanceEClass, MAPPING_INSTANCE__RIGHT);
		createEReference(mappingInstanceEClass, MAPPING_INSTANCE__CONSEQUENT);
		createEAttribute(mappingInstanceEClass, MAPPING_INSTANCE__TRACKER);

		iMappingInstanceEClass = createEClass(IMAPPING_INSTANCE);

		internalInstanceEClass = createEClass(INTERNAL_INSTANCE);

		internalEObjectEClass = createEClass(INTERNAL_EOBJECT);

		mappingModelEClass = createEClass(MAPPING_MODEL);
		createEReference(mappingModelEClass, MAPPING_MODEL__INSTANCE);

		// Create data types
		oneEDataType = createEDataType(ONE);
		mappingEDataType = createEDataType(MAPPING);
		observerTrackerEDataType = createEDataType(OBSERVER_TRACKER);
		iteratorEDataType = createEDataType(ITERATOR);
		mappingContextEDataType = createEDataType(MAPPING_CONTEXT);
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

		// Create type parameters
		ETypeParameter mappingInstanceEClass_F = addETypeParameter(mappingInstanceEClass, "F"); //$NON-NLS-1$
		ETypeParameter mappingInstanceEClass_T = addETypeParameter(mappingInstanceEClass, "T"); //$NON-NLS-1$
		addETypeParameter(iMappingInstanceEClass, "F"); //$NON-NLS-1$
		addETypeParameter(iMappingInstanceEClass, "T"); //$NON-NLS-1$
		ETypeParameter internalInstanceEClass_F = addETypeParameter(internalInstanceEClass, "F"); //$NON-NLS-1$
		ETypeParameter internalInstanceEClass_T = addETypeParameter(internalInstanceEClass, "T"); //$NON-NLS-1$
		addETypeParameter(oneEDataType, "E"); //$NON-NLS-1$
		addETypeParameter(mappingEDataType, "F"); //$NON-NLS-1$
		addETypeParameter(mappingEDataType, "T"); //$NON-NLS-1$
		addETypeParameter(iteratorEDataType, "E"); //$NON-NLS-1$

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(this.getInternalInstance());
		EGenericType g2 = createEGenericType(mappingInstanceEClass_F);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(mappingInstanceEClass_T);
		g1.getETypeArguments().add(g2);
		mappingInstanceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getIMappingInstance());
		g2 = createEGenericType(internalInstanceEClass_F);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(internalInstanceEClass_T);
		g1.getETypeArguments().add(g2);
		internalInstanceEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes and features; add operations and parameters
		initEClass(mappingInstanceEClass, MappingInstance.class, "MappingInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		g1 = createEGenericType(this.getMapping());
		g2 = createEGenericType(mappingInstanceEClass_F);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(mappingInstanceEClass_T);
		g1.getETypeArguments().add(g2);
		initEAttribute(getMappingInstance_Type(), g1, "type", null, 1, 1, MappingInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(this.getOne());
		g2 = createEGenericType(mappingInstanceEClass_F);
		g1.getETypeArguments().add(g2);
		initEAttribute(getMappingInstance_Left(), g1, "left", null, 1, 1, MappingInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(this.getOne());
		g2 = createEGenericType(mappingInstanceEClass_T);
		g1.getETypeArguments().add(g2);
		initEAttribute(getMappingInstance_Right(), g1, "right", null, 1, 1, MappingInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(this.getIMappingInstance());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEReference(getMappingInstance_Consequent(), g1, null, "consequent", null, 0, -1, MappingInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMappingInstance_Tracker(), this.getObserverTracker(), "tracker", null, 1, 1, MappingInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		EOperation op = addEOperation(mappingInstanceEClass, null, "addConsequent", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(this.getIMappingInstance());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "consequent", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		addEOperation(mappingInstanceEClass, null, "destroy", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(mappingInstanceEClass, null, "iterator", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(this.getIterator());
		g2 = createEGenericType(this.getIMappingInstance());
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType();
		g2.getETypeArguments().add(g3);
		g3 = createEGenericType();
		g2.getETypeArguments().add(g3);
		initEOperation(op, g1);

		op = addEOperation(mappingInstanceEClass, null, "eBasicSetContainer", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getInternalEObject(), "newContainer", 1, 1, IS_UNIQUE, !IS_ORDERED); //$NON-NLS-1$

		initEClass(iMappingInstanceEClass, IMappingInstance.class, "IMappingInstance", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(internalInstanceEClass, AbstractMapping.InternalInstance.class, "InternalInstance", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(internalEObjectEClass, InternalEObject.class, "InternalEObject", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(mappingModelEClass, MappingModel.class, "MappingModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		g1 = createEGenericType(this.getIMappingInstance());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEReference(getMappingModel_Instance(), g1, null, "instance", null, 0, -1, MappingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		// Initialize data types
		initEDataType(oneEDataType, IOne.class, "One", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(mappingEDataType, IMapping.class, "Mapping", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(observerTrackerEDataType, ObserverTracker.class, "ObserverTracker", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(iteratorEDataType, Iterator.class, "Iterator", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(mappingContextEDataType, IMappingContext.class, "MappingContext", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} // SyncMappingPackageImpl
