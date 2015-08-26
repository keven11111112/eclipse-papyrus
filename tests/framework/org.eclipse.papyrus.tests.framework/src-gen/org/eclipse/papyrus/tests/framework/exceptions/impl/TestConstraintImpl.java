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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage;
import org.eclipse.papyrus.tests.framework.exceptions.TestConstraint;
import org.eclipse.papyrus.tests.framework.exceptions.TestExceptions;

import org.eclipse.papyrus.tests.framework.internal.exceptions.operations.TestConstraintOperations;

import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.impl.TestConstraintImpl#getContainer <em>Container</em>}</li>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.impl.TestConstraintImpl#isOmitOnFailure <em>Omit On Failure</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TestConstraintImpl extends TestExceptionsObject implements TestConstraint {
	/**
	 * The default value of the '{@link #isOmitOnFailure() <em>Omit On Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isOmitOnFailure()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OMIT_ON_FAILURE_EDEFAULT = false;
	/**
	 * The flag representing the value of the '{@link #isOmitOnFailure() <em>Omit On Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isOmitOnFailure()
	 * @generated
	 * @ordered
	 */
	protected static final int OMIT_ON_FAILURE_EFLAG = 1 << 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected TestConstraintImpl() {
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
		return ExceptionsPackage.Literals.TEST_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public TestExceptions getContainer() {
		if (eContainerFeatureID() != ExceptionsPackage.TEST_CONSTRAINT__CONTAINER) {
			return null;
		}
		return (TestExceptions) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetContainer(TestExceptions newContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newContainer, ExceptionsPackage.TEST_CONSTRAINT__CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setContainer(TestExceptions newContainer) {
		if (newContainer != eInternalContainer() || (eContainerFeatureID() != ExceptionsPackage.TEST_CONSTRAINT__CONTAINER && newContainer != null)) {
			if (EcoreUtil.isAncestor(this, newContainer)) {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newContainer != null) {
				msgs = ((InternalEObject) newContainer).eInverseAdd(this, ExceptionsPackage.TEST_EXCEPTIONS__CONSTRAINT, TestExceptions.class, msgs);
			}
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ExceptionsPackage.TEST_CONSTRAINT__CONTAINER, newContainer, newContainer));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean isOmitOnFailure() {
		return (eFlags & OMIT_ON_FAILURE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setOmitOnFailure(boolean newOmitOnFailure) {
		boolean oldOmitOnFailure = (eFlags & OMIT_ON_FAILURE_EFLAG) != 0;
		if (newOmitOnFailure) {
			eFlags |= OMIT_ON_FAILURE_EFLAG;
		} else {
			eFlags &= ~OMIT_ON_FAILURE_EFLAG;
		}
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ExceptionsPackage.TEST_CONSTRAINT__OMIT_ON_FAILURE, oldOmitOnFailure, newOmitOnFailure));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean validate(EList<InstanceSpecification> editPart, org.eclipse.uml2.uml.Class testClass, DiagnosticChain diagnostics) {
		return TestConstraintOperations.validate(this, editPart, testClass, diagnostics);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ExceptionsPackage.TEST_CONSTRAINT__CONTAINER:
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			return basicSetContainer((TestExceptions) otherEnd, msgs);
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
		case ExceptionsPackage.TEST_CONSTRAINT__CONTAINER:
			return basicSetContainer(null, msgs);
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case ExceptionsPackage.TEST_CONSTRAINT__CONTAINER:
			return eInternalContainer().eInverseRemove(this, ExceptionsPackage.TEST_EXCEPTIONS__CONSTRAINT, TestExceptions.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
		case ExceptionsPackage.TEST_CONSTRAINT__CONTAINER:
			return getContainer();
		case ExceptionsPackage.TEST_CONSTRAINT__OMIT_ON_FAILURE:
			return isOmitOnFailure();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ExceptionsPackage.TEST_CONSTRAINT__CONTAINER:
			setContainer((TestExceptions) newValue);
			return;
		case ExceptionsPackage.TEST_CONSTRAINT__OMIT_ON_FAILURE:
			setOmitOnFailure((Boolean) newValue);
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
		case ExceptionsPackage.TEST_CONSTRAINT__CONTAINER:
			setContainer((TestExceptions) null);
			return;
		case ExceptionsPackage.TEST_CONSTRAINT__OMIT_ON_FAILURE:
			setOmitOnFailure(OMIT_ON_FAILURE_EDEFAULT);
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
		case ExceptionsPackage.TEST_CONSTRAINT__CONTAINER:
			return getContainer() != null;
		case ExceptionsPackage.TEST_CONSTRAINT__OMIT_ON_FAILURE:
			return ((eFlags & OMIT_ON_FAILURE_EFLAG) != 0) != OMIT_ON_FAILURE_EDEFAULT;
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
		case ExceptionsPackage.TEST_CONSTRAINT___VALIDATE__ELIST_CLASS_DIAGNOSTICCHAIN:
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
		result.append(" (omitOnFailure: ");
		result.append((eFlags & OMIT_ON_FAILURE_EFLAG) != 0);
		result.append(')');
		return result.toString();
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

} // TestConstraintImpl
