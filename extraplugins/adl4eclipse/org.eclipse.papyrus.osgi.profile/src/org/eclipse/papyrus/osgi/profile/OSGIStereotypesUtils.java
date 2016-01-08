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

package org.eclipse.papyrus.osgi.profile;

import org.eclipse.uml2.uml.Element;

/**
 * Utility class for {@link OSGIStereotypes}
 */
public class OSGIStereotypesUtils {

	/**
	 * Returns <code>true</code> if the specified element represents a bundle
	 * @param element the element to check
	 * @return <code>true</code> if the specified element represents a bundle
	 */
	public static boolean isBundle(Element element) {
		return element.getAppliedStereotype(OSGIStereotypes.BUNDLE) !=null;
	}
}
