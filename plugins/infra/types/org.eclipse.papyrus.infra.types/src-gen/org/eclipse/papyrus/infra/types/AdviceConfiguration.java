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
 * A representation of the model object '<em><b>Advice Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.types.AdviceConfiguration#getBefore <em>Before</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.types.AdviceConfiguration#getAfter <em>After</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.types.ElementTypesConfigurationsPackage#getAdviceConfiguration()
 * @model abstract="true"
 * @generated
 */
public interface AdviceConfiguration extends ConfigurationElement {

	/**
	 * Returns the value of the '<em><b>Before</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Before</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Before</em>' attribute list.
	 * @see org.eclipse.papyrus.infra.types.ElementTypesConfigurationsPackage#getAdviceConfiguration_Before()
	 * @model
	 * @generated
	 */
	EList<String> getBefore();

	/**
	 * Returns the value of the '<em><b>After</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>After</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>After</em>' attribute list.
	 * @see org.eclipse.papyrus.infra.types.ElementTypesConfigurationsPackage#getAdviceConfiguration_After()
	 * @model
	 * @generated
	 */
	EList<String> getAfter();

} // AdviceConfiguration
