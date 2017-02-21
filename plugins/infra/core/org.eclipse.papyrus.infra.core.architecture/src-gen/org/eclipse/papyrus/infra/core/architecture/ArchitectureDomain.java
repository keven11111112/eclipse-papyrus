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
 * A representation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain#getStakeholders <em>Stakeholders</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain#getConcerns <em>Concerns</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureDomain#getContexts <em>Contexts</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage#getArchitectureDomain()
 * @model
 * @generated
 */
public interface ArchitectureDomain extends ADElement {
	/**
	 * Returns the value of the '<em><b>Stakeholders</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.core.architecture.Stakeholder}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.core.architecture.Stakeholder#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stakeholders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stakeholders</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage#getArchitectureDomain_Stakeholders()
	 * @see org.eclipse.papyrus.infra.core.architecture.Stakeholder#getDomain
	 * @model opposite="domain" containment="true"
	 * @generated
	 */
	EList<Stakeholder> getStakeholders();

	/**
	 * Returns the value of the '<em><b>Concerns</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.core.architecture.Concern}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.core.architecture.Concern#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concerns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concerns</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage#getArchitectureDomain_Concerns()
	 * @see org.eclipse.papyrus.infra.core.architecture.Concern#getDomain
	 * @model opposite="domain" containment="true"
	 * @generated
	 */
	EList<Concern> getConcerns();

	/**
	 * Returns the value of the '<em><b>Contexts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contexts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contexts</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitecturePackage#getArchitectureDomain_Contexts()
	 * @see org.eclipse.papyrus.infra.core.architecture.ArchitectureContext#getDomain
	 * @model opposite="domain" containment="true"
	 * @generated
	 */
	EList<ArchitectureContext> getContexts();

} // ArchitectureDomain
