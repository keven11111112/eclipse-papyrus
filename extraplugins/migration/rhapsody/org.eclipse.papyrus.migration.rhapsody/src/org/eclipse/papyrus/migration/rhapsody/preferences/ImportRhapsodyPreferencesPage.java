/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.migration.rhapsody.preferences;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.papyrus.migration.rhapsody.Activator;
import org.eclipse.papyrus.migration.rhapsody.messages.Messages;
import org.eclipse.papyrus.migration.rhapsody.utils.RhapsodyShareFolderUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * 
 * This class provides the preference page for the Rhapsody Importer
 *
 */
public class ImportRhapsodyPreferencesPage extends PreferencePage implements IWorkbenchPreferencePage {

	/**
	 * The text field used to edit the path of the Rhapsody Shared folder
	 */
	private Text fLocationText;

	/**
	 * The buttons used to select the directory
	 */
	private Button workspaceButton, fileSystemButton;

	@SuppressWarnings("unused")
	private static final String WORKSPACE_BUTTON_TEXT = Messages.ImportRhapsodyPreferencesPage_Worskspace;

	private static final String FILE_SYSTEM_BUTTON_TEXT = Messages.ImportRhapsodyPreferencesPage_FileSystem;

	private static final String TEXT_FIELD_LABEL = Messages.ImportRhapsodyPreferencesPage_Locatio;

	private static final String TEXT_FIELD_TOOLTIP = Messages.ImportRhapsodyPreferencesPage_SelectTheLocation_DialogMessage;

	private static final String GROUP_TITLE = Messages.ImportRhapsodyPreferencesPage_SelectTheShareRhapsodyFolder;

	private static final String HELP_MESSAGE = Messages.ImportRhapsodyPreferencesPage_Information;


	// the folder can be here : C:\\Program Files (x86)\\IBM\\Rational\\Rhapsody\\8.1.3\\Share
	// or here : C:\\Program Files (x86)\\IBM\\Rational\\Rhapsody\\8.1.3\\Share

	/**
	 * 
	 * @param parent
	 * @return
	 */
	@Override
	protected Control createContents(final Composite parent) {
		// there is no default value for the Share folder
		noDefaultButton();

		final Composite localParent = new Composite(parent, SWT.NONE);
		GridLayout parentLayout = new GridLayout();
		parentLayout.numColumns = 1;
		localParent.setLayout(parentLayout);


		final Group group = new Group(localParent, SWT.NONE);
		group.setText(GROUP_TITLE);
		final GridData groupDataLayout = new GridData();
		groupDataLayout.grabExcessHorizontalSpace = true;
		groupDataLayout.horizontalAlignment = SWT.FILL;
		group.setLayoutData(groupDataLayout);
		group.setLayout(new GridLayout(2, false));

		final Label helpLabel = new Label(group, SWT.NONE);
		helpLabel.setText(HELP_MESSAGE);
		final GridData helperGridData = new GridData();
		helperGridData.grabExcessHorizontalSpace = true;
		helperGridData.horizontalSpan = 2;
		helperGridData.verticalSpan = 2;
		helpLabel.setLayoutData(helperGridData);

		final Label label = new Label(group, SWT.NONE);
		label.setText(TEXT_FIELD_LABEL);
		label.setToolTipText(TEXT_FIELD_TOOLTIP);
		label.setLayoutData(new GridData());

		this.fLocationText = new Text(group, SWT.NONE);
		this.fLocationText.addModifyListener(this.fModifyListener);
		this.fLocationText.setText(getSavedLocation());


		final GridData textLayoutData = new GridData(GridData.FILL_HORIZONTAL);
		textLayoutData.grabExcessHorizontalSpace = true;
		this.fLocationText.setLayoutData(textLayoutData);
		this.fLocationText.pack();

		final Composite parentButton = new Composite(group, SWT.NONE);

		final GridData buttonParentLayoutData = new GridData(GridData.HORIZONTAL_ALIGN_END);
		buttonParentLayoutData.horizontalSpan = GridData.HORIZONTAL_ALIGN_END | GridData.GRAB_HORIZONTAL;
		parentButton.setLayoutData(buttonParentLayoutData);

		parentButton.setLayout(new GridLayout(1, false));
		// parentButton.setLayout(new GridLayout(2, false));
		// this.workspaceButton = createButton(parentButton, WORKSPACE_BUTTON_TEXT);
		this.fileSystemButton = createButton(parentButton, FILE_SYSTEM_BUTTON_TEXT);

		return localParent;
	}

	/**
	 * 
	 * @return
	 * 		the saved location in the preference store for the Rhapsody Share folder
	 */
	protected String getSavedLocation() {
		final String savedLocation = RhapsodyShareFolderUtils.getRhapsodyShareFolder();
		final String returnedValue;
		if (savedLocation == null) {
			returnedValue = ""; //$NON-NLS-1$
		} else {
			returnedValue = savedLocation;
		}
		return returnedValue;
	}

	/**
	 * 
	 * @param parent
	 *            the composite parent
	 * @param text
	 *            the text of the button
	 * @return
	 * 		the created button
	 */
	protected Button createButton(Composite parent, String text) {
		Button button = new Button(parent, SWT.PUSH);
		button.setText(text);
		button.setLayoutData(new GridData());
		button.addSelectionListener(this.fListener);
		return button;
	}

	/**
	 * @see org.eclipse.jface.preference.PreferencePage#isValid()
	 *
	 * @return
	 */
	@Override
	public boolean isValid() {
		setMessage(null, SWT.NONE);
		final IStatus status = RhapsodyShareFolderUtils.isARhapsodySharedFolder(this.fLocationText.getText());
		boolean result = status.isOK();
		if (!result) {
			setMessage(status.getMessage(), SWT.ERROR);
		}
		return result;
	}


	/**
	 * @see org.eclipse.jface.preference.PreferencePage#performApply()
	 *
	 */
	@Override
	protected void performApply() {
		if (isValid()) {
			RhapsodyShareFolderUtils.registerRhapsodyShareFolderFromString(this.fLocationText.getText());
		}
	}


	/**
	 * 
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 *
	 * @param workbench
	 */

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	/**
	 * Open the dialog to select a folder in the File System and set the result in the text field
	 */
	protected void handleBrowseFileSystem() {
		final String result = RhapsodyShareFolderUtils.browseFileSystemForRhapsodyShareFolder(this.fLocationText.getShell(), getLocation());
		if (result != null) {
			this.fLocationText.setText(result);
		}
	}

	// /**
	// * Open the dialog to select a folder in the workspace and set the result in the text field
	// */
	// protected void handleBrowseWorkspace() {
	// ContainerSelectionDialog dialog = new ContainerSelectionDialog(fLocationText.getShell(), getWorkspaceRoot(), true, "text_3" /* PDEUIMessages.BaseBlock_relative */);
	// if (dialog.open() == Window.OK) {
	// Object[] result = dialog.getResult();
	// if (result.length == 0)
	// return;
	// IPath path = (IPath) result[0];
	//
	// fLocationText.setText(path.toString());
	// fLocationText.setText("${workspace_loc:" + path.makeRelative().toString() + "}"); //$NON-NLS-1$ //$NON-NLS-2$
	// }
	// }

	/**
	 * @return
	 * 		Returns the selected workspace container,or <code>null</code>
	 */
	@SuppressWarnings("unused")
	private IContainer getWorkspaceRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	/**
	 * 
	 * @return
	 * 		the current location displayed in the text field
	 */
	protected String getLocation() {
		return fLocationText.getText().trim();
	}

	private ModifyListener fModifyListener = new ModifyListener() {

		@Override
		public void modifyText(ModifyEvent e) {
			updateApplyButton();
		}
	};

	/**
	 * The listener used to listen the button in the dialog
	 */
	private SelectionListener fListener = new SelectionListener() {

		/**
		 * 
		 * @param e
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			if (e.getSource() == workspaceButton) {
				// handleBrowseWorkspace();
			} else if (e.getSource() == fileSystemButton) {
				handleBrowseFileSystem();
			}
		}

		/**
		 * 
		 * @param e
		 */
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// nothing to do
		}
	};
}
