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
package org.eclipse.papyrus.gmf.internal.bridge.trace;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenLink;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Link Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.internal.bridge.trace.GenLinkTrace#getLinkLabelTraces <em>Link Label Traces</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.internal.bridge.trace.TracePackage#getGenLinkTrace()
 * @model
 * @generated
 */
public interface GenLinkTrace extends MatchingTrace {
	/**
	 * Returns the value of the '<em><b>Link Label Traces</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.gmf.internal.bridge.trace.GenLinkLabelTrace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Label Traces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link Label Traces</em>' containment reference list.
	 * @see org.eclipse.papyrus.gmf.internal.bridge.trace.TracePackage#getGenLinkTrace_LinkLabelTraces()
	 * @model type="org.eclipse.papyrus.gmf.internal.bridge.trace.GenLinkLabelTrace" containment="true"
	 * @generated
	 */
	EList<GenLinkLabelTrace> getLinkLabelTraces();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setContext(GenLink genLink);

} // GenLinkTrace
