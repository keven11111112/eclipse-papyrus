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
package org.eclipse.papyrus.adltool.designer;

/**
 * This class holds the settings needed for the ArchitectureSnapshotDesigner.
 */
public class ReverseSettings {

	/**
	 * Whether the designer should reverse the projects dependencies or not.
	 */
	private boolean reverseDependencies;

	/**
	 * Whether the designer should reverse the exported packages or not.
	 */
	private boolean reverseExportPackages;

	/**
	 * Whether the designer should reverse the extension points or not.
	 */
	private boolean reverseExtensionPoints;

	/**
	 * Whether the designer should reverse the extensions or not.
	 */
	private boolean reverseExtensions;

	/**
	 * The depth of the reverse.
	 */
	private int reverseDepth;

	/**
	 * Default constructor.
	 */
	public ReverseSettings() {
		reverseDepth = 1;
		reverseExtensions = true;
		reverseDependencies = true;
		reverseExportPackages = true;
		reverseExtensionPoints = true;
	}

	/**
	 * @return true if a project's dependencies should be reversed, false of
	 *         not.
	 */
	public boolean reverseDependencies() {
		return reverseDependencies;
	}

	/**
	 * @param reverseDependencies
	 *            the reverseDependencies to set
	 */
	public void setReverseChildren(boolean reverseDependencies) {
		this.reverseDependencies = reverseDependencies;
	}

	/**
	 * @return true if a project's export packages should be reversed, false of
	 *         not.
	 */
	public boolean reverseExportPackages() {
		return reverseExportPackages;
	}

	/**
	 * @param reverseExportPackages
	 *            the reverseExportPackages to set
	 */
	public void setReverseExportPackages(boolean reverseExportPackages) {
		this.reverseExportPackages = reverseExportPackages;
	}

	/**
	 * @return true if a project's extension points should be reversed, false of
	 *         not.
	 */
	public boolean reverseExtensionPoints() {
		return reverseExtensionPoints;
	}

	/**
	 * @param reverseExtensionPoints
	 *            the reverseExtensionPoints to set
	 */
	public void setReverseExtensionPoints(boolean reverseExtensionPoints) {
		this.reverseExtensionPoints = reverseExtensionPoints;
	}

	/**
	 * @return true if a project's extensions should be reversed, false of
	 *         not.
	 */
	public boolean reverseExtensions() {
		return reverseExtensions;
	}

	/**
	 * @param reverseExtensions
	 *            the reverseExtensions to set
	 */
	public void setReverseExtensions(boolean reverseExtensions) {
		this.reverseExtensions = reverseExtensions;
	}

	/**
	 * @return the reverseDepth
	 */
	public int getReverseDepth() {
		return reverseDepth;
	}

	/**
	 * @param reverseDepth
	 *            the reverseDepth to set
	 */
	public void setReverseDepth(int reverseDepth) {
		this.reverseDepth = reverseDepth;
	}

}
