/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   EclipseSource - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.util;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.anchors.AnchorConstants;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * <p>
 * Util class related to the manipulation of Links targetting {@link OccurrenceSpecification}s,
 * typically used by {@link GraphicalNodeEditPolicy} or {@link EditPart}.
 * </p>
 *
 * @see DurationLinkUtil
 * @see GeneralOrderingUtil
 */
public class OccurrenceSpecificationUtil {


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
	 * Find the semantic {@link OccurrenceSpecification} represented by the given <code>connectorEnd</code>.
	 * The connector should be the source or target of a DurationLink connector.
	 *
	 * @param connectorEnd
	 *            the source or target of a DurationLink connector
	 * @param anchorTerminal
	 *            The connection anchor corresponding to the given connector end.
	 * @return
	 * 		The semantic occurrence specification represented by the given connector end (View), or null
	 *         if the view doesn't represent a valid {@link OccurrenceSpecification}.
	 */
	public static OccurrenceSpecification findSemanticOccurrence(View connectorEnd, String anchorTerminal) {
		EObject semantic = connectorEnd.getElement();
		if (semantic instanceof OccurrenceSpecification) {
			return (OccurrenceSpecification) semantic;
		} else if (semantic instanceof ExecutionSpecification) {
			switch (anchorTerminal) {
			case AnchorConstants.START_TERMINAL:
				return ((ExecutionSpecification) semantic).getStart();
			case AnchorConstants.END_TERMINAL:
				return ((ExecutionSpecification) semantic).getFinish();
			default:
				return null;
			}
		} else if (semantic instanceof Message) {
			switch (anchorTerminal) {
			case AnchorConstants.START_TERMINAL:
				MessageEnd sendEvent = ((Message) semantic).getSendEvent();
				return sendEvent instanceof OccurrenceSpecification ? (OccurrenceSpecification) sendEvent : null;
			case AnchorConstants.END_TERMINAL:
				MessageEnd receiveEvent = ((Message) semantic).getReceiveEvent();
				return receiveEvent instanceof OccurrenceSpecification ? (OccurrenceSpecification) receiveEvent : null;
			default:
				return null;
			}
		}
		return null;
	}
}
