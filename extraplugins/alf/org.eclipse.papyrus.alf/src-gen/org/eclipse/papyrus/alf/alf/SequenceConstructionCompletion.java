/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
 * A representation of the model object '<em><b>Sequence Construction Completion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SequenceConstructionCompletion#isMultiplicityIndicator <em>Multiplicity Indicator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.SequenceConstructionCompletion#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceConstructionCompletion()
 * @model
 * @generated
 */
public interface SequenceConstructionCompletion extends EObject
{
  /**
   * Returns the value of the '<em><b>Multiplicity Indicator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiplicity Indicator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplicity Indicator</em>' attribute.
   * @see #setMultiplicityIndicator(boolean)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceConstructionCompletion_MultiplicityIndicator()
   * @model
   * @generated
   */
  boolean isMultiplicityIndicator();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SequenceConstructionCompletion#isMultiplicityIndicator <em>Multiplicity Indicator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicity Indicator</em>' attribute.
   * @see #isMultiplicityIndicator()
   * @generated
   */
  void setMultiplicityIndicator(boolean value);

  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(SequenceConstructionExpression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getSequenceConstructionCompletion_Expression()
   * @model containment="true"
   * @generated
   */
  SequenceConstructionExpression getExpression();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.SequenceConstructionCompletion#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(SequenceConstructionExpression value);

} // SequenceConstructionCompletion
