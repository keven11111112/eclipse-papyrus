/*
 * Copyright (c) 2015 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *
 */
package org.eclipse.papyrus.uml.profile.tests;

import org.eclipse.papyrus.uml.profile.service.ReapplyProfilesServiceTest;
import org.junit.runner.RunWith;
import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * The Papyrus UML Profile bundle's master test suite.
 */
@RunWith(ClassificationSuite.class)
@SuiteClasses({ ReapplyProfilesServiceTest.class })
public class AllTests {
	// JUnit 4 Test Suite
}
