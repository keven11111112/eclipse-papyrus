/**
 * Copyright (c) 2015 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.AbstractRepresentation;
import org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.DiagramExpansion;
import org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.ExpansionmodelFactory;
import org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.ExpansionmodelPackage;
import org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.GMFT_BasedRepresentation;
import org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.GraphicalElementLibrary;
import org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.InducedRepresentation;
import org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.Representation;
import org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.RepresentationKind;
import org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.UseContext;

import org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.util.ExpansionmodelValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpansionmodelPackageImpl extends EPackageImpl implements ExpansionmodelPackage {
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
	private EClass abstractRepresentationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass representationKindEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inducedRepresentationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphicalElementLibraryEClass = null;

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
	private EClass gmfT_BasedRepresentationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagramExpansionEClass = null;

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
	 * @see org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.ExpansionmodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExpansionmodelPackageImpl() {
		super(eNS_URI, ExpansionmodelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ExpansionmodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExpansionmodelPackage init() {
		if (isInited) return (ExpansionmodelPackage)EPackage.Registry.INSTANCE.getEPackage(ExpansionmodelPackage.eNS_URI);

		// Obtain or create and register package
		ExpansionmodelPackageImpl theExpansionmodelPackage = (ExpansionmodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExpansionmodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExpansionmodelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theExpansionmodelPackage.createPackageContents();

		// Initialize created meta-data
		theExpansionmodelPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theExpansionmodelPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return ExpansionmodelValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theExpansionmodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExpansionmodelPackage.eNS_URI, theExpansionmodelPackage);
		return theExpansionmodelPackage;
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
	public EAttribute getRepresentation_GraphicalElementType() {
		return (EAttribute)representationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepresentation_InducedRepresentations() {
		return (EReference)representationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepresentation_SubRepresentations() {
		return (EReference)representationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractRepresentation() {
		return abstractRepresentationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractRepresentation_EditPartQualifiedName() {
		return (EAttribute)abstractRepresentationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractRepresentation_Kind() {
		return (EReference)abstractRepresentationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractRepresentation_Name() {
		return (EAttribute)abstractRepresentationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractRepresentation_ViewFactory() {
		return (EAttribute)abstractRepresentationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractRepresentation_Description() {
		return (EAttribute)abstractRepresentationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractRepresentation__Validate__DiagnosticChain_Map() {
		return abstractRepresentationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepresentationKind() {
		return representationKindEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepresentationKind_EditPartQualifiedName() {
		return (EAttribute)representationKindEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepresentationKind_Name() {
		return (EAttribute)representationKindEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepresentationKind_ViewFactory() {
		return (EAttribute)representationKindEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInducedRepresentation() {
		return inducedRepresentationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInducedRepresentation_Hint() {
		return (EAttribute)inducedRepresentationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInducedRepresentation_Children() {
		return (EReference)inducedRepresentationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraphicalElementLibrary() {
		return graphicalElementLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicalElementLibrary_Name() {
		return (EAttribute)graphicalElementLibraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphicalElementLibrary_Representationkinds() {
		return (EReference)graphicalElementLibraryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphicalElementLibrary_Representations() {
		return (EReference)graphicalElementLibraryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraphicalElementLibrary_Description() {
		return (EAttribute)graphicalElementLibraryEClass.getEStructuralFeatures().get(3);
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
	public EAttribute getUseContext_Description() {
		return (EAttribute)useContextEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGMFT_BasedRepresentation() {
		return gmfT_BasedRepresentationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGMFT_BasedRepresentation_ReusedID() {
		return (EAttribute)gmfT_BasedRepresentationEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getDiagramExpansion_ID() {
		return (EAttribute)diagramExpansionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiagramExpansion_Description() {
		return (EAttribute)diagramExpansionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpansionmodelFactory getExpansionmodelFactory() {
		return (ExpansionmodelFactory)getEFactoryInstance();
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
		createEAttribute(representationEClass, REPRESENTATION__GRAPHICAL_ELEMENT_TYPE);
		createEReference(representationEClass, REPRESENTATION__INDUCED_REPRESENTATIONS);
		createEReference(representationEClass, REPRESENTATION__SUB_REPRESENTATIONS);

		abstractRepresentationEClass = createEClass(ABSTRACT_REPRESENTATION);
		createEAttribute(abstractRepresentationEClass, ABSTRACT_REPRESENTATION__EDIT_PART_QUALIFIED_NAME);
		createEReference(abstractRepresentationEClass, ABSTRACT_REPRESENTATION__KIND);
		createEAttribute(abstractRepresentationEClass, ABSTRACT_REPRESENTATION__NAME);
		createEAttribute(abstractRepresentationEClass, ABSTRACT_REPRESENTATION__VIEW_FACTORY);
		createEAttribute(abstractRepresentationEClass, ABSTRACT_REPRESENTATION__DESCRIPTION);
		createEOperation(abstractRepresentationEClass, ABSTRACT_REPRESENTATION___VALIDATE__DIAGNOSTICCHAIN_MAP);

		representationKindEClass = createEClass(REPRESENTATION_KIND);
		createEAttribute(representationKindEClass, REPRESENTATION_KIND__EDIT_PART_QUALIFIED_NAME);
		createEAttribute(representationKindEClass, REPRESENTATION_KIND__NAME);
		createEAttribute(representationKindEClass, REPRESENTATION_KIND__VIEW_FACTORY);

		inducedRepresentationEClass = createEClass(INDUCED_REPRESENTATION);
		createEAttribute(inducedRepresentationEClass, INDUCED_REPRESENTATION__HINT);
		createEReference(inducedRepresentationEClass, INDUCED_REPRESENTATION__CHILDREN);

		graphicalElementLibraryEClass = createEClass(GRAPHICAL_ELEMENT_LIBRARY);
		createEAttribute(graphicalElementLibraryEClass, GRAPHICAL_ELEMENT_LIBRARY__NAME);
		createEReference(graphicalElementLibraryEClass, GRAPHICAL_ELEMENT_LIBRARY__REPRESENTATIONKINDS);
		createEReference(graphicalElementLibraryEClass, GRAPHICAL_ELEMENT_LIBRARY__REPRESENTATIONS);
		createEAttribute(graphicalElementLibraryEClass, GRAPHICAL_ELEMENT_LIBRARY__DESCRIPTION);

		useContextEClass = createEClass(USE_CONTEXT);
		createEAttribute(useContextEClass, USE_CONTEXT__DIAGRAM_TYPE);
		createEReference(useContextEClass, USE_CONTEXT__REPRESENTATIONS);
		createEAttribute(useContextEClass, USE_CONTEXT__NAME);
		createEReference(useContextEClass, USE_CONTEXT__GMFT_REPRESENTATIONS);
		createEAttribute(useContextEClass, USE_CONTEXT__DESCRIPTION);

		gmfT_BasedRepresentationEClass = createEClass(GMFT_BASED_REPRESENTATION);
		createEAttribute(gmfT_BasedRepresentationEClass, GMFT_BASED_REPRESENTATION__REUSED_ID);

		diagramExpansionEClass = createEClass(DIAGRAM_EXPANSION);
		createEReference(diagramExpansionEClass, DIAGRAM_EXPANSION__USAGES);
		createEReference(diagramExpansionEClass, DIAGRAM_EXPANSION__LIBRARIES);
		createEAttribute(diagramExpansionEClass, DIAGRAM_EXPANSION__ID);
		createEAttribute(diagramExpansionEClass, DIAGRAM_EXPANSION__DESCRIPTION);
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
		representationEClass.getESuperTypes().add(this.getAbstractRepresentation());
		inducedRepresentationEClass.getESuperTypes().add(this.getAbstractRepresentation());
		gmfT_BasedRepresentationEClass.getESuperTypes().add(this.getRepresentation());

		// Initialize classes, features, and operations; add parameters
		initEClass(representationEClass, Representation.class, "Representation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRepresentation_GraphicalElementType(), ecorePackage.getEString(), "graphicalElementType", null, 0, 1, Representation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRepresentation_InducedRepresentations(), this.getInducedRepresentation(), null, "inducedRepresentations", null, 0, -1, Representation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRepresentation_SubRepresentations(), this.getRepresentation(), null, "subRepresentations", null, 0, -1, Representation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(abstractRepresentationEClass, AbstractRepresentation.class, "AbstractRepresentation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractRepresentation_EditPartQualifiedName(), ecorePackage.getEString(), "editPartQualifiedName", null, 0, 1, AbstractRepresentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAbstractRepresentation_Kind(), this.getRepresentationKind(), null, "kind", null, 0, 1, AbstractRepresentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAbstractRepresentation_Name(), ecorePackage.getEString(), "name", null, 1, 1, AbstractRepresentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAbstractRepresentation_ViewFactory(), ecorePackage.getEString(), "viewFactory", null, 0, 1, AbstractRepresentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAbstractRepresentation_Description(), ecorePackage.getEString(), "description", null, 0, 1, AbstractRepresentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = initEOperation(getAbstractRepresentation__Validate__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validate", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostic", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEMap(), "context", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(representationKindEClass, RepresentationKind.class, "RepresentationKind", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRepresentationKind_EditPartQualifiedName(), ecorePackage.getEString(), "editPartQualifiedName", null, 1, 1, RepresentationKind.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRepresentationKind_Name(), ecorePackage.getEString(), "name", null, 1, 1, RepresentationKind.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRepresentationKind_ViewFactory(), ecorePackage.getEString(), "viewFactory", null, 1, 1, RepresentationKind.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(inducedRepresentationEClass, InducedRepresentation.class, "InducedRepresentation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInducedRepresentation_Hint(), ecorePackage.getEString(), "hint", null, 1, 1, InducedRepresentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInducedRepresentation_Children(), this.getRepresentation(), null, "children", null, 0, -1, InducedRepresentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(graphicalElementLibraryEClass, GraphicalElementLibrary.class, "GraphicalElementLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGraphicalElementLibrary_Name(), ecorePackage.getEString(), "name", null, 1, 1, GraphicalElementLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGraphicalElementLibrary_Representationkinds(), this.getRepresentationKind(), null, "representationkinds", null, 0, -1, GraphicalElementLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGraphicalElementLibrary_Representations(), this.getAbstractRepresentation(), null, "representations", null, 0, -1, GraphicalElementLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGraphicalElementLibrary_Description(), ecorePackage.getEString(), "description", null, 0, 1, GraphicalElementLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(useContextEClass, UseContext.class, "UseContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUseContext_DiagramType(), ecorePackage.getEString(), "diagramType", null, 1, 1, UseContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getUseContext_Representations(), this.getRepresentation(), null, "representations", null, 1, -1, UseContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getUseContext_Name(), ecorePackage.getEString(), "name", null, 1, 1, UseContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getUseContext_GmftRepresentations(), this.getGMFT_BasedRepresentation(), null, "gmftRepresentations", null, 0, -1, UseContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getUseContext_Description(), ecorePackage.getEString(), "description", null, 0, 1, UseContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(gmfT_BasedRepresentationEClass, GMFT_BasedRepresentation.class, "GMFT_BasedRepresentation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGMFT_BasedRepresentation_ReusedID(), ecorePackage.getEString(), "reusedID", null, 0, 1, GMFT_BasedRepresentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(diagramExpansionEClass, DiagramExpansion.class, "DiagramExpansion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDiagramExpansion_Usages(), this.getUseContext(), null, "usages", null, 0, -1, DiagramExpansion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDiagramExpansion_Libraries(), this.getGraphicalElementLibrary(), null, "libraries", null, 0, -1, DiagramExpansion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDiagramExpansion_ID(), ecorePackage.getEString(), "ID", null, 1, 1, DiagramExpansion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDiagramExpansion_Description(), ecorePackage.getEString(), "description", null, 0, 1, DiagramExpansion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ExpansionmodelPackageImpl
