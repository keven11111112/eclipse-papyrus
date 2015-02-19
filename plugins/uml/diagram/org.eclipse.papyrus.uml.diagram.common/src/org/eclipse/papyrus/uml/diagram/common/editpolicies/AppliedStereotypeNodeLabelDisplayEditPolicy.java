/*****************************************************************************
 * Copyright (c) 2009, 2014 CEA LIST and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 429275
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeNamedElementFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.stereotype.StereotypeDisplayHelper;
import org.eclipse.swt.graphics.Image;

/**
 * this edit policy can be apply only on {@link IPapyrusEditPart} in order to
 * access to primary figure. the primary figure has to be a {@link IPapyrusNodeUMLElementFigure}
 */
public class AppliedStereotypeNodeLabelDisplayEditPolicy extends AppliedStereotypeLabelDisplayEditPolicy {

	public AppliedStereotypeNodeLabelDisplayEditPolicy() {
		super();
	}

	public AppliedStereotypeNodeLabelDisplayEditPolicy(String tag) {
		super(tag);
	}

	/**
	 * Refreshes the stereotype display
	 */
	@Override
	protected void refreshStereotypeDisplay() {
		if (getHost() instanceof IPapyrusEditPart) {
			IFigure figure = ((IPapyrusEditPart) getHost()).getPrimaryShape();

			// calculate text and icon to display
			final String stereotypesToDisplay = StereotypeDisplayHelper.getStereotypeTextToDisplay((View) getHost().getModel());
			// computes the icon to be displayed
			final Image imageToDisplay = stereotypeIconToDisplay();

			// if the string is not empty, then, the figure has to display it.
			// Else, it displays nothing
			if (figure instanceof IPapyrusNodeUMLElementFigure) {
				// Stereotype should be passed as "" if null, in order to avoid "null" string.
				((IPapyrusNodeUMLElementFigure) figure).setStereotypeDisplay(tag + (stereotypesToDisplay == null ? "" : stereotypesToDisplay), imageToDisplay);

				if (figure instanceof IPapyrusNodeNamedElementFigure) {
					refreshAppliedStereotypesProperties((IPapyrusNodeNamedElementFigure) figure);
				} else {
					refreshAppliedStereotypesProperties((IPapyrusNodeUMLElementFigure) figure);
				}
			}
			// TODO we should manage PapyrusNodeFigure here too (and
			// WrappingLabel ?)
		}
	}

	/**
	 * Refreshes the displayed stereotypes properties for this edit part.
	 */
	protected void refreshAppliedStereotypesProperties(IPapyrusNodeNamedElementFigure figure) {

		refreshAppliedStereotypesPropertiesInBrace(figure);

		BooleanValueStyle displayStereotypes = (BooleanValueStyle) getView().getNamedStyle(NotationPackage.eINSTANCE.getBooleanValueStyle(), NamedElementEditPart.DISPLAY_STEREOTYPES);
		if (displayStereotypes != null && !displayStereotypes.isBooleanValue()) {
			figure.removeStereotypeLabel();
		} else {
			figure.restoreStereotypeLabel();
		}
	}

	/**
	 * Refreshes the displayed stereotypes properties for this edit part.
	 */
	protected void refreshAppliedStereotypesProperties(IPapyrusNodeUMLElementFigure figure) {

		refreshAppliedStereotypesPropertiesInBrace(figure);
	}


	/**
	 * Refreshes the stereotypes properties displayed above name of the element
	 * in this edit part.
	 * 
	 * @param stereotypesPropertiesToDisplay
	 */
	protected void refreshAppliedStereotypesPropertiesInBrace(IPapyrusNodeUMLElementFigure figure) {
		String toDisplayInBrace = StereotypeDisplayHelper.getStereotypePropertiesInBrace(((GraphicalEditPart) getHost()).getNotationView());
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

}
