/**
 * Copyright (c) 2015 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Induced Representation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.InducedRepresentation#getHint <em>Hint</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.InducedRepresentation#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionmodelPackage#getInducedRepresentation()
 * @model
 * @generated
 */
public interface InducedRepresentation extends AbstractRepresentation {
	/**
	 * Returns the value of the '<em><b>Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hint</em>' attribute.
	 * @see #setHint(String)
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionmodelPackage#getInducedRepresentation_Hint()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getHint();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.InducedRepresentation#getHint <em>Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hint</em>' attribute.
	 * @see #getHint()
	 * @generated
	 */
	void setHint(String value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionmodelPackage#getInducedRepresentation_Children()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Representation> getChildren();

} // InducedRepresentation
