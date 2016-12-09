/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.migration.rhapsody.handlers;

import org.eclipse.papyrus.migration.common.MigrationParameters.ThreadConfig;
import org.eclipse.papyrus.migration.common.handler.AbstractMigrationHandler;
import org.eclipse.papyrus.migration.common.transformation.IImportTransformationLauncher;
import org.eclipse.papyrus.migration.rhapsody.importer.utils.RhapsodyFileUtils;
import org.eclipse.papyrus.migration.rhapsody.transformations.RhapsodyImportTransformationLauncher;
import org.eclipse.swt.widgets.Control;

import com.google.common.collect.Sets;

/**
 * 
 * The handler to run Rhapsody import action when a file is selected
 *
 */
public class ImportRhapsodyHandler extends AbstractMigrationHandler {

	/**
	 * 
	 * Constructor.
	 *
	 */
	public ImportRhapsodyHandler() {
		super(Sets.newHashSet(RhapsodyFileUtils.FILE_EXTENSION_RPY, RhapsodyFileUtils.UML_RHAPSODY_FILE));
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.migration.common.handler.AbstractMigrationHandler#createImportTransformationLauncher(org.eclipse.papyrus.migration.common.MigrationParameters.Config, org.eclipse.swt.widgets.Control)
	 *
	 * @param config
	 * @param baseControl
	 * @return
	 */
	@Override
	protected IImportTransformationLauncher createImportTransformationLauncher(ThreadConfig config, Control baseControl) {
		return new RhapsodyImportTransformationLauncher(config, baseControl);
	}

}
