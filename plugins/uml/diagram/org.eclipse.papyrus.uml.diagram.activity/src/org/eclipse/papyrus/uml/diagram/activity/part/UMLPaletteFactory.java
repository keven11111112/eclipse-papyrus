/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;

/**
 * @generated
 */
public class UMLPaletteFactory extends PaletteFactory.Adapter {

	// RS: New Palette generation
	// Generates the ID for the tool elements
	// Generate the tool factory (if(ID) createtool...)
	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_ACCEPTEVENTACTION = "activity.nodes.accepteventaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_TESTIDENTITYACTION = "activity.nodes.testidentityaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_ACTIVITY = "activity.nodes.activity";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_ACTIVITYPARAMETERNODE = "activity.nodes.activityparameternode";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_CENTRALBUFFERNODE = "activity.nodes.centralbuffernode";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_DATASTORENODE = "activity.nodes.datastorenode";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_CONSTRAINT = "activity.nodes.constraint";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_COMMENT = "activity.nodes.comment";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_EDGES_CONTROLFLOW = "activity.edges.controlflow";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_EDGES_EXCEPTIONHANDLER = "activity.edges.exceptionhandler";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_EDGES_OBJECTFLOW = "activity.edges.objectflow";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_EDGES_LINK = "activity.edges.link";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_ACTIVITYGROUP_ACTIVITYPARTITION = "activity.nodes.activitygroup.activitypartition";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_ACTIVITYGROUP_INTERRUPTIBLEACTIVITYREGION = "activity.nodes.activitygroup.interruptibleactivityregion";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_CONTROLNODES_INITIALNODE = "activity.nodes.controlnodes.initialnode";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_CONTROLNODES_ACTIVITYFINAL = "activity.nodes.controlnodes.activityfinal";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_CONTROLNODES_FLOWFINAL = "activity.nodes.controlnodes.flowfinal";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_CONTROLNODES_DECISIONNODE = "activity.nodes.controlnodes.decisionnode";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_CONTROLNODES_MERGENODE = "activity.nodes.controlnodes.mergenode";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_CONTROLNODES_JOINNODE = "activity.nodes.controlnodes.joinnode";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_CONTROLNODES_FORKNODE = "activity.nodes.controlnodes.forknode";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_CONSTRAINTS_LOCALPRECONDITIONCONSTRAINT = "activity.nodes.constraints.localpreconditionconstraint";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_CONSTRAINTS_LOCALPRECONDITIONINTERVALCONSTRAINT = "activity.nodes.constraints.localpreconditionintervalconstraint";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_CONSTRAINTS_LOCALPRECONDITIONDURATIONCONSTRAINT = "activity.nodes.constraints.localpreconditiondurationconstraint";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_CONSTRAINTS_LOCALPRECONDITIONTIMECONSTRAINT = "activity.nodes.constraints.localpreconditiontimeconstraint";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_CONSTRAINTS_LOCALPOSTCONDITIONCONSTRAINT = "activity.nodes.constraints.localpostconditionconstraint";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_CONSTRAINTS_LOCALPOSTCONDITIONINTERVALCONSTRAINT = "activity.nodes.constraints.localpostconditionintervalconstraint";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_CONSTRAINTS_LOCALPOSTCONDITIONDURATIONCONSTRAINT = "activity.nodes.constraints.localpostconditiondurationconstraint";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_CONSTRAINTS_LOCALPOSTCONDITIONTIMECONSTRAINT = "activity.nodes.constraints.localpostconditiontimeconstraint";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_PINS_OUTPUTPIN = "activity.nodes.pins.outputpin";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_PINS_INPUTPIN = "activity.nodes.pins.inputpin";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_PINS_ACTIONINPUTPIN = "activity.nodes.pins.actioninputpin";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_PINS_VALUEPIN = "activity.nodes.pins.valuepin";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_EXPANSIONREGIONS_EXPANSIONREGION = "activity.nodes.expansionregions.expansionregion";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_EXPANSIONREGIONS_INPUTEXPANSIONNODE = "activity.nodes.expansionregions.inputexpansionnode";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_EXPANSIONREGIONS_OUTPUTEXPANSIONNODE = "activity.nodes.expansionregions.outputexpansionnode";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_INVOCATIONACTIONS_BROADCASTSIGNALACTION = "activity.nodes.invocationactions.broadcastsignalaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_INVOCATIONACTIONS_CALLBEHAVIORACTION = "activity.nodes.invocationactions.callbehavioraction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_INVOCATIONACTIONS_CALLOPERATIONACTION = "activity.nodes.invocationactions.calloperationaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_INVOCATIONACTIONS_SENDOBJECTACTION = "activity.nodes.invocationactions.sendobjectaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_INVOCATIONACTIONS_SENDSIGNALACTION = "activity.nodes.invocationactions.sendsignalaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_INVOCATIONACTIONS_STARTOBJECTBEHAVIOURACTION = "activity.nodes.invocationactions.startobjectbehaviouraction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_OBJECTACTIONS_CREATEOBJECTACTION = "activity.nodes.objectactions.createobjectaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_OBJECTACTIONS_DESTROYOBJECTACTION = "activity.nodes.objectactions.destroyobjectaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_OBJECTACTIONS_READSELFACTION = "activity.nodes.objectactions.readselfaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_OBJECTACTIONS_RECLASSIFYOBJECTACTION = "activity.nodes.objectactions.reclassifyobjectaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_OBJECTACTIONS_READISCLASSIFIEDOBJECTACTION = "activity.nodes.objectactions.readisclassifiedobjectaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_STRUCTUREDACTIONS_STRUCTUREDACTIVITYNODE = "activity.nodes.structuredactions.structuredactivitynode";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_STRUCTUREDACTIONS_LOOPNODE = "activity.nodes.structuredactions.loopnode";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_STRUCTUREDACTIONS_SEQUENCENODE = "activity.nodes.structuredactions.sequencenode";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_STRUCTUREDACTIONS_CONDITIONALNODE = "activity.nodes.structuredactions.conditionalnode";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_STRUCTURALFEATUREACTIONS_READSTRUCTURALFEATUREACTION = "activity.nodes.structuralfeatureactions.readstructuralfeatureaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_STRUCTURALFEATUREACTIONS_ADDSTRUCTURALFEATUREVALUEACTION = "activity.nodes.structuralfeatureactions.addstructuralfeaturevalueaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_STRUCTURALFEATUREACTIONS_CLEARSTRUCTURALFEATURE = "activity.nodes.structuralfeatureactions.clearstructuralfeature";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_VARIABLEACTIONS_ADDVARIABLEVALUEACTION = "activity.nodes.variableactions.addvariablevalueaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_VARIABLEACTIONS_READVARIABLEACTION = "activity.nodes.variableactions.readvariableaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_MISCELLANEOUSACTIONS_OPAQUEACTION = "activity.nodes.miscellaneousactions.opaqueaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_MISCELLANEOUSACTIONS_VALUESPECIFICATIONACTION = "activity.nodes.miscellaneousactions.valuespecificationaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_MISCELLANEOUSACTIONS_CLEARASSOCIATIONACTION = "activity.nodes.miscellaneousactions.clearassociationaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_MISCELLANEOUSACTIONS_READEXTENTACTION = "activity.nodes.miscellaneousactions.readextentaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_MISCELLANEOUSACTIONS_REDUCEACTION = "activity.nodes.miscellaneousactions.reduceaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_MISCELLANEOUSACTIONS_STARTCLASSIFIERBEHAVIOR = "activity.nodes.miscellaneousactions.startclassifierbehavior";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_LINKACTIONS_CREATELINKACTION = "activity.nodes.linkactions.createlinkaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_LINKACTIONS_READLINKACTION = "activity.nodes.linkactions.readlinkaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_LINKACTIONS_DESTROYLINKACTION = "activity.nodes.linkactions.destroylinkaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String ACTIVITY_NODES_LINKACTIONS_CREATELINKOBJECTACTION = "activity.nodes.linkactions.createlinkobjectaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	public UMLPaletteFactory() {

	}

	/**
	 * @generated
	 */
	@Override
	public Tool createTool(String toolId) {
		if (toolId.equals(ACTIVITY_NODES_ACCEPTEVENTACTION)) {
			return createAcceptEventAction14CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_TESTIDENTITYACTION)) {
			return createTestIdentityAction15CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_ACTIVITY)) {
			return createActivity16CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_ACTIVITYPARAMETERNODE)) {
			return createActivityParameterNode17CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_CENTRALBUFFERNODE)) {
			return createCentralBufferNode18CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_DATASTORENODE)) {
			return createDataStoreNode19CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_CONSTRAINT)) {
			return createConstraint20CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_COMMENT)) {
			return createComment21CreationTool();
		}
		if (toolId.equals(ACTIVITY_EDGES_CONTROLFLOW)) {
			return createControlFlow1CreationTool();
		}
		if (toolId.equals(ACTIVITY_EDGES_EXCEPTIONHANDLER)) {
			return createExceptionHandler2CreationTool();
		}
		if (toolId.equals(ACTIVITY_EDGES_OBJECTFLOW)) {
			return createObjectFlow3CreationTool();
		}
		if (toolId.equals(ACTIVITY_EDGES_LINK)) {
			return createLink4CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_ACTIVITYGROUP_ACTIVITYPARTITION)) {
			return createActivityPartition1CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_ACTIVITYGROUP_INTERRUPTIBLEACTIVITYREGION)) {
			return createInterruptibleActivityRegion2CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_CONTROLNODES_INITIALNODE)) {
			return createInitialnode1CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_CONTROLNODES_ACTIVITYFINAL)) {
			return createActivityfinal2CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_CONTROLNODES_FLOWFINAL)) {
			return createFlowfinal3CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_CONTROLNODES_DECISIONNODE)) {
			return createDecisionnode4CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_CONTROLNODES_MERGENODE)) {
			return createMergenode5CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_CONTROLNODES_JOINNODE)) {
			return createJoinnode6CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_CONTROLNODES_FORKNODE)) {
			return createForknode7CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_CONSTRAINTS_LOCALPRECONDITIONCONSTRAINT)) {
			return createLocalPreconditionConstraint1CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_CONSTRAINTS_LOCALPRECONDITIONINTERVALCONSTRAINT)) {
			return createLocalPreconditionIntervalConstraint3CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_CONSTRAINTS_LOCALPRECONDITIONDURATIONCONSTRAINT)) {
			return createLocalPreconditionDurationConstraint4CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_CONSTRAINTS_LOCALPRECONDITIONTIMECONSTRAINT)) {
			return createLocalPreconditionTimeConstraint5CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_CONSTRAINTS_LOCALPOSTCONDITIONCONSTRAINT)) {
			return createLocalPostconditionConstraint6CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_CONSTRAINTS_LOCALPOSTCONDITIONINTERVALCONSTRAINT)) {
			return createLocalPostconditionIntervalConstraint8CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_CONSTRAINTS_LOCALPOSTCONDITIONDURATIONCONSTRAINT)) {
			return createLocalPostconditionDurationConstraint9CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_CONSTRAINTS_LOCALPOSTCONDITIONTIMECONSTRAINT)) {
			return createLocalPostconditionTimeConstraint10CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_PINS_OUTPUTPIN)) {
			return createOutputPin1CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_PINS_INPUTPIN)) {
			return createInputPin2CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_PINS_ACTIONINPUTPIN)) {
			return createActionInputPin3CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_PINS_VALUEPIN)) {
			return createValuePin4CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_EXPANSIONREGIONS_EXPANSIONREGION)) {
			return createExpansionRegion1CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_EXPANSIONREGIONS_INPUTEXPANSIONNODE)) {
			return createInputExpansionNode2CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_EXPANSIONREGIONS_OUTPUTEXPANSIONNODE)) {
			return createOutputExpansionNode3CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_INVOCATIONACTIONS_BROADCASTSIGNALACTION)) {
			return createBroadcastSignalAction1CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_INVOCATIONACTIONS_CALLBEHAVIORACTION)) {
			return createCallBehaviorAction2CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_INVOCATIONACTIONS_CALLOPERATIONACTION)) {
			return createCallOperationAction3CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_INVOCATIONACTIONS_SENDOBJECTACTION)) {
			return createSendObjectAction4CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_INVOCATIONACTIONS_SENDSIGNALACTION)) {
			return createSendSignalAction5CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_INVOCATIONACTIONS_STARTOBJECTBEHAVIOURACTION)) {
			return createStartObjectBehaviourAction6CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_OBJECTACTIONS_CREATEOBJECTACTION)) {
			return createCreateObjectAction1CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_OBJECTACTIONS_DESTROYOBJECTACTION)) {
			return createDestroyObjectAction2CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_OBJECTACTIONS_READSELFACTION)) {
			return createReadSelfAction3CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_OBJECTACTIONS_RECLASSIFYOBJECTACTION)) {
			return createReclassifyObjectAction4CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_OBJECTACTIONS_READISCLASSIFIEDOBJECTACTION)) {
			return createReadIsClassifiedObjectAction5CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_STRUCTUREDACTIONS_STRUCTUREDACTIVITYNODE)) {
			return createStructuredActivityNode1CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_STRUCTUREDACTIONS_LOOPNODE)) {
			return createLoopNode2CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_STRUCTUREDACTIONS_SEQUENCENODE)) {
			return createSequenceNode3CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_STRUCTUREDACTIONS_CONDITIONALNODE)) {
			return createConditionalNode4CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_STRUCTURALFEATUREACTIONS_READSTRUCTURALFEATUREACTION)) {
			return createReadStructuralFeatureAction1CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_STRUCTURALFEATUREACTIONS_ADDSTRUCTURALFEATUREVALUEACTION)) {
			return createAddStructuralFeatureValueAction2CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_STRUCTURALFEATUREACTIONS_CLEARSTRUCTURALFEATURE)) {
			return createClearStructuralFeature3CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_VARIABLEACTIONS_ADDVARIABLEVALUEACTION)) {
			return createAddVariableValueAction1CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_VARIABLEACTIONS_READVARIABLEACTION)) {
			return createReadVariableAction2CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_MISCELLANEOUSACTIONS_OPAQUEACTION)) {
			return createOpaqueAction1CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_MISCELLANEOUSACTIONS_VALUESPECIFICATIONACTION)) {
			return createValueSpecificationAction2CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_MISCELLANEOUSACTIONS_CLEARASSOCIATIONACTION)) {
			return createClearAssociationAction3CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_MISCELLANEOUSACTIONS_READEXTENTACTION)) {
			return createReadExtentAction4CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_MISCELLANEOUSACTIONS_REDUCEACTION)) {
			return createReduceAction5CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_MISCELLANEOUSACTIONS_STARTCLASSIFIERBEHAVIOR)) {
			return createStartClassifierBehavior6CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_LINKACTIONS_CREATELINKACTION)) {
			return createCreateLinkAction1CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_LINKACTIONS_READLINKACTION)) {
			return createReadLinkAction2CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_LINKACTIONS_DESTROYLINKACTION)) {
			return createDestroyLinkAction3CreationTool();
		}
		if (toolId.equals(ACTIVITY_NODES_LINKACTIONS_CREATELINKOBJECTACTION)) {
			return createCreateLinkObjectAction4CreationTool();
		}
		// default return: null
		return null;
	}

	/**
	 * @generated
	 */
	@Override
	public Object getTemplate(String templateId) {

		// default return: null
		return null;
	}

	/**
	 * @generated
	 */
	private Tool createAcceptEventAction14CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.AcceptEventAction_3063);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createTestIdentityAction15CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.TestIdentityAction_3114);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createActivity16CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Activity_2001);
		types.add(UMLElementTypes.Activity_3083);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createActivityParameterNode17CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ActivityParameterNode_3059);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCentralBufferNode18CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.CentralBufferNode_3104);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDataStoreNode19CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.DataStoreNode_3078);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConstraint20CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Constraint_3112);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createComment21CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Comment_3080);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createControlFlow1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ControlFlow_4004);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createExceptionHandler2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ExceptionHandler_4005);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createObjectFlow3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ObjectFlow_4003);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLink4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.CommentAnnotatedElement_4006);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4007);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createActivityPartition1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ActivityPartition_3067);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInterruptibleActivityRegion2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.InterruptibleActivityRegion_3068);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInitialnode1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.InitialNode_3004);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createActivityfinal2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ActivityFinalNode_3005);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createFlowfinal3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.FlowFinalNode_3006);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDecisionnode4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.DecisionNode_3038);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createMergenode5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.MergeNode_3039);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createJoinnode6CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.JoinNode_3041);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createForknode7CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ForkNode_3040);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLocalPreconditionConstraint1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Constraint_3011);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLocalPreconditionIntervalConstraint3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.IntervalConstraint_3032);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLocalPreconditionDurationConstraint4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.DurationConstraint_3034);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLocalPreconditionTimeConstraint5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.TimeConstraint_3036);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLocalPostconditionConstraint6CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Constraint_3012);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLocalPostconditionIntervalConstraint8CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.IntervalConstraint_3033);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLocalPostconditionDurationConstraint9CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.DurationConstraint_3035);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLocalPostconditionTimeConstraint10CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.TimeConstraint_3037);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createOutputPin1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(19);
		types.add(UMLElementTypes.OutputPin_3014);
		types.add(UMLElementTypes.OutputPin_3020);
		types.add(UMLElementTypes.OutputPin_3024);
		types.add(UMLElementTypes.OutputPin_3064);
		types.add(UMLElementTypes.OutputPin_3077);
		types.add(UMLElementTypes.OutputPin_3084);
		types.add(UMLElementTypes.OutputPin_3125);
		types.add(UMLElementTypes.OutputPin_3126);
		types.add(UMLElementTypes.OutputPin_3127);
		types.add(UMLElementTypes.OutputPin_3128);
		types.add(UMLElementTypes.OutputPin_3129);
		types.add(UMLElementTypes.OutputPin_3130);
		types.add(UMLElementTypes.OutputPin_3131);
		types.add(UMLElementTypes.OutputPin_3094);
		types.add(UMLElementTypes.OutputPin_3109);
		types.add(UMLElementTypes.OutputPin_3110);
		types.add(UMLElementTypes.OutputPin_3111);
		types.add(UMLElementTypes.OutputPin_3191);
		types.add(UMLElementTypes.OutputPin_3202);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInputPin2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(27);
		types.add(UMLElementTypes.InputPin_3013);
		types.add(UMLElementTypes.InputPin_3019);
		types.add(UMLElementTypes.InputPin_3023);
		types.add(UMLElementTypes.InputPin_3055);
		types.add(UMLElementTypes.InputPin_3132);
		types.add(UMLElementTypes.InputPin_3133);
		types.add(UMLElementTypes.InputPin_3134);
		types.add(UMLElementTypes.InputPin_3135);
		types.add(UMLElementTypes.InputPin_3136);
		types.add(UMLElementTypes.InputPin_3137);
		types.add(UMLElementTypes.InputPin_3138);
		types.add(UMLElementTypes.InputPin_3139);
		types.add(UMLElementTypes.InputPin_3141);
		types.add(UMLElementTypes.InputPin_3142);
		types.add(UMLElementTypes.InputPin_3143);
		types.add(UMLElementTypes.InputPin_3144);
		types.add(UMLElementTypes.InputPin_3096);
		types.add(UMLElementTypes.InputPin_3100);
		types.add(UMLElementTypes.InputPin_3101);
		types.add(UMLElementTypes.InputPin_3103);
		types.add(UMLElementTypes.InputPin_3092);
		types.add(UMLElementTypes.InputPin_3093);
		types.add(UMLElementTypes.InputPin_3181);
		types.add(UMLElementTypes.InputPin_3105);
		types.add(UMLElementTypes.InputPin_3089);
		types.add(UMLElementTypes.InputPin_3188);
		types.add(UMLElementTypes.InputPin_3199);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createActionInputPin3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(28);
		types.add(UMLElementTypes.ActionInputPin_3016);
		types.add(UMLElementTypes.ActionInputPin_3018);
		types.add(UMLElementTypes.ActionInputPin_3021);
		types.add(UMLElementTypes.ActionInputPin_3053);
		types.add(UMLElementTypes.ActionInputPin_3158);
		types.add(UMLElementTypes.ActionInputPin_3159);
		types.add(UMLElementTypes.ActionInputPin_3160);
		types.add(UMLElementTypes.ActionInputPin_3161);
		types.add(UMLElementTypes.ActionInputPin_3162);
		types.add(UMLElementTypes.ActionInputPin_3163);
		types.add(UMLElementTypes.ActionInputPin_3164);
		types.add(UMLElementTypes.ActionInputPin_3165);
		types.add(UMLElementTypes.ActionInputPin_3166);
		types.add(UMLElementTypes.ActionInputPin_3167);
		types.add(UMLElementTypes.ActionInputPin_3168);
		types.add(UMLElementTypes.ActionInputPin_3169);
		types.add(UMLElementTypes.ActionInputPin_3170);
		types.add(UMLElementTypes.ActionInputPin_3174);
		types.add(UMLElementTypes.ActionInputPin_3177);
		types.add(UMLElementTypes.ActionInputPin_3178);
		types.add(UMLElementTypes.ActionInputPin_3180);
		types.add(UMLElementTypes.ActionInputPin_3185);
		types.add(UMLElementTypes.ActionInputPin_3186);
		types.add(UMLElementTypes.ActionInputPin_3187);
		types.add(UMLElementTypes.ActionInputPin_3193);
		types.add(UMLElementTypes.ActionInputPin_3190);
		types.add(UMLElementTypes.ActionInputPin_3201);
		types.add(UMLElementTypes.ActionInputPin_3204);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createValuePin4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(28);
		types.add(UMLElementTypes.ValuePin_3015);
		types.add(UMLElementTypes.ValuePin_3017);
		types.add(UMLElementTypes.ValuePin_3022);
		types.add(UMLElementTypes.ValuePin_3054);
		types.add(UMLElementTypes.ValuePin_3145);
		types.add(UMLElementTypes.ValuePin_3146);
		types.add(UMLElementTypes.ValuePin_3147);
		types.add(UMLElementTypes.ValuePin_3148);
		types.add(UMLElementTypes.ValuePin_3149);
		types.add(UMLElementTypes.ValuePin_3151);
		types.add(UMLElementTypes.ValuePin_3150);
		types.add(UMLElementTypes.ValuePin_3152);
		types.add(UMLElementTypes.ValuePin_3153);
		types.add(UMLElementTypes.ValuePin_3154);
		types.add(UMLElementTypes.ValuePin_3155);
		types.add(UMLElementTypes.ValuePin_3156);
		types.add(UMLElementTypes.ValuePin_3157);
		types.add(UMLElementTypes.ValuePin_3173);
		types.add(UMLElementTypes.ValuePin_3175);
		types.add(UMLElementTypes.ValuePin_3176);
		types.add(UMLElementTypes.ValuePin_3179);
		types.add(UMLElementTypes.ValuePin_3182);
		types.add(UMLElementTypes.ValuePin_3183);
		types.add(UMLElementTypes.ValuePin_3184);
		types.add(UMLElementTypes.ValuePin_3192);
		types.add(UMLElementTypes.ValuePin_3189);
		types.add(UMLElementTypes.ValuePin_3200);
		types.add(UMLElementTypes.ValuePin_3203);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createExpansionRegion1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ExpansionRegion_3070);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInputExpansionNode2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ExpansionNode_3074);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createOutputExpansionNode3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ExpansionNode_3075);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createBroadcastSignalAction1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.BroadcastSignalAction_3102);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCallBehaviorAction2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.CallBehaviorAction_3008);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCallOperationAction3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.CallOperationAction_3010);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createSendObjectAction4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.SendObjectAction_3042);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createSendSignalAction5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.SendSignalAction_3052);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createStartObjectBehaviourAction6CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.StartObjectBehaviorAction_3113);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCreateObjectAction1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.CreateObjectAction_3086);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDestroyObjectAction2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.DestroyObjectAction_3095);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createReadSelfAction3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ReadSelfAction_3081);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createReclassifyObjectAction4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ReclassifyObjectAction_3121);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createReadIsClassifiedObjectAction5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ReadIsClassifiedObjectAction_3122);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createStructuredActivityNode1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.StructuredActivityNode_3065);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLoopNode2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.LoopNode_3071);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createSequenceNode3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.SequenceNode_3073);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConditionalNode4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ConditionalNode_3069);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createReadStructuralFeatureAction1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ReadStructuralFeatureAction_3088);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAddStructuralFeatureValueAction2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.AddStructuralFeatureValueAction_3091);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createClearStructuralFeature3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ClearStructuralFeatureAction_3115);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAddVariableValueAction1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.AddVariableValueAction_3099);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createReadVariableAction2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ReadVariableAction_3097);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createOpaqueAction1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.OpaqueAction_3007);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createValueSpecificationAction2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ValueSpecificationAction_3076);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createClearAssociationAction3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ClearAssociationAction_3119);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createReadExtentAction4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ReadExtentAction_3120);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createReduceAction5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ReduceAction_3123);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createStartClassifierBehavior6CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.StartClassifierBehaviorAction_3124);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCreateLinkAction1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.CreateLinkAction_3117);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createReadLinkAction2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ReadLinkAction_3116);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDestroyLinkAction3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.DestroyLinkAction_3118);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCreateLinkObjectAction4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.CreateLinkObjectAction_3198);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}
}
