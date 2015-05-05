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
import org.eclipse.uml2.uml.Vertex;

/**
 * Synchronization registry for the vertices in a state machine diagrams.
 */
public class VertexSyncRegistry extends UMLRTSyncRegistry<Vertex> {

	public VertexSyncRegistry() {
		super(org.eclipse.papyrus.umlrt.internal.sync.statemachine.VertexSyncRegistry.class);
	}
}
