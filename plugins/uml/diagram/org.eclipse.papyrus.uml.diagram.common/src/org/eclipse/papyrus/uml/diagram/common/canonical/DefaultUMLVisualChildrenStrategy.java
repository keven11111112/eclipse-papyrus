/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.canonical;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.canonical.strategy.IVisualChildrenStrategy;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

import com.google.common.collect.ImmutableSet;

/**
 * Default strategy for calculation of child views in the UML domain. This accounts for the compartments and labels
 * that present applied stereotypes, which have nothing to do with model-view synchronization.
 */
public class DefaultUMLVisualChildrenStrategy implements IVisualChildrenStrategy {

	public DefaultUMLVisualChildrenStrategy() {
		super();
	}

	@Override
	public List<? extends View> getCanonicalChildren(EditPart editPart, View view) {
		List<? extends View> result = DEFAULT.getCanonicalChildren(editPart, view);

		// Filter out child views that represent applied stereotypes
		final EObject semantic = ((IGraphicalEditPart) editPart).resolveSemanticElement();
		final Set<Stereotype> appliedStereotypes = (semantic instanceof Element)
				? ImmutableSet.copyOf(((Element) semantic).getAppliedStereotypes())
				: Collections.<Stereotype> emptySet();

		if (!appliedStereotypes.isEmpty()) {
			for (Iterator<? extends View> iter = result.iterator(); iter.hasNext();) {
				final EObject nextElement = iter.next().getElement();

				if (appliedStereotypes.contains(nextElement)) {
					iter.remove();
				}
			}
		}

		return result;
	}

	@Override
	public List<? extends View> getCanonicalEdges(EditPart editPart, View view) {
		return DEFAULT.getCanonicalEdges(editPart, view);
	}

}
