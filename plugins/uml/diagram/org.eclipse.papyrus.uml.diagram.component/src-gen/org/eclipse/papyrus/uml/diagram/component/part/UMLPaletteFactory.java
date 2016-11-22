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
package org.eclipse.papyrus.uml.diagram.component.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes;

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
	private final static String COMPONENT_TOOL_CONSTRAINT = "component.tool.constraint";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPONENT_TOOL_COMMENT = "component.tool.comment";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPONENT_TOOL_COMPONENT = "component.tool.component";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPONENT_TOOL_INTERFACE = "component.tool.interface";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPONENT_TOOL_MODEL = "component.tool.model";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPONENT_TOOL_PROPERTY = "component.tool.property";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPONENT_TOOL_OPERATION = "component.tool.operation";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPONENT_TOOL_PACKAGE = "component.tool.package";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPONENT_TOOL_PORT = "component.tool.port";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPONENT_TOOL_RECEPTION = "component.tool.reception";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPONENT_TOOL_LINK = "component.tool.link";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPONENT_TOOL_CONNECTOR = "component.tool.connector";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPONENT_TOOL_DEPENDENCY = "component.tool.dependency";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPONENT_TOOL_DEPENDENCYBRANCH = "component.tool.dependencybranch";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPONENT_TOOL_ABSTRACTION = "component.tool.abstraction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPONENT_TOOL_MANIFESTATION = "component.tool.manifestation";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPONENT_TOOL_GENERALIZATION = "component.tool.generalization";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPONENT_TOOL_USAGE = "component.tool.usage";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPONENT_TOOL_SUBSTITUTION = "component.tool.substitution";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPONENT_TOOL_INTERFACEREALIZATION = "component.tool.interfaceRealization";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String COMPONENT_TOOL_COMPONENTREALIZATION = "component.tool.componentRealization";//$NON-NLS-1$

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
		if (toolId.equals(COMPONENT_TOOL_CONSTRAINT)) {
			return createConstraintCreationTool();
		}
		if (toolId.equals(COMPONENT_TOOL_COMMENT)) {
			return createCommentCreationTool();
		}
		if (toolId.equals(COMPONENT_TOOL_COMPONENT)) {
			return createComponentCreationTool();
		}
		if (toolId.equals(COMPONENT_TOOL_INTERFACE)) {
			return createRectancleInterfaceCreationTool();
		}
		if (toolId.equals(COMPONENT_TOOL_MODEL)) {
			return createModelCreationTool();
		}
		if (toolId.equals(COMPONENT_TOOL_PROPERTY)) {
			return createPropertyCreationTool();
		}
		if (toolId.equals(COMPONENT_TOOL_OPERATION)) {
			return createOperationCreationTool();
		}
		if (toolId.equals(COMPONENT_TOOL_PACKAGE)) {
			return createPackageCreationTool();
		}
		if (toolId.equals(COMPONENT_TOOL_PORT)) {
			return createPortCreationTool();
		}
		if (toolId.equals(COMPONENT_TOOL_RECEPTION)) {
			return createReceptionCreationTool();
		}
		if (toolId.equals(COMPONENT_TOOL_LINK)) {
			return createLinkCreationTool();
		}
		if (toolId.equals(COMPONENT_TOOL_CONNECTOR)) {
			return createConnectorCreationTool();
		}
		if (toolId.equals(COMPONENT_TOOL_DEPENDENCY)) {
			return createDependencyCreationTool();
		}
		if (toolId.equals(COMPONENT_TOOL_DEPENDENCYBRANCH)) {
			return createDependencyBranchCreationTool();
		}
		if (toolId.equals(COMPONENT_TOOL_ABSTRACTION)) {
			return createAbstractionCreationTool();
		}
		if (toolId.equals(COMPONENT_TOOL_MANIFESTATION)) {
			return createManifestationCreationTool();
		}
		if (toolId.equals(COMPONENT_TOOL_GENERALIZATION)) {
			return createGeneralizationCreationTool();
		}
		if (toolId.equals(COMPONENT_TOOL_USAGE)) {
			return createUsageCreationTool();
		}
		if (toolId.equals(COMPONENT_TOOL_SUBSTITUTION)) {
			return createSubstitutionCreationTool();
		}
		if (toolId.equals(COMPONENT_TOOL_INTERFACEREALIZATION)) {
			return createInterfaceRealizationCreationTool();
		}
		if (toolId.equals(COMPONENT_TOOL_COMPONENTREALIZATION)) {
			return createComponentRealizationCreationTool();
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
	private Tool createComponentCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(UMLElementTypes.Component_PackagedElementShape);
		types.add(UMLElementTypes.Component_PackagedElementShape_CCN);
		types.add(UMLElementTypes.Component_PackagedElementShape_CN);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createRectancleInterfaceCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Interface_ClassifierShape);
		types.add(UMLElementTypes.Interface_ClassifierShape_CN);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
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
	private Tool createPropertyCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Property_InterfaceAttributeLabel);
		types.add(UMLElementTypes.Property_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createOperationCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Operation_InterfaceOperationLabel);
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
	private Tool createPortCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Port_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createReceptionCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Reception_InterfaceReceptionLabel);
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
	private Tool createConnectorCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Connector_Edge);
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
	private Tool createAbstractionCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Abstraction_Edge);
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
	private Tool createGeneralizationCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Generalization_Edge);
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
	private Tool createSubstitutionCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Substitution_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInterfaceRealizationCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.InterfaceRealization_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createComponentRealizationCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ComponentRealization_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}
}
