/******************************************************************************
 * Copyright (c) 2006, 2020 Borland Software Corporation, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Alexander Fedorov (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - refactored to use osgi Preferences and context-sensitive scope
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge.transform;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.papyrus.gmf.internal.bridge.ui.Plugin;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;


public class TransformOptions extends AbstractPreferenceInitializer {
	
	private static final String PREF_GENERATE_RCP = "generate_rcp"; //$NON-NLS-1$
	private static final String PREF_USE_MAP_MODE = "use_map_mode"; //$NON-NLS-1$
	private static final String PREF_USE_RUNTIME_FIGURES = "use_runtime_figures"; //$NON-NLS-1$
	private static final String PREF_USE_IN_TRANSFORMATION_CODE_GEN = "use_in_transfo_code_gen"; //$NON-NLS-1$
	private static final String PREF_IGNORE_MAPMODEL_VALIDATION = "ignore_mapmodel_validation"; //$NON-NLS-1$
	private static final String PREF_IGNORE_GMFGEN_VALIDATION = "ignore_gmfgen_validation"; //$NON-NLS-1$
	private static final String PREF_FIGURE_TEMPLATES = "dynamic_figure_templates"; //$NON-NLS-1$
	private static final String PREF_MAIN_TRANSFORM = "main-qvto"; //$NON-NLS-1$
	private static final String PREF_PRE_RECONCILE_TRANSFORM = "pre-reconcile-qvto"; //$NON-NLS-1$
	private static final String PREF_POST_RECONCILE_TRANSFORM = "post-reconcile-qvto"; //$NON-NLS-1$
	
	private static String[] PROP_NAMES = new String[] {
		PREF_GENERATE_RCP, 
		PREF_USE_MAP_MODE, 
		PREF_USE_IN_TRANSFORMATION_CODE_GEN,
		PREF_USE_RUNTIME_FIGURES,
		PREF_IGNORE_MAPMODEL_VALIDATION,
		PREF_IGNORE_GMFGEN_VALIDATION,
		PREF_FIGURE_TEMPLATES,
		PREF_MAIN_TRANSFORM,
		PREF_PRE_RECONCILE_TRANSFORM,
		PREF_POST_RECONCILE_TRANSFORM,
		};

	private Preferences myContextPrefs; // may be null
	private Preferences myGlobalPrefs;
	// null value indicates value was not yet accessed, to indicate value removal, use dedicated myNoValueToken 
	private final HashMap<String,String> myInMemPrefs = new HashMap<String,String>();
	// explicit "no-value" value to indicate absence of the key
	// need this when global preferences have e.g. postReconcileTr set, but current transformation cleaned the option, 
	// hence key absence in the myInMemPrefs map is non-indicative
	private final String myNoValueToken = new String("no value"); //$NON-NLS-1$
	
	public TransformOptions() {
	}

	public void setContext(Preferences contextPrefs) {
		if (myContextPrefs != contextPrefs) {
			myContextPrefs = contextPrefs;
			reset();
		}
	}

	public void reset() {
		myInMemPrefs.clear();
	}
	
	public void flush() {
		try {
			for (String k : myInMemPrefs.keySet()) {
				// Is it reasonable to always record last used options as global
				// (so that next time wizard shows up, last-used options will be used, not defaults)?
				String v = myInMemPrefs.get(k);
				if (v != myNoValueToken) { // XXX might be reasonable also check for null, though should never happen
					getGlobalPrefs().put(k, v);
				}
			}
			getGlobalPrefs().flush();
			if (myContextPrefs != null) {
				// global preferences may change in the future, so record all values
				for (String k : PROP_NAMES) {
					String v = getWithContexts(k);
					if (v != null && v != myNoValueToken) {
						myContextPrefs.put(k, v);
					} else {
						myContextPrefs.remove(k);
					}
				}
				myContextPrefs.flush();
			}
		} catch (BackingStoreException ex) {
			Plugin.log(ex);
		}
	}
	
	public boolean getGenerateRCP() {
		return getBoolean(PREF_GENERATE_RCP);
	}

	public boolean getUseMapMode() {
		return getBoolean(PREF_USE_MAP_MODE);
	}

	public boolean getUseRuntimeFigures() {
		return getBoolean(PREF_USE_RUNTIME_FIGURES);
	}
	
	public boolean getUseInTransformationCodeGen() {
		return getBoolean(PREF_USE_IN_TRANSFORMATION_CODE_GEN);
	}

	public boolean getIgnoreMapModelValidation() {
		return getBoolean(PREF_IGNORE_MAPMODEL_VALIDATION);
	}

	public boolean getIgnoreGMFGenValidation() {
		return getBoolean(PREF_IGNORE_GMFGEN_VALIDATION);
	}

	public URL getFigureTemplatesPath() {
		return getURL(PREF_FIGURE_TEMPLATES);
	}

	public URL getMainTransformation() {
		return getURL(PREF_MAIN_TRANSFORM);
	}

	public URL getPreReconcileTransform() {
		return getURL(PREF_PRE_RECONCILE_TRANSFORM);
	}

	public URL getPostReconcileTransform() {
		return getURL(PREF_POST_RECONCILE_TRANSFORM);
	}

	//
	//
	//
	
	public void setGenerateRCP(boolean value) {
		myInMemPrefs.put(PREF_GENERATE_RCP, Boolean.toString(value));
	}

	public void setUseMapMode(boolean value) {
		myInMemPrefs.put(PREF_USE_MAP_MODE, Boolean.toString(value));
	}

	public void setUseRuntimeFigures(boolean value) {
		myInMemPrefs.put(PREF_USE_RUNTIME_FIGURES, Boolean.toString(value));
	}

	public void setIgnoreMapModelValidation(boolean value) {
		myInMemPrefs.put(PREF_IGNORE_MAPMODEL_VALIDATION, Boolean.toString(value));
	}

	public void setIgnoreGMFGenValidation(boolean value) {
		myInMemPrefs.put(PREF_IGNORE_GMFGEN_VALIDATION, Boolean.toString(value));
	}
	
	public void setInTransformationCodeGen(boolean value) {
		myInMemPrefs.put(PREF_USE_IN_TRANSFORMATION_CODE_GEN, Boolean.toString(value));
	}

	public void setFigureTemplatesPath(URL path) {
		myInMemPrefs.put(PREF_FIGURE_TEMPLATES, path == null ? myNoValueToken : path.toString());
	}

	public void setTransformation(URL path) {
		myInMemPrefs.put(PREF_MAIN_TRANSFORM, path == null ? myNoValueToken : path.toString());
	}

	public void setPreReconcileTransform(URL path) {
		myInMemPrefs.put(PREF_PRE_RECONCILE_TRANSFORM, path == null ? myNoValueToken : path.toString());
	}

	public void setPostReconcileTransform(URL path) {
		myInMemPrefs.put(PREF_POST_RECONCILE_TRANSFORM, path == null ? myNoValueToken : path.toString());
	}

	@Override
	public void initializeDefaultPreferences() {
		Preferences node = getDefaultPrefs();
		node.putBoolean(PREF_GENERATE_RCP, false);
		node.putBoolean(PREF_USE_MAP_MODE, true);
		node.putBoolean(PREF_USE_RUNTIME_FIGURES, true);
		node.putBoolean(PREF_IGNORE_MAPMODEL_VALIDATION, false);
		node.putBoolean(PREF_IGNORE_GMFGEN_VALIDATION, false);
		node.putBoolean(PREF_USE_IN_TRANSFORMATION_CODE_GEN, true);
	}
	
	static boolean checkLiteOptionPresent() {
		return Platform.getBundle("org.eclipse.papyrus.gmf.codegen.lite") != null; //$NON-NLS-1$
	}

	private String getWithContexts(String key) {
		String v = myInMemPrefs.get(key);
		if (v != null && v != myNoValueToken) {
			return v;
		}
		if (v == myNoValueToken) {
			return null;
		}
		ArrayList<Preferences> scopes = new ArrayList<Preferences>(3);
		if (myContextPrefs != null) {
			// there may be no context-specific scope
			scopes.add(myContextPrefs);
		} else {
			// respect globals only if there's no context. Otherwise (if we chain both), globals may have postRecoTr set, while context not
			// but chaining would give us a result as if it would have been set
			scopes.add(getGlobalPrefs());
		}
		scopes.add(getDefaultPrefs());
		// XXX alternative is to use default lookup order, with getString(Plugin.getPluginID, key, null, null))
		// but seems like we don't care about other scopes than project, instance and default
		return Platform.getPreferencesService().get(key, null, scopes.toArray(new Preferences[scopes.size()]));
	}

	private boolean getBoolean(String key) {
		String value = getWithContexts(key);
		assert value != null; // DefaultScope should never fail ;)
		return Boolean.parseBoolean(value);
	}

	private URL getURL(String key) {
		final String value = getWithContexts(key);
		if (value == null || value.length() == 0) {
			return null;
		}
		try {
			return new URL(value);
		} catch (MalformedURLException ex) {
			Plugin.log(ex);
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	private Preferences getGlobalPrefs() {
		if (myGlobalPrefs == null) {
			// no real need to cache, though
			myGlobalPrefs = new InstanceScope().getNode(Plugin.getPluginID());
		}
		return myGlobalPrefs;
	}
	
	@SuppressWarnings("deprecation")
	private static Preferences getDefaultPrefs() {
		return new DefaultScope().getNode(Plugin.getPluginID());
	}
}
