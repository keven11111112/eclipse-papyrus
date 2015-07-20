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

import java.util.List;

import org.eclipse.papyrus.adltool.reversible.Reversible;
import org.eclipse.papyrus.adltool.reversible.extension.SchemaElement;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleProject;
import org.eclipse.uml2.uml.Component;

/**
 * The interface representing a reversible extension point.<br />
 * A reversed extension is a {@link org.eclipse.uml2.uml.Component
 * Component} inside it's reversible parent's representation.
 */
public interface ReversibleExtensionPoint extends Reversible<Component> {

	/**
	 * Gets the reversible parent.
	 *
	 * @return
	 */
	ReversibleProject getParent();

	/**
	 * Sets the reversible parent.
	 *
	 * @param parent
	 */
	void setParent(ReversibleProject parent);

	/**
	 * Gets the extension point's elements.
	 *
	 * @return
	 */
	List<SchemaElement> getElements();

}
