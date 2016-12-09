/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.migration.rhapsody.messages;

import org.eclipse.osgi.util.NLS;

/**
 * @author VL222926
 *
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.migration.rhapsody.messages.messages"; //$NON-NLS-1$
	public static String ImportRhapsodyPreferencesPage_FileSystem;
	public static String ImportRhapsodyPreferencesPage_Information;
	public static String ImportRhapsodyPreferencesPage_Locatio;
	public static String RhapsodyShareFolderUtils_PapyrusRhapsodyImporter_DialogMessage;
	public static String RhapsodyShareFolderUtils_PapyrusRhapsodyImporter_DialogTitle;
	public static String ImportRhapsodyPreferencesPage_SelectTheLocation_DialogMessage;
	public static String ImportRhapsodyPreferencesPage_SelectTheShareRhapsodyFolder;
	public static String ImportRhapsodyPreferencesPage_Worskspace;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
