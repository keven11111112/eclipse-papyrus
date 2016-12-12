/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.common.tests;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.rendering.DiagramExpansionSingleton;
import org.eclipse.papyrus.infra.gmfdiag.expansion.expansionmodel.rendering.DiagramExpansionsRegistry;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * this Test is used to test if expansion can be loaded
 * see #Test T001-Load ExpansionModel
 *
 */
public class LoadExpansionModel extends AbstractPapyrusTest {

	@Test
	public void init_DiagramExpansionRegistry() {
		DiagramExpansionsRegistry diagramExpansionsRegistry = DiagramExpansionSingleton.getInstance().getDiagramExpansionRegistry();
		diagramExpansionsRegistry.clear();
		Assert.assertEquals("Size ot the registry must be equals to 0", 0, diagramExpansionsRegistry.getDiagramExpansions().size());
		Assert.assertEquals("Size ot the map childreen must be equals to 0", 0, diagramExpansionsRegistry.mapChildreen.size());
	}

	@Test
	public void load_DiagramExpansion() {
		DiagramExpansionsRegistry diagramExpansionsRegistry = loadXMIExpansionModel("NullExpansion.xmi");
		Assert.assertEquals("Size ot the registry must be equals to 1", 1, diagramExpansionsRegistry.getDiagramExpansions().size());
		Assert.assertEquals("Size ot the map childreen must be equals to 0", 0, diagramExpansionsRegistry.mapChildreen.size());

	}

	@Test
	public void load_BadDiagramExpansion() {
		DiagramExpansionsRegistry diagramExpansionsRegistry = loadXMIExpansionModel("BadContextExpansion.xmi");

		// This model is not valid so it is not loaded
		Assert.assertEquals("Size ot the registry must be equals to 0", 0, diagramExpansionsRegistry.getDiagramExpansions().size());
		Assert.assertEquals("Size ot the map childreen must be equals to 0", 0, diagramExpansionsRegistry.mapChildreen.size());
	}

	@Test
	public void load_BadProviderDiagramExpansion() {
		DiagramExpansionsRegistry diagramExpansionsRegistry = loadXMIExpansionModel("BadProviderForExpansion.xmi");

		// This model is not valid so it is not loaded
		Assert.assertEquals("Size ot the registry must be equals to 0", 0, diagramExpansionsRegistry.getDiagramExpansions().size());
		Assert.assertEquals("Size ot the map childreen must be equals to 0", 0, diagramExpansionsRegistry.mapChildreen.size());
	}

	@Test
	public void load_BadelementTypeDiagramExpansion() {
		DiagramExpansionsRegistry diagramExpansionsRegistry = loadXMIExpansionModel("BadElementTypeForExpansion.xmi");

		// This model is not valid so it is not loaded
		Assert.assertEquals("Size ot the registry must be equals to 0", 0, diagramExpansionsRegistry.getDiagramExpansions().size());
		Assert.assertEquals("Size ot the map childreen must be equals to 0", 0, diagramExpansionsRegistry.mapChildreen.size());
	}

	protected DiagramExpansionsRegistry loadXMIExpansionModel(String filename) {
		DiagramExpansionsRegistry diagramExpansionsRegistry = DiagramExpansionSingleton.getInstance().getDiagramExpansionRegistry();
		Assert.assertEquals("Size ot the registry must be equals to 0", 0, diagramExpansionsRegistry.getDiagramExpansions().size());
		Assert.assertEquals("Size ot the map childreen must be equals to 0", 0, diagramExpansionsRegistry.mapChildreen.size());
		URI badContextExpansion = URI.createPlatformPluginURI("org.eclipse.papyrus.infra.gmfdiag.common.tests", true);
		badContextExpansion = badContextExpansion.appendSegment("models");
		badContextExpansion = badContextExpansion.appendSegment(filename);

		diagramExpansionsRegistry.loadExpansion(badContextExpansion);
		return diagramExpansionsRegistry;
	}

	@After
	@Before
	public void clearExpansionRegistry() {
		DiagramExpansionSingleton.getInstance().getDiagramExpansionRegistry().clear();
	}

}
