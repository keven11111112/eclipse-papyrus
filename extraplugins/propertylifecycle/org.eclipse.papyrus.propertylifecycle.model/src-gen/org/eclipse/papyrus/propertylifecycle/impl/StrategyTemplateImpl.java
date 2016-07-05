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
import org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage;
import org.eclipse.papyrus.propertylifecycle.StrategyTemplate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Strategy Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.impl.StrategyTemplateImpl#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.impl.StrategyTemplateImpl#getDecription <em>Decription</em>}</li>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.impl.StrategyTemplateImpl#getId <em>Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class StrategyTemplateImpl extends MinimalEObjectImpl.Container implements StrategyTemplate {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDecription() <em>Decription</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDecription()
	 * @generated
	 * @ordered
	 */
	protected static final String DECRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDecription() <em>Decription</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDecription()
	 * @generated
	 * @ordered
	 */
	protected String decription = DECRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected StrategyTemplateImpl() {
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
		return PropertylifecyclePackage.Literals.STRATEGY_TEMPLATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PropertylifecyclePackage.STRATEGY_TEMPLATE__NAME, oldName, name));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getDecription() {
		return decription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setDecription(String newDecription) {
		String oldDecription = decription;
		decription = newDecription;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PropertylifecyclePackage.STRATEGY_TEMPLATE__DECRIPTION, oldDecription, decription));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PropertylifecyclePackage.STRATEGY_TEMPLATE__ID, oldId, id));
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
		case PropertylifecyclePackage.STRATEGY_TEMPLATE__NAME:
			return getName();
		case PropertylifecyclePackage.STRATEGY_TEMPLATE__DECRIPTION:
			return getDecription();
		case PropertylifecyclePackage.STRATEGY_TEMPLATE__ID:
			return getId();
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
		case PropertylifecyclePackage.STRATEGY_TEMPLATE__NAME:
			setName((String) newValue);
			return;
		case PropertylifecyclePackage.STRATEGY_TEMPLATE__DECRIPTION:
			setDecription((String) newValue);
			return;
		case PropertylifecyclePackage.STRATEGY_TEMPLATE__ID:
			setId((String) newValue);
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
		case PropertylifecyclePackage.STRATEGY_TEMPLATE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case PropertylifecyclePackage.STRATEGY_TEMPLATE__DECRIPTION:
			setDecription(DECRIPTION_EDEFAULT);
			return;
		case PropertylifecyclePackage.STRATEGY_TEMPLATE__ID:
			setId(ID_EDEFAULT);
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
		case PropertylifecyclePackage.STRATEGY_TEMPLATE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case PropertylifecyclePackage.STRATEGY_TEMPLATE__DECRIPTION:
			return DECRIPTION_EDEFAULT == null ? decription != null : !DECRIPTION_EDEFAULT.equals(decription);
		case PropertylifecyclePackage.STRATEGY_TEMPLATE__ID:
			return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
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
		result.append(" (name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", decription: "); //$NON-NLS-1$
		result.append(decription);
		result.append(", id: "); //$NON-NLS-1$
		result.append(id);
		result.append(')');
		return result.toString();
	}

} // StrategyTemplateImpl
