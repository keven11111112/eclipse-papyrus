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

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.omg.smm.Measurement;
import org.omg.smm.MeasurementRelationship;
import org.omg.smm.ObservedMeasure;
import org.omg.smm.SmmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Measurement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.impl.MeasurementImpl#getBreakValue <em>Break Value</em>}</li>
 *   <li>{@link org.omg.smm.impl.MeasurementImpl#getError <em>Error</em>}</li>
 *   <li>{@link org.omg.smm.impl.MeasurementImpl#getMeasurementRelationships <em>Measurement Relationships</em>}</li>
 *   <li>{@link org.omg.smm.impl.MeasurementImpl#getObservedMeasure <em>Observed Measure</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MeasurementImpl extends SmmElementImpl implements Measurement {
	/**
	 * The default value of the '{@link #getBreakValue() <em>Break Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBreakValue()
	 * @generated
	 * @ordered
	 */
	protected static final String BREAK_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBreakValue() <em>Break Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBreakValue()
	 * @generated
	 * @ordered
	 */
	protected String breakValue = BREAK_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getError() <em>Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getError()
	 * @generated
	 * @ordered
	 */
	protected static final String ERROR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getError() <em>Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getError()
	 * @generated
	 * @ordered
	 */
	protected String error = ERROR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMeasurementRelationships() <em>Measurement Relationships</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasurementRelationships()
	 * @generated
	 * @ordered
	 */
	protected EList<MeasurementRelationship> measurementRelationships;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MeasurementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmmPackage.Literals.MEASUREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBreakValue() {
		return breakValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBreakValue(String newBreakValue) {
		String oldBreakValue = breakValue;
		breakValue = newBreakValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.MEASUREMENT__BREAK_VALUE, oldBreakValue, breakValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getError() {
		return error;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setError(String newError) {
		String oldError = error;
		error = newError;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.MEASUREMENT__ERROR, oldError, error));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MeasurementRelationship> getMeasurementRelationships() {
		if (measurementRelationships == null) {
			measurementRelationships = new EObjectContainmentEList<MeasurementRelationship>(MeasurementRelationship.class, this, SmmPackage.MEASUREMENT__MEASUREMENT_RELATIONSHIPS);
		}
		return measurementRelationships;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObservedMeasure getObservedMeasure() {
		if (eContainerFeatureID() != SmmPackage.MEASUREMENT__OBSERVED_MEASURE) return null;
		return (ObservedMeasure)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetObservedMeasure(ObservedMeasure newObservedMeasure, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newObservedMeasure, SmmPackage.MEASUREMENT__OBSERVED_MEASURE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObservedMeasure(ObservedMeasure newObservedMeasure) {
		if (newObservedMeasure != eInternalContainer() || (eContainerFeatureID() != SmmPackage.MEASUREMENT__OBSERVED_MEASURE && newObservedMeasure != null)) {
			if (EcoreUtil.isAncestor(this, newObservedMeasure))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newObservedMeasure != null)
				msgs = ((InternalEObject)newObservedMeasure).eInverseAdd(this, SmmPackage.OBSERVED_MEASURE__MEASUREMENTS, ObservedMeasure.class, msgs);
			msgs = basicSetObservedMeasure(newObservedMeasure, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.MEASUREMENT__OBSERVED_MEASURE, newObservedMeasure, newObservedMeasure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMeasureLabel() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMeasurementLabel() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SmmPackage.MEASUREMENT__OBSERVED_MEASURE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetObservedMeasure((ObservedMeasure)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SmmPackage.MEASUREMENT__MEASUREMENT_RELATIONSHIPS:
				return ((InternalEList<?>)getMeasurementRelationships()).basicRemove(otherEnd, msgs);
			case SmmPackage.MEASUREMENT__OBSERVED_MEASURE:
				return basicSetObservedMeasure(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SmmPackage.MEASUREMENT__OBSERVED_MEASURE:
				return eInternalContainer().eInverseRemove(this, SmmPackage.OBSERVED_MEASURE__MEASUREMENTS, ObservedMeasure.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SmmPackage.MEASUREMENT__BREAK_VALUE:
				return getBreakValue();
			case SmmPackage.MEASUREMENT__ERROR:
				return getError();
			case SmmPackage.MEASUREMENT__MEASUREMENT_RELATIONSHIPS:
				return getMeasurementRelationships();
			case SmmPackage.MEASUREMENT__OBSERVED_MEASURE:
				return getObservedMeasure();
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
			case SmmPackage.MEASUREMENT__BREAK_VALUE:
				setBreakValue((String)newValue);
				return;
			case SmmPackage.MEASUREMENT__ERROR:
				setError((String)newValue);
				return;
			case SmmPackage.MEASUREMENT__MEASUREMENT_RELATIONSHIPS:
				getMeasurementRelationships().clear();
				getMeasurementRelationships().addAll((Collection<? extends MeasurementRelationship>)newValue);
				return;
			case SmmPackage.MEASUREMENT__OBSERVED_MEASURE:
				setObservedMeasure((ObservedMeasure)newValue);
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
			case SmmPackage.MEASUREMENT__BREAK_VALUE:
				setBreakValue(BREAK_VALUE_EDEFAULT);
				return;
			case SmmPackage.MEASUREMENT__ERROR:
				setError(ERROR_EDEFAULT);
				return;
			case SmmPackage.MEASUREMENT__MEASUREMENT_RELATIONSHIPS:
				getMeasurementRelationships().clear();
				return;
			case SmmPackage.MEASUREMENT__OBSERVED_MEASURE:
				setObservedMeasure((ObservedMeasure)null);
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
			case SmmPackage.MEASUREMENT__BREAK_VALUE:
				return BREAK_VALUE_EDEFAULT == null ? breakValue != null : !BREAK_VALUE_EDEFAULT.equals(breakValue);
			case SmmPackage.MEASUREMENT__ERROR:
				return ERROR_EDEFAULT == null ? error != null : !ERROR_EDEFAULT.equals(error);
			case SmmPackage.MEASUREMENT__MEASUREMENT_RELATIONSHIPS:
				return measurementRelationships != null && !measurementRelationships.isEmpty();
			case SmmPackage.MEASUREMENT__OBSERVED_MEASURE:
				return getObservedMeasure() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SmmPackage.MEASUREMENT___GET_MEASURE_LABEL:
				return getMeasureLabel();
			case SmmPackage.MEASUREMENT___GET_MEASUREMENT_LABEL:
				return getMeasurementLabel();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (breakValue: ");
		result.append(breakValue);
		result.append(", error: ");
		result.append(error);
		result.append(')');
		return result.toString();
	}

} //MeasurementImpl
