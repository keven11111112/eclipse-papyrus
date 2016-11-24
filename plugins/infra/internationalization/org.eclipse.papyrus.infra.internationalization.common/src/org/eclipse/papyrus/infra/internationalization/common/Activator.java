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

package org.eclipse.papyrus.infra.internationalization.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.papyrus.infra.core.resource.PapyrusProjectScope;
import org.eclipse.papyrus.infra.ui.preferences.PapyrusScopedPreferenceStore;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends AbstractUIPlugin {

	/**
	 * The plug-in ID.
	 */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.infra.internationalization.common"; //$NON-NLS-1$
	
	/**
	 * The internationalization preference node label.
	 */
	public static final String INTERNATIONALIZATION_NODE_LABEL = "internationalization"; //$NON-NLS-1$

	/**
	 * The shared instance.
	 */
	private static Activator plugin;

	/**
	 * The log helper.
	 */
	public static LogHelper log;
	
	/**
	 * Storage for preferences. Use a list of preference store (one preference
	 * store by internationalization of a project).
	 */
	private List<IPreferenceStore> preferencesStore;

	/**
	 * The constructor
	 */
	public Activator() {
		preferencesStore = new ArrayList<IPreferenceStore>(0);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		log = new LogHelper(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(final BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}
	
	/**
	 * Get the preference store and create it if necessary.
	 * 
	 * @param project
	 *            The current project
	 * @param papyrusProjectName
	 *            The current papyrus project name.
	 * @return The preference store.
	 */
	public IPreferenceStore getInternationalizationPreferenceStore(final IProject project,
			final String papyrusProjectName) {
		IPreferenceStore result = null;
		final IScopeContext scope = new PapyrusProjectScope(project, papyrusProjectName);
		if (!preferencesStore.isEmpty()) {
			final IEclipsePreferences scopePreferenceNode = scope.getNode(INTERNATIONALIZATION_NODE_LABEL);
			final Iterator<IPreferenceStore> preferenceStoreIterator = preferencesStore.iterator();
			while (preferenceStoreIterator.hasNext() && null == result) {
				final IPreferenceStore preferenceStore = preferenceStoreIterator.next();
				if (preferenceStore instanceof PapyrusScopedPreferenceStore) {
					final IEclipsePreferences[] preferenceNodes = ((PapyrusScopedPreferenceStore) preferenceStore)
							.getPreferenceNodes(false);
					for (int index = 0; index < preferenceNodes.length && null == result; index++) {
						if (preferenceNodes[index].equals(scopePreferenceNode)) {
							result = preferenceStore;
						}
					}
				}
			}
		}

		if (null == result) {
			result = new PapyrusScopedPreferenceStore(scope, INTERNATIONALIZATION_NODE_LABEL);
			preferencesStore.add(result); // $NON-NLS-1$
		}

		return result;
	}

	/**
	 * Get the first preference store if existing, else a scoped preference
	 * store must be created and added to the list of preferences store.
	 * 
	 * @return The preference store.
	 */
	public IPreferenceStore getInternationalizationPreferenceStore() {
		// Create the preference store lazily.
		if (preferencesStore.isEmpty()) {
			preferencesStore.add(new ScopedPreferenceStore(InstanceScope.INSTANCE, getBundle().getSymbolicName()));
		}
		return preferencesStore.get(0);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
}
