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
import org.eclipse.papyrus.uml.service.types.utils.SequenceRequestConstant;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;

public class LifelineMessageDeleteHelper {

	
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
