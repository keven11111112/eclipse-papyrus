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
 * A representation of the model object '<em><b>Lifeline Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.LifelineShape#getSubfragmentShape <em>Subfragment Shape</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.LifelineShape#getNestingLifelineShape <em>Nesting Lifeline Shape</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.LifelineShape#getNestedLifelineShape <em>Nested Lifeline Shape</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.LifelineShape#getConstraintLabel <em>Constraint Label</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getLifelineShape()
 * @model
 * @generated
 */
public interface LifelineShape extends ElementShape {

	/**
	 * Returns the value of the '<em><b>Subfragment Shape</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.umldi.InteractionFragmentShape}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.InteractionFragmentShape#getLifelineShape <em>Lifeline Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subfragment Shape</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Subfragment Shape</em>' containment reference list.
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getLifelineShape_SubfragmentShape()
	 * @see org.eclipse.papyrus.umldi.InteractionFragmentShape#getLifelineShape
	 * @model opposite="lifelineShape" containment="true"
	 * @generated
	 */
	EList<InteractionFragmentShape> getSubfragmentShape();

	/**
	 * Returns the value of the '<em><b>Nesting Lifeline Shape</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.LifelineShape#getNestedLifelineShape <em>Nested Lifeline Shape</em>}
	 * '.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwningUmlDiagramElement() <em>Owning Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nesting Lifeline Shape</em>' container reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Nesting Lifeline Shape</em>' container reference.
	 * @see #setNestingLifelineShape(LifelineShape)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getLifelineShape_NestingLifelineShape()
	 * @see org.eclipse.papyrus.umldi.LifelineShape#getNestedLifelineShape
	 * @model opposite="nestedLifelineShape" transient="false" ordered="false"
	 * @generated
	 */
	LifelineShape getNestingLifelineShape();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.LifelineShape#getNestingLifelineShape <em>Nesting Lifeline Shape</em>}' container
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Nesting Lifeline Shape</em>' container reference.
	 * @see #getNestingLifelineShape()
	 * @generated
	 */
	void setNestingLifelineShape(LifelineShape value);

	/**
	 * Returns the value of the '<em><b>Nested Lifeline Shape</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.umldi.LifelineShape}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.LifelineShape#getNestingLifelineShape
	 * <em>Nesting Lifeline Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested Lifeline Shape</em>' containment reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Nested Lifeline Shape</em>' containment reference list.
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getLifelineShape_NestedLifelineShape()
	 * @see org.eclipse.papyrus.umldi.LifelineShape#getNestingLifelineShape
	 * @model opposite="nestingLifelineShape" containment="true"
	 * @generated
	 */
	EList<LifelineShape> getNestedLifelineShape();

	/**
	 * Returns the value of the '<em><b>Constraint Label</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.umldi.ConstraintLabel}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.ConstraintLabel#getLifelineShape <em>Lifeline Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Label</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint Label</em>' containment reference list.
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getLifelineShape_ConstraintLabel()
	 * @see org.eclipse.papyrus.umldi.ConstraintLabel#getLifelineShape
	 * @model opposite="lifelineShape" containment="true"
	 * @generated
	 */
	EList<ConstraintLabel> getConstraintLabel();
} // LifelineShape
