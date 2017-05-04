/*****************************************************************************
 * Copyright (c) 2014, 2016 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 508404
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IDiagramPreferenceSupport;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard;
import org.eclipse.papyrus.infra.core.internal.clipboard.CopierFactory;
import org.eclipse.papyrus.infra.gmfdiag.common.service.visualtype.VisualTypeService;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.CopyPasteUtil;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;


/**
 * this command is used to wrap a copy command. it allows set a new owner for views.
 */
public class DefaultDiagramPasteCommand extends AbstractTransactionalCommand {



	/** the new container for the shape */
	protected View container = null;

	protected List<EObject> semanticList = new ArrayList<EObject>();

	protected List<EObject> viewList = new ArrayList<EObject>();

	protected ICommand editCommand;

	private CompoundCommand allDropCommand;

	private GraphicalEditPart targetEditPart;

	private List<EObject> objectToDrop;

	/**
	 * Constructor.
	 *
	 * @param editingDomain
	 * @param label
	 * @param papyrusClipboard
	 * @param subCommand
	 * @param container
	 */
	public DefaultDiagramPasteCommand(TransactionalEditingDomain editingDomain, String label, PapyrusClipboard<Object> papyrusClipboard, GraphicalEditPart targetEditPart) {
		super(editingDomain, label, null);
		this.container = (View) targetEditPart.getModel();
		this.targetEditPart = targetEditPart;

		EcoreUtil.Copier copier = new CopierFactory(editingDomain.getResourceSet()).get();

		List<EObject> rootElementInClipboard = EcoreUtil.filterDescendants(CopyPasteUtil.filterEObject(papyrusClipboard));
		copier.copyAll(rootElementInClipboard);
		copier.copyReferences();
		viewList.addAll(EcoreUtil.filterDescendants(copier.values()));
		for (Object eObject : rootElementInClipboard) {
			if (!(eObject instanceof View)) {
				viewList.remove(copier.get(eObject));
				semanticList.add(copier.get(eObject));
			}
		}

		// Inform the clipboard of the element created (used by strategies)
		Map<Object, EObject> transtypeCopier = CopyPasteUtil.transtypeCopier(copier);
		papyrusClipboard.addAllInternalToTargetCopy(transtypeCopier);
		List<EObject> semanticRootList = EcoreUtil.filterDescendants(semanticList);
		MoveRequest moveRequest = new MoveRequest(container.getElement(), semanticRootList);

		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(container.getElement());
		if (provider != null) {
			editCommand = provider.getEditCommand(moveRequest);
		}
		if (!papyrusClipboard.getContainerType().equals(targetEditPart.getNotationView().getDiagram().getType()) || viewList.isEmpty()) {
			this.objectToDrop = semanticRootList;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		editCommand.execute(progressMonitor, info);
		if (this.objectToDrop != null) { // try to drop the views
			constructDropRequest(targetEditPart, this.objectToDrop);
			if (allDropCommand != null && !allDropCommand.isEmpty()) {
				allDropCommand.execute();
			}
		} else if (viewList != null && !viewList.isEmpty()) {
			createAndShiftViews(targetEditPart, viewList);
		}
		return editCommand.getCommandResult();
	}


	/**
	 * Construct the drop request
	 *
	 * @param targetEditPart
	 * @param objectToDrop
	 */
	protected void constructDropRequest(GraphicalEditPart targetEditPart, List<EObject> objectToDrop) {
		DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
		if (container instanceof Diagram) {
			Point cursorPosition = CopyPasteUtil.getCursorPosition(targetEditPart);
			allDropCommand = new CompoundCommand("Drop all semantics elements on diagram"); //$NON-NLS-1$
			for (EObject eObject : objectToDrop) {
				dropObjectsRequest.setObjects(Collections.singletonList(eObject));
				dropObjectsRequest.setLocation(cursorPosition);
				Command command = targetEditPart.getCommand(dropObjectsRequest);
				allDropCommand.add(command);
				cursorPosition = CopyPasteUtil.shiftLayout(cursorPosition);
			}
		} else if (!(container instanceof Diagram)) {
			Rectangle bounds = targetEditPart.getFigure().getBounds();
			Point center = bounds.getCenter();
			allDropCommand = new CompoundCommand("Drop all semantics elements on a view"); //$NON-NLS-1$
			dropObjectsRequest.setObjects(objectToDrop);
			dropObjectsRequest.setLocation(center);
			Command command = targetEditPart.getCommand(dropObjectsRequest);
			if (command == null) {
				command = CopyPasteUtil.lookForCommandInSubContainer(targetEditPart, objectToDrop);
			}
			allDropCommand.add(command);
		}
	}





	/**
	 * Create and shift the layout of all duplicate Views
	 *
	 * @param values
	 */
	// TODO : move it in a View utility class
	private void createAndShiftViews(GraphicalEditPart targetEditPart, Collection<EObject> values) {
		// Collection values = duplicatedObject.values();
		Iterator<EObject> iterator = values.iterator();
		// for each view, a create view command is executed
		// if this is a shape a new position is set in order to avoid overlap
		while (iterator.hasNext()) {
			Object object = iterator.next();
			if (object instanceof View) {
				View duplicatedView = (View) object;
				if (object instanceof Shape) {
					LayoutConstraint layoutConstraint = ((Shape) object).getLayoutConstraint();
					if (layoutConstraint instanceof Bounds) {
						((Bounds) layoutConstraint).setX(((Bounds) layoutConstraint).getX() + CopyPasteUtil.DEFAULT_AVOID_SUPERPOSITION_X);
						((Bounds) layoutConstraint).setY(((Bounds) layoutConstraint).getY() + CopyPasteUtil.DEFAULT_AVOID_SUPERPOSITION_Y);
					}
				}
				if (duplicatedView.eContainer() == null && targetEditPart != null) {

					// ViewUtil.insertChildView is very dangerous it inserts the view without any verification
					// it is preferable to create a view request and see if the UMLProvider allows the view creation

					// ViewUtil.insertChildView(container, duplicatedView, ViewUtil.APPEND, true);

					Command command = createViewCommand(targetEditPart, duplicatedView);
					if (command != null && command.canExecute()) {
						command.execute();
					} else {
						GraphicalEditPart subtargetEditPart = CopyPasteUtil.lookForTargetEditPart(targetEditPart, duplicatedView);
						command = createViewCommand(subtargetEditPart, duplicatedView);
						if (command != null && command.canExecute()) {
							command.execute();
						}
					}
				}
			}
		}
	}



	/**
	 * 
	 * @param editpart
	 * @param duplicatedView
	 * @return
	 */
	private Command createViewCommand(IGraphicalEditPart editpart, View duplicatedView) {

		IAdaptable adapter = new EObjectAdapter(duplicatedView.getElement());
		PreferencesHint prefs = ((IDiagramPreferenceSupport) targetEditPart.getRoot()).getPreferencesHint();
		String visualid = null;
		ViewDescriptor descriptor = null;
		visualid = VisualTypeService.getInstance().getNodeType((View) editpart.getModel(), duplicatedView.getElement());
		descriptor = new ViewDescriptor(adapter, Node.class, visualid, prefs);		
		CreateViewRequest request = new CreateViewRequest(descriptor);
		Command command = editpart.getCommand(request);

		return command;
	}





}
