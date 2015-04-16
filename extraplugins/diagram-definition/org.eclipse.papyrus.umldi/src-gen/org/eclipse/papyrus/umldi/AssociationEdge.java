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
 * A representation of the model object '<em><b>Association Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.AssociationEdge#getEndMultiplicityLabel <em>End Multiplicity Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.AssociationEdge#getEndConstraintLabel <em>End Constraint Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.AssociationEdge#getEndRoleLabel <em>End Role Label</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getAssociationEdge()
 * @model
 * @generated
 */
public interface AssociationEdge extends ElementEdge {
	/**
	 * Returns the value of the '<em><b>End Multiplicity Label</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.umldi.MultiplicityLabel}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.MultiplicityLabel#getAssociationEdge <em>Association Edge</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Multiplicity Label</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Multiplicity Label</em>' containment reference list.
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getAssociationEdge_EndMultiplicityLabel()
	 * @see org.eclipse.papyrus.umldi.MultiplicityLabel#getAssociationEdge
	 * @model opposite="associationEdge" containment="true" upper="2" ordered="false"
	 * @generated
	 */
	EList<MultiplicityLabel> getEndMultiplicityLabel();

	/**
	 * Returns the value of the '<em><b>End Constraint Label</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.umldi.ConstraintLabel}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.ConstraintLabel#getAssociationEdge <em>Association Edge</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Constraint Label</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Constraint Label</em>' containment reference list.
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getAssociationEdge_EndConstraintLabel()
	 * @see org.eclipse.papyrus.umldi.ConstraintLabel#getAssociationEdge
	 * @model opposite="associationEdge" containment="true" upper="2" ordered="false"
	 * @generated
	 */
	EList<ConstraintLabel> getEndConstraintLabel();

	/**
	 * Returns the value of the '<em><b>End Role Label</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.umldi.RoleLabel}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.RoleLabel#getAssociationEdge <em>Association Edge</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Role Label</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Role Label</em>' containment reference list.
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getAssociationEdge_EndRoleLabel()
	 * @see org.eclipse.papyrus.umldi.RoleLabel#getAssociationEdge
	 * @model opposite="associationEdge" containment="true" upper="2" ordered="false"
	 * @generated
	 */
	EList<RoleLabel> getEndRoleLabel();

} // AssociationEdge
