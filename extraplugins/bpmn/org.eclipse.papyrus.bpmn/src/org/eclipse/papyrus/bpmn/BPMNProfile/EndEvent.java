/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.uml2.uml.FinalNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>End Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.EndEvent#getBase_FinalNode <em>Base Final Node</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getEndEvent()
 * @model
 * @generated
 */
public interface EndEvent extends ThrowEvent {
	/**
	 * Returns the value of the '<em><b>Base Final Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Final Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Final Node</em>' reference.
	 * @see #setBase_FinalNode(FinalNode)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getEndEvent_Base_FinalNode()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FinalNode getBase_FinalNode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.EndEvent#getBase_FinalNode <em>Base Final Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Final Node</em>' reference.
	 * @see #getBase_FinalNode()
	 * @generated
	 */
	void setBase_FinalNode(FinalNode value);

} // EndEvent
