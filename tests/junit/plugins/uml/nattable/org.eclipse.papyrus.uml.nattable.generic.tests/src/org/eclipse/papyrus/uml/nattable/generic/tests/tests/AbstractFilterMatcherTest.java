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

package org.eclipse.papyrus.uml.nattable.generic.tests.tests;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.edit.command.UpdateDataCommand;
import org.eclipse.papyrus.commands.OpenDiagramCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.infra.nattable.common.editor.NatTableEditor;
import org.eclipse.papyrus.infra.nattable.filter.FilterPreferences;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.utils.TableEditingDomainUtils;
import org.eclipse.papyrus.junit.utils.EditorUtils;
import org.eclipse.papyrus.junit.utils.GenericUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.papyrus.uml.nattable.generic.tests.Activator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.junit.AfterClass;
import org.junit.Assert;
import org.osgi.framework.Bundle;

/**
 * Abstract Class used to test filter
 *
 */
public abstract class AbstractFilterMatcherTest extends AbstractGenericTableTest {

	/**
	 * the path where the Papyrus model to test are stored
	 */
	public static final String PATH = "/resources/filter/"; //$NON-NLS-1$


	public void initModel() throws Exception {
		initModel("table", getClass().getSimpleName(), getBundle()); //$NON-NLS-1$

		// this test work only for false
		Assert.assertTrue(!FilterPreferences.displayInconsistentValueWithFilter(null));
//		openGenericTableForTest();
		loadGenericTable(); //$NON-NLS-1$ //$NON-NLS-2$
		flushDisplayEvents();
		//this test work only for false
		Assert.assertTrue(!FilterPreferences.displayInconsistentValueWithFilter(null));
	}

	public void initModelWithAdditionalModels(Collection<String> otherModelToLoad) throws Exception {
		initModelWithAdditionalModels("table", getClass().getSimpleName(), getBundle(), otherModelToLoad); //$NON-NLS-1$
//		openGenericTableForTest();
		loadGenericTable(); //$NON-NLS-1$ //$NON-NLS-2$
		flushDisplayEvents();
		//this test work only for false
		Assert.assertTrue(!FilterPreferences.displayInconsistentValueWithFilter(null));
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.generic.tests.tests.AbstractGenericTableTest#getSourcePath()
	 *
	 * @return
	 *         the folder where the model are stored
	 */
	@Override
	protected String getSourcePath() {
		return PATH;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.generic.tests.tests.AbstractGenericTableTest#getBundle()
	 *
	 * @return
	 *         the curernt bundler
	 */
	@Override
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	/**
	 * Close all the opened editors
	 */
	@AfterClass
	public static void endOfTest() {
		GenericUtils.closeAllEditors();
	}

	/**
	 * 
	 * @param tableManager
	 *            the table manager
	 * @return
	 *         the nattable widget to use
	 */
	protected NatTable getNatTable(INattableModelManager tableManager) {
		NatTable natTable = (NatTable) tableManager.getAdapter(NatTable.class);
		return natTable;
	}

	/**
	 * 
	 * @param matchOn
	 *            the filter value : the object on which we do the math
	 * @param columnPosition
	 *            the position of the filtered column
	 * @param rowPosition
	 *            the row position of the filter
	 * @param nbElementsInTheTable
	 *            the initial number of elements in the table
	 * @param nbMatchingElement
	 *            the number of elements matching the filter
	 * @throws Exception
	 */
	protected void checkFilter(Object matchOn, int columnPosition, int rowPosition, int nbElementsInTheTable, int nbMatchingElement) throws Exception {
		INattableModelManager manager = getTableManager();
		List<Object> elements = manager.getRowElementsList();
		Assert.assertEquals(nbElementsInTheTable, elements.size());
		checkUnicityOfElements(elements);

		NatTable natTable = getNatTable(manager);

		// 1. we apply the filter
		natTable.getLayer().doCommand(new UpdateDataCommand(natTable.getLayer(), columnPosition, rowPosition, matchOn));
		flushDisplayEvents();

		// 2. we check the result
		checkUnicityOfElements(elements);
		int newSize = elements.size();
		Assert.assertEquals(nbMatchingElement, newSize);

		// 3. we undo the filter
		TransactionalEditingDomain domain = TableEditingDomainUtils.getTableEditingDomain(manager.getTable());
		domain.getCommandStack().undo();
		flushDisplayEvents();

		// 4. we check the undo result
		checkUnicityOfElements(elements);
		newSize = elements.size();
		Assert.assertEquals(nbElementsInTheTable, newSize);

		// 5. we reapply the filter
		domain.getCommandStack().redo();
		flushDisplayEvents();

		// 6. we check the result
		newSize = elements.size();
		Assert.assertEquals(nbMatchingElement, newSize);
	}

	/**
	 * 
	 * @param rowElements
	 * 
	 *            This method check than the row elements list doesn't contain duplicated elements
	 */
	protected void checkUnicityOfElements(List<?> rowElements) {
		int initialSize = rowElements.size();
		Set<Object> set = new HashSet<Object>();
		for (Object current : rowElements) {
			set.add(current);
		}
		Assert.assertEquals("Some objects seems duplicated in the row elements list", initialSize, set.size()); //$NON-NLS-1$
	}
}
