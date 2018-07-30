/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
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

package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.service.palette.AspectUnspecifiedTypeConnectionTool.CreateAspectUnspecifiedTypeConnectionRequest;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintLinkEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationLinkEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;

/**
 * <p>
 * Util class related to the manipulation of DurationLinks, typically used by
 * {@link GraphicalNodeEditPolicy} or {@link EditPart}
 * </p>
 */
public class DurationLinkUtil {

	/**
	 * Test if the given {@link CreateConnectionRequest} is creating a DurationLink
	 *
	 * @param request
	 * @return
	 */
	public static boolean isCreateDurationLink(CreateConnectionRequest request) {
		CreateRelationshipRequest createElementRequest = getCreateRelationshipRequest(request);
		if (createElementRequest == null) {
			if (request instanceof CreateAspectUnspecifiedTypeConnectionRequest) {
				CreateAspectUnspecifiedTypeConnectionRequest createRequest = (CreateAspectUnspecifiedTypeConnectionRequest) request;
				List<?> types = createRequest.getElementTypes();
				if (types.stream().allMatch(
						type -> type == UMLElementTypes.DurationConstraint_Edge ||
								type == UMLElementTypes.DurationObservation_Edge)) {
					return true;
				}
			}
		} else {
			IElementType type = createElementRequest.getElementType();
			return type == UMLElementTypes.DurationConstraint_Edge || type == UMLElementTypes.DurationObservation_Edge;
		}
		return false;
	}


	/**
	 * Test if the given {@link CreateConnectionViewRequest} is creating a DurationLink
	 *
	 * @param createRequest
	 * @return
	 */
	public static boolean isDurationLink(CreateConnectionViewRequest createRequest) {
		String semanticHint = createRequest.getConnectionViewDescriptor().getSemanticHint();
		switch (semanticHint) {
		case DurationConstraintLinkEditPart.VISUAL_ID:
		case DurationObservationLinkEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * Retrieve the semantic {@link CreateRelationshipRequest} from the given GEF {@link CreateConnectionRequest},
	 * or <code>null</code>.
	 *
	 * @param request
	 * @return
	 */
	public static CreateRelationshipRequest getCreateRelationshipRequest(CreateConnectionRequest request) {
		if (false == request instanceof CreateConnectionViewAndElementRequest) {
			return null;
		}
		CreateElementRequestAdapter requestAdapter = ((CreateConnectionViewAndElementRequest) request).getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter();
		if (requestAdapter == null) {
			return null;
		}
		CreateRelationshipRequest createElementRequest = (CreateRelationshipRequest) requestAdapter.getAdapter(CreateRelationshipRequest.class);
		return createElementRequest;
	}

	/**
	 * Test whether the given request is closer to the start (top) or to the finish (bottom) point of the execution specification
	 *
	 * @param createRequest
	 *            The create request
	 * @return
	 * 		<code>true</code> if the given request is closer to the top of the figure; false if it is closer to the bottom
	 */
	public static boolean isStart(IFigure targetFigure, CreateRequest createRequest) {
		Point location = createRequest.getLocation();
		Rectangle bounds = targetFigure.getBounds().getCopy();
		targetFigure.translateToAbsolute(bounds);

		double distanceToTop = location.getDistance(bounds.getTop());
		double distanceToBottom = location.getDistance(bounds.getBottom());
		return distanceToTop < distanceToBottom;
	}

	/**
	 * Test whether the given request is closer to the source or to the target point of the message
	 *
	 * @param targetFigure
	 *            The connection figure representing the message
	 * @param createRequest
	 *            The create request
	 * @return
	 * 		<code>true</code> if the given request is closer to the source of the connection; false if it is closer to the target
	 */
	public static boolean isSource(IFigure targetFigure, CreateRequest createRequest) {
		Point location = createRequest.getLocation();
		IFigure connection = targetFigure;
		if (connection instanceof Connection) {
			PointList points = ((Connection) connection).getPoints();
			if (points.size() >= 2) {
				Point source = points.getFirstPoint();
				Point target = points.getLastPoint();
				double distanceToSource = location.getDistance(source);
				double distanceToTarget = location.getDistance(target);
				return distanceToSource < distanceToTarget;
			}
		}

		// Default; shouldn't happen, unless the Message figure is invalid,
		// in which case we can't determine the source/target).
		return true;
	}


	/**
	 * <p>
	 * Test if this request is trying to reconnect a DurationLink edit part
	 * </p>
	 *
	 * @param request
	 * @return
	 *
	 * @see DurationConstraintLinkEditPart
	 * @see DurationObservationLinkEditPart
	 */
	public static boolean isDurationLink(ReconnectRequest request) {
		return request.getConnectionEditPart() instanceof DurationConstraintLinkEditPart ||
				request.getConnectionEditPart() instanceof DurationObservationLinkEditPart;
	}

}
