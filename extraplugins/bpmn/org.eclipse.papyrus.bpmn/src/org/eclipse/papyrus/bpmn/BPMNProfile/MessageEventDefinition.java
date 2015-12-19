/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.uml2.uml.CallEvent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Event Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageEventDefinition#getMessageRef <em>Message Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageEventDefinition#getOperationRef <em>Operation Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageEventDefinition#getBase_CallEvent <em>Base Call Event</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMessageEventDefinition()
 * @model
 * @generated
 */
public interface MessageEventDefinition extends EventDefinition {
	/**
	 * Returns the value of the '<em><b>Message Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Ref</em>' reference.
	 * @see #setMessageRef(BPMNMessage)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMessageEventDefinition_MessageRef()
	 * @model ordered="false"
	 * @generated
	 */
	BPMNMessage getMessageRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageEventDefinition#getMessageRef <em>Message Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Ref</em>' reference.
	 * @see #getMessageRef()
	 * @generated
	 */
	void setMessageRef(BPMNMessage value);

	/**
	 * Returns the value of the '<em><b>Operation Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Ref</em>' reference.
	 * @see #setOperationRef(BPMNOperation)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMessageEventDefinition_OperationRef()
	 * @model ordered="false"
	 * @generated
	 */
	BPMNOperation getOperationRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageEventDefinition#getOperationRef <em>Operation Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Ref</em>' reference.
	 * @see #getOperationRef()
	 * @generated
	 */
	void setOperationRef(BPMNOperation value);

	/**
	 * Returns the value of the '<em><b>Base Call Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Call Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Call Event</em>' reference.
	 * @see #setBase_CallEvent(CallEvent)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMessageEventDefinition_Base_CallEvent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CallEvent getBase_CallEvent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageEventDefinition#getBase_CallEvent <em>Base Call Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Call Event</em>' reference.
	 * @see #getBase_CallEvent()
	 * @generated
	 */
	void setBase_CallEvent(CallEvent value);

} // MessageEventDefinition
