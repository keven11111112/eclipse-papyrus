/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.requirements.reqif.assistant;

import java.util.ArrayList;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.FormDialog;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.uml2.uml.Profile;

/** this dialog is used to select registered profiles**/
public class SelectProfilDialog extends FormDialog {


	/**
	 * list of applied local profile
	 */
	protected ArrayList<Profile> appliedLocalProfiles;
	
	protected Button selectionRadio;
	protected Label profileSelectionLabel;
	protected Combo profileSelectionCombo;
	protected Section lSection;
	protected String resultProfileName;

	/**
	 * 
	 * Constructor.
	 *
	 * @param shell
	 * @param appliedLocalProfiles list of local profiles
	 */
	public SelectProfilDialog(Shell shell, ArrayList<Profile> appliedLocalProfiles) {
		super(shell);
		this.appliedLocalProfiles= appliedLocalProfiles;
	}



	protected void createFormContent(IManagedForm pForm) {
		pForm.getForm().setText("Profile Selection");
		ScrolledForm scrolledForm = pForm.getForm();
		FormToolkit toolkit = pForm.getToolkit();
		Composite parent = scrolledForm.getBody();
		parent.setLayout(new GridLayout());

		createFormSelectionSection(scrolledForm.getBody(), toolkit);

		refreshSectionsEnable(false);
		makeSelectionVisible(appliedLocalProfiles.size()>0);
		addListeners();

		scrolledForm.reflow(true);
	}

	/**
	 * 
	 * @param visible if true the panel about the selection is visible
	 */
	protected void makeSelectionVisible( boolean visible){
		selectionRadio.setVisible(visible);
		profileSelectionLabel.setVisible(visible);
		profileSelectionCombo.setVisible(visible);
		profileSelectionCombo.setVisible(visible);
		lSection.setText("Select a rofile among registered profiles");
	}
	/**
	 * make enable sections
	 * @param selectionEnable if the the selection section must be enable
	 */
	protected void refreshSectionsEnable(boolean selectionEnable) {
		//selectionSection
		selectionRadio.setSelection(selectionEnable);
		profileSelectionLabel.setEnabled(selectionEnable);
		profileSelectionCombo.setEnabled(selectionEnable);
		if(selectionEnable){
			profileSelectionCombo.setFocus();
		}
	}

	/**
	 * Add listeners to widgets
	 */
	protected void addListeners() {
		// listener to choose active section
		SelectionListener selectCreateListener = new SelectionAdapter() {

			/**
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
					refreshSectionsEnable(true);
				refreshOkButton();
			}
		};
		selectionRadio.addSelectionListener(selectCreateListener);
		profileSelectionCombo.addSelectionListener(selectCreateListener);

	}

	/** Refresh the OK button activation */
	protected void refreshOkButton() {
		boolean isSelectionSelected = selectionRadio.getSelection();
		if(isSelectionSelected){
			if(profileSelectionCombo.getSelectionIndex()==-1){
				getButton(IDialogConstants.OK_ID).setEnabled(false);
			}
			else{
				getButton(IDialogConstants.OK_ID).setEnabled(true);
			}
		}
	}

	/**
	 * Create the section to ask the user to choose an existing element.
	 * 
	 * @param pParent
	 *        the section's parent widget
	 * @param pToolkit
	 *        the form toolkit
	 */
	protected void createFormSelectionSection(Composite pParent, FormToolkit pToolkit) {
		// create the section
		String lSectionTitle = "Select an existing profile";
		lSection = pToolkit.createSection(pParent, Section.EXPANDED | Section.TITLE_BAR);
		lSection.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		if(lSectionTitle != null) {
			lSection.setText(lSectionTitle);
		}

		ScrolledForm lInsideScrolledForm = pToolkit.createScrolledForm(lSection);
		lInsideScrolledForm.setExpandHorizontal(true);
		lInsideScrolledForm.setExpandVertical(true);
		Composite lBody = lInsideScrolledForm.getBody();

		GridLayout lLayout = new GridLayout();
		lLayout.numColumns = 3;
		lBody.setLayout(lLayout);

		selectionRadio = pToolkit.createButton(lBody, "Selection profile mode", SWT.RADIO);
		selectionRadio.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));

		profileSelectionLabel = pToolkit.createLabel(lBody, "Profile:", SWT.NONE);
		profileSelectionCombo = new Combo (lBody, SWT.READ_ONLY);
		for(Profile profile : appliedLocalProfiles) {
			profileSelectionCombo.add(profile.getName());
		}
		pToolkit.adapt(profileSelectionCombo, true, true);


		lInsideScrolledForm.reflow(true);
		lSection.setClient(lInsideScrolledForm);
	}

	@Override
	protected void okPressed() {
		resultProfileName = null;
		boolean isSelectionSelected = selectionRadio.getSelection();
		if(isSelectionSelected){
			if(profileSelectionCombo.getSelectionIndex()!=-1){
				resultProfileName=profileSelectionCombo.getItem(profileSelectionCombo.getSelectionIndex());
			}
		}
		super.okPressed();
	}
	/**
	 * 
	 * @return the name of the profile that will be created
	 */
	public String getProfileName(){
		return resultProfileName;
	}

}
