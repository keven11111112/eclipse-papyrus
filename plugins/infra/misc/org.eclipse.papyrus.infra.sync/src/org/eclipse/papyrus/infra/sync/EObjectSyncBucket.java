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

package org.eclipse.papyrus.infra.sync;

import org.eclipse.emf.ecore.EObject;

/**
 * A specialization of the {@link SyncBucket} that synchronizes EMF objects.
 */
public abstract class EObjectSyncBucket<M extends EObject, T, X> extends SyncBucket<M, T, X> {

	public EObjectSyncBucket(M model) throws IllegalArgumentException {
		super(model);
	}

}
