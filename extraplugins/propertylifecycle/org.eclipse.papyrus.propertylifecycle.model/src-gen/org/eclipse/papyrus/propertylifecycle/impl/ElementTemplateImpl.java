/**
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 * Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.propertylifecycle.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.propertylifecycle.ElementTemplate;
import org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.impl.ElementTemplateImpl#getBaseType <em>Base Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.impl.ElementTemplateImpl#getSpecializedType <em>Specialized Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ElementTemplateImpl extends MinimalEObjectImpl.Container implements ElementTemplate {
	/**
	 * The default value of the '{@link #getBaseType() <em>Base Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getBaseType()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBaseType() <em>Base Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getBaseType()
	 * @generated
	 * @ordered
	 */
	protected String baseType = BASE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpecializedType() <em>Specialized Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getSpecializedType()
	 * @generated
	 * @ordered
	 */
	protected static final String SPECIALIZED_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpecializedType() <em>Specialized Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getSpecializedType()
	 * @generated
	 * @ordered
	 */
	protected String specializedType = SPECIALIZED_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ElementTemplateImpl() {
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
		return PropertylifecyclePackage.Literals.ELEMENT_TEMPLATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getBaseType() {
		return baseType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setBaseType(String newBaseType) {
		String oldBaseType = baseType;
		baseType = newBaseType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PropertylifecyclePackage.ELEMENT_TEMPLATE__BASE_TYPE, oldBaseType, baseType));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getSpecializedType() {
		return specializedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setSpecializedType(String newSpecializedType) {
		String oldSpecializedType = specializedType;
		specializedType = newSpecializedType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PropertylifecyclePackage.ELEMENT_TEMPLATE__SPECIALIZED_TYPE, oldSpecializedType, specializedType));
		}
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
		case PropertylifecyclePackage.ELEMENT_TEMPLATE__BASE_TYPE:
			return getBaseType();
		case PropertylifecyclePackage.ELEMENT_TEMPLATE__SPECIALIZED_TYPE:
			return getSpecializedType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case PropertylifecyclePackage.ELEMENT_TEMPLATE__BASE_TYPE:
			setBaseType((String) newValue);
			return;
		case PropertylifecyclePackage.ELEMENT_TEMPLATE__SPECIALIZED_TYPE:
			setSpecializedType((String) newValue);
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
		case PropertylifecyclePackage.ELEMENT_TEMPLATE__BASE_TYPE:
			setBaseType(BASE_TYPE_EDEFAULT);
			return;
		case PropertylifecyclePackage.ELEMENT_TEMPLATE__SPECIALIZED_TYPE:
			setSpecializedType(SPECIALIZED_TYPE_EDEFAULT);
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
		case PropertylifecyclePackage.ELEMENT_TEMPLATE__BASE_TYPE:
			return BASE_TYPE_EDEFAULT == null ? baseType != null : !BASE_TYPE_EDEFAULT.equals(baseType);
		case PropertylifecyclePackage.ELEMENT_TEMPLATE__SPECIALIZED_TYPE:
			return SPECIALIZED_TYPE_EDEFAULT == null ? specializedType != null : !SPECIALIZED_TYPE_EDEFAULT.equals(specializedType);
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
		result.append(" (baseType: "); //$NON-NLS-1$
		result.append(baseType);
		result.append(", specializedType: "); //$NON-NLS-1$
		result.append(specializedType);
		result.append(')');
		return result.toString();
	}

} // ElementTemplateImpl
