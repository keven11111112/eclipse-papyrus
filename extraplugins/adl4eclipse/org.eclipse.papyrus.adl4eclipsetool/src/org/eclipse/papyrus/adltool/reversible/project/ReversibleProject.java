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
package org.eclipse.papyrus.adltool.reversible.project;

import java.util.List;

import org.eclipse.papyrus.adltool.reversible.Reversible;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Component;

/**
 * Reversibles that implement this interface can contain other reversibles and
 * be displayed in a tree.
 */
public interface ReversibleProject extends Reversible<Component> {

	/**
	 * Returns the reversible dependencies.
	 *
	 * @return
	 */
	List<ReversibleProject> getDependencies();

	/**
	 * Returns the version range of a dependency.
	 *
	 * @return
	 */
	StereotypeVersion getReversibleVersion(Reversible<?> reversible);

	/**
	 * Sets the version range of a reversible.
	 *
	 * @param reversible
	 * @param version
	 */
	void setReversibleVersion(Reversible<?> reversible, StereotypeVersion version);

	/**
	 * Gets the description.
	 *
	 * @return the description or null.
	 */
	String getDescription();

	/**
	 * Gets the image name corresponding to the reversible object.
	 *
	 * @return
	 */
	Image getImage();

}
