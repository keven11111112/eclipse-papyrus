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
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNExpression;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowNode;
import org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow;
import org.eclipse.papyrus.bpmn.BPMNProfile.util.BPMNProfileValidator;
import org.eclipse.uml2.uml.ControlFlow;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.SequenceFlowImpl#getBase_ControlFlow <em>Base Control Flow</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.SequenceFlowImpl#isImmediate <em>Is Immediate</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.SequenceFlowImpl#getConditionExpression <em>Condition Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.SequenceFlowImpl#getSourceRef <em>Source Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.SequenceFlowImpl#getTargetRef <em>Target Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SequenceFlowImpl extends FlowElementImpl implements SequenceFlow {
	/**
	 * The cached value of the '{@link #getBase_ControlFlow() <em>Base Control Flow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_ControlFlow()
	 * @generated
	 * @ordered
	 */
	protected ControlFlow base_ControlFlow;

	/**
	 * The default value of the '{@link #isImmediate() <em>Is Immediate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImmediate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_IMMEDIATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isImmediate() <em>Is Immediate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImmediate()
	 * @generated
	 * @ordered
	 */
	protected boolean isImmediate = IS_IMMEDIATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConditionExpression() <em>Condition Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionExpression()
	 * @generated
	 * @ordered
	 */
	protected BPMNExpression conditionExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceFlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getSequenceFlow();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlFlow getBase_ControlFlow() {
		if (base_ControlFlow != null && base_ControlFlow.eIsProxy()) {
			InternalEObject oldBase_ControlFlow = (InternalEObject)base_ControlFlow;
			base_ControlFlow = (ControlFlow)eResolveProxy(oldBase_ControlFlow);
			if (base_ControlFlow != oldBase_ControlFlow) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.SEQUENCE_FLOW__BASE_CONTROL_FLOW, oldBase_ControlFlow, base_ControlFlow));
			}
		}
		return base_ControlFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlFlow basicGetBase_ControlFlow() {
		return base_ControlFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_ControlFlow(ControlFlow newBase_ControlFlow) {
		ControlFlow oldBase_ControlFlow = base_ControlFlow;
		base_ControlFlow = newBase_ControlFlow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.SEQUENCE_FLOW__BASE_CONTROL_FLOW, oldBase_ControlFlow, base_ControlFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isImmediate() {
		return isImmediate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsImmediate(boolean newIsImmediate) {
		boolean oldIsImmediate = isImmediate;
		isImmediate = newIsImmediate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.SEQUENCE_FLOW__IS_IMMEDIATE, oldIsImmediate, isImmediate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNExpression getConditionExpression() {
		if (conditionExpression != null && conditionExpression.eIsProxy()) {
			InternalEObject oldConditionExpression = (InternalEObject)conditionExpression;
			conditionExpression = (BPMNExpression)eResolveProxy(oldConditionExpression);
			if (conditionExpression != oldConditionExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.SEQUENCE_FLOW__CONDITION_EXPRESSION, oldConditionExpression, conditionExpression));
			}
		}
		return conditionExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNExpression basicGetConditionExpression() {
		return conditionExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditionExpression(BPMNExpression newConditionExpression) {
		BPMNExpression oldConditionExpression = conditionExpression;
		conditionExpression = newConditionExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.SEQUENCE_FLOW__CONDITION_EXPRESSION, oldConditionExpression, conditionExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowNode getSourceRef() {
		FlowNode sourceRef = basicGetSourceRef();
		return sourceRef != null && sourceRef.eIsProxy() ? (FlowNode)eResolveProxy((InternalEObject)sourceRef) : sourceRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FlowNode basicGetSourceRef() {
		return SequenceFlowCustom.basicGetSourceRef(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceRef(FlowNode newSourceRef) {
		// TODO: implement this method to set the 'Source Ref' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowNode getTargetRef() {
		FlowNode targetRef = basicGetTargetRef();
		return targetRef != null && targetRef.eIsProxy() ? (FlowNode)eResolveProxy((InternalEObject)targetRef) : targetRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FlowNode basicGetTargetRef() {
		return SequenceFlowCustom.basicGetTargetRef(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetRef(FlowNode newTargetRef) {
		// TODO: implement this method to set the 'Target Ref' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean SequenceFlowconditionExpression(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.SEQUENCE_FLOW__SEQUENCE_FLOWCONDITION_EXPRESSION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "SequenceFlowconditionExpression", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean SequenceFlowsourceRef(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.SEQUENCE_FLOW__SEQUENCE_FLOWSOURCE_REF,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "SequenceFlowsourceRef", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean SequenceFlowtargetRef(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.SEQUENCE_FLOW__SEQUENCE_FLOWTARGET_REF,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "SequenceFlowtargetRef", EObjectValidator.getObjectLabel(this, context) }),
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
			case BPMNProfilePackage.SEQUENCE_FLOW__BASE_CONTROL_FLOW:
				if (resolve) return getBase_ControlFlow();
				return basicGetBase_ControlFlow();
			case BPMNProfilePackage.SEQUENCE_FLOW__IS_IMMEDIATE:
				return isImmediate();
			case BPMNProfilePackage.SEQUENCE_FLOW__CONDITION_EXPRESSION:
				if (resolve) return getConditionExpression();
				return basicGetConditionExpression();
			case BPMNProfilePackage.SEQUENCE_FLOW__SOURCE_REF:
				if (resolve) return getSourceRef();
				return basicGetSourceRef();
			case BPMNProfilePackage.SEQUENCE_FLOW__TARGET_REF:
				if (resolve) return getTargetRef();
				return basicGetTargetRef();
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
			case BPMNProfilePackage.SEQUENCE_FLOW__BASE_CONTROL_FLOW:
				setBase_ControlFlow((ControlFlow)newValue);
				return;
			case BPMNProfilePackage.SEQUENCE_FLOW__IS_IMMEDIATE:
				setIsImmediate((Boolean)newValue);
				return;
			case BPMNProfilePackage.SEQUENCE_FLOW__CONDITION_EXPRESSION:
				setConditionExpression((BPMNExpression)newValue);
				return;
			case BPMNProfilePackage.SEQUENCE_FLOW__SOURCE_REF:
				setSourceRef((FlowNode)newValue);
				return;
			case BPMNProfilePackage.SEQUENCE_FLOW__TARGET_REF:
				setTargetRef((FlowNode)newValue);
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
			case BPMNProfilePackage.SEQUENCE_FLOW__BASE_CONTROL_FLOW:
				setBase_ControlFlow((ControlFlow)null);
				return;
			case BPMNProfilePackage.SEQUENCE_FLOW__IS_IMMEDIATE:
				setIsImmediate(IS_IMMEDIATE_EDEFAULT);
				return;
			case BPMNProfilePackage.SEQUENCE_FLOW__CONDITION_EXPRESSION:
				setConditionExpression((BPMNExpression)null);
				return;
			case BPMNProfilePackage.SEQUENCE_FLOW__SOURCE_REF:
				setSourceRef((FlowNode)null);
				return;
			case BPMNProfilePackage.SEQUENCE_FLOW__TARGET_REF:
				setTargetRef((FlowNode)null);
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
			case BPMNProfilePackage.SEQUENCE_FLOW__BASE_CONTROL_FLOW:
				return base_ControlFlow != null;
			case BPMNProfilePackage.SEQUENCE_FLOW__IS_IMMEDIATE:
				return isImmediate != IS_IMMEDIATE_EDEFAULT;
			case BPMNProfilePackage.SEQUENCE_FLOW__CONDITION_EXPRESSION:
				return conditionExpression != null;
			case BPMNProfilePackage.SEQUENCE_FLOW__SOURCE_REF:
				return basicGetSourceRef() != null;
			case BPMNProfilePackage.SEQUENCE_FLOW__TARGET_REF:
				return basicGetTargetRef() != null;
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
			case BPMNProfilePackage.SEQUENCE_FLOW___SEQUENCE_FLOWCONDITION_EXPRESSION__DIAGNOSTICCHAIN_MAP:
				return SequenceFlowconditionExpression((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.SEQUENCE_FLOW___SEQUENCE_FLOWSOURCE_REF__DIAGNOSTICCHAIN_MAP:
				return SequenceFlowsourceRef((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.SEQUENCE_FLOW___SEQUENCE_FLOWTARGET_REF__DIAGNOSTICCHAIN_MAP:
				return SequenceFlowtargetRef((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		result.append(" (isImmediate: ");
		result.append(isImmediate);
		result.append(')');
		return result.toString();
	}

} //SequenceFlowImpl
