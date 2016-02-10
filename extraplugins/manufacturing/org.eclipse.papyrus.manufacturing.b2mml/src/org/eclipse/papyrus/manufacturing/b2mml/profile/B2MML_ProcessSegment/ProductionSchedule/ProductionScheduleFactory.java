/**
 */
package org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.ProductionSchedulePackage
 * @generated
 */
public interface ProductionScheduleFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProductionScheduleFactory eINSTANCE = org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.impl.ProductionScheduleFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Production Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Production Schedule</em>'.
	 * @generated
	 */
	ProductionSchedule createProductionSchedule();

	/**
	 * Returns a new object of class '<em>Production Request</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Production Request</em>'.
	 * @generated
	 */
	ProductionRequest createProductionRequest();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ProductionSchedulePackage getProductionSchedulePackage();

} //ProductionScheduleFactory
