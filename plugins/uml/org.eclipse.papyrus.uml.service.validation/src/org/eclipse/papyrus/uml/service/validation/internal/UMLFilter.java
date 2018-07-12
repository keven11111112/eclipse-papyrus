/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.service.validation.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.services.validation.IValidationFilter;
import org.eclipse.uml2.uml.Element;

/**
 * A filter that associates UML models with the UMLDiagnotician (it is
 * referenced from the plugin.xml)
 */
public class UMLFilter implements IValidationFilter {

	/**
	 * @see org.eclipse.papyrus.infra.services.validation.IValidationFilter#isApplicable(org.eclipse.emf.ecore.EObject)
	 *
	 * @param an
	 *            element of the model to validate
	 * @return true, iff the element is a UML element
	 */
	public boolean isApplicable(EObject element) {
		return element instanceof Element;
	}
}
