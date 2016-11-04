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
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.DrawerConfiguration;

/** Returns the label for a drawer */
public class GetDrawerLabelQuery implements IJavaQuery2<DrawerConfiguration, String> {

	public String evaluate(DrawerConfiguration source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		return (source.getLabel() != null ? source.getLabel() : "<>");
	}
}
