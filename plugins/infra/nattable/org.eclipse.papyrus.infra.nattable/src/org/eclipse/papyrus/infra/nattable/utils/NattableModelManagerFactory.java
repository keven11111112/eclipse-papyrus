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

package org.eclipse.papyrus.infra.nattable.utils;

import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.TreeNattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.selection.ISelectionExtractor;

/**
 * This class allows to create a {@link INattableModelManager} from a table model
 *
 */
public class NattableModelManagerFactory {

	public static final NattableModelManagerFactory INSTANCE = new NattableModelManagerFactory();

	private NattableModelManagerFactory() {
		// to prevent instanciation
	}

	/**
	 * 
	 * @param table
	 *            the table model
	 * @return
	 *         the INattableModelManager to use to manipulate the table
	 */
	public INattableModelManager createNatTableModelManager(final Table table, ISelectionExtractor selectionExtractor) {
		if (TableHelper.isTreeTable(table)) {
			return new TreeNattableModelManager(table,selectionExtractor);
		}
		return new NattableModelManager(table, selectionExtractor);
	}

}
