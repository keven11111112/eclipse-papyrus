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

import java.util.Set;

import org.eclipse.papyrus.adltool.ADL4EclipseUtils;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleProject;

public class AdvanceFeatureImport extends AbstractImportWizard {
	private static boolean ADVANCED_MODE = true;

	public AdvanceFeatureImport() {
		super(ADVANCED_MODE);
	}

	@Override
	protected Set<ReversibleProject> getReversibleList() {
		return ADL4EclipseUtils.getReversibleFeatures();
	}

}
