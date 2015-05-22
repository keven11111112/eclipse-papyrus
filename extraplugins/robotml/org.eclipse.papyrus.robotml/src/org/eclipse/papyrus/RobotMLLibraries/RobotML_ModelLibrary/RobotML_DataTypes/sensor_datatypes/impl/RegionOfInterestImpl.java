/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.RegionOfInterest;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Region Of Interest</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RegionOfInterestImpl#getX_offset <em>Xoffset</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RegionOfInterestImpl#getY_offset <em>Yoffset</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RegionOfInterestImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RegionOfInterestImpl#getDo_rectify <em>Do rectify</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RegionOfInterestImpl#getWidth <em>Width</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegionOfInterestImpl extends MinimalEObjectImpl.Container implements RegionOfInterest {
	/**
	 * The default value of the '{@link #getX_offset() <em>Xoffset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX_offset()
	 * @generated
	 * @ordered
	 */
	protected static final Object XOFFSET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getX_offset() <em>Xoffset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX_offset()
	 * @generated
	 * @ordered
	 */
	protected Object x_offset = XOFFSET_EDEFAULT;

	/**
	 * The default value of the '{@link #getY_offset() <em>Yoffset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY_offset()
	 * @generated
	 * @ordered
	 */
	protected static final Object YOFFSET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getY_offset() <em>Yoffset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY_offset()
	 * @generated
	 * @ordered
	 */
	protected Object y_offset = YOFFSET_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final Object HEIGHT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected Object height = HEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDo_rectify() <em>Do rectify</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDo_rectify()
	 * @generated
	 * @ordered
	 */
	protected static final Object DO_RECTIFY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDo_rectify() <em>Do rectify</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDo_rectify()
	 * @generated
	 * @ordered
	 */
	protected Object do_rectify = DO_RECTIFY_EDEFAULT;

	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final Object WIDTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected Object width = WIDTH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegionOfInterestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Sensor_datatypesPackage.Literals.REGION_OF_INTEREST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getX_offset() {
		return x_offset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX_offset(Object newX_offset) {
		Object oldX_offset = x_offset;
		x_offset = newX_offset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.REGION_OF_INTEREST__XOFFSET, oldX_offset, x_offset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getY_offset() {
		return y_offset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setY_offset(Object newY_offset) {
		Object oldY_offset = y_offset;
		y_offset = newY_offset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.REGION_OF_INTEREST__YOFFSET, oldY_offset, y_offset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getHeight() {
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeight(Object newHeight) {
		Object oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.REGION_OF_INTEREST__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getDo_rectify() {
		return do_rectify;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDo_rectify(Object newDo_rectify) {
		Object oldDo_rectify = do_rectify;
		do_rectify = newDo_rectify;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.REGION_OF_INTEREST__DO_RECTIFY, oldDo_rectify, do_rectify));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(Object newWidth) {
		Object oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.REGION_OF_INTEREST__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Sensor_datatypesPackage.REGION_OF_INTEREST__XOFFSET:
				return getX_offset();
			case Sensor_datatypesPackage.REGION_OF_INTEREST__YOFFSET:
				return getY_offset();
			case Sensor_datatypesPackage.REGION_OF_INTEREST__HEIGHT:
				return getHeight();
			case Sensor_datatypesPackage.REGION_OF_INTEREST__DO_RECTIFY:
				return getDo_rectify();
			case Sensor_datatypesPackage.REGION_OF_INTEREST__WIDTH:
				return getWidth();
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
			case Sensor_datatypesPackage.REGION_OF_INTEREST__XOFFSET:
				setX_offset((Object)newValue);
				return;
			case Sensor_datatypesPackage.REGION_OF_INTEREST__YOFFSET:
				setY_offset((Object)newValue);
				return;
			case Sensor_datatypesPackage.REGION_OF_INTEREST__HEIGHT:
				setHeight((Object)newValue);
				return;
			case Sensor_datatypesPackage.REGION_OF_INTEREST__DO_RECTIFY:
				setDo_rectify((Object)newValue);
				return;
			case Sensor_datatypesPackage.REGION_OF_INTEREST__WIDTH:
				setWidth((Object)newValue);
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
			case Sensor_datatypesPackage.REGION_OF_INTEREST__XOFFSET:
				setX_offset(XOFFSET_EDEFAULT);
				return;
			case Sensor_datatypesPackage.REGION_OF_INTEREST__YOFFSET:
				setY_offset(YOFFSET_EDEFAULT);
				return;
			case Sensor_datatypesPackage.REGION_OF_INTEREST__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case Sensor_datatypesPackage.REGION_OF_INTEREST__DO_RECTIFY:
				setDo_rectify(DO_RECTIFY_EDEFAULT);
				return;
			case Sensor_datatypesPackage.REGION_OF_INTEREST__WIDTH:
				setWidth(WIDTH_EDEFAULT);
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
			case Sensor_datatypesPackage.REGION_OF_INTEREST__XOFFSET:
				return XOFFSET_EDEFAULT == null ? x_offset != null : !XOFFSET_EDEFAULT.equals(x_offset);
			case Sensor_datatypesPackage.REGION_OF_INTEREST__YOFFSET:
				return YOFFSET_EDEFAULT == null ? y_offset != null : !YOFFSET_EDEFAULT.equals(y_offset);
			case Sensor_datatypesPackage.REGION_OF_INTEREST__HEIGHT:
				return HEIGHT_EDEFAULT == null ? height != null : !HEIGHT_EDEFAULT.equals(height);
			case Sensor_datatypesPackage.REGION_OF_INTEREST__DO_RECTIFY:
				return DO_RECTIFY_EDEFAULT == null ? do_rectify != null : !DO_RECTIFY_EDEFAULT.equals(do_rectify);
			case Sensor_datatypesPackage.REGION_OF_INTEREST__WIDTH:
				return WIDTH_EDEFAULT == null ? width != null : !WIDTH_EDEFAULT.equals(width);
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
		result.append(" (x_offset: ");
		result.append(x_offset);
		result.append(", y_offset: ");
		result.append(y_offset);
		result.append(", height: ");
		result.append(height);
		result.append(", do_rectify: ");
		result.append(do_rectify);
		result.append(", width: ");
		result.append(width);
		result.append(')');
		return result.toString();
	}

} // RegionOfInterestImpl
