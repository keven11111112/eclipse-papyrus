/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.manager.InsertInNattableManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.nattable.provider.TableStructuredSelection;
import org.eclipse.papyrus.infra.nattable.utils.AbstractPasteInsertInTableHandler;
import org.eclipse.papyrus.infra.nattable.utils.CSVPasteHelper;
import org.eclipse.papyrus.infra.nattable.utils.TableClipboardUtils;
import org.eclipse.papyrus.infra.nattable.utils.TableSelectionWrapper;
import org.eclipse.papyrus.infra.nattable.utils.UserActionConstants;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Insert Handler.
 */
public class InsertInTableHandler extends AbstractPasteInsertInTableHandler {

	/**
	 * This field is used to determine if we want open a dialog to prevent the user that the command creation and the command execution can take a
	 * long time
	 */
	protected final boolean useProgressMonitorDialog = true;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final CSVPasteHelper pasteHelper = new CSVPasteHelper();

		boolean openProgressMonitor = useProgressMonitorDialog;
		final Object value = event.getParameters().get(OPEN__PROGRESS_MONITOR_DIALOG);
		if (value instanceof Boolean) {
			openProgressMonitor = ((Boolean) value).booleanValue();
		}
		final INattableModelManager currentNattableModelManager = getCurrentNattableModelManager();
		// Try to get the selection in the nattable editor
		final ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		TableSelectionWrapper tableSelectionWrapper = null;
		if (currentSelection instanceof TableStructuredSelection) {
			tableSelectionWrapper = (TableSelectionWrapper) ((TableStructuredSelection) currentSelection).getAdapter(TableSelectionWrapper.class);
			if (tableSelectionWrapper.getSelectedCells().isEmpty()) {
				tableSelectionWrapper = null;
			}
		}

		// Calculate if the dialog must be opened during the process
		final Object res = event.getParameters().get(OPEN_DIALOG_ON_FAIL_BOOLEAN_PARAMETER);
		final boolean openDialog = ((null == res) || Boolean.TRUE.equals(res));

		final Object userAction = event.getParameters().get(USER_ACTION__PREFERRED_USER_ACTION);
		final int preferredUserAction = null == userAction ? UserActionConstants.UNDEFINED_USER_ACTION : Integer.parseInt(userAction.toString());

		final Object textToPaste = event.getParameters().get(TEXT_TO_PASTE);
		final String clipboardContentsAsString = null != textToPaste ? (String) textToPaste : TableClipboardUtils.getClipboardContentsAsString();
		
		IStatus result = null;
		if (null != clipboardContentsAsString && !clipboardContentsAsString.isEmpty()) {
			final InsertInNattableManager pasteManager = new InsertInNattableManager(currentNattableModelManager, pasteHelper, openProgressMonitor, openDialog, preferredUserAction, tableSelectionWrapper, clipboardContentsAsString);
			result = pasteManager.doAction();
		} else {
			result = new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.PasteImportHandler_EmptyClipboardString);
		}

		// Manage different types of dialog error depending of type error
		if (openDialog) {
			displayDialog(result);
		}
		return result;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractTableHandler#setEnabled(java.lang.Object)
	 *
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(final Object evaluationContext) {
		super.setEnabled(evaluationContext);
		if (isEnabled()) {
			// Recalculate if the enable is allowed because the user can select cells and try to insert by click on rows for example.
			boolean canEnable = false;
			final INattableModelManager currentNattableModelManager = getCurrentNattableModelManager();
			if (null != currentNattableModelManager) {
				final ISelection currentSelection = ((NattableModelManager) currentNattableModelManager).getSelectionInTable();
				if (null == currentSelection) {
					canEnable = true;
				} else if (currentSelection instanceof TableStructuredSelection) {
					TableSelectionWrapper tableSelectionWrapper = (TableSelectionWrapper) ((TableStructuredSelection) currentSelection).getAdapter(TableSelectionWrapper.class);
					if (null != tableSelectionWrapper) {
						if (tableSelectionWrapper.getSelectedCells().isEmpty()
								|| !tableSelectionWrapper.getFullySelectedRows().isEmpty() && tableSelectionWrapper.getFullySelectedColumns().isEmpty()) {
							canEnable = true;
						}
					}
				}
			}
			setBaseEnabled(canEnable);
		}
	}
}
