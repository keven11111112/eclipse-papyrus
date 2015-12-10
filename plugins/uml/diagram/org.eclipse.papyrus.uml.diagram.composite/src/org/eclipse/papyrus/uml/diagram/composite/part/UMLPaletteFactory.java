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
package org.eclipse.papyrus.uml.diagram.composite.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes;

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
	private final static String COMPOSITE_TOOL_CLASS = "composite.tool.class";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_PROPERTY = "composite.tool.property";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_PORT = "composite.tool.port";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_COLLABORATION = "composite.tool.collaboration";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_COLLABORATIONROLE = "composite.tool.collaborationrole";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_COLLABORATIONUSE = "composite.tool.collaborationuse";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_COMMENT = "composite.tool.comment";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_CONSTRAINT = "composite.tool.constraint";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_TIMEOBSERVATION = "composite.tool.timeobservation";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_DURATIONOBSERVATION = "composite.tool.durationobservation";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_INFORMATIONITEM = "composite.tool.informationitem";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_PARAMETER = "composite.tool.parameter";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_ACTIVITY = "composite.tool.activity";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_INTERACTION = "composite.tool.interaction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_PROTOCOLSTATEMACHINE = "composite.tool.protocolstatemachine";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_STATEMACHINE = "composite.tool.statemachine";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_FUNCTIONBEHAVIOR = "composite.tool.functionbehavior";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_OPAQUEBEHAVIOR = "composite.tool.opaquebehavior";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_STRINGEXPRESSION = "composite.tool.stringExpression";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_LINK = "composite.tool.link";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_CONNECTOR = "composite.tool.connector";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_ROLEBINDING = "composite.tool.rolebinding";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_GENERALIZATION = "composite.tool.generalization";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_REALIZATION = "composite.tool.realization";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_SUBSTITUTION = "composite.tool.substitution";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_ABSTRACTION = "composite.tool.abstraction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_USAGE = "composite.tool.usage";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_DEPENDENCY = "composite.tool.dependency";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_REPRESENTATION = "composite.tool.representation";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_INFORMATIONFLOW = "composite.tool.informationflow";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_MANIFESTATION = "composite.tool.manifestation";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPOSITE_TOOL_DEPLOYMENT = "composite.tool.deployment";//$NON-NLS-1$

	/**
	 * @generated
	 */
	public UMLPaletteFactory() {

	}

	/**
	 * @generated
	 */
	public Tool createTool(String toolId) {
		if (toolId.equals(COMPOSITE_TOOL_CLASS)) {
			return createClassCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_PROPERTY)) {
			return createPropertyCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_PORT)) {
			return createPortCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_COLLABORATION)) {
			return createCollaborationCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_COLLABORATIONROLE)) {
			return createCollaborationRoleCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_COLLABORATIONUSE)) {
			return createCollaborationUseCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_COMMENT)) {
			return createCommentCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_CONSTRAINT)) {
			return createConstraintCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_TIMEOBSERVATION)) {
			return createTimeObservationCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_DURATIONOBSERVATION)) {
			return createDurationObservationCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_INFORMATIONITEM)) {
			return createInformationItemCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_PARAMETER)) {
			return createParameterCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_ACTIVITY)) {
			return createActivityCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_INTERACTION)) {
			return createInteractionCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_PROTOCOLSTATEMACHINE)) {
			return createProtocolStateMachineCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_STATEMACHINE)) {
			return createStateMachineCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_FUNCTIONBEHAVIOR)) {
			return createFunctionBehaviorCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_OPAQUEBEHAVIOR)) {
			return createOpaqueBehaviorCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_STRINGEXPRESSION)) {
			return createStringExpressionCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_LINK)) {
			return createLinkCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_CONNECTOR)) {
			return createConnectorCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_ROLEBINDING)) {
			return createRoleBindingCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_GENERALIZATION)) {
			return createGeneralizationCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_REALIZATION)) {
			return createRealizationCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_SUBSTITUTION)) {
			return createSubstitutionCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_ABSTRACTION)) {
			return createAbstractionCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_USAGE)) {
			return createUsageCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_DEPENDENCY)) {
			return createDependencyCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_REPRESENTATION)) {
			return createRepresentationCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_INFORMATIONFLOW)) {
			return createInformationFlowCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_MANIFESTATION)) {
			return createManifestationCreationTool();
		}
		if (toolId.equals(COMPOSITE_TOOL_DEPLOYMENT)) {
			return createDeploymentCreationTool();
		}
		// default return: null
		return null;
	}

	/**
	 * @generated
	 */
	public Object getTemplate(String templateId) {

		// default return: null
		return null;
	}

	/**
	 * @generated
	 */
	private Tool createClassCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Class_Shape);
		types.add(UMLElementTypes.Class_Shape_CN);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPropertyCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Property_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPortCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Port_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCollaborationCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Collaboration_Shape_CN);
		types.add(UMLElementTypes.Collaboration_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCollaborationRoleCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ConnectableElement_CollaborationRoleShape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCollaborationUseCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.CollaborationUse_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCommentCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Comment_Shape_CN);
		types.add(UMLElementTypes.Comment_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConstraintCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Constraint_Shape);
		types.add(UMLElementTypes.Constraint_Shape_CN);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createTimeObservationCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.TimeObservation_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDurationObservationCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.DurationObservation_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInformationItemCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.InformationItem_Shape_CN);
		types.add(UMLElementTypes.InformationItem_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createParameterCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Parameter_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createActivityCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Activity_Shape_CN);
		types.add(UMLElementTypes.Activity_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInteractionCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Interaction_Shape_CN);
		types.add(UMLElementTypes.Interaction_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createProtocolStateMachineCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.ProtocolStateMachine_Shape_CN);
		types.add(UMLElementTypes.ProtocolStateMachine_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createStateMachineCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.StateMachine_Shape_CN);
		types.add(UMLElementTypes.StateMachine_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createFunctionBehaviorCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.FunctionBehavior_Shape_CN);
		types.add(UMLElementTypes.FunctionBehavior_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createOpaqueBehaviorCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.OpaqueBehavior_Shape_CN);
		types.add(UMLElementTypes.OpaqueBehavior_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createStringExpressionCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.StringExpression_PackagedElementShape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLinkCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(UMLElementTypes.Comment_AnnotatedElementEdge);
		types.add(UMLElementTypes.Constraint_ConstrainedElementEdge);
		types.add(UMLElementTypes.TimeObservation_EventEdge);
		types.add(UMLElementTypes.DurationObservation_EventEdge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConnectorCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Connector_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createRoleBindingCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Dependency_RoleBindingEdge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createGeneralizationCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Generalization_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createRealizationCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Realization_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createSubstitutionCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Substitution_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAbstractionCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Abstraction_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createUsageCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Usage_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDependencyCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Dependency_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createRepresentationCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Representation_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInformationFlowCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.InformationFlow_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createManifestationCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Manifestation_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDeploymentCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Deployment_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}
}
