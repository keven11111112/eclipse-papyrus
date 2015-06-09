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
 * A representation of the model object '<em><b>Base State Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.BaseStateShape#getConnectionPointShape <em>Connection Point Shape</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.BaseStateShape#getRegionCompartment <em>Region Compartment</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getBaseStateShape()
 * @model abstract="true"
 * @generated
 */
public interface BaseStateShape extends ElementShape {

	/**
	 * Returns the value of the '<em><b>Connection Point Shape</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.umldi.PseudostateShape}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.PseudostateShape#getBaseStateShape <em>Base State Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Point Shape</em>' containment reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Connection Point Shape</em>' containment reference list.
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getBaseStateShape_ConnectionPointShape()
	 * @see org.eclipse.papyrus.umldi.PseudostateShape#getBaseStateShape
	 * @model opposite="baseStateShape" containment="true"
	 * @generated
	 */
	EList<PseudostateShape> getConnectionPointShape();

	/**
	 * Returns the value of the '<em><b>Region Compartment</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.RegionCompartment#getBaseStateShape <em>Base State Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Region Compartment</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Region Compartment</em>' containment reference.
	 * @see #setRegionCompartment(RegionCompartment)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getBaseStateShape_RegionCompartment()
	 * @see org.eclipse.papyrus.umldi.RegionCompartment#getBaseStateShape
	 * @model opposite="baseStateShape" containment="true" ordered="false"
	 * @generated
	 */
	RegionCompartment getRegionCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.BaseStateShape#getRegionCompartment <em>Region Compartment</em>}' containment
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Region Compartment</em>' containment reference.
	 * @see #getRegionCompartment()
	 * @generated
	 */
	void setRegionCompartment(RegionCompartment value);
} // BaseStateShape
