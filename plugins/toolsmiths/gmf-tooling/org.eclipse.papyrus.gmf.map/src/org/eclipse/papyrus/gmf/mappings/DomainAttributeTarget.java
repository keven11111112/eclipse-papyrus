/*******************************************************************************
 * Copyright (c) 2005, 2020 Borland Software Corporation, CEA LIST, ARTAL
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 * 
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *     Borland - initial API and implementation
 *     Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * $Id: DomainAttributeTarget.java,v 1.2 2006/05/05 17:11:49 ashatalin Exp $
 */
package org.eclipse.papyrus.gmf.mappings;

import org.eclipse.emf.ecore.EAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Attribute Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents value based target, useful for audit rules expression not capable of ecore meta-model access
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.DomainAttributeTarget#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.eclipse.papyrus.gmf.mappings.DomainAttributeTarget#isNullAsError <em>Null As Error</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getDomainAttributeTarget()
 * @model annotation="http://www.eclipse.org/gmf/2005/constraints/meta def='context' ocl='attribute.eType'"
 * @generated
 */
public interface DomainAttributeTarget extends Auditable {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attribute the value of which is used as context in audit rule defining this target
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attribute</em>' reference.
	 * @see #setAttribute(EAttribute)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getDomainAttributeTarget_Attribute()
	 * @model required="true"
	 * @generated
	 */
	EAttribute getAttribute();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.DomainAttributeTarget#getAttribute <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(EAttribute value);

	/**
	 * Returns the value of the '<em><b>Null As Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Indicates whether null value of the attribute is reported as audit failure or success
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Null As Error</em>' attribute.
	 * @see #setNullAsError(boolean)
	 * @see org.eclipse.papyrus.gmf.mappings.GMFMapPackage#getDomainAttributeTarget_NullAsError()
	 * @model
	 * @generated
	 */
	boolean isNullAsError();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.gmf.mappings.DomainAttributeTarget#isNullAsError <em>Null As Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Null As Error</em>' attribute.
	 * @see #isNullAsError()
	 * @generated
	 */
	void setNullAsError(boolean value);

} // DomainAttributeTarget
