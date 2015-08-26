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
package org.eclipse.papyrus.tests.framework.exceptions;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage
 * @generated
 */
public interface ExceptionsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	ExceptionsFactory eINSTANCE = org.eclipse.papyrus.tests.framework.exceptions.impl.ExceptionsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Forbidden Edit Part Permutation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Forbidden Edit Part Permutation</em>'.
	 * @generated
	 */
	ForbiddenEditPartPermutation createForbiddenEditPartPermutation();

	/**
	 * Returns a new object of class '<em>Test Exceptions</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Test Exceptions</em>'.
	 * @generated
	 */
	TestExceptions createTestExceptions();

	/**
	 * Returns a new object of class '<em>Composite Edit Part Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Composite Edit Part Spec</em>'.
	 * @generated
	 */
	CompositeEditPartSpec createCompositeEditPartSpec();

	/**
	 * Returns a new object of class '<em>Edit Part Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Edit Part Ref</em>'.
	 * @generated
	 */
	EditPartRef createEditPartRef();

	/**
	 * Returns a new object of class '<em>Any Edit Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Any Edit Part</em>'.
	 * @generated
	 */
	AnyEditPart createAnyEditPart();

	/**
	 * Returns a new object of class '<em>Forbidden Edit Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Forbidden Edit Part</em>'.
	 * @generated
	 */
	ForbiddenEditPart createForbiddenEditPart();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExceptionsPackage getExceptionsPackage();

} // ExceptionsFactory
