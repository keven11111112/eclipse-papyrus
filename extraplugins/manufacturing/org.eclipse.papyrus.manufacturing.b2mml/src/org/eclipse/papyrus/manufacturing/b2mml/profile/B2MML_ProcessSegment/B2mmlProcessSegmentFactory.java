/**
 */
package org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.B2mmlProcessSegmentPackage
 * @generated
 */
public interface B2mmlProcessSegmentFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	B2mmlProcessSegmentFactory eINSTANCE = org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.B2mmlProcessSegmentFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Process Segment Information</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process Segment Information</em>'.
	 * @generated
	 */
	ProcessSegmentInformation createProcessSegmentInformation();

	/**
	 * Returns a new object of class '<em>Process Segment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process Segment</em>'.
	 * @generated
	 */
	ProcessSegment createProcessSegment();

	/**
	 * Returns a new object of class '<em>Process Segment Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process Segment Parameter</em>'.
	 * @generated
	 */
	ProcessSegmentParameter createProcessSegmentParameter();

	/**
	 * Returns a new object of class '<em>Personnel Segment Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Personnel Segment Specification</em>'.
	 * @generated
	 */
	PersonnelSegmentSpecification createPersonnelSegmentSpecification();

	/**
	 * Returns a new object of class '<em>Equipment Segment Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equipment Segment Specification</em>'.
	 * @generated
	 */
	EquipmentSegmentSpecification createEquipmentSegmentSpecification();

	/**
	 * Returns a new object of class '<em>Physical Asset Segment Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Physical Asset Segment Specification</em>'.
	 * @generated
	 */
	PhysicalAssetSegmentSpecification createPhysicalAssetSegmentSpecification();

	/**
	 * Returns a new object of class '<em>Material Segment Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Material Segment Specification</em>'.
	 * @generated
	 */
	MaterialSegmentSpecification createMaterialSegmentSpecification();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	B2mmlProcessSegmentPackage getB2mmlProcessSegmentPackage();

} //B2mmlProcessSegmentFactory
