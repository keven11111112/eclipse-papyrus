/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.tests;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.papyrus.junit.framework.runner.AllTestsRunner;
import org.eclipse.papyrus.junit.framework.runner.Headless;
import org.eclipse.papyrus.junit.framework.runner.ITestSuiteClass;
import org.eclipse.papyrus.junit.framework.runner.SuiteSpot;
import org.junit.runner.RunWith;

/**
 * A test suite that automatically selects all non-{@linkplain Headless headless} tests
 * from the {@link AllTests} suite.
 */
@RunWith(AllTestsRunner.class)
public class AllUITests {

	@SuiteSpot
	public static final List<ITestSuiteClass> suiteClasses;

	static {
		suiteClasses = AllTests.suiteClasses.stream()
				.filter(ITestSuiteClass::isUI)
				.collect(Collectors.toList());
	}

	public AllUITests() {
		super();
	}

}
