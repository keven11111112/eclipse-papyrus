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
 * A representation of the model object '<em><b>Gate Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.GateShape#getInteractionFragmentWithGatesShape <em>Interaction Fragment With Gates Shape</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getGateShape()
 * @model
 * @generated
 */
public interface GateShape extends ElementShape {

	/**
	 * Returns the value of the '<em><b>Interaction Fragment With Gates Shape</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.InteractionFragmentWithGatesShape#getGateShape <em>Gate Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwningUmlDiagramElement() <em>Owning Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interaction Fragment With Gates Shape</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Interaction Fragment With Gates Shape</em>' container reference.
	 * @see #setInteractionFragmentWithGatesShape(InteractionFragmentWithGatesShape)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getGateShape_InteractionFragmentWithGatesShape()
	 * @see org.eclipse.papyrus.umldi.InteractionFragmentWithGatesShape#getGateShape
	 * @model opposite="gateShape" transient="false" ordered="false"
	 * @generated
	 */
	InteractionFragmentWithGatesShape getInteractionFragmentWithGatesShape();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.GateShape#getInteractionFragmentWithGatesShape
	 * <em>Interaction Fragment With Gates Shape</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Interaction Fragment With Gates Shape</em>' container reference.
	 * @see #getInteractionFragmentWithGatesShape()
	 * @generated
	 */
	void setInteractionFragmentWithGatesShape(InteractionFragmentWithGatesShape value);
} // GateShape
