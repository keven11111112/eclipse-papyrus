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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.omg.smm.BaseMeasureRelationship;
import org.omg.smm.RescaledMeasure;
import org.omg.smm.SmmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base Measure Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.impl.BaseMeasureRelationshipImpl#getRescaledMeasure <em>Rescaled Measure</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BaseMeasureRelationshipImpl extends MeasureRelationshipImpl implements BaseMeasureRelationship {
	/**
	 * The cached value of the '{@link #getRescaledMeasure() <em>Rescaled Measure</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRescaledMeasure()
	 * @generated
	 * @ordered
	 */
	protected RescaledMeasure rescaledMeasure;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BaseMeasureRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmmPackage.Literals.BASE_MEASURE_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RescaledMeasure getRescaledMeasure() {
		return rescaledMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRescaledMeasure(RescaledMeasure newRescaledMeasure, NotificationChain msgs) {
		RescaledMeasure oldRescaledMeasure = rescaledMeasure;
		rescaledMeasure = newRescaledMeasure;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmmPackage.BASE_MEASURE_RELATIONSHIP__RESCALED_MEASURE, oldRescaledMeasure, newRescaledMeasure);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRescaledMeasure(RescaledMeasure newRescaledMeasure) {
		if (newRescaledMeasure != rescaledMeasure) {
			NotificationChain msgs = null;
			if (rescaledMeasure != null)
				msgs = ((InternalEObject)rescaledMeasure).eInverseRemove(this, SmmPackage.RESCALED_MEASURE__RESCALES, RescaledMeasure.class, msgs);
			if (newRescaledMeasure != null)
				msgs = ((InternalEObject)newRescaledMeasure).eInverseAdd(this, SmmPackage.RESCALED_MEASURE__RESCALES, RescaledMeasure.class, msgs);
			msgs = basicSetRescaledMeasure(newRescaledMeasure, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.BASE_MEASURE_RELATIONSHIP__RESCALED_MEASURE, newRescaledMeasure, newRescaledMeasure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SmmPackage.BASE_MEASURE_RELATIONSHIP__RESCALED_MEASURE:
				if (rescaledMeasure != null)
					msgs = ((InternalEObject)rescaledMeasure).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmmPackage.BASE_MEASURE_RELATIONSHIP__RESCALED_MEASURE, null, msgs);
				return basicSetRescaledMeasure((RescaledMeasure)otherEnd, msgs);
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
			case SmmPackage.BASE_MEASURE_RELATIONSHIP__RESCALED_MEASURE:
				return basicSetRescaledMeasure(null, msgs);
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
			case SmmPackage.BASE_MEASURE_RELATIONSHIP__RESCALED_MEASURE:
				return getRescaledMeasure();
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
			case SmmPackage.BASE_MEASURE_RELATIONSHIP__RESCALED_MEASURE:
				setRescaledMeasure((RescaledMeasure)newValue);
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
			case SmmPackage.BASE_MEASURE_RELATIONSHIP__RESCALED_MEASURE:
				setRescaledMeasure((RescaledMeasure)null);
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
			case SmmPackage.BASE_MEASURE_RELATIONSHIP__RESCALED_MEASURE:
				return rescaledMeasure != null;
		}
		return super.eIsSet(featureID);
	}

} //BaseMeasureRelationshipImpl
