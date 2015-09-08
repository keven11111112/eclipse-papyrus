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
 * A representation of the model object '<em><b>Information Flow Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.InformationFlowEdge#getConveyedLabel <em>Conveyed Label</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getInformationFlowEdge()
 * @model
 * @generated
 */
public interface InformationFlowEdge extends ElementEdge {

	/**
	 * Returns the value of the '<em><b>Conveyed Label</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.ConveyedLabel#getInformationFlowEdge <em>Information Flow Edge</em>}
	 * '.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conveyed Label</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Conveyed Label</em>' containment reference.
	 * @see #setConveyedLabel(ConveyedLabel)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getInformationFlowEdge_ConveyedLabel()
	 * @see org.eclipse.papyrus.umldi.ConveyedLabel#getInformationFlowEdge
	 * @model opposite="informationFlowEdge" containment="true" ordered="false"
	 * @generated
	 */
	ConveyedLabel getConveyedLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.InformationFlowEdge#getConveyedLabel <em>Conveyed Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Conveyed Label</em>' containment reference.
	 * @see #getConveyedLabel()
	 * @generated
	 */
	void setConveyedLabel(ConveyedLabel value);
} // InformationFlowEdge
