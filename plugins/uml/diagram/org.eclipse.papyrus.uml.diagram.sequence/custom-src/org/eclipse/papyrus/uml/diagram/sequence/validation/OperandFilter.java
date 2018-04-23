/*****************************************************************************
 * Copyright (c) 2018 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.services.validation.IValidationFilter;
import org.eclipse.uml2.uml.InteractionOperand;

/**
 * A validation filter that matches {@link InteractionOperand}s.
 */
public class OperandFilter implements IValidationFilter {

	/**
	 * Initializes me.
	 */
	public OperandFilter() {
		super();
	}

	@Override
	public boolean isApplicable(EObject element) {
		return element instanceof InteractionOperand;
	}

}
