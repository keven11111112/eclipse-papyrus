/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;

/**
 *
 * @author vl222926
 *
 */
public class SelectAllHandler extends AbstractTableHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final INattableModelManager manager = getCurrentNattableModelManager();
		if (manager != null) {
			manager.selectAll();
		}
		return null;
	}

}
