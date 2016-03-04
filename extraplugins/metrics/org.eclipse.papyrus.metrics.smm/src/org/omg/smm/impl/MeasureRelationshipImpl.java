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

import org.omg.smm.Influence;
import org.omg.smm.MeasureRelationship;
import org.omg.smm.Operation;
import org.omg.smm.SmmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Measure Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.impl.MeasureRelationshipImpl#getInfluence <em>Influence</em>}</li>
 *   <li>{@link org.omg.smm.impl.MeasureRelationshipImpl#getMeasurandQuery <em>Measurand Query</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MeasureRelationshipImpl extends SmmRelationshipImpl implements MeasureRelationship {
	/**
	 * The default value of the '{@link #getInfluence() <em>Influence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfluence()
	 * @generated
	 * @ordered
	 */
	protected static final Influence INFLUENCE_EDEFAULT = Influence.POSITIVE;

	/**
	 * The cached value of the '{@link #getInfluence() <em>Influence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfluence()
	 * @generated
	 * @ordered
	 */
	protected Influence influence = INFLUENCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMeasurandQuery() <em>Measurand Query</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasurandQuery()
	 * @generated
	 * @ordered
	 */
	protected Operation measurandQuery;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MeasureRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmmPackage.Literals.MEASURE_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Influence getInfluence() {
		return influence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInfluence(Influence newInfluence) {
		Influence oldInfluence = influence;
		influence = newInfluence == null ? INFLUENCE_EDEFAULT : newInfluence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.MEASURE_RELATIONSHIP__INFLUENCE, oldInfluence, influence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getMeasurandQuery() {
		if (measurandQuery != null && measurandQuery.eIsProxy()) {
			InternalEObject oldMeasurandQuery = (InternalEObject)measurandQuery;
			measurandQuery = (Operation)eResolveProxy(oldMeasurandQuery);
			if (measurandQuery != oldMeasurandQuery) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SmmPackage.MEASURE_RELATIONSHIP__MEASURAND_QUERY, oldMeasurandQuery, measurandQuery));
			}
		}
		return measurandQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetMeasurandQuery() {
		return measurandQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasurandQuery(Operation newMeasurandQuery) {
		Operation oldMeasurandQuery = measurandQuery;
		measurandQuery = newMeasurandQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.MEASURE_RELATIONSHIP__MEASURAND_QUERY, oldMeasurandQuery, measurandQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SmmPackage.MEASURE_RELATIONSHIP__INFLUENCE:
				return getInfluence();
			case SmmPackage.MEASURE_RELATIONSHIP__MEASURAND_QUERY:
				if (resolve) return getMeasurandQuery();
				return basicGetMeasurandQuery();
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
			case SmmPackage.MEASURE_RELATIONSHIP__INFLUENCE:
				setInfluence((Influence)newValue);
				return;
			case SmmPackage.MEASURE_RELATIONSHIP__MEASURAND_QUERY:
				setMeasurandQuery((Operation)newValue);
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
			case SmmPackage.MEASURE_RELATIONSHIP__INFLUENCE:
				setInfluence(INFLUENCE_EDEFAULT);
				return;
			case SmmPackage.MEASURE_RELATIONSHIP__MEASURAND_QUERY:
				setMeasurandQuery((Operation)null);
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
			case SmmPackage.MEASURE_RELATIONSHIP__INFLUENCE:
				return influence != INFLUENCE_EDEFAULT;
			case SmmPackage.MEASURE_RELATIONSHIP__MEASURAND_QUERY:
				return measurandQuery != null;
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
		result.append(" (influence: ");
		result.append(influence);
		result.append(')');
		return result.toString();
	}

} //MeasureRelationshipImpl
