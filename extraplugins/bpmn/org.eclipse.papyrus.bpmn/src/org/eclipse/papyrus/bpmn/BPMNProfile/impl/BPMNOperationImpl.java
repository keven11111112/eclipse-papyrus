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
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNMessage;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.util.BPMNProfileValidator;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Operation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BPMN Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNOperationImpl#getBase_Operation <em>Base Operation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNOperationImpl#getImplementationRef <em>Implementation Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNOperationImpl#getInMessageRef <em>In Message Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNOperationImpl#getOutMessageRef <em>Out Message Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNOperationImpl#getErrorRef <em>Error Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BPMNOperationImpl extends BaseElementImpl implements BPMNOperation {
	/**
	 * The cached value of the '{@link #getBase_Operation() <em>Base Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Operation()
	 * @generated
	 * @ordered
	 */
	protected Operation base_Operation;

	/**
	 * The cached value of the '{@link #getImplementationRef() <em>Implementation Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationRef()
	 * @generated
	 * @ordered
	 */
	protected Element implementationRef;

	/**
	 * The cached value of the '{@link #getInMessageRef() <em>In Message Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInMessageRef()
	 * @generated
	 * @ordered
	 */
	protected BPMNMessage inMessageRef;

	/**
	 * The cached value of the '{@link #getOutMessageRef() <em>Out Message Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutMessageRef()
	 * @generated
	 * @ordered
	 */
	protected BPMNMessage outMessageRef;

	/**
	 * The cached value of the '{@link #getErrorRef() <em>Error Ref</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorRef()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.papyrus.bpmn.BPMNProfile.Error> errorRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BPMNOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getBPMNOperation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getBase_Operation() {
		if (base_Operation != null && base_Operation.eIsProxy()) {
			InternalEObject oldBase_Operation = (InternalEObject)base_Operation;
			base_Operation = (Operation)eResolveProxy(oldBase_Operation);
			if (base_Operation != oldBase_Operation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.BPMN_OPERATION__BASE_OPERATION, oldBase_Operation, base_Operation));
			}
		}
		return base_Operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetBase_Operation() {
		return base_Operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Operation(Operation newBase_Operation) {
		Operation oldBase_Operation = base_Operation;
		base_Operation = newBase_Operation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BPMN_OPERATION__BASE_OPERATION, oldBase_Operation, base_Operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getImplementationRef() {
		if (implementationRef != null && implementationRef.eIsProxy()) {
			InternalEObject oldImplementationRef = (InternalEObject)implementationRef;
			implementationRef = (Element)eResolveProxy(oldImplementationRef);
			if (implementationRef != oldImplementationRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.BPMN_OPERATION__IMPLEMENTATION_REF, oldImplementationRef, implementationRef));
			}
		}
		return implementationRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetImplementationRef() {
		return implementationRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementationRef(Element newImplementationRef) {
		Element oldImplementationRef = implementationRef;
		implementationRef = newImplementationRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BPMN_OPERATION__IMPLEMENTATION_REF, oldImplementationRef, implementationRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNMessage getInMessageRef() {
		if (inMessageRef != null && inMessageRef.eIsProxy()) {
			InternalEObject oldInMessageRef = (InternalEObject)inMessageRef;
			inMessageRef = (BPMNMessage)eResolveProxy(oldInMessageRef);
			if (inMessageRef != oldInMessageRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.BPMN_OPERATION__IN_MESSAGE_REF, oldInMessageRef, inMessageRef));
			}
		}
		return inMessageRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNMessage basicGetInMessageRef() {
		return inMessageRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInMessageRef(BPMNMessage newInMessageRef) {
		BPMNMessage oldInMessageRef = inMessageRef;
		inMessageRef = newInMessageRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BPMN_OPERATION__IN_MESSAGE_REF, oldInMessageRef, inMessageRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNMessage getOutMessageRef() {
		if (outMessageRef != null && outMessageRef.eIsProxy()) {
			InternalEObject oldOutMessageRef = (InternalEObject)outMessageRef;
			outMessageRef = (BPMNMessage)eResolveProxy(oldOutMessageRef);
			if (outMessageRef != oldOutMessageRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.BPMN_OPERATION__OUT_MESSAGE_REF, oldOutMessageRef, outMessageRef));
			}
		}
		return outMessageRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNMessage basicGetOutMessageRef() {
		return outMessageRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutMessageRef(BPMNMessage newOutMessageRef) {
		BPMNMessage oldOutMessageRef = outMessageRef;
		outMessageRef = newOutMessageRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BPMN_OPERATION__OUT_MESSAGE_REF, oldOutMessageRef, outMessageRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.eclipse.papyrus.bpmn.BPMNProfile.Error> getErrorRef() {
		if (errorRef == null) {
			errorRef = new EObjectResolvingEList<org.eclipse.papyrus.bpmn.BPMNProfile.Error>(org.eclipse.papyrus.bpmn.BPMNProfile.Error.class, this, BPMNProfilePackage.BPMN_OPERATION__ERROR_REF);
		}
		return errorRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean BPMNOperationowner(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.BPMN_OPERATION__BPMN_OPERATIONOWNER,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "BPMNOperationowner", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean BPMNOperationinMessageRef(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.BPMN_OPERATION__BPMN_OPERATIONIN_MESSAGE_REF,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "BPMNOperationinMessageRef", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean BPMNOperationoutMessageRef(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.BPMN_OPERATION__BPMN_OPERATIONOUT_MESSAGE_REF,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "BPMNOperationoutMessageRef", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean BPMNOperationerrorRefs(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.BPMN_OPERATION__BPMN_OPERATIONERROR_REFS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "BPMNOperationerrorRefs", EObjectValidator.getObjectLabel(this, context) }),
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
			case BPMNProfilePackage.BPMN_OPERATION__BASE_OPERATION:
				if (resolve) return getBase_Operation();
				return basicGetBase_Operation();
			case BPMNProfilePackage.BPMN_OPERATION__IMPLEMENTATION_REF:
				if (resolve) return getImplementationRef();
				return basicGetImplementationRef();
			case BPMNProfilePackage.BPMN_OPERATION__IN_MESSAGE_REF:
				if (resolve) return getInMessageRef();
				return basicGetInMessageRef();
			case BPMNProfilePackage.BPMN_OPERATION__OUT_MESSAGE_REF:
				if (resolve) return getOutMessageRef();
				return basicGetOutMessageRef();
			case BPMNProfilePackage.BPMN_OPERATION__ERROR_REF:
				return getErrorRef();
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
			case BPMNProfilePackage.BPMN_OPERATION__BASE_OPERATION:
				setBase_Operation((Operation)newValue);
				return;
			case BPMNProfilePackage.BPMN_OPERATION__IMPLEMENTATION_REF:
				setImplementationRef((Element)newValue);
				return;
			case BPMNProfilePackage.BPMN_OPERATION__IN_MESSAGE_REF:
				setInMessageRef((BPMNMessage)newValue);
				return;
			case BPMNProfilePackage.BPMN_OPERATION__OUT_MESSAGE_REF:
				setOutMessageRef((BPMNMessage)newValue);
				return;
			case BPMNProfilePackage.BPMN_OPERATION__ERROR_REF:
				getErrorRef().clear();
				getErrorRef().addAll((Collection<? extends org.eclipse.papyrus.bpmn.BPMNProfile.Error>)newValue);
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
			case BPMNProfilePackage.BPMN_OPERATION__BASE_OPERATION:
				setBase_Operation((Operation)null);
				return;
			case BPMNProfilePackage.BPMN_OPERATION__IMPLEMENTATION_REF:
				setImplementationRef((Element)null);
				return;
			case BPMNProfilePackage.BPMN_OPERATION__IN_MESSAGE_REF:
				setInMessageRef((BPMNMessage)null);
				return;
			case BPMNProfilePackage.BPMN_OPERATION__OUT_MESSAGE_REF:
				setOutMessageRef((BPMNMessage)null);
				return;
			case BPMNProfilePackage.BPMN_OPERATION__ERROR_REF:
				getErrorRef().clear();
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
			case BPMNProfilePackage.BPMN_OPERATION__BASE_OPERATION:
				return base_Operation != null;
			case BPMNProfilePackage.BPMN_OPERATION__IMPLEMENTATION_REF:
				return implementationRef != null;
			case BPMNProfilePackage.BPMN_OPERATION__IN_MESSAGE_REF:
				return inMessageRef != null;
			case BPMNProfilePackage.BPMN_OPERATION__OUT_MESSAGE_REF:
				return outMessageRef != null;
			case BPMNProfilePackage.BPMN_OPERATION__ERROR_REF:
				return errorRef != null && !errorRef.isEmpty();
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
			case BPMNProfilePackage.BPMN_OPERATION___BPMN_OPERATIONOWNER__DIAGNOSTICCHAIN_MAP:
				return BPMNOperationowner((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.BPMN_OPERATION___BPMN_OPERATIONIN_MESSAGE_REF__DIAGNOSTICCHAIN_MAP:
				return BPMNOperationinMessageRef((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.BPMN_OPERATION___BPMN_OPERATIONOUT_MESSAGE_REF__DIAGNOSTICCHAIN_MAP:
				return BPMNOperationoutMessageRef((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.BPMN_OPERATION___BPMN_OPERATIONERROR_REFS__DIAGNOSTICCHAIN_MAP:
				return BPMNOperationerrorRefs((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //BPMNOperationImpl
