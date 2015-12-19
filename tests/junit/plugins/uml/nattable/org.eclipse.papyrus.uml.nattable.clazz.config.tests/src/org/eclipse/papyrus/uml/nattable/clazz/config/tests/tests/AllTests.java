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
 *  Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.clazz.config.tests.tests;

import org.eclipse.papyrus.uml.nattable.clazz.config.tests.bugs.AxisChangeIndexWithConfigurationTest;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.bugs.AxisChangeIndexWithoutConfigurationTest;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.bugs.DeleteRequirementsWithNestedClassifier;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.bugs.EditInvalidPastedText_V1_V3_V1;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.bugs.OpenAndDeleteTest;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.bugs.RequirementsNestedClassifier;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.creation.outside.CreateElementDepth0_H1_V3_V1_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.creation.outside.CreateElementDepth0_V1_V3_V1_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.creation.outside.CreateElementDepth1_H1_H3_V1_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.creation.outside.CreateElementDepth1_H1_V3_V1_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.creation.outside.CreateElementDepth1_V1_H3_V1_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.creation.outside.CreateElementDepth1_V1_V3_V1_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.creation.outside.CreateElementDepth2_H1_H3_H1_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.creation.outside.CreateElementDepth2_H1_H3_V1_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.creation.outside.CreateElementDepth2_H1_V3_H1_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.creation.outside.CreateElementDepth2_H1_V3_V1_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.creation.outside.CreateElementDepth2_V1_H3_H1_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.creation.outside.CreateElementDepth2_V1_H3_V1_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.creation.outside.CreateElementDepth2_V1_V3_H1_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.creation.outside.CreateElementDepth2_V1_V3_V1_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.filter.ReopenFilteredTable_Empty_H1_H1;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.filter.ReopenFilteredTable_Empty_H1_V1;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.filter.ReopenFilteredTable_Empty_V1_H1;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.filter.ReopenFilteredTable_Empty_V1_V1;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.filter.ReopenFilteredTable_H1_H1_H1;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.filter.ReopenFilteredTable_H1_H1_V1;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.filter.ReopenFilteredTable_H1_V1_H1;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.filter.ReopenFilteredTable_H1_V1_V1;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.filter.ReopenFilteredTable_V1_H1_H1;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.filter.ReopenFilteredTable_V1_H1_V1;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.filter.ReopenFilteredTable_V1_V1_H1;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.filter.ReopenFilteredTable_V1_V1_V1;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.markers.ValidationMarkerInTableHeaderTest;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_H1_H1_SingleColumn_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_H1_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_H1_V1_SingleColumn_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_H3_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_H3_V1_SingleColumn_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_V3_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_V3_H1_SingleColumn_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_V3_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_V3_V1_SingleColumn_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_H1_H1_SingleColumn_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_H1_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_H1_V1_SingleColumn_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_H3_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_H3_H1_SingleColumn_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_V3_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_V3_H1_SingleColumn_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_V3_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_V3_V1_SingleColumn_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_H1_H1_SingleColumn_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_H1_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_H1_V1_SingleColumn_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_V3_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_V3_H1_SingleColumn_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_V3_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_V3_V1_SingleColumn_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.sort.Sort_H1_H3_H1;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.sort.Sort_V1_V3_V1;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.unset.UnsetCellValueWithProfile_V1_V3_V1_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.unset.UnsetCellValue_H1_H3_H1_Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
		EditInvalidPastedText_V1_V3_V1.class,
		OpenTableTest.class,
		OpenAndDeleteTest.class,
		Bug_481017_ReloadEditorTest.class,

		SortAxisClassTreeTableTest.class,
		EditAxisClassTreeTableTest.class,
		
		// Bug 481023 : The nested requirement was not available in table
		RequirementsNestedClassifier.class,

		// Bug 481020 : Delete a requirement containing a nested requirement
		DeleteRequirementsWithNestedClassifier.class,

		ContentsAndExpandWithCategories_0_1_2_Tests.class,
		ContentsAndExpandWithoutCategories_H0_H1_H2_Tests.class,

		// SORT
		Sort_V1_V3_V1.class,
		Sort_H1_H3_H1.class,

		// Bug 473155 : change axis index style
		AxisChangeIndexWithConfigurationTest.class,
		AxisChangeIndexWithoutConfigurationTest.class,

		// reset cell value
		UnsetCellValueWithProfile_V1_V3_V1_Test.class,
		UnsetCellValue_H1_H3_H1_Test.class,

		// test creation outside of the table
		CreateElementDepth0_H1_V3_V1_Test.class,
		CreateElementDepth0_V1_V3_V1_Test.class,
		CreateElementDepth1_H1_H3_V1_Test.class,
		CreateElementDepth1_H1_V3_V1_Test.class,
		CreateElementDepth1_V1_H3_V1_Test.class,
		CreateElementDepth1_V1_V3_V1_Test.class,
		CreateElementDepth2_H1_H3_H1_Test.class,
		CreateElementDepth2_H1_H3_V1_Test.class,
		CreateElementDepth2_H1_V3_H1_Test.class,
		CreateElementDepth2_H1_V3_V1_Test.class,
		CreateElementDepth2_V1_H3_H1_Test.class,
		CreateElementDepth2_V1_H3_V1_Test.class,
		CreateElementDepth2_V1_V3_H1_Test.class,
		CreateElementDepth2_V1_V3_V1_Test.class,

		// filter tests
		ReopenFilteredTable_Empty_H1_H1.class,
		ReopenFilteredTable_Empty_H1_V1.class,
		ReopenFilteredTable_Empty_V1_H1.class,
		ReopenFilteredTable_Empty_V1_V1.class,
		ReopenFilteredTable_H1_H1_H1.class,
		ReopenFilteredTable_H1_H1_V1.class,
		ReopenFilteredTable_H1_V1_H1.class,
		ReopenFilteredTable_H1_V1_V1.class,
		ReopenFilteredTable_V1_H1_H1.class,
		ReopenFilteredTable_V1_H1_V1.class,
		ReopenFilteredTable_V1_V1_H1.class,
		ReopenFilteredTable_V1_V1_V1.class,

		// Paste tests for single column
		PasteWithCategories_Empty_H1_H1_SingleColumn_Test.class,
		PasteWithCategories_Empty_H1_V1_SingleColumn_Test.class,
		PasteWithCategories_Empty_H3_V1_SingleColumn_Test.class,
		PasteWithCategories_Empty_V3_H1_SingleColumn_Test.class,
		PasteWithCategories_Empty_V3_V1_SingleColumn_Test.class,

		PasteWithCategories_H1_H1_H1_SingleColumn_Test.class,
		PasteWithCategories_H1_H1_V1_SingleColumn_Test.class,
		PasteWithCategories_H1_H3_H1_SingleColumn_Test.class,
		PasteWithCategories_H1_V3_H1_SingleColumn_Test.class,
		PasteWithCategories_H1_V3_V1_SingleColumn_Test.class,

		PasteWithCategories_V1_H1_H1_SingleColumn_Test.class,
		PasteWithCategories_V1_H1_V1_SingleColumn_Test.class,
		PasteWithCategories_V1_V3_H1_SingleColumn_Test.class,
		PasteWithCategories_V1_V3_V1_SingleColumn_Test.class,

		// Paste tests for multi columns
		PasteWithCategories_Empty_H1_H1_MultiColumns_Test.class,
		PasteWithCategories_Empty_H1_V1_MultiColumns_Test.class,
		PasteWithCategories_Empty_H3_V1_MultiColumns_Test.class,
		PasteWithCategories_Empty_V3_H1_MultiColumns_Test.class,
		PasteWithCategories_Empty_V3_V1_MultiColumns_Test.class,

		PasteWithCategories_H1_H1_H1_MultiColumns_Test.class,
		PasteWithCategories_H1_H1_V1_MultiColumns_Test.class,
		PasteWithCategories_H1_H3_H1_MultiColumns_Test.class,
		PasteWithCategories_H1_V3_H1_MultiColumns_Test.class,
		PasteWithCategories_H1_V3_V1_MultiColumns_Test.class,

		PasteWithCategories_V1_H1_H1_MultiColumns_Test.class,
		PasteWithCategories_V1_H1_V1_MultiColumns_Test.class,
		PasteWithCategories_V1_V3_H1_MultiColumns_Test.class,
		PasteWithCategories_V1_V3_V1_MultiColumns_Test.class,

		// validation marker test
		ValidationMarkerInTableHeaderTest.class,
})
public class AllTests {
	// JUnit 4 test suite

}
