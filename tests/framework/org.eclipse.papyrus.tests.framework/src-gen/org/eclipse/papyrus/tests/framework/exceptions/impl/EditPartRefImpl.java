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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.papyrus.tests.framework.exceptions.EditPartRef;
import org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage;
import org.eclipse.papyrus.tests.framework.internal.exceptions.operations.EditPartRefOperations;
import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edit Part Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.impl.EditPartRefImpl#getEditPart <em>Edit Part</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EditPartRefImpl extends EditPartSpecImpl implements EditPartRef {
	/**
	 * The cached value of the '{@link #getEditPart() <em>Edit Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getEditPart()
	 * @generated
	 * @ordered
	 */
	protected GenCommonBase editPart;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected EditPartRefImpl() {
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
		return ExceptionsPackage.Literals.EDIT_PART_REF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public GenCommonBase getEditPart() {
		if (editPart != null && editPart.eIsProxy()) {
			InternalEObject oldEditPart = (InternalEObject) editPart;
			editPart = (GenCommonBase) eResolveProxy(oldEditPart);
			if (editPart != oldEditPart) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExceptionsPackage.EDIT_PART_REF__EDIT_PART, oldEditPart, editPart));
				}
			}
		}
		return editPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public GenCommonBase basicGetEditPart() {
		return editPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setEditPart(GenCommonBase newEditPart) {
		GenCommonBase oldEditPart = editPart;
		editPart = newEditPart;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ExceptionsPackage.EDIT_PART_REF__EDIT_PART, oldEditPart, editPart));
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
		return EditPartRefOperations.matches(this, editPart);
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
		case ExceptionsPackage.EDIT_PART_REF__EDIT_PART:
			if (resolve) {
				return getEditPart();
			}
			return basicGetEditPart();
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
		case ExceptionsPackage.EDIT_PART_REF__EDIT_PART:
			setEditPart((GenCommonBase) newValue);
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
		case ExceptionsPackage.EDIT_PART_REF__EDIT_PART:
			setEditPart((GenCommonBase) null);
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
		case ExceptionsPackage.EDIT_PART_REF__EDIT_PART:
			return editPart != null;
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
		case ExceptionsPackage.EDIT_PART_REF___MATCHES__INSTANCESPECIFICATION:
			return matches((InstanceSpecification) arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} // EditPartRefImpl
