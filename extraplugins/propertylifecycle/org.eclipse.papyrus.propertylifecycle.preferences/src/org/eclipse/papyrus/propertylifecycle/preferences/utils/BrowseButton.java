/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.propertylifecycle.preferences.utils;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.propertylifecycle.preferences.messages.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;

/**
 * Class used to create the browser button and its associated window
 * 
 */
public class BrowseButton {

	/** The file extensions */
	private static String[] filterExtensions = { "*.propertylifecycle", "*" }; //$NON-NLS-1$ //$NON-NLS-2$

	/** Their associated names in the window's scrolling menu */
	private static String[] filterExtensionsNames = { "Strategies Sets", "All" }; //$NON-NLS-1$ //$NON-NLS-2$

	/** The button's parent composite */
	protected Composite parent;

	/** The viewer to receive the fetched model */
	protected Viewer viewer;


	/**
	 * Constructor.
	 *
	 * @param parent
	 * @param viewer
	 */
	public BrowseButton(final Composite parent, final Viewer viewer) {
		this.parent = parent;
		this.viewer = viewer;

		createBrowserButton(this.parent);
		// TODO implement a link to grey-out the imported model
	}

	/**
	 * @return
	 * 		The browser button used to fetch the strategy models from the user's disk and add it is not already loaded
	 */
	public Button createBrowserButton(Composite parent) {
		Button browseButton = new Button(parent, SWT.NONE);
		// browseButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		browseButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		browseButton.setText(Messages.BrowseButton_Label);

		browseButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				FileDialog dialog = new FileDialog(parent.getShell(), SWT.MULTI);
				dialog.setText(Messages.SystemSelectionDialog_Title);
				dialog.setFilterExtensions(filterExtensions);
				dialog.setFilterNames(filterExtensionsNames);

				Collection<String> newSystemPaths = new LinkedList<String>();
				Collection<String> existingResources = BrowserUtils.getViewerResources(viewer);

				String dialogResult = dialog.open();
				if (dialogResult == null) {
					return;
				}
				// Settings - Store the last folder/directory visited
				String[] names = dialog.getFileNames();

				// Empty the list to avoid remembering old selections
				for (int i = 0, n = names.length; i < n; i++) {
					StringBuffer buf = new StringBuffer(dialog.getFilterPath());
					if (buf.charAt(buf.length() - 1) != File.separatorChar) {
						buf.append(File.separatorChar);
					}
					buf.append(names[i]);

					if (existingResources.contains(names[i])) {
						continue;
					}

					newSystemPaths.add(buf.toString());
				}

				BrowserUtils.addBrowsedModel(newSystemPaths, viewer);
			}
		});

		return browseButton;
	}



}
