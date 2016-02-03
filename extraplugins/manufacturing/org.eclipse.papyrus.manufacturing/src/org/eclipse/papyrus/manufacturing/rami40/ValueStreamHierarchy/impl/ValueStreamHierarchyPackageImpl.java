/**
 */
package org.eclipse.papyrus.manufacturing.rami40.ValueStreamHierarchy.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy.InfrastructureHierarchyPackage;

import org.eclipse.papyrus.manufacturing.rami40.InfrastructureHierarchy.impl.InfrastructureHierarchyPackageImpl;

import org.eclipse.papyrus.manufacturing.rami40.LifeCycleHierarchy.LifeCycleHierarchyPackage;

import org.eclipse.papyrus.manufacturing.rami40.LifeCycleHierarchy.impl.LifeCycleHierarchyPackageImpl;

import org.eclipse.papyrus.manufacturing.rami40.ValueStreamHierarchy.ValueStreamHierarchyFactory;
import org.eclipse.papyrus.manufacturing.rami40.ValueStreamHierarchy.ValueStreamHierarchyPackage;
import org.eclipse.papyrus.manufacturing.rami40.ValueStreamHierarchy._1BusinessLayer;
import org.eclipse.papyrus.manufacturing.rami40.ValueStreamHierarchy._2FunctionalLayer;
import org.eclipse.papyrus.manufacturing.rami40.ValueStreamHierarchy._3InformationLayer;
import org.eclipse.papyrus.manufacturing.rami40.ValueStreamHierarchy._4CommunicationLayer;
import org.eclipse.papyrus.manufacturing.rami40.ValueStreamHierarchy._5IntegrationLayer;
import org.eclipse.papyrus.manufacturing.rami40.ValueStreamHierarchy._6AssetLayer;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ValueStreamHierarchyPackageImpl extends EPackageImpl implements ValueStreamHierarchyPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass _1BusinessLayerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass _2FunctionalLayerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass _3InformationLayerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass _4CommunicationLayerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass _5IntegrationLayerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass _6AssetLayerEClass = null;

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
	 * @see org.eclipse.papyrus.manufacturing.rami40.ValueStreamHierarchy.ValueStreamHierarchyPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ValueStreamHierarchyPackageImpl() {
		super(eNS_URI, ValueStreamHierarchyFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ValueStreamHierarchyPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ValueStreamHierarchyPackage init() {
		if (isInited) return (ValueStreamHierarchyPackage)EPackage.Registry.INSTANCE.getEPackage(ValueStreamHierarchyPackage.eNS_URI);

		// Obtain or create and register package
		ValueStreamHierarchyPackageImpl theValueStreamHierarchyPackage = (ValueStreamHierarchyPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ValueStreamHierarchyPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ValueStreamHierarchyPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		InfrastructureHierarchyPackageImpl theInfrastructureHierarchyPackage = (InfrastructureHierarchyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InfrastructureHierarchyPackage.eNS_URI) instanceof InfrastructureHierarchyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InfrastructureHierarchyPackage.eNS_URI) : InfrastructureHierarchyPackage.eINSTANCE);
		LifeCycleHierarchyPackageImpl theLifeCycleHierarchyPackage = (LifeCycleHierarchyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LifeCycleHierarchyPackage.eNS_URI) instanceof LifeCycleHierarchyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LifeCycleHierarchyPackage.eNS_URI) : LifeCycleHierarchyPackage.eINSTANCE);

		// Create package meta-data objects
		theValueStreamHierarchyPackage.createPackageContents();
		theInfrastructureHierarchyPackage.createPackageContents();
		theLifeCycleHierarchyPackage.createPackageContents();

		// Initialize created meta-data
		theValueStreamHierarchyPackage.initializePackageContents();
		theInfrastructureHierarchyPackage.initializePackageContents();
		theLifeCycleHierarchyPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theValueStreamHierarchyPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ValueStreamHierarchyPackage.eNS_URI, theValueStreamHierarchyPackage);
		return theValueStreamHierarchyPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass get_1BusinessLayer() {
		return _1BusinessLayerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference get_1BusinessLayer_Base_Package() {
		return (EReference)_1BusinessLayerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass get_2FunctionalLayer() {
		return _2FunctionalLayerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference get_2FunctionalLayer_Base_Package() {
		return (EReference)_2FunctionalLayerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass get_3InformationLayer() {
		return _3InformationLayerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference get_3InformationLayer_Base_Package() {
		return (EReference)_3InformationLayerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass get_4CommunicationLayer() {
		return _4CommunicationLayerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference get_4CommunicationLayer_Base_Package() {
		return (EReference)_4CommunicationLayerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass get_5IntegrationLayer() {
		return _5IntegrationLayerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference get_5IntegrationLayer_Base_Package() {
		return (EReference)_5IntegrationLayerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass get_6AssetLayer() {
		return _6AssetLayerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference get_6AssetLayer_Base_Package() {
		return (EReference)_6AssetLayerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueStreamHierarchyFactory getValueStreamHierarchyFactory() {
		return (ValueStreamHierarchyFactory)getEFactoryInstance();
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
		_1BusinessLayerEClass = createEClass(_1BUSINESS_LAYER);
		createEReference(_1BusinessLayerEClass, _1BUSINESS_LAYER__BASE_PACKAGE);

		_2FunctionalLayerEClass = createEClass(_2FUNCTIONAL_LAYER);
		createEReference(_2FunctionalLayerEClass, _2FUNCTIONAL_LAYER__BASE_PACKAGE);

		_3InformationLayerEClass = createEClass(_3INFORMATION_LAYER);
		createEReference(_3InformationLayerEClass, _3INFORMATION_LAYER__BASE_PACKAGE);

		_4CommunicationLayerEClass = createEClass(_4COMMUNICATION_LAYER);
		createEReference(_4CommunicationLayerEClass, _4COMMUNICATION_LAYER__BASE_PACKAGE);

		_5IntegrationLayerEClass = createEClass(_5INTEGRATION_LAYER);
		createEReference(_5IntegrationLayerEClass, _5INTEGRATION_LAYER__BASE_PACKAGE);

		_6AssetLayerEClass = createEClass(_6ASSET_LAYER);
		createEReference(_6AssetLayerEClass, _6ASSET_LAYER__BASE_PACKAGE);
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
		initEClass(_1BusinessLayerEClass, _1BusinessLayer.class, "_1BusinessLayer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(get_1BusinessLayer_Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, _1BusinessLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(_2FunctionalLayerEClass, _2FunctionalLayer.class, "_2FunctionalLayer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(get_2FunctionalLayer_Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, _2FunctionalLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(_3InformationLayerEClass, _3InformationLayer.class, "_3InformationLayer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(get_3InformationLayer_Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, _3InformationLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(_4CommunicationLayerEClass, _4CommunicationLayer.class, "_4CommunicationLayer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(get_4CommunicationLayer_Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, _4CommunicationLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(_5IntegrationLayerEClass, _5IntegrationLayer.class, "_5IntegrationLayer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(get_5IntegrationLayer_Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, _5IntegrationLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(_6AssetLayerEClass, _6AssetLayer.class, "_6AssetLayer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(get_6AssetLayer_Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, _6AssetLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

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
		  (_1BusinessLayerEClass, 
		   source, 
		   new String[] {
			 "originalName", "1-BusinessLayer"
		   });	
		addAnnotation
		  (_2FunctionalLayerEClass, 
		   source, 
		   new String[] {
			 "originalName", "2-FunctionalLayer"
		   });	
		addAnnotation
		  (_3InformationLayerEClass, 
		   source, 
		   new String[] {
			 "originalName", "3-InformationLayer"
		   });	
		addAnnotation
		  (_4CommunicationLayerEClass, 
		   source, 
		   new String[] {
			 "originalName", "4-CommunicationLayer"
		   });	
		addAnnotation
		  (_5IntegrationLayerEClass, 
		   source, 
		   new String[] {
			 "originalName", "5-IntegrationLayer"
		   });	
		addAnnotation
		  (_6AssetLayerEClass, 
		   source, 
		   new String[] {
			 "originalName", "6-AssetLayer"
		   });
	}

} //ValueStreamHierarchyPackageImpl
