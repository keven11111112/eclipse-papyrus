/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.ColorRGBA;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Std_datatypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Color RGBA</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.ColorRGBAImpl#getR <em>R</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.ColorRGBAImpl#getG <em>G</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.ColorRGBAImpl#getB <em>B</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.impl.ColorRGBAImpl#getA <em>A</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColorRGBAImpl extends MinimalEObjectImpl.Container implements ColorRGBA {
	/**
	 * The default value of the '{@link #getR() <em>R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getR()
	 * @generated
	 * @ordered
	 */
	protected static final Object R_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getR() <em>R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getR()
	 * @generated
	 * @ordered
	 */
	protected Object r = R_EDEFAULT;

	/**
	 * The default value of the '{@link #getG() <em>G</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getG()
	 * @generated
	 * @ordered
	 */
	protected static final Object G_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getG() <em>G</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getG()
	 * @generated
	 * @ordered
	 */
	protected Object g = G_EDEFAULT;

	/**
	 * The default value of the '{@link #getB() <em>B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getB()
	 * @generated
	 * @ordered
	 */
	protected static final Object B_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getB() <em>B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getB()
	 * @generated
	 * @ordered
	 */
	protected Object b = B_EDEFAULT;

	/**
	 * The default value of the '{@link #getA() <em>A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA()
	 * @generated
	 * @ordered
	 */
	protected static final Object A_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getA() <em>A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA()
	 * @generated
	 * @ordered
	 */
	protected Object a = A_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColorRGBAImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Std_datatypesPackage.Literals.COLOR_RGBA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getR() {
		return r;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setR(Object newR) {
		Object oldR = r;
		r = newR;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Std_datatypesPackage.COLOR_RGBA__R, oldR, r));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getG() {
		return g;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setG(Object newG) {
		Object oldG = g;
		g = newG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Std_datatypesPackage.COLOR_RGBA__G, oldG, g));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getB() {
		return b;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setB(Object newB) {
		Object oldB = b;
		b = newB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Std_datatypesPackage.COLOR_RGBA__B, oldB, b));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getA() {
		return a;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setA(Object newA) {
		Object oldA = a;
		a = newA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Std_datatypesPackage.COLOR_RGBA__A, oldA, a));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Std_datatypesPackage.COLOR_RGBA__R:
				return getR();
			case Std_datatypesPackage.COLOR_RGBA__G:
				return getG();
			case Std_datatypesPackage.COLOR_RGBA__B:
				return getB();
			case Std_datatypesPackage.COLOR_RGBA__A:
				return getA();
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
			case Std_datatypesPackage.COLOR_RGBA__R:
				setR((Object)newValue);
				return;
			case Std_datatypesPackage.COLOR_RGBA__G:
				setG((Object)newValue);
				return;
			case Std_datatypesPackage.COLOR_RGBA__B:
				setB((Object)newValue);
				return;
			case Std_datatypesPackage.COLOR_RGBA__A:
				setA((Object)newValue);
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
			case Std_datatypesPackage.COLOR_RGBA__R:
				setR(R_EDEFAULT);
				return;
			case Std_datatypesPackage.COLOR_RGBA__G:
				setG(G_EDEFAULT);
				return;
			case Std_datatypesPackage.COLOR_RGBA__B:
				setB(B_EDEFAULT);
				return;
			case Std_datatypesPackage.COLOR_RGBA__A:
				setA(A_EDEFAULT);
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
			case Std_datatypesPackage.COLOR_RGBA__R:
				return R_EDEFAULT == null ? r != null : !R_EDEFAULT.equals(r);
			case Std_datatypesPackage.COLOR_RGBA__G:
				return G_EDEFAULT == null ? g != null : !G_EDEFAULT.equals(g);
			case Std_datatypesPackage.COLOR_RGBA__B:
				return B_EDEFAULT == null ? b != null : !B_EDEFAULT.equals(b);
			case Std_datatypesPackage.COLOR_RGBA__A:
				return A_EDEFAULT == null ? a != null : !A_EDEFAULT.equals(a);
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
		result.append(" (r: ");
		result.append(r);
		result.append(", g: ");
		result.append(g);
		result.append(", b: ");
		result.append(b);
		result.append(", a: ");
		result.append(a);
		result.append(')');
		return result.toString();
	}

} // ColorRGBAImpl
