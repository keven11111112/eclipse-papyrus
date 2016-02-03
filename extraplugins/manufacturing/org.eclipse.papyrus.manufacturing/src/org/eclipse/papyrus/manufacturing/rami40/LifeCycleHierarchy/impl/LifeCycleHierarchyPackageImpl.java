/**
 */
package org.eclipse.papyrus.manufacturing.rami40.LifeCycleHierarchy.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy.InfrastructureHierarchyPackage;

import org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy.impl.InfrastructureHierarchyPackageImpl;

import org.eclipse.papyrus.manufacturing.rami40.LifeCycleHierarchy.LifeCycleHierarchyFactory;
import org.eclipse.papyrus.manufacturing.rami40.LifeCycleHierarchy.LifeCycleHierarchyPackage;
import org.eclipse.papyrus.manufacturing.rami40.LifeCycleHierarchy._1TypeDevelopment;
import org.eclipse.papyrus.manufacturing.rami40.LifeCycleHierarchy._2InstanceProduction;

import org.eclipse.papyrus.manufacturing.rami40.ValueStreamHierarchy.ValueStreamHierarchyPackage;

import org.eclipse.papyrus.manufacturing.rami40.ValueStreamHierarchy.impl.ValueStreamHierarchyPackageImpl;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LifeCycleHierarchyPackageImpl extends EPackageImpl implements LifeCycleHierarchyPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass _2InstanceProductionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass _1TypeDevelopmentEClass = null;

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
	 * @see org.eclipse.papyrus.manufacturing.rami40.LifeCycleHierarchy.LifeCycleHierarchyPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LifeCycleHierarchyPackageImpl() {
		super(eNS_URI, LifeCycleHierarchyFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link LifeCycleHierarchyPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LifeCycleHierarchyPackage init() {
		if (isInited) return (LifeCycleHierarchyPackage)EPackage.Registry.INSTANCE.getEPackage(LifeCycleHierarchyPackage.eNS_URI);

		// Obtain or create and register package
		LifeCycleHierarchyPackageImpl theLifeCycleHierarchyPackage = (LifeCycleHierarchyPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LifeCycleHierarchyPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LifeCycleHierarchyPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ValueStreamHierarchyPackageImpl theValueStreamHierarchyPackage = (ValueStreamHierarchyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ValueStreamHierarchyPackage.eNS_URI) instanceof ValueStreamHierarchyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ValueStreamHierarchyPackage.eNS_URI) : ValueStreamHierarchyPackage.eINSTANCE);
		InfrastructureHierarchyPackageImpl theInfrastructureHierarchyPackage = (InfrastructureHierarchyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InfrastructureHierarchyPackage.eNS_URI) instanceof InfrastructureHierarchyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InfrastructureHierarchyPackage.eNS_URI) : InfrastructureHierarchyPackage.eINSTANCE);

		// Create package meta-data objects
		theLifeCycleHierarchyPackage.createPackageContents();
		theValueStreamHierarchyPackage.createPackageContents();
		theInfrastructureHierarchyPackage.createPackageContents();

		// Initialize created meta-data
		theLifeCycleHierarchyPackage.initializePackageContents();
		theValueStreamHierarchyPackage.initializePackageContents();
		theInfrastructureHierarchyPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLifeCycleHierarchyPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LifeCycleHierarchyPackage.eNS_URI, theLifeCycleHierarchyPackage);
		return theLifeCycleHierarchyPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass get_2InstanceProduction() {
		return _2InstanceProductionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference get_2InstanceProduction_Base_Package() {
		return (EReference)_2InstanceProductionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass get_1TypeDevelopment() {
		return _1TypeDevelopmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference get_1TypeDevelopment_Base_Package() {
		return (EReference)_1TypeDevelopmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LifeCycleHierarchyFactory getLifeCycleHierarchyFactory() {
		return (LifeCycleHierarchyFactory)getEFactoryInstance();
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
		_2InstanceProductionEClass = createEClass(_2INSTANCE_PRODUCTION);
		createEReference(_2InstanceProductionEClass, _2INSTANCE_PRODUCTION__BASE_PACKAGE);

		_1TypeDevelopmentEClass = createEClass(_1TYPE_DEVELOPMENT);
		createEReference(_1TypeDevelopmentEClass, _1TYPE_DEVELOPMENT__BASE_PACKAGE);
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
		initEClass(_2InstanceProductionEClass, _2InstanceProduction.class, "_2InstanceProduction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(get_2InstanceProduction_Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, _2InstanceProduction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(_1TypeDevelopmentEClass, _1TypeDevelopment.class, "_1TypeDevelopment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(get_1TypeDevelopment_Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, _1TypeDevelopment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/uml2/2.0.0/UML</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUMLAnnotations() {
		String source = "http://www.eclipse.org/uml2/2.0.0/UML";	
		addAnnotation
		  (_2InstanceProductionEClass, 
		   source, 
		   new String[] {
			 "originalName", "2-InstanceProduction"
		   });	
		addAnnotation
		  (_1TypeDevelopmentEClass, 
		   source, 
		   new String[] {
			 "originalName", "1-TypeDevelopment"
		   });
	}

} //LifeCycleHierarchyPackageImpl
