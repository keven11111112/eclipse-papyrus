/**
 * Copyright (c) 2017 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Maged Elaasar - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.architecture;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureContext;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureDomain;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureViewpoint;

/**
 * The main API for reading architecture domains information
 * 
 * It reads architecture domain models registered in extensions and preferences
 * 
 * @since 1.0
 */
public class ArchitectureDomainManager implements IPreferenceChangeListener {

	/**
	 * The extension point for architecture models
	 */
	private static final String EXTENSION_POINT = Activator.PLUGIN_ID + ".models";

	/**
	 * The name pf the path attribute
	 */
	private static final String PATH = "path"; //$NON-NLS-1$
	
	/**
	 * The singleton instance of this class
	 */
	private static ArchitectureDomainManager INSTANCE;
	
	/**
	 * Gets the singleton instance of this class
	 * 
	 * @return the singleton instance of this class
	 */
	public static ArchitectureDomainManager getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ArchitectureDomainManager();
		return INSTANCE;
	}
	
	/**
	 * An interface for listening to changes to architectural domains 
	 */
	public static interface Listener {
		public void domainManagerChanged();
	}
	
	/**
	 * The architecture domain preferences
	 */
	private ArchitectureDomainPreferences preferences;

	/**
	 * The architecture domain merger
	 */
	private ArchitectureDomainMerger merger;
	
	/**
	 * A collection of listeners to architecture domain changes
	 */
	private Collection<Listener> listeners;

	/**
	 * Constructs a new instance of this class
	 */
	private ArchitectureDomainManager() {
		listeners = new HashSet<Listener>();
		merger = new ArchitectureDomainMerger();
		preferences = new ArchitectureDomainPreferences();
		preferences.addListener(this);
		initializeFromExtensions();
		initializeFromPreferences();
		merger.init(); // init as early as possible
	}

	/**
	 * initialize the architecture domain merger from the registered extensions
	 */
	private void initializeFromExtensions() {
		List<URI> models = new ArrayList<URI>();
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_POINT);
		for (IConfigurationElement element : elements) {
			String path = element.getAttribute(PATH);
			String bundleId = element.getContributor().getName();
			String modelPath = bundleId + IPath.SEPARATOR + path;
			models.add(URI.createPlatformPluginURI(modelPath, true));
		}
		merger.setExtensionModels(models);
	}

	/**
	 * initialize the architecture domain merger from the preferences
	 */
	private void initializeFromPreferences() {
		preferences.read();
		List<URI> models = new ArrayList<URI>();
		for (String value : preferences.getAddedModelURIs()) {
			if (value.length()>0) {
				models.add(URI.createURI(value, true));
			}
		}
		merger.setPreferenceModels(models);
	}

	/**
	 * Add the given listener to the domain changes
	 * 
	 * @param listener a given domain change listener
	 */
	public void addListener(Listener listener) {
		listeners.add(listener);
	}

	/**
	 * Remove the given listener to the domain changes
	 * 
	 * @param listener a given domain change listener
	 */
	public void removeListener(Listener listener) {
		listeners.remove(listener);
	}

	/**
	 * React to the preferences changing by reinitializing from them; notify listeners
	 * @see org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener#preferenceChange(org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent)
	 * 
	 * @param event a preference change event
	 */
	@Override
	public void preferenceChange(PreferenceChangeEvent event) {
		initializeFromPreferences();
		for (Listener listener : listeners)
			listener.domainManagerChanged();
	}
	
	/**
	 * Gets the architecture domain preferences
	 * 
	 * @return the architecture domain preferences
	 */
	public ArchitectureDomainPreferences getPreferences() {
		return preferences;
	}

	/**
	 * Get the architecture domain merger
	 * 
	 * @return the architecture domain merger
	 */
	public ArchitectureDomainMerger getMerger() {
		return merger;
	}

	/**
	 * Gets the collection of architecture contexts that are visible based on preferences
	 * 
	 * @return a list of architecture contexts
	 */
	public Collection<MergedArchitectureContext> getVisibleArchitectureContexts() {
		Collection<MergedArchitectureContext> contexts = new ArrayList<MergedArchitectureContext>();
		for (MergedArchitectureDomain domain : merger.getDomains()) {
			for (MergedArchitectureContext context : domain.getContexts()) {
				if (!preferences.getExcludedContextIds().contains(context.getId()))
					contexts.add(context);
			}
		}
		return contexts;
	}
	
	/**
	 * Gets the id of the default architecture context
	 * 
	 * @return the default architecture context id
	 */
	public String getDefaultArchitectureContextId() {
		return preferences.getDefaultContextId();
	}
	
	/**
	 * Gets the default architecture context
	 * 
	 * @return the default architecture context
	 */
	public MergedArchitectureContext getDefaultArchitectureContext() {
		return getArchitectureContextById(getDefaultArchitectureContextId());
	}

	/**
	 * Gets an architecture context by the given id
	 *  
	 * @param id a given id of an architecture context
	 * @return the architecture context with the given id
	 */
	public MergedArchitectureContext getArchitectureContextById(String id) {
		return merger.getArchitectureContextById(id);
	}

	/**
	 * Gets an architecture viewpoint by the given id
	 * 
	 * @param id a given id of an architecture viewpoint
	 * @return the architecture viewpoint with the given id
	 */
	public MergedArchitectureViewpoint getArchitectureViewpointById(String id) {
		return merger.getArchitectureViewpointById(id);
	}

}
