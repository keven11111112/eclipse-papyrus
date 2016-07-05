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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.propertylifecycle.ElementContainer;
import org.eclipse.papyrus.propertylifecycle.ElementProperty;
import org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage;
import org.eclipse.papyrus.propertylifecycle.StrategyElement;
import org.eclipse.papyrus.propertylifecycle.StrategyTemplate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Strategy Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.impl.StrategyElementImpl#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.impl.StrategyElementImpl#getDecription <em>Decription</em>}</li>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.impl.StrategyElementImpl#getId <em>Id</em>}</li>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.impl.StrategyElementImpl#getElementContainers <em>Element Containers</em>}</li>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.impl.StrategyElementImpl#getElementProperties <em>Element Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StrategyElementImpl extends ElementTemplateImpl implements StrategyElement {
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
	 * The cached value of the '{@link #getElementContainers() <em>Element Containers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getElementContainers()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementContainer> elementContainers;

	/**
	 * The cached value of the '{@link #getElementProperties() <em>Element Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getElementProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementProperty> elementProperties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected StrategyElementImpl() {
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
		return PropertylifecyclePackage.Literals.STRATEGY_ELEMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PropertylifecyclePackage.STRATEGY_ELEMENT__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PropertylifecyclePackage.STRATEGY_ELEMENT__DECRIPTION, oldDecription, decription));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PropertylifecyclePackage.STRATEGY_ELEMENT__ID, oldId, id));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<ElementContainer> getElementContainers() {
		if (elementContainers == null) {
			elementContainers = new EObjectContainmentEList<ElementContainer>(ElementContainer.class, this, PropertylifecyclePackage.STRATEGY_ELEMENT__ELEMENT_CONTAINERS);
		}
		return elementContainers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<ElementProperty> getElementProperties() {
		if (elementProperties == null) {
			elementProperties = new EObjectContainmentEList<ElementProperty>(ElementProperty.class, this, PropertylifecyclePackage.STRATEGY_ELEMENT__ELEMENT_PROPERTIES);
		}
		return elementProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case PropertylifecyclePackage.STRATEGY_ELEMENT__ELEMENT_CONTAINERS:
			return ((InternalEList<?>) getElementContainers()).basicRemove(otherEnd, msgs);
		case PropertylifecyclePackage.STRATEGY_ELEMENT__ELEMENT_PROPERTIES:
			return ((InternalEList<?>) getElementProperties()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
		case PropertylifecyclePackage.STRATEGY_ELEMENT__NAME:
			return getName();
		case PropertylifecyclePackage.STRATEGY_ELEMENT__DECRIPTION:
			return getDecription();
		case PropertylifecyclePackage.STRATEGY_ELEMENT__ID:
			return getId();
		case PropertylifecyclePackage.STRATEGY_ELEMENT__ELEMENT_CONTAINERS:
			return getElementContainers();
		case PropertylifecyclePackage.STRATEGY_ELEMENT__ELEMENT_PROPERTIES:
			return getElementProperties();
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
		case PropertylifecyclePackage.STRATEGY_ELEMENT__NAME:
			setName((String) newValue);
			return;
		case PropertylifecyclePackage.STRATEGY_ELEMENT__DECRIPTION:
			setDecription((String) newValue);
			return;
		case PropertylifecyclePackage.STRATEGY_ELEMENT__ID:
			setId((String) newValue);
			return;
		case PropertylifecyclePackage.STRATEGY_ELEMENT__ELEMENT_CONTAINERS:
			getElementContainers().clear();
			getElementContainers().addAll((Collection<? extends ElementContainer>) newValue);
			return;
		case PropertylifecyclePackage.STRATEGY_ELEMENT__ELEMENT_PROPERTIES:
			getElementProperties().clear();
			getElementProperties().addAll((Collection<? extends ElementProperty>) newValue);
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
		case PropertylifecyclePackage.STRATEGY_ELEMENT__NAME:
			setName(NAME_EDEFAULT);
			return;
		case PropertylifecyclePackage.STRATEGY_ELEMENT__DECRIPTION:
			setDecription(DECRIPTION_EDEFAULT);
			return;
		case PropertylifecyclePackage.STRATEGY_ELEMENT__ID:
			setId(ID_EDEFAULT);
			return;
		case PropertylifecyclePackage.STRATEGY_ELEMENT__ELEMENT_CONTAINERS:
			getElementContainers().clear();
			return;
		case PropertylifecyclePackage.STRATEGY_ELEMENT__ELEMENT_PROPERTIES:
			getElementProperties().clear();
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
		case PropertylifecyclePackage.STRATEGY_ELEMENT__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case PropertylifecyclePackage.STRATEGY_ELEMENT__DECRIPTION:
			return DECRIPTION_EDEFAULT == null ? decription != null : !DECRIPTION_EDEFAULT.equals(decription);
		case PropertylifecyclePackage.STRATEGY_ELEMENT__ID:
			return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		case PropertylifecyclePackage.STRATEGY_ELEMENT__ELEMENT_CONTAINERS:
			return elementContainers != null && !elementContainers.isEmpty();
		case PropertylifecyclePackage.STRATEGY_ELEMENT__ELEMENT_PROPERTIES:
			return elementProperties != null && !elementProperties.isEmpty();
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == StrategyTemplate.class) {
			switch (derivedFeatureID) {
			case PropertylifecyclePackage.STRATEGY_ELEMENT__NAME:
				return PropertylifecyclePackage.STRATEGY_TEMPLATE__NAME;
			case PropertylifecyclePackage.STRATEGY_ELEMENT__DECRIPTION:
				return PropertylifecyclePackage.STRATEGY_TEMPLATE__DECRIPTION;
			case PropertylifecyclePackage.STRATEGY_ELEMENT__ID:
				return PropertylifecyclePackage.STRATEGY_TEMPLATE__ID;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == StrategyTemplate.class) {
			switch (baseFeatureID) {
			case PropertylifecyclePackage.STRATEGY_TEMPLATE__NAME:
				return PropertylifecyclePackage.STRATEGY_ELEMENT__NAME;
			case PropertylifecyclePackage.STRATEGY_TEMPLATE__DECRIPTION:
				return PropertylifecyclePackage.STRATEGY_ELEMENT__DECRIPTION;
			case PropertylifecyclePackage.STRATEGY_TEMPLATE__ID:
				return PropertylifecyclePackage.STRATEGY_ELEMENT__ID;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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

} // StrategyElementImpl
