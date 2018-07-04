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
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.service.palette.AspectUnspecifiedTypeConnectionTool.CreateAspectUnspecifiedTypeConnectionRequest;
import org.eclipse.papyrus.uml.diagram.sequence.figures.DurationLinkFigure;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.SequenceRequestConstant;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * <p>
 * A specialized {@link GraphicalNodeEditPolicy} for {@link ExecutionSpecification ExecutionSpecifications}, to handle
 * connection of DurationLinks to the Start/Finish Occurrences of the {@link ExecutionSpecification}
 * </p>
 */
public class ExecutionSpecificationGraphicalNodeEditPolicy extends ElementCreationWithMessageEditPolicy {

	// Source (First half of the request)
	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		if (isCreateDurationLink(request)) {
			CreateRelationshipRequest createRequest = getCreateRelationshipRequest(request);
			if (createRequest != null) {
				OccurrenceSpecification sourceOccurrence;
				ExecutionSpecification execSpec = getExecutionSpecification();
				if (execSpec != null) {
					if (isStart(request)) {
						sourceOccurrence = execSpec.getStart();
					} else {
						sourceOccurrence = execSpec.getFinish();
					}
					request.getExtendedData().put(SequenceRequestConstant.SOURCE_OCCURRENCE, sourceOccurrence);
					createRequest.setParameter(SequenceRequestConstant.SOURCE_OCCURRENCE, sourceOccurrence);
				}
			}
		}
		return super.getConnectionCreateCommand(request);
	}

	private ExecutionSpecification getExecutionSpecification() {
		Object model = getHost().getModel();
		if (model instanceof View && ((View) model).getElement() instanceof ExecutionSpecification) {
			return (ExecutionSpecification) ((View) model).getElement();
		}
		return null;
	}

	/**
	 * Test whether the given request is closer to the start (top) or to the finish (bottom) point of the execution specification
	 *
	 * @param createRequest
	 *            The create request
	 * @return
	 * 		<code>true</code> if the given request is closer to the top of the figure; false if it is closer to the bottom
	 */
	private boolean isStart(CreateRequest createRequest) {
		Point location = createRequest.getLocation();
		Rectangle bounds = getHostFigure().getBounds();

		double distanceToTop = location.getDistance(bounds.getTop());
		double distanceToBottom = location.getDistance(bounds.getBottom());
		return distanceToTop < distanceToBottom;
	}

	// Target (Second half of the request)
	@Override
	protected Command getConnectionAndRelationshipCompleteCommand(CreateConnectionViewAndElementRequest request) {
		if (isCreateDurationLink(request)) {
			CreateRelationshipRequest createRequest = getCreateRelationshipRequest(request);
			if (createRequest != null) {
				OccurrenceSpecification targetOccurrence;
				ExecutionSpecification execSpec = getExecutionSpecification();
				if (execSpec != null) {
					if (isStart(request)) {
						targetOccurrence = execSpec.getStart();
					} else {
						targetOccurrence = execSpec.getFinish();
					}
					request.getExtendedData().put(SequenceRequestConstant.TARGET_OCCURRENCE, targetOccurrence);
					createRequest.setParameter(SequenceRequestConstant.TARGET_OCCURRENCE, targetOccurrence);
				}
			}
		}
		return super.getConnectionAndRelationshipCompleteCommand(request);
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
		}
		IElementType type = createElementRequest.getElementType();
		return type == UMLElementTypes.DurationConstraint_Edge || type == UMLElementTypes.DurationObservation_Edge;
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
