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
 * A representation of the model object '<em><b>Action Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.ActionShape#getPinShape <em>Pin Shape</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.ActionShape#getConditionLabel <em>Condition Label</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getActionShape()
 * @model
 * @generated
 */
public interface ActionShape extends ActivityNodeShape {

	/**
	 * Returns the value of the '<em><b>Pin Shape</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.umldi.PinShape}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.PinShape#getActionShape <em>Action Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pin Shape</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Pin Shape</em>' containment reference list.
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getActionShape_PinShape()
	 * @see org.eclipse.papyrus.umldi.PinShape#getActionShape
	 * @model opposite="actionShape" containment="true"
	 * @generated
	 */
	EList<PinShape> getPinShape();

	/**
	 * Returns the value of the '<em><b>Condition Label</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.umldi.ConstraintLabel}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.ConstraintLabel#getActionShape <em>Action Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition Label</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Condition Label</em>' containment reference list.
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getActionShape_ConditionLabel()
	 * @see org.eclipse.papyrus.umldi.ConstraintLabel#getActionShape
	 * @model opposite="actionShape" containment="true"
	 * @generated
	 */
	EList<ConstraintLabel> getConditionLabel();
} // ActionShape
