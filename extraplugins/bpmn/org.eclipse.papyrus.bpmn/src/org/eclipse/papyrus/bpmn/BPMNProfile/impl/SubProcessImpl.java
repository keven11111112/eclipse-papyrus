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
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement;
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowElementsContainer;
import org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet;
import org.eclipse.papyrus.bpmn.BPMNProfile.SubProcess;

import org.eclipse.papyrus.bpmn.BPMNProfile.util.BPMNProfileValidator;

import org.eclipse.uml2.uml.StructuredActivityNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.SubProcessImpl#getLaneSets <em>Lane Sets</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.SubProcessImpl#getFlowElements <em>Flow Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.SubProcessImpl#isTriggeredByEvent <em>Triggered By Event</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.SubProcessImpl#getBase_StructuredActivityNode <em>Base Structured Activity Node</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.SubProcessImpl#getHasLaneSets <em>Has Lane Sets</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubProcessImpl extends BPMNActivityImpl implements SubProcess {
	/**
	 * The cached value of the '{@link #getLaneSets() <em>Lane Sets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaneSets()
	 * @generated
	 * @ordered
	 */
	protected EList<LaneSet> laneSets;

	/**
	 * The cached value of the '{@link #getFlowElements() <em>Flow Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlowElements()
	 * @generated
	 * @ordered
	 */
	protected EList<FlowElement> flowElements;

	/**
	 * The default value of the '{@link #isTriggeredByEvent() <em>Triggered By Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTriggeredByEvent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRIGGERED_BY_EVENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTriggeredByEvent() <em>Triggered By Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTriggeredByEvent()
	 * @generated
	 * @ordered
	 */
	protected boolean triggeredByEvent = TRIGGERED_BY_EVENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_StructuredActivityNode() <em>Base Structured Activity Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_StructuredActivityNode()
	 * @generated
	 * @ordered
	 */
	protected StructuredActivityNode base_StructuredActivityNode;

	/**
	 * The cached value of the '{@link #getHasLaneSets() <em>Has Lane Sets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasLaneSets()
	 * @generated
	 * @ordered
	 */
	protected EList<LaneSet> hasLaneSets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubProcessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getSubProcess();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LaneSet> getLaneSets() {
		if (laneSets == null) {
			laneSets = new EObjectWithInverseResolvingEList<LaneSet>(LaneSet.class, this, BPMNProfilePackage.SUB_PROCESS__LANE_SETS, BPMNProfilePackage.LANE_SET__FLOW_ELEMENTS_CONTAINER);
		}
		return laneSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FlowElement> getFlowElements() {
		if (flowElements == null) {
			flowElements = new EObjectWithInverseResolvingEList<FlowElement>(FlowElement.class, this, BPMNProfilePackage.SUB_PROCESS__FLOW_ELEMENTS, BPMNProfilePackage.FLOW_ELEMENT__CONTAINER);
		}
		return flowElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTriggeredByEvent() {
		return triggeredByEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTriggeredByEvent(boolean newTriggeredByEvent) {
		boolean oldTriggeredByEvent = triggeredByEvent;
		triggeredByEvent = newTriggeredByEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.SUB_PROCESS__TRIGGERED_BY_EVENT, oldTriggeredByEvent, triggeredByEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuredActivityNode getBase_StructuredActivityNode() {
		if (base_StructuredActivityNode != null && base_StructuredActivityNode.eIsProxy()) {
			InternalEObject oldBase_StructuredActivityNode = (InternalEObject)base_StructuredActivityNode;
			base_StructuredActivityNode = (StructuredActivityNode)eResolveProxy(oldBase_StructuredActivityNode);
			if (base_StructuredActivityNode != oldBase_StructuredActivityNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.SUB_PROCESS__BASE_STRUCTURED_ACTIVITY_NODE, oldBase_StructuredActivityNode, base_StructuredActivityNode));
			}
		}
		return base_StructuredActivityNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuredActivityNode basicGetBase_StructuredActivityNode() {
		return base_StructuredActivityNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_StructuredActivityNode(StructuredActivityNode newBase_StructuredActivityNode) {
		StructuredActivityNode oldBase_StructuredActivityNode = base_StructuredActivityNode;
		base_StructuredActivityNode = newBase_StructuredActivityNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.SUB_PROCESS__BASE_STRUCTURED_ACTIVITY_NODE, oldBase_StructuredActivityNode, base_StructuredActivityNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LaneSet> getHasLaneSets() {
		if (hasLaneSets == null) {
			hasLaneSets = new EObjectResolvingEList<LaneSet>(LaneSet.class, this, BPMNProfilePackage.SUB_PROCESS__HAS_LANE_SETS);
		}
		return hasLaneSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean SubProcesstriggeredByEvent(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.SUB_PROCESS__SUB_PROCESSTRIGGERED_BY_EVENT,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "SubProcesstriggeredByEvent", EObjectValidator.getObjectLabel(this, context) }),
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
			case BPMNProfilePackage.SUB_PROCESS__LANE_SETS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLaneSets()).basicAdd(otherEnd, msgs);
			case BPMNProfilePackage.SUB_PROCESS__FLOW_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFlowElements()).basicAdd(otherEnd, msgs);
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
			case BPMNProfilePackage.SUB_PROCESS__LANE_SETS:
				return ((InternalEList<?>)getLaneSets()).basicRemove(otherEnd, msgs);
			case BPMNProfilePackage.SUB_PROCESS__FLOW_ELEMENTS:
				return ((InternalEList<?>)getFlowElements()).basicRemove(otherEnd, msgs);
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
			case BPMNProfilePackage.SUB_PROCESS__LANE_SETS:
				return getLaneSets();
			case BPMNProfilePackage.SUB_PROCESS__FLOW_ELEMENTS:
				return getFlowElements();
			case BPMNProfilePackage.SUB_PROCESS__TRIGGERED_BY_EVENT:
				return isTriggeredByEvent();
			case BPMNProfilePackage.SUB_PROCESS__BASE_STRUCTURED_ACTIVITY_NODE:
				if (resolve) return getBase_StructuredActivityNode();
				return basicGetBase_StructuredActivityNode();
			case BPMNProfilePackage.SUB_PROCESS__HAS_LANE_SETS:
				return getHasLaneSets();
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
			case BPMNProfilePackage.SUB_PROCESS__LANE_SETS:
				getLaneSets().clear();
				getLaneSets().addAll((Collection<? extends LaneSet>)newValue);
				return;
			case BPMNProfilePackage.SUB_PROCESS__FLOW_ELEMENTS:
				getFlowElements().clear();
				getFlowElements().addAll((Collection<? extends FlowElement>)newValue);
				return;
			case BPMNProfilePackage.SUB_PROCESS__TRIGGERED_BY_EVENT:
				setTriggeredByEvent((Boolean)newValue);
				return;
			case BPMNProfilePackage.SUB_PROCESS__BASE_STRUCTURED_ACTIVITY_NODE:
				setBase_StructuredActivityNode((StructuredActivityNode)newValue);
				return;
			case BPMNProfilePackage.SUB_PROCESS__HAS_LANE_SETS:
				getHasLaneSets().clear();
				getHasLaneSets().addAll((Collection<? extends LaneSet>)newValue);
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
			case BPMNProfilePackage.SUB_PROCESS__LANE_SETS:
				getLaneSets().clear();
				return;
			case BPMNProfilePackage.SUB_PROCESS__FLOW_ELEMENTS:
				getFlowElements().clear();
				return;
			case BPMNProfilePackage.SUB_PROCESS__TRIGGERED_BY_EVENT:
				setTriggeredByEvent(TRIGGERED_BY_EVENT_EDEFAULT);
				return;
			case BPMNProfilePackage.SUB_PROCESS__BASE_STRUCTURED_ACTIVITY_NODE:
				setBase_StructuredActivityNode((StructuredActivityNode)null);
				return;
			case BPMNProfilePackage.SUB_PROCESS__HAS_LANE_SETS:
				getHasLaneSets().clear();
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
			case BPMNProfilePackage.SUB_PROCESS__LANE_SETS:
				return laneSets != null && !laneSets.isEmpty();
			case BPMNProfilePackage.SUB_PROCESS__FLOW_ELEMENTS:
				return flowElements != null && !flowElements.isEmpty();
			case BPMNProfilePackage.SUB_PROCESS__TRIGGERED_BY_EVENT:
				return triggeredByEvent != TRIGGERED_BY_EVENT_EDEFAULT;
			case BPMNProfilePackage.SUB_PROCESS__BASE_STRUCTURED_ACTIVITY_NODE:
				return base_StructuredActivityNode != null;
			case BPMNProfilePackage.SUB_PROCESS__HAS_LANE_SETS:
				return hasLaneSets != null && !hasLaneSets.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == FlowElementsContainer.class) {
			switch (derivedFeatureID) {
				case BPMNProfilePackage.SUB_PROCESS__LANE_SETS: return BPMNProfilePackage.FLOW_ELEMENTS_CONTAINER__LANE_SETS;
				case BPMNProfilePackage.SUB_PROCESS__FLOW_ELEMENTS: return BPMNProfilePackage.FLOW_ELEMENTS_CONTAINER__FLOW_ELEMENTS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == FlowElementsContainer.class) {
			switch (baseFeatureID) {
				case BPMNProfilePackage.FLOW_ELEMENTS_CONTAINER__LANE_SETS: return BPMNProfilePackage.SUB_PROCESS__LANE_SETS;
				case BPMNProfilePackage.FLOW_ELEMENTS_CONTAINER__FLOW_ELEMENTS: return BPMNProfilePackage.SUB_PROCESS__FLOW_ELEMENTS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
			case BPMNProfilePackage.SUB_PROCESS___SUB_PROCESSTRIGGERED_BY_EVENT__DIAGNOSTICCHAIN_MAP:
				return SubProcesstriggeredByEvent((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		result.append(" (triggeredByEvent: ");
		result.append(triggeredByEvent);
		result.append(')');
		return result.toString();
	}

} //SubProcessImpl
