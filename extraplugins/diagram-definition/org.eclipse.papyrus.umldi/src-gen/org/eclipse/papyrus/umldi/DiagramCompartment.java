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
 * A representation of the model object '<em><b>Diagram Compartment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.DiagramCompartment#getTopUmlDiagramElement <em>Top Uml Diagram Element</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getDiagramCompartment()
 * @model abstract="true"
 * @generated
 */
public interface DiagramCompartment extends UmlCompartment {

	/**
	 * Returns the value of the '<em><b>Top Uml Diagram Element</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.umldi.TopUmlDiagramElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.TopUmlDiagramElement#getDiagramCompartment
	 * <em>Diagram Compartment</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top Uml Diagram Element</em>' containment reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Top Uml Diagram Element</em>' containment reference list.
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getDiagramCompartment_TopUmlDiagramElement()
	 * @see org.eclipse.papyrus.umldi.TopUmlDiagramElement#getDiagramCompartment
	 * @model opposite="diagramCompartment" containment="true"
	 * @generated
	 */
	EList<TopUmlDiagramElement> getTopUmlDiagramElement();
} // DiagramCompartment
