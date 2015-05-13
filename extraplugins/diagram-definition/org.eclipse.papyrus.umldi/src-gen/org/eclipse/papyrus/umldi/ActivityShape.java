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
 * A representation of the model object '<em><b>Activity Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.ActivityShape#getParameterCompartment <em>Parameter Compartment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.ActivityShape#getPostConditionCompartment <em>Post Condition Compartment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.ActivityShape#getPreConditionCompartment <em>Pre Condition Compartment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.ActivityShape#getContentCompartment <em>Content Compartment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.ActivityShape#getActivityParameterNodeShape <em>Activity Parameter Node Shape</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getActivityShape()
 * @model
 * @generated
 */
public interface ActivityShape extends ClassShape {
	/**
	 * Returns the value of the '<em><b>Parameter Compartment</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.ParameterCompartment#getActivityShape <em>Activity Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Compartment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Compartment</em>' containment reference.
	 * @see #setParameterCompartment(ParameterCompartment)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getActivityShape_ParameterCompartment()
	 * @see org.eclipse.papyrus.umldi.ParameterCompartment#getActivityShape
	 * @model opposite="activityShape" containment="true" ordered="false"
	 * @generated
	 */
	ParameterCompartment getParameterCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.ActivityShape#getParameterCompartment <em>Parameter Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Compartment</em>' containment reference.
	 * @see #getParameterCompartment()
	 * @generated
	 */
	void setParameterCompartment(ParameterCompartment value);

	/**
	 * Returns the value of the '<em><b>Post Condition Compartment</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.PostConditionCompartment#getActivityShape <em>Activity Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Post Condition Compartment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Post Condition Compartment</em>' containment reference.
	 * @see #setPostConditionCompartment(PostConditionCompartment)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getActivityShape_PostConditionCompartment()
	 * @see org.eclipse.papyrus.umldi.PostConditionCompartment#getActivityShape
	 * @model opposite="activityShape" containment="true" ordered="false"
	 * @generated
	 */
	PostConditionCompartment getPostConditionCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.ActivityShape#getPostConditionCompartment <em>Post Condition Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post Condition Compartment</em>' containment reference.
	 * @see #getPostConditionCompartment()
	 * @generated
	 */
	void setPostConditionCompartment(PostConditionCompartment value);

	/**
	 * Returns the value of the '<em><b>Pre Condition Compartment</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.PreConditionCompartment#getActivityShape <em>Activity Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre Condition Compartment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre Condition Compartment</em>' containment reference.
	 * @see #setPreConditionCompartment(PreConditionCompartment)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getActivityShape_PreConditionCompartment()
	 * @see org.eclipse.papyrus.umldi.PreConditionCompartment#getActivityShape
	 * @model opposite="activityShape" containment="true" ordered="false"
	 * @generated
	 */
	PreConditionCompartment getPreConditionCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.ActivityShape#getPreConditionCompartment <em>Pre Condition Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pre Condition Compartment</em>' containment reference.
	 * @see #getPreConditionCompartment()
	 * @generated
	 */
	void setPreConditionCompartment(PreConditionCompartment value);

	/**
	 * Returns the value of the '<em><b>Content Compartment</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.ContentCompartment#getActivityShape <em>Activity Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content Compartment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content Compartment</em>' containment reference.
	 * @see #setContentCompartment(ContentCompartment)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getActivityShape_ContentCompartment()
	 * @see org.eclipse.papyrus.umldi.ContentCompartment#getActivityShape
	 * @model opposite="activityShape" containment="true" ordered="false"
	 * @generated
	 */
	ContentCompartment getContentCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.ActivityShape#getContentCompartment <em>Content Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content Compartment</em>' containment reference.
	 * @see #getContentCompartment()
	 * @generated
	 */
	void setContentCompartment(ContentCompartment value);

	/**
	 * Returns the value of the '<em><b>Activity Parameter Node Shape</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.umldi.ActivityParameterNodeShape}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.ActivityParameterNodeShape#getActivityShape <em>Activity Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activity Parameter Node Shape</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activity Parameter Node Shape</em>' containment reference list.
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getActivityShape_ActivityParameterNodeShape()
	 * @see org.eclipse.papyrus.umldi.ActivityParameterNodeShape#getActivityShape
	 * @model opposite="activityShape" containment="true" ordered="false"
	 * @generated
	 */
	EList<ActivityParameterNodeShape> getActivityParameterNodeShape();

} // ActivityShape
