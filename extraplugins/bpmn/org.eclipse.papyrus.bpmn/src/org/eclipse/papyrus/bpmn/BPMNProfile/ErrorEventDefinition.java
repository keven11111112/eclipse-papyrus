/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.uml2.uml.CallEvent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Event Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.ErrorEventDefinition#getErrorRef <em>Error Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.ErrorEventDefinition#getBase_CallEvent <em>Base Call Event</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getErrorEventDefinition()
 * @model
 * @generated
 */
public interface ErrorEventDefinition extends EventDefinition {
	/**
	 * Returns the value of the '<em><b>Error Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Ref</em>' reference.
	 * @see #setErrorRef(org.eclipse.papyrus.bpmn.BPMNProfile.Error)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getErrorEventDefinition_ErrorRef()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.papyrus.bpmn.BPMNProfile.Error getErrorRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ErrorEventDefinition#getErrorRef <em>Error Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Ref</em>' reference.
	 * @see #getErrorRef()
	 * @generated
	 */
	void setErrorRef(org.eclipse.papyrus.bpmn.BPMNProfile.Error value);

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
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getErrorEventDefinition_Base_CallEvent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CallEvent getBase_CallEvent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ErrorEventDefinition#getBase_CallEvent <em>Base Call Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Call Event</em>' reference.
	 * @see #getBase_CallEvent()
	 * @generated
	 */
	void setBase_CallEvent(CallEvent value);

} // ErrorEventDefinition
