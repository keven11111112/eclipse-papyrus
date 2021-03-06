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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Type Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.types.ElementTypeConfiguration#getHint <em>Hint</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.types.ElementTypeConfiguration#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.types.ElementTypeConfiguration#getIconEntry <em>Icon Entry</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.types.ElementTypesConfigurationsPackage#getElementTypeConfiguration()
 * @model abstract="true"
 * @generated
 */
public interface ElementTypeConfiguration extends ConfigurationElement, IdentifiedConfiguration, NamedConfiguration {
	/**
	 * Returns the value of the '<em><b>Hint</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hint</em>' attribute.
	 * @see #setHint(String)
	 * @see org.eclipse.papyrus.infra.types.ElementTypesConfigurationsPackage#getElementTypeConfiguration_Hint()
	 * @model default=""
	 * @generated
	 */
	String getHint();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.types.ElementTypeConfiguration#getHint <em>Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hint</em>' attribute.
	 * @see #getHint()
	 * @generated
	 */
	void setHint(String value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The default value is <code>"org.eclipse.gmf.runtime.emf.type.core.IHintedType"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see #setKind(String)
	 * @see org.eclipse.papyrus.infra.types.ElementTypesConfigurationsPackage#getElementTypeConfiguration_Kind()
	 * @model default="org.eclipse.gmf.runtime.emf.type.core.IHintedType"
	 * @generated
	 */
	String getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.types.ElementTypeConfiguration#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see #getKind()
	 * @generated
	 */
	void setKind(String value);

	/**
	 * Returns the value of the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon Entry</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon Entry</em>' containment reference.
	 * @see #setIconEntry(IconEntry)
	 * @see org.eclipse.papyrus.infra.types.ElementTypesConfigurationsPackage#getElementTypeConfiguration_IconEntry()
	 * @model containment="true"
	 * @generated
	 */
	IconEntry getIconEntry();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.types.ElementTypeConfiguration#getIconEntry <em>Icon Entry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon Entry</em>' containment reference.
	 * @see #getIconEntry()
	 * @generated
	 */
	void setIconEntry(IconEntry value);

} // ElementTypeConfiguration
