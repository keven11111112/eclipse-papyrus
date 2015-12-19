/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.training.library.tests;

import org.eclipse.papyrus.training.library.tests.elementtypes.ElementTypesTests;
import org.eclipse.papyrus.training.library.tests.modelexplorer.NewChildTests;
import org.eclipse.papyrus.training.library.tests.palette.GraphicalElementTypesTests;
import org.eclipse.papyrus.training.library.tests.palette.PaletteTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All tests for library training plugins
 */
@RunWith(Suite.class)
@SuiteClasses({ ElementTypesTests.class, NewChildTests.class, GraphicalElementTypesTests.class, PaletteTest.class })
public class AllTests {

}
