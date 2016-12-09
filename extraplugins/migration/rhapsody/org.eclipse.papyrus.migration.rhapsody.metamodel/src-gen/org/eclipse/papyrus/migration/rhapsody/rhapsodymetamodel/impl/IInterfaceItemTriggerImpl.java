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

import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.IInterfaceItemTrigger;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.M_pFormalMessageType;
import org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.UMLRhapsodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IInterface Item Trigger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IInterfaceItemTriggerImpl#getItsInterfaceItem <em>Its Interface Item</em>}</li>
 *   <li>{@link org.eclipse.papyrus.migration.rhapsody.rhapsodymetamodel.impl.IInterfaceItemTriggerImpl#getInheritsFromHandle <em>Inherits From Handle</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IInterfaceItemTriggerImpl extends ItsTriggerTypeImpl implements IInterfaceItemTrigger {
	/**
	 * The cached value of the '{@link #getItsInterfaceItem() <em>Its Interface Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItsInterfaceItem()
	 * @generated
	 * @ordered
	 */
	protected M_pFormalMessageType itsInterfaceItem;

	/**
	 * The cached value of the '{@link #getInheritsFromHandle() <em>Inherits From Handle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritsFromHandle()
	 * @generated
	 * @ordered
	 */
	protected IInterfaceItemTrigger inheritsFromHandle;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IInterfaceItemTriggerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLRhapsodyPackage.eINSTANCE.getIInterfaceItemTrigger();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M_pFormalMessageType getItsInterfaceItem() {
		if (itsInterfaceItem != null && itsInterfaceItem.eIsProxy()) {
			InternalEObject oldItsInterfaceItem = (InternalEObject)itsInterfaceItem;
			itsInterfaceItem = (M_pFormalMessageType)eResolveProxy(oldItsInterfaceItem);
			if (itsInterfaceItem != oldItsInterfaceItem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IINTERFACE_ITEM_TRIGGER__ITS_INTERFACE_ITEM, oldItsInterfaceItem, itsInterfaceItem));
			}
		}
		return itsInterfaceItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public M_pFormalMessageType basicGetItsInterfaceItem() {
		return itsInterfaceItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItsInterfaceItem(M_pFormalMessageType newItsInterfaceItem) {
		M_pFormalMessageType oldItsInterfaceItem = itsInterfaceItem;
		itsInterfaceItem = newItsInterfaceItem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IINTERFACE_ITEM_TRIGGER__ITS_INTERFACE_ITEM, oldItsInterfaceItem, itsInterfaceItem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IInterfaceItemTrigger getInheritsFromHandle() {
		if (inheritsFromHandle != null && inheritsFromHandle.eIsProxy()) {
			InternalEObject oldInheritsFromHandle = (InternalEObject)inheritsFromHandle;
			inheritsFromHandle = (IInterfaceItemTrigger)eResolveProxy(oldInheritsFromHandle);
			if (inheritsFromHandle != oldInheritsFromHandle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLRhapsodyPackage.IINTERFACE_ITEM_TRIGGER__INHERITS_FROM_HANDLE, oldInheritsFromHandle, inheritsFromHandle));
			}
		}
		return inheritsFromHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IInterfaceItemTrigger basicGetInheritsFromHandle() {
		return inheritsFromHandle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInheritsFromHandle(IInterfaceItemTrigger newInheritsFromHandle) {
		IInterfaceItemTrigger oldInheritsFromHandle = inheritsFromHandle;
		inheritsFromHandle = newInheritsFromHandle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLRhapsodyPackage.IINTERFACE_ITEM_TRIGGER__INHERITS_FROM_HANDLE, oldInheritsFromHandle, inheritsFromHandle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLRhapsodyPackage.IINTERFACE_ITEM_TRIGGER__ITS_INTERFACE_ITEM:
				if (resolve) return getItsInterfaceItem();
				return basicGetItsInterfaceItem();
			case UMLRhapsodyPackage.IINTERFACE_ITEM_TRIGGER__INHERITS_FROM_HANDLE:
				if (resolve) return getInheritsFromHandle();
				return basicGetInheritsFromHandle();
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
			case UMLRhapsodyPackage.IINTERFACE_ITEM_TRIGGER__ITS_INTERFACE_ITEM:
				setItsInterfaceItem((M_pFormalMessageType)newValue);
				return;
			case UMLRhapsodyPackage.IINTERFACE_ITEM_TRIGGER__INHERITS_FROM_HANDLE:
				setInheritsFromHandle((IInterfaceItemTrigger)newValue);
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
			case UMLRhapsodyPackage.IINTERFACE_ITEM_TRIGGER__ITS_INTERFACE_ITEM:
				setItsInterfaceItem((M_pFormalMessageType)null);
				return;
			case UMLRhapsodyPackage.IINTERFACE_ITEM_TRIGGER__INHERITS_FROM_HANDLE:
				setInheritsFromHandle((IInterfaceItemTrigger)null);
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
			case UMLRhapsodyPackage.IINTERFACE_ITEM_TRIGGER__ITS_INTERFACE_ITEM:
				return itsInterfaceItem != null;
			case UMLRhapsodyPackage.IINTERFACE_ITEM_TRIGGER__INHERITS_FROM_HANDLE:
				return inheritsFromHandle != null;
		}
		return super.eIsSet(featureID);
	}

} //IInterfaceItemTriggerImpl
