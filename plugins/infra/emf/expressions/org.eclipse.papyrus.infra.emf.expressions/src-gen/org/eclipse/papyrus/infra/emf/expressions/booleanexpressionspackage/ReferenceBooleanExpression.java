/**
 * Copyright (c) 2017 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Boolean Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This expression allows to reference an expression defined in another model.
 * If there is no expression referenced we return TRUE.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.ReferenceBooleanExpression#getReferencedExpression <em>Referenced Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.EObjectBooleanExpressionsPackage#getReferenceBooleanExpression()
 * @model
 * @generated
 */
public interface ReferenceBooleanExpression extends IBooleanEObjectExpression {
	/**
	 * Returns the value of the '<em><b>Referenced Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Expression</em>' reference.
	 * @see #setReferencedExpression(IBooleanEObjectExpression)
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.EObjectBooleanExpressionsPackage#getReferenceBooleanExpression_ReferencedExpression()
	 * @model ordered="false"
	 * @generated
	 */
	IBooleanEObjectExpression getReferencedExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressionspackage.ReferenceBooleanExpression#getReferencedExpression <em>Referenced Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Expression</em>' reference.
	 * @see #getReferencedExpression()
	 * @generated
	 */
	void setReferencedExpression(IBooleanEObjectExpression value);

} // ReferenceBooleanExpression
