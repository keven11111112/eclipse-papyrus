/*****************************************************************************
 * Copyright (c) 2010-2017 CEA
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *   Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net - Bug 519408, 525372
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.AbstractRouter;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.BendpointRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionBendpointEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.util.SelectInDiagramHelper;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.LineMode;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.NodeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.CustomMessages;
import org.eclipse.papyrus.uml.diagram.sequence.command.DropDestructionOccurenceSpecification;
import org.eclipse.papyrus.uml.diagram.sequence.draw2d.routers.MessageRouter.RouterKind;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CLifeLineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageAsyncEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageCreateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageDeleteEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageFoundEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageLostEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageSyncEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.figures.MessageCreate;
import org.eclipse.papyrus.uml.diagram.sequence.util.OccurrenceSpecificationMoveHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * This bendpoint edit policy is used to allow drag of horizontal messages and forbid drag otherwise.
 *
 * @author mvelten
 *
 */
@SuppressWarnings("restriction")
public class MessageConnectionLineSegEditPolicy extends ConnectionBendpointEditPolicy {

	/**
	 * Set up moving LineSeg data for self linked message, the value should be one of MOVED_UP, MOVED_DOWN and MOVED_HORIAONTZL.
	 * See showMoveLineSegFeedback() for self linked message for details.
	 */
	private static final String MOVE_LINE_ORIENTATION_DATA = "Move line orientation";

	private static final String MOVED_UP = "Moved Up";

	private static final String MOVED_DOWN = "Moved Down";

	private static final String MOVED_HORIZONTAL = "Moved Horizontal";

	/** The minimum height of the figure. */
	private static final int LIFELINE_MIN_HEIGHT = 100;

	public MessageConnectionLineSegEditPolicy() {
		super(LineMode.ORTHOGONAL_FREE);
	}

	@Override
	protected List createManualHandles() {
		RouterKind kind = RouterKind.getKind(getConnection(), getConnection().getPoints());
		if (kind == RouterKind.SELF || kind == RouterKind.HORIZONTAL || getConnection() instanceof MessageCreate) {
			// Removed the handles for self message.
			return Collections.emptyList();
		}
		return super.createManualHandles();
	}

	@Override
	public Command getCommand(Request request) {
		RouterKind kind = RouterKind.getKind(getConnection(), getConnection().getPoints());
		if (kind == RouterKind.SELF || kind == RouterKind.HORIZONTAL || getConnection() instanceof MessageCreate) {
			return super.getCommand(request);
		} else if (request instanceof BendpointRequest) {
			return getMoveMessageCommand((BendpointRequest) request);
		}
		return null;
	}

	/**
	 * Add impossible to move the message lost/found by drag the middle line
	 *
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=403138
	 */
	protected Command getMoveMessageCommand(BendpointRequest request) {
		if (getHost() instanceof MessageLostEditPart || getHost() instanceof MessageFoundEditPart) {
			PointList points = getConnection().getPoints().getCopy();
			CompoundCommand command = new CompoundCommand("Move");//$NON-NLS-1$
			AbstractMessageEditPart messageSyncEditPart = (AbstractMessageEditPart) getHost();
			// move source
			ReconnectRequest sourceReq = new ReconnectRequest(REQ_RECONNECT_SOURCE);
			sourceReq.setConnectionEditPart(messageSyncEditPart);
			Point sourceLocation = points.getFirstPoint().getCopy();
			getConnection().translateToAbsolute(sourceLocation);
			sourceLocation = SequenceUtil.getSnappedLocation(getHost(), sourceLocation);
			EditPart source = messageSyncEditPart.getSource();
			sourceReq.setLocation(sourceLocation);
			sourceReq.setTargetEditPart(source);
			Command moveSourceCommand = source.getCommand(sourceReq);
			command.add(moveSourceCommand);
			// move target
			EditPart target = messageSyncEditPart.getTarget();
			ReconnectRequest targetReq = new ReconnectRequest(REQ_RECONNECT_TARGET);
			targetReq.setConnectionEditPart(messageSyncEditPart);
			Point targetLocation = points.getLastPoint().getCopy();
			getConnection().translateToAbsolute(targetLocation);
			targetLocation = SequenceUtil.getSnappedLocation(getHost(), targetLocation);
			targetReq.setLocation(targetLocation);
			targetReq.setTargetEditPart(target);
			Command moveTargetCommand = target.getCommand(targetReq);
			command.add(moveTargetCommand);
			return command.unwrap();
		}
		return null;
	}

	/**
	 * Move the anchors along with the line and update bendpoints accordingly.
	 */
	@Override
	protected Command getBendpointsChangedCommand(BendpointRequest request) {
		//snap to grid the location request
		request.setLocation(SequenceUtil.getSnappedLocation(getHost(), request.getLocation()));
		if ((getHost().getViewer() instanceof ScrollingGraphicalViewer) && (getHost().getViewer().getControl() instanceof FigureCanvas)) {
			SelectInDiagramHelper.exposeLocation((FigureCanvas) getHost().getViewer().getControl(), request.getLocation().getCopy());
		}
		if (getHost() instanceof ConnectionNodeEditPart) {
			ConnectionNodeEditPart connectionPart = (ConnectionNodeEditPart) getHost();
			EObject message = connectionPart.resolveSemanticElement();
			if (message instanceof Message) {
				MessageEnd send = ((Message) message).getSendEvent();
				MessageEnd rcv = ((Message) message).getReceiveEvent();
				EditPart srcPart = connectionPart.getSource();
				CLifeLineEditPart srcLifelinePart = (CLifeLineEditPart) SequenceUtil.getParentLifelinePart(srcPart);
				EditPart tgtPart = connectionPart.getTarget();
				CLifeLineEditPart targetLifelinePart = (CLifeLineEditPart) SequenceUtil.getParentLifelinePart(tgtPart);
				if (/* send instanceof OccurrenceSpecification && rcv instanceof OccurrenceSpecification && */srcLifelinePart != null && targetLifelinePart != null) {
					RouterKind kind = RouterKind.getKind(getConnection(), getConnection().getPoints());
					if ((getHost() instanceof MessageSyncEditPart || getHost() instanceof MessageAsyncEditPart) && kind == RouterKind.SELF) {
						// TODO_MIA Test it
						return getSelfLinkMoveCommand(request, connectionPart, send, rcv, srcLifelinePart);
					} else if (getHost() instanceof MessageCreateEditPart) {
						// Reposition lifeline
						IFigure targetFigure = targetLifelinePart.getPrimaryShape();

						Point sourcePoint = request.getLocation().getCopy();
						sourcePoint = SequenceUtil.getSnappedLocation(targetLifelinePart, sourcePoint);
						targetFigure.getParent().translateToRelative(sourcePoint);
						// gets the final snapped position

						// Take into account of the sticker size
						int stickerHeight = ((CLifeLineEditPart) targetLifelinePart).getStickerHeight();
						if (stickerHeight != -1) {
							sourcePoint.y = sourcePoint.y - (stickerHeight / 2);
						}

						Bounds bounds = ((Bounds) ((Node) targetLifelinePart.getModel()).getLayoutConstraint());

						SetBoundsCommand moveLifelineCmd = new SetBoundsCommand(targetLifelinePart.getEditingDomain(), "Move LifeLine", new EObjectAdapter(((GraphicalEditPart) targetLifelinePart).getNotationView()), //$NON-NLS-1$
								new Point(bounds.getX(), sourcePoint.y));

						SetBoundsCommand setSizeCommand = new SetBoundsCommand(targetLifelinePart.getEditingDomain(), "Size LifeLine", new EObjectAdapter(((GraphicalEditPart) targetLifelinePart).getNotationView()), //$NON-NLS-1$
								new Dimension(bounds.getWidth(), bounds.getHeight() - (sourcePoint.y - targetFigure.getBounds().y)));

						// Move message End
						int y = request.getLocation().y;
						Command srcCmd = createMoveMessageEndCommand((Message) message, srcPart, send, y, srcLifelinePart, request);
						Command tgtCmd = createMoveMessageEndCommand((Message) message, tgtPart, rcv, y, targetLifelinePart, request);

						CompoundCommand compoudCmd = new CompoundCommand(CustomMessages.MoveMessageCommand_Label);
						Point oldLocation = SequenceUtil.getAbsoluteEdgeExtremity(connectionPart, true);
						if (oldLocation != null) {
							int oldY = oldLocation.y;
							if (oldY < y) {
								compoudCmd.add(tgtCmd);
								compoudCmd.add(srcCmd);
								compoudCmd.add(new ICommandProxy(moveLifelineCmd));
							} else {
								compoudCmd.add(new ICommandProxy(moveLifelineCmd));
								compoudCmd.add(new ICommandProxy(setSizeCommand));
								compoudCmd.add(srcCmd);
								compoudCmd.add(tgtCmd);
							}
							return compoudCmd;
						}
					} else if (getHost() instanceof MessageDeleteEditPart) {
						// Reposition lifeline
						IFigure targetFigure = targetLifelinePart.getPrimaryShape();

						Point refPoint = SequenceUtil.getSnappedLocation(targetLifelinePart, request.getLocation().getCopy());
						targetFigure.getParent().translateToRelative(refPoint);
						Bounds bounds = ((Bounds) ((Node) targetLifelinePart.getModel()).getLayoutConstraint());


						SetBoundsCommand setSizeCommand = new SetBoundsCommand(targetLifelinePart.getEditingDomain(), "Size LifeLine", new EObjectAdapter(((GraphicalEditPart) targetLifelinePart).getNotationView()), //$NON-NLS-1$
								new Dimension(bounds.getWidth(), refPoint.y - bounds.getY()));

						CompoundCommand compoudCmd = new CompoundCommand(CustomMessages.MoveMessageCommand_Label);
						if (kind == RouterKind.SELF) {
							// Only resize for down moved
							if (MOVED_DOWN.equals(request.getExtendedData().get(MOVE_LINE_ORIENTATION_DATA))) {
								compoudCmd.add(new ICommandProxy(setSizeCommand));
							}
						} else {
							// Move message End
							int y = request.getLocation().y;
							Command srcCmd = createMoveMessageEndCommand((Message) message, srcPart, send, y, srcLifelinePart, request);
							Command tgtCmd = createMoveMessageEndCommand((Message) message, tgtPart, rcv, y, targetLifelinePart, request);
							DropDestructionOccurenceSpecification dropDestructionOccurenceSpecification = new DropDestructionOccurenceSpecification(((ConnectionEditPart) getHost()).getEditingDomain(), request, targetLifelinePart,
									request.getLocation().getCopy());

							Point oldLocation = SequenceUtil.getAbsoluteEdgeExtremity(connectionPart, true);
							if (oldLocation != null) {
								int oldY = oldLocation.y;
								if (oldY < y) {// down
									compoudCmd.add(new ICommandProxy(setSizeCommand));
									compoudCmd.add(tgtCmd);
									compoudCmd.add(srcCmd);
									compoudCmd.add(new ICommandProxy(dropDestructionOccurenceSpecification));
								} else {// up
									compoudCmd.add(srcCmd);
									compoudCmd.add(tgtCmd);
									compoudCmd.add(new ICommandProxy(setSizeCommand));
									compoudCmd.add(new ICommandProxy(dropDestructionOccurenceSpecification));
								}
							}
						}
						return compoudCmd;
					} else {
						int y = request.getLocation().y;
						Command srcCmd = createMoveMessageEndCommand((Message) message, srcPart, send, y, srcLifelinePart, request);
						Command tgtCmd = createMoveMessageEndCommand((Message) message, tgtPart, rcv, y, targetLifelinePart, request);
						CompoundCommand compoudCmd = new CompoundCommand(CustomMessages.MoveMessageCommand_Label);
						/*
						 * Take care of the order of commands, to make sure target is always bellow the source.
						 * Otherwise, moving the target above the source would cause order conflict with existing CF.
						 */
						Point oldLocation = SequenceUtil.getAbsoluteEdgeExtremity(connectionPart, true);
						if (oldLocation != null) {
							int oldY = oldLocation.y;
							if (oldY < y) {
								compoudCmd.add(tgtCmd);
								compoudCmd.add(srcCmd);
							} else {
								compoudCmd.add(srcCmd);
								compoudCmd.add(tgtCmd);
							}
							return compoudCmd;
						}
					}
				} else
				// Found message case && Lost message case
				if ((srcLifelinePart == null) && (targetLifelinePart != null) || (srcLifelinePart != null && targetLifelinePart == null)) {
					return getMoveMessageCommand((BendpointRequest) request);
				}
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Add impossible to move the anchor connected inside of CoRegion
	 *
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=402970
	 */
	protected Command createMoveMessageEndCommand(Message message, EditPart endEditPart, MessageEnd end, int yLocation, LifelineEditPart lifeline, Request request) {
		if (end instanceof OccurrenceSpecification) {
			List<EditPart> empty = Collections.emptyList();
			return OccurrenceSpecificationMoveHelper.getMoveOccurrenceSpecificationsCommand((OccurrenceSpecification) end, null, yLocation, -1, lifeline, empty, request);
		} else if (end instanceof Gate) {
			boolean isSource = (end == message.getSendEvent());
			ConnectionNodeEditPart connection = (ConnectionNodeEditPart) getHost();
			if (isSource) {
				ReconnectRequest req = new ReconnectRequest(REQ_RECONNECT_SOURCE);
				req.getExtendedData().put(SequenceUtil.DO_NOT_CHECK_HORIZONTALITY, true);
				req.setConnectionEditPart(connection);
				req.setTargetEditPart(endEditPart);
				Point location = SequenceUtil.getAbsoluteEdgeExtremity(connection, true);
				location.setY(yLocation);
				req.setLocation(location);
				Command command = endEditPart.getCommand(req);
				return command;
			} else {
				ReconnectRequest req = new ReconnectRequest(REQ_RECONNECT_TARGET);
				req.getExtendedData().put(SequenceUtil.DO_NOT_CHECK_HORIZONTALITY, true);
				req.setConnectionEditPart(connection);
				req.setTargetEditPart(endEditPart);
				Point location = SequenceUtil.getAbsoluteEdgeExtremity(connection, false);
				location.setY(yLocation);
				req.setLocation(location);
				Command command = endEditPart.getCommand(req);
				return command;
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	protected Command getSelfLinkMoveCommand(BendpointRequest request, ConnectionNodeEditPart connectionPart, MessageEnd send, MessageEnd rcv, LifelineEditPart srcLifelinePart) {
		// Just do it, checking was finished by showing feedback.
		Object moveData = request.getExtendedData().get(MOVE_LINE_ORIENTATION_DATA);
		CompoundCommand compoudCmd = new CompoundCommand(CustomMessages.MoveMessageCommand_Label);
		// And make sure the self linked message can be customized by using bendpoints.
		compoudCmd.add(super.getBendpointsChangedCommand(request));
		PointList points = getConnection().getPoints();
		if (MOVED_UP.equals(moveData)) {
			Point sourceRefPoint = points.getFirstPoint();
			getConnection().translateToAbsolute(sourceRefPoint);
			Command srcCmd = getReconnectCommand(connectionPart, connectionPart.getSource(), sourceRefPoint, RequestConstants.REQ_RECONNECT_SOURCE);
			compoudCmd.add(srcCmd);
		} else if (MOVED_DOWN.equals(moveData)) {
			Point targetRefPoint = points.getLastPoint();
			getConnection().translateToAbsolute(targetRefPoint);
			// Self message not always has same source and target, such as MessageSync.
			Command tgtCmd = getReconnectCommand(connectionPart, connectionPart.getTarget(), targetRefPoint, RequestConstants.REQ_RECONNECT_TARGET);
			compoudCmd.add(tgtCmd);
		}
		return compoudCmd.unwrap();
	}

	protected Command getReconnectCommand(ConnectionNodeEditPart connectionPart, EditPart targetPart, Point location, String requestType) {
		// Create and set the properties of the request
		ReconnectRequest reconnReq = new ReconnectRequest();
		reconnReq.setConnectionEditPart(connectionPart);
		reconnReq.setLocation(location);
		reconnReq.setTargetEditPart(targetPart);
		reconnReq.setType(requestType);
		// add a parameter to bypass the move impact to avoid infinite loop
		reconnReq.getExtendedData().put(SequenceRequestConstant.DO_NOT_MOVE_EDIT_PARTS, true);
		Command cmd = targetPart.getCommand(reconnReq);
		return cmd;
	}

	/**
	 * don't show feedback if the drag is forbidden (message not horizontal).
	 */
	@Override
	public void showSourceFeedback(Request request) {
		if (request instanceof BendpointRequest) {
			RouterKind kind = RouterKind.getKind(getConnection(), getConnection().getPoints());
			if (getHost() instanceof MessageFoundEditPart || getHost() instanceof MessageLostEditPart) {
				showMoveLineSegFeedback((BendpointRequest) request);
			} else if (kind == RouterKind.SELF || kind == RouterKind.HORIZONTAL || getConnection() instanceof MessageCreate) {
				if (getLineSegMode() != LineMode.OBLIQUE && REQ_MOVE_BENDPOINT.equals(request.getType())) {
					// Fixed bug about show feedback for moving bendpoints, make sure at least 3 points.
					List constraint = (List) getConnection().getRoutingConstraint();
					if (constraint.size() > 2) {
						super.showSourceFeedback(request);
					}
				} else {
					super.showSourceFeedback(request);
				}
				if (getLineSegMode() != LineMode.OBLIQUE && REQ_MOVE_BENDPOINT.equals(request.getType())) {
					showMoveLineSegFeedback((BendpointRequest) request);
				}
			}
		}
	}

	private ConnectionRouter router;

	static class DummyRouter extends AbstractRouter {

		@Override
		public void route(Connection conn) {
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	protected void showMoveLineSegFeedback(BendpointRequest request) {
		RouterKind kind = RouterKind.getKind(getConnection(), getConnection().getPoints());
		if ((getHost() instanceof MessageSyncEditPart || getHost() instanceof MessageAsyncEditPart || getHost() instanceof MessageDeleteEditPart) && kind == RouterKind.SELF) {
			if (router == null) {
				router = getConnection().getConnectionRouter();
				getConnection().setConnectionRouter(new DummyRouter());
			}
			PointList linkPoints = getConnection().getPoints().getCopy();
			Point ptLoc = SequenceUtil.getSnappedLocation(getHost(), request.getLocation());

			getConnection().translateToRelative(ptLoc);
			int dy = 0;
			int dx = 0;
			int from = 0, to = 0;
			int index = request.getIndex();
			if (index == 0) {
				dy = ptLoc.y - linkPoints.getFirstPoint().y;
				from = 0;
				to = 1;
				request.getExtendedData().put(MOVE_LINE_ORIENTATION_DATA, MOVED_UP);
			} else if (index == 1) {
				dx = ptLoc.x - linkPoints.getMidpoint().x;
				from = 1;
				to = 2;
				request.getExtendedData().put(MOVE_LINE_ORIENTATION_DATA, MOVED_HORIZONTAL);
			} else if (index == 2) {
				dy = ptLoc.y - linkPoints.getLastPoint().y;
				from = 2;
				to = 3;
				request.getExtendedData().put(MOVE_LINE_ORIENTATION_DATA, MOVED_DOWN);
			}
			if (getHost() instanceof MessageSyncEditPart && index > 1) {
				dy = 0;
			}
			// move points on link
			int size = linkPoints.size();
			if (from >= 0 && from < size && to >= 0 && to < size && from <= to) {
				for (int i = from; i <= to; i++) {
					Point p = linkPoints.getPoint(i);
					p.translate(dx, dy);
					linkPoints.setPoint(p, i);
				}
			}
			// link should not exceed lifeline bounds
			getConnection().setPoints(linkPoints);
			getConnection().getLayoutManager().layout(getConnection());
			return;
		}
		// Add impossible to dragging MessageLost and MessageFound. See bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=403138
		if (getHost() instanceof MessageCreateEditPart || getHost() instanceof MessageDeleteEditPart || getHost() instanceof MessageLostEditPart || getHost() instanceof MessageFoundEditPart) {
			if (router == null) {
				router = getConnection().getConnectionRouter();
				getConnection().setConnectionRouter(new DummyRouter());
			}
			PointList linkPoints = getConnection().getPoints().getCopy();
			Point ptLoc = new Point(request.getLocation());
			ptLoc = SequenceUtil.getSnappedLocation(getHost(), ptLoc);
			getConnection().translateToRelative(ptLoc);

			int dy = ptLoc.y - linkPoints.getFirstPoint().y;
			int size = linkPoints.size();
			for (int i = 0; i < size; i++) {
				Point p = linkPoints.getPoint(i).translate(0, dy);
				linkPoints.setPoint(p, i);
			}
			if (checkBounds(linkPoints)) {
				getConnection().setPoints(linkPoints);
				getConnection().getLayoutManager().layout(getConnection());
			}
			return;
		}
		super.showMoveLineSegFeedback(request);
	}

	protected boolean checkBounds(PointList linkPoints) {
		if (linkPoints.getFirstPoint().y > linkPoints.getLastPoint().y) {
			return false;
		}
		EditPart sourcePart = ((ConnectionNodeEditPart) getHost()).getSource();
		if (sourcePart instanceof CLifeLineEditPart) {
			CLifeLineEditPart sourceLifelineEditPart = (CLifeLineEditPart) sourcePart;
			NodeFigure sourceFigure = sourceLifelineEditPart.getPrimaryShape();
			Rectangle boundsToMatch = sourceFigure.getBounds().getCopy();
			// The bounds to match must be the top of the dashline of the source lifeline and the bottom of the target or source lifeline.
			// TODO_MIA case where target is not a lifeline(AbstractExecutionSpecificationEditPart)
			EditPart targetPart = ((ConnectionNodeEditPart) getHost()).getTarget();
			if (sourceLifelineEditPart.getStickerHeight() != -1) {
				boundsToMatch.setHeight(boundsToMatch.height - sourceLifelineEditPart.getStickerHeight());
				boundsToMatch.setY(boundsToMatch.y + sourceLifelineEditPart.getStickerHeight());
			}

			if (getHost() instanceof MessageCreateEditPart && targetPart instanceof CLifeLineEditPart) {
				NodeFigure targetFigure = (NodeFigure) ((NodeEditPart) targetPart).getPrimaryShape();
				// If the bottom of the target is higher
				int bottom = targetFigure.getBounds().bottom();
				if (bottom < boundsToMatch.bottom()) {
					int delta = boundsToMatch.bottom() - bottom + LIFELINE_MIN_HEIGHT;
					boundsToMatch.setHeight(boundsToMatch.height - delta);
				}
			}
			sourceFigure.translateToAbsolute(boundsToMatch);
			Rectangle boundsToCheck = linkPoints.getBounds();
			getConnection().translateToAbsolute(boundsToCheck);
			// check top and bottom y limit
			if (boundsToCheck.y <= boundsToMatch.y || boundsToCheck.getBottom().y >= boundsToMatch.getBottom().y) {
				return false;
			}
		}
		// It seems the self message can be created on ES, too
		else if (sourcePart instanceof AbstractExecutionSpecificationEditPart) {
			AbstractExecutionSpecificationEditPart esep = (AbstractExecutionSpecificationEditPart) sourcePart;
			IFigure fig = esep.getFigure();
			Rectangle bounds = fig.getBounds().getCopy();
			fig.translateToAbsolute(bounds);
			Rectangle conBounds = linkPoints.getBounds().getCopy();
			getConnection().translateToAbsolute(conBounds);
			if (getHost() instanceof MessageSyncEditPart) {// Sync message is linked between two executions.
				if (conBounds.width < 2 || conBounds.height < 2
				// check top and bottom y limit
						|| conBounds.y <= bounds.y || conBounds.getBottom().y >= bounds.getBottom().y) {
					return false;
				}
			} else if ( // Don't change the orientation of self message.
			bounds.intersects(conBounds.getShrinked(1, 1))
					// make sure the line is not closest.
					|| conBounds.width < 2 || conBounds.height < 2
					// check top and bottom y limit
					|| conBounds.y <= bounds.y || conBounds.getBottom().y >= bounds.getBottom().y) {
				return false;
			}
		}
		return true;
	}

	@Override
	protected void eraseConnectionFeedback(BendpointRequest request, boolean removeFeedbackFigure) {
		getConnection().setVisible(true);
		super.eraseConnectionFeedback(request, removeFeedbackFigure);
		if (router != null) {
			getConnection().setConnectionRouter(router);
		}
		router = null;
	}
	// private boolean isHorizontal() {
	// Connection connection = getConnection();
	// RouterKind kind = RouterKind.getKind(connection, connection.getPoints());
	//
	// if(kind.equals(RouterKind.HORIZONTAL)) {
	// return true;
	// }
	// return false;
	// }
	//
	// final private static char TERMINAL_START_CHAR = '(';
	//
	// final private static char TERMINAL_DELIMITER_CHAR = ',';
	//
	// final private static char TERMINAL_END_CHAR = ')';
	//
	// private static String composeTerminalString(PrecisionPoint p) {
	// StringBuffer s = new StringBuffer(24);
	// s.append(TERMINAL_START_CHAR); // 1 char
	// s.append(p.preciseX); // 10 chars
	// s.append(TERMINAL_DELIMITER_CHAR); // 1 char
	// s.append(p.preciseY); // 10 chars
	// s.append(TERMINAL_END_CHAR); // 1 char
	// return s.toString(); // 24 chars max (+1 for safety, i.e. for string termination)
	// }
}
