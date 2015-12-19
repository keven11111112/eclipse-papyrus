/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Conversation</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getGlobalConversation()
 * @model
 * @generated
 */
public interface GlobalConversation extends BPMNCollaboration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A GlobalConversation MUST NOT contain any ConversationNodes.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='GlobalConversation.contained.elements'"
	 * @generated
	 */
	boolean GlobalConversationcontainedelements(DiagnosticChain diagnostics, Map<Object, Object> context);

} // GlobalConversation
