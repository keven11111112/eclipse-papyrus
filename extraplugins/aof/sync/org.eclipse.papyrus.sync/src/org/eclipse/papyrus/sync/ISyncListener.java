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

package org.eclipse.papyrus.sync;

/**
 * Listener protocol for notification of changes to synchronization of model
 * elements in the {@link ISyncService}.
 */
public interface ISyncListener {

	/**
	 * Notifies me that some synchronization state has changed for a model
	 * element
	 * 
	 * @param event
	 *            the synchronization change event
	 */
	void synchronizationChanged(SyncEvent event);
}
