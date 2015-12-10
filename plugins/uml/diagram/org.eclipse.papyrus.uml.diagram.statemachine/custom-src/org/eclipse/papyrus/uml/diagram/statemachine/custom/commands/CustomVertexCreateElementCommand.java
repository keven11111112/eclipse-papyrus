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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.ElementInitializers;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.Vertex;

/**
 * Create a vertex (sub-state), used only in composition with region creation
 * in CustomStateCreationEditPolicy
 * TODO: create a more cleaner combination of region creation and state creation that behaves exactly like the state
 * creation. Current differences: there's no pop-up for editing its name, (2) positioning is always top-left.
 * => use unchanged StateCreateCommand instead
 */
@Deprecated
public class CustomVertexCreateElementCommand extends AbstractTransactionalCommand {

	IAdaptable adaptable;

	PreferencesHint prefHints;

	IHintedType hint;

	CreateViewRequest.ViewDescriptor viewDescriptor;

	CreateElementRequest createElementRequest;

	public CustomVertexCreateElementCommand(IAdaptable adaptable, IHintedType hint, PreferencesHint prefHints, TransactionalEditingDomain domain, String label) {
		super(domain, label, null);
		this.adaptable = adaptable;
		this.hint = hint;
		this.prefHints = prefHints;

		viewDescriptor = new ViewDescriptor(adaptable, prefHints);

		// make sure the return object is available even before
		// executing/undoing/redoing
		setResult(CommandResult.newOKCommandResult(viewDescriptor));

	}

	protected void doConfigure(Vertex newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
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
		View regionView = (View) adaptable.getAdapter(View.class);
		View compartment = (View) regionView.getChildren().get(0);
		// hack
		viewDescriptor = new ViewDescriptor(new SemanticAdapter(null, adaptable.getAdapter(EObject.class)), prefHints);

		Region owner = (Region) regionView.getElement();
		Vertex newVertex = null;
		if (hint.getSemanticHint().equals(((IHintedType) UMLElementTypes.FinalState_Shape).getSemanticHint())) {
			newVertex = UMLFactory.eINSTANCE.createFinalState();
			owner.getSubvertices().add(newVertex);
			ElementInitializers.getInstance().init_FinalState_Shape((FinalState) newVertex);
			createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.FinalState_Shape);
		} else if (hint.getSemanticHint().equals(((IHintedType) UMLElementTypes.State_Shape).getSemanticHint())) {
			newVertex = UMLFactory.eINSTANCE.createState();
			owner.getSubvertices().add(newVertex);
			ElementInitializers.getInstance().init_State_Shape((State) newVertex);
			createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.State_Shape);
		} else {
			newVertex = UMLFactory.eINSTANCE.createPseudostate();
			if (hint.getSemanticHint().equals(((IHintedType) UMLElementTypes.Pseudostate_InitialShape).getSemanticHint())) {
				owner.getSubvertices().add(newVertex);
				ElementInitializers.getInstance().init_Pseudostate_InitialShape((Pseudostate) newVertex);
				createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.Pseudostate_InitialShape);
			} else if (hint.getSemanticHint().equals(((IHintedType) UMLElementTypes.Pseudostate_JoinShape).getSemanticHint())) {
				owner.getSubvertices().add(newVertex);
				ElementInitializers.getInstance().init_Pseudostate_JoinShape((Pseudostate) newVertex);
				createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.Pseudostate_JoinShape);
			} else if (hint.getSemanticHint().equals(((IHintedType) UMLElementTypes.Pseudostate_ForkShape).getSemanticHint())) {
				owner.getSubvertices().add(newVertex);
				ElementInitializers.getInstance().init_Pseudostate_ForkShape((Pseudostate) newVertex);
				createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.Pseudostate_ForkShape);
			} else if (hint.getSemanticHint().equals(((IHintedType) UMLElementTypes.Pseudostate_ChoiceShape).getSemanticHint())) {
				owner.getSubvertices().add(newVertex);
				ElementInitializers.getInstance().init_Pseudostate_ChoiceShape((Pseudostate) newVertex);
				createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.Pseudostate_ChoiceShape);
			} else if (hint.getSemanticHint().equals(((IHintedType) UMLElementTypes.Pseudostate_JunctionShape).getSemanticHint())) {
				owner.getSubvertices().add(newVertex);
				ElementInitializers.getInstance().init_Pseudostate_JunctionShape((Pseudostate) newVertex);
				createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.Pseudostate_JunctionShape);
			} else if (hint.getSemanticHint().equals(((IHintedType) UMLElementTypes.Pseudostate_ShallowHistoryShape).getSemanticHint())) {
				owner.getSubvertices().add(newVertex);
				ElementInitializers.getInstance().init_Pseudostate_ShallowHistoryShape((Pseudostate) newVertex);
				createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.Pseudostate_ShallowHistoryShape);
			} else if (hint.getSemanticHint().equals(((IHintedType) UMLElementTypes.Pseudostate_DeepHistoryShape).getSemanticHint())) {
				owner.getSubvertices().add(newVertex);
				ElementInitializers.getInstance().init_Pseudostate_DeepHistoryShape((Pseudostate) newVertex);
				createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.Pseudostate_DeepHistoryShape);
			} else if (hint.getSemanticHint().equals(((IHintedType) UMLElementTypes.Pseudostate_TerminateShape).getSemanticHint())) {
				owner.getSubvertices().add(newVertex);
				ElementInitializers.getInstance().init_Pseudostate_TerminateShape((Pseudostate) newVertex);
				createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.Pseudostate_TerminateShape);
			} else if (hint.getSemanticHint().equals(((IHintedType) UMLElementTypes.Pseudostate_EntryPointShape).getSemanticHint())) {
				((State) owner.eContainer()).getConnectionPoints().add((Pseudostate) newVertex);
				ElementInitializers.getInstance().init_Pseudostate_EntryPointShape((Pseudostate) newVertex);
				createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.Pseudostate_EntryPointShape);
			} else if (hint.getSemanticHint().equals(((IHintedType) UMLElementTypes.Pseudostate_ExitPointShape).getSemanticHint())) {
				((State) owner.eContainer()).getConnectionPoints().add((Pseudostate) newVertex);
				ElementInitializers.getInstance().init_Pseudostate_ExitPointShape((Pseudostate) newVertex);
				createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.Pseudostate_ExitPointShape);
			}
		}

		doConfigure(newVertex, monitor, info);

		// create a view for the new vertex on the regionCompartment
		IAdaptable newVertexAdapatable = new SemanticAdapter(newVertex, null);

		// see below
		// View newVertexView;

		if (hint.getSemanticHint().equals(((IHintedType) UMLElementTypes.Pseudostate_EntryPointShape).getSemanticHint()) || hint.getSemanticHint().equals(((IHintedType) UMLElementTypes.Pseudostate_ExitPointShape).getSemanticHint())) {
			// newVertexView =
			ViewService.getInstance().createNode(newVertexAdapatable, (View) regionView.eContainer().eContainer(), hint.getSemanticHint(), -1, prefHints);
		} else {
			// newVertexView =
			ViewService.getInstance().createNode(newVertexAdapatable, compartment, hint.getSemanticHint(), -1, prefHints);

		}
		// removed viewDescriptor.setView: problematic since region can be moved along with state immediately after creation along with state
		// can cause bug 397730
		// viewDescriptor.setView(newVertexView);

		return CommandResult.newOKCommandResult(viewDescriptor);
	}

}
