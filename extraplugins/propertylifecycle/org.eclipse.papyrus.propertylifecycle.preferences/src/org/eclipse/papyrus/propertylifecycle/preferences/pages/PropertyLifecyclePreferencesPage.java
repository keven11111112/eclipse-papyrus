/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.propertylifecycle.preferences.pages;


//import org.eclipse.jface.action.Action;
//import org.eclipse.papyrus.infra.propertylifecycle.preferences.utils.ConvertEcoreToUML;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.papyrus.propertylifecycle.preferences.Activator;
import org.eclipse.papyrus.propertylifecycle.preferences.messages.Messages;
import org.eclipse.papyrus.propertylifecycle.preferences.utils.PropertyLifecyclePreferencesManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Preference Page initiating the creation of its contents and the update of the selected preferences
 * 
 */
public class PropertyLifecyclePreferencesPage extends PreferencePage implements IWorkbenchPreferencePage {

	/** The preferenceManager used to handle the previous and current preferences on the strategies */
	private PropertyLifecyclePreferencesManager preferencesManager = new PropertyLifecyclePreferencesManager();

	/** The root composite containing the page's contents */
	private PropertyLifecyclePageComposite propertyLifecyclePageComposite;

	/**
	 * Constructor.
	 */
	public PropertyLifecyclePreferencesPage() {
		super(Messages.PropertyLifecycle_PreferencePage_Title, Activator.getDefault().getImageDescriptor("/icons/papyrus.png")); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 *
	 * @param workbench
	 */
	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription(Messages.Choose_Configuration);
	}

	/**
	 * Method used to initialize the composite before applying the visual effects linked to the selected strategies
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 *
	 * @param parent
	 * @return
	 * 		parent
	 */
	@Override
	public Control createContents(Composite parent) {
		initializeDialogUnits(parent);
		propertyLifecyclePageComposite = new PropertyLifecyclePageComposite(parent, SWT.NONE);
		return parent;
	}

	/**
	 * Get all the selected strategies and register them through the PreferenceManager
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performApply()
	 *
	 */
	@Override
	protected void performApply() {
		preferencesManager.registerCurrentPreferences(
				propertyLifecyclePageComposite.getBasicParentModels(),
				propertyLifecyclePageComposite.getAdvancedParentModels(),
				propertyLifecyclePageComposite.getBasicStrategies(),
				propertyLifecyclePageComposite.getAdvancedStrategies());

		// ConvertEcoreToUML convertDialog = new ConvertEcoreToUML();
		// convertDialog.run(new Action() {
		// });

		super.performApply();
	}

	/**
	 * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
	 *
	 */
	@Override
	protected void performDefaults() {
		preferencesManager.clearPreferences();
		propertyLifecyclePageComposite.resetViewers();

		super.performDefaults();
	}

	@Override
	public void performHelp() {
		// do something ?
	}
}
