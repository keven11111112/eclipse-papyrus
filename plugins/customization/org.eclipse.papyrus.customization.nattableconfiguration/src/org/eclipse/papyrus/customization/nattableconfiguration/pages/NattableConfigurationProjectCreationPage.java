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

package org.eclipse.papyrus.customization.nattableconfiguration.pages;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.customization.nattableconfiguration.messages.Messages;
import org.eclipse.pde.internal.ui.wizards.plugin.AbstractFieldData;
import org.eclipse.pde.internal.ui.wizards.plugin.NewProjectCreationPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

/**
 * This allows to initialise the nattable configuration creation by getting the name of the plugin to create and the nattable configuration name.
 */
public class NattableConfigurationProjectCreationPage extends NewProjectCreationPage {

	/**
	 * The nattable configuration file name text composite.
	 */
	private Text nattableConfigurationFileName;

	/**
	 * The file name modify listener.
	 */
	private Listener fileNameModifyListener = new Listener() {

		@Override
		public void handleEvent(final Event e) {
			setPageComplete(canFlipToNextPage());
		}
	};
	
	/**
	 * Constructor.
	 *
	 * @param helper
	 *            The table configuration helper.
	 */
	public NattableConfigurationProjectCreationPage(final AbstractFieldData data, final IStructuredSelection selection) {
		super(Messages.NattableConfigurationProjectCreationPage_pageName, data, false, selection);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(final Composite parent) {
		
		super.createControl(parent);
		final Composite composite = (Composite) getControl();
		composite.setLayoutData(new GridData(SWT.FILL, SWT.DOWN, true, false));
		final GridLayout gridLayout = new GridLayout(1, false);
		composite.setLayout(gridLayout);
		setControl(composite);
		final Group group = createGroup(composite, Messages.NattableConfigurationProjectCreationPage_nattableConfigurationFileNameLabel);
		nattableConfigurationFileName = new Text(group, SWT.BORDER);
		nattableConfigurationFileName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		nattableConfigurationFileName.addListener(SWT.Modify, fileNameModifyListener);
		setPageComplete(false);
	}

	/**
	 * Creates the group.
	 *
	 * @param parent
	 *            the parent
	 * @param name
	 *            the name
	 * @return the group
	 */
	private static Group createGroup(final Composite parent, final String name) {
		final Group group = new Group(parent, SWT.NONE);
		group.setText(name);
		final GridLayout layout = new GridLayout(1, true);
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		group.setLayout(layout);
		final GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		group.setLayoutData(data);
		return group;
	}

	@Override
	protected boolean validatePage() {
		if (null != nattableConfigurationFileName) {
			if ("".equals(nattableConfigurationFileName.getText())) { //$NON-NLS-1$
				this.setErrorMessage("Set nattable configuration file name"); //$NON-NLS-1$
				return false;
			}
		}

		return super.validatePage();
	}

	public String getNattableConfigurationFileName() {
		return nattableConfigurationFileName.getText();
	}

	/**
	 * This method is used to avoid case conflicts between existing and newly created projects
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 *
	 * @return
	 */
	@Override
	public boolean canFlipToNextPage() {
		// retrieve the selected elements and get its children
		boolean canFlip = true;

		final IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		if (canFlip) {
			for (IProject iproject : projects) {
				if (this.getProjectName().equalsIgnoreCase(iproject.getName())) {
					canFlip = false;
					this.setErrorMessage("There already is a project with this name: " + iproject.getName()); //$NON-NLS-1$
					// A conflict has been found, no need to go further
					break;
				}
			}
		}

		if (!validatePage()) {
			canFlip = false;
		}

		return canFlip;
	}
}
