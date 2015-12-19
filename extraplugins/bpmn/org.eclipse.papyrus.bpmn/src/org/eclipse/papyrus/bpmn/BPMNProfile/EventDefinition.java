/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.uml2.uml.Event;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.EventDefinition#getBase_Event <em>Base Event</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getEventDefinition()
 * @model abstract="true"
 * @generated
 */
public interface EventDefinition extends RootElement {
	/**
	 * Returns the value of the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Event</em>' reference.
	 * @see #setBase_Event(Event)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getEventDefinition_Base_Event()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Event getBase_Event();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.EventDefinition#getBase_Event <em>Base Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Event</em>' reference.
	 * @see #getBase_Event()
	 * @generated
	 */
	void setBase_Event(Event value);

} // EventDefinition
