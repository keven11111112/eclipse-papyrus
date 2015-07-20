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

import java.util.List;

import org.eclipse.papyrus.adltool.reversible.Reversible;
import org.eclipse.papyrus.adltool.reversible.extensionpoint.ReversibleExtensionPoint;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleProject;
import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * The interface representing a reversible extension.<br />
 * A reversed extension is an {@link org.eclipse.uml2.uml.InstanceSpecification
 * InstanceSpecification} inside it's reversible parent's representation.
 */
public interface ReversibleExtension extends Reversible<InstanceSpecification> {

	/**
	 * Returns the extension's parent.
	 *
	 * @return the extension's parent or null if it does not exists
	 */
	ReversibleProject getParent();

	/**
	 * Sets the extension's parent.
	 *
	 * @param project the extension's parent
	 */
	void setParent(ReversibleProject project);

	/**
	 * Returns the extension point this extension contributes to.
	 *
	 * @return the extension point or null if it does not exist
	 */
	ReversibleExtensionPoint getExtensionPoint();

	/**
	 * Returns the list of the ExtensionPoint elements used by this extension.
	 *
	 * @return the list of ExtensionPoint elements used by this extension.
	 */
	List<SchemaElement> getElements();

}
