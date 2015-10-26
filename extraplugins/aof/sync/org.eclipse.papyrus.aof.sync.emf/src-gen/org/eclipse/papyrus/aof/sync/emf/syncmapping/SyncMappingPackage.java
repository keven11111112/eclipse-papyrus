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
package org.eclipse.papyrus.aof.sync.emf.syncmapping;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.SyncMappingFactory
 * @model kind="package"
 * @generated
 */
public interface SyncMappingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "syncmapping"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/2015/syncmapping"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "syncmapping"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SyncMappingPackage eINSTANCE = org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.SyncMappingPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.aof.sync.IMapping.Instance <em>IMapping Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.aof.sync.IMapping.Instance
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.SyncMappingPackageImpl#getIMappingInstance()
	 * @generated
	 */
	int IMAPPING_INSTANCE = 1;

	/**
	 * The number of structural features of the '<em>IMapping Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAPPING_INSTANCE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.aof.sync.AbstractMapping.InternalInstance <em>Internal Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.aof.sync.AbstractMapping.InternalInstance
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.SyncMappingPackageImpl#getInternalInstance()
	 * @generated
	 */
	int INTERNAL_INSTANCE = 2;

	/**
	 * The number of structural features of the '<em>Internal Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_INSTANCE_FEATURE_COUNT = IMAPPING_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.MappingInstanceImpl <em>Mapping Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.MappingInstanceImpl
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.SyncMappingPackageImpl#getMappingInstance()
	 * @generated
	 */
	int MAPPING_INSTANCE = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INSTANCE__TYPE = INTERNAL_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Left</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INSTANCE__LEFT = INTERNAL_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INSTANCE__RIGHT = INTERNAL_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Consequent</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INSTANCE__CONSEQUENT = INTERNAL_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Tracker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INSTANCE__TRACKER = INTERNAL_INSTANCE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Mapping Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_INSTANCE_FEATURE_COUNT = INTERNAL_INSTANCE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecore.InternalEObject <em>Internal EObject</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.InternalEObject
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.SyncMappingPackageImpl#getInternalEObject()
	 * @generated
	 */
	int INTERNAL_EOBJECT = 3;

	/**
	 * The number of structural features of the '<em>Internal EObject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_EOBJECT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.MappingModelImpl <em>Mapping Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.MappingModelImpl
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.SyncMappingPackageImpl#getMappingModel()
	 * @generated
	 */
	int MAPPING_MODEL = 4;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL__INSTANCE = 0;

	/**
	 * The number of structural features of the '<em>Mapping Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '<em>One</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.aof.core.IOne
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.SyncMappingPackageImpl#getOne()
	 * @generated
	 */
	int ONE = 5;

	/**
	 * The meta object id for the '<em>Mapping</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.aof.sync.IMapping
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.SyncMappingPackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 6;

	/**
	 * The meta object id for the '<em>Observer Tracker</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.aof.core.utils.ObserverTracker
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.SyncMappingPackageImpl#getObserverTracker()
	 * @generated
	 */
	int OBSERVER_TRACKER = 7;

	/**
	 * The meta object id for the '<em>Iterator</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Iterator
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.SyncMappingPackageImpl#getIterator()
	 * @generated
	 */
	int ITERATOR = 8;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance <em>Mapping Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Instance</em>'.
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance
	 * @generated
	 */
	EClass getMappingInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance#getType()
	 * @see #getMappingInstance()
	 * @generated
	 */
	EAttribute getMappingInstance_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Left</em>'.
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance#getLeft()
	 * @see #getMappingInstance()
	 * @generated
	 */
	EAttribute getMappingInstance_Left();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Right</em>'.
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance#getRight()
	 * @see #getMappingInstance()
	 * @generated
	 */
	EAttribute getMappingInstance_Right();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance#getConsequents <em>Consequent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Consequent</em>'.
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance#getConsequents()
	 * @see #getMappingInstance()
	 * @generated
	 */
	EReference getMappingInstance_Consequent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance#getTracker <em>Tracker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tracker</em>'.
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance#getTracker()
	 * @see #getMappingInstance()
	 * @generated
	 */
	EAttribute getMappingInstance_Tracker();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.aof.sync.IMapping.Instance <em>IMapping Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IMapping Instance</em>'.
	 * @see org.eclipse.papyrus.aof.sync.IMapping.Instance
	 * @model instanceClass="org.eclipse.papyrus.aof.sync.IMapping$Instance" typeParameters="F T"
	 * @generated
	 */
	EClass getIMappingInstance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.aof.sync.AbstractMapping.InternalInstance <em>Internal Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Instance</em>'.
	 * @see org.eclipse.papyrus.aof.sync.AbstractMapping.InternalInstance
	 * @model instanceClass="org.eclipse.papyrus.aof.sync.AbstractMapping$InternalInstance" typeParameters="F T" superTypes="org.eclipse.papyrus.aof.sync.emf.syncmapping.IMappingInstance"
	 * @generated
	 */
	EClass getInternalInstance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecore.InternalEObject <em>Internal EObject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal EObject</em>'.
	 * @see org.eclipse.emf.ecore.InternalEObject
	 * @model instanceClass="org.eclipse.emf.ecore.InternalEObject"
	 * @generated
	 */
	EClass getInternalEObject();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingModel <em>Mapping Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Model</em>'.
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingModel
	 * @generated
	 */
	EClass getMappingModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingModel#getInstances <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instance</em>'.
	 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingModel#getInstances()
	 * @see #getMappingModel()
	 * @generated
	 */
	EReference getMappingModel_Instance();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.papyrus.aof.core.IOne <em>One</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>One</em>'.
	 * @see org.eclipse.papyrus.aof.core.IOne
	 * @model instanceClass="org.eclipse.papyrus.aof.core.IOne" typeParameters="E"
	 * @generated
	 */
	EDataType getOne();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.papyrus.aof.sync.IMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Mapping</em>'.
	 * @see org.eclipse.papyrus.aof.sync.IMapping
	 * @model instanceClass="org.eclipse.papyrus.aof.sync.IMapping" typeParameters="F T"
	 * @generated
	 */
	EDataType getMapping();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.papyrus.aof.core.utils.ObserverTracker <em>Observer Tracker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Observer Tracker</em>'.
	 * @see org.eclipse.papyrus.aof.core.utils.ObserverTracker
	 * @model instanceClass="org.eclipse.papyrus.aof.core.utils.ObserverTracker"
	 * @generated
	 */
	EDataType getObserverTracker();

	/**
	 * Returns the meta object for data type '{@link java.util.Iterator <em>Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Iterator</em>'.
	 * @see java.util.Iterator
	 * @model instanceClass="java.util.Iterator" typeParameters="E"
	 * @generated
	 */
	EDataType getIterator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SyncMappingFactory getSyncMappingFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.MappingInstanceImpl <em>Mapping Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.MappingInstanceImpl
		 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.SyncMappingPackageImpl#getMappingInstance()
		 * @generated
		 */
		EClass MAPPING_INSTANCE = eINSTANCE.getMappingInstance();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_INSTANCE__TYPE = eINSTANCE.getMappingInstance_Type();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_INSTANCE__LEFT = eINSTANCE.getMappingInstance_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_INSTANCE__RIGHT = eINSTANCE.getMappingInstance_Right();

		/**
		 * The meta object literal for the '<em><b>Consequent</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_INSTANCE__CONSEQUENT = eINSTANCE.getMappingInstance_Consequent();

		/**
		 * The meta object literal for the '<em><b>Tracker</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_INSTANCE__TRACKER = eINSTANCE.getMappingInstance_Tracker();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.aof.sync.IMapping.Instance <em>IMapping Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.aof.sync.IMapping.Instance
		 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.SyncMappingPackageImpl#getIMappingInstance()
		 * @generated
		 */
		EClass IMAPPING_INSTANCE = eINSTANCE.getIMappingInstance();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.aof.sync.AbstractMapping.InternalInstance <em>Internal Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.aof.sync.AbstractMapping.InternalInstance
		 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.SyncMappingPackageImpl#getInternalInstance()
		 * @generated
		 */
		EClass INTERNAL_INSTANCE = eINSTANCE.getInternalInstance();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecore.InternalEObject <em>Internal EObject</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecore.InternalEObject
		 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.SyncMappingPackageImpl#getInternalEObject()
		 * @generated
		 */
		EClass INTERNAL_EOBJECT = eINSTANCE.getInternalEObject();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.MappingModelImpl <em>Mapping Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.MappingModelImpl
		 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.SyncMappingPackageImpl#getMappingModel()
		 * @generated
		 */
		EClass MAPPING_MODEL = eINSTANCE.getMappingModel();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_MODEL__INSTANCE = eINSTANCE.getMappingModel_Instance();

		/**
		 * The meta object literal for the '<em>One</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.aof.core.IOne
		 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.SyncMappingPackageImpl#getOne()
		 * @generated
		 */
		EDataType ONE = eINSTANCE.getOne();

		/**
		 * The meta object literal for the '<em>Mapping</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.aof.sync.IMapping
		 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.SyncMappingPackageImpl#getMapping()
		 * @generated
		 */
		EDataType MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '<em>Observer Tracker</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.aof.core.utils.ObserverTracker
		 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.SyncMappingPackageImpl#getObserverTracker()
		 * @generated
		 */
		EDataType OBSERVER_TRACKER = eINSTANCE.getObserverTracker();

		/**
		 * The meta object literal for the '<em>Iterator</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Iterator
		 * @see org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.SyncMappingPackageImpl#getIterator()
		 * @generated
		 */
		EDataType ITERATOR = eINSTANCE.getIterator();

	}

} //SyncMappingPackage
