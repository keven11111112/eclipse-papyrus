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

import org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invariant Type Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfiguration#getInvariantRuleConfiguration <em>Invariant Rule Configuration</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfigurationPackage#getInvariantTypeConfiguration()
 * @model
 * @generated
 */
public interface InvariantTypeConfiguration extends SpecializationTypeConfiguration {
	/**
	 * Returns the value of the '<em><b>Invariant Rule Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invariant Rule Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invariant Rule Configuration</em>' containment reference.
	 * @see #setInvariantRuleConfiguration(InvariantRuleConfiguration)
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfigurationPackage#getInvariantTypeConfiguration_InvariantRuleConfiguration()
	 * @model containment="true" required="true"
	 * @generated
	 */
	InvariantRuleConfiguration getInvariantRuleConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfiguration#getInvariantRuleConfiguration <em>Invariant Rule Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invariant Rule Configuration</em>' containment reference.
	 * @see #getInvariantRuleConfiguration()
	 * @generated
	 */
	void setInvariantRuleConfiguration(InvariantRuleConfiguration value);

} // InvariantTypeConfiguration
