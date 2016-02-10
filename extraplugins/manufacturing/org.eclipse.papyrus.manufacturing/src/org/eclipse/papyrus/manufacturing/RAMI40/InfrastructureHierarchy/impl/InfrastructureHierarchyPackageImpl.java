/**
 */
package org.eclipse.papyrus.manufacturing.RAMI40.InfrastructureHierarchy.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.manufacturing.RAMI40.InfrastructureHierarchy.InfrastructureHierarchyFactory;
import org.eclipse.papyrus.manufacturing.RAMI40.InfrastructureHierarchy.InfrastructureHierarchyPackage;
import org.eclipse.papyrus.manufacturing.RAMI40.InfrastructureHierarchy._1ConnectedWorld;
import org.eclipse.papyrus.manufacturing.RAMI40.InfrastructureHierarchy._2EnterpriseLevel;
import org.eclipse.papyrus.manufacturing.RAMI40.InfrastructureHierarchy._3WorkCentersLevel;
import org.eclipse.papyrus.manufacturing.RAMI40.InfrastructureHierarchy._4StationsLevel;
import org.eclipse.papyrus.manufacturing.RAMI40.InfrastructureHierarchy._5ControlDeviceLevel;
import org.eclipse.papyrus.manufacturing.RAMI40.InfrastructureHierarchy._6FieldDeviceLevel;
import org.eclipse.papyrus.manufacturing.RAMI40.InfrastructureHierarchy._7ProductLevel;

import org.eclipse.papyrus.manufacturing.RAMI40.LifeCycleHierarchy.LifeCycleHierarchyPackage;

import org.eclipse.papyrus.manufacturing.RAMI40.LifeCycleHierarchy.impl.LifeCycleHierarchyPackageImpl;

import org.eclipse.papyrus.manufacturing.RAMI40.ValueStreamHierarchy.ValueStreamHierarchyPackage;

import org.eclipse.papyrus.manufacturing.RAMI40.ValueStreamHierarchy.impl.ValueStreamHierarchyPackageImpl;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InfrastructureHierarchyPackageImpl extends EPackageImpl implements InfrastructureHierarchyPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass _1ConnectedWorldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass _2EnterpriseLevelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass _3WorkCentersLevelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass _4StationsLevelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass _5ControlDeviceLevelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass _6FieldDeviceLevelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass _7ProductLevelEClass = null;

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
	 * @see org.eclipse.papyrus.manufacturing.RAMI40.InfrastructureHierarchy.InfrastructureHierarchyPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private InfrastructureHierarchyPackageImpl() {
		super(eNS_URI, InfrastructureHierarchyFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link InfrastructureHierarchyPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static InfrastructureHierarchyPackage init() {
		if (isInited) return (InfrastructureHierarchyPackage)EPackage.Registry.INSTANCE.getEPackage(InfrastructureHierarchyPackage.eNS_URI);

		// Obtain or create and register package
		InfrastructureHierarchyPackageImpl theInfrastructureHierarchyPackage = (InfrastructureHierarchyPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof InfrastructureHierarchyPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new InfrastructureHierarchyPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ValueStreamHierarchyPackageImpl theValueStreamHierarchyPackage = (ValueStreamHierarchyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ValueStreamHierarchyPackage.eNS_URI) instanceof ValueStreamHierarchyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ValueStreamHierarchyPackage.eNS_URI) : ValueStreamHierarchyPackage.eINSTANCE);
		LifeCycleHierarchyPackageImpl theLifeCycleHierarchyPackage = (LifeCycleHierarchyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LifeCycleHierarchyPackage.eNS_URI) instanceof LifeCycleHierarchyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LifeCycleHierarchyPackage.eNS_URI) : LifeCycleHierarchyPackage.eINSTANCE);

		// Create package meta-data objects
		theInfrastructureHierarchyPackage.createPackageContents();
		theValueStreamHierarchyPackage.createPackageContents();
		theLifeCycleHierarchyPackage.createPackageContents();

		// Initialize created meta-data
		theInfrastructureHierarchyPackage.initializePackageContents();
		theValueStreamHierarchyPackage.initializePackageContents();
		theLifeCycleHierarchyPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theInfrastructureHierarchyPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(InfrastructureHierarchyPackage.eNS_URI, theInfrastructureHierarchyPackage);
		return theInfrastructureHierarchyPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass get_1ConnectedWorld() {
		return _1ConnectedWorldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference get_1ConnectedWorld_Base_Package() {
		return (EReference)_1ConnectedWorldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass get_2EnterpriseLevel() {
		return _2EnterpriseLevelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference get_2EnterpriseLevel_Base_Package() {
		return (EReference)_2EnterpriseLevelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass get_3WorkCentersLevel() {
		return _3WorkCentersLevelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference get_3WorkCentersLevel_Base_Package() {
		return (EReference)_3WorkCentersLevelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass get_4StationsLevel() {
		return _4StationsLevelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference get_4StationsLevel_Base_Package() {
		return (EReference)_4StationsLevelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass get_5ControlDeviceLevel() {
		return _5ControlDeviceLevelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference get_5ControlDeviceLevel_Base_Package() {
		return (EReference)_5ControlDeviceLevelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass get_6FieldDeviceLevel() {
		return _6FieldDeviceLevelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference get_6FieldDeviceLevel_Base_Package() {
		return (EReference)_6FieldDeviceLevelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass get_7ProductLevel() {
		return _7ProductLevelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference get_7ProductLevel_Base_Package() {
		return (EReference)_7ProductLevelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureHierarchyFactory getInfrastructureHierarchyFactory() {
		return (InfrastructureHierarchyFactory)getEFactoryInstance();
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
		_1ConnectedWorldEClass = createEClass(_1CONNECTED_WORLD);
		createEReference(_1ConnectedWorldEClass, _1CONNECTED_WORLD__BASE_PACKAGE);

		_2EnterpriseLevelEClass = createEClass(_2ENTERPRISE_LEVEL);
		createEReference(_2EnterpriseLevelEClass, _2ENTERPRISE_LEVEL__BASE_PACKAGE);

		_3WorkCentersLevelEClass = createEClass(_3WORK_CENTERS_LEVEL);
		createEReference(_3WorkCentersLevelEClass, _3WORK_CENTERS_LEVEL__BASE_PACKAGE);

		_4StationsLevelEClass = createEClass(_4STATIONS_LEVEL);
		createEReference(_4StationsLevelEClass, _4STATIONS_LEVEL__BASE_PACKAGE);

		_5ControlDeviceLevelEClass = createEClass(_5CONTROL_DEVICE_LEVEL);
		createEReference(_5ControlDeviceLevelEClass, _5CONTROL_DEVICE_LEVEL__BASE_PACKAGE);

		_6FieldDeviceLevelEClass = createEClass(_6FIELD_DEVICE_LEVEL);
		createEReference(_6FieldDeviceLevelEClass, _6FIELD_DEVICE_LEVEL__BASE_PACKAGE);

		_7ProductLevelEClass = createEClass(_7PRODUCT_LEVEL);
		createEReference(_7ProductLevelEClass, _7PRODUCT_LEVEL__BASE_PACKAGE);
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
		initEClass(_1ConnectedWorldEClass, _1ConnectedWorld.class, "_1ConnectedWorld", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(get_1ConnectedWorld_Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, _1ConnectedWorld.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(_2EnterpriseLevelEClass, _2EnterpriseLevel.class, "_2EnterpriseLevel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(get_2EnterpriseLevel_Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, _2EnterpriseLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(_3WorkCentersLevelEClass, _3WorkCentersLevel.class, "_3WorkCentersLevel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(get_3WorkCentersLevel_Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, _3WorkCentersLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(_4StationsLevelEClass, _4StationsLevel.class, "_4StationsLevel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(get_4StationsLevel_Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, _4StationsLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(_5ControlDeviceLevelEClass, _5ControlDeviceLevel.class, "_5ControlDeviceLevel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(get_5ControlDeviceLevel_Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, _5ControlDeviceLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(_6FieldDeviceLevelEClass, _6FieldDeviceLevel.class, "_6FieldDeviceLevel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(get_6FieldDeviceLevel_Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, _6FieldDeviceLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(_7ProductLevelEClass, _7ProductLevel.class, "_7ProductLevel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(get_7ProductLevel_Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, _7ProductLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

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
		  (_1ConnectedWorldEClass, 
		   source, 
		   new String[] {
			 "originalName", "1-ConnectedWorld"
		   });	
		addAnnotation
		  (_2EnterpriseLevelEClass, 
		   source, 
		   new String[] {
			 "originalName", "2-EnterpriseLevel"
		   });	
		addAnnotation
		  (_3WorkCentersLevelEClass, 
		   source, 
		   new String[] {
			 "originalName", "3-WorkCentersLevel"
		   });	
		addAnnotation
		  (_4StationsLevelEClass, 
		   source, 
		   new String[] {
			 "originalName", "4-StationsLevel"
		   });	
		addAnnotation
		  (_5ControlDeviceLevelEClass, 
		   source, 
		   new String[] {
			 "originalName", "5-ControlDeviceLevel"
		   });	
		addAnnotation
		  (_6FieldDeviceLevelEClass, 
		   source, 
		   new String[] {
			 "originalName", "6-FieldDeviceLevel"
		   });	
		addAnnotation
		  (_7ProductLevelEClass, 
		   source, 
		   new String[] {
			 "originalName", "7-ProductLevel"
		   });
	}

} //InfrastructureHierarchyPackageImpl
