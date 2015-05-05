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
import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.sync.EMFDispatch;
import org.eclipse.papyrus.infra.sync.EMFDispatchManager;
import org.eclipse.papyrus.infra.sync.ISyncObject;

/**
 * A Papyrus Service providing EMF dispatch managers, synchronization registries, and other synchronization facilities.
 */
public interface ISyncService extends ISyncObject, IService {
	<D extends EMFDispatch> EMFDispatchManager<D> createSingleDispatchManager();

	<D extends EMFDispatch> EMFDispatchManager<D> createMultipleDispatchManager();

	IStatus evaluateTriggers(Object object);
}
