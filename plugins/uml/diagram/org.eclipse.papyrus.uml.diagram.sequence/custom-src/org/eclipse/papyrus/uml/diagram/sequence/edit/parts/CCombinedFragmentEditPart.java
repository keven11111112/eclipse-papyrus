/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Céline Janssens (celine.janssens@all4tec.net) - Add Coregion  functionnality
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.figures.CombinedFragmentFigure;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.ConsiderIgnoreFragment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InteractionOperatorKind;

/**
 * @author PT202707
 * @since 3.0
 *
 */
public class CCombinedFragmentEditPart extends CombinedFragmentEditPart {
	public static int DEFAULT_HEIGHT = 60;
	public static int DEFAULT_WIDTH = 40;


	/**
	 * Constructor.
	 *
	 * @param view
	 */
	public CCombinedFragmentEditPart(View view) {
		super(view);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param event
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {

		super.handleNotificationEvent(event);
		getPrimaryShape().setName(((CombinedFragment) this.resolveSemanticElement()).getInteractionOperator().getLiteral());
	}


	/**
	 * Get the Notation Value of the CoRegion boolean
	 * 
	 * @return true if the Combined Fragment should be displayed as a CoRegion with Brackets.
	 *         This is the case if the Operator is Parallel and if the combinedFragment covers only 1 lifeline
	 */
	public boolean isCoregion() {

		boolean coregion = false;
		Element umlElement = getUMLElement();

		if ((umlElement instanceof CombinedFragment) && !(umlElement instanceof ConsiderIgnoreFragment)) {

			InteractionOperatorKind interactionOperator = ((CombinedFragment) umlElement).getInteractionOperator();
			if (InteractionOperatorKind.PAR_LITERAL.getLiteral() == interactionOperator.getLiteral()) {
				if (((CombinedFragment) umlElement).getCovereds().size() == 1) {
					coregion = true;
				}
			}
		}

		return coregion;
	}


	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart#refresh()
	 *
	 *      Refresh the CoRegion Value
	 */
	@Override
	public void refresh() {

		((CombinedFragmentFigure) getPrimaryShape()).setCoregion(isCoregion());
		super.refresh();

	}

}
