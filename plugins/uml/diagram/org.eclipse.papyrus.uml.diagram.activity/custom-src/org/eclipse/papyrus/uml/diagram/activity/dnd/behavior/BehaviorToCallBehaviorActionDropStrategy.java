/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Francois Le Fevre (CEA LIST) francois.le-fevre@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.activity.dnd.behavior;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.TransactionalDropStrategy;
import org.eclipse.papyrus.uml.diagram.activity.part.CustomMessages;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallBehaviorAction;

/**
 * Class dedicated to the management of drag and drop of a Behavior (Functional etc..) into a Activity diagram to create automatically a callbehavor action
 *
 */
public class BehaviorToCallBehaviorActionDropStrategy extends TransactionalDropStrategy {

	public String getLabel() {
		return CustomMessages.BehaviorToCallBehaviorActionDropStrategy_Label; 
	}

	public String getDescription() {
		return CustomMessages.BehaviorToCallBehaviorActionDropStrategy_Description;
	}

	public Image getImage() {
		return null;
	}

	public String getID() {
		return UMLDiagramEditorPlugin.ID + ".operation.represents"; //$NON-NLS-1$
	}

	@Override
	protected Command doGetCommand(Request request, final EditPart targetEditPart) {
		//Step 1: check the environment

		//Step 1.1: The only supported case is "Drop a single element"
		List<EObject> sourceElements = getSourceEObjects(request);

		if (sourceElements.size() != 1) {
			return null;
		}
		final EObject sourceElement = sourceElements.get(0);

		//Step 1.2: The only supported case is Operation
		if (!(sourceElement instanceof Behavior)) {
			return null;
		}
		final Behavior behavior = (Behavior)sourceElement;

		//Step 1.3: The only supported case is Activity
		final EObject targetElement = getTargetSemanticElement(targetEditPart);
		if (!(targetElement instanceof org.eclipse.uml2.uml.Activity)) {
			return null;
		}
		final Activity activity = (Activity)targetElement;

		//Step 2: create the commands

		//CompositeCommand to hold the commands
		CompositeCommand cc = new CompositeCommand(getLabel());


		ICommand editSlotsCommand = new CreateCallBehaviorAndUpdateCommand<CallBehaviorAction, Activity, Behavior>(targetEditPart, CallBehaviorAction.class, activity, behavior, false, UMLElementTypes.CALL_BEHAVIOR_ACTION);
		if (editSlotsCommand != null) {
			cc.add(editSlotsCommand);
		}
		
		return cc.canExecute() ? new ICommandProxy(cc.reduce()) : null;

	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.DropStrategy#getPriority()
	 *
	 * @return
	 * @deprecated
	 */
	public int getPriority() {
		return 0;
	}
}

