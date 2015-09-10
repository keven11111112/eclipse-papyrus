/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.adl4eclipsetool.assistant;

import java.util.Set;

import org.eclipse.papyrus.adltool.ADL4EclipseUtils;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleProject;

/**
 * This class is used to do the reverse engineering from workspace plug-in. It adds only in the platform dependencies.
 */
public class SimplePluginImport extends AbstractImportWizard {

	private static final boolean ADVANCED_MODE = false;

	public SimplePluginImport() {
		super(ADVANCED_MODE);
	}

	@Override
	protected Set<ReversibleProject> getReversibleList() {
		return ADL4EclipseUtils.getWorkspacePlugins();
	}
}
