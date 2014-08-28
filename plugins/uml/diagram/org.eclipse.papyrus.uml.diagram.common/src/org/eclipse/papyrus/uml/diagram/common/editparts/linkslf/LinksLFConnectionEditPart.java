package org.eclipse.papyrus.uml.diagram.common.editparts.linkslf;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.ForestRouter;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.OrthogonalRouter;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.LineMode;
import org.eclipse.gmf.runtime.gef.ui.internal.l10n.Cursors;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.RoutingStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.ConnectionEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.linklf.AbsoluteBendpointsConvention;
import org.eclipse.papyrus.infra.gmfdiag.common.linklf.editpolicies.DebugShowConnectionEndPointsAndAnchorsEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.linklf.editpolicies.LinksLFConnectionBendpointEditPolicy;


public abstract class LinksLFConnectionEditPart extends ConnectionEditPart {

	public LinksLFConnectionEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();

		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new DebugShowConnectionEndPointsAndAnchorsEditPolicy());
		installBendpointEditPolicy();
	}

	@Override
	protected void refreshBendpoints() {
		RelativeBendpoints bendpoints = (RelativeBendpoints)getEdge().getBendpoints();
		List<?> modelConstraint = bendpoints.getPoints();
		List<Bendpoint> figureConstraint = new ArrayList<Bendpoint>();
		for(int i = 0; i < modelConstraint.size(); i++) {
			org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint wbp = (org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint)modelConstraint.get(i);
			float weight;
			if(modelConstraint.size() == 1) {
				weight = 0.5f;
			} else {
				weight = i / ((float)modelConstraint.size() - 1);
			}
			Bendpoint bp = getAbsoluteBendpointsConvention().d2dBendpoint(wbp, getConnectionFigure(), weight);
			figureConstraint.add(bp);
		}
		getConnectionFigure().setRoutingConstraint(figureConstraint);
	}

	/**
	 * [GMFRT] make protected
	 */
	protected final void installBendpointEditPolicy() {
		if(getConnectionFigure().getConnectionRouter() instanceof ForestRouter) {
			installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new LinksLFConnectionBendpointEditPolicy(LineMode.ORTHOGONAL_CONSTRAINED));
		} else if(getConnectionFigure().getConnectionRouter() instanceof OrthogonalRouter) {
			installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new LinksLFConnectionBendpointEditPolicy(LineMode.ORTHOGONAL_FREE));
		} else {
			installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new LinksLFConnectionBendpointEditPolicy(LineMode.OBLIQUE));
		}

		EditPartUtil.synchronizeRunnableToMainThread(this, new Runnable() {

			public void run() {
				if(getConnectionFigure().getConnectionRouter() instanceof ForestRouter) {
					getConnectionFigure().setCursor(Cursors.CURSOR_SEG_MOVE);
				} else if(getConnectionFigure().getConnectionRouter() instanceof OrthogonalRouter) {
					getConnectionFigure().setCursor(Cursors.CURSOR_SEG_MOVE);
				} else {
					getConnectionFigure().setCursor(Cursors.CURSOR_SEG_ADD);
				}
			};
		});
	}

	protected void refreshRouterChange() {
		refreshBendpoints();
		installBendpointEditPolicy();
	}

	@Override
	protected void refreshRoutingStyles() {
		Connection connection = getConnectionFigure();
		if(!(connection instanceof PolylineConnectionEx))
			return;

		PolylineConnectionEx poly = (PolylineConnectionEx)connection;

		RoutingStyle style = (RoutingStyle)((View)getModel()).getStyle(NotationPackage.Literals.ROUTING_STYLE);
		if(style != null) {

			boolean closestDistance = style.isClosestDistance();
			boolean avoidObstruction = style.isAvoidObstructions();

			poly.setRoutingStyles(closestDistance, avoidObstruction);

			if(avoidObstruction)
				installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, null);
			else
				installBendpointEditPolicy();
		}
	}
	
	protected AbsoluteBendpointsConvention getAbsoluteBendpointsConvention() {
		return AbsoluteBendpointsConvention.getInstance();
	}

}
