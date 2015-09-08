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
 * A representation of the model object '<em><b>Classifier With Nested Classifiers Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.ClassifierWithNestedClassifiersShape#getNestedClassifierCompartment <em>Nested Classifier Compartment</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getClassifierWithNestedClassifiersShape()
 * @model abstract="true"
 * @generated
 */
public interface ClassifierWithNestedClassifiersShape extends ClassifierWithReceptionsShape {

	/**
	 * Returns the value of the '<em><b>Nested Classifier Compartment</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.NestedClassifierCompartment#getClassifierWithNestedClassifiersShape
	 * <em>Classifier With Nested Classifiers Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested Classifier Compartment</em>' containment reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Nested Classifier Compartment</em>' containment reference.
	 * @see #setNestedClassifierCompartment(NestedClassifierCompartment)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getClassifierWithNestedClassifiersShape_NestedClassifierCompartment()
	 * @see org.eclipse.papyrus.umldi.NestedClassifierCompartment#getClassifierWithNestedClassifiersShape
	 * @model opposite="classifierWithNestedClassifiersShape" containment="true" ordered="false"
	 * @generated
	 */
	NestedClassifierCompartment getNestedClassifierCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.ClassifierWithNestedClassifiersShape#getNestedClassifierCompartment
	 * <em>Nested Classifier Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Nested Classifier Compartment</em>' containment reference.
	 * @see #getNestedClassifierCompartment()
	 * @generated
	 */
	void setNestedClassifierCompartment(NestedClassifierCompartment value);
} // ClassifierWithNestedClassifiersShape
