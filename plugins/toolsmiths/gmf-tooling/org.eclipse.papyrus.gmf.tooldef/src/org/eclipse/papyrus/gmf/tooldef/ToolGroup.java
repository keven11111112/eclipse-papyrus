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
package org.eclipse.papyrus.gmf.tooldef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tool Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.tooldef.ToolGroup#isCollapsible <em>Collapsible</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.tooldef.ToolGroup#isStack <em>Stack</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.tooldef.ToolGroup#getActive <em>Active</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.tooldef.GMFToolPackage#getToolGroup()
 * @model
 * @generated
 */
public interface ToolGroup extends ToolContainer {

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
	 * @see org.eclipse.papyrus.gmf.tooldef.GMFToolPackage#getToolGroup_Collapsible()
	 * @model
	 * @generated
	 */
	boolean isCollapsible();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.tooldef.ToolGroup#isCollapsible <em>Collapsible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collapsible</em>' attribute.
	 * @see #isCollapsible()
	 * @generated
	 */
	void setCollapsible(boolean value);

	/**
	 * Returns the value of the '<em><b>Stack</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stack</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stack</em>' attribute.
	 * @see #setStack(boolean)
	 * @see org.eclipse.papyrus.gmf.tooldef.GMFToolPackage#getToolGroup_Stack()
	 * @model
	 * @generated
	 */
	boolean isStack();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.tooldef.ToolGroup#isStack <em>Stack</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stack</em>' attribute.
	 * @see #isStack()
	 * @generated
	 */
	void setStack(boolean value);

	/**
	 * Returns the value of the '<em><b>Active</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active</em>' reference.
	 * @see #setActive(AbstractTool)
	 * @see org.eclipse.papyrus.gmf.tooldef.GMFToolPackage#getToolGroup_Active()
	 * @model
	 * @generated
	 */
	AbstractTool getActive();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.tooldef.ToolGroup#getActive <em>Active</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active</em>' reference.
	 * @see #getActive()
	 * @generated
	 */
	void setActive(AbstractTool value);

} // ToolGroup
