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

/**
 * Composite Diagram Reconciler from 1.0.0 to 1.1.0
 */
public class CompositeReconciler extends DiagramReconciler {

	private final static String ActivityCompositeEditPart_VISUAL_ID = "2060";
	private final static String ActivityCompositeFloatingLabelEditPart_VISUAL_ID = "6079";
	private final static String ActivityCompositeEditPartCN_VISUAL_ID = "3072";
	private final static String ActivityCompositeFloatingLabelEditPartCN_VISUAL_ID = "6057";
	private final static String ActorEditPart_VISUAL_ID = "2077";
	private final static String ActorFloatingLabelEditPart_VISUAL_ID = "6095";
	private final static String ActorEditPartCN_VISUAL_ID = "3091";
	private final static String ActorFloatingLabelEditPartCN_VISUAL_ID = "6073";
	private final static String AnyReceiveEventEditPart_VISUAL_ID = "2085";
	private final static String AnyReceiveEventFloatingLabelEditPart_VISUAL_ID = "6103";
	private final static String ArtifactEditPart_VISUAL_ID = "2079";
	private final static String ArtifactFloatingLabelEditPart_VISUAL_ID = "6097";
	private final static String ArtifactEditPartCN_VISUAL_ID = "3093";
	private final static String ArtifactFloatingLabelEditPartCN_VISUAL_ID = "6075";
	private final static String BehaviorPortEditPart_VISUAL_ID = "3121";
	private final static String BehaviorPortFloatingLabelEditPart_VISUAL_ID = "6053";
	private final static String CallEventEditPart_VISUAL_ID = "2084";
	private final static String CallEventFloatingLabelEditPart_VISUAL_ID = "6102";
	private final static String ChangeEventEditPart_VISUAL_ID = "2088";
	private final static String ChangeEventFloatingLabelEditPart_VISUAL_ID = "6104";
	private final static String ClassCompositeEditPart_VISUAL_ID = "2073";
	private final static String ClassCompositeFloatingLabelEditPart_VISUAL_ID = "6089";
	private final static String ClassCompositeEditPartCN_VISUAL_ID = "3085";
	private final static String ClassCompositeFloatingLabelEditPartCN_VISUAL_ID = "6067";
	private final static String CollaborationCompositeEditPart_VISUAL_ID = "2075";
	private final static String CollaborationCompositeFloatingLabelEditPart_VISUAL_ID = "6090";
	private final static String CollaborationCompositeEditPartCN_VISUAL_ID = "3086";
	private final static String CollaborationCompositeFloatingLabelEditPartCN_VISUAL_ID = "6068";
	private final static String CollaborationRoleEditPartCN_VISUAL_ID = "3115";
	private final static String CollaborationRoleFloatingLabelEditPartCN_VISUAL_ID = "6055";
	private final static String CollaborationUseEditPartCN_VISUAL_ID = "3071";
	private final static String CollaborationUseFloatingLabelEditPartCN_VISUAL_ID = "6056";
	private final static String ComponentCompositeEditPart_VISUAL_ID = "2069";
	private final static String ComponentCompositeFloatingLabelEditPart_VISUAL_ID = "6085";
	private final static String ComponentCompositeEditPartCN_VISUAL_ID = "3081";
	private final static String ComponentCompositeFloatingLabelEditPartCN_VISUAL_ID = "6063";
	private final static String DataTypeEditPart_VISUAL_ID = "2068";
	private final static String DataTypeFloatingLabelEditPart_VISUAL_ID = "6094";
	private final static String DataTypeEditPartCN_VISUAL_ID = "3080";
	private final static String DataTypeFloatingLabelEditPartCN_VISUAL_ID = "6072";
	private final static String DeploymentSpecificationEditPart_VISUAL_ID = "2078";
	private final static String DeploymentSpecificationFloatingLabelEditPart_VISUAL_ID = "6096";
	private final static String DeploymentSpecificationEditPartCN_VISUAL_ID = "3092";
	private final static String DeploymentSpecificationFloatingLabelEditPartCN_VISUAL_ID = "6074";
	private final static String DeviceCompositeEditPart_VISUAL_ID = "2070";
	private final static String DeviceCompositeFloatingLabelEditPart_VISUAL_ID = "6086";
	private final static String DeviceCompositeEditPartCN_VISUAL_ID = "3082";
	private final static String DeviceCompositeFloatingLabelEditPartCN_VISUAL_ID = "6064";
	private final static String DurationEditPart_VISUAL_ID = "2104";
	private final static String DurationFloatingLabelEditPart_VISUAL_ID = "6115";
	private final static String DurationIntervalEditPart_VISUAL_ID = "2106";
	private final static String DurationIntervalFloatingLabelEditPart_VISUAL_ID = "6117";
	private final static String EnumerationEditPart_VISUAL_ID = "2067";
	private final static String EnumerationFloatingLabelEditPart_VISUAL_ID = "6093";
	private final static String EnumerationEditPartCN_VISUAL_ID = "3079";
	private final static String EnumerationFloatingLabelEditPartCN_VISUAL_ID = "6071";
	private final static String ExecutionEnvironmentCompositeEditPart_VISUAL_ID = "2071";
	private final static String ExecutionEnvironmentCompositeFloatingLabelEditPart_VISUAL_ID = "6087";
	private final static String ExecutionEnvironmentCompositeEditPartCN_VISUAL_ID = "3083";
	private final static String ExecutionEnvironmentCompositeFloatingLabelEditPartCN_VISUAL_ID = "6065";
	private final static String ExpressionEditPart_VISUAL_ID = "2103";
	private final static String ExpressionFloatingLabelEditPart_VISUAL_ID = "6114";
	private final static String FunctionBehaviorCompositeEditPart_VISUAL_ID = "2064";
	private final static String FunctionBehaviorCompositeFloatingLabelEditPart_VISUAL_ID = "6083";
	private final static String FunctionBehaviorCompositeEditPartCN_VISUAL_ID = "3076";
	private final static String FunctionBehaviorCompositeFloatingLabelEditPartCN_VISUAL_ID = "6061";
	private final static String InformationItemEditPart_VISUAL_ID = "2080";
	private final static String InformationItemFloatingLabelEditPart_VISUAL_ID = "6098";
	private final static String InformationItemEditPartCN_VISUAL_ID = "3094";
	private final static String InformationItemFloatingLabelEditPartCN_VISUAL_ID = "6076";
	private final static String InstanceValueEditPart_VISUAL_ID = "2108";
	private final static String InstanceValueFloatingLabelEditPart_VISUAL_ID = "6119";
	private final static String InteractionCompositeEditPart_VISUAL_ID = "2061";
	private final static String InteractionCompositeFloatingLabelEditPart_VISUAL_ID = "6080";
	private final static String InteractionCompositeEditPartCN_VISUAL_ID = "3073";
	private final static String InteractionCompositeFloatingLabelEditPartCN_VISUAL_ID = "6058";
	private final static String InterfaceEditPart_VISUAL_ID = "2076";
	private final static String InterfaceFloatingLabelEditPart_VISUAL_ID = "6091";
	private final static String InterfaceEditPartCN_VISUAL_ID = "3087";
	private final static String InterfaceFloatingLabelEditPartCN_VISUAL_ID = "6069";
	private final static String IntervalEditPart_VISUAL_ID = "2107";
	private final static String IntervalFloatingLabelEditPart_VISUAL_ID = "6118";
	private final static String LiteralBooleanEditPart_VISUAL_ID = "2095";
	private final static String LiteralBooleanFloatingLabelEditPart_VISUAL_ID = "6106";
	private final static String LiteralIntegerEditPart_VISUAL_ID = "2096";
	private final static String LiteralIntegerFloatingLabelEditPart_VISUAL_ID = "6107";
	private final static String LiteralNullEditPart_VISUAL_ID = "2097";
	private final static String LiteralNullFloatingLabelEditPart_VISUAL_ID = "6108";
	private final static String LiteralStringEditPart_VISUAL_ID = "2098";
	private final static String LiteralStringFloatingLabelEditPart_VISUAL_ID = "6109";
	private final static String LiteralUnlimitedNaturalEditPart_VISUAL_ID = "2099";
	private final static String LiteralUnlimitedNaturalFloatingLabelEditPart_VISUAL_ID = "6110";
	private final static String NodeCompositeEditPart_VISUAL_ID = "2072";
	private final static String NodeCompositeFloatingLabelEditPart_VISUAL_ID = "6088";
	private final static String NodeCompositeEditPartCN_VISUAL_ID = "3084";
	private final static String NodeCompositeFloatingLabelEditPartCN_VISUAL_ID = "6066";
	private final static String OpaqueBehaviorCompositeEditPart_VISUAL_ID = "2065";
	private final static String OpaqueBehaviorCompositeFloatingLabelEditPart_VISUAL_ID = "6084";
	private final static String OpaqueBehaviorCompositeEditPartCN_VISUAL_ID = "3077";
	private final static String OpaqueBehaviorCompositeFloatingLabelEditPartCN_VISUAL_ID = "6062";
	private final static String OpaqueExpressionEditPart_VISUAL_ID = "2101";
	private final static String OpaqueExpressionFloatingLabelEditPart_VISUAL_ID = "6112";
	private final static String PrimitiveTypeEditPart_VISUAL_ID = "2066";
	private final static String PrimitiveTypeFloatingLabelEditPart_VISUAL_ID = "6092";
	private final static String PrimitiveTypeEditPartCN_VISUAL_ID = "3078";
	private final static String PrimitiveTypeFloatingLabelEditPartCN_VISUAL_ID = "6070";
	private final static String PropertyPartEditPartCN_VISUAL_ID = "3070";
	private final static String PropertyPartFloatingLabelEditPartCN_VISUAL_ID = "6054";
	private final static String ProtocolStateMachineCompositeEditPart_VISUAL_ID = "2062";
	private final static String ProtocolStateMachineCompositeFloatingLabelEditPart_VISUAL_ID = "6081";
	private final static String ProtocolStateMachineCompositeEditPartCN_VISUAL_ID = "3074";
	private final static String ProtocolStateMachineCompositeFloatingLabelEditPartCN_VISUAL_ID = "6059";
	private final static String SignalEventEditPart_VISUAL_ID = "2083";
	private final static String SignalEventFloatingLabelEditPart_VISUAL_ID = "6101";
	private final static String SignalEditPart_VISUAL_ID = "2081";
	private final static String SignalFloatingLabelEditPart_VISUAL_ID = "6099";
	private final static String SignalEditPartCN_VISUAL_ID = "3095";
	private final static String SignalFloatingLabelEditPartCN_VISUAL_ID = "6077";
	private final static String StateMachineCompositeEditPart_VISUAL_ID = "2063";
	private final static String StateMachineCompositeFloatingLabelEditPart_VISUAL_ID = "6082";
	private final static String StateMachineCompositeEditPartCN_VISUAL_ID = "3075";
	private final static String StateMachineCompositeFloatingLabelEditPartCN_VISUAL_ID = "6060";
	private final static String StringExpressionEditPart_VISUAL_ID = "2100";
	private final static String StringExpressionFloatingLabelEditPart_VISUAL_ID = "6111";
	private final static String TimeEventEditPart_VISUAL_ID = "2089";
	private final static String TimeEventFloatingLabelEditPart_VISUAL_ID = "6105";
	private final static String TimeExpressionEditPart_VISUAL_ID = "2102";
	private final static String TimeExpressionFloatingLabelEditPart_VISUAL_ID = "6113";
	private final static String TimeIntervalEditPart_VISUAL_ID = "2105";
	private final static String TimeIntervalFloatingLabelEditPart_VISUAL_ID = "6116";
	private final static String UseCaseEditPart_VISUAL_ID = "2082";
	private final static String UseCaseFloatingLabelEditPart_VISUAL_ID = "6100";
	private final static String UseCaseEditPartCN_VISUAL_ID = "3096";
	private final static String UseCaseFloatingLabelEditPartCN_VISUAL_ID = "6078";

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
		map.put(ActivityCompositeEditPart_VISUAL_ID, ActivityCompositeFloatingLabelEditPart_VISUAL_ID);
		map.put(ActivityCompositeEditPartCN_VISUAL_ID, ActivityCompositeFloatingLabelEditPartCN_VISUAL_ID);
		map.put(ActorEditPart_VISUAL_ID, ActorFloatingLabelEditPart_VISUAL_ID);
		map.put(ActorEditPartCN_VISUAL_ID, ActorFloatingLabelEditPartCN_VISUAL_ID);
		map.put(AnyReceiveEventEditPart_VISUAL_ID, AnyReceiveEventFloatingLabelEditPart_VISUAL_ID);
		map.put(ArtifactEditPart_VISUAL_ID, ArtifactFloatingLabelEditPart_VISUAL_ID);
		map.put(ArtifactEditPartCN_VISUAL_ID, ArtifactFloatingLabelEditPartCN_VISUAL_ID);
		map.put(BehaviorPortEditPart_VISUAL_ID, BehaviorPortFloatingLabelEditPart_VISUAL_ID);
		map.put(CallEventEditPart_VISUAL_ID, CallEventFloatingLabelEditPart_VISUAL_ID);
		map.put(ChangeEventEditPart_VISUAL_ID, ChangeEventFloatingLabelEditPart_VISUAL_ID);
		map.put(ClassCompositeEditPart_VISUAL_ID, ClassCompositeFloatingLabelEditPart_VISUAL_ID);
		map.put(ClassCompositeEditPartCN_VISUAL_ID, ClassCompositeFloatingLabelEditPartCN_VISUAL_ID);
		map.put(CollaborationCompositeEditPart_VISUAL_ID, CollaborationCompositeFloatingLabelEditPart_VISUAL_ID);
		map.put(CollaborationCompositeEditPartCN_VISUAL_ID, CollaborationCompositeFloatingLabelEditPartCN_VISUAL_ID);
		map.put(CollaborationRoleEditPartCN_VISUAL_ID, CollaborationRoleFloatingLabelEditPartCN_VISUAL_ID);
		map.put(CollaborationUseEditPartCN_VISUAL_ID, CollaborationUseFloatingLabelEditPartCN_VISUAL_ID);
		map.put(ComponentCompositeEditPart_VISUAL_ID, ComponentCompositeFloatingLabelEditPart_VISUAL_ID);
		map.put(ComponentCompositeEditPartCN_VISUAL_ID, ComponentCompositeFloatingLabelEditPartCN_VISUAL_ID);
		map.put(DataTypeEditPart_VISUAL_ID, DataTypeFloatingLabelEditPart_VISUAL_ID);
		map.put(DataTypeEditPartCN_VISUAL_ID, DataTypeFloatingLabelEditPartCN_VISUAL_ID);
		map.put(DeploymentSpecificationEditPart_VISUAL_ID, DeploymentSpecificationFloatingLabelEditPart_VISUAL_ID);
		map.put(DeploymentSpecificationEditPartCN_VISUAL_ID, DeploymentSpecificationFloatingLabelEditPartCN_VISUAL_ID);
		map.put(DeviceCompositeEditPart_VISUAL_ID, DeviceCompositeFloatingLabelEditPart_VISUAL_ID);
		map.put(DeviceCompositeEditPartCN_VISUAL_ID, DeviceCompositeFloatingLabelEditPartCN_VISUAL_ID);
		map.put(DurationEditPart_VISUAL_ID, DurationFloatingLabelEditPart_VISUAL_ID);
		map.put(DurationIntervalEditPart_VISUAL_ID, DurationIntervalFloatingLabelEditPart_VISUAL_ID);
		map.put(EnumerationEditPart_VISUAL_ID, EnumerationFloatingLabelEditPart_VISUAL_ID);
		map.put(EnumerationEditPartCN_VISUAL_ID, EnumerationFloatingLabelEditPartCN_VISUAL_ID);
		map.put(ExecutionEnvironmentCompositeEditPart_VISUAL_ID, ExecutionEnvironmentCompositeFloatingLabelEditPart_VISUAL_ID);
		map.put(ExecutionEnvironmentCompositeEditPartCN_VISUAL_ID, ExecutionEnvironmentCompositeFloatingLabelEditPartCN_VISUAL_ID);
		map.put(ExpressionEditPart_VISUAL_ID, ExpressionFloatingLabelEditPart_VISUAL_ID);
		map.put(FunctionBehaviorCompositeEditPart_VISUAL_ID, FunctionBehaviorCompositeFloatingLabelEditPart_VISUAL_ID);
		map.put(FunctionBehaviorCompositeEditPartCN_VISUAL_ID, FunctionBehaviorCompositeFloatingLabelEditPartCN_VISUAL_ID);
		map.put(InformationItemEditPart_VISUAL_ID, InformationItemFloatingLabelEditPart_VISUAL_ID);
		map.put(InformationItemEditPartCN_VISUAL_ID, InformationItemFloatingLabelEditPartCN_VISUAL_ID);
		map.put(InstanceValueEditPart_VISUAL_ID, InstanceValueFloatingLabelEditPart_VISUAL_ID);
		map.put(InteractionCompositeEditPart_VISUAL_ID, InteractionCompositeFloatingLabelEditPart_VISUAL_ID);
		map.put(InteractionCompositeEditPartCN_VISUAL_ID, InteractionCompositeFloatingLabelEditPartCN_VISUAL_ID);
		map.put(InterfaceEditPart_VISUAL_ID, InterfaceFloatingLabelEditPart_VISUAL_ID);
		map.put(InterfaceEditPartCN_VISUAL_ID, InterfaceFloatingLabelEditPartCN_VISUAL_ID);
		map.put(IntervalEditPart_VISUAL_ID, IntervalFloatingLabelEditPart_VISUAL_ID);
		map.put(LiteralBooleanEditPart_VISUAL_ID, LiteralBooleanFloatingLabelEditPart_VISUAL_ID);
		map.put(LiteralIntegerEditPart_VISUAL_ID, LiteralIntegerFloatingLabelEditPart_VISUAL_ID);
		map.put(LiteralNullEditPart_VISUAL_ID, LiteralNullFloatingLabelEditPart_VISUAL_ID);
		map.put(LiteralStringEditPart_VISUAL_ID, LiteralStringFloatingLabelEditPart_VISUAL_ID);
		map.put(LiteralUnlimitedNaturalEditPart_VISUAL_ID, LiteralUnlimitedNaturalFloatingLabelEditPart_VISUAL_ID);
		map.put(NodeCompositeEditPart_VISUAL_ID, NodeCompositeFloatingLabelEditPart_VISUAL_ID);
		map.put(NodeCompositeEditPartCN_VISUAL_ID, NodeCompositeFloatingLabelEditPartCN_VISUAL_ID);
		map.put(OpaqueBehaviorCompositeEditPart_VISUAL_ID, OpaqueBehaviorCompositeFloatingLabelEditPart_VISUAL_ID);
		map.put(OpaqueBehaviorCompositeEditPartCN_VISUAL_ID, OpaqueBehaviorCompositeFloatingLabelEditPartCN_VISUAL_ID);
		map.put(OpaqueExpressionEditPart_VISUAL_ID, OpaqueExpressionFloatingLabelEditPart_VISUAL_ID);
		map.put(PrimitiveTypeEditPart_VISUAL_ID, PrimitiveTypeFloatingLabelEditPart_VISUAL_ID);
		map.put(PrimitiveTypeEditPartCN_VISUAL_ID, PrimitiveTypeFloatingLabelEditPartCN_VISUAL_ID);
		map.put(PropertyPartEditPartCN_VISUAL_ID, PropertyPartFloatingLabelEditPartCN_VISUAL_ID);
		map.put(ProtocolStateMachineCompositeEditPart_VISUAL_ID, ProtocolStateMachineCompositeFloatingLabelEditPart_VISUAL_ID);
		map.put(ProtocolStateMachineCompositeEditPartCN_VISUAL_ID, ProtocolStateMachineCompositeFloatingLabelEditPartCN_VISUAL_ID);
		map.put(SignalEventEditPart_VISUAL_ID, SignalEventFloatingLabelEditPart_VISUAL_ID);
		map.put(SignalEditPart_VISUAL_ID, SignalFloatingLabelEditPart_VISUAL_ID);
		map.put(SignalEditPartCN_VISUAL_ID, SignalFloatingLabelEditPartCN_VISUAL_ID);
		map.put(StateMachineCompositeEditPart_VISUAL_ID, StateMachineCompositeFloatingLabelEditPart_VISUAL_ID);
		map.put(StateMachineCompositeEditPartCN_VISUAL_ID, StateMachineCompositeFloatingLabelEditPartCN_VISUAL_ID);
		map.put(StringExpressionEditPart_VISUAL_ID, StringExpressionFloatingLabelEditPart_VISUAL_ID);
		map.put(TimeEventEditPart_VISUAL_ID, TimeEventFloatingLabelEditPart_VISUAL_ID);
		map.put(TimeExpressionEditPart_VISUAL_ID, TimeExpressionFloatingLabelEditPart_VISUAL_ID);
		map.put(TimeIntervalEditPart_VISUAL_ID, TimeIntervalFloatingLabelEditPart_VISUAL_ID);
		map.put(UseCaseEditPart_VISUAL_ID, UseCaseFloatingLabelEditPart_VISUAL_ID);
		map.put(UseCaseEditPartCN_VISUAL_ID, UseCaseFloatingLabelEditPartCN_VISUAL_ID);

		return map;
	}
}
