/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.referencialgrilling;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.util.DurationLinkUtil;
import org.eclipse.papyrus.uml.service.types.element.UMLDIElementTypes;

/**
 * This allows to define the creation edit policy for the execution specification.
 */
public class CustomExecutionSpecificationCreationEditPolicy extends DefaultCreationEditPolicy {

	@Override
	protected ICommand getSetBoundsCommand(CreateViewRequest request, ViewDescriptor descriptor) {
		if (UMLDIElementTypes.TIME_CONSTRAINT_SHAPE.getSemanticHint().equals(descriptor.getSemanticHint())
				|| UMLDIElementTypes.TIME_OBSERVATION_SHAPE.getSemanticHint().equals(descriptor.getSemanticHint())) {
			// check the position of the request to give the basic constraint for the created shape (should not be moveable)
			Point location = request.getLocation().getCopy();
			location.setX(-10);
			boolean isStart = DurationLinkUtil.isStart(((IGraphicalEditPart) getHost()).getFigure(), location);
			if (isStart) {
				location.setY(-1);
			} else {
				location.setY(10);
			}
			Dimension size = new Dimension(40, 1);
			return new SetBoundsCommand(((IGraphicalEditPart) getHost()).getEditingDomain(), DiagramUIMessages.Commands_MoveElement, descriptor, new Rectangle(location, size));
		}
		return super.getSetBoundsCommand(request, descriptor);
	}
}
