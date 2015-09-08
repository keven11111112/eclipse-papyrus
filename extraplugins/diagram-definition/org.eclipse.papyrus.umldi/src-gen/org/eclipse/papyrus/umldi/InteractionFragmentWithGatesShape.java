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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interaction Fragment With Gates Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.InteractionFragmentWithGatesShape#getGateShape <em>Gate Shape</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getInteractionFragmentWithGatesShape()
 * @model abstract="true"
 * @generated
 */
public interface InteractionFragmentWithGatesShape extends InteractionFragmentShape {

	/**
	 * Returns the value of the '<em><b>Gate Shape</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.umldi.GateShape}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.GateShape#getInteractionFragmentWithGatesShape
	 * <em>Interaction Fragment With Gates Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gate Shape</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Gate Shape</em>' containment reference list.
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getInteractionFragmentWithGatesShape_GateShape()
	 * @see org.eclipse.papyrus.umldi.GateShape#getInteractionFragmentWithGatesShape
	 * @model opposite="interactionFragmentWithGatesShape" containment="true"
	 * @generated
	 */
	EList<GateShape> getGateShape();
} // InteractionFragmentWithGatesShape
