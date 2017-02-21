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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Representation Kind</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.architecture.RepresentationKind#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.architecture.RepresentationKind#getConcerns <em>Concerns</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.architecture.RepresentationKind#getIcon <em>Icon</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage#getRepresentationKind()
 * @model abstract="true"
 * @generated
 */
public interface RepresentationKind extends ADElement {
	/**
	 * Returns the value of the '<em><b>Concerns</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.core.architecture.Concern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concerns</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concerns</em>' reference list.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage#getRepresentationKind_Concerns()
	 * @model
	 * @generated
	 */
	EList<Concern> getConcerns();

	/**
	 * Returns the value of the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' attribute.
	 * @see #setIcon(String)
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage#getRepresentationKind_Icon()
	 * @model
	 * @generated
	 */
	String getIcon();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.architecture.RepresentationKind#getIcon <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon</em>' attribute.
	 * @see #getIcon()
	 * @generated
	 */
	void setIcon(String value);

	/**
	 * Returns the value of the '<em><b>Language</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionLanguage#getRepresentationKinds <em>Representation Kinds</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language</em>' container reference.
	 * @see #setLanguage(ArchitectureDescriptionLanguage)
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage#getRepresentationKind_Language()
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureDescriptionLanguage#getRepresentationKinds
	 * @model opposite="representationKinds" required="true" transient="false"
	 * @generated
	 */
	ArchitectureDescriptionLanguage getLanguage();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.architecture.RepresentationKind#getLanguage <em>Language</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' container reference.
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(ArchitectureDescriptionLanguage value);

} // RepresentationKind
