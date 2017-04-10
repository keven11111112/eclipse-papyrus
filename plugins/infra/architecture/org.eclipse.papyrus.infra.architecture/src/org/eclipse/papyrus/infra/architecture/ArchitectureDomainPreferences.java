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
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.papyrus.infra.services.edit.context.TypeContext;
import org.osgi.service.prefs.BackingStoreException;

/**
 * This class reads/writes the architecture domain preferences
 * 
 * @since 1.0
 */
public class ArchitectureDomainPreferences implements Cloneable {

	/**
	 * The addedModels preference property name
	 */
	public static final String ADDED_MODELS = "addedModels"; //$NON-NLS-1$

	/**
	 * The excludedContexts preference property name
	 */
	public static final String EXCLUDED_CONTEXTS = "excludedContexts"; //$NON-NLS-1$
	
	/**
	 * The defaultContext preference property name
	 */
	public static final String DEFAULT_CONTEXT = "defaultContext"; //$NON-NLS-1$

	/**
	 * The list of added architecture models in the preferences
	 */
	private List<String> addedModels;

	/**
	 * The set of excluded architecture contexts in the preferences
	 */
	private Set<String> excludedContexts;
	
	/**
	 * The id of the default context in the preferences
	 */
	private String defaultContext;

	/**
	 * The default value of the default context when not set
	 */
	private String defaultDefaultContext = TypeContext.getDefaultContextId();

	/*
	 * Gets the preferences node
	 */
	private static IEclipsePreferences getPreferences() {
		return InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);
	}

	/**
	 * Reads the state of the preferences
	 */
	public void read() {
		addedModels = Arrays.asList(getPreferences().get(ArchitectureDomainPreferences.ADDED_MODELS, "").split(" "));
		excludedContexts = new HashSet<String>(Arrays.asList(getPreferences().get(ArchitectureDomainPreferences.EXCLUDED_CONTEXTS, "").split(",")));
		defaultContext = getPreferences().get(ArchitectureDomainPreferences.DEFAULT_CONTEXT, defaultDefaultContext);
	}
	
	/**
	 * Writes the state of the preferences
	 */
	public void write() {
		getPreferences().put(ArchitectureDomainPreferences.ADDED_MODELS, "");
		getPreferences().put(ArchitectureDomainPreferences.ADDED_MODELS, String.join(" ", addedModels));
		getPreferences().put(ArchitectureDomainPreferences.EXCLUDED_CONTEXTS, String.join(",", excludedContexts));
		if (defaultContext != null)
			getPreferences().put(ArchitectureDomainPreferences.DEFAULT_CONTEXT, defaultContext);
		else
			getPreferences().remove(ArchitectureDomainPreferences.DEFAULT_CONTEXT);
		try {
			getPreferences().flush();
		} catch (BackingStoreException e) {
			Activator.log.error(e);
		}
	}
	
	/**
	 * Resets the state of this class to default
	 */
	public void reset() {
		addedModels.clear();
		excludedContexts.clear();
		defaultContext = defaultDefaultContext;
	}
	
	/**
	 * Adds the given preference change listener
	 * 
	 * @param listener
	 */
	public void addListener(IPreferenceChangeListener listener) {
		getPreferences().addPreferenceChangeListener(listener);
	}

	/**
	 * @return the added model URIs
	 */
	public List<String> getAddedModelURIs() {
		return addedModels;
	}

	/**
	 * @return the excluded context ids
	 */
	public Set<String> getExcludedContextIds() {
		return excludedContexts;
	}

	/**
	 * @return the default context id
	 */
	public String getDefaultContextId() {
		return defaultContext;
	}

	/**
	 * Sets the default context id
	 * 
	 * @param defaultContext the default context id
	 */
	public void setDefaultContextId(String defaultContext) {
		this.defaultContext = defaultContext;
	}

	@Override
	public ArchitectureDomainPreferences clone() {
		ArchitectureDomainPreferences clone = new ArchitectureDomainPreferences();
		clone.addedModels = new ArrayList<String>(getAddedModelURIs());
		clone.excludedContexts = new HashSet<String>(getExcludedContextIds());
		clone.setDefaultContextId(getDefaultContextId());
		return clone;
	}

}
