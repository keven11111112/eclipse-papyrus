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
 * A representation of the model object '<em><b>Node Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.NodeShape#getNestedNodeCompartment <em>Nested Node Compartment</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getNodeShape()
 * @model
 * @generated
 */
public interface NodeShape extends ClassShape, DeploymentTargetShape {

	/**
	 * Returns the value of the '<em><b>Nested Node Compartment</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.NestedNodeCompartment#getNodeShape <em>Node Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested Node Compartment</em>' containment reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Nested Node Compartment</em>' containment reference.
	 * @see #setNestedNodeCompartment(NestedNodeCompartment)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getNodeShape_NestedNodeCompartment()
	 * @see org.eclipse.papyrus.umldi.NestedNodeCompartment#getNodeShape
	 * @model opposite="nodeShape" containment="true" ordered="false"
	 * @generated
	 */
	NestedNodeCompartment getNestedNodeCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.NodeShape#getNestedNodeCompartment <em>Nested Node Compartment</em>}' containment
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Nested Node Compartment</em>' containment reference.
	 * @see #getNestedNodeCompartment()
	 * @generated
	 */
	void setNestedNodeCompartment(NestedNodeCompartment value);
} // NodeShape
