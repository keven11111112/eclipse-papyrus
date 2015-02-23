/*****************************************************************************
 * Copyright (c) 2012, 2014 CEA LIST and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 323802
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.fr - Bug 393532
 *  Celine Janssens (ALL4TEC) celine.janssens@all4tec.net - Bug 455311 : Refactor Stereotypes Display
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.stereotype.edition.editpolicies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.uml2.uml.Element;

/**
 * this edit policy can be apply only on {@link IPapyrusEditPart} in order to
 * access to primary figure. the primary figure has to be a {@link IPapyrusNodeUMLElementFigure}
 * 
 */

public class AppliedStereotypeCompartmentEditPolicy extends AppliedStereotypeNodeLabelDisplayEditPolicy {

	/** constant for this edit policy role */
	public final static String STEREOTYPE_LABEL_POLICY = "AppliedStereotypeCompartmentEditPolicy"; //$NON-NLS-1$

	/**
	 * Creates a new AppliedStereotype display edit policy
	 */
	public AppliedStereotypeCompartmentEditPolicy() {
		super();
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy#refreshStereotypeDisplay()
	 *
	 */
	@Override
	protected void refreshStereotypeDisplay() {
		if (getHost() instanceof IPapyrusEditPart) {
			IFigure figure = ((IPapyrusEditPart) getHost()).getPrimaryShape();
			// Refresh Properties in braces
			refreshAppliedStereotypesPropertiesInBrace((IPapyrusNodeUMLElementFigure) figure);
		}
	}


	/**
	 * Refreshes the stereotypes properties displayed above name of the element
	 * in this edit part.
	 * 
	 * @param stereotypesPropertiesToDisplay
	 */
	protected void refreshAppliedStereotypesPropertiesInBrace(IPapyrusNodeUMLElementFigure figure) {
		String toDisplayInBrace = helper.getStereotypePropertiesInBrace(((GraphicalEditPart) getHost()).getNotationView());
		// if the string is not empty, then, the figure has to display it. Else,
		// it displays nothing
		if (!"".equals(toDisplayInBrace)) {
			// it has to be displayed in braces, so compute the string to
			// display
			figure.setStereotypePropertiesInBrace(toDisplayInBrace);
		} else {
			figure.setStereotypePropertiesInBrace(null);
		}
	}


	/**
	 * Returns the uml element controlled by the host edit part
	 *
	 * @return the uml element controlled by the host edit part
	 */
	@Override
	protected Element getUMLElement() {
		Element element = null;

		View view = getView();
		if (view != null) {

			EObject container = view.eContainer();
			if (container instanceof View) {
				element = (Element) ((View) container).getElement();
			}
		}

		return element;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.AbstractAppliedStereotypeDisplayEditPolicy#getView()
	 *
	 * @return
	 */
	@Override
	protected View getView() {
		View view = null;

		Object model = getHost().getModel();
		if (model instanceof View) {

			EObject container = ((View) model).eContainer();
			if (container instanceof View) {
				view = (View) container;
			}
		}
		return view;
	}


}
