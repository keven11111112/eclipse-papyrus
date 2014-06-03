/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.gmf.diagram.common.edit.policy;

import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionEndsCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.commands.CreateViewCommand;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.FixEdgeAnchorAfterCreationCommand;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ServiceUtilsForEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.Util;
import org.eclipse.papyrus.infra.services.edit.utils.RequestParameterConstants;
import org.eclipse.papyrus.sysml.diagram.common.Activator;


/**
 * Default graphical node edit policy replacement used to replace {@link CreateCommand} by {@link CreateViewCommand},
 * different implementation of the canExecute() method.
 * See https://bugs.eclipse.org/bugs/show_bug.cgi?id=346739.
 */
public class DefaultGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getConnectionAndRelationshipCompleteCommand(CreateConnectionViewAndElementRequest request) {

		// Add parameter (source and target view to the CreateRelationshipRequest
		CreateElementRequestAdapter requestAdapter = request.getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter();
		CreateRelationshipRequest createElementRequest = (CreateRelationshipRequest)requestAdapter.getAdapter(CreateRelationshipRequest.class);

		View sourceView = (View)request.getSourceEditPart().getModel();
		createElementRequest.setParameter(RequestParameterConstants.EDGE_CREATE_REQUEST_SOURCE_VIEW, sourceView);

		View targetView = (View)request.getTargetEditPart().getModel();
		createElementRequest.setParameter(RequestParameterConstants.EDGE_CREATE_REQUEST_TARGET_VIEW, targetView);
		createElementRequest.setParameter(RequestParameterConstants.EDGE_TARGET_POINT, request.getLocation());

		//see bug 430702: [Diagram] Moving source of a link moves the target too, we need to store in the parameters : 
		//- the source point
		//- the target point
		//- the source figure
		//- the target figure
		final EditPart sourceEP = request.getSourceEditPart();
		if(sourceEP instanceof GraphicalEditPart) {
			createElementRequest.setParameter(RequestParameterConstants.EDGE_SOURCE_FIGURE, ((GraphicalEditPart)sourceEP).getFigure());
		}
		final EditPart targetEP = request.getTargetEditPart();
		if(targetEP instanceof GraphicalEditPart) {
			createElementRequest.setParameter(RequestParameterConstants.EDGE_TARGET_FIGURE, ((GraphicalEditPart)targetEP).getFigure());
		}

		final TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		final Command defaultCommand = super.getConnectionAndRelationshipCompleteCommand(request);
		if(defaultCommand != null && defaultCommand.canExecute()) {
			final CompoundCommand cc = new CompoundCommand("ConnectionAndRelationshipCompleteCommand");//$NON-NLS-1$
			cc.add(defaultCommand);
			final ICommand fixAnchor = new FixEdgeAnchorAfterCreationCommand(editingDomain, request);
			cc.add(new ICommandProxy(fixAnchor));
			return cc;
		}
		return defaultCommand;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("restriction")
	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		if(!(request instanceof CreateConnectionViewRequest)) {
			return null;
		}
		CreateConnectionViewRequest req = (CreateConnectionViewRequest)request;
		CompositeCommand cc = new CompositeCommand(DiagramUIMessages.Commands_CreateCommand_Connection_Label);
		Diagram diagramView = ((View)getHost().getModel()).getDiagram();

		// TransactionalEditingDomain editingDomain = getEditingDomain();
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		CreateCommand createCommand = new CreateViewCommand(editingDomain, req.getConnectionViewDescriptor(), diagramView.getDiagram());
		//
		setViewAdapter((IAdaptable)createCommand.getCommandResult().getReturnValue());

		//see bug 430702: [Diagram] Moving source of a link moves the target too, we need to store the source point to fix this bug.
		@SuppressWarnings("unchecked")
		Map<Object, Object> parameters = req.getExtendedData();
		parameters.put(RequestParameterConstants.EDGE_SOURCE_POINT, request.getLocation());

		SetConnectionEndsCommand sceCommand = new SetConnectionEndsCommand(editingDomain, StringStatics.BLANK);
		sceCommand.setEdgeAdaptor(getViewAdapter());
		sceCommand.setNewSourceAdaptor(new EObjectAdapter(getView()));
		ConnectionAnchor sourceAnchor = getConnectableEditPart().getSourceConnectionAnchor(request);
		SetConnectionAnchorsCommand scaCommand = new SetConnectionAnchorsCommand(editingDomain, StringStatics.BLANK);
		scaCommand.setEdgeAdaptor(getViewAdapter());
		scaCommand.setNewSourceTerminal(getConnectableEditPart().mapConnectionAnchorToTerminal(sourceAnchor));
		SetConnectionBendpointsCommand sbbCommand = new SetConnectionBendpointsCommand(editingDomain);
		sbbCommand.setEdgeAdapter(getViewAdapter());
		cc.compose(createCommand);
		cc.compose(sceCommand);
		cc.compose(scaCommand);
		cc.compose(sbbCommand);
		Command c = new ICommandProxy(cc);
		request.setStartCommand(c);
		return c;
	}

	/**
	 * Overriding for the bug 430702: [Diagram] Moving source of a link moves the target too.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy#getReconnectSourceCommand(org.eclipse.gef.requests.ReconnectRequest)
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("restriction")
	//suppress restriction to SetConnectionBendpointsCommand
	@Override
	protected Command getReconnectSourceCommand(final ReconnectRequest request) {
		INodeEditPart node = getConnectableEditPart();
		if(node == null) {
			return null;
		}
		final CompositeCommand cc = new CompositeCommand(DiagramUIMessages.Commands_SetConnectionEndsCommand_Source);
		final TransactionalEditingDomain editingDomain = getEditingDomain();
		//1. set connection ends
		final SetConnectionEndsCommand sceCommand = new SetConnectionEndsCommand(editingDomain, StringStatics.BLANK);
		sceCommand.setEdgeAdaptor(new EObjectAdapter((View)request.getConnectionEditPart().getModel()));
		sceCommand.setNewSourceAdaptor(new EObjectAdapter((View)node.getModel()));
		cc.add(sceCommand);
		//we assume that the Class FeedBackHelper has already updated the figure, using the router
		//so we take the pointslist of the connection figure and we store these new values as bendpoints and anchor



		final IFigure fig = request.getConnectionEditPart().getFigure();
		if(fig instanceof Connection) {
			Map<?, ?> param = request.getExtendedData();
			if(param.get(Util.FEEDBACK_SOURCE_TERMINAL) != null) {//TODO : use a boolean or a wrapper for these information!
				final String newSourceTerminal = (String)param.get(Util.FEEDBACK_SOURCE_TERMINAL);
				final String newTargetTerminal = (String)param.get(Util.FEEDBKACK_TARGET_TERMINAL);
				final PointList points = (PointList)param.get(Util.FEEDBACK_BENDPOINTS);
				//2.1 get the points list of the figure
				final Connection connection = (Connection)fig;
				//				final PointList points = connection.getPoints();

				//2.2 save bendpoints
				SetConnectionBendpointsCommand connectionBendpoints = new SetConnectionBendpointsCommand(getEditingDomain());
				connectionBendpoints.setNewPointList(points, points.getFirstPoint(), points.getLastPoint());
				connectionBendpoints.setEdgeAdapter(request.getConnectionEditPart());
				cc.add(connectionBendpoints);

				//2.3 save connection anchor
				final SetConnectionAnchorsCommand setConnectionAnchorsCommand = new SetConnectionAnchorsCommand(getEditingDomain(), "Set Anchors Command");
				//				final ConnectionAnchor sourceAnchor = ((IAnchorableFigure)node.getFigure()).getSourceConnectionAnchorAt(points.getFirstPoint());
				//				final ConnectionAnchor targetAnchor = ((IAnchorableFigure)connection.getTargetAnchor().getOwner()).getTargetConnectionAnchorAt(points.getLastPoint());

				//				final String newSourceTerminal = ((IAnchorableFigure)node.getFigure()).getConnectionAnchorTerminal(sourceAnchor);
				//				final String newTargetTerminal = ((IAnchorableFigure)connection.getTargetAnchor().getOwner()).getConnectionAnchorTerminal(targetAnchor);

				setConnectionAnchorsCommand.setEdgeAdaptor(new EObjectAdapter((View)request.getConnectionEditPart().getModel()));
				setConnectionAnchorsCommand.setNewSourceTerminal(newSourceTerminal);
				setConnectionAnchorsCommand.setNewTargetTerminal(newTargetTerminal);
				cc.add(setConnectionAnchorsCommand);

			} else {

				//TODO : extract the calculus from PapyrusConnectionEndEditPolicy and put it here! 

			}
		}



		return new ICommandProxy(cc);
	}

	/**
	 * Overriding for the bug 430702: [Diagram] Moving source of a link moves the target too.
	 * TODO Warning this overriding ignore some works done in the super class methods concerning the routers!
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy#getReconnectTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("restriction")
	//suppress restriction to SetConnectionBendpointsCommand
	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		INodeEditPart node = getConnectableEditPart();
		if(node == null) {
			return null;
		}
		final CompositeCommand cc = new CompositeCommand(DiagramUIMessages.Commands_SetConnectionEndsCommand_Source);
		final TransactionalEditingDomain editingDomain = getEditingDomain();
		//1. set connection ends
		final SetConnectionEndsCommand sceCommand = new SetConnectionEndsCommand(editingDomain, StringStatics.BLANK);
		sceCommand.setEdgeAdaptor(new EObjectAdapter((View)request.getConnectionEditPart().getModel()));
		sceCommand.setNewTargetAdaptor(new EObjectAdapter((View)node.getModel()));
		cc.add(sceCommand);
		//we assume that the Class FeedBackHelper has already updated the figure, using the router
		//so we take the pointslist of the connection figure and we store these new values as bendpoints and anchor


		final IFigure fig = request.getConnectionEditPart().getFigure();
		if(fig instanceof Connection) {
			//2.1 get the points list of the figure
			final Connection connection = (Connection)fig;
			final PointList points = connection.getPoints();

			//2.2 save bendpoints
			SetConnectionBendpointsCommand connectionBendpoints = new SetConnectionBendpointsCommand(getEditingDomain());
			connectionBendpoints.setNewPointList(points, points.getFirstPoint(), points.getLastPoint());
			connectionBendpoints.setEdgeAdapter(request.getConnectionEditPart());
			cc.add(connectionBendpoints);

			//2.3 save connection anchor
			final SetConnectionAnchorsCommand setConnectionAnchorsCommand = new SetConnectionAnchorsCommand(getEditingDomain(), "Set Anchors Command");
			final ConnectionAnchor sourceAnchor = ((IAnchorableFigure)connection.getSourceAnchor().getOwner()).getSourceConnectionAnchorAt(points.getFirstPoint());
			final ConnectionAnchor targetAnchor = ((IAnchorableFigure)node.getFigure()).getTargetConnectionAnchorAt(points.getLastPoint());

			final String newSourceTerminal = ((IAnchorableFigure)connection.getSourceAnchor().getOwner()).getConnectionAnchorTerminal(sourceAnchor);
			final String newTargetTerminal = ((IAnchorableFigure)node.getFigure()).getConnectionAnchorTerminal(targetAnchor);

			setConnectionAnchorsCommand.setEdgeAdaptor(new EObjectAdapter((View)request.getConnectionEditPart().getModel()));
			setConnectionAnchorsCommand.setNewSourceTerminal(newSourceTerminal);
			setConnectionAnchorsCommand.setNewTargetTerminal(newTargetTerminal);
			cc.add(setConnectionAnchorsCommand);
		}

		return new ICommandProxy(cc);
	}



	/**
	 * 
	 * @return
	 *         the editing domain to use
	 */
	protected final TransactionalEditingDomain getEditingDomain() {
		try {
			return ServiceUtilsForEditPart.getInstance().getTransactionalEditingDomain(getHost());
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
		return null;
	}
}
