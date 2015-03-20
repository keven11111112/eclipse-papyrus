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

package org.eclipse.papyrus.uml.diagram.statemachine.tests.canonical;

import static org.junit.Assert.assertNotNull;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.CreateStateMachineDiagramCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.RegionCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.RegionEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateMachineCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.statemachine.tests.IStateMachineDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.tests.canonical.AbstractPapyrusTestCase;

public class BaseTestCase extends AbstractPapyrusTestCase {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateStateMachineDiagramCommand();
	}

	@Override
	protected String getProjectName() {
		return IStateMachineDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IStateMachineDiagramTestsConstants.FILE_NAME;
	}

	/**
	 * create childNodeEditPart in parentEditPart
	 */
	protected IGraphicalEditPart createChild(int childVID, IGraphicalEditPart container) {
		final IElementType childType = UMLElementTypes.getElementType(childVID);
		final CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(childType, container.getDiagramPreferencesHint());
		requestcreation.setSize(new Dimension(1, 1));
		requestcreation.setLocation(new Point(10, 10));
		Command cmd = container.getCommand(requestcreation);
		executeOnUIThread(cmd);
		return findChildBySemanticHint(container, childVID);
	}

	protected IGraphicalEditPart findChildBySemanticHint(IGraphicalEditPart parent, int vid) {
		IGraphicalEditPart childEP = parent.getChildBySemanticHint(Integer.toString(vid));
		assertNotNull("Parent " + parent + ", type " + parent.getNotationView() + " looking for: " + vid, childEP);
		return childEP;
	}

	protected IGraphicalEditPart getRegionCompartmentEditPart() {
		IGraphicalEditPart sm = findChildBySemanticHint(getDiagramEditPart(), StateMachineEditPart.VISUAL_ID);
		IGraphicalEditPart smCompartment = findChildBySemanticHint(sm, StateMachineCompartmentEditPart.VISUAL_ID);
		IGraphicalEditPart region = findChildBySemanticHint(smCompartment, RegionEditPart.VISUAL_ID);
		return findChildBySemanticHint(region, RegionCompartmentEditPart.VISUAL_ID);
	}
}
