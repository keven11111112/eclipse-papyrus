/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/



package org.eclipse.papyrus.infra.gmfdiag.common.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ConnectionLayerEx;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.RoutingStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.papyrus.infra.gmfdiag.common.routers.GridUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.infra.services.edit.utils.RequestParameterConstants;


/**
 * 
 * This command is used to fix the edge anchor just after the creation of the edge, in order to get anchor on the sides of the source
 * and target figure and not somewhere inside the figure.
 * 
 * This fix allows to avoid to get source (or target) location moving instead you are moving the target (or source) anchor
 * 
 * see bug 430702: [Diagram] Moving source of a link moves the target too.
 */

@SuppressWarnings("restriction")
public class FixEdgeAnchorAfterCreationCommand extends AbstractTransactionalCommand {

	/**
	 * the request used to create connection view
	 */
	protected CreateConnectionViewRequest request;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param editingDomain
	 *        the editing domain
	 * @param request
	 *        the creation request
	 * @param containerEP
	 *        the diagram edit part
	 */
	public FixEdgeAnchorAfterCreationCommand(final TransactionalEditingDomain editingDomain, final CreateConnectionViewRequest request) {
		super(editingDomain, "Fix Edge Anchor after creation", null); //$NON-NLS-1$
		this.request = request;
	}


	/**
	 * Executes a fix anchor command for the created edge
	 * 
	 */
	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor progressMonitor, final IAdaptable info) throws ExecutionException {
		final ConnectionViewDescriptor connectionViewDescriptor = this.request.getConnectionViewDescriptor();
		final Edge createdEdge = (Edge)connectionViewDescriptor.getAdapter(View.class);

		final IAdaptable adaptable = connectionViewDescriptor.getElementAdapter();
		final CreateRelationshipRequest createRelationShipRequest = (CreateRelationshipRequest)adaptable.getAdapter(CreateRelationshipRequest.class);
		final Map<?, ?> requestParameters = createRelationShipRequest.getParameters();
		final Point sourcePoint = ((Point)requestParameters.get(RequestParameterConstants.EDGE_SOURCE_POINT)).getCopy();
		final Point targetPoint = ((Point)requestParameters.get(RequestParameterConstants.EDGE_TARGET_POINT)).getCopy();
		final IFigure fig1 = (IFigure)requestParameters.get(RequestParameterConstants.EDGE_SOURCE_FIGURE);
		final IFigure fig2 = (IFigure)requestParameters.get(RequestParameterConstants.EDGE_TARGET_FIGURE);
		if(fig1 instanceof IAnchorableFigure && fig2 instanceof IAnchorableFigure) {
			final IAnchorableFigure sourceFigure = (IAnchorableFigure)fig1;
			final IAnchorableFigure targetFigure = (IAnchorableFigure)fig2;

			//we route the future connection to find its anchors and its bendpoints
			final ConnectionRouter router = getRouterToUse(createdEdge);
			final Connection dummyConnection = new PolylineConnectionEx();

			final PointList pointsList = new PointList();
			pointsList.addPoint(sourcePoint);
			pointsList.addPoint(targetPoint);

			final ConnectionAnchor arg0 = sourceFigure.getSourceConnectionAnchorAt(sourcePoint);
			dummyConnection.setSourceAnchor(arg0);

			final ConnectionAnchor arg1 = targetFigure.getTargetConnectionAnchorAt(targetPoint);
			dummyConnection.setTargetAnchor(arg1);

			router.route(dummyConnection);

			if(createdEdge != null && sourcePoint != null && targetPoint != null) {
				Point realSourcePoint = dummyConnection.getPoints().getFirstPoint();
				Point realTargetPoint = dummyConnection.getPoints().getLastPoint();

				//get source anchor terminal
				final BaseSlidableAnchor anchorSource = (BaseSlidableAnchor)sourceFigure.getSourceConnectionAnchorAt(realSourcePoint);
				final String sourceTerminal = anchorSource.getTerminal();

				//get target anchor terminal
				final BaseSlidableAnchor anchorTarget = (BaseSlidableAnchor)targetFigure.getTargetConnectionAnchorAt(realTargetPoint);
				final String targetTerminal = anchorTarget.getTerminal();

				//create and set the source anchor
				final IdentityAnchor sourceAnchor = NotationFactory.eINSTANCE.createIdentityAnchor();
				sourceAnchor.setId(sourceTerminal);
				createdEdge.setSourceAnchor(sourceAnchor);

				//create an set the target anchor
				final IdentityAnchor targetAnchor = NotationFactory.eINSTANCE.createIdentityAnchor();
				targetAnchor.setId(targetTerminal);
				createdEdge.setTargetAnchor(targetAnchor);


				//serialize bendpoints
				int numOfPoints = dummyConnection.getPoints().size();
				final List<RelativeBendpoint> newBendpoints = new ArrayList<RelativeBendpoint>();
				Point first = dummyConnection.getPoints().getFirstPoint();
				Point last = dummyConnection.getPoints().getLastPoint();

				//required for bendpoints calculus
				first = GridUtils.getPointFromFeedbackToGridCoordinate(first, this.request.getSourceEditPart());
				last = GridUtils.getPointFromFeedbackToGridCoordinate(last, this.request.getSourceEditPart());
				for(int i = 0; i < numOfPoints; i++) {
					Point current = dummyConnection.getPoints().getPoint(i);
					//required for bendpoints calculus
					current = GridUtils.getPointFromFeedbackToGridCoordinate(current, this.request.getSourceEditPart());

					Dimension s = current.getDifference(first);
					Dimension t = current.getDifference(last);
					newBendpoints.add(new RelativeBendpoint(s.width, s.height, t.width, t.height));
				}

				final RelativeBendpoints points = (RelativeBendpoints)createdEdge.getBendpoints();
				points.setPoints(newBendpoints);
				return CommandResult.newOKCommandResult();
			}
		}
		return CommandResult.newOKCommandResult();
	}

	/**
	 * 
	 * @param edge
	 *        an edge
	 * @return
	 *         the router to use to calculte bendpoints
	 */
	//remove warning for ConnectionLayerEx
	protected ConnectionRouter getRouterToUse(final Edge edge) {
		final DiagramEditPart rootEP = DiagramEditPartsUtil.getDiagramEditPart(this.request.getSourceEditPart());
		final IFigure layer = rootEP.getLayer(LayerConstants.CONNECTION_LAYER);
		RoutingStyle style = (RoutingStyle)edge.getStyle(NotationPackage.Literals.ROUTING_STYLE);
		if(style != null && layer instanceof ConnectionLayerEx) {
			ConnectionLayerEx cLayerEx = (ConnectionLayerEx)layer;
			final Routing routing = style.getRouting();
			if(Routing.MANUAL_LITERAL == routing) {
				return cLayerEx.getObliqueRouter();
			} else if(Routing.RECTILINEAR_LITERAL == routing) {
				return cLayerEx.getRectilinearRouter();
			} else if(Routing.TREE_LITERAL == routing) {
				return cLayerEx.getTreeRouter();
			}
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#cleanup()
	 * 
	 */
	@Override
	protected void cleanup() {
		this.request = null;
		super.cleanup();
	}


	/**
	 * 
	 * @see org.eclipse.core.commands.operations.AbstractOperation#canExecute()
	 * 
	 * @return
	 */
	@Override
	public boolean canExecute() {
		return super.canExecute() && this.request != null;
	}
}
