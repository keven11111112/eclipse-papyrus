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
package org.eclipse.papyrus.infra.elementtypesconfigurations;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Advice Binding Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration#getContainerConfiguration <em>Container Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration#getMatcherConfiguration <em>Matcher Configuration</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage#getAdviceBindingConfiguration()
 * @model
 * @generated
 */
public interface AdviceBindingConfiguration extends AdviceConfiguration {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ElementTypeConfiguration)
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage#getAdviceBindingConfiguration_Target()
	 * @model required="true"
	 * @generated
	 */
	ElementTypeConfiguration getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ElementTypeConfiguration value);

	/**
	 * Returns the value of the '<em><b>Container Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container Configuration</em>' containment reference.
	 * @see #setContainerConfiguration(ContainerConfiguration)
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage#getAdviceBindingConfiguration_ContainerConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	ContainerConfiguration getContainerConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration#getContainerConfiguration <em>Container Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container Configuration</em>' containment reference.
	 * @see #getContainerConfiguration()
	 * @generated
	 */
	void setContainerConfiguration(ContainerConfiguration value);

	/**
	 * Returns the value of the '<em><b>Matcher Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matcher Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matcher Configuration</em>' containment reference.
	 * @see #setMatcherConfiguration(MatcherConfiguration)
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage#getAdviceBindingConfiguration_MatcherConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	MatcherConfiguration getMatcherConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration#getMatcherConfiguration <em>Matcher Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matcher Configuration</em>' containment reference.
	 * @see #getMatcherConfiguration()
	 * @generated
	 */
	void setMatcherConfiguration(MatcherConfiguration value);

} // AdviceBindingConfiguration
