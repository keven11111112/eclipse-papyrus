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
package org.eclipse.papyrus.uml.diagram.deployment.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes;

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
	private final static String CREATEMODELCREATIONTOOL = "createModelCreationTool";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_PACKAGE = "deployment.tool.package";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_NODE = "deployment.tool.node";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_DEVICE = "deployment.tool.device";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_DEPLOYMENTSPECIFICATION = "deployment.tool.deploymentspecification";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_EXECUTIONENVIRONMENT = "deployment.tool.executionEnvironment";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_ARTIFACT = "deployment.tool.artifact";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_COMMENT = "deployment.tool.comment";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_CONSTRAINT = "deployment.tool.constraint";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_LINK = "deployment.tool.link";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_DEPENDENCY = "deployment.tool.dependency";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_DEPENDENCYBRANCH = "deployment.tool.dependencybranch";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_GENERALIZATION = "deployment.tool.generalization";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_DEPLOYMENT = "deployment.tool.deployment";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_MANIFESTATION = "deployment.tool.manifestation";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String DEPLOYMENT_TOOL_COMMUNICATIONPATH = "deployment.tool.communicationpath";//$NON-NLS-1$

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
		if (toolId.equals(DEPLOYMENT_TOOL_ARTIFACT)) {
			return createArtifactCreationTool();
		}
		if (toolId.equals(DEPLOYMENT_TOOL_COMMENT)) {
			return createCommentCreationTool();
		}
		if (toolId.equals(DEPLOYMENT_TOOL_CONSTRAINT)) {
			return createConstraintCreationTool();
		}
		if (toolId.equals(DEPLOYMENT_TOOL_DEVICE)) {
			return createDeviceCreationTool();
		}
		if (toolId.equals(DEPLOYMENT_TOOL_DEPLOYMENTSPECIFICATION)) {
			return createDeploymentSpecification5CreationTool();
		}
		if (toolId.equals(DEPLOYMENT_TOOL_EXECUTIONENVIRONMENT)) {
			return createExecutionEnvironmentCreationTool();
		}
		if (toolId.equals(CREATEMODELCREATIONTOOL)) {
			return createModelCreationTool();
		}
		if (toolId.equals(DEPLOYMENT_TOOL_NODE)) {
			return createNodeCreationTool();
		}
		if (toolId.equals(DEPLOYMENT_TOOL_PACKAGE)) {
			return createPackageCreationTool();
		}
		if (toolId.equals(DEPLOYMENT_TOOL_COMMUNICATIONPATH)) {
			return createCommunicationPath1CreationTool();
		}
		if (toolId.equals(DEPLOYMENT_TOOL_DEPENDENCY)) {
			return createDependencyCreationTool();
		}
		if (toolId.equals(DEPLOYMENT_TOOL_DEPENDENCYBRANCH)) {
			return createDependencyBranchCreationTool();
		}
		if (toolId.equals(DEPLOYMENT_TOOL_DEPLOYMENT)) {
			return createDeploymentCreationTool();
		}
		if (toolId.equals(DEPLOYMENT_TOOL_GENERALIZATION)) {
			return createGeneralizationCreationTool();
		}
		if (toolId.equals(DEPLOYMENT_TOOL_LINK)) {
			return createLinkCreationTool();
		}
		if (toolId.equals(DEPLOYMENT_TOOL_MANIFESTATION)) {
			return createManifestationCreationTool();
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
	private Tool createModelCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Model_Shape_CN);
		types.add(UMLElementTypes.Model_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPackageCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Package_Shape);
		types.add(UMLElementTypes.Package_Shape_CN);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCommunicationPath1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.CommunicationPath_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createNodeCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(UMLElementTypes.Node_Shape);
		types.add(UMLElementTypes.Node_Shape_CCN);
		types.add(UMLElementTypes.Node_Shape_CN);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDeviceCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(UMLElementTypes.Device_Shape);
		types.add(UMLElementTypes.Device_Shape_CCN);
		types.add(UMLElementTypes.Device_Shape_CN);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDeploymentSpecification5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(UMLElementTypes.DeploymentSpecification_Shape);
		types.add(UMLElementTypes.DeploymentSpecification_Shape_CCN);
		types.add(UMLElementTypes.DeploymentSpecification_Shape_CN);
		types.add(UMLElementTypes.DeploymentSpecification_Shape_ACN);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createExecutionEnvironmentCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(UMLElementTypes.ExecutionEnvironment_Shape);
		types.add(UMLElementTypes.ExecutionEnvironment_Shape_CCN);
		types.add(UMLElementTypes.ExecutionEnvironment_Shape_CN);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createArtifactCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(UMLElementTypes.Artifact_Shape);
		types.add(UMLElementTypes.Artifact_Shape_CCN);
		types.add(UMLElementTypes.Artifact_Shape_ACN);
		types.add(UMLElementTypes.Artifact_Shape_CN);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createCommentCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Comment_Shape);
		types.add(UMLElementTypes.Comment_Shape_CN);
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
	private Tool createLinkCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Comment_AnnotatedElementEdge);
		types.add(UMLElementTypes.Constraint_ConstrainedElementEdge);
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
	private Tool createDependencyBranchCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Dependency_BranchEdge);
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
	private Tool createDeploymentCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Deployment_Edge);
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
}
