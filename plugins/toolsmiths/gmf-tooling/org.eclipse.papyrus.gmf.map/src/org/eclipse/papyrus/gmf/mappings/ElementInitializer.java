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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Initializer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Base class for initializers of domain model elements
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.ElementInitializer#getMappingEntry <em>Mapping Entry</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getElementInitializer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ElementInitializer extends EObject {
	/**
	 * Returns the value of the '<em><b>Mapping Entry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Entry</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The 'MappingEntry' whose domain model element is to be intialized by this initializer
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mapping Entry</em>' reference.
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getElementInitializer_MappingEntry()
	 * @model required="true" transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	MappingEntry getMappingEntry();

} // ElementInitializer
