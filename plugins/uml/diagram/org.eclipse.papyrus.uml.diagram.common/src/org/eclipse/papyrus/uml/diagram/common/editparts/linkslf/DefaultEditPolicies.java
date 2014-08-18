package org.eclipse.papyrus.uml.diagram.common.editparts.linkslf;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.linklf.editpolicies.AdjustImplicitlyMovedLinksEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.linklf.editpolicies.LinksLFGraphicalNodeEditPolicy;


class DefaultEditPolicies {

	static void installNodeEditPolicies(INodeEditPart nodeEP) {
		nodeEP.installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new LinksLFGraphicalNodeEditPolicy());
		nodeEP.installEditPolicy(AdjustImplicitlyMovedLinksEditPolicy.ROLE, new AdjustImplicitlyMovedLinksEditPolicy());
	}

}
