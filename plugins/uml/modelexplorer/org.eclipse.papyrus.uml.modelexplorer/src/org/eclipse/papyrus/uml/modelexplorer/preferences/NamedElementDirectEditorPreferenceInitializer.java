/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Fanch BONNABESSE (ALL4TEC) fanch.bonnabesse@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.modelexplorer.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.extensionpoints.editors.Activator;
import org.eclipse.uml2.uml.NamedElement;

/**
 * 
 * This preference initializer initializes the preferences for the direct editor of NamedElement.
 *
 */
public class NamedElementDirectEditorPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * Prefix 'papyrus.editors' to store preferences.
	 */
	private static final String PREFIX_PAPYRUS_EDITOR = "papyrus.directeditor."; //$NON-NLS-1$

	/**
	 * The Value for the objects 'NamedElement'.
	 */
	private static final String VALUE_NAMED_ELEMENT = "Named Element Direct Editor"; //$NON-NLS-1$

	/**
	 * Constructor.
	 */
	public NamedElementDirectEditorPreferenceInitializer() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault(PREFIX_PAPYRUS_EDITOR + NamedElement.class.getName(), VALUE_NAMED_ELEMENT);
	}
}
