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
 * A representation of the model object '<em><b>Feature Value Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Value specification associated with a specific feature
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.FeatureValueSpec#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getFeatureValueSpec()
 * @model
 * @generated
 */
public interface FeatureValueSpec extends FeatureInitializer {

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(ValueExpression)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getFeatureValueSpec_Value()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/gmf/2005/constraints/meta def='context' ocl='featureSeqInitializer.elementClass'"
	 *        annotation="http://www.eclipse.org/gmf/2005/constraints/meta def='type' ocl='feature'"
	 * @generated
	 */
	ValueExpression getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.FeatureValueSpec#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(ValueExpression value);
} // FeatureValueSpec
