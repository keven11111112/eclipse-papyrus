/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Partner Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.PartnerEntity#getBase_InstanceSpecification <em>Base Instance Specification</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.PartnerEntity#getParticipantRef <em>Participant Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getPartnerEntity()
 * @model
 * @generated
 */
public interface PartnerEntity extends RootElement {
	/**
	 * Returns the value of the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Instance Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Instance Specification</em>' reference.
	 * @see #setBase_InstanceSpecification(InstanceSpecification)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getPartnerEntity_Base_InstanceSpecification()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InstanceSpecification getBase_InstanceSpecification();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.PartnerEntity#getBase_InstanceSpecification <em>Base Instance Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Instance Specification</em>' reference.
	 * @see #getBase_InstanceSpecification()
	 * @generated
	 */
	void setBase_InstanceSpecification(InstanceSpecification value);

	/**
	 * Returns the value of the '<em><b>Participant Ref</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.Participant}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Participant#getPartnerEntityRef <em>Partner Entity Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participant Ref</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participant Ref</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getPartnerEntity_ParticipantRef()
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Participant#getPartnerEntityRef
	 * @model opposite="partnerEntityRef" ordered="false"
	 * @generated
	 */
	EList<Participant> getParticipantRef();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * PartnerEntity::/participantRef : Participant [*] = properties with Participant stereotype applied that the instance specification is default value of.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='PartnerEntity.participantRef'"
	 * @generated
	 */
	boolean PartnerEntityparticipantRef(DiagnosticChain diagnostics, Map<Object, Object> context);

} // PartnerEntity
