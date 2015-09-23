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

import java.util.function.Supplier;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.aof.sync.ISyncMapping;
import org.eclipse.papyrus.aof.sync.MappingFactory;

import com.google.inject.Module;
import com.google.inject.util.Providers;

/**
 * Mapping factory for diagram mappings.
 */
public class DiagramMappingFactory extends MappingFactory {

	public DiagramMappingFactory() {
		this(new DiagramMappingModule());
	}

	public DiagramMappingFactory(TransactionalEditingDomain editingDomain) {
		this(new DiagramMappingModule(Providers.of(editingDomain)));
	}

	public DiagramMappingFactory(Supplier<? extends TransactionalEditingDomain> editingDomainSupplier) {
		this(new DiagramMappingModule(editingDomainSupplier::get));
	}

	public DiagramMappingFactory(Module module, Module... more) {
		super(module, more);
	}

	public ISyncMapping<Diagram> getDiagramMapping() {
		return getSyncMapping(Diagram.class);
	}

	public ISyncMapping<Node> getNodeMapping() {
		return getSyncMapping(Node.class);
	}

	public ISyncMapping<Edge> getEdgeMapping() {
		return getSyncMapping(Edge.class);
	}
}
