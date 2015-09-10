/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thomas Daniellou (CEA LIST) - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.adltool.reversible.extensionpoint;

import org.eclipse.papyrus.adl4eclipse.org.ADL4Eclipse_Stereotypes;
import org.eclipse.papyrus.adltool.reversible.AbstractReversible;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleProject;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * This abstract class provides the default implementation of the
 * {@link ReversibleExtensionPoint} adapter.
 */
public abstract class AbstractExtensionPoint extends AbstractReversible<Component>implements ReversibleExtensionPoint {

	protected ReversibleProject parent;

	@Override
	public ReversibleProject getParent() {
		return parent;
	}

	@Override
	public void setParent(ReversibleProject parent) {
		this.parent = parent;
	}

	@Override
	public String getStereotypeName() {
		return ADL4Eclipse_Stereotypes.EXTENSION_POINT_STEREOTYPE;
	}

	@Override
	public String getDependencyStereotypeName() {
		return ADL4Eclipse_Stereotypes.EXTENSION_POINT_REFERENCE;
	}

	@Override
	public Type getType() {
		return Type.EXTENSION_POINT;
	}

	@Override
	public Component createRepresentation() {
		return UMLFactory.eINSTANCE.createComponent();
	}

}
