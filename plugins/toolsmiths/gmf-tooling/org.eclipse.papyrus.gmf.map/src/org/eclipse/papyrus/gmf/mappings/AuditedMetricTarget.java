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
package org.eclipse.papyrus.gmf.mappings;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Audited Metric Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Target metric which can be evaluated by audit rule. The target context here is the metric rule resulting type classifier
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.AuditedMetricTarget#getMetric <em>Metric</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getAuditedMetricTarget()
 * @model annotation="http://www.eclipse.org/gmf/2005/constraints/meta def='context' ocl='\'ecore::EDoubleObject\''"
 * @generated
 */
public interface AuditedMetricTarget extends Auditable {
	/**
	 * Returns the value of the '<em><b>Metric</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Metric which can be checked by audit
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metric</em>' reference.
	 * @see #setMetric(MetricRule)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getAuditedMetricTarget_Metric()
	 * @model required="true"
	 * @generated
	 */
	MetricRule getMetric();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.AuditedMetricTarget#getMetric <em>Metric</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metric</em>' reference.
	 * @see #getMetric()
	 * @generated
	 */
	void setMetric(MetricRule value);

} // AuditedMetricTarget
