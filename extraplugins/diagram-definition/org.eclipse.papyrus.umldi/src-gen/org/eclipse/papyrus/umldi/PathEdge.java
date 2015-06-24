/**
 * Copyright (c) 2014 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.umldi;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Path Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.PathEdge#getMessageLabel <em>Message Label</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getPathEdge()
 * @model
 * @generated
 */
public interface PathEdge extends UmlEdge {

	/**
	 * Returns the value of the '<em><b>Message Label</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.umldi.MessageLabel}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.MessageLabel#getPathEdge <em>Path Edge</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Label</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Message Label</em>' containment reference list.
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getPathEdge_MessageLabel()
	 * @see org.eclipse.papyrus.umldi.MessageLabel#getPathEdge
	 * @model opposite="pathEdge" containment="true"
	 * @generated
	 */
	EList<MessageLabel> getMessageLabel();
} // PathEdge
