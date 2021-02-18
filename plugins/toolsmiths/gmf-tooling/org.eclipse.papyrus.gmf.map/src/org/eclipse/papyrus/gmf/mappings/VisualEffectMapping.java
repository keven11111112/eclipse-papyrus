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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.gmf.gmfgraph.Pin;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visual Effect Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.VisualEffectMapping#getDiagramPin <em>Diagram Pin</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.VisualEffectMapping#getOclExpression <em>Ocl Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.VisualEffectMapping#getParentMapEntry <em>Parent Map Entry</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getVisualEffectMapping()
 * @model
 * @generated
 */
public interface VisualEffectMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Diagram Pin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Pin</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram Pin</em>' reference.
	 * @see #setDiagramPin(Pin)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getVisualEffectMapping_DiagramPin()
	 * @model required="true"
	 * @generated
	 */
	Pin getDiagramPin();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.VisualEffectMapping#getDiagramPin <em>Diagram Pin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram Pin</em>' reference.
	 * @see #getDiagramPin()
	 * @generated
	 */
	void setDiagramPin(Pin value);

	/**
	 * Returns the value of the '<em><b>Ocl Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ocl Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ocl Expression</em>' attribute.
	 * @see #setOclExpression(String)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getVisualEffectMapping_OclExpression()
	 * @model
	 * @generated
	 */
	String getOclExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.VisualEffectMapping#getOclExpression <em>Ocl Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocl Expression</em>' attribute.
	 * @see #getOclExpression()
	 * @generated
	 */
	void setOclExpression(String value);

	/**
	 * Returns the value of the '<em><b>Parent Map Entry</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.gmf.mappings.MappingEntry#getVisualEffects <em>Visual Effects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Map Entry</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Map Entry</em>' container reference.
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getVisualEffectMapping_ParentMapEntry()
	 * @see org.eclipse.papyrus.gmf.mappings.MappingEntry#getVisualEffects
	 * @model opposite="visualEffects" required="true" transient="false" changeable="false"
	 * @generated
	 */
	MappingEntry getParentMapEntry();

} // VisualEffectMapping
