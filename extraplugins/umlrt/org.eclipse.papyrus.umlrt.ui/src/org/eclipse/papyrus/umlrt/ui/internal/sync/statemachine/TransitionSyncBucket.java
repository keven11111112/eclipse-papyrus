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

package org.eclipse.papyrus.umlrt.ui.internal.sync.statemachine;

import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.umlrt.ui.internal.sync.UMLRTMasterSlaveSyncBucket;
import org.eclipse.uml2.uml.Transition;

/**
 * Synchronization bucket for triggers in a UML-RT Capsule state machine diagram.
 */
public class TransitionSyncBucket extends UMLRTMasterSlaveSyncBucket<Transition> {

	public TransitionSyncBucket(Transition model, EditPart master) {
		super(model, master);

		// Don't attempt to synchronize bendpoints
	}

}
