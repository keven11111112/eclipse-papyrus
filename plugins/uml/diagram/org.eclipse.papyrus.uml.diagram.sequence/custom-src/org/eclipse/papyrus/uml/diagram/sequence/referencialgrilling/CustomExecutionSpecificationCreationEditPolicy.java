/*****************************************************************************
 * Copyright (c) 2017, 2018 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *   Christian W. Damus - bug 539373
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.referencialgrilling;

import static org.eclipse.papyrus.uml.service.types.utils.ElementUtil.isTypeOf;

import java.util.stream.Stream;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.util.DurationLinkUtil;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.papyrus.uml.service.types.element.UMLDIElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;

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

	@SuppressWarnings("unchecked")
	@Override
	public EditPart getTargetEditPart(Request request) {
		EditPart result = super.getTargetEditPart(request);
		if (!(request instanceof CreateRequest)) {
			return result;
		}

		Stream<? extends IElementType> elementTypes = null;
		if (request instanceof CreateViewAndElementRequest) {
			elementTypes = ((CreateViewAndElementRequest) request).getViewDescriptors().stream()
					.map(v -> v.getElementAdapter().getAdapter(IElementType.class));
		} else if (request instanceof CreateUnspecifiedTypeRequest) {
			elementTypes = ((CreateUnspecifiedTypeRequest) request).getElementTypes().stream();
		}
		if ((elementTypes != null) && elementTypes.anyMatch(type -> isTypeOf(type, UMLElementTypes.EXECUTION_SPECIFICATION))) {
			// The lifeline is responsible for creating all execution specifications, as they
			// are semantically all children of it (nesting is strictly visual)
			return SequenceUtil.getParentLifelinePart(getHost());
		}

		return result;
	}

}
