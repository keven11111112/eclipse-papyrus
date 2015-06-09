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
 * A representation of the model object '<em><b>Stereotyped Diagram Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.StereotypedDiagramElement#isShowStereotypeAttributes <em>Show Stereotype Attributes</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.StereotypedDiagramElement#getStereotypeLabel <em>Stereotype Label</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getStereotypedDiagramElement()
 * @model abstract="true"
 * @generated
 */
public interface StereotypedDiagramElement extends UmlDiagramElement {

	/**
	 * Returns the value of the '<em><b>Show Stereotype Attributes</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Show Stereotype Attributes</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Show Stereotype Attributes</em>' attribute.
	 * @see #setShowStereotypeAttributes(boolean)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getStereotypedDiagramElement_ShowStereotypeAttributes()
	 * @model default="true" dataType="org.eclipse.papyrus.dd.dc.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isShowStereotypeAttributes();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.StereotypedDiagramElement#isShowStereotypeAttributes
	 * <em>Show Stereotype Attributes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Show Stereotype Attributes</em>' attribute.
	 * @see #isShowStereotypeAttributes()
	 * @generated
	 */
	void setShowStereotypeAttributes(boolean value);

	/**
	 * Returns the value of the '<em><b>Stereotype Label</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.StereotypeLabel#getStereotypedDiagramElement
	 * <em>Stereotyped Diagram Element</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype Label</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Stereotype Label</em>' containment reference.
	 * @see #setStereotypeLabel(StereotypeLabel)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getStereotypedDiagramElement_StereotypeLabel()
	 * @see org.eclipse.papyrus.umldi.StereotypeLabel#getStereotypedDiagramElement
	 * @model opposite="stereotypedDiagramElement" containment="true" ordered="false"
	 * @generated
	 */
	StereotypeLabel getStereotypeLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.StereotypedDiagramElement#getStereotypeLabel <em>Stereotype Label</em>}' containment
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Stereotype Label</em>' containment reference.
	 * @see #getStereotypeLabel()
	 * @generated
	 */
	void setStereotypeLabel(StereotypeLabel value);
} // StereotypedDiagramElement
