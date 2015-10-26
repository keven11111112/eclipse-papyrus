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

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.aof.core.IOne;

import org.eclipse.papyrus.aof.core.utils.ObserverTracker;

import org.eclipse.papyrus.aof.sync.IMapping;

import org.eclipse.papyrus.aof.sync.IMapping.Instance;

import org.eclipse.papyrus.aof.sync.emf.internal.syncmapping.operations.MappingInstanceOperations;

import org.eclipse.papyrus.aof.sync.emf.syncmapping.MappingInstance;
import org.eclipse.papyrus.aof.sync.emf.syncmapping.SyncMappingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.MappingInstanceImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.MappingInstanceImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.MappingInstanceImpl#getRight <em>Right</em>}</li>
 *   <li>{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.MappingInstanceImpl#getConsequents <em>Consequent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.aof.sync.emf.syncmapping.impl.MappingInstanceImpl#getTracker <em>Tracker</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingInstanceImpl<F, T> extends MinimalEObjectImpl.Container implements MappingInstance<F, T> {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected IMapping<F, T> type;

	/**
	 * The cached value of the '{@link #getLeft() <em>Left</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeft()
	 * @generated
	 * @ordered
	 */
	protected IOne<F> left;

	/**
	 * The cached value of the '{@link #getRight() <em>Right</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRight()
	 * @generated
	 * @ordered
	 */
	protected IOne<T> right;

	/**
	 * The cached value of the '{@link #getConsequents() <em>Consequent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsequents()
	 * @generated
	 * @ordered
	 */
	protected EList<Instance<?, ?>> consequents;

	/**
	 * The default value of the '{@link #getTracker() <em>Tracker</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTracker()
	 * @generated
	 * @ordered
	 */
	protected static final ObserverTracker TRACKER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTracker() <em>Tracker</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTracker()
	 * @generated
	 * @ordered
	 */
	protected ObserverTracker tracker = TRACKER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SyncMappingPackage.Literals.MAPPING_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IMapping<F, T> getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(IMapping<F, T> newType) {
		IMapping<F, T> oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, SyncMappingPackage.MAPPING_INSTANCE__TYPE, oldType, type));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IOne<F> getLeft() {
		return left;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLeft(IOne<F> newLeft) {
		IOne<F> oldLeft = left;
		left = newLeft;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, SyncMappingPackage.MAPPING_INSTANCE__LEFT, oldLeft, left));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IOne<T> getRight() {
		return right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRight(IOne<T> newRight) {
		IOne<T> oldRight = right;
		right = newRight;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, SyncMappingPackage.MAPPING_INSTANCE__RIGHT, oldRight, right));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Instance<?, ?>> getConsequents() {
		if (consequents == null) {
			consequents = new EObjectContainmentEList<Instance<?, ?>>(Instance.class, this, SyncMappingPackage.MAPPING_INSTANCE__CONSEQUENT);
		}
		return consequents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObserverTracker getTracker() {
		return tracker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTracker(ObserverTracker newTracker) {
		ObserverTracker oldTracker = tracker;
		tracker = newTracker;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, SyncMappingPackage.MAPPING_INSTANCE__TRACKER, oldTracker, tracker));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addConsequent(Instance<?, ?> consequent) {
		MappingInstanceOperations.addConsequent(this, consequent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void destroy() {
		MappingInstanceOperations.destroy(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Iterator<Instance<?, ?>> iterator() {
		return MappingInstanceOperations.iterator(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eBasicSetContainerGen(InternalEObject newContainer) {
		MappingInstanceOperations.eBasicSetContainer(this, newContainer);
	}

	@Override
	protected void eBasicSetContainer(InternalEObject newContainer) {
		try {
			eBasicSetContainerGen(newContainer);
		} finally {
			super.eBasicSetContainer(newContainer);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SyncMappingPackage.MAPPING_INSTANCE__CONSEQUENT:
			return ((InternalEList<?>) getConsequents()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SyncMappingPackage.MAPPING_INSTANCE__TYPE:
			return getType();
		case SyncMappingPackage.MAPPING_INSTANCE__LEFT:
			return getLeft();
		case SyncMappingPackage.MAPPING_INSTANCE__RIGHT:
			return getRight();
		case SyncMappingPackage.MAPPING_INSTANCE__CONSEQUENT:
			return getConsequents();
		case SyncMappingPackage.MAPPING_INSTANCE__TRACKER:
			return getTracker();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SyncMappingPackage.MAPPING_INSTANCE__TYPE:
			setType((IMapping<F, T>) newValue);
			return;
		case SyncMappingPackage.MAPPING_INSTANCE__LEFT:
			setLeft((IOne<F>) newValue);
			return;
		case SyncMappingPackage.MAPPING_INSTANCE__RIGHT:
			setRight((IOne<T>) newValue);
			return;
		case SyncMappingPackage.MAPPING_INSTANCE__CONSEQUENT:
			getConsequents().clear();
			getConsequents().addAll((Collection<? extends Instance<?, ?>>) newValue);
			return;
		case SyncMappingPackage.MAPPING_INSTANCE__TRACKER:
			setTracker((ObserverTracker) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case SyncMappingPackage.MAPPING_INSTANCE__TYPE:
			setType((IMapping<F, T>) null);
			return;
		case SyncMappingPackage.MAPPING_INSTANCE__LEFT:
			setLeft((IOne<F>) null);
			return;
		case SyncMappingPackage.MAPPING_INSTANCE__RIGHT:
			setRight((IOne<T>) null);
			return;
		case SyncMappingPackage.MAPPING_INSTANCE__CONSEQUENT:
			getConsequents().clear();
			return;
		case SyncMappingPackage.MAPPING_INSTANCE__TRACKER:
			setTracker(TRACKER_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case SyncMappingPackage.MAPPING_INSTANCE__TYPE:
			return type != null;
		case SyncMappingPackage.MAPPING_INSTANCE__LEFT:
			return left != null;
		case SyncMappingPackage.MAPPING_INSTANCE__RIGHT:
			return right != null;
		case SyncMappingPackage.MAPPING_INSTANCE__CONSEQUENT:
			return consequents != null && !consequents.isEmpty();
		case SyncMappingPackage.MAPPING_INSTANCE__TRACKER:
			return TRACKER_EDEFAULT == null ? tracker != null : !TRACKER_EDEFAULT.equals(tracker);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (type: "); //$NON-NLS-1$
		result.append(type);
		result.append(", left: "); //$NON-NLS-1$
		result.append(left);
		result.append(", right: "); //$NON-NLS-1$
		result.append(right);
		result.append(", tracker: "); //$NON-NLS-1$
		result.append(tracker);
		result.append(')');
		return result.toString();
	}

} //MappingInstanceImpl
