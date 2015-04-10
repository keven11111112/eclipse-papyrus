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

import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.umlrt.custom.IUMLRTElementTypes;
import org.eclipse.uml2.uml.Package;

public class IsProtocolContainerQuery implements IJavaQuery2<Package, Boolean> {

	/**
	 * {@inheritDoc}
	 */
	public Boolean evaluate(final Package context,
			final IParameterValueList2 parameterValues,
			final IFacetManager facetManager)
					throws DerivedTypedElementException {
		
		// check the package is a protocol container
		IElementType type = ElementTypeRegistry.getInstance().getType(IUMLRTElementTypes.PROTOCOL_CONTAINER_ID);
		
		if(type instanceof ISpecializationType) { // check at the same time UMLRT element types are correctly loaded  
			return ((ISpecializationType) type).getMatcher().matches(context);
		}
		
		// by default, assumes the element is not a protocol container
		return false;
	}
}
