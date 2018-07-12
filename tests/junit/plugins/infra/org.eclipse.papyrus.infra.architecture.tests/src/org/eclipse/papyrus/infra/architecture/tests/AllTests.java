/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.infra.architecture.tests;

import org.eclipse.papyrus.infra.architecture.tests.merged.MergedArchitectureDomainTest;
import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.eclipse.papyrus.junit.framework.runner.Headless;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * The master test suite for the plug-in.
 */
@RunWith(ClassificationSuite.class)
@SuiteClasses({
	MergedArchitectureDomainTest.class,
	})
@Headless
public class AllTests {
	// Nothing required
}
