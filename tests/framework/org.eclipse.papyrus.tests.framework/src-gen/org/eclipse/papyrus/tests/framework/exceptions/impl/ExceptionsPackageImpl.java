/**
 * Copyright (c) 2015 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 */
package org.eclipse.papyrus.tests.framework.exceptions.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;

import org.eclipse.papyrus.tests.framework.exceptions.AnyEditPart;
import org.eclipse.papyrus.tests.framework.exceptions.CompositeEditPartSpec;
import org.eclipse.papyrus.tests.framework.exceptions.EditPartRef;
import org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec;
import org.eclipse.papyrus.tests.framework.exceptions.ExceptionsFactory;
import org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage;
import org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPart;
import org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation;
import org.eclipse.papyrus.tests.framework.exceptions.ForbiddenReasonKind;

import org.eclipse.papyrus.tests.framework.exceptions.OperatorKind;
import org.eclipse.papyrus.tests.framework.exceptions.TestConstraint;
import org.eclipse.papyrus.tests.framework.exceptions.TestExceptions;
import org.eclipse.papyrus.tests.framework.exceptions.util.ExceptionsValidator;

import org.eclipse.uml2.types.TypesPackage;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ExceptionsPackageImpl extends EPackageImpl implements ExceptionsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass forbiddenEditPartPermutationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass testConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass testExceptionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass editPartSpecEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass compositeEditPartSpecEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass editPartRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass anyEditPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass forbiddenEditPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EEnum forbiddenReasonKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EEnum operatorKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExceptionsPackageImpl() {
		super(eNS_URI, ExceptionsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>
	 * This method is used to initialize {@link ExceptionsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExceptionsPackage init() {
		if (isInited) {
			return (ExceptionsPackage) EPackage.Registry.INSTANCE.getEPackage(ExceptionsPackage.eNS_URI);
		}

		// Obtain or create and register package
		ExceptionsPackageImpl theExceptionsPackage = (ExceptionsPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExceptionsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExceptionsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		GMFGenPackage.eINSTANCE.eClass();
		UMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theExceptionsPackage.createPackageContents();

		// Initialize created meta-data
		theExceptionsPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put(theExceptionsPackage,
				new EValidator.Descriptor() {
					@Override
					public EValidator getEValidator() {
						return ExceptionsValidator.INSTANCE;
					}
				});

		// Mark meta-data to indicate it can't be changed
		theExceptionsPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExceptionsPackage.eNS_URI, theExceptionsPackage);
		return theExceptionsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getForbiddenEditPartPermutation() {
		return forbiddenEditPartPermutationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getForbiddenEditPartPermutation_EditPart() {
		return (EReference) forbiddenEditPartPermutationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getForbiddenEditPartPermutation_ReasonKind() {
		return (EAttribute) forbiddenEditPartPermutationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getForbiddenEditPartPermutation_Reason() {
		return (EAttribute) forbiddenEditPartPermutationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getForbiddenEditPartPermutation_TestClass() {
		return (EReference) forbiddenEditPartPermutationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EOperation getForbiddenEditPartPermutation__Test_classes__DiagnosticChain_Map() {
		return forbiddenEditPartPermutationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getTestConstraint() {
		return testConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getTestConstraint_Container() {
		return (EReference) testConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getTestConstraint_OmitOnFailure() {
		return (EAttribute) testConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EOperation getTestConstraint__Validate__EList_Class_DiagnosticChain() {
		return testConstraintEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getTestExceptions() {
		return testExceptionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getTestExceptions_Constraint() {
		return (EReference) testExceptionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EOperation getTestExceptions__Validate__EList_Class_DiagnosticChain() {
		return testExceptionsEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getEditPartSpec() {
		return editPartSpecEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getEditPartSpec_Composite() {
		return (EReference) editPartSpecEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EOperation getEditPartSpec__Matches__InstanceSpecification() {
		return editPartSpecEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getCompositeEditPartSpec() {
		return compositeEditPartSpecEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getCompositeEditPartSpec_Operator() {
		return (EAttribute) compositeEditPartSpecEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getCompositeEditPartSpec_Operand() {
		return (EReference) compositeEditPartSpecEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getEditPartRef() {
		return editPartRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getEditPartRef_EditPart() {
		return (EReference) editPartRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getAnyEditPart() {
		return anyEditPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getForbiddenEditPart() {
		return forbiddenEditPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getForbiddenEditPart_EditPart() {
		return (EReference) forbiddenEditPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getForbiddenEditPart_Reason() {
		return (EAttribute) forbiddenEditPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getForbiddenEditPart_ReasonKind() {
		return (EAttribute) forbiddenEditPartEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EEnum getForbiddenReasonKind() {
		return forbiddenReasonKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EEnum getOperatorKind() {
		return operatorKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ExceptionsFactory getExceptionsFactory() {
		return (ExceptionsFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) {
			return;
		}
		isCreated = true;

		// Create classes and their features
		forbiddenEditPartPermutationEClass = createEClass(FORBIDDEN_EDIT_PART_PERMUTATION);
		createEAttribute(forbiddenEditPartPermutationEClass, FORBIDDEN_EDIT_PART_PERMUTATION__REASON_KIND);
		createEAttribute(forbiddenEditPartPermutationEClass, FORBIDDEN_EDIT_PART_PERMUTATION__REASON);
		createEReference(forbiddenEditPartPermutationEClass, FORBIDDEN_EDIT_PART_PERMUTATION__TEST_CLASS);
		createEReference(forbiddenEditPartPermutationEClass, FORBIDDEN_EDIT_PART_PERMUTATION__EDIT_PART);
		createEOperation(forbiddenEditPartPermutationEClass, FORBIDDEN_EDIT_PART_PERMUTATION___TEST_CLASSES__DIAGNOSTICCHAIN_MAP);

		testConstraintEClass = createEClass(TEST_CONSTRAINT);
		createEReference(testConstraintEClass, TEST_CONSTRAINT__CONTAINER);
		createEAttribute(testConstraintEClass, TEST_CONSTRAINT__OMIT_ON_FAILURE);
		createEOperation(testConstraintEClass, TEST_CONSTRAINT___VALIDATE__ELIST_CLASS_DIAGNOSTICCHAIN);

		testExceptionsEClass = createEClass(TEST_EXCEPTIONS);
		createEReference(testExceptionsEClass, TEST_EXCEPTIONS__CONSTRAINT);
		createEOperation(testExceptionsEClass, TEST_EXCEPTIONS___VALIDATE__ELIST_CLASS_DIAGNOSTICCHAIN);

		editPartSpecEClass = createEClass(EDIT_PART_SPEC);
		createEReference(editPartSpecEClass, EDIT_PART_SPEC__COMPOSITE);
		createEOperation(editPartSpecEClass, EDIT_PART_SPEC___MATCHES__INSTANCESPECIFICATION);

		compositeEditPartSpecEClass = createEClass(COMPOSITE_EDIT_PART_SPEC);
		createEAttribute(compositeEditPartSpecEClass, COMPOSITE_EDIT_PART_SPEC__OPERATOR);
		createEReference(compositeEditPartSpecEClass, COMPOSITE_EDIT_PART_SPEC__OPERAND);

		editPartRefEClass = createEClass(EDIT_PART_REF);
		createEReference(editPartRefEClass, EDIT_PART_REF__EDIT_PART);

		anyEditPartEClass = createEClass(ANY_EDIT_PART);

		forbiddenEditPartEClass = createEClass(FORBIDDEN_EDIT_PART);
		createEReference(forbiddenEditPartEClass, FORBIDDEN_EDIT_PART__EDIT_PART);
		createEAttribute(forbiddenEditPartEClass, FORBIDDEN_EDIT_PART__REASON);
		createEAttribute(forbiddenEditPartEClass, FORBIDDEN_EDIT_PART__REASON_KIND);

		// Create enums
		forbiddenReasonKindEEnum = createEEnum(FORBIDDEN_REASON_KIND);
		operatorKindEEnum = createEEnum(OPERATOR_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) {
			return;
		}
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		TypesPackage theTypesPackage = (TypesPackage) EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		UMLPackage theUMLPackage = (UMLPackage) EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		GMFGenPackage theGMFGenPackage = (GMFGenPackage) EPackage.Registry.INSTANCE.getEPackage(GMFGenPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		forbiddenEditPartPermutationEClass.getESuperTypes().add(this.getTestConstraint());
		compositeEditPartSpecEClass.getESuperTypes().add(this.getEditPartSpec());
		editPartRefEClass.getESuperTypes().add(this.getEditPartSpec());
		anyEditPartEClass.getESuperTypes().add(this.getEditPartSpec());
		forbiddenEditPartEClass.getESuperTypes().add(this.getTestConstraint());

		// Initialize classes, features, and operations; add parameters
		initEClass(forbiddenEditPartPermutationEClass, ForbiddenEditPartPermutation.class, "ForbiddenEditPartPermutation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getForbiddenEditPartPermutation_ReasonKind(), this.getForbiddenReasonKind(), "reasonKind", "invalid", 1, 1, ForbiddenEditPartPermutation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEAttribute(getForbiddenEditPartPermutation_Reason(), theTypesPackage.getString(), "reason", null, 0, 1, ForbiddenEditPartPermutation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getForbiddenEditPartPermutation_TestClass(), theUMLPackage.getClass_(), null, "testClass", null, 1, -1, ForbiddenEditPartPermutation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getForbiddenEditPartPermutation_EditPart(), this.getEditPartSpec(), null, "editPart", null, 1, -1, ForbiddenEditPartPermutation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = initEOperation(getForbiddenEditPartPermutation__Test_classes__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "test_classes", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(testConstraintEClass, TestConstraint.class, "TestConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestConstraint_Container(), this.getTestExceptions(), this.getTestExceptions_Constraint(), "container", null, 1, 1, TestConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTestConstraint_OmitOnFailure(), theTypesPackage.getBoolean(), "omitOnFailure", null, 1, 1, TestConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = initEOperation(getTestConstraint__Validate__EList_Class_DiagnosticChain(), theTypesPackage.getBoolean(), "validate", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theUMLPackage.getInstanceSpecification(), "editPart", 1, -1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theUMLPackage.getClass_(), "testClass", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theEcorePackage.getEDiagnosticChain(), "diagnostics", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(testExceptionsEClass, TestExceptions.class, "TestExceptions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTestExceptions_Constraint(), this.getTestConstraint(), this.getTestConstraint_Container(), "constraint", null, 0, -1, TestExceptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = initEOperation(getTestExceptions__Validate__EList_Class_DiagnosticChain(), theTypesPackage.getBoolean(), "validate", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theUMLPackage.getInstanceSpecification(), "editPart", 1, -1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theUMLPackage.getClass_(), "testClass", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theEcorePackage.getEDiagnosticChain(), "diagnostics", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(editPartSpecEClass, EditPartSpec.class, "EditPartSpec", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEditPartSpec_Composite(), this.getCompositeEditPartSpec(), this.getCompositeEditPartSpec_Operand(), "composite", null, 0, 1, EditPartSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = initEOperation(getEditPartSpec__Matches__InstanceSpecification(), theTypesPackage.getBoolean(), "matches", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theUMLPackage.getInstanceSpecification(), "editPart", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(compositeEditPartSpecEClass, CompositeEditPartSpec.class, "CompositeEditPartSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompositeEditPartSpec_Operator(), this.getOperatorKind(), "operator", null, 1, 1, CompositeEditPartSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCompositeEditPartSpec_Operand(), this.getEditPartSpec(), this.getEditPartSpec_Composite(), "operand", null, 1, -1, CompositeEditPartSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(editPartRefEClass, EditPartRef.class, "EditPartRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEditPartRef_EditPart(), theGMFGenPackage.getGenCommonBase(), null, "editPart", null, 1, 1, EditPartRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);

		initEClass(anyEditPartEClass, AnyEditPart.class, "AnyEditPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(forbiddenEditPartEClass, ForbiddenEditPart.class, "ForbiddenEditPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForbiddenEditPart_EditPart(), this.getEditPartSpec(), null, "editPart", null, 1, 1, ForbiddenEditPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEAttribute(getForbiddenEditPart_Reason(), theTypesPackage.getString(), "reason", null, 0, 1, ForbiddenEditPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getForbiddenEditPart_ReasonKind(), this.getForbiddenReasonKind(), "reasonKind", "invalid", 1, 1, ForbiddenEditPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(forbiddenReasonKindEEnum, ForbiddenReasonKind.class, "ForbiddenReasonKind");
		addEEnumLiteral(forbiddenReasonKindEEnum, ForbiddenReasonKind.INVALID);
		addEEnumLiteral(forbiddenReasonKindEEnum, ForbiddenReasonKind.FAILING);
		addEEnumLiteral(forbiddenReasonKindEEnum, ForbiddenReasonKind.UNIMPLEMENTED);
		addEEnumLiteral(forbiddenReasonKindEEnum, ForbiddenReasonKind.INTERACTIVE);

		initEEnum(operatorKindEEnum, OperatorKind.class, "OperatorKind");
		addEEnumLiteral(operatorKindEEnum, OperatorKind.AND);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.OR);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.NOT);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// duplicates
		createDuplicatesAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL
		createOCLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";
		addAnnotation(this,
				source,
				new String[] {
						"validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL"
				});
	}

	/**
	 * Initializes the annotations for <b>duplicates</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void createDuplicatesAnnotations() {
		String source = "duplicates";
		addAnnotation(forbiddenEditPartPermutationEClass,
				source,
				new String[] {
				});
		addAnnotation(compositeEditPartSpecEClass,
				source,
				new String[] {
				});
		addAnnotation(editPartRefEClass,
				source,
				new String[] {
				});
		addAnnotation(anyEditPartEClass,
				source,
				new String[] {
				});
		addAnnotation(forbiddenEditPartEClass,
				source,
				new String[] {
				});
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void createOCLAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL";
		addAnnotation(getForbiddenEditPartPermutation__Test_classes__DiagnosticChain_Map(),
				source,
				new String[] {
						"body", "testClass->forAll(conformsTo(_\'org.eclipse.papyrus.uml.diagram.tests\'::AbstractPapyrusTestCase.oclAsType(UML::Type)))"
				});
	}

} // ExceptionsPackageImpl
