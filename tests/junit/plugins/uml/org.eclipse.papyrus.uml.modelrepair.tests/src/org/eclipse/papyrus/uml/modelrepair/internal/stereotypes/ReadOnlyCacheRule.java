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

package org.eclipse.papyrus.uml.modelrepair.internal.stereotypes;

import java.util.concurrent.Executor;

import org.eclipse.papyrus.infra.emf.readonly.Activator;
import org.eclipse.papyrus.junit.utils.rules.ExecutorRule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;

/**
 * A JUnit {@linkplain TestRule rule} that makes the resource read-only state cache persist
 * for the duration of the test and be purged at shutdown.
 */
public class ReadOnlyCacheRule extends ExecutorRule {

	public ReadOnlyCacheRule() {
		super();
	}

	/**
	 * Ensures that the read-only resource state cache is cleared now, by running any
	 * pending cache runnables.
	 */
	public void clearCache() {
		runPending();
	}

	@Override
	protected void starting(Description description) {
		super.starting(description);

		final Executor restore = Activator.getDefault().setReadOnlyCacheExecutor(this);
		execute(new Runnable() {

			@Override
			public void run() {
				Activator.getDefault().setReadOnlyCacheExecutor(restore);
			}
		});
	}
}
