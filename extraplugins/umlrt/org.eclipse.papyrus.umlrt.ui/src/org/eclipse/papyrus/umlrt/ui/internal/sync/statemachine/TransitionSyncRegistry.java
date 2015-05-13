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

import org.eclipse.papyrus.umlrt.ui.internal.sync.UMLRTSyncRegistry;
import org.eclipse.uml2.uml.Transition;

/**
 * Synchronization registry for the transitions in a state machine diagrams.
 */
public class TransitionSyncRegistry extends UMLRTSyncRegistry<Transition> {

	public TransitionSyncRegistry() {
		super(org.eclipse.papyrus.umlrt.internal.sync.statemachine.TransitionSyncRegistry.class);
	}
}
