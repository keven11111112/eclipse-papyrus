/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import java.lang.reflect.InvocationTargetException;

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

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.ExclusiveGateway;
import org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow;

import org.eclipse.papyrus.bpmn.BPMNProfile.util.BPMNProfileValidator;

import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.MergeNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exclusive Gateway</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ExclusiveGatewayImpl#getBase_DecisionNode <em>Base Decision Node</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ExclusiveGatewayImpl#getBase_MergeNode <em>Base Merge Node</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ExclusiveGatewayImpl#getDefault <em>Default</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExclusiveGatewayImpl extends GatewayImpl implements ExclusiveGateway {
	/**
	 * The cached value of the '{@link #getBase_DecisionNode() <em>Base Decision Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_DecisionNode()
	 * @generated
	 * @ordered
	 */
	protected DecisionNode base_DecisionNode;

	/**
	 * The cached value of the '{@link #getBase_MergeNode() <em>Base Merge Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_MergeNode()
	 * @generated
	 * @ordered
	 */
	protected MergeNode base_MergeNode;

	/**
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected SequenceFlow default_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExclusiveGatewayImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getExclusiveGateway();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecisionNode getBase_DecisionNode() {
		if (base_DecisionNode != null && base_DecisionNode.eIsProxy()) {
			InternalEObject oldBase_DecisionNode = (InternalEObject)base_DecisionNode;
			base_DecisionNode = (DecisionNode)eResolveProxy(oldBase_DecisionNode);
			if (base_DecisionNode != oldBase_DecisionNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.EXCLUSIVE_GATEWAY__BASE_DECISION_NODE, oldBase_DecisionNode, base_DecisionNode));
			}
		}
		return base_DecisionNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecisionNode basicGetBase_DecisionNode() {
		return base_DecisionNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_DecisionNode(DecisionNode newBase_DecisionNode) {
		DecisionNode oldBase_DecisionNode = base_DecisionNode;
		base_DecisionNode = newBase_DecisionNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.EXCLUSIVE_GATEWAY__BASE_DECISION_NODE, oldBase_DecisionNode, base_DecisionNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MergeNode getBase_MergeNode() {
		if (base_MergeNode != null && base_MergeNode.eIsProxy()) {
			InternalEObject oldBase_MergeNode = (InternalEObject)base_MergeNode;
			base_MergeNode = (MergeNode)eResolveProxy(oldBase_MergeNode);
			if (base_MergeNode != oldBase_MergeNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.EXCLUSIVE_GATEWAY__BASE_MERGE_NODE, oldBase_MergeNode, base_MergeNode));
			}
		}
		return base_MergeNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MergeNode basicGetBase_MergeNode() {
		return base_MergeNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_MergeNode(MergeNode newBase_MergeNode) {
		MergeNode oldBase_MergeNode = base_MergeNode;
		base_MergeNode = newBase_MergeNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.EXCLUSIVE_GATEWAY__BASE_MERGE_NODE, oldBase_MergeNode, base_MergeNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceFlow getDefault() {
		if (default_ != null && default_.eIsProxy()) {
			InternalEObject oldDefault = (InternalEObject)default_;
			default_ = (SequenceFlow)eResolveProxy(oldDefault);
			if (default_ != oldDefault) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.EXCLUSIVE_GATEWAY__DEFAULT, oldDefault, default_));
			}
		}
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceFlow basicGetDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(SequenceFlow newDefault) {
		SequenceFlow oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.EXCLUSIVE_GATEWAY__DEFAULT, oldDefault, default_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean exclusiveGatewaydefault(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.EXCLUSIVE_GATEWAY__EXCLUSIVE_GATEWAYDEFAULT,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "exclusiveGatewaydefault", EObjectValidator.getObjectLabel(this, context) }),
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
			case BPMNProfilePackage.EXCLUSIVE_GATEWAY__BASE_DECISION_NODE:
				if (resolve) return getBase_DecisionNode();
				return basicGetBase_DecisionNode();
			case BPMNProfilePackage.EXCLUSIVE_GATEWAY__BASE_MERGE_NODE:
				if (resolve) return getBase_MergeNode();
				return basicGetBase_MergeNode();
			case BPMNProfilePackage.EXCLUSIVE_GATEWAY__DEFAULT:
				if (resolve) return getDefault();
				return basicGetDefault();
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
			case BPMNProfilePackage.EXCLUSIVE_GATEWAY__BASE_DECISION_NODE:
				setBase_DecisionNode((DecisionNode)newValue);
				return;
			case BPMNProfilePackage.EXCLUSIVE_GATEWAY__BASE_MERGE_NODE:
				setBase_MergeNode((MergeNode)newValue);
				return;
			case BPMNProfilePackage.EXCLUSIVE_GATEWAY__DEFAULT:
				setDefault((SequenceFlow)newValue);
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
			case BPMNProfilePackage.EXCLUSIVE_GATEWAY__BASE_DECISION_NODE:
				setBase_DecisionNode((DecisionNode)null);
				return;
			case BPMNProfilePackage.EXCLUSIVE_GATEWAY__BASE_MERGE_NODE:
				setBase_MergeNode((MergeNode)null);
				return;
			case BPMNProfilePackage.EXCLUSIVE_GATEWAY__DEFAULT:
				setDefault((SequenceFlow)null);
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
			case BPMNProfilePackage.EXCLUSIVE_GATEWAY__BASE_DECISION_NODE:
				return base_DecisionNode != null;
			case BPMNProfilePackage.EXCLUSIVE_GATEWAY__BASE_MERGE_NODE:
				return base_MergeNode != null;
			case BPMNProfilePackage.EXCLUSIVE_GATEWAY__DEFAULT:
				return default_ != null;
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
			case BPMNProfilePackage.EXCLUSIVE_GATEWAY___EXCLUSIVE_GATEWAYDEFAULT__DIAGNOSTICCHAIN_MAP:
				return exclusiveGatewaydefault((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ExclusiveGatewayImpl
