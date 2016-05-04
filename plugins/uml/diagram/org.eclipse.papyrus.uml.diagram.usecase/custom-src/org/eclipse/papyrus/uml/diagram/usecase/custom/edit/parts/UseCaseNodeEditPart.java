package org.eclipse.papyrus.uml.diagram.usecase.custom.edit.parts;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editparts.RoundedCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideClassifierContentsEditPolicy;

/**
 * @author Mickael ADAM
 *
 */
abstract public class UseCaseNodeEditPart extends RoundedCompartmentEditPart {

	/**
	 * Constructor.
	 *
	 * @param view
	 */
	public UseCaseNodeEditPart(View view) {
		super(view);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * Add missing edit policy to show/hide contents (Bug 489118)
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.RoundedCompartmentEditPart#createDefaultEditPolicies()
	 *
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(ShowHideClassifierContentsEditPolicy.SHOW_HIDE_CLASSIFIER_CONTENTS_POLICY, new ShowHideClassifierContentsEditPolicy());
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.RoundedCompartmentEditPart#getDefaultIsOvalValue()
	 *
	 * @return
	 */
	@Override
	protected boolean getDefaultIsOvalValue() {
		return true;
	}

}
