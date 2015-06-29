/**
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.migration.rsa.diagramholder;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.gmf.runtime.notation.Diagram;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram Holder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.migration.rsa.diagramholder.DiagramHolder#getOwnedDiagrams <em>Owned Diagrams</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rsa.diagramholder.DiagramHolderPackage#getDiagramHolder()
 * @model
 * @generated
 */
public interface DiagramHolder extends EAnnotation {
	/**
	 * Returns the value of the '<em><b>Owned Diagrams</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.runtime.notation.Diagram}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Diagrams</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Diagrams</em>' reference list.
	 * @see org.eclipse.papyrus.migration.rsa.diagramholder.DiagramHolderPackage#getDiagramHolder_OwnedDiagrams()
	 * @model
	 * @generated
	 */
	EList<Diagram> getOwnedDiagrams();

} // DiagramHolder
