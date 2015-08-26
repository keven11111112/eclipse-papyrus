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
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec;
import org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage;
import org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPart;
import org.eclipse.papyrus.tests.framework.exceptions.ForbiddenReasonKind;

import org.eclipse.papyrus.tests.framework.internal.exceptions.operations.ForbiddenEditPartOperations;

import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Forbidden Edit Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.impl.ForbiddenEditPartImpl#getEditPart <em>Edit Part</em>}</li>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.impl.ForbiddenEditPartImpl#getReason <em>Reason</em>}</li>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.impl.ForbiddenEditPartImpl#getReasonKind <em>Reason Kind</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForbiddenEditPartImpl extends TestConstraintImpl implements ForbiddenEditPart {
	/**
	 * The cached value of the '{@link #getEditPart() <em>Edit Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getEditPart()
	 * @generated
	 * @ordered
	 */
	protected EditPartSpec editPart;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ForbiddenEditPartImpl() {
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
		return ExceptionsPackage.Literals.FORBIDDEN_EDIT_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EditPartSpec getEditPart() {
		return editPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetEditPart(EditPartSpec newEditPart, NotificationChain msgs) {
		EditPartSpec oldEditPart = editPart;
		editPart = newEditPart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExceptionsPackage.FORBIDDEN_EDIT_PART__EDIT_PART, oldEditPart, newEditPart);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setEditPart(EditPartSpec newEditPart) {
		if (newEditPart != editPart) {
			NotificationChain msgs = null;
			if (editPart != null) {
				msgs = ((InternalEObject) editPart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExceptionsPackage.FORBIDDEN_EDIT_PART__EDIT_PART, null, msgs);
			}
			if (newEditPart != null) {
				msgs = ((InternalEObject) newEditPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExceptionsPackage.FORBIDDEN_EDIT_PART__EDIT_PART, null, msgs);
			}
			msgs = basicSetEditPart(newEditPart, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ExceptionsPackage.FORBIDDEN_EDIT_PART__EDIT_PART, newEditPart, newEditPart));
		}
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
		setEditPart(newEditPart);
		return newEditPart;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExceptionsPackage.FORBIDDEN_EDIT_PART__REASON, oldReason, reason));
		}
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExceptionsPackage.FORBIDDEN_EDIT_PART__REASON_KIND, oldReasonKind, reasonKind));
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
		return ForbiddenEditPartOperations.validate(this, editPart, testClass, diagnostics);
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
		case ExceptionsPackage.FORBIDDEN_EDIT_PART__EDIT_PART:
			return basicSetEditPart(null, msgs);
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
		case ExceptionsPackage.FORBIDDEN_EDIT_PART__EDIT_PART:
			return getEditPart();
		case ExceptionsPackage.FORBIDDEN_EDIT_PART__REASON:
			return getReason();
		case ExceptionsPackage.FORBIDDEN_EDIT_PART__REASON_KIND:
			return getReasonKind();
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
		case ExceptionsPackage.FORBIDDEN_EDIT_PART__EDIT_PART:
			setEditPart((EditPartSpec) newValue);
			return;
		case ExceptionsPackage.FORBIDDEN_EDIT_PART__REASON:
			setReason((String) newValue);
			return;
		case ExceptionsPackage.FORBIDDEN_EDIT_PART__REASON_KIND:
			setReasonKind((ForbiddenReasonKind) newValue);
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
		case ExceptionsPackage.FORBIDDEN_EDIT_PART__EDIT_PART:
			setEditPart((EditPartSpec) null);
			return;
		case ExceptionsPackage.FORBIDDEN_EDIT_PART__REASON:
			setReason(REASON_EDEFAULT);
			return;
		case ExceptionsPackage.FORBIDDEN_EDIT_PART__REASON_KIND:
			setReasonKind(REASON_KIND_EDEFAULT);
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
		case ExceptionsPackage.FORBIDDEN_EDIT_PART__EDIT_PART:
			return editPart != null;
		case ExceptionsPackage.FORBIDDEN_EDIT_PART__REASON:
			return REASON_EDEFAULT == null ? reason != null : !REASON_EDEFAULT.equals(reason);
		case ExceptionsPackage.FORBIDDEN_EDIT_PART__REASON_KIND:
			return reasonKind != REASON_KIND_EDEFAULT;
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
		case ExceptionsPackage.FORBIDDEN_EDIT_PART___VALIDATE__ELIST_CLASS_DIAGNOSTICCHAIN:
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
		result.append(" (reason: ");
		result.append(reason);
		result.append(", reasonKind: ");
		result.append(reasonKind);
		result.append(')');
		return result.toString();
	}

} // ForbiddenEditPartImpl
