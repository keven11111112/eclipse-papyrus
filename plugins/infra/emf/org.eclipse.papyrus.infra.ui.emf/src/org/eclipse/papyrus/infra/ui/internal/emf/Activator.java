/*****************************************************************************
 * Copyright (c) 2013, 2016 CEA LIST, Christian W. Damus, ALL4TEC, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *  Christian W. Damus - bug 485220
 *  Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and implementation
 *  Benoit Maggi - Bug 509346
 *****************************************************************************/
package org.eclipse.papyrus.infra.ui.internal.emf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationCatalogManager;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationCatalogManagerFactory;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.papyrus.emf.facet.custom.ui.CustomizedContentProviderUtils;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.papyrus.infra.emf.CustomizationComparator;
import org.eclipse.papyrus.infra.emf.readonly.spi.IReadOnlyManagerProcessor;
import org.eclipse.papyrus.infra.emf.spi.resolver.IEObjectResolver;
import org.eclipse.papyrus.infra.ui.internal.emf.readonly.EditorReloadProcessor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {



	/**
	 *  Preference to enforce loaded facet by default
	 */
	private static final String DEFAULT_LOADED_FACET = "defaultLoadedFacet"; //$NON-NLS-1$


	/**
	 * Separator for DEFAULT_LOADED_FACET
	 */
	private static final String SEPARATOR_DEFAULT_LOADED_FACET = ",";	
	
	/**
	 * The plug-in ID
	 */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.infra.ui.emf"; //$NON-NLS-1$

	/**
	 * The section name of the Dialog Settings for storing Customization Manager settings
	 */
	public static final String CUSTOMIZATION_MANAGER_SECTION = PLUGIN_ID + ".customizationManager";//$NON-NLS-1$
	
	/**
	 * Key to store the facet order
	 */
	private static final String LOADED_FACET_ORDER = PLUGIN_ID+".facet.order";
	
	
	// The shared instance
	private static Activator plugin;

	/**
	 * The plug-in's logger
	 */
	public static LogHelper log;

	private ServiceRegistration<IEObjectResolver> eobjectResolverReg;
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

		eobjectResolverReg = context.registerService(IEObjectResolver.class, CustomizedContentProviderUtils::resolve, null);
		roManagerProcessorReg = context.registerService(IReadOnlyManagerProcessor.class, new EditorReloadProcessor(), null);
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		if (roManagerProcessorReg != null) {
			roManagerProcessorReg.unregister();
			roManagerProcessorReg = null;
		}
		if (eobjectResolverReg != null) {
			eobjectResolverReg.unregister();
			eobjectResolverReg = null;
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
		
		// We have to use a temporary list since CustomizationsDelegatingList is buggy (missing a lot of methods)
		List<Customization> customizationList = new ArrayList<>();
		customizationList.addAll(appliedCustomizations);
		String[] loadedCustomizationArray = customizationList.stream().map(customization -> customization.eResource().getURI().toString()).toArray(size -> new String[size]);
		dialogSettings.put(LOADED_FACET_ORDER, loadedCustomizationArray);
	}

	private String getSettingKey(Customization customization) {
		// do not exist anymore
		return customization.eResource().getURI().toString();
	}

	protected IDialogSettings getBrowserCustomizationDialogSettings() {
		IDialogSettings settings = Activator.getDefault().getDialogSettings().getSection(CUSTOMIZATION_MANAGER_SECTION);
		if (settings == null) {
			settings = Activator.getDefault().getDialogSettings().addNewSection(CUSTOMIZATION_MANAGER_SECTION);
			IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();
			String string = preferenceStore.getString(DEFAULT_LOADED_FACET);
			settings.put(LOADED_FACET_ORDER, string.split(SEPARATOR_DEFAULT_LOADED_FACET));
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
			List<Customization> orderedCustomizationList = new ArrayList<>();
			for (Customization customization : registryAllCustomizations) {
				String settingKey = getSettingKey(customization);
				boolean isActive;
				if (settings.get(settingKey) == null) { // Never customized
					isActive = customization.isMustBeLoadedByDefault(); // Loaded by default
				} else {
					isActive = settings.getBoolean(settingKey);
				}

				if (isActive) {
					orderedCustomizationList.add(customization);
				}
			}
			String[] loadedFacetOrder = settings.getArray(LOADED_FACET_ORDER);
			if (loadedFacetOrder != null && loadedFacetOrder.length > 0){
				
				Map<String, Customization> mapProp = registryAllCustomizations.stream().collect(
					    Collectors.toMap(e -> getSettingKey(e),e -> e));
				Stream<String> stream = Arrays.stream(loadedFacetOrder);
				Stream<Customization> map = stream.map(id -> mapProp.get(id.trim()));
				orderedCustomizationList = map.collect(Collectors.toList());
			} else {
				Collections.sort(orderedCustomizationList, new CustomizationComparator());
			}
			customizationManager.getManagedCustomizations().addAll(orderedCustomizationList);
		} catch (Throwable e) {
			log.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error initializing customizations", e)); //$NON-NLS-1$
		}
	}



	/**
	 * Restores the default Customization Manager configuration
	 */
	public void restoreDefaultCustomizationManager() {
		DialogSettings settings = (DialogSettings) getDialogSettings();
		settings.removeSection(CUSTOMIZATION_MANAGER_SECTION);
	}

	public ICustomizationManager getCustomizationManager() {
		if (customizationManager == null) {
			customizationManager = org.eclipse.papyrus.infra.emf.Activator.getDefault().getCustomizationManager();
			init(getCustomizationManager());
		}
		return customizationManager;
	}

	/**
	 * Get Icon image from the specified path on the specified plugin id.
	 * 
	 * @param pluginId
	 *            The plugin id.
	 * @param iconPath
	 *            The icon local path.
	 * @return the {@link Image}
	 */
	public static Image getPluginIconImage(final String pluginId, final String iconPath) {
		String key = pluginId + iconPath;
		ImageRegistry registry = getDefault().getImageRegistry();
		Image image = registry.get(key);

		if (null == image) {
			ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin(pluginId, iconPath);
			registry.put(key, desc);
			image = registry.get(key);
		}
		return image;
	}

}
