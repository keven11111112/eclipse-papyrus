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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Additive Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.AdditiveExpressionCompletion#getMultiplicativeExpressionCompletion <em>Multiplicative Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.AdditiveExpressionCompletion#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.AdditiveExpressionCompletion#getMultiplicativeExpression <em>Multiplicative Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAdditiveExpressionCompletion()
 * @model
 * @generated
 */
public interface AdditiveExpressionCompletion extends EObject
{
  /**
   * Returns the value of the '<em><b>Multiplicative Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiplicative Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplicative Expression Completion</em>' containment reference.
   * @see #setMultiplicativeExpressionCompletion(MultiplicativeExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAdditiveExpressionCompletion_MultiplicativeExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  MultiplicativeExpressionCompletion getMultiplicativeExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.AdditiveExpressionCompletion#getMultiplicativeExpressionCompletion <em>Multiplicative Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicative Expression Completion</em>' containment reference.
   * @see #getMultiplicativeExpressionCompletion()
   * @generated
   */
  void setMultiplicativeExpressionCompletion(MultiplicativeExpressionCompletion value);

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute list.
   * The list contents are of type {@link org.eclipse.papyrus.alf.alf.AdditiveOperator}.
   * The literals are from the enumeration {@link org.eclipse.papyrus.alf.alf.AdditiveOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute list.
   * @see org.eclipse.papyrus.alf.alf.AdditiveOperator
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAdditiveExpressionCompletion_Operator()
   * @model unique="false"
   * @generated
   */
  EList<AdditiveOperator> getOperator();

  /**
   * Returns the value of the '<em><b>Multiplicative Expression</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.alf.alf.MultiplicativeExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiplicative Expression</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplicative Expression</em>' containment reference list.
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAdditiveExpressionCompletion_MultiplicativeExpression()
   * @model containment="true"
   * @generated
   */
  EList<MultiplicativeExpression> getMultiplicativeExpression();

} // AdditiveExpressionCompletion
