/**
 * Copyright (c) 2015 Christian W. Damus and others.
  * 
  * All rights reserved. This program and the accompanying materials
  * are made available under the terms of the Eclipse Public License v1.0
  * which accompanies this distribution, and is available at
  * http://www.eclipse.org/legal/epl-v10.html
  * 
  * Contributors:
  *  Christian W. Damus - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.composite.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.service.visualtype.AbstractVisualTypeProvider;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class UMLVisualTypeProvider extends AbstractVisualTypeProvider {

	/**
	 * @generated
	 */
	public UMLVisualTypeProvider() {
		super();
	}

	/**
	 * @generated
	 */
	@Override
	public IElementType getElementType(Diagram diagram, String viewType) {
		IElementType result = null;
		try {
			result = UMLElementTypes.getElementType(viewType);
		} catch (NumberFormatException e) {
			// Not supported by this diagram
		}
		return result;
	}

	/**
	 * @generated
	 */
	@Override
	public String getNodeType(View parentView, EObject element) {
		return UMLVisualIDRegistry.getNodeVisualID(parentView, element);
	}

	/**
	 * @generated
	 */
	@Override
	public String getLinkType(Diagram diagram, EObject element) {
		return UMLVisualIDRegistry.getLinkWithClassVisualID(element);
	}
}
