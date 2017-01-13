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

package org.eclipse.papyrus.migration.rhapsody.sysml.tests.tests;


import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.migration.rhapsody.sysml.tests.Activator;
import org.eclipse.papyrus.migration.rhapsody.tests.tests.AbstractImportRhapsodyModelTests;
import org.junit.Before;

/**
 * 
 * @author VL222926
 * 
 * 
 *
 */
@PluginResource("resources/AssociationLabelInBDD_test/expected_papyrus/AssociationLabelInBDD.di") // the name of the expected model must be the same than the name of the Rhapsody project
public class ImportSysML11_AssociationLabelInBDD_Test extends AbstractImportRhapsodyModelTests {

	/**
	 * the name of the Rhapsody File
	 */
	public static final String RHAPSODY_MODEL_NAME = "AssociationLabelInBDD";// $NON-NLS-0$

	/**
	 * the name of the project created to execute the tests
	 */
	public static final String PROJECT_NAME = "org.eclipse.papyrus.sysml.rhapsody.testImport"; // $NON-NLS-0$

	private static final String SOURCE_PATH = "resources/AssociationLabelInBDD_test/"; // $NON-NLS-0$

	/**
	 * 
	 * @throws Exception
	 */
	@Before
	public void initTest() throws Exception {
		super.initTest(PROJECT_NAME, RHAPSODY_MODEL_NAME, SOURCE_PATH, Activator.getDefault().getBundle());
	}

}
