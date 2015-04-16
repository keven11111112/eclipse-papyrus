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
 * A representation of the model object '<em><b>Reception Compartment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.ReceptionCompartment#getClassifierWithReceptionShape <em>Classifier With Reception Shape</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getReceptionCompartment()
 * @model
 * @generated
 */
public interface ReceptionCompartment extends ListCompartment {
	/**
	 * Returns the value of the '<em><b>Classifier With Reception Shape</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.ClassifierWithReceptionsShape#getReceptionCompartment <em>Reception Compartment</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwningUmlDiagramElement() <em>Owning Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifier With Reception Shape</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classifier With Reception Shape</em>' container reference.
	 * @see #setClassifierWithReceptionShape(ClassifierWithReceptionsShape)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getReceptionCompartment_ClassifierWithReceptionShape()
	 * @see org.eclipse.papyrus.umldi.ClassifierWithReceptionsShape#getReceptionCompartment
	 * @model opposite="receptionCompartment" transient="false" ordered="false"
	 * @generated
	 */
	ClassifierWithReceptionsShape getClassifierWithReceptionShape();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.ReceptionCompartment#getClassifierWithReceptionShape <em>Classifier With Reception Shape</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classifier With Reception Shape</em>' container reference.
	 * @see #getClassifierWithReceptionShape()
	 * @generated
	 */
	void setClassifierWithReceptionShape(ClassifierWithReceptionsShape value);

} // ReceptionCompartment
