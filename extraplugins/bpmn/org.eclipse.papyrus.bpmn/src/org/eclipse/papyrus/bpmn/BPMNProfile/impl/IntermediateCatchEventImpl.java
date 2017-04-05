/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.IntermediateCatchEvent;
import org.eclipse.uml2.uml.AcceptEventAction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Intermediate Catch Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.IntermediateCatchEventImpl#getBase_AcceptEventAction <em>Base Accept Event Action</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateCatchEventImpl extends CatchEventImpl implements IntermediateCatchEvent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntermediateCatchEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getIntermediateCatchEvent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AcceptEventAction getBase_AcceptEventAction() {
		if (base_AcceptEventAction != null && base_AcceptEventAction.eIsProxy()) {
			InternalEObject oldBase_AcceptEventAction = (InternalEObject)base_AcceptEventAction;
			base_AcceptEventAction = (AcceptEventAction)eResolveProxy(oldBase_AcceptEventAction);
			if (base_AcceptEventAction != oldBase_AcceptEventAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.INTERMEDIATE_CATCH_EVENT__BASE_ACCEPT_EVENT_ACTION, oldBase_AcceptEventAction, base_AcceptEventAction));
			}
		}
		return base_AcceptEventAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AcceptEventAction basicGetBase_AcceptEventAction() {
		return base_AcceptEventAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_AcceptEventAction(AcceptEventAction newBase_AcceptEventAction) {
		AcceptEventAction oldBase_AcceptEventAction = base_AcceptEventAction;
		base_AcceptEventAction = newBase_AcceptEventAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.INTERMEDIATE_CATCH_EVENT__BASE_ACCEPT_EVENT_ACTION, oldBase_AcceptEventAction, base_AcceptEventAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBase_AcceptEventAction() {
		return base_AcceptEventAction != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BPMNProfilePackage.INTERMEDIATE_CATCH_EVENT__BASE_ACCEPT_EVENT_ACTION:
				return isSetBase_AcceptEventAction();
		}
		return super.eIsSet(featureID);
	}

} //IntermediateCatchEventImpl
