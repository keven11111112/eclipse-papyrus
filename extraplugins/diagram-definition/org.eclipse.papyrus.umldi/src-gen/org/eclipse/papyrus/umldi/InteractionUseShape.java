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
 * A representation of the model object '<em><b>Interaction Use Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.InteractionUseShape#getTypeLabel <em>Type Label</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getInteractionUseShape()
 * @model
 * @generated
 */
public interface InteractionUseShape extends InteractionFragmentWithGatesShape {

	/**
	 * Returns the value of the '<em><b>Type Label</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.TypeLabel#getInteractionUseShape <em>Interaction Use Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Label</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type Label</em>' containment reference.
	 * @see #setTypeLabel(TypeLabel)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getInteractionUseShape_TypeLabel()
	 * @see org.eclipse.papyrus.umldi.TypeLabel#getInteractionUseShape
	 * @model opposite="interactionUseShape" containment="true" ordered="false"
	 * @generated
	 */
	TypeLabel getTypeLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.InteractionUseShape#getTypeLabel <em>Type Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Type Label</em>' containment reference.
	 * @see #getTypeLabel()
	 * @generated
	 */
	void setTypeLabel(TypeLabel value);
} // InteractionUseShape
