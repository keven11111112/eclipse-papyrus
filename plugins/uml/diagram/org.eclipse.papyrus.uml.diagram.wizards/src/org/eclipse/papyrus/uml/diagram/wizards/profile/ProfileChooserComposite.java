/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.wizards.profile;

import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.diagram.wizards.Activator;
import org.eclipse.papyrus.uml.diagram.wizards.messages.Messages;
import org.eclipse.papyrus.uml.diagram.wizards.widget.ExtensionFilter;
import org.eclipse.papyrus.uml.extensionpoints.profile.IRegisteredProfile;
import org.eclipse.papyrus.uml.extensionpoints.profile.RegisteredProfile;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.uml2.uml.Profile;

/**
 * @author Quentin Le Menez
 *
 */
public class ProfileChooserComposite extends Composite {

	private Text textField;

	private Button workspaceButton;

	private Button registeredButton;

	private LinkedList<ViewerFilter> filters;

	private IFile selectedFile;

	private ElementTreeSelectionDialog treeDialog;

	private boolean workspaceProfile;

	private String[] workspaceFilters = new String[] { "profile.uml" }; //$NON-NLS-1$


	/**
	 * Constructor.
	 *
	 */
	public ProfileChooserComposite(Composite parent) {
		super(parent, SWT.NONE);

		this.setLayout(new GridLayout(2, true));
		this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		createProfileChooser(this);
	}

	/**
	 * Creates the Profile selection composite
	 * 
	 * @param parent
	 *            The parent composite
	 */
	private void createProfileChooser(Composite parent) {

		filters = new LinkedList<ViewerFilter>();
		setFilterExtensions(workspaceFilters);

		textField = new Text(parent, SWT.BORDER);
		GridData fieldGrid = new GridData(SWT.FILL, SWT.FILL, true, false);
		fieldGrid.verticalAlignment = SWT.FILL;
		fieldGrid.horizontalSpan = 2;
		textField.setLayoutData(fieldGrid);

		treeDialog = new ElementTreeSelectionDialog(getShell(), new ProfileChooserLabelProvider(), new ProfileChooserContentProvider());
		treeDialog.setInput(RegisteredProfile.getRegisteredProfiles());
		treeDialog.setAllowMultiple(false);
		treeDialog.setTitle(Messages.ProfileChooserComposite_RegisteredProfilesDialog);

		SelectionListener selectionListener = new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (e.widget.equals(workspaceButton)) {
					workspaceProfile = true;
					IFile[] ifile = WorkspaceResourceDialog.openFileSelection(getShell(), null, null, false, new IFile[] { selectedFile }, filters);

					if (ifile.length > 0) {
						selectedFile = ifile[0];
						textField.setText(selectedFile.getFullPath().toString());
					}
				}
				if (e.widget.equals(registeredButton)) {
					workspaceProfile = false;
					treeDialog.open();
					IRegisteredProfile profile = (IRegisteredProfile) treeDialog.getFirstResult();

					if (profile != null) {
						textField.setText(profile.getPath().toString());
					}
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do
			}
		};

		workspaceButton = new Button(parent, SWT.NONE);
		workspaceButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		workspaceButton.addSelectionListener(selectionListener);
		workspaceButton.setText(Messages.ProfileChooserComposite_WorkspaceSelectionButton);

		registeredButton = new Button(parent, SWT.NONE);
		registeredButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		registeredButton.addSelectionListener(selectionListener);
		registeredButton.setText(Messages.ProfileChooserComposite_RegisteredSelectionButton);


	}

	/**
	 * Check that the provided path matches against a known Profile and that it is defined
	 * 
	 * @return
	 * 		The IStatus of the fetched profile
	 */
	public IStatus getProfileDefinitionStatus() {
		ResourceSet resourceSet = Util.createTemporaryResourceSet();

		try {
			String profilePath = getProfileURI();
			if (profilePath == null || profilePath.equalsIgnoreCase("")) {//$NON-NLS-1$
				return Status.OK_STATUS;
			}

			URI profileURI = URI.createURI(profilePath);
			Resource resource = resourceSet.getResource(profileURI, true);

			if (resource == null) {
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.ProfileChooserComposite_ProfileStatus_NullResource);
			}
			if (resource.getContents().isEmpty()) {
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.ProfileChooserComposite_ProfileStatus_EmptyResource);
			}

			EObject eObject = resource.getContents().get(0);
			if (!(eObject instanceof Profile)) {
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.ProfileChooserComposite_ProfileStatus_NotAProfile);
			}

			Profile profile = (Profile) eObject;
			if (!profile.isDefined()) {
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.ProfileChooserComposite_ProfileStatus_ProfileNotDefined);
			}

			return Status.OK_STATUS;

		} catch (WrappedException ex) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.ProfileChooserComposite_ProfileStatus_UnavailableResource, ex);
		} finally {
			// Unload the created resourceSet to avoid memory leaks
			EMFHelper.unload(resourceSet);
		}
	}

	/**
	 * Gets the selected profile's path
	 * 
	 * @return
	 * 		the selected profile's path
	 */
	public String getProfileURI() {
		if (textField.isDisposed()) {
			return null;
		}
		String path = textField.getText();
		if (path.trim().equals("")) { //$NON-NLS-1$
			return null;
		}

		if (workspaceProfile) {
			return path.trim();
		} else {
			return URI.createURI(path).toString();
		}
	}

	/**
	 * Sets the file extensions that this FileChooser accepts
	 * Files that don't match one of these extensions will be hidden
	 * 
	 * @param extensions
	 */
	public void setFilterExtensions(String[] extensions) {
		filters.clear();
		ExtensionFilter filter = new ExtensionFilter(extensions);
		filters.add(filter);
	}

	public Text getTextField() {
		return textField;
	}

}
