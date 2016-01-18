/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Francois Le Fevre (CEA LIST)  - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.usecase.dnd.strategy;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.uml.diagram.usecase.dnd.cmd.UsecaseCommand;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.SubjectComponentUsecasesEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.messages.Messages;
import org.eclipse.papyrus.uml.diagram.usecase.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.UseCase;

/**
 * A strategy to drop a usecase on a subject into a usecase diagram.
 * @author Francois Le Fevre
 */
public class UsecaseToSubjectinUsecaseDiagramDropStrategy extends GraphicalTransactionalDropStrategy {

	protected EStructuralFeature feature;

	public String getLabel() {
		return Messages.UsecaseToSubjectinUsecaseDiagramDropStrategy_LABEL;
	}

	public String getID() {
		return UMLDiagramEditorPlugin.ID + ".usecase2SubjectInUsecaseDiagram"; //$NON-NLS-1$
	}

	public String getDescription() {
		return Messages.UsecaseToSubjectinUsecaseDiagramDropStrategy_DESCRIPTION;
	}

	public Image getImage() {
		return null;
	}

	public int getPriority() {
		return 0;
	}

	public void setOptions(Map<String, Object> options) {
		// Nothing
	}

	@Override
	public Command doGetCommand(Request request, final EditPart targetEditPart) {

		final UseCase sourceUsecase;
		final Classifier subject;

		List<EObject> sourceElements = getSourceEObjects(request);

		// The only supported case is "Drop a single usecase on a single subject"
		if (sourceElements.size() != 1) {
			return null;
		}

		EObject sourceElement = sourceElements.get(0);
		if (sourceElement instanceof UseCase) {
			sourceUsecase = (UseCase) sourceElement;
		}
		else{
			return null;
		}

		if(targetEditPart instanceof SubjectComponentUsecasesEditPart ){ //$NON-NLS-1$
			Classifier targetElement = (Classifier)getTargetSemanticElement(targetEditPart);
			if(targetElement==null){
				return null;
			}

			subject = targetElement;

			if(sourceUsecase.getSubjects().contains(subject)
					&& subject.getUseCases().contains(sourceUsecase)
					&& sourceUsecase.getOwner().equals(subject)){

				//just display usecase in the object
				CompositeCommand cc = new CompositeCommand(getLabel());

				Command graphicalCommand = getGraphicalCommand(request, targetEditPart);
				if (graphicalCommand != null) {
					cc.add(new CommandProxy(graphicalCommand));
				}
				return cc.canExecute() ? new ICommandProxy(cc.reduce()) : null;

			}
			else{
				//dialog box
				CompositeCommand cc = new CompositeCommand(getLabel());

				ICommand editSlotsCommand = getEditSlotsCommand(sourceUsecase,subject);
				if (editSlotsCommand != null) {
					cc.add(editSlotsCommand);
				}

				Command graphicalCommand = getGraphicalCommand(request, targetEditPart);
				if (graphicalCommand != null) {
					cc.add(new CommandProxy(graphicalCommand));
				}

				return cc.canExecute() ? new ICommandProxy(cc.reduce()) : null;
			}
		}

		return null;
	}

	protected ICommand getEditSlotsCommand(UseCase sourceUsecase, Classifier subject) {
		return new UsecaseCommand(sourceUsecase,subject);
	}

	public String getCategoryID() {
		return "org.eclipse.papyrus.dnd.usecaseToUsecaseSubject"; //$NON-NLS-1$
	}

	public String getCategoryLabel() {
		return "Drop a Usecase on an subject in a usecase diagram"; //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.usecase.dnd.strategy.GraphicalTransactionalDropStrategy#getViewDescriptors(org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest, org.eclipse.gef.EditPart)
	 *
	 * @param dropRequest
	 * @param targetEditPart
	 * @return
	 */
	@Override
	protected List<ViewDescriptor> getViewDescriptors(DropObjectsRequest dropRequest, EditPart targetEditPart) {
		List<CreateViewRequest.ViewDescriptor> viewDescriptors = new LinkedList<CreateViewRequest.ViewDescriptor>();

		for (EObject eObject : getSourceEObjects(dropRequest)) {
			if(eObject instanceof org.eclipse.uml2.uml.UseCase){
				viewDescriptors.add(new CreateViewRequest.ViewDescriptor(new EObjectAdapter(eObject), Node.class, UseCaseInComponentEditPart.VISUAL_ID, ((IGraphicalEditPart) targetEditPart).getDiagramPreferencesHint()));
			}
		}
		return viewDescriptors;
	}
}
