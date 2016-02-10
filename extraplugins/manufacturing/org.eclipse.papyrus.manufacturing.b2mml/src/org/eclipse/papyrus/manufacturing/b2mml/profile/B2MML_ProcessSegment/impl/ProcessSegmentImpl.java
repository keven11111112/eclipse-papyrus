/**
 */
package org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.B2mmlProcessSegmentPackage;
import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegment;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Behavior;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Segment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.ProcessSegmentImpl#getBase_Action <em>Base Action</em>}</li>
 *   <li>{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.ProcessSegmentImpl#getProcesssegment <em>Processsegment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.ProcessSegmentImpl#getBase_Behavior <em>Base Behavior</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcessSegmentImpl extends MinimalEObjectImpl.Container implements ProcessSegment {
	/**
	 * The cached value of the '{@link #getBase_Action() <em>Base Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Action()
	 * @generated
	 * @ordered
	 */
	protected Action base_Action;

	/**
	 * The cached value of the '{@link #getProcesssegment() <em>Processsegment</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcesssegment()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessSegment> processsegment;

	/**
	 * The cached value of the '{@link #getBase_Behavior() <em>Base Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Behavior()
	 * @generated
	 * @ordered
	 */
	protected Behavior base_Behavior;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessSegmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return B2mmlProcessSegmentPackage.Literals.PROCESS_SEGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getBase_Action() {
		if (base_Action != null && base_Action.eIsProxy()) {
			InternalEObject oldBase_Action = (InternalEObject)base_Action;
			base_Action = (Action)eResolveProxy(oldBase_Action);
			if (base_Action != oldBase_Action) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, B2mmlProcessSegmentPackage.PROCESS_SEGMENT__BASE_ACTION, oldBase_Action, base_Action));
			}
		}
		return base_Action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action basicGetBase_Action() {
		return base_Action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Action(Action newBase_Action) {
		Action oldBase_Action = base_Action;
		base_Action = newBase_Action;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, B2mmlProcessSegmentPackage.PROCESS_SEGMENT__BASE_ACTION, oldBase_Action, base_Action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcessSegment> getProcesssegment() {
		if (processsegment == null) {
			processsegment = new EObjectResolvingEList<ProcessSegment>(ProcessSegment.class, this, B2mmlProcessSegmentPackage.PROCESS_SEGMENT__PROCESSSEGMENT);
		}
		return processsegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Behavior getBase_Behavior() {
		if (base_Behavior != null && base_Behavior.eIsProxy()) {
			InternalEObject oldBase_Behavior = (InternalEObject)base_Behavior;
			base_Behavior = (Behavior)eResolveProxy(oldBase_Behavior);
			if (base_Behavior != oldBase_Behavior) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, B2mmlProcessSegmentPackage.PROCESS_SEGMENT__BASE_BEHAVIOR, oldBase_Behavior, base_Behavior));
			}
		}
		return base_Behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Behavior basicGetBase_Behavior() {
		return base_Behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Behavior(Behavior newBase_Behavior) {
		Behavior oldBase_Behavior = base_Behavior;
		base_Behavior = newBase_Behavior;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, B2mmlProcessSegmentPackage.PROCESS_SEGMENT__BASE_BEHAVIOR, oldBase_Behavior, base_Behavior));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT__BASE_ACTION:
				if (resolve) return getBase_Action();
				return basicGetBase_Action();
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT__PROCESSSEGMENT:
				return getProcesssegment();
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT__BASE_BEHAVIOR:
				if (resolve) return getBase_Behavior();
				return basicGetBase_Behavior();
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
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT__BASE_ACTION:
				setBase_Action((Action)newValue);
				return;
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT__PROCESSSEGMENT:
				getProcesssegment().clear();
				getProcesssegment().addAll((Collection<? extends ProcessSegment>)newValue);
				return;
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT__BASE_BEHAVIOR:
				setBase_Behavior((Behavior)newValue);
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
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT__BASE_ACTION:
				setBase_Action((Action)null);
				return;
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT__PROCESSSEGMENT:
				getProcesssegment().clear();
				return;
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT__BASE_BEHAVIOR:
				setBase_Behavior((Behavior)null);
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
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT__BASE_ACTION:
				return base_Action != null;
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT__PROCESSSEGMENT:
				return processsegment != null && !processsegment.isEmpty();
			case B2mmlProcessSegmentPackage.PROCESS_SEGMENT__BASE_BEHAVIOR:
				return base_Behavior != null;
		}
		return super.eIsSet(featureID);
	}

} //ProcessSegmentImpl
