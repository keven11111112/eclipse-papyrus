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

package org.eclipse.papyrus.uml.nattable.generic.tests.bugs;

import java.util.List;

import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.nattable.common.editor.NatTableEditor;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.junit.utils.TableUtils;
import org.eclipse.papyrus.junit.utils.rules.PapyrusEditorFixture;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.ui.IEditorPart;
import org.eclipse.uml2.uml.Model;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * This allows to test the cell editors containing for all cells.
 */
@PluginResource("resources/cellEditors/CellEditorsConfiguration.di")
public class CellEditorsConfigurationTest extends AbstractPapyrusTest {

	/**
	 * The table name.
	 */
	private static final String TABLE_NAME = "GenericTable0"; //$NON-NLS-1$

	/**
	 * The papyrus fixture.
	 */
	@Rule
	public final PapyrusEditorFixture fixture = new PapyrusEditorFixture();

	/**
	 * Constructor.
	 */
	public CellEditorsConfigurationTest() {
		super();
	}

	/**
	 * This allow to initialize the tests.
	 */
	@Before
	public void init() {
		final Model model = (Model) fixture.getModel();
		Assert.assertNotNull("RootModel is null", model); //$NON-NLS-1$

		// Get the table and open it
		Table mainTable = TableUtils.getNotationFirstTable(fixture.getModelSet(), TABLE_NAME);
		fixture.getPageManager().openPage(mainTable);
		fixture.flushDisplayEvents();
	}

	/**
	 * The test for the change index of the column.
	 * 
	 * @throws Exception
	 *             The exception.
	 */
	@Test
	public void testCellEditorsConfigruation() throws Exception {
		// Open the table and get the manager
		IPageManager pageManager = fixture.getPageManager();
		List<Object> pages = pageManager.allPages();
		pageManager.openPage(pages.get(0));
		IEditorPart part = fixture.getEditor().getActiveEditor();
		Assert.assertTrue(part instanceof NatTableEditor);
		NatTableEditor editor = (NatTableEditor) part;
		INattableModelManager currentManager = (INattableModelManager) editor.getAdapter(INattableModelManager.class);
		Assert.assertTrue(currentManager instanceof INattableModelManager);

		// The first cell must be an UMLStereotypeSingleBooleanCellEditorConfiguration
		ILayerCell cell0 = currentManager.getBodyLayerStack().getCellByPosition(0, 0);
		Assert.assertNotEquals("The first cell must have config labels", null, cell0.getConfigLabels()); //$NON-NLS-1$
		Assert.assertNotEquals("The first cell must have at least one cell editor configuration", 0, cell0.getConfigLabels().getLabels().size()); //$NON-NLS-1$
		Assert.assertEquals("The first cell editor must be an UMLStereotypeSingleBooleanCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeSingleBooleanCellEditorConfiguration.CheckBox0", //$NON-NLS-1$ //$NON-NLS-2$
				cell0.getConfigLabels().getLabels().get(0));

		// The second cell must be an UMLStereotypeMultiBooleanCellEditorConfiguration
		ILayerCell cell1 = currentManager.getBodyLayerStack().getCellByPosition(1, 0);
		Assert.assertNotEquals("The second cell must have config labels", null, cell1.getConfigLabels()); //$NON-NLS-1$
		Assert.assertNotEquals("The second cell must have at least one cell editor configuration", 0, cell1.getConfigLabels().getLabels().size()); //$NON-NLS-1$
		Assert.assertEquals("The second cell editor must be an UMLStereotypeMultiBooleanCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeMultiBooleanCellEditorConfiguration.MultiEditor1", //$NON-NLS-1$ //$NON-NLS-2$
				cell1.getConfigLabels().getLabels().get(0));

		// The third cell must be an UMLStereotypeSingleUMLEnumerationCellEditorConfiguration
		ILayerCell cell2 = currentManager.getBodyLayerStack().getCellByPosition(2, 0);
		Assert.assertNotEquals("The third cell must have config labels", null, cell2.getConfigLabels()); //$NON-NLS-1$
		Assert.assertNotEquals("The third cell must have at least one cell editor configuration", 0, cell2.getConfigLabels().getLabels().size()); //$NON-NLS-1$
		Assert.assertEquals("The third cell editor must be an UMLStereotypeSingleUMLEnumerationCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeSingleUMLEnumerationCellEditorConfiguration.ComboBox2", //$NON-NLS-1$ //$NON-NLS-2$
				cell2.getConfigLabels().getLabels().get(0));

		// The fourth cell must be an UMLStereotypeMultiUMLEnumerationCellEditorConfiguration
		ILayerCell cell3 = currentManager.getBodyLayerStack().getCellByPosition(3, 0);
		Assert.assertNotEquals("The fourth cell must have config labels", null, cell3.getConfigLabels()); //$NON-NLS-1$
		Assert.assertNotEquals("The fourth cell must have at least one cell editor configuration", 0, cell3.getConfigLabels().getLabels().size()); //$NON-NLS-1$
		Assert.assertEquals("The fourth cell editor must be an UMLStereotypeMultiUMLEnumerationCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeMultiUMLEnumerationCellEditorConfiguration.MultiEditor3", //$NON-NLS-1$ //$NON-NLS-2$
				cell3.getConfigLabels().getLabels().get(0));

		// The fifth cell must be an UMLStereotypeSingleIntegerCellEditorConfiguration
		ILayerCell cell4 = currentManager.getBodyLayerStack().getCellByPosition(4, 0);
		Assert.assertNotEquals("The fifth cell must have config labels", null, cell4.getConfigLabels()); //$NON-NLS-1$
		Assert.assertNotEquals("The fifth cell must have at least one cell editor configuration", 0, cell4.getConfigLabels().getLabels().size()); //$NON-NLS-1$
		Assert.assertEquals("The fifth cell editor must be an UMLStereotypeSingleIntegerCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeSingleIntegerCellEditorConfiguration.Text4", //$NON-NLS-1$ //$NON-NLS-2$
				cell4.getConfigLabels().getLabels().get(0));

		// The sixth cell must be an UMLStereotypeMultiIntegerCellEditorConfiguration
		ILayerCell cell5 = currentManager.getBodyLayerStack().getCellByPosition(5, 0);
		Assert.assertNotEquals("The sixth cell must have config labels", null, cell5.getConfigLabels()); //$NON-NLS-1$
		Assert.assertNotEquals("The sixth cell must have at least one cell editor configuration", 0, cell5.getConfigLabels().getLabels().size()); //$NON-NLS-1$
		Assert.assertEquals("The sixth cell editor must be an UMLStereotypeMultiIntegerCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeMultiIntegerCellEditorConfiguration.MultiEditor5", //$NON-NLS-1$ //$NON-NLS-2$
				cell5.getConfigLabels().getLabels().get(0));

		// The seventh cell must be an UMLStereotypeSingleStringCellEditorConfiguration
		ILayerCell cell6 = currentManager.getBodyLayerStack().getCellByPosition(6, 0);
		Assert.assertNotEquals("The seventh cell must have config labels", null, cell6.getConfigLabels()); //$NON-NLS-1$
		Assert.assertNotEquals("The seventh cell must have at least one cell editor configuration", 0, cell6.getConfigLabels().getLabels().size()); //$NON-NLS-1$
		Assert.assertEquals("The seventh cell editor must be an UMLStereotypeSingleStringCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeSingleStringCellEditorConfiguration.MultiLineText6", //$NON-NLS-1$ //$NON-NLS-2$
				cell6.getConfigLabels().getLabels().get(0));

		// The height cell must be an UMLStereotypeMultiStringCellEditorConfiguration
		ILayerCell cell7 = currentManager.getBodyLayerStack().getCellByPosition(7, 0);
		Assert.assertNotEquals("The height cell must have config labels", null, cell7.getConfigLabels()); //$NON-NLS-1$
		Assert.assertNotEquals("The height cell must have at least one cell editor configuration", 0, cell7.getConfigLabels().getLabels().size()); //$NON-NLS-1$
		Assert.assertEquals("The height cell editor must be an UMLStereotypeMultiStringCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeMultiStringCellEditorConfiguration.MultiEditor7", //$NON-NLS-1$ //$NON-NLS-2$
				cell7.getConfigLabels().getLabels().get(0));

		// The ninth cell must be an UMLStereotypeSingleUnlimitedNaturalCellEditorConfiguration
		ILayerCell cell8 = currentManager.getBodyLayerStack().getCellByPosition(8, 0);
		Assert.assertNotEquals("The ninth cell must have config labels", null, cell8.getConfigLabels());
		Assert.assertNotEquals("The ninth cell must have at least one cell editor configuration", 0, cell8.getConfigLabels().getLabels().size());
		Assert.assertEquals("The ninth cell editor must be an UMLStereotypeSingleUnlimitedNaturalCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeSingleUnlimitedNaturalCellEditorConfiguration.Text8", //$NON-NLS-1$ //$NON-NLS-2$
				cell8.getConfigLabels().getLabels().get(0));

		// The tenth cell must be an UMLStereotypeMultiUnlimitedNaturalCellEditorConfiguration
		ILayerCell cell9 = currentManager.getBodyLayerStack().getCellByPosition(9, 0);
		Assert.assertNotEquals("The tenth cell must have config labels", null, cell9.getConfigLabels());
		Assert.assertNotEquals("The tenth cell must have at least one cell editor configuration", 0, cell9.getConfigLabels().getLabels().size());
		Assert.assertEquals("The tenth cell editor must be an UMLStereotypeMultiUnlimitedNaturalCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeMultiUnlimitedNaturalCellEditorConfiguration.MultiEditor9", //$NON-NLS-1$ //$NON-NLS-2$
				cell9.getConfigLabels().getLabels().get(0));
		
		// The eleventh cell must be an UMLStereotypeSingleUMLReferenceCellEditorConfiguration
		ILayerCell cell10 = currentManager.getBodyLayerStack().getCellByPosition(10, 0);
		Assert.assertNotEquals("The eleventh cell must have config labels", null, cell10.getConfigLabels());
		Assert.assertNotEquals("The eleventh cell must have at least one cell editor configuration", 0, cell10.getConfigLabels().getLabels().size());
		Assert.assertEquals("The eleventh cell editor must be an UMLStereotypeSingleUMLReferenceCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeSingleUMLReferenceCellEditorConfiguration.Reference10", //$NON-NLS-1$ //$NON-NLS-2$
				cell10.getConfigLabels().getLabels().get(0));

		// The twelveth cell must be an UMLStereotypeMultiUMLReferenceCellEditorConfiguration
		ILayerCell cell11 = currentManager.getBodyLayerStack().getCellByPosition(11, 0);
		Assert.assertNotEquals("The twelveth cell must have config labels", null, cell11.getConfigLabels());
		Assert.assertNotEquals("The twelveth cell must have at least one cell editor configuration", 0, cell11.getConfigLabels().getLabels().size());
		Assert.assertEquals("The twelveth cell editor must be an UMLStereotypeMultiUMLReferenceCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeMultiUMLReferenceCellEditorConfiguration.MultiEditor11", //$NON-NLS-1$ //$NON-NLS-2$
				cell11.getConfigLabels().getLabels().get(0));
	}
}
