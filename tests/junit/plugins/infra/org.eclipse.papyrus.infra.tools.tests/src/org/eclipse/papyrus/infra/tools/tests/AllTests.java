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
package org.eclipse.papyrus.infra.tools.tests;

import org.eclipse.papyrus.infra.tools.databinding.AllDataBindingTests;
import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;


/**
 * The master test suite for the plug-in.
 */
@RunWith(ClassificationSuite.class)
@SuiteClasses({ AllDataBindingTests.class })
public class AllTests {

	public AllTests() {
		super();
	}

}
