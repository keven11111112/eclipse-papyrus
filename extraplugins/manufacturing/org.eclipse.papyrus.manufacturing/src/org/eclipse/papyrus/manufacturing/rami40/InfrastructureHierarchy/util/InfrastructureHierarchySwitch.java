/**
 */
package org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy.InfrastructureHierarchyPackage
 * @generated
 */
public class InfrastructureHierarchySwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static InfrastructureHierarchyPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureHierarchySwitch() {
		if (modelPackage == null) {
			modelPackage = InfrastructureHierarchyPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case InfrastructureHierarchyPackage._1CONNECTED_WORLD: {
				_1ConnectedWorld _1ConnectedWorld = (_1ConnectedWorld)theEObject;
				T result = case_1ConnectedWorld(_1ConnectedWorld);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InfrastructureHierarchyPackage._2ENTERPRISE_LEVEL: {
				_2EnterpriseLevel _2EnterpriseLevel = (_2EnterpriseLevel)theEObject;
				T result = case_2EnterpriseLevel(_2EnterpriseLevel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InfrastructureHierarchyPackage._3WORK_CENTERS_LEVEL: {
				_3WorkCentersLevel _3WorkCentersLevel = (_3WorkCentersLevel)theEObject;
				T result = case_3WorkCentersLevel(_3WorkCentersLevel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InfrastructureHierarchyPackage._4STATIONS_LEVEL: {
				_4StationsLevel _4StationsLevel = (_4StationsLevel)theEObject;
				T result = case_4StationsLevel(_4StationsLevel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InfrastructureHierarchyPackage._5CONTROL_DEVICE_LEVEL: {
				_5ControlDeviceLevel _5ControlDeviceLevel = (_5ControlDeviceLevel)theEObject;
				T result = case_5ControlDeviceLevel(_5ControlDeviceLevel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InfrastructureHierarchyPackage._6FIELD_DEVICE_LEVEL: {
				_6FieldDeviceLevel _6FieldDeviceLevel = (_6FieldDeviceLevel)theEObject;
				T result = case_6FieldDeviceLevel(_6FieldDeviceLevel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InfrastructureHierarchyPackage._7PRODUCT_LEVEL: {
				_7ProductLevel _7ProductLevel = (_7ProductLevel)theEObject;
				T result = case_7ProductLevel(_7ProductLevel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>1Connected World</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>1Connected World</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T case_1ConnectedWorld(_1ConnectedWorld object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>2Enterprise Level</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>2Enterprise Level</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T case_2EnterpriseLevel(_2EnterpriseLevel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>3Work Centers Level</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>3Work Centers Level</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T case_3WorkCentersLevel(_3WorkCentersLevel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>4Stations Level</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>4Stations Level</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T case_4StationsLevel(_4StationsLevel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>5Control Device Level</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>5Control Device Level</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T case_5ControlDeviceLevel(_5ControlDeviceLevel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>6Field Device Level</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>6Field Device Level</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T case_6FieldDeviceLevel(_6FieldDeviceLevel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>7Product Level</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>7Product Level</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T case_7ProductLevel(_7ProductLevel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //InfrastructureHierarchySwitch
