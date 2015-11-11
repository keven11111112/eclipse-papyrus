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

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.IMappingContext;
import org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncExclusion;
import org.eclipse.papyrus.aof.sync.gmf.syncstyles.SyncStylesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sync Exclusion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.aof.sync.gmf.syncstyles.impl.SyncExclusionImpl#getExcludedTypes <em>Excluded Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SyncExclusionImpl extends MinimalEObjectImpl.Container implements SyncExclusion {
	/**
	 * The cached value of the '{@link #getExcludedTypes() <em>Excluded Types</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getExcludedTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Class<?>> excludedTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected SyncExclusionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SyncStylesPackage.Literals.SYNC_EXCLUSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<Class<?>> getExcludedTypes() {
		if (excludedTypes == null) {
			excludedTypes = new EDataTypeUniqueEList<Class<?>>(Class.class, this, SyncStylesPackage.SYNC_EXCLUSION__EXCLUDED_TYPES);
		}
		return excludedTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public boolean isEnabled(IMapping<?, ?> mapping, IMappingContext context) {
		return !getExcludedTypes().stream().anyMatch(excl -> mapping == context.getMappingProvider().getMapping(excl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SyncStylesPackage.SYNC_EXCLUSION__EXCLUDED_TYPES:
			return getExcludedTypes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SyncStylesPackage.SYNC_EXCLUSION__EXCLUDED_TYPES:
			getExcludedTypes().clear();
			getExcludedTypes().addAll((Collection<? extends Class<?>>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case SyncStylesPackage.SYNC_EXCLUSION__EXCLUDED_TYPES:
			getExcludedTypes().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case SyncStylesPackage.SYNC_EXCLUSION__EXCLUDED_TYPES:
			return excludedTypes != null && !excludedTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (excludedTypes: "); //$NON-NLS-1$
		result.append(excludedTypes);
		result.append(')');
		return result.toString();
	}

} // SyncExclusionImpl
