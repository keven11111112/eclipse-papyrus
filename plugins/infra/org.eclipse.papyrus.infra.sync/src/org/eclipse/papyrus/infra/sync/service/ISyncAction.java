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

import org.eclipse.core.runtime.IStatus;

/**
 * An action performed on occurrence of a {@linkplain ISyncTrigger synchronization trigger} to configure/modify the synchronization
 * behaviour of some object.
 */
public interface ISyncAction {
	IStatus perform(ISyncService syncService, Object object);
}
