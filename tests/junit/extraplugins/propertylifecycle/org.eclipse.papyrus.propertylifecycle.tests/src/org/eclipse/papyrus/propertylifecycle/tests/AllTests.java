/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.propertylifecycle.tests;

import org.junit.runner.RunWith;
import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.eclipse.papyrus.propertylifecycle.tests.tests.PropertyLifecycleTests;
import org.junit.runners.Suite.SuiteClasses;


/**
 * All tests for this fragment
 */
@RunWith(ClassificationSuite.class)
@SuiteClasses({ PropertyLifecycleTests.class })
public class AllTests {

}
