/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
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
package org.eclipse.papyrus.uml.properties.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;

/**
 * This class define the constants and the preference store for the multiplicity editor in properties view.
 */
public class MultiplicityEditorPreferences {

	/**
	 * Instance singleton.
	 */
	public static final MultiplicityEditorPreferences instance = new MultiplicityEditorPreferences();


	/**
	 * The preference store.
	 */
	private IPreferenceStore preferences = Activator.getInstance().getPreferenceStore();


	/**
	 * Constructor.
	 */
	private MultiplicityEditorPreferences() {
		// Nothing
	}

	/**
	 * Gets the preference store.
	 * 
	 * @return The preference store.
	 */
	public IPreferenceStore getPreferenceStore() {
		return preferences;
	}

}
