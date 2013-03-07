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
 * A representation of the model object '<em><b>Name Or Primary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.NameOrPrimaryExpression#getPotentiallyAmbiguousQualifiedName <em>Potentially Ambiguous Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.NameOrPrimaryExpression#getNameToPrimaryExpression <em>Name To Primary Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNameOrPrimaryExpression()
 * @model
 * @generated
 */
public interface NameOrPrimaryExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Potentially Ambiguous Qualified Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Potentially Ambiguous Qualified Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Potentially Ambiguous Qualified Name</em>' containment reference.
   * @see #setPotentiallyAmbiguousQualifiedName(QualifiedNameWithoutBinding)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNameOrPrimaryExpression_PotentiallyAmbiguousQualifiedName()
   * @model containment="true"
   * @generated
   */
  QualifiedNameWithoutBinding getPotentiallyAmbiguousQualifiedName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.NameOrPrimaryExpression#getPotentiallyAmbiguousQualifiedName <em>Potentially Ambiguous Qualified Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Potentially Ambiguous Qualified Name</em>' containment reference.
   * @see #getPotentiallyAmbiguousQualifiedName()
   * @generated
   */
  void setPotentiallyAmbiguousQualifiedName(QualifiedNameWithoutBinding value);

  /**
   * Returns the value of the '<em><b>Name To Primary Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name To Primary Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name To Primary Expression</em>' containment reference.
   * @see #setNameToPrimaryExpression(NameToPrimaryExpression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getNameOrPrimaryExpression_NameToPrimaryExpression()
   * @model containment="true"
   * @generated
   */
  NameToPrimaryExpression getNameToPrimaryExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.NameOrPrimaryExpression#getNameToPrimaryExpression <em>Name To Primary Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name To Primary Expression</em>' containment reference.
   * @see #getNameToPrimaryExpression()
   * @generated
   */
  void setNameToPrimaryExpression(NameToPrimaryExpression value);

} // NameOrPrimaryExpression
