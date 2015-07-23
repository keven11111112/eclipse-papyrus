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
package org.eclipse.papyrus.tests.framework.internal.exceptions.operations;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.tests.framework.exceptions.TestConstraint;
import org.eclipse.papyrus.tests.framework.exceptions.TestExceptions;
import org.eclipse.uml2.uml.InstanceSpecification;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Test Exceptions</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.TestExceptions#validate(org.eclipse.emf.common.util.EList, org.eclipse.uml2.uml.Class, org.eclipse.emf.common.util.DiagnosticChain) <em>Validate</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestExceptionsOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected TestExceptionsOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static boolean validate(TestExceptions testExceptions, final EList<InstanceSpecification> editPart, final org.eclipse.uml2.uml.Class testClass, final DiagnosticChain diagnostics) {
		return testExceptions.getConstraints().isEmpty() || Iterables.all(testExceptions.getConstraints(), new Predicate<TestConstraint>() {
			@Override
			public boolean apply(TestConstraint input) {
				return input.validate(editPart, testClass, diagnostics);
			}
		});
	}

} // TestExceptionsOperations
