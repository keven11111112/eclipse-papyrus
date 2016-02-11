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

package org.eclipse.papyrus.uml.service.types.ui.handlers;

import org.eclipse.papyrus.uml.service.types.filter.ICommandFilter;
import org.eclipse.papyrus.uml.service.types.filter.UmlElementCommandFilter;

/**
 * Abstract handler for every creation command for UML elements
 * used in the ModelExplorer contextual ("Create new child") menu
 *
 */
public abstract class AbstractUmlCreateElementCommandHandler extends AbstractCreateElementCommandHandler {
	
	private static final ICommandFilter filter = UmlElementCommandFilter.INSTANCE;

	/**
	 *
	 * @see org.eclipse.papyrus.uml.service.types.ui.handlers.AbstractCreateCommandHandler#getCommandFilter()
	 *
	 * @return
	 */
	@Override
	public ICommandFilter getCommandFilter() {
		return filter;
	}

}
