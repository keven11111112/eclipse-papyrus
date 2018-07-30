/*****************************************************************************
 * Copyright (c) 2018 CEA LIST, EclipseSource and others.
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
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.service.palette.AspectUnspecifiedTypeConnectionTool.CreateAspectUnspecifiedTypeConnectionRequest;
import org.eclipse.papyrus.uml.diagram.sequence.figures.DurationLinkFigure;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.SequenceRequestConstant;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.OccurrenceSpecification;

public class MessageGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {
	// Source (First half of the request)
	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		if (isCreateDurationLink(request)) {
			CreateRelationshipRequest createRequest = getCreateRelationshipRequest(request);
			if (createRequest != null) {
				MessageEnd sourceOccurrence;
				Message message = getMessage();
				if (message != null) {
					sourceOccurrence = isSource(request) ? message.getSendEvent() : message.getReceiveEvent();
					if (sourceOccurrence instanceof OccurrenceSpecification) {
						request.getExtendedData().put(SequenceRequestConstant.SOURCE_OCCURRENCE, sourceOccurrence);
						createRequest.setParameter(SequenceRequestConstant.SOURCE_OCCURRENCE, sourceOccurrence);
					}
				}
			}
		}
		return super.getConnectionCreateCommand(request);
	}

	// Target (Second half of the request)
	@Override
	protected Command getConnectionAndRelationshipCompleteCommand(CreateConnectionViewAndElementRequest request) {
		if (isCreateDurationLink(request)) {
			CreateRelationshipRequest createRequest = getCreateRelationshipRequest(request);
			if (createRequest != null) {
				MessageEnd targetOccurrence;
				Message message = getMessage();
				if (message != null) {
					targetOccurrence = isSource(request) ? message.getSendEvent() : message.getReceiveEvent();
					if (targetOccurrence instanceof OccurrenceSpecification) {
						request.getExtendedData().put(SequenceRequestConstant.TARGET_OCCURRENCE, targetOccurrence);
						createRequest.setParameter(SequenceRequestConstant.TARGET_OCCURRENCE, targetOccurrence);
					}
				}
			}
		}
		return super.getConnectionAndRelationshipCompleteCommand(request);
	}

	/**
	 * Test whether the given request is closer to the source or to the target point of the message
	 *
	 * @param createRequest
	 *            The create request
	 * @return
	 * 		<code>true</code> if the given request is closer to the source of the connection; false if it is closer to the target
	 */
	private boolean isSource(CreateRequest createRequest) {
		Point location = createRequest.getLocation();
		IFigure connection = getHostFigure();
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

	private Message getMessage() {
		EObject model = EMFHelper.getEObject(getHost());
		return model instanceof Message ? (Message) model : null;
	}

	private boolean isCreateDurationLink(CreateConnectionRequest request) {
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

	private CreateRelationshipRequest getCreateRelationshipRequest(CreateConnectionRequest request) {
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

	@Override
	protected Connection createDummyConnection(Request req) {
		if (req instanceof CreateConnectionRequest && isCreateDurationLink((CreateConnectionRequest) req)) {
			return new DurationLinkFigure();
		}
		return new PolylineConnection();
	}
}
