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

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.omg.smm.Interval;
import org.omg.smm.SmmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interval</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.omg.smm.impl.IntervalImpl#getMaximumEndpoint <em>Maximum Endpoint</em>}</li>
 *   <li>{@link org.omg.smm.impl.IntervalImpl#isMaximumOpen <em>Maximum Open</em>}</li>
 *   <li>{@link org.omg.smm.impl.IntervalImpl#getMinimumEndpoint <em>Minimum Endpoint</em>}</li>
 *   <li>{@link org.omg.smm.impl.IntervalImpl#isMinimumOpen <em>Minimum Open</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class IntervalImpl extends SmmElementImpl implements Interval {
	/**
	 * The default value of the '{@link #getMaximumEndpoint() <em>Maximum Endpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumEndpoint()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal MAXIMUM_ENDPOINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaximumEndpoint() <em>Maximum Endpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumEndpoint()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal maximumEndpoint = MAXIMUM_ENDPOINT_EDEFAULT;

	/**
	 * The default value of the '{@link #isMaximumOpen() <em>Maximum Open</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMaximumOpen()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MAXIMUM_OPEN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMaximumOpen() <em>Maximum Open</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMaximumOpen()
	 * @generated
	 * @ordered
	 */
	protected boolean maximumOpen = MAXIMUM_OPEN_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinimumEndpoint() <em>Minimum Endpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumEndpoint()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal MINIMUM_ENDPOINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinimumEndpoint() <em>Minimum Endpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumEndpoint()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal minimumEndpoint = MINIMUM_ENDPOINT_EDEFAULT;

	/**
	 * The default value of the '{@link #isMinimumOpen() <em>Minimum Open</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMinimumOpen()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MINIMUM_OPEN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMinimumOpen() <em>Minimum Open</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMinimumOpen()
	 * @generated
	 * @ordered
	 */
	protected boolean minimumOpen = MINIMUM_OPEN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntervalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SmmPackage.Literals.INTERVAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getMaximumEndpoint() {
		return maximumEndpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumEndpoint(BigDecimal newMaximumEndpoint) {
		BigDecimal oldMaximumEndpoint = maximumEndpoint;
		maximumEndpoint = newMaximumEndpoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.INTERVAL__MAXIMUM_ENDPOINT, oldMaximumEndpoint, maximumEndpoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMaximumOpen() {
		return maximumOpen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumOpen(boolean newMaximumOpen) {
		boolean oldMaximumOpen = maximumOpen;
		maximumOpen = newMaximumOpen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.INTERVAL__MAXIMUM_OPEN, oldMaximumOpen, maximumOpen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getMinimumEndpoint() {
		return minimumEndpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumEndpoint(BigDecimal newMinimumEndpoint) {
		BigDecimal oldMinimumEndpoint = minimumEndpoint;
		minimumEndpoint = newMinimumEndpoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.INTERVAL__MINIMUM_ENDPOINT, oldMinimumEndpoint, minimumEndpoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMinimumOpen() {
		return minimumOpen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumOpen(boolean newMinimumOpen) {
		boolean oldMinimumOpen = minimumOpen;
		minimumOpen = newMinimumOpen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SmmPackage.INTERVAL__MINIMUM_OPEN, oldMinimumOpen, minimumOpen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SmmPackage.INTERVAL__MAXIMUM_ENDPOINT:
				return getMaximumEndpoint();
			case SmmPackage.INTERVAL__MAXIMUM_OPEN:
				return isMaximumOpen();
			case SmmPackage.INTERVAL__MINIMUM_ENDPOINT:
				return getMinimumEndpoint();
			case SmmPackage.INTERVAL__MINIMUM_OPEN:
				return isMinimumOpen();
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
			case SmmPackage.INTERVAL__MAXIMUM_ENDPOINT:
				setMaximumEndpoint((BigDecimal)newValue);
				return;
			case SmmPackage.INTERVAL__MAXIMUM_OPEN:
				setMaximumOpen((Boolean)newValue);
				return;
			case SmmPackage.INTERVAL__MINIMUM_ENDPOINT:
				setMinimumEndpoint((BigDecimal)newValue);
				return;
			case SmmPackage.INTERVAL__MINIMUM_OPEN:
				setMinimumOpen((Boolean)newValue);
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
			case SmmPackage.INTERVAL__MAXIMUM_ENDPOINT:
				setMaximumEndpoint(MAXIMUM_ENDPOINT_EDEFAULT);
				return;
			case SmmPackage.INTERVAL__MAXIMUM_OPEN:
				setMaximumOpen(MAXIMUM_OPEN_EDEFAULT);
				return;
			case SmmPackage.INTERVAL__MINIMUM_ENDPOINT:
				setMinimumEndpoint(MINIMUM_ENDPOINT_EDEFAULT);
				return;
			case SmmPackage.INTERVAL__MINIMUM_OPEN:
				setMinimumOpen(MINIMUM_OPEN_EDEFAULT);
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
			case SmmPackage.INTERVAL__MAXIMUM_ENDPOINT:
				return MAXIMUM_ENDPOINT_EDEFAULT == null ? maximumEndpoint != null : !MAXIMUM_ENDPOINT_EDEFAULT.equals(maximumEndpoint);
			case SmmPackage.INTERVAL__MAXIMUM_OPEN:
				return maximumOpen != MAXIMUM_OPEN_EDEFAULT;
			case SmmPackage.INTERVAL__MINIMUM_ENDPOINT:
				return MINIMUM_ENDPOINT_EDEFAULT == null ? minimumEndpoint != null : !MINIMUM_ENDPOINT_EDEFAULT.equals(minimumEndpoint);
			case SmmPackage.INTERVAL__MINIMUM_OPEN:
				return minimumOpen != MINIMUM_OPEN_EDEFAULT;
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
		result.append(" (maximumEndpoint: ");
		result.append(maximumEndpoint);
		result.append(", maximumOpen: ");
		result.append(maximumOpen);
		result.append(", minimumEndpoint: ");
		result.append(minimumEndpoint);
		result.append(", minimumOpen: ");
		result.append(minimumOpen);
		result.append(')');
		return result.toString();
	}

} //IntervalImpl
