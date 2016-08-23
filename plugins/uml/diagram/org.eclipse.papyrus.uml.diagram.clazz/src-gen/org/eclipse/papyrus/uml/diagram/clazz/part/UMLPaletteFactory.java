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
package org.eclipse.papyrus.uml.diagram.clazz.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
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
	private final static String CLAZZ_TOOL_CLASS = "clazz.tool.class";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_CLASSIFIERTEMPLATEPARAMETER = "clazz.tool.classifiertemplateparameter";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_COMMENT = "clazz.tool.comment";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_COMPONENT = "clazz.tool.component";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_CONSTRAINT = "clazz.tool.constraint";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_DATATYPE = "clazz.tool.datatype";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATEDURATIONOBSERVATION7CREATIONTOOL = "createDurationObservation7CreationTool";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_ENUMERATION = "clazz.tool.enumeration";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_ENUMERATIONLITERAL = "clazz.tool.enumerationliteral";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_INTERFACE = "clazz.tool.interface";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_INSTANCESPECIFICATION = "clazz.tool.instancespecification";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_INFORMATIONITEM = "clazz.tool.informationitem";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_PRIMITIVETYPE = "clazz.tool.primitivetype";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_MODEL = "clazz.tool.model";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_OPERATION = "clazz.tool.operation";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_OPERATIONTEMPLATEPARAMETER = "clazz.tool.OperationTemplateParameter";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_PACKAGE = "clazz.tool.package";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_PROPERTY = "clazz.tool.property";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_RECEPTION = "clazz.tool.reception";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_REDEFINABLETEMPLATESIGNATURE = "clazz.tool.redefinabletemplatesignature";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_SIGNAL = "clazz.tool.signal";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_SLOT = "clazz.tool.slot";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_TEMPLATEPARAMETER = "clazz.tool.templateparameter";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_TEMPLATESIGNATURE = "clazz.tool.templatesignature";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CREATETIMEOBSERVATION22CREATIONTOOL = "createTimeObservation22CreationTool";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_CONNECTABLEELEMENTTEMPLATEPARAMETER = "clazz.tool.connectableelementtemplateparameter";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_ABSTRACTION = "clazz.tool.abstraction";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_ASSOCIATION = "clazz.tool.association";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_ASSOCIATIONBRANCH = "clazz.tool.associationbranch";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_ASSOCIATIONCLASS = "clazz.tool.associationclass";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_CONTAINMENTLINK = "clazz.tool.containmentlink";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_CONTEXTLINK = "clazz.tool.contextlink";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_DEPENDENCY = "clazz.tool.dependency";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_DEPENDENCYBRANCH = "clazz.tool.dependencybranch";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_ELEMENTIMPORT = "clazz.tool.elementimport";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_GENERALIZATION = "clazz.tool.generalization";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_GENERALIZATIONSET = "clazz.tool.generalizationset";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_INFORMATIONFLOWLINK = "clazz.tool.informationflowlink";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_INSTANCESPECIFICATIONLINK = "clazz.tool.instancespecificationlink";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_INTERFACEREALIZATION = "clazz.tool.interfacerealization";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_LINK = "clazz.tool.link";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_PACKAGEIMPORT = "clazz.tool.packageimport";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_PACKAGEMERGE = "clazz.tool.packagemerge";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_PROFILEAPPLICATION = "clazz.tool.profileapplication";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_REALIZATION = "clazz.tool.realization";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_SUBSTITUTION = "clazz.tool.substitution";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_TEMPLATEBINDING = "clazz.tool.templatebinding";//$NON-NLS-1$

	/**
	 * @generated
	 */
	private final static String CLAZZ_TOOL_USAGE = "clazz.tool.usage";//$NON-NLS-1$

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
		if (toolId.equals(CLAZZ_TOOL_CLASS)) {
			return createClass1CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_CLASSIFIERTEMPLATEPARAMETER)) {
			return createClassifierTemplateParameter2CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_COMMENT)) {
			return createComment5CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_COMPONENT)) {
			return createComponent4CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_CONSTRAINT)) {
			return createConstraint5CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_DATATYPE)) {
			return createDataType6CreationTool();
		}
		if (toolId.equals(CREATEDURATIONOBSERVATION7CREATIONTOOL)) {
			return createDurationObservation7CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_ENUMERATION)) {
			return createEnumeration8CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_ENUMERATIONLITERAL)) {
			return createEnumerationLiteral9CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_INTERFACE)) {
			return createInterface10CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_INSTANCESPECIFICATION)) {
			return createInstanceSpecification11CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_INFORMATIONITEM)) {
			return createInformationItem12CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_PRIMITIVETYPE)) {
			return createPrimitiveType13CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_MODEL)) {
			return createModel14CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_OPERATION)) {
			return createOperation15CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_OPERATIONTEMPLATEPARAMETER)) {
			return createOperationTemplateParameterCreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_PACKAGE)) {
			return createPackage17CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_PROPERTY)) {
			return createProperty18CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_RECEPTION)) {
			return createReception19CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_REDEFINABLETEMPLATESIGNATURE)) {
			return createRedefinableTemplateSignature20CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_SIGNAL)) {
			return createSignal21CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_SLOT)) {
			return createSlot22CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_TEMPLATEPARAMETER)) {
			return createTemplateParameter23CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_TEMPLATESIGNATURE)) {
			return createTemplateSignatureCreationTool();
		}
		if (toolId.equals(CREATETIMEOBSERVATION22CREATIONTOOL)) {
			return createTimeObservation22CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_CONNECTABLEELEMENTTEMPLATEPARAMETER)) {
			return createConnectableElementTemplateParameter26CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_ABSTRACTION)) {
			return createAbstraction1CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_ASSOCIATION)) {
			return createAssociation2CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_ASSOCIATIONBRANCH)) {
			return createAssociationBranch3CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_ASSOCIATIONCLASS)) {
			return createAssociationClass4CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_CONTAINMENTLINK)) {
			return createContainmentLink5CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_CONTEXTLINK)) {
			return createContextLink6CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_DEPENDENCY)) {
			return createDependency7CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_DEPENDENCYBRANCH)) {
			return createDependencyBranch8CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_ELEMENTIMPORT)) {
			return createElementImport9CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_GENERALIZATION)) {
			return createGeneralization10CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_GENERALIZATIONSET)) {
			return createGeneralizationSet11CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_INFORMATIONFLOWLINK)) {
			return createInformationFlowLinkCreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_INSTANCESPECIFICATIONLINK)) {
			return createInstanceSpecificationLinkCreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_INTERFACEREALIZATION)) {
			return createInterfaceRealization14CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_LINK)) {
			return createLink15CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_PACKAGEIMPORT)) {
			return createPackageImport16CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_PACKAGEMERGE)) {
			return createPackageMerge17CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_PROFILEAPPLICATION)) {
			return createProfileApplication18CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_REALIZATION)) {
			return createRealization19CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_SUBSTITUTION)) {
			return createSubstitution20CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_TEMPLATEBINDING)) {
			return createTemplateBinding21CreationTool();
		}
		if (toolId.equals(CLAZZ_TOOL_USAGE)) {
			return createUsage22CreationTool();
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
	private Tool createClass1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(UMLElementTypes.Class_ComponentNestedClassifierLabel);
		types.add(UMLElementTypes.Class_InterfaceNestedClassifierLabel);
		types.add(UMLElementTypes.Class_Shape_CN);
		types.add(UMLElementTypes.Class_ClassNestedClassifierLabel);
		types.add(UMLElementTypes.Class_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createClassifierTemplateParameter2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ClassifierTemplateParameter_TemplateParameterLabel);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createComment5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Comment_Shape_CN);
		types.add(UMLElementTypes.Comment_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createComponent4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Component_Shape);
		types.add(UMLElementTypes.Component_Shape_CN);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConstraint5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Constraint_PackagedElementShape_CN);
		types.add(UMLElementTypes.Constraint_PackagedElementShape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDataType6CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(UMLElementTypes.DataType_Shape_CN);
		types.add(UMLElementTypes.DataType_Shape);
		types.add(UMLElementTypes.DataType_ClassNestedClassifierLabel);
		types.add(UMLElementTypes.DataType_ComponentNestedClassifierLabel);
		types.add(UMLElementTypes.DataType_InterfaceNestedClassifierLabel);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDurationObservation7CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.DurationObservation_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createEnumeration8CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(UMLElementTypes.Enumeration_Shape_CN);
		types.add(UMLElementTypes.Enumeration_Shape);
		types.add(UMLElementTypes.Enumeration_ClassNestedClassifierLabel);
		types.add(UMLElementTypes.Enumeration_ComponentNestedClassifierLabel);
		types.add(UMLElementTypes.Enumeration_InterfaceNestedClassifierLabel);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createEnumerationLiteral9CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.EnumerationLiteral_LiteralLabel);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInterface10CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(UMLElementTypes.Interface_Shape);
		types.add(UMLElementTypes.Interface_Shape_CN);
		types.add(UMLElementTypes.Interface_ClassNestedClassifierLabel);
		types.add(UMLElementTypes.Interface_ComponentNestedClassifierLabel);
		types.add(UMLElementTypes.Interface_InterfaceNestedClassifierLabel);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInstanceSpecification11CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.InstanceSpecification_Shape);
		types.add(UMLElementTypes.InstanceSpecification_Shape_CN);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInformationItem12CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.InformationItem_Shape);
		types.add(UMLElementTypes.InformationItem_Shape_CN);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPrimitiveType13CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(UMLElementTypes.PrimitiveType_Shape_CN);
		types.add(UMLElementTypes.PrimitiveType_Shape);
		types.add(UMLElementTypes.PrimitiveType_ClassNestedClassifierLabel);
		types.add(UMLElementTypes.PrimitiveType_ComponentNestedClassifierLabel);
		types.add(UMLElementTypes.PrimitiveType_InterfaceNestedClassifierLabel);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createModel14CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Model_Shape);
		types.add(UMLElementTypes.Model_Shape_CN);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createOperation15CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(UMLElementTypes.Operation_ComponentOperationLabel);
		types.add(UMLElementTypes.Operation_InterfaceOperationLabel);
		types.add(UMLElementTypes.Operation_ClassOperationLabel);
		types.add(UMLElementTypes.Operation_DataTypeOperationLabel);
		types.add(UMLElementTypes.Operation_PrimitiveTypeOperationLabel);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createOperationTemplateParameterCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.OperationTemplateParameter_TemplateParameterLabel);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPackage17CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Package_Shape_CN);
		types.add(UMLElementTypes.Package_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createProperty18CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(6);
		types.add(UMLElementTypes.Property_ComponentAttributeLabel);
		types.add(UMLElementTypes.Property_SignalAttributeLabel);
		types.add(UMLElementTypes.Property_InterfaceAttributeLabel);
		types.add(UMLElementTypes.Property_ClassAttributeLabel);
		types.add(UMLElementTypes.Property_DataTypeAttributeLabel);
		types.add(UMLElementTypes.Property_PrimitiveTypeAttributeLabel);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createReception19CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Reception_ReceptionLabel);
		types.add(UMLElementTypes.Reception_InterfaceReceptionLabel);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createRedefinableTemplateSignature20CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.RedefinableTemplateSignature_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createSignal21CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(UMLElementTypes.Signal_Shape);
		types.add(UMLElementTypes.Signal_Shape_CN);
		types.add(UMLElementTypes.Signal_ClassNestedClassifierLabel);
		types.add(UMLElementTypes.Signal_ComponentNestedClassifierLabel);
		types.add(UMLElementTypes.Signal_InterfaceNestedClassifierLabel);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createSlot22CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Slot_SlotLabel);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createTemplateParameter23CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.TemplateParameter_TemplateParameterLabel);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createTemplateSignatureCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.TemplateSignature_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createTimeObservation22CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.TimeObservation_Shape);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createConnectableElementTemplateParameter26CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ConnectableElementTemplateParameter_TemplateParameterLabel);
		Tool tool = new AspectUnspecifiedTypeCreationTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAbstraction1CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Abstraction_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAssociation2CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Association_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAssociationBranch3CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Association_BranchEdge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createAssociationClass4CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.AssociationClass_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createContainmentLink5CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Element_ContainmentEdge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createContextLink6CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Constraint_ContextEdge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDependency7CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Dependency_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createDependencyBranch8CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Dependency_BranchEdge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createElementImport9CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ElementImport_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createGeneralization10CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Generalization_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createGeneralizationSet11CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.GeneralizationSet_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInformationFlowLinkCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.InformationFlow_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInstanceSpecificationLinkCreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.InstanceSpecification_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createInterfaceRealization14CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.InterfaceRealization_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createLink15CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(UMLElementTypes.Comment_AnnotatedElementEdge);
		types.add(UMLElementTypes.TimeObservation_EventEdge);
		types.add(UMLElementTypes.DurationObservation_EventEdge);
		types.add(UMLElementTypes.Constraint_ConstrainedElementEdge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPackageImport16CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.PackageImport_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createPackageMerge17CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.PackageMerge_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createProfileApplication18CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.ProfileApplication_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createRealization19CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Realization_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createSubstitution20CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Substitution_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createTemplateBinding21CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.TemplateBinding_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}

	/**
	 * @generated
	 */
	private Tool createUsage22CreationTool() {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Usage_Edge);
		Tool tool = new AspectUnspecifiedTypeConnectionTool(types);
		return tool;
	}
}
