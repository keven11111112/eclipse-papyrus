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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pin Owner</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.gmfgraph.PinOwner#getPins <em>Pins</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getPinOwner()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface PinOwner extends EObject {
	/**
	 * Returns the value of the '<em><b>Pins</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.gmf.gmfgraph.Pin}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pins</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pins</em>' containment reference list.
	 * @see org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage#getPinOwner_Pins()
	 * @model containment="true"
	 * @generated
	 */
	EList<Pin> getPins();

} // PinOwner
