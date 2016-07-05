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
import org.eclipse.papyrus.propertylifecycle.BasicTrigger;
import org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Trigger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.impl.BasicTriggerImpl#isOnCreate <em>On Create</em>}</li>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.impl.BasicTriggerImpl#isOnDelete <em>On Delete</em>}</li>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.impl.BasicTriggerImpl#isOnOpen <em>On Open</em>}</li>
 * <li>{@link org.eclipse.papyrus.propertylifecycle.impl.BasicTriggerImpl#isOnMove <em>On Move</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BasicTriggerImpl extends AbstractTriggerImpl implements BasicTrigger {
	/**
	 * The default value of the '{@link #isOnCreate() <em>On Create</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isOnCreate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ON_CREATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOnCreate() <em>On Create</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isOnCreate()
	 * @generated
	 * @ordered
	 */
	protected boolean onCreate = ON_CREATE_EDEFAULT;

	/**
	 * The default value of the '{@link #isOnDelete() <em>On Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isOnDelete()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ON_DELETE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOnDelete() <em>On Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isOnDelete()
	 * @generated
	 * @ordered
	 */
	protected boolean onDelete = ON_DELETE_EDEFAULT;

	/**
	 * The default value of the '{@link #isOnOpen() <em>On Open</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isOnOpen()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ON_OPEN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOnOpen() <em>On Open</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isOnOpen()
	 * @generated
	 * @ordered
	 */
	protected boolean onOpen = ON_OPEN_EDEFAULT;

	/**
	 * The default value of the '{@link #isOnMove() <em>On Move</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isOnMove()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ON_MOVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOnMove() <em>On Move</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isOnMove()
	 * @generated
	 * @ordered
	 */
	protected boolean onMove = ON_MOVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected BasicTriggerImpl() {
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
		return PropertylifecyclePackage.Literals.BASIC_TRIGGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean isOnCreate() {
		return onCreate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setOnCreate(boolean newOnCreate) {
		boolean oldOnCreate = onCreate;
		onCreate = newOnCreate;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PropertylifecyclePackage.BASIC_TRIGGER__ON_CREATE, oldOnCreate, onCreate));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean isOnDelete() {
		return onDelete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setOnDelete(boolean newOnDelete) {
		boolean oldOnDelete = onDelete;
		onDelete = newOnDelete;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PropertylifecyclePackage.BASIC_TRIGGER__ON_DELETE, oldOnDelete, onDelete));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean isOnOpen() {
		return onOpen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setOnOpen(boolean newOnOpen) {
		boolean oldOnOpen = onOpen;
		onOpen = newOnOpen;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PropertylifecyclePackage.BASIC_TRIGGER__ON_OPEN, oldOnOpen, onOpen));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean isOnMove() {
		return onMove;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setOnMove(boolean newOnMove) {
		boolean oldOnMove = onMove;
		onMove = newOnMove;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PropertylifecyclePackage.BASIC_TRIGGER__ON_MOVE, oldOnMove, onMove));
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
		case PropertylifecyclePackage.BASIC_TRIGGER__ON_CREATE:
			return isOnCreate();
		case PropertylifecyclePackage.BASIC_TRIGGER__ON_DELETE:
			return isOnDelete();
		case PropertylifecyclePackage.BASIC_TRIGGER__ON_OPEN:
			return isOnOpen();
		case PropertylifecyclePackage.BASIC_TRIGGER__ON_MOVE:
			return isOnMove();
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
		case PropertylifecyclePackage.BASIC_TRIGGER__ON_CREATE:
			setOnCreate((Boolean) newValue);
			return;
		case PropertylifecyclePackage.BASIC_TRIGGER__ON_DELETE:
			setOnDelete((Boolean) newValue);
			return;
		case PropertylifecyclePackage.BASIC_TRIGGER__ON_OPEN:
			setOnOpen((Boolean) newValue);
			return;
		case PropertylifecyclePackage.BASIC_TRIGGER__ON_MOVE:
			setOnMove((Boolean) newValue);
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
		case PropertylifecyclePackage.BASIC_TRIGGER__ON_CREATE:
			setOnCreate(ON_CREATE_EDEFAULT);
			return;
		case PropertylifecyclePackage.BASIC_TRIGGER__ON_DELETE:
			setOnDelete(ON_DELETE_EDEFAULT);
			return;
		case PropertylifecyclePackage.BASIC_TRIGGER__ON_OPEN:
			setOnOpen(ON_OPEN_EDEFAULT);
			return;
		case PropertylifecyclePackage.BASIC_TRIGGER__ON_MOVE:
			setOnMove(ON_MOVE_EDEFAULT);
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
		case PropertylifecyclePackage.BASIC_TRIGGER__ON_CREATE:
			return onCreate != ON_CREATE_EDEFAULT;
		case PropertylifecyclePackage.BASIC_TRIGGER__ON_DELETE:
			return onDelete != ON_DELETE_EDEFAULT;
		case PropertylifecyclePackage.BASIC_TRIGGER__ON_OPEN:
			return onOpen != ON_OPEN_EDEFAULT;
		case PropertylifecyclePackage.BASIC_TRIGGER__ON_MOVE:
			return onMove != ON_MOVE_EDEFAULT;
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
		result.append(" (onCreate: "); //$NON-NLS-1$
		result.append(onCreate);
		result.append(", onDelete: "); //$NON-NLS-1$
		result.append(onDelete);
		result.append(", onOpen: "); //$NON-NLS-1$
		result.append(onOpen);
		result.append(", onMove: "); //$NON-NLS-1$
		result.append(onMove);
		result.append(')');
		return result.toString();
	}

} // BasicTriggerImpl
