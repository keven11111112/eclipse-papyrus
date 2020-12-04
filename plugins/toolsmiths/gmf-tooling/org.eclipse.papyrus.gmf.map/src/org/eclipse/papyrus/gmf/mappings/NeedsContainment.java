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
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Needs Containment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.NeedsContainment#getContainmentFeature <em>Containment Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getNeedsContainment()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface NeedsContainment extends EObject {
	/**
	 * Returns the value of the '<em><b>Containment Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containment Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containment Feature</em>' reference.
	 * @see #setContainmentFeature(EReference)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getNeedsContainment_ContainmentFeature()
	 * @model annotation="http://www.eclipse.org/gmf/2005/constraints ocl='not containmentFeature.oclIsUndefined() implies containmentFeature.containment' description='Containment EReference expected'"
	 * @generated
	 */
	EReference getContainmentFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.NeedsContainment#getContainmentFeature <em>Containment Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containment Feature</em>' reference.
	 * @see #getContainmentFeature()
	 * @generated
	 */
	void setContainmentFeature(EReference value);

} // NeedsContainment
