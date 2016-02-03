/**
 */
package org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy.InfrastructureHierarchyPackage;
import org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy._5ControlDeviceLevel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>5Control Device Level</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy.impl._5ControlDeviceLevelImpl#getBase_Package <em>Base Package</em>}</li>
 * </ul>
 *
 * @generated
 */
public class _5ControlDeviceLevelImpl extends MinimalEObjectImpl.Container implements _5ControlDeviceLevel {
	/**
	 * The cached value of the '{@link #getBase_Package() <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Package()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Package base_Package;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected _5ControlDeviceLevelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InfrastructureHierarchyPackage.Literals._5CONTROL_DEVICE_LEVEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package getBase_Package() {
		if (base_Package != null && base_Package.eIsProxy()) {
			InternalEObject oldBase_Package = (InternalEObject)base_Package;
			base_Package = (org.eclipse.uml2.uml.Package)eResolveProxy(oldBase_Package);
			if (base_Package != oldBase_Package) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InfrastructureHierarchyPackage._5CONTROL_DEVICE_LEVEL__BASE_PACKAGE, oldBase_Package, base_Package));
			}
		}
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package basicGetBase_Package() {
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Package(org.eclipse.uml2.uml.Package newBase_Package) {
		org.eclipse.uml2.uml.Package oldBase_Package = base_Package;
		base_Package = newBase_Package;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructureHierarchyPackage._5CONTROL_DEVICE_LEVEL__BASE_PACKAGE, oldBase_Package, base_Package));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InfrastructureHierarchyPackage._5CONTROL_DEVICE_LEVEL__BASE_PACKAGE:
				if (resolve) return getBase_Package();
				return basicGetBase_Package();
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
			case InfrastructureHierarchyPackage._5CONTROL_DEVICE_LEVEL__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)newValue);
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
			case InfrastructureHierarchyPackage._5CONTROL_DEVICE_LEVEL__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)null);
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
			case InfrastructureHierarchyPackage._5CONTROL_DEVICE_LEVEL__BASE_PACKAGE:
				return base_Package != null;
		}
		return super.eIsSet(featureID);
	}

} //_5ControlDeviceLevelImpl
