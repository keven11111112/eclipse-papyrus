/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Fadwa TMAR (CEA LIST) fadwa.tmar@cea.fr - Initial API and implementation
 *****************************************************************************/
package SoaML.impl;

import SoaML.MotivationRealization;
import SoaML.SoaMLPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.uml2.uml.Realization;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Motivation Realization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link SoaML.impl.MotivationRealizationImpl#getBase_Realization <em>Base Realization</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MotivationRealizationImpl extends MinimalEObjectImpl.Container implements MotivationRealization {
	/**
	 * The cached value of the '{@link #getBase_Realization() <em>Base Realization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Realization()
	 * @generated
	 * @ordered
	 */
	protected Realization base_Realization;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MotivationRealizationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SoaMLPackage.Literals.MOTIVATION_REALIZATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Realization getBase_Realization() {
		if (base_Realization != null && base_Realization.eIsProxy()) {
			InternalEObject oldBase_Realization = (InternalEObject)base_Realization;
			base_Realization = (Realization)eResolveProxy(oldBase_Realization);
			if (base_Realization != oldBase_Realization) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SoaMLPackage.MOTIVATION_REALIZATION__BASE_REALIZATION, oldBase_Realization, base_Realization));
			}
		}
		return base_Realization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Realization basicGetBase_Realization() {
		return base_Realization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Realization(Realization newBase_Realization) {
		Realization oldBase_Realization = base_Realization;
		base_Realization = newBase_Realization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SoaMLPackage.MOTIVATION_REALIZATION__BASE_REALIZATION, oldBase_Realization, base_Realization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SoaMLPackage.MOTIVATION_REALIZATION__BASE_REALIZATION:
				if (resolve) return getBase_Realization();
				return basicGetBase_Realization();
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
			case SoaMLPackage.MOTIVATION_REALIZATION__BASE_REALIZATION:
				setBase_Realization((Realization)newValue);
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
			case SoaMLPackage.MOTIVATION_REALIZATION__BASE_REALIZATION:
				setBase_Realization((Realization)null);
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
			case SoaMLPackage.MOTIVATION_REALIZATION__BASE_REALIZATION:
				return base_Realization != null;
		}
		return super.eIsSet(featureID);
	}

} //MotivationRealizationImpl
