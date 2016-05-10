/*****************************************************************************
 * Copyright (c) 2015, 2016 Christian W. Damus and others.
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

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewType;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.canonical.strategy.IVisualChildrenStrategy;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.AutomaticNotationEditPolicy;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

/**
 * Default strategy for calculation of child views in the UML domain. This accounts for the compartments and labels
 * that present applied stereotypes, which have nothing to do with model-view synchronization.
 */
public class DefaultUMLVisualChildrenStrategy implements IVisualChildrenStrategy {
	/** View types that are managed by other edit-policies. */
	private static final Set<String> excludedViewTypes = new HashSet<String>();

	public DefaultUMLVisualChildrenStrategy() {
		super();
	}

	/**
	 * Registers view types that should be ignored by the CanonicalEditPolicy for
	 * the purposes of view creation and deletion, because (usually) they are managed
	 * {@linkplain AutomaticNotationEditPolicy automatically} by other edit-policies.
	 * 
	 * @param viewTypes
	 *            view types to be excluded from canonical management
	 */
	public static void registerExcludedViewTypes(Collection<String> viewTypes) {
		excludedViewTypes.addAll(viewTypes);
	}

	@Override
	public List<? extends View> getCanonicalChildren(EditPart editPart, View view) {
		List<View> result = Lists.newArrayListWithCapacity(view.getChildren().size());

		collectChildren(view, result);

		// Filter out child views that visualize the same element as my view (these
		// should be compartments, decorations, labels) or that represent applied stereotypes
		final EObject semantic = ((IGraphicalEditPart) editPart).resolveSemanticElement();

		final Set<Stereotype> appliedStereotypes = (semantic instanceof Element)
				? ImmutableSet.copyOf(((Element) semantic).getAppliedStereotypes())
				: Collections.<Stereotype> emptySet();

		// And the transient views that support CSS-driven presentation
		for (Iterator<View> iter = result.iterator(); iter.hasNext();) {
			View v = iter.next();
			EObject element = v.getElement();

			if ((element == semantic)
					|| appliedStereotypes.contains(v.getElement())
					|| excludedViewTypes.contains(v.getType())) {

				iter.remove();
			}
		}

		return result;
	}


	protected void collectChildren(View view, List<? super View> result) {
		for (Object child : view.getChildren()) {
			if (child instanceof View) {
				View childView = (View) child;

				// Elide groups
				if (ViewType.GROUP.equals(childView.getType())) {
					collectChildren(childView, result);
				} else {
					result.add(childView);
				}
			}
		}
	}

	@Override
	public List<? extends View> getCanonicalEdges(EditPart editPart, View view) {
		// Get distinct incoming and outgoing edges of top shapes and border items.
		// Compartments of top shapes take care of their own contents
		List<View> result = Lists.newArrayList();

		if (view.eIsSet(NotationPackage.Literals.VIEW__SOURCE_EDGES)) {
			result.addAll(view.getSourceEdges());
		}
		if (view.eIsSet(NotationPackage.Literals.VIEW__TARGET_EDGES)) {
			for (Edge next : (Iterable<? extends Edge>) view.getTargetEdges()) {
				if (next.getSource() != view) {
					// Didn't already get a self-edge from the source edges
					result.add(next);
				}
			}
		}

		// And filter out any edges that do not represent a semantic element (reference links, such as
		// for Constraint::constrainedElement)
		for (ListIterator<View> iter = result.listIterator(); iter.hasNext();) {
			View next = iter.next();

			// An unset-null would mean that it represents the parent view's semantic element
			if (next.isSetElement() && (next.getElement() == null)) {
				iter.remove();
			}
		}

		return result;
	}

}
