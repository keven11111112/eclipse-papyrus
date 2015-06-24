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

package org.eclipse.papyrus.uml.nattable.clazz.config.tests.sort;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.sort.command.SortColumnCommand;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.nattable.common.editor.NatTableEditor;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.TreeNattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TreeFillingConfiguration;
import org.eclipse.papyrus.infra.nattable.tree.CollapseAndExpandActionsEnum;
import org.eclipse.papyrus.infra.nattable.utils.FillingConfigurationUtils;
import org.eclipse.papyrus.infra.nattable.utils.StyleUtils;
import org.eclipse.papyrus.infra.nattable.utils.TableClipboardUtils;
import org.eclipse.papyrus.infra.tools.util.FileUtils;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.junit.utils.rules.ActiveTable;
import org.eclipse.papyrus.junit.utils.rules.PapyrusEditorFixture;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.Activator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * 
 * Abstract test class to reopen filtered table
 */
public abstract class AbstractSortTable extends AbstractPapyrusTest {

	@Rule
	public final PapyrusEditorFixture fixture = new PapyrusEditorFixture();

	/**
	 * the nattable editor
	 */
	private NatTableEditor editor;

	/**
	 * the nattable widget
	 */
	private NatTable natTable;
	/**
	 * the tree table manager
	 */
	private TreeNattableModelManager manager;

	/**
	 * the resource path
	 */
	private static final String RESOURCES_PATH = "resources/sort/";//$NON-NLS-1$

	public static final String NAME_ASC = "NAME_ASC";//$NON-NLS-1$

	public static final String NAME_DESC = "NAME_DESC";//$NON-NLS-1$

	public static final String TYPE_ASC = "TYPE_ASC"; //$NON-NLS-1$

	public static final String TYPE_DESC = "TYPE_DESC";//$NON-NLS-1$

	/**
	 * load the table editor
	 */
	@Before
	public void init() {
		// these tests works only when the sorted columns are visible (without scrollbar)!
		if (Display.getDefault() != null) {
			Shell shell = Display.getDefault().getActiveShell();
			if(shell!=null){
				shell.setMaximized(true);
			}
		}
	}

	@Test
	@ActiveTable("ClassTreeTable")
	public void test_sort_NAME_ASC() {
		startTest();
		// we do the sort
		Assert.assertTrue(natTable.doCommand(new SortColumnCommand(natTable, getNameColumnIndex(), false)));

		endTest(getResultFile_Name_ASC_SORT());
	}

	@Test
	@ActiveTable("ClassTreeTable")
	public void test_sort_TYPE_ASC() {
		startTest();
		// we do the sort
		Assert.assertTrue(natTable.doCommand(new SortColumnCommand(natTable, getTypeColumnIndex(), false)));

		endTest(getResultFile_Type_ASC_SORT());
	}

	/**
	 * @return
	 */
	private String getResultFile_Type_ASC_SORT() {
		return createSortFileNameResult(TYPE_ASC);
	}

	@Test
	@ActiveTable("ClassTreeTable")
	public void test_sort_TYPE_DESC() {
		startTest();
		// we do the sort
		Assert.assertTrue(natTable.doCommand(new SortColumnCommand(natTable, getTypeColumnIndex(), false)));
		Assert.assertTrue(natTable.doCommand(new SortColumnCommand(natTable, getTypeColumnIndex(), false)));

		endTest(getResultFile_Type_DESC_SORT());
	}



	/**
	 * @return
	 */
	private String getResultFile_Type_DESC_SORT() {
		return createSortFileNameResult(TYPE_DESC);
	}

	/**
	 * this method initialize some field for the test + expand all the table + check the initial state of the table
	 */
	protected void startTest() {
		this.manager = (TreeNattableModelManager) fixture.getActiveTableManager();
		this.natTable = (NatTable) this.manager.getAdapter(NatTable.class);
		manager.doCollapseExpandAction(CollapseAndExpandActionsEnum.EXPAND_ALL, null);
		fixture.flushDisplayEvents();
		manager.selectAll();
		manager.copyToClipboard();
		String clipboard = getClipboardContent();
		// we check than the contents of the clipboard (so the displayed table) is the same than the wanted result
		Assert.assertNotNull(clipboard);
		String str = getWantedString(getInitialStateFileName());
		// we check than the contents of the clipboard (so the displayed table) is the same than the wanted result
		Assert.assertEquals(str, clipboard);
	}

	/**
	 * 
	 * @param resultFileName
	 *            the name of the result file to use to compare the displayed state and the wanted state
	 */
	protected void endTest(String resultFileName) {
		fixture.flushDisplayEvents();
		manager.selectAll();
		((NattableModelManager) manager).copyToClipboard();
		fixture.flushDisplayEvents();

		String clipboard = getClipboardContent();
		Assert.assertNotNull(clipboard);

		String str = getWantedString(resultFileName);

		// we check than the contents of the clipboard (so the displayed table) is the same than the wanted result
		Assert.assertEquals(str, clipboard);
	}

	/**
	 * 
	 * @return
	 * 		the name column index
	 */
	protected int getNameColumnIndex() {
		return 2;
	}

	/**
	 * 
	 * @return
	 * 		the type column index
	 */
	protected int getTypeColumnIndex() {
		return 3;
	}

	@Test
	@ActiveTable("ClassTreeTable")
	public void test_sort_NAME_DESC() {
		startTest();
		// we do the sort
		Assert.assertTrue(natTable.doCommand(new SortColumnCommand(natTable, getNameColumnIndex(), false)));
		Assert.assertTrue(natTable.doCommand(new SortColumnCommand(natTable, getNameColumnIndex(), false)));

		endTest(getResultFile_Name_DESC_SORT());
	}

	/**
	 * this test is used to check the test
	 */
	@Test
	@ActiveTable("ClassTreeTable")
	public void checkTestConsitency() {
		startTest();
		String className = getClass().getSimpleName();
		URI modelUri = fixture.getModel().eResource().getURI();
		URI uri = modelUri.trimFileExtension();

		// we check than the className is the same than the tested file
		Assert.assertEquals("The java class doesn't test the wanted papyrus model", className, uri.lastSegment()); //$NON-NLS-1$

		checkFillingConfigurationAndHiddenCategoryForTestConsistency(manager.getTable(), className);
	}



	/**
	 * @param table
	 *            the tested table
	 * @param the
	 *            simple Class name : should be something like than : className_Empty/H1/V1_H1/V1_H1/V1, where Empty than the roots of the table are filled by DnD, H1 : means 1 category hidden and V1 means 1 category visible
	 * 
	 */
	public void checkFillingConfigurationAndHiddenCategoryForTestConsistency(Table table, String simpleClassName) {
		int index = simpleClassName.indexOf(FileUtils.UNDERSCORE);
		simpleClassName = simpleClassName.substring(index + 1);
		String[] result = simpleClassName.split(FileUtils.UNDERSCORE); // $NON-NLS-1$
		Assert.assertTrue(result.length == 3);
		for (int depth = 0; depth < 3; depth++) {
			String current = result[depth];
			// filled by DnD
			if (current.equals("Empty")) { //$NON-NLS-1$
				// no configuration
				Assert.assertTrue("We must not have filling configuration for depth==0", FillingConfigurationUtils.getAllTreeFillingConfigurationForDepth(table, 0).size() == 0); //$NON-NLS-1$
				// we can't hide a depth for which we don't have category

				Assert.assertTrue("The depth 0 can't be hidden", StyleUtils.isHiddenDepth(table, 0) == false);//$NON-NLS-1$
			} else {
				Assert.assertEquals(2, current.length());
				char visibility = current.charAt(0);
				char nbCategoriesForTheDepth = current.charAt(1);
				switch (visibility) {
				case 'H':
					Assert.assertTrue(NLS.bind("The depth {0} must be hidden", depth), true == StyleUtils.isHiddenDepth(table, depth));//$NON-NLS-1$
					break;
				case 'V':
					Assert.assertTrue(NLS.bind("The depth {0} must be visible", depth), false == StyleUtils.isHiddenDepth(table, depth));//$NON-NLS-1$
					break;
				default:
					Assert.assertTrue("Not supported case", false); //$NON-NLS-1$
				}
				// we check that we have the wanted number of filling categories
				List<TreeFillingConfiguration> confs = FillingConfigurationUtils.getAllTreeFillingConfigurationForDepth(table, depth);
				int nbConfig = confs.size();
				int wantedConfig = Integer.parseInt(String.valueOf(nbCategoriesForTheDepth));
				Assert.assertEquals(wantedConfig, nbConfig);
			}
		}
	}

	/**
	 * 
	 * @return
	 * 		the name of the file which contains the wanted contents of the clipboard after the copy to clipboard
	 */
	private String getInitialStateFileName() {
		URI uri = manager.getTable().eResource().getURI();
		uri = uri.trimFileExtension();
		StringBuffer buffer = new StringBuffer(uri.lastSegment());
		buffer.append(FileUtils.DOT_STRING);
		buffer.append(FileUtils.TEXT_EXTENSION);
		return buffer.toString();
	}

	/**
	 * @return
	 */
	private String getSourcePath() {
		return RESOURCES_PATH;
	}

	/**
	 * 
	 * @param fileName
	 *            a file name
	 * @return
	 * 		the text stored in the file associated to this test
	 */
	protected String getWantedString(String fileName) {
		return FileUtils.getStringFromPlatformFile(Activator.PLUGIN_ID, getSourcePath(), fileName, FileUtils.getSystemPropertyLineSeparator());// $NON-NLS-1$
	}


	/**
	 * 
	 * @return
	 * 		the clipboard contents
	 */
	protected String getClipboardContent() {
		String clipboard = TableClipboardUtils.getClipboardContentsAsString();
		return clipboard;
	}



	/**
	 * @see org.eclipse.papyrus.uml.nattable.clazz.config.tests.sort.AbstractSortTable#getResultFile_Name_ASC_SORT()
	 *
	 * @return
	 */

	protected String getResultFile_Name_ASC_SORT() {
		return createSortFileNameResult(NAME_ASC);
	}

	protected String getResultFile_Name_DESC_SORT() {
		return createSortFileNameResult(NAME_DESC);
	};

	protected String createSortFileNameResult(String fileNameSuffix) {
		URI uri = fixture.getActiveTableManager().getTable().eResource().getURI().trimFileExtension();
		String lastSegment = uri.lastSegment();
		StringBuffer buffer = new StringBuffer(lastSegment);
		buffer.append(FileUtils.UNDERSCORE);
		buffer.append(fileNameSuffix);
		buffer.append(FileUtils.DOT_STRING);
		buffer.append(FileUtils.TEXT_EXTENSION);
		return buffer.toString();
	}


}
