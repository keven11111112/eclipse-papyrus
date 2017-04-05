/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowNode;
import org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow;
import org.eclipse.uml2.uml.ActivityNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flow Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.FlowNodeImpl#getBase_ActivityNode <em>Base Activity Node</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.FlowNodeImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.FlowNodeImpl#getOutgoing <em>Outgoing</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FlowNodeImpl extends FlowElementImpl implements FlowNode {
	/**
	 * The cached value of the '{@link #getBase_ActivityNode() <em>Base Activity Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_ActivityNode()
	 * @generated
	 * @ordered
	 */
	protected ActivityNode base_ActivityNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getFlowNode();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityNode getBase_ActivityNode() {
		if (base_ActivityNode != null && base_ActivityNode.eIsProxy()) {
			InternalEObject oldBase_ActivityNode = (InternalEObject)base_ActivityNode;
			base_ActivityNode = (ActivityNode)eResolveProxy(oldBase_ActivityNode);
			if (base_ActivityNode != oldBase_ActivityNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.FLOW_NODE__BASE_ACTIVITY_NODE, oldBase_ActivityNode, base_ActivityNode));
			}
		}
		return base_ActivityNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityNode basicGetBase_ActivityNode() {
		return base_ActivityNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_ActivityNode(ActivityNode newBase_ActivityNode) {
		ActivityNode oldBase_ActivityNode = base_ActivityNode;
		base_ActivityNode = newBase_ActivityNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.FLOW_NODE__BASE_ACTIVITY_NODE, oldBase_ActivityNode, base_ActivityNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<BPMNAssociation> getIncoming() {
		if (incoming == null) {
			incoming = new EObjectWithInverseResolvingEList<BPMNAssociation>(SequenceFlow.class, this, BPMNProfilePackage.FLOW_NODE__INCOMING, BPMNProfilePackage.BPMN_ASSOCIATION__TARGET_REF);
		}
		return incoming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIncoming() {
		return incoming != null && !incoming.isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<BPMNAssociation> getOutgoing() {
		if (outgoing == null) {
			outgoing = new EObjectWithInverseResolvingEList<BPMNAssociation>(SequenceFlow.class, this, BPMNProfilePackage.FLOW_NODE__OUTGOING, BPMNProfilePackage.BPMN_ASSOCIATION__SOURCE_REF);
		}
		return outgoing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOutgoing() {
		return outgoing != null && !outgoing.isEmpty();
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
			case BPMNProfilePackage.FLOW_NODE__INCOMING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncoming()).basicAdd(otherEnd, msgs);
			case BPMNProfilePackage.FLOW_NODE__OUTGOING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoing()).basicAdd(otherEnd, msgs);
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
			case BPMNProfilePackage.FLOW_NODE__INCOMING:
				return ((InternalEList<?>)getIncoming()).basicRemove(otherEnd, msgs);
			case BPMNProfilePackage.FLOW_NODE__OUTGOING:
				return ((InternalEList<?>)getOutgoing()).basicRemove(otherEnd, msgs);
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
			case BPMNProfilePackage.FLOW_NODE__BASE_ACTIVITY_NODE:
				if (resolve) return getBase_ActivityNode();
				return basicGetBase_ActivityNode();
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
			case BPMNProfilePackage.FLOW_NODE__BASE_ACTIVITY_NODE:
				setBase_ActivityNode((ActivityNode)newValue);
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
			case BPMNProfilePackage.FLOW_NODE__BASE_ACTIVITY_NODE:
				setBase_ActivityNode((ActivityNode)null);
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
			case BPMNProfilePackage.FLOW_NODE__BASE_ACTIVITY_NODE:
				return base_ActivityNode != null;
			case BPMNProfilePackage.FLOW_NODE__INCOMING:
				return isSetIncoming();
			case BPMNProfilePackage.FLOW_NODE__OUTGOING:
				return isSetOutgoing();
		}
		return super.eIsSet(featureID);
	}

} //FlowNodeImpl
