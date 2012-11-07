/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.efacet.common.utils;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;


/**
 * 
 * This class provides utilities for the AdditionalContentsFacetSet.
 * This facetset is used to provide additional contents for table EFacet (Currently,
 * this main job is to provide FacetSet to edit easily the properties of the stereotypes into a table
 * 
 */
public class AdditionalContentsFacetSetUtils {

	private AdditionalContentsFacetSetUtils() {
		//to prevent instanciation
	}

	public static final String ADDITIONAL_CONTENTS_FACET_SET_NAME = "AdditionalContentsForTable";

	public static final String ADDITIONAL_CONTENTS_FACET_SET_NS_URI = "http://www.eclipse.org/papyrustableefacet/additionalcontentsfacetset";

	public static final String ADDITIONAL_CONTENTS_FACET_SET_PREFIX = "additionalcontentsfacetset";

	public static final String ADDITIONAL_CONTENTS_FACET_SET_DOCUMENTATION = "This FacetSet provides facets to edit easily additional contents (Stereotype Properties for example). It had been generated by the Papyrus Show/Hide columns";

	/**
	 * 
	 * @param source
	 *        a resource
	 * @return
	 *         return the FacetSet with the uri {@link #ADDITIONAL_CONTENTS_FACET_SET_NS_URI} in the resource or <code>null</code> if not found
	 */
	public static FacetSet getAdditionalContentFacetSet(final Resource source) {
		FacetSet additionalSet = null;
		Iterator<EObject> iter = source.getContents().iterator();
		while(iter.hasNext() && additionalSet == null) {
			final EObject contents = iter.next();
			if(contents instanceof FacetSet && AdditionalContentsFacetSetUtils.ADDITIONAL_CONTENTS_FACET_SET_NS_URI.equals(((FacetSet)contents).getNsURI())) {
				additionalSet = (FacetSet)contents;
			}
		}
		return additionalSet;
	}
}
