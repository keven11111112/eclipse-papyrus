/*****************************************************************************
 * Copyright (c) 2012, 2017 CEA LIST, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus - bugs 458685, 468071, 465899, 478314, 485220
 *   Vincent Lorenzo - bug 492522
 *   Martin Fleck - bug 510268
 *****************************************************************************/

package org.eclipse.papyrus.uml.service.types.tests.suites;

import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.eclipse.papyrus.junit.framework.runner.Headless;
import org.eclipse.papyrus.uml.service.types.tests.creation.ConnectorReadOnlyTestBug465899;
import org.eclipse.papyrus.uml.service.types.tests.creation.CreatePureUMLElementTest;
import org.eclipse.papyrus.uml.service.types.tests.deletion.DeleteCommentLinkTest;
import org.eclipse.papyrus.uml.service.types.tests.deletion.DeleteContainmentSubsetTest;
import org.eclipse.papyrus.uml.service.types.tests.deletion.DeleteDependentWithStereotypeApplications458685;
import org.eclipse.papyrus.uml.service.types.tests.deletion.DeletePureUMLElementTest;
import org.eclipse.papyrus.uml.service.types.tests.deletion.DeleteTransitionsWithVertexTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Main Test suite.
 */
@Headless
@RunWith(ClassificationSuite.class)
@SuiteClasses({
		// TestElementTypeRegistryContent.class,
		CreatePureUMLElementTest.class, // pure uml tests, only element edit service
		DeletePureUMLElementTest.class,
		DeleteDependentWithStereotypeApplications458685.class,
		DeleteTransitionsWithVertexTest.class,
		DeleteContainmentSubsetTest.class,
		ConnectorReadOnlyTestBug465899.class,
		DeleteCommentLinkTest.class
})
public class AllTests {
	// JUnit 4 Test Suite
}
