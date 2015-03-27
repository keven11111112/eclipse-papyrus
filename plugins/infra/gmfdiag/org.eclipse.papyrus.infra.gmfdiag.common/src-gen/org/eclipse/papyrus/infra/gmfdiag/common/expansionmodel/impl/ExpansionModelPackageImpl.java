/**
 */
package org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.CompartmentKind;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.CompartmentLibrary;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Compartments;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.DiagramExpansion;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionModelFactory;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionModelPackage;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.GmftBasedRepresentation;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Library;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.RepresentationKind;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.RepresentationLibrary;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.UseContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpansionModelPackageImpl extends EPackageImpl implements ExpansionModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass representationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compartmentsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass representationLibraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compartmentLibraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass useContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gmftBasedRepresentationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagramExpansionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum representationKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum compartmentKindEEnum = null;

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
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExpansionModelPackageImpl() {
		super(eNS_URI, ExpansionModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ExpansionModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExpansionModelPackage init() {
		if (isInited) return (ExpansionModelPackage)EPackage.Registry.INSTANCE.getEPackage(ExpansionModelPackage.eNS_URI);

		// Obtain or create and register package
		ExpansionModelPackageImpl theExpansionModelPackage = (ExpansionModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExpansionModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExpansionModelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theExpansionModelPackage.createPackageContents();

		// Initialize created meta-data
		theExpansionModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExpansionModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExpansionModelPackage.eNS_URI, theExpansionModelPackage);
		return theExpansionModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepresentation() {
		return representationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepresentation_EditPartQualifiedName() {
		return (EAttribute)representationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepresentation_Kind() {
		return (EAttribute)representationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepresentation_GraphicalElementType() {
		return (EAttribute)representationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepresentation_Compartments() {
		return (EReference)representationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepresentation_Name() {
		return (EAttribute)representationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepresentation_ViewFactory() {
		return (EAttribute)representationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompartments() {
		return compartmentsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompartments_Hint() {
		return (EAttribute)compartmentsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompartments_Children() {
		return (EReference)compartmentsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompartments_Kind() {
		return (EAttribute)compartmentsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompartments_Name() {
		return (EAttribute)compartmentsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompartments_EditPartQualifiedName() {
		return (EAttribute)compartmentsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepresentationLibrary() {
		return representationLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepresentationLibrary_Representations() {
		return (EReference)representationLibraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibrary() {
		return libraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLibrary_Name() {
		return (EAttribute)libraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompartmentLibrary() {
		return compartmentLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompartmentLibrary_Compartments() {
		return (EReference)compartmentLibraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUseContext() {
		return useContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUseContext_DiagramType() {
		return (EAttribute)useContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseContext_Representations() {
		return (EReference)useContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUseContext_Name() {
		return (EAttribute)useContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseContext_GmftRepresentations() {
		return (EReference)useContextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGmftBasedRepresentation() {
		return gmftBasedRepresentationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGmftBasedRepresentation_ReusedId() {
		return (EAttribute)gmftBasedRepresentationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiagramExpansion() {
		return diagramExpansionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiagramExpansion_Usages() {
		return (EReference)diagramExpansionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiagramExpansion_Libraries() {
		return (EReference)diagramExpansionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRepresentationKind() {
		return representationKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCompartmentKind() {
		return compartmentKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpansionModelFactory getExpansionModelFactory() {
		return (ExpansionModelFactory)getEFactoryInstance();
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
		representationEClass = createEClass(REPRESENTATION);
		createEAttribute(representationEClass, REPRESENTATION__EDIT_PART_QUALIFIED_NAME);
		createEAttribute(representationEClass, REPRESENTATION__KIND);
		createEAttribute(representationEClass, REPRESENTATION__GRAPHICAL_ELEMENT_TYPE);
		createEReference(representationEClass, REPRESENTATION__COMPARTMENTS);
		createEAttribute(representationEClass, REPRESENTATION__NAME);
		createEAttribute(representationEClass, REPRESENTATION__VIEW_FACTORY);

		compartmentsEClass = createEClass(COMPARTMENTS);
		createEAttribute(compartmentsEClass, COMPARTMENTS__HINT);
		createEReference(compartmentsEClass, COMPARTMENTS__CHILDREN);
		createEAttribute(compartmentsEClass, COMPARTMENTS__KIND);
		createEAttribute(compartmentsEClass, COMPARTMENTS__NAME);
		createEAttribute(compartmentsEClass, COMPARTMENTS__EDIT_PART_QUALIFIED_NAME);

		representationLibraryEClass = createEClass(REPRESENTATION_LIBRARY);
		createEReference(representationLibraryEClass, REPRESENTATION_LIBRARY__REPRESENTATIONS);

		libraryEClass = createEClass(LIBRARY);
		createEAttribute(libraryEClass, LIBRARY__NAME);

		compartmentLibraryEClass = createEClass(COMPARTMENT_LIBRARY);
		createEReference(compartmentLibraryEClass, COMPARTMENT_LIBRARY__COMPARTMENTS);

		useContextEClass = createEClass(USE_CONTEXT);
		createEAttribute(useContextEClass, USE_CONTEXT__DIAGRAM_TYPE);
		createEReference(useContextEClass, USE_CONTEXT__REPRESENTATIONS);
		createEAttribute(useContextEClass, USE_CONTEXT__NAME);
		createEReference(useContextEClass, USE_CONTEXT__GMFT_REPRESENTATIONS);

		gmftBasedRepresentationEClass = createEClass(GMFT_BASED_REPRESENTATION);
		createEAttribute(gmftBasedRepresentationEClass, GMFT_BASED_REPRESENTATION__REUSED_ID);

		diagramExpansionEClass = createEClass(DIAGRAM_EXPANSION);
		createEReference(diagramExpansionEClass, DIAGRAM_EXPANSION__USAGES);
		createEReference(diagramExpansionEClass, DIAGRAM_EXPANSION__LIBRARIES);

		// Create enums
		representationKindEEnum = createEEnum(REPRESENTATION_KIND);
		compartmentKindEEnum = createEEnum(COMPARTMENT_KIND);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		representationLibraryEClass.getESuperTypes().add(this.getLibrary());
		compartmentLibraryEClass.getESuperTypes().add(this.getLibrary());
		gmftBasedRepresentationEClass.getESuperTypes().add(this.getRepresentation());

		// Initialize classes, features, and operations; add parameters
		initEClass(representationEClass, Representation.class, "Representation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRepresentation_EditPartQualifiedName(), ecorePackage.getEString(), "editPartQualifiedName", null, 0, 1, Representation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRepresentation_Kind(), this.getRepresentationKind(), "kind", null, 1, 1, Representation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRepresentation_GraphicalElementType(), ecorePackage.getEString(), "graphicalElementType", null, 0, 1, Representation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRepresentation_Compartments(), this.getCompartments(), null, "compartments", null, 0, -1, Representation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRepresentation_Name(), ecorePackage.getEString(), "name", null, 1, 1, Representation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRepresentation_ViewFactory(), ecorePackage.getEString(), "viewFactory", null, 1, 1, Representation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(compartmentsEClass, Compartments.class, "Compartments", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompartments_Hint(), ecorePackage.getEString(), "hint", null, 1, 1, Compartments.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCompartments_Children(), this.getRepresentation(), null, "children", null, 1, -1, Compartments.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCompartments_Kind(), this.getCompartmentKind(), "kind", null, 1, 1, Compartments.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCompartments_Name(), ecorePackage.getEString(), "name", null, 1, 1, Compartments.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCompartments_EditPartQualifiedName(), ecorePackage.getEString(), "editPartQualifiedName", null, 0, 1, Compartments.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(representationLibraryEClass, RepresentationLibrary.class, "RepresentationLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRepresentationLibrary_Representations(), this.getRepresentation(), null, "representations", null, 1, -1, RepresentationLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(libraryEClass, Library.class, "Library", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLibrary_Name(), ecorePackage.getEString(), "name", null, 1, 1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(compartmentLibraryEClass, CompartmentLibrary.class, "CompartmentLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompartmentLibrary_Compartments(), this.getCompartments(), null, "compartments", null, 1, -1, CompartmentLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(useContextEClass, UseContext.class, "UseContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUseContext_DiagramType(), ecorePackage.getEString(), "diagramType", null, 1, 1, UseContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getUseContext_Representations(), this.getRepresentation(), null, "representations", null, 1, -1, UseContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getUseContext_Name(), ecorePackage.getEString(), "name", null, 1, 1, UseContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getUseContext_GmftRepresentations(), this.getGmftBasedRepresentation(), null, "gmftRepresentations", null, 0, -1, UseContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(gmftBasedRepresentationEClass, GmftBasedRepresentation.class, "GmftBasedRepresentation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGmftBasedRepresentation_ReusedId(), ecorePackage.getEString(), "reusedId", null, 0, 1, GmftBasedRepresentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(diagramExpansionEClass, DiagramExpansion.class, "DiagramExpansion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDiagramExpansion_Usages(), this.getUseContext(), null, "usages", null, 1, -1, DiagramExpansion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDiagramExpansion_Libraries(), this.getLibrary(), null, "libraries", null, 0, -1, DiagramExpansion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(representationKindEEnum, RepresentationKind.class, "RepresentationKind");
		addEEnumLiteral(representationKindEEnum, RepresentationKind.SHAPE);
		addEEnumLiteral(representationKindEEnum, RepresentationKind.LABEL);
		addEEnumLiteral(representationKindEEnum, RepresentationKind.LINK);
		addEEnumLiteral(representationKindEEnum, RepresentationKind.BORDER_ITEM);
		addEEnumLiteral(representationKindEEnum, RepresentationKind.BORDER_ITEM_LABEL);
		addEEnumLiteral(representationKindEEnum, RepresentationKind.CUSTOM);

		initEEnum(compartmentKindEEnum, CompartmentKind.class, "CompartmentKind");
		addEEnumLiteral(compartmentKindEEnum, CompartmentKind.LIST);
		addEEnumLiteral(compartmentKindEEnum, CompartmentKind.XY);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
		// duplicates
		createDuplicatesAnnotations();
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
		  (this, 
		   source, 
		   new String[] {
			 "originalName", "ExpansionModel"
		   });	
		addAnnotation
		  (representationKindEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "originalName", "Shape"
		   });	
		addAnnotation
		  (representationKindEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "originalName", "Label"
		   });	
		addAnnotation
		  (representationKindEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "originalName", "Link"
		   });	
		addAnnotation
		  (representationKindEEnum.getELiterals().get(3), 
		   source, 
		   new String[] {
			 "originalName", "BorderItem"
		   });	
		addAnnotation
		  (representationKindEEnum.getELiterals().get(4), 
		   source, 
		   new String[] {
			 "originalName", "BorderItemLabel"
		   });	
		addAnnotation
		  (representationKindEEnum.getELiterals().get(5), 
		   source, 
		   new String[] {
			 "originalName", "Custom"
		   });	
		addAnnotation
		  (compartmentKindEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "originalName", "XY"
		   });	
		addAnnotation
		  (getUseContext_DiagramType(), 
		   source, 
		   new String[] {
			 "originalName", "DiagramType"
		   });	
		addAnnotation
		  (getUseContext_GmftRepresentations(), 
		   source, 
		   new String[] {
			 "originalName", "GmftRepresentations"
		   });	
		addAnnotation
		  (gmftBasedRepresentationEClass, 
		   source, 
		   new String[] {
			 "originalName", "GMFT_Based_Representation"
		   });	
		addAnnotation
		  (getGmftBasedRepresentation_ReusedId(), 
		   source, 
		   new String[] {
			 "originalName", "reusedID"
		   });
	}

	/**
	 * Initializes the annotations for <b>duplicates</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createDuplicatesAnnotations() {
		String source = "duplicates";	
		addAnnotation
		  (gmftBasedRepresentationEClass, 
		   source, 
		   new String[] {
		   });
	}

} //ExpansionModelPackageImpl
