/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.types;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.types.ContainerConfiguration#getContainerMatcherConfiguration <em>Container Matcher Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.types.ContainerConfiguration#getEContainmentFeatures <em>EContainment Features</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.types.ElementTypesConfigurationsPackage#getContainerConfiguration()
 * @model
 * @generated
 */
public interface ContainerConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Container Matcher Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container Matcher Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container Matcher Configuration</em>' containment reference.
	 * @see #setContainerMatcherConfiguration(AbstractMatcherConfiguration)
	 * @see org.eclipse.papyrus.infra.types.ElementTypesConfigurationsPackage#getContainerConfiguration_ContainerMatcherConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	AbstractMatcherConfiguration getContainerMatcherConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.types.ContainerConfiguration#getContainerMatcherConfiguration <em>Container Matcher Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container Matcher Configuration</em>' containment reference.
	 * @see #getContainerMatcherConfiguration()
	 * @generated
	 */
	void setContainerMatcherConfiguration(AbstractMatcherConfiguration value);

	/**
	 * Returns the value of the '<em><b>EContainment Features</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EContainment Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EContainment Features</em>' reference list.
	 * @see org.eclipse.papyrus.infra.types.ElementTypesConfigurationsPackage#getContainerConfiguration_EContainmentFeatures()
	 * @model
	 * @generated
	 */
	EList<EReference> getEContainmentFeatures();

} // ContainerConfiguration
