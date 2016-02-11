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
 * A description of conditions for triggering some synchronization action on some object.
 * Synchronization triggers are evaluated by the system initially on the root object of
 * a model. Cascading evaluation of triggers, if necessary, is the responsibility of
 * trigger extensions.
 */
public interface ISyncTrigger {

	boolean isTriggeredOn(Object object);

	ISyncAction trigger(ISyncService syncService, Object object);
}
