/*
 * Copyright (c) 2014, 2016 CEA, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *   Christian W. Damus - bug 485220
 *
 */
package org.eclipse.papyrus.uml.modelrepair.tests;

import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.eclipse.papyrus.junit.framework.runner.Headless;
import org.eclipse.papyrus.uml.modelrepair.internal.stereotypes.StereotypeApplicationRepairSnippetTest;
import org.eclipse.papyrus.uml.modelrepair.internal.stereotypes.StereotypeRepairRegressionTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;


/**
 * This is the AllTests type. Enjoy.
 */
@Headless
@RunWith(ClassificationSuite.class)
@SuiteClasses({ StereotypeApplicationRepairSnippetTest.class, StereotypeRepairRegressionTest.class })
public class AllTests {
	// JUnit 4 Test Suite
}
