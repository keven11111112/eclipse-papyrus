/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 *  Celine JANSSENS (ALL4TEC) celine.janssens@all4tec.net - Bug 455311 Stereotype Display
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusUMLElementFigure;
import org.eclipse.uml2.uml.Stereotype;

/**
 * This edit policy is used to display only applied stereotypes and properties
 * in a external node (that is a labelEditPart) In order to use it, the edit
 * part has to be {@link IPapyrusEditPart} and the associated figure has to be {@link IPapyrusUMLElementFigure}
 */
public class AppliedStereotypeExternalNodeEditPolicy extends AppliedStereotypeLabelDisplayEditPolicy {

	protected View parentView = null;

	public AppliedStereotypeExternalNodeEditPolicy() {
		super();
	}

	@Override
	public void activate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if (view == null) {
			return;
		}
		super.activate();
		// add a listener for TimeObservationEditPart
		// eContainer = getParent() , but here it's the ECore model
		EObject parent = view.eContainer();
		if (parent instanceof View) {
			parentView = (View) parent;
			getDiagramEventBroker().addNotificationListener(parentView, this);
		}

		refreshDisplay();

	}

	@Override
	public void deactivate() {
		if (parentView != null) {
			getDiagramEventBroker().removeNotificationListener(parentView, this);
		}

		super.deactivate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void refreshDisplay() {
		refreshStereotypeDisplay();
	}

	/**
	 * Retrieve the List of the Stereotypes to Display
	 *
	 * @return the list of stereotypes to display with properties if there are
	 *         selected to be displayed
	 */
	@Override
	public String stereotypesToDisplay() {

		// retrieve all stereotypes to be displayed

		if (parentView == null) {
			return "";
		}

		// try to display stereotype properties
		String stereotypesToDisplay = helper.getStereotypeTextToDisplay(parentView);
		return stereotypesToDisplay;
	}


	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.AbstractAppliedStereotypeDisplayEditPolicy#refreshStereotypeBraceStructure(org.eclipse.uml2.uml.Stereotype)
	 *
	 * @param stereotype
	 *            Stereotype related to the Brace to refresh
	 */
	@Override
	public void refreshStereotypeBraceStructure(Stereotype stereotype) {
		// Nothing to Do
	}



	/**
	 * Refresh the text of the stereotype
	 */
	@Override
	protected void refreshStereotypeDisplay() {
		if (getHost() instanceof IPapyrusEditPart) {
			IFigure figure = ((IPapyrusEditPart) getHost()).getPrimaryShape();

			if (figure instanceof IPapyrusUMLElementFigure) {// calculate text
				// and icon to display
				final String stereotypesToDisplay = stereotypesToDisplay();
				((IPapyrusUMLElementFigure) figure).setStereotypeDisplay(tag + (stereotypesToDisplay), null);

			}

		}

	}
}
