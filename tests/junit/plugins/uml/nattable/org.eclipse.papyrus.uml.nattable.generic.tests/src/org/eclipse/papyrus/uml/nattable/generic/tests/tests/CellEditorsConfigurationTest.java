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

package org.eclipse.papyrus.uml.nattable.generic.tests.tests;

import java.util.List;

import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
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
		
		int nbUMLCellEditors = checkUMLCellEditors(currentManager, 0);
		checkEMFCellEditors(currentManager, nbUMLCellEditors);
	}

	/**
	 * This allows to check the cell editors corresponding to UML Types.
	 * 
	 * @param currentManager the current nattable model manager.
	 * @param nbCellsBefore The number of cells before the first one.
	 */
	private int checkUMLCellEditors(final INattableModelManager currentManager, final int nbCellsBefore) {
		
		int currentCellNumber = nbCellsBefore;
		
		// The first cell must be an UMLStereotypeSingleUMLBooleanCellEditorConfiguration
		final ILayerCell cell0 = currentManager.getBodyLayerStack().getCellByPosition(currentCellNumber, 0);
		Assert.assertNotEquals("The first UML cell must have config labels", null, cell0.getConfigLabels()); //$NON-NLS-1$
		Assert.assertNotEquals("The first UML cell must have at least one cell editor configuration", 0, cell0.getConfigLabels().getLabels().size()); //$NON-NLS-1$
		Assert.assertEquals("The first UML cell editor must be an UMLStereotypeSingleUMLBooleanCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeSingleUMLBooleanCellEditorConfiguration.CheckBox" + currentCellNumber, //$NON-NLS-1$ //$NON-NLS-2$
				cell0.getConfigLabels().getLabels().get(0));
		currentCellNumber++;

		// The second cell must be an UMLStereotypeMultiUMLBooleanCellEditorConfiguration
		final ILayerCell cell1 = currentManager.getBodyLayerStack().getCellByPosition(currentCellNumber, 0);
		Assert.assertNotEquals("The second UML cell must have config labels", null, cell1.getConfigLabels()); //$NON-NLS-1$
		Assert.assertNotEquals("The second UML cell must have at least one cell editor configuration", 0, cell1.getConfigLabels().getLabels().size()); //$NON-NLS-1$
		Assert.assertEquals("The second UML cell editor must be an UMLStereotypeMultiUMLBooleanCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeMultiUMLBooleanCellEditorConfiguration.MultiEditor" + currentCellNumber, //$NON-NLS-1$ //$NON-NLS-2$
				cell1.getConfigLabels().getLabels().get(0));
		currentCellNumber++;

		// The third cell must be an UMLStereotypeSingleUMLEnumerationCellEditorConfiguration
		final ILayerCell cell2 = currentManager.getBodyLayerStack().getCellByPosition(currentCellNumber, 0);
		Assert.assertNotEquals("The third UML cell must have config labels", null, cell2.getConfigLabels()); //$NON-NLS-1$
		Assert.assertNotEquals("The third UML cell must have at least one cell editor configuration", 0, cell2.getConfigLabels().getLabels().size()); //$NON-NLS-1$
		Assert.assertEquals("The third UML cell editor must be an UMLStereotypeSingleUMLEnumerationCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeSingleUMLEnumerationCellEditorConfiguration.ComboBox" + currentCellNumber, //$NON-NLS-1$ //$NON-NLS-2$
				cell2.getConfigLabels().getLabels().get(0));
		currentCellNumber++;

		// The fourth cell must be an UMLStereotypeMultiUMLEnumerationCellEditorConfiguration
		final ILayerCell cell3 = currentManager.getBodyLayerStack().getCellByPosition(currentCellNumber, 0);
		Assert.assertNotEquals("The fourth UML cell must have config labels", null, cell3.getConfigLabels()); //$NON-NLS-1$
		Assert.assertNotEquals("The fourth UML cell must have at least one cell editor configuration", 0, cell3.getConfigLabels().getLabels().size()); //$NON-NLS-1$
		Assert.assertEquals("The fourth UML cell editor must be an UMLStereotypeMultiUMLEnumerationCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeMultiUMLEnumerationCellEditorConfiguration.MultiEditor" + currentCellNumber, //$NON-NLS-1$ //$NON-NLS-2$
				cell3.getConfigLabels().getLabels().get(0));
		currentCellNumber++;

		// The fifth cell must be an UMLStereotypeSingleUMLIntegerCellEditorConfiguration
		final ILayerCell cell4 = currentManager.getBodyLayerStack().getCellByPosition(currentCellNumber, 0);
		Assert.assertNotEquals("The fifth UML cell must have config labels", null, cell4.getConfigLabels()); //$NON-NLS-1$
		Assert.assertNotEquals("The fifth UML cell must have at least one cell editor configuration", 0, cell4.getConfigLabels().getLabels().size()); //$NON-NLS-1$
		Assert.assertEquals("The fifth UML cell editor must be an UMLStereotypeSingleUMLIntegerCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeSingleUMLIntegerCellEditorConfiguration.Text" + currentCellNumber, //$NON-NLS-1$ //$NON-NLS-2$
				cell4.getConfigLabels().getLabels().get(0));
		currentCellNumber++;

		// The sixth cell must be an UMLStereotypeMultiUMLIntegerCellEditorConfiguration
		final ILayerCell cell5 = currentManager.getBodyLayerStack().getCellByPosition(currentCellNumber, 0);
		Assert.assertNotEquals("The sixth UML cell must have config labels", null, cell5.getConfigLabels()); //$NON-NLS-1$
		Assert.assertNotEquals("The sixth UML cell must have at least one cell editor configuration", 0, cell5.getConfigLabels().getLabels().size()); //$NON-NLS-1$
		Assert.assertEquals("The sixth UML cell editor must be an UMLStereotypeMultiUMLIntegerCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeMultiUMLIntegerCellEditorConfiguration.MultiEditor" + currentCellNumber, //$NON-NLS-1$ //$NON-NLS-2$
				cell5.getConfigLabels().getLabels().get(0));
		currentCellNumber++;

		// The seventh cell must be an UMLStereotypeSingleUMLStringCellEditorConfiguration
		final ILayerCell cell6 = currentManager.getBodyLayerStack().getCellByPosition(currentCellNumber, 0);
		Assert.assertNotEquals("The seventh UML cell must have config labels", null, cell6.getConfigLabels()); //$NON-NLS-1$
		Assert.assertNotEquals("The seventh UML cell must have at least one cell editor configuration", 0, cell6.getConfigLabels().getLabels().size()); //$NON-NLS-1$
		Assert.assertEquals("The seventh UML cell editor must be an UMLStereotypeSingleUMLStringCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeSingleUMLStringCellEditorConfiguration.MultiLineText" + currentCellNumber, //$NON-NLS-1$ //$NON-NLS-2$
				cell6.getConfigLabels().getLabels().get(0));
		currentCellNumber++;

		// The height cell must be an UMLStereotypeMultiUMLStringCellEditorConfiguration
		final ILayerCell cell7 = currentManager.getBodyLayerStack().getCellByPosition(currentCellNumber, 0);
		Assert.assertNotEquals("The height UML cell must have config labels", null, cell7.getConfigLabels()); //$NON-NLS-1$
		Assert.assertNotEquals("The height UML cell must have at least one cell editor configuration", 0, cell7.getConfigLabels().getLabels().size()); //$NON-NLS-1$
		Assert.assertEquals("The height UML cell editor must be an UMLStereotypeMultiUMLStringCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeMultiUMLStringCellEditorConfiguration.MultiEditor" + currentCellNumber, //$NON-NLS-1$ //$NON-NLS-2$
				cell7.getConfigLabels().getLabels().get(0));
		currentCellNumber++;

		// The ninth cell must be an UMLStereotypeSingleUnlimitedNaturalCellEditorConfiguration
		final ILayerCell cell8 = currentManager.getBodyLayerStack().getCellByPosition(currentCellNumber, 0);
		Assert.assertNotEquals("The ninth UML cell must have config labels", null, cell8.getConfigLabels());
		Assert.assertNotEquals("The ninth UML cell must have at least one cell editor configuration", 0, cell8.getConfigLabels().getLabels().size());
		Assert.assertEquals("The ninth UML cell editor must be an UMLStereotypeSingleUnlimitedNaturalCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeSingleUnlimitedNaturalCellEditorConfiguration.Text" + currentCellNumber, //$NON-NLS-1$ //$NON-NLS-2$
				cell8.getConfigLabels().getLabels().get(0));
		currentCellNumber++;

		// The tenth cell must be an UMLStereotypeMultiUnlimitedNaturalCellEditorConfiguration
		final ILayerCell cell9 = currentManager.getBodyLayerStack().getCellByPosition(currentCellNumber, 0);
		Assert.assertNotEquals("The tenth UML cell must have config labels", null, cell9.getConfigLabels());
		Assert.assertNotEquals("The tenth UML cell must have at least one cell editor configuration", 0, cell9.getConfigLabels().getLabels().size());
		Assert.assertEquals("The tenth UML cell editor must be an UMLStereotypeMultiUnlimitedNaturalCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeMultiUnlimitedNaturalCellEditorConfiguration.MultiEditor" + currentCellNumber, //$NON-NLS-1$ //$NON-NLS-2$
				cell9.getConfigLabels().getLabels().get(0));
		currentCellNumber++;
		
		// The eleventh cell must be an UMLStereotypeSingleRealCellEditorConfiguration
		final ILayerCell cell10 = currentManager.getBodyLayerStack().getCellByPosition(currentCellNumber, 0);
		Assert.assertNotEquals("The eleventh UML cell must have config labels", null, cell10.getConfigLabels());
		Assert.assertNotEquals("The eleventh UML cell must have at least one cell editor configuration", 0, cell10.getConfigLabels().getLabels().size());
		Assert.assertEquals("The eleventh UML cell editor must be an UMLStereotypeSingleRealCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeSingleRealCellEditorConfiguration.Text" + currentCellNumber, //$NON-NLS-1$ //$NON-NLS-2$
				cell10.getConfigLabels().getLabels().get(0));
		currentCellNumber++;

		// The twelveth cell must be an UMLStereotypeSingleRealCellEditorConfiguration
		final ILayerCell cell11 = currentManager.getBodyLayerStack().getCellByPosition(currentCellNumber, 0);
		Assert.assertNotEquals("The twelveth UML cell must have config labels", null, cell11.getConfigLabels());
		Assert.assertNotEquals("The twelveth UML cell must have at least one cell editor configuration", 0, cell11.getConfigLabels().getLabels().size());
		Assert.assertEquals("The twelveth UML cell editor must be an UMLStereotypeMultiRealCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeMultiRealCellEditorConfiguration.MultiEditor" + currentCellNumber, //$NON-NLS-1$ //$NON-NLS-2$
				cell11.getConfigLabels().getLabels().get(0));
		currentCellNumber++;

		// The thirteenth cell must be an UMLStereotypeMultiRealCellEditorConfiguration
		final ILayerCell cell12 = currentManager.getBodyLayerStack().getCellByPosition(currentCellNumber, 0);
		Assert.assertNotEquals("The thirteenth UML cell must have config labels", null, cell12.getConfigLabels());
		Assert.assertNotEquals("The thirteenth UML cell must have at least one cell editor configuration", 0, cell12.getConfigLabels().getLabels().size());
		Assert.assertEquals("The thirteenth UML cell editor must be an UMLStereotypeSingleUMLReferenceCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeSingleUMLReferenceCellEditorConfiguration.Reference" + currentCellNumber, //$NON-NLS-1$ //$NON-NLS-2$
				cell12.getConfigLabels().getLabels().get(0));
		currentCellNumber++;

		// The fourteenth cell must be an UMLStereotypeMultiUMLReferenceCellEditorConfiguration
		final ILayerCell cell13 = currentManager.getBodyLayerStack().getCellByPosition(currentCellNumber, 0);
		Assert.assertNotEquals("The fourteenth UML cell must have config labels", null, cell13.getConfigLabels());
		Assert.assertNotEquals("The fourteenth UML cell must have at least one cell editor configuration", 0, cell13.getConfigLabels().getLabels().size());
		Assert.assertEquals("The fourteenth UML cell editor must be an UMLStereotypeMultiUMLReferenceCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeMultiUMLReferenceCellEditorConfiguration.MultiEditor" + currentCellNumber, //$NON-NLS-1$ //$NON-NLS-2$
				cell13.getConfigLabels().getLabels().get(0));
		currentCellNumber++;
		
		return currentCellNumber;
	}
	
	/**
	 * This allows to check the cell editors corresponding to EMF Types.
	 * 
	 * @param currentManager The current nattable model manager.
	 * @param nbCellsBefore The number of cells before the first one.
	 */
	private int checkEMFCellEditors(final INattableModelManager currentManager, final int nbCellsBefore) {
		
		int currentCellNumber = nbCellsBefore;
		
		// The first cell must be an UMLStereotypeSingleBooleanCellEditorConfiguration
		final ILayerCell cell0 = currentManager.getBodyLayerStack().getCellByPosition(currentCellNumber, 0);
		Assert.assertNotEquals("The first EMF cell must have config labels", null, cell0.getConfigLabels()); //$NON-NLS-1$
		Assert.assertNotEquals("The first EMF cell must have at least one cell editor configuration", 0, cell0.getConfigLabels().getLabels().size()); //$NON-NLS-1$
		Assert.assertEquals("The first EMF cell editor must be an UMLStereotypeSingleBooleanCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeSingleBooleanCellEditorConfiguration.CheckBox" + currentCellNumber, //$NON-NLS-1$ //$NON-NLS-2$
				cell0.getConfigLabels().getLabels().get(0));
		currentCellNumber++;

		// The second cell must be an UMLStereotypeMultiBooleanCellEditorConfiguration
		final ILayerCell cell1 = currentManager.getBodyLayerStack().getCellByPosition(currentCellNumber, 0);
		Assert.assertNotEquals("The second EMF cell must have config labels", null, cell1.getConfigLabels()); //$NON-NLS-1$
		Assert.assertNotEquals("The second EMF cell must have at least one cell editor configuration", 0, cell1.getConfigLabels().getLabels().size()); //$NON-NLS-1$
		Assert.assertEquals("The second EMF cell editor must be an UMLStereotypeMultiBooleanCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeMultiBooleanCellEditorConfiguration.MultiEditor" +currentCellNumber, //$NON-NLS-1$ //$NON-NLS-2$
				cell1.getConfigLabels().getLabels().get(0));
		currentCellNumber++;
		
		// The third cell must be an UMLStereotypeSingleIntegerCellEditorConfiguration
		final ILayerCell cell2 = currentManager.getBodyLayerStack().getCellByPosition(currentCellNumber, 0);
		Assert.assertNotEquals("The third EMF cell must have config labels", null, cell2.getConfigLabels()); //$NON-NLS-1$
		Assert.assertNotEquals("The third EMF cell must have at least one cell editor configuration", 0, cell2.getConfigLabels().getLabels().size()); //$NON-NLS-1$
		Assert.assertEquals("The third EMF cell editor must be an UMLStereotypeSingleIntegerCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeSingleIntegerCellEditorConfiguration.Text" + currentCellNumber, //$NON-NLS-1$ //$NON-NLS-2$
				cell2.getConfigLabels().getLabels().get(0));
		currentCellNumber++;

		// The fourth cell must be an UMLStereotypeMultiIntegerCellEditorConfiguration
		final ILayerCell cell3 = currentManager.getBodyLayerStack().getCellByPosition(currentCellNumber, 0);
		Assert.assertNotEquals("The fourth EMF cell must have config labels", null, cell3.getConfigLabels()); //$NON-NLS-1$
		Assert.assertNotEquals("The fourth EMF cell must have at least one cell editor configuration", 0, cell3.getConfigLabels().getLabels().size()); //$NON-NLS-1$
		Assert.assertEquals("The fourth EMF cell editor must be an UMLStereotypeMultiIntegerCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeMultiIntegerCellEditorConfiguration.MultiEditor" + currentCellNumber, //$NON-NLS-1$ //$NON-NLS-2$
				cell3.getConfigLabels().getLabels().get(0));
		currentCellNumber++;

		// The fifth cell must be an UMLStereotypeSingleStringCellEditorConfiguration
		final ILayerCell cell4 = currentManager.getBodyLayerStack().getCellByPosition(currentCellNumber, 0);
		Assert.assertNotEquals("The fifth EMF cell must have config labels", null, cell4.getConfigLabels()); //$NON-NLS-1$
		Assert.assertNotEquals("The fifth EMF cell must have at least one cell editor configuration", 0, cell4.getConfigLabels().getLabels().size()); //$NON-NLS-1$
		Assert.assertEquals("The fifth EMF cell editor must be an UMLStereotypeSingleStringCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeSingleStringCellEditorConfiguration.MultiLineText" + currentCellNumber, //$NON-NLS-1$ //$NON-NLS-2$
				cell4.getConfigLabels().getLabels().get(0));
		currentCellNumber++;

		// The sixth cell must be an UMLStereotypeMultiStringCellEditorConfiguration
		final ILayerCell cell5 = currentManager.getBodyLayerStack().getCellByPosition(currentCellNumber, 0);
		Assert.assertNotEquals("The sixth EMF cell must have config labels", null, cell5.getConfigLabels()); //$NON-NLS-1$
		Assert.assertNotEquals("The sixth EMF cell must have at least one cell editor configuration", 0, cell5.getConfigLabels().getLabels().size()); //$NON-NLS-1$
		Assert.assertEquals("The sixth EMF cell editor must be an UMLStereotypeMultiStringCellEditorConfiguration", "org.eclipse.papyrus.uml.nattable.celleditor.configuration.UMLStereotypeMultiStringCellEditorConfiguration.MultiEditor" + currentCellNumber, //$NON-NLS-1$ //$NON-NLS-2$
				cell5.getConfigLabels().getLabels().get(0));
		currentCellNumber++;
		
		return currentCellNumber;

	}
}
