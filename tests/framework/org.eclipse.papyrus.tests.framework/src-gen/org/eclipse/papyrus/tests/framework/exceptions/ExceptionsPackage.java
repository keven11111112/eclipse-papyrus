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
package org.eclipse.papyrus.tests.framework.exceptions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface ExceptionsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNAME = "exceptions";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/2015/testframework/exceptions";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_PREFIX = "exceptions";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	ExceptionsPackage eINSTANCE = org.eclipse.papyrus.tests.framework.exceptions.impl.ExceptionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.tests.framework.exceptions.impl.TestConstraintImpl <em>Test Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.TestConstraintImpl
	 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ExceptionsPackageImpl#getTestConstraint()
	 * @generated
	 */
	int TEST_CONSTRAINT = 1;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int TEST_CONSTRAINT__CONTAINER = 0;

	/**
	 * The feature id for the '<em><b>Omit On Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int TEST_CONSTRAINT__OMIT_ON_FAILURE = 1;

	/**
	 * The number of structural features of the '<em>Test Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int TEST_CONSTRAINT_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int TEST_CONSTRAINT___VALIDATE__ELIST_CLASS_DIAGNOSTICCHAIN = 0;

	/**
	 * The number of operations of the '<em>Test Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int TEST_CONSTRAINT_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.tests.framework.exceptions.impl.ForbiddenEditPartPermutationImpl <em>Forbidden Edit Part Permutation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ForbiddenEditPartPermutationImpl
	 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ExceptionsPackageImpl#getForbiddenEditPartPermutation()
	 * @generated
	 */
	int FORBIDDEN_EDIT_PART_PERMUTATION = 0;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORBIDDEN_EDIT_PART_PERMUTATION__CONTAINER = TEST_CONSTRAINT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Omit On Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORBIDDEN_EDIT_PART_PERMUTATION__OMIT_ON_FAILURE = TEST_CONSTRAINT__OMIT_ON_FAILURE;

	/**
	 * The feature id for the '<em><b>Reason Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORBIDDEN_EDIT_PART_PERMUTATION__REASON_KIND = TEST_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORBIDDEN_EDIT_PART_PERMUTATION__REASON = TEST_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Test Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORBIDDEN_EDIT_PART_PERMUTATION__TEST_CLASS = TEST_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Edit Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORBIDDEN_EDIT_PART_PERMUTATION__EDIT_PART = TEST_CONSTRAINT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Forbidden Edit Part Permutation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORBIDDEN_EDIT_PART_PERMUTATION_FEATURE_COUNT = TEST_CONSTRAINT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORBIDDEN_EDIT_PART_PERMUTATION___VALIDATE__ELIST_CLASS_DIAGNOSTICCHAIN = TEST_CONSTRAINT___VALIDATE__ELIST_CLASS_DIAGNOSTICCHAIN;

	/**
	 * The operation id for the '<em>Test classes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORBIDDEN_EDIT_PART_PERMUTATION___TEST_CLASSES__DIAGNOSTICCHAIN_MAP = TEST_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Forbidden Edit Part Permutation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORBIDDEN_EDIT_PART_PERMUTATION_OPERATION_COUNT = TEST_CONSTRAINT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.tests.framework.exceptions.impl.TestExceptionsImpl <em>Test Exceptions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.TestExceptionsImpl
	 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ExceptionsPackageImpl#getTestExceptions()
	 * @generated
	 */
	int TEST_EXCEPTIONS = 2;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int TEST_EXCEPTIONS__CONSTRAINT = 0;

	/**
	 * The number of structural features of the '<em>Test Exceptions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int TEST_EXCEPTIONS_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int TEST_EXCEPTIONS___VALIDATE__ELIST_CLASS_DIAGNOSTICCHAIN = 0;

	/**
	 * The number of operations of the '<em>Test Exceptions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int TEST_EXCEPTIONS_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.tests.framework.exceptions.impl.EditPartSpecImpl <em>Edit Part Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.EditPartSpecImpl
	 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ExceptionsPackageImpl#getEditPartSpec()
	 * @generated
	 */
	int EDIT_PART_SPEC = 3;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int EDIT_PART_SPEC__COMPOSITE = 0;

	/**
	 * The number of structural features of the '<em>Edit Part Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int EDIT_PART_SPEC_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Matches</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int EDIT_PART_SPEC___MATCHES__INSTANCESPECIFICATION = 0;

	/**
	 * The number of operations of the '<em>Edit Part Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int EDIT_PART_SPEC_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.tests.framework.exceptions.impl.CompositeEditPartSpecImpl <em>Composite Edit Part Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.CompositeEditPartSpecImpl
	 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ExceptionsPackageImpl#getCompositeEditPartSpec()
	 * @generated
	 */
	int COMPOSITE_EDIT_PART_SPEC = 4;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_EDIT_PART_SPEC__COMPOSITE = EDIT_PART_SPEC__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_EDIT_PART_SPEC__OPERATOR = EDIT_PART_SPEC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_EDIT_PART_SPEC__OPERAND = EDIT_PART_SPEC_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composite Edit Part Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_EDIT_PART_SPEC_FEATURE_COUNT = EDIT_PART_SPEC_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Matches</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_EDIT_PART_SPEC___MATCHES__INSTANCESPECIFICATION = EDIT_PART_SPEC___MATCHES__INSTANCESPECIFICATION;

	/**
	 * The number of operations of the '<em>Composite Edit Part Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_EDIT_PART_SPEC_OPERATION_COUNT = EDIT_PART_SPEC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.tests.framework.exceptions.impl.EditPartRefImpl <em>Edit Part Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.EditPartRefImpl
	 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ExceptionsPackageImpl#getEditPartRef()
	 * @generated
	 */
	int EDIT_PART_REF = 5;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int EDIT_PART_REF__COMPOSITE = EDIT_PART_SPEC__COMPOSITE;

	/**
	 * The feature id for the '<em><b>Edit Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int EDIT_PART_REF__EDIT_PART = EDIT_PART_SPEC_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Edit Part Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int EDIT_PART_REF_FEATURE_COUNT = EDIT_PART_SPEC_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Matches</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int EDIT_PART_REF___MATCHES__INSTANCESPECIFICATION = EDIT_PART_SPEC___MATCHES__INSTANCESPECIFICATION;

	/**
	 * The number of operations of the '<em>Edit Part Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int EDIT_PART_REF_OPERATION_COUNT = EDIT_PART_SPEC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.tests.framework.exceptions.impl.AnyEditPartImpl <em>Any Edit Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.AnyEditPartImpl
	 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ExceptionsPackageImpl#getAnyEditPart()
	 * @generated
	 */
	int ANY_EDIT_PART = 6;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ANY_EDIT_PART__COMPOSITE = EDIT_PART_SPEC__COMPOSITE;

	/**
	 * The number of structural features of the '<em>Any Edit Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ANY_EDIT_PART_FEATURE_COUNT = EDIT_PART_SPEC_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Matches</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ANY_EDIT_PART___MATCHES__INSTANCESPECIFICATION = EDIT_PART_SPEC___MATCHES__INSTANCESPECIFICATION;

	/**
	 * The number of operations of the '<em>Any Edit Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ANY_EDIT_PART_OPERATION_COUNT = EDIT_PART_SPEC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.tests.framework.exceptions.impl.ForbiddenEditPartImpl <em>Forbidden Edit Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ForbiddenEditPartImpl
	 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ExceptionsPackageImpl#getForbiddenEditPart()
	 * @generated
	 */
	int FORBIDDEN_EDIT_PART = 7;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORBIDDEN_EDIT_PART__CONTAINER = TEST_CONSTRAINT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Omit On Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORBIDDEN_EDIT_PART__OMIT_ON_FAILURE = TEST_CONSTRAINT__OMIT_ON_FAILURE;

	/**
	 * The feature id for the '<em><b>Edit Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORBIDDEN_EDIT_PART__EDIT_PART = TEST_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORBIDDEN_EDIT_PART__REASON = TEST_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Reason Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORBIDDEN_EDIT_PART__REASON_KIND = TEST_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Forbidden Edit Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORBIDDEN_EDIT_PART_FEATURE_COUNT = TEST_CONSTRAINT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Validate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORBIDDEN_EDIT_PART___VALIDATE__ELIST_CLASS_DIAGNOSTICCHAIN = TEST_CONSTRAINT___VALIDATE__ELIST_CLASS_DIAGNOSTICCHAIN;

	/**
	 * The number of operations of the '<em>Forbidden Edit Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int FORBIDDEN_EDIT_PART_OPERATION_COUNT = TEST_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenReasonKind <em>Forbidden Reason Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ForbiddenReasonKind
	 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ExceptionsPackageImpl#getForbiddenReasonKind()
	 * @generated
	 */
	int FORBIDDEN_REASON_KIND = 8;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.tests.framework.exceptions.OperatorKind <em>Operator Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.tests.framework.exceptions.OperatorKind
	 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ExceptionsPackageImpl#getOperatorKind()
	 * @generated
	 */
	int OPERATOR_KIND = 9;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation <em>Forbidden Edit Part Permutation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Forbidden Edit Part Permutation</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation
	 * @generated
	 */
	EClass getForbiddenEditPartPermutation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation#getEditParts <em>Edit Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Edit Part</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation#getEditParts()
	 * @see #getForbiddenEditPartPermutation()
	 * @generated
	 */
	EReference getForbiddenEditPartPermutation_EditPart();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation#getReasonKind <em>Reason Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Reason Kind</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation#getReasonKind()
	 * @see #getForbiddenEditPartPermutation()
	 * @generated
	 */
	EAttribute getForbiddenEditPartPermutation_ReasonKind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation#getReason <em>Reason</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Reason</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation#getReason()
	 * @see #getForbiddenEditPartPermutation()
	 * @generated
	 */
	EAttribute getForbiddenEditPartPermutation_Reason();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation#getTestClasses <em>Test Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference list '<em>Test Class</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation#getTestClasses()
	 * @see #getForbiddenEditPartPermutation()
	 * @generated
	 */
	EReference getForbiddenEditPartPermutation_TestClass();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation#test_classes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Test classes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the '<em>Test classes</em>' operation.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation#test_classes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getForbiddenEditPartPermutation__Test_classes__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.tests.framework.exceptions.TestConstraint <em>Test Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Test Constraint</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.TestConstraint
	 * @generated
	 */
	EClass getTestConstraint();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.tests.framework.exceptions.TestConstraint#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the container reference '<em>Container</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.TestConstraint#getContainer()
	 * @see #getTestConstraint()
	 * @generated
	 */
	EReference getTestConstraint_Container();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.tests.framework.exceptions.TestConstraint#isOmitOnFailure <em>Omit On Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Omit On Failure</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.TestConstraint#isOmitOnFailure()
	 * @see #getTestConstraint()
	 * @generated
	 */
	EAttribute getTestConstraint_OmitOnFailure();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.tests.framework.exceptions.TestConstraint#validate(org.eclipse.emf.common.util.EList, org.eclipse.uml2.uml.Class, org.eclipse.emf.common.util.DiagnosticChain) <em>Validate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the '<em>Validate</em>' operation.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.TestConstraint#validate(org.eclipse.emf.common.util.EList, org.eclipse.uml2.uml.Class, org.eclipse.emf.common.util.DiagnosticChain)
	 * @generated
	 */
	EOperation getTestConstraint__Validate__EList_Class_DiagnosticChain();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.tests.framework.exceptions.TestExceptions <em>Test Exceptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Test Exceptions</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.TestExceptions
	 * @generated
	 */
	EClass getTestExceptions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.tests.framework.exceptions.TestExceptions#getConstraints <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Constraint</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.TestExceptions#getConstraints()
	 * @see #getTestExceptions()
	 * @generated
	 */
	EReference getTestExceptions_Constraint();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.tests.framework.exceptions.TestExceptions#validate(org.eclipse.emf.common.util.EList, org.eclipse.uml2.uml.Class, org.eclipse.emf.common.util.DiagnosticChain) <em>Validate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the '<em>Validate</em>' operation.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.TestExceptions#validate(org.eclipse.emf.common.util.EList, org.eclipse.uml2.uml.Class, org.eclipse.emf.common.util.DiagnosticChain)
	 * @generated
	 */
	EOperation getTestExceptions__Validate__EList_Class_DiagnosticChain();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec <em>Edit Part Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Edit Part Spec</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec
	 * @generated
	 */
	EClass getEditPartSpec();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec#getComposite <em>Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the container reference '<em>Composite</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec#getComposite()
	 * @see #getEditPartSpec()
	 * @generated
	 */
	EReference getEditPartSpec_Composite();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec#matches(org.eclipse.uml2.uml.InstanceSpecification) <em>Matches</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the '<em>Matches</em>' operation.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec#matches(org.eclipse.uml2.uml.InstanceSpecification)
	 * @generated
	 */
	EOperation getEditPartSpec__Matches__InstanceSpecification();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.tests.framework.exceptions.CompositeEditPartSpec <em>Composite Edit Part Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Composite Edit Part Spec</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.CompositeEditPartSpec
	 * @generated
	 */
	EClass getCompositeEditPartSpec();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.tests.framework.exceptions.CompositeEditPartSpec#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.CompositeEditPartSpec#getOperator()
	 * @see #getCompositeEditPartSpec()
	 * @generated
	 */
	EAttribute getCompositeEditPartSpec_Operator();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.tests.framework.exceptions.CompositeEditPartSpec#getOperands <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Operand</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.CompositeEditPartSpec#getOperands()
	 * @see #getCompositeEditPartSpec()
	 * @generated
	 */
	EReference getCompositeEditPartSpec_Operand();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.tests.framework.exceptions.EditPartRef <em>Edit Part Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Edit Part Ref</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.EditPartRef
	 * @generated
	 */
	EClass getEditPartRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.tests.framework.exceptions.EditPartRef#getEditPart <em>Edit Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference '<em>Edit Part</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.EditPartRef#getEditPart()
	 * @see #getEditPartRef()
	 * @generated
	 */
	EReference getEditPartRef_EditPart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.tests.framework.exceptions.AnyEditPart <em>Any Edit Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Any Edit Part</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.AnyEditPart
	 * @generated
	 */
	EClass getAnyEditPart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPart <em>Forbidden Edit Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Forbidden Edit Part</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPart
	 * @generated
	 */
	EClass getForbiddenEditPart();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPart#getEditPart <em>Edit Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference '<em>Edit Part</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPart#getEditPart()
	 * @see #getForbiddenEditPart()
	 * @generated
	 */
	EReference getForbiddenEditPart_EditPart();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPart#getReason <em>Reason</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Reason</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPart#getReason()
	 * @see #getForbiddenEditPart()
	 * @generated
	 */
	EAttribute getForbiddenEditPart_Reason();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPart#getReasonKind <em>Reason Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Reason Kind</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPart#getReasonKind()
	 * @see #getForbiddenEditPart()
	 * @generated
	 */
	EAttribute getForbiddenEditPart_ReasonKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenReasonKind <em>Forbidden Reason Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for enum '<em>Forbidden Reason Kind</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ForbiddenReasonKind
	 * @generated
	 */
	EEnum getForbiddenReasonKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.tests.framework.exceptions.OperatorKind <em>Operator Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for enum '<em>Operator Kind</em>'.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.OperatorKind
	 * @generated
	 */
	EEnum getOperatorKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExceptionsFactory getExceptionsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each operation of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.tests.framework.exceptions.impl.ForbiddenEditPartPermutationImpl <em>Forbidden Edit Part Permutation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ForbiddenEditPartPermutationImpl
		 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ExceptionsPackageImpl#getForbiddenEditPartPermutation()
		 * @generated
		 */
		EClass FORBIDDEN_EDIT_PART_PERMUTATION = eINSTANCE.getForbiddenEditPartPermutation();

		/**
		 * The meta object literal for the '<em><b>Edit Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference FORBIDDEN_EDIT_PART_PERMUTATION__EDIT_PART = eINSTANCE.getForbiddenEditPartPermutation_EditPart();

		/**
		 * The meta object literal for the '<em><b>Reason Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute FORBIDDEN_EDIT_PART_PERMUTATION__REASON_KIND = eINSTANCE.getForbiddenEditPartPermutation_ReasonKind();

		/**
		 * The meta object literal for the '<em><b>Reason</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute FORBIDDEN_EDIT_PART_PERMUTATION__REASON = eINSTANCE.getForbiddenEditPartPermutation_Reason();

		/**
		 * The meta object literal for the '<em><b>Test Class</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference FORBIDDEN_EDIT_PART_PERMUTATION__TEST_CLASS = eINSTANCE.getForbiddenEditPartPermutation_TestClass();

		/**
		 * The meta object literal for the '<em><b>Test classes</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EOperation FORBIDDEN_EDIT_PART_PERMUTATION___TEST_CLASSES__DIAGNOSTICCHAIN_MAP = eINSTANCE.getForbiddenEditPartPermutation__Test_classes__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.tests.framework.exceptions.impl.TestConstraintImpl <em>Test Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.TestConstraintImpl
		 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ExceptionsPackageImpl#getTestConstraint()
		 * @generated
		 */
		EClass TEST_CONSTRAINT = eINSTANCE.getTestConstraint();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference TEST_CONSTRAINT__CONTAINER = eINSTANCE.getTestConstraint_Container();

		/**
		 * The meta object literal for the '<em><b>Omit On Failure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute TEST_CONSTRAINT__OMIT_ON_FAILURE = eINSTANCE.getTestConstraint_OmitOnFailure();

		/**
		 * The meta object literal for the '<em><b>Validate</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EOperation TEST_CONSTRAINT___VALIDATE__ELIST_CLASS_DIAGNOSTICCHAIN = eINSTANCE.getTestConstraint__Validate__EList_Class_DiagnosticChain();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.tests.framework.exceptions.impl.TestExceptionsImpl <em>Test Exceptions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.TestExceptionsImpl
		 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ExceptionsPackageImpl#getTestExceptions()
		 * @generated
		 */
		EClass TEST_EXCEPTIONS = eINSTANCE.getTestExceptions();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference TEST_EXCEPTIONS__CONSTRAINT = eINSTANCE.getTestExceptions_Constraint();

		/**
		 * The meta object literal for the '<em><b>Validate</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EOperation TEST_EXCEPTIONS___VALIDATE__ELIST_CLASS_DIAGNOSTICCHAIN = eINSTANCE.getTestExceptions__Validate__EList_Class_DiagnosticChain();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.tests.framework.exceptions.impl.EditPartSpecImpl <em>Edit Part Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.EditPartSpecImpl
		 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ExceptionsPackageImpl#getEditPartSpec()
		 * @generated
		 */
		EClass EDIT_PART_SPEC = eINSTANCE.getEditPartSpec();

		/**
		 * The meta object literal for the '<em><b>Composite</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference EDIT_PART_SPEC__COMPOSITE = eINSTANCE.getEditPartSpec_Composite();

		/**
		 * The meta object literal for the '<em><b>Matches</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EOperation EDIT_PART_SPEC___MATCHES__INSTANCESPECIFICATION = eINSTANCE.getEditPartSpec__Matches__InstanceSpecification();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.tests.framework.exceptions.impl.CompositeEditPartSpecImpl <em>Composite Edit Part Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.CompositeEditPartSpecImpl
		 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ExceptionsPackageImpl#getCompositeEditPartSpec()
		 * @generated
		 */
		EClass COMPOSITE_EDIT_PART_SPEC = eINSTANCE.getCompositeEditPartSpec();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute COMPOSITE_EDIT_PART_SPEC__OPERATOR = eINSTANCE.getCompositeEditPartSpec_Operator();

		/**
		 * The meta object literal for the '<em><b>Operand</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference COMPOSITE_EDIT_PART_SPEC__OPERAND = eINSTANCE.getCompositeEditPartSpec_Operand();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.tests.framework.exceptions.impl.EditPartRefImpl <em>Edit Part Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.EditPartRefImpl
		 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ExceptionsPackageImpl#getEditPartRef()
		 * @generated
		 */
		EClass EDIT_PART_REF = eINSTANCE.getEditPartRef();

		/**
		 * The meta object literal for the '<em><b>Edit Part</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference EDIT_PART_REF__EDIT_PART = eINSTANCE.getEditPartRef_EditPart();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.tests.framework.exceptions.impl.AnyEditPartImpl <em>Any Edit Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.AnyEditPartImpl
		 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ExceptionsPackageImpl#getAnyEditPart()
		 * @generated
		 */
		EClass ANY_EDIT_PART = eINSTANCE.getAnyEditPart();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.tests.framework.exceptions.impl.ForbiddenEditPartImpl <em>Forbidden Edit Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ForbiddenEditPartImpl
		 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ExceptionsPackageImpl#getForbiddenEditPart()
		 * @generated
		 */
		EClass FORBIDDEN_EDIT_PART = eINSTANCE.getForbiddenEditPart();

		/**
		 * The meta object literal for the '<em><b>Edit Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference FORBIDDEN_EDIT_PART__EDIT_PART = eINSTANCE.getForbiddenEditPart_EditPart();

		/**
		 * The meta object literal for the '<em><b>Reason</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute FORBIDDEN_EDIT_PART__REASON = eINSTANCE.getForbiddenEditPart_Reason();

		/**
		 * The meta object literal for the '<em><b>Reason Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute FORBIDDEN_EDIT_PART__REASON_KIND = eINSTANCE.getForbiddenEditPart_ReasonKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenReasonKind <em>Forbidden Reason Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.tests.framework.exceptions.ForbiddenReasonKind
		 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ExceptionsPackageImpl#getForbiddenReasonKind()
		 * @generated
		 */
		EEnum FORBIDDEN_REASON_KIND = eINSTANCE.getForbiddenReasonKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.tests.framework.exceptions.OperatorKind <em>Operator Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.tests.framework.exceptions.OperatorKind
		 * @see org.eclipse.papyrus.tests.framework.exceptions.impl.ExceptionsPackageImpl#getOperatorKind()
		 * @generated
		 */
		EEnum OPERATOR_KIND = eINSTANCE.getOperatorKind();

	}

} // ExceptionsPackage
