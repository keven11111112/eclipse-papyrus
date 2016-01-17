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

package org.eclipse.papyrus.sysml.nattable.requirement.tests.paste.overwrite;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.selection.command.ClearAllSelectionsCommand;
import org.eclipse.papyrus.infra.nattable.common.editor.NatTableEditor;
import org.eclipse.papyrus.infra.nattable.handler.PasteInTableHandler;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.tools.util.FileUtils;
import org.eclipse.papyrus.infra.ui.util.EclipseCommandUtils;
import org.eclipse.papyrus.sysml.nattable.requirement.tests.Activator;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.commands.ICommandService;
import org.junit.Assert;
import org.junit.Test;

/**
 * This class allows to manage the paste with overwrite tests.
 */
public abstract class AbstractPasteEmptyOverwriteTest extends AbstractPasteOverwriteTest {

	/**
	 * This allows to test the paste.
	 * 
	 * @throws Exception
	 *             The caught exception
	 */
	@Override
	@Test
	public void testPaste() throws Exception {
		// Open the table and get the manager
		testOpenExistingTable(getClass().getSimpleName(), "RequirementTable0"); //$NON-NLS-1$
		final IEditorPart editorPart = editor.getActiveEditor();
		Assert.assertTrue("Table editor must be a nattable editor", editorPart instanceof NatTableEditor); //$NON-NLS-1$
		final INattableModelManager currentManager = (INattableModelManager) editor.getAdapter(INattableModelManager.class);
		Assert.assertTrue("The manager must be a nattable model manager", currentManager instanceof NattableModelManager); //$NON-NLS-1$
		final NattableModelManager manager = (NattableModelManager) currentManager;

		// Check the table context before command
		checkTableContent(manager, INITIAL_POST_FILE_NAME);

		// Manage the selection
		manageSelection(manager);
		flushDisplayEvents();

		// fill the clipboard
		final ICommandService commandService = EclipseCommandUtils.getCommandService();
		Assert.assertNotNull("The command service must not be null", commandService); //$NON-NLS-1$
		final String fileName = getSuffixStateFileName(manager, TOCOPY_POST_FILE_NAME);
		final String str = FileUtils.getStringFromPlatformFile(Activator.PLUGIN_ID, getSourcePath(), fileName);
		fillClipboard(str);

		// Get the paste command
		final Command cmd = commandService.getCommand("org.eclipse.ui.edit.paste"); //$NON-NLS-1$
		final IHandler handler = cmd.getHandler();
		Assert.assertTrue("The handler must be enabled", handler.isEnabled()); //$NON-NLS-1$

		// Execute the command with the non-UI parameters
		final Map<Object, Object> parameters = new HashMap<Object, Object>();
		parameters.put(PasteInTableHandler.OPEN_DIALOG_ON_FAIL_BOOLEAN_PARAMETER, Boolean.FALSE);
		parameters.put(PasteInTableHandler.OPEN__PROGRESS_MONITOR_DIALOG, Boolean.FALSE);
		manageParameters(parameters);
		final ExecutionEvent event = new ExecutionEvent(cmd, parameters, null, null);
		flushDisplayEvents();
		final Object res = cmd.executeWithChecks(event);
		Assert.assertTrue("The result must be a status", res instanceof IStatus); //$NON-NLS-1$
		final IStatus status = (IStatus) res;

		// Check the returned status
		checkReturned_Status(status);

		if (status.isOK()) {
			// Check the table content after command
			checkTableContent(manager, RESULT_POST_FILE_NAME);

			// Undo/Redo
			testUndo_Redo(manager);
		}
	}

	/**
	 * This allows to add parameters if necessary
	 * 
	 * @param parameters
	 *            The parameters for the command.
	 */
	public void manageParameters(final Map<Object, Object> parameters) {
		// Do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.AbstractPasteOverwriteTest#manageSelection(org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager)
	 */
	@Override
	public void manageSelection(final NattableModelManager manager) throws Exception {
		final NatTable natTable = (NatTable) manager.getAdapter(NatTable.class);
		natTable.doCommand(new ClearAllSelectionsCommand());
	}
}
