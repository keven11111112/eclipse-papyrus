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
 * A representation of the model object '<em><b>Expression Label Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Label based on a calculated value
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.ExpressionLabelMapping#getViewExpression <em>View Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.ExpressionLabelMapping#getEditExpression <em>Edit Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.ExpressionLabelMapping#getValidateExpression <em>Validate Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getExpressionLabelMapping()
 * @model
 * @generated
 */
public interface ExpressionLabelMapping extends LabelMapping {
	/**
	 * Returns the value of the '<em><b>View Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Expression to produce regular label value. Evaluated in the context of the owning mapEntry.domainMetaElement
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>View Expression</em>' containment reference.
	 * @see #setViewExpression(ValueExpression)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getExpressionLabelMapping_ViewExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ValueExpression getViewExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.ExpressionLabelMapping#getViewExpression <em>View Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View Expression</em>' containment reference.
	 * @see #getViewExpression()
	 * @generated
	 */
	void setViewExpression(ValueExpression value);

	/**
	 * Returns the value of the '<em><b>Edit Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Optional expression to produce editable string representation of the label. If not set, viewExpression is used.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Edit Expression</em>' containment reference.
	 * @see #setEditExpression(ValueExpression)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getExpressionLabelMapping_EditExpression()
	 * @model containment="true"
	 * @generated
	 */
	ValueExpression getEditExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.ExpressionLabelMapping#getEditExpression <em>Edit Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edit Expression</em>' containment reference.
	 * @see #getEditExpression()
	 * @generated
	 */
	void setEditExpression(ValueExpression value);

	/**
	 * Returns the value of the '<em><b>Validate Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Boolean expression in a string context, which able to tell whether user-entered text is valid.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Validate Expression</em>' containment reference.
	 * @see #setValidateExpression(Constraint)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getExpressionLabelMapping_ValidateExpression()
	 * @model containment="true"
	 * @generated
	 */
	Constraint getValidateExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.ExpressionLabelMapping#getValidateExpression <em>Validate Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validate Expression</em>' containment reference.
	 * @see #getValidateExpression()
	 * @generated
	 */
	void setValidateExpression(Constraint value);

} // ExpressionLabelMapping
