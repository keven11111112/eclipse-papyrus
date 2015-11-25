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

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.selection.command.ClearAllSelectionsCommand;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.TableClipboardUtils;
import org.eclipse.papyrus.infra.tools.util.FileUtils;
import org.eclipse.papyrus.junit.utils.GenericUtils;
import org.eclipse.papyrus.sysml.nattable.requirement.tests.Activator;
import org.eclipse.papyrus.sysml.nattable.requirement.tests.paste.without.service.edit.AbstractOpenTableTest;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;

/**
 * This class allows to manage the paste with overwrite tests.
 */
public abstract class AbstractPasteInsertTest extends AbstractOpenTableTest {

	/**
	 * The path of the model to test.
	 */
	public static final String PASTE_FOLDER_PATH = "/resources/paste_overwrite/"; //$NON-NLS-1$

	/**
	 * The suffix of the file containing the initial content.
	 */
	public static final String INITIAL_POST_FILE_NAME = "_Initial"; //$NON-NLS-1$

	/**
	 * The suffix of the file containing the content to copy.
	 */
	public static final String TOCOPY_POST_FILE_NAME = "_ToCopy"; //$NON-NLS-1$

	/**
	 * The suffix of the file containing the result content.
	 */
	public static final String RESULT_POST_FILE_NAME = "_Result"; //$NON-NLS-1$

	/**
	 * Constructor.
	 */
	public AbstractPasteInsertTest() {
		super();
	}

	/**
	 * Initialize the model.
	 * 
	 * @throws Exception
	 *             The caught exception.
	 */
	@Before
	public void initModel() throws Exception {
		initModel("RequirementTable0", getClass().getSimpleName(), getBundle()); //$NON-NLS-1$
	};

	/**
	 * This allows to set the selection in table for the paste. The initial selection is the first cell of the table.
	 * 
	 * @param manager
	 *            The tree nattable model manager.
	 * @throws Exception
	 *             The caught exception.
	 */
	public abstract void manageSelection(final NattableModelManager manager) throws Exception;

	/**
	 * This allows to test the undo redo commands.
	 * 
	 * @param treeManager
	 *            The tree nattable model manager.
	 * @throws Exception
	 *             The caught exception.
	 */
	protected void testUndo_Redo(final NattableModelManager treeManager) throws Exception {
		// Check the undo
		getTransactionalEditingDomain().getCommandStack().undo();
		// Check the table context after undo
		checkTableContent(treeManager, INITIAL_POST_FILE_NAME);

		// Check the redo
		getTransactionalEditingDomain().getCommandStack().redo();
		// Check the table context after redo
		checkTableContent(treeManager, RESULT_POST_FILE_NAME);
	}

	/**
	 * This allows to check the returned status.
	 * 
	 * @param status
	 *            The status.
	 */
	protected void checkReturned_Status(final IStatus status) {
		Assert.assertTrue("The status must be OK", status.isOK()); //$NON-NLS-1$
	}

	/**
	 * This allows to check the table content comparing the table content with file content.
	 * 
	 * @param manager
	 *            The nattable model manager.
	 * @param suffixFileName
	 *            The suffix of the file to check.
	 * @throws Exception
	 *             The caught exception.
	 */
	protected void checkTableContent(final NattableModelManager manager, final String suffixFileName) throws Exception {
		final NatTable natTable = (NatTable) manager.getAdapter(NatTable.class);
		flushDisplayEvents();
		natTable.doCommand(new ClearAllSelectionsCommand());
		manager.selectAll();
		manager.copyToClipboard();
		String clipboard = getClipboardContent();
		// we check than the contents of the clipboard (so the displayed table) is the same than the wanted result
		Assert.assertNotNull("Clipboard must not be null", clipboard); //$NON-NLS-1$
		String str = getWantedString(getSuffixStateFileName(manager, suffixFileName));
		// we check than the contents of the clipboard (so the displayed table) is the same than the wanted result
		Assert.assertEquals("The clipboard must be equals to string which one it is filled", str, clipboard); //$NON-NLS-1$
	}

	/**
	 * Get the string content from a file.
	 * 
	 * @param fileName
	 *            a file name
	 * @return
	 * 		the text stored in the file associated to this test
	 */
	protected String getWantedString(final String fileName) {
		return FileUtils.getStringFromPlatformFile(Activator.PLUGIN_ID, getSourcePath(), fileName, FileUtils.getSystemPropertyLineSeparator());// $NON-NLS-1$
	}

	/**
	 * Get the file name corresponding to the model with the suffix in parameter.
	 * 
	 * @param manager
	 *            The nattable model manager.
	 * @param suffixFileName
	 *            The suffix of the file to get.
	 * @return The file name corresponding
	 */
	protected String getSuffixStateFileName(final NattableModelManager manager, final String suffixFileName) {
		URI uri = manager.getTable().eResource().getURI();
		uri = uri.trimFileExtension();
		final StringBuffer buffer = new StringBuffer(uri.lastSegment());
		buffer.append(suffixFileName);
		buffer.append(FileUtils.DOT_STRING);
		buffer.append(FileUtils.TEXT_EXTENSION);
		return buffer.toString();
	}

	/**
	 * Get the clipboard contents.
	 * 
	 * @return
	 * 		the clipboard contents.
	 */
	protected String getClipboardContent() {
		String clipboard = TableClipboardUtils.getClipboardContentsAsString();
		return clipboard;
	}

	/**
	 * This allows to fill the clipboard with the string in parameter.
	 * 
	 * @param newClipBoardContents
	 *            The string needed to fill the clipboard.
	 */
	protected void fillClipboard(final String newClipBoardContents) {

		// its seems that the clipboard must be filled with the same way than we read it!
		java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		StringSelection s = new StringSelection(newClipBoardContents);
		clipboard.setContents(s, s);
	}

	/**
	 * This allow to close the opened editors.
	 */
	@AfterClass
	public static void endOfTest() {
		GenericUtils.closeAllEditors();
	}
}
