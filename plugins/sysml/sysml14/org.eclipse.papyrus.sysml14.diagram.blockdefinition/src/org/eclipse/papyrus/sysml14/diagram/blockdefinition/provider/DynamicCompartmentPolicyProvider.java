/*****************************************************************************
 * Copyright (c) 2010-2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *		CEA LIST - Initial API and implementation
 *		Arthur Daussy - arthur.daussy@atos.net - 395920: [Block Diagram Definition] All element contained by a block should be able to be linked to constraint or comment
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml14.diagram.blockdefinition.provider;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.ShapeCompartmentEditPolicy;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.papyrus.sysml14.diagram.blockdefinition.policy.DynamicCompartmentCreatorEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;

/**
 * Edit policy provider for the shape compartement
 */
public class DynamicCompartmentPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	private String diagramType="SysML 1.4 Block Definition";
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean provides(IOperation operation) {
		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation) operation;
		if (!(epOperation.getEditPart() instanceof IGraphicalEditPart)) {
			return false;
		}

		// Make sure this concern Block Definition Diagram only
		IGraphicalEditPart gep = (IGraphicalEditPart) epOperation.getEditPart();
		if (! isRelevantDiagram(gep.getNotationView().getDiagram())) {
			return false;
		}
		
		if (gep instanceof NamedElementEditPart) {
			return true;
		}

		return false;
	}
	protected boolean isRelevantDiagram (Diagram diagram){
		ViewPrototype viewPrototype=org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils.getPrototype(diagram);
		if(viewPrototype!=null){
			if(diagramType.equals(viewPrototype.getLabel())){
				return true;
			}
			return false;
			
		}
		if ((diagramType != null) && (diagramType.equals(diagram.getType()))) {
			return true;
		}
		return false;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createEditPolicies(EditPart editPart) {
		// add behavior for the shapes display
		if (editPart instanceof NamedElementEditPart) { // add to Block Property Composite and Block Composite
			editPart.installEditPolicy(DynamicCompartmentCreatorEditPolicy.COMPARTMENT_CREATOR_EDITPOLICY, new DynamicCompartmentCreatorEditPolicy());
		}
	}
}
