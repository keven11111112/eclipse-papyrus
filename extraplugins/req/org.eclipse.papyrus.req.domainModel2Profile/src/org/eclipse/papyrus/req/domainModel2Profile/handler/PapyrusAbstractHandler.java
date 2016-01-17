/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
*     CEA LIST. - initial API and implementation
*******************************************************************************/
package org.eclipse.papyrus.req.domainModel2Profile.handler;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.ui.util.ServiceUtilsForHandlers;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Element;

/**
 * Abstract handler in order to do the connection with Papyrus
 *
 */
public abstract class PapyrusAbstractHandler extends AbstractHandler {

	protected TransactionalEditingDomain transactionalEditingDomain = null;
	protected IMultiDiagramEditor papyrusEditor;


	/**
	 * install element of Papyrus in order to execute commands
	 * 
	 * @param event
	 *            the context of the execution
	 */
	protected void setPapyrusEnvironment(ExecutionEvent event) {
		// look for papyrus
		try {
			papyrusEditor = ServiceUtilsForHandlers.getInstance().getService(IMultiDiagramEditor.class, event);
			transactionalEditingDomain = ServiceUtilsForHandlers.getInstance().getService(org.eclipse.emf.transaction.TransactionalEditingDomain.class, event);

		} catch (ServiceException ex) {
			System.err.println(ex);
		}
	}

	/**
	 * getSelected element in the diagram or in the model explorer
	 * 
	 * @return Element or null
	 */
	protected Element getSelection() {
		org.eclipse.uml2.uml.Element selectedElement = null;
		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
		ISelection selection = selectionService.getSelection();
		// look for papyrus
		if (selection instanceof IStructuredSelection) {
			Object selectedobject = ((IStructuredSelection) selection).getFirstElement();
			if (selectedobject instanceof GraphicalEditPart) {
				Object graphicalElement = ((GraphicalEditPart) selectedobject).getModel();
				if ((graphicalElement instanceof View) && ((View) graphicalElement).getElement() instanceof org.eclipse.uml2.uml.Element) {
					selectedElement = (org.eclipse.uml2.uml.Element) ((View) graphicalElement).getElement();
				}
			} else if (selectedobject instanceof IAdaptable) {
				EObject selectedEObject = ((IAdaptable) selectedobject).getAdapter(EObject.class);
				if (selectedEObject instanceof org.eclipse.uml2.uml.Element) {
					selectedElement = (Element) selectedEObject;
				}
			}
		}
		return selectedElement;
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		setPapyrusEnvironment(event);
		return null;
	}

	/**
	 * getSelected element in the diagram or in the model explorer
	 * 
	 * @return Element or null
	 */
	protected ArrayList<Element> getSelectionSet() {
		ArrayList<Element> selectedSet = new ArrayList<Element>();
		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
		ISelection selection = selectionService.getSelection();


		if (selection instanceof IStructuredSelection) {
			@SuppressWarnings("rawtypes")
			Iterator selectedobjectIteractor = ((IStructuredSelection) selection).iterator();
			while (selectedobjectIteractor.hasNext()) {
				Object currentSelection = selectedobjectIteractor.next();
				if (currentSelection instanceof GraphicalEditPart) {
					Object graphicalElement = ((GraphicalEditPart) currentSelection).getModel();
					if ((graphicalElement instanceof View) && ((View) graphicalElement).getElement() instanceof org.eclipse.uml2.uml.Element) {
						selectedSet.add((org.eclipse.uml2.uml.Element) ((View) graphicalElement).getElement());
					}
				} else if (currentSelection instanceof IAdaptable) {
					EObject selectedEObject = ((IAdaptable) currentSelection).getAdapter(EObject.class);
					if (selectedEObject instanceof org.eclipse.uml2.uml.Element) {
						selectedSet.add((Element) selectedEObject);
					}
				}
			}


		}
		return selectedSet;
	}
}

