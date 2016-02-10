/**
 */
package org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.B2mmlProcessSegmentPackage;
import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegment;
import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegmentInformation;

import org.eclipse.uml2.uml.Activity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Segment Information</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.ProcessSegmentInformationImpl#getProcesssegment <em>Processsegment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.ProcessSegmentInformationImpl#getBase_Activity <em>Base Activity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcessSegmentInformationImpl extends MinimalEObjectImpl.Container implements ProcessSegmentInformation {
	/**
	 * The cached value of the '{@link #getProcesssegment() <em>Processsegment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcesssegment()
	 * @generated
	 * @ordered
	 */
	protected ProcessSegment processsegment;

	/**
	 * The cached value of the '{@link #getBase_Activity() <em>Base Activity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Activity()
	 * @generated
	 * @ordered
	 */
	protected Activity base_Activity;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessSegmentInformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return B2mmlProcessSegmentPackage.Literals.PROCESS_SEGMENT_INFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessSegment getProcesssegment() {
		if (processsegment != null && processsegment.eIsProxy()) {
			InternalEObject oldProcesssegment = (InternalEObject)processsegment;
			processsegment = (ProcessSegment)eResolveProxy(oldProcesssegment);
			if (processsegment != oldProcesssegment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, B2mmlProcessSegmentPackage.PROCESS_SEGMENT_INFORMATION__PROCESSSEGMENT, oldProcesssegment, processsegment));
			}
		}
		return processsegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessSegment basicGetProcesssegment() {
		return processsegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcesssegment(ProcessSegment newProcesssegment) {
		ProcessSegment oldProcesssegment = processsegment;
		processsegment = newProcesssegment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, B2mmlProcessSegmentPackage.PROCESS_SEGMENT_INFORMATION__PROCESSSEGMENT, oldProcesssegment, processsegment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getBase_Activity() {
		if (base_Activity != null && base_Activity.eIsProxy()) {
			InternalEObject oldBase_Activity = (InternalEObject)base_Activity;
			base_Activity = (Activity)eResolveProxy(oldBase_Activity);
			if (base_Activity != oldBase_Activity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, B2mmlProcessSegmentPackage.PROCESS_SEGMENT_INFORMATION__BASE_ACTIVITY, oldBase_Activity, base_Activity));
			}
		}
		return base_Activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity basicGetBase_Activity() {
		return base_Activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Activity(Activity newBase_Activity) {
		Activity oldBase_Activity = base_Activity;
		base_Activity = newBase_Activity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, B2mmlProcessSegmentPackage.PROCESS_SEGMENT_INFORMATION__BASE_ACTIVITY, oldBase_Activity, base_Activity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT_INFORMATION__PROCESSSEGMENT:
				if (resolve) return getProcesssegment();
				return basicGetProcesssegment();
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT_INFORMATION__BASE_ACTIVITY:
				if (resolve) return getBase_Activity();
				return basicGetBase_Activity();
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
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT_INFORMATION__PROCESSSEGMENT:
				setProcesssegment((ProcessSegment)newValue);
				return;
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT_INFORMATION__BASE_ACTIVITY:
				setBase_Activity((Activity)newValue);
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
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT_INFORMATION__PROCESSSEGMENT:
				setProcesssegment((ProcessSegment)null);
				return;
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT_INFORMATION__BASE_ACTIVITY:
				setBase_Activity((Activity)null);
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
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT_INFORMATION__PROCESSSEGMENT:
				return processsegment != null;
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT_INFORMATION__BASE_ACTIVITY:
				return base_Activity != null;
		}
		return super.eIsSet(featureID);
	}

} //ProcessSegmentInformationImpl
