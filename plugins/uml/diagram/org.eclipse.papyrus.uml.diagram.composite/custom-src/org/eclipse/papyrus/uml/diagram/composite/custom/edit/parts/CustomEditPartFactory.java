/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConnectorMultiplicitySourceEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConnectorMultiplicityTargetEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.DurationObservationStereotypeLabelEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ParameterAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.PortAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.PortEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.PortNameEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.TimeObservationStereotypeLabelEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.UMLEditPartFactory;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLVisualIDRegistry;

/**
 * Replacement EditPart factory.
 */
public class CustomEditPartFactory extends UMLEditPartFactory {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (UMLVisualIDRegistry.getVisualID(view)) {

			case ConnectorMultiplicitySourceEditPart.VISUAL_ID:
				return new CustomConnectorMultiplicitySourceEditPart(view);
			case ConnectorMultiplicityTargetEditPart.VISUAL_ID:
				return new CustomConnectorMultiplicityTargetEditPart(view);
			case ConstraintEditPartCN.VISUAL_ID:
				return new CustomConstraintEditPartCN(view);
			case PortEditPart.VISUAL_ID:
				return new CustomPortEditPart(view);
			case PortNameEditPart.VISUAL_ID:
				return new CustomPortNameEditPart(view);
			case DurationObservationStereotypeLabelEditPart.VISUAL_ID:
				return new CustomDurationObservationStereotypeLabelEditPart(view);
			case ParameterAppliedStereotypeEditPart.VISUAL_ID:
				return new CustomParameterAppliedStereotypeEditPart(view);
			case PortAppliedStereotypeEditPart.VISUAL_ID:
				return new CustomPortAppliedStereotypeEditPart(view);
			case TimeObservationStereotypeLabelEditPart.VISUAL_ID:
				return new CustomTimeObservationStereotypeLabelEditPart(view);
			}
		}
		return super.createEditPart(context, model);
	}
}
