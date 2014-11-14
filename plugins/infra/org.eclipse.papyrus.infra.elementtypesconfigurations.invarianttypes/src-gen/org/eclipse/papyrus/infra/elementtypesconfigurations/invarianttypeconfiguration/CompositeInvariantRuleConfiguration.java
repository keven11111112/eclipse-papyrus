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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Invariant Rule Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.CompositeInvariantRuleConfiguration#getComposedRules <em>Composed Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfigurationPackage#getCompositeInvariantRuleConfiguration()
 * @model abstract="true"
 * @generated
 */
public interface CompositeInvariantRuleConfiguration extends InvariantRuleConfiguration {
	/**
	 * Returns the value of the '<em><b>Composed Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantRuleConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composed Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composed Rules</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantTypeConfigurationPackage#getCompositeInvariantRuleConfiguration_ComposedRules()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<InvariantRuleConfiguration> getComposedRules();

} // CompositeInvariantRuleConfiguration
