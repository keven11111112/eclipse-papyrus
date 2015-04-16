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
 * A representation of the model object '<em><b>Selection Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.SelectionLabel#getObjectFlowEdge <em>Object Flow Edge</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.SelectionLabel#getObjectNodeShape <em>Object Node Shape</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getSelectionLabel()
 * @model
 * @generated
 */
public interface SelectionLabel extends UmlLabel {
	/**
	 * Returns the value of the '<em><b>Object Flow Edge</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.ObjectFlowEdge#getSelectionLabel <em>Selection Label</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwningUmlDiagramElement() <em>Owning Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Flow Edge</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Flow Edge</em>' container reference.
	 * @see #setObjectFlowEdge(ObjectFlowEdge)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getSelectionLabel_ObjectFlowEdge()
	 * @see org.eclipse.papyrus.umldi.ObjectFlowEdge#getSelectionLabel
	 * @model opposite="selectionLabel" transient="false" ordered="false"
	 * @generated
	 */
	ObjectFlowEdge getObjectFlowEdge();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.SelectionLabel#getObjectFlowEdge <em>Object Flow Edge</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Flow Edge</em>' container reference.
	 * @see #getObjectFlowEdge()
	 * @generated
	 */
	void setObjectFlowEdge(ObjectFlowEdge value);

	/**
	 * Returns the value of the '<em><b>Object Node Shape</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.ObjectNodeShape#getSelectionLabel <em>Selection Label</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwningUmlDiagramElement() <em>Owning Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Node Shape</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Node Shape</em>' container reference.
	 * @see #setObjectNodeShape(ObjectNodeShape)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getSelectionLabel_ObjectNodeShape()
	 * @see org.eclipse.papyrus.umldi.ObjectNodeShape#getSelectionLabel
	 * @model opposite="selectionLabel" transient="false" ordered="false"
	 * @generated
	 */
	ObjectNodeShape getObjectNodeShape();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.SelectionLabel#getObjectNodeShape <em>Object Node Shape</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Node Shape</em>' container reference.
	 * @see #getObjectNodeShape()
	 * @generated
	 */
	void setObjectNodeShape(ObjectNodeShape value);

} // SelectionLabel
