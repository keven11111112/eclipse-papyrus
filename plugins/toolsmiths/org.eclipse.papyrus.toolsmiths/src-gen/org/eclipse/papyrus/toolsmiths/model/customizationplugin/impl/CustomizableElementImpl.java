/**
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.toolsmiths.model.customizationplugin.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.papyrus.toolsmiths.model.customizationplugin.CustomizableElement;
import org.eclipse.papyrus.toolsmiths.model.customizationplugin.CustomizationPluginPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Customizable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class CustomizableElementImpl extends EObjectImpl implements CustomizableElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomizableElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CustomizationPluginPackage.Literals.CUSTOMIZABLE_ELEMENT;
	}

} //CustomizableElementImpl
