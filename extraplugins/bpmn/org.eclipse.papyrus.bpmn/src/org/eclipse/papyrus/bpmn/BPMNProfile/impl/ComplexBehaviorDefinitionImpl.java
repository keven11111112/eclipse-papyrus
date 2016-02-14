/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.ComplexBehaviorDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.FormalExpression;
import org.eclipse.papyrus.bpmn.BPMNProfile.ImplicitThrowEvent;
import org.eclipse.uml2.uml.ControlFlow;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Behavior Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ComplexBehaviorDefinitionImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ComplexBehaviorDefinitionImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ComplexBehaviorDefinitionImpl#getBase_ControlFlow <em>Base Control Flow</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComplexBehaviorDefinitionImpl extends BaseElementImpl implements ComplexBehaviorDefinition {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected FormalExpression condition;
	/**
	 * The cached value of the '{@link #getEvent() <em>Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvent()
	 * @generated
	 * @ordered
	 */
	protected ImplicitThrowEvent event;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexBehaviorDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getComplexBehaviorDefinition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormalExpression getCondition() {
		if (condition != null && condition.eIsProxy()) {
			InternalEObject oldCondition = (InternalEObject)condition;
			condition = (FormalExpression)eResolveProxy(oldCondition);
			if (condition != oldCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.COMPLEX_BEHAVIOR_DEFINITION__CONDITION, oldCondition, condition));
			}
		}
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormalExpression basicGetCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(FormalExpression newCondition) {
		FormalExpression oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.COMPLEX_BEHAVIOR_DEFINITION__CONDITION, oldCondition, condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplicitThrowEvent getEvent() {
		if (event != null && event.eIsProxy()) {
			InternalEObject oldEvent = (InternalEObject)event;
			event = (ImplicitThrowEvent)eResolveProxy(oldEvent);
			if (event != oldEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.COMPLEX_BEHAVIOR_DEFINITION__EVENT, oldEvent, event));
			}
		}
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplicitThrowEvent basicGetEvent() {
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvent(ImplicitThrowEvent newEvent) {
		ImplicitThrowEvent oldEvent = event;
		event = newEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.COMPLEX_BEHAVIOR_DEFINITION__EVENT, oldEvent, event));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.COMPLEX_BEHAVIOR_DEFINITION__BASE_CONTROL_FLOW, oldBase_ControlFlow, base_ControlFlow));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.COMPLEX_BEHAVIOR_DEFINITION__BASE_CONTROL_FLOW, oldBase_ControlFlow, base_ControlFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.COMPLEX_BEHAVIOR_DEFINITION__CONDITION:
				if (resolve) return getCondition();
				return basicGetCondition();
			case BPMNProfilePackage.COMPLEX_BEHAVIOR_DEFINITION__EVENT:
				if (resolve) return getEvent();
				return basicGetEvent();
			case BPMNProfilePackage.COMPLEX_BEHAVIOR_DEFINITION__BASE_CONTROL_FLOW:
				if (resolve) return getBase_ControlFlow();
				return basicGetBase_ControlFlow();
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
			case BPMNProfilePackage.COMPLEX_BEHAVIOR_DEFINITION__CONDITION:
				setCondition((FormalExpression)newValue);
				return;
			case BPMNProfilePackage.COMPLEX_BEHAVIOR_DEFINITION__EVENT:
				setEvent((ImplicitThrowEvent)newValue);
				return;
			case BPMNProfilePackage.COMPLEX_BEHAVIOR_DEFINITION__BASE_CONTROL_FLOW:
				setBase_ControlFlow((ControlFlow)newValue);
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
			case BPMNProfilePackage.COMPLEX_BEHAVIOR_DEFINITION__CONDITION:
				setCondition((FormalExpression)null);
				return;
			case BPMNProfilePackage.COMPLEX_BEHAVIOR_DEFINITION__EVENT:
				setEvent((ImplicitThrowEvent)null);
				return;
			case BPMNProfilePackage.COMPLEX_BEHAVIOR_DEFINITION__BASE_CONTROL_FLOW:
				setBase_ControlFlow((ControlFlow)null);
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
			case BPMNProfilePackage.COMPLEX_BEHAVIOR_DEFINITION__CONDITION:
				return condition != null;
			case BPMNProfilePackage.COMPLEX_BEHAVIOR_DEFINITION__EVENT:
				return event != null;
			case BPMNProfilePackage.COMPLEX_BEHAVIOR_DEFINITION__BASE_CONTROL_FLOW:
				return base_ControlFlow != null;
		}
		return super.eIsSet(featureID);
	}

} //ComplexBehaviorDefinitionImpl
