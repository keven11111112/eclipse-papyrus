/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
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

package org.eclipse.papyrus.migration.rhapsody.importer.utils;

/**
 * 
 * @author VL222926 Utils class for Rhapsody files
 */
public class RhapsodyFileUtils {

	private RhapsodyFileUtils() {
		// to prevent instanciation
	}

	/**
	 * the extensions of the Rhapsody files
	 */
	public static final String FILE_EXTENSION_EHL = "ehl"; //$NON-NLS-1$

	public static final String FILE_EXTENSION_RPW = "rpw"; //$NON-NLS-1$

	public static final String FILE_EXTENSION_RPY = "rpy"; //$NON-NLS-1$
	
	public static final String ALL_RPY_FILES = "*.rpy"; //$NON-NLS-1$

	public static final String FILE_EXTENSION_SAVE = "save"; //$NON-NLS-1$

	public static final String FOLDER_SUFFIX = "_rpy";//$NON-NLS-1$

	/**
	 * default files for Rhapsody model
	 */
	public static final String FILE__FILES_TABLES_DAT = "filesTable.dat"; //$NON-NLS-1$

	public static final String FILE__DEFAULT_SBS = "Default.sbs"; //$NON-NLS-1$

	public static final String FILE__DEFAULT_COMPONENT_CMP = "DefaultComponent.cmp"; //$NON-NLS-1$

	/**
	 * the extension of the file after the conversion from rpy to UMl file
	 */
	public static final String UML_RHAPSODY_FILE = "umlrhapsody"; //$NON-NLS-1$

	//TODO externalize me
	public static final String STRING_ALL = "All";

	public static final String STRING_STAR = "*";//$NON-NLS-1$

}
