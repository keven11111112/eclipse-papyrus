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
 * A representation of the model object '<em><b>Interaction Fragment With Subfragments Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.InteractionFragmentWithSubfragmentsShape#getSubfragmentCompartment <em>Subfragment Compartment</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getInteractionFragmentWithSubfragmentsShape()
 * @model abstract="true"
 * @generated
 */
public interface InteractionFragmentWithSubfragmentsShape extends InteractionFragmentShape {

	/**
	 * Returns the value of the '<em><b>Subfragment Compartment</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.SubfragmentCompartment#getInteractionFragmentWithSubfragmentsShape
	 * <em>Interaction Fragment With Subfragments Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subfragment Compartment</em>' containment reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Subfragment Compartment</em>' containment reference.
	 * @see #setSubfragmentCompartment(SubfragmentCompartment)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getInteractionFragmentWithSubfragmentsShape_SubfragmentCompartment()
	 * @see org.eclipse.papyrus.umldi.SubfragmentCompartment#getInteractionFragmentWithSubfragmentsShape
	 * @model opposite="interactionFragmentWithSubfragmentsShape" containment="true" ordered="false"
	 * @generated
	 */
	SubfragmentCompartment getSubfragmentCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.InteractionFragmentWithSubfragmentsShape#getSubfragmentCompartment
	 * <em>Subfragment Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Subfragment Compartment</em>' containment reference.
	 * @see #getSubfragmentCompartment()
	 * @generated
	 */
	void setSubfragmentCompartment(SubfragmentCompartment value);
} // InteractionFragmentWithSubfragmentsShape
