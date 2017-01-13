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
package org.eclipse.papyrus.migration.rhapsody.tests.tests;

import java.io.File;

import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.migration.rhapsody.utils.RhapsodyShareFolderUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author VL222926
 *
 */
public class TestRhapsodySharedFolder {

	// TODO : duplicated into org.eclipse.papyrus.migration.rhapsody.preferences.RhapsodyShareFolderUtils
	// TODO probably works only on windows!
	private static final String SYSML_FILE_PATH_IN_SHARE_FOLDER = "\\Profiles\\SysML\\SysMLProfile.rpy";
	private static final String MARTE_FOLDER_PATH_IN_SHARE_FOLDER = "\\Profiles\\MARTE";
	private static final String PREDEFINED_C_TYPES_IN_SHARE_FOLDER = "\\Properties\\PredefinedTypesC.sbs";
	private static final String PREDEFINED_CPP_TYPES_IN_SHARE_FOLDER = "\\Properties\\PredefinedTypesC++.sbs";

	/**
	 * this test check that the Rhapsody folder is known by the system
	 */
	 @Test
	public void checkSharedRhapsodyFolder() {
		// if this field is not registered, we can't execute the JUnit tests!
		// System.setProperty("-RhapsodyHome","C:\\IBM\\Rational\\Rhapsody\\8.0\\Share");
		// or //C:\ProgramData\IBM\Rational\Rhapsody\8.1.5\Share
		final String rhpHome = RhapsodyShareFolderUtils.getRhapsodyShareFolder();
		String uri = rhpHome;// + "traze";
		File file = new File(uri);
		Assert.assertTrue(NLS.bind("The given Rhapsody Shared Folder Path doesn't not exists. We don't found: {0}", rhpHome), file.exists());


		// checking SysML file is found
		Assert.assertTrue("SysML File not found in the Rhapsody Share folder", new File(rhpHome + SYSML_FILE_PATH_IN_SHARE_FOLDER).exists());
		// checking Predefined Types C file is found
		Assert.assertTrue("Predefined Type C File not found in the Rhapsody Share folder", new File(rhpHome + PREDEFINED_C_TYPES_IN_SHARE_FOLDER).exists());
		// checking Predefined Types C++ file is found
		Assert.assertTrue("Predefined Type C++ File not found in the Rhapsody Share folder", new File(rhpHome + PREDEFINED_CPP_TYPES_IN_SHARE_FOLDER).exists());
		// checking MARTE folder is found
		Assert.assertTrue("MARTE not found in the Rhapsody Share folder", new File(rhpHome + MARTE_FOLDER_PATH_IN_SHARE_FOLDER).exists());
	}


}
