/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

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
import org.eclipse.papyrus.bpmn.BPMNProfile.DataInputAssociation;
import org.eclipse.papyrus.bpmn.BPMNProfile.ThrowEvent;

import org.eclipse.papyrus.bpmn.BPMNProfile.util.BPMNProfileValidator;

import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.FlowFinalNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Throw Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ThrowEventImpl#getBase_CallOperationAction <em>Base Call Operation Action</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ThrowEventImpl#getBase_FlowFinalNode <em>Base Flow Final Node</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ThrowEventImpl#getDataInputAssociation <em>Data Input Association</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ThrowEventImpl extends BPMNEventImpl implements ThrowEvent {
	/**
	 * The cached value of the '{@link #getBase_CallOperationAction() <em>Base Call Operation Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_CallOperationAction()
	 * @generated
	 * @ordered
	 */
	protected CallOperationAction base_CallOperationAction;

	/**
	 * The cached value of the '{@link #getBase_FlowFinalNode() <em>Base Flow Final Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_FlowFinalNode()
	 * @generated
	 * @ordered
	 */
	protected FlowFinalNode base_FlowFinalNode;

	/**
	 * The cached value of the '{@link #getDataInputAssociation() <em>Data Input Association</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataInputAssociation()
	 * @generated
	 * @ordered
	 */
	protected EList<DataInputAssociation> dataInputAssociation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThrowEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getThrowEvent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallOperationAction getBase_CallOperationAction() {
		if (base_CallOperationAction != null && base_CallOperationAction.eIsProxy()) {
			InternalEObject oldBase_CallOperationAction = (InternalEObject)base_CallOperationAction;
			base_CallOperationAction = (CallOperationAction)eResolveProxy(oldBase_CallOperationAction);
			if (base_CallOperationAction != oldBase_CallOperationAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.THROW_EVENT__BASE_CALL_OPERATION_ACTION, oldBase_CallOperationAction, base_CallOperationAction));
			}
		}
		return base_CallOperationAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallOperationAction basicGetBase_CallOperationAction() {
		return base_CallOperationAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_CallOperationAction(CallOperationAction newBase_CallOperationAction) {
		CallOperationAction oldBase_CallOperationAction = base_CallOperationAction;
		base_CallOperationAction = newBase_CallOperationAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.THROW_EVENT__BASE_CALL_OPERATION_ACTION, oldBase_CallOperationAction, base_CallOperationAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowFinalNode getBase_FlowFinalNode() {
		if (base_FlowFinalNode != null && base_FlowFinalNode.eIsProxy()) {
			InternalEObject oldBase_FlowFinalNode = (InternalEObject)base_FlowFinalNode;
			base_FlowFinalNode = (FlowFinalNode)eResolveProxy(oldBase_FlowFinalNode);
			if (base_FlowFinalNode != oldBase_FlowFinalNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.THROW_EVENT__BASE_FLOW_FINAL_NODE, oldBase_FlowFinalNode, base_FlowFinalNode));
			}
		}
		return base_FlowFinalNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowFinalNode basicGetBase_FlowFinalNode() {
		return base_FlowFinalNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_FlowFinalNode(FlowFinalNode newBase_FlowFinalNode) {
		FlowFinalNode oldBase_FlowFinalNode = base_FlowFinalNode;
		base_FlowFinalNode = newBase_FlowFinalNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.THROW_EVENT__BASE_FLOW_FINAL_NODE, oldBase_FlowFinalNode, base_FlowFinalNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataInputAssociation> getDataInputAssociation() {
		if (dataInputAssociation == null) {
			dataInputAssociation = new EObjectResolvingEList<DataInputAssociation>(DataInputAssociation.class, this, BPMNProfilePackage.THROW_EVENT__DATA_INPUT_ASSOCIATION);
		}
		return dataInputAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ThrowEventeventDefinitionRefs(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.THROW_EVENT__THROW_EVENTEVENT_DEFINITION_REFS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ThrowEventeventDefinitionRefs", EObjectValidator.getObjectLabel(this, context) }),
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.THROW_EVENT__BASE_CALL_OPERATION_ACTION:
				if (resolve) return getBase_CallOperationAction();
				return basicGetBase_CallOperationAction();
			case BPMNProfilePackage.THROW_EVENT__BASE_FLOW_FINAL_NODE:
				if (resolve) return getBase_FlowFinalNode();
				return basicGetBase_FlowFinalNode();
			case BPMNProfilePackage.THROW_EVENT__DATA_INPUT_ASSOCIATION:
				return getDataInputAssociation();
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
			case BPMNProfilePackage.THROW_EVENT__BASE_CALL_OPERATION_ACTION:
				setBase_CallOperationAction((CallOperationAction)newValue);
				return;
			case BPMNProfilePackage.THROW_EVENT__BASE_FLOW_FINAL_NODE:
				setBase_FlowFinalNode((FlowFinalNode)newValue);
				return;
			case BPMNProfilePackage.THROW_EVENT__DATA_INPUT_ASSOCIATION:
				getDataInputAssociation().clear();
				getDataInputAssociation().addAll((Collection<? extends DataInputAssociation>)newValue);
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
			case BPMNProfilePackage.THROW_EVENT__BASE_CALL_OPERATION_ACTION:
				setBase_CallOperationAction((CallOperationAction)null);
				return;
			case BPMNProfilePackage.THROW_EVENT__BASE_FLOW_FINAL_NODE:
				setBase_FlowFinalNode((FlowFinalNode)null);
				return;
			case BPMNProfilePackage.THROW_EVENT__DATA_INPUT_ASSOCIATION:
				getDataInputAssociation().clear();
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
			case BPMNProfilePackage.THROW_EVENT__BASE_CALL_OPERATION_ACTION:
				return base_CallOperationAction != null;
			case BPMNProfilePackage.THROW_EVENT__BASE_FLOW_FINAL_NODE:
				return base_FlowFinalNode != null;
			case BPMNProfilePackage.THROW_EVENT__DATA_INPUT_ASSOCIATION:
				return dataInputAssociation != null && !dataInputAssociation.isEmpty();
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
			case BPMNProfilePackage.THROW_EVENT___THROW_EVENTEVENT_DEFINITION_REFS__DIAGNOSTICCHAIN_MAP:
				return ThrowEventeventDefinitionRefs((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ThrowEventImpl
