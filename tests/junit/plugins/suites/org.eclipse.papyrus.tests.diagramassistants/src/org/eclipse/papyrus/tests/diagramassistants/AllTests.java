/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Christian W. Damus - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.tests.diagramassistants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.papyrus.junit.framework.runner.AllTestsRunner;
import org.eclipse.papyrus.junit.framework.runner.ITestSuiteClass;
import org.eclipse.papyrus.junit.framework.runner.PluginTestSuiteClass;
import org.eclipse.papyrus.junit.framework.runner.SuiteSpot;
import org.junit.runner.RunWith;


/**
 * Test suite for all Diagram Assistants tests for Papyrus.
 */
@RunWith(AllTestsRunner.class)
public class AllTests {

	@SuiteSpot
	public static final List<ITestSuiteClass> suiteClasses;

	static {
		suiteClasses = new ArrayList<ITestSuiteClass>();

		// Basic bundle metadata tests (always want to cover the plug-ins we're testing in the suite)
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.bundles.tests.AllTests.class));

		// Infrastructure layer
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.filters.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.infra.gmfdiag.assistant.tests.AllTests.class));

		// UML layer
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.filters.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.profile.assistants.generator.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.uml.profile.types.generator.tests.AllTests.class));
	}

	public static void appendTo(Collection<? super ITestSuiteClass> suite) {
		// Don't include the bundles tests, which the suite we're appending to should already have
		suite.addAll(suiteClasses.subList(1, suiteClasses.size()));
	}
}
