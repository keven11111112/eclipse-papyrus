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
package org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfigurationPackage
 * @generated
 */
public interface InvariantTypeConfigurationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InvariantTypeConfigurationFactory eINSTANCE = org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.impl.InvariantTypeConfigurationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Invariant Type Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invariant Type Configuration</em>'.
	 * @generated
	 */
	InvariantTypeConfiguration createInvariantTypeConfiguration();

	/**
	 * Returns a new object of class '<em>And Invariant Rule Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And Invariant Rule Configuration</em>'.
	 * @generated
	 */
	AndInvariantRuleConfiguration createAndInvariantRuleConfiguration();

	/**
	 * Returns a new object of class '<em>Or Invariant Rule Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or Invariant Rule Configuration</em>'.
	 * @generated
	 */
	OrInvariantRuleConfiguration createOrInvariantRuleConfiguration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	InvariantTypeConfigurationPackage getInvariantTypeConfigurationPackage();

} //InvariantTypeConfigurationFactory
