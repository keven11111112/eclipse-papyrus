/*****************************************************************************
 * Copyright (c) 2016 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Christian W. Damus - Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.migration.rsa.tests.regression;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



/**
 * Suite of specific bug regression tests.
 */
@RunWith(Suite.class)
@SuiteClasses({
		StructureDiagramTest.class,
})
public class RegressionTests {
	// All is specified in annotations
}
