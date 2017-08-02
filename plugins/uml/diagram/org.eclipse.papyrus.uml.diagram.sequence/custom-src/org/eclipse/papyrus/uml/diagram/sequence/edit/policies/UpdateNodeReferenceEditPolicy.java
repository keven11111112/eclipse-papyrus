/*****************************************************************************
 * Copyright s(c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.util.CoordinateReferentialUtils;
import org.eclipse.papyrus.uml.diagram.sequence.util.LogOptions;

/**
 * this editpolicy is to manage the movement of message on node as lifeline
 * It is like a graphical node
 * 
 * @since 3.0
 *
 */
public class UpdateNodeReferenceEditPolicy extends GraphicalEditPolicy {
	public static String UDPATE_NODE_REFERENCE = "UdpateNodeReferenceEditPolicy"; //$NON-NLS-1$

	/**
	 * To extract in other EditPolicy
	 * 
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getCommand(org.eclipse.gef.Request)
	 *
	 * @param request
	 * @return
	 * 
	 * 		<img src="../../../../../../../../../icons/sequenceScheme.png" width="250" />
	 *         <UL>
	 *         <LI>when move B (anchor of the message)-->move E but not move F this is a resize of the execution specification
	 *         <LI>when move C (anchor of the message)-->move F but not move E this is a resize of the execution specification
	 *         <UL>
	 */
	@Override
	public Command getCommand(Request request) {
		if (request instanceof ReconnectRequest && !(SenderRequestUtils.isASender(request, getHost()))) {

			ReconnectRequest reconnectRequest = (ReconnectRequest) request;
			ConnectionEditPart linkEditPart = reconnectRequest.getConnectionEditPart();
			UMLDiagramEditorPlugin.log.trace(LogOptions.SEQUENCE_DEBUG, "+ MOVE ANCHORS of " + linkEditPart.getClass().getName());//$NON-NLS-1$
			Point locationOnDiagram = CoordinateReferentialUtils.transformPointFromScreenToDiagramReferential(reconnectRequest.getLocation(), (GraphicalViewer) getHost().getViewer());
			UMLDiagramEditorPlugin.log.trace(LogOptions.SEQUENCE_DEBUG, "+-- LocationOnDiagram " + locationOnDiagram);// $NON-NLS-2$ //$NON-NLS-1$

			if (linkEditPart.getEditPolicy(SequenceReferenceEditPolicy.SEQUENCE_REFERENCE) != null) {
				SequenceReferenceEditPolicy references = (SequenceReferenceEditPolicy) linkEditPart.getEditPolicy(SequenceReferenceEditPolicy.SEQUENCE_REFERENCE);
				CompoundCommand compoundCommand = new CompoundCommand();
				for (Iterator<EditPart> iterator = references.getStrongReferences().keySet().iterator(); iterator.hasNext();) {
					EditPart editPart = (EditPart) iterator.next();
					if (!SenderRequestUtils.isASender(request, editPart) && getHost().getChildren().contains(editPart)) {
						GraphicalEditPart gEditPart = (GraphicalEditPart) editPart;
						Point GEPlocationOnDiagram = CoordinateReferentialUtils.getFigurePositionRelativeToDiagramReferential(gEditPart.getFigure(), getDiagramEditPart(getHost()));

						UMLDiagramEditorPlugin.log.trace(LogOptions.SEQUENCE_DEBUG, "+--> try to Move  from " + GEPlocationOnDiagram + " " + editPart.getClass().getName());// $NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-2$
						ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
						changeBoundsRequest.setLocation(reconnectRequest.getLocation());
						changeBoundsRequest.setEditParts(editPart);
						if (references.getStrongReferences().get(editPart).equals(SequenceReferenceEditPolicy.ROLE_START)) {
							int delta = (locationOnDiagram.y() - GEPlocationOnDiagram.y());
							UMLDiagramEditorPlugin.log.trace(LogOptions.SEQUENCE_DEBUG, "+--> Delta " + delta + " " + editPart.getClass().getName());// $NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-2$
							changeBoundsRequest.setMoveDelta(new Point(0, delta));
							changeBoundsRequest.setSizeDelta(new Dimension(0, -delta));
						}
						if (references.getStrongReferences().get(editPart).equals(SequenceReferenceEditPolicy.ROLE_FINISH)) {
							int delta = (locationOnDiagram.y() - GEPlocationOnDiagram.y() - gEditPart.getFigure().getBounds().height);
							UMLDiagramEditorPlugin.log.trace(LogOptions.SEQUENCE_DEBUG, "+--> Delta " + delta + " " + editPart.getClass().getName());// $NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-2$
							changeBoundsRequest.setMoveDelta(new Point(0, 0));
							changeBoundsRequest.setSizeDelta(new Dimension(0, delta));
						}
						ArrayList<EditPart> senderList = SenderRequestUtils.getSenders(request);
						SenderRequestUtils.addRequestSenders(changeBoundsRequest, senderList);
						SenderRequestUtils.addRequestSender(changeBoundsRequest, linkEditPart);
						Command cmd = editPart.getCommand(changeBoundsRequest);
						compoundCommand.add(cmd);
					}
				}
				if (compoundCommand.size() == 0) {
					// to avoid pb of non-executable command
					return super.getCommand(reconnectRequest);
				}
				return compoundCommand;

			}
			return super.getCommand(request);
		}
		return super.getCommand(request);
	}


	/**
	 * Walks up the editpart hierarchy to find and return the
	 * <code>TopGraphicEditPart</code> instance.
	 */
	public DiagramEditPart getDiagramEditPart(EditPart editPart) {
		while (editPart instanceof IGraphicalEditPart) {
			if (editPart instanceof DiagramEditPart) {
				return (DiagramEditPart) editPart;
			}

			editPart = editPart.getParent();
		}
		if (editPart instanceof DiagramRootEditPart) {
			return (DiagramEditPart) ((DiagramRootEditPart) editPart).getChildren().get(0);
		}
		return null;
	}
}
