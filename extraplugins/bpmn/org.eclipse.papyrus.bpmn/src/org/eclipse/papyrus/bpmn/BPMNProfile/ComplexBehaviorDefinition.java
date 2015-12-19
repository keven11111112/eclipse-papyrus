/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.uml2.uml.ControlFlow;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Behavior Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.ComplexBehaviorDefinition#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.ComplexBehaviorDefinition#getEvent <em>Event</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.ComplexBehaviorDefinition#getBase_ControlFlow <em>Base Control Flow</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getComplexBehaviorDefinition()
 * @model
 * @generated
 */
public interface ComplexBehaviorDefinition extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' reference.
	 * @see #setCondition(FormalExpression)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getComplexBehaviorDefinition_Condition()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FormalExpression getCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ComplexBehaviorDefinition#getCondition <em>Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(FormalExpression value);

	/**
	 * Returns the value of the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' reference.
	 * @see #setEvent(ImplicitThrowEvent)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getComplexBehaviorDefinition_Event()
	 * @model ordered="false"
	 * @generated
	 */
	ImplicitThrowEvent getEvent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ComplexBehaviorDefinition#getEvent <em>Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' reference.
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(ImplicitThrowEvent value);

	/**
	 * Returns the value of the '<em><b>Base Control Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Control Flow</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Control Flow</em>' reference.
	 * @see #setBase_ControlFlow(ControlFlow)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getComplexBehaviorDefinition_Base_ControlFlow()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ControlFlow getBase_ControlFlow();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ComplexBehaviorDefinition#getBase_ControlFlow <em>Base Control Flow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Control Flow</em>' reference.
	 * @see #getBase_ControlFlow()
	 * @generated
	 */
	void setBase_ControlFlow(ControlFlow value);

} // ComplexBehaviorDefinition
