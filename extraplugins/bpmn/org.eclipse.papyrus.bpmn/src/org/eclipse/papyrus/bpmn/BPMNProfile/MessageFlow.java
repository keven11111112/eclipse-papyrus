/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.uml2.uml.InformationFlow;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow#getBase_InformationFlow <em>Base Information Flow</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow#getSourceRef <em>Source Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow#getTargetRef <em>Target Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow#getMessageRef <em>Message Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMessageFlow()
 * @model
 * @generated
 */
public interface MessageFlow extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Base Information Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Information Flow</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Information Flow</em>' reference.
	 * @see #setBase_InformationFlow(InformationFlow)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMessageFlow_Base_InformationFlow()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InformationFlow getBase_InformationFlow();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow#getBase_InformationFlow <em>Base Information Flow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Information Flow</em>' reference.
	 * @see #getBase_InformationFlow()
	 * @generated
	 */
	void setBase_InformationFlow(InformationFlow value);

	/**
	 * Returns the value of the '<em><b>Source Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Ref</em>' reference.
	 * @see #setSourceRef(InteractionNode)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMessageFlow_SourceRef()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InteractionNode getSourceRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow#getSourceRef <em>Source Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Ref</em>' reference.
	 * @see #getSourceRef()
	 * @generated
	 */
	void setSourceRef(InteractionNode value);

	/**
	 * Returns the value of the '<em><b>Target Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Ref</em>' reference.
	 * @see #setTargetRef(InteractionNode)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMessageFlow_TargetRef()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InteractionNode getTargetRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow#getTargetRef <em>Target Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Ref</em>' reference.
	 * @see #getTargetRef()
	 * @generated
	 */
	void setTargetRef(InteractionNode value);

	/**
	 * Returns the value of the '<em><b>Message Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Ref</em>' reference.
	 * @see #setMessageRef(BPMNMessage)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMessageFlow_MessageRef()
	 * @model ordered="false"
	 * @generated
	 */
	BPMNMessage getMessageRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow#getMessageRef <em>Message Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Ref</em>' reference.
	 * @see #getMessageRef()
	 * @generated
	 */
	void setMessageRef(BPMNMessage value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * MessageFlow::/sourceRef = InformationFlow.informationSource
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='MessageFlow.sourceRef'"
	 * @generated
	 */
	boolean MessageFlowsourceRef(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * MessageFlow::/messageRef : Message [0..1] = InformationFlow.conveyed
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='MessageFlow.targetRef'"
	 * @generated
	 */
	boolean MessageFlowtargetRef(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * MessageFlow::/targetRef = InformationFlow.informationTarget
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='MessageFlow.messageRef'"
	 * @generated
	 */
	boolean MessageFlowmessageRef(DiagnosticChain diagnostics, Map<Object, Object> context);

} // MessageFlow
