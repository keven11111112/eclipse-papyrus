/*****************************************************************************
 * Copyright (c) 2010, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bugs 402525, 323802, 431953, 433310, 434993
 *  Christian W. Damus - bugs 399859, 451230, 433206, 463156, 474610, 469188, 485220, 488791, 496598, 508629
 *
 *****************************************************************************/
package org.eclipse.papyrus.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.junit.framework.runner.AllTestsRunner;
import org.eclipse.papyrus.junit.framework.runner.ITestSuiteClass;
import org.eclipse.papyrus.junit.framework.runner.PluginTestSuiteClass;
import org.eclipse.papyrus.junit.framework.runner.SuiteSpot;
import org.junit.runner.RunWith;


/**
 * Test class for all tests for Papyrus
 */
@RunWith(AllTestsRunner.class)
public class AllTests {

	@SuiteSpot
	public static final List<ITestSuiteClass> suiteClasses;

	/** list of classes to launch */
	static {
		suiteClasses = new ArrayList<>();

		/* **************** suites *********************** */
		// suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.developer.suite.tests.AllTests.class));
		// suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.core.suite.tests.AllTests.class));
		// suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.nattable.suite.tests.AllTests.class));
		// suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.suite.tests.AllTests.class));
		// suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.diagram.suite.tests.AllTests.class));
		// suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.nattable.suite.tests.AllTests.class));
		// suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.suite.tests.AllTests.class));
		// suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.textedit.suite.tests.AllTests.class));
		// suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.views.suite.tests.AllTests.class));


		// end
	}

}
