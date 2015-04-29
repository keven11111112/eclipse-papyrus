/*****************************************************************************
 * Copyright (c) 2009-2015 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.migration;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.InsertFloatingLabelFromMapCommand;
import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.DiagramReconciler;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.*;

/**
 * Composite Diagram Reconciler from 1.0.0 to 1.1.0
 */
public class CompositeReconcilier extends DiagramReconciler {

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
		map.put(String.valueOf(ActivityCompositeEditPart.VISUAL_ID), String.valueOf(ActivityCompositeFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(ActivityCompositeEditPartCN.VISUAL_ID), String.valueOf(ActivityCompositeFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(ActorEditPart.VISUAL_ID), String.valueOf(ActorFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(ActorEditPartCN.VISUAL_ID), String.valueOf(ActorFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(AnyReceiveEventEditPart.VISUAL_ID), String.valueOf(AnyReceiveEventFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(ArtifactEditPart.VISUAL_ID), String.valueOf(ArtifactFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(ArtifactEditPartCN.VISUAL_ID), String.valueOf(ArtifactFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(BehaviorPortEditPart.VISUAL_ID), String.valueOf(BehaviorPortFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(CallEventEditPart.VISUAL_ID), String.valueOf(CallEventFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(ChangeEventEditPart.VISUAL_ID), String.valueOf(ChangeEventFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(ClassCompositeEditPart.VISUAL_ID), String.valueOf(ClassCompositeFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(ClassCompositeEditPartCN.VISUAL_ID), String.valueOf(ClassCompositeFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(CollaborationCompositeEditPart.VISUAL_ID), String.valueOf(CollaborationCompositeFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(CollaborationCompositeEditPartCN.VISUAL_ID), String.valueOf(CollaborationCompositeFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(CollaborationRoleEditPartCN.VISUAL_ID), String.valueOf(CollaborationRoleFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(CollaborationUseEditPartCN.VISUAL_ID), String.valueOf(CollaborationUseFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(ComponentCompositeEditPart.VISUAL_ID), String.valueOf(ComponentCompositeFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(ComponentCompositeEditPartCN.VISUAL_ID), String.valueOf(ComponentCompositeFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(DataTypeEditPart.VISUAL_ID), String.valueOf(DataTypeFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(DataTypeEditPartCN.VISUAL_ID), String.valueOf(DataTypeFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(DeploymentSpecificationEditPart.VISUAL_ID), String.valueOf(DeploymentSpecificationFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(DeploymentSpecificationEditPartCN.VISUAL_ID), String.valueOf(DeploymentSpecificationFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(DeviceCompositeEditPart.VISUAL_ID), String.valueOf(DeviceCompositeFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(DeviceCompositeEditPartCN.VISUAL_ID), String.valueOf(DeviceCompositeFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(DurationEditPart.VISUAL_ID), String.valueOf(DurationFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(DurationIntervalEditPart.VISUAL_ID), String.valueOf(DurationIntervalFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(EnumerationEditPart.VISUAL_ID), String.valueOf(EnumerationFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(EnumerationEditPartCN.VISUAL_ID), String.valueOf(EnumerationFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(ExecutionEnvironmentCompositeEditPart.VISUAL_ID), String.valueOf(ExecutionEnvironmentCompositeFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID), String.valueOf(ExecutionEnvironmentCompositeFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(ExpressionEditPart.VISUAL_ID), String.valueOf(ExpressionFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(FunctionBehaviorCompositeEditPart.VISUAL_ID), String.valueOf(FunctionBehaviorCompositeFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(FunctionBehaviorCompositeEditPartCN.VISUAL_ID), String.valueOf(FunctionBehaviorCompositeFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(InformationItemEditPart.VISUAL_ID), String.valueOf(InformationItemFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(InformationItemEditPartCN.VISUAL_ID), String.valueOf(InformationItemFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(InstanceValueEditPart.VISUAL_ID), String.valueOf(InstanceValueFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(InteractionCompositeEditPart.VISUAL_ID), String.valueOf(InteractionCompositeFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(InteractionCompositeEditPartCN.VISUAL_ID), String.valueOf(InteractionCompositeFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(InterfaceEditPart.VISUAL_ID), String.valueOf(InterfaceFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(InterfaceEditPartCN.VISUAL_ID), String.valueOf(InterfaceFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(IntervalEditPart.VISUAL_ID), String.valueOf(IntervalFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(LiteralBooleanEditPart.VISUAL_ID), String.valueOf(LiteralBooleanFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(LiteralIntegerEditPart.VISUAL_ID), String.valueOf(LiteralIntegerFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(LiteralNullEditPart.VISUAL_ID), String.valueOf(LiteralNullFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(LiteralStringEditPart.VISUAL_ID), String.valueOf(LiteralStringFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(LiteralUnlimitedNaturalEditPart.VISUAL_ID), String.valueOf(LiteralUnlimitedNaturalFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(NodeCompositeEditPart.VISUAL_ID), String.valueOf(NodeCompositeFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(NodeCompositeEditPartCN.VISUAL_ID), String.valueOf(NodeCompositeFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(OpaqueBehaviorCompositeEditPart.VISUAL_ID), String.valueOf(OpaqueBehaviorCompositeFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID), String.valueOf(OpaqueBehaviorCompositeFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(OpaqueExpressionEditPart.VISUAL_ID), String.valueOf(OpaqueExpressionFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(PrimitiveTypeEditPart.VISUAL_ID), String.valueOf(PrimitiveTypeFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(PrimitiveTypeEditPartCN.VISUAL_ID), String.valueOf(PrimitiveTypeFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(PropertyPartEditPartCN.VISUAL_ID), String.valueOf(PropertyPartFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(ProtocolStateMachineCompositeEditPart.VISUAL_ID), String.valueOf(ProtocolStateMachineCompositeFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID), String.valueOf(ProtocolStateMachineCompositeFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(SignalEventEditPart.VISUAL_ID), String.valueOf(SignalEventFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(SignalEditPart.VISUAL_ID), String.valueOf(SignalFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(SignalEditPartCN.VISUAL_ID), String.valueOf(SignalFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(StateMachineCompositeEditPart.VISUAL_ID), String.valueOf(StateMachineCompositeFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(StateMachineCompositeEditPartCN.VISUAL_ID), String.valueOf(StateMachineCompositeFloatingLabelEditPartCN.VISUAL_ID));
		map.put(String.valueOf(StringExpressionEditPart.VISUAL_ID), String.valueOf(StringExpressionFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(TimeEventEditPart.VISUAL_ID), String.valueOf(TimeEventFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(TimeExpressionEditPart.VISUAL_ID), String.valueOf(TimeExpressionFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(TimeIntervalEditPart.VISUAL_ID), String.valueOf(TimeIntervalFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(UseCaseEditPart.VISUAL_ID), String.valueOf(UseCaseFloatingLabelEditPart.VISUAL_ID));
		map.put(String.valueOf(UseCaseEditPartCN.VISUAL_ID), String.valueOf(UseCaseFloatingLabelEditPartCN.VISUAL_ID));

		return map;
	}
}
