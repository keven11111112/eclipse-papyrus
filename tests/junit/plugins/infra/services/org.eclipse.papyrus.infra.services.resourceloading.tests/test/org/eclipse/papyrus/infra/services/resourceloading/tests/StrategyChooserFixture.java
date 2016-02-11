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
package org.eclipse.papyrus.infra.services.resourceloading.tests;

import org.eclipse.papyrus.infra.services.resourceloading.IStrategyChooser;
import org.eclipse.papyrus.infra.services.resourceloading.impl.ProxyManager;


/**
 * A {@link StrategyChooser} fixture for the control-mode tests that ensures a normal control-mode strategy
 * is restored after completion for predictable/correct resource loading behaviour in the execution of
 * subsequent (and unrelated) tests.
 */
public class StrategyChooserFixture {

	private final int strategyToRestore;
	private IStrategyChooser chooser;

	public StrategyChooserFixture(int choose) {
		super();

		chooser = ProxyManager.getStrategyChooser();
		strategyToRestore = chooser.getCurrentStrategy();
		chooser.setStrategy(choose);
	}

	public void dispose() {
		if (chooser != null) {
			chooser.setStrategy(strategyToRestore);
			chooser = null;
		}
	}

}
