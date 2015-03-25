/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml14.tests.portandflows;

import junit.framework.TestSuite;

import org.eclipse.papyrus.sysml14.tests.deprecatedelements.FlowPortTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * A test suite for the '<em><b>portandflows</b></em>' package. 
 */
@RunWith(Suite.class)
@SuiteClasses({ FlowPortTest.class }) // FIXME , FlowPropertyTest.class : only test not runnig
public class PortandflowsTestSuite extends TestSuite {
	// PortandflowsTests
}
