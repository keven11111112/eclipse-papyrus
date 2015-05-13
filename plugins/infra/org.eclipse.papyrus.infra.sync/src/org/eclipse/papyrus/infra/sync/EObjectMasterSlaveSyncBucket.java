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
 * A specialization of the {@link MasterSlaveSyncBucket} that synchronizes EMF objects.
 */
public abstract class EObjectMasterSlaveSyncBucket<M extends EObject, T, X> extends MasterSlaveSyncBucket<M, T, X> {

	public EObjectMasterSlaveSyncBucket(M model, T master) {
		super(model, master);
	}

	@Override
	public boolean isActive() {
		return getMaster().isActive();
	}

}
