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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.umlrt.custom.utils.CapsuleUtils;
import org.eclipse.papyrus.umlrt.internal.sync.UMLSyncRegistry;
import org.eclipse.uml2.uml.Vertex;

/**
 * Capsule statemachine vertex synchronization registry.
 */
public class VertexSyncRegistry extends UMLSyncRegistry<Vertex> {

	public VertexSyncRegistry() {
		super();
	}

	@Override
	public Vertex getModelOf(EObject backend) {
		return getRedefinedVertex(backend);
	}

	public static Vertex getRedefinedVertex(EObject vertex) {
		return (vertex instanceof Vertex) ? CapsuleUtils.getSuperVertex((Vertex) vertex) : null;
	}
}
