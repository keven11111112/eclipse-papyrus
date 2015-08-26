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

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec;
import org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage;
import org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation;
import org.eclipse.papyrus.tests.framework.exceptions.ForbiddenReasonKind;

import org.eclipse.papyrus.tests.framework.exceptions.util.ExceptionsValidator;
import org.eclipse.papyrus.tests.framework.internal.exceptions.operations.ForbiddenEditPartPermutationOperations;
import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Forbidden Edit Part Permutation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.impl.ForbiddenEditPartPermutationImpl#getReasonKind <em>Reason Kind</em>}</li>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.impl.ForbiddenEditPartPermutationImpl#getReason <em>Reason</em>}</li>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.impl.ForbiddenEditPartPermutationImpl#getTestClasses <em>Test Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.impl.ForbiddenEditPartPermutationImpl#getEditParts <em>Edit Part</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForbiddenEditPartPermutationImpl extends TestConstraintImpl implements ForbiddenEditPartPermutation {
	/**
	 * The default value of the '{@link #getReasonKind() <em>Reason Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getReasonKind()
	 * @generated
	 * @ordered
	 */
	protected static final ForbiddenReasonKind REASON_KIND_EDEFAULT = ForbiddenReasonKind.INVALID;

	/**
	 * The cached value of the '{@link #getReasonKind() <em>Reason Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getReasonKind()
	 * @generated
	 * @ordered
	 */
	protected ForbiddenReasonKind reasonKind = REASON_KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getReason() <em>Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getReason()
	 * @generated
	 * @ordered
	 */
	protected static final String REASON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReason() <em>Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getReason()
	 * @generated
	 * @ordered
	 */
	protected String reason = REASON_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTestClasses() <em>Test Class</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getTestClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.uml2.uml.Class> testClasses;

	/**
	 * The cached value of the '{@link #getEditParts() <em>Edit Part</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getEditParts()
	 * @generated
	 * @ordered
	 */
	protected EList<EditPartSpec> editParts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ForbiddenEditPartPermutationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExceptionsPackage.Literals.FORBIDDEN_EDIT_PART_PERMUTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<EditPartSpec> getEditParts() {
		if (editParts == null) {
			editParts = new EObjectContainmentEList<EditPartSpec>(EditPartSpec.class, this, ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__EDIT_PART);
		}
		return editParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EditPartSpec createEditPart(EClass eClass) {
		EditPartSpec newEditPart = (EditPartSpec) create(eClass);
		getEditParts().add(newEditPart);
		return newEditPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ForbiddenReasonKind getReasonKind() {
		return reasonKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setReasonKind(ForbiddenReasonKind newReasonKind) {
		ForbiddenReasonKind oldReasonKind = reasonKind;
		reasonKind = newReasonKind == null ? REASON_KIND_EDEFAULT : newReasonKind;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__REASON_KIND, oldReasonKind, reasonKind));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getReason() {
		return reason;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setReason(String newReason) {
		String oldReason = reason;
		reason = newReason;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__REASON, oldReason, reason));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<org.eclipse.uml2.uml.Class> getTestClasses() {
		if (testClasses == null) {
			testClasses = new EObjectResolvingEList<org.eclipse.uml2.uml.Class>(org.eclipse.uml2.uml.Class.class, this, ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__TEST_CLASS);
		}
		return testClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public org.eclipse.uml2.uml.Class getTestClass(String name) {
		return getTestClass(name, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public org.eclipse.uml2.uml.Class getTestClass(String name, boolean ignoreCase, EClass eClass) {
		testClassLoop: for (org.eclipse.uml2.uml.Class testClass : getTestClasses()) {
			if (eClass != null && !eClass.isInstance(testClass)) {
				continue testClassLoop;
			}
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(testClass.getName()) : name.equals(testClass.getName()))) {
				continue testClassLoop;
			}
			return testClass;
		}
		return null;
	}

	/**
	 * The cached validation expression for the '{@link #test_classes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Test classes</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #test_classes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String TEST_CLASSES_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION = "testClass->forAll(conformsTo(_'org.eclipse.papyrus.uml.diagram.tests'::AbstractPapyrusTestCase.oclAsType(UML::Type)))";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean test_classes(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return ExceptionsValidator.validate(ExceptionsPackage.Literals.FORBIDDEN_EDIT_PART_PERMUTATION,
				this,
				diagnostics,
				context,
				"http://www.eclipse.org/emf/2002/Ecore/OCL",
				ExceptionsPackage.Literals.FORBIDDEN_EDIT_PART_PERMUTATION___TEST_CLASSES__DIAGNOSTICCHAIN_MAP,
				TEST_CLASSES_DIAGNOSTIC_CHAIN_MAP__EEXPRESSION,
				Diagnostic.ERROR,
				ExceptionsValidator.DIAGNOSTIC_SOURCE,
				ExceptionsValidator.FORBIDDEN_EDIT_PART_PERMUTATION__TEST_CLASSES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean validate(EList<InstanceSpecification> editPart, org.eclipse.uml2.uml.Class testClass, DiagnosticChain diagnostics) {
		return ForbiddenEditPartPermutationOperations.validate(this, editPart, testClass, diagnostics);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__EDIT_PART:
			return ((InternalEList<?>) getEditParts()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__REASON_KIND:
			return getReasonKind();
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__REASON:
			return getReason();
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__TEST_CLASS:
			return getTestClasses();
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__EDIT_PART:
			return getEditParts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__REASON_KIND:
			setReasonKind((ForbiddenReasonKind) newValue);
			return;
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__REASON:
			setReason((String) newValue);
			return;
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__TEST_CLASS:
			getTestClasses().clear();
			getTestClasses().addAll((Collection<? extends org.eclipse.uml2.uml.Class>) newValue);
			return;
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__EDIT_PART:
			getEditParts().clear();
			getEditParts().addAll((Collection<? extends EditPartSpec>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__REASON_KIND:
			setReasonKind(REASON_KIND_EDEFAULT);
			return;
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__REASON:
			setReason(REASON_EDEFAULT);
			return;
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__TEST_CLASS:
			getTestClasses().clear();
			return;
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__EDIT_PART:
			getEditParts().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__REASON_KIND:
			return reasonKind != REASON_KIND_EDEFAULT;
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__REASON:
			return REASON_EDEFAULT == null ? reason != null : !REASON_EDEFAULT.equals(reason);
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__TEST_CLASS:
			return testClasses != null && !testClasses.isEmpty();
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION__EDIT_PART:
			return editParts != null && !editParts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION___TEST_CLASSES__DIAGNOSTICCHAIN_MAP:
			return test_classes((DiagnosticChain) arguments.get(0), (Map<Object, Object>) arguments.get(1));
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION___VALIDATE__ELIST_CLASS_DIAGNOSTICCHAIN:
			return validate((EList<InstanceSpecification>) arguments.get(0), (org.eclipse.uml2.uml.Class) arguments.get(1), (DiagnosticChain) arguments.get(2));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (reasonKind: ");
		result.append(reasonKind);
		result.append(", reason: ");
		result.append(reason);
		result.append(')');
		return result.toString();
	}

} // ForbiddenEditPartPermutationImpl
