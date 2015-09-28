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

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.tooling.runtime.linklf.policies.LinksLFGraphicalNodeEditPolicy;
import org.eclipse.papyrus.uml.diagram.deployment.custom.edit.helpers.MultiDependencyHelper;
import org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes;

public class DeploymentLinksLFEditPolicy extends LinksLFGraphicalNodeEditPolicy {

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	public Command getCommand(Request request) {

		// we have to distinguish the case where this is an association class
		if (REQ_CONNECTION_END.equals(request.getType())) {
			if (request instanceof CreateConnectionViewAndElementRequest) {
				// default behavior
				Command c = getConnectionAndRelationshipCompleteCommand((CreateConnectionViewAndElementRequest) request);

				// case of associationClass
				CreateElementRequestAdapter requestAdapter = ((CreateConnectionViewAndElementRequest) request).getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter();
				CreateRelationshipRequest createElementRequest = (CreateRelationshipRequest) requestAdapter.getAdapter(CreateRelationshipRequest.class);

				if (UMLElementTypes.Dependency_4010.equals(createElementRequest.getElementType())) {
					MultiDependencyHelper multiDependencyHelper = new MultiDependencyHelper(getEditingDomain());
					return multiDependencyHelper.getCommand(((CreateConnectionViewAndElementRequest) request), c);

				} else {
					return c;
				}
			} else if (request instanceof CreateUnspecifiedTypeConnectionRequest) {
				return getUnspecifiedConnectionCompleteCommand((CreateUnspecifiedTypeConnectionRequest) request);
			}
		}

		return super.getCommand(request);
	}
}
