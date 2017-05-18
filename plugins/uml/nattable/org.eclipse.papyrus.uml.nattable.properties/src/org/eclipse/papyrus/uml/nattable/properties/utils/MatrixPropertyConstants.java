/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Vincent LORENZO (CEA-LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.nattable.properties.utils;

/**
 * 
 * These constants are used in the property view model to identify the edited feature
 *
 */
public class MatrixPropertyConstants {

	private MatrixPropertyConstants() {
		// to prevent instanciation
	}

	public static final String MATRIX_ROW_SOURCES = "rowSources";//$NON-NLS-1$

	public static final String MATRIX_COLUMN_SOURCES = "columnSources";//$NON-NLS-1$

	public static final String MATRIX_ROW_FILTER = "rowFilter";//$NON-NLS-1$

	public static final String MATRIX_COLUMN_FILTER = "columnFilter";//$NON-NLS-1$

	public static final String MATRIX_CELL_TYPE = "managedElementType";//$NON-NLS-1$

	public static final String MATRIX_CELL_FILTER = "cellContentsFilter";//$NON-NLS-1$

	public static final String MATRIX_RELATIONSHIP_DIRECTION = "relationshipDirection";//$NON-NLS-1$
}
