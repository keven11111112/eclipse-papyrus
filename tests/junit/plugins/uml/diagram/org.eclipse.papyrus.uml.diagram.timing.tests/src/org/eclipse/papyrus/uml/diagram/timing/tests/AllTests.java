/*******************************************************************************
 * Copyright (c) 2012, 2015 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus - bug 464647
 *   
 *******************************************************************************/

package org.eclipse.papyrus.uml.diagram.timing.tests;

import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite.DynamicClasses;
import org.eclipse.papyrus.uml.diagram.timing.tests.canonical.AllCanonicalTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

//@formatter:off
@RunWith(ClassificationSuite.class)
@SuiteClasses({
		// canonical
		AllCanonicalTests.class,
})
@DynamicClasses("org.eclipse.papyrus.uml.diagram.timing.test.AllGenTests")
// @formatter:on
public class AllTests {
	// Junit 4 test case
}
