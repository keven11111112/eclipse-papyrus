/*****************************************************************************
 * Copyright (c) 2010, 2016 CEA LIST, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus - bug 485220
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.ui.preferences;

import org.eclipse.jface.preference.IPreferencePage;

/**
 * Specialized protocol for preference pages participating in the {@link VisiblePageSingleton}
 * mechanism.
 */
public interface IPapyrusPreferencePage extends IPreferencePage {
	/**
	 * Requests the page to store all of its preferences in the preference store.
	 */
	void storeAllPreferences();
}
