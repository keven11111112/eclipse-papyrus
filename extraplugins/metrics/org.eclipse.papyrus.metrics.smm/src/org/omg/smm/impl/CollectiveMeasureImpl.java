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

import org.omg.smm.Accumulator;
import org.omg.smm.CollectiveMeasure;
import org.omg.smm.Operation;
import org.omg.smm.SmmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collective Measure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.impl.CollectiveMeasureImpl#getAccumulator <em>Accumulator</em>}</li>
 *   <li>{@link org.omg.smm.impl.CollectiveMeasureImpl#getCustomAccumulator <em>Custom Accumulator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectiveMeasureImpl extends DimensionalMeasureImpl implements CollectiveMeasure {
	/**
	 * The default value of the '{@link #getAccumulator() <em>Accumulator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccumulator()
	 * @generated
	 * @ordered
	 */
	protected static final Accumulator ACCUMULATOR_EDEFAULT = Accumulator.SUM;

	/**
	 * The cached value of the '{@link #getAccumulator() <em>Accumulator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccumulator()
	 * @generated
	 * @ordered
	 */
	protected Accumulator accumulator = ACCUMULATOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCustomAccumulator() <em>Custom Accumulator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomAccumulator()
	 * @generated
	 * @ordered
	 */
	protected Operation customAccumulator;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectiveMeasureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmmPackage.Literals.COLLECTIVE_MEASURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Accumulator getAccumulator() {
		return accumulator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccumulator(Accumulator newAccumulator) {
		Accumulator oldAccumulator = accumulator;
		accumulator = newAccumulator == null ? ACCUMULATOR_EDEFAULT : newAccumulator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.COLLECTIVE_MEASURE__ACCUMULATOR, oldAccumulator, accumulator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getCustomAccumulator() {
		if (customAccumulator != null && customAccumulator.eIsProxy()) {
			InternalEObject oldCustomAccumulator = (InternalEObject)customAccumulator;
			customAccumulator = (Operation)eResolveProxy(oldCustomAccumulator);
			if (customAccumulator != oldCustomAccumulator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SmmPackage.COLLECTIVE_MEASURE__CUSTOM_ACCUMULATOR, oldCustomAccumulator, customAccumulator));
			}
		}
		return customAccumulator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetCustomAccumulator() {
		return customAccumulator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomAccumulator(Operation newCustomAccumulator) {
		Operation oldCustomAccumulator = customAccumulator;
		customAccumulator = newCustomAccumulator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.COLLECTIVE_MEASURE__CUSTOM_ACCUMULATOR, oldCustomAccumulator, customAccumulator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SmmPackage.COLLECTIVE_MEASURE__ACCUMULATOR:
				return getAccumulator();
			case SmmPackage.COLLECTIVE_MEASURE__CUSTOM_ACCUMULATOR:
				if (resolve) return getCustomAccumulator();
				return basicGetCustomAccumulator();
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
			case SmmPackage.COLLECTIVE_MEASURE__ACCUMULATOR:
				setAccumulator((Accumulator)newValue);
				return;
			case SmmPackage.COLLECTIVE_MEASURE__CUSTOM_ACCUMULATOR:
				setCustomAccumulator((Operation)newValue);
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
			case SmmPackage.COLLECTIVE_MEASURE__ACCUMULATOR:
				setAccumulator(ACCUMULATOR_EDEFAULT);
				return;
			case SmmPackage.COLLECTIVE_MEASURE__CUSTOM_ACCUMULATOR:
				setCustomAccumulator((Operation)null);
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
			case SmmPackage.COLLECTIVE_MEASURE__ACCUMULATOR:
				return accumulator != ACCUMULATOR_EDEFAULT;
			case SmmPackage.COLLECTIVE_MEASURE__CUSTOM_ACCUMULATOR:
				return customAccumulator != null;
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
		result.append(" (accumulator: ");
		result.append(accumulator);
		result.append(')');
		return result.toString();
	}

} //CollectiveMeasureImpl
