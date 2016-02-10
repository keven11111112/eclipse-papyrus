/**
 */
package org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.B2mmlProcessSegmentFactory;
import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.B2mmlProcessSegmentPackage;
import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.EquipmentSegmentSpecification;
import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.MaterialSegmentSpecification;
import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.PersonnelSegmentSpecification;
import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.PhysicalAssetSegmentSpecification;
import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegment;
import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegmentInformation;
import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProcessSegmentParameter;

import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.ProductionSchedulePackage;

import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.impl.ProductionSchedulePackageImpl;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class B2mmlProcessSegmentPackageImpl extends EPackageImpl implements B2mmlProcessSegmentPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processSegmentInformationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processSegmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processSegmentParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personnelSegmentSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equipmentSegmentSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass physicalAssetSegmentSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass materialSegmentSpecificationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.B2mmlProcessSegmentPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private B2mmlProcessSegmentPackageImpl() {
		super(eNS_URI, B2mmlProcessSegmentFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link B2mmlProcessSegmentPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static B2mmlProcessSegmentPackage init() {
		if (isInited) return (B2mmlProcessSegmentPackage)EPackage.Registry.INSTANCE.getEPackage(B2mmlProcessSegmentPackage.eNS_URI);

		// Obtain or create and register package
		B2mmlProcessSegmentPackageImpl theB2mmlProcessSegmentPackage = (B2mmlProcessSegmentPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof B2mmlProcessSegmentPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new B2mmlProcessSegmentPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ProductionSchedulePackageImpl theProductionSchedulePackage = (ProductionSchedulePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProductionSchedulePackage.eNS_URI) instanceof ProductionSchedulePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProductionSchedulePackage.eNS_URI) : ProductionSchedulePackage.eINSTANCE);

		// Create package meta-data objects
		theB2mmlProcessSegmentPackage.createPackageContents();
		theProductionSchedulePackage.createPackageContents();

		// Initialize created meta-data
		theB2mmlProcessSegmentPackage.initializePackageContents();
		theProductionSchedulePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theB2mmlProcessSegmentPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(B2mmlProcessSegmentPackage.eNS_URI, theB2mmlProcessSegmentPackage);
		return theB2mmlProcessSegmentPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessSegmentInformation() {
		return processSegmentInformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessSegmentInformation_Processsegment() {
		return (EReference)processSegmentInformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessSegmentInformation_Base_Activity() {
		return (EReference)processSegmentInformationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessSegment() {
		return processSegmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessSegment_Base_Action() {
		return (EReference)processSegmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessSegment_Processsegment() {
		return (EReference)processSegmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessSegment_Base_Behavior() {
		return (EReference)processSegmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessSegmentParameter() {
		return processSegmentParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPersonnelSegmentSpecification() {
		return personnelSegmentSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEquipmentSegmentSpecification() {
		return equipmentSegmentSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPhysicalAssetSegmentSpecification() {
		return physicalAssetSegmentSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMaterialSegmentSpecification() {
		return materialSegmentSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B2mmlProcessSegmentFactory getB2mmlProcessSegmentFactory() {
		return (B2mmlProcessSegmentFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		processSegmentInformationEClass = createEClass(PROCESS_SEGMENT_INFORMATION);
		createEReference(processSegmentInformationEClass, PROCESS_SEGMENT_INFORMATION__PROCESSSEGMENT);
		createEReference(processSegmentInformationEClass, PROCESS_SEGMENT_INFORMATION__BASE_ACTIVITY);

		processSegmentEClass = createEClass(PROCESS_SEGMENT);
		createEReference(processSegmentEClass, PROCESS_SEGMENT__BASE_ACTION);
		createEReference(processSegmentEClass, PROCESS_SEGMENT__PROCESSSEGMENT);
		createEReference(processSegmentEClass, PROCESS_SEGMENT__BASE_BEHAVIOR);

		processSegmentParameterEClass = createEClass(PROCESS_SEGMENT_PARAMETER);

		personnelSegmentSpecificationEClass = createEClass(PERSONNEL_SEGMENT_SPECIFICATION);

		equipmentSegmentSpecificationEClass = createEClass(EQUIPMENT_SEGMENT_SPECIFICATION);

		physicalAssetSegmentSpecificationEClass = createEClass(PHYSICAL_ASSET_SEGMENT_SPECIFICATION);

		materialSegmentSpecificationEClass = createEClass(MATERIAL_SEGMENT_SPECIFICATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ProductionSchedulePackage theProductionSchedulePackage = (ProductionSchedulePackage)EPackage.Registry.INSTANCE.getEPackage(ProductionSchedulePackage.eNS_URI);
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theProductionSchedulePackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(processSegmentInformationEClass, ProcessSegmentInformation.class, "ProcessSegmentInformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcessSegmentInformation_Processsegment(), this.getProcessSegment(), null, "processsegment", null, 1, 1, ProcessSegmentInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProcessSegmentInformation_Base_Activity(), theUMLPackage.getActivity(), null, "base_Activity", null, 1, 1, ProcessSegmentInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(processSegmentEClass, ProcessSegment.class, "ProcessSegment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcessSegment_Base_Action(), theUMLPackage.getAction(), null, "base_Action", null, 1, 1, ProcessSegment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProcessSegment_Processsegment(), this.getProcessSegment(), null, "processsegment", null, 0, -1, ProcessSegment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProcessSegment_Base_Behavior(), theUMLPackage.getBehavior(), null, "base_Behavior", null, 1, 1, ProcessSegment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(processSegmentParameterEClass, ProcessSegmentParameter.class, "ProcessSegmentParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(personnelSegmentSpecificationEClass, PersonnelSegmentSpecification.class, "PersonnelSegmentSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(equipmentSegmentSpecificationEClass, EquipmentSegmentSpecification.class, "EquipmentSegmentSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(physicalAssetSegmentSpecificationEClass, PhysicalAssetSegmentSpecification.class, "PhysicalAssetSegmentSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(materialSegmentSpecificationEClass, MaterialSegmentSpecification.class, "MaterialSegmentSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //B2mmlProcessSegmentPackageImpl
