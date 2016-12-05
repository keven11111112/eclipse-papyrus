/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.activity.edit.utils.updater.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.activity.part.CustomMessages;
import org.eclipse.papyrus.uml.diagram.common.Activator;

/**
 * Automated pin derivation for AcceptEventAction and AcceptCallAction
 *
 * This class initialize preference
 */
public class AutomatedModelCompletionPreferencesInitializer extends AbstractPreferenceInitializer {

	final static public String PIN_SYNCHRONIZATION = CustomMessages.AutomatedModelCompletionPreferencesInitializer_PinSynchronization;

	final static public String NONE = CustomMessages.AutomatedModelCompletionPreferencesInitializer_None;

	/**
	 * Constructor.
	 *
	 */
	public AutomatedModelCompletionPreferencesInitializer() {
		super();
	}

	/**
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 *
	 */
	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		store.setDefault(IAutomatedModelCompletionPreferencesConstants.ACCEPT_CALL_ACTION_ACCELERATOR, PIN_SYNCHRONIZATION);
		store.setDefault(IAutomatedModelCompletionPreferencesConstants.ACCEPTE_EVENT_ACTION_ACCELERATOR, PIN_SYNCHRONIZATION);
		store.setDefault(IAutomatedModelCompletionPreferencesConstants.ADD_STRUCTURAL_FEATURE_VALUE_ACTION_ACCELERATOR, PIN_SYNCHRONIZATION);
		store.setDefault(IAutomatedModelCompletionPreferencesConstants.CREATE_OBJECT_ACTION_ACCELERATOR, PIN_SYNCHRONIZATION);
		store.setDefault(IAutomatedModelCompletionPreferencesConstants.READ_STRUCTURAL_FEATURE_ACTION_ACCELERATOR, PIN_SYNCHRONIZATION);
	}

	/**
	 * Get the preference store
	 */
	protected IPreferenceStore getPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}
}
