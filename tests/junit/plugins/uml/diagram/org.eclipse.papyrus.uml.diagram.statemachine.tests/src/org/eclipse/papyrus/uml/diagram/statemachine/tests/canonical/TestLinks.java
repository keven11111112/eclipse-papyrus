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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes;
import org.junit.Assert;
import org.junit.Test;


public class TestLinks extends BaseTestCase {

	protected Command createLinkCommand(IGraphicalEditPart start, IGraphicalEditPart end, IElementType type) {
		List<IElementType> types = new LinkedList<IElementType>();
		types.add(type);

		AspectUnspecifiedTypeConnectionTool.CreateAspectUnspecifiedTypeConnectionRequest req =
				new AspectUnspecifiedTypeConnectionTool(types).
				new CreateAspectUnspecifiedTypeConnectionRequest(types, false, getDiagramEditPart().getDiagramPreferencesHint());

		req.setSourceEditPart(start);
		req.setType((RequestConstants.REQ_CONNECTION_START));

		Command startCommand = start.getCommand(req);
		Assert.assertNotNull(startCommand);

		req.setStartCommand(startCommand);

		req.setTargetEditPart(end);
		req.setType(RequestConstants.REQ_CONNECTION_END);

		Command endCommand = end.getCommand(req);
		Assert.assertNotNull(endCommand);
		Assert.assertTrue(endCommand.canExecute());
		return endCommand;
	}

	@Test
	public void testToCreateCommentLink() {
		IGraphicalEditPart comment = createChild(CommentEditPart.VISUAL_ID, getRegionCompartmentEditPart());
		IGraphicalEditPart state = createChild(StateEditPart.VISUAL_ID, getRegionCompartmentEditPart());

		Command endCommand = createLinkCommand(comment, state, UMLElementTypes.CommentAnnotatedElement_667);

		executeOnUIThread(endCommand);
		Assert.assertEquals(1, getDiagramEditPart().getConnections().size());
		IGraphicalEditPart commentConnection = (IGraphicalEditPart) getDiagramEditPart().getConnections().get(0);
		Assert.assertTrue(commentConnection instanceof CommentAnnotatedElementEditPart);
	}
}