/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ContainerNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.providers.BaseViewInfo;
import org.eclipse.papyrus.uml.diagram.common.providers.ViewInfo;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomPackageItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomPackageEditPart extends PackageEditPart {

	/**
	 * Constructor.
	 *
	 * @param view
	 */
	public CustomPackageEditPart(View view) {
		super(view);
	}

	/**
	 * Remove the two policies dealing with the popup menu
	 *
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomPackageItemSemanticEditPolicy());
		removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		// fix https://bugs.eclipse.org/bugs/show_bug.cgi?id=364688
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// do not handle connection event
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ContainerNodeEditPolicy() {

			@Override
			protected Command getConnectionAndEndCommands(CreateConnectionRequest request) {
				return UnexecutableCommand.INSTANCE;
			}
		});
	}

	private EditPolicy createLayoutEditPolicy() {
		return new XYLayoutEditPolicy() {

			@Override
			protected Command createAddCommand(EditPart child, Object constraint) {
				if (child instanceof LifelineEditPart) {
					if (!SequenceUtil.isCreateMessageEndLifeline((LifelineEditPart) child)) {
						return null;
					}
				}
				return super.createAddCommand(child, constraint);
			}
		};
	}

	@Override
	public Object getAdapter(Class adapter) {
		if (adapter != null && adapter.equals(ViewInfo.class)) {
			return getDiagramViewInfo();
		}
		return super.getAdapter(adapter);
	}

	private static ViewInfo diagramViewInfo = null;

	public static ViewInfo getDiagramViewInfo() {
		if (diagramViewInfo == null) {
			diagramViewInfo = getPackage_SequenceDiagramViewInfo();
		}
		return diagramViewInfo;
	}

	protected static ViewInfo getPackage_SequenceDiagramViewInfo() {
		ViewInfo root = new BaseViewInfo("Package_SequenceDiagram", ViewInfo.Head, "", null, null);
		ViewInfo viewInfo = null;
		ViewInfo labelInfo = null;
		viewInfo = new BaseViewInfo("Interaction_Shape", ViewInfo.Node, "Interaction");
		root.addNode("Package_SequenceDiagram", viewInfo);
		viewInfo = new BaseViewInfo("Message_SynchEdge", ViewInfo.Edge, "");
		root.addNode("Package_SequenceDiagram", viewInfo);
		labelInfo = new BaseViewInfo("Message_SynchNameLabel", ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		labelInfo = new BaseViewInfo("Message_SynchStereotypeLabel", ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		viewInfo = new BaseViewInfo("Message_AsynchEdge", ViewInfo.Edge, "");
		root.addNode("Package_SequenceDiagram", viewInfo);
		labelInfo = new BaseViewInfo("Message_AsynchNameLabel", ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		labelInfo = new BaseViewInfo("Message_AsynchStereotypeLabel", ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		viewInfo = new BaseViewInfo("Message_ReplyEdge", ViewInfo.Edge, "");
		root.addNode("Package_SequenceDiagram", viewInfo);
		labelInfo = new BaseViewInfo("Message_ReplyNameLabel", ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		labelInfo = new BaseViewInfo("Message_ReplyStereotypeLabel", ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		viewInfo = new BaseViewInfo("Message_CreateEdge", ViewInfo.Edge, "");
		root.addNode("Package_SequenceDiagram", viewInfo);
		labelInfo = new BaseViewInfo("Message_CreateNameLabel", ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		labelInfo = new BaseViewInfo("Message_CreateStereotypeLabel", ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		viewInfo = new BaseViewInfo("Message_DeleteEdge", ViewInfo.Edge, "");
		root.addNode("Package_SequenceDiagram", viewInfo);
		labelInfo = new BaseViewInfo("Message_DeleteNameLabel", ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		labelInfo = new BaseViewInfo("Message_DeleteStereotypeLabel", ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		viewInfo = new BaseViewInfo("Message_LostEdge", ViewInfo.Edge, "");
		root.addNode("Package_SequenceDiagram", viewInfo);
		labelInfo = new BaseViewInfo("Message_LostNameLabel", ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		labelInfo = new BaseViewInfo("Message_LostStereotypeLabel", ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		viewInfo = new BaseViewInfo("Message_FoundEdge", ViewInfo.Edge, "");
		root.addNode("Package_SequenceDiagram", viewInfo);
		labelInfo = new BaseViewInfo("Message_FoundNameLabel", ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		labelInfo = new BaseViewInfo("Message_FoundStereotypeLabel", ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		viewInfo = new BaseViewInfo("Comment_AnnotatedElementEdge", ViewInfo.Edge, "");
		root.addNode("Package_SequenceDiagram", viewInfo);
		viewInfo = new BaseViewInfo("Constraint_ConstrainedElementEdge", ViewInfo.Edge, "");
		root.addNode("Package_SequenceDiagram", viewInfo);
		viewInfo = new BaseViewInfo("GeneralOrdering_Edge", ViewInfo.Edge, "");
		root.addNode("Package_SequenceDiagram", viewInfo);
		labelInfo = new BaseViewInfo("GeneralOrdering_StereotypeLabel", ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);
		viewInfo = new BaseViewInfo("ConsiderIgnoreFragment_Shape", ViewInfo.Node, "ConsiderIgnoreFragment");
		root.addNode("Interaction_SubfragmentCompartment", viewInfo);
		root.addNode("InteractionOperand_Shape", viewInfo);
		viewInfo = new BaseViewInfo("CombinedFragment_Shape", ViewInfo.Node, "CombinedFragment");
		root.addNode("InteractionOperand_Shape", viewInfo);
		root.addNode("Interaction_SubfragmentCompartment", viewInfo);
		viewInfo = new BaseViewInfo("InteractionOperand_Shape", ViewInfo.Node, "InteractionOperand");
		root.addNode("CombinedFragment_SubfragmentCompartment", viewInfo);
		viewInfo = new BaseViewInfo("InteractionUse_Shape", ViewInfo.Node, "InteractionUse");
		root.addNode("InteractionOperand_Shape", viewInfo);
		root.addNode("Interaction_SubfragmentCompartment", viewInfo);
		viewInfo = new BaseViewInfo("Continuation_Shape", ViewInfo.Node, "Continuation");
		root.addNode("InteractionOperand_Shape", viewInfo);
		viewInfo = new BaseViewInfo("Lifeline_Shape", ViewInfo.Node, "Lifeline");
		root.addNode("Interaction_SubfragmentCompartment", viewInfo);
		viewInfo = new BaseViewInfo("ActionExecutionSpecification_Shape", ViewInfo.Node, "ActionExecutionSpecification");
		root.addNode("Lifeline_Shape", viewInfo);
		viewInfo = new BaseViewInfo("BehaviorExecutionSpecification_Shape", ViewInfo.Node, "BehaviorExecutionSpecification");
		root.addNode("Lifeline_Shape", viewInfo);
		viewInfo = new BaseViewInfo("StateInvariant_Shape", ViewInfo.Node, "StateInvariant");
		root.addNode("Lifeline_Shape", viewInfo);
		viewInfo = new BaseViewInfo("CombinedFragment_CoRegionShape", ViewInfo.Node, "CombinedFragment");
		root.addNode("Lifeline_Shape", viewInfo);
		viewInfo = new BaseViewInfo("TimeConstraint_Shape", ViewInfo.Node, "TimeConstraint");
		root.addNode("Lifeline_Shape", viewInfo);
		viewInfo = new BaseViewInfo("TimeObservation_Shape", ViewInfo.Node, "TimeObservation");
		root.addNode("Lifeline_Shape", viewInfo);
		viewInfo = new BaseViewInfo("DurationConstraint_Shape", ViewInfo.Node, "DurationConstraint");
		root.addNode("Lifeline_Shape", viewInfo);
		viewInfo = new BaseViewInfo("DestructionOccurrenceSpecification_Shape", ViewInfo.Node, "DestructionOccurrenceSpecification");
		root.addNode("Lifeline_Shape", viewInfo);
		viewInfo = new BaseViewInfo("Constraint_Shape", ViewInfo.Node, "Constraint");
		root.addNode("Interaction_SubfragmentCompartment", viewInfo);
		viewInfo = new BaseViewInfo("Comment_Shape", ViewInfo.Node, "Comment");
		root.addNode("Interaction_SubfragmentCompartment", viewInfo);
		viewInfo = new BaseViewInfo("DurationConstraint_Shape_CN", ViewInfo.Node, "DurationConstraint");
		root.addNode("Interaction_Shape", viewInfo);
		viewInfo = new BaseViewInfo("DurationObservation_Shape", ViewInfo.Node, "DurationObservation");
		root.addNode("Interaction_Shape", viewInfo);
		return root;
	}
}
