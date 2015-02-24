/*****************************************************************************
 * Copyright (c) 2014, 2015 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 433206
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.canonical.DefaultUMLSemanticChildrenStrategy;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * This class is used to precise semantic element that could be displayed in compartment of parts
 */
public class PropertyPartCompartmentSemanticChildrenStrategy extends DefaultUMLSemanticChildrenStrategy {

	public PropertyPartCompartmentSemanticChildrenStrategy() {
		super();
	}

	@Override
	public List<? extends EObject> getCanonicalSemanticChildren(EObject semanticFromEditPart, View viewFromEditPart) {
		List<? extends EObject> result = null;

		Property property = (semanticFromEditPart instanceof Property) ? (Property) semanticFromEditPart : null;
		if (property != null) {
			Type type = property.getType();
			if (type != null) {
				// Show nested structure of the part as defined by its type
				result = super.getCanonicalSemanticChildren(type, viewFromEditPart);
			}
		}

		return result;
	}

	@Override
	public Collection<? extends EObject> getCanonicalDependents(EObject semanticFromEditPart) {
		if (semanticFromEditPart instanceof Property) {
			if (((Property) semanticFromEditPart).getType() != null) {
				return Collections.singletonList(((Property) semanticFromEditPart).getType());
			}
		}
		return null;
	}
}
