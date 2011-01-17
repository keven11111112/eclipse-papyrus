/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.adaptor.gmf;

import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.BusinessModelResolver;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

/**
 * Command creating a new GMF diagram in Papyrus. This command is intended to be used in eclipse
 * extensions.
 * 
 * Commands to create a GMF Diagram can subclass this class. There is two kinds of commands: -
 * Eclipse handlers issuing commands (toolbar, menu, ...). This commands can find the active editor
 * by using the Worbench.getActivePArt(). The entry point is {@link #execute(ExecutionEvent)}. -
 * Commands called during editor initializing (like wizard). This commands require the diResourceSet
 * to work. The entry point is {@link #createDiagram(DiResourceSet, EObject, String)}
 * 
 * @author cedric dumoulin
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public abstract class AbstractPapyrusGmfCreateDiagramCommandHandler extends AbstractHandler implements IHandler, ICreationCommand {

	/**
	 * Method called when the command is invoked.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		EObject container = null;
		// if editor is open and active
		if(getMultiDiagramEditor() != null) {
			container = getSelectedElement();
		}
		runAsTransaction(container);
		return null;
	}

	/**
	 * Create a new class diagram
	 * 
	 * @param sharedObjects
	 * @param container
	 *        The uml element to which the diagram should be attached, if possible.
	 * @throws ExecutionException
	 */
	protected void runAsTransaction(EObject container) throws ExecutionException {

		DiResourceSet diResourceSet;
		try {
			diResourceSet = EditorUtils.getServiceRegistry().getService(DiResourceSet.class);
		} catch (ServiceException e) {
			throw new ExecutionException("Can't get diResourceSet", e);
		}

		runAsTransaction(diResourceSet, container, null);
	}

	/**
	 * Create a new gmf diagram
	 * 
	 * @param sharedObjects
	 * @param container
	 *        The eObject to which the diagram should be attached, if possible.
	 */
	protected void runAsTransaction(final DiResourceSet diResourceSet, final EObject container, String name) {
		try {
			CompositeCommand cmd = new CompositeCommand("Create diagram");
			ICommand createCmd = getCreateDiagramCommand(diResourceSet, container, name);
			cmd.add(createCmd);
			cmd.add(new OpenDiagramCommand(diResourceSet.getTransactionalEditingDomain(), createCmd));

			OperationHistoryFactory.getOperationHistory().execute(cmd, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
			Activator.getInstance().logError(Messages.AbstractPapyrusGmfCreateDiagramCommandHandler_UnableCreateModelAndDiagram, e);
		}
	}

	/**
	 * Get the root element associated with canvas.
	 */
	protected EObject getRootElement(Resource modelResource) {
		EObject rootElement = null;
		if(modelResource != null && modelResource.getContents() != null && modelResource.getContents().size() > 0) {
			Object root = modelResource.getContents().get(0);
			if(root instanceof EObject) {
				rootElement = (EObject)root;
			}
		}

		return rootElement;
	}

	/**
	 * Store model element in the resource.
	 */
	protected void attachModelToResource(EObject root, Resource resource) {
		resource.getContents().add(root);
	}

	/**
	 * @return
	 */
	abstract protected String getDiagramNotationID();

	/**
	 * @return
	 */
	abstract protected PreferencesHint getPreferenceHint();

	/**
	 * Get the name used for diagram.
	 * 
	 * @return
	 */
	abstract protected String getDefaultDiagramName();

	/**
	 * Get currently selected element.
	 * 
	 * @return The currently selected element, or null if any.
	 */
	protected EObject getSelectedElement() {
		EObject eObject = null;
		Object selection = getCurrentSelection();
		if(selection != null) {
			Object businessObject = BusinessModelResolver.getInstance().getBusinessModel(selection);
			if(businessObject instanceof EObject) {
				eObject = (EObject)businessObject;
			}
		}
		return eObject;
	}

	/**
	 * Get current selection first element.
	 * 
	 * @return the selected element or null.
	 */
	private Object getCurrentSelection() {
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			return structuredSelection.getFirstElement();
		}

		return null;
	}

	/**
	 * Create a diagram.
	 * 
	 * @param diagramResource
	 *        the diagram resource
	 * @param owner
	 *        the diagram container
	 * @param name
	 *        the diagram name
	 * @return
	 */
	protected Diagram createDiagram(Resource diagramResource, EObject owner, String name) {
		// create diagram
		Diagram diagram = ViewService.createDiagram(owner, getDiagramNotationID(), getPreferenceHint());
		if(diagram != null) {
			diagram.setName(name);
			diagram.setElement(owner);
			initializeDiagram(diagram);
			diagramResource.getContents().add(diagram);
		}
		return diagram;
	}

	protected void initializeDiagram(EObject diagram) {
	};

	/**
	 * Get the current MultiDiagramEditor.
	 * 
	 * @return
	 */
	protected IMultiDiagramEditor getMultiDiagramEditor() {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart editorPart = page.getActiveEditor();
		return (IMultiDiagramEditor)editorPart;
	}

	/**
	 * Open popup to enter the new diagram name
	 * 
	 * @param defaultValue
	 *        the default value
	 * @return the entered diagram name
	 */
	protected String openDiagramNameDialog(final String defaultValue) {
		InputDialog inputDialog = new InputDialog(Display.getCurrent().getActiveShell(), Messages.AbstractPapyrusGmfCreateDiagramCommandHandler_SelectNewDiagramName, Messages.AbstractPapyrusGmfCreateDiagramCommandHandler_NewDiagramName, defaultValue, null) {

			@Override
			protected void createButtonsForButtonBar(Composite parent) {
				super.createButtonsForButtonBar(parent);
				getCancelButton().setEnabled(false);
			}

		};

		inputDialog.open();

		String name = inputDialog.getValue();
		if(name == null || name.length() == 0) {
			name = defaultValue;
		}
		return name;
	}

	/**
	 * {@inheritDoc}
	 */
	public void createDiagram(final DiResourceSet diResourceSet, final EObject container, final String diagramName) {
		TransactionalEditingDomain transactionalEditingDomain = diResourceSet.getTransactionalEditingDomain();
		RecordingCommand command = new RecordingCommand(transactionalEditingDomain) {

			@Override
			protected void doExecute() {
				runAsTransaction(diResourceSet, container, diagramName);
			}
		};
		transactionalEditingDomain.getCommandStack().execute(command);
	}

	/**
	 * {@inheritDoc}
	 */
	public ICommand getCreateDiagramCommand(final DiResourceSet diResourceSet, final EObject container, final String diagramName) {
		// Get the uml element to which the newly created diagram will be attached.
		// Create the diagram

		return new AbstractTransactionalCommand(diResourceSet.getTransactionalEditingDomain(), Messages.AbstractPapyrusGmfCreateDiagramCommandHandler_CreateDiagramCommandLabel, Collections.EMPTY_LIST) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				Resource modelResource = diResourceSet.getAssociatedModelResource(container, true);
				Resource notationResource = diResourceSet.getAssociatedNotationResource(container, true);
				Resource diResource = diResourceSet.getAssociatedDiResource(container, true);

				String name;
				if(diagramName == null) {
					name = openDiagramNameDialog(getDefaultDiagramName());
				} else {
					name = diagramName;
				}

				CommandResult commandResult = CommandResult.newErrorCommandResult("Error during diagram creation");
				EObject model = container;
				if(model == null) {
					model = getRootElement(modelResource);
					attachModelToResource(model, modelResource);
				}

				Diagram diagram = createDiagram(notationResource, model, name);

				if(diagram != null) {
					IPageMngr pageMngr = EditorUtils.getIPageMngr(diResource);
					pageMngr.addPage(diagram);
					commandResult = CommandResult.newOKCommandResult(diagram);
				}
				return commandResult;
			}
		};
	}

	/**
	 * Get the ServiceRegistry of the main editor.
	 * 
	 * @return
	 */
	protected ServicesRegistry getServiceRegistry() {
		return EditorUtils.getServiceRegistry();
	}

	/**
	 * Get the ISashWindowsContentProvider from the main editor.
	 * 
	 * @return
	 */
	protected ISashWindowsContentProvider getISashWindowsContentProvider() {
		return EditorUtils.getISashWindowsContentProvider();

	}

}
