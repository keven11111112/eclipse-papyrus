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
 * A representation of the model object '<em><b>Collaboration Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.CollaborationShape#getReceptionCompartment <em>Reception Compartment</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getCollaborationShape()
 * @model
 * @generated
 */
public interface CollaborationShape extends ClassifierWithOperationsShape, BehavioredClassifierShape, ElementWithStructureShape {

	/**
	 * Returns the value of the '<em><b>Reception Compartment</b></em>' containment reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reception Compartment</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Reception Compartment</em>' containment reference.
	 * @see #setReceptionCompartment(ReceptionCompartment)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getCollaborationShape_ReceptionCompartment()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	ReceptionCompartment getReceptionCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.CollaborationShape#getReceptionCompartment <em>Reception Compartment</em>}' containment
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Reception Compartment</em>' containment reference.
	 * @see #getReceptionCompartment()
	 * @generated
	 */
	void setReceptionCompartment(ReceptionCompartment value);
} // CollaborationShape
