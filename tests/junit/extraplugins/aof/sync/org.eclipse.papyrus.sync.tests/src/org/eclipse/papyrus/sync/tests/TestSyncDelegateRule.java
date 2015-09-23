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

package org.eclipse.papyrus.sync.tests;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 * A JUnit rule that enables our test sync delegate for the duration of the test.
 */
public class TestSyncDelegateRule extends TestWatcher {

	public TestSyncDelegateRule() {
		super();
	}

	@Override
	protected void starting(Description description) {
		TestSyncDelegate.runningTest = true;
	}

	@Override
	protected void finished(Description description) {
		TestSyncDelegate.runningTest = false;
	}
}
