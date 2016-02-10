/**
 */
package org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.B2mmlProcessSegmentPackage;

import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.ProductionRequest;
import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.ProductionSchedule;
import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.ProductionScheduleFactory;
import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.ProductionSchedulePackage;

import org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.impl.B2mmlProcessSegmentPackageImpl;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProductionSchedulePackageImpl extends EPackageImpl implements ProductionSchedulePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass productionScheduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass productionRequestEClass = null;

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
	 * @see org.eclipse.papyrus.manufacturing.b2mml.profile.B2MML_ProcessSegment.ProductionSchedule.ProductionSchedulePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ProductionSchedulePackageImpl() {
		super(eNS_URI, ProductionScheduleFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ProductionSchedulePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ProductionSchedulePackage init() {
		if (isInited) return (ProductionSchedulePackage)EPackage.Registry.INSTANCE.getEPackage(ProductionSchedulePackage.eNS_URI);

		// Obtain or create and register package
		ProductionSchedulePackageImpl theProductionSchedulePackage = (ProductionSchedulePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ProductionSchedulePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ProductionSchedulePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		B2mmlProcessSegmentPackageImpl theB2mmlProcessSegmentPackage = (B2mmlProcessSegmentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(B2mmlProcessSegmentPackage.eNS_URI) instanceof B2mmlProcessSegmentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(B2mmlProcessSegmentPackage.eNS_URI) : B2mmlProcessSegmentPackage.eINSTANCE);

		// Create package meta-data objects
		theProductionSchedulePackage.createPackageContents();
		theB2mmlProcessSegmentPackage.createPackageContents();

		// Initialize created meta-data
		theProductionSchedulePackage.initializePackageContents();
		theB2mmlProcessSegmentPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theProductionSchedulePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ProductionSchedulePackage.eNS_URI, theProductionSchedulePackage);
		return theProductionSchedulePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProductionSchedule() {
		return productionScheduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProductionSchedule_Base_Artifact() {
		return (EReference)productionScheduleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProductionRequest() {
		return productionRequestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProductionRequest_Base_Artifact() {
		return (EReference)productionRequestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProductionScheduleFactory getProductionScheduleFactory() {
		return (ProductionScheduleFactory)getEFactoryInstance();
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
		productionScheduleEClass = createEClass(PRODUCTION_SCHEDULE);
		createEReference(productionScheduleEClass, PRODUCTION_SCHEDULE__BASE_ARTIFACT);

		productionRequestEClass = createEClass(PRODUCTION_REQUEST);
		createEReference(productionRequestEClass, PRODUCTION_REQUEST__BASE_ARTIFACT);
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
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(productionScheduleEClass, ProductionSchedule.class, "ProductionSchedule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProductionSchedule_Base_Artifact(), theUMLPackage.getArtifact(), null, "base_Artifact", null, 1, 1, ProductionSchedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(productionRequestEClass, ProductionRequest.class, "ProductionRequest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProductionRequest_Base_Artifact(), theUMLPackage.getArtifact(), null, "base_Artifact", null, 1, 1, ProductionRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //ProductionSchedulePackageImpl
