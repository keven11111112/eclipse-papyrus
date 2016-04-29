/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.customization.nattableconfiguration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.customization.nattableconfiguration.helper.TableConfigurationHelper;
import org.eclipse.papyrus.customization.nattableconfiguration.messages.Messages;
import org.eclipse.papyrus.customization.nattableconfiguration.pages.ColumnConfigurationWizardPage;
import org.eclipse.papyrus.customization.nattableconfiguration.pages.EditGenericNattableConfigurationFieldsNattableWizardPage;
import org.eclipse.papyrus.customization.nattableconfiguration.pages.NattableConfigurationProjectCreationPage;
import org.eclipse.papyrus.customization.nattableconfiguration.pages.RowConfigurationWizardPage;
import org.eclipse.papyrus.customization.nattableconfiguration.pages.SlaveConfigurationWizardPage;
import org.eclipse.papyrus.customization.nattableconfiguration.utils.NattableConfigurationConstants;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResourceSet;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration;
import org.eclipse.papyrus.infra.nattable.wizard.AbstractTableWizard;
import org.eclipse.pde.internal.ui.wizards.IProjectProvider;
import org.eclipse.pde.internal.ui.wizards.plugin.NewProjectCreationOperation;
import org.eclipse.pde.internal.ui.wizards.plugin.PluginContentPage;
import org.eclipse.pde.internal.ui.wizards.plugin.PluginFieldData;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PlatformUI;

/**
 * The wizard to manage the nattable configuration.
 */
public class CreateNattableConfigurationWizard extends AbstractTableWizard {

	/**
	 * The dot string.
	 */
	private static final String DOT = "."; //$NON-NLS-1$
	
	/**
	 * The generate plugin activator setting.
	 */
	private static final String GENERATE_PlUGIN_ACTIVATOR = "generatePluginActivator"; //$NON-NLS-1$
	
	/**
	 * The ui plugin setting.
	 */
	private static final String UI_PLUGIN = "uiPlugin"; //$NON-NLS-1$

	/**
	 * The edited table configuration
	 */
	private final TableConfiguration configuration;

	/**
	 * The initial resource selected.
	 */
	private Resource initialResource;

	/**
	 * the edited Table Configuration Helper;
	 */
	private TableConfigurationHelper helper;

	/**
	 * Boolean to determinate if this is a project creation or just an edition.
	 */
	private boolean isProjectCreation = false;

	/**
	 * The page for the project creation.
	 */
	private NattableConfigurationProjectCreationPage nattableConfigurationProjectCreationPage;

	/**
	 * The project provider.
	 */
	private IProjectProvider projectProvider;

	/**
	 * The content page for the project creation.
	 */
	protected PluginContentPage contentPage;

	/**
	 * The fields data to manage the project creation
	 */
	private PluginFieldData pluginData;

	/**
	 * Constructor.
	 *
	 * @param configuration
	 *            The edited table configuration.
	 * @param initialResource
	 *            The initial nattable configuration resource.
	 */
	public CreateNattableConfigurationWizard(final TableConfiguration configuration, final Resource initialResource) {
		this.configuration = configuration;
		this.helper = new TableConfigurationHelper(this.configuration);
		final ImageDescriptor desc = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImageDescriptor(Activator.PLUGIN_ID, NattableConfigurationConstants.ICON_WIZBAN_PATH);
		setDefaultPageImageDescriptor(desc);
		setWindowTitle(Messages.CreateNattableConfigurationWizard_WizardTitke);
		setForcePreviousAndNextButtons(true);

		this.initialResource = initialResource;

		isProjectCreation = null == this.initialResource;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		if (isProjectCreation) {

			pluginData = new PluginFieldData();

			nattableConfigurationProjectCreationPage = new NattableConfigurationProjectCreationPage(pluginData, new StructuredSelection());
			addPage(nattableConfigurationProjectCreationPage);

			projectProvider = new IProjectProvider() {
				@Override
				public String getProjectName() {
					return nattableConfigurationProjectCreationPage.getProjectName();
				}

				@Override
				public IProject getProject() {
					return nattableConfigurationProjectCreationPage.getProjectHandle();
				}

				@Override
				public IPath getLocationPath() {
					return nattableConfigurationProjectCreationPage.getLocationPath();
				}
			};

			contentPage = new PluginContentPage("page2", projectProvider, nattableConfigurationProjectCreationPage, pluginData); //$NON-NLS-1$

			addPage(contentPage);
		}
		addPage(new EditGenericNattableConfigurationFieldsNattableWizardPage(this.helper));
		addPage(new RowConfigurationWizardPage(this.helper));
		addPage(new ColumnConfigurationWizardPage(this.helper));
		addPage(new SlaveConfigurationWizardPage(this.helper));
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#getDialogSettings()
	 */
	@Override
	public IDialogSettings getDialogSettings() {
		DialogSettings dialogSettings = new DialogSettings(""); //$NON-NLS-1$
		dialogSettings.put(GENERATE_PlUGIN_ACTIVATOR, true);
		dialogSettings.put(UI_PLUGIN, false);
		return dialogSettings;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		boolean result = false;

		IProject createdProject = null;

		if (isProjectCreation) {
			try {

				// Create the project
				getContainer().run(false, true, new NewProjectCreationOperation(pluginData, projectProvider, null));

				createdProject = projectProvider.getProject();

				// Set the project into the working sets
				final IWorkingSet[] workingSets = nattableConfigurationProjectCreationPage.getSelectedWorkingSets();
				if (0 < workingSets.length) {
					PlatformUI.getWorkbench().getWorkingSetManager().addToWorkingSets(createdProject, workingSets);
				}

				// Copy the about file
				copyAboutFile(createdProject);

				StringBuilder nattableConfigurationFileName = new StringBuilder(nattableConfigurationProjectCreationPage.getNattableConfigurationFileName());

				// Check if the file has the nattable configuration extension file, else add it
				if (!nattableConfigurationFileName.toString().contains(DOT)
						|| !NattableConfigurationConstants.NATTABLE_CONFIGURATION_EXTENSION_FILE.equals(nattableConfigurationFileName.toString().substring(nattableConfigurationFileName.lastIndexOf(DOT) + 1))) {
					nattableConfigurationFileName.append(DOT);
					nattableConfigurationFileName.append(NattableConfigurationConstants.NATTABLE_CONFIGURATION_EXTENSION_FILE);
				}

				final ResourceSet set = new ResourceSetImpl();
				final StringBuilder nattableConfFileURI = new StringBuilder();
				nattableConfFileURI.append(createdProject.getLocation());
				nattableConfFileURI.append(NattableConfigurationConstants.CONFIG_FOLDER);
				nattableConfFileURI.append(nattableConfigurationFileName);
				initialResource = set.createResource(URI.createFileURI(nattableConfFileURI.toString()));
				initialResource.getContents().add(configuration);

				result = true;
			} catch (final InvocationTargetException e) {
				Activator.logException(e);
			} catch (final InterruptedException e) {
				Activator.logException(e);
			}
		} else if (null != initialResource) {
			ServicesRegistry registry;
			try {
				registry = ServiceUtilsForResourceSet.getInstance().getServiceRegistry(initialResource.getResourceSet());
				final TransactionalEditingDomain editingDomain = registry.getService(TransactionalEditingDomain.class);

				final CommandStack commandStack = editingDomain.getCommandStack();
				commandStack.execute(new RecordingCommand(editingDomain) {

					@Override
					protected void doExecute() {
						// Save DiagramDialog at proper position
						if (null != initialResource) {
							initialResource.getContents().clear();
							initialResource.getContents().add(configuration);
						}
					}
				});

				result = true;
			} catch (final ServiceException e) {
				Activator.logException(e);
			}
		}

		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		saveOptions.put(Resource.OPTION_LINE_DELIMITER, Resource.OPTION_LINE_DELIMITER_UNSPECIFIED);

		try {
			initialResource.save(saveOptions);
		} catch (final IOException e) {
			Activator.logException(e);
			result = false;
		}

		return result;
	}

	/**
	 * This allows to copy the about file in the created project.
	 * 
	 * @param createdProject
	 *            The created project.
	 */
	protected void copyAboutFile(final IProject createdProject) {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			final URL url = Activator.getDefault().getBundle().getResource(NattableConfigurationConstants.ABOUT_FILE_NAME);
			inputStream = url.openStream();

			final File newAboutFile = new File(createdProject.getLocation().toOSString() + File.separator + NattableConfigurationConstants.ABOUT_FILE_NAME);
			newAboutFile.createNewFile();

			outputStream = new FileOutputStream(newAboutFile);

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (final IOException e) {
			Activator.logException(e);
		} finally {
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (final IOException e) {
					Activator.logException(e);
				}
			}
			if (null != outputStream) {
				try {
					// outputStream.flush();
					outputStream.close();
				} catch (final IOException e) {
					Activator.logException(e);
				}

			}
		}
	}
}
