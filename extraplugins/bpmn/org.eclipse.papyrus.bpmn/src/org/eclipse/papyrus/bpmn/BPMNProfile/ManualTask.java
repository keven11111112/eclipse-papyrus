/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.uml2.uml.OpaqueAction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Manual Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.ManualTask#getBase_OpaqueAction <em>Base Opaque Action</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getManualTask()
 * @model
 * @generated
 */
public interface ManualTask extends Task {
	/**
	 * Returns the value of the '<em><b>Base Opaque Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Opaque Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Opaque Action</em>' reference.
	 * @see #setBase_OpaqueAction(OpaqueAction)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getManualTask_Base_OpaqueAction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	OpaqueAction getBase_OpaqueAction();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ManualTask#getBase_OpaqueAction <em>Base Opaque Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Opaque Action</em>' reference.
	 * @see #getBase_OpaqueAction()
	 * @generated
	 */
	void setBase_OpaqueAction(OpaqueAction value);

} // ManualTask
