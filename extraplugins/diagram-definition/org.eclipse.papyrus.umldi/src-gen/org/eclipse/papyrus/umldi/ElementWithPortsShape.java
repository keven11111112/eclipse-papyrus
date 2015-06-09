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
 * A representation of the model object '<em><b>Element With Ports Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.ElementWithPortsShape#getPortShape <em>Port Shape</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getElementWithPortsShape()
 * @model abstract="true"
 * @generated
 */
public interface ElementWithPortsShape extends ElementWithStructureShape {

	/**
	 * Returns the value of the '<em><b>Port Shape</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.umldi.PortShape}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.PortShape#getElementWithPortsShape <em>Element With Ports Shape</em>}
	 * '.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Shape</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Port Shape</em>' containment reference list.
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getElementWithPortsShape_PortShape()
	 * @see org.eclipse.papyrus.umldi.PortShape#getElementWithPortsShape
	 * @model opposite="elementWithPortsShape" containment="true"
	 * @generated
	 */
	EList<PortShape> getPortShape();
} // ElementWithPortsShape
