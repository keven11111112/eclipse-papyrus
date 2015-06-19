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
package org.eclipse.papyrus.adltool.reversible.extension;

import static org.eclipse.papyrus.adltool.Activator.log;

import org.eclipse.papyrus.adl4eclipse.org.IADL4ECLIPSE_Stereotype;
import org.eclipse.papyrus.adltool.reversible.AbstractReversible;
import org.eclipse.papyrus.adltool.reversible.extensionpoint.ReversibleExtensionPoint;
import org.eclipse.papyrus.adltool.reversible.factory.ReversibleFactory;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleProject;
import org.eclipse.papyrus.osgi.profile.IOSGIStereotype;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * This abstract class provides the default implementation (type, representation
 * type, stereotype name to be applied) of the {@link ReversibleExtension}
 * adapter.
 */
public abstract class AbstractExtension extends AbstractReversible<InstanceSpecification>implements ReversibleExtension {

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
		return IADL4ECLIPSE_Stereotype.EXTENSION_STEREOTYPE;
	}

	@Override
	public String getDependencyStereotypeName() {
		return IOSGIStereotype.EXTENSION_REFERENCE;
	}

	@Override
	public Type getType() {
		return Type.EXTENSION;
	}

	@Override
	public InstanceSpecification createRepresentation() {
		return UMLFactory.eINSTANCE.createInstanceSpecification();
	}

	@Override
	public void fillStereotype() {
		if (!applyStereotype()) {
			log.warn(getId() + ": cannot fill the stereotype properties");
		}
	}

	@Override
	public ReversibleExtensionPoint getExtensionPoint() {
		return ReversibleFactory.getInstance().getExtensionPoint(getId());
	}

}
