/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.uml2.uml.CallEvent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Terminate Event Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.TerminateEventDefinition#getBase_CallEvent <em>Base Call Event</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getTerminateEventDefinition()
 * @model
 * @generated
 */
public interface TerminateEventDefinition extends EventDefinition {
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
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getTerminateEventDefinition_Base_CallEvent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CallEvent getBase_CallEvent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.TerminateEventDefinition#getBase_CallEvent <em>Base Call Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Call Event</em>' reference.
	 * @see #getBase_CallEvent()
	 * @generated
	 */
	void setBase_CallEvent(CallEvent value);

} // TerminateEventDefinition
