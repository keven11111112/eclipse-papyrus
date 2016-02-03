/**
 */
package org.eclipse.papyrus.manufacturing.rami40.ValueStreamHierarchy.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.manufacturing.rami40.ValueStreamHierarchy.*;

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
 * @see org.eclipse.papyrus.manufacturing.rami40.ValueStreamHierarchy.ValueStreamHierarchyPackage
 * @generated
 */
public class ValueStreamHierarchySwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ValueStreamHierarchyPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueStreamHierarchySwitch() {
		if (modelPackage == null) {
			modelPackage = ValueStreamHierarchyPackage.eINSTANCE;
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
			case ValueStreamHierarchyPackage._1BUSINESS_LAYER: {
				_1BusinessLayer _1BusinessLayer = (_1BusinessLayer)theEObject;
				T result = case_1BusinessLayer(_1BusinessLayer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValueStreamHierarchyPackage._2FUNCTIONAL_LAYER: {
				_2FunctionalLayer _2FunctionalLayer = (_2FunctionalLayer)theEObject;
				T result = case_2FunctionalLayer(_2FunctionalLayer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValueStreamHierarchyPackage._3INFORMATION_LAYER: {
				_3InformationLayer _3InformationLayer = (_3InformationLayer)theEObject;
				T result = case_3InformationLayer(_3InformationLayer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValueStreamHierarchyPackage._4COMMUNICATION_LAYER: {
				_4CommunicationLayer _4CommunicationLayer = (_4CommunicationLayer)theEObject;
				T result = case_4CommunicationLayer(_4CommunicationLayer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValueStreamHierarchyPackage._5INTEGRATION_LAYER: {
				_5IntegrationLayer _5IntegrationLayer = (_5IntegrationLayer)theEObject;
				T result = case_5IntegrationLayer(_5IntegrationLayer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ValueStreamHierarchyPackage._6ASSET_LAYER: {
				_6AssetLayer _6AssetLayer = (_6AssetLayer)theEObject;
				T result = case_6AssetLayer(_6AssetLayer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>1Business Layer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>1Business Layer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T case_1BusinessLayer(_1BusinessLayer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>2Functional Layer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>2Functional Layer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T case_2FunctionalLayer(_2FunctionalLayer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>3Information Layer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>3Information Layer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T case_3InformationLayer(_3InformationLayer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>4Communication Layer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>4Communication Layer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T case_4CommunicationLayer(_4CommunicationLayer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>5Integration Layer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>5Integration Layer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T case_5IntegrationLayer(_5IntegrationLayer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>6Asset Layer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>6Asset Layer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T case_6AssetLayer(_6AssetLayer object) {
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

} //ValueStreamHierarchySwitch
