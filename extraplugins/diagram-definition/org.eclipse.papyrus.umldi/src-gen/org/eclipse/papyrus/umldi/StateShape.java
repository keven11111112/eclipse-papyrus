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
 * A representation of the model object '<em><b>State Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.umldi.StateShape#getConnectionPointReferenceShape <em>Connection Point Reference Shape</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.StateShape#getInternalTransitionCompartment <em>Internal Transition Compartment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.StateShape#getDeferrableTriggerCompartment <em>Deferrable Trigger Compartment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.umldi.StateShape#getInternalBehaviorCompartment <em>Internal Behavior Compartment</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getStateShape()
 * @model
 * @generated
 */
public interface StateShape extends BaseStateShape {
	/**
	 * Returns the value of the '<em><b>Connection Point Reference Shape</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.umldi.ConnectionPointReferenceShape}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.ConnectionPointReferenceShape#getStateShape <em>State Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Point Reference Shape</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Point Reference Shape</em>' containment reference list.
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getStateShape_ConnectionPointReferenceShape()
	 * @see org.eclipse.papyrus.umldi.ConnectionPointReferenceShape#getStateShape
	 * @model opposite="stateShape" containment="true" ordered="false"
	 * @generated
	 */
	EList<ConnectionPointReferenceShape> getConnectionPointReferenceShape();

	/**
	 * Returns the value of the '<em><b>Internal Transition Compartment</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.InternalTransitionCompartment#getStateShape <em>State Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Transition Compartment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Transition Compartment</em>' containment reference.
	 * @see #setInternalTransitionCompartment(InternalTransitionCompartment)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getStateShape_InternalTransitionCompartment()
	 * @see org.eclipse.papyrus.umldi.InternalTransitionCompartment#getStateShape
	 * @model opposite="stateShape" containment="true" ordered="false"
	 * @generated
	 */
	InternalTransitionCompartment getInternalTransitionCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.StateShape#getInternalTransitionCompartment <em>Internal Transition Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal Transition Compartment</em>' containment reference.
	 * @see #getInternalTransitionCompartment()
	 * @generated
	 */
	void setInternalTransitionCompartment(InternalTransitionCompartment value);

	/**
	 * Returns the value of the '<em><b>Deferrable Trigger Compartment</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.DeferrableTriggerCompartment#getStateShape <em>State Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deferrable Trigger Compartment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deferrable Trigger Compartment</em>' containment reference.
	 * @see #setDeferrableTriggerCompartment(DeferrableTriggerCompartment)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getStateShape_DeferrableTriggerCompartment()
	 * @see org.eclipse.papyrus.umldi.DeferrableTriggerCompartment#getStateShape
	 * @model opposite="stateShape" containment="true" ordered="false"
	 * @generated
	 */
	DeferrableTriggerCompartment getDeferrableTriggerCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.StateShape#getDeferrableTriggerCompartment <em>Deferrable Trigger Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deferrable Trigger Compartment</em>' containment reference.
	 * @see #getDeferrableTriggerCompartment()
	 * @generated
	 */
	void setDeferrableTriggerCompartment(DeferrableTriggerCompartment value);

	/**
	 * Returns the value of the '<em><b>Internal Behavior Compartment</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.InternalBehaviorCompartment#getStateShape <em>State Shape</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwnedUmlDiagramElement() <em>Owned Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Behavior Compartment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Behavior Compartment</em>' containment reference.
	 * @see #setInternalBehaviorCompartment(InternalBehaviorCompartment)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getStateShape_InternalBehaviorCompartment()
	 * @see org.eclipse.papyrus.umldi.InternalBehaviorCompartment#getStateShape
	 * @model opposite="stateShape" containment="true" ordered="false"
	 * @generated
	 */
	InternalBehaviorCompartment getInternalBehaviorCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.StateShape#getInternalBehaviorCompartment <em>Internal Behavior Compartment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal Behavior Compartment</em>' containment reference.
	 * @see #getInternalBehaviorCompartment()
	 * @generated
	 */
	void setInternalBehaviorCompartment(InternalBehaviorCompartment value);

} // StateShape
