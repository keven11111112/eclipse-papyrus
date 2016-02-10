/**
 */
package org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.ProductionScheduleFactory
 * @model kind="package"
 * @generated
 */
public interface ProductionSchedulePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ProductionSchedule";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///B2MML_ProcessSegment/ProductionSchedule.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "B2MML_ProcessSegment.ProductionSchedule";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProductionSchedulePackage eINSTANCE = org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.impl.ProductionSchedulePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.impl.ProductionScheduleImpl <em>Production Schedule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.impl.ProductionScheduleImpl
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.impl.ProductionSchedulePackageImpl#getProductionSchedule()
	 * @generated
	 */
	int PRODUCTION_SCHEDULE = 0;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCTION_SCHEDULE__BASE_ARTIFACT = 0;

	/**
	 * The number of structural features of the '<em>Production Schedule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCTION_SCHEDULE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Production Schedule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCTION_SCHEDULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.impl.ProductionRequestImpl <em>Production Request</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.impl.ProductionRequestImpl
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.impl.ProductionSchedulePackageImpl#getProductionRequest()
	 * @generated
	 */
	int PRODUCTION_REQUEST = 1;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCTION_REQUEST__BASE_ARTIFACT = 0;

	/**
	 * The number of structural features of the '<em>Production Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCTION_REQUEST_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Production Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCTION_REQUEST_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.ProductionSchedule <em>Production Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Production Schedule</em>'.
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.ProductionSchedule
	 * @generated
	 */
	EClass getProductionSchedule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.ProductionSchedule#getBase_Artifact <em>Base Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Artifact</em>'.
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.ProductionSchedule#getBase_Artifact()
	 * @see #getProductionSchedule()
	 * @generated
	 */
	EReference getProductionSchedule_Base_Artifact();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.ProductionRequest <em>Production Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Production Request</em>'.
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.ProductionRequest
	 * @generated
	 */
	EClass getProductionRequest();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.ProductionRequest#getBase_Artifact <em>Base Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Artifact</em>'.
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.ProductionRequest#getBase_Artifact()
	 * @see #getProductionRequest()
	 * @generated
	 */
	EReference getProductionRequest_Base_Artifact();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ProductionScheduleFactory getProductionScheduleFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.impl.ProductionScheduleImpl <em>Production Schedule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.impl.ProductionScheduleImpl
		 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.impl.ProductionSchedulePackageImpl#getProductionSchedule()
		 * @generated
		 */
		EClass PRODUCTION_SCHEDULE = eINSTANCE.getProductionSchedule();

		/**
		 * The meta object literal for the '<em><b>Base Artifact</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRODUCTION_SCHEDULE__BASE_ARTIFACT = eINSTANCE.getProductionSchedule_Base_Artifact();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.impl.ProductionRequestImpl <em>Production Request</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.impl.ProductionRequestImpl
		 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.impl.ProductionSchedulePackageImpl#getProductionRequest()
		 * @generated
		 */
		EClass PRODUCTION_REQUEST = eINSTANCE.getProductionRequest();

		/**
		 * The meta object literal for the '<em><b>Base Artifact</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRODUCTION_REQUEST__BASE_ARTIFACT = eINSTANCE.getProductionRequest_Base_Artifact();

	}

} //ProductionSchedulePackage
