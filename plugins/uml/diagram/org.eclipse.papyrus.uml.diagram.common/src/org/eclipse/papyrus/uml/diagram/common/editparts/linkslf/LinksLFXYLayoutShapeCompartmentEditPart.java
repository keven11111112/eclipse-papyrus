package org.eclipse.papyrus.uml.diagram.common.editparts.linkslf;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.XYLayoutShapeCompartmentEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.XYLayoutWithConstrainedResizedEditPolicy;

/**
 * This is LinksLF counterpart for {@link XYLayoutShapeCompartmentEditPart}.
 * We don't extend it directly but just enforced installation of the same edit policy.
 * <p/>
 * This compartment edit part should be used for CompartmentEditPart with XYlayoutEditPolicy, as it replaces default editpolicy by papyrus-specific
 * 
 * @see #424942: [Diagram] Papyrus shall ease resizing of model elements owning children
 * 
 */
public class LinksLFXYLayoutShapeCompartmentEditPart extends XYLayoutShapeCompartmentEditPart {

	public LinksLFXYLayoutShapeCompartmentEditPart(View view) {
		super(view);
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutWithConstrainedResizedEditPolicy());
	}

}
