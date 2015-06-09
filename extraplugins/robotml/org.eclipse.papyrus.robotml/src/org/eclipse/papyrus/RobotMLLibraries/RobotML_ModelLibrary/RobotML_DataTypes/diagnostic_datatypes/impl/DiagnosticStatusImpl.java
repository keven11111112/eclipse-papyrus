/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.diagnostic_datatypes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.diagnostic_datatypes.DiagnosticStatus;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.diagnostic_datatypes.Diagnostic_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.diagnostic_datatypes.KeyValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagnostic Status</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.diagnostic_datatypes.impl.DiagnosticStatusImpl#getOK <em>OK</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.diagnostic_datatypes.impl.DiagnosticStatusImpl#getWARN <em>WARN</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.diagnostic_datatypes.impl.DiagnosticStatusImpl#getERROR <em>ERROR</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.diagnostic_datatypes.impl.DiagnosticStatusImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.diagnostic_datatypes.impl.DiagnosticStatusImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.diagnostic_datatypes.impl.DiagnosticStatusImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.diagnostic_datatypes.impl.DiagnosticStatusImpl#getHardware_id <em>Hardware id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.diagnostic_datatypes.impl.DiagnosticStatusImpl#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiagnosticStatusImpl extends MinimalEObjectImpl.Container implements DiagnosticStatus {
	/**
	 * The default value of the '{@link #getOK() <em>OK</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOK()
	 * @generated
	 * @ordered
	 */
	protected static final Object OK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOK() <em>OK</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOK()
	 * @generated
	 * @ordered
	 */
	protected Object ok = OK_EDEFAULT;

	/**
	 * The default value of the '{@link #getWARN() <em>WARN</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWARN()
	 * @generated
	 * @ordered
	 */
	protected static final Object WARN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWARN() <em>WARN</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWARN()
	 * @generated
	 * @ordered
	 */
	protected Object warn = WARN_EDEFAULT;

	/**
	 * The default value of the '{@link #getERROR() <em>ERROR</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getERROR()
	 * @generated
	 * @ordered
	 */
	protected static final Object ERROR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getERROR() <em>ERROR</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getERROR()
	 * @generated
	 * @ordered
	 */
	protected Object error = ERROR_EDEFAULT;

	/**
	 * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected static final Object LEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected Object level = LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final Object NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected Object name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final Object MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected Object message = MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getHardware_id() <em>Hardware id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHardware_id()
	 * @generated
	 * @ordered
	 */
	protected static final Object HARDWARE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHardware_id() <em>Hardware id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHardware_id()
	 * @generated
	 * @ordered
	 */
	protected Object hardware_id = HARDWARE_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<KeyValue> values;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagnosticStatusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Diagnostic_datatypesPackage.Literals.DIAGNOSTIC_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getOK() {
		return ok;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOK(Object newOK) {
		Object oldOK = ok;
		ok = newOK;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__OK, oldOK, ok));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getWARN() {
		return warn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWARN(Object newWARN) {
		Object oldWARN = warn;
		warn = newWARN;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__WARN, oldWARN, warn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getERROR() {
		return error;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setERROR(Object newERROR) {
		Object oldERROR = error;
		error = newERROR;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__ERROR, oldERROR, error));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getLevel() {
		return level;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLevel(Object newLevel) {
		Object oldLevel = level;
		level = newLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__LEVEL, oldLevel, level));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(Object newName) {
		Object oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(Object newMessage) {
		Object oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getHardware_id() {
		return hardware_id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHardware_id(Object newHardware_id) {
		Object oldHardware_id = hardware_id;
		hardware_id = newHardware_id;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__HARDWARE_ID, oldHardware_id, hardware_id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<KeyValue> getValues() {
		if (values == null) {
			values = new EObjectContainmentEList<KeyValue>(KeyValue.class, this, Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__VALUES:
				return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
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
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__OK:
				return getOK();
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__WARN:
				return getWARN();
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__ERROR:
				return getERROR();
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__LEVEL:
				return getLevel();
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__NAME:
				return getName();
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__MESSAGE:
				return getMessage();
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__HARDWARE_ID:
				return getHardware_id();
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__VALUES:
				return getValues();
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
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__OK:
				setOK((Object)newValue);
				return;
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__WARN:
				setWARN((Object)newValue);
				return;
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__ERROR:
				setERROR((Object)newValue);
				return;
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__LEVEL:
				setLevel((Object)newValue);
				return;
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__NAME:
				setName((Object)newValue);
				return;
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__MESSAGE:
				setMessage((Object)newValue);
				return;
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__HARDWARE_ID:
				setHardware_id((Object)newValue);
				return;
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends KeyValue>)newValue);
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
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__OK:
				setOK(OK_EDEFAULT);
				return;
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__WARN:
				setWARN(WARN_EDEFAULT);
				return;
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__ERROR:
				setERROR(ERROR_EDEFAULT);
				return;
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__LEVEL:
				setLevel(LEVEL_EDEFAULT);
				return;
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__HARDWARE_ID:
				setHardware_id(HARDWARE_ID_EDEFAULT);
				return;
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__VALUES:
				getValues().clear();
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
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__OK:
				return OK_EDEFAULT == null ? ok != null : !OK_EDEFAULT.equals(ok);
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__WARN:
				return WARN_EDEFAULT == null ? warn != null : !WARN_EDEFAULT.equals(warn);
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__ERROR:
				return ERROR_EDEFAULT == null ? error != null : !ERROR_EDEFAULT.equals(error);
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__LEVEL:
				return LEVEL_EDEFAULT == null ? level != null : !LEVEL_EDEFAULT.equals(level);
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__HARDWARE_ID:
				return HARDWARE_ID_EDEFAULT == null ? hardware_id != null : !HARDWARE_ID_EDEFAULT.equals(hardware_id);
			case Diagnostic_datatypesPackage.DIAGNOSTIC_STATUS__VALUES:
				return values != null && !values.isEmpty();
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
		result.append(" (OK: ");
		result.append(ok);
		result.append(", WARN: ");
		result.append(warn);
		result.append(", ERROR: ");
		result.append(error);
		result.append(", level: ");
		result.append(level);
		result.append(", name: ");
		result.append(name);
		result.append(", message: ");
		result.append(message);
		result.append(", hardware_id: ");
		result.append(hardware_id);
		result.append(')');
		return result.toString();
	}

} // DiagnosticStatusImpl
