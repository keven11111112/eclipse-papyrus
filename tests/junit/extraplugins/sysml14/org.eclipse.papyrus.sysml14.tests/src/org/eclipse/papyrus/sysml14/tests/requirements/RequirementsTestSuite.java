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
package org.eclipse.papyrus.sysml14.tests.requirements;

import junit.framework.TestSuite;

import org.eclipse.papyrus.sysml14.tests.deprecatedelements.RequirementRelatedTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * A test suite for the '<em><b>requirements</b></em>' package.
 */
@RunWith(Suite.class)
@SuiteClasses({  RequirementTest.class, RequirementRelatedTest.class }) 
public class RequirementsTestSuite extends TestSuite {
}
