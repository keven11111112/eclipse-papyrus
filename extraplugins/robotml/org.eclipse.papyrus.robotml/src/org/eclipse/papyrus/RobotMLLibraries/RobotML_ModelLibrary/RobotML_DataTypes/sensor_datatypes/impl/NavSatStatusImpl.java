/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.NavSatStatus;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Std_datatypesFactory;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Std_datatypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nav Sat Status</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatStatusImpl#getSTATUS_NO_FIX <em>STATUS NO FIX</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatStatusImpl#getSTATUS_FIX <em>STATUS FIX</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatStatusImpl#getSTATUS_SBAS_FIX <em>STATUS SBAS FIX</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatStatusImpl#getSTATUS_GBAS_FIX <em>STATUS GBAS FIX</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatStatusImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatStatusImpl#getSERVICE_GPS <em>SERVICE GPS</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatStatusImpl#getSERVICE_GLONASS <em>SERVICE GLONASS</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatStatusImpl#getSERVICE_COMPASS <em>SERVICE COMPASS</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatStatusImpl#getSERVICE_GALILEO <em>SERVICE GALILEO</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.NavSatStatusImpl#getService <em>Service</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NavSatStatusImpl extends MinimalEObjectImpl.Container implements NavSatStatus {
	/**
	 * The default value of the '{@link #getSTATUS_NO_FIX() <em>STATUS NO FIX</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSTATUS_NO_FIX()
	 * @generated
	 * @ordered
	 */
	protected static final Object STATUS_NO_FIX_EDEFAULT = (Object)Std_datatypesFactory.eINSTANCE.createFromString(Std_datatypesPackage.eINSTANCE.getInt8(), "-1");

	/**
	 * The cached value of the '{@link #getSTATUS_NO_FIX() <em>STATUS NO FIX</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSTATUS_NO_FIX()
	 * @generated
	 * @ordered
	 */
	protected Object statuS_NO_FIX = STATUS_NO_FIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getSTATUS_FIX() <em>STATUS FIX</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSTATUS_FIX()
	 * @generated
	 * @ordered
	 */
	protected static final Object STATUS_FIX_EDEFAULT = (Object)Std_datatypesFactory.eINSTANCE.createFromString(Std_datatypesPackage.eINSTANCE.getInt8(), "0");

	/**
	 * The cached value of the '{@link #getSTATUS_FIX() <em>STATUS FIX</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSTATUS_FIX()
	 * @generated
	 * @ordered
	 */
	protected Object statuS_FIX = STATUS_FIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getSTATUS_SBAS_FIX() <em>STATUS SBAS FIX</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSTATUS_SBAS_FIX()
	 * @generated
	 * @ordered
	 */
	protected static final Object STATUS_SBAS_FIX_EDEFAULT = (Object)Std_datatypesFactory.eINSTANCE.createFromString(Std_datatypesPackage.eINSTANCE.getInt8(), "1");

	/**
	 * The cached value of the '{@link #getSTATUS_SBAS_FIX() <em>STATUS SBAS FIX</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSTATUS_SBAS_FIX()
	 * @generated
	 * @ordered
	 */
	protected Object statuS_SBAS_FIX = STATUS_SBAS_FIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getSTATUS_GBAS_FIX() <em>STATUS GBAS FIX</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSTATUS_GBAS_FIX()
	 * @generated
	 * @ordered
	 */
	protected static final Object STATUS_GBAS_FIX_EDEFAULT = (Object)Std_datatypesFactory.eINSTANCE.createFromString(Std_datatypesPackage.eINSTANCE.getInt8(), "2");

	/**
	 * The cached value of the '{@link #getSTATUS_GBAS_FIX() <em>STATUS GBAS FIX</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSTATUS_GBAS_FIX()
	 * @generated
	 * @ordered
	 */
	protected Object statuS_GBAS_FIX = STATUS_GBAS_FIX_EDEFAULT;

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
	 * The default value of the '{@link #getSERVICE_GPS() <em>SERVICE GPS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSERVICE_GPS()
	 * @generated
	 * @ordered
	 */
	protected static final Object SERVICE_GPS_EDEFAULT = (Object)Std_datatypesFactory.eINSTANCE.createFromString(Std_datatypesPackage.eINSTANCE.getUInt16(), "1");

	/**
	 * The cached value of the '{@link #getSERVICE_GPS() <em>SERVICE GPS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSERVICE_GPS()
	 * @generated
	 * @ordered
	 */
	protected Object servicE_GPS = SERVICE_GPS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSERVICE_GLONASS() <em>SERVICE GLONASS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSERVICE_GLONASS()
	 * @generated
	 * @ordered
	 */
	protected static final Object SERVICE_GLONASS_EDEFAULT = (Object)Std_datatypesFactory.eINSTANCE.createFromString(Std_datatypesPackage.eINSTANCE.getUInt16(), "2");

	/**
	 * The cached value of the '{@link #getSERVICE_GLONASS() <em>SERVICE GLONASS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSERVICE_GLONASS()
	 * @generated
	 * @ordered
	 */
	protected Object servicE_GLONASS = SERVICE_GLONASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSERVICE_COMPASS() <em>SERVICE COMPASS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSERVICE_COMPASS()
	 * @generated
	 * @ordered
	 */
	protected static final Object SERVICE_COMPASS_EDEFAULT = (Object)Std_datatypesFactory.eINSTANCE.createFromString(Std_datatypesPackage.eINSTANCE.getUInt16(), "4");

	/**
	 * The cached value of the '{@link #getSERVICE_COMPASS() <em>SERVICE COMPASS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSERVICE_COMPASS()
	 * @generated
	 * @ordered
	 */
	protected Object servicE_COMPASS = SERVICE_COMPASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSERVICE_GALILEO() <em>SERVICE GALILEO</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSERVICE_GALILEO()
	 * @generated
	 * @ordered
	 */
	protected static final Object SERVICE_GALILEO_EDEFAULT = (Object)Std_datatypesFactory.eINSTANCE.createFromString(Std_datatypesPackage.eINSTANCE.getUInt16(), "8");

	/**
	 * The cached value of the '{@link #getSERVICE_GALILEO() <em>SERVICE GALILEO</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSERVICE_GALILEO()
	 * @generated
	 * @ordered
	 */
	protected Object servicE_GALILEO = SERVICE_GALILEO_EDEFAULT;

	/**
	 * The default value of the '{@link #getService() <em>Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getService()
	 * @generated
	 * @ordered
	 */
	protected static final Object SERVICE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getService() <em>Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getService()
	 * @generated
	 * @ordered
	 */
	protected Object service = SERVICE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NavSatStatusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Sensor_datatypesPackage.Literals.NAV_SAT_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getSTATUS_NO_FIX() {
		return statuS_NO_FIX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getSTATUS_FIX() {
		return statuS_FIX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getSTATUS_SBAS_FIX() {
		return statuS_SBAS_FIX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getSTATUS_GBAS_FIX() {
		return statuS_GBAS_FIX;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getSERVICE_GPS() {
		return servicE_GPS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getSERVICE_GLONASS() {
		return servicE_GLONASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getSERVICE_COMPASS() {
		return servicE_COMPASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getSERVICE_GALILEO() {
		return servicE_GALILEO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getService() {
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setService(Object newService) {
		Object oldService = service;
		service = newService;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE, oldService, service));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS_NO_FIX:
				return getSTATUS_NO_FIX();
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS_FIX:
				return getSTATUS_FIX();
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS_SBAS_FIX:
				return getSTATUS_SBAS_FIX();
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS_GBAS_FIX:
				return getSTATUS_GBAS_FIX();
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS:
				return getStatus();
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE_GPS:
				return getSERVICE_GPS();
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE_GLONASS:
				return getSERVICE_GLONASS();
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE_COMPASS:
				return getSERVICE_COMPASS();
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE_GALILEO:
				return getSERVICE_GALILEO();
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE:
				return getService();
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
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS:
				setStatus((Object)newValue);
				return;
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE:
				setService((Object)newValue);
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
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE:
				setService(SERVICE_EDEFAULT);
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
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS_NO_FIX:
				return STATUS_NO_FIX_EDEFAULT == null ? statuS_NO_FIX != null : !STATUS_NO_FIX_EDEFAULT.equals(statuS_NO_FIX);
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS_FIX:
				return STATUS_FIX_EDEFAULT == null ? statuS_FIX != null : !STATUS_FIX_EDEFAULT.equals(statuS_FIX);
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS_SBAS_FIX:
				return STATUS_SBAS_FIX_EDEFAULT == null ? statuS_SBAS_FIX != null : !STATUS_SBAS_FIX_EDEFAULT.equals(statuS_SBAS_FIX);
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS_GBAS_FIX:
				return STATUS_GBAS_FIX_EDEFAULT == null ? statuS_GBAS_FIX != null : !STATUS_GBAS_FIX_EDEFAULT.equals(statuS_GBAS_FIX);
			case Sensor_datatypesPackage.NAV_SAT_STATUS__STATUS:
				return STATUS_EDEFAULT == null ? status != null : !STATUS_EDEFAULT.equals(status);
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE_GPS:
				return SERVICE_GPS_EDEFAULT == null ? servicE_GPS != null : !SERVICE_GPS_EDEFAULT.equals(servicE_GPS);
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE_GLONASS:
				return SERVICE_GLONASS_EDEFAULT == null ? servicE_GLONASS != null : !SERVICE_GLONASS_EDEFAULT.equals(servicE_GLONASS);
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE_COMPASS:
				return SERVICE_COMPASS_EDEFAULT == null ? servicE_COMPASS != null : !SERVICE_COMPASS_EDEFAULT.equals(servicE_COMPASS);
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE_GALILEO:
				return SERVICE_GALILEO_EDEFAULT == null ? servicE_GALILEO != null : !SERVICE_GALILEO_EDEFAULT.equals(servicE_GALILEO);
			case Sensor_datatypesPackage.NAV_SAT_STATUS__SERVICE:
				return SERVICE_EDEFAULT == null ? service != null : !SERVICE_EDEFAULT.equals(service);
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
		result.append(" (STATUS_NO_FIX: ");
		result.append(statuS_NO_FIX);
		result.append(", STATUS_FIX: ");
		result.append(statuS_FIX);
		result.append(", STATUS_SBAS_FIX: ");
		result.append(statuS_SBAS_FIX);
		result.append(", STATUS_GBAS_FIX: ");
		result.append(statuS_GBAS_FIX);
		result.append(", status: ");
		result.append(status);
		result.append(", SERVICE_GPS: ");
		result.append(servicE_GPS);
		result.append(", SERVICE_GLONASS: ");
		result.append(servicE_GLONASS);
		result.append(", SERVICE_COMPASS: ");
		result.append(servicE_COMPASS);
		result.append(", SERVICE_GALILEO: ");
		result.append(servicE_GALILEO);
		result.append(", service: ");
		result.append(service);
		result.append(')');
		return result.toString();
	}

} // NavSatStatusImpl
