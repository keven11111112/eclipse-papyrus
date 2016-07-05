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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.propertylifecycle.ElementContainer;
import org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.impl.ElementContainerImpl#getContainersContainer <em>Containers Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ElementContainerImpl extends ElementTemplateImpl implements ElementContainer {
	/**
	 * The cached value of the '{@link #getContainersContainer() <em>Containers Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getContainersContainer()
	 * @generated
	 * @ordered
	 */
	protected ElementContainer containersContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ElementContainerImpl() {
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
		return PropertylifecyclePackage.Literals.ELEMENT_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ElementContainer getContainersContainer() {
		return containersContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetContainersContainer(ElementContainer newContainersContainer, NotificationChain msgs) {
		ElementContainer oldContainersContainer = containersContainer;
		containersContainer = newContainersContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PropertylifecyclePackage.ELEMENT_CONTAINER__CONTAINERS_CONTAINER, oldContainersContainer, newContainersContainer);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setContainersContainer(ElementContainer newContainersContainer) {
		if (newContainersContainer != containersContainer) {
			NotificationChain msgs = null;
			if (containersContainer != null) {
				msgs = ((InternalEObject) containersContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PropertylifecyclePackage.ELEMENT_CONTAINER__CONTAINERS_CONTAINER, null, msgs);
			}
			if (newContainersContainer != null) {
				msgs = ((InternalEObject) newContainersContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PropertylifecyclePackage.ELEMENT_CONTAINER__CONTAINERS_CONTAINER, null, msgs);
			}
			msgs = basicSetContainersContainer(newContainersContainer, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PropertylifecyclePackage.ELEMENT_CONTAINER__CONTAINERS_CONTAINER, newContainersContainer, newContainersContainer));
		}
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
		case PropertylifecyclePackage.ELEMENT_CONTAINER__CONTAINERS_CONTAINER:
			return basicSetContainersContainer(null, msgs);
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
		case PropertylifecyclePackage.ELEMENT_CONTAINER__CONTAINERS_CONTAINER:
			return getContainersContainer();
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
		case PropertylifecyclePackage.ELEMENT_CONTAINER__CONTAINERS_CONTAINER:
			setContainersContainer((ElementContainer) newValue);
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
		case PropertylifecyclePackage.ELEMENT_CONTAINER__CONTAINERS_CONTAINER:
			setContainersContainer((ElementContainer) null);
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
		case PropertylifecyclePackage.ELEMENT_CONTAINER__CONTAINERS_CONTAINER:
			return containersContainer != null;
		}
		return super.eIsSet(featureID);
	}

} // ElementContainerImpl
