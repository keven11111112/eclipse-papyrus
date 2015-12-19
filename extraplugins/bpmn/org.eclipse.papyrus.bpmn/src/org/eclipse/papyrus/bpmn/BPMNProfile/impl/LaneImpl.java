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

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement;
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowNode;
import org.eclipse.papyrus.bpmn.BPMNProfile.Lane;
import org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet;

import org.eclipse.papyrus.bpmn.BPMNProfile.util.BPMNProfileValidator;

import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Element;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lane</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.LaneImpl#getBase_ActivityPartition <em>Base Activity Partition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.LaneImpl#get_partitionElement <em>partition Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.LaneImpl#getFlowNodeRefs <em>Flow Node Refs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.LaneImpl#getPartitionElementRef <em>Partition Element Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.LaneImpl#getChildLaneSet <em>Child Lane Set</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.LaneImpl#getLaneSet <em>Lane Set</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LaneImpl extends BaseElementImpl implements Lane {
	/**
	 * The cached value of the '{@link #getBase_ActivityPartition() <em>Base Activity Partition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_ActivityPartition()
	 * @generated
	 * @ordered
	 */
	protected ActivityPartition base_ActivityPartition;

	/**
	 * The cached value of the '{@link #get_partitionElement() <em>partition Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #get_partitionElement()
	 * @generated
	 * @ordered
	 */
	protected Element _partitionElement;

	/**
	 * The cached value of the '{@link #getFlowNodeRefs() <em>Flow Node Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlowNodeRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<FlowNode> flowNodeRefs;

	/**
	 * The cached value of the '{@link #getPartitionElementRef() <em>Partition Element Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartitionElementRef()
	 * @generated
	 * @ordered
	 */
	protected BaseElement partitionElementRef;

	/**
	 * The cached value of the '{@link #getChildLaneSet() <em>Child Lane Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildLaneSet()
	 * @generated
	 * @ordered
	 */
	protected LaneSet childLaneSet;

	/**
	 * The cached value of the '{@link #getLaneSet() <em>Lane Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaneSet()
	 * @generated
	 * @ordered
	 */
	protected LaneSet laneSet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LaneImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getLane();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityPartition getBase_ActivityPartition() {
		if (base_ActivityPartition != null && base_ActivityPartition.eIsProxy()) {
			InternalEObject oldBase_ActivityPartition = (InternalEObject)base_ActivityPartition;
			base_ActivityPartition = (ActivityPartition)eResolveProxy(oldBase_ActivityPartition);
			if (base_ActivityPartition != oldBase_ActivityPartition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.LANE__BASE_ACTIVITY_PARTITION, oldBase_ActivityPartition, base_ActivityPartition));
			}
		}
		return base_ActivityPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityPartition basicGetBase_ActivityPartition() {
		return base_ActivityPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_ActivityPartition(ActivityPartition newBase_ActivityPartition) {
		ActivityPartition oldBase_ActivityPartition = base_ActivityPartition;
		base_ActivityPartition = newBase_ActivityPartition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.LANE__BASE_ACTIVITY_PARTITION, oldBase_ActivityPartition, base_ActivityPartition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element get_partitionElement() {
		if (_partitionElement != null && _partitionElement.eIsProxy()) {
			InternalEObject old_partitionElement = (InternalEObject)_partitionElement;
			_partitionElement = (Element)eResolveProxy(old_partitionElement);
			if (_partitionElement != old_partitionElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.LANE__PARTITION_ELEMENT, old_partitionElement, _partitionElement));
			}
		}
		return _partitionElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGet_partitionElement() {
		return _partitionElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void set_partitionElement(Element new_partitionElement) {
		Element old_partitionElement = _partitionElement;
		_partitionElement = new_partitionElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.LANE__PARTITION_ELEMENT, old_partitionElement, _partitionElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FlowNode> getFlowNodeRefs() {
		if (flowNodeRefs == null) {
			flowNodeRefs = new EObjectResolvingEList<FlowNode>(FlowNode.class, this, BPMNProfilePackage.LANE__FLOW_NODE_REFS);
		}
		return flowNodeRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseElement getPartitionElementRef() {
		if (partitionElementRef != null && partitionElementRef.eIsProxy()) {
			InternalEObject oldPartitionElementRef = (InternalEObject)partitionElementRef;
			partitionElementRef = (BaseElement)eResolveProxy(oldPartitionElementRef);
			if (partitionElementRef != oldPartitionElementRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.LANE__PARTITION_ELEMENT_REF, oldPartitionElementRef, partitionElementRef));
			}
		}
		return partitionElementRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseElement basicGetPartitionElementRef() {
		return partitionElementRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartitionElementRef(BaseElement newPartitionElementRef) {
		BaseElement oldPartitionElementRef = partitionElementRef;
		partitionElementRef = newPartitionElementRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.LANE__PARTITION_ELEMENT_REF, oldPartitionElementRef, partitionElementRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LaneSet getChildLaneSet() {
		if (childLaneSet != null && childLaneSet.eIsProxy()) {
			InternalEObject oldChildLaneSet = (InternalEObject)childLaneSet;
			childLaneSet = (LaneSet)eResolveProxy(oldChildLaneSet);
			if (childLaneSet != oldChildLaneSet) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.LANE__CHILD_LANE_SET, oldChildLaneSet, childLaneSet));
			}
		}
		return childLaneSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LaneSet basicGetChildLaneSet() {
		return childLaneSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildLaneSet(LaneSet newChildLaneSet) {
		LaneSet oldChildLaneSet = childLaneSet;
		childLaneSet = newChildLaneSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.LANE__CHILD_LANE_SET, oldChildLaneSet, childLaneSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LaneSet getLaneSet() {
		if (laneSet != null && laneSet.eIsProxy()) {
			InternalEObject oldLaneSet = (InternalEObject)laneSet;
			laneSet = (LaneSet)eResolveProxy(oldLaneSet);
			if (laneSet != oldLaneSet) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.LANE__LANE_SET, oldLaneSet, laneSet));
			}
		}
		return laneSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LaneSet basicGetLaneSet() {
		return laneSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLaneSet(LaneSet newLaneSet, NotificationChain msgs) {
		LaneSet oldLaneSet = laneSet;
		laneSet = newLaneSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.LANE__LANE_SET, oldLaneSet, newLaneSet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLaneSet(LaneSet newLaneSet) {
		if (newLaneSet != laneSet) {
			NotificationChain msgs = null;
			if (laneSet != null)
				msgs = ((InternalEObject)laneSet).eInverseRemove(this, BPMNProfilePackage.LANE_SET__LANES, LaneSet.class, msgs);
			if (newLaneSet != null)
				msgs = ((InternalEObject)newLaneSet).eInverseAdd(this, BPMNProfilePackage.LANE_SET__LANES, LaneSet.class, msgs);
			msgs = basicSetLaneSet(newLaneSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.LANE__LANE_SET, newLaneSet, newLaneSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean LanelaneSet(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.LANE__LANELANE_SET,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "LanelaneSet", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean LanechildLaneSet(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.LANE__LANECHILD_LANE_SET,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "LanechildLaneSet", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean LanepartitionElementRef(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.LANE__LANEPARTITION_ELEMENT_REF,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "LanepartitionElementRef", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean LaneflowNodeRefs(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.LANE__LANEFLOW_NODE_REFS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "LaneflowNodeRefs", EObjectValidator.getObjectLabel(this, context) }),
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
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BPMNProfilePackage.LANE__LANE_SET:
				if (laneSet != null)
					msgs = ((InternalEObject)laneSet).eInverseRemove(this, BPMNProfilePackage.LANE_SET__LANES, LaneSet.class, msgs);
				return basicSetLaneSet((LaneSet)otherEnd, msgs);
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
			case BPMNProfilePackage.LANE__LANE_SET:
				return basicSetLaneSet(null, msgs);
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
			case BPMNProfilePackage.LANE__BASE_ACTIVITY_PARTITION:
				if (resolve) return getBase_ActivityPartition();
				return basicGetBase_ActivityPartition();
			case BPMNProfilePackage.LANE__PARTITION_ELEMENT:
				if (resolve) return get_partitionElement();
				return basicGet_partitionElement();
			case BPMNProfilePackage.LANE__FLOW_NODE_REFS:
				return getFlowNodeRefs();
			case BPMNProfilePackage.LANE__PARTITION_ELEMENT_REF:
				if (resolve) return getPartitionElementRef();
				return basicGetPartitionElementRef();
			case BPMNProfilePackage.LANE__CHILD_LANE_SET:
				if (resolve) return getChildLaneSet();
				return basicGetChildLaneSet();
			case BPMNProfilePackage.LANE__LANE_SET:
				if (resolve) return getLaneSet();
				return basicGetLaneSet();
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
			case BPMNProfilePackage.LANE__BASE_ACTIVITY_PARTITION:
				setBase_ActivityPartition((ActivityPartition)newValue);
				return;
			case BPMNProfilePackage.LANE__PARTITION_ELEMENT:
				set_partitionElement((Element)newValue);
				return;
			case BPMNProfilePackage.LANE__FLOW_NODE_REFS:
				getFlowNodeRefs().clear();
				getFlowNodeRefs().addAll((Collection<? extends FlowNode>)newValue);
				return;
			case BPMNProfilePackage.LANE__PARTITION_ELEMENT_REF:
				setPartitionElementRef((BaseElement)newValue);
				return;
			case BPMNProfilePackage.LANE__CHILD_LANE_SET:
				setChildLaneSet((LaneSet)newValue);
				return;
			case BPMNProfilePackage.LANE__LANE_SET:
				setLaneSet((LaneSet)newValue);
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
			case BPMNProfilePackage.LANE__BASE_ACTIVITY_PARTITION:
				setBase_ActivityPartition((ActivityPartition)null);
				return;
			case BPMNProfilePackage.LANE__PARTITION_ELEMENT:
				set_partitionElement((Element)null);
				return;
			case BPMNProfilePackage.LANE__FLOW_NODE_REFS:
				getFlowNodeRefs().clear();
				return;
			case BPMNProfilePackage.LANE__PARTITION_ELEMENT_REF:
				setPartitionElementRef((BaseElement)null);
				return;
			case BPMNProfilePackage.LANE__CHILD_LANE_SET:
				setChildLaneSet((LaneSet)null);
				return;
			case BPMNProfilePackage.LANE__LANE_SET:
				setLaneSet((LaneSet)null);
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
			case BPMNProfilePackage.LANE__BASE_ACTIVITY_PARTITION:
				return base_ActivityPartition != null;
			case BPMNProfilePackage.LANE__PARTITION_ELEMENT:
				return _partitionElement != null;
			case BPMNProfilePackage.LANE__FLOW_NODE_REFS:
				return flowNodeRefs != null && !flowNodeRefs.isEmpty();
			case BPMNProfilePackage.LANE__PARTITION_ELEMENT_REF:
				return partitionElementRef != null;
			case BPMNProfilePackage.LANE__CHILD_LANE_SET:
				return childLaneSet != null;
			case BPMNProfilePackage.LANE__LANE_SET:
				return laneSet != null;
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
			case BPMNProfilePackage.LANE___LANELANE_SET__DIAGNOSTICCHAIN_MAP:
				return LanelaneSet((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.LANE___LANECHILD_LANE_SET__DIAGNOSTICCHAIN_MAP:
				return LanechildLaneSet((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.LANE___LANEPARTITION_ELEMENT_REF__DIAGNOSTICCHAIN_MAP:
				return LanepartitionElementRef((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.LANE___LANEFLOW_NODE_REFS__DIAGNOSTICCHAIN_MAP:
				return LaneflowNodeRefs((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //LaneImpl
