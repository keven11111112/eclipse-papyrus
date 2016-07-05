/**
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 * Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.propertylifecycle.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.propertylifecycle.*;

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
 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage
 * @generated
 */
public class PropertylifecycleSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected static PropertylifecyclePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public PropertylifecycleSwitch() {
		if (modelPackage == null) {
			modelPackage = PropertylifecyclePackage.eINSTANCE;
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
		case PropertylifecyclePackage.STRATEGY_TEMPLATE: {
			StrategyTemplate strategyTemplate = (StrategyTemplate) theEObject;
			T result = caseStrategyTemplate(strategyTemplate);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case PropertylifecyclePackage.STRATEGY_SET: {
			StrategySet strategySet = (StrategySet) theEObject;
			T result = caseStrategySet(strategySet);
			if (result == null) {
				result = caseStrategyTemplate(strategySet);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case PropertylifecyclePackage.STRATEGY_ELEMENT: {
			StrategyElement strategyElement = (StrategyElement) theEObject;
			T result = caseStrategyElement(strategyElement);
			if (result == null) {
				result = caseElementTemplate(strategyElement);
			}
			if (result == null) {
				result = caseStrategyTemplate(strategyElement);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case PropertylifecyclePackage.ELEMENT_TEMPLATE: {
			ElementTemplate elementTemplate = (ElementTemplate) theEObject;
			T result = caseElementTemplate(elementTemplate);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case PropertylifecyclePackage.ELEMENT_CONTAINER: {
			ElementContainer elementContainer = (ElementContainer) theEObject;
			T result = caseElementContainer(elementContainer);
			if (result == null) {
				result = caseElementTemplate(elementContainer);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case PropertylifecyclePackage.ELEMENT_PROPERTY: {
			ElementProperty elementProperty = (ElementProperty) theEObject;
			T result = caseElementProperty(elementProperty);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case PropertylifecyclePackage.ABSTRACT_TRIGGER: {
			AbstractTrigger abstractTrigger = (AbstractTrigger) theEObject;
			T result = caseAbstractTrigger(abstractTrigger);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case PropertylifecyclePackage.ABSTRACT_VALUE_PROCESSOR: {
			AbstractValueProcessor abstractValueProcessor = (AbstractValueProcessor) theEObject;
			T result = caseAbstractValueProcessor(abstractValueProcessor);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case PropertylifecyclePackage.JAVA_PROCESSOR: {
			JavaProcessor javaProcessor = (JavaProcessor) theEObject;
			T result = caseJavaProcessor(javaProcessor);
			if (result == null) {
				result = caseAbstractValueProcessor(javaProcessor);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case PropertylifecyclePackage.BASIC_TRIGGER: {
			BasicTrigger basicTrigger = (BasicTrigger) theEObject;
			T result = caseBasicTrigger(basicTrigger);
			if (result == null) {
				result = caseAbstractTrigger(basicTrigger);
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
	 * Returns the result of interpreting the object as an instance of '<em>Strategy Template</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Strategy Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStrategyTemplate(StrategyTemplate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Strategy Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Strategy Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStrategySet(StrategySet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Strategy Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Strategy Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStrategyElement(StrategyElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Template</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementTemplate(ElementTemplate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementContainer(ElementContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementProperty(ElementProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Trigger</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractTrigger(AbstractTrigger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Value Processor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Value Processor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractValueProcessor(AbstractValueProcessor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Processor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Processor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaProcessor(JavaProcessor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Trigger</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicTrigger(BasicTrigger object) {
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

} // PropertylifecycleSwitch
