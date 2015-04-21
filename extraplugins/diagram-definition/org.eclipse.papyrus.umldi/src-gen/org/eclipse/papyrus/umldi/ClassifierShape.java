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
 * A representation of the model object '<em><b>Classifier Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.ClassifierShape#isUseClassifierNotation <em>Use Classifier Notation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.ClassifierShape#getOwnedUseCaseCompartment <em>Owned Use Case Compartment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.ClassifierShape#getUseCaseCompartment <em>Use Case Compartment</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getClassifierShape()
 * @model abstract="true"
 * @generated
 */
public interface ClassifierShape extends TemplateableElementShape {
	/**
	 * Returns the value of the '<em><b>Use Classifier Notation</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Classifier Notation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Classifier Notation</em>' attribute.
	 * @see #setUseClassifierNotation(boolean)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getClassifierShape_UseClassifierNotation()
	 * @model default="true" dataType="org.eclipse.papyrus.dd.dc.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isUseClassifierNotation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.ClassifierShape#isUseClassifierNotation <em>Use Classifier Notation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Classifier Notation</em>' attribute.
	 * @see #isUseClassifierNotation()
	 * @generated
	 */
	void setUseClassifierNotation(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Use Case Compartment</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.OwnedUseCaseCompartment#getClassifierShape <em>Classifier Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Use Case Compartment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Use Case Compartment</em>' containment reference.
	 * @see #setOwnedUseCaseCompartment(OwnedUseCaseCompartment)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getClassifierShape_OwnedUseCaseCompartment()
	 * @see org.eclipse.papyrus.umldi.OwnedUseCaseCompartment#getClassifierShape
	 * @model opposite="classifierShape" containment="true" ordered="false"
	 * @generated
	 */
	OwnedUseCaseCompartment getOwnedUseCaseCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.ClassifierShape#getOwnedUseCaseCompartment <em>Owned Use Case Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Use Case Compartment</em>' containment reference.
	 * @see #getOwnedUseCaseCompartment()
	 * @generated
	 */
	void setOwnedUseCaseCompartment(OwnedUseCaseCompartment value);

	/**
	 * Returns the value of the '<em><b>Use Case Compartment</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.UseCaseCompartment#getClassifierShape <em>Classifier Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Case Compartment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Case Compartment</em>' containment reference.
	 * @see #setUseCaseCompartment(UseCaseCompartment)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getClassifierShape_UseCaseCompartment()
	 * @see org.eclipse.papyrus.umldi.UseCaseCompartment#getClassifierShape
	 * @model opposite="classifierShape" containment="true" ordered="false"
	 * @generated
	 */
	UseCaseCompartment getUseCaseCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.ClassifierShape#getUseCaseCompartment <em>Use Case Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Case Compartment</em>' containment reference.
	 * @see #getUseCaseCompartment()
	 * @generated
	 */
	void setUseCaseCompartment(UseCaseCompartment value);

} // ClassifierShape
