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

package org.eclipse.papyrus.infra.sync.service;

/**
 * The base class of {@link ISyncTrigger}s that are registered on the extension point with XML enablement expressions.
 */
public abstract class AbstractSyncTrigger implements ISyncTrigger {

	public AbstractSyncTrigger() {
		super();
	}

	/**
	 * Just returns {@code true} because enablement is actually computed by the XML expression on the extension point.
	 */
	@Override
	public boolean isTriggeredOn(Object object) {
		return true;
	}

}
