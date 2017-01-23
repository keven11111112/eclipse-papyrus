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

import java.util.Iterator;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.linklf.policies.LinksLFGraphicalNodeEditPolicy;
import org.eclipse.papyrus.uml.diagram.communication.custom.helper.CommunicationRequestConstant;
import org.eclipse.papyrus.uml.diagram.communication.custom.helper.CommunicationUtil;
import org.eclipse.papyrus.uml.diagram.communication.custom.helper.MessageHelper;
import org.eclipse.papyrus.uml.diagram.communication.edit.parts.LifelineEditPartCN;

public class CommunicationLinksLFEditPolicy extends LinksLFGraphicalNodeEditPolicy {

	/**
	 * Overrides to disable uphill message.
	 *
	 * @param request
	 *            the request
	 * @return the connection complete command
	 */
	@SuppressWarnings({ "unchecked" })
	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
		Command command = super.getConnectionCompleteCommand(request);
		if (command == null) {
			return UnexecutableCommand.INSTANCE;
		}
		ICommandProxy proxy = (ICommandProxy) request.getStartCommand();
		CompositeCommand cc = (CompositeCommand) proxy.getICommand();
		Iterator<?> commandItr = cc.iterator();
		while (commandItr.hasNext()) {
			Object obj = commandItr.next();
			if (obj instanceof SetConnectionBendpointsCommand) {
				SetConnectionBendpointsCommand sbbCommand = (SetConnectionBendpointsCommand) obj;
				final PointList pointList = sbbCommand.getNewPointList();
				request.getExtendedData().put(CommunicationRequestConstant.SOURCE_MODEL_CONTAINER, CommunicationUtil.findInteractionFragmentAt(pointList.getFirstPoint(), getHost()));
				request.getExtendedData().put(CommunicationRequestConstant.TARGET_MODEL_CONTAINER, CommunicationUtil.findInteractionFragmentAt(pointList.getLastPoint(), getHost()));
			}
		}
		return command;
	}

	/**
	 * Gets the command.
	 *
	 * @param request
	 *            the request
	 * @return the command {@inheritDoc}
	 */
	@Override
	public Command getCommand(Request request) {
		if (REQ_CONNECTION_END.equals(request.getType())) {
			if (request instanceof CreateConnectionViewAndElementRequest) {
				// default behavior
				Command c = getConnectionAndRelationshipCompleteCommand((CreateConnectionViewAndElementRequest) request);
				// case of Message
				CreateElementRequestAdapter requestAdapter = ((CreateConnectionViewAndElementRequest) request).getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter();
				CreateRelationshipRequest createElementRequest = (CreateRelationshipRequest) requestAdapter.getAdapter(CreateRelationshipRequest.class);
				if (org.eclipse.papyrus.uml.diagram.communication.providers.UMLElementTypes.Path_Edge.equals(createElementRequest.getElementType())) {
					EditPart sourceEditPart = ((CreateConnectionViewAndElementRequest) request).getSourceEditPart();
					EditPart targetEditPart = ((CreateConnectionViewAndElementRequest) request).getTargetEditPart();
					MessageHelper messageHelper = new MessageHelper(getEditingDomain());
					// test if source and target are already connected
					if ((sourceEditPart instanceof LifelineEditPartCN) && (targetEditPart instanceof LifelineEditPartCN)) {
						if (CommunicationUtil.verifyIfLifelinesEPConnected(sourceEditPart, targetEditPart) != null) {
							ConnectionEditPart link = CommunicationUtil.verifyIfLifelinesEPConnected(sourceEditPart, targetEditPart);
							return messageHelper.getCommand((CreateConnectionViewAndElementRequest) request, c, link);
						}
					}
				}
			}
		}
		return super.getCommand(request);
	}

	/**
	 * Overrides to set the color of the dummyConnection to color black. This
	 * allow to see the feedback of the connection when it is created. By
	 * default, the color was the foreground color of the lifeline, which is
	 * always blank leading to an invisible feedback.
	 *
	 * @param req
	 *            the req
	 * @return the connection
	 */
	@Override
	protected Connection createDummyConnection(Request req) {
		Connection conn = super.createDummyConnection(req);
		conn.setForegroundColor(org.eclipse.draw2d.ColorConstants.black);
		return conn;
	}
}
