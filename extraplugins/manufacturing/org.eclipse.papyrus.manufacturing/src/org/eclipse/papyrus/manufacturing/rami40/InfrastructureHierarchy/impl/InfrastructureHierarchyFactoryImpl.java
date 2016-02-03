/**
 */
package org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InfrastructureHierarchyFactoryImpl extends EFactoryImpl implements InfrastructureHierarchyFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InfrastructureHierarchyFactory init() {
		try {
			InfrastructureHierarchyFactory theInfrastructureHierarchyFactory = (InfrastructureHierarchyFactory)EPackage.Registry.INSTANCE.getEFactory(InfrastructureHierarchyPackage.eNS_URI);
			if (theInfrastructureHierarchyFactory != null) {
				return theInfrastructureHierarchyFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new InfrastructureHierarchyFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureHierarchyFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case InfrastructureHierarchyPackage._1CONNECTED_WORLD: return create_1ConnectedWorld();
			case InfrastructureHierarchyPackage._2ENTERPRISE_LEVEL: return create_2EnterpriseLevel();
			case InfrastructureHierarchyPackage._3WORK_CENTERS_LEVEL: return create_3WorkCentersLevel();
			case InfrastructureHierarchyPackage._4STATIONS_LEVEL: return create_4StationsLevel();
			case InfrastructureHierarchyPackage._5CONTROL_DEVICE_LEVEL: return create_5ControlDeviceLevel();
			case InfrastructureHierarchyPackage._6FIELD_DEVICE_LEVEL: return create_6FieldDeviceLevel();
			case InfrastructureHierarchyPackage._7PRODUCT_LEVEL: return create_7ProductLevel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public _1ConnectedWorld create_1ConnectedWorld() {
		_1ConnectedWorldImpl _1ConnectedWorld = new _1ConnectedWorldImpl();
		return _1ConnectedWorld;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public _2EnterpriseLevel create_2EnterpriseLevel() {
		_2EnterpriseLevelImpl _2EnterpriseLevel = new _2EnterpriseLevelImpl();
		return _2EnterpriseLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public _3WorkCentersLevel create_3WorkCentersLevel() {
		_3WorkCentersLevelImpl _3WorkCentersLevel = new _3WorkCentersLevelImpl();
		return _3WorkCentersLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public _4StationsLevel create_4StationsLevel() {
		_4StationsLevelImpl _4StationsLevel = new _4StationsLevelImpl();
		return _4StationsLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public _5ControlDeviceLevel create_5ControlDeviceLevel() {
		_5ControlDeviceLevelImpl _5ControlDeviceLevel = new _5ControlDeviceLevelImpl();
		return _5ControlDeviceLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public _6FieldDeviceLevel create_6FieldDeviceLevel() {
		_6FieldDeviceLevelImpl _6FieldDeviceLevel = new _6FieldDeviceLevelImpl();
		return _6FieldDeviceLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public _7ProductLevel create_7ProductLevel() {
		_7ProductLevelImpl _7ProductLevel = new _7ProductLevelImpl();
		return _7ProductLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureHierarchyPackage getInfrastructureHierarchyPackage() {
		return (InfrastructureHierarchyPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static InfrastructureHierarchyPackage getPackage() {
		return InfrastructureHierarchyPackage.eINSTANCE;
	}

} //InfrastructureHierarchyFactoryImpl
