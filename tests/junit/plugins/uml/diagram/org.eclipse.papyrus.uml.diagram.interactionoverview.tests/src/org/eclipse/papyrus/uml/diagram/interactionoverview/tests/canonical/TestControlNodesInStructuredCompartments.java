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

package org.eclipse.papyrus.uml.diagram.interactionoverview.tests.canonical;

import org.eclipse.papyrus.infra.gmfdiag.common.updater.DiagramUpdater;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.junit.framework.classification.NotImplemented;
import org.eclipse.papyrus.uml.diagram.interactionoverview.InteractionOverviewDiagramCreateCommand;
import org.eclipse.papyrus.uml.diagram.interactionoverview.tests.IInteractionoverviewDiagramTestsConstants;

public class TestControlNodesInStructuredCompartments extends org.eclipse.papyrus.uml.diagram.activity.tests.canonical.TestControlNodesInStructuredActivityNodes {

	@Override
	public DiagramUpdater getDiagramUpdater() {
		return null;
	}

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new InteractionOverviewDiagramCreateCommand();
	}

	@Override
	protected String getProjectName() {
		return IInteractionoverviewDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IInteractionoverviewDiagramTestsConstants.FILE_NAME;
	}
	
	@Override
	@NotImplemented("InteractionD does not have ability to create StructuralNode")
	public void testCreateInitialNodeInStructuralActivityNode() {
	}

	@Override
	@NotImplemented("InteractionD does not have ability to create ExpansionRegion")
	public void testCreateJoinNodeInExpansionRegion() {
	}
}