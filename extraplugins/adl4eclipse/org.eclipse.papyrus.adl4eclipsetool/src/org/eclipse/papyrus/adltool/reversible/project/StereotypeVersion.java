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

import org.eclipse.osgi.service.resolver.VersionRange;
import org.eclipse.papyrus.adltool.ADL4EclipseUtils;
import org.osgi.framework.Version;

/**
 * This class represents a stereotyped dependency version. It wraps simple OSGi
 * {@link org.osgi.framework.Version Version} identifier and
 * {@link org.osgi.framework.Version VersionRange}
 */
public class StereotypeVersion {

	/**
	 * The floor of the version.
	 */
	private String floor;

	/**
	 * The ceiling of the version.
	 */
	private String ceiling;

	/**
	 * Whether the floor should be included or not.
	 */
	private boolean includeFloor;

	/**
	 * Whether the ceiling should be included or not.
	 */
	private boolean includeCeiling;

	/**
	 * VersionRange flag used to generate the readable version.
	 */
	private boolean versionRange = false;

	/**
	 * Constructor.
	 *
	 * @param floor the readable version
	 */
	public StereotypeVersion(String floor) {
		setFloor(floor);
	}

	/**
	 * Constructor.
	 *
	 * @param version the OSGi version
	 */
	public StereotypeVersion(Version version) {
		floor = ADL4EclipseUtils.formatVersion(version);
	}

	/**
	 * Constructor.
	 *
	 * @param version the OSGi version range
	 */
	public StereotypeVersion(VersionRange version) {
		Version left = version.getLeft();
		Version right = version.getRight();

		setFloor(ADL4EclipseUtils.formatVersion(left));
		setIncludeFloor(version.getIncludeMinimum());

		if (right != null) {
			setCeiling(ADL4EclipseUtils.formatVersion(right));
			setIncludeCeiling(version.getIncludeMaximum());
		}
	}

	/**
	 * Constructor.
	 *
	 * @param floor
	 * @param ceiling
	 * @param includeFloor
	 * @param includeCeiling
	 */
	public StereotypeVersion(String floor, String ceiling, boolean includeFloor, boolean includeCeiling) {
		setFloor(floor);
		setCeiling(ceiling);
		setIncludeFloor(includeFloor);
		setIncludeCeiling(includeCeiling);
	}

	/**
	 * Returns the floor of the version.<br />
	 * If the version is not flagged as version range, the floor corresponds to
	 * the version.
	 *
	 * @return the floor of the version
	 */
	public String getFloor() {
		return floor;
	}

	/**
	 * Sets the floor of the version.
	 *
	 * @param floor the floor of the version
	 */
	public void setFloor(String floor) {
		this.floor = floor;
	}

	/**
	 * Gets the ceiling of the version.
	 *
	 * @return the ceiling of the version
	 */
	public String getCeiling() {
		return ceiling;
	}

	/**
	 * Sets the ceiling of the version. <br />
	 * If the ceiling is not null, the version is flagged as version range.
	 *
	 * @param ceiling the ceiling of the version
	 */
	public void setCeiling(String ceiling) {
		this.ceiling = ceiling;
		versionRange = ceiling != null;
	}

	/**
	 * Returns whether the floor should be included or not.
	 *
	 * @return true if the floor should be included, false if not
	 */
	public boolean includeFloor() {
		return includeFloor;
	}

	/**
	 * Sets whether the floor should be included or not.
	 *
	 * @param includeFloor the new value
	 */
	public void setIncludeFloor(boolean includeFloor) {
		this.includeFloor = includeFloor;
	}

	/**
	 * Returns whether the ceiling should be included or not.
	 *
	 * @return true if the ceiling should be included, false if not
	 */
	public boolean includeCeiling() {
		return includeCeiling;
	}

	/**
	 * Sets whether the ceiling should be included or not.
	 *
	 * @param includeCeiling the new value
	 */
	public void setIncludeCeiling(boolean includeCeiling) {
		this.includeCeiling = includeCeiling;
	}

	/**
	 * Returns the OSGi version range in an interval notation.<br />
	 * If the version is not flagged as version range, the generated output will
	 * be the version.<br />
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		if (versionRange) {
			if (includeFloor) {
				sb.append("[");
			} else {
				sb.append("(");
			}
		}

		sb.append(floor);

		if (versionRange) {
			if (ceiling != null) {
				sb.append(",");
				sb.append(ceiling);

				if (includeCeiling) {
					sb.append("]");
				} else {
					sb.append(")");
				}
			}
		}

		return sb.toString();
	}

}
