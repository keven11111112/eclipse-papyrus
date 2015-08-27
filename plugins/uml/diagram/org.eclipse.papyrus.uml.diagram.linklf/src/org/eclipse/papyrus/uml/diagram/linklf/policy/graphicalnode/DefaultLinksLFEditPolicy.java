/*****************************************************************************
 * Copyright (c) 2015 CEA LIST, Montages AG and others
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Svyatoslav Kovalsky - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.linklf.policy.graphicalnode;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.linklf.policies.LinksLFGraphicalNodeEditPolicy;
import org.eclipse.papyrus.infra.services.edit.utils.RequestParameterConstants;

public class DefaultLinksLFEditPolicy extends LinksLFGraphicalNodeEditPolicy {

	@Override
	protected Command getConnectionAndRelationshipCompleteCommand(CreateConnectionViewAndElementRequest request) {

		// Add parameter (source and target view to the CreateRelationshipRequest
		CreateElementRequestAdapter requestAdapter = request.getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter();
		CreateRelationshipRequest createElementRequest = (CreateRelationshipRequest) requestAdapter.getAdapter(CreateRelationshipRequest.class);

		View sourceView = (View) request.getSourceEditPart().getModel();
		createElementRequest.setParameter(RequestParameterConstants.EDGE_CREATE_REQUEST_SOURCE_VIEW, sourceView);

		View targetView = (View) request.getTargetEditPart().getModel();
		createElementRequest.setParameter(RequestParameterConstants.EDGE_CREATE_REQUEST_TARGET_VIEW, targetView);
		createElementRequest.setParameter(RequestParameterConstants.EDGE_TARGET_POINT, request.getLocation());
		return super.getConnectionAndRelationshipCompleteCommand(request);
	}
}
