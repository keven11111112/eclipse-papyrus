/*****************************************************************************
 * Copyright (c) 2010, 2015 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	 Florian Noyrit  (CEA) florian.noyrit@cea.fr - Initial API and Implementation
 *   Mickael ADAM (ALL4TEC) mickael.adam@all4tec.net - reconciler to add floating label
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.migration;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.DiagramReconciler;

/**
 * Class Diagram Reconciler from 1.1.0 to 1.2.0
 */
public class ClassReconciler_1_2_0 extends DiagramReconciler {

	@Override
	public ICommand getReconcileCommand(Diagram diagram) {
		CompositeCommand cc = new CompositeCommand("Migrate diagram from 1.1.0 to 1.2.0");
		cc.add(new ChangeVisualIDsCommand(diagram));
		return cc;
	}

	protected class ChangeVisualIDsCommand extends AbstractCommand {

		protected final Diagram diagram;

		public ChangeVisualIDsCommand(Diagram diagram) {
			super("Change the diagram's visual ids from 1.1.0 to 1.2.0");
			this.diagram = diagram;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			TreeIterator<EObject> allContentIterator = diagram.eAllContents();

			while (allContentIterator.hasNext()) {
				EObject eObject = allContentIterator.next();
				if (eObject instanceof View) {
					View view = (View) eObject;
					view.setType(getNewVisualID(view.getType()));
				}
			}

			return CommandResult.newOKCommandResult();
		}

		@Override
		public boolean canUndo() {
			return false;
		}

		@Override
		public boolean canRedo() {
			return false;
		}

		@Override
		protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			throw new ExecutionException("Should not be called, canRedo false");
		}

		@Override
		protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			throw new ExecutionException("Should not be called, canUndo false");
		}
	}

	public static String getNewVisualID(String oldVisualID) {
		switch (oldVisualID) {
		case "1000":
			return "Package_ClassDiagram";
		case "3012":
			return "Property_ClassAttributeLabel";
		case "3002":
			return "Property_ComponentAttributeLabel";
		case "3005":
			return "Property_SignalAttributeLabel";
		case "3006":
			return "Property_InterfaceAttributeLabel";
		case "3041":
			return "Property_PrimitiveTypeAttributeLabel";
		case "3018":
			return "Property_DataTypeAttributeLabel";
		case "3014":
			return "Class_ClassNestedClassifierLabel";
		case "3004":
			return "Class_ComponentNestedClassifierLabel";
		case "3008":
			return "Class_InterfaceNestedClassifierLabel";
		case "3013":
			return "Operation_ClassOperationLabel";
		case "3003":
			return "Operation_ComponentOperationLabel";
		case "3007":
			return "Operation_InterfaceOperationLabel";
		case "3042":
			return "Operation_PrimitiveTypeOperationLabel";
		case "3019":
			return "Operation_DataTypeOperationLabel";
		case "3034":
			return "ConnectableElementTemplateParameter_TemplateParameterLabel";
		case "3035":
			return "OperationTemplateParameter_TemplateParameterLabel";
		case "3031":
			return "ClassifierTemplateParameter_TemplateParameterLabel";
		case "3016":
			return "TemplateParameter_TemplateParameterLabel";
		case "3017":
			return "EnumerationLiteral_LiteralLabel";
		case "3011":
			return "Reception_ReceptionLabel";
		case "3039":
			return "Reception_InterfaceReceptionLabel";
		case "3030":
			return "Slot_SlotLabel";
		case "3015":
			return "RedefinableTemplateSignature_Shape";
		case "3033":
			return "TemplateSignature_Shape";
		case "3020":
			return "InstanceSpecification_Shape_CN";
		case "5040":
			return "InstanceSpecification_NameLabel_CN";
		case "8509":
			return "InstanceSpecification_FloatingNameLabel_CN";
		case "3021":
			return "Component_Shape_CN";
		case "5043":
			return "Component_NameLabel_CN";
		case "8513":
			return "Component_FloatingNameLabel_CN";
		case "3022":
			return "Signal_Shape_CN";
		case "5046":
			return "Signal_NameLabel_CN";
		case "8514":
			return "Signal_FloatingNameLabel_CN";
		case "3023":
			return "Interface_Shape_CN";
		case "5049":
			return "Interface_NameLabel_CN";
		case "8515":
			return "Interface_FloatingNameLabel_CN";
		case "3024":
			return "Model_Shape_CN";
		case "5052":
			return "Model_NameLabel_CN";
		case "3025":
			return "Enumeration_Shape_CN";
		case "5055":
			return "Enumeration_NameLabel_CN";
		case "8516":
			return "Enumeration_FloatingNameLabel_CN";
		case "3009":
			return "Package_Shape_CN";
		case "5017":
			return "Package_NameLabel_CN";
		case "3040":
			return "InformationItem_Shape_CN";
		case "5162":
			return "InformationItem_NameLabel_CN";
		case "8517":
			return "InformationItem_FloatingNameLabel_CN";
		case "3010":
			return "Class_Shape_CN";
		case "5014":
			return "Class_NameLabel_CN";
		case "8518":
			return "Class_FloatingNameLabel_CN";
		case "3026":
			return "PrimitiveType_Shape_CN";
		case "5058":
			return "PrimitiveType_NameLabel_CN";
		case "8519":
			return "PrimitiveType_FloatingNameLabel_CN";
		case "3027":
			return "DataType_Shape_CN";
		case "5061":
			return "DataType_NameLabel_CN";
		case "8520":
			return "DataType_FloatingNameLabel_CN";
		case "3028":
			return "Comment_Shape_CN";
		case "5063":
			return "Comment_BodyLabel_CN";
		case "3029":
			return "Constraint_PackagedElementShape_CN";
		case "5064":
			return "Constraint_NameLabel_CN";
		case "5160":
			return "Constraint_FloatingNameLabel_CN";
		case "3036":
			return "Interface_ClassNestedClassifierLabel";
		case "3037":
			return "Interface_ComponentNestedClassifierLabel";
		case "3038":
			return "Interface_InterfaceNestedClassifierLabel";
		case "3052":
			return "Enumeration_ClassNestedClassifierLabel";
		case "3053":
			return "Enumeration_ComponentNestedClassifierLabel";
		case "3054":
			return "Enumeration_InterfaceNestedClassifierLabel";
		case "3047":
			return "PrimitiveType_ClassNestedClassifierLabel";
		case "3046":
			return "PrimitiveType_ComponentNestedClassifierLabel";
		case "3048":
			return "PrimitiveType_InterfaceNestedClassifierLabel";
		case "3044":
			return "DataType_ClassNestedClassifierLabel";
		case "3045":
			return "DataType_ComponentNestedClassifierLabel";
		case "3043":
			return "DataType_InterfaceNestedClassifierLabel";
		case "3050":
			return "Signal_ClassNestedClassifierLabel";
		case "3051":
			return "Signal_ComponentNestedClassifierLabel";
		case "3049":
			return "Signal_InterfaceNestedClassifierLabel";
		case "3055":
			return "Component_ClassNestedClassifierLabel";
		case "3056":
			return "Component_InterfaceNestedClassifierLabel";
		case "3057":
			return "Component_ComponentNestedClassifierLabel";
		case "2014":
			return "Dependency_Shape";
		case "1":
			return "Dependency_MultiNameLabel";
		case "8522":
			return "Dependency_FloatingNameLabel";
		case "2013":
			return "AssociationClass_Shape";
		case "5066":
			return "AssociationClass_NameLabel";
		case "8504":
			return "AssociationClass_FloatingNameLabel";
		case "2015":
			return "Association_Shape";
		case "8521":
			return "Association_FloatingNameLabel";
		case "2001":
			return "InstanceSpecification_Shape";
		case "5002":
			return "InstanceSpecification_NameLabel";
		case "8505":
			return "InstanceSpecification_FloatingNameLabel";
		case "2002":
			return "Component_Shape";
		case "5005":
			return "Component_NameLabel";
		case "8503":
			return "Component_FloatingNameLabel";
		case "2003":
			return "Signal_Shape";
		case "5008":
			return "Signal_NameLabel";
		case "8506":
			return "Signal_FloatingNameLabel";
		case "2004":
			return "Interface_Shape";
		case "5011":
			return "Interface_NameLabel";
		case "8507":
			return "Interface_FloatingNameLabel";
		case "2005":
			return "Model_Shape";
		case "5020":
			return "Model_NameLabel";
		case "2006":
			return "Enumeration_Shape";
		case "5023":
			return "Enumeration_NameLabel";
		case "8508":
			return "Enumeration_FloatingNameLabel";
		case "2007":
			return "Package_Shape";
		case "5026":
			return "Package_NameLabel";
		case "2099":
			return "InformationItem_Shape";
		case "5161":
			return "InformationItem_NameLabel";
		case "8512":
			return "InformationItem_FloatingNameLabel";
		case "2008":
			return "Class_Shape";
		case "5029":
			return "Class_NameLabel";
		case "8510":
			return "Class_FloatingNameLabel";
		case "2009":
			return "PrimitiveType_Shape";
		case "5032":
			return "PrimitiveType_NameLabel";
		case "8511":
			return "PrimitiveType_FloatingNameLabel";
		case "2010":
			return "DataType_Shape";
		case "5035":
			return "DataType_NameLabel";
		case "8502":
			return "DataType_FloatingNameLabel";
		case "2011":
			return "Constraint_PackagedElementShape";
		case "5037":
			return "Constraint_NameLabel";
		case "5159":
			return "Constraint_BodyLabel";
		case "2012":
			return "Comment_Shape";
		case "5038":
			return "Comment_BodyLabel";
		case "2016":
			return "Diagram_ShortcutShape";
		case "0":
			return "Diagram_NameLabel";
		case "2095":
			return "DurationObservation_Shape";
		case "5155":
			return "DurationObservation_FloatingNameLabel";
		case "5156":
			return "DurationObservation_StereotypeLabel";
		case "2096":
			return "TimeObservation_Shape";
		case "5153":
			return "TimeObservation_FloatingNameLabel";
		case "5154":
			return "TimeObservation_StereotypeLabel";
		case "2097":
			return "NamedElement_DefaultShape";
		case "5157":
			return "NamedElement_NameLabel";
		case "4016":
			return "AssociationClass_TetherEdge";
		case "4017":
			return "AssociationClass_Edge";
		case "6031":
			return "AssociationClass_SourceRoleLabel";
		case "6032":
			return "AssociationClass_TargetRoleLabel";
		case "4001":
			return "Association_Edge";
		case "6001":
			return "Association_StereotypeLabel";
		case "6002":
			return "Association_NameLabel";
		case "6003":
			return "Association_TargetRoleLabel";
		case "6005":
			return "Association_SourceRoleLabel";
		case "6033":
			return "Association_SourceMultiplicityLabel";
		case "6034":
			return "Association_TargetMultiplicityLabel";
		case "4019":
			return "Association_BranchEdge";
		case "6024":
			return "Association_BranchRoleLabel";
		case "6035":
			return "Association_BranchMultiplicityLabel";
		case "4002":
			return "Generalization_Edge";
		case "6007":
			return "Generalization_StereotypeLabel";
		case "4003":
			return "InterfaceRealization_Edge";
		case "6008":
			return "InterfaceRealization_StereotypeLabel";
		case "6009":
			return "InterfaceRealization_NameLabel";
		case "4004":
			return "Substitution_Edge";
		case "6010":
			return "Substitution_StereotypeLabel";
		case "6011":
			return "Substitution_NameLabel";
		case "4005":
			return "Realization_Edge";
		case "6012":
			return "Realization_StereotypeLabel";
		case "6013":
			return "Realization_NameLabel";
		case "4006":
			return "Abstraction_Edge";
		case "6014":
			return "Abstraction_NameLabel";
		case "6015":
			return "Abstraction_StereotypeLabel";
		case "4007":
			return "Usage_Edge";
		case "6016":
			return "Usage_NameLabel";
		case "6017":
			return "Usage_StereotypeLabel";
		case "4008":
			return "Dependency_Edge";
		case "6026":
			return "Dependency_NameLabel";
		case "6027":
			return "Dependency_StereotypeLabel";
		case "4018":
			return "Dependency_BranchEdge";
		case "4009":
			return "ElementImport_Edge";
		case "6020":
			return "ElementImport_AliasLabel";
		case "6021":
			return "ElementImport_StereotypeLabel";
		case "4010":
			return "PackageImport_Edge";
		case "6022":
			return "PackageImport_StereotypeLabel";
		case "4011":
			return "PackageMerge_Edge";
		case "6030":
			return "PackageMerge_StereotypeLabel";
		case "4012":
			return "ProfileApplication_Edge";
		case "4013":
			return "Comment_AnnotatedElementEdge";
		case "4014":
			return "Constraint_ConstrainedElementEdge";
		case "4015":
			return "TemplateBinding_Edge";
		case "6023":
			return "TemplateBinding_SubstitutionLabel";
		case "6036":
			return "TemplateBinding_StereotypeLabel";
		case "4020":
			return "GeneralizationSet_Edge";
		case "5067":
			return "GeneralizationSet_ConstraintLabel";
		case "6037":
			return "GeneralizationSet_StereotypeLabel";
		case "4021":
			return "InstanceSpecification_Edge";
		case "6039":
			return "InstanceSpecification_SourceRoleLabel";
		case "6038":
			return "InstanceSpecification_TargetRoleLabel";
		case "4023":
			return "Element_ContainmentEdge";
		case "4024":
			return "TimeObservation_EventEdge";
		case "4025":
			return "DurationObservation_EventEdge";
		case "4026":
			return "InformationFlow_Edge";
		case "6040":
			return "InformationFlow_ConveyedLabel";
		case "6041":
			return "InformationFlow_StereotypeLabel";
		case "8500":
			return "Constraint_ContextEdge";
		case "8501":
			return "Constraint_KeywordLabel";
		case "7011":
			return "Class_AttributeCompartment_CN";
		case "7012":
			return "Class_OperationCompartment_CN";
		case "7013":
			return "Class_NestedClassifierCompartment_CN";
		case "7023":
			return "Component_AttributeCompartment_CN";
		case "7024":
			return "Component_OperationCompartment_CN";
		case "7025":
			return "Component_NestedClassifierCompartment_CN";
		case "7026":
			return "Signal_AttributeCompartment_CN";
		case "7027":
			return "Interface_AttributeCompartment_CN";
		case "7028":
			return "Interface_OperationCompartment_CN";
		case "7029":
			return "Interface_NestedClassifierCompartment_CN";
		case "7041":
			return "PrimitiveType_AttributeCompartment_CN";
		case "7042":
			return "PrimitiveType_OperationCompartment_CN";
		case "7032":
			return "DataType_AttributeCompartment_CN";
		case "7033":
			return "DataType_OperationCompartment_CN";
		case "7030":
			return "Model_PackagedElementCompartment_CN";
		case "7010":
			return "Package_PackagedElementCompartment_CN";
		case "7031":
			return "Enumeration_LiteralCompartment_CN";
		case "7035":
			return "InstanceSpecification_SlotCompartment_CN";
		case "7017":
			return "Class_AttributeCompartment";
		case "7018":
			return "Class_OperationCompartment";
		case "7019":
			return "Class_NestedClassifierCompartment";
		case "7002":
			return "Component_AttributeCompartment";
		case "7003":
			return "Component_OperationCompartment";
		case "7004":
			return "Component_NestedClassifierCompartment";
		case "7006":
			return "Interface_AttributeCompartment";
		case "7007":
			return "Interface_OperationCompartment";
		case "7008":
			return "Interface_NestedClassifierCompartment";
		case "7039":
			return "PrimitiveType_AttributeCompartment";
		case "7040":
			return "PrimitiveType_OperationCompartment";
		case "7020":
			return "DataType_AttributeCompartment";
		case "7021":
			return "DataType_OperationCompartment";
		case "7034":
			return "AssociationClass_AttributeCompartment";
		case "7001":
			return "InstanceSpecification_SlotCompartment";
		case "7005":
			return "Signal_AttributeCompartment";
		case "7009":
			return "Model_PackagedElementCompartment";
		case "7016":
			return "Package_PackagedElementCompartment";
		case "7015":
			return "Enumeration_LiteralCompartment";
		case "7036":
			return "AssociationClass_OperationCompartment";
		case "7037":
			return "AssociationClass_NestedClassifierCompartment";
		case "7014":
			return "RedefinableTemplateSignature_TemplateParameterCompartment";
		case "7038":
			return "TemplateSignature_TemplateParameterCompartment";
		default:
			return defaultGetNewVisualID(oldVisualID);
		}
	}

	private static String defaultGetNewVisualID(String oldVisualID) {
		return oldVisualID;
	}
}
