/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST. - initial API and implementation
 *     Mauricio Alferez (mauricio.alferez@cea.fr) CEA LIST - Bugs 477726, 478595, 481377, ...
 *     
 ******************************************************************************/
package org.eclipse.papyrus.requirements.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Initializes the preferences for the creation of Papyrus REQ SysML
 * requirements
 *
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();

		// Options for requirements creation
		store.setDefault(PreferenceConstants.REQUIREMENT_ID_PREFIX, "REQ_");
		store.setDefault(PreferenceConstants.REQUIREMENT_ID_DIGIT, 3);
		store.setDefault(PreferenceConstants.CHILD_REQUIREMENTS_SEPARATOR, "_");

		// Options for the generation of a profile based on a domain model
		store.setDefault(PreferenceConstants.NSURI_PREFIX, "https://www.eclipse.org/papyrus/");
		store.setDefault(PreferenceConstants.GENERATE_ABSTRACTIONS_MODEL, false);
		store.setDefault(PreferenceConstants.FROM_ASSOCIATIONS_TO_STEREOTYPES, false);
		store.setDefault(PreferenceConstants.FROM_ASSOCIATIONS_TO_ASSOCIATIONS, false);
		// store.setDefault(PreferenceConstants.METACLASS_EXTENDED_BY_NODES,
		// "none");
		// store.setDefault(PreferenceConstants.METACLASS_EXTENDED_BY_EDGES,
		// "none");
	}
}
