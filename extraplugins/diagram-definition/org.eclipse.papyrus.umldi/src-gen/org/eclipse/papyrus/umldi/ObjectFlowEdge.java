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
 * A representation of the model object '<em><b>Object Flow Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.ObjectFlowEdge#getTransformationLabel <em>Transformation Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.ObjectFlowEdge#getSelectionLabel <em>Selection Label</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getObjectFlowEdge()
 * @model
 * @generated
 */
public interface ObjectFlowEdge extends ActivityEdgeEdge {

	/**
	 * Returns the value of the '<em><b>Transformation Label</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.TransformationLabel#getObjectFlowEdge <em>Object Flow Edge</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation Label</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation Label</em>' containment reference.
	 * @see #setTransformationLabel(TransformationLabel)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getObjectFlowEdge_TransformationLabel()
	 * @see org.eclipse.papyrus.umldi.TransformationLabel#getObjectFlowEdge
	 * @model opposite="objectFlowEdge" containment="true" ordered="false"
	 * @generated
	 */
	TransformationLabel getTransformationLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.ObjectFlowEdge#getTransformationLabel <em>Transformation Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation Label</em>' containment reference.
	 * @see #getTransformationLabel()
	 * @generated
	 */
	void setTransformationLabel(TransformationLabel value);

	/**
	 * Returns the value of the '<em><b>Selection Label</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.SelectionLabel#getObjectFlowEdge <em>Object Flow Edge</em>}'.
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
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getObjectFlowEdge_SelectionLabel()
	 * @see org.eclipse.papyrus.umldi.SelectionLabel#getObjectFlowEdge
	 * @model opposite="objectFlowEdge" containment="true" ordered="false"
	 * @generated
	 */
	SelectionLabel getSelectionLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.ObjectFlowEdge#getSelectionLabel <em>Selection Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selection Label</em>' containment reference.
	 * @see #getSelectionLabel()
	 * @generated
	 */
	void setSelectionLabel(SelectionLabel value);
} // ObjectFlowEdge
