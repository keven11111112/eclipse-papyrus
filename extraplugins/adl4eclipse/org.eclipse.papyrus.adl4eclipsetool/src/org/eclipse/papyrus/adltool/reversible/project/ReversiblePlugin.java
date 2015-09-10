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
import org.eclipse.papyrus.adltool.reversible.packages.ReversiblePackage;

/**
 * Projects that implements that interface are reversible plug-ins that
 * contain exported packages, extension points and extensions.
 */
public interface ReversiblePlugin extends ReversibleProject {

	/**
	 * Returns whether the plug-in is a singleton or not.
	 *
	 * @return true if the plug-in is a singleton, false of not
	 */
	boolean isSingleton();

	/**
	 * Returns a list containing all the exported packages names.
	 *
	 * @return the list of reversible exported packages
	 */
	List<ReversiblePackage> getExportedPackages();

	/**
	 * Sets the list of exported package.
	 *
	 * @param exportedPackages
	 */
	void setExportedPackages(List<ReversiblePackage> exportedPackages);

	/**
	 * Returns a list containing all the imported packages names.
	 *
	 * @return the list of reversible imported packages
	 */
	List<ReversiblePackage> getImportedPackages();

	/**
	 * Sets the list of imported package.
	 *
	 * @param exportedPackages
	 */
	void setImportedPackages(List<ReversiblePackage> importedPackages);

	/**
	 * Returns a list of reversible corresponding to the project's extension
	 * points.
	 *
	 * @return the list of reversible extension points
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
	 * @return the list of reversible extensions
	 */
	List<ReversibleExtension> getExtensions();

	/**
	 * Sets the list of reversible extensions.
	 *
	 * @param extensions
	 */
	void setExtensions(List<ReversibleExtension> extensions);

}
