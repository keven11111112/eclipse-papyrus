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
package org.eclipse.papyrus.adltool.reversible.packages;

import org.eclipse.papyrus.adltool.reversible.Reversible;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleProject;
import org.eclipse.uml2.uml.Package;

public interface ReversiblePackage extends Reversible<Package> {

	/**
	 * Gets the ReversibleProject parent of this package.
	 * @return
	 */
	ReversibleProject getParent();

	/**
	 * Sets the ReversibleProject parent of this package.
	 * @param parent
	 */
	void setParent(ReversibleProject parent);
}
