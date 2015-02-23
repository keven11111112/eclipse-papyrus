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
 *   Celine Janssens (ALL4TEC) celine.janssens@all4tec.net - Bug 460356 : Refactor Stereotype Display
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.stereotype.edition.editpolicies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeNamedElementFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.swt.graphics.Image;

/**
 * @author Céline JANSSENS
 *         This Policy is in charge of create and delete the applied Stereotype Label Node into the Notation model
 */
public class AppliedStereotypeLabelEditPolicy extends AppliedStereotypeNodeLabelDisplayEditPolicy {

	/** constant for this edit policy role */
	public final static String STEREOTYPE_LABEL_POLICY = "AppliedStereotypeLabelEditPolicy"; //$NON-NLS-1$

	private GraphicalEditPart hostEditPart = null;

	/**
	 * Creates a new AppliedStereotype display edit policy
	 */
	public AppliedStereotypeLabelEditPolicy() {
		super();

	}


	@Override
	public void activate() {
		super.activate();
		if (getHost() instanceof GraphicalEditPart) {
			hostEditPart = (GraphicalEditPart) getHost();
		}
	}


	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy#refreshStereotypeDisplay()
	 *
	 */
	@Override
	protected void refreshStereotypeDisplay() {
		refreshStereotypeLabelDisplay();


	}

	protected void refreshStereotypeLabelDisplay() {
		if (getHost() instanceof IPapyrusEditPart) {
			IFigure figure = ((IPapyrusEditPart) getHost()).getPrimaryShape();

			// calculate text and icon to display
			final String stereotypesToDisplay = helper.getStereotypeTextToDisplay((View) getHost().getModel());
			// computes the icon to be displayed
			final Image imageToDisplay = stereotypeIconToDisplay();

			// if the string is not empty, then, the figure has to display it.
			// Else, it displays nothing
			if (figure instanceof IPapyrusNodeUMLElementFigure) {

				// Refresh Stereotype Label
				// Stereotype should be passed as "" if null, in order to avoid "null" string.
				((IPapyrusNodeUMLElementFigure) figure).setStereotypeDisplay(tag + (stereotypesToDisplay == null ? "" : stereotypesToDisplay), imageToDisplay);

				// Refresh Stereotype Label
				if (figure instanceof IPapyrusNodeNamedElementFigure) {
					refreshAppliedStereotypesLabel((IPapyrusNodeUMLElementFigure) figure);
				}
			}
		}

	}


	/**
	 * Refreshes the displayed stereotypes properties for this edit part.
	 */
	protected void refreshAppliedStereotypesLabel(IPapyrusNodeUMLElementFigure figure) {
		// If node has a Label
		if (figure instanceof IPapyrusNodeNamedElementFigure) {

			// Refresh Label
			boolean displayStereotypes = NotationUtils.getBooleanValue(getView(), NamedElementEditPart.DISPLAY_STEREOTYPES, true);
			if (!displayStereotypes) {
				((IPapyrusNodeNamedElementFigure) figure).removeStereotypeLabel();
			} else {
				((IPapyrusNodeNamedElementFigure) figure).restoreStereotypeLabel();
			}
		}
	}

}
