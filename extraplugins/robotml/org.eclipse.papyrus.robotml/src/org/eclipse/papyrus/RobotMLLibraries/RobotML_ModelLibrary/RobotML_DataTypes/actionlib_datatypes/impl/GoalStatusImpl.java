/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.Actionlib_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.GoalStatus;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Std_datatypesFactory;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Std_datatypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Goal Status</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getPENDING <em>PENDING</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getACTIVE <em>ACTIVE</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getPREEMPTED <em>PREEMPTED</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getSUCCEEDED <em>SUCCEEDED</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getABORTED <em>ABORTED</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getREJECTED <em>REJECTED</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getPREEMPTING <em>PREEMPTING</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getRECALLING <em>RECALLING</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getRECALLED <em>RECALLED</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getLOST <em>LOST</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.actionlib_datatypes.impl.GoalStatusImpl#getStatus <em>Status</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GoalStatusImpl extends MinimalEObjectImpl.Container implements GoalStatus {
	/**
	 * The default value of the '{@link #getPENDING() <em>PENDING</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPENDING()
	 * @generated
	 * @ordered
	 */
	protected static final Object PENDING_EDEFAULT = (Object)Std_datatypesFactory.eINSTANCE.createFromString(Std_datatypesPackage.eINSTANCE.getUInt8(), "0");

	/**
	 * The cached value of the '{@link #getPENDING() <em>PENDING</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPENDING()
	 * @generated
	 * @ordered
	 */
	protected Object pending = PENDING_EDEFAULT;

	/**
	 * The default value of the '{@link #getACTIVE() <em>ACTIVE</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getACTIVE()
	 * @generated
	 * @ordered
	 */
	protected static final Object ACTIVE_EDEFAULT = (Object)Std_datatypesFactory.eINSTANCE.createFromString(Std_datatypesPackage.eINSTANCE.getUInt8(), "1");

	/**
	 * The cached value of the '{@link #getACTIVE() <em>ACTIVE</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getACTIVE()
	 * @generated
	 * @ordered
	 */
	protected Object active = ACTIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPREEMPTED() <em>PREEMPTED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPREEMPTED()
	 * @generated
	 * @ordered
	 */
	protected static final Object PREEMPTED_EDEFAULT = (Object)Std_datatypesFactory.eINSTANCE.createFromString(Std_datatypesPackage.eINSTANCE.getUInt8(), "2");

	/**
	 * The cached value of the '{@link #getPREEMPTED() <em>PREEMPTED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPREEMPTED()
	 * @generated
	 * @ordered
	 */
	protected Object preempted = PREEMPTED_EDEFAULT;

	/**
	 * The default value of the '{@link #getSUCCEEDED() <em>SUCCEEDED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSUCCEEDED()
	 * @generated
	 * @ordered
	 */
	protected static final Object SUCCEEDED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSUCCEEDED() <em>SUCCEEDED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSUCCEEDED()
	 * @generated
	 * @ordered
	 */
	protected Object succeeded = SUCCEEDED_EDEFAULT;

	/**
	 * The default value of the '{@link #getABORTED() <em>ABORTED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getABORTED()
	 * @generated
	 * @ordered
	 */
	protected static final Object ABORTED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getABORTED() <em>ABORTED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getABORTED()
	 * @generated
	 * @ordered
	 */
	protected Object aborted = ABORTED_EDEFAULT;

	/**
	 * The default value of the '{@link #getREJECTED() <em>REJECTED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getREJECTED()
	 * @generated
	 * @ordered
	 */
	protected static final Object REJECTED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getREJECTED() <em>REJECTED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getREJECTED()
	 * @generated
	 * @ordered
	 */
	protected Object rejected = REJECTED_EDEFAULT;

	/**
	 * The default value of the '{@link #getPREEMPTING() <em>PREEMPTING</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPREEMPTING()
	 * @generated
	 * @ordered
	 */
	protected static final Object PREEMPTING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPREEMPTING() <em>PREEMPTING</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPREEMPTING()
	 * @generated
	 * @ordered
	 */
	protected Object preempting = PREEMPTING_EDEFAULT;

	/**
	 * The default value of the '{@link #getRECALLING() <em>RECALLING</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRECALLING()
	 * @generated
	 * @ordered
	 */
	protected static final Object RECALLING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRECALLING() <em>RECALLING</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRECALLING()
	 * @generated
	 * @ordered
	 */
	protected Object recalling = RECALLING_EDEFAULT;

	/**
	 * The default value of the '{@link #getRECALLED() <em>RECALLED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRECALLED()
	 * @generated
	 * @ordered
	 */
	protected static final Object RECALLED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRECALLED() <em>RECALLED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRECALLED()
	 * @generated
	 * @ordered
	 */
	protected Object recalled = RECALLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getLOST() <em>LOST</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLOST()
	 * @generated
	 * @ordered
	 */
	protected static final Object LOST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLOST() <em>LOST</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLOST()
	 * @generated
	 * @ordered
	 */
	protected Object lost = LOST_EDEFAULT;

	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final Object TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected Object text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final Object STATUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected Object status = STATUS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GoalStatusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Actionlib_datatypesPackage.Literals.GOAL_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPENDING() {
		return pending;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPENDING(Object newPENDING) {
		Object oldPENDING = pending;
		pending = newPENDING;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__PENDING, oldPENDING, pending));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getACTIVE() {
		return active;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setACTIVE(Object newACTIVE) {
		Object oldACTIVE = active;
		active = newACTIVE;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__ACTIVE, oldACTIVE, active));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPREEMPTED() {
		return preempted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPREEMPTED(Object newPREEMPTED) {
		Object oldPREEMPTED = preempted;
		preempted = newPREEMPTED;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__PREEMPTED, oldPREEMPTED, preempted));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getSUCCEEDED() {
		return succeeded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSUCCEEDED(Object newSUCCEEDED) {
		Object oldSUCCEEDED = succeeded;
		succeeded = newSUCCEEDED;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__SUCCEEDED, oldSUCCEEDED, succeeded));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getABORTED() {
		return aborted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setABORTED(Object newABORTED) {
		Object oldABORTED = aborted;
		aborted = newABORTED;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__ABORTED, oldABORTED, aborted));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getREJECTED() {
		return rejected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setREJECTED(Object newREJECTED) {
		Object oldREJECTED = rejected;
		rejected = newREJECTED;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__REJECTED, oldREJECTED, rejected));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPREEMPTING() {
		return preempting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPREEMPTING(Object newPREEMPTING) {
		Object oldPREEMPTING = preempting;
		preempting = newPREEMPTING;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__PREEMPTING, oldPREEMPTING, preempting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRECALLING() {
		return recalling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRECALLING(Object newRECALLING) {
		Object oldRECALLING = recalling;
		recalling = newRECALLING;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__RECALLING, oldRECALLING, recalling));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRECALLED() {
		return recalled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRECALLED(Object newRECALLED) {
		Object oldRECALLED = recalled;
		recalled = newRECALLED;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__RECALLED, oldRECALLED, recalled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getLOST() {
		return lost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLOST(Object newLOST) {
		Object oldLOST = lost;
		lost = newLOST;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__LOST, oldLOST, lost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(Object newText) {
		Object oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(Object newStatus) {
		Object oldStatus = status;
		status = newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionlib_datatypesPackage.GOAL_STATUS__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Actionlib_datatypesPackage.GOAL_STATUS__PENDING:
				return getPENDING();
			case Actionlib_datatypesPackage.GOAL_STATUS__ACTIVE:
				return getACTIVE();
			case Actionlib_datatypesPackage.GOAL_STATUS__PREEMPTED:
				return getPREEMPTED();
			case Actionlib_datatypesPackage.GOAL_STATUS__SUCCEEDED:
				return getSUCCEEDED();
			case Actionlib_datatypesPackage.GOAL_STATUS__ABORTED:
				return getABORTED();
			case Actionlib_datatypesPackage.GOAL_STATUS__REJECTED:
				return getREJECTED();
			case Actionlib_datatypesPackage.GOAL_STATUS__PREEMPTING:
				return getPREEMPTING();
			case Actionlib_datatypesPackage.GOAL_STATUS__RECALLING:
				return getRECALLING();
			case Actionlib_datatypesPackage.GOAL_STATUS__RECALLED:
				return getRECALLED();
			case Actionlib_datatypesPackage.GOAL_STATUS__LOST:
				return getLOST();
			case Actionlib_datatypesPackage.GOAL_STATUS__TEXT:
				return getText();
			case Actionlib_datatypesPackage.GOAL_STATUS__STATUS:
				return getStatus();
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
			case Actionlib_datatypesPackage.GOAL_STATUS__PENDING:
				setPENDING((Object)newValue);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__ACTIVE:
				setACTIVE((Object)newValue);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__PREEMPTED:
				setPREEMPTED((Object)newValue);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__SUCCEEDED:
				setSUCCEEDED((Object)newValue);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__ABORTED:
				setABORTED((Object)newValue);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__REJECTED:
				setREJECTED((Object)newValue);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__PREEMPTING:
				setPREEMPTING((Object)newValue);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__RECALLING:
				setRECALLING((Object)newValue);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__RECALLED:
				setRECALLED((Object)newValue);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__LOST:
				setLOST((Object)newValue);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__TEXT:
				setText((Object)newValue);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__STATUS:
				setStatus((Object)newValue);
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
			case Actionlib_datatypesPackage.GOAL_STATUS__PENDING:
				setPENDING(PENDING_EDEFAULT);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__ACTIVE:
				setACTIVE(ACTIVE_EDEFAULT);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__PREEMPTED:
				setPREEMPTED(PREEMPTED_EDEFAULT);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__SUCCEEDED:
				setSUCCEEDED(SUCCEEDED_EDEFAULT);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__ABORTED:
				setABORTED(ABORTED_EDEFAULT);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__REJECTED:
				setREJECTED(REJECTED_EDEFAULT);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__PREEMPTING:
				setPREEMPTING(PREEMPTING_EDEFAULT);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__RECALLING:
				setRECALLING(RECALLING_EDEFAULT);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__RECALLED:
				setRECALLED(RECALLED_EDEFAULT);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__LOST:
				setLOST(LOST_EDEFAULT);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case Actionlib_datatypesPackage.GOAL_STATUS__STATUS:
				setStatus(STATUS_EDEFAULT);
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
			case Actionlib_datatypesPackage.GOAL_STATUS__PENDING:
				return PENDING_EDEFAULT == null ? pending != null : !PENDING_EDEFAULT.equals(pending);
			case Actionlib_datatypesPackage.GOAL_STATUS__ACTIVE:
				return ACTIVE_EDEFAULT == null ? active != null : !ACTIVE_EDEFAULT.equals(active);
			case Actionlib_datatypesPackage.GOAL_STATUS__PREEMPTED:
				return PREEMPTED_EDEFAULT == null ? preempted != null : !PREEMPTED_EDEFAULT.equals(preempted);
			case Actionlib_datatypesPackage.GOAL_STATUS__SUCCEEDED:
				return SUCCEEDED_EDEFAULT == null ? succeeded != null : !SUCCEEDED_EDEFAULT.equals(succeeded);
			case Actionlib_datatypesPackage.GOAL_STATUS__ABORTED:
				return ABORTED_EDEFAULT == null ? aborted != null : !ABORTED_EDEFAULT.equals(aborted);
			case Actionlib_datatypesPackage.GOAL_STATUS__REJECTED:
				return REJECTED_EDEFAULT == null ? rejected != null : !REJECTED_EDEFAULT.equals(rejected);
			case Actionlib_datatypesPackage.GOAL_STATUS__PREEMPTING:
				return PREEMPTING_EDEFAULT == null ? preempting != null : !PREEMPTING_EDEFAULT.equals(preempting);
			case Actionlib_datatypesPackage.GOAL_STATUS__RECALLING:
				return RECALLING_EDEFAULT == null ? recalling != null : !RECALLING_EDEFAULT.equals(recalling);
			case Actionlib_datatypesPackage.GOAL_STATUS__RECALLED:
				return RECALLED_EDEFAULT == null ? recalled != null : !RECALLED_EDEFAULT.equals(recalled);
			case Actionlib_datatypesPackage.GOAL_STATUS__LOST:
				return LOST_EDEFAULT == null ? lost != null : !LOST_EDEFAULT.equals(lost);
			case Actionlib_datatypesPackage.GOAL_STATUS__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case Actionlib_datatypesPackage.GOAL_STATUS__STATUS:
				return STATUS_EDEFAULT == null ? status != null : !STATUS_EDEFAULT.equals(status);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (PENDING: ");
		result.append(pending);
		result.append(", ACTIVE: ");
		result.append(active);
		result.append(", PREEMPTED: ");
		result.append(preempted);
		result.append(", SUCCEEDED: ");
		result.append(succeeded);
		result.append(", ABORTED: ");
		result.append(aborted);
		result.append(", REJECTED: ");
		result.append(rejected);
		result.append(", PREEMPTING: ");
		result.append(preempting);
		result.append(", RECALLING: ");
		result.append(recalling);
		result.append(", RECALLED: ");
		result.append(recalled);
		result.append(", LOST: ");
		result.append(lost);
		result.append(", text: ");
		result.append(text);
		result.append(", status: ");
		result.append(status);
		result.append(')');
		return result.toString();
	}

} // GoalStatusImpl
