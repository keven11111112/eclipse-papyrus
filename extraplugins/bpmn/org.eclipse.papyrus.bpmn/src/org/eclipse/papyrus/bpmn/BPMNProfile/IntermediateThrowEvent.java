/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.uml2.uml.SendObjectAction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Intermediate Throw Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.IntermediateThrowEvent#getBase_SendObjectAction <em>Base Send Object Action</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getIntermediateThrowEvent()
 * @model
 * @generated
 */
public interface IntermediateThrowEvent extends ThrowEvent {
	/**
	 * Returns the value of the '<em><b>Base Send Object Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Send Object Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Send Object Action</em>' reference.
	 * @see #setBase_SendObjectAction(SendObjectAction)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getIntermediateThrowEvent_Base_SendObjectAction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SendObjectAction getBase_SendObjectAction();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.IntermediateThrowEvent#getBase_SendObjectAction <em>Base Send Object Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Send Object Action</em>' reference.
	 * @see #getBase_SendObjectAction()
	 * @generated
	 */
	void setBase_SendObjectAction(SendObjectAction value);

} // IntermediateThrowEvent
