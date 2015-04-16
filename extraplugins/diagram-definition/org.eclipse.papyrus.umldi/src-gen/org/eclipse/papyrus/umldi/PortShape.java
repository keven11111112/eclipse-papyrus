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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.PortShape#getElementWithPortsShape <em>Element With Ports Shape</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getPortShape()
 * @model
 * @generated
 */
public interface PortShape extends ElementShape {
	/**
	 * Returns the value of the '<em><b>Element With Ports Shape</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.ElementWithPortsShape#getPortShape <em>Port Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwningUmlDiagramElement() <em>Owning Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element With Ports Shape</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element With Ports Shape</em>' container reference.
	 * @see #setElementWithPortsShape(ElementWithPortsShape)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getPortShape_ElementWithPortsShape()
	 * @see org.eclipse.papyrus.umldi.ElementWithPortsShape#getPortShape
	 * @model opposite="portShape" transient="false" ordered="false"
	 * @generated
	 */
	ElementWithPortsShape getElementWithPortsShape();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.PortShape#getElementWithPortsShape <em>Element With Ports Shape</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element With Ports Shape</em>' container reference.
	 * @see #getElementWithPortsShape()
	 * @generated
	 */
	void setElementWithPortsShape(ElementWithPortsShape value);

} // PortShape
