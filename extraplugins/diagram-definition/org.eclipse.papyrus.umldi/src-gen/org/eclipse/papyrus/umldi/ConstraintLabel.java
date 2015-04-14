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
 * A representation of the model object '<em><b>Constraint Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.ConstraintLabel#getAssociationEdge <em>Association Edge</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.ConstraintLabel#getGeneralizationSetEdge <em>Generalization Set Edge</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.ConstraintLabel#getObjectNodeShape <em>Object Node Shape</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.ConstraintLabel#getPropertyEdge <em>Property Edge</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getConstraintLabel()
 * @model
 * @generated
 */
public interface ConstraintLabel extends UmlLabel {
	/**
	 * Returns the value of the '<em><b>Association Edge</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.AssociationEdge#getEndConstraintLabel <em>End Constraint Label</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwningUmlDiagramElement() <em>Owning Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association Edge</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association Edge</em>' container reference.
	 * @see #setAssociationEdge(AssociationEdge)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getConstraintLabel_AssociationEdge()
	 * @see org.eclipse.papyrus.umldi.AssociationEdge#getEndConstraintLabel
	 * @model opposite="endConstraintLabel" transient="false" ordered="false"
	 * @generated
	 */
	AssociationEdge getAssociationEdge();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.ConstraintLabel#getAssociationEdge <em>Association Edge</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Association Edge</em>' container reference.
	 * @see #getAssociationEdge()
	 * @generated
	 */
	void setAssociationEdge(AssociationEdge value);

	/**
	 * Returns the value of the '<em><b>Generalization Set Edge</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.GeneralizationSetEdge#getConstraintLabel <em>Constraint Label</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwningUmlDiagramElement() <em>Owning Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generalization Set Edge</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generalization Set Edge</em>' container reference.
	 * @see #setGeneralizationSetEdge(GeneralizationSetEdge)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getConstraintLabel_GeneralizationSetEdge()
	 * @see org.eclipse.papyrus.umldi.GeneralizationSetEdge#getConstraintLabel
	 * @model opposite="constraintLabel" transient="false" ordered="false"
	 * @generated
	 */
	GeneralizationSetEdge getGeneralizationSetEdge();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.ConstraintLabel#getGeneralizationSetEdge <em>Generalization Set Edge</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generalization Set Edge</em>' container reference.
	 * @see #getGeneralizationSetEdge()
	 * @generated
	 */
	void setGeneralizationSetEdge(GeneralizationSetEdge value);

	/**
	 * Returns the value of the '<em><b>Object Node Shape</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.ObjectNodeShape#getConstraintLabel <em>Constraint Label</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwningUmlDiagramElement() <em>Owning Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Node Shape</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Node Shape</em>' container reference.
	 * @see #setObjectNodeShape(ObjectNodeShape)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getConstraintLabel_ObjectNodeShape()
	 * @see org.eclipse.papyrus.umldi.ObjectNodeShape#getConstraintLabel
	 * @model opposite="constraintLabel" transient="false" ordered="false"
	 * @generated
	 */
	ObjectNodeShape getObjectNodeShape();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.ConstraintLabel#getObjectNodeShape <em>Object Node Shape</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Node Shape</em>' container reference.
	 * @see #getObjectNodeShape()
	 * @generated
	 */
	void setObjectNodeShape(ObjectNodeShape value);

	/**
	 * Returns the value of the '<em><b>Property Edge</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.PropertyEdge#getConstraintLabel <em>Constraint Label</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwningUmlDiagramElement() <em>Owning Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Edge</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Edge</em>' container reference.
	 * @see #setPropertyEdge(PropertyEdge)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getConstraintLabel_PropertyEdge()
	 * @see org.eclipse.papyrus.umldi.PropertyEdge#getConstraintLabel
	 * @model opposite="constraintLabel" transient="false" ordered="false"
	 * @generated
	 */
	PropertyEdge getPropertyEdge();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.ConstraintLabel#getPropertyEdge <em>Property Edge</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Edge</em>' container reference.
	 * @see #getPropertyEdge()
	 * @generated
	 */
	void setPropertyEdge(PropertyEdge value);

} // ConstraintLabel
