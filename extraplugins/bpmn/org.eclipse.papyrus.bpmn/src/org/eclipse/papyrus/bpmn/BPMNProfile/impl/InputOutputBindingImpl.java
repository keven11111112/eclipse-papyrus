/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputBinding;
import org.eclipse.papyrus.bpmn.BPMNProfile.InputSet;
import org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet;

import org.eclipse.uml2.uml.Dependency;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Output Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.InputOutputBindingImpl#getInputDataRef <em>Input Data Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.InputOutputBindingImpl#getOutputDataRef <em>Output Data Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.InputOutputBindingImpl#getOperationRef <em>Operation Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.InputOutputBindingImpl#getBase_Dependency <em>Base Dependency</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InputOutputBindingImpl extends BaseElementImpl implements InputOutputBinding {
	/**
	 * The cached value of the '{@link #getInputDataRef() <em>Input Data Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputDataRef()
	 * @generated
	 * @ordered
	 */
	protected InputSet inputDataRef;
	/**
	 * The cached value of the '{@link #getOutputDataRef() <em>Output Data Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputDataRef()
	 * @generated
	 * @ordered
	 */
	protected OutputSet outputDataRef;
	/**
	 * The cached value of the '{@link #getOperationRef() <em>Operation Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationRef()
	 * @generated
	 * @ordered
	 */
	protected BPMNOperation operationRef;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputOutputBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getInputOutputBinding();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputSet getInputDataRef() {
		if (inputDataRef != null && inputDataRef.eIsProxy()) {
			InternalEObject oldInputDataRef = (InternalEObject)inputDataRef;
			inputDataRef = (InputSet)eResolveProxy(oldInputDataRef);
			if (inputDataRef != oldInputDataRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.INPUT_OUTPUT_BINDING__INPUT_DATA_REF, oldInputDataRef, inputDataRef));
			}
		}
		return inputDataRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputSet basicGetInputDataRef() {
		return inputDataRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputDataRef(InputSet newInputDataRef) {
		InputSet oldInputDataRef = inputDataRef;
		inputDataRef = newInputDataRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.INPUT_OUTPUT_BINDING__INPUT_DATA_REF, oldInputDataRef, inputDataRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputSet getOutputDataRef() {
		if (outputDataRef != null && outputDataRef.eIsProxy()) {
			InternalEObject oldOutputDataRef = (InternalEObject)outputDataRef;
			outputDataRef = (OutputSet)eResolveProxy(oldOutputDataRef);
			if (outputDataRef != oldOutputDataRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.INPUT_OUTPUT_BINDING__OUTPUT_DATA_REF, oldOutputDataRef, outputDataRef));
			}
		}
		return outputDataRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputSet basicGetOutputDataRef() {
		return outputDataRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputDataRef(OutputSet newOutputDataRef) {
		OutputSet oldOutputDataRef = outputDataRef;
		outputDataRef = newOutputDataRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.INPUT_OUTPUT_BINDING__OUTPUT_DATA_REF, oldOutputDataRef, outputDataRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNOperation getOperationRef() {
		if (operationRef != null && operationRef.eIsProxy()) {
			InternalEObject oldOperationRef = (InternalEObject)operationRef;
			operationRef = (BPMNOperation)eResolveProxy(oldOperationRef);
			if (operationRef != oldOperationRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.INPUT_OUTPUT_BINDING__OPERATION_REF, oldOperationRef, operationRef));
			}
		}
		return operationRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNOperation basicGetOperationRef() {
		return operationRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationRef(BPMNOperation newOperationRef) {
		BPMNOperation oldOperationRef = operationRef;
		operationRef = newOperationRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.INPUT_OUTPUT_BINDING__OPERATION_REF, oldOperationRef, operationRef));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.INPUT_OUTPUT_BINDING__BASE_DEPENDENCY, oldBase_Dependency, base_Dependency));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.INPUT_OUTPUT_BINDING__BASE_DEPENDENCY, oldBase_Dependency, base_Dependency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.INPUT_OUTPUT_BINDING__INPUT_DATA_REF:
				if (resolve) return getInputDataRef();
				return basicGetInputDataRef();
			case BPMNProfilePackage.INPUT_OUTPUT_BINDING__OUTPUT_DATA_REF:
				if (resolve) return getOutputDataRef();
				return basicGetOutputDataRef();
			case BPMNProfilePackage.INPUT_OUTPUT_BINDING__OPERATION_REF:
				if (resolve) return getOperationRef();
				return basicGetOperationRef();
			case BPMNProfilePackage.INPUT_OUTPUT_BINDING__BASE_DEPENDENCY:
				if (resolve) return getBase_Dependency();
				return basicGetBase_Dependency();
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
			case BPMNProfilePackage.INPUT_OUTPUT_BINDING__INPUT_DATA_REF:
				setInputDataRef((InputSet)newValue);
				return;
			case BPMNProfilePackage.INPUT_OUTPUT_BINDING__OUTPUT_DATA_REF:
				setOutputDataRef((OutputSet)newValue);
				return;
			case BPMNProfilePackage.INPUT_OUTPUT_BINDING__OPERATION_REF:
				setOperationRef((BPMNOperation)newValue);
				return;
			case BPMNProfilePackage.INPUT_OUTPUT_BINDING__BASE_DEPENDENCY:
				setBase_Dependency((Dependency)newValue);
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
			case BPMNProfilePackage.INPUT_OUTPUT_BINDING__INPUT_DATA_REF:
				setInputDataRef((InputSet)null);
				return;
			case BPMNProfilePackage.INPUT_OUTPUT_BINDING__OUTPUT_DATA_REF:
				setOutputDataRef((OutputSet)null);
				return;
			case BPMNProfilePackage.INPUT_OUTPUT_BINDING__OPERATION_REF:
				setOperationRef((BPMNOperation)null);
				return;
			case BPMNProfilePackage.INPUT_OUTPUT_BINDING__BASE_DEPENDENCY:
				setBase_Dependency((Dependency)null);
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
			case BPMNProfilePackage.INPUT_OUTPUT_BINDING__INPUT_DATA_REF:
				return inputDataRef != null;
			case BPMNProfilePackage.INPUT_OUTPUT_BINDING__OUTPUT_DATA_REF:
				return outputDataRef != null;
			case BPMNProfilePackage.INPUT_OUTPUT_BINDING__OPERATION_REF:
				return operationRef != null;
			case BPMNProfilePackage.INPUT_OUTPUT_BINDING__BASE_DEPENDENCY:
				return base_Dependency != null;
		}
		return super.eIsSet(featureID);
	}

} //InputOutputBindingImpl
