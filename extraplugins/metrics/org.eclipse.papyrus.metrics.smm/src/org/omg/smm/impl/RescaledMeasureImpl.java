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

import java.math.BigDecimal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.omg.smm.BaseMeasureRelationship;
import org.omg.smm.Operation;
import org.omg.smm.RescaledMeasure;
import org.omg.smm.SmmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rescaled Measure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.impl.RescaledMeasureImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.omg.smm.impl.RescaledMeasureImpl#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.omg.smm.impl.RescaledMeasureImpl#getMultiplier <em>Multiplier</em>}</li>
 *   <li>{@link org.omg.smm.impl.RescaledMeasureImpl#getRescales <em>Rescales</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RescaledMeasureImpl extends DimensionalMeasureImpl implements RescaledMeasure {
	/**
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected Operation operation;

	/**
	 * The default value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal OFFSET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal offset = OFFSET_EDEFAULT;

	/**
	 * The default value of the '{@link #getMultiplier() <em>Multiplier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplier()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal MULTIPLIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMultiplier() <em>Multiplier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplier()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal multiplier = MULTIPLIER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RescaledMeasureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmmPackage.Literals.RESCALED_MEASURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getOperation() {
		if (operation != null && operation.eIsProxy()) {
			InternalEObject oldOperation = (InternalEObject)operation;
			operation = (Operation)eResolveProxy(oldOperation);
			if (operation != oldOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SmmPackage.RESCALED_MEASURE__OPERATION, oldOperation, operation));
			}
		}
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetOperation() {
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperation(Operation newOperation) {
		Operation oldOperation = operation;
		operation = newOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.RESCALED_MEASURE__OPERATION, oldOperation, operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getOffset() {
		return offset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOffset(BigDecimal newOffset) {
		BigDecimal oldOffset = offset;
		offset = newOffset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.RESCALED_MEASURE__OFFSET, oldOffset, offset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getMultiplier() {
		return multiplier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiplier(BigDecimal newMultiplier) {
		BigDecimal oldMultiplier = multiplier;
		multiplier = newMultiplier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.RESCALED_MEASURE__MULTIPLIER, oldMultiplier, multiplier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseMeasureRelationship getRescales() {
		if (eContainerFeatureID() != SmmPackage.RESCALED_MEASURE__RESCALES) return null;
		return (BaseMeasureRelationship)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRescales(BaseMeasureRelationship newRescales, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRescales, SmmPackage.RESCALED_MEASURE__RESCALES, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRescales(BaseMeasureRelationship newRescales) {
		if (newRescales != eInternalContainer() || (eContainerFeatureID() != SmmPackage.RESCALED_MEASURE__RESCALES && newRescales != null)) {
			if (EcoreUtil.isAncestor(this, newRescales))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRescales != null)
				msgs = ((InternalEObject)newRescales).eInverseAdd(this, SmmPackage.BASE_MEASURE_RELATIONSHIP__RESCALED_MEASURE, BaseMeasureRelationship.class, msgs);
			msgs = basicSetRescales(newRescales, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.RESCALED_MEASURE__RESCALES, newRescales, newRescales));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SmmPackage.RESCALED_MEASURE__RESCALES:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRescales((BaseMeasureRelationship)otherEnd, msgs);
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
			case SmmPackage.RESCALED_MEASURE__RESCALES:
				return basicSetRescales(null, msgs);
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
			case SmmPackage.RESCALED_MEASURE__RESCALES:
				return eInternalContainer().eInverseRemove(this, SmmPackage.BASE_MEASURE_RELATIONSHIP__RESCALED_MEASURE, BaseMeasureRelationship.class, msgs);
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
			case SmmPackage.RESCALED_MEASURE__OPERATION:
				if (resolve) return getOperation();
				return basicGetOperation();
			case SmmPackage.RESCALED_MEASURE__OFFSET:
				return getOffset();
			case SmmPackage.RESCALED_MEASURE__MULTIPLIER:
				return getMultiplier();
			case SmmPackage.RESCALED_MEASURE__RESCALES:
				return getRescales();
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
			case SmmPackage.RESCALED_MEASURE__OPERATION:
				setOperation((Operation)newValue);
				return;
			case SmmPackage.RESCALED_MEASURE__OFFSET:
				setOffset((BigDecimal)newValue);
				return;
			case SmmPackage.RESCALED_MEASURE__MULTIPLIER:
				setMultiplier((BigDecimal)newValue);
				return;
			case SmmPackage.RESCALED_MEASURE__RESCALES:
				setRescales((BaseMeasureRelationship)newValue);
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
			case SmmPackage.RESCALED_MEASURE__OPERATION:
				setOperation((Operation)null);
				return;
			case SmmPackage.RESCALED_MEASURE__OFFSET:
				setOffset(OFFSET_EDEFAULT);
				return;
			case SmmPackage.RESCALED_MEASURE__MULTIPLIER:
				setMultiplier(MULTIPLIER_EDEFAULT);
				return;
			case SmmPackage.RESCALED_MEASURE__RESCALES:
				setRescales((BaseMeasureRelationship)null);
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
			case SmmPackage.RESCALED_MEASURE__OPERATION:
				return operation != null;
			case SmmPackage.RESCALED_MEASURE__OFFSET:
				return OFFSET_EDEFAULT == null ? offset != null : !OFFSET_EDEFAULT.equals(offset);
			case SmmPackage.RESCALED_MEASURE__MULTIPLIER:
				return MULTIPLIER_EDEFAULT == null ? multiplier != null : !MULTIPLIER_EDEFAULT.equals(multiplier);
			case SmmPackage.RESCALED_MEASURE__RESCALES:
				return getRescales() != null;
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
		result.append(" (offset: ");
		result.append(offset);
		result.append(", multiplier: ");
		result.append(multiplier);
		result.append(')');
		return result.toString();
	}

} //RescaledMeasureImpl
