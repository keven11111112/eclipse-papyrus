/*****************************************************************************
 * Copyright (c) 2018 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Pauline DEVILLE (CEA LIST) - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.toolsmiths.profilemigration.internal.handler;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.onefile.model.ISubResourceFile;
import org.eclipse.papyrus.toolsmiths.profilemigration.Activator;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;

public class ProfileMigrationToolHandler extends AbstractHandler implements IHandler {

	private static final String MODEL_FILE_EXTENSION = "di"; //$NON-NLS-1$

	private static final String DOT = "."; //$NON-NLS-1$

	/**
	 * Open the di file using the ProfileMigrationToolService
	 * 
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 *
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ProfileMigrationToolService.isUsingProfileMigrationTool = true;
		// Get current selection
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		File file = getFileFromSelection(currentSelection);

		String filePath = file.getAbsolutePath();
		String diFilePath = filePath.substring(0, filePath.lastIndexOf(DOT)) + DOT + MODEL_FILE_EXTENSION; // $NON-NLS-1$ //$NON-NLS-2$

		File fileToOpen = new File(diFilePath);
		if (fileToOpen.exists() && fileToOpen.isFile()) {
			IFileStore fileStore = EFS.getLocalFileSystem().getStore(fileToOpen.toURI());
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

			try {
				IDE.openEditorOnFileStore(page, fileStore);
			} catch (PartInitException e) {
				// Put your exception handler here if you wish to
			}
		} else {
			// Do something if the file does not exist
		}
		return null;
	}

	private File getFileFromSelection(ISelection selection) {
		IFile target_file = null;
		if (selection != null & selection instanceof IStructuredSelection) {
			IStructuredSelection strucSelection = (IStructuredSelection) selection;

			if (!strucSelection.isEmpty() && strucSelection.getFirstElement() instanceof ISubResourceFile) {
				target_file = ((ISubResourceFile) strucSelection.getFirstElement()).getFile();
			} else if (!strucSelection.isEmpty() && strucSelection.getFirstElement() instanceof IFile) {
				target_file = (IFile) strucSelection.getFirstElement();
			} else if (!strucSelection.isEmpty() && strucSelection.getFirstElement() instanceof IPapyrusFile) {
				IPapyrusFile papyrusFile = (IPapyrusFile) strucSelection.getFirstElement();
				target_file = papyrusFile.getMainFile();
			} else {
				return null;
			}

			if (strucSelection.size() > 1) {
				Activator.log.debug("WARNING: Selection contains more than one model. Using the first and ingnoring others."); //$NON-NLS-1$
			}

			return target_file.getLocation().toFile();
		}
		return null;
	}

}
