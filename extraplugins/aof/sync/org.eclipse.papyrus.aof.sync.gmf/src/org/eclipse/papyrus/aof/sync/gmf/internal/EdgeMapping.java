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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Anchor;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.aof.core.IFactory;
import org.eclipse.papyrus.aof.core.IOne;
import org.eclipse.papyrus.aof.gmf.DiagramFactory;
import org.eclipse.papyrus.aof.sync.ICorrespondenceResolver;
import org.eclipse.papyrus.aof.sync.IMapping;

/**
 * Mapping of edges, including the nodes that they attach to (not yet supporting
 * edges attached to edges).
 */
@Singleton
public class EdgeMapping extends ViewMapping<Edge> {

	@Inject
	private ICorrespondenceResolver<Node, Edge> endpointCorrespondence;

	@Inject
	private ICorrespondenceResolver<Node, View> labelCorrespondence;

	@Inject
	private IMapping<Node> labelMapping;

	@Inject
	public EdgeMapping(IFactory factory) {
		super(NotationPackage.Literals.EDGE, factory);
	}

	@Override
	protected void mapProperties(IOne<Edge> from, IOne<Edge> to) {
		super.mapProperties(from, to);

		mapCorresponding(from, to, NotationPackage.Literals.EDGE__SOURCE, endpointCorrespondence);
		mapCorresponding(from, to, NotationPackage.Literals.EDGE__TARGET, endpointCorrespondence);
		mapCorresponding(from, to, DiagramFactory.CHILDREN_PROPERTY, labelCorrespondence, labelMapping);

		this.<Anchor> initProperty(from, to, NotationPackage.Literals.EDGE__SOURCE_ANCHOR, EcoreUtil::copy);
		this.<Anchor> initProperty(from, to, NotationPackage.Literals.EDGE__TARGET_ANCHOR, EcoreUtil::copy);
	}
}
