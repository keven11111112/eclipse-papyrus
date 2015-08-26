/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Start Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.StartEvent#isInterrupting <em>Is Interrupting</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getStartEvent()
 * @model
 * @generated
 */
public interface StartEvent extends CatchEvent {
	/**
	 * Returns the value of the '<em><b>Is Interrupting</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Interrupting</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Interrupting</em>' attribute.
	 * @see #setIsInterrupting(boolean)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getStartEvent_IsInterrupting()
	 * @model default="true" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isInterrupting();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.StartEvent#isInterrupting <em>Is Interrupting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Interrupting</em>' attribute.
	 * @see #isInterrupting()
	 * @generated
	 */
	void setIsInterrupting(boolean value);

} // StartEvent
