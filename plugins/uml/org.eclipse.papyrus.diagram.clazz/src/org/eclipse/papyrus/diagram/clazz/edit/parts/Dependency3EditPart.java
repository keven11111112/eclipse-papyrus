package org.eclipse.papyrus.diagram.clazz.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.policies.Dependency3ItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.common.figure.edge.DashEdgeFigure;

/**
 * @generated
 */
public class Dependency3EditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4018;

	/**
	 * @generated
	 */
	public Dependency3EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new Dependency3ItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof DependencyName3EditPart) {
			((DependencyName3EditPart) childEditPart)
					.setLabel(getPrimaryShape().getDependencyNameLabel());
			return true;
		}
		if (childEditPart instanceof AppliedStereotypeDependency3EditPart) {
			((AppliedStereotypeDependency3EditPart) childEditPart)
					.setLabel(getPrimaryShape().getAppliedStereotypeLabel());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof DependencyName3EditPart) {
			return true;
		}
		if (childEditPart instanceof AppliedStereotypeDependency3EditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
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
		return new DependencyDescriptor();
	}

	/**
	 * @generated
	 */
	public DependencyDescriptor getPrimaryShape() {
		return (DependencyDescriptor) getFigure();
	}

	/**
	 * @generated
	 */
	public class DependencyDescriptor extends DashEdgeFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fDependencyNameLabel;
		/**
		 * @generated
		 */
		private WrappingLabel fAppliedStereotypeLabel;

		/**
		 * @generated
		 */
		public DependencyDescriptor() {

			this.setForegroundColor(ColorConstants.black);
			this.setBackgroundColor(ColorConstants.black);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fDependencyNameLabel = new WrappingLabel();
			fDependencyNameLabel.setText("");

			this.add(fDependencyNameLabel);

			fAppliedStereotypeLabel = new WrappingLabel();
			fAppliedStereotypeLabel.setText("");

			this.add(fAppliedStereotypeLabel);

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getDependencyNameLabel() {
			return fDependencyNameLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getAppliedStereotypeLabel() {
			return fAppliedStereotypeLabel;
		}

	}

}
