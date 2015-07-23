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

import java.util.List;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec;
import org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation;
import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Forbidden Edit Part Permutation</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation#validate(org.eclipse.emf.common.util.EList, org.eclipse.uml2.uml.Class, org.eclipse.emf.common.util.DiagnosticChain) <em>Validate</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForbiddenEditPartPermutationOperations extends TestConstraintOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ForbiddenEditPartPermutationOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static boolean validate(ForbiddenEditPartPermutation constraint, EList<InstanceSpecification> editPart, org.eclipse.uml2.uml.Class testClass, DiagnosticChain diagnostics) {
		boolean result = true; // Assume satisfied until otherwise determined

		for (org.eclipse.uml2.uml.Class next : constraint.getTestClasses()) {
			if (testClass.conformsTo(next)) {
				// Eligible, so far. Check the edit-parts
				List<EditPartSpec> constraintEditParts = constraint.getEditParts();
				if (editPart.size() == constraintEditParts.size()) {
					// Assume the constraint is not satisfied
					result = false;

					for (int i = 0; !result && (i < editPart.size()); i++) {
						// The constraint is satisfied if any one of the edit parts is not forbidden in this permutation
						result = !constraintEditParts.get(i).matches(editPart.get(i));
					}

					if (!result && (diagnostics != null)) {
						diagnostics.add(createDiagnostic(constraint, constraint.getReasonKind(), constraint.getReason(), testClass, editPart));
					}
				}

				break;
			}
		}

		return result;
	}

} // ForbiddenEditPartPermutationOperations
