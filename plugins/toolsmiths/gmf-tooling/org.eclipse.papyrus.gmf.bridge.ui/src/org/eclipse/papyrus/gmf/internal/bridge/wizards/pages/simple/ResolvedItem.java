/******************************************************************************
 * Copyright (c) 2006, 2020 Eclipse.org, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Dmitry Stadnik - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge.wizards.pages.simple;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.gmf.internal.bridge.resolver.TypePattern;

/**
 * @author dstadnik
 */
public class ResolvedItem {

	public enum Resolution {
		NODE,
		LINK,
		LABEL
	}

	public static final Resolution[] NO_RESOLUTIONS = { null };

	public static final Resolution[] ALL_RESOLUTIONS = { null, Resolution.NODE, Resolution.LINK, Resolution.LABEL };

	public static final Resolution[] NODE_LINK_RESOLUTIONS = { null, Resolution.NODE, Resolution.LINK };

	public static final Resolution[] LINK_RESOLUTIONS = { null, Resolution.LINK };

	public static final Resolution[] LABEL_RESOLUTIONS = { null, Resolution.LABEL };

	private Resolution resolution;

	private Object domainRef;

	private TypePattern pattern;

	private Resolution[] possibleResolutions;

	private boolean disabled;

	private ResolvedItem parent;

	private List<ResolvedItem> children = new ArrayList<ResolvedItem>();

	public ResolvedItem(Resolution resolution, Object domainRef, TypePattern pattern, Resolution[] possibleResolutions, boolean disabled) {
		this.resolution = resolution;
		this.domainRef = domainRef;
		this.pattern = pattern;
		this.possibleResolutions = possibleResolutions;
		this.disabled = disabled;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public Resolution[] getPossibleResolutions() {
		return possibleResolutions;
	}

	public boolean isPossibleResolution(Resolution possibleResolution) {
		for (int i = 0; i < possibleResolutions.length; i++) {
			if (possibleResolutions[i] == possibleResolution) {
				return true;
			}
		}
		return false;
	}

	public Resolution getResolution() {
		return resolution;
	}

	public void setResolution(Resolution resolution) {
		this.resolution = resolution;
	}

	public Object getDomainRef() {
		return domainRef;
	}

	public TypePattern getPattern() {
		return pattern;
	}

	public ResolvedItem getParent() {
		return parent;
	}

	public void addChild(ResolvedItem child) {
		children.add(child);
		child.parent = this;
	}

	public void removeChild(ResolvedItem child) {
		if (children.remove(child)) {
			child.parent = null;
		}
	}

	public List<ResolvedItem> getChildren() {
		return children;
	}
}
