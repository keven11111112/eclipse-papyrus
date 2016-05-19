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
package org.eclipse.papyrus.infra.types;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specialization Type Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.types.SpecializationTypeConfiguration#getEditHelperAdviceConfiguration <em>Edit Helper Advice Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.types.SpecializationTypeConfiguration#getContainerConfiguration <em>Container Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.types.SpecializationTypeConfiguration#getMatcherConfiguration <em>Matcher Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.types.SpecializationTypeConfiguration#getSpecializedTypes <em>Specialized Types</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.types.ElementTypesConfigurationsPackage#getSpecializationTypeConfiguration()
 * @model
 * @generated
 */
public interface SpecializationTypeConfiguration extends ElementTypeConfiguration {
	/**
	 * Returns the value of the '<em><b>Edit Helper Advice Configuration</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.types.AbstractEditHelperAdviceConfiguration#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edit Helper Advice Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edit Helper Advice Configuration</em>' containment reference.
	 * @see #setEditHelperAdviceConfiguration(AbstractEditHelperAdviceConfiguration)
	 * @see org.eclipse.papyrus.infra.types.ElementTypesConfigurationsPackage#getSpecializationTypeConfiguration_EditHelperAdviceConfiguration()
	 * @see org.eclipse.papyrus.infra.types.AbstractEditHelperAdviceConfiguration#getTarget
	 * @model opposite="target" containment="true"
	 * @generated
	 */
	AbstractEditHelperAdviceConfiguration getEditHelperAdviceConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.types.SpecializationTypeConfiguration#getEditHelperAdviceConfiguration <em>Edit Helper Advice Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edit Helper Advice Configuration</em>' containment reference.
	 * @see #getEditHelperAdviceConfiguration()
	 * @generated
	 */
	void setEditHelperAdviceConfiguration(AbstractEditHelperAdviceConfiguration value);

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
	 * @see org.eclipse.papyrus.infra.types.ElementTypesConfigurationsPackage#getSpecializationTypeConfiguration_ContainerConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	ContainerConfiguration getContainerConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.types.SpecializationTypeConfiguration#getContainerConfiguration <em>Container Configuration</em>}' containment reference.
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
	 * @see #setMatcherConfiguration(AbstractMatcherConfiguration)
	 * @see org.eclipse.papyrus.infra.types.ElementTypesConfigurationsPackage#getSpecializationTypeConfiguration_MatcherConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	AbstractMatcherConfiguration getMatcherConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.types.SpecializationTypeConfiguration#getMatcherConfiguration <em>Matcher Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matcher Configuration</em>' containment reference.
	 * @see #getMatcherConfiguration()
	 * @generated
	 */
	void setMatcherConfiguration(AbstractMatcherConfiguration value);

	/**
	 * Returns the value of the '<em><b>Specialized Types</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.types.ElementTypeConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specialized Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specialized Types</em>' reference list.
	 * @see org.eclipse.papyrus.infra.types.ElementTypesConfigurationsPackage#getSpecializationTypeConfiguration_SpecializedTypes()
	 * @model
	 * @generated
	 */
	EList<ElementTypeConfiguration> getSpecializedTypes();

} // SpecializationTypeConfiguration
