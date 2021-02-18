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


import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.gmf.gmfgraph.Node;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Both top-level diagram node and any inner node
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.NodeMapping#getDiagramNode <em>Diagram Node</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.NodeMapping#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.NodeMapping#getCompartments <em>Compartments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getNodeMapping()
 * @model
 * @generated
 */
public interface NodeMapping extends MappingEntry, MenuOwner, ToolOwner, AppearanceSteward {
	/**
	 * Returns the value of the '<em><b>Diagram Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram Node</em>' reference.
	 * @see #setDiagramNode(Node)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getNodeMapping_DiagramNode()
	 * @model required="true"
	 * @generated
	 */
	Node getDiagramNode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.NodeMapping#getDiagramNode <em>Diagram Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram Node</em>' reference.
	 * @see #getDiagramNode()
	 * @generated
	 */
	void setDiagramNode(Node value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.gmf.mappings.ChildReference}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.gmf.mappings.ChildReference#getParentNode <em>Parent Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getNodeMapping_Children()
	 * @see org.eclipse.papyrus.gmf.mappings.ChildReference#getParentNode
	 * @model opposite="parentNode" containment="true"
	 * @generated
	 */
	EList<ChildReference> getChildren();

	/**
	 * Returns the value of the '<em><b>Compartments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.gmf.mappings.CompartmentMapping}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.gmf.mappings.CompartmentMapping#getParentNode <em>Parent Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compartments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compartments</em>' containment reference list.
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getNodeMapping_Compartments()
	 * @see org.eclipse.papyrus.gmf.mappings.CompartmentMapping#getParentNode
	 * @model opposite="parentNode" containment="true"
	 * @generated
	 */
	EList<CompartmentMapping> getCompartments();

} // NodeMapping
