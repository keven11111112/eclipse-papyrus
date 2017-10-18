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
 *   Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net - Bug 526191
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.papyrus.uml.diagram.common.editparts.RoundedCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.util.CoordinateReferentialUtils;
import org.eclipse.papyrus.uml.diagram.sequence.util.LogOptions;

/**
 * this editpolicy is to manage the movement of Execution specification and update move of messages
 * It is like a graphical node
 * 
 * @since 4.0
 *
 */
public class UpdateWeakReferenceForMessageSpecEditPolicy extends UpdateWeakReferenceEditPolicy {
	public static final String UDPATE_WEAK_REFERENCE_FOR_MESSAGE = "UpdateWeakReferenceForMessageSpecEditPolicy"; //$NON-NLS-1$

	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getCommand(org.eclipse.gef.Request)
	 *
	 * @param request
	 * @return
	 * 
	 * 
	 * 		<img src="../../../../../../../../../icons/sequenceScheme.png" width="250" />
	 *         <UL>
	 *         <LI>when move E --> move B on the coordinate Y of E and move A on the coordinate Y of E
	 *         <LI>when Move F (execution specification) (resize)--> move C on the coordinate of C of F and move D on the coordinate of Y of F
	 *         <LI>Move E and F (execution specification) move the execution--> move B on the coordinate of Y of E and move A on the coordinate of Y of E and move C on the coordinate of C of F and move D on the coordinate of Y of F
	 *         <UL>
	 *
	 */
	@Override
	public Command getCommand(Request request) {
		if (request instanceof ReconnectRequest && !(SenderRequestUtils.isASender(request, getHost()))) {
			ReconnectRequest reconnectRequest = (ReconnectRequest) request;
			ConnectionEditPart hostConnectionEditPart = reconnectRequest.getConnectionEditPart();
			UMLDiagramEditorPlugin.log.trace(LogOptions.SEQUENCE_DEBUG, "+ MOVE ANCHORS of " + hostConnectionEditPart.getClass().getName());//$NON-NLS-1$
			Point locationOnDiagram = CoordinateReferentialUtils.transformPointFromScreenToDiagramReferential(reconnectRequest.getLocation(), (GraphicalViewer) getHost().getViewer());
			UMLDiagramEditorPlugin.log.trace(LogOptions.SEQUENCE_DEBUG, "+-- LocationOnDiagram " + locationOnDiagram);// $NON-NLS-2$ //$NON-NLS-1$
			// compute Delta
			Point moveDelta = new Point(0, 0);

			PolylineConnectionEx polyline = (PolylineConnectionEx) hostConnectionEditPart.getFigure();

			if (RequestConstants.REQ_RECONNECT_TARGET.equals(reconnectRequest.getType())) {
				Point anchorPositionOnScreen = polyline.getSourceAnchor().getReferencePoint();
				moveDelta.y = reconnectRequest.getLocation().y - anchorPositionOnScreen.y;
			} else {
				Point anchorPositionOnScreen = polyline.getSourceAnchor().getReferencePoint();
				moveDelta.y = reconnectRequest.getLocation().y - anchorPositionOnScreen.y;
			}
			if (moveDelta.y != 0 && mustMove) {
				if (hostConnectionEditPart.getEditPolicy(SequenceReferenceEditPolicy.SEQUENCE_REFERENCE) != null) {
					SequenceReferenceEditPolicy references = (SequenceReferenceEditPolicy) hostConnectionEditPart.getEditPolicy(SequenceReferenceEditPolicy.SEQUENCE_REFERENCE);
					if (!SenderRequestUtils.isASender(request, getHost())) {
						CompoundCommand compoundCommand = new CompoundCommand();

						// Gets weak references
						HashMap<EditPart, String> weakReferences = new HashMap<EditPart, String>();
						if ((moveDelta.y > 0 && mustMoveBelowAtMovingDown) || (moveDelta.y < 0 && mustMoveBelowAtMovingUp)) {
							weakReferences.putAll(references.getWeakReferences());
						}

						for (Iterator<EditPart> iterator = weakReferences.keySet().iterator(); iterator.hasNext();) {
							EditPart editPart = (EditPart) iterator.next();
							if (!SenderRequestUtils.isASender(request, editPart)) {
								UMLDiagramEditorPlugin.log.trace(LogOptions.SEQUENCE_DEBUG, "+--> try to Move " + editPart);//$NON-NLS-1$
								ArrayList<EditPart> senderList = SenderRequestUtils.getSenders(request);
								if (editPart instanceof ConnectionEditPart) {
									ConnectionEditPart connectionEditPart = (ConnectionEditPart) editPart;
									// create the request
									moveSourceConnectionEditPart(hostConnectionEditPart, moveDelta, compoundCommand, connectionEditPart, senderList);
									moveTargetConnectionEditPart(hostConnectionEditPart, moveDelta, compoundCommand, connectionEditPart, senderList);
								}
								if (editPart instanceof RoundedCompartmentEditPart) {
									moveRoundedEditPart(hostConnectionEditPart, moveDelta, compoundCommand, editPart, senderList);
								}
							}
						}
						if (compoundCommand.size() == 0) {
							// to avoid pb of non-executable command
							return super.getCommand(request);
						}

						return compoundCommand;
					}
				}
			}
		}
		return super.getCommand(request);
	}

}
