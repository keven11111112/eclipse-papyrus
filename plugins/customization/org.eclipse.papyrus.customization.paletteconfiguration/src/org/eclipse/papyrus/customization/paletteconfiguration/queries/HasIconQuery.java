/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.customization.paletteconfiguration.queries;

import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration;

/** Returns <code>true</code> if the element has a specific icon to display */
public class HasIconQuery implements IJavaQuery2<Configuration, Boolean> {


	public Boolean evaluate(Configuration source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		IJavaQuery2<Configuration, String> getImageQuery = new GetIconQuery();
		String imagePath = getImageQuery.evaluate(source, parameterValues, facetManager);

		if (imagePath != null && imagePath.length() > 0) {
			return true;
		}
		return false;
	}
}
