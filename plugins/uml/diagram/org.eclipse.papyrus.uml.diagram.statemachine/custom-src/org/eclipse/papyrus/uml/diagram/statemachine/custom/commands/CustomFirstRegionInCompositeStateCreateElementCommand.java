/**
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.statemachine.custom.commands;

import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.adapter.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.helpers.Zone;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.RegionEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateNameEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.ElementInitializers;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Create a region (UML and associated view)
 */
public class CustomFirstRegionInCompositeStateCreateElementCommand extends AbstractTransactionalCommand {
	IAdaptable adaptable;
	IAdaptable adaptableForDropped = null;
	PreferencesHint prefHints;
	CreateViewRequest.ViewDescriptor viewDescriptor;
	CreateElementRequest createElementRequest;
	String dropLocation = Zone.NONE;
	
	/**
	 * An existing UML region
	 */
	protected Region umlRegion;
	
	public CustomFirstRegionInCompositeStateCreateElementCommand(IAdaptable adaptable, IAdaptable adaptableForDropped, PreferencesHint prefHints, TransactionalEditingDomain domain, String label, String dropLocation) {
		super(domain, label, null);
		this.adaptable = adaptable;
		this.adaptableForDropped = adaptableForDropped;
		this.prefHints = prefHints;
		viewDescriptor = new ViewDescriptor(adaptable, prefHints);
		// make sure the return object is available even before
		// executing/undoing/redoing
		setResult(CommandResult.newOKCommandResult(viewDescriptor));
		this.dropLocation = dropLocation;
		umlRegion = null;
	}

	/**
	 * Pass an existing (semantic) region. In this case, no new region is created during command
	 * execution, only the view is passed. 
	 * @param umlRegion an existing semantic region
	 */
	public void useExistingRegion(Region umlRegion) {
		this.umlRegion = umlRegion; 
	}
	
	@Override
	public boolean canExecute() {
		View compartment = (View) adaptable.getAdapter(View.class);
		if (compartment.getChildren().isEmpty()) {
			View owner = (View) compartment.eContainer();
			State state = (State) owner.getElement();
			if (state.getSubmachine() == null) {
				return true;
			}
		}
		return false;
	}

	protected void doConfigure(Region newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = createElementRequest.getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(createElementRequest.getClientContext());
		configureRequest.addParameters(createElementRequest.getParameters());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if (configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// adapt the view at execution time
		View compartment = adaptable.getAdapter(View.class);
		View ownerView = (View) compartment.eContainer();
		// get state bounds
		int height = Zone.getHeight(ownerView);
		int width = Zone.getWidth(ownerView);
		if (height < Zone.defaultHeight) {
			height = Zone.defaultHeight;
			Zone.setHeight(ownerView, height);
		}
		if (width < Zone.defaultWidth) {
			width = Zone.defaultWidth;
			Zone.setWidth(ownerView, width);
		}
	
		if (adaptableForDropped == null) {
			if (umlRegion == null) {
				umlRegion = UMLFactory.eINSTANCE.createRegion();
				createElementRequest = new CreateElementRequest(getEditingDomain(), ownerView, UMLElementTypes.Region_Shape);
				State umlState = (State) ownerView.getElement();
				umlState.getRegions().add(umlRegion);
				ElementInitializers.getInstance().init_Region_Shape(umlRegion);
				doConfigure(umlRegion, monitor, info);
			}
			adaptableForDropped = new SemanticAdapter(umlRegion, null);
		}
		// create a view for the new region on the stateMachineCompartment
		String semanticHint = ((IHintedType) UMLElementTypes.Region_Shape).getSemanticHint();

		View newRegion = ViewService.getInstance().createNode(adaptableForDropped, compartment, semanticHint, -1, prefHints);
		// add region specific annotation
		Zone.createRegionDefaultAnnotation(newRegion);
		// adjust bounds and zone
		Iterator<?> it = ownerView.getChildren().iterator();
		while (it.hasNext()) {
			Object next = it.next();
			if (next instanceof Node) {
				Node currentNode = (Node) next;
				if (currentNode.getLayoutConstraint() == null) {
					currentNode.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
				}
				if (StateNameEditPart.VISUAL_ID.equals(UMLVisualIDRegistry.getVisualID(currentNode.getType()))) {
					Zone.setWidth(currentNode, width);
					Zone.setHeight(currentNode, Zone.defaultHeader);
				} else if (StateCompartmentEditPart.VISUAL_ID.equals(UMLVisualIDRegistry.getVisualID(currentNode.getType()))) {
					Zone.setY(currentNode, Zone.defaultHeader);
					Zone.setWidth(currentNode, width);
					Zone.setHeight(currentNode, height - Zone.defaultHeader);
					Iterator<?> subit = currentNode.getChildren().iterator();
					while (subit.hasNext()) {
						Object subnext = subit.next();
						if (subnext instanceof Node) {
							Node subCurrentNode = (Node) subnext;
							if (subCurrentNode.getLayoutConstraint() == null) {
								subCurrentNode.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
							}
							if (RegionEditPart.VISUAL_ID.equals(UMLVisualIDRegistry.getVisualID(subCurrentNode.getType()))) {
								Zone.setWidth(subCurrentNode, width);
								Zone.setHeight(subCurrentNode, height - Zone.defaultHeader);
							}
						}
					}
				}
			}
		}
		viewDescriptor.setView(newRegion);
		// do not return the view descriptor. Otherwise, the region edit part is seen as result of composite commands that
		// create a sub-vertex within the first region (see AspectUnspecifiedTypeCreationTool). In turn, the region instead
		// of the new vertex is selected (implying no name edit prompt for the new vertex).
		return CommandResult.newOKCommandResult(null);
	}
}
