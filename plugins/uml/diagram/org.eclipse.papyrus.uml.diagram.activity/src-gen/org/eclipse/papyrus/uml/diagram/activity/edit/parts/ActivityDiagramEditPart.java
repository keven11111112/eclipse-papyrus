package org.eclipse.papyrus.uml.diagram.activity.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.PapyrusDiagramEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCompartmentSemanticEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.activity.edit.policies.RemoveOrphanViewPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.PasteEditPolicy;

/**
 * @generated
 */
public class ActivityDiagramEditPart extends PapyrusDiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "PapyrusUMLActivityDiagram"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String VISUAL_ID = "Package_ActivityDiagram";

	/**
	 * @generated
	 */
	public ActivityDiagramEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();

		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new DefaultCreationEditPolicy());
		installEditPolicy(PasteEditPolicy.PASTE_ROLE, new PasteEditPolicy());

		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DefaultCompartmentSemanticEditPolicy());
		// in Papyrus diagrams are not strongly synchronised
		// installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new org.eclipse.papyrus.uml.diagram.activity.edit.policies.ActivityDiagramCanonicalEditPolicy());

		installEditPolicy("RemoveOrphanView", new RemoveOrphanViewPolicy()); //$NON-NLS-1$
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

}
