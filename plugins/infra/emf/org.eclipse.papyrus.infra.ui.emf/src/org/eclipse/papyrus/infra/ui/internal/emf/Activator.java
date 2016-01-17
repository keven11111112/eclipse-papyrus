/*****************************************************************************
 * Copyright (c) 2013, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *  Christian W. Damus - bug 485220
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.ui.internal.emf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationCatalogManager;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationCatalogManagerFactory;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.papyrus.infra.emf.CustomizationComparator;
import org.eclipse.papyrus.infra.emf.readonly.spi.IReadOnlyManagerProcessor;
import org.eclipse.papyrus.infra.ui.internal.emf.readonly.EditorReloadProcessor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	/**
	 * The plug-in ID
	 */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.infra.ui.emf"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * The plug-in's logger
	 */
	public static LogHelper log;

	private ServiceRegistration<IReadOnlyManagerProcessor> roManagerProcessorReg;

	private ICustomizationManager customizationManager;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		log = new LogHelper(this);

		roManagerProcessorReg = context.registerService(IReadOnlyManagerProcessor.class, new EditorReloadProcessor(), null);
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		if (roManagerProcessorReg != null) {
			roManagerProcessorReg.unregister();
			roManagerProcessorReg = null;
		}

		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Saves the current Customization Manager settings to the preferences
	 */
	public void saveCustomizationManagerState() {
		IDialogSettings dialogSettings = getBrowserCustomizationDialogSettings();
		List<Customization> appliedCustomizations = getCustomizationManager().getManagedCustomizations();

		final List<Customization> registeredCustomizations = ICustomizationCatalogManagerFactory.DEFAULT.getOrCreateCustomizationCatalogManager(getCustomizationManager().getResourceSet()).getRegisteredCustomizations();

		for (Customization customization : registeredCustomizations) {

			boolean isApplied = appliedCustomizations.contains(customization);
			String settingKey = getSettingKey(customization);

			dialogSettings.put(settingKey, isApplied);
		}
	}

	private String getSettingKey(Customization customization) {
		// do not exist anymore
		return customization.eResource().getURI().toString();
		// return "";
	}

	protected IDialogSettings getBrowserCustomizationDialogSettings() {
		String sectionId = CUSTOMIZATION_MANAGER_SECTION;

		IDialogSettings settings = Activator.getDefault().getDialogSettings().getSection(sectionId);
		if (settings == null) {
			settings = Activator.getDefault().getDialogSettings().addNewSection(sectionId);
		}
		return settings;
	}

	private void init(final ICustomizationManager customizationManager) {
		// the appearance can be customized here:

		IDialogSettings settings = getBrowserCustomizationDialogSettings();

		try {

			// load customizations defined as default through the customization
			// extension
			ICustomizationCatalogManager customCatalog = ICustomizationCatalogManagerFactory.DEFAULT.getOrCreateCustomizationCatalogManager(customizationManager.getResourceSet());
			// no possibility to get default customization

			List<Customization> registryAllCustomizations = customCatalog.getRegisteredCustomizations();
			ArrayList<Customization> orderedCustomizationList = new ArrayList<Customization>();
			for (Customization customization : registryAllCustomizations) {
				String settingKey = getSettingKey(customization);

				boolean isActive = false;
				if (settings.get(settingKey) == null) { // Never customized
					isActive = customization.isMustBeLoadedByDefault(); // Loaded by default

				} else {
					isActive = settings.getBoolean(settingKey);
				}

				if (isActive) {
					orderedCustomizationList.add(customization);

				}
			}

			Collections.sort(orderedCustomizationList, new CustomizationComparator());
			customizationManager.getManagedCustomizations().addAll(orderedCustomizationList);

		} catch (Throwable e) {
			log.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error initializing customizations", e)); //$NON-NLS-1$
		}
	}

	/**
	 * The section name of the Dialog Settings for storing Customization Manager settings
	 */
	public static final String CUSTOMIZATION_MANAGER_SECTION = PLUGIN_ID + ".customizationManager";//$NON-NLS-1$

	/**
	 * Restores the default Customization Manager configuration
	 */
	public void restoreDefaultCustomizationManager() {
		// ICustomizationManager manager = getCustomizationManager();

		DialogSettings settings = (DialogSettings) getDialogSettings();
		settings.removeSection(CUSTOMIZATION_MANAGER_SECTION);

		// List<MetamodelView> registryDefaultCustomizations = CustomizationsCatalog.getInstance().getRegistryDefaultCustomizations();
		//
		// manager.clearCustomizations();
		// for(MetamodelView customization : registryDefaultCustomizations) {
		// manager.registerCustomization(customization);
		// }
		// manager.loadCustomizations();
	}

	public ICustomizationManager getCustomizationManager() {
		if (customizationManager == null) {
			customizationManager = org.eclipse.papyrus.infra.emf.Activator.getDefault().getCustomizationManager();
			init(getCustomizationManager());
		}
		return customizationManager;
	}
}
