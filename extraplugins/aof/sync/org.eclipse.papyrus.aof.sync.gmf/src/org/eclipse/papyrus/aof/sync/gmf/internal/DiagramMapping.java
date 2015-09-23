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

package org.eclipse.papyrus.aof.sync.gmf.internal;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.sync.ISyncCorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.ISyncMapping;
import org.eclipse.papyrus.aof.sync.emf.EMFSyncMapping;

/**
 * Mapping of diagrams, including their contained top-level nodes and edges.
 */
@Singleton
public class DiagramMapping extends EMFSyncMapping<Diagram> {
	@Inject
	private ISyncMapping<Node> nodes;

	@Inject
	private ISyncMapping<Edge> edges;

	@Inject
	private ISyncCorrespondenceResolver<Node, View> nodeCorrespondence;

	@Inject
	private ISyncCorrespondenceResolver<Edge, Diagram> edgeCorrespondence;

	@Inject
	public DiagramMapping(IFactory factory) {
		super(NotationPackage.Literals.DIAGRAM, factory);
	}

	@Override
	protected void mapProperties(IOne<Diagram> from, IOne<Diagram> to) {
		mapCorresponding(from, to, NotationPackage.Literals.VIEW__PERSISTED_CHILDREN, nodeCorrespondence, nodes);
		mapCorresponding(from, to, NotationPackage.Literals.DIAGRAM__PERSISTED_EDGES, edgeCorrespondence, edges);
	}
}
