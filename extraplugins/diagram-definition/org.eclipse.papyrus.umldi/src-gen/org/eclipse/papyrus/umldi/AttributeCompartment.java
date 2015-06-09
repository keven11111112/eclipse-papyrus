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
 * A representation of the model object '<em><b>Attribute Compartment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.AttributeCompartment#getClassifierWithAttributesShape <em>Classifier With Attributes Shape</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getAttributeCompartment()
 * @model
 * @generated
 */
public interface AttributeCompartment extends ListCompartment {

	/**
	 * Returns the value of the '<em><b>Classifier With Attributes Shape</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.ClassifierWithAttributesShape#getAttributeCompartment
	 * <em>Attribute Compartment</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwningUmlDiagramElement() <em>Owning Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifier With Attributes Shape</em>' container reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Classifier With Attributes Shape</em>' container reference.
	 * @see #setClassifierWithAttributesShape(ClassifierWithAttributesShape)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getAttributeCompartment_ClassifierWithAttributesShape()
	 * @see org.eclipse.papyrus.umldi.ClassifierWithAttributesShape#getAttributeCompartment
	 * @model opposite="attributeCompartment" transient="false" ordered="false"
	 * @generated
	 */
	ClassifierWithAttributesShape getClassifierWithAttributesShape();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.AttributeCompartment#getClassifierWithAttributesShape
	 * <em>Classifier With Attributes Shape</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Classifier With Attributes Shape</em>' container reference.
	 * @see #getClassifierWithAttributesShape()
	 * @generated
	 */
	void setClassifierWithAttributesShape(ClassifierWithAttributesShape value);
} // AttributeCompartment
