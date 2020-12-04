/******************************************************************************
 * Copyright (c) 2006, 2020 Borland Software Corporation, CEA LIST, Artal
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.bridge.wizards.pages;

import org.eclipse.papyrus.gmf.mappings.LinkMapping;
import org.eclipse.papyrus.gmf.mappings.NodeMapping;
import org.eclipse.papyrus.gmf.tooldef.AbstractTool;
import org.eclipse.papyrus.gmf.tooldef.CreationTool;
import org.eclipse.papyrus.gmf.tooldef.GMFToolFactory;
import org.eclipse.papyrus.gmf.tooldef.Palette;
import org.eclipse.papyrus.gmf.tooldef.ToolGroup;
import org.eclipse.papyrus.gmf.tooldef.ToolRegistry;

/**
 * Naive, creates new tool each time, don't care about duplicated mappings.
 * @author artem
 */
@SuppressWarnings("unchecked")
public class CreateToolDef implements ToolDefSupplier {
	private final Palette myPalette;
	private final ToolGroup myNodesGroup;
	private final ToolGroup myLinksGroup;

	public CreateToolDef(ToolRegistry registry) {
		assert registry != null;
		if (registry.getPalette() == null) {
			myPalette = GMFToolFactory.eINSTANCE.createPalette();
			myPalette.setTitle("Generated");
			myPalette.setDescription("Generated");
			registry.setPalette(myPalette);
		} else {
			myPalette = registry.getPalette();
		}
		myNodesGroup = GMFToolFactory.eINSTANCE.createToolGroup();
		myNodesGroup.setDescription("Generated node creation tools");
		myNodesGroup.setTitle("Nodes");
		myLinksGroup = GMFToolFactory.eINSTANCE.createToolGroup();
		myLinksGroup.setDescription("Generated link creation tools");
		myLinksGroup.setTitle("Links");

		myPalette.getTools().add(myNodesGroup);
		myPalette.getTools().add(myLinksGroup);
	}

	public AbstractTool findTool(NodeMapping nm) {
		CreationTool t = GMFToolFactory.eINSTANCE.createCreationTool();
		t.setTitle("Create Node " + String.valueOf(1 + myNodesGroup.getTools().size()));
		t.setSmallIcon(GMFToolFactory.eINSTANCE.createDefaultImage());
		myNodesGroup.getTools().add(t);
		return t;
	}

	public AbstractTool findTool(LinkMapping lm) {
		CreationTool t = GMFToolFactory.eINSTANCE.createCreationTool();
		t.setTitle("Create Link " + String.valueOf(1 + myLinksGroup.getTools().size()));
		t.setSmallIcon(GMFToolFactory.eINSTANCE.createDefaultImage());
		myLinksGroup.getTools().add(t);
		return t;
	}
}
