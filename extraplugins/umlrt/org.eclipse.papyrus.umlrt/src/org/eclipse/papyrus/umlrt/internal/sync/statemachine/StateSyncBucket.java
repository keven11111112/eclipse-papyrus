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

package org.eclipse.papyrus.umlrt.internal.sync.statemachine;

import org.eclipse.papyrus.umlrt.internal.sync.UMLSyncBucket;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Synchronization bucket for capsule state machine vertices.
 */
public class StateSyncBucket extends UMLSyncBucket<State> {

	public StateSyncBucket(State model) {
		super(model);

		// VertexSyncBucket takes care of the state name and other details of vertices generally
		add(new StateMachineRegionsSyncFeature<State>(this, UMLPackage.Literals.STATE__REGION));
	}

}
