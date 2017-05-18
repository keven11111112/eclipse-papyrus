/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
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

package org.eclipse.papyrus.uml.diagram.sequence.command;

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest.ConnectionViewAndElementDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.uml.diagram.sequence.CustomMessages;
import org.eclipse.papyrus.uml.diagram.sequence.figures.DestructionEventFigure;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;

/**
 *this class is used to drop the representation of the DestructionOccurrenceSpecification from the request in charge to create the message delete
 *
 */
public class DropDestructionOccurenceSpecification extends AbstractTransactionalCommand {

	private CreateConnectionViewAndElementRequest request;
	private EditPart graphicalContainer;
	private Point absolutePosition;

	
	/**
	 * @param domain
	 * @param request the request that has in charge to create the deleteMessage
	 * @param graphicalContainer for example the lifeline that will contain the representation of the event
	 */
	public DropDestructionOccurenceSpecification(TransactionalEditingDomain domain, CreateConnectionViewAndElementRequest request, EditPart graphicalContainer, Point absolutePosition) {
		super(domain, CustomMessages.Commands_DropDestructionOccurenceSpecification_Label, null);
		this.request=request;
		this.graphicalContainer= graphicalContainer;
		this.absolutePosition=absolutePosition;
	}


	/**
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 *
	 * @param monitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		CommandResult commandresult = null;
		//1. look for the message
		Message deleteMessage=getDeleteMessage();
		if( deleteMessage==null){
			return commandresult;
		}
		//2. look for the Destruction occurrence
		DestructionOccurrenceSpecification destructionOccurrenceSpecification=getDestructionOccurrence(deleteMessage);
		if( destructionOccurrenceSpecification==null){
			return commandresult;
		}
		//3. drop the Destruction Occurrence
		dropDestructionOccurrence(destructionOccurrenceSpecification);
		return CommandResult.newOKCommandResult();
	}

	/**
	 * @param destructionOccurrenceSpecification
	 */
	private void dropDestructionOccurrence(DestructionOccurrenceSpecification destructionOccurrenceSpecification) {
		DropObjectsRequest dropDestructionOccurrenceRequest= new DropObjectsRequest();
		Point point=request.getLocation().getCopy();
		IFigure parentFigure=((GraphicalEditPart)graphicalContainer).getFigure();
		parentFigure.translateToRelative(absolutePosition);
		DestructionEventFigure destructionEventFigure= new DestructionEventFigure();
		point.y=point.y-destructionEventFigure.getDefaultSize().height/2;
		dropDestructionOccurrenceRequest.setLocation(point);
		ArrayList<EObject> destructionOccurrenceListToDrop=new ArrayList<EObject>();
		destructionOccurrenceListToDrop.add(destructionOccurrenceSpecification);
		dropDestructionOccurrenceRequest.setObjects(destructionOccurrenceListToDrop);
		
		//give the position from the layer it is not relative
		Command command=graphicalContainer.getCommand(dropDestructionOccurrenceRequest);
		command.execute();
	}

	/**
	 * get the DestructionOccurenceSpecification from a given message
	 * @param deleteMessage the message to look for must be never null
	 * @return DestructionOccurenceSpecification or null
	 */
	private DestructionOccurrenceSpecification getDestructionOccurrence(Message deleteMessage) {
		DestructionOccurrenceSpecification destructionOccurrenceSpecification=null;
		MessageEnd messageEnd =deleteMessage.getReceiveEvent();
		if(messageEnd instanceof DestructionOccurrenceSpecification){
			destructionOccurrenceSpecification=(DestructionOccurrenceSpecification)messageEnd;
		}
		return destructionOccurrenceSpecification;
	}

	/**
	 * @return the delete message from the given request, can return null
	 */
	private Message getDeleteMessage() {
		Message deleteMessage=null;
		ConnectionViewAndElementDescriptor connectionViewAndElementDescriptor=request.getConnectionViewAndElementDescriptor();
		if( connectionViewAndElementDescriptor!=null){
			CreateElementRequestAdapter createElementRequestAdapter=connectionViewAndElementDescriptor.getCreateElementRequestAdapter();
			deleteMessage=(Message)createElementRequestAdapter.getAdapter(Message.class);
		}
		return deleteMessage;
	}



}
