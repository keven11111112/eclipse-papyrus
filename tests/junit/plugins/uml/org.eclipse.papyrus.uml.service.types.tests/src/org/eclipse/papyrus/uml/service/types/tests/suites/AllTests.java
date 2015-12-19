/*****************************************************************************
 * Copyright (c) 2012, 2015 CEA LIST, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus - bug 458685
 *   Christian W. Damus - bug 468071
 *   Christian W. Damus - bug 465899
 *   Christian W. Damus - bug 478314
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.service.types.tests.suites;

import org.eclipse.papyrus.uml.service.types.tests.creation.ConnectorReadOnlyTestBug465899;
import org.eclipse.papyrus.uml.service.types.tests.creation.CreateElementTest;
import org.eclipse.papyrus.uml.service.types.tests.creation.CreateProfileRelationshipTest;
import org.eclipse.papyrus.uml.service.types.tests.creation.CreatePureUMLElementTest;
import org.eclipse.papyrus.uml.service.types.tests.creation.CreateRelationshipTest;
import org.eclipse.papyrus.uml.service.types.tests.creation.MoveElementTest;
import org.eclipse.papyrus.uml.service.types.tests.creation.SetFeatureTest;
import org.eclipse.papyrus.uml.service.types.tests.deletion.DeleteAssociationTest;
import org.eclipse.papyrus.uml.service.types.tests.deletion.DeleteContainmentSubsetTest;
import org.eclipse.papyrus.uml.service.types.tests.deletion.DeleteDependentWithStereotypeApplications458685;
import org.eclipse.papyrus.uml.service.types.tests.deletion.DeletePureUMLElementTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Main Test suite.
 */
@RunWith(Suite.class)
@SuiteClasses({
		// TestElementTypeRegistryContent.class,
		CreatePureUMLElementTest.class, // pure uml tests, only element edit service
		CreateElementTest.class,
		CreateRelationshipTest.class,
		CreateProfileRelationshipTest.class,
		MoveElementTest.class,
		SetFeatureTest.class,
		DeletePureUMLElementTest.class,
		DeleteAssociationTest.class,
		DeleteDependentWithStereotypeApplications458685.class,
		DeleteContainmentSubsetTest.class,
		ConnectorReadOnlyTestBug465899.class,
})
public class AllTests {
	// JUnit 4 Test Suite
}
