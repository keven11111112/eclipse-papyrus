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
 * An abstract sync item for synchronization with EMF back-ends.
 */
public abstract class EObjectSyncItem<M, T extends EObject> extends SyncItem<M, T> {

	public EObjectSyncItem(T backend) {
		super(backend);
	}

	@Override
	public boolean isActive() {
		boolean result = super.isActive();

		if (result) {
			EObject eObject = getBackend();

			// Detached objects do not synchronize
			result = (eObject != null) && (eObject.eResource() != null);
		}

		return result;
	}
}
