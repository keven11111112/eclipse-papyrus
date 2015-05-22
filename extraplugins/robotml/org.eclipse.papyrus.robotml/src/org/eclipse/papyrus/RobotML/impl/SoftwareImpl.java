/**
 */
package org.eclipse.papyrus.RobotML.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.RobotML.RobotMLPackage;
import org.eclipse.papyrus.RobotML.Software;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Software</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SoftwareImpl#isPeriodic <em>Is Periodic</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SoftwareImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SoftwareImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SoftwareImpl#getDeadline <em>Deadline</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SoftwareImpl#getWcet <em>Wcet</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SoftwareImpl extends SystemImpl implements Software {
	/**
	 * The default value of the '{@link #isPeriodic() <em>Is Periodic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPeriodic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PERIODIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPeriodic() <em>Is Periodic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPeriodic()
	 * @generated
	 * @ordered
	 */
	protected boolean isPeriodic = IS_PERIODIC_EDEFAULT;

	/**
	 * The default value of the '{@link #getPeriod() <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriod()
	 * @generated
	 * @ordered
	 */
	protected static final Object PERIOD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPeriod() <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriod()
	 * @generated
	 * @ordered
	 */
	protected Object period = PERIOD_EDEFAULT;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final Object PRIORITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected Object priority = PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getDeadline() <em>Deadline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeadline()
	 * @generated
	 * @ordered
	 */
	protected static final Object DEADLINE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDeadline() <em>Deadline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeadline()
	 * @generated
	 * @ordered
	 */
	protected Object deadline = DEADLINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getWcet() <em>Wcet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWcet()
	 * @generated
	 * @ordered
	 */
	protected static final Object WCET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWcet() <em>Wcet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWcet()
	 * @generated
	 * @ordered
	 */
	protected Object wcet = WCET_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SoftwareImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotMLPackage.Literals.SOFTWARE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPeriodic() {
		return isPeriodic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsPeriodic(boolean newIsPeriodic) {
		boolean oldIsPeriodic = isPeriodic;
		isPeriodic = newIsPeriodic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.SOFTWARE__IS_PERIODIC, oldIsPeriodic, isPeriodic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPeriod() {
		return period;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeriod(Object newPeriod) {
		Object oldPeriod = period;
		period = newPeriod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.SOFTWARE__PERIOD, oldPeriod, period));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(Object newPriority) {
		Object oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.SOFTWARE__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getDeadline() {
		return deadline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeadline(Object newDeadline) {
		Object oldDeadline = deadline;
		deadline = newDeadline;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.SOFTWARE__DEADLINE, oldDeadline, deadline));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getWcet() {
		return wcet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWcet(Object newWcet) {
		Object oldWcet = wcet;
		wcet = newWcet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.SOFTWARE__WCET, oldWcet, wcet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RobotMLPackage.SOFTWARE__IS_PERIODIC:
				return isPeriodic();
			case RobotMLPackage.SOFTWARE__PERIOD:
				return getPeriod();
			case RobotMLPackage.SOFTWARE__PRIORITY:
				return getPriority();
			case RobotMLPackage.SOFTWARE__DEADLINE:
				return getDeadline();
			case RobotMLPackage.SOFTWARE__WCET:
				return getWcet();
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
			case RobotMLPackage.SOFTWARE__IS_PERIODIC:
				setIsPeriodic((Boolean)newValue);
				return;
			case RobotMLPackage.SOFTWARE__PERIOD:
				setPeriod((Object)newValue);
				return;
			case RobotMLPackage.SOFTWARE__PRIORITY:
				setPriority((Object)newValue);
				return;
			case RobotMLPackage.SOFTWARE__DEADLINE:
				setDeadline((Object)newValue);
				return;
			case RobotMLPackage.SOFTWARE__WCET:
				setWcet((Object)newValue);
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
			case RobotMLPackage.SOFTWARE__IS_PERIODIC:
				setIsPeriodic(IS_PERIODIC_EDEFAULT);
				return;
			case RobotMLPackage.SOFTWARE__PERIOD:
				setPeriod(PERIOD_EDEFAULT);
				return;
			case RobotMLPackage.SOFTWARE__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case RobotMLPackage.SOFTWARE__DEADLINE:
				setDeadline(DEADLINE_EDEFAULT);
				return;
			case RobotMLPackage.SOFTWARE__WCET:
				setWcet(WCET_EDEFAULT);
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
			case RobotMLPackage.SOFTWARE__IS_PERIODIC:
				return isPeriodic != IS_PERIODIC_EDEFAULT;
			case RobotMLPackage.SOFTWARE__PERIOD:
				return PERIOD_EDEFAULT == null ? period != null : !PERIOD_EDEFAULT.equals(period);
			case RobotMLPackage.SOFTWARE__PRIORITY:
				return PRIORITY_EDEFAULT == null ? priority != null : !PRIORITY_EDEFAULT.equals(priority);
			case RobotMLPackage.SOFTWARE__DEADLINE:
				return DEADLINE_EDEFAULT == null ? deadline != null : !DEADLINE_EDEFAULT.equals(deadline);
			case RobotMLPackage.SOFTWARE__WCET:
				return WCET_EDEFAULT == null ? wcet != null : !WCET_EDEFAULT.equals(wcet);
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
		result.append(" (isPeriodic: ");
		result.append(isPeriodic);
		result.append(", period: ");
		result.append(period);
		result.append(", priority: ");
		result.append(priority);
		result.append(", deadline: ");
		result.append(deadline);
		result.append(", wcet: ");
		result.append(wcet);
		result.append(')');
		return result.toString();
	}

} // SoftwareImpl
