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

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage;
import org.eclipse.papyrus.tests.framework.exceptions.TestConstraint;
import org.eclipse.papyrus.tests.framework.exceptions.TestExceptions;
import org.eclipse.papyrus.tests.framework.internal.exceptions.operations.TestExceptionsOperations;
import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Exceptions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.impl.TestExceptionsImpl#getConstraints <em>Constraint</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestExceptionsImpl extends TestExceptionsObject implements TestExceptions {
	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraint</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<TestConstraint> constraints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected TestExceptionsImpl() {
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
		return ExceptionsPackage.Literals.TEST_EXCEPTIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<TestConstraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentWithInverseEList<TestConstraint>(TestConstraint.class, this, ExceptionsPackage.TEST_EXCEPTIONS__CONSTRAINT, ExceptionsPackage.TEST_CONSTRAINT__CONTAINER);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public TestConstraint createConstraint(EClass eClass) {
		TestConstraint newConstraint = (TestConstraint) create(eClass);
		getConstraints().add(newConstraint);
		return newConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean validate(EList<InstanceSpecification> editPart, org.eclipse.uml2.uml.Class testClass, DiagnosticChain diagnostics) {
		return TestExceptionsOperations.validate(this, editPart, testClass, diagnostics);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ExceptionsPackage.TEST_EXCEPTIONS__CONSTRAINT:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getConstraints()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
		case ExceptionsPackage.TEST_EXCEPTIONS__CONSTRAINT:
			return ((InternalEList<?>) getConstraints()).basicRemove(otherEnd, msgs);
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
		case ExceptionsPackage.TEST_EXCEPTIONS__CONSTRAINT:
			return getConstraints();
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
		case ExceptionsPackage.TEST_EXCEPTIONS__CONSTRAINT:
			getConstraints().clear();
			getConstraints().addAll((Collection<? extends TestConstraint>) newValue);
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
		case ExceptionsPackage.TEST_EXCEPTIONS__CONSTRAINT:
			getConstraints().clear();
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
		case ExceptionsPackage.TEST_EXCEPTIONS__CONSTRAINT:
			return constraints != null && !constraints.isEmpty();
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
		case ExceptionsPackage.TEST_EXCEPTIONS___VALIDATE__ELIST_CLASS_DIAGNOSTICCHAIN:
			return validate((EList<InstanceSpecification>) arguments.get(0), (org.eclipse.uml2.uml.Class) arguments.get(1), (DiagnosticChain) arguments.get(2));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * Creates a new instance of the specified Ecore class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param eClass
	 *            The Ecore class of the instance to create.
	 * @return The new instance.
	 * @generated
	 */
	protected EObject create(EClass eClass) {
		return EcoreUtil.create(eClass);
	}

} // TestExceptionsImpl
