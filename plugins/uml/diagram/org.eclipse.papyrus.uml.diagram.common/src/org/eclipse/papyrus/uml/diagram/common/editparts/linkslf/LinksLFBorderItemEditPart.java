package org.eclipse.papyrus.uml.diagram.common.editparts.linkslf;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.linklf.ShapeNodeAnchorDelegate;


public abstract class LinksLFBorderItemEditPart extends AbstractBorderItemEditPart {

	private ShapeNodeAnchorDelegate myShapeNodeAnchorDelegate;

	public LinksLFBorderItemEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		DefaultEditPolicies.installNodeEditPolicies(this);
	}

	@Override
	public final ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return getShapeNodeAnchorDelegate().getSourceConnectionAnchor(request);
	}

	@Override
	public final ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return getShapeNodeAnchorDelegate().getTargetConnectionAnchor(request);
	}

	private ShapeNodeAnchorDelegate getShapeNodeAnchorDelegate() {
		if(myShapeNodeAnchorDelegate == null) {
			myShapeNodeAnchorDelegate = new ShapeNodeAnchorDelegate(getNodeFigure());
		}
		return myShapeNodeAnchorDelegate;
	}

}
