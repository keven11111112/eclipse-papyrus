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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.gmf.gmfgraph.Compartment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compartment Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.CompartmentMapping#getCompartment <em>Compartment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.CompartmentMapping#getParentNode <em>Parent Node</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.CompartmentMapping#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getCompartmentMapping()
 * @model
 * @generated
 */
public interface CompartmentMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Compartment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compartment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compartment</em>' reference.
	 * @see #setCompartment(Compartment)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getCompartmentMapping_Compartment()
	 * @model required="true"
	 * @generated
	 */
	Compartment getCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.CompartmentMapping#getCompartment <em>Compartment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compartment</em>' reference.
	 * @see #getCompartment()
	 * @generated
	 */
	void setCompartment(Compartment value);

	/**
	 * Returns the value of the '<em><b>Parent Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.gmf.mappings.NodeMapping#getCompartments <em>Compartments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Node</em>' container reference.
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getCompartmentMapping_ParentNode()
	 * @see org.eclipse.papyrus.gmf.mappings.NodeMapping#getCompartments
	 * @model opposite="compartments" resolveProxies="false" required="true" transient="false" changeable="false"
	 * @generated
	 */
	NodeMapping getParentNode();

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.gmf.mappings.ChildReference}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.gmf.mappings.ChildReference#getCompartment <em>Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getCompartmentMapping_Children()
	 * @see org.eclipse.papyrus.gmf.mappings.ChildReference#getCompartment
	 * @model opposite="compartment"
	 * @generated
	 */
	EList<ChildReference> getChildren();

} // CompartmentMapping
