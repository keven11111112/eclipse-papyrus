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

import org.eclipse.papyrus.junit.framework.classification.ClassificationSuite;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.bugs.AxisChangeIndexWithConfigurationTest;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.bugs.AxisChangeIndexWithoutConfigurationTest;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.bugs.DeleteRequirementsWithNestedClassifier;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.bugs.EditInvalidPastedText_V1_V3_V1;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.bugs.MoveElementsTreeTableTest;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.bugs.NoDepth0TreeFillingConfigurationTest;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.bugs.OpenAndDeleteTest;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.bugs.PasteWithCategories_H1_H3_H1_MultiColumns_AttachedMode_Bug481310Test;
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
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.importfile.ImportCellsAll_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.importfile.ImportCellsAll_V1_V3_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.importfile.ImportEmptyAddAll_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.importfile.ImportEmptyAddAll_V1_V3_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.importfile.ImportEmptyReplaceAll_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.importfile.ImportEmptyReplaceAll_V1_V3_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.importfile.ImportEmptySkipAll_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.importfile.ImportEmptySkipAll_V1_V3_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.importfile.ImportRowsAddAll_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.importfile.ImportRowsAddAll_V1_V3_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.importfile.ImportRowsReplaceAll_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.importfile.ImportRowsReplaceAll_V1_V3_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.importfile.ImportRowsSkipAll_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.importfile.ImportRowsSkipAll_V1_V3_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.insert.InsertEmptyAddAll_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.insert.InsertEmptyAddAll_V1_V3_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.insert.InsertEmptyAxisIdentifierNotExisting_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.insert.InsertEmptyClipboard_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.insert.InsertEmptyFailColumns_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.insert.InsertEmptyReplaceAll_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.insert.InsertEmptyReplaceAll_V1_V3_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.insert.InsertEmptySkipAll_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.insert.InsertEmptySkipAll_V1_V3_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.insert.InsertEmptyWarningNotExisting_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.insert.InsertRowsAddAll_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.insert.InsertRowsAddAll_V1_V3_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.insert.InsertRowsAxisIdentifierNotExisting_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.insert.InsertRowsFailColumns_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.insert.InsertRowsFailRows_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.insert.InsertRowsReplaceAll_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.insert.InsertRowsReplaceAll_V1_V3_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.insert.InsertRowsSkipAll_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.insert.InsertRowsSkipAll_V1_V3_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.insert.InsertRowsWarningNotExisting_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.markers.ValidationMarkerInTableHeaderTest;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteCellsOverwriteAll_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteCellsOverwriteAll_V1_V3_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteCellsOverwriteByOneLine_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteCellsOverwriteFailColumns_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteCellsOverwriteFailRows_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteColumnsOverwriteAll_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteColumnsOverwriteAll_V1_V3_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteColumnsOverwriteByOneColumn_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteColumnsOverwriteByOneLine_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteColumnsOverwriteFailColumns_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteColumnsOverwriteFailRows_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteEmptyClipboard_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteEmptyOverwriteAddAll_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteEmptyOverwriteAddAll_V1_V3_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteEmptyOverwriteAxisIdentifierNotExisting_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteEmptyOverwriteFailColumns_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteEmptyOverwriteReplaceAll_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteEmptyOverwriteReplaceAll_V1_V3_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteEmptyOverwriteSkipAll_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteEmptyOverwriteSkipAll_V1_V3_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteEmptyOverwriteWarningNotExisting_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteRowsOverwriteAll_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteRowsOverwriteAll_V1_V3_V1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteRowsOverwriteAxisIdentifierNotExisting_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteRowsOverwriteFailColumns_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteRowsOverwriteFailRows_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.overwrite.PasteRowsOverwriteWarningNotExisting_H1_H1_H1_MultiColumns_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_H1_H1_MultiColumns_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_H1_H1_MultiColumns_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_H1_H1_SingleColumn_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_H1_H1_SingleColumn_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_H1_V1_MultiColumns_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_H1_V1_MultiColumns_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_H1_V1_SingleColumn_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_H1_V1_SingleColumn_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_H3_V1_MultiColumns_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_H3_V1_MultiColumns_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_H3_V1_SingleColumn_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_H3_V1_SingleColumn_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_V3_H1_MultiColumns_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_V3_H1_MultiColumns_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_V3_H1_SingleColumn_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_V3_H1_SingleColumn_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_V3_V1_MultiColumns_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_V3_V1_MultiColumns_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_V3_V1_SingleColumn_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_Empty_V3_V1_SingleColumn_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_H1_H1_MultiColumns_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_H1_H1_MultiColumns_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_H1_H1_SingleColumn_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_H1_H1_SingleColumn_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_H1_V1_MultiColumns_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_H1_V1_MultiColumns_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_H1_V1_SingleColumn_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_H1_V1_SingleColumn_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_H3_H1_MultiColumns_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_H3_H1_MultiColumns_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_H3_H1_SingleColumn_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_H3_H1_SingleColumn_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_V3_H1_MultiColumns_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_V3_H1_MultiColumns_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_V3_H1_SingleColumn_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_V3_H1_SingleColumn_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_V3_V1_MultiColumns_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_V3_V1_MultiColumns_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_V3_V1_SingleColumn_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_H1_V3_V1_SingleColumn_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_H1_H1_MultiColumns_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_H1_H1_MultiColumns_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_H1_H1_SingleColumn_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_H1_H1_SingleColumn_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_H1_V1_MultiColumns_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_H1_V1_MultiColumns_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_H1_V1_SingleColumn_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_H1_V1_SingleColumn_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_V3_H1_MultiColumns_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_V3_H1_MultiColumns_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_V3_H1_SingleColumn_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_V3_H1_SingleColumn_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_V3_V1_MultiColumns_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_V3_V1_MultiColumns_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_V3_V1_SingleColumn_AttachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.paste.tests.PasteWithCategories_V1_V3_V1_SingleColumn_DetachedMode_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.sort.Sort_H1_H3_H1;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.sort.Sort_V1_V3_V1;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.styles.ResizeHeaderWithIndexTest;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.styles.ResizeHeaderWithoutIndexTest;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.unset.UnsetCellValueWithProfile_V1_V3_V1_Test;
import org.eclipse.papyrus.uml.nattable.clazz.config.tests.unset.UnsetCellValue_H1_H3_H1_Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(ClassificationSuite.class)
@SuiteClasses({
		EditInvalidPastedText_V1_V3_V1.class,
		OpenTableTest.class,
		OpenAndDeleteTest.class,
		Bug_481017_ReloadEditorTest.class,
		NoDepth0TreeFillingConfigurationTest.class,

		SortAxisClassTreeTableTest.class,
		EditAxisClassTreeTableTest.class,

		// Bug 481020 : Delete a requirement containing a nested requirement
		DeleteRequirementsWithNestedClassifier.class,

		// Bug 481023 : The nested requirement was not available in table
		RequirementsNestedClassifier.class,

		// Move elements
		MoveElementsTreeTableTest.class,

		ContentsAndExpandWithCategories_0_1_2_Tests.class,
		ContentsAndExpandWithoutCategories_H0_H1_H2_Tests.class,

		// Resize of header
		ResizeHeaderWithIndexTest.class,
		ResizeHeaderWithoutIndexTest.class,

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

		// Attached Mode
		// Paste tests for single column
		PasteWithCategories_Empty_H1_H1_SingleColumn_AttachedMode_Test.class,
		PasteWithCategories_Empty_H1_V1_SingleColumn_AttachedMode_Test.class,
		PasteWithCategories_Empty_H3_V1_SingleColumn_AttachedMode_Test.class,
		PasteWithCategories_Empty_V3_H1_SingleColumn_AttachedMode_Test.class,
		PasteWithCategories_Empty_V3_V1_SingleColumn_AttachedMode_Test.class,

		PasteWithCategories_H1_H1_H1_SingleColumn_AttachedMode_Test.class,
		PasteWithCategories_H1_H1_V1_SingleColumn_AttachedMode_Test.class,
		PasteWithCategories_H1_H3_H1_SingleColumn_AttachedMode_Test.class,
		PasteWithCategories_H1_V3_H1_SingleColumn_AttachedMode_Test.class,
		PasteWithCategories_H1_V3_V1_SingleColumn_AttachedMode_Test.class,

		PasteWithCategories_V1_H1_H1_SingleColumn_AttachedMode_Test.class,
		PasteWithCategories_V1_H1_V1_SingleColumn_AttachedMode_Test.class,
		PasteWithCategories_V1_V3_H1_SingleColumn_AttachedMode_Test.class,
		PasteWithCategories_V1_V3_V1_SingleColumn_AttachedMode_Test.class,

		// Paste tests for multi columns
		PasteWithCategories_Empty_H1_H1_MultiColumns_AttachedMode_Test.class,
		PasteWithCategories_Empty_H1_V1_MultiColumns_AttachedMode_Test.class,
		PasteWithCategories_Empty_H3_V1_MultiColumns_AttachedMode_Test.class,
		PasteWithCategories_Empty_V3_H1_MultiColumns_AttachedMode_Test.class,
		PasteWithCategories_Empty_V3_V1_MultiColumns_AttachedMode_Test.class,

		PasteWithCategories_H1_H1_H1_MultiColumns_AttachedMode_Test.class,
		PasteWithCategories_H1_H1_V1_MultiColumns_AttachedMode_Test.class,
		PasteWithCategories_H1_H3_H1_MultiColumns_AttachedMode_Test.class,
		PasteWithCategories_H1_V3_H1_MultiColumns_AttachedMode_Test.class,
		PasteWithCategories_H1_V3_V1_MultiColumns_AttachedMode_Test.class,

		PasteWithCategories_V1_H1_H1_MultiColumns_AttachedMode_Test.class,
		PasteWithCategories_V1_H1_V1_MultiColumns_AttachedMode_Test.class,
		PasteWithCategories_V1_V3_H1_MultiColumns_AttachedMode_Test.class,
		PasteWithCategories_V1_V3_V1_MultiColumns_AttachedMode_Test.class,
		
		// Bug 481310 : Paste one depth when others can't get pasted elements
		PasteWithCategories_H1_H3_H1_MultiColumns_AttachedMode_Bug481310Test.class,

		// Detached Mode
		// Paste tests for single column
		PasteWithCategories_Empty_H1_H1_SingleColumn_DetachedMode_Test.class,
		PasteWithCategories_Empty_H1_V1_SingleColumn_DetachedMode_Test.class,
		PasteWithCategories_Empty_H3_V1_SingleColumn_DetachedMode_Test.class,
		PasteWithCategories_Empty_V3_H1_SingleColumn_DetachedMode_Test.class,
		PasteWithCategories_Empty_V3_V1_SingleColumn_DetachedMode_Test.class,

		PasteWithCategories_H1_H1_H1_SingleColumn_DetachedMode_Test.class,
		PasteWithCategories_H1_H1_V1_SingleColumn_DetachedMode_Test.class,
		PasteWithCategories_H1_H3_H1_SingleColumn_DetachedMode_Test.class,
		PasteWithCategories_H1_V3_H1_SingleColumn_DetachedMode_Test.class,
		PasteWithCategories_H1_V3_V1_SingleColumn_DetachedMode_Test.class,

		PasteWithCategories_V1_H1_H1_SingleColumn_DetachedMode_Test.class,
		PasteWithCategories_V1_H1_V1_SingleColumn_DetachedMode_Test.class,
		PasteWithCategories_V1_V3_H1_SingleColumn_DetachedMode_Test.class,
		PasteWithCategories_V1_V3_V1_SingleColumn_DetachedMode_Test.class,
		
		// Paste tests for multi columns
		PasteWithCategories_Empty_H1_H1_MultiColumns_DetachedMode_Test.class,
		PasteWithCategories_Empty_H1_V1_MultiColumns_DetachedMode_Test.class,
		PasteWithCategories_Empty_H3_V1_MultiColumns_DetachedMode_Test.class,
		PasteWithCategories_Empty_V3_H1_MultiColumns_DetachedMode_Test.class,
		PasteWithCategories_Empty_V3_V1_MultiColumns_DetachedMode_Test.class,

		PasteWithCategories_H1_H1_H1_MultiColumns_DetachedMode_Test.class,
		PasteWithCategories_H1_H1_V1_MultiColumns_DetachedMode_Test.class,
		PasteWithCategories_H1_H3_H1_MultiColumns_DetachedMode_Test.class,
		PasteWithCategories_H1_V3_H1_MultiColumns_DetachedMode_Test.class,
		PasteWithCategories_H1_V3_V1_MultiColumns_DetachedMode_Test.class,

		PasteWithCategories_V1_H1_H1_MultiColumns_DetachedMode_Test.class,
		PasteWithCategories_V1_H1_V1_MultiColumns_DetachedMode_Test.class,
		PasteWithCategories_V1_V3_H1_MultiColumns_DetachedMode_Test.class,
		PasteWithCategories_V1_V3_V1_MultiColumns_DetachedMode_Test.class,

		// Tests of the paste with overwrite
		PasteEmptyClipboard_H1_H1_H1_MultiColumns_Test.class,

		PasteCellsOverwriteAll_H1_H1_H1_MultiColumns_Test.class,
		PasteCellsOverwriteAll_V1_V3_V1_MultiColumns_Test.class,
		PasteCellsOverwriteByOneLine_H1_H1_H1_MultiColumns_Test.class,
		PasteCellsOverwriteFailRows_H1_H1_H1_MultiColumns_Test.class,
		PasteCellsOverwriteFailColumns_H1_H1_H1_MultiColumns_Test.class,

		PasteColumnsOverwriteAll_H1_H1_H1_MultiColumns_Test.class,
		PasteColumnsOverwriteAll_V1_V3_V1_MultiColumns_Test.class,
		PasteColumnsOverwriteByOneLine_H1_H1_H1_MultiColumns_Test.class,
		PasteColumnsOverwriteByOneColumn_H1_H1_H1_MultiColumns_Test.class,
		PasteColumnsOverwriteFailColumns_H1_H1_H1_MultiColumns_Test.class,
		PasteColumnsOverwriteFailRows_H1_H1_H1_MultiColumns_Test.class,

		PasteRowsOverwriteAll_H1_H1_H1_MultiColumns_Test.class,
		PasteRowsOverwriteAll_V1_V3_V1_MultiColumns_Test.class,
		PasteRowsOverwriteFailColumns_H1_H1_H1_MultiColumns_Test.class,
		PasteRowsOverwriteFailRows_H1_H1_H1_MultiColumns_Test.class,
		PasteRowsOverwriteWarningNotExisting_H1_H1_H1_MultiColumns_Test.class,
		PasteRowsOverwriteAxisIdentifierNotExisting_H1_H1_H1_MultiColumns_Test.class,

		PasteEmptyOverwriteReplaceAll_H1_H1_H1_MultiColumns_Test.class,
		PasteEmptyOverwriteReplaceAll_V1_V3_V1_MultiColumns_Test.class,
		PasteEmptyOverwriteAddAll_H1_H1_H1_MultiColumns_Test.class,
		PasteEmptyOverwriteAddAll_V1_V3_V1_MultiColumns_Test.class,
		PasteEmptyOverwriteSkipAll_H1_H1_H1_MultiColumns_Test.class,
		PasteEmptyOverwriteSkipAll_V1_V3_V1_MultiColumns_Test.class,
		PasteEmptyOverwriteFailColumns_H1_H1_H1_MultiColumns_Test.class,
		PasteEmptyOverwriteWarningNotExisting_H1_H1_H1_MultiColumns_Test.class,
		PasteEmptyOverwriteAxisIdentifierNotExisting_H1_H1_H1_MultiColumns_Test.class,

		// Tests of insert
		InsertEmptyClipboard_H1_H1_H1_MultiColumns_Test.class,

		InsertRowsReplaceAll_H1_H1_H1_MultiColumns_Test.class,
		InsertRowsReplaceAll_V1_V3_V1_MultiColumns_Test.class,
		InsertRowsAddAll_H1_H1_H1_MultiColumns_Test.class,
		InsertRowsAddAll_V1_V3_V1_MultiColumns_Test.class,
		InsertRowsSkipAll_H1_H1_H1_MultiColumns_Test.class,
		InsertRowsSkipAll_V1_V3_V1_MultiColumns_Test.class,
		InsertRowsFailColumns_H1_H1_H1_MultiColumns_Test.class,
		InsertRowsFailRows_H1_H1_H1_MultiColumns_Test.class,
		InsertRowsWarningNotExisting_H1_H1_H1_MultiColumns_Test.class,
		InsertRowsAxisIdentifierNotExisting_H1_H1_H1_MultiColumns_Test.class,

		InsertEmptyReplaceAll_H1_H1_H1_MultiColumns_Test.class,
		InsertEmptyReplaceAll_V1_V3_V1_MultiColumns_Test.class,
		InsertEmptyAddAll_H1_H1_H1_MultiColumns_Test.class,
		InsertEmptyAddAll_V1_V3_V1_MultiColumns_Test.class,
		InsertEmptySkipAll_H1_H1_H1_MultiColumns_Test.class,
		InsertEmptySkipAll_V1_V3_V1_MultiColumns_Test.class,
		InsertEmptyFailColumns_H1_H1_H1_MultiColumns_Test.class,
		InsertEmptyWarningNotExisting_H1_H1_H1_MultiColumns_Test.class,
		InsertEmptyAxisIdentifierNotExisting_H1_H1_H1_MultiColumns_Test.class,

		// Import test
		ImportCellsAll_H1_H1_H1_MultiColumns_Test.class,
		ImportCellsAll_V1_V3_V1_MultiColumns_Test.class,

		ImportRowsReplaceAll_H1_H1_H1_MultiColumns_Test.class,
		ImportRowsReplaceAll_V1_V3_V1_MultiColumns_Test.class,
		ImportRowsAddAll_H1_H1_H1_MultiColumns_Test.class,
		ImportRowsAddAll_V1_V3_V1_MultiColumns_Test.class,
		ImportRowsSkipAll_H1_H1_H1_MultiColumns_Test.class,
		ImportRowsSkipAll_V1_V3_V1_MultiColumns_Test.class,

		ImportEmptyReplaceAll_H1_H1_H1_MultiColumns_Test.class,
		ImportEmptyReplaceAll_V1_V3_V1_MultiColumns_Test.class,
		ImportEmptyAddAll_H1_H1_H1_MultiColumns_Test.class,
		ImportEmptyAddAll_V1_V3_V1_MultiColumns_Test.class,
		ImportEmptySkipAll_H1_H1_H1_MultiColumns_Test.class,
		ImportEmptySkipAll_V1_V3_V1_MultiColumns_Test.class,

		// validation markers tests
		ValidationMarkerInTableHeaderTest.class,
})
public class AllTests {
	// JUnit 4 test suite

}
