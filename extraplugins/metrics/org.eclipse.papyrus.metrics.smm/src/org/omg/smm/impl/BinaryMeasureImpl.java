/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   CEA LIST - Initial API and implementation
 * 
 */
package org.omg.smm.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.omg.smm.BinaryFunctor;
import org.omg.smm.BinaryMeasure;
import org.omg.smm.Operation;
import org.omg.smm.SmmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Measure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.impl.BinaryMeasureImpl#getFunctor <em>Functor</em>}</li>
 *   <li>{@link org.omg.smm.impl.BinaryMeasureImpl#getCustomFunctor <em>Custom Functor</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BinaryMeasureImpl extends DimensionalMeasureImpl implements BinaryMeasure {
	/**
	 * The default value of the '{@link #getFunctor() <em>Functor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctor()
	 * @generated
	 * @ordered
	 */
	protected static final BinaryFunctor FUNCTOR_EDEFAULT = BinaryFunctor.PLUS;

	/**
	 * The cached value of the '{@link #getFunctor() <em>Functor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctor()
	 * @generated
	 * @ordered
	 */
	protected BinaryFunctor functor = FUNCTOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCustomFunctor() <em>Custom Functor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomFunctor()
	 * @generated
	 * @ordered
	 */
	protected Operation customFunctor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryMeasureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmmPackage.Literals.BINARY_MEASURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryFunctor getFunctor() {
		return functor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctor(BinaryFunctor newFunctor) {
		BinaryFunctor oldFunctor = functor;
		functor = newFunctor == null ? FUNCTOR_EDEFAULT : newFunctor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.BINARY_MEASURE__FUNCTOR, oldFunctor, functor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getCustomFunctor() {
		if (customFunctor != null && customFunctor.eIsProxy()) {
			InternalEObject oldCustomFunctor = (InternalEObject)customFunctor;
			customFunctor = (Operation)eResolveProxy(oldCustomFunctor);
			if (customFunctor != oldCustomFunctor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SmmPackage.BINARY_MEASURE__CUSTOM_FUNCTOR, oldCustomFunctor, customFunctor));
			}
		}
		return customFunctor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetCustomFunctor() {
		return customFunctor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomFunctor(Operation newCustomFunctor) {
		Operation oldCustomFunctor = customFunctor;
		customFunctor = newCustomFunctor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.BINARY_MEASURE__CUSTOM_FUNCTOR, oldCustomFunctor, customFunctor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SmmPackage.BINARY_MEASURE__FUNCTOR:
				return getFunctor();
			case SmmPackage.BINARY_MEASURE__CUSTOM_FUNCTOR:
				if (resolve) return getCustomFunctor();
				return basicGetCustomFunctor();
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
			case SmmPackage.BINARY_MEASURE__FUNCTOR:
				setFunctor((BinaryFunctor)newValue);
				return;
			case SmmPackage.BINARY_MEASURE__CUSTOM_FUNCTOR:
				setCustomFunctor((Operation)newValue);
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
			case SmmPackage.BINARY_MEASURE__FUNCTOR:
				setFunctor(FUNCTOR_EDEFAULT);
				return;
			case SmmPackage.BINARY_MEASURE__CUSTOM_FUNCTOR:
				setCustomFunctor((Operation)null);
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
			case SmmPackage.BINARY_MEASURE__FUNCTOR:
				return functor != FUNCTOR_EDEFAULT;
			case SmmPackage.BINARY_MEASURE__CUSTOM_FUNCTOR:
				return customFunctor != null;
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
		result.append(" (functor: ");
		result.append(functor);
		result.append(')');
		return result.toString();
	}

} //BinaryMeasureImpl
