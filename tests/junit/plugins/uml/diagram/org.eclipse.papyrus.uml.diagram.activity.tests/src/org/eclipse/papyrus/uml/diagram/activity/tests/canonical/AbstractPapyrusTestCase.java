/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.tests.canonical;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.activity.CreateActivityDiagramCommand;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityEditPart;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.junit.Assert;


/**
 * The Class AbstractPapyrusTestCase.
 */
public abstract class AbstractPapyrusTestCase extends org.eclipse.papyrus.uml.diagram.tests.canonical.AbstractPapyrusTestCase {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return  new CreateActivityDiagramCommand();
	}

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
		Assert.assertNotNull("Parent " + parent + ", type " + parent.getNotationView() + " looking for: " + vid, childEP);
		return childEP;
	}

	protected IGraphicalEditPart getActivityCompartmentEditPart() {
		IGraphicalEditPart activityEP = findChildBySemanticHint(getDiagramEditPart(), ActivityEditPart.VISUAL_ID);
		return findChildBySemanticHint(activityEP, ActivityActivityContentCompartmentEditPart.VISUAL_ID);
	}
}
