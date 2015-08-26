/**
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.migration.rsa.diagramholder.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.migration.rsa.diagramholder.DiagramHolder;
import org.eclipse.papyrus.migration.rsa.diagramholder.DiagramHolderFactory;
import org.eclipse.papyrus.migration.rsa.diagramholder.DiagramHolderPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DiagramHolderPackageImpl extends EPackageImpl implements DiagramHolderPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagramHolderEClass = null;

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
	 * @see org.eclipse.papyrus.migration.rsa.diagramholder.DiagramHolderPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DiagramHolderPackageImpl() {
		super(eNS_URI, DiagramHolderFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DiagramHolderPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DiagramHolderPackage init() {
		if (isInited) return (DiagramHolderPackage)EPackage.Registry.INSTANCE.getEPackage(DiagramHolderPackage.eNS_URI);

		// Obtain or create and register package
		DiagramHolderPackageImpl theDiagramHolderPackage = (DiagramHolderPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DiagramHolderPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DiagramHolderPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		NotationPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDiagramHolderPackage.createPackageContents();

		// Initialize created meta-data
		theDiagramHolderPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDiagramHolderPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DiagramHolderPackage.eNS_URI, theDiagramHolderPackage);
		return theDiagramHolderPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiagramHolder() {
		return diagramHolderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiagramHolder_OwnedDiagrams() {
		return (EReference)diagramHolderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramHolderFactory getDiagramHolderFactory() {
		return (DiagramHolderFactory)getEFactoryInstance();
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
		diagramHolderEClass = createEClass(DIAGRAM_HOLDER);
		createEReference(diagramHolderEClass, DIAGRAM_HOLDER__OWNED_DIAGRAMS);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		NotationPackage theNotationPackage = (NotationPackage)EPackage.Registry.INSTANCE.getEPackage(NotationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		diagramHolderEClass.getESuperTypes().add(theEcorePackage.getEAnnotation());

		// Initialize classes, features, and operations; add parameters
		initEClass(diagramHolderEClass, DiagramHolder.class, "DiagramHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDiagramHolder_OwnedDiagrams(), theNotationPackage.getDiagram(), null, "ownedDiagrams", null, 0, -1, DiagramHolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //DiagramHolderPackageImpl
