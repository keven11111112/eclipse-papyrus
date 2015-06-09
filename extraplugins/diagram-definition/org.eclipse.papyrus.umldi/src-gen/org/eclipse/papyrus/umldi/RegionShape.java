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
 * A representation of the model object '<em><b>Region Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.RegionShape#getPlacement <em>Placement</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.RegionShape#getSubvertexCompartment <em>Subvertex Compartment</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getRegionShape()
 * @model
 * @generated
 */
public interface RegionShape extends ElementShape {

	/**
	 * Returns the value of the '<em><b>Placement</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.papyrus.umldi.Placement}.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.umldi.Placement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Placement</em>' attribute list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Placement</em>' attribute list.
	 * @see org.eclipse.papyrus.umldi.Placement
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getRegionShape_Placement()
	 * @model unique="false"
	 * @generated
	 */
	EList<Placement> getPlacement();

	/**
	 * Returns the value of the '<em><b>Subvertex Compartment</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.SubvertexCompartment#getRegionShape <em>Region Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subvertex Compartment</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Subvertex Compartment</em>' containment reference.
	 * @see #setSubvertexCompartment(SubvertexCompartment)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getRegionShape_SubvertexCompartment()
	 * @see org.eclipse.papyrus.umldi.SubvertexCompartment#getRegionShape
	 * @model opposite="regionShape" containment="true" ordered="false"
	 * @generated
	 */
	SubvertexCompartment getSubvertexCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.RegionShape#getSubvertexCompartment <em>Subvertex Compartment</em>}' containment
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Subvertex Compartment</em>' containment reference.
	 * @see #getSubvertexCompartment()
	 * @generated
	 */
	void setSubvertexCompartment(SubvertexCompartment value);
} // RegionShape
