/**
 * Copyright (c) 2017 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Maged Elaasar - Initial API and implementation
 *  
 * 
 */
package org.eclipse.papyrus.infra.ui.architecture.navigator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.papyrus.infra.widgets.providers.AbstractTreeFilter;

/**
 * A tree filter for representations (diagrams, tables) based on active viewpoints in a model set 
 *
 * @since 1.0
 */
public class ViewpointFilter extends AbstractTreeFilter {

	public ViewpointFilter() {
		super();
		useCache = false;//don't cache
	}
	
	/**
	 * hide a representation when it's not supported by the active viewpoints
	 */
	@Override
	public boolean isVisible(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof EObjectTreeElement) {
			EObject eObj = ((EObjectTreeElement)element).getEObject();
			if (eObj instanceof Diagram || eObj instanceof Table) {
				return ViewPrototype.get(eObj) != ViewPrototype.UNAVAILABLE_VIEW;
			}
		}
		return true;
	}
}
