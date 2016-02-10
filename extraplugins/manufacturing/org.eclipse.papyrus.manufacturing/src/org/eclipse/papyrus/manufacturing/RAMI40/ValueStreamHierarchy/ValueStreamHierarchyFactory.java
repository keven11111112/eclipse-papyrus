/**
 */
package org.eclipse.papyrus.manufacturing.RAMI40.ValueStreamHierarchy;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.manufacturing.RAMI40.ValueStreamHierarchy.ValueStreamHierarchyPackage
 * @generated
 */
public interface ValueStreamHierarchyFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ValueStreamHierarchyFactory eINSTANCE = org.eclipse.papyrus.manufacturing.RAMI40.ValueStreamHierarchy.impl.ValueStreamHierarchyFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>1Business Layer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>1Business Layer</em>'.
	 * @generated
	 */
	_1BusinessLayer create_1BusinessLayer();

	/**
	 * Returns a new object of class '<em>2Functional Layer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>2Functional Layer</em>'.
	 * @generated
	 */
	_2FunctionalLayer create_2FunctionalLayer();

	/**
	 * Returns a new object of class '<em>3Information Layer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>3Information Layer</em>'.
	 * @generated
	 */
	_3InformationLayer create_3InformationLayer();

	/**
	 * Returns a new object of class '<em>4Communication Layer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>4Communication Layer</em>'.
	 * @generated
	 */
	_4CommunicationLayer create_4CommunicationLayer();

	/**
	 * Returns a new object of class '<em>5Integration Layer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>5Integration Layer</em>'.
	 * @generated
	 */
	_5IntegrationLayer create_5IntegrationLayer();

	/**
	 * Returns a new object of class '<em>6Asset Layer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>6Asset Layer</em>'.
	 * @generated
	 */
	_6AssetLayer create_6AssetLayer();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ValueStreamHierarchyPackage getValueStreamHierarchyPackage();

} //ValueStreamHierarchyFactory
