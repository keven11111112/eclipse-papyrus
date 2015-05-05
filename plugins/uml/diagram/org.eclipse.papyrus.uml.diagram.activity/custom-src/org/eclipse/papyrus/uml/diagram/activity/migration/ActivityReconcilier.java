/*****************************************************************************
 * Copyright (c) 2010, 2015 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and Implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.migration;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.InsertFloatingLabelFromMapCommand;
import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.DiagramReconciler;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.AcceptEventActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.AcceptEventActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityFinalNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityFinalNodeFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityPartitionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityPartitionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.AddStructuralFeatureValueActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.AddStructuralFeatureValueActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.AddVariableValueActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.AddVariableValueActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.BroadcastSignalActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.BroadcastSignalActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CallBehaviorActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CallBehaviorActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CallOperationActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CallOperationActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CentralBufferNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CentralBufferNodeFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ClearAssociationActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ClearAssociationActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ClearStructuralFeatureActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ClearStructuralFeatureActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CreateLinkActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CreateLinkActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CreateLinkObjectActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CreateLinkObjectActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CreateObjectActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CreateObjectActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.DataStoreNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.DataStoreNodeFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.DecisionNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.DecisionNodeFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.DestroyLinkActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.DestroyLinkActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.DestroyObjectActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.DestroyObjectActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.FlowFinalNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.FlowFinalNodeFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ForkNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ForkNodeFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InitialNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InitialNodeFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.JoinNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.JoinNodeFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.MergeNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.MergeNodeFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.OpaqueActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.OpaqueActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ReadExtentActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ReadExtentActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ReadIsClassifiedObjectActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ReadIsClassifiedObjectActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ReadLinkActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ReadLinkActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ReadSelfActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ReadSelfActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ReadStructuralFeatureActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ReadStructuralFeatureActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ReadVariableActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ReadVariableActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ReclassifyObjectActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ReclassifyObjectActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ReduceActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ReduceActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.SendObjectActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.SendObjectActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.SendSignalActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.SendSignalActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.StartClassifierBehaviorActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.StartClassifierBehaviorActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.StartObjectBehaviorActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.StartObjectBehavoiurActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.TestIdentityActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.TestIdentityActionFloatingNameEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ValueSpecificationActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ValueSpecificationActionFloatingNameEditPart;

/**
 * Activity Diagram Reconciler from 1.0.0 to 1.1.0
 */
public class ActivityReconcilier extends DiagramReconciler {

	/**
	 * Gets the reconcile command.
	 *
	 * @param diagram
	 *            the diagram
	 * @return the reconcile command
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.reconciler.DiagramReconciler#getReconcileCommand(org.eclipse.gmf.runtime.notation.Diagram)
	 */
	@Override
	public ICommand getReconcileCommand(Diagram diagram) {
		return new InsertFloatingLabelFromMapCommand(diagram, getFloatingLabelMap());
	}

	/**
	 * Gets the floating label map to add.
	 *
	 * @return the floating label map
	 */
	private Map<String, String> getFloatingLabelMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put(String.valueOf(AcceptEventActionEditPart.VISUAL_ID), String.valueOf(AcceptEventActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(ActivityFinalNodeEditPart.VISUAL_ID), String.valueOf(ActivityFinalNodeFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(ActivityPartitionEditPart.VISUAL_ID), String.valueOf(ActivityPartitionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(AddStructuralFeatureValueActionEditPart.VISUAL_ID), String.valueOf(AddStructuralFeatureValueActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(AddVariableValueActionEditPart.VISUAL_ID), String.valueOf(AddVariableValueActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(BroadcastSignalActionEditPart.VISUAL_ID), String.valueOf(BroadcastSignalActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(CallBehaviorActionEditPart.VISUAL_ID), String.valueOf(CallBehaviorActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(CallOperationActionEditPart.VISUAL_ID), String.valueOf(CallOperationActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(CentralBufferNodeEditPart.VISUAL_ID), String.valueOf(CentralBufferNodeFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(ClearAssociationActionEditPart.VISUAL_ID), String.valueOf(ClearAssociationActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(ClearStructuralFeatureActionEditPart.VISUAL_ID), String.valueOf(ClearStructuralFeatureActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(CreateLinkActionEditPart.VISUAL_ID), String.valueOf(CreateLinkActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(CreateLinkObjectActionEditPart.VISUAL_ID), String.valueOf(CreateLinkObjectActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(CreateObjectActionEditPart.VISUAL_ID), String.valueOf(CreateObjectActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(DataStoreNodeEditPart.VISUAL_ID), String.valueOf(DataStoreNodeFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(DecisionNodeEditPart.VISUAL_ID), String.valueOf(DecisionNodeFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(DestroyLinkActionEditPart.VISUAL_ID), String.valueOf(DestroyLinkActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(DestroyObjectActionEditPart.VISUAL_ID), String.valueOf(DestroyObjectActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(FlowFinalNodeEditPart.VISUAL_ID), String.valueOf(FlowFinalNodeFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(ForkNodeEditPart.VISUAL_ID), String.valueOf(ForkNodeFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(InitialNodeEditPart.VISUAL_ID), String.valueOf(InitialNodeFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(JoinNodeEditPart.VISUAL_ID), String.valueOf(JoinNodeFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(MergeNodeEditPart.VISUAL_ID), String.valueOf(MergeNodeFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(OpaqueActionEditPart.VISUAL_ID), String.valueOf(OpaqueActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(ReadExtentActionEditPart.VISUAL_ID), String.valueOf(ReadExtentActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(ReadIsClassifiedObjectActionEditPart.VISUAL_ID), String.valueOf(ReadIsClassifiedObjectActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(ReadLinkActionEditPart.VISUAL_ID), String.valueOf(ReadLinkActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(ReadSelfActionEditPart.VISUAL_ID), String.valueOf(ReadSelfActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(ReadStructuralFeatureActionEditPart.VISUAL_ID), String.valueOf(ReadStructuralFeatureActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(ReadVariableActionEditPart.VISUAL_ID), String.valueOf(ReadVariableActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(ReclassifyObjectActionEditPart.VISUAL_ID), String.valueOf(ReclassifyObjectActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(ReduceActionEditPart.VISUAL_ID), String.valueOf(ReduceActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(SendObjectActionEditPart.VISUAL_ID), String.valueOf(SendObjectActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(SendSignalActionEditPart.VISUAL_ID), String.valueOf(SendSignalActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(StartClassifierBehaviorActionEditPart.VISUAL_ID), String.valueOf(StartClassifierBehaviorActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(StartObjectBehavoiurActionEditPart.VISUAL_ID), String.valueOf(StartObjectBehaviorActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(TestIdentityActionEditPart.VISUAL_ID), String.valueOf(TestIdentityActionFloatingNameEditPart.VISUAL_ID));
		map.put(String.valueOf(ValueSpecificationActionEditPart.VISUAL_ID), String.valueOf(ValueSpecificationActionFloatingNameEditPart.VISUAL_ID));

		return map;
	}
}
