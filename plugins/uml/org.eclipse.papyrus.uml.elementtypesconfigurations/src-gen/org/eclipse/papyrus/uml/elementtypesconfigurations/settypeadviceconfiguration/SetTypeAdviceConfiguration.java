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
package org.eclipse.papyrus.uml.elementtypesconfigurations.settypeadviceconfiguration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.papyrus.infra.elementtypesconfigurations.AbstractAdviceBindingConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Type Advice Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.elementtypesconfigurations.settypeadviceconfiguration.SetTypeAdviceConfiguration#getValidTypes <em>Valid Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.elementtypesconfigurations.settypeadviceconfiguration.SetTypeAdviceConfiguration#getCreationTypes <em>Creation Types</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.elementtypesconfigurations.settypeadviceconfiguration.SetTypeAdviceConfigurationPackage#getSetTypeAdviceConfiguration()
 * @model
 * @generated
 */
public interface SetTypeAdviceConfiguration extends AbstractAdviceBindingConfiguration {
	/**
	 * Returns the value of the '<em><b>Valid Types</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Valid Types</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valid Types</em>' attribute list.
	 * @see org.eclipse.papyrus.uml.elementtypesconfigurations.settypeadviceconfiguration.SetTypeAdviceConfigurationPackage#getSetTypeAdviceConfiguration_ValidTypes()
	 * @model
	 * @generated
	 */
	EList<String> getValidTypes();

	/**
	 * Returns the value of the '<em><b>Creation Types</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Types</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Types</em>' attribute list.
	 * @see org.eclipse.papyrus.uml.elementtypesconfigurations.settypeadviceconfiguration.SetTypeAdviceConfigurationPackage#getSetTypeAdviceConfiguration_CreationTypes()
	 * @model
	 * @generated
	 */
	EList<String> getCreationTypes();

} // SetTypeAdviceConfiguration
