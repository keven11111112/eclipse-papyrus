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

import org.eclipse.papyrus.adltool.reversible.extension.ReversibleExtension;
import org.eclipse.papyrus.adltool.reversible.extensionpoint.ReversibleExtensionPoint;

/**
 * Projects that implements that interface are reversible plug-ins that
 * contain exported packages, extension points and extensions.
 */
public interface ReversiblePlugin extends ReversibleProject {

	/**
	 * Returns a list containing all the exported packages names.
	 *
	 * @return
	 */
	List<String> getExportedPackages();

	/**
	 * Returns a list of reversible corresponding to the project's extension
	 * points.
	 *
	 * @return
	 */
	List<ReversibleExtensionPoint> getExtensionPoints();

	/**
	 * Sets the list of extension points.
	 *
	 * @param extensionPoints
	 */
	void setExtensionPoints(List<ReversibleExtensionPoint> extensionPoints);

	/**
	 * Returns a list of extensions.
	 *
	 * @return
	 */
	List<ReversibleExtension> getExtensions();

	/**
	 * Sets the list of reversible extensions.
	 *
	 * @param extensions
	 */
	void setExtensions(List<ReversibleExtension> extensions);

}
