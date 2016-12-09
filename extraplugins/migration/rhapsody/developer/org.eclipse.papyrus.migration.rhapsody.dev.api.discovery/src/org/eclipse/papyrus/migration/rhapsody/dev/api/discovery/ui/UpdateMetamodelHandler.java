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
 *  Sebastien Revol (CEA LIST) sebastien.revol@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.migration.rhapsody.dev.api.discovery.ui;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.migration.rhapsody.dev.api.discovery.RhapsodyMetamodelUpdater;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;

public class UpdateMetamodelHandler extends AbstractHandler {

	private static final String FILE_EXTENSION = "ecore";

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (!(currentSelection instanceof IStructuredSelection) || currentSelection.isEmpty()) {
			return null;
		}

		final IStructuredSelection selection = (IStructuredSelection) currentSelection;

		Iterator<?> it = selection.iterator();

		while (it.hasNext()) {
			Object selectedElement = it.next();

			if (selectedElement instanceof IFile) {
				if (FILE_EXTENSION.equals(((IFile) selectedElement).getFileExtension())) {
					IFile selectedFile = ((IFile) selectedElement);

					URI inputMetamodelURI = URI.createPlatformResourceURI(selectedFile.getFullPath().toPortableString(),
							true);

					ContainerSelectionDialog dialog = new ContainerSelectionDialog(
							Display.getCurrent().getActiveShell(), null, true, "Select a folder:");
					dialog.setTitle("Select output folder");
					dialog.open();
					if (dialog.getResult() != null && dialog.getResult().length > 0
							&& dialog.getResult()[0] instanceof IPath) {
						URI outputMetamodelURI = URI
								.createPlatformResourceURI(((IPath) dialog.getResult()[0]).toPortableString(), true);
						outputMetamodelURI = outputMetamodelURI.appendSegment(inputMetamodelURI.lastSegment());

						ContainerSelectionDialog targetFolderDialog = new ContainerSelectionDialog(
								Display.getCurrent().getActiveShell(), null, true, "Select a folder:");
						targetFolderDialog.setTitle("Select folder with Rhapsody projects");
						targetFolderDialog.open();
						if (targetFolderDialog.getResult() != null && targetFolderDialog.getResult().length > 0
								&& targetFolderDialog.getResult()[0] instanceof IPath) {
							IPath selectedProjectFolderPath = (IPath) targetFolderDialog.getResult()[0];
							URI selectedProjectFolderURI = URI
									.createPlatformResourceURI(selectedProjectFolderPath.toPortableString(), true);
							URL projectFolderURL;
							try {
								projectFolderURL = FileLocator.toFileURL(new URL(selectedProjectFolderURI.toString()));

								File inputProjectFile = new File(projectFolderURL.getFile());

								if (inputProjectFile.exists()) {
									try {
										RhapsodyMetamodelUpdater.updateMetamodel(inputMetamodelURI, outputMetamodelURI,
												inputProjectFile.getParentFile());
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							} catch (MalformedURLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						}

					}

				}
			}

		}
		return null;
	}

}
