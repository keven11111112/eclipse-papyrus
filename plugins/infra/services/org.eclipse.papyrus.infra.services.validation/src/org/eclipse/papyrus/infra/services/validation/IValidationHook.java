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
 * A simple hook that can be executed before and after validation commands. A possible
 * use for the former is to register additional constraints.
 *
 */
public interface IValidationHook {
	/**
	 * This operation is called, before the validation is run
	 */
	public void beforeValidation(EObject element);

	/**
	 * This operation is called after validation has been run
	 */
	public void afterValidation(EObject element);
}
