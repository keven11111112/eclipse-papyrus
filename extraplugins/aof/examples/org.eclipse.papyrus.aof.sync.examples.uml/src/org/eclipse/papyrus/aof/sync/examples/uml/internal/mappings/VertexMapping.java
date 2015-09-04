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

package org.eclipse.papyrus.aof.sync.examples.uml.internal.mappings;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;

/**
 * Mapping of vertices in a region of a state machine.
 */
@Singleton
public class VertexMapping extends NamedElementMapping<Vertex> {
	@Inject
	public VertexMapping(IFactory factory) {
		super(UMLPackage.Literals.VERTEX, factory);
	}

	@Override
	protected void mapProperties(IOne<Vertex> parentVertex, IOne<Vertex> childVertex) {
		super.mapProperties(parentVertex, childVertex);

		bindPropertyValue(parentVertex.select(State.class), childVertex.select(State.class), UMLPackage.Literals.STATE, UMLPackage.Literals.STATE__REDEFINED_STATE);
	}
}
