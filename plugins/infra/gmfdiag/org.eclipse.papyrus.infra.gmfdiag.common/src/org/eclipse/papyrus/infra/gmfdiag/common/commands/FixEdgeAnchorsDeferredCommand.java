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
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RelativeBendpoint;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.edge.CustomRelativeBendpoint;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.IdentityAnchorHelper;


/**
 * 
 * see bug 430702: [Diagram] Moving source of a link moves the target too.
 * 
 * This class allows to fix the anchors for a collection of connection edit part
 * 
 */
public class FixEdgeAnchorsDeferredCommand extends AbstractFixEdgeAnchorDeferredCommand {

	/**
	 * the list of the connections to refresh
	 */
	private Collection<?> connectionsEditPartToRefresh;

	private Map<Connection, ConnectionInformation> map = new HashMap<Connection, ConnectionInformation>();

	public static class ConnectionInformation {

		private PointList initialPointList;

		private String sourceAnchorInit;

		private String targetAnchorInit;

		private Point sourcePoint;

		private Point targetPoint;

		private final Connection conn;

		public ConnectionInformation(Connection conn) {
			this.conn = conn;
			this.initialPointList = this.conn.getPoints().getCopy();
			this.sourcePoint = this.conn.getSourceAnchor().getReferencePoint().getCopy();
			this.targetPoint = this.conn.getTargetAnchor().getReferencePoint().getCopy();
			//		this.conn.getTargetAnchor().getOwner()?
		}

		public PointList getInitialPointList() {
			return this.initialPointList.getCopy();
		}
	}

	private INodeEditPart child;


	/**
	 * 
	 * Constructor.
	 * 
	 * @param editingDomain
	 *        the editing domain
	 * @param containerEP
	 *        the diagram edit part
	 * @param movedChild
	 *        TODO
	 * @param request
	 *        the creation request
	 */
	public FixEdgeAnchorsDeferredCommand(final TransactionalEditingDomain editingDomain, final IGraphicalEditPart containerEP, final Collection<?> connectionsEditPartToRefresh, INodeEditPart movedChild) {
		super(editingDomain, "Fix Edge Anchors", containerEP); //$NON-NLS-1$
		this.connectionsEditPartToRefresh = new ArrayList<Object>(connectionsEditPartToRefresh);
		this.child = movedChild;
		for(Object object : connectionsEditPartToRefresh) {
			if(object instanceof IGraphicalEditPart) {
				final IFigure fig = ((IGraphicalEditPart)object).getFigure();
				if(fig instanceof Connection) {
					Connection fig1 = (Connection)fig;
					this.map.put(fig1, new ConnectionInformation(fig1));
				}
			}
		}
		this.child = movedChild;

	}

	protected static PointList routeDummyConnection(final Connection connection, final boolean isMovingSource, final Map<Connection, ConnectionInformation> map) {
		//2. we create a dummy connection from current connection, with new informations to determine real anchor point
		PointList list = map.get(connection).initialPointList;
		System.out.println("BEEFORE");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.getPoint(i));
		}

		Point first = list.getFirstPoint();
		int size = list.size();
		Point last = list.getLastPoint();
		List<RelativeBendpoint> relatedBendpoints = new ArrayList<RelativeBendpoint>();
		//		List<RelativeBendpoint> relatedBendpoints = new ArrayList<RelativeBendpoint>();

		//		first = GridUtils.getFeedBackPointFromGridCoordinate(first, this.child);
		//		last = GridUtils.getFeedBackPointFromGridCoordinate(last, this.child);
		final Connection dummyConnection = new PolylineConnectionEx();
		for(int i = 0; i < list.size(); i++) {
			float c1 = 1.0f;
			float f2 = 0.0f;
			Point current = list.getPoint(i);
			//			current = GridUtils.getFeedBackPointFromGridCoordinate(current, this.child);
			final Dimension s = current.getDifference(first);
			final Dimension t = current.getDifference(last);
			final CustomRelativeBendpoint relatedBendpoint = new CustomRelativeBendpoint(connection);//TODO FIXME WARNING only for test
			relatedBendpoint.setRelativeDimensions(s, t);
			relatedBendpoints.add(relatedBendpoint);
			if(isMovingSource) {

				if(i > 1) {
					System.out.println("dedans");
					relatedBendpoint.setWeight(1.0f);
				} else {
					relatedBendpoint.setWeight(0);
				}
			} else {
				//				if(i < size - 2) {//FIXME : change me in the other location were i'm used
				if(i < size - 2) {
					//					System.out.println("dedans");
					relatedBendpoint.setWeight(0);
				} else {
					//					relatedBendpoint.setWeight(1.0f, 0f);//need more test
					if(i == size - 1) {
						relatedBendpoint.setWeight(1.0f);
					} else
					//ok for horizontal target
					if(current.y == last.y) {
						relatedBendpoint.setWeight(0f, 1.0f);
					} else if(current.x == last.x) {
						relatedBendpoint.setWeight(1.0f, 0f);
					}
					//					relatedBendpoint.setWeight(1.0f);
				}

			}
		}
		//		final Connection dummyConnection = new PolylineConnectionEx();

		IFigure node = null;
		if(isMovingSource) {
			node = connection.getSourceAnchor().getOwner();
		} else {
			node = connection.getTargetAnchor().getOwner();
		}
		//NodeFigure fig = new NodeFigure();
		//fig.setBounds(node.getBounds());
		//fig.setLocation(new Point(600,20));
		if(isMovingSource) {
			ConnectionAnchor sourceAnchor = ((IAnchorableFigure)node).getSourceConnectionAnchorAt(connection.getSourceAnchor().getReferencePoint());
			final Point targetPoint = connection.getTargetAnchor().getReferencePoint();
			final ConnectionAnchor targetAnchor = ((IAnchorableFigure)connection.getTargetAnchor().getOwner()).getTargetConnectionAnchorAt(targetPoint);
			dummyConnection.setSourceAnchor(sourceAnchor);
			dummyConnection.setTargetAnchor(targetAnchor);
		} else {
			ConnectionAnchor targetAnchor = ((IAnchorableFigure)node).getTargetConnectionAnchorAt(connection.getTargetAnchor().getReferencePoint());
			final Point sourcePoint = connection.getSourceAnchor().getReferencePoint();
			//			connection.getSourceAnchor().getOwner().translateToRelative(sourcePoint);
			final ConnectionAnchor sourceAnchor = ((IAnchorableFigure)connection.getSourceAnchor().getOwner()).getSourceConnectionAnchorAt(sourcePoint);
			dummyConnection.setSourceAnchor(sourceAnchor);
			dummyConnection.setTargetAnchor(targetAnchor);
		}

		//for test
		//		Point p1 = list.getFirstPoint();
		//		Point p2 = list.getLastPoint();
		//		connection.translateToRelative(p1);
		//		connection.translateToRelative(p2);
		//		ConnectionAnchor targetAnchor = ((IAnchorableFigure)node).getTargetConnectionAnchorAt(p2);
		//		final Point sourcePoint = p1;
		//		final ConnectionAnchor sourceAnchor = ((IAnchorableFigure)connection.getSourceAnchor().getOwner()).getSourceConnectionAnchorAt(sourcePoint);
		//		dummyConnection.setSourceAnchor(sourceAnchor);
		//		dummyConnection.setTargetAnchor(targetAnchor);
		//end of FOR test


		//		PointList newPoints = initialPoints.getCopy();
		PointList newPoints = map.get(connection).initialPointList.getCopy();
		IFigure parent = connection.getParent();
		//		final Layer layer = DiagramEditPartsUtil.getDiagramConnectionLayer(getContainerEP());
		final IFigure layer = parent;
		dummyConnection.setParent(layer);
		dummyConnection.setPoints(newPoints);//required?


		//configure the router for the dummy connection
		final ConnectionRouter router = connection.getConnectionRouter();
		router.setConstraint(dummyConnection, relatedBendpoints);
		dummyConnection.setConnectionRouter(router);
		router.route(dummyConnection);

		final PointList res = dummyConnection.getPoints();
		dummyConnection.setRoutingConstraint(null);
		dummyConnection.setConnectionRouter(null);
		return res;
	}



	/**
	 * Executes a fix anchor command for the created edge
	 * 
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		Point newLocation = this.child.getFigure().getBounds().getLocation();
		boolean movingTarget = true;



		//this.connectionsEditPartToRefresh.add(this.child);
		final RefreshConnectionElementsRunnable refreshRunnable = new RefreshConnectionElementsRunnable(this.connectionsEditPartToRefresh, getContainerEP());


		EditPartUtil.synchronizeRunnableToMainThread(getContainerEP(), refreshRunnable);



		for(AbstractConnectionEditPart conn : refreshRunnable.getResult()) {
			final Connection fig = (Connection)conn.getFigure();
			PointList res2 = routeDummyConnection(fig, false, this.map);
			Edge edge = (Edge)conn.getAdapter(Edge.class);
			SetConnectionAnchorsCommand setAnchorCommand = new SetConnectionAnchorsCommand(getEditingDomain(), "");
			setAnchorCommand.setEdgeAdaptor(new EObjectAdapter(edge));
			PrecisionPoint sourcePer = BaseSlidableAnchor.getAnchorRelativeLocation(res2.getFirstPoint(), fig.getSourceAnchor().getOwner().getBounds());

			String newSourceTerminal = IdentityAnchorHelper.createNewAnchorIdValue(sourcePer);
			setAnchorCommand.setNewSourceTerminal(newSourceTerminal);
			PrecisionPoint targetPer = BaseSlidableAnchor.getAnchorRelativeLocation(res2.getLastPoint(), fig.getTargetAnchor().getOwner().getBounds());

			String newTargetTerminal = IdentityAnchorHelper.createNewAnchorIdValue(targetPer);
			setAnchorCommand.setNewTargetTerminal(newTargetTerminal);
			setAnchorCommand.execute(null, null);
			SetConnectionBendpointsCommand setBendpoints = new SetConnectionBendpointsCommand(getEditingDomain());
			setBendpoints.setEdgeAdapter(new EObjectAdapter(edge));
			setBendpoints.setNewPointList(res2, res2.getFirstPoint(), res2.getLastPoint());
			setBendpoints.execute(null, null);
		}


		//		String newSourceID = 


		//		newLocation = this.child.getFigure().getBounds().getLocation();
		//		final Collection<AbstractConnectionEditPart> toRefresh = refreshRunnable.getResult();
		//		final Iterator<AbstractConnectionEditPart> iter = toRefresh.iterator();
		//		while(iter.hasNext()) {
		//			final CompoundCommand cc = new CompoundCommand("Fix connections anchors"); //$NON-NLS-1$
		//			final AbstractConnectionEditPart current = iter.next();
		//
		//			Connection currentConn = (Connection)current.getFigure();
		//			PolylineConnectionEx dummyCOnnection = new PolylineConnectionEx();
		//			final ConnectionRouter router = currentConn.getConnectionRouter();
		//			IFigure parent = DiagramEditPartsUtil.getDiagramFeedbackLayer(current);//FIXME : probably not the good parent
		//			dummyCOnnection.setParent(parent);
		//			dummyCOnnection.setPoints(this.map.get(currentConn).initialPointList);
		//			final IFigure sourceOwner = currentConn.getSourceAnchor().getOwner();
		//			final IFigure targetOwer = currentConn.getTargetAnchor().getOwner();
		//
		//			//assuming that we are moving target only!
		//			router.route(dummyCOnnection);
		//
		//
		//
		//
		//
		//			addFixAnchorCommand(current, cc);
		//			if(cc.canExecute()) {
		//				cc.execute();
		//			} else {
		//				Activator.log.warn("Command to fix the anchors is null"); //$NON-NLS-1$
		//			}
		//		}
		return CommandResult.newOKCommandResult();
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#cleanup()
	 * 
	 */
	@Override
	protected void cleanup() {
		super.cleanup();
		this.connectionsEditPartToRefresh.clear();
	}

	private static class RefreshConnectionElementsRunnable extends AbstractRefreshConnectionElementsRunnable<Collection<AbstractConnectionEditPart>> {

		/**
		 * the list of the connections to refresh
		 */
		private Collection<?> connectionsEditPartToRefresh;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param connectionsEditPartToRefresh
		 *        the list of the connection edit part to refresh
		 * @param containerEP
		 */
		public RefreshConnectionElementsRunnable(final Collection<?> connectionsEditPartToRefresh, final IGraphicalEditPart containerEP) {
			super(containerEP);
			this.connectionsEditPartToRefresh = connectionsEditPartToRefresh;
		}

		/**
		 * 
		 * @see java.lang.Runnable#run()
		 * 
		 */
		@Override
		public void run() {
			getContainerEditPart().refresh();

			// We update the figure world 
			getContainerFigure().invalidate();
			getContainerFigure().validate();
			final Iterator<?> iter = this.connectionsEditPartToRefresh.iterator();
			final Collection<AbstractConnectionEditPart> connectionsEP = new HashSet<AbstractConnectionEditPart>();
			setResult(connectionsEP);
			while(iter.hasNext()) {
				final Object object = iter.next();
				if(object instanceof AbstractConnectionEditPart) {
					connectionsEP.add((AbstractConnectionEditPart)object);
					refreshConnection((AbstractConnectionEditPart)object);
				}
			}
			setStatus(Status.OK_STATUS);
		}
	}
}
