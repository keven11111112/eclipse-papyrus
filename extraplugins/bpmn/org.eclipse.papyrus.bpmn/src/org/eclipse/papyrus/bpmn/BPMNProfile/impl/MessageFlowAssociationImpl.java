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
import org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow;
import org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlowAssociation;
import org.eclipse.papyrus.bpmn.BPMNProfile.util.BPMNProfileValidator;
import org.eclipse.uml2.uml.Dependency;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Flow Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.MessageFlowAssociationImpl#getBase_Dependency <em>Base Dependency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.MessageFlowAssociationImpl#getInnerMessageFlowRef <em>Inner Message Flow Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.MessageFlowAssociationImpl#getOuterMessageFlowRef <em>Outer Message Flow Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MessageFlowAssociationImpl extends BaseElementImpl implements MessageFlowAssociation {
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
	 * The cached value of the '{@link #getInnerMessageFlowRef() <em>Inner Message Flow Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerMessageFlowRef()
	 * @generated
	 * @ordered
	 */
	protected MessageFlow innerMessageFlowRef;
	/**
	 * The cached value of the '{@link #getOuterMessageFlowRef() <em>Outer Message Flow Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOuterMessageFlowRef()
	 * @generated
	 * @ordered
	 */
	protected MessageFlow outerMessageFlowRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageFlowAssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getMessageFlowAssociation();
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.MESSAGE_FLOW_ASSOCIATION__BASE_DEPENDENCY, oldBase_Dependency, base_Dependency));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.MESSAGE_FLOW_ASSOCIATION__BASE_DEPENDENCY, oldBase_Dependency, base_Dependency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageFlow getInnerMessageFlowRef() {
		if (innerMessageFlowRef != null && innerMessageFlowRef.eIsProxy()) {
			InternalEObject oldInnerMessageFlowRef = (InternalEObject)innerMessageFlowRef;
			innerMessageFlowRef = (MessageFlow)eResolveProxy(oldInnerMessageFlowRef);
			if (innerMessageFlowRef != oldInnerMessageFlowRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.MESSAGE_FLOW_ASSOCIATION__INNER_MESSAGE_FLOW_REF, oldInnerMessageFlowRef, innerMessageFlowRef));
			}
		}
		return innerMessageFlowRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageFlow basicGetInnerMessageFlowRef() {
		return innerMessageFlowRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInnerMessageFlowRef(MessageFlow newInnerMessageFlowRef) {
		MessageFlow oldInnerMessageFlowRef = innerMessageFlowRef;
		innerMessageFlowRef = newInnerMessageFlowRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.MESSAGE_FLOW_ASSOCIATION__INNER_MESSAGE_FLOW_REF, oldInnerMessageFlowRef, innerMessageFlowRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageFlow getOuterMessageFlowRef() {
		if (outerMessageFlowRef != null && outerMessageFlowRef.eIsProxy()) {
			InternalEObject oldOuterMessageFlowRef = (InternalEObject)outerMessageFlowRef;
			outerMessageFlowRef = (MessageFlow)eResolveProxy(oldOuterMessageFlowRef);
			if (outerMessageFlowRef != oldOuterMessageFlowRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.MESSAGE_FLOW_ASSOCIATION__OUTER_MESSAGE_FLOW_REF, oldOuterMessageFlowRef, outerMessageFlowRef));
			}
		}
		return outerMessageFlowRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageFlow basicGetOuterMessageFlowRef() {
		return outerMessageFlowRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOuterMessageFlowRef(MessageFlow newOuterMessageFlowRef) {
		MessageFlow oldOuterMessageFlowRef = outerMessageFlowRef;
		outerMessageFlowRef = newOuterMessageFlowRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.MESSAGE_FLOW_ASSOCIATION__OUTER_MESSAGE_FLOW_REF, oldOuterMessageFlowRef, outerMessageFlowRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean MessageFlowAssociationinnerMessageFlowRef(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.MESSAGE_FLOW_ASSOCIATION__MESSAGE_FLOW_ASSOCIATIONINNER_MESSAGE_FLOW_REF,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "MessageFlowAssociationinnerMessageFlowRef", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean MessageFlowAssociationouterMessageFlowRef(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.MESSAGE_FLOW_ASSOCIATION__MESSAGE_FLOW_ASSOCIATIONOUTER_MESSAGE_FLOW_REF,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "MessageFlowAssociationouterMessageFlowRef", EObjectValidator.getObjectLabel(this, context) }),
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
			case BPMNProfilePackage.MESSAGE_FLOW_ASSOCIATION__BASE_DEPENDENCY:
				if (resolve) return getBase_Dependency();
				return basicGetBase_Dependency();
			case BPMNProfilePackage.MESSAGE_FLOW_ASSOCIATION__INNER_MESSAGE_FLOW_REF:
				if (resolve) return getInnerMessageFlowRef();
				return basicGetInnerMessageFlowRef();
			case BPMNProfilePackage.MESSAGE_FLOW_ASSOCIATION__OUTER_MESSAGE_FLOW_REF:
				if (resolve) return getOuterMessageFlowRef();
				return basicGetOuterMessageFlowRef();
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
			case BPMNProfilePackage.MESSAGE_FLOW_ASSOCIATION__BASE_DEPENDENCY:
				setBase_Dependency((Dependency)newValue);
				return;
			case BPMNProfilePackage.MESSAGE_FLOW_ASSOCIATION__INNER_MESSAGE_FLOW_REF:
				setInnerMessageFlowRef((MessageFlow)newValue);
				return;
			case BPMNProfilePackage.MESSAGE_FLOW_ASSOCIATION__OUTER_MESSAGE_FLOW_REF:
				setOuterMessageFlowRef((MessageFlow)newValue);
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
			case BPMNProfilePackage.MESSAGE_FLOW_ASSOCIATION__BASE_DEPENDENCY:
				setBase_Dependency((Dependency)null);
				return;
			case BPMNProfilePackage.MESSAGE_FLOW_ASSOCIATION__INNER_MESSAGE_FLOW_REF:
				setInnerMessageFlowRef((MessageFlow)null);
				return;
			case BPMNProfilePackage.MESSAGE_FLOW_ASSOCIATION__OUTER_MESSAGE_FLOW_REF:
				setOuterMessageFlowRef((MessageFlow)null);
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
			case BPMNProfilePackage.MESSAGE_FLOW_ASSOCIATION__BASE_DEPENDENCY:
				return base_Dependency != null;
			case BPMNProfilePackage.MESSAGE_FLOW_ASSOCIATION__INNER_MESSAGE_FLOW_REF:
				return innerMessageFlowRef != null;
			case BPMNProfilePackage.MESSAGE_FLOW_ASSOCIATION__OUTER_MESSAGE_FLOW_REF:
				return outerMessageFlowRef != null;
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
			case BPMNProfilePackage.MESSAGE_FLOW_ASSOCIATION___MESSAGE_FLOW_ASSOCIATIONINNER_MESSAGE_FLOW_REF__DIAGNOSTICCHAIN_MAP:
				return MessageFlowAssociationinnerMessageFlowRef((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.MESSAGE_FLOW_ASSOCIATION___MESSAGE_FLOW_ASSOCIATIONOUTER_MESSAGE_FLOW_REF__DIAGNOSTICCHAIN_MAP:
				return MessageFlowAssociationouterMessageFlowRef((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //MessageFlowAssociationImpl
