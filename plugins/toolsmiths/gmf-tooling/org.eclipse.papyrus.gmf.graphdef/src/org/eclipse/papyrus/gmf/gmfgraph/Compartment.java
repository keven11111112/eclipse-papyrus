/*******************************************************************************
 * Copyright (c) 2006, 2020 Borland Software Corporation, CEA LIST, ARTAL
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
package org.eclipse.papyrus.gmf.gmfgraph;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compartment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.Compartment#isCollapsible <em>Collapsible</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.Compartment#isNeedsTitle <em>Needs Title</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.Compartment#getAccessor <em>Accessor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getCompartment()
 * @model
 * @generated
 */
public interface Compartment extends DiagramElement{
	/**
	 * Returns the value of the '<em><b>Collapsible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collapsible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collapsible</em>' attribute.
	 * @see #setCollapsible(boolean)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getCompartment_Collapsible()
	 * @model
	 * @generated
	 */
	boolean isCollapsible();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.Compartment#isCollapsible <em>Collapsible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collapsible</em>' attribute.
	 * @see #isCollapsible()
	 * @generated
	 */
	void setCollapsible(boolean value);

	/**
	 * Returns the value of the '<em><b>Needs Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Needs Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Needs Title</em>' attribute.
	 * @see #setNeedsTitle(boolean)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getCompartment_NeedsTitle()
	 * @model
	 * @generated
	 */
	boolean isNeedsTitle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.Compartment#isNeedsTitle <em>Needs Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Needs Title</em>' attribute.
	 * @see #isNeedsTitle()
	 * @generated
	 */
	void setNeedsTitle(boolean value);

	/**
	 * Returns the value of the '<em><b>Accessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accessor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accessor</em>' reference.
	 * @see #setAccessor(ChildAccess)
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getCompartment_Accessor()
	 * @model
	 * @generated
	 */
	ChildAccess getAccessor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.gmfgraph.Compartment#getAccessor <em>Accessor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Accessor</em>' reference.
	 * @see #getAccessor()
	 * @generated
	 */
	void setAccessor(ChildAccess value);

} // Compartment
