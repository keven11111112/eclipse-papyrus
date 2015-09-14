/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
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

package org.eclipse.papyrus.aof.sync.tests;

import org.eclipse.papyrus.aof.sync.tests.runners.GuiceRunner;
import org.eclipse.papyrus.junit.utils.rules.HouseKeeper;
import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * An useful superclass for tests in the AOF-based synchronization framework test suite.
 */
@RunWith(GuiceRunner.class)
public abstract class AbstractTest {

	@Rule
	public final HouseKeeper houseKeeper = new HouseKeeper();

}
