package org.eclipse.papyrus.bpmn.diagram.common.providers;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.bpmn.diagram.common.edit.part.LaneEditPart;
import org.eclipse.papyrus.bpmn.diagram.common.edit.part.LaneLaneContentCompartmentEditPart;
import org.eclipse.papyrus.bpmn.diagram.common.edit.part.LaneNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.part.CustomUMLEditPartFactory;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityPartitionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityPartitionNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry;

public class CustomBpmnUMLEditPartFactory extends CustomUMLEditPartFactory {
	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (UMLVisualIDRegistry.getVisualID(view)) {
			case LaneEditPart.VISUAL_ID:
				return new LaneEditPart(view);
			case LaneNameEditPart.VISUAL_ID:
				return new LaneNameEditPart(view);
			case LaneLaneContentCompartmentEditPart.VISUAL_ID:
				return new LaneLaneContentCompartmentEditPart(view);
			}
		}
		return super.createEditPart(context, model);
	}
}
