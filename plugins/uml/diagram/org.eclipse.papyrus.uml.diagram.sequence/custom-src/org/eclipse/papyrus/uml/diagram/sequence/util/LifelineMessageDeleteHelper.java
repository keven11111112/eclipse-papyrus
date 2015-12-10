/*****************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Alex Paperno - bug 444956
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.util;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gef.requests.TargetRequest;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionEndsCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.papyrus.uml.diagram.sequence.command.ChangeEdgeTargetCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.CreateElementAndNodeCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DestructionOccurrenceSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;

public class LifelineMessageDeleteHelper {

	public static Command getReconnectMessageDeleteTargetCommand(ReconnectRequest request, Command command) {
		GraphicalEditPart oldTarget = (GraphicalEditPart) request.getConnectionEditPart().getTarget();
		TransactionalEditingDomain editingDomain = oldTarget.getEditingDomain();
		EditPart targetEP = request.getTarget();
		CreateElementAndNodeCommand createDosCommand = getCreateNewDosCommand(request.getLocation(), editingDomain, targetEP, oldTarget);
		if (createDosCommand == null) {
			return UnexecutableCommand.INSTANCE;
		}
		command = command.chain(new ICommandProxy(createDosCommand));
		ChangeEdgeTargetCommand changeTargetCommand = new ChangeEdgeTargetCommand(editingDomain, createDosCommand, (Edge)request.getConnectionEditPart().getModel(), "(0.5, 1.0)");
		command = command.chain(new ICommandProxy(changeTargetCommand));
		return command;
	}
	
	public static Command getAttachToNewDosCommand(Command command, CreateConnectionViewAndElementRequest viewRequest, TransactionalEditingDomain editingDomain, EditPart targetEP, EditPart hostEP) {
		CreateElementAndNodeCommand createDosCommand = getCreateNewDosCommand(viewRequest.getLocation(), editingDomain, targetEP, hostEP);
		if (createDosCommand == null) {
			return UnexecutableCommand.INSTANCE;
		}
		command = command.chain(new ICommandProxy(createDosCommand));
		ChangeEdgeTargetCommand changeTargetCommand = new ChangeEdgeTargetCommand(editingDomain, createDosCommand, viewRequest.getConnectionViewDescriptor(), "(0.5, 1.0)");
		command = command.chain(new ICommandProxy(changeTargetCommand));
		// Set Edge.Target to the target lifeline
		command = command.chain(LifelineMessageDeleteHelper.getSetEdgeTargetCommand(viewRequest, editingDomain));
		return command;
	}
	
	private static CreateElementAndNodeCommand getCreateNewDosCommand(Point location, TransactionalEditingDomain editingDomain, EditPart targetEP, EditPart hostEP) {
		// target is either Lifeline or CustomBehaviorExecutionSpecificationEditPart, get Lifeline in the later case
		if (targetEP instanceof AbstractExecutionSpecificationEditPart) {
			targetEP = ((AbstractExecutionSpecificationEditPart)targetEP).getParent();
		}
		if (false == targetEP instanceof LifelineEditPart) {
			return null;
		}
		LifelineEditPart lifelineEP = (LifelineEditPart) targetEP;
		// Check if a DOS exists already
 		Lifeline lifeline = (Lifeline) lifelineEP.resolveSemanticElement();
 		EList<InteractionFragment> coveredBys = lifeline.getCoveredBys();
 		for (InteractionFragment interactionFragment : coveredBys) {
 			if (interactionFragment instanceof DestructionOccurrenceSpecification) {
 				return null;
 			}
 		}
 		// Create new DOS at coords from request
 		IHintedType hintType = (IHintedType) UMLElementTypes.DestructionOccurrenceSpecification_Shape;
		InteractionFragment ift = SequenceUtil.findInteractionFragmentContainerAt(location, hostEP);
		CreateElementAndNodeCommand createDosCommand = new CreateElementAndNodeCommand(editingDomain, lifelineEP, lifeline, hintType, location);
		createDosCommand.putCreateElementRequestParameter(SequenceRequestConstant.INTERACTIONFRAGMENT_CONTAINER, ift);
		return createDosCommand;
	}
	
	public static void setMessageEndDos(Message message, DestructionOccurrenceSpecification dos) {
		MessageEnd oldMessageEnd = message.getReceiveEvent();
		dos.setMessage(message);
		message.setReceiveEvent(dos);
		if (oldMessageEnd != null) {
			oldMessageEnd.setMessage(null);
			// Destroy orphan MessageOccurrenceSpecification
			if (oldMessageEnd instanceof MessageOccurrenceSpecification) {
				DestroyElementCommand.destroy(oldMessageEnd);
			}
		}
	}
	
	/*
	 * Set edge.target to the target lifeline
	 */
	public static Command getSetEdgeTargetCommand(TargetRequest request, TransactionalEditingDomain editingDomain) {
		if (request instanceof ReconnectRequest) {
			ReconnectRequest reconnectRequest = (ReconnectRequest) request;
			EditPart targetEP = reconnectRequest.getTarget().getParent();
			SetConnectionEndsCommand sceCommand = new SetConnectionEndsCommand(editingDomain, StringStatics.BLANK);
			sceCommand.setEdgeAdaptor(new EObjectAdapter((EObject) reconnectRequest.getConnectionEditPart().getModel()));
			sceCommand.setNewTargetAdaptor(targetEP);
			return new ICommandProxy(sceCommand);
		} else if (request instanceof CreateConnectionViewAndElementRequest) {
			CreateConnectionViewAndElementRequest createRequest = (CreateConnectionViewAndElementRequest) request;
			EditPart targetEP = createRequest.getTargetEditPart();
			if (targetEP instanceof DestructionOccurrenceSpecificationEditPart) {
				targetEP = targetEP.getParent();
			}
			SetConnectionEndsCommand sceCommand = new SetConnectionEndsCommand(editingDomain, StringStatics.BLANK);
			sceCommand.setEdgeAdaptor(createRequest.getConnectionViewDescriptor());
			sceCommand.setNewTargetAdaptor(targetEP);
			return new ICommandProxy(sceCommand);
		}			
		return null;		
	}
}
