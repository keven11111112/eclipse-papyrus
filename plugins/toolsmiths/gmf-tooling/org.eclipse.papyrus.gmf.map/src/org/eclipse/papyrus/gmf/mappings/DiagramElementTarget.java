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
 * A representation of the model object '<em><b>Diagram Element Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Target for rules applied on diagram notation model selectively, for specific visualized element
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.DiagramElementTarget#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getDiagramElementTarget()
 * @model annotation="http://www.eclipse.org/gmf/2005/constraints/meta def='context' ocl='if element.oclIsKindOf(NodeMapping) then \'notation::Node\' else \'notation::Edge\' endif'"
 * @generated
 */
public interface DiagramElementTarget extends Auditable, Measurable {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Targeted visualized element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(MappingEntry)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getDiagramElementTarget_Element()
	 * @model required="true"
	 * @generated
	 */
	MappingEntry getElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.DiagramElementTarget#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(MappingEntry value);

} // DiagramElementTarget
