/**
 */
package org.eclipse.papyrus.RobotML.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.RobotML.LidarSystem;
import org.eclipse.papyrus.RobotML.RobotMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lidar System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#getNbLayers <em>Nb Layers</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#getLayerAngleMin <em>Layer Angle Min</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#getLayerAngleStep <em>Layer Angle Step</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#getNoise <em>Noise</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#getSigmaNoise <em>Sigma Noise</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#getAngle_min <em>Angle min</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#getAngle_max <em>Angle max</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#getTime_increment <em>Time increment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#getScan_time <em>Scan time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#getRange_min <em>Range min</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#getRange_max <em>Range max</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl#getNbRays <em>Nb Rays</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LidarSystemImpl extends ObjectDetectionSensorSystemImpl implements LidarSystem {
	/**
	 * The default value of the '{@link #getNbLayers() <em>Nb Layers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbLayers()
	 * @generated
	 * @ordered
	 */
	protected static final Object NB_LAYERS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNbLayers() <em>Nb Layers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbLayers()
	 * @generated
	 * @ordered
	 */
	protected Object nbLayers = NB_LAYERS_EDEFAULT;

	/**
	 * The default value of the '{@link #getLayerAngleMin() <em>Layer Angle Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayerAngleMin()
	 * @generated
	 * @ordered
	 */
	protected static final Object LAYER_ANGLE_MIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLayerAngleMin() <em>Layer Angle Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayerAngleMin()
	 * @generated
	 * @ordered
	 */
	protected Object layerAngleMin = LAYER_ANGLE_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getLayerAngleStep() <em>Layer Angle Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayerAngleStep()
	 * @generated
	 * @ordered
	 */
	protected static final Object LAYER_ANGLE_STEP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLayerAngleStep() <em>Layer Angle Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayerAngleStep()
	 * @generated
	 * @ordered
	 */
	protected Object layerAngleStep = LAYER_ANGLE_STEP_EDEFAULT;

	/**
	 * The default value of the '{@link #getNoise() <em>Noise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNoise()
	 * @generated
	 * @ordered
	 */
	protected static final Object NOISE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNoise() <em>Noise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNoise()
	 * @generated
	 * @ordered
	 */
	protected Object noise = NOISE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSigmaNoise() <em>Sigma Noise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSigmaNoise()
	 * @generated
	 * @ordered
	 */
	protected static final Object SIGMA_NOISE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSigmaNoise() <em>Sigma Noise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSigmaNoise()
	 * @generated
	 * @ordered
	 */
	protected Object sigmaNoise = SIGMA_NOISE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAngle_min() <em>Angle min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAngle_min()
	 * @generated
	 * @ordered
	 */
	protected static final Object ANGLE_MIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAngle_min() <em>Angle min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAngle_min()
	 * @generated
	 * @ordered
	 */
	protected Object angle_min = ANGLE_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getAngle_max() <em>Angle max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAngle_max()
	 * @generated
	 * @ordered
	 */
	protected static final Object ANGLE_MAX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAngle_max() <em>Angle max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAngle_max()
	 * @generated
	 * @ordered
	 */
	protected Object angle_max = ANGLE_MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getTime_increment() <em>Time increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime_increment()
	 * @generated
	 * @ordered
	 */
	protected static final Object TIME_INCREMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTime_increment() <em>Time increment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime_increment()
	 * @generated
	 * @ordered
	 */
	protected Object time_increment = TIME_INCREMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getScan_time() <em>Scan time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScan_time()
	 * @generated
	 * @ordered
	 */
	protected static final Object SCAN_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getScan_time() <em>Scan time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScan_time()
	 * @generated
	 * @ordered
	 */
	protected Object scan_time = SCAN_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getRange_min() <em>Range min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRange_min()
	 * @generated
	 * @ordered
	 */
	protected static final Object RANGE_MIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRange_min() <em>Range min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRange_min()
	 * @generated
	 * @ordered
	 */
	protected Object range_min = RANGE_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getRange_max() <em>Range max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRange_max()
	 * @generated
	 * @ordered
	 */
	protected static final Object RANGE_MAX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRange_max() <em>Range max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRange_max()
	 * @generated
	 * @ordered
	 */
	protected Object range_max = RANGE_MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getNbRays() <em>Nb Rays</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbRays()
	 * @generated
	 * @ordered
	 */
	protected static final Object NB_RAYS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNbRays() <em>Nb Rays</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbRays()
	 * @generated
	 * @ordered
	 */
	protected Object nbRays = NB_RAYS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LidarSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotMLPackage.Literals.LIDAR_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getNbLayers() {
		return nbLayers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbLayers(Object newNbLayers) {
		Object oldNbLayers = nbLayers;
		nbLayers = newNbLayers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__NB_LAYERS, oldNbLayers, nbLayers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getLayerAngleMin() {
		return layerAngleMin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayerAngleMin(Object newLayerAngleMin) {
		Object oldLayerAngleMin = layerAngleMin;
		layerAngleMin = newLayerAngleMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__LAYER_ANGLE_MIN, oldLayerAngleMin, layerAngleMin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getLayerAngleStep() {
		return layerAngleStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayerAngleStep(Object newLayerAngleStep) {
		Object oldLayerAngleStep = layerAngleStep;
		layerAngleStep = newLayerAngleStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__LAYER_ANGLE_STEP, oldLayerAngleStep, layerAngleStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getNoise() {
		return noise;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNoise(Object newNoise) {
		Object oldNoise = noise;
		noise = newNoise;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__NOISE, oldNoise, noise));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getSigmaNoise() {
		return sigmaNoise;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSigmaNoise(Object newSigmaNoise) {
		Object oldSigmaNoise = sigmaNoise;
		sigmaNoise = newSigmaNoise;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__SIGMA_NOISE, oldSigmaNoise, sigmaNoise));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getAngle_min() {
		return angle_min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAngle_min(Object newAngle_min) {
		Object oldAngle_min = angle_min;
		angle_min = newAngle_min;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__ANGLE_MIN, oldAngle_min, angle_min));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getAngle_max() {
		return angle_max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAngle_max(Object newAngle_max) {
		Object oldAngle_max = angle_max;
		angle_max = newAngle_max;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__ANGLE_MAX, oldAngle_max, angle_max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getTime_increment() {
		return time_increment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTime_increment(Object newTime_increment) {
		Object oldTime_increment = time_increment;
		time_increment = newTime_increment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__TIME_INCREMENT, oldTime_increment, time_increment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getScan_time() {
		return scan_time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScan_time(Object newScan_time) {
		Object oldScan_time = scan_time;
		scan_time = newScan_time;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__SCAN_TIME, oldScan_time, scan_time));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRange_min() {
		return range_min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRange_min(Object newRange_min) {
		Object oldRange_min = range_min;
		range_min = newRange_min;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__RANGE_MIN, oldRange_min, range_min));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRange_max() {
		return range_max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRange_max(Object newRange_max) {
		Object oldRange_max = range_max;
		range_max = newRange_max;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__RANGE_MAX, oldRange_max, range_max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getNbRays() {
		return nbRays;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbRays(Object newNbRays) {
		Object oldNbRays = nbRays;
		nbRays = newNbRays;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.LIDAR_SYSTEM__NB_RAYS, oldNbRays, nbRays));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RobotMLPackage.LIDAR_SYSTEM__NB_LAYERS:
				return getNbLayers();
			case RobotMLPackage.LIDAR_SYSTEM__LAYER_ANGLE_MIN:
				return getLayerAngleMin();
			case RobotMLPackage.LIDAR_SYSTEM__LAYER_ANGLE_STEP:
				return getLayerAngleStep();
			case RobotMLPackage.LIDAR_SYSTEM__NOISE:
				return getNoise();
			case RobotMLPackage.LIDAR_SYSTEM__SIGMA_NOISE:
				return getSigmaNoise();
			case RobotMLPackage.LIDAR_SYSTEM__ANGLE_MIN:
				return getAngle_min();
			case RobotMLPackage.LIDAR_SYSTEM__ANGLE_MAX:
				return getAngle_max();
			case RobotMLPackage.LIDAR_SYSTEM__TIME_INCREMENT:
				return getTime_increment();
			case RobotMLPackage.LIDAR_SYSTEM__SCAN_TIME:
				return getScan_time();
			case RobotMLPackage.LIDAR_SYSTEM__RANGE_MIN:
				return getRange_min();
			case RobotMLPackage.LIDAR_SYSTEM__RANGE_MAX:
				return getRange_max();
			case RobotMLPackage.LIDAR_SYSTEM__NB_RAYS:
				return getNbRays();
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
			case RobotMLPackage.LIDAR_SYSTEM__NB_LAYERS:
				setNbLayers((Object)newValue);
				return;
			case RobotMLPackage.LIDAR_SYSTEM__LAYER_ANGLE_MIN:
				setLayerAngleMin((Object)newValue);
				return;
			case RobotMLPackage.LIDAR_SYSTEM__LAYER_ANGLE_STEP:
				setLayerAngleStep((Object)newValue);
				return;
			case RobotMLPackage.LIDAR_SYSTEM__NOISE:
				setNoise((Object)newValue);
				return;
			case RobotMLPackage.LIDAR_SYSTEM__SIGMA_NOISE:
				setSigmaNoise((Object)newValue);
				return;
			case RobotMLPackage.LIDAR_SYSTEM__ANGLE_MIN:
				setAngle_min((Object)newValue);
				return;
			case RobotMLPackage.LIDAR_SYSTEM__ANGLE_MAX:
				setAngle_max((Object)newValue);
				return;
			case RobotMLPackage.LIDAR_SYSTEM__TIME_INCREMENT:
				setTime_increment((Object)newValue);
				return;
			case RobotMLPackage.LIDAR_SYSTEM__SCAN_TIME:
				setScan_time((Object)newValue);
				return;
			case RobotMLPackage.LIDAR_SYSTEM__RANGE_MIN:
				setRange_min((Object)newValue);
				return;
			case RobotMLPackage.LIDAR_SYSTEM__RANGE_MAX:
				setRange_max((Object)newValue);
				return;
			case RobotMLPackage.LIDAR_SYSTEM__NB_RAYS:
				setNbRays((Object)newValue);
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
			case RobotMLPackage.LIDAR_SYSTEM__NB_LAYERS:
				setNbLayers(NB_LAYERS_EDEFAULT);
				return;
			case RobotMLPackage.LIDAR_SYSTEM__LAYER_ANGLE_MIN:
				setLayerAngleMin(LAYER_ANGLE_MIN_EDEFAULT);
				return;
			case RobotMLPackage.LIDAR_SYSTEM__LAYER_ANGLE_STEP:
				setLayerAngleStep(LAYER_ANGLE_STEP_EDEFAULT);
				return;
			case RobotMLPackage.LIDAR_SYSTEM__NOISE:
				setNoise(NOISE_EDEFAULT);
				return;
			case RobotMLPackage.LIDAR_SYSTEM__SIGMA_NOISE:
				setSigmaNoise(SIGMA_NOISE_EDEFAULT);
				return;
			case RobotMLPackage.LIDAR_SYSTEM__ANGLE_MIN:
				setAngle_min(ANGLE_MIN_EDEFAULT);
				return;
			case RobotMLPackage.LIDAR_SYSTEM__ANGLE_MAX:
				setAngle_max(ANGLE_MAX_EDEFAULT);
				return;
			case RobotMLPackage.LIDAR_SYSTEM__TIME_INCREMENT:
				setTime_increment(TIME_INCREMENT_EDEFAULT);
				return;
			case RobotMLPackage.LIDAR_SYSTEM__SCAN_TIME:
				setScan_time(SCAN_TIME_EDEFAULT);
				return;
			case RobotMLPackage.LIDAR_SYSTEM__RANGE_MIN:
				setRange_min(RANGE_MIN_EDEFAULT);
				return;
			case RobotMLPackage.LIDAR_SYSTEM__RANGE_MAX:
				setRange_max(RANGE_MAX_EDEFAULT);
				return;
			case RobotMLPackage.LIDAR_SYSTEM__NB_RAYS:
				setNbRays(NB_RAYS_EDEFAULT);
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
			case RobotMLPackage.LIDAR_SYSTEM__NB_LAYERS:
				return NB_LAYERS_EDEFAULT == null ? nbLayers != null : !NB_LAYERS_EDEFAULT.equals(nbLayers);
			case RobotMLPackage.LIDAR_SYSTEM__LAYER_ANGLE_MIN:
				return LAYER_ANGLE_MIN_EDEFAULT == null ? layerAngleMin != null : !LAYER_ANGLE_MIN_EDEFAULT.equals(layerAngleMin);
			case RobotMLPackage.LIDAR_SYSTEM__LAYER_ANGLE_STEP:
				return LAYER_ANGLE_STEP_EDEFAULT == null ? layerAngleStep != null : !LAYER_ANGLE_STEP_EDEFAULT.equals(layerAngleStep);
			case RobotMLPackage.LIDAR_SYSTEM__NOISE:
				return NOISE_EDEFAULT == null ? noise != null : !NOISE_EDEFAULT.equals(noise);
			case RobotMLPackage.LIDAR_SYSTEM__SIGMA_NOISE:
				return SIGMA_NOISE_EDEFAULT == null ? sigmaNoise != null : !SIGMA_NOISE_EDEFAULT.equals(sigmaNoise);
			case RobotMLPackage.LIDAR_SYSTEM__ANGLE_MIN:
				return ANGLE_MIN_EDEFAULT == null ? angle_min != null : !ANGLE_MIN_EDEFAULT.equals(angle_min);
			case RobotMLPackage.LIDAR_SYSTEM__ANGLE_MAX:
				return ANGLE_MAX_EDEFAULT == null ? angle_max != null : !ANGLE_MAX_EDEFAULT.equals(angle_max);
			case RobotMLPackage.LIDAR_SYSTEM__TIME_INCREMENT:
				return TIME_INCREMENT_EDEFAULT == null ? time_increment != null : !TIME_INCREMENT_EDEFAULT.equals(time_increment);
			case RobotMLPackage.LIDAR_SYSTEM__SCAN_TIME:
				return SCAN_TIME_EDEFAULT == null ? scan_time != null : !SCAN_TIME_EDEFAULT.equals(scan_time);
			case RobotMLPackage.LIDAR_SYSTEM__RANGE_MIN:
				return RANGE_MIN_EDEFAULT == null ? range_min != null : !RANGE_MIN_EDEFAULT.equals(range_min);
			case RobotMLPackage.LIDAR_SYSTEM__RANGE_MAX:
				return RANGE_MAX_EDEFAULT == null ? range_max != null : !RANGE_MAX_EDEFAULT.equals(range_max);
			case RobotMLPackage.LIDAR_SYSTEM__NB_RAYS:
				return NB_RAYS_EDEFAULT == null ? nbRays != null : !NB_RAYS_EDEFAULT.equals(nbRays);
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
		result.append(" (nbLayers: ");
		result.append(nbLayers);
		result.append(", layerAngleMin: ");
		result.append(layerAngleMin);
		result.append(", layerAngleStep: ");
		result.append(layerAngleStep);
		result.append(", noise: ");
		result.append(noise);
		result.append(", sigmaNoise: ");
		result.append(sigmaNoise);
		result.append(", angle_min: ");
		result.append(angle_min);
		result.append(", angle_max: ");
		result.append(angle_max);
		result.append(", time_increment: ");
		result.append(time_increment);
		result.append(", scan_time: ");
		result.append(scan_time);
		result.append(", range_min: ");
		result.append(range_min);
		result.append(", range_max: ");
		result.append(range_max);
		result.append(", nbRays: ");
		result.append(nbRays);
		result.append(')');
		return result.toString();
	}

} // LidarSystemImpl
