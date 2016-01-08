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

package org.eclipse.papyrus.adl4eclipse.org;

import org.eclipse.uml2.uml.Element;

/**
 * Utility class for {@link ADL4Eclipse_Stereotypes}
 */
public class ADL4Eclipse_StereotypesUtils {

	/**
	 * Returns <code>true</code> if the specified element represents a Feature
	 * @param element the element to check
	 * @return <code>true</code> if the specified element represents a Feature
	 */
	public static boolean isFeature(Element element) {
		return element.getAppliedStereotype(ADL4Eclipse_Stereotypes.FEATURE_STEREOTYPE) != null;
	}
}
