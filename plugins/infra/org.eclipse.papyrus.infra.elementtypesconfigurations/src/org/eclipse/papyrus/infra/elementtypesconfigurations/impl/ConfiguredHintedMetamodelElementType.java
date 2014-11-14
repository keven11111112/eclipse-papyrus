/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.elementtypesconfigurations.impl;

import java.net.URL;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelper;

public class ConfiguredHintedMetamodelElementType extends MetamodelType implements IHintedType {

	private String semanticHint;

	public ConfiguredHintedMetamodelElementType(String id, URL iconURL, String displayName, EClass eClass, IEditHelper editHelper, String semanticHint) {
		super(id, iconURL, displayName, eClass, editHelper);
		this.semanticHint = semanticHint;
	}

	public String getSemanticHint() {
		return semanticHint;
	}

	public void setSemanticHint(String semanticHint) {
		this.semanticHint = semanticHint;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Configured Metamodel Type: " + getDisplayName() + " [" + getId() + "]";
	}
}
