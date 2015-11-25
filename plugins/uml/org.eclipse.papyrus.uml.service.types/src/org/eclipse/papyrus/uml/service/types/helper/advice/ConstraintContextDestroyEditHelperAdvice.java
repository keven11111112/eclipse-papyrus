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

package org.eclipse.papyrus.uml.service.types.helper.advice;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.papyrus.uml.service.types.command.ConstraintContextDestroyCommand;


/**
 * Context link edit helper advice
 */
public class ConstraintContextDestroyEditHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getAfterDestroyReferenceCommand(DestroyReferenceRequest request) {
		return new ConstraintContextDestroyCommand(request);
	}

}
