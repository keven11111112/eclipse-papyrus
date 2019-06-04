/*****************************************************************************
 * Copyright (c) 2015, 2019 CEA LIST and others.
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
 *  Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Bug 517797
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.activity.dnd.behavior;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.TransactionalDropStrategy;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CallBehaviorActionEditPart;
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

	@Override
	public String getLabel() {
		return CustomMessages.BehaviorToCallBehaviorActionDropStrategy_Label;
	}

	@Override
	public String getDescription() {
		return CustomMessages.BehaviorToCallBehaviorActionDropStrategy_Description;
	}

	@Override
	public Image getImage() {
		return null;
	}

	@Override
	public String getID() {
		return UMLDiagramEditorPlugin.ID + ".operation.represents"; //$NON-NLS-1$
	}

	@Override
	protected Command doGetCommand(Request request, final EditPart targetEditPart) {
		// Step 1: check the environment

		// Step 1.1: The only supported case is "Drop a single element"
		List<EObject> sourceElements = getSourceEObjects(request);

		if (sourceElements.size() != 1) {
			return null;
		}
		final EObject sourceElement = sourceElements.get(0);

		// Step 1.2: The only supported case is Operation
		if (!(sourceElement instanceof Behavior)) {
			return null;
		}
		final Behavior behavior = (Behavior) sourceElement;

		// Step 1.3: The only supported case is Activity
		final EObject targetElement = getTargetSemanticElement(targetEditPart);
		if (!(targetElement instanceof org.eclipse.uml2.uml.Activity)) {
			return null;
		}
		final Activity activity = (Activity) targetElement;

		// Get the compartment edit part
		ActivityActivityContentCompartmentEditPart compartmentEditPart = null;
		Iterator<Object> children = targetEditPart.getChildren().iterator();
		while (children.hasNext() && null == compartmentEditPart) {
			Object child = children.next();
			if (child instanceof ActivityActivityContentCompartmentEditPart) {
				compartmentEditPart = (ActivityActivityContentCompartmentEditPart) child;
			}
		}
		final ActivityActivityContentCompartmentEditPart contentCompartmentEditPart = compartmentEditPart;

		// Step 2: create the commands
		// CompositeCommand to hold the commands
		CompositeCommand cc = new CompositeCommand(getLabel());

		ICommand editSlotsCommand = new CreateCallBehaviorAndUpdateCommand<CallBehaviorAction, Activity, Behavior>(targetEditPart, CallBehaviorAction.class, activity, behavior, false, UMLElementTypes.CALL_BEHAVIOR_ACTION) {

			/**
			 * @see org.eclipse.papyrus.uml.diagram.activity.dnd.behavior.CreateCallBehaviorAndUpdateCommand#updateNewlyCreatedEObjectWithEObjectDragged(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
			 *
			 * @param callBehaviorAction
			 * @param property
			 * @throws ExecutionException
			 */
			@Override
			public void updateNewlyCreatedEObjectWithEObjectDragged(CallBehaviorAction callBehaviorAction, Behavior property) throws ExecutionException {
				// Manage the super process
				super.updateNewlyCreatedEObjectWithEObjectDragged(callBehaviorAction, property);

				// If the content compartment edit part of the activity is visible, add the created CallBehaviorAction
				if (null != contentCompartmentEditPart) {
					// Get the location
					final Point location;
					if (request instanceof DropObjectsRequest) {
						location = ((DropObjectsRequest) request).getLocation();
					} else {
						location = new Point(100, 100);
					}

					// Create the view request, its associated command and execute it
					final ViewDescriptor descriptor = new ViewDescriptor(new EObjectAdapter(callBehaviorAction), Node.class, CallBehaviorActionEditPart.VISUAL_ID, ((IGraphicalEditPart) targetEditPart).getDiagramPreferencesHint());
					final CreateViewRequest createViewRequest = new CreateViewRequest(descriptor);
					createViewRequest.setLocation(location);
					final Command createViewCommand = contentCompartmentEditPart.getCommand(createViewRequest);
					if (null != createViewCommand) {
						createViewCommand.execute();
					}
				}
			}
		};
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
	@Deprecated
	@Override
	public int getPriority() {
		return 0;
	}

}

