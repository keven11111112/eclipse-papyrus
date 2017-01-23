/**
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.statemachine.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes;

/**
 * @generated
 */
public class UMLPaletteFactory extends PaletteFactory.Adapter {

	/**
	 * @generated
	 */
	private final static String STATEMACHINE_CREATENODESGROUP_REGION = "statemachine.createNodesGroup.region";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String STATEMACHINE_CREATENODESGROUP_STATE = "statemachine.createNodesGroup.state";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String STATEMACHINE_CREATENODESGROUP_INITIAL = "statemachine.createNodesGroup.initial";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String STATEMACHINE_CREATENODESGROUP_FINALSTATE = "statemachine.createNodesGroup.finalstate";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String STATEMACHINE_CREATENODESGROUP_SHALLOWHISTORY = "statemachine.createNodesGroup.shallowhistory";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String STATEMACHINE_CREATENODESGROUP_DEEPHISTORY = "statemachine.createNodesGroup.deephistory";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String STATEMACHINE_CREATENODESGROUP_FORK = "statemachine.createNodesGroup.fork";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String STATEMACHINE_CREATENODESGROUP_JOIN = "statemachine.createNodesGroup.join";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String STATEMACHINE_CREATENODESGROUP_CHOICE = "statemachine.createNodesGroup.choice";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String STATEMACHINE_CREATENODESGROUP_JUNCTION = "statemachine.createNodesGroup.junction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String STATEMACHINE_CREATENODESGROUP_ENTRYPOINT = "statemachine.createNodesGroup.entrypoint";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String STATEMACHINE_CREATENODESGROUP_EXITPOINT = "statemachine.createNodesGroup.exitpoint";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String STATEMACHINE_CREATENODESGROUP_TERMINATE = "statemachine.createNodesGroup.terminate";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String STATEMACHINE_CREATENODESGROUP_CONNECTIONPOINTREFERENCE = "statemachine.createNodesGroup.connectionpointreference";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String STATEMACHINE_CREATENODESGROUP_COMMENT = "statemachine.createNodesGroup.comment";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String STATEMACHINE_CREATENODESGROUP_CONSTRAINT = "statemachine.createNodesGroup.constraint";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String STATEMACHINE_CREATEEDGESGROUP_TRANSITION = "statemachine.createEdgesGroup.transition";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String STATEMACHINE_CREATEEDGESGROUP_LINK = "statemachine.createEdgesGroup.link";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String STATEMACHINE_CREATEEDGESGROUP_CONTEXTLINK = "statemachine.createEdgesGroup.contextlink";//$NON-NLS-1$

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
		if (toolId.equals(STATEMACHINE_CREATENODESGROUP_REGION)) {
			return createRegionCreationTool();
		}
		if (toolId.equals(STATEMACHINE_CREATENODESGROUP_STATE)) {
			return createStateCreationTool();
		}
		if (toolId.equals(STATEMACHINE_CREATENODESGROUP_INITIAL)) {
			return createInitialCreationTool();
		}
		if (toolId.equals(STATEMACHINE_CREATENODESGROUP_FINALSTATE)) {
			return createFinalStateCreationTool();
		}
		if (toolId.equals(STATEMACHINE_CREATENODESGROUP_SHALLOWHISTORY)) {
			return createShallowHistoryCreationTool();
		}
		if (toolId.equals(STATEMACHINE_CREATENODESGROUP_DEEPHISTORY)) {
			return createDeepHistoryCreationTool();
		}
		if (toolId.equals(STATEMACHINE_CREATENODESGROUP_FORK)) {
			return createForkCreationTool();
		}
		if (toolId.equals(STATEMACHINE_CREATENODESGROUP_JOIN)) {
			return createJoinCreationTool();
		}
		if (toolId.equals(STATEMACHINE_CREATENODESGROUP_CHOICE)) {
			return createChoiceCreationTool();
		}
		if (toolId.equals(STATEMACHINE_CREATENODESGROUP_JUNCTION)) {
			return createJunctionCreationTool();
		}
		if (toolId.equals(STATEMACHINE_CREATENODESGROUP_ENTRYPOINT)) {
			return createEntryPointCreationTool();
		}
		if (toolId.equals(STATEMACHINE_CREATENODESGROUP_EXITPOINT)) {
			return createExitPointCreationTool();
		}
		if (toolId.equals(STATEMACHINE_CREATENODESGROUP_TERMINATE)) {
			return createTerminateCreationTool();
		}
		if (toolId.equals(STATEMACHINE_CREATENODESGROUP_CONNECTIONPOINTREFERENCE)) {
			return createConnectionPointReferenceCreationTool();
		}
		if (toolId.equals(STATEMACHINE_CREATENODESGROUP_COMMENT)) {
			return createStateMachineCommentCreationTool();
		}
		if (toolId.equals(STATEMACHINE_CREATENODESGROUP_CONSTRAINT)) {
			return createConstraintCreationTool();
		}
		if (toolId.equals(STATEMACHINE_CREATEEDGESGROUP_TRANSITION)) {
			return createTransitionCreationTool();
		}
		if (toolId.equals(STATEMACHINE_CREATEEDGESGROUP_LINK)) {
			return createCommentlinkCreationTool();
		}
		if (toolId.equals(STATEMACHINE_CREATEEDGESGROUP_CONTEXTLINK)) {
			return createContextLink3CreationTool();
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
	private Tool createRegionCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Region_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createStateCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.State_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInitialCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Pseudostate_InitialShape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createFinalStateCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.FinalState_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createShallowHistoryCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Pseudostate_ShallowHistoryShape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDeepHistoryCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Pseudostate_DeepHistoryShape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createForkCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Pseudostate_ForkShape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createJoinCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Pseudostate_JoinShape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createChoiceCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Pseudostate_ChoiceShape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createJunctionCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Pseudostate_JunctionShape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createEntryPointCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Pseudostate_EntryPointShape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createExitPointCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Pseudostate_ExitPointShape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createTerminateCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Pseudostate_TerminateShape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConnectionPointReferenceCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ConnectionPointReference_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createStateMachineCommentCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Comment_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConstraintCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Constraint_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createTransitionCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Transition_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCommentlinkCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Comment_AnnotatedElementEdge);
		types.add(UMLElementTypes.Constraint_ConstrainedElementEdge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createContextLink3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Constraint_ContextEdge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}
}
