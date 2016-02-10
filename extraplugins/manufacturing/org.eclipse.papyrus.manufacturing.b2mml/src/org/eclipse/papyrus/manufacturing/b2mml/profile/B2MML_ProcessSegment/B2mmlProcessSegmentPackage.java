/**
 */
package org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment;

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
 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.B2mmlProcessSegmentFactory
 * @model kind="package"
 * @generated
 */
public interface B2mmlProcessSegmentPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "B2MML_ProcessSegment";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://papyrus/B2MML";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "B2MML_ProcessSegment";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	B2mmlProcessSegmentPackage eINSTANCE = org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.B2mmlProcessSegmentPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.ProcessSegmentInformationImpl <em>Process Segment Information</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.ProcessSegmentInformationImpl
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.B2mmlProcessSegmentPackageImpl#getProcessSegmentInformation()
	 * @generated
	 */
	int PROCESS_SEGMENT_INFORMATION = 0;

	/**
	 * The feature id for the '<em><b>Processsegment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SEGMENT_INFORMATION__PROCESSSEGMENT = 0;

	/**
	 * The feature id for the '<em><b>Base Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SEGMENT_INFORMATION__BASE_ACTIVITY = 1;

	/**
	 * The number of structural features of the '<em>Process Segment Information</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SEGMENT_INFORMATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Process Segment Information</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SEGMENT_INFORMATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.ProcessSegmentImpl <em>Process Segment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.ProcessSegmentImpl
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.B2mmlProcessSegmentPackageImpl#getProcessSegment()
	 * @generated
	 */
	int PROCESS_SEGMENT = 1;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SEGMENT__BASE_ACTION = 0;

	/**
	 * The feature id for the '<em><b>Processsegment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SEGMENT__PROCESSSEGMENT = 1;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SEGMENT__BASE_BEHAVIOR = 2;

	/**
	 * The number of structural features of the '<em>Process Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SEGMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Process Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SEGMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.ProcessSegmentParameterImpl <em>Process Segment Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.ProcessSegmentParameterImpl
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.B2mmlProcessSegmentPackageImpl#getProcessSegmentParameter()
	 * @generated
	 */
	int PROCESS_SEGMENT_PARAMETER = 2;

	/**
	 * The number of structural features of the '<em>Process Segment Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SEGMENT_PARAMETER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Process Segment Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SEGMENT_PARAMETER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.PersonnelSegmentSpecificationImpl <em>Personnel Segment Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.PersonnelSegmentSpecificationImpl
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.B2mmlProcessSegmentPackageImpl#getPersonnelSegmentSpecification()
	 * @generated
	 */
	int PERSONNEL_SEGMENT_SPECIFICATION = 3;

	/**
	 * The number of structural features of the '<em>Personnel Segment Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONNEL_SEGMENT_SPECIFICATION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Personnel Segment Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONNEL_SEGMENT_SPECIFICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.EquipmentSegmentSpecificationImpl <em>Equipment Segment Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.EquipmentSegmentSpecificationImpl
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.B2mmlProcessSegmentPackageImpl#getEquipmentSegmentSpecification()
	 * @generated
	 */
	int EQUIPMENT_SEGMENT_SPECIFICATION = 4;

	/**
	 * The number of structural features of the '<em>Equipment Segment Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_SEGMENT_SPECIFICATION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Equipment Segment Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIPMENT_SEGMENT_SPECIFICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.PhysicalAssetSegmentSpecificationImpl <em>Physical Asset Segment Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.PhysicalAssetSegmentSpecificationImpl
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.B2mmlProcessSegmentPackageImpl#getPhysicalAssetSegmentSpecification()
	 * @generated
	 */
	int PHYSICAL_ASSET_SEGMENT_SPECIFICATION = 5;

	/**
	 * The number of structural features of the '<em>Physical Asset Segment Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_ASSET_SEGMENT_SPECIFICATION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Physical Asset Segment Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_ASSET_SEGMENT_SPECIFICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.MaterialSegmentSpecificationImpl <em>Material Segment Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.MaterialSegmentSpecificationImpl
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.B2mmlProcessSegmentPackageImpl#getMaterialSegmentSpecification()
	 * @generated
	 */
	int MATERIAL_SEGMENT_SPECIFICATION = 6;

	/**
	 * The number of structural features of the '<em>Material Segment Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATERIAL_SEGMENT_SPECIFICATION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Material Segment Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATERIAL_SEGMENT_SPECIFICATION_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegmentInformation <em>Process Segment Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Segment Information</em>'.
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegmentInformation
	 * @generated
	 */
	EClass getProcessSegmentInformation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegmentInformation#getProcesssegment <em>Processsegment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Processsegment</em>'.
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegmentInformation#getProcesssegment()
	 * @see #getProcessSegmentInformation()
	 * @generated
	 */
	EReference getProcessSegmentInformation_Processsegment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegmentInformation#getBase_Activity <em>Base Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Activity</em>'.
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegmentInformation#getBase_Activity()
	 * @see #getProcessSegmentInformation()
	 * @generated
	 */
	EReference getProcessSegmentInformation_Base_Activity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegment <em>Process Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Segment</em>'.
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegment
	 * @generated
	 */
	EClass getProcessSegment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegment#getBase_Action <em>Base Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Action</em>'.
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegment#getBase_Action()
	 * @see #getProcessSegment()
	 * @generated
	 */
	EReference getProcessSegment_Base_Action();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegment#getProcesssegment <em>Processsegment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Processsegment</em>'.
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegment#getProcesssegment()
	 * @see #getProcessSegment()
	 * @generated
	 */
	EReference getProcessSegment_Processsegment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegment#getBase_Behavior <em>Base Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Behavior</em>'.
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegment#getBase_Behavior()
	 * @see #getProcessSegment()
	 * @generated
	 */
	EReference getProcessSegment_Base_Behavior();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegmentParameter <em>Process Segment Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Segment Parameter</em>'.
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegmentParameter
	 * @generated
	 */
	EClass getProcessSegmentParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.PersonnelSegmentSpecification <em>Personnel Segment Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Personnel Segment Specification</em>'.
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.PersonnelSegmentSpecification
	 * @generated
	 */
	EClass getPersonnelSegmentSpecification();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.EquipmentSegmentSpecification <em>Equipment Segment Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equipment Segment Specification</em>'.
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.EquipmentSegmentSpecification
	 * @generated
	 */
	EClass getEquipmentSegmentSpecification();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.PhysicalAssetSegmentSpecification <em>Physical Asset Segment Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Physical Asset Segment Specification</em>'.
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.PhysicalAssetSegmentSpecification
	 * @generated
	 */
	EClass getPhysicalAssetSegmentSpecification();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.MaterialSegmentSpecification <em>Material Segment Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Material Segment Specification</em>'.
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.MaterialSegmentSpecification
	 * @generated
	 */
	EClass getMaterialSegmentSpecification();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	B2mmlProcessSegmentFactory getB2mmlProcessSegmentFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.ProcessSegmentInformationImpl <em>Process Segment Information</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.ProcessSegmentInformationImpl
		 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.B2mmlProcessSegmentPackageImpl#getProcessSegmentInformation()
		 * @generated
		 */
		EClass PROCESS_SEGMENT_INFORMATION = eINSTANCE.getProcessSegmentInformation();

		/**
		 * The meta object literal for the '<em><b>Processsegment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_SEGMENT_INFORMATION__PROCESSSEGMENT = eINSTANCE.getProcessSegmentInformation_Processsegment();

		/**
		 * The meta object literal for the '<em><b>Base Activity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_SEGMENT_INFORMATION__BASE_ACTIVITY = eINSTANCE.getProcessSegmentInformation_Base_Activity();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.ProcessSegmentImpl <em>Process Segment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.ProcessSegmentImpl
		 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.B2mmlProcessSegmentPackageImpl#getProcessSegment()
		 * @generated
		 */
		EClass PROCESS_SEGMENT = eINSTANCE.getProcessSegment();

		/**
		 * The meta object literal for the '<em><b>Base Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_SEGMENT__BASE_ACTION = eINSTANCE.getProcessSegment_Base_Action();

		/**
		 * The meta object literal for the '<em><b>Processsegment</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_SEGMENT__PROCESSSEGMENT = eINSTANCE.getProcessSegment_Processsegment();

		/**
		 * The meta object literal for the '<em><b>Base Behavior</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_SEGMENT__BASE_BEHAVIOR = eINSTANCE.getProcessSegment_Base_Behavior();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.ProcessSegmentParameterImpl <em>Process Segment Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.ProcessSegmentParameterImpl
		 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.B2mmlProcessSegmentPackageImpl#getProcessSegmentParameter()
		 * @generated
		 */
		EClass PROCESS_SEGMENT_PARAMETER = eINSTANCE.getProcessSegmentParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.PersonnelSegmentSpecificationImpl <em>Personnel Segment Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.PersonnelSegmentSpecificationImpl
		 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.B2mmlProcessSegmentPackageImpl#getPersonnelSegmentSpecification()
		 * @generated
		 */
		EClass PERSONNEL_SEGMENT_SPECIFICATION = eINSTANCE.getPersonnelSegmentSpecification();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.EquipmentSegmentSpecificationImpl <em>Equipment Segment Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.EquipmentSegmentSpecificationImpl
		 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.B2mmlProcessSegmentPackageImpl#getEquipmentSegmentSpecification()
		 * @generated
		 */
		EClass EQUIPMENT_SEGMENT_SPECIFICATION = eINSTANCE.getEquipmentSegmentSpecification();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.PhysicalAssetSegmentSpecificationImpl <em>Physical Asset Segment Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.PhysicalAssetSegmentSpecificationImpl
		 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.B2mmlProcessSegmentPackageImpl#getPhysicalAssetSegmentSpecification()
		 * @generated
		 */
		EClass PHYSICAL_ASSET_SEGMENT_SPECIFICATION = eINSTANCE.getPhysicalAssetSegmentSpecification();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.MaterialSegmentSpecificationImpl <em>Material Segment Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.MaterialSegmentSpecificationImpl
		 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.B2mmlProcessSegmentPackageImpl#getMaterialSegmentSpecification()
		 * @generated
		 */
		EClass MATERIAL_SEGMENT_SPECIFICATION = eINSTANCE.getMaterialSegmentSpecification();

	}

} //B2mmlProcessSegmentPackage
