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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.tests.framework.exceptions.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.papyrus.tests.framework.exceptions.ExceptionsPackage
 * @generated
 */
public class ExceptionsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected static ExceptionsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ExceptionsSwitch() {
		if (modelPackage == null) {
			modelPackage = ExceptionsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param ePackage
	 *            the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case ExceptionsPackage.FORBIDDEN_EDIT_PART_PERMUTATION: {
			ForbiddenEditPartPermutation forbiddenEditPartPermutation = (ForbiddenEditPartPermutation) theEObject;
			T result = caseForbiddenEditPartPermutation(forbiddenEditPartPermutation);
			if (result == null) {
				result = caseTestConstraint(forbiddenEditPartPermutation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ExceptionsPackage.TEST_CONSTRAINT: {
			TestConstraint testConstraint = (TestConstraint) theEObject;
			T result = caseTestConstraint(testConstraint);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ExceptionsPackage.TEST_EXCEPTIONS: {
			TestExceptions testExceptions = (TestExceptions) theEObject;
			T result = caseTestExceptions(testExceptions);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ExceptionsPackage.EDIT_PART_SPEC: {
			EditPartSpec editPartSpec = (EditPartSpec) theEObject;
			T result = caseEditPartSpec(editPartSpec);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ExceptionsPackage.COMPOSITE_EDIT_PART_SPEC: {
			CompositeEditPartSpec compositeEditPartSpec = (CompositeEditPartSpec) theEObject;
			T result = caseCompositeEditPartSpec(compositeEditPartSpec);
			if (result == null) {
				result = caseEditPartSpec(compositeEditPartSpec);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ExceptionsPackage.EDIT_PART_REF: {
			EditPartRef editPartRef = (EditPartRef) theEObject;
			T result = caseEditPartRef(editPartRef);
			if (result == null) {
				result = caseEditPartSpec(editPartRef);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ExceptionsPackage.ANY_EDIT_PART: {
			AnyEditPart anyEditPart = (AnyEditPart) theEObject;
			T result = caseAnyEditPart(anyEditPart);
			if (result == null) {
				result = caseEditPartSpec(anyEditPart);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ExceptionsPackage.FORBIDDEN_EDIT_PART: {
			ForbiddenEditPart forbiddenEditPart = (ForbiddenEditPart) theEObject;
			T result = caseForbiddenEditPart(forbiddenEditPart);
			if (result == null) {
				result = caseTestConstraint(forbiddenEditPart);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Forbidden Edit Part Permutation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Forbidden Edit Part Permutation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForbiddenEditPartPermutation(ForbiddenEditPartPermutation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestConstraint(TestConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Exceptions</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Exceptions</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestExceptions(TestExceptions object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edit Part Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edit Part Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEditPartSpec(EditPartSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Edit Part Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Edit Part Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeEditPartSpec(CompositeEditPartSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edit Part Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edit Part Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEditPartRef(EditPartRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Any Edit Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Any Edit Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnyEditPart(AnyEditPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Forbidden Edit Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Forbidden Edit Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForbiddenEditPart(ForbiddenEditPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} // ExceptionsSwitch
