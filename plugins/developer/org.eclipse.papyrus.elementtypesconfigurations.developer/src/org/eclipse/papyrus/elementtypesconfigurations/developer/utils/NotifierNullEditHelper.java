/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
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

package org.eclipse.papyrus.elementtypesconfigurations.developer.utils;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.elementtypesconfigurations.notification.AbstractNotifierEditHelper;

/**
 * Edit helper for the NullElementType that considers before and after
 * advice, only.
 */
public class NotifierNullEditHelper
		extends AbstractNotifierEditHelper {

	protected ICommand getInsteadCommand(IEditCommandRequest req) {
		return null;
	}
}