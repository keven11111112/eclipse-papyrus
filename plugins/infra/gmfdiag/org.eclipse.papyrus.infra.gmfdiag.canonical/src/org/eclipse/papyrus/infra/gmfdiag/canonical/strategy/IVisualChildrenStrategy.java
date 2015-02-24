/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Christian W. Damus - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.canonical.strategy;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

/**
 * A pluggable strategy for determination of visual "children" of an element, those being
 * either child nodes or connected edges.
 */
public interface IVisualChildrenStrategy {
	/**
	 * Queries the visual elements that are children a view that should be synchronized
	 * with the represented element's semantic "children".
	 *
	 * @param editPart
	 *            the edit-part being synchronized
	 * @param view
	 *            the edit-part's notation view
	 * @return a list of child views, or {@code null} to indicate that the strategy does not support the given edit-part.
	 *         <b>Note</b> that the result is specifically a {@link List} type because the GMF {@link CanonicalEditPolicy} expects lists of views, not other kinds of collections
	 */
	public List<? extends View> getCanonicalChildren(EditPart editPart, View view);

	/**
	 * Queries the visual elements that are edges connected to a view that should be synchronized
	 * with the represented element's semantic "children" or "connections". The returned views may
	 * alternatively or also include child views of connected edges, in the case that those children
	 * (e.g., labels) are the significant representative views.
	 *
	 * @param editPart
	 *            the edit-part being synchronized
	 * @param view
	 *            the edit-part's notation view
	 * @return a list of connected edges (or some child views of connected edges), or {@code null} to indicate that the strategy does not support the given edit-part.
	 *         <b>Note</b> that the result is specifically a {@link List} type because the GMF {@link CanonicalEditPolicy} expects lists of views, not other kinds of collections
	 */
	public List<? extends View> getCanonicalEdges(EditPart editPart, View view);

}
