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

import org.eclipse.papyrus.tests.framework.exceptions.CompositeEditPartSpec;
import org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec;
import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Composite Edit Part Spec</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.CompositeEditPartSpec#matches(org.eclipse.uml2.uml.InstanceSpecification) <em>Matches</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompositeEditPartSpecOperations extends EditPartSpecOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected CompositeEditPartSpecOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static boolean matches(CompositeEditPartSpec compositeEditPartSpec, InstanceSpecification editPart) {
		boolean result;

		switch (compositeEditPartSpec.getOperator()) {
		case AND:
			result = true;
			for (Iterator<EditPartSpec> iter = compositeEditPartSpec.getOperands().iterator(); result && iter.hasNext();) {
				result = iter.next().matches(editPart);
			}
			break;
		case OR:
			result = false;
			for (Iterator<EditPartSpec> iter = compositeEditPartSpec.getOperands().iterator(); !result && iter.hasNext();) {
				result = iter.next().matches(editPart);
			}
			break;
		case NOT:
			result = true;
			for (Iterator<EditPartSpec> iter = compositeEditPartSpec.getOperands().iterator(); result && iter.hasNext();) {
				result = !iter.next().matches(editPart);
			}
			break;
		default:
			throw new IllegalArgumentException("unimplemented operator: " + compositeEditPartSpec.getOperator()); //$NON-NLS-1$
		}

		return result;
	}

} // CompositeEditPartSpecOperations
