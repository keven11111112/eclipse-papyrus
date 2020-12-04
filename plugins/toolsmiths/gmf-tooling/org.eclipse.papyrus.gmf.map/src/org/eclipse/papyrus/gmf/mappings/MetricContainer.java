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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metric Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.MetricContainer#getMetrics <em>Metrics</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getMetricContainer()
 * @model
 * @generated
 */
public interface MetricContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Metrics</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.gmf.mappings.MetricRule}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.gmf.mappings.MetricRule#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metrics</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metrics</em>' containment reference list.
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getMetricContainer_Metrics()
	 * @see org.eclipse.papyrus.gmf.mappings.MetricRule#getContainer
	 * @model opposite="container" containment="true" required="true"
	 * @generated
	 */
	EList<MetricRule> getMetrics();

} // MetricContainer
