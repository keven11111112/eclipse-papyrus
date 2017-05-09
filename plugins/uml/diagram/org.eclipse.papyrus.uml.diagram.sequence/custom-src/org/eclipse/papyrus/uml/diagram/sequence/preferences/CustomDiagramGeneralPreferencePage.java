/**
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
  *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.sequence.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.DiagramPreferencePage;
import org.eclipse.papyrus.uml.diagram.sequence.CustomMessages;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.SequenceDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * @generated
 */
public class CustomDiagramGeneralPreferencePage extends DiagramPreferencePage {
	
	/**
	 * preference page editor control for choosing if and which execution specifications should be automatically created with synchronous messages
	 */
	private RadioGroupFieldEditor executionSpecificationWithSyncMsg = null;

	/**
	 * preference page editor control for choosing if and which execution specifications should be automatically created with asynchronous messages
	 */
	private RadioGroupFieldEditor executionSpecificationWithAsyncMsg = null;
	
	/**
	 * @generated
	 */
	public CustomDiagramGeneralPreferencePage() {
		setPreferenceStore(UMLDiagramEditorPlugin.getInstance().getPreferenceStore());
		setPreferenceKey(SequenceDiagramEditPart.MODEL_ID);
	}
	
	/**
	 * Create new composite to contain the field editors 
	 *
	 * @param parent
	 *            the parent Composite that the field editors will be added to
	 */
	@Override
	protected void addFields(Composite parent) {
		super.addFields(parent);
		Group notificationsGroup = new Group(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout(2, false);
		notificationsGroup.setLayout(gridLayout);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 2;
		notificationsGroup.setLayoutData(gridData);
		notificationsGroup.setText(CustomMessages.DiagramsPreferencePage_notificationGroup_label);
		Composite composite = new Composite(notificationsGroup, SWT.NONE);
		createFieldEditors(composite);
		addField(executionSpecificationWithSyncMsg);
		addField(executionSpecificationWithAsyncMsg);
	}

	/**
	 * 
	 * @param composite
	 */
	protected void createFieldEditors(Composite composite) {
		// preference for choosing if and which execution specifications should be automatically created with synchronous message
		// choice between behavior execution specification, action execution specification or nothing
		executionSpecificationWithSyncMsg = new RadioGroupFieldEditor(CustomMessages.PREF_EXECUTION_SPECIFICATION_SYNC_MSG, 
				CustomMessages.DiagramsPreferencePage_executionSpecificationWithSyncMsg_label, 1,
				new String[][] {
						{ CustomMessages.DiagramsPreferencePage_createBehaviorExecutionSpecification, "CHOICE_BEHAVIOR" }, 
						{ CustomMessages.DiagramsPreferencePage_createActionExecutionSpecification, "CHOICE_ACTION" }, 
						{ CustomMessages.DiagramsPreferencePage_createNoExecutionSpecification, "CHOICE_NONE" }
				}, composite);

		// preference for choosing if and which execution specifications should be automatically created with asynchronous message
		// choice between behavior execution specification, action execution specification or nothing
		executionSpecificationWithAsyncMsg = new RadioGroupFieldEditor(CustomMessages.PREF_EXECUTION_SPECIFICATION_ASYNC_MSG, 
				CustomMessages.DiagramsPreferencePage_executionSpecificationWithAsyncMsg_label, 1,
				new String[][] {
						{ CustomMessages.DiagramsPreferencePage_createBehaviorExecutionSpecification, "CHOICE_BEHAVIOR" }, 
						{ CustomMessages.DiagramsPreferencePage_createActionExecutionSpecification, "CHOICE_ACTION" }, 
						{ CustomMessages.DiagramsPreferencePage_createNoExecutionSpecification, "CHOICE_NONE" }
				}, composite);
	}
	
	/**
	 * Initializes the default preference values for this preference store.
	 *
	 * @param IPreferenceStore
	 *            preferenceStore
	 */
	public static void initSpecificDefaults(IPreferenceStore preferenceStore) {
		preferenceStore.setDefault(CustomMessages.PREF_EXECUTION_SPECIFICATION_SYNC_MSG, 
				"CHOICE_BEHAVIOR");
		preferenceStore.setDefault(CustomMessages.PREF_EXECUTION_SPECIFICATION_ASYNC_MSG, 
				"CHOICE_BEHAVIOR");		

	}	
}
