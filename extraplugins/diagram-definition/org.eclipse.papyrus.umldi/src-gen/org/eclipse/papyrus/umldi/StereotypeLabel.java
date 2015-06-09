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
 * A representation of the model object '<em><b>Stereotype Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.StereotypeLabel#getStereotypedDiagramElement <em>Stereotyped Diagram Element</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getStereotypeLabel()
 * @model
 * @generated
 */
public interface StereotypeLabel extends UmlLabel {

	/**
	 * Returns the value of the '<em><b>Stereotyped Diagram Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.StereotypedDiagramElement#getStereotypeLabel
	 * <em>Stereotype Label</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwningUmlDiagramElement() <em>Owning Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotyped Diagram Element</em>' container reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Stereotyped Diagram Element</em>' container reference.
	 * @see #setStereotypedDiagramElement(StereotypedDiagramElement)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getStereotypeLabel_StereotypedDiagramElement()
	 * @see org.eclipse.papyrus.umldi.StereotypedDiagramElement#getStereotypeLabel
	 * @model opposite="stereotypeLabel" transient="false" ordered="false"
	 * @generated
	 */
	StereotypedDiagramElement getStereotypedDiagramElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.StereotypeLabel#getStereotypedDiagramElement <em>Stereotyped Diagram Element</em>}'
	 * container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Stereotyped Diagram Element</em>' container reference.
	 * @see #getStereotypedDiagramElement()
	 * @generated
	 */
	void setStereotypedDiagramElement(StereotypedDiagramElement value);
} // StereotypeLabel
