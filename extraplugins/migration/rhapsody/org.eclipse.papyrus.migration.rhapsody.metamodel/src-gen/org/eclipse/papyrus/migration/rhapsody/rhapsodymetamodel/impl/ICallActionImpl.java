/**
 *   Copyright (c) 2016 CEA LIST and others.
 *   
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *     CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.ICallAction;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IConstructor;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ICall Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICallActionImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICallActionImpl#getModifiedTimeWeak <em>Modified Time Weak</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICallActionImpl#getInterfaceItem <em>Interface Item</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICallActionImpl#getArgumentNames <em>Argument Names</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.ICallActionImpl#getArgumentValues <em>Argument Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ICallActionImpl extends MinimalEObjectImpl.Container implements ICallAction {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getModifiedTimeWeak() <em>Modified Time Weak</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiedTimeWeak()
	 * @generated
	 * @ordered
	 */
	protected static final String MODIFIED_TIME_WEAK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModifiedTimeWeak() <em>Modified Time Weak</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifiedTimeWeak()
	 * @generated
	 * @ordered
	 */
	protected String modifiedTimeWeak = MODIFIED_TIME_WEAK_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInterfaceItem() <em>Interface Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceItem()
	 * @generated
	 * @ordered
	 */
	protected IConstructor interfaceItem;

	/**
	 * The default value of the '{@link #getArgumentNames() <em>Argument Names</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgumentNames()
	 * @generated
	 * @ordered
	 */
	protected static final String ARGUMENT_NAMES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getArgumentNames() <em>Argument Names</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgumentNames()
	 * @generated
	 * @ordered
	 */
	protected String argumentNames = ARGUMENT_NAMES_EDEFAULT;

	/**
	 * The default value of the '{@link #getArgumentValues() <em>Argument Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgumentValues()
	 * @generated
	 * @ordered
	 */
	protected static final String ARGUMENT_VALUES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getArgumentValues() <em>Argument Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgumentValues()
	 * @generated
	 * @ordered
	 */
	protected String argumentValues = ARGUMENT_VALUES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ICallActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getICallAction();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICALL_ACTION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModifiedTimeWeak() {
		return modifiedTimeWeak;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModifiedTimeWeak(String newModifiedTimeWeak) {
		String oldModifiedTimeWeak = modifiedTimeWeak;
		modifiedTimeWeak = newModifiedTimeWeak;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICALL_ACTION__MODIFIED_TIME_WEAK, oldModifiedTimeWeak, modifiedTimeWeak));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IConstructor getInterfaceItem() {
		if (interfaceItem != null && interfaceItem.eIsProxy()) {
			InternalEObject oldInterfaceItem = (InternalEObject)interfaceItem;
			interfaceItem = (IConstructor)eResolveProxy(oldInterfaceItem);
			if (interfaceItem != oldInterfaceItem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.ICALL_ACTION__INTERFACE_ITEM, oldInterfaceItem, interfaceItem));
			}
		}
		return interfaceItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IConstructor basicGetInterfaceItem() {
		return interfaceItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfaceItem(IConstructor newInterfaceItem) {
		IConstructor oldInterfaceItem = interfaceItem;
		interfaceItem = newInterfaceItem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICALL_ACTION__INTERFACE_ITEM, oldInterfaceItem, interfaceItem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getArgumentNames() {
		return argumentNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArgumentNames(String newArgumentNames) {
		String oldArgumentNames = argumentNames;
		argumentNames = newArgumentNames;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICALL_ACTION__ARGUMENT_NAMES, oldArgumentNames, argumentNames));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getArgumentValues() {
		return argumentValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArgumentValues(String newArgumentValues) {
		String oldArgumentValues = argumentValues;
		argumentValues = newArgumentValues;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.ICALL_ACTION__ARGUMENT_VALUES, oldArgumentValues, argumentValues));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLRhapsodyPackage.ICALL_ACTION__ID:
				return getId();
			case UMLRhapsodyPackage.ICALL_ACTION__MODIFIED_TIME_WEAK:
				return getModifiedTimeWeak();
			case UMLRhapsodyPackage.ICALL_ACTION__INTERFACE_ITEM:
				if (resolve) return getInterfaceItem();
				return basicGetInterfaceItem();
			case UMLRhapsodyPackage.ICALL_ACTION__ARGUMENT_NAMES:
				return getArgumentNames();
			case UMLRhapsodyPackage.ICALL_ACTION__ARGUMENT_VALUES:
				return getArgumentValues();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UMLRhapsodyPackage.ICALL_ACTION__ID:
				setId((String)newValue);
				return;
			case UMLRhapsodyPackage.ICALL_ACTION__MODIFIED_TIME_WEAK:
				setModifiedTimeWeak((String)newValue);
				return;
			case UMLRhapsodyPackage.ICALL_ACTION__INTERFACE_ITEM:
				setInterfaceItem((IConstructor)newValue);
				return;
			case UMLRhapsodyPackage.ICALL_ACTION__ARGUMENT_NAMES:
				setArgumentNames((String)newValue);
				return;
			case UMLRhapsodyPackage.ICALL_ACTION__ARGUMENT_VALUES:
				setArgumentValues((String)newValue);
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
			case UMLRhapsodyPackage.ICALL_ACTION__ID:
				setId(ID_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICALL_ACTION__MODIFIED_TIME_WEAK:
				setModifiedTimeWeak(MODIFIED_TIME_WEAK_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICALL_ACTION__INTERFACE_ITEM:
				setInterfaceItem((IConstructor)null);
				return;
			case UMLRhapsodyPackage.ICALL_ACTION__ARGUMENT_NAMES:
				setArgumentNames(ARGUMENT_NAMES_EDEFAULT);
				return;
			case UMLRhapsodyPackage.ICALL_ACTION__ARGUMENT_VALUES:
				setArgumentValues(ARGUMENT_VALUES_EDEFAULT);
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
			case UMLRhapsodyPackage.ICALL_ACTION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UMLRhapsodyPackage.ICALL_ACTION__MODIFIED_TIME_WEAK:
				return MODIFIED_TIME_WEAK_EDEFAULT == null ? modifiedTimeWeak != null : !MODIFIED_TIME_WEAK_EDEFAULT.equals(modifiedTimeWeak);
			case UMLRhapsodyPackage.ICALL_ACTION__INTERFACE_ITEM:
				return interfaceItem != null;
			case UMLRhapsodyPackage.ICALL_ACTION__ARGUMENT_NAMES:
				return ARGUMENT_NAMES_EDEFAULT == null ? argumentNames != null : !ARGUMENT_NAMES_EDEFAULT.equals(argumentNames);
			case UMLRhapsodyPackage.ICALL_ACTION__ARGUMENT_VALUES:
				return ARGUMENT_VALUES_EDEFAULT == null ? argumentValues != null : !ARGUMENT_VALUES_EDEFAULT.equals(argumentValues);
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
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: "); //$NON-NLS-1$
		result.append(id);
		result.append(", modifiedTimeWeak: "); //$NON-NLS-1$
		result.append(modifiedTimeWeak);
		result.append(", argumentNames: "); //$NON-NLS-1$
		result.append(argumentNames);
		result.append(", argumentValues: "); //$NON-NLS-1$
		result.append(argumentValues);
		result.append(')');
		return result.toString();
	}

} //ICallActionImpl
