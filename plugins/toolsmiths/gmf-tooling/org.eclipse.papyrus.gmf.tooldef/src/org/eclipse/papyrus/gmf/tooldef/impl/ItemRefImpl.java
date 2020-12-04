/*******************************************************************************
 * Copyright (c) 2006, 2020 Borland Software Corporation, CEA LIST, ARTAL
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 * 
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *     Borland - initial API and implementation
 *     Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.gmf.tooldef.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.gmf.tooldef.GMFToolPackage;
import org.eclipse.papyrus.gmf.tooldef.ItemBase;
import org.eclipse.papyrus.gmf.tooldef.ItemRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Item Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.tooldef.impl.ItemRefImpl#getItem <em>Item</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ItemRefImpl extends EObjectImpl implements ItemRef {

	/**
	 * The cached value of the '{@link #getItem() <em>Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItem()
	 * @generated
	 * @ordered
	 */
	protected ItemBase item;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ItemRefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GMFToolPackage.eINSTANCE.getItemRef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemBase getItem() {
		if (item != null && item.eIsProxy()) {
			InternalEObject oldItem = (InternalEObject) item;
			item = (ItemBase) eResolveProxy(oldItem);
			if (item != oldItem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFToolPackage.ITEM_REF__ITEM, oldItem, item));
			}
		}
		return item;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemBase basicGetItem() {
		return item;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItem(ItemBase newItem) {
		ItemBase oldItem = item;
		item = newItem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFToolPackage.ITEM_REF__ITEM, oldItem, item));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case GMFToolPackage.ITEM_REF__ITEM:
			if (resolve)
				return getItem();
			return basicGetItem();
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
		case GMFToolPackage.ITEM_REF__ITEM:
			setItem((ItemBase) newValue);
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
		case GMFToolPackage.ITEM_REF__ITEM:
			setItem((ItemBase) null);
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
		case GMFToolPackage.ITEM_REF__ITEM:
			return item != null;
		}
		return super.eIsSet(featureID);
	}

} //ItemRefImpl
