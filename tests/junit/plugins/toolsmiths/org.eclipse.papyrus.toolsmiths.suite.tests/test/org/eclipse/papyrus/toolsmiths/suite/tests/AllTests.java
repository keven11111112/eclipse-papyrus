/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Pauline DEVILLE (CEA LIST) pauline.deville@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.toolsmiths.suite.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.junit.framework.runner.AllTestsRunner;
import org.eclipse.papyrus.junit.framework.runner.ITestSuiteClass;
import org.eclipse.papyrus.junit.framework.runner.PluginTestSuiteClass;
import org.eclipse.papyrus.junit.framework.runner.SuiteSpot;
import org.junit.runner.RunWith;

/**
 * Test class for all tests for toolsmiths
 */
@RunWith(AllTestsRunner.class)
public class AllTests {

	@SuiteSpot
	public static final List<ITestSuiteClass> suiteClasses;

	/** list of classes to launch */
	static {
		suiteClasses = new ArrayList<>();

		/* **************** plugins *********************** */
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.toolsmiths.profilemigration.tests.AllTests.class));


		// end
	}

}
