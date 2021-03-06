/*******************************************************************************
 * Copyright (c) 2006, 2020 Borland Software Corporation, CEA LIST, ARTAL
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
 */
package org.eclipse.papyrus.gmf.gmfgraph.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.gmf.gmfgraph.CenterLayout;
import org.eclipse.papyrus.gmf.gmfgraph.GMFGraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Center Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CenterLayoutImpl extends EObjectImpl implements CenterLayout {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CenterLayoutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GMFGraphPackage.eINSTANCE.getCenterLayout();
	}

} //CenterLayoutImpl
