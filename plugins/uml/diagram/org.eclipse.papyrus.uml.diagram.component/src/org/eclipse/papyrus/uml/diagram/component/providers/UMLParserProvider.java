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
package org.eclipse.papyrus.uml.diagram.component.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.parser.CommentParser;
import org.eclipse.papyrus.uml.diagram.common.parser.ConstraintParser;
import org.eclipse.papyrus.uml.diagram.common.parser.stereotype.AppliedStereotypeParser;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.AbstractionAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.AbstractionNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.CommentBodyEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentFloatingLabelEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentFloatingLabelEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentFloatingLabelEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentNameEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentRealizationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentRealizationNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConnectorAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConnectorNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintNameEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintSpecificationEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DefaultNamedElementNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyNodeFloatingLabelEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.GeneralizationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceFloatingLabelEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceFloatingLabelEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceNameEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceRealizationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceRealizationNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ManifestationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ManifestationNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.MultiDependencyLabelEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.OperationForInterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PortAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PortNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PropertyForInterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PropertyPartNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ReceptionInInterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.RectangleInterfaceFloatingLabelEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.RectangleInterfaceFloatingLabelEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.RectangleInterfaceNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.RectangleInterfaceNameEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.SubstitutionAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.SubstitutionNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.UsageAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.UsageNameEditPart;
import org.eclipse.papyrus.uml.diagram.component.parsers.MessageFormatParser;
import org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser dependencyName_5008Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyName_5008Parser() {
		if (dependencyName_5008Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dependencyName_5008Parser = parser;
		}
		return dependencyName_5008Parser;
	}

	/**
	 * @generated
	 */
	private IParser dependencyName_6029Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyName_6029Parser() {
		if (dependencyName_6029Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dependencyName_6029Parser = parser;
		}
		return dependencyName_6029Parser;
	}

	/**
	 * @generated
	 */
	private IParser componentName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getComponentName_5004Parser() {
		if (componentName_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			componentName_5004Parser = parser;
		}
		return componentName_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser componentName_6030Parser;

	/**
	 * @generated
	 */
	private IParser getComponentName_6030Parser() {
		if (componentName_6030Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			componentName_6030Parser = parser;
		}
		return componentName_6030Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelName_5262Parser;

	/**
	 * @generated
	 */
	private IParser getModelName_5262Parser() {
		if (modelName_5262Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			modelName_5262Parser = parser;
		}
		return modelName_5262Parser;
	}

	/**
	 * @generated
	 */
	private IParser packageName_5254Parser;

	/**
	 * @generated
	 */
	private IParser getPackageName_5254Parser() {
		if (packageName_5254Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			packageName_5254Parser = parser;
		}
		return packageName_5254Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceName_5266Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceName_5266Parser() {
		if (interfaceName_5266Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			interfaceName_5266Parser = parser;
		}
		return interfaceName_5266Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceName_6031Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceName_6031Parser() {
		if (interfaceName_6031Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			interfaceName_6031Parser = parser;
		}
		return interfaceName_6031Parser;
	}

	/**
	 * @generated
	 */
	private CommentParser commentBody_5255Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_5255Parser() {
		if (commentBody_5255Parser == null) {
			commentBody_5255Parser = new CommentParser();
		}
		return commentBody_5255Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_5252Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_5252Parser() {
		if (constraintName_5252Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			constraintName_5252Parser = parser;
		}
		return constraintName_5252Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser constraintSpecification_5253Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintSpecification_5253Parser() {
		if (constraintSpecification_5253Parser == null) {
			constraintSpecification_5253Parser = new ConstraintParser();
		}
		return constraintSpecification_5253Parser;
	}

	/**
	 * @generated
	 */
	private IParser namedElementName_5265Parser;

	/**
	 * @generated
	 */
	private IParser getNamedElementName_5265Parser() {
		if (namedElementName_5265Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			namedElementName_5265Parser = parser;
		}
		return namedElementName_5265Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceName_5005Parser() {
		if (interfaceName_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			interfaceName_5005Parser = parser;
		}
		return interfaceName_5005Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceName_6032Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceName_6032Parser() {
		if (interfaceName_6032Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			interfaceName_6032Parser = parser;
		}
		return interfaceName_6032Parser;
	}

	/**
	 * @generated
	 */
	private IParser portName_5006Parser;

	/**
	 * @generated
	 */
	private IParser getPortName_5006Parser() {
		if (portName_5006Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			portName_5006Parser = parser;
		}
		return portName_5006Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser portName_5007Parser;

	/**
	 * @generated
	 */
	private IParser getPortName_5007Parser() {
		if (portName_5007Parser == null) {
			portName_5007Parser = new AppliedStereotypeParser();
		}
		return portName_5007Parser;
	}

	/**
	 * @generated
	 */
	private IParser modelName_5264Parser;

	/**
	 * @generated
	 */
	private IParser getModelName_5264Parser() {
		if (modelName_5264Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			modelName_5264Parser = parser;
		}
		return modelName_5264Parser;
	}

	/**
	 * @generated
	 */
	private IParser packageName_5261Parser;

	/**
	 * @generated
	 */
	private IParser getPackageName_5261Parser() {
		if (packageName_5261Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			packageName_5261Parser = parser;
		}
		return packageName_5261Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceName_5267Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceName_5267Parser() {
		if (interfaceName_5267Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			interfaceName_5267Parser = parser;
		}
		return interfaceName_5267Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceName_6033Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceName_6033Parser() {
		if (interfaceName_6033Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			interfaceName_6033Parser = parser;
		}
		return interfaceName_6033Parser;
	}

	/**
	 * @generated
	 */
	private IParser componentName_5256Parser;

	/**
	 * @generated
	 */
	private IParser getComponentName_5256Parser() {
		if (componentName_5256Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			componentName_5256Parser = parser;
		}
		return componentName_5256Parser;
	}

	/**
	 * @generated
	 */
	private IParser componentName_6026Parser;

	/**
	 * @generated
	 */
	private IParser getComponentName_6026Parser() {
		if (componentName_6026Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			componentName_6026Parser = parser;
		}
		return componentName_6026Parser;
	}

	/**
	 * @generated
	 */
	private IParser componentName_5257Parser;

	/**
	 * @generated
	 */
	private IParser getComponentName_5257Parser() {
		if (componentName_5257Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			componentName_5257Parser = parser;
		}
		return componentName_5257Parser;
	}

	/**
	 * @generated
	 */
	private IParser componentName_6027Parser;

	/**
	 * @generated
	 */
	private IParser getComponentName_6027Parser() {
		if (componentName_6027Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			componentName_6027Parser = parser;
		}
		return componentName_6027Parser;
	}

	/**
	 * @generated
	 */
	private CommentParser commentBody_5258Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_5258Parser() {
		if (commentBody_5258Parser == null) {
			commentBody_5258Parser = new CommentParser();
		}
		return commentBody_5258Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_5259Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_5259Parser() {
		if (constraintName_5259Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			constraintName_5259Parser = parser;
		}
		return constraintName_5259Parser;
	}

	/**
	 * @generated
	 */
	private ConstraintParser constraintSpecification_5260Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintSpecification_5260Parser() {
		if (constraintSpecification_5260Parser == null) {
			constraintSpecification_5260Parser = new ConstraintParser();
		}
		return constraintSpecification_5260Parser;
	}

	/**
	 * @generated
	 */
	private IParser property_1Parser;

	/**
	 * @generated
	 */
	private IParser getProperty_1Parser() {
		if (property_1Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			property_1Parser = parser;
		}
		return property_1Parser;
	}

	/**
	 * @generated
	 */
	private IParser operation_5Parser;

	/**
	 * @generated
	 */
	private IParser getOperation_5Parser() {
		if (operation_5Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			operation_5Parser = parser;
		}
		return operation_5Parser;
	}

	/**
	 * @generated
	 */
	private IParser reception_6Parser;

	/**
	 * @generated
	 */
	private IParser getReception_6Parser() {
		if (reception_6Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("\u00ABSignal\u00BB {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			reception_6Parser = parser;
		}
		return reception_6Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceName_0Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceName_0Parser() {
		if (interfaceName_0Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			interfaceName_0Parser = parser;
		}
		return interfaceName_0Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceName_6028Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceName_6028Parser() {
		if (interfaceName_6028Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			interfaceName_6028Parser = parser;
		}
		return interfaceName_6028Parser;
	}

	/**
	 * @generated
	 */
	private IParser propertyName_5268Parser;

	/**
	 * @generated
	 */
	private IParser getPropertyName_5268Parser() {
		if (propertyName_5268Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			propertyName_5268Parser = parser;
		}
		return propertyName_5268Parser;
	}

	/**
	 * @generated
	 */
	private IParser usageName_6016Parser;

	/**
	 * @generated
	 */
	private IParser getUsageName_6016Parser() {
		if (usageName_6016Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			usageName_6016Parser = parser;
		}
		return usageName_6016Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser usageName_6017Parser;

	/**
	 * @generated
	 */
	private IParser getUsageName_6017Parser() {
		if (usageName_6017Parser == null) {
			usageName_6017Parser = new AppliedStereotypeParser();
		}
		return usageName_6017Parser;
	}

	/**
	 * @generated
	 */
	private IParser interfaceRealizationName_6010Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceRealizationName_6010Parser() {
		if (interfaceRealizationName_6010Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			interfaceRealizationName_6010Parser = parser;
		}
		return interfaceRealizationName_6010Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser interfaceRealizationName_6011Parser;

	/**
	 * @generated
	 */
	private IParser getInterfaceRealizationName_6011Parser() {
		if (interfaceRealizationName_6011Parser == null) {
			interfaceRealizationName_6011Parser = new AppliedStereotypeParser();
		}
		return interfaceRealizationName_6011Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser generalizationIsSubstitutable_2Parser;

	/**
	 * @generated
	 */
	private IParser getGeneralizationIsSubstitutable_2Parser() {
		if (generalizationIsSubstitutable_2Parser == null) {
			generalizationIsSubstitutable_2Parser = new AppliedStereotypeParser();
		}
		return generalizationIsSubstitutable_2Parser;
	}

	/**
	 * @generated
	 */
	private IParser substitutionName_6006Parser;

	/**
	 * @generated
	 */
	private IParser getSubstitutionName_6006Parser() {
		if (substitutionName_6006Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			substitutionName_6006Parser = parser;
		}
		return substitutionName_6006Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser substitutionName_6020Parser;

	/**
	 * @generated
	 */
	private IParser getSubstitutionName_6020Parser() {
		if (substitutionName_6020Parser == null) {
			substitutionName_6020Parser = new AppliedStereotypeParser();
		}
		return substitutionName_6020Parser;
	}

	/**
	 * @generated
	 */
	private IParser manifestationName_6008Parser;

	/**
	 * @generated
	 */
	private IParser getManifestationName_6008Parser() {
		if (manifestationName_6008Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			manifestationName_6008Parser = parser;
		}
		return manifestationName_6008Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser manifestationName_6022Parser;

	/**
	 * @generated
	 */
	private IParser getManifestationName_6022Parser() {
		if (manifestationName_6022Parser == null) {
			manifestationName_6022Parser = new AppliedStereotypeParser();
		}
		return manifestationName_6022Parser;
	}

	/**
	 * @generated
	 */
	private IParser componentRealizationName_3Parser;

	/**
	 * @generated
	 */
	private IParser getComponentRealizationName_3Parser() {
		if (componentRealizationName_3Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			componentRealizationName_3Parser = parser;
		}
		return componentRealizationName_3Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser componentRealizationName_4Parser;

	/**
	 * @generated
	 */
	private IParser getComponentRealizationName_4Parser() {
		if (componentRealizationName_4Parser == null) {
			componentRealizationName_4Parser = new AppliedStereotypeParser();
		}
		return componentRealizationName_4Parser;
	}

	/**
	 * @generated
	 */
	private IParser abstractionName_6007Parser;

	/**
	 * @generated
	 */
	private IParser getAbstractionName_6007Parser() {
		if (abstractionName_6007Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			abstractionName_6007Parser = parser;
		}
		return abstractionName_6007Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser abstractionName_6021Parser;

	/**
	 * @generated
	 */
	private IParser getAbstractionName_6021Parser() {
		if (abstractionName_6021Parser == null) {
			abstractionName_6021Parser = new AppliedStereotypeParser();
		}
		return abstractionName_6021Parser;
	}

	/**
	 * @generated
	 */
	private IParser dependencyName_6009Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyName_6009Parser() {
		if (dependencyName_6009Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			dependencyName_6009Parser = parser;
		}
		return dependencyName_6009Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser dependencyName_6023Parser;

	/**
	 * @generated
	 */
	private IParser getDependencyName_6023Parser() {
		if (dependencyName_6023Parser == null) {
			dependencyName_6023Parser = new AppliedStereotypeParser();
		}
		return dependencyName_6023Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser connectorName_6024Parser;

	/**
	 * @generated
	 */
	private IParser getConnectorName_6024Parser() {
		if (connectorName_6024Parser == null) {
			connectorName_6024Parser = new AppliedStereotypeParser();
		}
		return connectorName_6024Parser;
	}

	/**
	 * @generated
	 */
	private IParser connectorName_6025Parser;

	/**
	 * @generated
	 */
	private IParser getConnectorName_6025Parser() {
		if (connectorName_6025Parser == null) {
			EAttribute[] features = new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			connectorName_6025Parser = parser;
		}
		return connectorName_6025Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(String visualID) {
		if (visualID != null) {
			switch (visualID) {
			case MultiDependencyLabelEditPart.VISUAL_ID:
				return getDependencyName_5008Parser();
			case DependencyNodeFloatingLabelEditPart.VISUAL_ID:
				return getDependencyName_6029Parser();
			case ComponentNameEditPart.VISUAL_ID:
				return getComponentName_5004Parser();
			case ComponentFloatingLabelEditPart.VISUAL_ID:
				return getComponentName_6030Parser();
			case ModelNameEditPart.VISUAL_ID:
				return getModelName_5262Parser();
			case PackageNameEditPart.VISUAL_ID:
				return getPackageName_5254Parser();
			case RectangleInterfaceNameEditPart.VISUAL_ID:
				return getInterfaceName_5266Parser();
			case RectangleInterfaceFloatingLabelEditPart.VISUAL_ID:
				return getInterfaceName_6031Parser();
			case CommentBodyEditPart.VISUAL_ID:
				return getCommentBody_5255Parser();
			case ConstraintNameEditPart.VISUAL_ID:
				return getConstraintName_5252Parser();
			case ConstraintSpecificationEditPart.VISUAL_ID:
				return getConstraintSpecification_5253Parser();
			case DefaultNamedElementNameEditPart.VISUAL_ID:
				return getNamedElementName_5265Parser();
			case InterfaceNameEditPart.VISUAL_ID:
				return getInterfaceName_5005Parser();
			case InterfaceFloatingLabelEditPart.VISUAL_ID:
				return getInterfaceName_6032Parser();
			case PortNameEditPart.VISUAL_ID:
				return getPortName_5006Parser();
			case PortAppliedStereotypeEditPart.VISUAL_ID:
				return getPortName_5007Parser();
			case ModelNameEditPartCN.VISUAL_ID:
				return getModelName_5264Parser();
			case PackageNameEditPartCN.VISUAL_ID:
				return getPackageName_5261Parser();
			case RectangleInterfaceNameEditPartCN.VISUAL_ID:
				return getInterfaceName_5267Parser();
			case RectangleInterfaceFloatingLabelEditPartCN.VISUAL_ID:
				return getInterfaceName_6033Parser();
			case ComponentNameEditPartCN.VISUAL_ID:
				return getComponentName_5256Parser();
			case ComponentFloatingLabelEditPartCN.VISUAL_ID:
				return getComponentName_6026Parser();
			case ComponentNameEditPartPCN.VISUAL_ID:
				return getComponentName_5257Parser();
			case ComponentFloatingLabelEditPartPCN.VISUAL_ID:
				return getComponentName_6027Parser();
			case CommentBodyEditPartPCN.VISUAL_ID:
				return getCommentBody_5258Parser();
			case ConstraintNameEditPartPCN.VISUAL_ID:
				return getConstraintName_5259Parser();
			case ConstraintSpecificationEditPartPCN.VISUAL_ID:
				return getConstraintSpecification_5260Parser();
			case PropertyForInterfaceEditPart.VISUAL_ID:
				return getProperty_1Parser();
			case OperationForInterfaceEditPart.VISUAL_ID:
				return getOperation_5Parser();
			case ReceptionInInterfaceEditPart.VISUAL_ID:
				return getReception_6Parser();
			case InterfaceNameEditPartPCN.VISUAL_ID:
				return getInterfaceName_0Parser();
			case InterfaceFloatingLabelEditPartPCN.VISUAL_ID:
				return getInterfaceName_6028Parser();
			case PropertyPartNameEditPartCN.VISUAL_ID:
				return getPropertyName_5268Parser();
			case UsageNameEditPart.VISUAL_ID:
				return getUsageName_6016Parser();
			case UsageAppliedStereotypeEditPart.VISUAL_ID:
				return getUsageName_6017Parser();
			case InterfaceRealizationNameEditPart.VISUAL_ID:
				return getInterfaceRealizationName_6010Parser();
			case InterfaceRealizationAppliedStereotypeEditPart.VISUAL_ID:
				return getInterfaceRealizationName_6011Parser();
			case GeneralizationAppliedStereotypeEditPart.VISUAL_ID:
				return getGeneralizationIsSubstitutable_2Parser();
			case SubstitutionNameEditPart.VISUAL_ID:
				return getSubstitutionName_6006Parser();
			case SubstitutionAppliedStereotypeEditPart.VISUAL_ID:
				return getSubstitutionName_6020Parser();
			case ManifestationNameEditPart.VISUAL_ID:
				return getManifestationName_6008Parser();
			case ManifestationAppliedStereotypeEditPart.VISUAL_ID:
				return getManifestationName_6022Parser();
			case ComponentRealizationNameEditPart.VISUAL_ID:
				return getComponentRealizationName_3Parser();
			case ComponentRealizationAppliedStereotypeEditPart.VISUAL_ID:
				return getComponentRealizationName_4Parser();
			case AbstractionNameEditPart.VISUAL_ID:
				return getAbstractionName_6007Parser();
			case AbstractionAppliedStereotypeEditPart.VISUAL_ID:
				return getAbstractionName_6021Parser();
			case DependencyNameEditPart.VISUAL_ID:
				return getDependencyName_6009Parser();
			case DependencyAppliedStereotypeEditPart.VISUAL_ID:
				return getDependencyName_6023Parser();
			case ConnectorAppliedStereotypeEditPart.VISUAL_ID:
				return getConnectorName_6024Parser();
			case ConnectorNameEditPart.VISUAL_ID:
				return getConnectorName_6025Parser();
			}
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 *
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	@Override
	public IParser getParser(IAdaptable hint) {
		String vid = hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(UMLVisualIDRegistry.getVisualID(vid));
		}
		View view = hint.getAdapter(View.class);
		if (view != null) {
			return getParser(UMLVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	@Override
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (UMLElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		@Override
		public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}
}
