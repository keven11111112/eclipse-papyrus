/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - bug 496176
 *****************************************************************************/
package org.eclipse.papyrus.migration.common.internal;

import org.eclipse.core.runtime.jobs.Job;

public class JobWrapper implements Schedulable {

	protected final Job job;

	public JobWrapper(Job job) {
		this.job = job;
	}

	@Override
	public void start() {
		job.schedule();
	}

	@Override
	public boolean isComplete() {
		return job.getResult() != null;
	}

	@Override
	public String getName() {
		return job.getName();
	}

	@Override
	public void cancel() {
		job.cancel();
	}

}
