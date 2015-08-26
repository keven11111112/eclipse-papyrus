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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.papyrus.tests.framework.exceptions.AnyEditPart;
import org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage;

import org.eclipse.papyrus.tests.framework.internal.exceptions.operations.AnyEditPartOperations;

import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Any Edit Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class AnyEditPartImpl extends EditPartSpecImpl implements AnyEditPart {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected AnyEditPartImpl() {
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
		return ExceptionsPackage.Literals.ANY_EDIT_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean matches(InstanceSpecification editPart) {
		return AnyEditPartOperations.matches(this, editPart);
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
		case ExceptionsPackage.ANY_EDIT_PART___MATCHES__INSTANCESPECIFICATION:
			return matches((InstanceSpecification) arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} // AnyEditPartImpl
