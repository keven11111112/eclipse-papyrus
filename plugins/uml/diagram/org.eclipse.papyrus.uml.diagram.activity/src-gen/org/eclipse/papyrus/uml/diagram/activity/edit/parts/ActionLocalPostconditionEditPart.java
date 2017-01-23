package org.eclipse.papyrus.uml.diagram.activity.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.ConnectionEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultSemanticEditPolicy;

/**
	 * @generated
	 */
public class ActionLocalPostconditionEditPart extends ConnectionEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final String VISUAL_ID = "Action_LocalPostconditionEdge";

	/**
	 * @generated
	 */
	public ActionLocalPostconditionEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DefaultSemanticEditPolicy());
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected Connection createConnectionFigure() {
		return new DashedLinkDescriptor();
	}

	/**
	 * @generated
	 */
	public DashedLinkDescriptor getPrimaryShape() {
		return (DashedLinkDescriptor) getFigure();
	}

	/**
	 * @generated
	 */
	public class DashedLinkDescriptor extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public DashedLinkDescriptor() {
			this.setLineStyle(Graphics.LINE_DASH);

		}

	}

}
