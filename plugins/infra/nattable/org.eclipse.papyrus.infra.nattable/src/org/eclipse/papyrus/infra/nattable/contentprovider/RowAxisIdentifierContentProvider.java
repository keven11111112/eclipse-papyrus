/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nicolas FAUVERGUe (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.contentprovider;

import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;

/**
 * The content provider for the row axis identifier.
 */
public class RowAxisIdentifierContentProvider extends AbstractAxisIdentifierContentProvider {

	/**
	 * Constructor.
	 *
	 * @param tableManager
	 *            the table manager to get the column axis.
	 */
	public RowAxisIdentifierContentProvider(final INattableModelManager tableManager) {
		super(tableManager, false);
	}

}
