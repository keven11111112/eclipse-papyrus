/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;

/**
 * The customn DragDropEditPolicy for InteractionOperandEditPart.
 */
public class InteractionOperandDragDropEditPolicy extends ResizableEditPolicy {

	/**
	 * Disable drag and allow only south resize. {@inheritDoc}
	 */
	public InteractionOperandDragDropEditPolicy() {
		super();
		setDragAllowed(false);

		// Bug 533770: The layout is now handled exclusively by the parent.
		// The operand is no longer directly resizable. It may still provide
		// a height hint (Integer or Rectangle, height in pixels)
		setResizeDirections(0);
	}

	/**
	 * Handle resize InteractionOperand {@inheritDoc}
	 */
	@Override
	protected Command getResizeCommand(ChangeBoundsRequest request) {
		return super.getResizeCommand(request);
	}
}
