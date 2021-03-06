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
 * $Id$
 */
package org.eclipse.papyrus.gmf.mappings.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.gmf.mappings.DesignLabelMapping;
import org.eclipse.papyrus.gmf.mappings.GMFMapPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Design Label Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DesignLabelMappingImpl extends LabelMappingImpl implements DesignLabelMapping {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DesignLabelMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GMFMapPackage.eINSTANCE.getDesignLabelMapping();
	}

} //DesignLabelMappingImpl
