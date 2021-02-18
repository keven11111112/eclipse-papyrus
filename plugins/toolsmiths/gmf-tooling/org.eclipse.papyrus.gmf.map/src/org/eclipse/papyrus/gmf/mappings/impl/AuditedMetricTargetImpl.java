/*******************************************************************************
 * Copyright (c) 2005, 2020 Borland Software Corporation, CEA LIST, ARTAL
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
package org.eclipse.papyrus.gmf.mappings.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.gmf.mappings.AuditedMetricTarget;
import org.eclipse.papyrus.gmf.mappings.GMFMapPackage;
import org.eclipse.papyrus.gmf.mappings.MetricRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Audited Metric Target</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.impl.AuditedMetricTargetImpl#getMetric <em>Metric</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AuditedMetricTargetImpl extends EObjectImpl implements AuditedMetricTarget {
	/**
	 * The cached value of the '{@link #getMetric() <em>Metric</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetric()
	 * @generated
	 * @ordered
	 */
	protected MetricRule metric;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AuditedMetricTargetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GMFMapPackage.eINSTANCE.getAuditedMetricTarget();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricRule getMetric() {
		if (metric != null && metric.eIsProxy()) {
			InternalEObject oldMetric = (InternalEObject)metric;
			metric = (MetricRule)eResolveProxy(oldMetric);
			if (metric != oldMetric) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFMapPackage.AUDITED_METRIC_TARGET__METRIC, oldMetric, metric));
			}
		}
		return metric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricRule basicGetMetric() {
		return metric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetric(MetricRule newMetric) {
		MetricRule oldMetric = metric;
		metric = newMetric;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFMapPackage.AUDITED_METRIC_TARGET__METRIC, oldMetric, metric));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GMFMapPackage.AUDITED_METRIC_TARGET__METRIC:
				if (resolve) return getMetric();
				return basicGetMetric();
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
			case GMFMapPackage.AUDITED_METRIC_TARGET__METRIC:
				setMetric((MetricRule)newValue);
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
			case GMFMapPackage.AUDITED_METRIC_TARGET__METRIC:
				setMetric((MetricRule)null);
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
			case GMFMapPackage.AUDITED_METRIC_TARGET__METRIC:
				return metric != null;
		}
		return super.eIsSet(featureID);
	}

} //AuditedMetricTargetImpl
