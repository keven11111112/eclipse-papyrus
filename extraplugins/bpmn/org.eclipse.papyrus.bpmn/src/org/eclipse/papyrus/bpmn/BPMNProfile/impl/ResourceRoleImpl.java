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

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.Resource;
import org.eclipse.papyrus.bpmn.BPMNProfile.ResourceAssignmentExpression;
import org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameterBinding;
import org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole;

import org.eclipse.papyrus.bpmn.BPMNProfile.util.BPMNProfileValidator;

import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ResourceRoleImpl#getBase_Property <em>Base Property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ResourceRoleImpl#getResourceAssignmentExpression <em>Resource Assignment Expression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ResourceRoleImpl#getResourceRef <em>Resource Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ResourceRoleImpl#getResourceParameterBindings <em>Resource Parameter Bindings</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ResourceRoleImpl#getProcess <em>Process</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceRoleImpl extends BaseElementImpl implements ResourceRole {
	/**
	 * The cached value of the '{@link #getBase_Property() <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Property()
	 * @generated
	 * @ordered
	 */
	protected Property base_Property;

	/**
	 * The cached value of the '{@link #getResourceAssignmentExpression() <em>Resource Assignment Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceAssignmentExpression()
	 * @generated
	 * @ordered
	 */
	protected ResourceAssignmentExpression resourceAssignmentExpression;

	/**
	 * The cached value of the '{@link #getResourceRef() <em>Resource Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceRef()
	 * @generated
	 * @ordered
	 */
	protected Resource resourceRef;

	/**
	 * The cached value of the '{@link #getResourceParameterBindings() <em>Resource Parameter Bindings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceParameterBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceParameterBinding> resourceParameterBindings;

	/**
	 * The cached value of the '{@link #getProcess() <em>Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcess()
	 * @generated
	 * @ordered
	 */
	protected BPMNProcess process;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getResourceRole();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getBase_Property() {
		if (base_Property != null && base_Property.eIsProxy()) {
			InternalEObject oldBase_Property = (InternalEObject)base_Property;
			base_Property = (Property)eResolveProxy(oldBase_Property);
			if (base_Property != oldBase_Property) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.RESOURCE_ROLE__BASE_PROPERTY, oldBase_Property, base_Property));
			}
		}
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetBase_Property() {
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Property(Property newBase_Property) {
		Property oldBase_Property = base_Property;
		base_Property = newBase_Property;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.RESOURCE_ROLE__BASE_PROPERTY, oldBase_Property, base_Property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceAssignmentExpression getResourceAssignmentExpression() {
		if (resourceAssignmentExpression != null && resourceAssignmentExpression.eIsProxy()) {
			InternalEObject oldResourceAssignmentExpression = (InternalEObject)resourceAssignmentExpression;
			resourceAssignmentExpression = (ResourceAssignmentExpression)eResolveProxy(oldResourceAssignmentExpression);
			if (resourceAssignmentExpression != oldResourceAssignmentExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.RESOURCE_ROLE__RESOURCE_ASSIGNMENT_EXPRESSION, oldResourceAssignmentExpression, resourceAssignmentExpression));
			}
		}
		return resourceAssignmentExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceAssignmentExpression basicGetResourceAssignmentExpression() {
		return resourceAssignmentExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceAssignmentExpression(ResourceAssignmentExpression newResourceAssignmentExpression) {
		ResourceAssignmentExpression oldResourceAssignmentExpression = resourceAssignmentExpression;
		resourceAssignmentExpression = newResourceAssignmentExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.RESOURCE_ROLE__RESOURCE_ASSIGNMENT_EXPRESSION, oldResourceAssignmentExpression, resourceAssignmentExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getResourceRef() {
		if (resourceRef != null && resourceRef.eIsProxy()) {
			InternalEObject oldResourceRef = (InternalEObject)resourceRef;
			resourceRef = (Resource)eResolveProxy(oldResourceRef);
			if (resourceRef != oldResourceRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.RESOURCE_ROLE__RESOURCE_REF, oldResourceRef, resourceRef));
			}
		}
		return resourceRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource basicGetResourceRef() {
		return resourceRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceRef(Resource newResourceRef) {
		Resource oldResourceRef = resourceRef;
		resourceRef = newResourceRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.RESOURCE_ROLE__RESOURCE_REF, oldResourceRef, resourceRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceParameterBinding> getResourceParameterBindings() {
		if (resourceParameterBindings == null) {
			resourceParameterBindings = new EObjectResolvingEList<ResourceParameterBinding>(ResourceParameterBinding.class, this, BPMNProfilePackage.RESOURCE_ROLE__RESOURCE_PARAMETER_BINDINGS);
		}
		return resourceParameterBindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNProcess getProcess() {
		if (process != null && process.eIsProxy()) {
			InternalEObject oldProcess = (InternalEObject)process;
			process = (BPMNProcess)eResolveProxy(oldProcess);
			if (process != oldProcess) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.RESOURCE_ROLE__PROCESS, oldProcess, process));
			}
		}
		return process;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNProcess basicGetProcess() {
		return process;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProcess(BPMNProcess newProcess, NotificationChain msgs) {
		BPMNProcess oldProcess = process;
		process = newProcess;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.RESOURCE_ROLE__PROCESS, oldProcess, newProcess);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcess(BPMNProcess newProcess) {
		if (newProcess != process) {
			NotificationChain msgs = null;
			if (process != null)
				msgs = ((InternalEObject)process).eInverseRemove(this, BPMNProfilePackage.BPMN_PROCESS__RESOURCES, BPMNProcess.class, msgs);
			if (newProcess != null)
				msgs = ((InternalEObject)newProcess).eInverseAdd(this, BPMNProfilePackage.BPMN_PROCESS__RESOURCES, BPMNProcess.class, msgs);
			msgs = basicSetProcess(newProcess, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.RESOURCE_ROLE__PROCESS, newProcess, newProcess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ResourceRoleowner(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.RESOURCE_ROLE__RESOURCE_ROLEOWNER,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ResourceRoleowner", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean ResourceRoleresourceRef(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.RESOURCE_ROLE__RESOURCE_ROLERESOURCE_REF,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ResourceRoleresourceRef", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean ResourceRoleisRequired(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.RESOURCE_ROLE__RESOURCE_ROLEIS_REQUIRED,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ResourceRoleisRequired", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean ResourceRoleprocess(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.RESOURCE_ROLE__RESOURCE_ROLEPROCESS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ResourceRoleprocess", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean ResourceRoleresourceParameterBindings(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.RESOURCE_ROLE__RESOURCE_ROLERESOURCE_PARAMETER_BINDINGS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ResourceRoleresourceParameterBindings", EObjectValidator.getObjectLabel(this, context) }),
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
			case BPMNProfilePackage.RESOURCE_ROLE__PROCESS:
				if (process != null)
					msgs = ((InternalEObject)process).eInverseRemove(this, BPMNProfilePackage.BPMN_PROCESS__RESOURCES, BPMNProcess.class, msgs);
				return basicSetProcess((BPMNProcess)otherEnd, msgs);
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
			case BPMNProfilePackage.RESOURCE_ROLE__PROCESS:
				return basicSetProcess(null, msgs);
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
			case BPMNProfilePackage.RESOURCE_ROLE__BASE_PROPERTY:
				if (resolve) return getBase_Property();
				return basicGetBase_Property();
			case BPMNProfilePackage.RESOURCE_ROLE__RESOURCE_ASSIGNMENT_EXPRESSION:
				if (resolve) return getResourceAssignmentExpression();
				return basicGetResourceAssignmentExpression();
			case BPMNProfilePackage.RESOURCE_ROLE__RESOURCE_REF:
				if (resolve) return getResourceRef();
				return basicGetResourceRef();
			case BPMNProfilePackage.RESOURCE_ROLE__RESOURCE_PARAMETER_BINDINGS:
				return getResourceParameterBindings();
			case BPMNProfilePackage.RESOURCE_ROLE__PROCESS:
				if (resolve) return getProcess();
				return basicGetProcess();
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
			case BPMNProfilePackage.RESOURCE_ROLE__BASE_PROPERTY:
				setBase_Property((Property)newValue);
				return;
			case BPMNProfilePackage.RESOURCE_ROLE__RESOURCE_ASSIGNMENT_EXPRESSION:
				setResourceAssignmentExpression((ResourceAssignmentExpression)newValue);
				return;
			case BPMNProfilePackage.RESOURCE_ROLE__RESOURCE_REF:
				setResourceRef((Resource)newValue);
				return;
			case BPMNProfilePackage.RESOURCE_ROLE__RESOURCE_PARAMETER_BINDINGS:
				getResourceParameterBindings().clear();
				getResourceParameterBindings().addAll((Collection<? extends ResourceParameterBinding>)newValue);
				return;
			case BPMNProfilePackage.RESOURCE_ROLE__PROCESS:
				setProcess((BPMNProcess)newValue);
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
			case BPMNProfilePackage.RESOURCE_ROLE__BASE_PROPERTY:
				setBase_Property((Property)null);
				return;
			case BPMNProfilePackage.RESOURCE_ROLE__RESOURCE_ASSIGNMENT_EXPRESSION:
				setResourceAssignmentExpression((ResourceAssignmentExpression)null);
				return;
			case BPMNProfilePackage.RESOURCE_ROLE__RESOURCE_REF:
				setResourceRef((Resource)null);
				return;
			case BPMNProfilePackage.RESOURCE_ROLE__RESOURCE_PARAMETER_BINDINGS:
				getResourceParameterBindings().clear();
				return;
			case BPMNProfilePackage.RESOURCE_ROLE__PROCESS:
				setProcess((BPMNProcess)null);
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
			case BPMNProfilePackage.RESOURCE_ROLE__BASE_PROPERTY:
				return base_Property != null;
			case BPMNProfilePackage.RESOURCE_ROLE__RESOURCE_ASSIGNMENT_EXPRESSION:
				return resourceAssignmentExpression != null;
			case BPMNProfilePackage.RESOURCE_ROLE__RESOURCE_REF:
				return resourceRef != null;
			case BPMNProfilePackage.RESOURCE_ROLE__RESOURCE_PARAMETER_BINDINGS:
				return resourceParameterBindings != null && !resourceParameterBindings.isEmpty();
			case BPMNProfilePackage.RESOURCE_ROLE__PROCESS:
				return process != null;
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
			case BPMNProfilePackage.RESOURCE_ROLE___RESOURCE_ROLEOWNER__DIAGNOSTICCHAIN_MAP:
				return ResourceRoleowner((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.RESOURCE_ROLE___RESOURCE_ROLERESOURCE_REF__DIAGNOSTICCHAIN_MAP:
				return ResourceRoleresourceRef((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.RESOURCE_ROLE___RESOURCE_ROLEIS_REQUIRED__DIAGNOSTICCHAIN_MAP:
				return ResourceRoleisRequired((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.RESOURCE_ROLE___RESOURCE_ROLEPROCESS__DIAGNOSTICCHAIN_MAP:
				return ResourceRoleprocess((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.RESOURCE_ROLE___RESOURCE_ROLERESOURCE_PARAMETER_BINDINGS__DIAGNOSTICCHAIN_MAP:
				return ResourceRoleresourceParameterBindings((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ResourceRoleImpl
