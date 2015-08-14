/*****************************************************************************
 * Copyright (c) 2010, 2015 CEA LIST; Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid - juan.cadavid@cea.fr
 *  Christian W. Damus - bug 464647
 *
 *****************************************************************************/
package org.eclipse.papyrus.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.junit.framework.runner.AllTestsRunner;
import org.eclipse.papyrus.junit.framework.runner.FragmentTestSuiteClass;
import org.eclipse.papyrus.junit.framework.runner.ITestSuiteClass;
import org.eclipse.papyrus.junit.framework.runner.SuiteSpot;
import org.junit.runner.RunWith;

import com.google.common.collect.ImmutableList;


/**
 * Tests generated with the Papyrus Test Generation Framework
 */
@RunWith(AllTestsRunner.class)
public class AllGenTests {

	@SuiteSpot
	public static final List<ITestSuiteClass> suiteClasses;

	/** list of classes to launch */
	static {
		suiteClasses = new ArrayList<ITestSuiteClass>();

		/* **************** Dynamically loaded from the host plug-ins *********************** */

		suiteClasses.add(new FragmentTestSuiteClass("org.eclipse.papyrus.uml.diagram.activity.tests", "org.eclipse.papyrus.uml.diagram.activity.test.AllGenTests"));
		suiteClasses.add(new FragmentTestSuiteClass("org.eclipse.papyrus.uml.diagram.clazz.tests", "org.eclipse.papyrus.uml.diagram.clazz.test.AllGenTests"));
		suiteClasses.add(new FragmentTestSuiteClass("org.eclipse.papyrus.uml.diagram.communication.tests", "org.eclipse.papyrus.uml.diagram.communication.test.AllGenTests"));
		suiteClasses.add(new FragmentTestSuiteClass("org.eclipse.papyrus.uml.diagram.component.tests", "org.eclipse.papyrus.uml.diagram.component.test.AllGenTests"));
		suiteClasses.add(new FragmentTestSuiteClass("org.eclipse.papyrus.uml.diagram.composite.tests", "org.eclipse.papyrus.uml.diagram.composite.test.AllGenTests"));
		suiteClasses.add(new FragmentTestSuiteClass("org.eclipse.papyrus.uml.diagram.deployment.tests", "org.eclipse.papyrus.uml.diagram.deployment.test.AllGenTests"));
		suiteClasses.add(new FragmentTestSuiteClass("org.eclipse.papyrus.uml.diagram.profile.tests", "org.eclipse.papyrus.uml.diagram.profile.tests.AllGenTests"));
		suiteClasses.add(new FragmentTestSuiteClass("org.eclipse.papyrus.uml.diagram.statemachine.tests", "org.eclipse.papyrus.uml.diagram.statemachine.test.AllGenTests"));
		suiteClasses.add(new FragmentTestSuiteClass("org.eclipse.papyrus.uml.diagram.sequence.tests", "org.eclipse.papyrus.uml.diagram.sequence.test.AllGenTests"));
		suiteClasses.add(new FragmentTestSuiteClass("org.eclipse.papyrus.uml.diagram.timing.tests", "org.eclipse.papyrus.uml.diagram.timing.test.AllGenTests"));
		suiteClasses.add(new FragmentTestSuiteClass("org.eclipse.papyrus.uml.diagram.usecase.tests", "org.eclipse.papyrus.uml.diagram.usecase.test.AllGenTests"));
		// end
	}

	//
	// The tests broken out into sub-suites for serial execution, to avoid OOMEs
	//

	@RunWith(AllTestsRunner.class)
	public static class Suite1 {
		@SuiteSpot
		public static final List<? extends ITestSuiteClass> suiteClasses = ImmutableList.of( //
				new FragmentTestSuiteClass("org.eclipse.papyrus.uml.diagram.clazz.tests", "org.eclipse.papyrus.uml.diagram.clazz.test.AllGenTests"),
				new FragmentTestSuiteClass("org.eclipse.papyrus.uml.diagram.profile.tests", "org.eclipse.papyrus.uml.diagram.profile.tests.AllGenTests"),
				new FragmentTestSuiteClass("org.eclipse.papyrus.uml.diagram.usecase.tests", "org.eclipse.papyrus.uml.diagram.usecase.test.AllGenTests"));
	}

	@RunWith(AllTestsRunner.class)
	public static class Suite2 {
		@SuiteSpot
		public static final List<? extends ITestSuiteClass> suiteClasses = ImmutableList.of( //
				new FragmentTestSuiteClass("org.eclipse.papyrus.uml.diagram.component.tests", "org.eclipse.papyrus.uml.diagram.component.test.AllGenTests"),
				new FragmentTestSuiteClass("org.eclipse.papyrus.uml.diagram.composite.tests", "org.eclipse.papyrus.uml.diagram.composite.test.AllGenTests"),
				new FragmentTestSuiteClass("org.eclipse.papyrus.uml.diagram.deployment.tests", "org.eclipse.papyrus.uml.diagram.deployment.test.AllGenTests"));
	}

	@RunWith(AllTestsRunner.class)
	public static class Suite3 {
		@SuiteSpot
		public static final List<? extends ITestSuiteClass> suiteClasses = ImmutableList.of( //
				new FragmentTestSuiteClass("org.eclipse.papyrus.uml.diagram.activity.tests", "org.eclipse.papyrus.uml.diagram.activity.test.AllGenTests"),
				new FragmentTestSuiteClass("org.eclipse.papyrus.uml.diagram.statemachine.tests", "org.eclipse.papyrus.uml.diagram.statemachine.test.AllGenTests"));
	}

	@RunWith(AllTestsRunner.class)
	public static class Suite4 {
		@SuiteSpot
		public static final List<? extends ITestSuiteClass> suiteClasses = ImmutableList.of( //
				new FragmentTestSuiteClass("org.eclipse.papyrus.uml.diagram.communication.tests", "org.eclipse.papyrus.uml.diagram.communication.test.AllGenTests"),
				new FragmentTestSuiteClass("org.eclipse.papyrus.uml.diagram.sequence.tests", "org.eclipse.papyrus.uml.diagram.sequence.test.AllGenTests"),
				new FragmentTestSuiteClass("org.eclipse.papyrus.uml.diagram.timing.tests", "org.eclipse.papyrus.uml.diagram.timing.test.AllGenTests"));
	}
}
