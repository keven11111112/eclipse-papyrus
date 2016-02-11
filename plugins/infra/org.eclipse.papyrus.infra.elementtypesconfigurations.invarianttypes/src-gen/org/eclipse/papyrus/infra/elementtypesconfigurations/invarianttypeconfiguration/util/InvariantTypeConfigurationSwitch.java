/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.infra.elementtypesconfigurations.ConfigurationElement;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.IdentifiedConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.NamedConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration;

import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.*;

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
 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfigurationPackage
 * @generated
 */
public class InvariantTypeConfigurationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static InvariantTypeConfigurationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantTypeConfigurationSwitch() {
		if (modelPackage == null) {
			modelPackage = InvariantTypeConfigurationPackage.eINSTANCE;
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
			case InvariantTypeConfigurationPackage.INVARIANT_TYPE_CONFIGURATION: {
				InvariantTypeConfiguration invariantTypeConfiguration = (InvariantTypeConfiguration)theEObject;
				T result = caseInvariantTypeConfiguration(invariantTypeConfiguration);
				if (result == null) result = caseSpecializationTypeConfiguration(invariantTypeConfiguration);
				if (result == null) result = caseElementTypeConfiguration(invariantTypeConfiguration);
				if (result == null) result = caseConfigurationElement(invariantTypeConfiguration);
				if (result == null) result = caseIdentifiedConfiguration(invariantTypeConfiguration);
				if (result == null) result = caseNamedConfiguration(invariantTypeConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InvariantTypeConfigurationPackage.INVARIANT_RULE_CONFIGURATION: {
				InvariantRuleConfiguration invariantRuleConfiguration = (InvariantRuleConfiguration)theEObject;
				T result = caseInvariantRuleConfiguration(invariantRuleConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InvariantTypeConfigurationPackage.COMPOSITE_INVARIANT_RULE_CONFIGURATION: {
				CompositeInvariantRuleConfiguration compositeInvariantRuleConfiguration = (CompositeInvariantRuleConfiguration)theEObject;
				T result = caseCompositeInvariantRuleConfiguration(compositeInvariantRuleConfiguration);
				if (result == null) result = caseInvariantRuleConfiguration(compositeInvariantRuleConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InvariantTypeConfigurationPackage.NOT_INVARIANT_RULE_CONFIGURATION: {
				NotInvariantRuleConfiguration notInvariantRuleConfiguration = (NotInvariantRuleConfiguration)theEObject;
				T result = caseNotInvariantRuleConfiguration(notInvariantRuleConfiguration);
				if (result == null) result = caseInvariantRuleConfiguration(notInvariantRuleConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InvariantTypeConfigurationPackage.AND_INVARIANT_RULE_CONFIGURATION: {
				AndInvariantRuleConfiguration andInvariantRuleConfiguration = (AndInvariantRuleConfiguration)theEObject;
				T result = caseAndInvariantRuleConfiguration(andInvariantRuleConfiguration);
				if (result == null) result = caseCompositeInvariantRuleConfiguration(andInvariantRuleConfiguration);
				if (result == null) result = caseInvariantRuleConfiguration(andInvariantRuleConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InvariantTypeConfigurationPackage.OR_INVARIANT_RULE_CONFIGURATION: {
				OrInvariantRuleConfiguration orInvariantRuleConfiguration = (OrInvariantRuleConfiguration)theEObject;
				T result = caseOrInvariantRuleConfiguration(orInvariantRuleConfiguration);
				if (result == null) result = caseCompositeInvariantRuleConfiguration(orInvariantRuleConfiguration);
				if (result == null) result = caseInvariantRuleConfiguration(orInvariantRuleConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invariant Type Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invariant Type Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvariantTypeConfiguration(InvariantTypeConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invariant Rule Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invariant Rule Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvariantRuleConfiguration(InvariantRuleConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Invariant Rule Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Invariant Rule Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeInvariantRuleConfiguration(CompositeInvariantRuleConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Invariant Rule Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Invariant Rule Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotInvariantRuleConfiguration(NotInvariantRuleConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Invariant Rule Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Invariant Rule Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAndInvariantRuleConfiguration(AndInvariantRuleConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Invariant Rule Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Invariant Rule Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrInvariantRuleConfiguration(OrInvariantRuleConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfigurationElement(ConfigurationElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identified Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identified Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifiedConfiguration(IdentifiedConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedConfiguration(NamedConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Type Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Type Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementTypeConfiguration(ElementTypeConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specialization Type Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specialization Type Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecializationTypeConfiguration(SpecializationTypeConfiguration object) {
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

} //InvariantTypeConfigurationSwitch
