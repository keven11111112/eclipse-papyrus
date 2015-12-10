/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.contentprovider;

import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;

/**
 * The content provider for the column axis identifier.
 */
public class ColumnAxisIdentifierContentProvider extends AbstractAxisIdentifierContentProvider {

	/**
	 * Constructor.
	 *
	 * @param tableManager
	 *            the table manager to get the column axis.
	 */
	public ColumnAxisIdentifierContentProvider(final INattableModelManager tableManager) {
		super(tableManager, true);
	}

}
