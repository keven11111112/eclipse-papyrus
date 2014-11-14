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
package org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.papyrus.infra.elementtypesconfigurations.MatcherConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stereotype Application Matcher Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.StereotypeApplicationMatcherConfiguration#getStereotypesQualifiedNames <em>Stereotypes Qualified Names</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.StereotypeApplicationMatcherConfigurationPackage#getStereotypeApplicationMatcherConfiguration()
 * @model
 * @generated
 */
public interface StereotypeApplicationMatcherConfiguration extends MatcherConfiguration {
	/**
	 * Returns the value of the '<em><b>Stereotypes Qualified Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotypes Qualified Names</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotypes Qualified Names</em>' attribute list.
	 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.StereotypeApplicationMatcherConfigurationPackage#getStereotypeApplicationMatcherConfiguration_StereotypesQualifiedNames()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getStereotypesQualifiedNames();

} // StereotypeApplicationMatcherConfiguration
