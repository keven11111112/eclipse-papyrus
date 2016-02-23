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
 *  Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.utils;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablestyle.StringValueStyle;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablestyle.Style;

public class NamedStyleConstants {

	private NamedStyleConstants() {
		// to prevent instantiation
	}

	/**
	 *
	 * The following constants are used during the initialization and retrieval of the Axis and Header dimensions in the tables
	 */

	public static final String ROW_INDEX_WIDTH = "rowIndexWidth"; //$NON-NLS-1$1

	public static final String ROW_LABEL_WIDTH = "rowLabelWidth"; //$NON-NLS-1$
	
	/**
	 * The prefix of the name style to calculate the width of each row header.
	 * This prefix is followed by the position of the column to edit width.
	 */
	public static final String ROW_LABEL_POSITION_PREFIX_WIDTH = "rowPosition"; //$NON-NLS-1$
	
	/**
	 * The suffix of the name style to calculate the width of each row header
	 */
	public static final String ROW_LABEL_POSITION_SUFFIX_WIDTH = "LabelWidth"; //$NON-NLS-1$
	
	/**
	 * The named style id for the slider composite width.
	 */
	public static final String ROW_HEADER_WIDTH = "rowHeaderWidth"; //$NON-NLS-1$
	

	public static final String COLUMN_INDEX_HEIGHT = "columnIndexHeight"; //$NON-NLS-1$

	public static final String COLUMN_LABEL_HEIGHT = "columnLabelHeight"; //$NON-NLS-1$

	public static final String AXIS_WIDTH = "axisWidth"; //$NON-NLS-1$

	public static final String AXIS_HEIGHT = "axisHeight"; //$NON-NLS-1$

	/**
	 *
	 * The following constants are used during the initialization and retrieval of the merge options in the tables
	 */

	//	public static final String TABLEMERGE = "tableMerge"; //$NON-NLS-1$

	public static final String MERGE_ROWS = "mergeRows"; //$NON-NLS-1$

	public static final String MERGE_COLUMNS = "mergeColumns"; //$NON-NLS-1$

	public static final String MERGE_SELECTED_ROWS = "mergeSelectedRows"; //$NON-NLS-1$

	public static final String MERGE_SELECTED_COLUMNS = "mergeSelectedColumns"; //$NON-NLS-1$

	public static final String MERGE_IN_SELECTED_ROWS = "mergeInSelectedRows"; //$NON-NLS-1$

	public static final String MERGE_IN_SELECTED_COLUMNS = "mergeInSelectedColumns"; //$NON-NLS-1$

	// the merge of all the elements in the table is not yet supported
	//	public static final String MERGE_TABLE = "mergeTable"; //$NON-NLS-1$


	public static final String HIDDEN_CATEGORY_FOR_DEPTH = "hiddenCategoriesByDepth"; //$NON-NLS-1$

	/**
	 * key used to save a filter configuration id state when the system use the default filter provided by the configuration
	 * It is only used as name for a {@link StringValueStyle}
	 */
	public static final String FILTER_SYSTEM_ID = "filterId"; //$NON-NLS-1$

	/**
	 * key used to save filter state (the value typed by the user to filter the rows)
	 * This key used as name for a {@link Style} without more precision
	 */
	public static final String FILTER_VALUE_TO_MATCH = "filterValueToMatch"; //$NON-NLS-1$

	/**
	 * key used to save a filter configuration id state when the system use a filter choosen by the user
	 * It is only used as name for a {@link StringValueStyle}, we use a specific key in order to not destroyed it when we unapply filter on a column where filter has been definied by the user
	 * 
	 * 
	 */
	public static final String FILTER_FORCED_BY_USER_ID = "filterForcedByUserId"; //$NON-NLS-1$

}
