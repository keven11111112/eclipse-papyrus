/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.uml2.uml.MultiplicityElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Participant Multiplicity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantMultiplicity#getBase_MultiplicityElement <em>Base Multiplicity Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantMultiplicity#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantMultiplicity#getMaximum <em>Maximum</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getParticipantMultiplicity()
 * @model
 * @generated
 */
public interface ParticipantMultiplicity extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Base Multiplicity Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Multiplicity Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Multiplicity Element</em>' reference.
	 * @see #setBase_MultiplicityElement(MultiplicityElement)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getParticipantMultiplicity_Base_MultiplicityElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	MultiplicityElement getBase_MultiplicityElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantMultiplicity#getBase_MultiplicityElement <em>Base Multiplicity Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Multiplicity Element</em>' reference.
	 * @see #getBase_MultiplicityElement()
	 * @generated
	 */
	void setBase_MultiplicityElement(MultiplicityElement value);

	/**
	 * Returns the value of the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum</em>' attribute.
	 * @see #setMinimum(int)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getParticipantMultiplicity_Minimum()
	 * @model dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getMinimum();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantMultiplicity#getMinimum <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum</em>' attribute.
	 * @see #getMinimum()
	 * @generated
	 */
	void setMinimum(int value);

	/**
	 * Returns the value of the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum</em>' attribute.
	 * @see #setMaximum(int)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getParticipantMultiplicity_Maximum()
	 * @model dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getMaximum();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantMultiplicity#getMaximum <em>Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum</em>' attribute.
	 * @see #getMaximum()
	 * @generated
	 */
	void setMaximum(int value);

} // ParticipantMultiplicity
