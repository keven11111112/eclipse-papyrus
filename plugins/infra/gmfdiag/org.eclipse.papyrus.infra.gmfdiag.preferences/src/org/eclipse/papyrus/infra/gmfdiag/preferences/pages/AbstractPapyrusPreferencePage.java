/****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Thibault Landre (Atos Origin) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.preferences.pages;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.Activator;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.AbstractGroup;

/**
 * An abstract implementation of a Preference page.
 *
 * This preference page allows clients to define preference page in the preference of Eclipse, and
 * in the properties of a project in the workspace.
 * <p>
 * Clients must implement :
 * <ul>
 * <li><code>getBundleId()</code> method in order to define the preference scope (Project or Instance) of the preference page.</li>
 * <li><code>createPageContents()</code> method to populate the preference page with the different {@link AbstractGroup}. </br>
 * Each group added has to be declared through the <code>addAbstractGroup(AbstractGroup fe)</code> method</li>
 * </ul>
 * </p>
 * 
 * @deprecated Use the {@link org.eclipse.papyrus.infra.ui.preferences.AbstractPapyrusPreferencePage} API, instead.
 */
@Deprecated
public abstract class AbstractPapyrusPreferencePage extends org.eclipse.papyrus.infra.ui.preferences.AbstractPapyrusPreferencePage {

	@Override
	public IPreferenceStore getPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}

	/**
	 * Add the given {@code group} of field editors to the page.
	 */
	protected void addAbstractGroup(AbstractGroup fe) {
		addPreferenceGroup(fe);
	}
}
