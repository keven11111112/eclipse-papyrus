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
 * A representation of the model object '<em><b>Representation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation#getGraphicalElementType <em>Graphical Element Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation#getInducedRepresentations <em>Induced Representations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation#getSubRepresentations <em>Sub Representations</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionmodelPackage#getRepresentation()
 * @model
 * @generated
 */
public interface Representation extends AbstractRepresentation {
	/**
	 * Returns the value of the '<em><b>Graphical Element Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graphical Element Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graphical Element Type</em>' attribute.
	 * @see #setGraphicalElementType(String)
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionmodelPackage#getRepresentation_GraphicalElementType()
	 * @model ordered="false"
	 * @generated
	 */
	String getGraphicalElementType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation#getGraphicalElementType <em>Graphical Element Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graphical Element Type</em>' attribute.
	 * @see #getGraphicalElementType()
	 * @generated
	 */
	void setGraphicalElementType(String value);

	/**
	 * Returns the value of the '<em><b>Induced Representations</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.InducedRepresentation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Induced Representations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Induced Representations</em>' reference list.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionmodelPackage#getRepresentation_InducedRepresentations()
	 * @model ordered="false"
	 * @generated
	 */
	EList<InducedRepresentation> getInducedRepresentations();

	/**
	 * Returns the value of the '<em><b>Sub Representations</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Representations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Representations</em>' reference list.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionmodelPackage#getRepresentation_SubRepresentations()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Representation> getSubRepresentations();

} // Representation
