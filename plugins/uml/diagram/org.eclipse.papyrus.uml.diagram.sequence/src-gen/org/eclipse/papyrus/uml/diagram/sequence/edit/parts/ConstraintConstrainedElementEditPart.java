package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.ConstraintConstrainedElementItemSemanticEditPolicy;

/**
	 * @generated
	 */
public class ConstraintConstrainedElementEditPart extends AnnotatedLinkEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final String VISUAL_ID = "Constraint_ConstrainedElementEdge";

	/**
	 * @generated
	 */
	public ConstraintConstrainedElementEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DefaultSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ConstraintConstrainedElementItemSemanticEditPolicy());
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
		return new AnnotatedLinkEditPart.AnnotatedLinkDescriptor();
	}

	/**
	 * @generated
	 */
	public AnnotatedLinkEditPart.AnnotatedLinkDescriptor getPrimaryShape() {
		return (AnnotatedLinkEditPart.AnnotatedLinkDescriptor) getFigure();
	}

}
