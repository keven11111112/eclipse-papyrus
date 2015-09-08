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
import org.eclipse.papyrus.dd.di.Shape;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Uml Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The most general class for UML diagram elements that are not rendered as lines.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.UmlShape#getStereotypeCompartment <em>Stereotype Compartment</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getUmlShape()
 * @model abstract="true"
 * @generated
 */
public interface UmlShape extends TopUmlDiagramElement, Shape {

	/**
	 * Returns the value of the '<em><b>Stereotype Compartment</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.umldi.StereotypeCompartment}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.StereotypeCompartment#getUmlShape <em>Uml Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype Compartment</em>' containment reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Stereotype Compartment</em>' containment reference list.
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getUmlShape_StereotypeCompartment()
	 * @see org.eclipse.papyrus.umldi.StereotypeCompartment#getUmlShape
	 * @model opposite="umlShape" containment="true"
	 * @generated
	 */
	EList<StereotypeCompartment> getStereotypeCompartment();
} // UmlShape
