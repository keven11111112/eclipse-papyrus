/*****************************************************************************
 * Copyright (c) 2009, 2018 Atos Origin, EclipseSource and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *   EclipseSource - Bug 533770
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;

/**
 * The customn DragDropEditPolicy for InteractionOperandEditPart.
 */
public class InteractionOperandDragDropEditPolicy extends ResizableEditPolicy {

	/**
	 * The minimum height for the Operand. The policy will reject resize operations
	 * if they would result in a smaller height
	 *
	 * @since 5.0
	 */
	public static final int MIN_HEIGHT = 5;

	/**
	 * The minimum width for the Operand. The policy will reject resize operations
	 * if they would result in a smaller width
	 *
	 * @since 5.0
	 */
	public static final int MIN_WIDTH = 5;

	/**
	 * Disable drag and allow only south resize. {@inheritDoc}
	 */
	public InteractionOperandDragDropEditPolicy() {
		super();
		setDragAllowed(false);

		// Bug 533770: The layout is now handled exclusively by the parent.
		// The operand is no longer directly resizable. It may still provide
		// a height hint (Integer or Rectangle, height in pixels)
		setResizeDirections(PositionConstants.NONE);
	}

	/**
	 * @see org.eclipse.gef.editpolicies.ResizableEditPolicy#getResizeCommand(org.eclipse.gef.requests.ChangeBoundsRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected Command getResizeCommand(ChangeBoundsRequest request) {
		Dimension delta = new Dimension(request.getSizeDelta());
		IFigure figure = getHostFigure();
		if (figure != null) {
			Dimension currentDimension = figure.getBounds().getSize();

			// Take zoom into account; the request contains absolute mouse coordinates delta.
			figure.translateToRelative(delta);
			Dimension newDimension = currentDimension.expand(delta);
			if (newDimension.width() < MIN_WIDTH || newDimension.height < MIN_HEIGHT) {
				// XXX Currently we just reject the request. Ideally, we'd simply edit
				// the request to match the min size. However, since this policy is typically
				// called by the CF during its resize, we'd have to change that request, too. But we can't do that from here;
				// so it's easier to just reject the request.
				return UnexecutableCommand.INSTANCE;
			}
		}

		return super.getResizeCommand(request);
	}
}
