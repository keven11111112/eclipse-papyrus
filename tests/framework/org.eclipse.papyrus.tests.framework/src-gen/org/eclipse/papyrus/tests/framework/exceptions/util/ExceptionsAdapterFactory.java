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
package org.eclipse.papyrus.tests.framework.exceptions.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.tests.framework.exceptions.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage
 * @generated
 */
public class ExceptionsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected static ExceptionsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ExceptionsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ExceptionsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 *
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ExceptionsSwitch<Adapter> modelSwitch = new ExceptionsSwitch<Adapter>() {
		@Override
		public Adapter caseForbiddenEditPartPermutation(ForbiddenEditPartPermutation object) {
			return createForbiddenEditPartPermutationAdapter();
		}

		@Override
		public Adapter caseTestConstraint(TestConstraint object) {
			return createTestConstraintAdapter();
		}

		@Override
		public Adapter caseTestExceptions(TestExceptions object) {
			return createTestExceptionsAdapter();
		}

		@Override
		public Adapter caseEditPartSpec(EditPartSpec object) {
			return createEditPartSpecAdapter();
		}

		@Override
		public Adapter caseCompositeEditPartSpec(CompositeEditPartSpec object) {
			return createCompositeEditPartSpecAdapter();
		}

		@Override
		public Adapter caseEditPartRef(EditPartRef object) {
			return createEditPartRefAdapter();
		}

		@Override
		public Adapter caseAnyEditPart(AnyEditPart object) {
			return createAnyEditPartAdapter();
		}

		@Override
		public Adapter caseForbiddenEditPart(ForbiddenEditPart object) {
			return createForbiddenEditPartAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param target
	 *            the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation <em>Forbidden Edit Part Permutation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPartPermutation
	 * @generated
	 */
	public Adapter createForbiddenEditPartPermutationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.tests.framework.exceptions.TestConstraint <em>Test Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.TestConstraint
	 * @generated
	 */
	public Adapter createTestConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.tests.framework.exceptions.TestExceptions <em>Test Exceptions</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.TestExceptions
	 * @generated
	 */
	public Adapter createTestExceptionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec <em>Edit Part Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.EditPartSpec
	 * @generated
	 */
	public Adapter createEditPartSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.tests.framework.exceptions.CompositeEditPartSpec <em>Composite Edit Part Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.CompositeEditPartSpec
	 * @generated
	 */
	public Adapter createCompositeEditPartSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.tests.framework.exceptions.EditPartRef <em>Edit Part Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.EditPartRef
	 * @generated
	 */
	public Adapter createEditPartRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.tests.framework.exceptions.AnyEditPart <em>Any Edit Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.AnyEditPart
	 * @generated
	 */
	public Adapter createAnyEditPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPart <em>Forbidden Edit Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.tests.framework.exceptions.ForbiddenEditPart
	 * @generated
	 */
	public Adapter createForbiddenEditPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // ExceptionsAdapterFactory
