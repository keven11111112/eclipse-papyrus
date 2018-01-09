/*****************************************************************************
 * Copyright (c) 2010, 2015 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 451230
 *****************************************************************************/
package org.eclipse.papyrus.junit.framework.runner;


/**
 * Entry for a test suite in a test plugin
 */
public class PluginTestSuiteClass implements ITestSuiteClass {

	/** main test suite class */
	private final Class<?> testClass;

	/**
	 * Constructor.
	 *
	 * @param testClass
	 *        the main test suite class
	 */
	public PluginTestSuiteClass(Class<?> testClass) {
		this.testClass = testClass;
	}

	/**
	 * {@inheritDoc}
	 */
	public Class<?> getMainTestSuiteClass() {
		return testClass;
	}

	@Override
	public String toString() {
		return String.format("PluginTestSuite %s", testClass);
	}

}
