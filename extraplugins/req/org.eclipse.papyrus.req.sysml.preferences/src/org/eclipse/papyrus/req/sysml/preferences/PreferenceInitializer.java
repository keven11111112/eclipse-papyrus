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
 *     Mauricio Alférez (mauricio.alferez@cea.fr) CEA LIST - Bugs 477726, 478595
 *     
 ******************************************************************************/
package org.eclipse.papyrus.req.sysml.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;


/**
 * Initializes the preferences for the creation of Papyrus REQ SysML requirements
 *
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {


	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault(PreferenceConstants.REQUIREMENT_ID_PREFIX, "REQ_");
		store.setDefault(PreferenceConstants.REQUIREMENT_ID_DIGIT, 3);
		store.setDefault(PreferenceConstants.CHILD_REQUIREMENTS_SEPARATOR, "_");
	}

}
