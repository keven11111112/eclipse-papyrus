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
package org.eclipse.papyrus.uml.nattable.generic.tests.tests;

import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.eclipse.papyrus.uml.nattable.generic.tests.bugs.AddElementsOnConnectedTableTest;
import org.eclipse.papyrus.uml.nattable.generic.tests.bugs.AxisChangeIndexWithConfigurationTest;
import org.eclipse.papyrus.uml.nattable.generic.tests.bugs.AxisChangeIndexWithoutConfigurationTest;
import org.eclipse.papyrus.uml.nattable.generic.tests.bugs.CellEditorsConfigurationTest;
import org.eclipse.papyrus.uml.nattable.generic.tests.bugs.EnumerationContentItemsTest;
import org.eclipse.papyrus.uml.nattable.generic.tests.bugs.InvertedAxisChangeIndexWithConfigurationTest;
import org.eclipse.papyrus.uml.nattable.generic.tests.bugs.InvertedAxisChangeIndexWithoutConfigurationTest;
import org.eclipse.papyrus.uml.nattable.generic.tests.bugs.OpenAndDeleteTest;
import org.eclipse.papyrus.uml.nattable.generic.tests.bugs.StereotypeInheritDisplayTest;
import org.eclipse.papyrus.uml.nattable.generic.tests.importfile.ImportCellsAll_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.importfile.ImportEmptyAddAll_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.importfile.ImportEmptyReplaceAll_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.importfile.ImportEmptySkipAll_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.importfile.ImportRowsAddAll_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.importfile.ImportRowsReplaceAll_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.importfile.ImportRowsSkipAll_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.insert.InsertEmptyAddAll_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.insert.InsertEmptyAxisIdentifierNotExisting_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.insert.InsertEmptyClipboard_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.insert.InsertEmptyFailColumns_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.insert.InsertEmptyReplaceAll_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.insert.InsertEmptySkipAll_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.insert.InsertEmptyWarningNotExisting_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.insert.InsertRowsAddAll_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.insert.InsertRowsAxisIdentifierNotExisting_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.insert.InsertRowsFailColumns_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.insert.InsertRowsFailRows_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.insert.InsertRowsReplaceAll_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.insert.InsertRowsSkipAll_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.insert.InsertRowsWarningNotExisting_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.paste.overwrite.PasteCellsOverwriteAll_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.paste.overwrite.PasteCellsOverwriteByOneLine_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.paste.overwrite.PasteCellsOverwriteFailColumns_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.paste.overwrite.PasteCellsOverwriteFailRows_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.paste.overwrite.PasteColumnsOverwriteAll_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.paste.overwrite.PasteColumnsOverwriteFailColumns_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.paste.overwrite.PasteColumnsOverwriteFailRows_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.paste.overwrite.PasteEmptyClipboard_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.paste.overwrite.PasteEmptyOverwriteAddAll_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.paste.overwrite.PasteEmptyOverwriteAxisIdentifierNotExisting_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.paste.overwrite.PasteEmptyOverwriteFailColumns_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.paste.overwrite.PasteEmptyOverwriteReplaceAll_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.paste.overwrite.PasteEmptyOverwriteSkipAll_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.paste.overwrite.PasteEmptyOverwriteWarningNotExisting_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.paste.overwrite.PasteRowsOverwriteAll_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.paste.overwrite.PasteRowsOverwriteAxisIdentifierNotExisting_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.paste.overwrite.PasteRowsOverwriteFailColumns_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.paste.overwrite.PasteRowsOverwriteFailRows_Test;
import org.eclipse.papyrus.uml.nattable.generic.tests.paste.overwrite.PasteRowsOverwriteWarningNotExisting_Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(ClassificationSuite.class)
@SuiteClasses({
		SortAxisGenericTableTest.class,
		InvertAxisGenericTableTest.class,
		EditAxisGenericTableTest.class,
		OpenAndDeleteTest.class,
		AddElementsOnConnectedTableTest.class,
		Bug458492_Edition_Enumeration.class,
		AxisChangeIndexWithConfigurationTest.class,
		AxisChangeIndexWithoutConfigurationTest.class,
		InvertedAxisChangeIndexWithConfigurationTest.class,
		InvertedAxisChangeIndexWithoutConfigurationTest.class,
		RevealGenericTableTest.class,
		FilterStringMatcherTest.class,
		FilterEEnumMatcherTest.class,
		FilterNumericMatcherTest.class,
		FilterUMLEnumerationMatcherTest.class,
		CellEditorsConfigurationTest.class,
		
		// Stereotype inherited properties
		StereotypeInheritDisplayTest.class,
		
		// Check the enumeration content items
		EnumerationContentItemsTest.class,

		// Paste Overwrite tests
		PasteEmptyClipboard_Test.class,
		
		PasteCellsOverwriteAll_Test.class,
		PasteCellsOverwriteByOneLine_Test.class,
		PasteCellsOverwriteFailColumns_Test.class,
		PasteCellsOverwriteFailRows_Test.class,

		PasteColumnsOverwriteAll_Test.class,
		PasteCellsOverwriteByOneLine_Test.class,
		PasteColumnsOverwriteFailColumns_Test.class,
		PasteColumnsOverwriteFailRows_Test.class,

		PasteRowsOverwriteAll_Test.class,
		PasteRowsOverwriteFailColumns_Test.class,
		PasteRowsOverwriteFailRows_Test.class,
		PasteRowsOverwriteWarningNotExisting_Test.class,
		PasteRowsOverwriteAxisIdentifierNotExisting_Test.class,

		PasteEmptyOverwriteReplaceAll_Test.class,
		PasteEmptyOverwriteAddAll_Test.class,
		PasteEmptyOverwriteSkipAll_Test.class,
		PasteEmptyOverwriteFailColumns_Test.class,
		PasteEmptyOverwriteWarningNotExisting_Test.class,
		PasteEmptyOverwriteAxisIdentifierNotExisting_Test.class,

		// Insert tests
		InsertEmptyClipboard_Test.class,
		
		InsertRowsReplaceAll_Test.class,
		InsertRowsAddAll_Test.class,
		InsertRowsSkipAll_Test.class,
		InsertRowsFailColumns_Test.class,
		InsertRowsFailRows_Test.class,
		InsertRowsAxisIdentifierNotExisting_Test.class,
		InsertRowsWarningNotExisting_Test.class,

		InsertEmptyReplaceAll_Test.class,
		InsertEmptyAddAll_Test.class,
		InsertEmptySkipAll_Test.class,
		InsertEmptyFailColumns_Test.class,
		InsertEmptyAxisIdentifierNotExisting_Test.class,
		InsertEmptyWarningNotExisting_Test.class,

		// Import tests
		ImportCellsAll_Test.class,
		ImportRowsReplaceAll_Test.class,
		ImportRowsAddAll_Test.class,
		ImportRowsSkipAll_Test.class,
		ImportEmptyReplaceAll_Test.class,
		ImportEmptyAddAll_Test.class,
		ImportEmptySkipAll_Test.class
})
public class AllTests {
	// JUnit 4 test suite
}
