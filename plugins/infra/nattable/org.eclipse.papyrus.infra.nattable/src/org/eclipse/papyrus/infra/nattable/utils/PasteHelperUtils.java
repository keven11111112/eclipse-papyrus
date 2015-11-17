/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas fAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.utils;

import java.io.Reader;

import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.parsers.CSVParser;
import org.eclipse.papyrus.infra.nattable.parsers.CellIterator;
import org.eclipse.papyrus.infra.nattable.parsers.RowIterator;

/**
 *
 */
public class PasteHelperUtils {

	/**
	 * Constructor.
	 */
	private PasteHelperUtils() {
		// to prevent instanciation
	}
	
	/**
	 * Manage if this is a paste with overwrite or just a basic paste.
	 * 
	 * @param tableManager The nattable model manager.
	 * @param pasteHelper The paste helper.
	 * @param reader The reader of the file.
	 * @return
	 */
	public static final boolean isPasteWithOverwrite(final INattableModelManager tableManager, final CSVPasteHelper pasteHelper, final Reader reader) {
		boolean isPasteWithOverwrite = false;
		
		final CSVParser parser = pasteHelper.createParser(reader);

		// Get the pasted text
		final RowIterator rowIter = parser.parse();
		int nbColumnRead = -1;

		// Calculate the number of column pasted
		while (rowIter.hasNext()) {
			final CellIterator cellIter = rowIter.next();
			int nbColumnReadByRow = 0;
			if (cellIter.hasNext()) {
				while (cellIter.hasNext()) {
					cellIter.next();
					nbColumnReadByRow++;
				}
			}
			nbColumnRead = nbColumnRead >= nbColumnReadByRow ? nbColumnRead : nbColumnReadByRow;
		}

		// Calculate the number of column in the table (including rows header number column and excluding index column)
		int nbExpectedColumn = tableManager.getColumnCount();
		if (TableHelper.isSingleColumnTreeTable(tableManager)) {
			nbExpectedColumn++;
		} else {
			nbExpectedColumn = nbExpectedColumn + ((NattableModelManager) tableManager).getRowHeaderLayerStack().getRowHeaderLayerLabel().getColumnCount();
		}

		// If the number of column read is equals to the number of column in table, this is a basic paste (PasteEObject...)
		isPasteWithOverwrite = nbColumnRead != nbExpectedColumn;
		return isPasteWithOverwrite;
	}
	
}
