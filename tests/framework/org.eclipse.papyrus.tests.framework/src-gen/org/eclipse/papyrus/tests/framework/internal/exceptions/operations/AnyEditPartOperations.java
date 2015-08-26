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

import org.eclipse.papyrus.tests.framework.exceptions.AnyEditPart;
import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Any Edit Part</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.tests.framework.exceptions.AnyEditPart#matches(org.eclipse.uml2.uml.InstanceSpecification) <em>Matches</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnyEditPartOperations extends EditPartSpecOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected AnyEditPartOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public static boolean matches(AnyEditPart anyEditPart, InstanceSpecification editPart) {
		return true;
	}

} // AnyEditPartOperations
