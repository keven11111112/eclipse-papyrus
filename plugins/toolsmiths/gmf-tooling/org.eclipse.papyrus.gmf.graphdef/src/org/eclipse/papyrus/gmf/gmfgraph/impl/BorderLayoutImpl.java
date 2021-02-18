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
package org.eclipse.papyrus.gmf.gmfgraph.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.gmf.gmfgraph.BorderLayout;
import org.eclipse.papyrus.gmf.gmfgraph.Dimension;
import org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Border Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.impl.BorderLayoutImpl#getSpacing <em>Spacing</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BorderLayoutImpl extends EObjectImpl implements BorderLayout {
	/**
	 * The cached value of the '{@link #getSpacing() <em>Spacing</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpacing()
	 * @generated
	 * @ordered
	 */
	protected Dimension spacing;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BorderLayoutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GMFGraphPackage.eINSTANCE.getBorderLayout();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dimension getSpacing() {
		return spacing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpacing(Dimension newSpacing, NotificationChain msgs) {
		Dimension oldSpacing = spacing;
		spacing = newSpacing;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GMFGraphPackage.BORDER_LAYOUT__SPACING, oldSpacing, newSpacing);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpacing(Dimension newSpacing) {
		if (newSpacing != spacing) {
			NotificationChain msgs = null;
			if (spacing != null)
				msgs = ((InternalEObject)spacing).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GMFGraphPackage.BORDER_LAYOUT__SPACING, null, msgs);
			if (newSpacing != null)
				msgs = ((InternalEObject)newSpacing).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GMFGraphPackage.BORDER_LAYOUT__SPACING, null, msgs);
			msgs = basicSetSpacing(newSpacing, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGraphPackage.BORDER_LAYOUT__SPACING, newSpacing, newSpacing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GMFGraphPackage.BORDER_LAYOUT__SPACING:
				return basicSetSpacing(null, msgs);
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
			case GMFGraphPackage.BORDER_LAYOUT__SPACING:
				return getSpacing();
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
			case GMFGraphPackage.BORDER_LAYOUT__SPACING:
				setSpacing((Dimension)newValue);
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
			case GMFGraphPackage.BORDER_LAYOUT__SPACING:
				setSpacing((Dimension)null);
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
			case GMFGraphPackage.BORDER_LAYOUT__SPACING:
				return spacing != null;
		}
		return super.eIsSet(featureID);
	}

} //BorderLayoutImpl
