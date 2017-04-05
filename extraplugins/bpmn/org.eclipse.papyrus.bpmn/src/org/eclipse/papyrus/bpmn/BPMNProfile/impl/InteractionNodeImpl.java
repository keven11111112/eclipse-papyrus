/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.ConversationLink;
import org.eclipse.papyrus.bpmn.BPMNProfile.InteractionNode;
import org.eclipse.uml2.uml.Element;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interaction Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.InteractionNodeImpl#getBase_InteractionNode_Element <em>Base Interaction Node Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.InteractionNodeImpl#getOutgoingConversationLinks <em>Outgoing Conversation Links</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.InteractionNodeImpl#getIncomingConversationLinks <em>Incoming Conversation Links</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class InteractionNodeImpl extends MinimalEObjectImpl.Container implements InteractionNode {
	/**
	 * The cached value of the '{@link #getBase_InteractionNode_Element() <em>Base Interaction Node Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_InteractionNode_Element()
	 * @generated
	 * @ordered
	 */
	protected Element base_InteractionNode_Element;

	/**
	 * The cached value of the '{@link #getOutgoingConversationLinks() <em>Outgoing Conversation Links</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingConversationLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<ConversationLink> outgoingConversationLinks;
	/**
	 * The cached value of the '{@link #getIncomingConversationLinks() <em>Incoming Conversation Links</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingConversationLinks()
	 * @generated
	 * @ordered
	 */
	protected ConversationLink incomingConversationLinks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InteractionNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getInteractionNode();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getBase_InteractionNode_Element() {
		if (base_InteractionNode_Element != null && base_InteractionNode_Element.eIsProxy()) {
			InternalEObject oldBase_InteractionNode_Element = (InternalEObject)base_InteractionNode_Element;
			base_InteractionNode_Element = (Element)eResolveProxy(oldBase_InteractionNode_Element);
			if (base_InteractionNode_Element != oldBase_InteractionNode_Element) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.INTERACTION_NODE__BASE_INTERACTION_NODE_ELEMENT, oldBase_InteractionNode_Element, base_InteractionNode_Element));
			}
		}
		return base_InteractionNode_Element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetBase_InteractionNode_Element() {
		return base_InteractionNode_Element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_InteractionNode_Element(Element newBase_InteractionNode_Element) {
		Element oldBase_InteractionNode_Element = base_InteractionNode_Element;
		base_InteractionNode_Element = newBase_InteractionNode_Element;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.INTERACTION_NODE__BASE_INTERACTION_NODE_ELEMENT, oldBase_InteractionNode_Element, base_InteractionNode_Element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConversationLink> getOutgoingConversationLinks() {
		if (outgoingConversationLinks == null) {
			outgoingConversationLinks = new EObjectWithInverseResolvingEList<ConversationLink>(ConversationLink.class, this, BPMNProfilePackage.INTERACTION_NODE__OUTGOING_CONVERSATION_LINKS, BPMNProfilePackage.CONVERSATION_LINK__SOURCE_REF);
		}
		return outgoingConversationLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConversationLink getIncomingConversationLinks() {
		if (incomingConversationLinks != null && incomingConversationLinks.eIsProxy()) {
			InternalEObject oldIncomingConversationLinks = (InternalEObject)incomingConversationLinks;
			incomingConversationLinks = (ConversationLink)eResolveProxy(oldIncomingConversationLinks);
			if (incomingConversationLinks != oldIncomingConversationLinks) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.INTERACTION_NODE__INCOMING_CONVERSATION_LINKS, oldIncomingConversationLinks, incomingConversationLinks));
			}
		}
		return incomingConversationLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConversationLink basicGetIncomingConversationLinks() {
		return incomingConversationLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIncomingConversationLinks(ConversationLink newIncomingConversationLinks, NotificationChain msgs) {
		ConversationLink oldIncomingConversationLinks = incomingConversationLinks;
		incomingConversationLinks = newIncomingConversationLinks;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.INTERACTION_NODE__INCOMING_CONVERSATION_LINKS, oldIncomingConversationLinks, newIncomingConversationLinks);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncomingConversationLinks(ConversationLink newIncomingConversationLinks) {
		if (newIncomingConversationLinks != incomingConversationLinks) {
			NotificationChain msgs = null;
			if (incomingConversationLinks != null)
				msgs = ((InternalEObject)incomingConversationLinks).eInverseRemove(this, BPMNProfilePackage.CONVERSATION_LINK__TARGET_REF, ConversationLink.class, msgs);
			if (newIncomingConversationLinks != null)
				msgs = ((InternalEObject)newIncomingConversationLinks).eInverseAdd(this, BPMNProfilePackage.CONVERSATION_LINK__TARGET_REF, ConversationLink.class, msgs);
			msgs = basicSetIncomingConversationLinks(newIncomingConversationLinks, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.INTERACTION_NODE__INCOMING_CONVERSATION_LINKS, newIncomingConversationLinks, newIncomingConversationLinks));
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
			case BPMNProfilePackage.INTERACTION_NODE__OUTGOING_CONVERSATION_LINKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingConversationLinks()).basicAdd(otherEnd, msgs);
			case BPMNProfilePackage.INTERACTION_NODE__INCOMING_CONVERSATION_LINKS:
				if (incomingConversationLinks != null)
					msgs = ((InternalEObject)incomingConversationLinks).eInverseRemove(this, BPMNProfilePackage.CONVERSATION_LINK__TARGET_REF, ConversationLink.class, msgs);
				return basicSetIncomingConversationLinks((ConversationLink)otherEnd, msgs);
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
			case BPMNProfilePackage.INTERACTION_NODE__OUTGOING_CONVERSATION_LINKS:
				return ((InternalEList<?>)getOutgoingConversationLinks()).basicRemove(otherEnd, msgs);
			case BPMNProfilePackage.INTERACTION_NODE__INCOMING_CONVERSATION_LINKS:
				return basicSetIncomingConversationLinks(null, msgs);
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
			case BPMNProfilePackage.INTERACTION_NODE__BASE_INTERACTION_NODE_ELEMENT:
				if (resolve) return getBase_InteractionNode_Element();
				return basicGetBase_InteractionNode_Element();
			case BPMNProfilePackage.INTERACTION_NODE__OUTGOING_CONVERSATION_LINKS:
				return getOutgoingConversationLinks();
			case BPMNProfilePackage.INTERACTION_NODE__INCOMING_CONVERSATION_LINKS:
				if (resolve) return getIncomingConversationLinks();
				return basicGetIncomingConversationLinks();
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
			case BPMNProfilePackage.INTERACTION_NODE__BASE_INTERACTION_NODE_ELEMENT:
				setBase_InteractionNode_Element((Element)newValue);
				return;
			case BPMNProfilePackage.INTERACTION_NODE__OUTGOING_CONVERSATION_LINKS:
				getOutgoingConversationLinks().clear();
				getOutgoingConversationLinks().addAll((Collection<? extends ConversationLink>)newValue);
				return;
			case BPMNProfilePackage.INTERACTION_NODE__INCOMING_CONVERSATION_LINKS:
				setIncomingConversationLinks((ConversationLink)newValue);
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
			case BPMNProfilePackage.INTERACTION_NODE__BASE_INTERACTION_NODE_ELEMENT:
				setBase_InteractionNode_Element((Element)null);
				return;
			case BPMNProfilePackage.INTERACTION_NODE__OUTGOING_CONVERSATION_LINKS:
				getOutgoingConversationLinks().clear();
				return;
			case BPMNProfilePackage.INTERACTION_NODE__INCOMING_CONVERSATION_LINKS:
				setIncomingConversationLinks((ConversationLink)null);
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
			case BPMNProfilePackage.INTERACTION_NODE__BASE_INTERACTION_NODE_ELEMENT:
				return base_InteractionNode_Element != null;
			case BPMNProfilePackage.INTERACTION_NODE__OUTGOING_CONVERSATION_LINKS:
				return outgoingConversationLinks != null && !outgoingConversationLinks.isEmpty();
			case BPMNProfilePackage.INTERACTION_NODE__INCOMING_CONVERSATION_LINKS:
				return incomingConversationLinks != null;
		}
		return super.eIsSet(featureID);
	}

} //InteractionNodeImpl
