/**
 */
package org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy.InfrastructureHierarchyPackage
 * @generated
 */
public interface InfrastructureHierarchyFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InfrastructureHierarchyFactory eINSTANCE = org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy.impl.InfrastructureHierarchyFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>1Connected World</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>1Connected World</em>'.
	 * @generated
	 */
	_1ConnectedWorld create_1ConnectedWorld();

	/**
	 * Returns a new object of class '<em>2Enterprise Level</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>2Enterprise Level</em>'.
	 * @generated
	 */
	_2EnterpriseLevel create_2EnterpriseLevel();

	/**
	 * Returns a new object of class '<em>3Work Centers Level</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>3Work Centers Level</em>'.
	 * @generated
	 */
	_3WorkCentersLevel create_3WorkCentersLevel();

	/**
	 * Returns a new object of class '<em>4Stations Level</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>4Stations Level</em>'.
	 * @generated
	 */
	_4StationsLevel create_4StationsLevel();

	/**
	 * Returns a new object of class '<em>5Control Device Level</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>5Control Device Level</em>'.
	 * @generated
	 */
	_5ControlDeviceLevel create_5ControlDeviceLevel();

	/**
	 * Returns a new object of class '<em>6Field Device Level</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>6Field Device Level</em>'.
	 * @generated
	 */
	_6FieldDeviceLevel create_6FieldDeviceLevel();

	/**
	 * Returns a new object of class '<em>7Product Level</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>7Product Level</em>'.
	 * @generated
	 */
	_7ProductLevel create_7ProductLevel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	InfrastructureHierarchyPackage getInfrastructureHierarchyPackage();

} //InfrastructureHierarchyFactory
