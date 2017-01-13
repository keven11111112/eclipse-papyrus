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

import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Master test suite for this test fragment.
 */
@RunWith(ClassificationSuite.class)
@SuiteClasses({
		org.eclipse.papyrus.migration.rhapsody.tests.AllTests.class,
		
		ImportSysML11_EnumerationInBDD_Test.class,
		ImportSysML11_AssociationLabelInBDD_Test.class,
		ImportSysML11_Rph_Actors_And_Events_001_Test.class,
		ImportSysML11_Rph_LibraryImport_001_Test.class
})

public class AllTests {

}
 