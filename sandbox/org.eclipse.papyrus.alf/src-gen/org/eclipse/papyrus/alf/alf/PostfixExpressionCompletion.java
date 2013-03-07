/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Postfix Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PostfixExpressionCompletion#getPrimaryExpressionCompletion <em>Primary Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PostfixExpressionCompletion#getPostfixOperation <em>Postfix Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPostfixExpressionCompletion()
 * @model
 * @generated
 */
public interface PostfixExpressionCompletion extends EObject
{
  /**
   * Returns the value of the '<em><b>Primary Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Primary Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Primary Expression Completion</em>' containment reference.
   * @see #setPrimaryExpressionCompletion(PrimaryExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPostfixExpressionCompletion_PrimaryExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  PrimaryExpressionCompletion getPrimaryExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PostfixExpressionCompletion#getPrimaryExpressionCompletion <em>Primary Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Primary Expression Completion</em>' containment reference.
   * @see #getPrimaryExpressionCompletion()
   * @generated
   */
  void setPrimaryExpressionCompletion(PrimaryExpressionCompletion value);

  /**
   * Returns the value of the '<em><b>Postfix Operation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Postfix Operation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Postfix Operation</em>' containment reference.
   * @see #setPostfixOperation(PostfixOperation)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPostfixExpressionCompletion_PostfixOperation()
   * @model containment="true"
   * @generated
   */
  PostfixOperation getPostfixOperation();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.PostfixExpressionCompletion#getPostfixOperation <em>Postfix Operation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Postfix Operation</em>' containment reference.
   * @see #getPostfixOperation()
   * @generated
   */
  void setPostfixOperation(PostfixOperation value);

} // PostfixExpressionCompletion
