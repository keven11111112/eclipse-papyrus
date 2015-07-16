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

import org.eclipse.papyrus.bpmn.BPMNProfile.Assignment;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation;
import org.eclipse.papyrus.bpmn.BPMNProfile.FormalExpression;
import org.eclipse.papyrus.bpmn.BPMNProfile.ItemAwareElement;

import org.eclipse.papyrus.bpmn.BPMNProfile.util.BPMNProfileValidator;

import org.eclipse.uml2.uml.ObjectFlow;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataAssociationImpl#getBase_ObjectFlow <em>Base Object Flow</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataAssociationImpl#getSourceRef <em>Source Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataAssociationImpl#getTargetRef <em>Target Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataAssociationImpl#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataAssociationImpl#getAssignment <em>Assignment</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DataAssociationImpl extends BaseElementImpl implements DataAssociation {
	/**
	 * The cached value of the '{@link #getBase_ObjectFlow() <em>Base Object Flow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_ObjectFlow()
	 * @generated
	 * @ordered
	 */
	protected ObjectFlow base_ObjectFlow;

	/**
	 * The cached value of the '{@link #getSourceRef() <em>Source Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceRef()
	 * @generated
	 * @ordered
	 */
	protected ItemAwareElement sourceRef;

	/**
	 * The cached value of the '{@link #getTargetRef() <em>Target Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetRef()
	 * @generated
	 * @ordered
	 */
	protected ItemAwareElement targetRef;

	/**
	 * The cached value of the '{@link #getTransformation() <em>Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransformation()
	 * @generated
	 * @ordered
	 */
	protected FormalExpression transformation;

	/**
	 * The cached value of the '{@link #getAssignment() <em>Assignment</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignment()
	 * @generated
	 * @ordered
	 */
	protected EList<Assignment> assignment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataAssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getDataAssociation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectFlow getBase_ObjectFlow() {
		if (base_ObjectFlow != null && base_ObjectFlow.eIsProxy()) {
			InternalEObject oldBase_ObjectFlow = (InternalEObject)base_ObjectFlow;
			base_ObjectFlow = (ObjectFlow)eResolveProxy(oldBase_ObjectFlow);
			if (base_ObjectFlow != oldBase_ObjectFlow) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.DATA_ASSOCIATION__BASE_OBJECT_FLOW, oldBase_ObjectFlow, base_ObjectFlow));
			}
		}
		return base_ObjectFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectFlow basicGetBase_ObjectFlow() {
		return base_ObjectFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_ObjectFlow(ObjectFlow newBase_ObjectFlow) {
		ObjectFlow oldBase_ObjectFlow = base_ObjectFlow;
		base_ObjectFlow = newBase_ObjectFlow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.DATA_ASSOCIATION__BASE_OBJECT_FLOW, oldBase_ObjectFlow, base_ObjectFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemAwareElement getSourceRef() {
		if (sourceRef != null && sourceRef.eIsProxy()) {
			InternalEObject oldSourceRef = (InternalEObject)sourceRef;
			sourceRef = (ItemAwareElement)eResolveProxy(oldSourceRef);
			if (sourceRef != oldSourceRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.DATA_ASSOCIATION__SOURCE_REF, oldSourceRef, sourceRef));
			}
		}
		return sourceRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemAwareElement basicGetSourceRef() {
		return sourceRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceRef(ItemAwareElement newSourceRef) {
		ItemAwareElement oldSourceRef = sourceRef;
		sourceRef = newSourceRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.DATA_ASSOCIATION__SOURCE_REF, oldSourceRef, sourceRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemAwareElement getTargetRef() {
		if (targetRef != null && targetRef.eIsProxy()) {
			InternalEObject oldTargetRef = (InternalEObject)targetRef;
			targetRef = (ItemAwareElement)eResolveProxy(oldTargetRef);
			if (targetRef != oldTargetRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.DATA_ASSOCIATION__TARGET_REF, oldTargetRef, targetRef));
			}
		}
		return targetRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemAwareElement basicGetTargetRef() {
		return targetRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetRef(ItemAwareElement newTargetRef) {
		ItemAwareElement oldTargetRef = targetRef;
		targetRef = newTargetRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.DATA_ASSOCIATION__TARGET_REF, oldTargetRef, targetRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormalExpression getTransformation() {
		if (transformation != null && transformation.eIsProxy()) {
			InternalEObject oldTransformation = (InternalEObject)transformation;
			transformation = (FormalExpression)eResolveProxy(oldTransformation);
			if (transformation != oldTransformation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.DATA_ASSOCIATION__TRANSFORMATION, oldTransformation, transformation));
			}
		}
		return transformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormalExpression basicGetTransformation() {
		return transformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransformation(FormalExpression newTransformation) {
		FormalExpression oldTransformation = transformation;
		transformation = newTransformation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.DATA_ASSOCIATION__TRANSFORMATION, oldTransformation, transformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Assignment> getAssignment() {
		if (assignment == null) {
			assignment = new EObjectResolvingEList<Assignment>(Assignment.class, this, BPMNProfilePackage.DATA_ASSOCIATION__ASSIGNMENT);
		}
		return assignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean DataAssociationsource(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.DATA_ASSOCIATION__DATA_ASSOCIATIONSOURCE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "DataAssociationsource", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean DataAssociationtransformation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.DATA_ASSOCIATION__DATA_ASSOCIATIONTRANSFORMATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "DataAssociationtransformation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean DataAssociationtarget(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.DATA_ASSOCIATION__DATA_ASSOCIATIONTARGET,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "DataAssociationtarget", EObjectValidator.getObjectLabel(this, context) }),
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
			case BPMNProfilePackage.DATA_ASSOCIATION__BASE_OBJECT_FLOW:
				if (resolve) return getBase_ObjectFlow();
				return basicGetBase_ObjectFlow();
			case BPMNProfilePackage.DATA_ASSOCIATION__SOURCE_REF:
				if (resolve) return getSourceRef();
				return basicGetSourceRef();
			case BPMNProfilePackage.DATA_ASSOCIATION__TARGET_REF:
				if (resolve) return getTargetRef();
				return basicGetTargetRef();
			case BPMNProfilePackage.DATA_ASSOCIATION__TRANSFORMATION:
				if (resolve) return getTransformation();
				return basicGetTransformation();
			case BPMNProfilePackage.DATA_ASSOCIATION__ASSIGNMENT:
				return getAssignment();
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
			case BPMNProfilePackage.DATA_ASSOCIATION__BASE_OBJECT_FLOW:
				setBase_ObjectFlow((ObjectFlow)newValue);
				return;
			case BPMNProfilePackage.DATA_ASSOCIATION__SOURCE_REF:
				setSourceRef((ItemAwareElement)newValue);
				return;
			case BPMNProfilePackage.DATA_ASSOCIATION__TARGET_REF:
				setTargetRef((ItemAwareElement)newValue);
				return;
			case BPMNProfilePackage.DATA_ASSOCIATION__TRANSFORMATION:
				setTransformation((FormalExpression)newValue);
				return;
			case BPMNProfilePackage.DATA_ASSOCIATION__ASSIGNMENT:
				getAssignment().clear();
				getAssignment().addAll((Collection<? extends Assignment>)newValue);
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
			case BPMNProfilePackage.DATA_ASSOCIATION__BASE_OBJECT_FLOW:
				setBase_ObjectFlow((ObjectFlow)null);
				return;
			case BPMNProfilePackage.DATA_ASSOCIATION__SOURCE_REF:
				setSourceRef((ItemAwareElement)null);
				return;
			case BPMNProfilePackage.DATA_ASSOCIATION__TARGET_REF:
				setTargetRef((ItemAwareElement)null);
				return;
			case BPMNProfilePackage.DATA_ASSOCIATION__TRANSFORMATION:
				setTransformation((FormalExpression)null);
				return;
			case BPMNProfilePackage.DATA_ASSOCIATION__ASSIGNMENT:
				getAssignment().clear();
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
			case BPMNProfilePackage.DATA_ASSOCIATION__BASE_OBJECT_FLOW:
				return base_ObjectFlow != null;
			case BPMNProfilePackage.DATA_ASSOCIATION__SOURCE_REF:
				return sourceRef != null;
			case BPMNProfilePackage.DATA_ASSOCIATION__TARGET_REF:
				return targetRef != null;
			case BPMNProfilePackage.DATA_ASSOCIATION__TRANSFORMATION:
				return transformation != null;
			case BPMNProfilePackage.DATA_ASSOCIATION__ASSIGNMENT:
				return assignment != null && !assignment.isEmpty();
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
			case BPMNProfilePackage.DATA_ASSOCIATION___DATA_ASSOCIATIONSOURCE__DIAGNOSTICCHAIN_MAP:
				return DataAssociationsource((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.DATA_ASSOCIATION___DATA_ASSOCIATIONTRANSFORMATION__DIAGNOSTICCHAIN_MAP:
				return DataAssociationtransformation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.DATA_ASSOCIATION___DATA_ASSOCIATIONTARGET__DIAGNOSTICCHAIN_MAP:
				return DataAssociationtarget((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //DataAssociationImpl
