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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.model.editor.customeditors;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.presentation.NattableproblemEditor;
import org.eclipse.papyrus.infra.nattable.model.nattable.presentation.NattableEditorPlugin;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

public class CustomNattableproblemEditor extends NattableproblemEditor {

	/**
	 * This is for implementing {@link IEditorPart} and simply saves the model file.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		// Save only resources that have actually changed.
		//
		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		saveOptions.put(Resource.OPTION_LINE_DELIMITER, Resource.OPTION_LINE_DELIMITER_UNSPECIFIED);
		saveOptions.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, true);
		// Do the work within an operation because this is a long running activity that modifies the workbench.
		//
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {

			// This is the method that gets invoked when the operation runs.
			//
			@Override
			public void execute(IProgressMonitor monitor) {
				// Save the resources to the file system.
				//
				boolean first = true;
				for (Resource resource : getEditingDomain().getResourceSet().getResources()) {
					if ((first || !resource.getContents().isEmpty() || isPersisted(resource)) && !getEditingDomain().isReadOnly(resource)) {
						try {
							long timeStamp = resource.getTimeStamp();
							resource.save(saveOptions);
							if (resource.getTimeStamp() != timeStamp) {
								savedResources.add(resource);
							}
						} catch (Exception exception) {
							resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
						}
						first = false;
					}
				}
			}
		};
		this.updateProblemIndication = false;
		try {
			// This runs the options, and shows progress.
			//
			new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);
			// Refresh the necessary state.
			//
			((BasicCommandStack) this.editingDomain.getCommandStack()).saveIsDone();
			firePropertyChange(IEditorPart.PROP_DIRTY);
		} catch (Exception exception) {
			// Something went wrong that shouldn't.
			//
			NattableEditorPlugin.INSTANCE.log(exception);
		}
		this.updateProblemIndication = true;
		updateProblemIndication();
	}
}
