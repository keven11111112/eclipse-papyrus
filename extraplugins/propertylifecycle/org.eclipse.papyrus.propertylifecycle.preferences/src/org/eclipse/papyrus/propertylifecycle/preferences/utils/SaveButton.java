/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.propertylifecycle.preferences.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.propertylifecycle.preferences.Activator;
import org.eclipse.papyrus.propertylifecycle.preferences.messages.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;


/**
 * Class used to create the saver button, for the custom model in the advanced selection window, and its associated window
 *
 */
public class SaveButton {

	private Composite parent;

	private TreeViewer parentViewer;

	public SaveButton(Composite parent, TreeViewer parentViewer) {
		this.parent = parent;
		this.parentViewer = parentViewer;

		createSaverButton(this.parent);
	}

	/**
	 * Create a button that can be used to save the currently selected strategies as a new @see org.eclipse.emf.ecore.resource.Resource
	 * 
	 * @param parent
	 *            The parent Composite containing the button
	 */
	protected void createSaverButton(Composite parent) {
		Button saveButton = new Button(parent, SWT.NONE);
		saveButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		saveButton.setText(Messages.SaveButton_Label);

		saveButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Initialize the default variable
				saveModelResource(Messages.CustomModel_DefaultName);
			}
		});
	}

	/**
	 * Save the strategies inside a new @see org.eclipse.emf.ecore.resource.Resource
	 */
	private void saveModelResource(String modelName) {
		FileDialog dialog = new FileDialog(parent.getShell(), SWT.SAVE);
		dialog.setText(Messages.SystemSaveDialog_Title);
		// String filterPath = "/";
		// String platform = SWT.getPlatform();
		// if (platform.equals("win32")) {
		// filterPath = "c:\\";
		// }

		// ConvertEcoreToUML convertDialog = new ConvertEcoreToUML();
		// convertDialog.run(new Action() {
		// });

		String[] filterExtensions = { "*.propertylifecycle" }; //$NON-NLS-1$
		String[] filterExtensionsNames = { "Strategies Models" }; //$NON-NLS-1$
		dialog.setFilterNames(filterExtensionsNames);
		dialog.setFilterExtensions(filterExtensions);
		// dialog.setFilterPath(filterPath);
		dialog.setFileName(modelName);

		String dialogResult = dialog.open();
		if (dialogResult == null) {
			return;
		}

		Resource resource = getViewerModel();
		if (resource == null) {
			return;
		}

		URI resourceURI = CommonPlugin.resolve(URI.createFileURI(dialogResult));
		// URI resourceURI = URI.createFileURI(dialogResult);
		resource.setURI(resourceURI);

		try {
			Map<Object, Object> options = new HashMap<Object, Object>();
			options.put(XMIResource.OPTION_ENCODING, getEncoding());
			resource.save(options);
		} catch (IOException e) {
			// TODO display an error message in the preference window
			Activator.log.error(e);
		}
	}

	public Resource getViewerModel() {
		Object viewerInput = parentViewer.getInput();
		if (viewerInput != null && viewerInput instanceof ResourceSet) {
			return ((ResourceSet) viewerInput).getResources().get(0);
		}

		return null;
	}

	/**
	 * The encoding used for the file
	 * 
	 * @return
	 * 		UTF-8
	 */
	public String getEncoding() {
		return "UTF-8"; //$NON-NLS-1$
	}

}
