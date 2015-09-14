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

package org.eclipse.papyrus.aof.sync.gmf.tests;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.aof.sync.ISyncMapping;
import org.eclipse.papyrus.aof.sync.gmf.DiagramMappingFactory;
import org.eclipse.papyrus.aof.sync.gmf.internal.DiagramMapping;
import org.eclipse.papyrus.aof.sync.gmf.internal.EdgeMapping;
import org.eclipse.papyrus.aof.sync.gmf.internal.NodeMapping;
import org.junit.Test;

/**
 * Test cases for the {@link DiagramMappingFactory} class.
 */
public class DiagramMappingFactoryTest {

	private DiagramMappingFactory fixture = new DiagramMappingFactory();

	public DiagramMappingFactoryTest() {
		super();
	}

	@Test
	public void getDiagramMapping() {
		ISyncMapping<Diagram> mapping = fixture.getDiagramMapping();
		assertThat(mapping, instanceOf(DiagramMapping.class));
	}

	@Test
	public void getNodeMapping() {
		ISyncMapping<Node> mapping = fixture.getNodeMapping();
		assertThat(mapping, instanceOf(NodeMapping.class));
	}

	@Test
	public void getEdgeMapping() {
		ISyncMapping<Edge> mapping = fixture.getEdgeMapping();
		assertThat(mapping, instanceOf(EdgeMapping.class));
	}

}
