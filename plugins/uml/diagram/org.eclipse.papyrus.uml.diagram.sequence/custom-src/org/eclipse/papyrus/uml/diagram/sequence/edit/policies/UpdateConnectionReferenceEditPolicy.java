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

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.util.LogOptions;

/**
 * this editpolicy is to manage the movement of Execution specification and update move of messages
 * It is like a graphical node
 * 
 * @since 3.0
 *
 */
public class UpdateConnectionReferenceEditPolicy extends GraphicalEditPolicy {
	public static String UDPATE_CONNECTION_REFERENCE = "UdpateConnectionReferenceEditPolicy"; //$NON-NLS-1$


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
		if (request instanceof ChangeBoundsRequest && (!org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants.REQ_AUTOSIZE.equals(request.getType()))) {
			Point nextLocation = ((ChangeBoundsRequest) request).getLocation();
			UMLDiagramEditorPlugin.log.trace(LogOptions.SEQUENCE_DEBUG, "+ MOVE at " + nextLocation + " of " + getHost());//$NON-NLS-1$ //$NON-NLS-2$
			Rectangle locationAndSize = new PrecisionRectangle(getHostFigure().getBounds());

			if (getHost() instanceof AbstractExecutionSpecificationEditPart) {
				getHostFigure().translateToAbsolute(locationAndSize);
				locationAndSize = ((ChangeBoundsRequest) request).getTransformedRectangle(locationAndSize);
			}
			if (getHost().getEditPolicy(SequenceReferenceEditPolicy.SEQUENCE_REFERENCE) != null) {
				SequenceReferenceEditPolicy references = (SequenceReferenceEditPolicy) getHost().getEditPolicy(SequenceReferenceEditPolicy.SEQUENCE_REFERENCE);
				if (!SenderRequestUtils.isASender(request, getHost())) {
					CompoundCommand compoundCommand = new CompoundCommand();
					for (Iterator<EditPart> iterator = references.getStrongReferences().keySet().iterator(); iterator.hasNext();) {
						EditPart editPart = (EditPart) iterator.next();
						if (!SenderRequestUtils.isASender(request, editPart)) {
							UMLDiagramEditorPlugin.log.trace(LogOptions.SEQUENCE_DEBUG, "+--> try to Move " + editPart);//$NON-NLS-1$
							if (editPart instanceof ConnectionEditPart) {
								ConnectionEditPart connectionEditPart = (ConnectionEditPart) editPart;
								ArrayList<EditPart> senderList = SenderRequestUtils.getSenders(request);
								// create the request

								ReconnectRequest reconnectSourceRequest = createReconnectRequest(connectionEditPart, locationAndSize, senderList, RequestConstants.REQ_RECONNECT_SOURCE, references);
								ReconnectRequest reconnectTargetRequest = createReconnectRequest(connectionEditPart, locationAndSize, senderList, RequestConstants.REQ_RECONNECT_TARGET, references);
								compoundCommand.add(connectionEditPart.getTarget().getCommand(reconnectTargetRequest));
								compoundCommand.add(connectionEditPart.getSource().getCommand(reconnectSourceRequest));
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
		return super.getCommand(request);
	}

	/**
	 * Create a reconnection request
	 * 
	 * @param connectionEditPart
	 *            the link controller to reconnect
	 * @param locationAndSize
	 *            the position where want to reconnect
	 * @param senderList
	 *            the lest of controller that has sent the request
	 * @param reconnectType
	 *            the kind of the connection see {@link RequestConstants}
	 * @param references
	 *            the editpolicy that has strong references
	 * @return always a reconnect request
	 */
	protected ReconnectRequest createReconnectRequest(ConnectionEditPart connectionEditPart, Rectangle locationAndSize, ArrayList<EditPart> senderList, String reconnectType, SequenceReferenceEditPolicy references) {
		ReconnectRequest reconnectRequest = new ReconnectRequest();
		reconnectRequest.setConnectionEditPart(connectionEditPart);
		SenderRequestUtils.addRequestSenders(reconnectRequest, senderList);
		SenderRequestUtils.addRequestSender(reconnectRequest, getHost());
		if (SequenceReferenceEditPolicy.ROLE_START.equals(references.getStrongReferences().get(connectionEditPart))) {
			reconnectRequest.setLocation(new Point(100, locationAndSize.y));
		} else {
			reconnectRequest.setLocation(new Point(100, locationAndSize.y + locationAndSize.height));
		}
		reconnectRequest.setType(reconnectType);
		if (RequestConstants.REQ_RECONNECT_TARGET.equals(reconnectType)) {
			reconnectRequest.setTargetEditPart(connectionEditPart.getTarget());
		} else {
			reconnectRequest.setTargetEditPart(connectionEditPart.getSource());
		}
		return reconnectRequest;
	}

}
