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
package org.eclipse.papyrus.aof.sync.gmf.syncstyles;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.gmf.runtime.notation.NotationPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncStylesFactory
 * @model kind="package"
 * @generated
 */
public interface SyncStylesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNAME = "syncstyles"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/Papyrus/2015/sync/gmf/styles"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_PREFIX = "sync"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	SyncStylesPackage eINSTANCE = org.eclipse.papyrus.aof.sync.gmf.syncstyles.impl.SyncStylesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncStyle <em>Sync Style</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncStyle
	 * @see org.eclipse.papyrus.aof.sync.gmf.syncstyles.impl.SyncStylesPackageImpl#getSyncStyle()
	 * @generated
	 */
	int SYNC_STYLE = 0;

	/**
	 * The number of structural features of the '<em>Sync Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SYNC_STYLE_FEATURE_COUNT = NotationPackage.STYLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.aof.sync.gmf.syncstyles.impl.SyncExclusionImpl <em>Sync Exclusion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.aof.sync.gmf.syncstyles.impl.SyncExclusionImpl
	 * @see org.eclipse.papyrus.aof.sync.gmf.syncstyles.impl.SyncStylesPackageImpl#getSyncExclusion()
	 * @generated
	 */
	int SYNC_EXCLUSION = 1;

	/**
	 * The feature id for the '<em><b>Excluded Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SYNC_EXCLUSION__EXCLUDED_TYPES = SYNC_STYLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sync Exclusion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int SYNC_EXCLUSION_FEATURE_COUNT = SYNC_STYLE_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncStyle <em>Sync Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Sync Style</em>'.
	 * @see org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncStyle
	 * @generated
	 */
	EClass getSyncStyle();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncExclusion <em>Sync Exclusion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Sync Exclusion</em>'.
	 * @see org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncExclusion
	 * @generated
	 */
	EClass getSyncExclusion();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncExclusion#getExcludedTypes <em>Excluded Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute list '<em>Excluded Types</em>'.
	 * @see org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncExclusion#getExcludedTypes()
	 * @see #getSyncExclusion()
	 * @generated
	 */
	EAttribute getSyncExclusion_ExcludedTypes();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SyncStylesFactory getSyncStylesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each operation of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncStyle <em>Sync Style</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncStyle
		 * @see org.eclipse.papyrus.aof.sync.gmf.syncstyles.impl.SyncStylesPackageImpl#getSyncStyle()
		 * @generated
		 */
		EClass SYNC_STYLE = eINSTANCE.getSyncStyle();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.aof.sync.gmf.syncstyles.impl.SyncExclusionImpl <em>Sync Exclusion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.aof.sync.gmf.syncstyles.impl.SyncExclusionImpl
		 * @see org.eclipse.papyrus.aof.sync.gmf.syncstyles.impl.SyncStylesPackageImpl#getSyncExclusion()
		 * @generated
		 */
		EClass SYNC_EXCLUSION = eINSTANCE.getSyncExclusion();

		/**
		 * The meta object literal for the '<em><b>Excluded Types</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute SYNC_EXCLUSION__EXCLUDED_TYPES = eINSTANCE.getSyncExclusion_ExcludedTypes();

	}

} // SyncStylesPackage
