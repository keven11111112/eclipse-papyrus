/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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

package org.eclipse.papyrus.uml.nattable.matrix.tests.tests;

import java.util.Collections;
import java.util.List;

import org.eclipse.papyrus.infra.nattable.manager.table.IMatrixTableWidgetManager;
import org.eclipse.papyrus.infra.nattable.tree.CollapseAndExpandActionsEnum;
import org.eclipse.papyrus.junit.framework.classification.InvalidTest;
import org.eclipse.papyrus.junit.utils.rules.ActiveTable;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.Assert;
import org.junit.Test;

/**
 * This class tests the update of an existing table after editing the row sources
 */
@PluginResource("resources/updateTableContentsAfterRowsSourceChangeTests/updateTableContentsAfterRowsSourceChange.di")
public class UpdateTableAfterEditingRowSourceTest extends AbstractTableTest {

	private static final int NB_CLASSES_IN_PACKAGE1_ROWS_SOURCES = 4;

	private static final int NB_CLASSES_IN_PACKAGE2_ROWS_SOURCES = 5;

	private static final int NB_COLUMNS = 4;

	private NamedElement package1_Rows_Sources;

	private NamedElement package2_Rows_Sources;

	private static final String PACKAGE1_ROWS_SOURCES_NAME = "Package1_RowsSource"; //$NON-NLS-1$

	private static final String PACKAGE2_ROWS_SOURCES_NAME = "Package2_RowsSource"; //$NON-NLS-1$

	/**
	 * @see org.eclipse.papyrus.uml.nattable.matrix.tests.tests.AbstractTableTest#getSourcePath()
	 *
	 * @return
	 */
	@Override
	protected String getSourcePath() {
		return "updateTableContentsAfterRowsSourceChangeTests"; //$NON-NLS-1$
	}

	/**
	 * This JUnit tests check the opening of an existing matrix
	 */
	@Test
	@ActiveTable("Relationship Generic Matrix")
	public void testOpeningMatrix() {
		initTest();
		final List<Object> rowElementsList = this.manager.getRowElementsList();
		final List<Object> columnElementsList = this.manager.getColumnElementsList();
		Assert.assertEquals("The number of rows is not the expected one.", NB_CLASSES_IN_PACKAGE1_ROWS_SOURCES + 1 + 1, rowElementsList.size()); //$NON-NLS-1$ //+1 for tree filling + for the root package
		Assert.assertEquals("The number of columns is not the expected one.", NB_COLUMNS, columnElementsList.size()); //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.papyrus.uml.nattable.matrix.tests.tests.AbstractTableTest#initTest()
	 *
	 */
	@Override
	public void initTest() {
		super.initTest();
		this.package1_Rows_Sources = this.fixture.getModel().getMember(PACKAGE1_ROWS_SOURCES_NAME);
		this.package2_Rows_Sources = this.fixture.getModel().getMember(PACKAGE2_ROWS_SOURCES_NAME);
		Assert.assertNotNull(this.package1_Rows_Sources);
		Assert.assertNotNull(this.package2_Rows_Sources);

	}


	/**
	 * This JUnit tests check the opening of an existing matrix
	 * 
	 * @throws Exception
	 */
	@Test
	@ActiveTable("Relationship Generic Matrix")
	@InvalidTest // file not found
	public void testMatrixContents() throws Exception {
		initTest();

		// file is not found... I don't know why
		checkTableContent(manager, "_Package1AsSource"); //$NON-NLS-1$
	}

	/**
	 * This JUnit tests check the opening of an existing matrix
	 * 
	 * @throws Exception
	 */
	@Test
	@ActiveTable("Relationship Generic Matrix")
	@InvalidTest // not finish to write
	public void testMatrixRemovingAllRowSources() throws Exception {
		initTest();
		IMatrixTableWidgetManager matrixManager = (IMatrixTableWidgetManager) manager;
		matrixManager.removeRowSources(Collections.singleton(this.package1_Rows_Sources));
		// TODO : check there are no source wrapper
		// TODO : check there are no ITreeItemAxis stored for the rows

		// + UNDO/Redo and check
	}

	/**
	 * This JUnit tests check the opening of an existing matrix
	 * 
	 * @throws Exception
	 */
	@Test
	@ActiveTable("Relationship Generic Matrix")
	@InvalidTest //// not finish to write
	public void testMatrixAddPackage2AsSourceRowSources() throws Exception {
		initTest();
		IMatrixTableWidgetManager matrixManager = (IMatrixTableWidgetManager) manager;
		matrixManager.removeRowSources(Collections.singleton(this.package2_Rows_Sources));
		// TODO : check source wrapper contains P1 and P2
		// TODO : check ITreeItemAxis contains P1 and P2

		manager.doCollapseExpandAction(CollapseAndExpandActionsEnum.EXPAND_ALL, null);
		checkTableContent(manager, "_Package1AndPackage2ASource"); //$NON-NLS-1$

		// + UNDO/Redo and check
	}

}
