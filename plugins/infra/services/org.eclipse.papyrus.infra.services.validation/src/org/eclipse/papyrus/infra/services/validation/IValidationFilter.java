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

package org.eclipse.papyrus.infra.services.validation;

import org.eclipse.emf.ecore.EObject;

/**
 * This interface is used to identify whether a diagnostician or validation hook is applicable
 * for a given element
 * @since 3.0
 */
public interface IValidationFilter {
	/**
	 * Check whether a hook or diagnostician is applicable
	 * @param element an element of a model
	 * @return true, if applicable
	 */
	public boolean isApplicable(EObject element);
}
