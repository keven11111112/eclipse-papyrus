/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.ConversationLink;
import org.eclipse.papyrus.bpmn.BPMNProfile.InteractionNode;

import org.eclipse.uml2.uml.Dependency;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conversation Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ConversationLinkImpl#getCollaboration <em>Collaboration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ConversationLinkImpl#getBase_Dependency <em>Base Dependency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ConversationLinkImpl#getTargetRef <em>Target Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ConversationLinkImpl#getSourceRef <em>Source Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConversationLinkImpl extends BaseElementImpl implements ConversationLink {
	/**
	 * The cached value of the '{@link #getCollaboration() <em>Collaboration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollaboration()
	 * @generated
	 * @ordered
	 */
	protected BPMNCollaboration collaboration;
	/**
	 * The cached value of the '{@link #getBase_Dependency() <em>Base Dependency</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Dependency()
	 * @generated
	 * @ordered
	 */
	protected Dependency base_Dependency;

	/**
	 * The cached value of the '{@link #getTargetRef() <em>Target Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetRef()
	 * @generated
	 * @ordered
	 */
	protected InteractionNode targetRef;
	/**
	 * The cached value of the '{@link #getSourceRef() <em>Source Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceRef()
	 * @generated
	 * @ordered
	 */
	protected InteractionNode sourceRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConversationLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getConversationLink();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNCollaboration getCollaboration() {
		if (collaboration != null && collaboration.eIsProxy()) {
			InternalEObject oldCollaboration = (InternalEObject)collaboration;
			collaboration = (BPMNCollaboration)eResolveProxy(oldCollaboration);
			if (collaboration != oldCollaboration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.CONVERSATION_LINK__COLLABORATION, oldCollaboration, collaboration));
			}
		}
		return collaboration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNCollaboration basicGetCollaboration() {
		return collaboration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCollaboration(BPMNCollaboration newCollaboration, NotificationChain msgs) {
		BPMNCollaboration oldCollaboration = collaboration;
		collaboration = newCollaboration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.CONVERSATION_LINK__COLLABORATION, oldCollaboration, newCollaboration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCollaboration(BPMNCollaboration newCollaboration) {
		if (newCollaboration != collaboration) {
			NotificationChain msgs = null;
			if (collaboration != null)
				msgs = ((InternalEObject)collaboration).eInverseRemove(this, BPMNProfilePackage.BPMN_COLLABORATION__CONVERSATION_LINKS, BPMNCollaboration.class, msgs);
			if (newCollaboration != null)
				msgs = ((InternalEObject)newCollaboration).eInverseAdd(this, BPMNProfilePackage.BPMN_COLLABORATION__CONVERSATION_LINKS, BPMNCollaboration.class, msgs);
			msgs = basicSetCollaboration(newCollaboration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.CONVERSATION_LINK__COLLABORATION, newCollaboration, newCollaboration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dependency getBase_Dependency() {
		if (base_Dependency != null && base_Dependency.eIsProxy()) {
			InternalEObject oldBase_Dependency = (InternalEObject)base_Dependency;
			base_Dependency = (Dependency)eResolveProxy(oldBase_Dependency);
			if (base_Dependency != oldBase_Dependency) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.CONVERSATION_LINK__BASE_DEPENDENCY, oldBase_Dependency, base_Dependency));
			}
		}
		return base_Dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dependency basicGetBase_Dependency() {
		return base_Dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Dependency(Dependency newBase_Dependency) {
		Dependency oldBase_Dependency = base_Dependency;
		base_Dependency = newBase_Dependency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.CONVERSATION_LINK__BASE_DEPENDENCY, oldBase_Dependency, base_Dependency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionNode getTargetRef() {
		if (targetRef != null && targetRef.eIsProxy()) {
			InternalEObject oldTargetRef = (InternalEObject)targetRef;
			targetRef = (InteractionNode)eResolveProxy(oldTargetRef);
			if (targetRef != oldTargetRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.CONVERSATION_LINK__TARGET_REF, oldTargetRef, targetRef));
			}
		}
		return targetRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionNode basicGetTargetRef() {
		return targetRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetRef(InteractionNode newTargetRef, NotificationChain msgs) {
		InteractionNode oldTargetRef = targetRef;
		targetRef = newTargetRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.CONVERSATION_LINK__TARGET_REF, oldTargetRef, newTargetRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetRef(InteractionNode newTargetRef) {
		if (newTargetRef != targetRef) {
			NotificationChain msgs = null;
			if (targetRef != null)
				msgs = ((InternalEObject)targetRef).eInverseRemove(this, BPMNProfilePackage.INTERACTION_NODE__INCOMING_CONVERSATION_LINKS, InteractionNode.class, msgs);
			if (newTargetRef != null)
				msgs = ((InternalEObject)newTargetRef).eInverseAdd(this, BPMNProfilePackage.INTERACTION_NODE__INCOMING_CONVERSATION_LINKS, InteractionNode.class, msgs);
			msgs = basicSetTargetRef(newTargetRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.CONVERSATION_LINK__TARGET_REF, newTargetRef, newTargetRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionNode getSourceRef() {
		if (sourceRef != null && sourceRef.eIsProxy()) {
			InternalEObject oldSourceRef = (InternalEObject)sourceRef;
			sourceRef = (InteractionNode)eResolveProxy(oldSourceRef);
			if (sourceRef != oldSourceRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.CONVERSATION_LINK__SOURCE_REF, oldSourceRef, sourceRef));
			}
		}
		return sourceRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionNode basicGetSourceRef() {
		return sourceRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceRef(InteractionNode newSourceRef, NotificationChain msgs) {
		InteractionNode oldSourceRef = sourceRef;
		sourceRef = newSourceRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.CONVERSATION_LINK__SOURCE_REF, oldSourceRef, newSourceRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceRef(InteractionNode newSourceRef) {
		if (newSourceRef != sourceRef) {
			NotificationChain msgs = null;
			if (sourceRef != null)
				msgs = ((InternalEObject)sourceRef).eInverseRemove(this, BPMNProfilePackage.INTERACTION_NODE__OUTGOING_CONVERSATION_LINKS, InteractionNode.class, msgs);
			if (newSourceRef != null)
				msgs = ((InternalEObject)newSourceRef).eInverseAdd(this, BPMNProfilePackage.INTERACTION_NODE__OUTGOING_CONVERSATION_LINKS, InteractionNode.class, msgs);
			msgs = basicSetSourceRef(newSourceRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.CONVERSATION_LINK__SOURCE_REF, newSourceRef, newSourceRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BPMNProfilePackage.CONVERSATION_LINK__COLLABORATION:
				if (collaboration != null)
					msgs = ((InternalEObject)collaboration).eInverseRemove(this, BPMNProfilePackage.BPMN_COLLABORATION__CONVERSATION_LINKS, BPMNCollaboration.class, msgs);
				return basicSetCollaboration((BPMNCollaboration)otherEnd, msgs);
			case BPMNProfilePackage.CONVERSATION_LINK__TARGET_REF:
				if (targetRef != null)
					msgs = ((InternalEObject)targetRef).eInverseRemove(this, BPMNProfilePackage.INTERACTION_NODE__INCOMING_CONVERSATION_LINKS, InteractionNode.class, msgs);
				return basicSetTargetRef((InteractionNode)otherEnd, msgs);
			case BPMNProfilePackage.CONVERSATION_LINK__SOURCE_REF:
				if (sourceRef != null)
					msgs = ((InternalEObject)sourceRef).eInverseRemove(this, BPMNProfilePackage.INTERACTION_NODE__OUTGOING_CONVERSATION_LINKS, InteractionNode.class, msgs);
				return basicSetSourceRef((InteractionNode)otherEnd, msgs);
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
			case BPMNProfilePackage.CONVERSATION_LINK__COLLABORATION:
				return basicSetCollaboration(null, msgs);
			case BPMNProfilePackage.CONVERSATION_LINK__TARGET_REF:
				return basicSetTargetRef(null, msgs);
			case BPMNProfilePackage.CONVERSATION_LINK__SOURCE_REF:
				return basicSetSourceRef(null, msgs);
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
			case BPMNProfilePackage.CONVERSATION_LINK__COLLABORATION:
				if (resolve) return getCollaboration();
				return basicGetCollaboration();
			case BPMNProfilePackage.CONVERSATION_LINK__BASE_DEPENDENCY:
				if (resolve) return getBase_Dependency();
				return basicGetBase_Dependency();
			case BPMNProfilePackage.CONVERSATION_LINK__TARGET_REF:
				if (resolve) return getTargetRef();
				return basicGetTargetRef();
			case BPMNProfilePackage.CONVERSATION_LINK__SOURCE_REF:
				if (resolve) return getSourceRef();
				return basicGetSourceRef();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BPMNProfilePackage.CONVERSATION_LINK__COLLABORATION:
				setCollaboration((BPMNCollaboration)newValue);
				return;
			case BPMNProfilePackage.CONVERSATION_LINK__BASE_DEPENDENCY:
				setBase_Dependency((Dependency)newValue);
				return;
			case BPMNProfilePackage.CONVERSATION_LINK__TARGET_REF:
				setTargetRef((InteractionNode)newValue);
				return;
			case BPMNProfilePackage.CONVERSATION_LINK__SOURCE_REF:
				setSourceRef((InteractionNode)newValue);
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
			case BPMNProfilePackage.CONVERSATION_LINK__COLLABORATION:
				setCollaboration((BPMNCollaboration)null);
				return;
			case BPMNProfilePackage.CONVERSATION_LINK__BASE_DEPENDENCY:
				setBase_Dependency((Dependency)null);
				return;
			case BPMNProfilePackage.CONVERSATION_LINK__TARGET_REF:
				setTargetRef((InteractionNode)null);
				return;
			case BPMNProfilePackage.CONVERSATION_LINK__SOURCE_REF:
				setSourceRef((InteractionNode)null);
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
			case BPMNProfilePackage.CONVERSATION_LINK__COLLABORATION:
				return collaboration != null;
			case BPMNProfilePackage.CONVERSATION_LINK__BASE_DEPENDENCY:
				return base_Dependency != null;
			case BPMNProfilePackage.CONVERSATION_LINK__TARGET_REF:
				return targetRef != null;
			case BPMNProfilePackage.CONVERSATION_LINK__SOURCE_REF:
				return sourceRef != null;
		}
		return super.eIsSet(featureID);
	}

} //ConversationLinkImpl
