/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Thanh Liem PHAN (ALL4TEC) thanhliem.phan@all4tec.net - Bug 459220
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablestyle.BooleanValueStyle;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablestyle.NattablestylePackage;
import org.eclipse.papyrus.infra.nattable.utils.NamedStyleConstants;
import org.eclipse.papyrus.infra.nattable.utils.StyleUtils;

/**
 * Handler to enable or disable the auto-resizing of cell height of the active table.
 */
public class SetAutoResizeCellHeightHandler extends AbstractTableHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		TransactionalEditingDomain editingDomain = getTableEditingDomain();
		Table table = getTable();

		if (null != editingDomain && null != table) {

			// Get the auto resize cell height named style from the table
			BooleanValueStyle autoResizeValue = (BooleanValueStyle) table.getNamedStyle(NattablestylePackage.eINSTANCE.getBooleanValueStyle(), NamedStyleConstants.AUTO_RESIZE_CELL_HEIGHT);

			// If the auto resize value exists
			if (null != autoResizeValue) {
				// Inverse the auto resize cell boolean value and save it to the table
				StyleUtils.setBooleanNamedStyle(editingDomain, table, NamedStyleConstants.AUTO_RESIZE_CELL_HEIGHT, !autoResizeValue.isBooleanValue());

			} else {
				// Otherwise, initialise the auto resize cell height named value in the disable mode by default
				StyleUtils.initBooleanNamedStyle(editingDomain, table, NamedStyleConstants.AUTO_RESIZE_CELL_HEIGHT, false);
			}
		}

		return null;
	}
}
