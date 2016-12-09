/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.migration.rhapsody.transformations;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.migration.common.MigrationParameters.ThreadConfig;
import org.eclipse.papyrus.migration.common.transformation.AbstractImportTransformationLauncher;
import org.eclipse.papyrus.migration.common.transformation.IDependencyAnalysisHelper;
import org.eclipse.papyrus.migration.common.transformation.IImportTransformation;
import org.eclipse.papyrus.migration.rhapsody.importer.SelectedRhapsodyFilesImporter;
import org.eclipse.papyrus.migration.rhapsody.utils.RhapsodyShareFolderUtils;
import org.eclipse.swt.widgets.Control;

/**
 * @author Vincent Lorenzo
 *
 */
public class RhapsodyImportTransformationLauncher extends AbstractImportTransformationLauncher {

	private SelectedRhapsodyFilesImporter importer;
	public RhapsodyImportTransformationLauncher(ThreadConfig config) {
		super(config, null);
	}

	public RhapsodyImportTransformationLauncher(ThreadConfig config, Control baseControl) {
		super(config, baseControl);
	}

	/**
	 * @see org.eclipse.papyrus.migration.common.transformation.IImportTransformationLauncher#run(java.util.List)
	 *
	 * @param urisToImport
	 */
	@Override
	public void run(List<URI> urisToImport) {
		if (true == RhapsodyShareFolderUtils.checkRhapsodyShareFolderAndAskForItWhenRequired()) {
			importer = new SelectedRhapsodyFilesImporter(urisToImport);
			super.run(importer.getRhapsodyFilesToImportURI());
		}
	}

	/**
	 * @see org.eclipse.papyrus.migration.rhapsody..transformations.NEW_AbstractImportTransformationLauncher__NEW#createDependencyAnalysisHelper(org.eclipse.papyrus.migration.common.MigrationParameters.Config)
	 *
	 * @param config
	 * @return
	 */
	@Override
	protected IDependencyAnalysisHelper createDependencyAnalysisHelper(ThreadConfig config) {
		return new RhapsodyDependencyAnalysisHelper(config);
	}

	/**
	 * @see org.eclipse.papyrus.migration.rhapsody..transformations.NEW_AbstractImportTransformationLauncher__NEW#createTransformation(org.eclipse.emf.common.util.URI, org.eclipse.papyrus.migration.common.MigrationParameters.Config,
	 *      org.eclipse.papyrus.migration.common.transformation.IDependencyAnalysisHelper)
	 *
	 * @param transformationURI
	 * @param config
	 * @param analysisHelper
	 * @return
	 */
	@Override
	protected IImportTransformation createTransformation(URI transformationURI, ThreadConfig config, IDependencyAnalysisHelper analysisHelper) {
		return new RhapsodyImportTransformation(transformationURI, config, analysisHelper);
	}

}
