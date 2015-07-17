package org.eclipse.papyrus.uml.diagram.sequence.figures;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.PolylineShape;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.papyrus.uml.diagram.common.draw2d.CenterLayout;
import org.eclipse.papyrus.uml.diagram.common.draw2d.LinesBorder;

public class DurationConstraintFigure extends RectangleFigure {

	private PolylineShape fDurationArrow;

	private final IMapMode mapMode;

	public DurationConstraintFigure() {
		mapMode = SequenceMapModeUtil.getMapModel(this);
		CenterLayout layoutThis = new CenterLayout();
		this.setLayoutManager(layoutThis);
		this.setFill(false);
		this.setOutline(false);
		this.setPreferredSize(new Dimension(mapMode.DPtoLP(40), mapMode.DPtoLP(-1)));
		this.setBorder(createBorder0());
		createContents();
	}

	private void createContents() {
		fDurationArrow = new PolylineShape();
		fDurationArrow.addPoint(new Point(mapMode.DPtoLP(0), mapMode.DPtoLP(0)));
		fDurationArrow.addPoint(new Point(mapMode.DPtoLP(10), mapMode.DPtoLP(0)));
		this.add(fDurationArrow);
	}

	private Border createBorder0() {
		LinesBorder result = new LinesBorder();
		result.setSides(PositionConstants.TOP | PositionConstants.BOTTOM);
		return result;
	}

	public PolylineShape getDurationArrow() {
		return fDurationArrow;
	}
}