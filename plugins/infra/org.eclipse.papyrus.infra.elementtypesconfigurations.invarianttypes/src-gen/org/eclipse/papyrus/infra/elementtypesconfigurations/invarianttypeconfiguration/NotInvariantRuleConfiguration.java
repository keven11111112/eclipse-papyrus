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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not Invariant Rule Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.NotInvariantRuleConfiguration#getComposedRule <em>Composed Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfigurationPackage#getNotInvariantRuleConfiguration()
 * @model abstract="true"
 * @generated
 */
public interface NotInvariantRuleConfiguration extends InvariantRuleConfiguration {
	/**
	 * Returns the value of the '<em><b>Composed Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composed Rule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composed Rule</em>' reference.
	 * @see #setComposedRule(InvariantRuleConfiguration)
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfigurationPackage#getNotInvariantRuleConfiguration_ComposedRule()
	 * @model required="true"
	 * @generated
	 */
	InvariantRuleConfiguration getComposedRule();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.NotInvariantRuleConfiguration#getComposedRule <em>Composed Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composed Rule</em>' reference.
	 * @see #getComposedRule()
	 * @generated
	 */
	void setComposedRule(InvariantRuleConfiguration value);

} // NotInvariantRuleConfiguration
