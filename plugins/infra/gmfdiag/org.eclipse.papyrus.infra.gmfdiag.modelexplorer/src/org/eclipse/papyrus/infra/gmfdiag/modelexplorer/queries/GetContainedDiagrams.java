/**
 *  Copyright (c) 2011 Atos, Christian W. Damus, and others.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *    Atos - Initial API and implementation
 *    Christian W. Damus - bug 485220
 *
 */
package org.eclipse.papyrus.infra.gmfdiag.modelexplorer.queries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;

/** Get the collection of all contained diagrams */
public class GetContainedDiagrams implements IJavaQuery2<EObject, Collection<org.eclipse.gmf.runtime.notation.Diagram>> {


	public Collection<Diagram> evaluate(EObject source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		List<Diagram> result = new ArrayList<Diagram>();
		ResourceSet resourceSet = EMFHelper.getResourceSet(source);

		if (resourceSet != null) {
			for (Diagram diagram : NotationUtils.getAllNotations(resourceSet, Diagram.class)) {
				if (DiagramUtils.getOwner(diagram) == source) {
					result.add(diagram);
				}
			}
		}
		return result;
	}
}
