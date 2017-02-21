/**
 * Copyright (c) 2017 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Maged Elaasar - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.core.architecture;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Description Preferences</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionPreferences#getViewpointIds <em>Viewpoint Ids</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage#getArchitectureDescriptionPreferences()
 * @model
 * @generated
 */
public interface ArchitectureDescriptionPreferences extends EObject {
	/**
	 * Returns the value of the '<em><b>Viewpoint Ids</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Viewpoint Ids</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Viewpoint Ids</em>' attribute list.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage#getArchitectureDescriptionPreferences_ViewpointIds()
	 * @model
	 * @generated
	 */
	EList<String> getViewpointIds();

} // ArchitectureDescriptionPreferences
