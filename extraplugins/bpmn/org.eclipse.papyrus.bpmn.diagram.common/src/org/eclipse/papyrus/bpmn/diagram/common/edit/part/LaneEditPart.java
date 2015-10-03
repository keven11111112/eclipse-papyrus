package org.eclipse.papyrus.bpmn.diagram.common.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.bpmn.diagram.common.figures.ActivityHorizontalPartitionFigure;
import org.eclipse.papyrus.uml.diagram.activity.edit.part.CustomActivityPartitionEditPart;


public class LaneEditPart extends CustomActivityPartitionEditPart {

	private ActivityHorizontalPartitionFigure laneFigure;

	public LaneEditPart(View view) {
		super(view);
	}

	@Override
	protected IFigure createNodeShape() {
		laneFigure = new ActivityHorizontalPartitionFigure();
		return primaryShape = laneFigure;

	}
	
	@Override
	protected void refreshLabelDisplay() {
		laneFigure.getVerticalLabel().setText(getNamedElement().getName());;
	}
}
