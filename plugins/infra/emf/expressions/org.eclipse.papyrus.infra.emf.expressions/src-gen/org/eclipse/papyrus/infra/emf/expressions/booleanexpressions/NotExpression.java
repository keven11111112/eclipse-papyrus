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
package org.eclipse.papyrus.infra.emf.expressions.booleanexpressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Make a not on an IBooleanExpression
 * If ownedExpression==NULL and referencedExpression==NULL we return FALSE
 * If ownedExpression<>NULL and referencedExpression<>NULL we return the result for ownedExpression. The referencedExpression is ignored
 * In other case we return the evaluation of the non NULL expression
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressions.NotExpression#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressions.NotExpression#getReferencedExpression <em>Referenced Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressions.BooleanExpressionsPackage#getNotExpression()
 * @model
 * @generated
 */
public interface NotExpression extends IBooleanEObjectExpression {
	/**
	 * Returns the value of the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Expression</em>' containment reference.
	 * @see #setOwnedExpression(IBooleanEObjectExpression)
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressions.BooleanExpressionsPackage#getNotExpression_OwnedExpression()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	IBooleanEObjectExpression getOwnedExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressions.NotExpression#getOwnedExpression <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Expression</em>' containment reference.
	 * @see #getOwnedExpression()
	 * @generated
	 */
	void setOwnedExpression(IBooleanEObjectExpression value);

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
	 * @see org.eclipse.papyrus.infra.emf.expressions.booleanexpressions.BooleanExpressionsPackage#getNotExpression_ReferencedExpression()
	 * @model ordered="false"
	 * @generated
	 */
	IBooleanEObjectExpression getReferencedExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.emf.expressions.booleanexpressions.NotExpression#getReferencedExpression <em>Referenced Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Expression</em>' reference.
	 * @see #getReferencedExpression()
	 * @generated
	 */
	void setReferencedExpression(IBooleanEObjectExpression value);

} // NotExpression
