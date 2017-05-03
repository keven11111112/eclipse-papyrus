/**
 * Copyright (c) 2017 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.expressions.umlexpressions.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.infra.emf.expressions.ExpressionsPackage;
import org.eclipse.papyrus.infra.emf.expressions.booleanexpressions.BooleanExpressionsPackage;
import org.eclipse.papyrus.uml.expressions.umlexpressions.HasAppliedStereotypesExpression;
import org.eclipse.papyrus.uml.expressions.umlexpressions.IsKindOfExpression;
import org.eclipse.papyrus.uml.expressions.umlexpressions.IsStereotypedWithExpression;
import org.eclipse.papyrus.uml.expressions.umlexpressions.IsTypeOfExpression;
import org.eclipse.papyrus.uml.expressions.umlexpressions.UMLExpressionsFactory;
import org.eclipse.papyrus.uml.expressions.umlexpressions.UMLExpressionsPackage;
import org.eclipse.uml2.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UMLExpressionsPackageImpl extends EPackageImpl implements UMLExpressionsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isStereotypedWithExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hasAppliedStereotypesExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isTypeOfExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isKindOfExpressionEClass = null;

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
	 * @see org.eclipse.papyrus.uml.expressions.umlexpressions.UMLExpressionsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UMLExpressionsPackageImpl() {
		super(eNS_URI, UMLExpressionsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link UMLExpressionsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UMLExpressionsPackage init() {
		if (isInited) return (UMLExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(UMLExpressionsPackage.eNS_URI);

		// Obtain or create and register package
		UMLExpressionsPackageImpl theUMLExpressionsPackage = (UMLExpressionsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UMLExpressionsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UMLExpressionsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ExpressionsPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUMLExpressionsPackage.createPackageContents();

		// Initialize created meta-data
		theUMLExpressionsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUMLExpressionsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UMLExpressionsPackage.eNS_URI, theUMLExpressionsPackage);
		return theUMLExpressionsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsStereotypedWithExpression() {
		return isStereotypedWithExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIsStereotypedWithExpression_StereotypeQualifiedName() {
		return (EAttribute)isStereotypedWithExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIsStereotypedWithExpression_ProfileURI() {
		return (EAttribute)isStereotypedWithExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHasAppliedStereotypesExpression() {
		return hasAppliedStereotypesExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsTypeOfExpression() {
		return isTypeOfExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIsTypeOfExpression_UmlEClass() {
		return (EReference)isTypeOfExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsKindOfExpression() {
		return isKindOfExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIsKindOfExpression_UmlEClass() {
		return (EReference)isKindOfExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLExpressionsFactory getUMLExpressionsFactory() {
		return (UMLExpressionsFactory)getEFactoryInstance();
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
		isStereotypedWithExpressionEClass = createEClass(IS_STEREOTYPED_WITH_EXPRESSION);
		createEAttribute(isStereotypedWithExpressionEClass, IS_STEREOTYPED_WITH_EXPRESSION__STEREOTYPE_QUALIFIED_NAME);
		createEAttribute(isStereotypedWithExpressionEClass, IS_STEREOTYPED_WITH_EXPRESSION__PROFILE_URI);

		hasAppliedStereotypesExpressionEClass = createEClass(HAS_APPLIED_STEREOTYPES_EXPRESSION);

		isTypeOfExpressionEClass = createEClass(IS_TYPE_OF_EXPRESSION);
		createEReference(isTypeOfExpressionEClass, IS_TYPE_OF_EXPRESSION__UML_ECLASS);

		isKindOfExpressionEClass = createEClass(IS_KIND_OF_EXPRESSION);
		createEReference(isKindOfExpressionEClass, IS_KIND_OF_EXPRESSION__UML_ECLASS);
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
		BooleanExpressionsPackage theBooleanExpressionsPackage = (BooleanExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(BooleanExpressionsPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		isStereotypedWithExpressionEClass.getESuperTypes().add(theBooleanExpressionsPackage.getIBooleanEObjectExpression());
		hasAppliedStereotypesExpressionEClass.getESuperTypes().add(theBooleanExpressionsPackage.getIBooleanEObjectExpression());
		isTypeOfExpressionEClass.getESuperTypes().add(theBooleanExpressionsPackage.getIBooleanEObjectExpression());
		isKindOfExpressionEClass.getESuperTypes().add(theBooleanExpressionsPackage.getIBooleanEObjectExpression());

		// Initialize classes, features, and operations; add parameters
		initEClass(isStereotypedWithExpressionEClass, IsStereotypedWithExpression.class, "IsStereotypedWithExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getIsStereotypedWithExpression_StereotypeQualifiedName(), theTypesPackage.getString(), "stereotypeQualifiedName", null, 0, 1, IsStereotypedWithExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getIsStereotypedWithExpression_ProfileURI(), theTypesPackage.getString(), "profileURI", null, 0, 1, IsStereotypedWithExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(hasAppliedStereotypesExpressionEClass, HasAppliedStereotypesExpression.class, "HasAppliedStereotypesExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(isTypeOfExpressionEClass, IsTypeOfExpression.class, "IsTypeOfExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getIsTypeOfExpression_UmlEClass(), theExpressionsPackage.getEClass(), null, "umlEClass", null, 0, 1, IsTypeOfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(isKindOfExpressionEClass, IsKindOfExpression.class, "IsKindOfExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getIsKindOfExpression_UmlEClass(), theExpressionsPackage.getEClass(), null, "umlEClass", null, 0, 1, IsKindOfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

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
		String source = "http://www.eclipse.org/uml2/2.0.0/UML"; //$NON-NLS-1$	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "originalName", "UMLExpressions" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //UMLExpressionsPackageImpl
