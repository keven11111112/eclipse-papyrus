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

package org.eclipse.papyrus.customization.nattableconfiguration.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.File;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.papyrus.customization.nattableconfiguration.CreateNattableConfigurationWizard;
import org.eclipse.papyrus.customization.nattableconfiguration.utils.NattableConfigurationConstants;
import org.eclipse.papyrus.infra.nattable.handler.AbstractTableHandler;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TableHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.TableEditingDomainUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * The handler of the nattable configuration wwizard.
 */
public class CreateTableConfigurationWizardHandler extends AbstractTableHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {

		final String selectionParameter = event.getParameter("org.eclipse.papyrus.customization.nattableconfiguration.configurationParemeter"); //$NON-NLS-1$
		
		Resource resourceSelected = null;
		
		if(null != selectionParameter && selectionParameter.equals("nattableconfiguration")){ //$NON-NLS-1$
			final ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
			resourceSelected = getSelectedResource(currentSelection);
		}
		
		final TableConfiguration configuration = getEditedTableConfiguration(resourceSelected);
		final CreateNattableConfigurationWizard wizard = new CreateNattableConfigurationWizard(configuration, resourceSelected);
		final WizardDialog dialog = new WizardDialog(Display.getDefault().getActiveShell(), wizard);
		dialog.open();
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractTableHandler#setEnabled(java.lang.Object)
	 */
	@Override
	public void setEnabled(final Object evaluationContext) {
		super.setEnabled(evaluationContext);
		setBaseEnabled(true);
	}

	protected Resource getSelectedResource(final ISelection currentSelection) {
		Resource resource = null;

		if (currentSelection instanceof StructuredSelection && 1 == ((StructuredSelection) currentSelection).size()) {
			final Object selectedElement = ((StructuredSelection) currentSelection).getFirstElement();
			if (selectedElement instanceof File && NattableConfigurationConstants.NATTABLE_CONFIGURATION_EXTENSION_FILE.equals(((File) selectedElement).getFileExtension())) {

				INattableModelManager manager = null;
				final IEditorPart currentPart = getActivePart().getSite().getPage().getActiveEditor();
				if (null != currentPart) {
					manager = (INattableModelManager) currentPart.getAdapter(INattableModelManager.class);
				}

				if (null != manager) {
					resource = TableEditingDomainUtils.getTableEditingDomain(manager.getTable()).getResourceSet().getResource(URI.createFileURI(((File) selectedElement).getLocation().toString()), true);
				}
			}
		}

		return resource;
	}

	/**
	 * Get the edited table configuration.
	 * 
	 * @return
	 * 		the edited table configuration.
	 */
	protected TableConfiguration getEditedTableConfiguration(final Resource resource) {
		TableConfiguration configuration = null;

		boolean isCreation = true;

		if (null != resource) {
			if (!resource.getContents().isEmpty() && resource.getContents().get(0) instanceof TableConfiguration) {
				configuration = EcoreUtil.copy((TableConfiguration) resource.getContents().get(0));
				isCreation = false;
			}
		}

		if (isCreation) {
			// 1. create the configuration itself
			configuration = NattableconfigurationFactory.eINSTANCE.createTableConfiguration();

			// 2. create the row and the column header axis configuration
			final TableHeaderAxisConfiguration rowHeaderAxisConfiguration = NattableaxisconfigurationFactory.eINSTANCE.createTableHeaderAxisConfiguration();
			final TableHeaderAxisConfiguration columnHeaderAxisConfiguration = NattableaxisconfigurationFactory.eINSTANCE.createTableHeaderAxisConfiguration();
			configuration.setColumnHeaderAxisConfiguration(columnHeaderAxisConfiguration);
			configuration.setRowHeaderAxisConfiguration(rowHeaderAxisConfiguration);
		}

		return configuration;
	}
}
