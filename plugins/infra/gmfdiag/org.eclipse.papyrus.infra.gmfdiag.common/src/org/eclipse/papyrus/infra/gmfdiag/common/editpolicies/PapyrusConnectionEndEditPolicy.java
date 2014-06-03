/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.infra.gmfdiag.common.editpolicies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.RelativeBendpoint;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.editpolicies.FeedbackHelper;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IAnchorableFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.CustomFeedbackHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.snap.PapyrusConnectionEndpointHandle;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.Util;


/**
 * 
 * This class allows to provides our own EndPointHandle to provide our own DragTracker
 * 
 */
public class PapyrusConnectionEndEditPolicy extends ConnectionEndpointEditPolicy {

	/**
	 * the feedback helper
	 */
	private FeedbackHelper feedbackHelper;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public PapyrusConnectionEndEditPolicy() {
		super();
	}

	/**
	 * @see org.eclipse.gef.editpolicies.SelectionHandlesEditPolicy#createSelectionHandles()
	 */
	@Override
	protected List<?> createSelectionHandles() {
		List<PapyrusConnectionEndpointHandle> list = new ArrayList<PapyrusConnectionEndpointHandle>();
		list.add(new PapyrusConnectionEndpointHandle((ConnectionEditPart)getHost(), ConnectionLocator.SOURCE));
		list.add(new PapyrusConnectionEndpointHandle((ConnectionEditPart)getHost(), ConnectionLocator.TARGET));
		return list;
	}

	//Object initialConstraint
	/**
	 * 
	 * @see org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy#getFeedbackHelper(org.eclipse.gef.requests.ReconnectRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected FeedbackHelper getFeedbackHelper(final ReconnectRequest request) {
		if(this.feedbackHelper == null) {
			this.feedbackHelper = new CustomFeedbackHelper();
			this.feedbackHelper.setConnection(getConnection());
			this.feedbackHelper.setMovingStartAnchor(request.isMovingStartAnchor());
		}
		return this.feedbackHelper;
	}


	/**
	 * Erases connection move feedback. This method is called when a
	 * ReconnectRequest is received.
	 * 
	 * @param request
	 *        the reconnect request.
	 */
	@Override
	protected void eraseConnectionMoveFeedback(ReconnectRequest request) {
		super.eraseConnectionMoveFeedback(request);
		this.feedbackHelper = null;
	}

	/**
	 * 
	 * @see org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy#showConnectionMoveFeedback(org.eclipse.gef.requests.ReconnectRequest)
	 * 
	 * @param request
	 */
	@Override
	protected void showConnectionMoveFeedback(ReconnectRequest request) {
		final Point location = request.getLocation().getCopy();
		updateRouterConstraint(request);
		super.showConnectionMoveFeedback(request);
		request.setLocation(location);
		Map<Object, Object> param = request.getExtendedData();
		final PointList copy = getConnection().getPoints().getCopy();
		final String sourceID = ((IAnchorableFigure)getConnection().getSourceAnchor().getOwner()).getConnectionAnchorTerminal(getConnection().getSourceAnchor());
		final String targetID = ((IAnchorableFigure)getConnection().getTargetAnchor().getOwner()).getConnectionAnchorTerminal(getConnection().getTargetAnchor());
		param.put(Util.FEEDBACK_BENDPOINTS, copy);
		param.put(Util.FEEDBACK_SOURCE_TERMINAL, sourceID);
		param.put(Util.FEEDBKACK_TARGET_TERMINAL, targetID);
		System.out.println("sourceTerm" + sourceID);
		System.out.println("targetRer" + targetID);
	}


	protected PointList getInitialPointList(final Request request) {
		@SuppressWarnings("unchecked")
		final Map<Object, Object> param = request.getExtendedData();
		final Object result = param.get(Util.RECONNECT_REQUEST_INITIAL_POINTS_LIST);
		if(result instanceof PointList) {
			//			System.out.println("initial point list");
			for(int i = 0; i < ((PointList)result).size(); i++) {
				//				System.out.println("point i=" + i + "  " + ((PointList)result).getPoint(i));
			}
			return ((PointList)result).getCopy();
		}
		return new PointList();
	}

	protected List<RelativeBendpoint> getInitialBendpoints(final Request request) {
		@SuppressWarnings("unchecked")
		final Map<Object, Object> param = request.getExtendedData();
		Object value = param.get(Util.RECONNECT_REQUEST_INITIAL_CONSTRAINTS);
		List<RelativeBendpoint> result = new ArrayList<RelativeBendpoint>();
		if(value instanceof Collection<?>) {
			final Iterator<?> iter = ((Collection<?>)value).iterator();
			System.out.println("initial bendpoints");
			while(iter.hasNext()) {
				final Object current = iter.next();
				if(current instanceof RelativeBendpoint) {
					//					System.out.println("bendpoints" + ((RelativeBendpoint)current).getLocation() + "  " + current);
					result.add((RelativeBendpoint)current);
				}
			}

		}

		result = Util.copyRelatedBendpointList(result, getConnection());
		Iterator<RelativeBendpoint> iter = result.iterator();
		while(iter.hasNext()) {
			final Object current = iter.next();
			//			if(current instanceof RelativeBendpoint) {
			System.out.println("bendpoints" + ((RelativeBendpoint)current).getLocation() + "  " + current);
			//				result.add((RelativeBendpoint)current);
			//			}
		}

		return result;
	}

	protected void updateRouterConstraint(final ReconnectRequest request) {
		PointList list = getInitialPointList(request);
		final Point first = list.getFirstPoint();
		int size = list.size();
		final Point last = list.getLastPoint();
		List<RelativeBendpoint> relatedBendpoints = new ArrayList<RelativeBendpoint>();
		for(int i = 0; i < list.size(); i++) {
			final Point current = list.getPoint(i);
			final Dimension s = current.getDifference(first);
			final Dimension t = current.getDifference(last);
			final RelativeBendpoint relatedBendpoint = new org.eclipse.draw2d.RelativeBendpoint(getConnection());
			relatedBendpoint.setRelativeDimensions(s, t);
			relatedBendpoints.add(relatedBendpoint);
			if(request.isMovingStartAnchor()) {
				if(i > 1) {

					relatedBendpoint.setWeight(1.0f);
				} else {
					relatedBendpoint.setWeight(0);
				}
			} else {
				if(i < size - 2) {

					relatedBendpoint.setWeight(0);
				} else {
					relatedBendpoint.setWeight(1.0f);
				}

			}
		}

		getConnection().setRoutingConstraint(relatedBendpoints);

		//		//TODO : this calculus should be done in PapyrusConnectionEndEditPolicy 
		//		//1. find the old anchor location
		NodeEditPart node = null;
		if(request.getTarget() instanceof NodeEditPart) {
			node = (NodeEditPart)request.getTarget();
		} else {
			return;
		}

		//2. we create a dummy connection from current connection, with new informations to determine real anchor point
		final Connection dummyConnection = new PolylineConnectionEx();

		if(request.isMovingStartAnchor()) {
			ConnectionAnchor sourceAnchor = node.getSourceConnectionAnchor(request);
			final Point targetPoint = getConnection().getTargetAnchor().getReferencePoint();
			final ConnectionAnchor targetAnchor = ((IAnchorableFigure)getConnection().getTargetAnchor().getOwner()).getTargetConnectionAnchorAt(targetPoint);
			dummyConnection.setSourceAnchor(sourceAnchor);
			dummyConnection.setTargetAnchor(targetAnchor);
		} else {
			ConnectionAnchor targetAnchor = node.getTargetConnectionAnchor(request);
			final Point sourcePoint = getConnection().getSourceAnchor().getReferencePoint();
			final ConnectionAnchor sourceAnchor = ((IAnchorableFigure)getConnection().getSourceAnchor().getOwner()).getSourceConnectionAnchorAt(sourcePoint);
			dummyConnection.setSourceAnchor(sourceAnchor);
			dummyConnection.setTargetAnchor(targetAnchor);
		}


		//		PointList newPoints = initialPoints.getCopy();
		PointList newPoints = getInitialPointList(request);
		IFigure parent = getConnection().getParent();
		final Layer layer = DiagramEditPartsUtil.getDiagramFeedbackLayer(node);
		dummyConnection.setParent(layer);
		dummyConnection.setPoints(newPoints);//required?

		final ConnectionRouter router = getConnection().getConnectionRouter();
		router.setConstraint(dummyConnection, relatedBendpoints);
		router.route(dummyConnection);
		Point point = null;
		if(request.isMovingStartAnchor()) {
			point = dummyConnection.getPoints().getFirstPoint();
		} else {
			point = dummyConnection.getPoints().getLastPoint();
		}

		final IDiagramGraphicalViewer viewer = DiagramEditPartsUtil.getActiveDiagramGraphicalViewer();
		final FigureCanvas figureCanvas = (FigureCanvas)viewer.getControl();
		final Point diagramScrollbarLocation = figureCanvas.getViewport().getViewLocation().getCopy();
		point.translate(diagramScrollbarLocation.getNegated());
		request.setLocation(point);

		//clear the router
		getConnection().getConnectionRouter().remove(dummyConnection);
	}



	/**
	 * 
	 * @param connection
	 *        a connection
	 * @param points
	 *        a list of points representing bendpoints for this connection
	 * @return
	 *         the list of bendpoints
	 */
	public static final List<RelativeBendpoint> convertToRelativeBendpoints(final Connection connection, final List<Point> points) {
		int size = points.size();
		final List<RelativeBendpoint> relatedBendpoints = new ArrayList<RelativeBendpoint>(points.size());
		if(size > 0) {
			final Point first = points.get(0);
			final Point last = points.get(size - 1);
			for(int i = 0; i < size; i++) {
				final Point current = points.get(i);
				final Dimension s = current.getDifference(first);
				final Dimension t = current.getDifference(last);
				final RelativeBendpoint relatedBendpoint = new org.eclipse.draw2d.RelativeBendpoint(connection);
				relatedBendpoint.setRelativeDimensions(s, t);
				relatedBendpoints.add(relatedBendpoint);
			}
		}
		return relatedBendpoints;
	}

	/**
	 * 
	 * @return
	 *         the current constraints for the connection
	 */
	protected List<RelativeBendpoint> getCurrentConnectionConstraint() {
		Object value = getConnection().getConnectionRouter().getConstraint(getConnection());
		final List<RelativeBendpoint> contraints = new ArrayList<RelativeBendpoint>();
		if(value instanceof Collection<?>) {
			final Iterator<?> iter = ((Collection<?>)value).iterator();
			while(iter.hasNext()) {
				Object current = iter.next();
				if(current instanceof RelativeBendpoint) {
					contraints.add((RelativeBendpoint)current);
				}
			}
		}
		return contraints;
	}

}
