/**
 * Copyright (c) 2017 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 *
 *  SPDX-License-Identifier: EPL-2.0
 *  
 *  Contributors:
 *  Maged Elaasar - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.ui.architecture.handlers;

import java.util.Arrays;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.architecture.merged.MergedArchitectureContext;
import org.eclipse.papyrus.infra.architecture.ArchitectureDescriptionUtils;
import org.eclipse.papyrus.infra.architecture.ArchitectureDomainManager;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.ui.architecture.ArchitectureUIPlugin;
import org.eclipse.papyrus.infra.ui.architecture.widgets.ArchitectureContextComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * A command handler for changing architecture context in a model set
 *  
 * @since 1.0
 */
public class ChangeArchitectureContextHandler extends AbstractHandler {

	private final static String DIALOG_SECTION = ChangeArchitectureContextHandler.class.getName();
	
	/**
	 * Constructor.
	 */
	public ChangeArchitectureContextHandler() {
		// nothing by default
	}
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EObject selection = getSelection(event);
		if (selection == null)
			return new IContributionItem[0];
		ResourceSet resourceSet = selection.eResource().getResourceSet();
		if (!(resourceSet instanceof ModelSet))
			return new IContributionItem[0];
		final ArchitectureDescriptionUtils helper = new ArchitectureDescriptionUtils((ModelSet)resourceSet);
		String[] contextIds = new String[] {helper.getArchitectureContextId()};
		String[] viewpointIds = helper.getArchitectureViewpointIds().toArray(new String[0]);
		
		final Shell shell = Display.getCurrent().getActiveShell();
		ArchitectureContextDialog dialog = new ArchitectureContextDialog(shell);
		dialog.setSelectedContexts(contextIds);
		dialog.setSelectedViewpoints(viewpointIds);
		dialog.create();
		
		if (dialog.open() == Window.OK) {
			TransactionalEditingDomain dom = helper.getModelSet().getTransactionalEditingDomain();
			CompoundCommand cmd = new CompoundCommand("Change Architecture Context");
			if (!Arrays.equals(dialog.getSelectedContextIds(), contextIds)) {
				cmd.append(helper.switchArchitectureContextId(dialog.getSelectedContextIds()[0]));
			}
			if (!Arrays.equals(dialog.getSelectedViewpointIds(), viewpointIds)) {
				cmd.append(helper.switchArchitectureViewpointIds(dialog.getSelectedViewpointIds()));
			}
			if (!cmd.isEmpty()) {
				dom.getCommandStack().execute(cmd);
			}
		}
		return null;
	}

	/**
	 * Gets the current selection as an EObject
	 *
	 * @return The current selection, or <code>null</code> if it is not an EObject
	 */
	protected EObject getSelection(ExecutionEvent event) {
		Object selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection struct = (IStructuredSelection) selection;
			Object obj = struct.getFirstElement();
			return EMFHelper.getEObject(obj);
		}
		return null;
	}

	/**
	 * A dialog to allow choosing a new architecture context and viewpoints 
	 */
	private class ArchitectureContextDialog extends Dialog {

		private String[] originalContextIds;
		
		private String[] selectedContextIds;

		private String[] selectedViewpointIds;

		protected ArchitectureContextDialog(Shell parentShell) {
			super(parentShell);
		}
		
		public String[] getSelectedContextIds() {
			return selectedContextIds;
		}

		public String[] getSelectedViewpointIds() {
			return selectedViewpointIds;
		}

		public void setSelectedContexts(String[] selectedContextIds) {
			this.selectedContextIds = selectedContextIds;
			this.originalContextIds = selectedContextIds;
		}

		public void setSelectedViewpoints(String[] selectedViewpointIds) {
			this.selectedViewpointIds = selectedViewpointIds;
		}

		@Override
        protected Control createDialogArea(Composite parent) {
			Composite container = (Composite) super.createDialogArea(parent);
			
			Label label = new Label(container, SWT.NONE);
			label.setText("Switch the architecture context and/or viewpoints applied to the Papyrus model:");
			
			ArchitectureDomainManager manager = ArchitectureDomainManager.getInstance();
			
			ArchitectureContextComposite acc = new ArchitectureContextComposite(container, 1, 1, GridData.FILL_BOTH, 0, 0);
			acc.setAllowSeveralContexts(false);
			acc.setSelectedContexts(selectedContextIds);
			acc.setSelectedViewpoints(selectedViewpointIds);
			acc.setInput(manager.getVisibleArchitectureContexts().toArray(new MergedArchitectureContext[0]));
			acc.setUpdater(new ArchitectureContextComposite.Updater() {
				@Override
				public void update() {
					selectedContextIds = acc.getSelectedContexts();
					selectedViewpointIds = acc.getSelectedViewpoints();
				}
			});
			
			return container;
		}
		
		@Override
        protected void configureShell(Shell newShell) {
			super.configureShell(newShell);
            newShell.setText("Switch Architecture Context");
        }

        @Override
    	protected boolean isResizable() {
    		return true;
    	}
        
        @Override
        protected IDialogSettings getDialogBoundsSettings() {
    		IDialogSettings globalSettings = ArchitectureUIPlugin.getPlugin().getDialogSettings();
    		IDialogSettings dialogSettings = globalSettings.getSection(DIALOG_SECTION);
    		if (dialogSettings == null) {
    			dialogSettings = globalSettings.addNewSection(DIALOG_SECTION);
    	    }
    		return dialogSettings;
    	}
        
		@Override
		protected void okPressed() {
			if (!Arrays.equals(getSelectedContextIds(), originalContextIds)) {
				MessageBox messageBox = new MessageBox(getShell(), SWT.ICON_WARNING | SWT.YES | SWT.NO);
			    messageBox.setMessage("Changing the architecture context may cause significant changes to the model.\nDo you like to proceed?");
			    messageBox.setText("Warning");
			    int response = messageBox.open();
			    if (response != SWT.YES)
			    	return;
			}
	    	super.okPressed();
		}
	}

}
