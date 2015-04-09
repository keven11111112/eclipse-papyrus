/**
 * Copyright (c) 2015 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram Expansion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.DiagramExpansion#getUsages <em>Usages</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.DiagramExpansion#getLibraries <em>Libraries</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionmodelPackage#getDiagramExpansion()
 * @model
 * @generated
 */
public interface DiagramExpansion extends EObject {
	/**
	 * Returns the value of the '<em><b>Usages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.UseContext}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usages</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionmodelPackage#getDiagramExpansion_Usages()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<UseContext> getUsages();

	/**
	 * Returns the value of the '<em><b>Libraries</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Library}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Libraries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Libraries</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionmodelPackage#getDiagramExpansion_Libraries()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Library> getLibraries();

} // DiagramExpansion
