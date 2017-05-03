/**
 * Copyright (c) 2017 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.expressions.umlexpressions.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.infra.emf.expressions.IBasicExpressionElement;
import org.eclipse.papyrus.infra.emf.expressions.IExpression;
import org.eclipse.papyrus.infra.emf.expressions.booleanexpressions.IBooleanEObjectExpression;
import org.eclipse.papyrus.infra.emf.expressions.booleanexpressions.IBooleanExpression;
import org.eclipse.papyrus.uml.expressions.umlexpressions.*;

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
 * @see org.eclipse.papyrus.uml.expressions.umlexpressions.UMLExpressionsPackage
 * @generated
 */
public class UMLExpressionsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UMLExpressionsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLExpressionsSwitch() {
		if (modelPackage == null) {
			modelPackage = UMLExpressionsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
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
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case UMLExpressionsPackage.IS_STEREOTYPED_WITH_EXPRESSION: {
				IsStereotypedWithExpression isStereotypedWithExpression = (IsStereotypedWithExpression)theEObject;
				T result = caseIsStereotypedWithExpression(isStereotypedWithExpression);
				if (result == null) result = caseIBooleanEObjectExpression(isStereotypedWithExpression);
				if (result == null) result = caseIBooleanExpression(isStereotypedWithExpression);
				if (result == null) result = caseIExpression(isStereotypedWithExpression);
				if (result == null) result = caseIBasicExpressionElement(isStereotypedWithExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLExpressionsPackage.HAS_APPLIED_STEREOTYPES_EXPRESSION: {
				HasAppliedStereotypesExpression hasAppliedStereotypesExpression = (HasAppliedStereotypesExpression)theEObject;
				T result = caseHasAppliedStereotypesExpression(hasAppliedStereotypesExpression);
				if (result == null) result = caseIBooleanEObjectExpression(hasAppliedStereotypesExpression);
				if (result == null) result = caseIBooleanExpression(hasAppliedStereotypesExpression);
				if (result == null) result = caseIExpression(hasAppliedStereotypesExpression);
				if (result == null) result = caseIBasicExpressionElement(hasAppliedStereotypesExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLExpressionsPackage.IS_TYPE_OF_EXPRESSION: {
				IsTypeOfExpression isTypeOfExpression = (IsTypeOfExpression)theEObject;
				T result = caseIsTypeOfExpression(isTypeOfExpression);
				if (result == null) result = caseIBooleanEObjectExpression(isTypeOfExpression);
				if (result == null) result = caseIBooleanExpression(isTypeOfExpression);
				if (result == null) result = caseIExpression(isTypeOfExpression);
				if (result == null) result = caseIBasicExpressionElement(isTypeOfExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLExpressionsPackage.IS_KIND_OF_EXPRESSION: {
				IsKindOfExpression isKindOfExpression = (IsKindOfExpression)theEObject;
				T result = caseIsKindOfExpression(isKindOfExpression);
				if (result == null) result = caseIBooleanEObjectExpression(isKindOfExpression);
				if (result == null) result = caseIBooleanExpression(isKindOfExpression);
				if (result == null) result = caseIExpression(isKindOfExpression);
				if (result == null) result = caseIBasicExpressionElement(isKindOfExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Stereotyped With Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Stereotyped With Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIsStereotypedWithExpression(IsStereotypedWithExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Applied Stereotypes Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Applied Stereotypes Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasAppliedStereotypesExpression(HasAppliedStereotypesExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Type Of Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Type Of Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIsTypeOfExpression(IsTypeOfExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Kind Of Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Kind Of Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIsKindOfExpression(IsKindOfExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IBasic Expression Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IBasic Expression Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIBasicExpressionElement(IBasicExpressionElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IExpression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IExpression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <CONTEXT_TYPE, RETURN_TYPE> T caseIExpression(IExpression<CONTEXT_TYPE, RETURN_TYPE> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IBoolean Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IBoolean Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <IBooleanExpression_REDEFINED_CONTEXT_TYPE> T caseIBooleanExpression(IBooleanExpression<IBooleanExpression_REDEFINED_CONTEXT_TYPE> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IBoolean EObject Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IBoolean EObject Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIBooleanEObjectExpression(IBooleanEObjectExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //UMLExpressionsSwitch
