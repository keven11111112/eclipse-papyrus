/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BPMN Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNEvent#getEventClass <em>Event Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNEvent#get_eventDefinitions <em>event Definitions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNEvent#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNEvent#getEventDefinitionRefs <em>Event Definition Refs</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getBPMNEvent()
 * @model abstract="true"
 * @generated
 */
public interface BPMNEvent extends FlowNode {
	/**
	 * Returns the value of the '<em><b>Event Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Class</em>' reference.
	 * @see #setEventClass(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getBPMNEvent_EventClass()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getEventClass();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNEvent#getEventClass <em>Event Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Class</em>' reference.
	 * @see #getEventClass()
	 * @generated
	 */
	void setEventClass(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>event Definitions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.EventDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>event Definitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>event Definitions</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getBPMNEvent__eventDefinitions()
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName=' eventDefinitions'"
	 * @generated
	 */
	EList<EventDefinition> get_eventDefinitions();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getBPMNEvent_Properties()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<BPMNProperty> getProperties();

	/**
	 * Returns the value of the '<em><b>Event Definition Refs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.EventDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Definition Refs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Definition Refs</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getBPMNEvent_EventDefinitionRefs()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<EventDefinition> getEventDefinitionRefs();

} // BPMNEvent
