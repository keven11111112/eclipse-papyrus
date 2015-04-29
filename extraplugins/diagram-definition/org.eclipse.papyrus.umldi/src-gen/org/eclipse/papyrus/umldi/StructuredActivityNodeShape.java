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
 * A representation of the model object '<em><b>Structured Activity Node Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.StructuredActivityNodeShape#getContentCompartment <em>Content Compartment</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getStructuredActivityNodeShape()
 * @model
 * @generated
 */
public interface StructuredActivityNodeShape extends ActionShape, ActivityGroupShape {
	/**
	 * Returns the value of the '<em><b>Content Compartment</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.ContentCompartment#getStructuredActivityNodeShape <em>Structured Activity Node Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content Compartment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content Compartment</em>' containment reference.
	 * @see #setContentCompartment(ContentCompartment)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getStructuredActivityNodeShape_ContentCompartment()
	 * @see org.eclipse.papyrus.umldi.ContentCompartment#getStructuredActivityNodeShape
	 * @model opposite="structuredActivityNodeShape" containment="true" ordered="false"
	 * @generated
	 */
	ContentCompartment getContentCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.StructuredActivityNodeShape#getContentCompartment <em>Content Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content Compartment</em>' containment reference.
	 * @see #getContentCompartment()
	 * @generated
	 */
	void setContentCompartment(ContentCompartment value);

} // StructuredActivityNodeShape
