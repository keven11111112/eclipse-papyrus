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
package org.eclipse.papyrus.adl4eclipsetool.assistant;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.papyrus.adltool.ADL4EclipseUtils;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleProject;

public class CompleteImport extends AbstractImportWizard {

	private static final boolean ADVANCED_MODE = true;

	public CompleteImport() {
		super(ADVANCED_MODE);
	}

	@Override
	protected Set<ReversibleProject> getReversibleList() {
		Set<ReversibleProject> reversibleList = new HashSet<>();

		reversibleList.addAll(ADL4EclipseUtils.getReversibleFeatures());
		reversibleList.addAll(ADL4EclipseUtils.getLoadedPlugins());
		reversibleList.addAll(ADL4EclipseUtils.getWorkspacePlugins());

		return reversibleList;
	}

}
