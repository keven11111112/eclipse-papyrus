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
package org.eclipse.papyrus.umlrt.ui.queries;

import java.util.Collection;

import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.umlrt.custom.utils.ProtocolContainerUtils;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;

public class GetMessageOutFromProtocolContainerQuery implements IJavaQuery2<Package, Collection<Operation>> {
	public Collection<Operation> evaluate(final Package context,
			final IParameterValueList2 parameterValues,
			final IFacetManager facetManager)
			throws DerivedTypedElementException {
		return ProtocolContainerUtils.getAllOutOperations(context);
	}
}