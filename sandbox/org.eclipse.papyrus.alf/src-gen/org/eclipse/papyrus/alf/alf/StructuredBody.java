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
 * A representation of the model object '<em><b>Structured Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.StructuredBody#getStructuredMember <em>Structured Member</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getStructuredBody()
 * @model
 * @generated
 */
public interface StructuredBody extends EObject
{
  /**
   * Returns the value of the '<em><b>Structured Member</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.alf.alf.StructuredMember}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Structured Member</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Structured Member</em>' containment reference list.
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getStructuredBody_StructuredMember()
   * @model containment="true"
   * @generated
   */
  EList<StructuredMember> getStructuredMember();

} // StructuredBody
