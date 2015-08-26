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
package org.eclipse.papyrus.tests.framework.exceptions.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.papyrus.tests.framework.exceptions.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage
 * @generated
 */
public class ExceptionsValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final ExceptionsValidator INSTANCE = new ExceptionsValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.papyrus.tests.framework.exceptions";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Test classes' of 'Forbidden Edit Part Permutation'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final int FORBIDDEN_EDIT_PART_PERMUTATION__TEST_CLASSES = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Delegates evaluation of the given invariant expression against the object in the given context.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context, String validationDelegate, EOperation invariant, String expression, int severity, String source, int code) {
		return EObjectValidator.validate(eClass, eObject, diagnostics, context, validationDelegate, invariant, expression, severity, source, code);
	}

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ExceptionsValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
		return ExceptionsPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION:
			return validateForbiddenEditPartPermutation((ForbiddenEditPartPermutation) value, diagnostics, context);
		case ExceptionsPackage.TEST_CONSTRAINT:
			return validateTestConstraint((TestConstraint) value, diagnostics, context);
		case ExceptionsPackage.TEST_EXCEPTIONS:
			return validateTestExceptions((TestExceptions) value, diagnostics, context);
		case ExceptionsPackage.EDIT_PART_SPEC:
			return validateEditPartSpec((EditPartSpec) value, diagnostics, context);
		case ExceptionsPackage.COMPOSITE_EDIT_PART_SPEC:
			return validateCompositeEditPartSpec((CompositeEditPartSpec) value, diagnostics, context);
		case ExceptionsPackage.EDIT_PART_REF:
			return validateEditPartRef((EditPartRef) value, diagnostics, context);
		case ExceptionsPackage.ANY_EDIT_PART:
			return validateAnyEditPart((AnyEditPart) value, diagnostics, context);
		case ExceptionsPackage.FORBIDDEN_EDIT_PART:
			return validateForbiddenEditPart((ForbiddenEditPart) value, diagnostics, context);
		case ExceptionsPackage.FORBIDDEN_REASON_KIND:
			return validateForbiddenReasonKind((ForbiddenReasonKind) value, diagnostics, context);
		case ExceptionsPackage.OPERATOR_KIND:
			return validateOperatorKind((OperatorKind) value, diagnostics, context);
		default:
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateForbiddenEditPartPermutation(ForbiddenEditPartPermutation forbiddenEditPartPermutation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(forbiddenEditPartPermutation, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(forbiddenEditPartPermutation, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(forbiddenEditPartPermutation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(forbiddenEditPartPermutation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(forbiddenEditPartPermutation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(forbiddenEditPartPermutation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(forbiddenEditPartPermutation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(forbiddenEditPartPermutation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(forbiddenEditPartPermutation, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateForbiddenEditPartPermutation_test_classes(forbiddenEditPartPermutation, diagnostics, context);
		}
		return result;
	}

	/**
	 * Validates the test_classes constraint of '<em>Forbidden Edit Part Permutation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateForbiddenEditPartPermutation_test_classes(ForbiddenEditPartPermutation forbiddenEditPartPermutation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return forbiddenEditPartPermutation.test_classes(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateTestConstraint(TestConstraint testConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(testConstraint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateTestExceptions(TestExceptions testExceptions, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(testExceptions, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateEditPartSpec(EditPartSpec editPartSpec, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(editPartSpec, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateCompositeEditPartSpec(CompositeEditPartSpec compositeEditPartSpec, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(compositeEditPartSpec, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateEditPartRef(EditPartRef editPartRef, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(editPartRef, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateAnyEditPart(AnyEditPart anyEditPart, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(anyEditPart, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateForbiddenEditPart(ForbiddenEditPart forbiddenEditPart, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(forbiddenEditPart, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateForbiddenReasonKind(ForbiddenReasonKind forbiddenReasonKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateOperatorKind(OperatorKind operatorKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} // ExceptionsValidator
