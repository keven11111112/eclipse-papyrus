/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.internationalization.common.utils;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.internationalization.common.Activator;

/**
 * The internationalization preference initializer.
 */
public class InternationalizationPreferencesInitializer extends AbstractPreferenceInitializer {

	/**
	 * Constructor.
	 */
	public InternationalizationPreferencesInitializer() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		store.setDefault(InternationalizationPreferencesConstants.LOAD_INTERNATIONALIZATION, true);
		store.setDefault(InternationalizationPreferencesConstants.LOAD_INTERNATIONALIZATION_OF_EXTERNAL_FILES, false);
	}

	/**
	 * Get the preference store.
	 * 
	 * @return The preference store.
	 */
	protected IPreferenceStore getPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}

}
