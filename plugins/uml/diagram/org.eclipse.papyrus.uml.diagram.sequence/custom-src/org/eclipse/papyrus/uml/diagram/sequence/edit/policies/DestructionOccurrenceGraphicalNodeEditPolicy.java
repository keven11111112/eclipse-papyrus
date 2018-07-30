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
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultGraphicalNodeEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.service.palette.AspectUnspecifiedTypeConnectionTool.CreateAspectUnspecifiedTypeConnectionRequest;
import org.eclipse.papyrus.uml.diagram.sequence.figures.DurationLinkFigure;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;

/**
 * An extended {@link DefaultGraphicalNodeEditPolicy} which supports creation of DurationLinks
 */
public class DestructionOccurrenceGraphicalNodeEditPolicy extends DefaultGraphicalNodeEditPolicy {

	@Override
	protected ICommand getAfterConnectionCompleteCommand(CreateConnectionViewAndElementRequest request, final TransactionalEditingDomain editingDomain) {
		if (isCreateDurationLink(request)) {
			return null; // Prevent the superclass from "Fixing" the anchors
		}
		return super.getAfterConnectionCompleteCommand(request, editingDomain);
	}

	@Override
	protected Connection createDummyConnection(Request req) {
		if (req instanceof CreateConnectionRequest && isCreateDurationLink((CreateConnectionRequest) req)) {
			return new DurationLinkFigure();
		}
		return new PolylineConnection();
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
}
