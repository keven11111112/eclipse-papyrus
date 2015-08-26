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
import org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameter;
import org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameterBinding;

import org.eclipse.papyrus.bpmn.BPMNProfile.util.BPMNProfileValidator;

import org.eclipse.uml2.uml.Slot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Parameter Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ResourceParameterBindingImpl#getBase_Slot <em>Base Slot</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ResourceParameterBindingImpl#getParameterRef <em>Parameter Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ResourceParameterBindingImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceParameterBindingImpl extends BaseElementImpl implements ResourceParameterBinding {
	/**
	 * The cached value of the '{@link #getBase_Slot() <em>Base Slot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Slot()
	 * @generated
	 * @ordered
	 */
	protected Slot base_Slot;

	/**
	 * The cached value of the '{@link #getParameterRef() <em>Parameter Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterRef()
	 * @generated
	 * @ordered
	 */
	protected ResourceParameter parameterRef;
	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected BPMNExpression expression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceParameterBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getResourceParameterBinding();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Slot getBase_Slot() {
		if (base_Slot != null && base_Slot.eIsProxy()) {
			InternalEObject oldBase_Slot = (InternalEObject)base_Slot;
			base_Slot = (Slot)eResolveProxy(oldBase_Slot);
			if (base_Slot != oldBase_Slot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.RESOURCE_PARAMETER_BINDING__BASE_SLOT, oldBase_Slot, base_Slot));
			}
		}
		return base_Slot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Slot basicGetBase_Slot() {
		return base_Slot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Slot(Slot newBase_Slot) {
		Slot oldBase_Slot = base_Slot;
		base_Slot = newBase_Slot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.RESOURCE_PARAMETER_BINDING__BASE_SLOT, oldBase_Slot, base_Slot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceParameter getParameterRef() {
		if (parameterRef != null && parameterRef.eIsProxy()) {
			InternalEObject oldParameterRef = (InternalEObject)parameterRef;
			parameterRef = (ResourceParameter)eResolveProxy(oldParameterRef);
			if (parameterRef != oldParameterRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.RESOURCE_PARAMETER_BINDING__PARAMETER_REF, oldParameterRef, parameterRef));
			}
		}
		return parameterRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceParameter basicGetParameterRef() {
		return parameterRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterRef(ResourceParameter newParameterRef) {
		ResourceParameter oldParameterRef = parameterRef;
		parameterRef = newParameterRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.RESOURCE_PARAMETER_BINDING__PARAMETER_REF, oldParameterRef, parameterRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNExpression getExpression() {
		if (expression != null && expression.eIsProxy()) {
			InternalEObject oldExpression = (InternalEObject)expression;
			expression = (BPMNExpression)eResolveProxy(oldExpression);
			if (expression != oldExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.RESOURCE_PARAMETER_BINDING__EXPRESSION, oldExpression, expression));
			}
		}
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNExpression basicGetExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(BPMNExpression newExpression) {
		BPMNExpression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.RESOURCE_PARAMETER_BINDING__EXPRESSION, oldExpression, expression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ResourceParameterBindingexpression(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.RESOURCE_PARAMETER_BINDING__RESOURCE_PARAMETER_BINDINGEXPRESSION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ResourceParameterBindingexpression", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean ResourceParameterBindingparameterRef(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.RESOURCE_PARAMETER_BINDING__RESOURCE_PARAMETER_BINDINGPARAMETER_REF,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ResourceParameterBindingparameterRef", EObjectValidator.getObjectLabel(this, context) }),
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
			case BPMNProfilePackage.RESOURCE_PARAMETER_BINDING__BASE_SLOT:
				if (resolve) return getBase_Slot();
				return basicGetBase_Slot();
			case BPMNProfilePackage.RESOURCE_PARAMETER_BINDING__PARAMETER_REF:
				if (resolve) return getParameterRef();
				return basicGetParameterRef();
			case BPMNProfilePackage.RESOURCE_PARAMETER_BINDING__EXPRESSION:
				if (resolve) return getExpression();
				return basicGetExpression();
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
			case BPMNProfilePackage.RESOURCE_PARAMETER_BINDING__BASE_SLOT:
				setBase_Slot((Slot)newValue);
				return;
			case BPMNProfilePackage.RESOURCE_PARAMETER_BINDING__PARAMETER_REF:
				setParameterRef((ResourceParameter)newValue);
				return;
			case BPMNProfilePackage.RESOURCE_PARAMETER_BINDING__EXPRESSION:
				setExpression((BPMNExpression)newValue);
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
			case BPMNProfilePackage.RESOURCE_PARAMETER_BINDING__BASE_SLOT:
				setBase_Slot((Slot)null);
				return;
			case BPMNProfilePackage.RESOURCE_PARAMETER_BINDING__PARAMETER_REF:
				setParameterRef((ResourceParameter)null);
				return;
			case BPMNProfilePackage.RESOURCE_PARAMETER_BINDING__EXPRESSION:
				setExpression((BPMNExpression)null);
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
			case BPMNProfilePackage.RESOURCE_PARAMETER_BINDING__BASE_SLOT:
				return base_Slot != null;
			case BPMNProfilePackage.RESOURCE_PARAMETER_BINDING__PARAMETER_REF:
				return parameterRef != null;
			case BPMNProfilePackage.RESOURCE_PARAMETER_BINDING__EXPRESSION:
				return expression != null;
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
			case BPMNProfilePackage.RESOURCE_PARAMETER_BINDING___RESOURCE_PARAMETER_BINDINGEXPRESSION__DIAGNOSTICCHAIN_MAP:
				return ResourceParameterBindingexpression((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.RESOURCE_PARAMETER_BINDING___RESOURCE_PARAMETER_BINDINGPARAMETER_REF__DIAGNOSTICCHAIN_MAP:
				return ResourceParameterBindingparameterRef((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ResourceParameterBindingImpl
