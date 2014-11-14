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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Advice Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration#getEditHelperAdviceClassName <em>Edit Helper Advice Class Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration#getBefore <em>Before</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration#getAfter <em>After</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration#getInheritance <em>Inheritance</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage#getAdviceConfiguration()
 * @model abstract="true"
 * @generated
 */
public interface AdviceConfiguration extends ConfigurationElement {
	/**
	 * Returns the value of the '<em><b>Edit Helper Advice Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edit Helper Advice Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edit Helper Advice Class Name</em>' attribute.
	 * @see #setEditHelperAdviceClassName(String)
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage#getAdviceConfiguration_EditHelperAdviceClassName()
	 * @model required="true"
	 * @generated
	 */
	String getEditHelperAdviceClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration#getEditHelperAdviceClassName <em>Edit Helper Advice Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edit Helper Advice Class Name</em>' attribute.
	 * @see #getEditHelperAdviceClassName()
	 * @generated
	 */
	void setEditHelperAdviceClassName(String value);

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
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage#getAdviceConfiguration_Before()
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
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage#getAdviceConfiguration_After()
	 * @model
	 * @generated
	 */
	EList<String> getAfter();

	/**
	 * Returns the value of the '<em><b>Inheritance</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.infra.elementtypesconfigurations.InheritanceKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inheritance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inheritance</em>' attribute.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.InheritanceKind
	 * @see #setInheritance(InheritanceKind)
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage#getAdviceConfiguration_Inheritance()
	 * @model required="true"
	 * @generated
	 */
	InheritanceKind getInheritance();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration#getInheritance <em>Inheritance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inheritance</em>' attribute.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.InheritanceKind
	 * @see #getInheritance()
	 * @generated
	 */
	void setInheritance(InheritanceKind value);

} // AdviceConfiguration
