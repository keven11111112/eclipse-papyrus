package org.eclipse.papyrus.bpmn.diagram.common.editpolicy;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ForkNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.JoinNodeEditPart;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

public class BpmnProcessEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider {

	public void createEditPolicies(EditPart editPart) {
		/*
		 * 
		 * Installation of notiying edit polocy
		 */
		if (editPart instanceof ForkNodeEditPart || editPart instanceof JoinNodeEditPart) {
			if (editPart.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) != null) {
				editPart.removeEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				editPart.installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new ResizableShapeEditPolicy());
			}
		}
	}

	public boolean provides(IOperation operation) {
		if (operation instanceof CreateEditPoliciesOperation) {
			CreateEditPoliciesOperation createEditPoliciesOperation = (CreateEditPoliciesOperation) operation;
			EditPart editPart = createEditPoliciesOperation.getEditPart();
			boolean isForkNodeEditPart = editPart instanceof ForkNodeEditPart;
			boolean isJoinNodeEditPart = editPart instanceof JoinNodeEditPart;
			if(isForkNodeEditPart || isJoinNodeEditPart){
				
				Element element = UMLUtil.resolveUMLElement(createEditPoliciesOperation.getEditPart());
				EList<Stereotype> appliedStereotypes = element.getOwner().getAppliedStereotypes();
				for (Stereotype stereotype : appliedStereotypes) {
					if (stereotype.getProfile().getName().equals(BPMNProfilePackage.eNAME)){
						return true;
					}
				}
			}
		}
		return false;
		
	}

}
