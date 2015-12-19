/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.ConversationLink;
import org.eclipse.papyrus.bpmn.BPMNProfile.ConversationNode;
import org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationKey;
import org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow;
import org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlowAssociation;
import org.eclipse.papyrus.bpmn.BPMNProfile.Participant;
import org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantAssociation;

import org.eclipse.papyrus.bpmn.BPMNProfile.util.BPMNProfileValidator;

import org.eclipse.uml2.uml.Collaboration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BPMN Collaboration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNCollaborationImpl#isClosed <em>Is Closed</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNCollaborationImpl#getParticipantAssociations <em>Participant Associations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNCollaborationImpl#getConversationLinks <em>Conversation Links</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNCollaborationImpl#getMessageFlowAssociations <em>Message Flow Associations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNCollaborationImpl#getMessageFlows <em>Message Flows</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNCollaborationImpl#getBase_Collaboration <em>Base Collaboration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNCollaborationImpl#getConversations <em>Conversations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNCollaborationImpl#getCorrelationKeys <em>Correlation Keys</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNCollaborationImpl#getParticipants <em>Participants</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BPMNCollaborationImpl extends RootElementImpl implements BPMNCollaboration {
	/**
	 * The default value of the '{@link #isClosed() <em>Is Closed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClosed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CLOSED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isClosed() <em>Is Closed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClosed()
	 * @generated
	 * @ordered
	 */
	protected boolean isClosed = IS_CLOSED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParticipantAssociations() <em>Participant Associations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipantAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<ParticipantAssociation> participantAssociations;

	/**
	 * The cached value of the '{@link #getConversationLinks() <em>Conversation Links</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConversationLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<ConversationLink> conversationLinks;

	/**
	 * The cached value of the '{@link #getMessageFlowAssociations() <em>Message Flow Associations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageFlowAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<MessageFlowAssociation> messageFlowAssociations;

	/**
	 * The cached value of the '{@link #getMessageFlows() <em>Message Flows</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageFlows()
	 * @generated
	 * @ordered
	 */
	protected EList<MessageFlow> messageFlows;

	/**
	 * The cached value of the '{@link #getBase_Collaboration() <em>Base Collaboration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Collaboration()
	 * @generated
	 * @ordered
	 */
	protected Collaboration base_Collaboration;

	/**
	 * The cached value of the '{@link #getConversations() <em>Conversations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConversations()
	 * @generated
	 * @ordered
	 */
	protected EList<ConversationNode> conversations;

	/**
	 * The cached value of the '{@link #getCorrelationKeys() <em>Correlation Keys</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrelationKeys()
	 * @generated
	 * @ordered
	 */
	protected EList<CorrelationKey> correlationKeys;

	/**
	 * The cached value of the '{@link #getParticipants() <em>Participants</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipants()
	 * @generated
	 * @ordered
	 */
	protected EList<Participant> participants;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BPMNCollaborationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getBPMNCollaboration();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isClosed() {
		return isClosed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsClosed(boolean newIsClosed) {
		boolean oldIsClosed = isClosed;
		isClosed = newIsClosed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BPMN_COLLABORATION__IS_CLOSED, oldIsClosed, isClosed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParticipantAssociation> getParticipantAssociations() {
		if (participantAssociations == null) {
			participantAssociations = new EObjectResolvingEList<ParticipantAssociation>(ParticipantAssociation.class, this, BPMNProfilePackage.BPMN_COLLABORATION__PARTICIPANT_ASSOCIATIONS);
		}
		return participantAssociations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConversationLink> getConversationLinks() {
		if (conversationLinks == null) {
			conversationLinks = new EObjectWithInverseResolvingEList<ConversationLink>(ConversationLink.class, this, BPMNProfilePackage.BPMN_COLLABORATION__CONVERSATION_LINKS, BPMNProfilePackage.CONVERSATION_LINK__COLLABORATION);
		}
		return conversationLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MessageFlowAssociation> getMessageFlowAssociations() {
		if (messageFlowAssociations == null) {
			messageFlowAssociations = new EObjectResolvingEList<MessageFlowAssociation>(MessageFlowAssociation.class, this, BPMNProfilePackage.BPMN_COLLABORATION__MESSAGE_FLOW_ASSOCIATIONS);
		}
		return messageFlowAssociations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MessageFlow> getMessageFlows() {
		if (messageFlows == null) {
			messageFlows = new EObjectResolvingEList<MessageFlow>(MessageFlow.class, this, BPMNProfilePackage.BPMN_COLLABORATION__MESSAGE_FLOWS);
		}
		return messageFlows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collaboration getBase_Collaboration() {
		if (base_Collaboration != null && base_Collaboration.eIsProxy()) {
			InternalEObject oldBase_Collaboration = (InternalEObject)base_Collaboration;
			base_Collaboration = (Collaboration)eResolveProxy(oldBase_Collaboration);
			if (base_Collaboration != oldBase_Collaboration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.BPMN_COLLABORATION__BASE_COLLABORATION, oldBase_Collaboration, base_Collaboration));
			}
		}
		return base_Collaboration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collaboration basicGetBase_Collaboration() {
		return base_Collaboration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Collaboration(Collaboration newBase_Collaboration) {
		Collaboration oldBase_Collaboration = base_Collaboration;
		base_Collaboration = newBase_Collaboration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BPMN_COLLABORATION__BASE_COLLABORATION, oldBase_Collaboration, base_Collaboration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConversationNode> getConversations() {
		if (conversations == null) {
			conversations = new EObjectResolvingEList<ConversationNode>(ConversationNode.class, this, BPMNProfilePackage.BPMN_COLLABORATION__CONVERSATIONS);
		}
		return conversations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CorrelationKey> getCorrelationKeys() {
		if (correlationKeys == null) {
			correlationKeys = new EObjectResolvingEList<CorrelationKey>(CorrelationKey.class, this, BPMNProfilePackage.BPMN_COLLABORATION__CORRELATION_KEYS);
		}
		return correlationKeys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Participant> getParticipants() {
		if (participants == null) {
			participants = new EObjectResolvingEList<Participant>(Participant.class, this, BPMNProfilePackage.BPMN_COLLABORATION__PARTICIPANTS);
		}
		return participants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean Collaborationparticipants(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 BPMNProfileValidator.DIAGNOSTIC_SOURCE,
						 BPMNProfileValidator.BPMN_COLLABORATION__COLLABORATIONPARTICIPANTS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "Collaborationparticipants", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BPMNProfilePackage.BPMN_COLLABORATION__CONVERSATION_LINKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConversationLinks()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BPMNProfilePackage.BPMN_COLLABORATION__CONVERSATION_LINKS:
				return ((InternalEList<?>)getConversationLinks()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.BPMN_COLLABORATION__IS_CLOSED:
				return isClosed();
			case BPMNProfilePackage.BPMN_COLLABORATION__PARTICIPANT_ASSOCIATIONS:
				return getParticipantAssociations();
			case BPMNProfilePackage.BPMN_COLLABORATION__CONVERSATION_LINKS:
				return getConversationLinks();
			case BPMNProfilePackage.BPMN_COLLABORATION__MESSAGE_FLOW_ASSOCIATIONS:
				return getMessageFlowAssociations();
			case BPMNProfilePackage.BPMN_COLLABORATION__MESSAGE_FLOWS:
				return getMessageFlows();
			case BPMNProfilePackage.BPMN_COLLABORATION__BASE_COLLABORATION:
				if (resolve) return getBase_Collaboration();
				return basicGetBase_Collaboration();
			case BPMNProfilePackage.BPMN_COLLABORATION__CONVERSATIONS:
				return getConversations();
			case BPMNProfilePackage.BPMN_COLLABORATION__CORRELATION_KEYS:
				return getCorrelationKeys();
			case BPMNProfilePackage.BPMN_COLLABORATION__PARTICIPANTS:
				return getParticipants();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BPMNProfilePackage.BPMN_COLLABORATION__IS_CLOSED:
				setIsClosed((Boolean)newValue);
				return;
			case BPMNProfilePackage.BPMN_COLLABORATION__PARTICIPANT_ASSOCIATIONS:
				getParticipantAssociations().clear();
				getParticipantAssociations().addAll((Collection<? extends ParticipantAssociation>)newValue);
				return;
			case BPMNProfilePackage.BPMN_COLLABORATION__CONVERSATION_LINKS:
				getConversationLinks().clear();
				getConversationLinks().addAll((Collection<? extends ConversationLink>)newValue);
				return;
			case BPMNProfilePackage.BPMN_COLLABORATION__MESSAGE_FLOW_ASSOCIATIONS:
				getMessageFlowAssociations().clear();
				getMessageFlowAssociations().addAll((Collection<? extends MessageFlowAssociation>)newValue);
				return;
			case BPMNProfilePackage.BPMN_COLLABORATION__MESSAGE_FLOWS:
				getMessageFlows().clear();
				getMessageFlows().addAll((Collection<? extends MessageFlow>)newValue);
				return;
			case BPMNProfilePackage.BPMN_COLLABORATION__BASE_COLLABORATION:
				setBase_Collaboration((Collaboration)newValue);
				return;
			case BPMNProfilePackage.BPMN_COLLABORATION__CONVERSATIONS:
				getConversations().clear();
				getConversations().addAll((Collection<? extends ConversationNode>)newValue);
				return;
			case BPMNProfilePackage.BPMN_COLLABORATION__CORRELATION_KEYS:
				getCorrelationKeys().clear();
				getCorrelationKeys().addAll((Collection<? extends CorrelationKey>)newValue);
				return;
			case BPMNProfilePackage.BPMN_COLLABORATION__PARTICIPANTS:
				getParticipants().clear();
				getParticipants().addAll((Collection<? extends Participant>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BPMNProfilePackage.BPMN_COLLABORATION__IS_CLOSED:
				setIsClosed(IS_CLOSED_EDEFAULT);
				return;
			case BPMNProfilePackage.BPMN_COLLABORATION__PARTICIPANT_ASSOCIATIONS:
				getParticipantAssociations().clear();
				return;
			case BPMNProfilePackage.BPMN_COLLABORATION__CONVERSATION_LINKS:
				getConversationLinks().clear();
				return;
			case BPMNProfilePackage.BPMN_COLLABORATION__MESSAGE_FLOW_ASSOCIATIONS:
				getMessageFlowAssociations().clear();
				return;
			case BPMNProfilePackage.BPMN_COLLABORATION__MESSAGE_FLOWS:
				getMessageFlows().clear();
				return;
			case BPMNProfilePackage.BPMN_COLLABORATION__BASE_COLLABORATION:
				setBase_Collaboration((Collaboration)null);
				return;
			case BPMNProfilePackage.BPMN_COLLABORATION__CONVERSATIONS:
				getConversations().clear();
				return;
			case BPMNProfilePackage.BPMN_COLLABORATION__CORRELATION_KEYS:
				getCorrelationKeys().clear();
				return;
			case BPMNProfilePackage.BPMN_COLLABORATION__PARTICIPANTS:
				getParticipants().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BPMNProfilePackage.BPMN_COLLABORATION__IS_CLOSED:
				return isClosed != IS_CLOSED_EDEFAULT;
			case BPMNProfilePackage.BPMN_COLLABORATION__PARTICIPANT_ASSOCIATIONS:
				return participantAssociations != null && !participantAssociations.isEmpty();
			case BPMNProfilePackage.BPMN_COLLABORATION__CONVERSATION_LINKS:
				return conversationLinks != null && !conversationLinks.isEmpty();
			case BPMNProfilePackage.BPMN_COLLABORATION__MESSAGE_FLOW_ASSOCIATIONS:
				return messageFlowAssociations != null && !messageFlowAssociations.isEmpty();
			case BPMNProfilePackage.BPMN_COLLABORATION__MESSAGE_FLOWS:
				return messageFlows != null && !messageFlows.isEmpty();
			case BPMNProfilePackage.BPMN_COLLABORATION__BASE_COLLABORATION:
				return base_Collaboration != null;
			case BPMNProfilePackage.BPMN_COLLABORATION__CONVERSATIONS:
				return conversations != null && !conversations.isEmpty();
			case BPMNProfilePackage.BPMN_COLLABORATION__CORRELATION_KEYS:
				return correlationKeys != null && !correlationKeys.isEmpty();
			case BPMNProfilePackage.BPMN_COLLABORATION__PARTICIPANTS:
				return participants != null && !participants.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case BPMNProfilePackage.BPMN_COLLABORATION___COLLABORATIONPARTICIPANTS__DIAGNOSTICCHAIN_MAP:
				return Collaborationparticipants((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isClosed: ");
		result.append(isClosed);
		result.append(')');
		return result.toString();
	}

} //BPMNCollaborationImpl
