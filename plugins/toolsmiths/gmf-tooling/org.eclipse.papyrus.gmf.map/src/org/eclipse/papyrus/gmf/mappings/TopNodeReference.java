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
 * A representation of the model object '<em><b>Top Node Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.TopNodeReference#getOwnedChild <em>Owned Child</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getTopNodeReference()
 * @model
 * @generated
 */
public interface TopNodeReference extends NodeReference {
	/**
	 * Returns the value of the '<em><b>Owned Child</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Child</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Child</em>' containment reference.
	 * @see #setOwnedChild(NodeMapping)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getTopNodeReference_OwnedChild()
	 * @model containment="true" required="true"
	 * @generated
	 */
	NodeMapping getOwnedChild();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.TopNodeReference#getOwnedChild <em>Owned Child</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Child</em>' containment reference.
	 * @see #getOwnedChild()
	 * @generated
	 */
	void setOwnedChild(NodeMapping value);

} // TopNodeReference
