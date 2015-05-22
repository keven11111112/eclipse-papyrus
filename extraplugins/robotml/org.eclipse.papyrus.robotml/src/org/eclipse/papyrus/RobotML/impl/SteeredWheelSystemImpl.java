/**
 */
package org.eclipse.papyrus.RobotML.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.RobotML.RobotMLPackage;
import org.eclipse.papyrus.RobotML.SteeredWheelSystem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Steered Wheel System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getWheelRadius <em>Wheel Radius</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getWheelWidth <em>Wheel Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getSuspensionRestLength <em>Suspension Rest Length</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getWheelConnectionHeight <em>Wheel Connection Height</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getTypeOfWheel <em>Type Of Wheel</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getWheelVelocityPIDkp <em>Wheel Velocity PI Dkp</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getWheelVelocityPIDki <em>Wheel Velocity PI Dki</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getWheelVelocityPIDkd <em>Wheel Velocity PI Dkd</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getWheelSteeringPIDkp <em>Wheel Steering PI Dkp</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getWheelSteeringPIDkd <em>Wheel Steering PI Dkd</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getWheelFriction <em>Wheel Friction</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getSuspensionStiffness <em>Suspension Stiffness</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getSuspensionDamping <em>Suspension Damping</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getSuspensionCompression <em>Suspension Compression</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getWheelVelocityPIDmaxSum <em>Wheel Velocity PI Dmax Sum</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl#getWheelVelocityPIDmaxVal <em>Wheel Velocity PI Dmax Val</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SteeredWheelSystemImpl extends LocomotionSystemImpl implements SteeredWheelSystem {
	/**
	 * The default value of the '{@link #getWheelRadius() <em>Wheel Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelRadius()
	 * @generated
	 * @ordered
	 */
	protected static final Object WHEEL_RADIUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWheelRadius() <em>Wheel Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelRadius()
	 * @generated
	 * @ordered
	 */
	protected Object wheelRadius = WHEEL_RADIUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getWheelWidth() <em>Wheel Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelWidth()
	 * @generated
	 * @ordered
	 */
	protected static final Object WHEEL_WIDTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWheelWidth() <em>Wheel Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelWidth()
	 * @generated
	 * @ordered
	 */
	protected Object wheelWidth = WHEEL_WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuspensionRestLength() <em>Suspension Rest Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspensionRestLength()
	 * @generated
	 * @ordered
	 */
	protected static final Object SUSPENSION_REST_LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuspensionRestLength() <em>Suspension Rest Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspensionRestLength()
	 * @generated
	 * @ordered
	 */
	protected Object suspensionRestLength = SUSPENSION_REST_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getWheelConnectionHeight() <em>Wheel Connection Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelConnectionHeight()
	 * @generated
	 * @ordered
	 */
	protected static final Object WHEEL_CONNECTION_HEIGHT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWheelConnectionHeight() <em>Wheel Connection Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelConnectionHeight()
	 * @generated
	 * @ordered
	 */
	protected Object wheelConnectionHeight = WHEEL_CONNECTION_HEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTypeOfWheel() <em>Type Of Wheel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeOfWheel()
	 * @generated
	 * @ordered
	 */
	protected static final Object TYPE_OF_WHEEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypeOfWheel() <em>Type Of Wheel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeOfWheel()
	 * @generated
	 * @ordered
	 */
	protected Object typeOfWheel = TYPE_OF_WHEEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getWheelVelocityPIDkp() <em>Wheel Velocity PI Dkp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelVelocityPIDkp()
	 * @generated
	 * @ordered
	 */
	protected static final Object WHEEL_VELOCITY_PI_DKP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWheelVelocityPIDkp() <em>Wheel Velocity PI Dkp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelVelocityPIDkp()
	 * @generated
	 * @ordered
	 */
	protected Object wheelVelocityPIDkp = WHEEL_VELOCITY_PI_DKP_EDEFAULT;

	/**
	 * The default value of the '{@link #getWheelVelocityPIDki() <em>Wheel Velocity PI Dki</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelVelocityPIDki()
	 * @generated
	 * @ordered
	 */
	protected static final Object WHEEL_VELOCITY_PI_DKI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWheelVelocityPIDki() <em>Wheel Velocity PI Dki</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelVelocityPIDki()
	 * @generated
	 * @ordered
	 */
	protected Object wheelVelocityPIDki = WHEEL_VELOCITY_PI_DKI_EDEFAULT;

	/**
	 * The default value of the '{@link #getWheelVelocityPIDkd() <em>Wheel Velocity PI Dkd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelVelocityPIDkd()
	 * @generated
	 * @ordered
	 */
	protected static final Object WHEEL_VELOCITY_PI_DKD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWheelVelocityPIDkd() <em>Wheel Velocity PI Dkd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelVelocityPIDkd()
	 * @generated
	 * @ordered
	 */
	protected Object wheelVelocityPIDkd = WHEEL_VELOCITY_PI_DKD_EDEFAULT;

	/**
	 * The default value of the '{@link #getWheelSteeringPIDkp() <em>Wheel Steering PI Dkp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelSteeringPIDkp()
	 * @generated
	 * @ordered
	 */
	protected static final Object WHEEL_STEERING_PI_DKP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWheelSteeringPIDkp() <em>Wheel Steering PI Dkp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelSteeringPIDkp()
	 * @generated
	 * @ordered
	 */
	protected Object wheelSteeringPIDkp = WHEEL_STEERING_PI_DKP_EDEFAULT;

	/**
	 * The default value of the '{@link #getWheelSteeringPIDkd() <em>Wheel Steering PI Dkd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelSteeringPIDkd()
	 * @generated
	 * @ordered
	 */
	protected static final Object WHEEL_STEERING_PI_DKD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWheelSteeringPIDkd() <em>Wheel Steering PI Dkd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelSteeringPIDkd()
	 * @generated
	 * @ordered
	 */
	protected Object wheelSteeringPIDkd = WHEEL_STEERING_PI_DKD_EDEFAULT;

	/**
	 * The default value of the '{@link #getWheelFriction() <em>Wheel Friction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelFriction()
	 * @generated
	 * @ordered
	 */
	protected static final Object WHEEL_FRICTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWheelFriction() <em>Wheel Friction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelFriction()
	 * @generated
	 * @ordered
	 */
	protected Object wheelFriction = WHEEL_FRICTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuspensionStiffness() <em>Suspension Stiffness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspensionStiffness()
	 * @generated
	 * @ordered
	 */
	protected static final Object SUSPENSION_STIFFNESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuspensionStiffness() <em>Suspension Stiffness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspensionStiffness()
	 * @generated
	 * @ordered
	 */
	protected Object suspensionStiffness = SUSPENSION_STIFFNESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuspensionDamping() <em>Suspension Damping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspensionDamping()
	 * @generated
	 * @ordered
	 */
	protected static final Object SUSPENSION_DAMPING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuspensionDamping() <em>Suspension Damping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspensionDamping()
	 * @generated
	 * @ordered
	 */
	protected Object suspensionDamping = SUSPENSION_DAMPING_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuspensionCompression() <em>Suspension Compression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspensionCompression()
	 * @generated
	 * @ordered
	 */
	protected static final Object SUSPENSION_COMPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuspensionCompression() <em>Suspension Compression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuspensionCompression()
	 * @generated
	 * @ordered
	 */
	protected Object suspensionCompression = SUSPENSION_COMPRESSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getWheelVelocityPIDmaxSum() <em>Wheel Velocity PI Dmax Sum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelVelocityPIDmaxSum()
	 * @generated
	 * @ordered
	 */
	protected static final Object WHEEL_VELOCITY_PI_DMAX_SUM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWheelVelocityPIDmaxSum() <em>Wheel Velocity PI Dmax Sum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelVelocityPIDmaxSum()
	 * @generated
	 * @ordered
	 */
	protected Object wheelVelocityPIDmaxSum = WHEEL_VELOCITY_PI_DMAX_SUM_EDEFAULT;

	/**
	 * The default value of the '{@link #getWheelVelocityPIDmaxVal() <em>Wheel Velocity PI Dmax Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelVelocityPIDmaxVal()
	 * @generated
	 * @ordered
	 */
	protected static final Object WHEEL_VELOCITY_PI_DMAX_VAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWheelVelocityPIDmaxVal() <em>Wheel Velocity PI Dmax Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWheelVelocityPIDmaxVal()
	 * @generated
	 * @ordered
	 */
	protected Object wheelVelocityPIDmaxVal = WHEEL_VELOCITY_PI_DMAX_VAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SteeredWheelSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RobotMLPackage.Literals.STEERED_WHEEL_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getWheelRadius() {
		return wheelRadius;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWheelRadius(Object newWheelRadius) {
		Object oldWheelRadius = wheelRadius;
		wheelRadius = newWheelRadius;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_RADIUS, oldWheelRadius, wheelRadius));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getWheelWidth() {
		return wheelWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWheelWidth(Object newWheelWidth) {
		Object oldWheelWidth = wheelWidth;
		wheelWidth = newWheelWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_WIDTH, oldWheelWidth, wheelWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getSuspensionRestLength() {
		return suspensionRestLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuspensionRestLength(Object newSuspensionRestLength) {
		Object oldSuspensionRestLength = suspensionRestLength;
		suspensionRestLength = newSuspensionRestLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_REST_LENGTH, oldSuspensionRestLength, suspensionRestLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getWheelConnectionHeight() {
		return wheelConnectionHeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWheelConnectionHeight(Object newWheelConnectionHeight) {
		Object oldWheelConnectionHeight = wheelConnectionHeight;
		wheelConnectionHeight = newWheelConnectionHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_CONNECTION_HEIGHT, oldWheelConnectionHeight, wheelConnectionHeight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getTypeOfWheel() {
		return typeOfWheel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeOfWheel(Object newTypeOfWheel) {
		Object oldTypeOfWheel = typeOfWheel;
		typeOfWheel = newTypeOfWheel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__TYPE_OF_WHEEL, oldTypeOfWheel, typeOfWheel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getWheelVelocityPIDkp() {
		return wheelVelocityPIDkp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWheelVelocityPIDkp(Object newWheelVelocityPIDkp) {
		Object oldWheelVelocityPIDkp = wheelVelocityPIDkp;
		wheelVelocityPIDkp = newWheelVelocityPIDkp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKP, oldWheelVelocityPIDkp, wheelVelocityPIDkp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getWheelVelocityPIDki() {
		return wheelVelocityPIDki;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWheelVelocityPIDki(Object newWheelVelocityPIDki) {
		Object oldWheelVelocityPIDki = wheelVelocityPIDki;
		wheelVelocityPIDki = newWheelVelocityPIDki;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKI, oldWheelVelocityPIDki, wheelVelocityPIDki));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getWheelVelocityPIDkd() {
		return wheelVelocityPIDkd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWheelVelocityPIDkd(Object newWheelVelocityPIDkd) {
		Object oldWheelVelocityPIDkd = wheelVelocityPIDkd;
		wheelVelocityPIDkd = newWheelVelocityPIDkd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKD, oldWheelVelocityPIDkd, wheelVelocityPIDkd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getWheelSteeringPIDkp() {
		return wheelSteeringPIDkp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWheelSteeringPIDkp(Object newWheelSteeringPIDkp) {
		Object oldWheelSteeringPIDkp = wheelSteeringPIDkp;
		wheelSteeringPIDkp = newWheelSteeringPIDkp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKP, oldWheelSteeringPIDkp, wheelSteeringPIDkp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getWheelSteeringPIDkd() {
		return wheelSteeringPIDkd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWheelSteeringPIDkd(Object newWheelSteeringPIDkd) {
		Object oldWheelSteeringPIDkd = wheelSteeringPIDkd;
		wheelSteeringPIDkd = newWheelSteeringPIDkd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKD, oldWheelSteeringPIDkd, wheelSteeringPIDkd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getWheelFriction() {
		return wheelFriction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWheelFriction(Object newWheelFriction) {
		Object oldWheelFriction = wheelFriction;
		wheelFriction = newWheelFriction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_FRICTION, oldWheelFriction, wheelFriction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getSuspensionStiffness() {
		return suspensionStiffness;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuspensionStiffness(Object newSuspensionStiffness) {
		Object oldSuspensionStiffness = suspensionStiffness;
		suspensionStiffness = newSuspensionStiffness;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_STIFFNESS, oldSuspensionStiffness, suspensionStiffness));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getSuspensionDamping() {
		return suspensionDamping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuspensionDamping(Object newSuspensionDamping) {
		Object oldSuspensionDamping = suspensionDamping;
		suspensionDamping = newSuspensionDamping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_DAMPING, oldSuspensionDamping, suspensionDamping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getSuspensionCompression() {
		return suspensionCompression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuspensionCompression(Object newSuspensionCompression) {
		Object oldSuspensionCompression = suspensionCompression;
		suspensionCompression = newSuspensionCompression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_COMPRESSION, oldSuspensionCompression, suspensionCompression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getWheelVelocityPIDmaxSum() {
		return wheelVelocityPIDmaxSum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWheelVelocityPIDmaxSum(Object newWheelVelocityPIDmaxSum) {
		Object oldWheelVelocityPIDmaxSum = wheelVelocityPIDmaxSum;
		wheelVelocityPIDmaxSum = newWheelVelocityPIDmaxSum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_SUM, oldWheelVelocityPIDmaxSum, wheelVelocityPIDmaxSum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getWheelVelocityPIDmaxVal() {
		return wheelVelocityPIDmaxVal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWheelVelocityPIDmaxVal(Object newWheelVelocityPIDmaxVal) {
		Object oldWheelVelocityPIDmaxVal = wheelVelocityPIDmaxVal;
		wheelVelocityPIDmaxVal = newWheelVelocityPIDmaxVal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_VAL, oldWheelVelocityPIDmaxVal, wheelVelocityPIDmaxVal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_RADIUS:
				return getWheelRadius();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_WIDTH:
				return getWheelWidth();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_REST_LENGTH:
				return getSuspensionRestLength();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_CONNECTION_HEIGHT:
				return getWheelConnectionHeight();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__TYPE_OF_WHEEL:
				return getTypeOfWheel();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKP:
				return getWheelVelocityPIDkp();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKI:
				return getWheelVelocityPIDki();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKD:
				return getWheelVelocityPIDkd();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKP:
				return getWheelSteeringPIDkp();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKD:
				return getWheelSteeringPIDkd();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_FRICTION:
				return getWheelFriction();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_STIFFNESS:
				return getSuspensionStiffness();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_DAMPING:
				return getSuspensionDamping();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_COMPRESSION:
				return getSuspensionCompression();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_SUM:
				return getWheelVelocityPIDmaxSum();
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_VAL:
				return getWheelVelocityPIDmaxVal();
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
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_RADIUS:
				setWheelRadius((Object)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_WIDTH:
				setWheelWidth((Object)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_REST_LENGTH:
				setSuspensionRestLength((Object)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_CONNECTION_HEIGHT:
				setWheelConnectionHeight((Object)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__TYPE_OF_WHEEL:
				setTypeOfWheel((Object)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKP:
				setWheelVelocityPIDkp((Object)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKI:
				setWheelVelocityPIDki((Object)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKD:
				setWheelVelocityPIDkd((Object)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKP:
				setWheelSteeringPIDkp((Object)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKD:
				setWheelSteeringPIDkd((Object)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_FRICTION:
				setWheelFriction((Object)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_STIFFNESS:
				setSuspensionStiffness((Object)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_DAMPING:
				setSuspensionDamping((Object)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_COMPRESSION:
				setSuspensionCompression((Object)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_SUM:
				setWheelVelocityPIDmaxSum((Object)newValue);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_VAL:
				setWheelVelocityPIDmaxVal((Object)newValue);
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
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_RADIUS:
				setWheelRadius(WHEEL_RADIUS_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_WIDTH:
				setWheelWidth(WHEEL_WIDTH_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_REST_LENGTH:
				setSuspensionRestLength(SUSPENSION_REST_LENGTH_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_CONNECTION_HEIGHT:
				setWheelConnectionHeight(WHEEL_CONNECTION_HEIGHT_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__TYPE_OF_WHEEL:
				setTypeOfWheel(TYPE_OF_WHEEL_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKP:
				setWheelVelocityPIDkp(WHEEL_VELOCITY_PI_DKP_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKI:
				setWheelVelocityPIDki(WHEEL_VELOCITY_PI_DKI_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKD:
				setWheelVelocityPIDkd(WHEEL_VELOCITY_PI_DKD_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKP:
				setWheelSteeringPIDkp(WHEEL_STEERING_PI_DKP_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKD:
				setWheelSteeringPIDkd(WHEEL_STEERING_PI_DKD_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_FRICTION:
				setWheelFriction(WHEEL_FRICTION_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_STIFFNESS:
				setSuspensionStiffness(SUSPENSION_STIFFNESS_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_DAMPING:
				setSuspensionDamping(SUSPENSION_DAMPING_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_COMPRESSION:
				setSuspensionCompression(SUSPENSION_COMPRESSION_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_SUM:
				setWheelVelocityPIDmaxSum(WHEEL_VELOCITY_PI_DMAX_SUM_EDEFAULT);
				return;
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_VAL:
				setWheelVelocityPIDmaxVal(WHEEL_VELOCITY_PI_DMAX_VAL_EDEFAULT);
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
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_RADIUS:
				return WHEEL_RADIUS_EDEFAULT == null ? wheelRadius != null : !WHEEL_RADIUS_EDEFAULT.equals(wheelRadius);
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_WIDTH:
				return WHEEL_WIDTH_EDEFAULT == null ? wheelWidth != null : !WHEEL_WIDTH_EDEFAULT.equals(wheelWidth);
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_REST_LENGTH:
				return SUSPENSION_REST_LENGTH_EDEFAULT == null ? suspensionRestLength != null : !SUSPENSION_REST_LENGTH_EDEFAULT.equals(suspensionRestLength);
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_CONNECTION_HEIGHT:
				return WHEEL_CONNECTION_HEIGHT_EDEFAULT == null ? wheelConnectionHeight != null : !WHEEL_CONNECTION_HEIGHT_EDEFAULT.equals(wheelConnectionHeight);
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__TYPE_OF_WHEEL:
				return TYPE_OF_WHEEL_EDEFAULT == null ? typeOfWheel != null : !TYPE_OF_WHEEL_EDEFAULT.equals(typeOfWheel);
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKP:
				return WHEEL_VELOCITY_PI_DKP_EDEFAULT == null ? wheelVelocityPIDkp != null : !WHEEL_VELOCITY_PI_DKP_EDEFAULT.equals(wheelVelocityPIDkp);
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKI:
				return WHEEL_VELOCITY_PI_DKI_EDEFAULT == null ? wheelVelocityPIDki != null : !WHEEL_VELOCITY_PI_DKI_EDEFAULT.equals(wheelVelocityPIDki);
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKD:
				return WHEEL_VELOCITY_PI_DKD_EDEFAULT == null ? wheelVelocityPIDkd != null : !WHEEL_VELOCITY_PI_DKD_EDEFAULT.equals(wheelVelocityPIDkd);
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKP:
				return WHEEL_STEERING_PI_DKP_EDEFAULT == null ? wheelSteeringPIDkp != null : !WHEEL_STEERING_PI_DKP_EDEFAULT.equals(wheelSteeringPIDkp);
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKD:
				return WHEEL_STEERING_PI_DKD_EDEFAULT == null ? wheelSteeringPIDkd != null : !WHEEL_STEERING_PI_DKD_EDEFAULT.equals(wheelSteeringPIDkd);
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_FRICTION:
				return WHEEL_FRICTION_EDEFAULT == null ? wheelFriction != null : !WHEEL_FRICTION_EDEFAULT.equals(wheelFriction);
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_STIFFNESS:
				return SUSPENSION_STIFFNESS_EDEFAULT == null ? suspensionStiffness != null : !SUSPENSION_STIFFNESS_EDEFAULT.equals(suspensionStiffness);
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_DAMPING:
				return SUSPENSION_DAMPING_EDEFAULT == null ? suspensionDamping != null : !SUSPENSION_DAMPING_EDEFAULT.equals(suspensionDamping);
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__SUSPENSION_COMPRESSION:
				return SUSPENSION_COMPRESSION_EDEFAULT == null ? suspensionCompression != null : !SUSPENSION_COMPRESSION_EDEFAULT.equals(suspensionCompression);
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_SUM:
				return WHEEL_VELOCITY_PI_DMAX_SUM_EDEFAULT == null ? wheelVelocityPIDmaxSum != null : !WHEEL_VELOCITY_PI_DMAX_SUM_EDEFAULT.equals(wheelVelocityPIDmaxSum);
			case RobotMLPackage.STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_VAL:
				return WHEEL_VELOCITY_PI_DMAX_VAL_EDEFAULT == null ? wheelVelocityPIDmaxVal != null : !WHEEL_VELOCITY_PI_DMAX_VAL_EDEFAULT.equals(wheelVelocityPIDmaxVal);
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
		result.append(" (wheelRadius: ");
		result.append(wheelRadius);
		result.append(", wheelWidth: ");
		result.append(wheelWidth);
		result.append(", suspensionRestLength: ");
		result.append(suspensionRestLength);
		result.append(", wheelConnectionHeight: ");
		result.append(wheelConnectionHeight);
		result.append(", typeOfWheel: ");
		result.append(typeOfWheel);
		result.append(", wheelVelocityPIDkp: ");
		result.append(wheelVelocityPIDkp);
		result.append(", wheelVelocityPIDki: ");
		result.append(wheelVelocityPIDki);
		result.append(", wheelVelocityPIDkd: ");
		result.append(wheelVelocityPIDkd);
		result.append(", wheelSteeringPIDkp: ");
		result.append(wheelSteeringPIDkp);
		result.append(", wheelSteeringPIDkd: ");
		result.append(wheelSteeringPIDkd);
		result.append(", wheelFriction: ");
		result.append(wheelFriction);
		result.append(", suspensionStiffness: ");
		result.append(suspensionStiffness);
		result.append(", suspensionDamping: ");
		result.append(suspensionDamping);
		result.append(", suspensionCompression: ");
		result.append(suspensionCompression);
		result.append(", wheelVelocityPIDmaxSum: ");
		result.append(wheelVelocityPIDmaxSum);
		result.append(", wheelVelocityPIDmaxVal: ");
		result.append(wheelVelocityPIDmaxVal);
		result.append(')');
		return result.toString();
	}

} // SteeredWheelSystemImpl
