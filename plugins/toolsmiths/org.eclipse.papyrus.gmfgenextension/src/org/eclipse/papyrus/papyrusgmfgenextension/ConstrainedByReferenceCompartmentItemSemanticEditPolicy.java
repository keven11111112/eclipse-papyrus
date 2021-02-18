/**
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *   CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.papyrusgmfgenextension;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.gmf.codegen.gmfgen.GenCommonBase;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constrained By Reference Compartment Item Semantic Edit Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.ConstrainedByReferenceCompartmentItemSemanticEditPolicy#getGenView <em>Gen View</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getConstrainedByReferenceCompartmentItemSemanticEditPolicy()
 * @model annotation="http://www.eclipse.org/emf/2002/GenModel Documentation='Add constraint on Compartment Item Semantic Policy in order to prevent move into compartment of elements which can be contained. This constraint used the child node define in the GMF Model in order to define the correspoding EReference. When a move is executed the item semantic policy will fisrt check that the element can be conatined/referenced by this EReference?'"
 * @generated
 */
public interface ConstrainedByReferenceCompartmentItemSemanticEditPolicy extends CommentedElement {
	/**
	 * Returns the value of the '<em><b>Gen View</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.gmf.codegen.gmfgen.GenCommonBase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen View</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen View</em>' reference list.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getConstrainedByReferenceCompartmentItemSemanticEditPolicy_GenView()
	 * @model
	 * @generated
	 */
	EList<GenCommonBase> getGenView();

} // ConstrainedByReferenceCompartmentItemSemanticEditPolicy
