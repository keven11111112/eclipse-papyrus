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
 * A representation of the model object '<em><b>Property Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.PropertyEdge#getConstraintLabel <em>Constraint Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.PropertyEdge#getMultiplicityLabel <em>Multiplicity Label</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getPropertyEdge()
 * @model
 * @generated
 */
public interface PropertyEdge extends ElementEdge {
	/**
	 * Returns the value of the '<em><b>Constraint Label</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.ConstraintLabel#getPropertyEdge <em>Property Edge</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Label</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Label</em>' containment reference.
	 * @see #setConstraintLabel(ConstraintLabel)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getPropertyEdge_ConstraintLabel()
	 * @see org.eclipse.papyrus.umldi.ConstraintLabel#getPropertyEdge
	 * @model opposite="propertyEdge" containment="true" ordered="false"
	 * @generated
	 */
	ConstraintLabel getConstraintLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.PropertyEdge#getConstraintLabel <em>Constraint Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Label</em>' containment reference.
	 * @see #getConstraintLabel()
	 * @generated
	 */
	void setConstraintLabel(ConstraintLabel value);

	/**
	 * Returns the value of the '<em><b>Multiplicity Label</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.MultiplicityLabel#getPropertyEdge <em>Property Edge</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplicity Label</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiplicity Label</em>' containment reference.
	 * @see #setMultiplicityLabel(MultiplicityLabel)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getPropertyEdge_MultiplicityLabel()
	 * @see org.eclipse.papyrus.umldi.MultiplicityLabel#getPropertyEdge
	 * @model opposite="propertyEdge" containment="true" ordered="false"
	 * @generated
	 */
	MultiplicityLabel getMultiplicityLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.PropertyEdge#getMultiplicityLabel <em>Multiplicity Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity Label</em>' containment reference.
	 * @see #getMultiplicityLabel()
	 * @generated
	 */
	void setMultiplicityLabel(MultiplicityLabel value);

} // PropertyEdge
