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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.tests.framework.exceptions.CompositeEditPartSpec;
import org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec;
import org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage;
import org.eclipse.papyrus.tests.framework.exceptions.OperatorKind;
import org.eclipse.papyrus.tests.framework.internal.exceptions.operations.CompositeEditPartSpecOperations;
import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Edit Part Spec</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.impl.CompositeEditPartSpecImpl#getOperator <em>Operator</em>}</li>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.impl.CompositeEditPartSpecImpl#getOperands <em>Operand</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompositeEditPartSpecImpl extends EditPartSpecImpl implements CompositeEditPartSpec {
	/**
	 * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected static final OperatorKind OPERATOR_EDEFAULT = OperatorKind.AND;

	/**
	 * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected OperatorKind operator = OPERATOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOperands() <em>Operand</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getOperands()
	 * @generated
	 * @ordered
	 */
	protected EList<EditPartSpec> operands;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected CompositeEditPartSpecImpl() {
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
		return ExceptionsPackage.Literals.COMPOSITE_EDIT_PART_SPEC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public OperatorKind getOperator() {
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setOperator(OperatorKind newOperator) {
		OperatorKind oldOperator = operator;
		operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ExceptionsPackage.COMPOSITE_EDIT_PART_SPEC__OPERATOR, oldOperator, operator));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<EditPartSpec> getOperands() {
		if (operands == null) {
			operands = new EObjectContainmentWithInverseEList<EditPartSpec>(EditPartSpec.class, this, ExceptionsPackage.COMPOSITE_EDIT_PART_SPEC__OPERAND, ExceptionsPackage.EDIT_PART_SPEC__COMPOSITE);
		}
		return operands;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EditPartSpec createOperand(EClass eClass) {
		EditPartSpec newOperand = (EditPartSpec) create(eClass);
		getOperands().add(newOperand);
		return newOperand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean matches(InstanceSpecification editPart) {
		return CompositeEditPartSpecOperations.matches(this, editPart);
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
		case ExceptionsPackage.COMPOSITE_EDIT_PART_SPEC__OPERAND:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOperands()).basicAdd(otherEnd, msgs);
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
		case ExceptionsPackage.COMPOSITE_EDIT_PART_SPEC__OPERAND:
			return ((InternalEList<?>) getOperands()).basicRemove(otherEnd, msgs);
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
		case ExceptionsPackage.COMPOSITE_EDIT_PART_SPEC__OPERATOR:
			return getOperator();
		case ExceptionsPackage.COMPOSITE_EDIT_PART_SPEC__OPERAND:
			return getOperands();
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
		case ExceptionsPackage.COMPOSITE_EDIT_PART_SPEC__OPERATOR:
			setOperator((OperatorKind) newValue);
			return;
		case ExceptionsPackage.COMPOSITE_EDIT_PART_SPEC__OPERAND:
			getOperands().clear();
			getOperands().addAll((Collection<? extends EditPartSpec>) newValue);
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
		case ExceptionsPackage.COMPOSITE_EDIT_PART_SPEC__OPERATOR:
			setOperator(OPERATOR_EDEFAULT);
			return;
		case ExceptionsPackage.COMPOSITE_EDIT_PART_SPEC__OPERAND:
			getOperands().clear();
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
		case ExceptionsPackage.COMPOSITE_EDIT_PART_SPEC__OPERATOR:
			return operator != OPERATOR_EDEFAULT;
		case ExceptionsPackage.COMPOSITE_EDIT_PART_SPEC__OPERAND:
			return operands != null && !operands.isEmpty();
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
		case ExceptionsPackage.COMPOSITE_EDIT_PART_SPEC___MATCHES__INSTANCESPECIFICATION:
			return matches((InstanceSpecification) arguments.get(0));
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
		result.append(" (operator: ");
		result.append(operator);
		result.append(')');
		return result.toString();
	}

} // CompositeEditPartSpecImpl
