/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest.ConnectionViewAndElementDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.sequence.CustomMessages;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLDIElementTypes;
import org.eclipse.uml2.uml.Message;

/**
 * this class is used to automatically create execution specifications at target  
 * from the request in charge of creating a message between lifelines
 * according to the preferences for this message sort
 */
public class CreateExecutionSpecificationWithMessage extends RecordingCommand {

	protected CreateConnectionViewAndElementRequest request;
	protected EditPart graphicalContainer;

	protected String preference;
	protected IHintedType type;
	protected boolean createReply;
	
	/**
	 * @param domain
	 * @param request the request that is in charge of creating the message
	 * @param graphicalContainer the lifeline that will contain the event representation
	 */
	public CreateExecutionSpecificationWithMessage(TransactionalEditingDomain domain, CreateConnectionViewAndElementRequest request, EditPart graphicalContainer) {
		super(domain);
		this.request=request;
		this.graphicalContainer= graphicalContainer;
		
		this.preference = "CHOICE_BEHAVIOR";
		this.type = UMLDIElementTypes.BEHAVIOR_EXECUTION_SPECIFICATION_SHAPE;
		this.createReply = false;
	}

	/**
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 *
	 */
	@Override
	protected void doExecute() {
		//1. look for the message triggering the creation of the execution specification
		Message message=getMessage();
		if( message==null){
			return;
		}
		//2. retrieve preferences to apply
		// according to the message sort
		retrievePreferences();
		if( type==null || preference=="CHOICE_NONE") {
			return;
		}
		//3. create execution specification at target
		createExecutionSpecification();
		
	}

	
	
	/**
	 * creates an execution specification on the target lifeline
	 * creation location is computed from the request
	 */
	private void createExecutionSpecification() {	
		LifelineEditPart lifelineEditPart = (LifelineEditPart) graphicalContainer;
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, lifelineEditPart.getDiagramPreferencesHint());	
		Point point=request.getLocation().getCopy();
		requestcreation.setLocation(point);		
		Command command = lifelineEditPart.getCommand(requestcreation);
		command.execute();
		
		// case where a reply message must also be created
		if(createReply) {
			Point replysourcepoint = point.getCopy();
			replysourcepoint.setY(replysourcepoint.y+CustomActionExecutionSpecificationEditPart.DEFAULT_HEIGHT);
			// source of the reply message is the end of the execution specification
			createReplyMessage(lifelineEditPart, replysourcepoint); 
		}

	}

	/**
	 * creates a reply message originating from lifelineEditPart at replysourcepoint
	 */
	private void createReplyMessage(LifelineEditPart lifelineEditPart, Point replysourcepoint) {
		CreateConnectionViewRequest requestreplycreation = CreateViewRequestFactory.getCreateConnectionRequest(UMLDIElementTypes.MESSAGE_REPLY_EDGE, lifelineEditPart.getDiagramPreferencesHint());
		requestreplycreation.setLocation(replysourcepoint);				
		requestreplycreation.setSourceEditPart(null);
		requestreplycreation.setTargetEditPart(lifelineEditPart);
		requestreplycreation.setType(RequestConstants.REQ_CONNECTION_START);
		Command replycommand = lifelineEditPart.getCommand(requestreplycreation);
		
		// setup the request in preparation to get the connection end command
		requestreplycreation.setSourceEditPart(lifelineEditPart);
		LifelineEditPart target = (LifelineEditPart) request.getSourceEditPart();
		requestreplycreation.setTargetEditPart(target);
		requestreplycreation.setType(RequestConstants.REQ_CONNECTION_END);
		
		IFigure f = ((LifelineEditPart)target).getPrimaryShape();
		Rectangle b = f.getBounds().getCopy();
		f.translateToAbsolute(b);
		Point c = b.getCenter().getCopy();
		
		Point replytargetpoint = replysourcepoint.getCopy();
		replytargetpoint.setX(c.x);
		requestreplycreation.setLocation(replytargetpoint);
		replycommand = target.getCommand(requestreplycreation);	
		replycommand.execute();
	}


	/**
	 * @return the message from the given request, can return null
	 */
	private Message getMessage() {
		Message message=null;
		ConnectionViewAndElementDescriptor connectionViewAndElementDescriptor=request.getConnectionViewAndElementDescriptor();
		if( connectionViewAndElementDescriptor!=null){
			CreateElementRequestAdapter createElementRequestAdapter=connectionViewAndElementDescriptor.getCreateElementRequestAdapter();
			message=(Message)createElementRequestAdapter.getAdapter(Message.class);
		}
		return message;
	}
	
	/**
	 * retrieve preferences concerned with automatic creation of execution specifications
	 */
	private void retrievePreferences() {
		this.preference = "CHOICE_BEHAVIOR";
		this.type = null;
		IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		if (request.getConnectionViewAndElementDescriptor().getSemanticHint().equals(UMLDIElementTypes.MESSAGE_ASYNCH_EDGE.getSemanticHint())) {
			//for asynchronous messages
			this.preference = store.getString(CustomMessages.PREF_EXECUTION_SPECIFICATION_ASYNC_MSG);
		}
		if (request.getConnectionViewAndElementDescriptor().getSemanticHint().equals(UMLDIElementTypes.MESSAGE_SYNCH_EDGE.getSemanticHint())) {
			//for synchronous messages
			this.preference = store.getString(CustomMessages.PREF_EXECUTION_SPECIFICATION_SYNC_MSG);
		}		
		// case where a behavior execution specification must be created at target
		if ("CHOICE_BEHAVIOR".equals(preference) || "CHOICE_BEHAVIOR_AND_REPLY".equals(preference)) {
			this.type = UMLDIElementTypes.BEHAVIOR_EXECUTION_SPECIFICATION_SHAPE;			
		}
		// case where an action execution specification must be created at target
		if ("CHOICE_ACTION".equals(preference) || "CHOICE_ACTION_AND_REPLY".equals(preference)) {
			this.type = UMLDIElementTypes.ACTION_EXECUTION_SPECIFICATION_SHAPE;			
		}	
		// case where a message reply must also be created
		if ("CHOICE_BEHAVIOR_AND_REPLY".equals(preference) || "CHOICE_ACTION_AND_REPLY".equals(preference)) {
			this.createReply = true;
		}
	}

}
