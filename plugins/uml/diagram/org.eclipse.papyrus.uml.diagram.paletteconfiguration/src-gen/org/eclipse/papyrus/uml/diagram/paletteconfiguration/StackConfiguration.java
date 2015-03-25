/**
 * Copyright (c) 2015 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.paletteconfiguration;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stack Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.StackConfiguration#getOwnedConfigurations <em>Owned Configurations</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage#getStackConfiguration()
 * @model
 * @generated
 */
public interface StackConfiguration extends ChildConfiguration {
	/**
	 * Returns the value of the '<em><b>Owned Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.LeafConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Configurations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Configurations</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage#getStackConfiguration_OwnedConfigurations()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<LeafConfiguration> getOwnedConfigurations();

} // StackConfiguration
