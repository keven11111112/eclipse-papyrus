/*****************************************************************************
 * Copyright (c) 2018 Christian W. Damus, CEA LIST, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.Optional;
import java.util.function.Supplier;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.uml2.uml.MessageEnd;

/**
 * Common behaviour that time-element edit-parts can delegate.
 */
class TimeElementEditPartHelper {

	private final IGraphicalEditPart owner;
	private final Supplier<? extends Optional<MessageEnd>> messageEndSupplier;

	/**
	 * Initializes me with the edit-part that I help.
	 *
	 * @param owner
	 *            my owner
	 * @param messageEndSupplier
	 *            extracts the message-end from my {@code owner}'s semantic element
	 */
	public TimeElementEditPartHelper(IGraphicalEditPart owner,
			Supplier<? extends Optional<MessageEnd>> messageEndSupplier) {

		super();

		this.owner = owner;
		this.messageEndSupplier = messageEndSupplier;
	}

	boolean refreshBounds(IBorderItemLocator locator) {
		boolean result = false;

		if (locator != null) {
			Optional<Point> messageEndLoc = getMessageEnd().map(this::getLocation);

			if (messageEndLoc.isPresent()) {
				// We are fixed by a message end, then
				Dimension size = new Dimension(
						((Integer) owner.getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Width())).intValue(),
						((Integer) owner.getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Height())).intValue());

				locator.setConstraint(new Rectangle(messageEndLoc.get(), size));
				result = true;
			}
		}

		return result;
	}

	/**
	 * Obtain the message end that is my observedor constrained event, if any.
	 *
	 * @return my message end, or {@code null} if I do not observe or constrain a message end
	 */
	Optional<MessageEnd> getMessageEnd() {
		return messageEndSupplier.get();
	}

	/**
	 * Compute the location of a message end.
	 *
	 * @param messageEnd
	 *            a message end
	 * @return the location of that end relative to my parent, or {@code null} if it cannot
	 *         be determined
	 */
	Point getLocation(MessageEnd messageEnd) {
		Point result = null;

		if (messageEnd != null) {
			EditPart messageEP = DiagramEditPartsUtil.getChildByEObject(messageEnd.getMessage(),
					(IGraphicalEditPart) owner.getRoot().getContents(), true);
			if (messageEP instanceof ConnectionEditPart) {
				Connection connection = (Connection) ((ConnectionEditPart) messageEP).getFigure();
				ConnectionAnchor anchor = messageEnd.isSend()
						? connection.getSourceAnchor()
						: connection.getTargetAnchor();
				if (anchor != null) {
					result = anchor.getReferencePoint().getCopy();
					owner.getFigure().getParent().translateToRelative(result);
				}
			}
		}

		return result;
	}

}
