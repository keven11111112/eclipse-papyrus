/*****************************************************************************
 * Copyright (c) 2014, 2017 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 505330
 *****************************************************************************/
package org.eclipse.papyrus.migration.rsa.wizard;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.migration.rsa.Activator;
import org.eclipse.papyrus.migration.rsa.RSAToPapyrusParameters.Config;
import org.eclipse.papyrus.migration.rsa.internal.ConfigurationManager;
import org.eclipse.papyrus.migration.rsa.messages.Messages;
import org.eclipse.papyrus.migration.rsa.transformation.ImportTransformationLauncher;
import org.eclipse.papyrus.migration.rsa.wizard.pages.DialogData;
import org.eclipse.papyrus.migration.rsa.wizard.pages.TransformationConfigPage;
import org.eclipse.papyrus.migration.rsa.wizard.pages.TransformationSelectionPage;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

/**
 * 
 * Wizard handling the selection and transformation of .emx/.epx files
 * 
 * @author Quentin Le Menez
 *
 */
public class TransformationWizard extends Wizard implements IImportWizard {

	protected IWizardPage currentPage;

	protected DialogData dialogData = new DialogData();

	protected TransformationSelectionPage selectionPage = new TransformationSelectionPage(dialogData);

	protected TransformationConfigPage configPage = new TransformationConfigPage(dialogData);

	private ConfigurationManager configMan = new ConfigurationManager();

	public TransformationWizard() {
		setWindowTitle(Messages.TransformationWizard_Title);

		configMan.loadConfig(dialogData.getConfig());
	}

	@Override
	public void dispose() {
		try {
			configMan.dispose();
		} finally {
			super.dispose();
		}
	}

	@Override
	public void addPages() {
		this.addPage(selectionPage);
		this.addPage(configPage);
	}

	@Override
	public IWizardPage getNextPage(IWizardPage currentPage) {
		if (currentPage == selectionPage) {
			this.currentPage = configPage;
			// Resets the viewer input in order to show the newly selected elements from the selectionPage
			configPage.resetViewerInput();
			return configPage;
		}
		if (this.currentPage == configPage) {
			this.currentPage = selectionPage;
		}
		return null;
	}

	@Override
	public boolean canFinish() {
		if (currentPage == configPage) {
			return super.canFinish();
		}
		return false;
	}

	@Override
	public boolean performCancel() {
		removeWizardImportedProjects();
		return super.performCancel();
	}

	@Override
	public boolean performFinish() {
		configMan.saveConfig(dialogData.getConfig());

		// Set or update the unchecked elements for future executions of the plugin
		dialogData.setSelectionMap();
		importFiles();

		// Remove the imported projects from the workspace
		// removeWizardImportedProjects();

		return true;
	}


	/**
	 * 
	 * Remove any imported projects, through the wizard, from the workspace
	 * 
	 */
	public void removeWizardImportedProjects() {
		if (/* dialogData != null && */dialogData.getImportedProjects() != null) {
			for (Object object : dialogData.getImportedProjects()) {
				if (object instanceof IProject) {
					IProject project = (IProject) object;
					try {
						project.delete(false, true, null);
					} catch (CoreException e) {
						Activator.log.error(e);
					}
				}
			}
		}
	}

	/**
	 *
	 * Launch the transformation with the previously selected files and configuration parameters
	 *
	 */
	protected void importFiles() {
		Config config = dialogData.getConfig();
		if (config == null) {
			return;
		}

		List<URI> urisToImport = new LinkedList<URI>();

		for (Object selectedFile : dialogData.getTransformationFiles()) {
			String path = null;
			if (selectedFile instanceof IFile) {
				path = ((IFile) selectedFile).getFullPath().toString();
			}
			if (path != null) {
				URI uri = URI.createPlatformResourceURI(path, true);
				urisToImport.add(uri);
			}
		}

		// The wizard's Shell will be disposed because the transformation is asynchronous. Use the Shell's parent instead
		ImportTransformationLauncher launcher = new ImportTransformationLauncher(config, this.getShell().getParent());
		launcher.run(urisToImport);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// nothing
	}


}
