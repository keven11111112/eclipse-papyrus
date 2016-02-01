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
 * A representation of the model object '<em><b>Element Type Set Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration#getElementTypeConfigurations <em>Element Type Configurations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration#getAdviceBindingsConfigurations <em>Advice Bindings Configurations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration#getMetamodelNsURI <em>Metamodel Ns URI</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage#getElementTypeSetConfiguration()
 * @model
 * @generated
 */
public interface ElementTypeSetConfiguration extends ConfigurationElement, IdentifiedConfiguration, NamedConfiguration {
	/**
	 * Returns the value of the '<em><b>Element Type Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type Configurations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type Configurations</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage#getElementTypeSetConfiguration_ElementTypeConfigurations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ElementTypeConfiguration> getElementTypeConfigurations();

	/**
	 * Returns the value of the '<em><b>Advice Bindings Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.elementtypesconfigurations.AbstractAdviceBindingConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Advice Bindings Configurations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Advice Bindings Configurations</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage#getElementTypeSetConfiguration_AdviceBindingsConfigurations()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractAdviceBindingConfiguration> getAdviceBindingsConfigurations();

	/**
	 * Returns the value of the '<em><b>Metamodel Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel Ns URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel Ns URI</em>' attribute.
	 * @see #setMetamodelNsURI(String)
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage#getElementTypeSetConfiguration_MetamodelNsURI()
	 * @model required="true"
	 * @generated
	 */
	String getMetamodelNsURI();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration#getMetamodelNsURI <em>Metamodel Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel Ns URI</em>' attribute.
	 * @see #getMetamodelNsURI()
	 * @generated
	 */
	void setMetamodelNsURI(String value);

} // ElementTypeSetConfiguration
