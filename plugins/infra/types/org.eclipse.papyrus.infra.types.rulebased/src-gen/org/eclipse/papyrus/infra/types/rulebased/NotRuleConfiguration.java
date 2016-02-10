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
package org.eclipse.papyrus.infra.types.rulebased;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not Rule Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.types.rulebased.NotRuleConfiguration#getComposedRule <em>Composed Rule</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.types.rulebased.RuleBasedPackage#getNotRuleConfiguration()
 * @model
 * @generated
 */
public interface NotRuleConfiguration extends RuleConfiguration {
	/**
	 * Returns the value of the '<em><b>Composed Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composed Rule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composed Rule</em>' reference.
	 * @see #setComposedRule(RuleConfiguration)
	 * @see org.eclipse.papyrus.infra.types.rulebased.RuleBasedPackage#getNotRuleConfiguration_ComposedRule()
	 * @model required="true"
	 * @generated
	 */
	RuleConfiguration getComposedRule();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.types.rulebased.NotRuleConfiguration#getComposedRule <em>Composed Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composed Rule</em>' reference.
	 * @see #getComposedRule()
	 * @generated
	 */
	void setComposedRule(RuleConfiguration value);

} // NotRuleConfiguration
