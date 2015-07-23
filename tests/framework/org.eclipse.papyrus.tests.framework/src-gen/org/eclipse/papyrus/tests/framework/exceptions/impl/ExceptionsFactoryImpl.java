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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.tests.framework.exceptions.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ExceptionsFactoryImpl extends EFactoryImpl implements ExceptionsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static ExceptionsFactory init() {
		try {
			ExceptionsFactory theExceptionsFactory = (ExceptionsFactory) EPackage.Registry.INSTANCE.getEFactory(ExceptionsPackage.eNS_URI);
			if (theExceptionsFactory != null) {
				return theExceptionsFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExceptionsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ExceptionsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION:
			return createForbiddenEditPartPermutation();
		case ExceptionsPackage.TEST_EXCEPTIONS:
			return createTestExceptions();
		case ExceptionsPackage.COMPOSITE_EDIT_PART_SPEC:
			return createCompositeEditPartSpec();
		case ExceptionsPackage.EDIT_PART_REF:
			return createEditPartRef();
		case ExceptionsPackage.ANY_EDIT_PART:
			return createAnyEditPart();
		case ExceptionsPackage.FORBIDDEN_EDIT_PART:
			return createForbiddenEditPart();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case ExceptionsPackage.FORBIDDEN_REASON_KIND:
			return createForbiddenReasonKindFromString(eDataType, initialValue);
		case ExceptionsPackage.OPERATOR_KIND:
			return createOperatorKindFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case ExceptionsPackage.FORBIDDEN_REASON_KIND:
			return convertForbiddenReasonKindToString(eDataType, instanceValue);
		case ExceptionsPackage.OPERATOR_KIND:
			return convertOperatorKindToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ForbiddenEditPartPermutation createForbiddenEditPartPermutation() {
		ForbiddenEditPartPermutationImpl forbiddenEditPartPermutation = new ForbiddenEditPartPermutationImpl();
		return forbiddenEditPartPermutation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public TestExceptions createTestExceptions() {
		TestExceptionsImpl testExceptions = new TestExceptionsImpl();
		return testExceptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public CompositeEditPartSpec createCompositeEditPartSpec() {
		CompositeEditPartSpecImpl compositeEditPartSpec = new CompositeEditPartSpecImpl();
		return compositeEditPartSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EditPartRef createEditPartRef() {
		EditPartRefImpl editPartRef = new EditPartRefImpl();
		return editPartRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public AnyEditPart createAnyEditPart() {
		AnyEditPartImpl anyEditPart = new AnyEditPartImpl();
		return anyEditPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ForbiddenEditPart createForbiddenEditPart() {
		ForbiddenEditPartImpl forbiddenEditPart = new ForbiddenEditPartImpl();
		return forbiddenEditPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ForbiddenReasonKind createForbiddenReasonKindFromString(EDataType eDataType, String initialValue) {
		ForbiddenReasonKind result = ForbiddenReasonKind.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String convertForbiddenReasonKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public OperatorKind createOperatorKindFromString(EDataType eDataType, String initialValue) {
		OperatorKind result = OperatorKind.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String convertOperatorKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ExceptionsPackage getExceptionsPackage() {
		return (ExceptionsPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExceptionsPackage getPackage() {
		return ExceptionsPackage.eINSTANCE;
	}

} // ExceptionsFactoryImpl
