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
 * A representation of the model object '<em><b>Object Node Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.ObjectNodeShape#getSelectionLabel <em>Selection Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.ObjectNodeShape#getConstraintLabel <em>Constraint Label</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getObjectNodeShape()
 * @model
 * @generated
 */
public interface ObjectNodeShape extends ActivityNodeShape {
	/**
	 * Returns the value of the '<em><b>Selection Label</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.SelectionLabel#getObjectNodeShape <em>Object Node Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selection Label</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection Label</em>' containment reference.
	 * @see #setSelectionLabel(SelectionLabel)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getObjectNodeShape_SelectionLabel()
	 * @see org.eclipse.papyrus.umldi.SelectionLabel#getObjectNodeShape
	 * @model opposite="objectNodeShape" containment="true" ordered="false"
	 * @generated
	 */
	SelectionLabel getSelectionLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.ObjectNodeShape#getSelectionLabel <em>Selection Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selection Label</em>' containment reference.
	 * @see #getSelectionLabel()
	 * @generated
	 */
	void setSelectionLabel(SelectionLabel value);

	/**
	 * Returns the value of the '<em><b>Constraint Label</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.ConstraintLabel#getObjectNodeShape <em>Object Node Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Label</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Label</em>' containment reference.
	 * @see #setConstraintLabel(ConstraintLabel)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getObjectNodeShape_ConstraintLabel()
	 * @see org.eclipse.papyrus.umldi.ConstraintLabel#getObjectNodeShape
	 * @model opposite="objectNodeShape" containment="true" ordered="false"
	 * @generated
	 */
	ConstraintLabel getConstraintLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.ObjectNodeShape#getConstraintLabel <em>Constraint Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Label</em>' containment reference.
	 * @see #getConstraintLabel()
	 * @generated
	 */
	void setConstraintLabel(ConstraintLabel value);

} // ObjectNodeShape
