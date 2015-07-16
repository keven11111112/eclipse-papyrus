/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification;
import org.eclipse.papyrus.bpmn.BPMNProfile.Task;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.TaskImpl#getIoSpecification <em>Io Specification</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaskImpl extends BPMNActivityImpl implements Task {
	/**
	 * The cached value of the '{@link #getIoSpecification() <em>Io Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIoSpecification()
	 * @generated
	 * @ordered
	 */
	protected InputOutputSpecification ioSpecification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getTask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputOutputSpecification getIoSpecification() {
		if (ioSpecification != null && ioSpecification.eIsProxy()) {
			InternalEObject oldIoSpecification = (InternalEObject)ioSpecification;
			ioSpecification = (InputOutputSpecification)eResolveProxy(oldIoSpecification);
			if (ioSpecification != oldIoSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.TASK__IO_SPECIFICATION, oldIoSpecification, ioSpecification));
			}
		}
		return ioSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputOutputSpecification basicGetIoSpecification() {
		return ioSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIoSpecification(InputOutputSpecification newIoSpecification) {
		InputOutputSpecification oldIoSpecification = ioSpecification;
		ioSpecification = newIoSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.TASK__IO_SPECIFICATION, oldIoSpecification, ioSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.TASK__IO_SPECIFICATION:
				if (resolve) return getIoSpecification();
				return basicGetIoSpecification();
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
			case BPMNProfilePackage.TASK__IO_SPECIFICATION:
				setIoSpecification((InputOutputSpecification)newValue);
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
			case BPMNProfilePackage.TASK__IO_SPECIFICATION:
				setIoSpecification((InputOutputSpecification)null);
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
			case BPMNProfilePackage.TASK__IO_SPECIFICATION:
				return ioSpecification != null;
		}
		return super.eIsSet(featureID);
	}

} //TaskImpl
