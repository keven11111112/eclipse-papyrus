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

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;

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
		setResizeDirections(PositionConstants.NONE);
	}
}
