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
 * A representation of the model object '<em><b>List Compartment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.ListCompartment#getListItemLabel <em>List Item Label</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getListCompartment()
 * @model abstract="true"
 * @generated
 */
public interface ListCompartment extends UmlCompartment {
	/**
	 * Returns the value of the '<em><b>List Item Label</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.umldi.ListItemLabel}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.ListItemLabel#getListCompartment <em>List Compartment</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List Item Label</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List Item Label</em>' containment reference list.
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getListCompartment_ListItemLabel()
	 * @see org.eclipse.papyrus.umldi.ListItemLabel#getListCompartment
	 * @model opposite="listCompartment" containment="true"
	 * @generated
	 */
	EList<ListItemLabel> getListItemLabel();

} // ListCompartment
