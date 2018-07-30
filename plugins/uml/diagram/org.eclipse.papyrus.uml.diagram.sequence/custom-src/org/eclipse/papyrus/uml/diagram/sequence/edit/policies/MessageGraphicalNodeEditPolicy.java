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

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.diagram.sequence.figures.DurationLinkFigure;
import org.eclipse.papyrus.uml.diagram.sequence.util.DurationLinkUtil;
import org.eclipse.papyrus.uml.service.types.utils.SequenceRequestConstant;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.OccurrenceSpecification;

public class MessageGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {
	// Source (First half of the request)
	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		if (DurationLinkUtil.isCreateDurationLink(request)) {
			CreateRelationshipRequest createRequest = DurationLinkUtil.getCreateRelationshipRequest(request);
			if (createRequest != null) {
				MessageEnd sourceOccurrence;
				Message message = getMessage();
				if (message != null) {
					sourceOccurrence = DurationLinkUtil.isSource(getHostFigure(), request) ? message.getSendEvent() : message.getReceiveEvent();
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
		if (DurationLinkUtil.isCreateDurationLink(request)) {
			CreateRelationshipRequest createRequest = DurationLinkUtil.getCreateRelationshipRequest(request);
			if (createRequest != null) {
				MessageEnd targetOccurrence;
				Message message = getMessage();
				if (message != null) {
					targetOccurrence = DurationLinkUtil.isSource(getHostFigure(), request) ? message.getSendEvent() : message.getReceiveEvent();
					if (targetOccurrence instanceof OccurrenceSpecification) {
						request.getExtendedData().put(SequenceRequestConstant.TARGET_OCCURRENCE, targetOccurrence);
						createRequest.setParameter(SequenceRequestConstant.TARGET_OCCURRENCE, targetOccurrence);
					}
				}
			}
		}
		return super.getConnectionAndRelationshipCompleteCommand(request);
	}

	private Message getMessage() {
		EObject model = EMFHelper.getEObject(getHost());
		return model instanceof Message ? (Message) model : null;
	}

	@Override
	protected Connection createDummyConnection(Request req) {
		if (req instanceof CreateConnectionRequest && DurationLinkUtil.isCreateDurationLink((CreateConnectionRequest) req)) {
			return new DurationLinkFigure();
		}
		return new PolylineConnection();
	}
}
