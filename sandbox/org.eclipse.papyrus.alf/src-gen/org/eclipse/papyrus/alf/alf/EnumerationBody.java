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
 * A representation of the model object '<em><b>Enumeration Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.EnumerationBody#getEnumerationLiteralName <em>Enumeration Literal Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getEnumerationBody()
 * @model
 * @generated
 */
public interface EnumerationBody extends EObject
{
  /**
   * Returns the value of the '<em><b>Enumeration Literal Name</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.alf.alf.EnumerationLiteralName}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enumeration Literal Name</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enumeration Literal Name</em>' containment reference list.
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getEnumerationBody_EnumerationLiteralName()
   * @model containment="true"
   * @generated
   */
  EList<EnumerationLiteralName> getEnumerationLiteralName();

} // EnumerationBody
