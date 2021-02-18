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

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Notation Element Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Target for rules applied on diagram notation model elements
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.NotationElementTarget#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getNotationElementTarget()
 * @model annotation="http://www.eclipse.org/gmf/2005/constraints/meta def='context' ocl='element'"
 * @generated
 */
public interface NotationElementTarget extends Auditable, Measurable {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Targeted diagram notation model element
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(EClass)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getNotationElementTarget_Element()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/gmf/2005/constraints ocl='element.eAllSuperTypes->including(element)->one(ePackage.name = \'notation\' and name = \'View\')' description='\'notation::View\' or its sub-class must be set to NotationElement target'"
	 * @generated
	 */
	EClass getElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.NotationElementTarget#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(EClass value);

} // NotationElementTarget
