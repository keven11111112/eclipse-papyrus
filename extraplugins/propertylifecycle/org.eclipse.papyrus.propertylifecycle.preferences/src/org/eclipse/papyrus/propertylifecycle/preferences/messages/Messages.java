/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.propertylifecycle.preferences.messages;

import org.eclipse.osgi.util.NLS;

/**
 * Messages Class
 * 
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.propertylifecycle.preferences.messages.messages"; //$NON-NLS-1$

	// Preference page
	public static String PropertyLifecycle_PreferencePage_Title;

	public static String PropertyLifecycle_PreferencePage_Description;

	public static String Choose_Configuration;

	// ControlsComposite
	public static String PropertyLifecycleStrategies;

	public static String Sync_Label;

	public static String Sync_IconPath;

	public static String Add_Label;

	public static String Add_IconPath;

	public static String Remove_Label;

	public static String Remove_IconPath;

	public static String RemoveAll_Label;

	public static String RemoveAll_IconPath;

	public static String AddAll_Label;

	public static String AddAll_IconPath;

	// TreeViewer
	public static String Resource_IconPath;

	public static String StrategySet_IconPath;

	public static String Strategy_IconPath;

	public static String Property_IconPath;

	public static String ElementContainer_IconPath;

	// StrategiesComposite
	public static String StrategyElement_Label;

	public static String ElementProperty_Label;

	public static String ElementContainer_Label;

	// SystemSelectionDialog
	public static String SystemSelectionDialog_Title;

	public static String SystemSaveDialog_Title;

	// Menu
	public static String AddStrategy_Label;

	public static String AddStrategy_IconPath;

	public static String RemoveStrategy_Label;

	public static String RemoveStrategy_IconPath;

	public static String RemoveStrategyModel_Label;

	public static String RemoveStrategyModel_IconPath;

	public static String RemoveAllStrategies_Label;

	public static String RemoveAllStrategies_IconPath;

	// Preferences
	public static String BasicBrowsedModels_Node;

	public static String BasicSelectedStrategies_Node;

	public static String AdvancedBrowsedModels_Node;

	public static String AdvancedSelectedStrategies_Node;

	// Models buttons
	public static String SaveButton_Label;

	public static String BrowseButton_Label;

	public static String CustomModel_DefaultName;

	// TableViewer
	public static String SelectAllButton_Label;

	public static String DeselectAllButton_Label;

	public static String Checked_IconPath;

	public static String Unchecked_IconPath;


	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
