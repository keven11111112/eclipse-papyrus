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

import java.util.Iterator;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPart;
import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Forbidden Edit Part</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPart#validate(org.eclipse.emf.common.util.EList, org.eclipse.uml2.uml.Class, org.eclipse.emf.common.util.DiagnosticChain) <em>Validate</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForbiddenEditPartOperations extends TestConstraintOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ForbiddenEditPartOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static boolean validate(ForbiddenEditPart constraint, EList<InstanceSpecification> editPart, org.eclipse.uml2.uml.Class testClass, DiagnosticChain diagnostics) {
		// Assume OK until proven otherwise
		boolean result = true;

		// The constraint is satisfied if every edit part is not forbidden
		for (Iterator<InstanceSpecification> iter = editPart.iterator(); result && iter.hasNext();) {
			result = !constraint.getEditPart().matches(iter.next());
		}

		if (!result && (diagnostics != null)) {
			diagnostics.add(createDiagnostic(constraint, constraint.getReasonKind(), constraint.getReason(), testClass, editPart));
		}

		return result;
	}

} // ForbiddenEditPartOperations
