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

package org.eclipse.papyrus.aof.sync.gmf;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.aof.sync.IMapping;
import org.eclipse.papyrus.aof.sync.MappingFactory;

import com.google.inject.Module;

/**
 * Mapping factory for diagram mappings.
 */
public class DiagramMappingFactory extends MappingFactory {

	public DiagramMappingFactory() {
		this(new DiagramMappingModule());
	}

	public DiagramMappingFactory(Module... module) {
		super(module);
	}

	public IMapping<Diagram> getDiagramMapping() {
		return getMapping(Diagram.class);
	}

	public IMapping<Node> getNodeMapping() {
		return getMapping(Node.class);
	}

	public IMapping<Edge> getEdgeMapping() {
		return getMapping(Edge.class);
	}
}
