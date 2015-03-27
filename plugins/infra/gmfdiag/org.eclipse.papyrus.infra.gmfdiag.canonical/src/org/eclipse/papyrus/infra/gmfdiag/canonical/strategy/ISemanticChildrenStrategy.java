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
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.canonical.strategy;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

/**
 * A pluggable strategy for determination of semantic "children" of an element, those being
 * either contained elements, relationships of the element, or other related elements.
 */
public interface ISemanticChildrenStrategy {
	/**
	 * Queries the semantic elements that should be presented visually as children of the specified element.
	 *
	 * @param semanticFromEditPart
	 *            the semantic model element represented by a canonical edit-part in the diagram
	 * @param viewFromEditPart
	 *            the visual (notational) representation of the semantic element, to provide diagram context if required (such as
	 *            for determining the appropriate part-with-port match of a connector end)
	 * @return list of semantic elements, or {@code null} to indicate that the strategy does not support the given element.
	 *         <b>Note</b> that the result is specifically a {@link List} type because the GMF {@link CanonicalEditPolicy} expects lists of children, not other kinds of collections
	 */
	public List<? extends EObject> getCanonicalSemanticChildren(EObject semanticFromEditPart, View viewFromEditPart);

	/**
	 * Queries the semantic elements that should be presented visually as connections attached to the specified element.
	 *
	 * @param semanticFromEditPart
	 *            the semantic model element represented by a canonical edit-part in the diagram
	 * @param viewFromEditPart
	 *            the visual (notational) representation of the semantic element, to provide diagram context if required (such as
	 *            for determining the appropriate part-with-port match of a connector end)
	 * @return list of semantic connection elements, or {@code null} to indicate that the strategy does not support the given element.
	 *         <b>Note</b> that the result is specifically a {@link List} type because the GMF {@link CanonicalEditPolicy} expects lists of children, not other kinds of collections
	 */
	public List<? extends EObject> getCanonicalSemanticConnections(EObject semanticFromEditPart, View viewFromEditPart);

	/**
	 * Retrieves objects, if any, related to the element behind a canonical edit-part
	 * on which the that element depends for canonical refresh updates.
	 * 
	 * @param semanticFromEditPart
	 *            the semantic model element represented by a canonical edit-part in the diagram
	 * @param viewFromEditPart
	 *            the visual (notational) representation of the semantic element, to provide diagram context if required (such as
	 *            for determining the appropriate part-with-port match of a connector end)
	 * @return dependents of the semantic element, or {@code null} to indicate that it does not support dependents
	 */
	public Collection<? extends EObject> getCanonicalDependents(EObject semanticFromEditPart, View viewFromEditPart);

}
