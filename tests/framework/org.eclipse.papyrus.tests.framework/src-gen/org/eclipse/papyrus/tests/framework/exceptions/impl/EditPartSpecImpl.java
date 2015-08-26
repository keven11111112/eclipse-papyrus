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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.papyrus.tests.framework.exceptions.CompositeEditPartSpec;
import org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec;
import org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage;
import org.eclipse.papyrus.tests.framework.internal.exceptions.operations.EditPartSpecOperations;

import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edit Part Spec</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.impl.EditPartSpecImpl#getComposite <em>Composite</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class EditPartSpecImpl extends TestExceptionsObject implements EditPartSpec {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected EditPartSpecImpl() {
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
		return ExceptionsPackage.Literals.EDIT_PART_SPEC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public CompositeEditPartSpec getComposite() {
		if (eContainerFeatureID() != ExceptionsPackage.EDIT_PART_SPEC__COMPOSITE) {
			return null;
		}
		return (CompositeEditPartSpec) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetComposite(CompositeEditPartSpec newComposite, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newComposite, ExceptionsPackage.EDIT_PART_SPEC__COMPOSITE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setComposite(CompositeEditPartSpec newComposite) {
		if (newComposite != eInternalContainer() || (eContainerFeatureID() != ExceptionsPackage.EDIT_PART_SPEC__COMPOSITE && newComposite != null)) {
			if (EcoreUtil.isAncestor(this, newComposite)) {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newComposite != null) {
				msgs = ((InternalEObject) newComposite).eInverseAdd(this, ExceptionsPackage.COMPOSITE_EDIT_PART_SPEC__OPERAND, CompositeEditPartSpec.class, msgs);
			}
			msgs = basicSetComposite(newComposite, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ExceptionsPackage.EDIT_PART_SPEC__COMPOSITE, newComposite, newComposite));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean matches(InstanceSpecification editPart) {
		return EditPartSpecOperations.matches(this, editPart);
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
		case ExceptionsPackage.EDIT_PART_SPEC__COMPOSITE:
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			return basicSetComposite((CompositeEditPartSpec) otherEnd, msgs);
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
		case ExceptionsPackage.EDIT_PART_SPEC__COMPOSITE:
			return basicSetComposite(null, msgs);
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
		case ExceptionsPackage.EDIT_PART_SPEC__COMPOSITE:
			return eInternalContainer().eInverseRemove(this, ExceptionsPackage.COMPOSITE_EDIT_PART_SPEC__OPERAND, CompositeEditPartSpec.class, msgs);
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
		case ExceptionsPackage.EDIT_PART_SPEC__COMPOSITE:
			return getComposite();
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
		case ExceptionsPackage.EDIT_PART_SPEC__COMPOSITE:
			setComposite((CompositeEditPartSpec) newValue);
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
		case ExceptionsPackage.EDIT_PART_SPEC__COMPOSITE:
			setComposite((CompositeEditPartSpec) null);
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
		case ExceptionsPackage.EDIT_PART_SPEC__COMPOSITE:
			return getComposite() != null;
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case ExceptionsPackage.EDIT_PART_SPEC___MATCHES__INSTANCESPECIFICATION:
			return matches((InstanceSpecification) arguments.get(0));
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

} // EditPartSpecImpl
