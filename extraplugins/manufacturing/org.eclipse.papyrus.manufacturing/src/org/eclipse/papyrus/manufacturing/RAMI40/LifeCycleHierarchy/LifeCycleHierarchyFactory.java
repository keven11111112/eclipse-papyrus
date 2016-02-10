/**
 */
package org.eclipse.papyrus.manufacturing.RAMI40.LifeCycleHierarchy;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.manufacturing.RAMI40.LifeCycleHierarchy.LifeCycleHierarchyPackage
 * @generated
 */
public interface LifeCycleHierarchyFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LifeCycleHierarchyFactory eINSTANCE = org.eclipse.papyrus.manufacturing.RAMI40.LifeCycleHierarchy.impl.LifeCycleHierarchyFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>2Instance Production</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>2Instance Production</em>'.
	 * @generated
	 */
	_2InstanceProduction create_2InstanceProduction();

	/**
	 * Returns a new object of class '<em>1Type Development</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>1Type Development</em>'.
	 * @generated
	 */
	_1TypeDevelopment create_1TypeDevelopment();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LifeCycleHierarchyPackage getLifeCycleHierarchyPackage();

} //LifeCycleHierarchyFactory
