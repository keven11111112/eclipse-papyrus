package org.eclipse.papyrus.uml.diagram.sequence.figures;

import org.eclipse.draw2d.PolylineShape;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;

public class SequencePolylineShape extends PolylineShape {

	protected IMapMode getMapModel() {
		IMapMode curMapMode = MapModeUtil.getMapMode(this);
		return curMapMode == null ? MapModeUtil.getMapMode() : curMapMode;
	}
}
