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
package org.eclipse.papyrus.umldi.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.dd.dc.DCPackage;
import org.eclipse.papyrus.dd.di.DIPackage;
import org.eclipse.papyrus.umldi.AbstractionEdge;
import org.eclipse.papyrus.umldi.ActionShape;
import org.eclipse.papyrus.umldi.ActivityDiagram;
import org.eclipse.papyrus.umldi.ActivityEdgeEdge;
import org.eclipse.papyrus.umldi.ActivityGroupShape;
import org.eclipse.papyrus.umldi.ActivityNodeCompartment;
import org.eclipse.papyrus.umldi.ActivityNodeShape;
import org.eclipse.papyrus.umldi.ActivityParameterNodeShape;
import org.eclipse.papyrus.umldi.ActivityPartitionShape;
import org.eclipse.papyrus.umldi.ActivityShape;
import org.eclipse.papyrus.umldi.ActorShape;
import org.eclipse.papyrus.umldi.ArtifactShape;
import org.eclipse.papyrus.umldi.AssociationClassEdge;
import org.eclipse.papyrus.umldi.AssociationClassShape;
import org.eclipse.papyrus.umldi.AssociationEdge;
import org.eclipse.papyrus.umldi.AssociationShape;
import org.eclipse.papyrus.umldi.AttachmentEdge;
import org.eclipse.papyrus.umldi.AttributeCompartment;
import org.eclipse.papyrus.umldi.BaseStateShape;
import org.eclipse.papyrus.umldi.BehaviorDiagram;
import org.eclipse.papyrus.umldi.BehavioredClassifierShape;
import org.eclipse.papyrus.umldi.ClassDiagram;
import org.eclipse.papyrus.umldi.ClassShape;
import org.eclipse.papyrus.umldi.ClassifierCompartment;
import org.eclipse.papyrus.umldi.ClassifierShape;
import org.eclipse.papyrus.umldi.ClassifierWithAttributesShape;
import org.eclipse.papyrus.umldi.ClassifierWithNestedClassifiersShape;
import org.eclipse.papyrus.umldi.ClassifierWithOperationsShape;
import org.eclipse.papyrus.umldi.ClassifierWithReceptionsShape;
import org.eclipse.papyrus.umldi.CollaborationShape;
import org.eclipse.papyrus.umldi.CollaborationUseShape;
import org.eclipse.papyrus.umldi.CombinedFragmentShape;
import org.eclipse.papyrus.umldi.CommentShape;
import org.eclipse.papyrus.umldi.CommunicationDiagram;
import org.eclipse.papyrus.umldi.CommunicationPathEdge;
import org.eclipse.papyrus.umldi.CompartmentLayout;
import org.eclipse.papyrus.umldi.ComponentDiagram;
import org.eclipse.papyrus.umldi.ComponentRealizationEdge;
import org.eclipse.papyrus.umldi.ComponentShape;
import org.eclipse.papyrus.umldi.CompositeStructureDiagram;
import org.eclipse.papyrus.umldi.ConnectionPointReferenceShape;
import org.eclipse.papyrus.umldi.ConnectorEdge;
import org.eclipse.papyrus.umldi.ConstraintLabel;
import org.eclipse.papyrus.umldi.ConstraintShape;
import org.eclipse.papyrus.umldi.ContainmentEdge;
import org.eclipse.papyrus.umldi.ControlFlowEdge;
import org.eclipse.papyrus.umldi.ConveyedLabel;
import org.eclipse.papyrus.umldi.DataTypeShape;
import org.eclipse.papyrus.umldi.DeferrableTriggerCompartment;
import org.eclipse.papyrus.umldi.DependencyEdge;
import org.eclipse.papyrus.umldi.DependencyShape;
import org.eclipse.papyrus.umldi.DeployedArtifactCompartment;
import org.eclipse.papyrus.umldi.DeploymentDiagram;
import org.eclipse.papyrus.umldi.DeploymentEdge;
import org.eclipse.papyrus.umldi.DeploymentSpecificationShape;
import org.eclipse.papyrus.umldi.DeploymentTargetShape;
import org.eclipse.papyrus.umldi.DeviceShape;
import org.eclipse.papyrus.umldi.DiagramCompartment;
import org.eclipse.papyrus.umldi.DurationConstraintShape;
import org.eclipse.papyrus.umldi.DurationObservationShape;
import org.eclipse.papyrus.umldi.DurationShape;
import org.eclipse.papyrus.umldi.ElementEdge;
import org.eclipse.papyrus.umldi.ElementImportEdge;
import org.eclipse.papyrus.umldi.ElementShape;
import org.eclipse.papyrus.umldi.ElementWithActivityNodesShape;
import org.eclipse.papyrus.umldi.ElementWithPackagedElementsShape;
import org.eclipse.papyrus.umldi.ElementWithPortsShape;
import org.eclipse.papyrus.umldi.ElementWithStructureShape;
import org.eclipse.papyrus.umldi.EnumerationShape;
import org.eclipse.papyrus.umldi.ExceptionHandlerEdge;
import org.eclipse.papyrus.umldi.ExecutionEnvironmentShape;
import org.eclipse.papyrus.umldi.ExecutionSpecificationShape;
import org.eclipse.papyrus.umldi.ExpansionNodeShape;
import org.eclipse.papyrus.umldi.ExpansionRegionShape;
import org.eclipse.papyrus.umldi.ExtendEdge;
import org.eclipse.papyrus.umldi.ExtensionEdge;
import org.eclipse.papyrus.umldi.ExtensionPointCompartment;
import org.eclipse.papyrus.umldi.FunctionBehaviorShape;
import org.eclipse.papyrus.umldi.GateShape;
import org.eclipse.papyrus.umldi.GeneralOrderingEdge;
import org.eclipse.papyrus.umldi.GeneralizationEdge;
import org.eclipse.papyrus.umldi.GeneralizationSetEdge;
import org.eclipse.papyrus.umldi.GuardLabel;
import org.eclipse.papyrus.umldi.IconLabel;
import org.eclipse.papyrus.umldi.IncludeEdge;
import org.eclipse.papyrus.umldi.InformationFlowEdge;
import org.eclipse.papyrus.umldi.InformationItemShape;
import org.eclipse.papyrus.umldi.InstanceSpecificationEdge;
import org.eclipse.papyrus.umldi.InstanceSpecificationShape;
import org.eclipse.papyrus.umldi.InteractionDiagram;
import org.eclipse.papyrus.umldi.InteractionFragmentShape;
import org.eclipse.papyrus.umldi.InteractionFragmentWithGatesShape;
import org.eclipse.papyrus.umldi.InteractionFragmentWithSubfragmentsShape;
import org.eclipse.papyrus.umldi.InteractionOperandShape;
import org.eclipse.papyrus.umldi.InteractionOverviewDiagram;
import org.eclipse.papyrus.umldi.InteractionShape;
import org.eclipse.papyrus.umldi.InteractionUseShape;
import org.eclipse.papyrus.umldi.InterfaceRealizationEdge;
import org.eclipse.papyrus.umldi.InterfaceShape;
import org.eclipse.papyrus.umldi.InternalBehaviorCompartment;
import org.eclipse.papyrus.umldi.InternalTransitionCompartment;
import org.eclipse.papyrus.umldi.LifelineShape;
import org.eclipse.papyrus.umldi.ListCompartment;
import org.eclipse.papyrus.umldi.ListItemLabel;
import org.eclipse.papyrus.umldi.LiteralCompartment;
import org.eclipse.papyrus.umldi.MainLabel;
import org.eclipse.papyrus.umldi.ManifestationEdge;
import org.eclipse.papyrus.umldi.MessageEdge;
import org.eclipse.papyrus.umldi.MessageLabel;
import org.eclipse.papyrus.umldi.ModelShape;
import org.eclipse.papyrus.umldi.MultiplicityLabel;
import org.eclipse.papyrus.umldi.NestedArtifactCompartment;
import org.eclipse.papyrus.umldi.NestedClassifierCompartment;
import org.eclipse.papyrus.umldi.NestedNodeCompartment;
import org.eclipse.papyrus.umldi.NodeShape;
import org.eclipse.papyrus.umldi.ObjectDiagram;
import org.eclipse.papyrus.umldi.ObjectFlowEdge;
import org.eclipse.papyrus.umldi.ObjectNodeShape;
import org.eclipse.papyrus.umldi.OpaqueBehaviorShape;
import org.eclipse.papyrus.umldi.OperationCompartment;
import org.eclipse.papyrus.umldi.OwnedBehaviorCompartment;
import org.eclipse.papyrus.umldi.OwnedUseCaseCompartment;
import org.eclipse.papyrus.umldi.PackageDiagram;
import org.eclipse.papyrus.umldi.PackageImportEdge;
import org.eclipse.papyrus.umldi.PackageMergeEdge;
import org.eclipse.papyrus.umldi.PackageShape;
import org.eclipse.papyrus.umldi.PackagedElementCompartment;
import org.eclipse.papyrus.umldi.ParameterCompartment;
import org.eclipse.papyrus.umldi.PathEdge;
import org.eclipse.papyrus.umldi.PinShape;
import org.eclipse.papyrus.umldi.Placement;
import org.eclipse.papyrus.umldi.PortShape;
import org.eclipse.papyrus.umldi.PostConditionCompartment;
import org.eclipse.papyrus.umldi.PowerLabel;
import org.eclipse.papyrus.umldi.PreConditionCompartment;
import org.eclipse.papyrus.umldi.PrimitiveTypeShape;
import org.eclipse.papyrus.umldi.ProfileApplicationEdge;
import org.eclipse.papyrus.umldi.ProfileDiagram;
import org.eclipse.papyrus.umldi.ProfileShape;
import org.eclipse.papyrus.umldi.PropertyEdge;
import org.eclipse.papyrus.umldi.PropertyShape;
import org.eclipse.papyrus.umldi.ProtocolStateMachineShape;
import org.eclipse.papyrus.umldi.PseudostateShape;
import org.eclipse.papyrus.umldi.RealizationEdge;
import org.eclipse.papyrus.umldi.ReceptionCompartment;
import org.eclipse.papyrus.umldi.RegionCompartment;
import org.eclipse.papyrus.umldi.RegionShape;
import org.eclipse.papyrus.umldi.RepresentationEdge;
import org.eclipse.papyrus.umldi.RoleLabel;
import org.eclipse.papyrus.umldi.SelectionLabel;
import org.eclipse.papyrus.umldi.SequenceDiagram;
import org.eclipse.papyrus.umldi.SignalShape;
import org.eclipse.papyrus.umldi.SlotCompartment;
import org.eclipse.papyrus.umldi.StateInvariantShape;
import org.eclipse.papyrus.umldi.StateMachineDiagram;
import org.eclipse.papyrus.umldi.StateMachineShape;
import org.eclipse.papyrus.umldi.StateShape;
import org.eclipse.papyrus.umldi.StereotypeCompartment;
import org.eclipse.papyrus.umldi.StereotypeLabel;
import org.eclipse.papyrus.umldi.StereotypeShape;
import org.eclipse.papyrus.umldi.StereotypedDiagramElement;
import org.eclipse.papyrus.umldi.StructureCompartment;
import org.eclipse.papyrus.umldi.StructureDiagram;
import org.eclipse.papyrus.umldi.StructuredActivityNodeShape;
import org.eclipse.papyrus.umldi.SubfragmentCompartment;
import org.eclipse.papyrus.umldi.SubpartitionCompartment;
import org.eclipse.papyrus.umldi.SubstitutionEdge;
import org.eclipse.papyrus.umldi.SubvertexCompartment;
import org.eclipse.papyrus.umldi.TemplateBindingEdge;
import org.eclipse.papyrus.umldi.TemplateParameterCompartment;
import org.eclipse.papyrus.umldi.TemplateableElementShape;
import org.eclipse.papyrus.umldi.TimeConstraintShape;
import org.eclipse.papyrus.umldi.TimeExpressionShape;
import org.eclipse.papyrus.umldi.TimeObservationShape;
import org.eclipse.papyrus.umldi.TimeObservationShape_TimeObservationShape;
import org.eclipse.papyrus.umldi.TimingDiagram;
import org.eclipse.papyrus.umldi.TopUmlDiagramElement;
import org.eclipse.papyrus.umldi.TransformationLabel;
import org.eclipse.papyrus.umldi.TransitionEdge;
import org.eclipse.papyrus.umldi.TypeLabel;
import org.eclipse.papyrus.umldi.UMLDIFactory;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlCompartment;
import org.eclipse.papyrus.umldi.UmlDiagram;
import org.eclipse.papyrus.umldi.UmlDiagramElement;
import org.eclipse.papyrus.umldi.UmlEdge;
import org.eclipse.papyrus.umldi.UmlLabel;
import org.eclipse.papyrus.umldi.UmlShape;
import org.eclipse.papyrus.umldi.UmlStyle;
import org.eclipse.papyrus.umldi.UsageEdge;
import org.eclipse.papyrus.umldi.UseCaseCompartment;
import org.eclipse.papyrus.umldi.UseCaseDiagram;
import org.eclipse.papyrus.umldi.UseCaseShape;
import org.eclipse.papyrus.umldi.WeightLabel;
import org.eclipse.papyrus.umldi.util.UMLDIValidator;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class UMLDIPackageImpl extends EPackageImpl implements UMLDIPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass umlDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass umlDiagramElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass umlStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass umlEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass topUmlDiagramElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stereotypedDiagramElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass diagramCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass umlCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass mainLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass umlLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass umlShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass classDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass structureDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass classifierShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass templateableElementShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass elementShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stereotypeCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass templateParameterCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass listCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass listItemLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stereotypeLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass ownedUseCaseCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass classifierCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass useCaseCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass packageShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass elementWithPackagedElementsShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass packagedElementCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass constraintShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass attributeCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass classifierWithAttributesShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass operationCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass classifierWithOperationsShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass receptionCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass classifierWithReceptionsShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass literalCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass enumerationShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass roleLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass associationEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass elementEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass multiplicityLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass propertyEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass constraintLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass generalizationSetEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass powerLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass objectNodeShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass activityNodeShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass selectionLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass objectFlowEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass activityEdgeEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass guardLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass weightLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass transformationLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass connectorEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass instanceSpecificationEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass dependencyEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass instanceSpecificationShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass deploymentTargetShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass deployedArtifactCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass slotCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass classShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass elementWithPortsShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass elementWithStructureShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass structureCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass portShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass classifierWithNestedClassifiersShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass nestedClassifierCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass behavioredClassifierShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass ownedBehaviorCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass interfaceShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass dataTypeShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass primitiveTypeShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass signalShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass modelShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass containmentEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass generalizationEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass realizationEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass abstractionEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass interfaceRealizationEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass usageEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass elementImportEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass packageImportEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass packageMergeEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass substitutionEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass informationFlowEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass conveyedLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass associationClassEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass commentShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass attachmentEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass associationClassShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass componentShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass informationItemShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass representationEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass associationShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass dependencyShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass timeObservationShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass timeObservationShape_TimeObservationShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass durationObservationShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass packageDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass profileDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass compositeStructureDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass deploymentDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass componentDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass objectDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass profileShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass profileApplicationEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass extensionEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass behaviorDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass useCaseDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass artifactShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass nestedArtifactCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass componentRealizationEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass manifestationEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass propertyShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass collaborationShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass collaborationUseShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass templateBindingEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stereotypeShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass nodeShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass nestedNodeCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass deviceShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass executionEnvironmentShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass activityShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass elementWithActivityNodesShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass activityNodeCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass parameterCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass postConditionCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass preConditionCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass activityParameterNodeShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass interactionShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass interactionFragmentWithSubfragmentsShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass interactionFragmentShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass subfragmentCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass interactionFragmentWithGatesShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass gateShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass opaqueBehaviorShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass functionBehaviorShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stateMachineShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass baseStateShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass pseudostateShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass regionCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass protocolStateMachineShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass deploymentSpecificationShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass communicationPathEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass deploymentEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass actorShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass extensionPointCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass useCaseShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass includeEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass extendEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stateMachineDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass activityDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass sequenceDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass interactionDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass communicationDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass timingDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass interactionOverviewDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass internalBehaviorCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stateShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass connectionPointReferenceShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass internalTransitionCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass deferrableTriggerCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass regionShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass subvertexCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass transitionEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass controlFlowEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass activityGroupShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass exceptionHandlerEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass typeLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass iconLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass actionShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass pinShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass subpartitionCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass activityPartitionShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass structuredActivityNodeShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass expansionRegionShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass expansionNodeShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass lifelineShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass executionSpecificationShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass durationConstraintShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass timeConstraintShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass timeExpressionShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass durationShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass pathEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass messageLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stateInvariantShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass messageEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass generalOrderingEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass combinedFragmentShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass interactionUseShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass interactionOperandShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum compartmentLayoutEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum placementEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UMLDIPackageImpl() {
		super(eNS_URI, UMLDIFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link UMLDIPackage#eINSTANCE} when that field is accessed. Clients should not invoke it directly. Instead,
	 * they should simply access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UMLDIPackage init() {
		if(isInited)
			return (UMLDIPackage)EPackage.Registry.INSTANCE.getEPackage(UMLDIPackage.eNS_URI);
		// Obtain or create and register package
		UMLDIPackageImpl theUMLDIPackage = (UMLDIPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UMLDIPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UMLDIPackageImpl());
		isInited = true;
		// Initialize simple dependencies
		DIPackage.eINSTANCE.eClass();
		UMLPackage.eINSTANCE.eClass();
		// Create package meta-data objects
		theUMLDIPackage.createPackageContents();
		// Initialize created meta-data
		theUMLDIPackage.initializePackageContents();
		// Register package validator
		EValidator.Registry.INSTANCE.put(theUMLDIPackage, new EValidator.Descriptor() {

			public EValidator getEValidator() {
				return UMLDIValidator.INSTANCE;
			}
		});
		// Mark meta-data to indicate it can't be changed
		theUMLDIPackage.freeze();
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UMLDIPackage.eNS_URI, theUMLDIPackage);
		return theUMLDIPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getUmlDiagram() {
		return umlDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUmlDiagram_TopUmlDiagramElement() {
		return (EReference)umlDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getUmlDiagramElement() {
		return umlDiagramElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUmlDiagramElement_UmlModelElement() {
		return (EReference)umlDiagramElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUmlDiagramElement_SharedUmlStyle() {
		return (EReference)umlDiagramElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUmlDiagramElement_LocalUmlStyle() {
		return (EReference)umlDiagramElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUmlDiagramElement_OwnedUmlDiagramElement() {
		return (EReference)umlDiagramElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUmlDiagramElement_OwningUmlDiagramElement() {
		return (EReference)umlDiagramElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUmlDiagramElement_TargetUmlEdge() {
		return (EReference)umlDiagramElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUmlDiagramElement_SourceUmlEdge() {
		return (EReference)umlDiagramElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getUmlStyle() {
		return umlStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getUmlStyle_FontName() {
		return (EAttribute)umlStyleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getUmlStyle_FontSize() {
		return (EAttribute)umlStyleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EOperation getUmlStyle__FontsizePositive__DiagnosticChain_Map() {
		return umlStyleEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getUmlEdge() {
		return umlEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUmlEdge_SourceUmlDiagramElement() {
		return (EReference)umlEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUmlEdge_TargetUmlDiagramElement() {
		return (EReference)umlEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTopUmlDiagramElement() {
		return topUmlDiagramElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTopUmlDiagramElement_UmlDiagram() {
		return (EReference)topUmlDiagramElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTopUmlDiagramElement_DiagramCompartment() {
		return (EReference)topUmlDiagramElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTopUmlDiagramElement_MainLabel() {
		return (EReference)topUmlDiagramElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStereotypedDiagramElement() {
		return stereotypedDiagramElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getStereotypedDiagramElement_ShowStereotypeAttributes() {
		return (EAttribute)stereotypedDiagramElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getStereotypedDiagramElement_StereotypeLabel() {
		return (EReference)stereotypedDiagramElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDiagramCompartment() {
		return diagramCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDiagramCompartment_TopUmlDiagramElement() {
		return (EReference)diagramCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getUmlCompartment() {
		return umlCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getMainLabel() {
		return mainLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getMainLabel_TopUmlDiagramElement() {
		return (EReference)mainLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getUmlLabel() {
		return umlLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getUmlShape() {
		return umlShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUmlShape_StereotypeCompartment() {
		return (EReference)umlShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getClassDiagram() {
		return classDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStructureDiagram() {
		return structureDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getClassifierShape() {
		return classifierShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getClassifierShape_UseClassifierNotation() {
		return (EAttribute)classifierShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getClassifierShape_OwnedUseCaseCompartment() {
		return (EReference)classifierShapeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getClassifierShape_UseCaseCompartment() {
		return (EReference)classifierShapeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTemplateableElementShape() {
		return templateableElementShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTemplateableElementShape_TemplateParameterCompartment() {
		return (EReference)templateableElementShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getElementShape() {
		return elementShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStereotypeCompartment() {
		return stereotypeCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getStereotypeCompartment_UmlShape() {
		return (EReference)stereotypeCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTemplateParameterCompartment() {
		return templateParameterCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTemplateParameterCompartment_TemplateableElementShape() {
		return (EReference)templateParameterCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getListCompartment() {
		return listCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getListCompartment_ListItemLabel() {
		return (EReference)listCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getListItemLabel() {
		return listItemLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getListItemLabel_ListCompartment() {
		return (EReference)listItemLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStereotypeLabel() {
		return stereotypeLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getStereotypeLabel_StereotypedDiagramElement() {
		return (EReference)stereotypeLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getOwnedUseCaseCompartment() {
		return ownedUseCaseCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOwnedUseCaseCompartment_ClassifierShape() {
		return (EReference)ownedUseCaseCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getClassifierCompartment() {
		return classifierCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getClassifierCompartment_Layout() {
		return (EAttribute)classifierCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getUseCaseCompartment() {
		return useCaseCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUseCaseCompartment_ClassifierShape() {
		return (EReference)useCaseCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPackageShape() {
		return packageShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getElementWithPackagedElementsShape() {
		return elementWithPackagedElementsShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getElementWithPackagedElementsShape_PackagedElementCompartment() {
		return (EReference)elementWithPackagedElementsShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPackagedElementCompartment() {
		return packagedElementCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPackagedElementCompartment_ElementWithPackagedElementsShape() {
		return (EReference)packagedElementCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getConstraintShape() {
		return constraintShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAttributeCompartment() {
		return attributeCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAttributeCompartment_ClassifierWithAttributesShape() {
		return (EReference)attributeCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getClassifierWithAttributesShape() {
		return classifierWithAttributesShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getClassifierWithAttributesShape_AttributeCompartment() {
		return (EReference)classifierWithAttributesShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getOperationCompartment() {
		return operationCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOperationCompartment_ClassifierWithOperationsShape() {
		return (EReference)operationCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getClassifierWithOperationsShape() {
		return classifierWithOperationsShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getClassifierWithOperationsShape_OperationCompartment() {
		return (EReference)classifierWithOperationsShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getReceptionCompartment() {
		return receptionCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getReceptionCompartment_ClassifierWithReceptionShape() {
		return (EReference)receptionCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getClassifierWithReceptionsShape() {
		return classifierWithReceptionsShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getClassifierWithReceptionsShape_ReceptionCompartment() {
		return (EReference)classifierWithReceptionsShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getLiteralCompartment() {
		return literalCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getLiteralCompartment_EnumerationShape() {
		return (EReference)literalCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEnumerationShape() {
		return enumerationShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEnumerationShape_LiteralCompartment() {
		return (EReference)enumerationShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getRoleLabel() {
		return roleLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getRoleLabel_AssociationEdge() {
		return (EReference)roleLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getRoleLabel_InstanceSpecificationEdge() {
		return (EReference)roleLabelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getRoleLabel_RoleBindingEdge() {
		return (EReference)roleLabelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAssociationEdge() {
		return associationEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAssociationEdge_EndMultiplicityLabel() {
		return (EReference)associationEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAssociationEdge_EndConstraintLabel() {
		return (EReference)associationEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAssociationEdge_EndRoleLabel() {
		return (EReference)associationEdgeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getElementEdge() {
		return elementEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getMultiplicityLabel() {
		return multiplicityLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getMultiplicityLabel_PropertyEdge() {
		return (EReference)multiplicityLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getMultiplicityLabel_ConnectorEdge() {
		return (EReference)multiplicityLabelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getMultiplicityLabel_AssociationEdge() {
		return (EReference)multiplicityLabelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPropertyEdge() {
		return propertyEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPropertyEdge_ConstraintLabel() {
		return (EReference)propertyEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPropertyEdge_MultiplicityLabel() {
		return (EReference)propertyEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getConstraintLabel() {
		return constraintLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintLabel_AssociationEdge() {
		return (EReference)constraintLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintLabel_GeneralizationSetEdge() {
		return (EReference)constraintLabelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintLabel_ObjectNodeShape() {
		return (EReference)constraintLabelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintLabel_LifelineShape() {
		return (EReference)constraintLabelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintLabel_ActionShape() {
		return (EReference)constraintLabelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintLabel_PropertyEdge() {
		return (EReference)constraintLabelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getGeneralizationSetEdge() {
		return generalizationSetEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getGeneralizationSetEdge_PowerLabel() {
		return (EReference)generalizationSetEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getGeneralizationSetEdge_ConstraintLabel() {
		return (EReference)generalizationSetEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPowerLabel() {
		return powerLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPowerLabel_GeneralizationSetEdge() {
		return (EReference)powerLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getObjectNodeShape() {
		return objectNodeShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getObjectNodeShape_SelectionLabel() {
		return (EReference)objectNodeShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getObjectNodeShape_ConstraintLabel() {
		return (EReference)objectNodeShapeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getActivityNodeShape() {
		return activityNodeShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSelectionLabel() {
		return selectionLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSelectionLabel_ObjectFlowEdge() {
		return (EReference)selectionLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSelectionLabel_ObjectNodeShape() {
		return (EReference)selectionLabelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getObjectFlowEdge() {
		return objectFlowEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getObjectFlowEdge_TransformationLabel() {
		return (EReference)objectFlowEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getObjectFlowEdge_SelectionLabel() {
		return (EReference)objectFlowEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getActivityEdgeEdge() {
		return activityEdgeEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getActivityEdgeEdge_GuardLabel() {
		return (EReference)activityEdgeEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getActivityEdgeEdge_WeightLabel() {
		return (EReference)activityEdgeEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getGuardLabel() {
		return guardLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getGuardLabel_ActivityEdgeEdge() {
		return (EReference)guardLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getWeightLabel() {
		return weightLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getWeightLabel_ActivityEdgeEdge() {
		return (EReference)weightLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTransformationLabel() {
		return transformationLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTransformationLabel_ObjectFlowEdge() {
		return (EReference)transformationLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getConnectorEdge() {
		return connectorEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConnectorEdge_EndMultiplicityLabel() {
		return (EReference)connectorEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getInstanceSpecificationEdge() {
		return instanceSpecificationEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getInstanceSpecificationEdge_EndRoleLabel() {
		return (EReference)instanceSpecificationEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDependencyEdge() {
		return dependencyEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDependencyEdge_RoleLabel() {
		return (EReference)dependencyEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getInstanceSpecificationShape() {
		return instanceSpecificationShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getInstanceSpecificationShape_SlotCompartment() {
		return (EReference)instanceSpecificationShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDeploymentTargetShape() {
		return deploymentTargetShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDeploymentTargetShape_DeployedArtifactCompartment() {
		return (EReference)deploymentTargetShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDeployedArtifactCompartment() {
		return deployedArtifactCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDeployedArtifactCompartment_DeploymentTargetShape() {
		return (EReference)deployedArtifactCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSlotCompartment() {
		return slotCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSlotCompartment_InstanceSpecificationShape() {
		return (EReference)slotCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getClassShape() {
		return classShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getElementWithPortsShape() {
		return elementWithPortsShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getElementWithPortsShape_PortShape() {
		return (EReference)elementWithPortsShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getElementWithStructureShape() {
		return elementWithStructureShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getElementWithStructureShape_StructureCompartment() {
		return (EReference)elementWithStructureShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStructureCompartment() {
		return structureCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getStructureCompartment_ElementWithStructureShape() {
		return (EReference)structureCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPortShape() {
		return portShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPortShape_ElementWithPortsShape() {
		return (EReference)portShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getClassifierWithNestedClassifiersShape() {
		return classifierWithNestedClassifiersShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getClassifierWithNestedClassifiersShape_NestedClassifierCompartment() {
		return (EReference)classifierWithNestedClassifiersShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getNestedClassifierCompartment() {
		return nestedClassifierCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getNestedClassifierCompartment_ClassifierWithNestedClassifiersShape() {
		return (EReference)nestedClassifierCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getBehavioredClassifierShape() {
		return behavioredClassifierShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getBehavioredClassifierShape_OwnedBehaviorCompartment() {
		return (EReference)behavioredClassifierShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getOwnedBehaviorCompartment() {
		return ownedBehaviorCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOwnedBehaviorCompartment_BehavioredClassifierShape() {
		return (EReference)ownedBehaviorCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getInterfaceShape() {
		return interfaceShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDataTypeShape() {
		return dataTypeShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPrimitiveTypeShape() {
		return primitiveTypeShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSignalShape() {
		return signalShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getModelShape() {
		return modelShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getContainmentEdge() {
		return containmentEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getGeneralizationEdge() {
		return generalizationEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getRealizationEdge() {
		return realizationEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAbstractionEdge() {
		return abstractionEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getInterfaceRealizationEdge() {
		return interfaceRealizationEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getUsageEdge() {
		return usageEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getElementImportEdge() {
		return elementImportEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPackageImportEdge() {
		return packageImportEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPackageMergeEdge() {
		return packageMergeEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSubstitutionEdge() {
		return substitutionEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getInformationFlowEdge() {
		return informationFlowEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getInformationFlowEdge_ConveyedLabel() {
		return (EReference)informationFlowEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getConveyedLabel() {
		return conveyedLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConveyedLabel_InformationFlowEdge() {
		return (EReference)conveyedLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAssociationClassEdge() {
		return associationClassEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCommentShape() {
		return commentShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAttachmentEdge() {
		return attachmentEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAssociationClassShape() {
		return associationClassShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getComponentShape() {
		return componentShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getInformationItemShape() {
		return informationItemShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getRepresentationEdge() {
		return representationEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAssociationShape() {
		return associationShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDependencyShape() {
		return dependencyShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTimeObservationShape() {
		return timeObservationShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTimeObservationShape_TimeObservationShape() {
		return timeObservationShape_TimeObservationShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDurationObservationShape() {
		return durationObservationShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPackageDiagram() {
		return packageDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getProfileDiagram() {
		return profileDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCompositeStructureDiagram() {
		return compositeStructureDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDeploymentDiagram() {
		return deploymentDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getComponentDiagram() {
		return componentDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getObjectDiagram() {
		return objectDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getProfileShape() {
		return profileShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getProfileApplicationEdge() {
		return profileApplicationEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getExtensionEdge() {
		return extensionEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getBehaviorDiagram() {
		return behaviorDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getUseCaseDiagram() {
		return useCaseDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getArtifactShape() {
		return artifactShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getArtifactShape_NestedArtifactCompartment() {
		return (EReference)artifactShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getNestedArtifactCompartment() {
		return nestedArtifactCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getNestedArtifactCompartment_ArtifactShape() {
		return (EReference)nestedArtifactCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getComponentRealizationEdge() {
		return componentRealizationEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getManifestationEdge() {
		return manifestationEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPropertyShape() {
		return propertyShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCollaborationShape() {
		return collaborationShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCollaborationShape_ReceptionCompartment() {
		return (EReference)collaborationShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCollaborationUseShape() {
		return collaborationUseShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTemplateBindingEdge() {
		return templateBindingEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStereotypeShape() {
		return stereotypeShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getNodeShape() {
		return nodeShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getNodeShape_NestedNodeCompartment() {
		return (EReference)nodeShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getNestedNodeCompartment() {
		return nestedNodeCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getNestedNodeCompartment_NodeShape() {
		return (EReference)nestedNodeCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDeviceShape() {
		return deviceShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getExecutionEnvironmentShape() {
		return executionEnvironmentShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getActivityShape() {
		return activityShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getActivityShape_ParameterCompartment() {
		return (EReference)activityShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getActivityShape_PostConditionCompartment() {
		return (EReference)activityShapeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getActivityShape_PreConditionCompartment() {
		return (EReference)activityShapeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getActivityShape_ActivityParameterNodeShape() {
		return (EReference)activityShapeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getElementWithActivityNodesShape() {
		return elementWithActivityNodesShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getElementWithActivityNodesShape_ActivityNodeCompartment() {
		return (EReference)elementWithActivityNodesShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getActivityNodeCompartment() {
		return activityNodeCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getActivityNodeCompartment_ElementWithActivityNodesShape() {
		return (EReference)activityNodeCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getParameterCompartment() {
		return parameterCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getParameterCompartment_ActivityShape() {
		return (EReference)parameterCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPostConditionCompartment() {
		return postConditionCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPostConditionCompartment_ActivityShape() {
		return (EReference)postConditionCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPreConditionCompartment() {
		return preConditionCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPreConditionCompartment_ActivityShape() {
		return (EReference)preConditionCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getActivityParameterNodeShape() {
		return activityParameterNodeShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getActivityParameterNodeShape_ActivityShape() {
		return (EReference)activityParameterNodeShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getInteractionShape() {
		return interactionShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getInteractionFragmentWithSubfragmentsShape() {
		return interactionFragmentWithSubfragmentsShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getInteractionFragmentWithSubfragmentsShape_SubfragmentCompartment() {
		return (EReference)interactionFragmentWithSubfragmentsShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getInteractionFragmentShape() {
		return interactionFragmentShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getInteractionFragmentShape_LifelineShape() {
		return (EReference)interactionFragmentShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSubfragmentCompartment() {
		return subfragmentCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSubfragmentCompartment_InteractionFragmentWithSubfragmentsShape() {
		return (EReference)subfragmentCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getInteractionFragmentWithGatesShape() {
		return interactionFragmentWithGatesShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getInteractionFragmentWithGatesShape_GateShape() {
		return (EReference)interactionFragmentWithGatesShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getGateShape() {
		return gateShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getGateShape_InteractionFragmentWithGatesShape() {
		return (EReference)gateShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getOpaqueBehaviorShape() {
		return opaqueBehaviorShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getFunctionBehaviorShape() {
		return functionBehaviorShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStateMachineShape() {
		return stateMachineShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getBaseStateShape() {
		return baseStateShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getBaseStateShape_ConnectionPointShape() {
		return (EReference)baseStateShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getBaseStateShape_RegionCompartment() {
		return (EReference)baseStateShapeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPseudostateShape() {
		return pseudostateShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPseudostateShape_BaseStateShape() {
		return (EReference)pseudostateShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getRegionCompartment() {
		return regionCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getRegionCompartment_BaseStateShape() {
		return (EReference)regionCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getProtocolStateMachineShape() {
		return protocolStateMachineShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDeploymentSpecificationShape() {
		return deploymentSpecificationShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCommunicationPathEdge() {
		return communicationPathEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDeploymentEdge() {
		return deploymentEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getActorShape() {
		return actorShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getExtensionPointCompartment() {
		return extensionPointCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getExtensionPointCompartment_UseCaseShape() {
		return (EReference)extensionPointCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getUseCaseShape() {
		return useCaseShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUseCaseShape_ExtensionPointCompartment() {
		return (EReference)useCaseShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getIncludeEdge() {
		return includeEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getExtendEdge() {
		return extendEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStateMachineDiagram() {
		return stateMachineDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getActivityDiagram() {
		return activityDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSequenceDiagram() {
		return sequenceDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getInteractionDiagram() {
		return interactionDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCommunicationDiagram() {
		return communicationDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTimingDiagram() {
		return timingDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getInteractionOverviewDiagram() {
		return interactionOverviewDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getInternalBehaviorCompartment() {
		return internalBehaviorCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getInternalBehaviorCompartment_StateShape() {
		return (EReference)internalBehaviorCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStateShape() {
		return stateShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getStateShape_ConnectionPointReferenceShape() {
		return (EReference)stateShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getStateShape_InternalTransitionCompartment() {
		return (EReference)stateShapeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getStateShape_DeferrableTriggerCompartment() {
		return (EReference)stateShapeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getStateShape_InternalBehaviorCompartment() {
		return (EReference)stateShapeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getConnectionPointReferenceShape() {
		return connectionPointReferenceShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConnectionPointReferenceShape_StateShape() {
		return (EReference)connectionPointReferenceShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getInternalTransitionCompartment() {
		return internalTransitionCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getInternalTransitionCompartment_StateShape() {
		return (EReference)internalTransitionCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDeferrableTriggerCompartment() {
		return deferrableTriggerCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDeferrableTriggerCompartment_StateShape() {
		return (EReference)deferrableTriggerCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getRegionShape() {
		return regionShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRegionShape_Placement() {
		return (EAttribute)regionShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getRegionShape_SubvertexCompartment() {
		return (EReference)regionShapeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSubvertexCompartment() {
		return subvertexCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSubvertexCompartment_RegionShape() {
		return (EReference)subvertexCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTransitionEdge() {
		return transitionEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getControlFlowEdge() {
		return controlFlowEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getActivityGroupShape() {
		return activityGroupShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getExceptionHandlerEdge() {
		return exceptionHandlerEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getExceptionHandlerEdge_TypeLabel() {
		return (EReference)exceptionHandlerEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getExceptionHandlerEdge_IconLabel() {
		return (EReference)exceptionHandlerEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTypeLabel() {
		return typeLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTypeLabel_InteractionUseShape() {
		return (EReference)typeLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTypeLabel_ExceptionHandlerEdge() {
		return (EReference)typeLabelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getIconLabel() {
		return iconLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIconLabel_ExceptionHandlerEdge() {
		return (EReference)iconLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getActionShape() {
		return actionShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getActionShape_PinShape() {
		return (EReference)actionShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getActionShape_ConditionLabel() {
		return (EReference)actionShapeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPinShape() {
		return pinShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPinShape_ActionShape() {
		return (EReference)pinShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSubpartitionCompartment() {
		return subpartitionCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSubpartitionCompartment_ActivityPartitionShape() {
		return (EReference)subpartitionCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getActivityPartitionShape() {
		return activityPartitionShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getActivityPartitionShape_IsVertical() {
		return (EAttribute)activityPartitionShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getActivityPartitionShape_SubpartitionCompartment() {
		return (EReference)activityPartitionShapeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStructuredActivityNodeShape() {
		return structuredActivityNodeShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getExpansionRegionShape() {
		return expansionRegionShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getExpansionRegionShape_ExpansionNodeShape() {
		return (EReference)expansionRegionShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getExpansionNodeShape() {
		return expansionNodeShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getExpansionNodeShape_ExpansionRegionShape() {
		return (EReference)expansionNodeShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getLifelineShape() {
		return lifelineShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getLifelineShape_SubfragmentShape() {
		return (EReference)lifelineShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getLifelineShape_NestingLifelineShape() {
		return (EReference)lifelineShapeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getLifelineShape_NestedLifelineShape() {
		return (EReference)lifelineShapeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getLifelineShape_ConstraintLabel() {
		return (EReference)lifelineShapeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getExecutionSpecificationShape() {
		return executionSpecificationShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDurationConstraintShape() {
		return durationConstraintShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTimeConstraintShape() {
		return timeConstraintShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTimeExpressionShape() {
		return timeExpressionShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDurationShape() {
		return durationShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPathEdge() {
		return pathEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPathEdge_MessageLabel() {
		return (EReference)pathEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getMessageLabel() {
		return messageLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getMessageLabel_PathEdge() {
		return (EReference)messageLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStateInvariantShape() {
		return stateInvariantShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getStateInvariantShape_UseStateShape() {
		return (EAttribute)stateInvariantShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getMessageEdge() {
		return messageEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getGeneralOrderingEdge() {
		return generalOrderingEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCombinedFragmentShape() {
		return combinedFragmentShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getInteractionUseShape() {
		return interactionUseShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getInteractionUseShape_TypeLabel() {
		return (EReference)interactionUseShapeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getInteractionOperandShape() {
		return interactionOperandShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getCompartmentLayout() {
		return compartmentLayoutEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getPlacement() {
		return placementEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UMLDIFactory getUMLDIFactory() {
		return (UMLDIFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if(isCreated)
			return;
		isCreated = true;
		// Create classes and their features
		umlDiagramEClass = createEClass(UML_DIAGRAM);
		createEReference(umlDiagramEClass, UML_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT);
		umlDiagramElementEClass = createEClass(UML_DIAGRAM_ELEMENT);
		createEReference(umlDiagramElementEClass, UML_DIAGRAM_ELEMENT__UML_MODEL_ELEMENT);
		createEReference(umlDiagramElementEClass, UML_DIAGRAM_ELEMENT__SHARED_UML_STYLE);
		createEReference(umlDiagramElementEClass, UML_DIAGRAM_ELEMENT__LOCAL_UML_STYLE);
		createEReference(umlDiagramElementEClass, UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
		createEReference(umlDiagramElementEClass, UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
		createEReference(umlDiagramElementEClass, UML_DIAGRAM_ELEMENT__TARGET_UML_EDGE);
		createEReference(umlDiagramElementEClass, UML_DIAGRAM_ELEMENT__SOURCE_UML_EDGE);
		umlStyleEClass = createEClass(UML_STYLE);
		createEAttribute(umlStyleEClass, UML_STYLE__FONT_NAME);
		createEAttribute(umlStyleEClass, UML_STYLE__FONT_SIZE);
		createEOperation(umlStyleEClass, UML_STYLE___FONTSIZE_POSITIVE__DIAGNOSTICCHAIN_MAP);
		umlEdgeEClass = createEClass(UML_EDGE);
		createEReference(umlEdgeEClass, UML_EDGE__SOURCE_UML_DIAGRAM_ELEMENT);
		createEReference(umlEdgeEClass, UML_EDGE__TARGET_UML_DIAGRAM_ELEMENT);
		topUmlDiagramElementEClass = createEClass(TOP_UML_DIAGRAM_ELEMENT);
		createEReference(topUmlDiagramElementEClass, TOP_UML_DIAGRAM_ELEMENT__UML_DIAGRAM);
		createEReference(topUmlDiagramElementEClass, TOP_UML_DIAGRAM_ELEMENT__DIAGRAM_COMPARTMENT);
		createEReference(topUmlDiagramElementEClass, TOP_UML_DIAGRAM_ELEMENT__MAIN_LABEL);
		stereotypedDiagramElementEClass = createEClass(STEREOTYPED_DIAGRAM_ELEMENT);
		createEAttribute(stereotypedDiagramElementEClass, STEREOTYPED_DIAGRAM_ELEMENT__SHOW_STEREOTYPE_ATTRIBUTES);
		createEReference(stereotypedDiagramElementEClass, STEREOTYPED_DIAGRAM_ELEMENT__STEREOTYPE_LABEL);
		stereotypeLabelEClass = createEClass(STEREOTYPE_LABEL);
		createEReference(stereotypeLabelEClass, STEREOTYPE_LABEL__STEREOTYPED_DIAGRAM_ELEMENT);
		umlLabelEClass = createEClass(UML_LABEL);
		diagramCompartmentEClass = createEClass(DIAGRAM_COMPARTMENT);
		createEReference(diagramCompartmentEClass, DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT);
		umlCompartmentEClass = createEClass(UML_COMPARTMENT);
		mainLabelEClass = createEClass(MAIN_LABEL);
		createEReference(mainLabelEClass, MAIN_LABEL__TOP_UML_DIAGRAM_ELEMENT);
		umlShapeEClass = createEClass(UML_SHAPE);
		createEReference(umlShapeEClass, UML_SHAPE__STEREOTYPE_COMPARTMENT);
		stereotypeCompartmentEClass = createEClass(STEREOTYPE_COMPARTMENT);
		createEReference(stereotypeCompartmentEClass, STEREOTYPE_COMPARTMENT__UML_SHAPE);
		listCompartmentEClass = createEClass(LIST_COMPARTMENT);
		createEReference(listCompartmentEClass, LIST_COMPARTMENT__LIST_ITEM_LABEL);
		listItemLabelEClass = createEClass(LIST_ITEM_LABEL);
		createEReference(listItemLabelEClass, LIST_ITEM_LABEL__LIST_COMPARTMENT);
		classDiagramEClass = createEClass(CLASS_DIAGRAM);
		structureDiagramEClass = createEClass(STRUCTURE_DIAGRAM);
		classifierShapeEClass = createEClass(CLASSIFIER_SHAPE);
		createEAttribute(classifierShapeEClass, CLASSIFIER_SHAPE__USE_CLASSIFIER_NOTATION);
		createEReference(classifierShapeEClass, CLASSIFIER_SHAPE__OWNED_USE_CASE_COMPARTMENT);
		createEReference(classifierShapeEClass, CLASSIFIER_SHAPE__USE_CASE_COMPARTMENT);
		templateableElementShapeEClass = createEClass(TEMPLATEABLE_ELEMENT_SHAPE);
		createEReference(templateableElementShapeEClass, TEMPLATEABLE_ELEMENT_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT);
		elementShapeEClass = createEClass(ELEMENT_SHAPE);
		templateParameterCompartmentEClass = createEClass(TEMPLATE_PARAMETER_COMPARTMENT);
		createEReference(templateParameterCompartmentEClass, TEMPLATE_PARAMETER_COMPARTMENT__TEMPLATEABLE_ELEMENT_SHAPE);
		ownedUseCaseCompartmentEClass = createEClass(OWNED_USE_CASE_COMPARTMENT);
		createEReference(ownedUseCaseCompartmentEClass, OWNED_USE_CASE_COMPARTMENT__CLASSIFIER_SHAPE);
		classifierCompartmentEClass = createEClass(CLASSIFIER_COMPARTMENT);
		createEAttribute(classifierCompartmentEClass, CLASSIFIER_COMPARTMENT__LAYOUT);
		useCaseCompartmentEClass = createEClass(USE_CASE_COMPARTMENT);
		createEReference(useCaseCompartmentEClass, USE_CASE_COMPARTMENT__CLASSIFIER_SHAPE);
		packageShapeEClass = createEClass(PACKAGE_SHAPE);
		elementWithPackagedElementsShapeEClass = createEClass(ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE);
		createEReference(elementWithPackagedElementsShapeEClass, ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE__PACKAGED_ELEMENT_COMPARTMENT);
		packagedElementCompartmentEClass = createEClass(PACKAGED_ELEMENT_COMPARTMENT);
		createEReference(packagedElementCompartmentEClass, PACKAGED_ELEMENT_COMPARTMENT__ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE);
		constraintShapeEClass = createEClass(CONSTRAINT_SHAPE);
		attributeCompartmentEClass = createEClass(ATTRIBUTE_COMPARTMENT);
		createEReference(attributeCompartmentEClass, ATTRIBUTE_COMPARTMENT__CLASSIFIER_WITH_ATTRIBUTES_SHAPE);
		classifierWithAttributesShapeEClass = createEClass(CLASSIFIER_WITH_ATTRIBUTES_SHAPE);
		createEReference(classifierWithAttributesShapeEClass, CLASSIFIER_WITH_ATTRIBUTES_SHAPE__ATTRIBUTE_COMPARTMENT);
		operationCompartmentEClass = createEClass(OPERATION_COMPARTMENT);
		createEReference(operationCompartmentEClass, OPERATION_COMPARTMENT__CLASSIFIER_WITH_OPERATIONS_SHAPE);
		classifierWithOperationsShapeEClass = createEClass(CLASSIFIER_WITH_OPERATIONS_SHAPE);
		createEReference(classifierWithOperationsShapeEClass, CLASSIFIER_WITH_OPERATIONS_SHAPE__OPERATION_COMPARTMENT);
		receptionCompartmentEClass = createEClass(RECEPTION_COMPARTMENT);
		createEReference(receptionCompartmentEClass, RECEPTION_COMPARTMENT__CLASSIFIER_WITH_RECEPTION_SHAPE);
		classifierWithReceptionsShapeEClass = createEClass(CLASSIFIER_WITH_RECEPTIONS_SHAPE);
		createEReference(classifierWithReceptionsShapeEClass, CLASSIFIER_WITH_RECEPTIONS_SHAPE__RECEPTION_COMPARTMENT);
		literalCompartmentEClass = createEClass(LITERAL_COMPARTMENT);
		createEReference(literalCompartmentEClass, LITERAL_COMPARTMENT__ENUMERATION_SHAPE);
		enumerationShapeEClass = createEClass(ENUMERATION_SHAPE);
		createEReference(enumerationShapeEClass, ENUMERATION_SHAPE__LITERAL_COMPARTMENT);
		roleLabelEClass = createEClass(ROLE_LABEL);
		createEReference(roleLabelEClass, ROLE_LABEL__ASSOCIATION_EDGE);
		createEReference(roleLabelEClass, ROLE_LABEL__INSTANCE_SPECIFICATION_EDGE);
		createEReference(roleLabelEClass, ROLE_LABEL__ROLE_BINDING_EDGE);
		associationEdgeEClass = createEClass(ASSOCIATION_EDGE);
		createEReference(associationEdgeEClass, ASSOCIATION_EDGE__END_MULTIPLICITY_LABEL);
		createEReference(associationEdgeEClass, ASSOCIATION_EDGE__END_CONSTRAINT_LABEL);
		createEReference(associationEdgeEClass, ASSOCIATION_EDGE__END_ROLE_LABEL);
		elementEdgeEClass = createEClass(ELEMENT_EDGE);
		multiplicityLabelEClass = createEClass(MULTIPLICITY_LABEL);
		createEReference(multiplicityLabelEClass, MULTIPLICITY_LABEL__PROPERTY_EDGE);
		createEReference(multiplicityLabelEClass, MULTIPLICITY_LABEL__CONNECTOR_EDGE);
		createEReference(multiplicityLabelEClass, MULTIPLICITY_LABEL__ASSOCIATION_EDGE);
		propertyEdgeEClass = createEClass(PROPERTY_EDGE);
		createEReference(propertyEdgeEClass, PROPERTY_EDGE__CONSTRAINT_LABEL);
		createEReference(propertyEdgeEClass, PROPERTY_EDGE__MULTIPLICITY_LABEL);
		constraintLabelEClass = createEClass(CONSTRAINT_LABEL);
		createEReference(constraintLabelEClass, CONSTRAINT_LABEL__ASSOCIATION_EDGE);
		createEReference(constraintLabelEClass, CONSTRAINT_LABEL__GENERALIZATION_SET_EDGE);
		createEReference(constraintLabelEClass, CONSTRAINT_LABEL__OBJECT_NODE_SHAPE);
		createEReference(constraintLabelEClass, CONSTRAINT_LABEL__LIFELINE_SHAPE);
		createEReference(constraintLabelEClass, CONSTRAINT_LABEL__ACTION_SHAPE);
		createEReference(constraintLabelEClass, CONSTRAINT_LABEL__PROPERTY_EDGE);
		generalizationSetEdgeEClass = createEClass(GENERALIZATION_SET_EDGE);
		createEReference(generalizationSetEdgeEClass, GENERALIZATION_SET_EDGE__POWER_LABEL);
		createEReference(generalizationSetEdgeEClass, GENERALIZATION_SET_EDGE__CONSTRAINT_LABEL);
		powerLabelEClass = createEClass(POWER_LABEL);
		createEReference(powerLabelEClass, POWER_LABEL__GENERALIZATION_SET_EDGE);
		objectNodeShapeEClass = createEClass(OBJECT_NODE_SHAPE);
		createEReference(objectNodeShapeEClass, OBJECT_NODE_SHAPE__SELECTION_LABEL);
		createEReference(objectNodeShapeEClass, OBJECT_NODE_SHAPE__CONSTRAINT_LABEL);
		activityNodeShapeEClass = createEClass(ACTIVITY_NODE_SHAPE);
		selectionLabelEClass = createEClass(SELECTION_LABEL);
		createEReference(selectionLabelEClass, SELECTION_LABEL__OBJECT_FLOW_EDGE);
		createEReference(selectionLabelEClass, SELECTION_LABEL__OBJECT_NODE_SHAPE);
		objectFlowEdgeEClass = createEClass(OBJECT_FLOW_EDGE);
		createEReference(objectFlowEdgeEClass, OBJECT_FLOW_EDGE__TRANSFORMATION_LABEL);
		createEReference(objectFlowEdgeEClass, OBJECT_FLOW_EDGE__SELECTION_LABEL);
		activityEdgeEdgeEClass = createEClass(ACTIVITY_EDGE_EDGE);
		createEReference(activityEdgeEdgeEClass, ACTIVITY_EDGE_EDGE__GUARD_LABEL);
		createEReference(activityEdgeEdgeEClass, ACTIVITY_EDGE_EDGE__WEIGHT_LABEL);
		guardLabelEClass = createEClass(GUARD_LABEL);
		createEReference(guardLabelEClass, GUARD_LABEL__ACTIVITY_EDGE_EDGE);
		weightLabelEClass = createEClass(WEIGHT_LABEL);
		createEReference(weightLabelEClass, WEIGHT_LABEL__ACTIVITY_EDGE_EDGE);
		transformationLabelEClass = createEClass(TRANSFORMATION_LABEL);
		createEReference(transformationLabelEClass, TRANSFORMATION_LABEL__OBJECT_FLOW_EDGE);
		lifelineShapeEClass = createEClass(LIFELINE_SHAPE);
		createEReference(lifelineShapeEClass, LIFELINE_SHAPE__SUBFRAGMENT_SHAPE);
		createEReference(lifelineShapeEClass, LIFELINE_SHAPE__NESTING_LIFELINE_SHAPE);
		createEReference(lifelineShapeEClass, LIFELINE_SHAPE__NESTED_LIFELINE_SHAPE);
		createEReference(lifelineShapeEClass, LIFELINE_SHAPE__CONSTRAINT_LABEL);
		interactionFragmentShapeEClass = createEClass(INTERACTION_FRAGMENT_SHAPE);
		createEReference(interactionFragmentShapeEClass, INTERACTION_FRAGMENT_SHAPE__LIFELINE_SHAPE);
		actionShapeEClass = createEClass(ACTION_SHAPE);
		createEReference(actionShapeEClass, ACTION_SHAPE__PIN_SHAPE);
		createEReference(actionShapeEClass, ACTION_SHAPE__CONDITION_LABEL);
		pinShapeEClass = createEClass(PIN_SHAPE);
		createEReference(pinShapeEClass, PIN_SHAPE__ACTION_SHAPE);
		connectorEdgeEClass = createEClass(CONNECTOR_EDGE);
		createEReference(connectorEdgeEClass, CONNECTOR_EDGE__END_MULTIPLICITY_LABEL);
		instanceSpecificationEdgeEClass = createEClass(INSTANCE_SPECIFICATION_EDGE);
		createEReference(instanceSpecificationEdgeEClass, INSTANCE_SPECIFICATION_EDGE__END_ROLE_LABEL);
		dependencyEdgeEClass = createEClass(DEPENDENCY_EDGE);
		createEReference(dependencyEdgeEClass, DEPENDENCY_EDGE__ROLE_LABEL);
		instanceSpecificationShapeEClass = createEClass(INSTANCE_SPECIFICATION_SHAPE);
		createEReference(instanceSpecificationShapeEClass, INSTANCE_SPECIFICATION_SHAPE__SLOT_COMPARTMENT);
		deploymentTargetShapeEClass = createEClass(DEPLOYMENT_TARGET_SHAPE);
		createEReference(deploymentTargetShapeEClass, DEPLOYMENT_TARGET_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT);
		deployedArtifactCompartmentEClass = createEClass(DEPLOYED_ARTIFACT_COMPARTMENT);
		createEReference(deployedArtifactCompartmentEClass, DEPLOYED_ARTIFACT_COMPARTMENT__DEPLOYMENT_TARGET_SHAPE);
		slotCompartmentEClass = createEClass(SLOT_COMPARTMENT);
		createEReference(slotCompartmentEClass, SLOT_COMPARTMENT__INSTANCE_SPECIFICATION_SHAPE);
		classShapeEClass = createEClass(CLASS_SHAPE);
		elementWithPortsShapeEClass = createEClass(ELEMENT_WITH_PORTS_SHAPE);
		createEReference(elementWithPortsShapeEClass, ELEMENT_WITH_PORTS_SHAPE__PORT_SHAPE);
		elementWithStructureShapeEClass = createEClass(ELEMENT_WITH_STRUCTURE_SHAPE);
		createEReference(elementWithStructureShapeEClass, ELEMENT_WITH_STRUCTURE_SHAPE__STRUCTURE_COMPARTMENT);
		structureCompartmentEClass = createEClass(STRUCTURE_COMPARTMENT);
		createEReference(structureCompartmentEClass, STRUCTURE_COMPARTMENT__ELEMENT_WITH_STRUCTURE_SHAPE);
		portShapeEClass = createEClass(PORT_SHAPE);
		createEReference(portShapeEClass, PORT_SHAPE__ELEMENT_WITH_PORTS_SHAPE);
		classifierWithNestedClassifiersShapeEClass = createEClass(CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE);
		createEReference(classifierWithNestedClassifiersShapeEClass, CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE__NESTED_CLASSIFIER_COMPARTMENT);
		nestedClassifierCompartmentEClass = createEClass(NESTED_CLASSIFIER_COMPARTMENT);
		createEReference(nestedClassifierCompartmentEClass, NESTED_CLASSIFIER_COMPARTMENT__CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE);
		behavioredClassifierShapeEClass = createEClass(BEHAVIORED_CLASSIFIER_SHAPE);
		createEReference(behavioredClassifierShapeEClass, BEHAVIORED_CLASSIFIER_SHAPE__OWNED_BEHAVIOR_COMPARTMENT);
		ownedBehaviorCompartmentEClass = createEClass(OWNED_BEHAVIOR_COMPARTMENT);
		createEReference(ownedBehaviorCompartmentEClass, OWNED_BEHAVIOR_COMPARTMENT__BEHAVIORED_CLASSIFIER_SHAPE);
		interfaceShapeEClass = createEClass(INTERFACE_SHAPE);
		dataTypeShapeEClass = createEClass(DATA_TYPE_SHAPE);
		primitiveTypeShapeEClass = createEClass(PRIMITIVE_TYPE_SHAPE);
		signalShapeEClass = createEClass(SIGNAL_SHAPE);
		modelShapeEClass = createEClass(MODEL_SHAPE);
		containmentEdgeEClass = createEClass(CONTAINMENT_EDGE);
		generalizationEdgeEClass = createEClass(GENERALIZATION_EDGE);
		realizationEdgeEClass = createEClass(REALIZATION_EDGE);
		abstractionEdgeEClass = createEClass(ABSTRACTION_EDGE);
		interfaceRealizationEdgeEClass = createEClass(INTERFACE_REALIZATION_EDGE);
		usageEdgeEClass = createEClass(USAGE_EDGE);
		elementImportEdgeEClass = createEClass(ELEMENT_IMPORT_EDGE);
		packageImportEdgeEClass = createEClass(PACKAGE_IMPORT_EDGE);
		packageMergeEdgeEClass = createEClass(PACKAGE_MERGE_EDGE);
		substitutionEdgeEClass = createEClass(SUBSTITUTION_EDGE);
		informationFlowEdgeEClass = createEClass(INFORMATION_FLOW_EDGE);
		createEReference(informationFlowEdgeEClass, INFORMATION_FLOW_EDGE__CONVEYED_LABEL);
		conveyedLabelEClass = createEClass(CONVEYED_LABEL);
		createEReference(conveyedLabelEClass, CONVEYED_LABEL__INFORMATION_FLOW_EDGE);
		associationClassEdgeEClass = createEClass(ASSOCIATION_CLASS_EDGE);
		commentShapeEClass = createEClass(COMMENT_SHAPE);
		attachmentEdgeEClass = createEClass(ATTACHMENT_EDGE);
		associationClassShapeEClass = createEClass(ASSOCIATION_CLASS_SHAPE);
		componentShapeEClass = createEClass(COMPONENT_SHAPE);
		informationItemShapeEClass = createEClass(INFORMATION_ITEM_SHAPE);
		representationEdgeEClass = createEClass(REPRESENTATION_EDGE);
		associationShapeEClass = createEClass(ASSOCIATION_SHAPE);
		dependencyShapeEClass = createEClass(DEPENDENCY_SHAPE);
		timeObservationShapeEClass = createEClass(TIME_OBSERVATION_SHAPE);
		timeObservationShape_TimeObservationShapeEClass = createEClass(TIME_OBSERVATION_SHAPE_TIME_OBSERVATION_SHAPE);
		durationObservationShapeEClass = createEClass(DURATION_OBSERVATION_SHAPE);
		packageDiagramEClass = createEClass(PACKAGE_DIAGRAM);
		profileDiagramEClass = createEClass(PROFILE_DIAGRAM);
		compositeStructureDiagramEClass = createEClass(COMPOSITE_STRUCTURE_DIAGRAM);
		deploymentDiagramEClass = createEClass(DEPLOYMENT_DIAGRAM);
		componentDiagramEClass = createEClass(COMPONENT_DIAGRAM);
		objectDiagramEClass = createEClass(OBJECT_DIAGRAM);
		profileShapeEClass = createEClass(PROFILE_SHAPE);
		profileApplicationEdgeEClass = createEClass(PROFILE_APPLICATION_EDGE);
		extensionEdgeEClass = createEClass(EXTENSION_EDGE);
		behaviorDiagramEClass = createEClass(BEHAVIOR_DIAGRAM);
		useCaseDiagramEClass = createEClass(USE_CASE_DIAGRAM);
		artifactShapeEClass = createEClass(ARTIFACT_SHAPE);
		createEReference(artifactShapeEClass, ARTIFACT_SHAPE__NESTED_ARTIFACT_COMPARTMENT);
		nestedArtifactCompartmentEClass = createEClass(NESTED_ARTIFACT_COMPARTMENT);
		createEReference(nestedArtifactCompartmentEClass, NESTED_ARTIFACT_COMPARTMENT__ARTIFACT_SHAPE);
		componentRealizationEdgeEClass = createEClass(COMPONENT_REALIZATION_EDGE);
		manifestationEdgeEClass = createEClass(MANIFESTATION_EDGE);
		propertyShapeEClass = createEClass(PROPERTY_SHAPE);
		collaborationShapeEClass = createEClass(COLLABORATION_SHAPE);
		createEReference(collaborationShapeEClass, COLLABORATION_SHAPE__RECEPTION_COMPARTMENT);
		collaborationUseShapeEClass = createEClass(COLLABORATION_USE_SHAPE);
		templateBindingEdgeEClass = createEClass(TEMPLATE_BINDING_EDGE);
		stereotypeShapeEClass = createEClass(STEREOTYPE_SHAPE);
		nodeShapeEClass = createEClass(NODE_SHAPE);
		createEReference(nodeShapeEClass, NODE_SHAPE__NESTED_NODE_COMPARTMENT);
		nestedNodeCompartmentEClass = createEClass(NESTED_NODE_COMPARTMENT);
		createEReference(nestedNodeCompartmentEClass, NESTED_NODE_COMPARTMENT__NODE_SHAPE);
		deviceShapeEClass = createEClass(DEVICE_SHAPE);
		executionEnvironmentShapeEClass = createEClass(EXECUTION_ENVIRONMENT_SHAPE);
		activityShapeEClass = createEClass(ACTIVITY_SHAPE);
		createEReference(activityShapeEClass, ACTIVITY_SHAPE__PARAMETER_COMPARTMENT);
		createEReference(activityShapeEClass, ACTIVITY_SHAPE__POST_CONDITION_COMPARTMENT);
		createEReference(activityShapeEClass, ACTIVITY_SHAPE__PRE_CONDITION_COMPARTMENT);
		createEReference(activityShapeEClass, ACTIVITY_SHAPE__ACTIVITY_PARAMETER_NODE_SHAPE);
		elementWithActivityNodesShapeEClass = createEClass(ELEMENT_WITH_ACTIVITY_NODES_SHAPE);
		createEReference(elementWithActivityNodesShapeEClass, ELEMENT_WITH_ACTIVITY_NODES_SHAPE__ACTIVITY_NODE_COMPARTMENT);
		activityNodeCompartmentEClass = createEClass(ACTIVITY_NODE_COMPARTMENT);
		createEReference(activityNodeCompartmentEClass, ACTIVITY_NODE_COMPARTMENT__ELEMENT_WITH_ACTIVITY_NODES_SHAPE);
		parameterCompartmentEClass = createEClass(PARAMETER_COMPARTMENT);
		createEReference(parameterCompartmentEClass, PARAMETER_COMPARTMENT__ACTIVITY_SHAPE);
		postConditionCompartmentEClass = createEClass(POST_CONDITION_COMPARTMENT);
		createEReference(postConditionCompartmentEClass, POST_CONDITION_COMPARTMENT__ACTIVITY_SHAPE);
		preConditionCompartmentEClass = createEClass(PRE_CONDITION_COMPARTMENT);
		createEReference(preConditionCompartmentEClass, PRE_CONDITION_COMPARTMENT__ACTIVITY_SHAPE);
		activityParameterNodeShapeEClass = createEClass(ACTIVITY_PARAMETER_NODE_SHAPE);
		createEReference(activityParameterNodeShapeEClass, ACTIVITY_PARAMETER_NODE_SHAPE__ACTIVITY_SHAPE);
		interactionShapeEClass = createEClass(INTERACTION_SHAPE);
		interactionFragmentWithSubfragmentsShapeEClass = createEClass(INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE);
		createEReference(interactionFragmentWithSubfragmentsShapeEClass, INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE__SUBFRAGMENT_COMPARTMENT);
		subfragmentCompartmentEClass = createEClass(SUBFRAGMENT_COMPARTMENT);
		createEReference(subfragmentCompartmentEClass, SUBFRAGMENT_COMPARTMENT__INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE);
		interactionFragmentWithGatesShapeEClass = createEClass(INTERACTION_FRAGMENT_WITH_GATES_SHAPE);
		createEReference(interactionFragmentWithGatesShapeEClass, INTERACTION_FRAGMENT_WITH_GATES_SHAPE__GATE_SHAPE);
		gateShapeEClass = createEClass(GATE_SHAPE);
		createEReference(gateShapeEClass, GATE_SHAPE__INTERACTION_FRAGMENT_WITH_GATES_SHAPE);
		opaqueBehaviorShapeEClass = createEClass(OPAQUE_BEHAVIOR_SHAPE);
		functionBehaviorShapeEClass = createEClass(FUNCTION_BEHAVIOR_SHAPE);
		stateMachineShapeEClass = createEClass(STATE_MACHINE_SHAPE);
		baseStateShapeEClass = createEClass(BASE_STATE_SHAPE);
		createEReference(baseStateShapeEClass, BASE_STATE_SHAPE__CONNECTION_POINT_SHAPE);
		createEReference(baseStateShapeEClass, BASE_STATE_SHAPE__REGION_COMPARTMENT);
		pseudostateShapeEClass = createEClass(PSEUDOSTATE_SHAPE);
		createEReference(pseudostateShapeEClass, PSEUDOSTATE_SHAPE__BASE_STATE_SHAPE);
		regionCompartmentEClass = createEClass(REGION_COMPARTMENT);
		createEReference(regionCompartmentEClass, REGION_COMPARTMENT__BASE_STATE_SHAPE);
		protocolStateMachineShapeEClass = createEClass(PROTOCOL_STATE_MACHINE_SHAPE);
		deploymentSpecificationShapeEClass = createEClass(DEPLOYMENT_SPECIFICATION_SHAPE);
		communicationPathEdgeEClass = createEClass(COMMUNICATION_PATH_EDGE);
		deploymentEdgeEClass = createEClass(DEPLOYMENT_EDGE);
		actorShapeEClass = createEClass(ACTOR_SHAPE);
		extensionPointCompartmentEClass = createEClass(EXTENSION_POINT_COMPARTMENT);
		createEReference(extensionPointCompartmentEClass, EXTENSION_POINT_COMPARTMENT__USE_CASE_SHAPE);
		useCaseShapeEClass = createEClass(USE_CASE_SHAPE);
		createEReference(useCaseShapeEClass, USE_CASE_SHAPE__EXTENSION_POINT_COMPARTMENT);
		includeEdgeEClass = createEClass(INCLUDE_EDGE);
		extendEdgeEClass = createEClass(EXTEND_EDGE);
		stateMachineDiagramEClass = createEClass(STATE_MACHINE_DIAGRAM);
		activityDiagramEClass = createEClass(ACTIVITY_DIAGRAM);
		sequenceDiagramEClass = createEClass(SEQUENCE_DIAGRAM);
		interactionDiagramEClass = createEClass(INTERACTION_DIAGRAM);
		communicationDiagramEClass = createEClass(COMMUNICATION_DIAGRAM);
		timingDiagramEClass = createEClass(TIMING_DIAGRAM);
		interactionOverviewDiagramEClass = createEClass(INTERACTION_OVERVIEW_DIAGRAM);
		internalBehaviorCompartmentEClass = createEClass(INTERNAL_BEHAVIOR_COMPARTMENT);
		createEReference(internalBehaviorCompartmentEClass, INTERNAL_BEHAVIOR_COMPARTMENT__STATE_SHAPE);
		stateShapeEClass = createEClass(STATE_SHAPE);
		createEReference(stateShapeEClass, STATE_SHAPE__CONNECTION_POINT_REFERENCE_SHAPE);
		createEReference(stateShapeEClass, STATE_SHAPE__INTERNAL_TRANSITION_COMPARTMENT);
		createEReference(stateShapeEClass, STATE_SHAPE__DEFERRABLE_TRIGGER_COMPARTMENT);
		createEReference(stateShapeEClass, STATE_SHAPE__INTERNAL_BEHAVIOR_COMPARTMENT);
		connectionPointReferenceShapeEClass = createEClass(CONNECTION_POINT_REFERENCE_SHAPE);
		createEReference(connectionPointReferenceShapeEClass, CONNECTION_POINT_REFERENCE_SHAPE__STATE_SHAPE);
		internalTransitionCompartmentEClass = createEClass(INTERNAL_TRANSITION_COMPARTMENT);
		createEReference(internalTransitionCompartmentEClass, INTERNAL_TRANSITION_COMPARTMENT__STATE_SHAPE);
		deferrableTriggerCompartmentEClass = createEClass(DEFERRABLE_TRIGGER_COMPARTMENT);
		createEReference(deferrableTriggerCompartmentEClass, DEFERRABLE_TRIGGER_COMPARTMENT__STATE_SHAPE);
		regionShapeEClass = createEClass(REGION_SHAPE);
		createEAttribute(regionShapeEClass, REGION_SHAPE__PLACEMENT);
		createEReference(regionShapeEClass, REGION_SHAPE__SUBVERTEX_COMPARTMENT);
		subvertexCompartmentEClass = createEClass(SUBVERTEX_COMPARTMENT);
		createEReference(subvertexCompartmentEClass, SUBVERTEX_COMPARTMENT__REGION_SHAPE);
		transitionEdgeEClass = createEClass(TRANSITION_EDGE);
		controlFlowEdgeEClass = createEClass(CONTROL_FLOW_EDGE);
		activityGroupShapeEClass = createEClass(ACTIVITY_GROUP_SHAPE);
		exceptionHandlerEdgeEClass = createEClass(EXCEPTION_HANDLER_EDGE);
		createEReference(exceptionHandlerEdgeEClass, EXCEPTION_HANDLER_EDGE__TYPE_LABEL);
		createEReference(exceptionHandlerEdgeEClass, EXCEPTION_HANDLER_EDGE__ICON_LABEL);
		typeLabelEClass = createEClass(TYPE_LABEL);
		createEReference(typeLabelEClass, TYPE_LABEL__INTERACTION_USE_SHAPE);
		createEReference(typeLabelEClass, TYPE_LABEL__EXCEPTION_HANDLER_EDGE);
		interactionUseShapeEClass = createEClass(INTERACTION_USE_SHAPE);
		createEReference(interactionUseShapeEClass, INTERACTION_USE_SHAPE__TYPE_LABEL);
		iconLabelEClass = createEClass(ICON_LABEL);
		createEReference(iconLabelEClass, ICON_LABEL__EXCEPTION_HANDLER_EDGE);
		subpartitionCompartmentEClass = createEClass(SUBPARTITION_COMPARTMENT);
		createEReference(subpartitionCompartmentEClass, SUBPARTITION_COMPARTMENT__ACTIVITY_PARTITION_SHAPE);
		activityPartitionShapeEClass = createEClass(ACTIVITY_PARTITION_SHAPE);
		createEAttribute(activityPartitionShapeEClass, ACTIVITY_PARTITION_SHAPE__IS_VERTICAL);
		createEReference(activityPartitionShapeEClass, ACTIVITY_PARTITION_SHAPE__SUBPARTITION_COMPARTMENT);
		structuredActivityNodeShapeEClass = createEClass(STRUCTURED_ACTIVITY_NODE_SHAPE);
		expansionRegionShapeEClass = createEClass(EXPANSION_REGION_SHAPE);
		createEReference(expansionRegionShapeEClass, EXPANSION_REGION_SHAPE__EXPANSION_NODE_SHAPE);
		expansionNodeShapeEClass = createEClass(EXPANSION_NODE_SHAPE);
		createEReference(expansionNodeShapeEClass, EXPANSION_NODE_SHAPE__EXPANSION_REGION_SHAPE);
		messageEdgeEClass = createEClass(MESSAGE_EDGE);
		generalOrderingEdgeEClass = createEClass(GENERAL_ORDERING_EDGE);
		combinedFragmentShapeEClass = createEClass(COMBINED_FRAGMENT_SHAPE);
		interactionOperandShapeEClass = createEClass(INTERACTION_OPERAND_SHAPE);
		executionSpecificationShapeEClass = createEClass(EXECUTION_SPECIFICATION_SHAPE);
		durationConstraintShapeEClass = createEClass(DURATION_CONSTRAINT_SHAPE);
		timeConstraintShapeEClass = createEClass(TIME_CONSTRAINT_SHAPE);
		timeExpressionShapeEClass = createEClass(TIME_EXPRESSION_SHAPE);
		durationShapeEClass = createEClass(DURATION_SHAPE);
		pathEdgeEClass = createEClass(PATH_EDGE);
		createEReference(pathEdgeEClass, PATH_EDGE__MESSAGE_LABEL);
		messageLabelEClass = createEClass(MESSAGE_LABEL);
		createEReference(messageLabelEClass, MESSAGE_LABEL__PATH_EDGE);
		stateInvariantShapeEClass = createEClass(STATE_INVARIANT_SHAPE);
		createEAttribute(stateInvariantShapeEClass, STATE_INVARIANT_SHAPE__USE_STATE_SHAPE);
		// Create enums
		compartmentLayoutEEnum = createEEnum(COMPARTMENT_LAYOUT);
		placementEEnum = createEEnum(PLACEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if(isInitialized)
			return;
		isInitialized = true;
		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);
		// Obtain other dependent packages
		DIPackage theDIPackage = (DIPackage)EPackage.Registry.INSTANCE.getEPackage(DIPackage.eNS_URI);
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);
		DCPackage theDCPackage = (DCPackage)EPackage.Registry.INSTANCE.getEPackage(DCPackage.eNS_URI);
		// Create type parameters
		// Set bounds for type parameters
		// Add supertypes to classes
		umlDiagramEClass.getESuperTypes().add(this.getUmlDiagramElement());
		umlDiagramEClass.getESuperTypes().add(theDIPackage.getDiagram());
		umlDiagramElementEClass.getESuperTypes().add(theDIPackage.getDiagramElement());
		umlStyleEClass.getESuperTypes().add(theDIPackage.getStyle());
		umlEdgeEClass.getESuperTypes().add(this.getTopUmlDiagramElement());
		umlEdgeEClass.getESuperTypes().add(theDIPackage.getEdge());
		topUmlDiagramElementEClass.getESuperTypes().add(this.getStereotypedDiagramElement());
		stereotypedDiagramElementEClass.getESuperTypes().add(this.getUmlDiagramElement());
		stereotypeLabelEClass.getESuperTypes().add(this.getUmlLabel());
		umlLabelEClass.getESuperTypes().add(this.getUmlDiagramElement());
		umlLabelEClass.getESuperTypes().add(theDIPackage.getShape());
		diagramCompartmentEClass.getESuperTypes().add(this.getUmlCompartment());
		umlCompartmentEClass.getESuperTypes().add(this.getUmlDiagramElement());
		umlCompartmentEClass.getESuperTypes().add(theDIPackage.getShape());
		mainLabelEClass.getESuperTypes().add(this.getUmlLabel());
		umlShapeEClass.getESuperTypes().add(this.getTopUmlDiagramElement());
		umlShapeEClass.getESuperTypes().add(theDIPackage.getShape());
		stereotypeCompartmentEClass.getESuperTypes().add(this.getListCompartment());
		listCompartmentEClass.getESuperTypes().add(this.getUmlCompartment());
		listItemLabelEClass.getESuperTypes().add(this.getStereotypedDiagramElement());
		listItemLabelEClass.getESuperTypes().add(this.getUmlLabel());
		classDiagramEClass.getESuperTypes().add(this.getStructureDiagram());
		structureDiagramEClass.getESuperTypes().add(this.getUmlDiagram());
		classifierShapeEClass.getESuperTypes().add(this.getTemplateableElementShape());
		templateableElementShapeEClass.getESuperTypes().add(this.getElementShape());
		elementShapeEClass.getESuperTypes().add(this.getUmlShape());
		templateParameterCompartmentEClass.getESuperTypes().add(this.getListCompartment());
		ownedUseCaseCompartmentEClass.getESuperTypes().add(this.getClassifierCompartment());
		classifierCompartmentEClass.getESuperTypes().add(this.getDiagramCompartment());
		classifierCompartmentEClass.getESuperTypes().add(this.getListCompartment());
		useCaseCompartmentEClass.getESuperTypes().add(this.getDiagramCompartment());
		packageShapeEClass.getESuperTypes().add(this.getElementWithPackagedElementsShape());
		packageShapeEClass.getESuperTypes().add(this.getTemplateableElementShape());
		elementWithPackagedElementsShapeEClass.getESuperTypes().add(this.getElementShape());
		packagedElementCompartmentEClass.getESuperTypes().add(this.getDiagramCompartment());
		constraintShapeEClass.getESuperTypes().add(this.getElementShape());
		attributeCompartmentEClass.getESuperTypes().add(this.getListCompartment());
		classifierWithAttributesShapeEClass.getESuperTypes().add(this.getClassifierShape());
		operationCompartmentEClass.getESuperTypes().add(this.getListCompartment());
		classifierWithOperationsShapeEClass.getESuperTypes().add(this.getClassifierWithAttributesShape());
		receptionCompartmentEClass.getESuperTypes().add(this.getListCompartment());
		classifierWithReceptionsShapeEClass.getESuperTypes().add(this.getClassifierWithOperationsShape());
		literalCompartmentEClass.getESuperTypes().add(this.getListCompartment());
		enumerationShapeEClass.getESuperTypes().add(this.getClassifierShape());
		roleLabelEClass.getESuperTypes().add(this.getUmlLabel());
		associationEdgeEClass.getESuperTypes().add(this.getElementEdge());
		elementEdgeEClass.getESuperTypes().add(this.getUmlEdge());
		multiplicityLabelEClass.getESuperTypes().add(this.getUmlLabel());
		propertyEdgeEClass.getESuperTypes().add(this.getElementEdge());
		constraintLabelEClass.getESuperTypes().add(this.getUmlLabel());
		generalizationSetEdgeEClass.getESuperTypes().add(this.getElementEdge());
		powerLabelEClass.getESuperTypes().add(this.getUmlLabel());
		objectNodeShapeEClass.getESuperTypes().add(this.getActivityNodeShape());
		activityNodeShapeEClass.getESuperTypes().add(this.getElementShape());
		selectionLabelEClass.getESuperTypes().add(this.getUmlLabel());
		objectFlowEdgeEClass.getESuperTypes().add(this.getActivityEdgeEdge());
		activityEdgeEdgeEClass.getESuperTypes().add(this.getElementEdge());
		guardLabelEClass.getESuperTypes().add(this.getUmlLabel());
		weightLabelEClass.getESuperTypes().add(this.getUmlLabel());
		transformationLabelEClass.getESuperTypes().add(this.getUmlLabel());
		lifelineShapeEClass.getESuperTypes().add(this.getElementShape());
		interactionFragmentShapeEClass.getESuperTypes().add(this.getElementShape());
		actionShapeEClass.getESuperTypes().add(this.getActivityNodeShape());
		pinShapeEClass.getESuperTypes().add(this.getObjectNodeShape());
		pinShapeEClass.getESuperTypes().add(this.getActivityNodeShape());
		connectorEdgeEClass.getESuperTypes().add(this.getElementEdge());
		instanceSpecificationEdgeEClass.getESuperTypes().add(this.getElementEdge());
		dependencyEdgeEClass.getESuperTypes().add(this.getElementEdge());
		instanceSpecificationShapeEClass.getESuperTypes().add(this.getDeploymentTargetShape());
		deploymentTargetShapeEClass.getESuperTypes().add(this.getElementShape());
		deployedArtifactCompartmentEClass.getESuperTypes().add(this.getClassifierCompartment());
		slotCompartmentEClass.getESuperTypes().add(this.getListCompartment());
		classShapeEClass.getESuperTypes().add(this.getClassifierWithNestedClassifiersShape());
		classShapeEClass.getESuperTypes().add(this.getBehavioredClassifierShape());
		classShapeEClass.getESuperTypes().add(this.getElementWithPortsShape());
		elementWithPortsShapeEClass.getESuperTypes().add(this.getElementWithStructureShape());
		elementWithStructureShapeEClass.getESuperTypes().add(this.getElementShape());
		structureCompartmentEClass.getESuperTypes().add(this.getDiagramCompartment());
		portShapeEClass.getESuperTypes().add(this.getElementShape());
		classifierWithNestedClassifiersShapeEClass.getESuperTypes().add(this.getClassifierWithReceptionsShape());
		nestedClassifierCompartmentEClass.getESuperTypes().add(this.getClassifierCompartment());
		behavioredClassifierShapeEClass.getESuperTypes().add(this.getClassifierShape());
		ownedBehaviorCompartmentEClass.getESuperTypes().add(this.getClassifierCompartment());
		interfaceShapeEClass.getESuperTypes().add(this.getClassifierWithNestedClassifiersShape());
		dataTypeShapeEClass.getESuperTypes().add(this.getClassifierWithOperationsShape());
		primitiveTypeShapeEClass.getESuperTypes().add(this.getDataTypeShape());
		signalShapeEClass.getESuperTypes().add(this.getClassifierWithAttributesShape());
		modelShapeEClass.getESuperTypes().add(this.getPackageShape());
		containmentEdgeEClass.getESuperTypes().add(this.getUmlEdge());
		generalizationEdgeEClass.getESuperTypes().add(this.getElementEdge());
		realizationEdgeEClass.getESuperTypes().add(this.getAbstractionEdge());
		abstractionEdgeEClass.getESuperTypes().add(this.getDependencyEdge());
		interfaceRealizationEdgeEClass.getESuperTypes().add(this.getRealizationEdge());
		usageEdgeEClass.getESuperTypes().add(this.getDependencyEdge());
		elementImportEdgeEClass.getESuperTypes().add(this.getElementEdge());
		packageImportEdgeEClass.getESuperTypes().add(this.getElementEdge());
		packageMergeEdgeEClass.getESuperTypes().add(this.getElementEdge());
		substitutionEdgeEClass.getESuperTypes().add(this.getRealizationEdge());
		informationFlowEdgeEClass.getESuperTypes().add(this.getElementEdge());
		conveyedLabelEClass.getESuperTypes().add(this.getUmlLabel());
		associationClassEdgeEClass.getESuperTypes().add(this.getAssociationEdge());
		commentShapeEClass.getESuperTypes().add(this.getElementShape());
		attachmentEdgeEClass.getESuperTypes().add(this.getUmlEdge());
		associationClassShapeEClass.getESuperTypes().add(this.getClassShape());
		componentShapeEClass.getESuperTypes().add(this.getClassShape());
		componentShapeEClass.getESuperTypes().add(this.getElementWithPackagedElementsShape());
		informationItemShapeEClass.getESuperTypes().add(this.getClassifierShape());
		representationEdgeEClass.getESuperTypes().add(this.getUmlEdge());
		associationShapeEClass.getESuperTypes().add(this.getClassifierShape());
		dependencyShapeEClass.getESuperTypes().add(this.getElementShape());
		timeObservationShapeEClass.getESuperTypes().add(this.getElementShape());
		timeObservationShape_TimeObservationShapeEClass.getESuperTypes().add(this.getElementShape());
		durationObservationShapeEClass.getESuperTypes().add(this.getElementShape());
		packageDiagramEClass.getESuperTypes().add(this.getStructureDiagram());
		profileDiagramEClass.getESuperTypes().add(this.getStructureDiagram());
		compositeStructureDiagramEClass.getESuperTypes().add(this.getStructureDiagram());
		deploymentDiagramEClass.getESuperTypes().add(this.getStructureDiagram());
		componentDiagramEClass.getESuperTypes().add(this.getStructureDiagram());
		objectDiagramEClass.getESuperTypes().add(this.getStructureDiagram());
		profileShapeEClass.getESuperTypes().add(this.getPackageShape());
		profileApplicationEdgeEClass.getESuperTypes().add(this.getElementEdge());
		extensionEdgeEClass.getESuperTypes().add(this.getAssociationEdge());
		behaviorDiagramEClass.getESuperTypes().add(this.getUmlDiagram());
		useCaseDiagramEClass.getESuperTypes().add(this.getBehaviorDiagram());
		artifactShapeEClass.getESuperTypes().add(this.getClassifierWithOperationsShape());
		nestedArtifactCompartmentEClass.getESuperTypes().add(this.getClassifierCompartment());
		componentRealizationEdgeEClass.getESuperTypes().add(this.getRealizationEdge());
		manifestationEdgeEClass.getESuperTypes().add(this.getAbstractionEdge());
		propertyShapeEClass.getESuperTypes().add(this.getElementWithPortsShape());
		propertyShapeEClass.getESuperTypes().add(this.getDeploymentTargetShape());
		collaborationShapeEClass.getESuperTypes().add(this.getClassifierWithOperationsShape());
		collaborationShapeEClass.getESuperTypes().add(this.getBehavioredClassifierShape());
		collaborationShapeEClass.getESuperTypes().add(this.getElementWithStructureShape());
		collaborationUseShapeEClass.getESuperTypes().add(this.getElementShape());
		templateBindingEdgeEClass.getESuperTypes().add(this.getElementEdge());
		stereotypeShapeEClass.getESuperTypes().add(this.getClassShape());
		nodeShapeEClass.getESuperTypes().add(this.getClassShape());
		nodeShapeEClass.getESuperTypes().add(this.getDeploymentTargetShape());
		nestedNodeCompartmentEClass.getESuperTypes().add(this.getClassifierCompartment());
		deviceShapeEClass.getESuperTypes().add(this.getNodeShape());
		executionEnvironmentShapeEClass.getESuperTypes().add(this.getNodeShape());
		activityShapeEClass.getESuperTypes().add(this.getClassShape());
		activityShapeEClass.getESuperTypes().add(this.getElementWithActivityNodesShape());
		elementWithActivityNodesShapeEClass.getESuperTypes().add(this.getElementShape());
		activityNodeCompartmentEClass.getESuperTypes().add(this.getDiagramCompartment());
		parameterCompartmentEClass.getESuperTypes().add(this.getListCompartment());
		postConditionCompartmentEClass.getESuperTypes().add(this.getListCompartment());
		preConditionCompartmentEClass.getESuperTypes().add(this.getListCompartment());
		activityParameterNodeShapeEClass.getESuperTypes().add(this.getObjectNodeShape());
		interactionShapeEClass.getESuperTypes().add(this.getClassShape());
		interactionShapeEClass.getESuperTypes().add(this.getInteractionFragmentWithGatesShape());
		interactionShapeEClass.getESuperTypes().add(this.getInteractionFragmentWithSubfragmentsShape());
		interactionFragmentWithSubfragmentsShapeEClass.getESuperTypes().add(this.getInteractionFragmentShape());
		subfragmentCompartmentEClass.getESuperTypes().add(this.getDiagramCompartment());
		interactionFragmentWithGatesShapeEClass.getESuperTypes().add(this.getInteractionFragmentShape());
		gateShapeEClass.getESuperTypes().add(this.getElementShape());
		opaqueBehaviorShapeEClass.getESuperTypes().add(this.getClassShape());
		functionBehaviorShapeEClass.getESuperTypes().add(this.getOpaqueBehaviorShape());
		stateMachineShapeEClass.getESuperTypes().add(this.getClassShape());
		stateMachineShapeEClass.getESuperTypes().add(this.getBaseStateShape());
		baseStateShapeEClass.getESuperTypes().add(this.getElementShape());
		pseudostateShapeEClass.getESuperTypes().add(this.getElementShape());
		regionCompartmentEClass.getESuperTypes().add(this.getDiagramCompartment());
		protocolStateMachineShapeEClass.getESuperTypes().add(this.getStateMachineShape());
		deploymentSpecificationShapeEClass.getESuperTypes().add(this.getArtifactShape());
		communicationPathEdgeEClass.getESuperTypes().add(this.getAssociationEdge());
		deploymentEdgeEClass.getESuperTypes().add(this.getDependencyEdge());
		actorShapeEClass.getESuperTypes().add(this.getBehavioredClassifierShape());
		extensionPointCompartmentEClass.getESuperTypes().add(this.getListCompartment());
		useCaseShapeEClass.getESuperTypes().add(this.getBehavioredClassifierShape());
		includeEdgeEClass.getESuperTypes().add(this.getElementEdge());
		extendEdgeEClass.getESuperTypes().add(this.getElementEdge());
		stateMachineDiagramEClass.getESuperTypes().add(this.getBehaviorDiagram());
		activityDiagramEClass.getESuperTypes().add(this.getBehaviorDiagram());
		sequenceDiagramEClass.getESuperTypes().add(this.getInteractionDiagram());
		interactionDiagramEClass.getESuperTypes().add(this.getBehaviorDiagram());
		communicationDiagramEClass.getESuperTypes().add(this.getInteractionDiagram());
		timingDiagramEClass.getESuperTypes().add(this.getInteractionDiagram());
		interactionOverviewDiagramEClass.getESuperTypes().add(this.getInteractionDiagram());
		internalBehaviorCompartmentEClass.getESuperTypes().add(this.getListCompartment());
		stateShapeEClass.getESuperTypes().add(this.getBaseStateShape());
		connectionPointReferenceShapeEClass.getESuperTypes().add(this.getElementShape());
		internalTransitionCompartmentEClass.getESuperTypes().add(this.getListCompartment());
		deferrableTriggerCompartmentEClass.getESuperTypes().add(this.getListCompartment());
		regionShapeEClass.getESuperTypes().add(this.getElementShape());
		subvertexCompartmentEClass.getESuperTypes().add(this.getDiagramCompartment());
		transitionEdgeEClass.getESuperTypes().add(this.getElementEdge());
		controlFlowEdgeEClass.getESuperTypes().add(this.getActivityEdgeEdge());
		activityGroupShapeEClass.getESuperTypes().add(this.getElementShape());
		exceptionHandlerEdgeEClass.getESuperTypes().add(this.getElementEdge());
		typeLabelEClass.getESuperTypes().add(this.getUmlLabel());
		interactionUseShapeEClass.getESuperTypes().add(this.getInteractionFragmentWithGatesShape());
		iconLabelEClass.getESuperTypes().add(this.getUmlLabel());
		subpartitionCompartmentEClass.getESuperTypes().add(this.getDiagramCompartment());
		activityPartitionShapeEClass.getESuperTypes().add(this.getActivityGroupShape());
		structuredActivityNodeShapeEClass.getESuperTypes().add(this.getActionShape());
		structuredActivityNodeShapeEClass.getESuperTypes().add(this.getElementWithActivityNodesShape());
		structuredActivityNodeShapeEClass.getESuperTypes().add(this.getActivityGroupShape());
		expansionRegionShapeEClass.getESuperTypes().add(this.getStructuredActivityNodeShape());
		expansionNodeShapeEClass.getESuperTypes().add(this.getObjectNodeShape());
		messageEdgeEClass.getESuperTypes().add(this.getElementEdge());
		generalOrderingEdgeEClass.getESuperTypes().add(this.getElementEdge());
		combinedFragmentShapeEClass.getESuperTypes().add(this.getInteractionFragmentWithGatesShape());
		combinedFragmentShapeEClass.getESuperTypes().add(this.getInteractionFragmentWithSubfragmentsShape());
		interactionOperandShapeEClass.getESuperTypes().add(this.getInteractionFragmentWithSubfragmentsShape());
		executionSpecificationShapeEClass.getESuperTypes().add(this.getInteractionFragmentShape());
		durationConstraintShapeEClass.getESuperTypes().add(this.getConstraintShape());
		timeConstraintShapeEClass.getESuperTypes().add(this.getConstraintShape());
		timeExpressionShapeEClass.getESuperTypes().add(this.getElementShape());
		durationShapeEClass.getESuperTypes().add(this.getElementShape());
		pathEdgeEClass.getESuperTypes().add(this.getUmlEdge());
		messageLabelEClass.getESuperTypes().add(this.getUmlLabel());
		stateInvariantShapeEClass.getESuperTypes().add(this.getInteractionFragmentShape());
		// Initialize classes, features, and operations; add parameters
		initEClass(umlDiagramEClass, UmlDiagram.class, "UmlDiagram", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUmlDiagram_TopUmlDiagramElement(), this.getTopUmlDiagramElement(), this.getTopUmlDiagramElement_UmlDiagram(), "topUmlDiagramElement", null, 0, -1, UmlDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(umlDiagramElementEClass, UmlDiagramElement.class, "UmlDiagramElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUmlDiagramElement_UmlModelElement(), theUMLPackage.getElement(), null, "umlModelElement", null, 0, 1, UmlDiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUmlDiagramElement_SharedUmlStyle(), this.getUmlStyle(), null, "sharedUmlStyle", null, 0, 1, UmlDiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getUmlDiagramElement_LocalUmlStyle(), this.getUmlStyle(), null, "localUmlStyle", null, 0, 1, UmlDiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getUmlDiagramElement_OwnedUmlDiagramElement(), this.getUmlDiagramElement(), this.getUmlDiagramElement_OwningUmlDiagramElement(), "ownedUmlDiagramElement", null, 0, -1, UmlDiagramElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getUmlDiagramElement_OwningUmlDiagramElement(), this.getUmlDiagramElement(), this.getUmlDiagramElement_OwnedUmlDiagramElement(), "owningUmlDiagramElement", null, 0, 1, UmlDiagramElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getUmlDiagramElement_TargetUmlEdge(), this.getUmlEdge(), this.getUmlEdge_TargetUmlDiagramElement(), "targetUmlEdge", null, 0, -1, UmlDiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUmlDiagramElement_SourceUmlEdge(), this.getUmlEdge(), this.getUmlEdge_SourceUmlDiagramElement(), "sourceUmlEdge", null, 0, -1, UmlDiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(umlStyleEClass, UmlStyle.class, "UmlStyle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUmlStyle_FontName(), theDCPackage.getString(), "fontName", null, 0, 1, UmlStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getUmlStyle_FontSize(), theDCPackage.getReal(), "fontSize", null, 0, 1, UmlStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		EOperation op = initEOperation(getUmlStyle__FontsizePositive__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "fontsizePositive", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		initEClass(umlEdgeEClass, UmlEdge.class, "UmlEdge", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUmlEdge_SourceUmlDiagramElement(), this.getUmlDiagramElement(), this.getUmlDiagramElement_SourceUmlEdge(), "sourceUmlDiagramElement", null, 1, 1, UmlEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getUmlEdge_TargetUmlDiagramElement(), this.getUmlDiagramElement(), this.getUmlDiagramElement_TargetUmlEdge(), "targetUmlDiagramElement", null, 1, 1, UmlEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(topUmlDiagramElementEClass, TopUmlDiagramElement.class, "TopUmlDiagramElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTopUmlDiagramElement_UmlDiagram(), this.getUmlDiagram(), this.getUmlDiagram_TopUmlDiagramElement(), "umlDiagram", null, 0, 1, TopUmlDiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTopUmlDiagramElement_DiagramCompartment(), this.getDiagramCompartment(), this.getDiagramCompartment_TopUmlDiagramElement(), "diagramCompartment", null, 0, 1, TopUmlDiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTopUmlDiagramElement_MainLabel(), this.getMainLabel(), this.getMainLabel_TopUmlDiagramElement(), "mainLabel", null, 0, 1, TopUmlDiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(stereotypedDiagramElementEClass, StereotypedDiagramElement.class, "StereotypedDiagramElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStereotypedDiagramElement_ShowStereotypeAttributes(), theDCPackage.getBoolean(), "showStereotypeAttributes", "true", 1, 1, StereotypedDiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getStereotypedDiagramElement_StereotypeLabel(), this.getStereotypeLabel(), this.getStereotypeLabel_StereotypedDiagramElement(), "stereotypeLabel", null, 0, 1, StereotypedDiagramElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(stereotypeLabelEClass, StereotypeLabel.class, "StereotypeLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStereotypeLabel_StereotypedDiagramElement(), this.getStereotypedDiagramElement(), this.getStereotypedDiagramElement_StereotypeLabel(), "stereotypedDiagramElement", null, 0, 1, StereotypeLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(umlLabelEClass, UmlLabel.class, "UmlLabel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(diagramCompartmentEClass, DiagramCompartment.class, "DiagramCompartment", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDiagramCompartment_TopUmlDiagramElement(), this.getTopUmlDiagramElement(), this.getTopUmlDiagramElement_DiagramCompartment(), "topUmlDiagramElement", null, 0, -1, DiagramCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(umlCompartmentEClass, UmlCompartment.class, "UmlCompartment", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(mainLabelEClass, MainLabel.class, "MainLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMainLabel_TopUmlDiagramElement(), this.getTopUmlDiagramElement(), this.getTopUmlDiagramElement_MainLabel(), "topUmlDiagramElement", null, 0, 1, MainLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(umlShapeEClass, UmlShape.class, "UmlShape", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUmlShape_StereotypeCompartment(), this.getStereotypeCompartment(), this.getStereotypeCompartment_UmlShape(), "stereotypeCompartment", null, 0, -1, UmlShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(stereotypeCompartmentEClass, StereotypeCompartment.class, "StereotypeCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStereotypeCompartment_UmlShape(), this.getUmlShape(), this.getUmlShape_StereotypeCompartment(), "umlShape", null, 0, 1, StereotypeCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(listCompartmentEClass, ListCompartment.class, "ListCompartment", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getListCompartment_ListItemLabel(), this.getListItemLabel(), this.getListItemLabel_ListCompartment(), "listItemLabel", null, 0, -1, ListCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(listItemLabelEClass, ListItemLabel.class, "ListItemLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getListItemLabel_ListCompartment(), this.getListCompartment(), this.getListCompartment_ListItemLabel(), "listCompartment", null, 0, 1, ListItemLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(classDiagramEClass, ClassDiagram.class, "ClassDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(structureDiagramEClass, StructureDiagram.class, "StructureDiagram", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(classifierShapeEClass, ClassifierShape.class, "ClassifierShape", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassifierShape_UseClassifierNotation(), theDCPackage.getBoolean(), "useClassifierNotation", "true", 1, 1, ClassifierShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClassifierShape_OwnedUseCaseCompartment(), this.getOwnedUseCaseCompartment(), this.getOwnedUseCaseCompartment_ClassifierShape(), "ownedUseCaseCompartment", null, 0, 1, ClassifierShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClassifierShape_UseCaseCompartment(), this.getUseCaseCompartment(), this.getUseCaseCompartment_ClassifierShape(), "useCaseCompartment", null, 0, 1, ClassifierShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(templateableElementShapeEClass, TemplateableElementShape.class, "TemplateableElementShape", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplateableElementShape_TemplateParameterCompartment(), this.getTemplateParameterCompartment(), this.getTemplateParameterCompartment_TemplateableElementShape(), "templateParameterCompartment", null, 0, 1, TemplateableElementShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(elementShapeEClass, ElementShape.class, "ElementShape", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(templateParameterCompartmentEClass, TemplateParameterCompartment.class, "TemplateParameterCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplateParameterCompartment_TemplateableElementShape(), this.getTemplateableElementShape(), this.getTemplateableElementShape_TemplateParameterCompartment(), "templateableElementShape", null, 0, 1, TemplateParameterCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(ownedUseCaseCompartmentEClass, OwnedUseCaseCompartment.class, "OwnedUseCaseCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOwnedUseCaseCompartment_ClassifierShape(), this.getClassifierShape(), this.getClassifierShape_OwnedUseCaseCompartment(), "classifierShape", null, 0, 1, OwnedUseCaseCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(classifierCompartmentEClass, ClassifierCompartment.class, "ClassifierCompartment", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassifierCompartment_Layout(), this.getCompartmentLayout(), "layout", "list", 1, 1, ClassifierCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(useCaseCompartmentEClass, UseCaseCompartment.class, "UseCaseCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUseCaseCompartment_ClassifierShape(), this.getClassifierShape(), this.getClassifierShape_UseCaseCompartment(), "classifierShape", null, 0, 1, UseCaseCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(packageShapeEClass, PackageShape.class, "PackageShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(elementWithPackagedElementsShapeEClass, ElementWithPackagedElementsShape.class, "ElementWithPackagedElementsShape", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElementWithPackagedElementsShape_PackagedElementCompartment(), this.getPackagedElementCompartment(), this.getPackagedElementCompartment_ElementWithPackagedElementsShape(), "packagedElementCompartment", null, 0, 1, ElementWithPackagedElementsShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(packagedElementCompartmentEClass, PackagedElementCompartment.class, "PackagedElementCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPackagedElementCompartment_ElementWithPackagedElementsShape(), this.getElementWithPackagedElementsShape(), this.getElementWithPackagedElementsShape_PackagedElementCompartment(), "elementWithPackagedElementsShape", null, 0, 1, PackagedElementCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(constraintShapeEClass, ConstraintShape.class, "ConstraintShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(attributeCompartmentEClass, AttributeCompartment.class, "AttributeCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeCompartment_ClassifierWithAttributesShape(), this.getClassifierWithAttributesShape(), this.getClassifierWithAttributesShape_AttributeCompartment(), "classifierWithAttributesShape", null, 0, 1, AttributeCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(classifierWithAttributesShapeEClass, ClassifierWithAttributesShape.class, "ClassifierWithAttributesShape", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassifierWithAttributesShape_AttributeCompartment(), this.getAttributeCompartment(), this.getAttributeCompartment_ClassifierWithAttributesShape(), "attributeCompartment", null, 0, 1, ClassifierWithAttributesShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(operationCompartmentEClass, OperationCompartment.class, "OperationCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationCompartment_ClassifierWithOperationsShape(), this.getClassifierWithOperationsShape(), this.getClassifierWithOperationsShape_OperationCompartment(), "classifierWithOperationsShape", null, 0, 1, OperationCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(classifierWithOperationsShapeEClass, ClassifierWithOperationsShape.class, "ClassifierWithOperationsShape", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassifierWithOperationsShape_OperationCompartment(), this.getOperationCompartment(), this.getOperationCompartment_ClassifierWithOperationsShape(), "operationCompartment", null, 0, 1, ClassifierWithOperationsShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(receptionCompartmentEClass, ReceptionCompartment.class, "ReceptionCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReceptionCompartment_ClassifierWithReceptionShape(), this.getClassifierWithReceptionsShape(), this.getClassifierWithReceptionsShape_ReceptionCompartment(), "classifierWithReceptionShape", null, 0, 1, ReceptionCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(classifierWithReceptionsShapeEClass, ClassifierWithReceptionsShape.class, "ClassifierWithReceptionsShape", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassifierWithReceptionsShape_ReceptionCompartment(), this.getReceptionCompartment(), this.getReceptionCompartment_ClassifierWithReceptionShape(), "receptionCompartment", null, 0, 1, ClassifierWithReceptionsShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(literalCompartmentEClass, LiteralCompartment.class, "LiteralCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLiteralCompartment_EnumerationShape(), this.getEnumerationShape(), this.getEnumerationShape_LiteralCompartment(), "enumerationShape", null, 0, 1, LiteralCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(enumerationShapeEClass, EnumerationShape.class, "EnumerationShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumerationShape_LiteralCompartment(), this.getLiteralCompartment(), this.getLiteralCompartment_EnumerationShape(), "literalCompartment", null, 0, 1, EnumerationShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(roleLabelEClass, RoleLabel.class, "RoleLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoleLabel_AssociationEdge(), this.getAssociationEdge(), this.getAssociationEdge_EndRoleLabel(), "associationEdge", null, 0, 1, RoleLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRoleLabel_InstanceSpecificationEdge(), this.getInstanceSpecificationEdge(), this.getInstanceSpecificationEdge_EndRoleLabel(), "instanceSpecificationEdge", null, 0, 1, RoleLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRoleLabel_RoleBindingEdge(), this.getDependencyEdge(), this.getDependencyEdge_RoleLabel(), "roleBindingEdge", null, 0, 1, RoleLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(associationEdgeEClass, AssociationEdge.class, "AssociationEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssociationEdge_EndMultiplicityLabel(), this.getMultiplicityLabel(), this.getMultiplicityLabel_AssociationEdge(), "endMultiplicityLabel", null, 0, 2, AssociationEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssociationEdge_EndConstraintLabel(), this.getConstraintLabel(), this.getConstraintLabel_AssociationEdge(), "endConstraintLabel", null, 0, 2, AssociationEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssociationEdge_EndRoleLabel(), this.getRoleLabel(), this.getRoleLabel_AssociationEdge(), "endRoleLabel", null, 0, 2, AssociationEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(elementEdgeEClass, ElementEdge.class, "ElementEdge", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(multiplicityLabelEClass, MultiplicityLabel.class, "MultiplicityLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiplicityLabel_PropertyEdge(), this.getPropertyEdge(), this.getPropertyEdge_MultiplicityLabel(), "propertyEdge", null, 0, 1, MultiplicityLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMultiplicityLabel_ConnectorEdge(), this.getConnectorEdge(), this.getConnectorEdge_EndMultiplicityLabel(), "connectorEdge", null, 0, 1, MultiplicityLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMultiplicityLabel_AssociationEdge(), this.getAssociationEdge(), this.getAssociationEdge_EndMultiplicityLabel(), "associationEdge", null, 0, 1, MultiplicityLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(propertyEdgeEClass, PropertyEdge.class, "PropertyEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyEdge_ConstraintLabel(), this.getConstraintLabel(), this.getConstraintLabel_PropertyEdge(), "constraintLabel", null, 0, 1, PropertyEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPropertyEdge_MultiplicityLabel(), this.getMultiplicityLabel(), this.getMultiplicityLabel_PropertyEdge(), "multiplicityLabel", null, 0, 1, PropertyEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(constraintLabelEClass, ConstraintLabel.class, "ConstraintLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstraintLabel_AssociationEdge(), this.getAssociationEdge(), this.getAssociationEdge_EndConstraintLabel(), "associationEdge", null, 0, 1, ConstraintLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConstraintLabel_GeneralizationSetEdge(), this.getGeneralizationSetEdge(), this.getGeneralizationSetEdge_ConstraintLabel(), "generalizationSetEdge", null, 0, 1, ConstraintLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConstraintLabel_ObjectNodeShape(), this.getObjectNodeShape(), this.getObjectNodeShape_ConstraintLabel(), "objectNodeShape", null, 0, 1, ConstraintLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConstraintLabel_LifelineShape(), this.getLifelineShape(), this.getLifelineShape_ConstraintLabel(), "lifelineShape", null, 0, 1, ConstraintLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConstraintLabel_ActionShape(), this.getActionShape(), this.getActionShape_ConditionLabel(), "actionShape", null, 0, 1, ConstraintLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConstraintLabel_PropertyEdge(), this.getPropertyEdge(), this.getPropertyEdge_ConstraintLabel(), "propertyEdge", null, 0, 1, ConstraintLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(generalizationSetEdgeEClass, GeneralizationSetEdge.class, "GeneralizationSetEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGeneralizationSetEdge_PowerLabel(), this.getPowerLabel(), this.getPowerLabel_GeneralizationSetEdge(), "powerLabel", null, 0, 1, GeneralizationSetEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGeneralizationSetEdge_ConstraintLabel(), this.getConstraintLabel(), this.getConstraintLabel_GeneralizationSetEdge(), "constraintLabel", null, 0, 1, GeneralizationSetEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(powerLabelEClass, PowerLabel.class, "PowerLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPowerLabel_GeneralizationSetEdge(), this.getGeneralizationSetEdge(), this.getGeneralizationSetEdge_PowerLabel(), "generalizationSetEdge", null, 0, 1, PowerLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(objectNodeShapeEClass, ObjectNodeShape.class, "ObjectNodeShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectNodeShape_SelectionLabel(), this.getSelectionLabel(), this.getSelectionLabel_ObjectNodeShape(), "selectionLabel", null, 0, 1, ObjectNodeShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getObjectNodeShape_ConstraintLabel(), this.getConstraintLabel(), this.getConstraintLabel_ObjectNodeShape(), "constraintLabel", null, 0, 1, ObjectNodeShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(activityNodeShapeEClass, ActivityNodeShape.class, "ActivityNodeShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(selectionLabelEClass, SelectionLabel.class, "SelectionLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSelectionLabel_ObjectFlowEdge(), this.getObjectFlowEdge(), this.getObjectFlowEdge_SelectionLabel(), "objectFlowEdge", null, 0, 1, SelectionLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSelectionLabel_ObjectNodeShape(), this.getObjectNodeShape(), this.getObjectNodeShape_SelectionLabel(), "objectNodeShape", null, 0, 1, SelectionLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(objectFlowEdgeEClass, ObjectFlowEdge.class, "ObjectFlowEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectFlowEdge_TransformationLabel(), this.getTransformationLabel(), this.getTransformationLabel_ObjectFlowEdge(), "transformationLabel", null, 0, 1, ObjectFlowEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getObjectFlowEdge_SelectionLabel(), this.getSelectionLabel(), this.getSelectionLabel_ObjectFlowEdge(), "selectionLabel", null, 0, 1, ObjectFlowEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(activityEdgeEdgeEClass, ActivityEdgeEdge.class, "ActivityEdgeEdge", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActivityEdgeEdge_GuardLabel(), this.getGuardLabel(), this.getGuardLabel_ActivityEdgeEdge(), "guardLabel", null, 0, 1, ActivityEdgeEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getActivityEdgeEdge_WeightLabel(), this.getWeightLabel(), this.getWeightLabel_ActivityEdgeEdge(), "weightLabel", null, 0, 1, ActivityEdgeEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(guardLabelEClass, GuardLabel.class, "GuardLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGuardLabel_ActivityEdgeEdge(), this.getActivityEdgeEdge(), this.getActivityEdgeEdge_GuardLabel(), "activityEdgeEdge", null, 0, 1, GuardLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(weightLabelEClass, WeightLabel.class, "WeightLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWeightLabel_ActivityEdgeEdge(), this.getActivityEdgeEdge(), this.getActivityEdgeEdge_WeightLabel(), "activityEdgeEdge", null, 0, 1, WeightLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(transformationLabelEClass, TransformationLabel.class, "TransformationLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformationLabel_ObjectFlowEdge(), this.getObjectFlowEdge(), this.getObjectFlowEdge_TransformationLabel(), "objectFlowEdge", null, 0, 1, TransformationLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(lifelineShapeEClass, LifelineShape.class, "LifelineShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLifelineShape_SubfragmentShape(), this.getInteractionFragmentShape(), this.getInteractionFragmentShape_LifelineShape(), "subfragmentShape", null, 0, -1, LifelineShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLifelineShape_NestingLifelineShape(), this.getLifelineShape(), this.getLifelineShape_NestedLifelineShape(), "nestingLifelineShape", null, 0, 1, LifelineShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLifelineShape_NestedLifelineShape(), this.getLifelineShape(), this.getLifelineShape_NestingLifelineShape(), "nestedLifelineShape", null, 0, -1, LifelineShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLifelineShape_ConstraintLabel(), this.getConstraintLabel(), this.getConstraintLabel_LifelineShape(), "constraintLabel", null, 0, -1, LifelineShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(interactionFragmentShapeEClass, InteractionFragmentShape.class, "InteractionFragmentShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInteractionFragmentShape_LifelineShape(), this.getLifelineShape(), this.getLifelineShape_SubfragmentShape(), "lifelineShape", null, 0, 1, InteractionFragmentShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(actionShapeEClass, ActionShape.class, "ActionShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActionShape_PinShape(), this.getPinShape(), this.getPinShape_ActionShape(), "pinShape", null, 0, -1, ActionShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionShape_ConditionLabel(), this.getConstraintLabel(), this.getConstraintLabel_ActionShape(), "conditionLabel", null, 0, -1, ActionShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(pinShapeEClass, PinShape.class, "PinShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPinShape_ActionShape(), this.getActionShape(), this.getActionShape_PinShape(), "actionShape", null, 0, 1, PinShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(connectorEdgeEClass, ConnectorEdge.class, "ConnectorEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnectorEdge_EndMultiplicityLabel(), this.getMultiplicityLabel(), this.getMultiplicityLabel_ConnectorEdge(), "endMultiplicityLabel", null, 0, 2, ConnectorEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(instanceSpecificationEdgeEClass, InstanceSpecificationEdge.class, "InstanceSpecificationEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstanceSpecificationEdge_EndRoleLabel(), this.getRoleLabel(), this.getRoleLabel_InstanceSpecificationEdge(), "endRoleLabel", null, 0, 2, InstanceSpecificationEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(dependencyEdgeEClass, DependencyEdge.class, "DependencyEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDependencyEdge_RoleLabel(), this.getRoleLabel(), this.getRoleLabel_RoleBindingEdge(), "roleLabel", null, 0, 1, DependencyEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(instanceSpecificationShapeEClass, InstanceSpecificationShape.class, "InstanceSpecificationShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstanceSpecificationShape_SlotCompartment(), this.getSlotCompartment(), this.getSlotCompartment_InstanceSpecificationShape(), "slotCompartment", null, 0, 1, InstanceSpecificationShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(deploymentTargetShapeEClass, DeploymentTargetShape.class, "DeploymentTargetShape", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeploymentTargetShape_DeployedArtifactCompartment(), this.getDeployedArtifactCompartment(), this.getDeployedArtifactCompartment_DeploymentTargetShape(), "deployedArtifactCompartment", null, 0, 1, DeploymentTargetShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(deployedArtifactCompartmentEClass, DeployedArtifactCompartment.class, "DeployedArtifactCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeployedArtifactCompartment_DeploymentTargetShape(), this.getDeploymentTargetShape(), this.getDeploymentTargetShape_DeployedArtifactCompartment(), "deploymentTargetShape", null, 0, 1, DeployedArtifactCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(slotCompartmentEClass, SlotCompartment.class, "SlotCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSlotCompartment_InstanceSpecificationShape(), this.getInstanceSpecificationShape(), this.getInstanceSpecificationShape_SlotCompartment(), "instanceSpecificationShape", null, 0, 1, SlotCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(classShapeEClass, ClassShape.class, "ClassShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(elementWithPortsShapeEClass, ElementWithPortsShape.class, "ElementWithPortsShape", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElementWithPortsShape_PortShape(), this.getPortShape(), this.getPortShape_ElementWithPortsShape(), "portShape", null, 0, -1, ElementWithPortsShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(elementWithStructureShapeEClass, ElementWithStructureShape.class, "ElementWithStructureShape", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElementWithStructureShape_StructureCompartment(), this.getStructureCompartment(), this.getStructureCompartment_ElementWithStructureShape(), "structureCompartment", null, 0, 1, ElementWithStructureShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(structureCompartmentEClass, StructureCompartment.class, "StructureCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructureCompartment_ElementWithStructureShape(), this.getElementWithStructureShape(), this.getElementWithStructureShape_StructureCompartment(), "elementWithStructureShape", null, 0, 1, StructureCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(portShapeEClass, PortShape.class, "PortShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPortShape_ElementWithPortsShape(), this.getElementWithPortsShape(), this.getElementWithPortsShape_PortShape(), "elementWithPortsShape", null, 0, 1, PortShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(classifierWithNestedClassifiersShapeEClass, ClassifierWithNestedClassifiersShape.class, "ClassifierWithNestedClassifiersShape", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassifierWithNestedClassifiersShape_NestedClassifierCompartment(), this.getNestedClassifierCompartment(), this.getNestedClassifierCompartment_ClassifierWithNestedClassifiersShape(), "nestedClassifierCompartment", null, 0, 1, ClassifierWithNestedClassifiersShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(nestedClassifierCompartmentEClass, NestedClassifierCompartment.class, "NestedClassifierCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNestedClassifierCompartment_ClassifierWithNestedClassifiersShape(), this.getClassifierWithNestedClassifiersShape(), this.getClassifierWithNestedClassifiersShape_NestedClassifierCompartment(), "classifierWithNestedClassifiersShape", null, 0, 1, NestedClassifierCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(behavioredClassifierShapeEClass, BehavioredClassifierShape.class, "BehavioredClassifierShape", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehavioredClassifierShape_OwnedBehaviorCompartment(), this.getOwnedBehaviorCompartment(), this.getOwnedBehaviorCompartment_BehavioredClassifierShape(), "ownedBehaviorCompartment", null, 0, 1, BehavioredClassifierShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(ownedBehaviorCompartmentEClass, OwnedBehaviorCompartment.class, "OwnedBehaviorCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOwnedBehaviorCompartment_BehavioredClassifierShape(), this.getBehavioredClassifierShape(), this.getBehavioredClassifierShape_OwnedBehaviorCompartment(), "behavioredClassifierShape", null, 0, 1, OwnedBehaviorCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(interfaceShapeEClass, InterfaceShape.class, "InterfaceShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(dataTypeShapeEClass, DataTypeShape.class, "DataTypeShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(primitiveTypeShapeEClass, PrimitiveTypeShape.class, "PrimitiveTypeShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(signalShapeEClass, SignalShape.class, "SignalShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(modelShapeEClass, ModelShape.class, "ModelShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(containmentEdgeEClass, ContainmentEdge.class, "ContainmentEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(generalizationEdgeEClass, GeneralizationEdge.class, "GeneralizationEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(realizationEdgeEClass, RealizationEdge.class, "RealizationEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(abstractionEdgeEClass, AbstractionEdge.class, "AbstractionEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(interfaceRealizationEdgeEClass, InterfaceRealizationEdge.class, "InterfaceRealizationEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(usageEdgeEClass, UsageEdge.class, "UsageEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(elementImportEdgeEClass, ElementImportEdge.class, "ElementImportEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(packageImportEdgeEClass, PackageImportEdge.class, "PackageImportEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(packageMergeEdgeEClass, PackageMergeEdge.class, "PackageMergeEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(substitutionEdgeEClass, SubstitutionEdge.class, "SubstitutionEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(informationFlowEdgeEClass, InformationFlowEdge.class, "InformationFlowEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInformationFlowEdge_ConveyedLabel(), this.getConveyedLabel(), this.getConveyedLabel_InformationFlowEdge(), "conveyedLabel", null, 0, 1, InformationFlowEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(conveyedLabelEClass, ConveyedLabel.class, "ConveyedLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConveyedLabel_InformationFlowEdge(), this.getInformationFlowEdge(), this.getInformationFlowEdge_ConveyedLabel(), "informationFlowEdge", null, 0, 1, ConveyedLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(associationClassEdgeEClass, AssociationClassEdge.class, "AssociationClassEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(commentShapeEClass, CommentShape.class, "CommentShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(attachmentEdgeEClass, AttachmentEdge.class, "AttachmentEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(associationClassShapeEClass, AssociationClassShape.class, "AssociationClassShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(componentShapeEClass, ComponentShape.class, "ComponentShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(informationItemShapeEClass, InformationItemShape.class, "InformationItemShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(representationEdgeEClass, RepresentationEdge.class, "RepresentationEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(associationShapeEClass, AssociationShape.class, "AssociationShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(dependencyShapeEClass, DependencyShape.class, "DependencyShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(timeObservationShapeEClass, TimeObservationShape.class, "TimeObservationShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(timeObservationShape_TimeObservationShapeEClass, TimeObservationShape_TimeObservationShape.class, "TimeObservationShape_TimeObservationShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(durationObservationShapeEClass, DurationObservationShape.class, "DurationObservationShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(packageDiagramEClass, PackageDiagram.class, "PackageDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(profileDiagramEClass, ProfileDiagram.class, "ProfileDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(compositeStructureDiagramEClass, CompositeStructureDiagram.class, "CompositeStructureDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(deploymentDiagramEClass, DeploymentDiagram.class, "DeploymentDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(componentDiagramEClass, ComponentDiagram.class, "ComponentDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(objectDiagramEClass, ObjectDiagram.class, "ObjectDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(profileShapeEClass, ProfileShape.class, "ProfileShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(profileApplicationEdgeEClass, ProfileApplicationEdge.class, "ProfileApplicationEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(extensionEdgeEClass, ExtensionEdge.class, "ExtensionEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(behaviorDiagramEClass, BehaviorDiagram.class, "BehaviorDiagram", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(useCaseDiagramEClass, UseCaseDiagram.class, "UseCaseDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(artifactShapeEClass, ArtifactShape.class, "ArtifactShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArtifactShape_NestedArtifactCompartment(), this.getNestedArtifactCompartment(), this.getNestedArtifactCompartment_ArtifactShape(), "nestedArtifactCompartment", null, 0, 1, ArtifactShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(nestedArtifactCompartmentEClass, NestedArtifactCompartment.class, "NestedArtifactCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNestedArtifactCompartment_ArtifactShape(), this.getArtifactShape(), this.getArtifactShape_NestedArtifactCompartment(), "artifactShape", null, 0, 1, NestedArtifactCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(componentRealizationEdgeEClass, ComponentRealizationEdge.class, "ComponentRealizationEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(manifestationEdgeEClass, ManifestationEdge.class, "ManifestationEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(propertyShapeEClass, PropertyShape.class, "PropertyShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(collaborationShapeEClass, CollaborationShape.class, "CollaborationShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollaborationShape_ReceptionCompartment(), this.getReceptionCompartment(), null, "receptionCompartment", null, 0, 1, CollaborationShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(collaborationUseShapeEClass, CollaborationUseShape.class, "CollaborationUseShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(templateBindingEdgeEClass, TemplateBindingEdge.class, "TemplateBindingEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(stereotypeShapeEClass, StereotypeShape.class, "StereotypeShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(nodeShapeEClass, NodeShape.class, "NodeShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodeShape_NestedNodeCompartment(), this.getNestedNodeCompartment(), this.getNestedNodeCompartment_NodeShape(), "nestedNodeCompartment", null, 0, 1, NodeShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(nestedNodeCompartmentEClass, NestedNodeCompartment.class, "NestedNodeCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNestedNodeCompartment_NodeShape(), this.getNodeShape(), this.getNodeShape_NestedNodeCompartment(), "nodeShape", null, 0, 1, NestedNodeCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(deviceShapeEClass, DeviceShape.class, "DeviceShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(executionEnvironmentShapeEClass, ExecutionEnvironmentShape.class, "ExecutionEnvironmentShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(activityShapeEClass, ActivityShape.class, "ActivityShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActivityShape_ParameterCompartment(), this.getParameterCompartment(), this.getParameterCompartment_ActivityShape(), "parameterCompartment", null, 0, 1, ActivityShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getActivityShape_PostConditionCompartment(), this.getPostConditionCompartment(), this.getPostConditionCompartment_ActivityShape(), "postConditionCompartment", null, 0, 1, ActivityShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getActivityShape_PreConditionCompartment(), this.getPreConditionCompartment(), this.getPreConditionCompartment_ActivityShape(), "preConditionCompartment", null, 0, 1, ActivityShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getActivityShape_ActivityParameterNodeShape(), this.getActivityParameterNodeShape(), this.getActivityParameterNodeShape_ActivityShape(), "activityParameterNodeShape", null, 0, -1, ActivityShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(elementWithActivityNodesShapeEClass, ElementWithActivityNodesShape.class, "ElementWithActivityNodesShape", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElementWithActivityNodesShape_ActivityNodeCompartment(), this.getActivityNodeCompartment(), this.getActivityNodeCompartment_ElementWithActivityNodesShape(), "activityNodeCompartment", null, 0, 1, ElementWithActivityNodesShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(activityNodeCompartmentEClass, ActivityNodeCompartment.class, "ActivityNodeCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActivityNodeCompartment_ElementWithActivityNodesShape(), this.getElementWithActivityNodesShape(), this.getElementWithActivityNodesShape_ActivityNodeCompartment(), "elementWithActivityNodesShape", null, 0, 1, ActivityNodeCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(parameterCompartmentEClass, ParameterCompartment.class, "ParameterCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterCompartment_ActivityShape(), this.getActivityShape(), this.getActivityShape_ParameterCompartment(), "activityShape", null, 0, 1, ParameterCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(postConditionCompartmentEClass, PostConditionCompartment.class, "PostConditionCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPostConditionCompartment_ActivityShape(), this.getActivityShape(), this.getActivityShape_PostConditionCompartment(), "activityShape", null, 0, 1, PostConditionCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(preConditionCompartmentEClass, PreConditionCompartment.class, "PreConditionCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPreConditionCompartment_ActivityShape(), this.getActivityShape(), this.getActivityShape_PreConditionCompartment(), "activityShape", null, 0, 1, PreConditionCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(activityParameterNodeShapeEClass, ActivityParameterNodeShape.class, "ActivityParameterNodeShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActivityParameterNodeShape_ActivityShape(), this.getActivityShape(), this.getActivityShape_ActivityParameterNodeShape(), "activityShape", null, 0, 1, ActivityParameterNodeShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(interactionShapeEClass, InteractionShape.class, "InteractionShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(interactionFragmentWithSubfragmentsShapeEClass, InteractionFragmentWithSubfragmentsShape.class, "InteractionFragmentWithSubfragmentsShape", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInteractionFragmentWithSubfragmentsShape_SubfragmentCompartment(), this.getSubfragmentCompartment(), this.getSubfragmentCompartment_InteractionFragmentWithSubfragmentsShape(), "subfragmentCompartment", null, 0, 1, InteractionFragmentWithSubfragmentsShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(subfragmentCompartmentEClass, SubfragmentCompartment.class, "SubfragmentCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubfragmentCompartment_InteractionFragmentWithSubfragmentsShape(), this.getInteractionFragmentWithSubfragmentsShape(), this.getInteractionFragmentWithSubfragmentsShape_SubfragmentCompartment(), "interactionFragmentWithSubfragmentsShape", null, 0, 1, SubfragmentCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(interactionFragmentWithGatesShapeEClass, InteractionFragmentWithGatesShape.class, "InteractionFragmentWithGatesShape", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInteractionFragmentWithGatesShape_GateShape(), this.getGateShape(), this.getGateShape_InteractionFragmentWithGatesShape(), "gateShape", null, 0, -1, InteractionFragmentWithGatesShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(gateShapeEClass, GateShape.class, "GateShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGateShape_InteractionFragmentWithGatesShape(), this.getInteractionFragmentWithGatesShape(), this.getInteractionFragmentWithGatesShape_GateShape(), "interactionFragmentWithGatesShape", null, 0, 1, GateShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(opaqueBehaviorShapeEClass, OpaqueBehaviorShape.class, "OpaqueBehaviorShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(functionBehaviorShapeEClass, FunctionBehaviorShape.class, "FunctionBehaviorShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(stateMachineShapeEClass, StateMachineShape.class, "StateMachineShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(baseStateShapeEClass, BaseStateShape.class, "BaseStateShape", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBaseStateShape_ConnectionPointShape(), this.getPseudostateShape(), this.getPseudostateShape_BaseStateShape(), "connectionPointShape", null, 0, -1, BaseStateShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBaseStateShape_RegionCompartment(), this.getRegionCompartment(), this.getRegionCompartment_BaseStateShape(), "regionCompartment", null, 0, 1, BaseStateShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(pseudostateShapeEClass, PseudostateShape.class, "PseudostateShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPseudostateShape_BaseStateShape(), this.getBaseStateShape(), this.getBaseStateShape_ConnectionPointShape(), "baseStateShape", null, 0, 1, PseudostateShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(regionCompartmentEClass, RegionCompartment.class, "RegionCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRegionCompartment_BaseStateShape(), this.getBaseStateShape(), this.getBaseStateShape_RegionCompartment(), "baseStateShape", null, 0, 1, RegionCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(protocolStateMachineShapeEClass, ProtocolStateMachineShape.class, "ProtocolStateMachineShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(deploymentSpecificationShapeEClass, DeploymentSpecificationShape.class, "DeploymentSpecificationShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(communicationPathEdgeEClass, CommunicationPathEdge.class, "CommunicationPathEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(deploymentEdgeEClass, DeploymentEdge.class, "DeploymentEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(actorShapeEClass, ActorShape.class, "ActorShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(extensionPointCompartmentEClass, ExtensionPointCompartment.class, "ExtensionPointCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtensionPointCompartment_UseCaseShape(), this.getUseCaseShape(), this.getUseCaseShape_ExtensionPointCompartment(), "useCaseShape", null, 0, 1, ExtensionPointCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(useCaseShapeEClass, UseCaseShape.class, "UseCaseShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUseCaseShape_ExtensionPointCompartment(), this.getExtensionPointCompartment(), this.getExtensionPointCompartment_UseCaseShape(), "extensionPointCompartment", null, 0, 1, UseCaseShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(includeEdgeEClass, IncludeEdge.class, "IncludeEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(extendEdgeEClass, ExtendEdge.class, "ExtendEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(stateMachineDiagramEClass, StateMachineDiagram.class, "StateMachineDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(activityDiagramEClass, ActivityDiagram.class, "ActivityDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(sequenceDiagramEClass, SequenceDiagram.class, "SequenceDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(interactionDiagramEClass, InteractionDiagram.class, "InteractionDiagram", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(communicationDiagramEClass, CommunicationDiagram.class, "CommunicationDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(timingDiagramEClass, TimingDiagram.class, "TimingDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(interactionOverviewDiagramEClass, InteractionOverviewDiagram.class, "InteractionOverviewDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(internalBehaviorCompartmentEClass, InternalBehaviorCompartment.class, "InternalBehaviorCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInternalBehaviorCompartment_StateShape(), this.getStateShape(), this.getStateShape_InternalBehaviorCompartment(), "stateShape", null, 0, 1, InternalBehaviorCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(stateShapeEClass, StateShape.class, "StateShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateShape_ConnectionPointReferenceShape(), this.getConnectionPointReferenceShape(), this.getConnectionPointReferenceShape_StateShape(), "connectionPointReferenceShape", null, 0, -1, StateShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateShape_InternalTransitionCompartment(), this.getInternalTransitionCompartment(), this.getInternalTransitionCompartment_StateShape(), "internalTransitionCompartment", null, 0, 1, StateShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getStateShape_DeferrableTriggerCompartment(), this.getDeferrableTriggerCompartment(), this.getDeferrableTriggerCompartment_StateShape(), "deferrableTriggerCompartment", null, 0, 1, StateShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getStateShape_InternalBehaviorCompartment(), this.getInternalBehaviorCompartment(), this.getInternalBehaviorCompartment_StateShape(), "internalBehaviorCompartment", null, 0, 1, StateShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(connectionPointReferenceShapeEClass, ConnectionPointReferenceShape.class, "ConnectionPointReferenceShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnectionPointReferenceShape_StateShape(), this.getStateShape(), this.getStateShape_ConnectionPointReferenceShape(), "stateShape", null, 0, 1, ConnectionPointReferenceShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(internalTransitionCompartmentEClass, InternalTransitionCompartment.class, "InternalTransitionCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInternalTransitionCompartment_StateShape(), this.getStateShape(), this.getStateShape_InternalTransitionCompartment(), "stateShape", null, 0, 1, InternalTransitionCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(deferrableTriggerCompartmentEClass, DeferrableTriggerCompartment.class, "DeferrableTriggerCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeferrableTriggerCompartment_StateShape(), this.getStateShape(), this.getStateShape_DeferrableTriggerCompartment(), "stateShape", null, 0, 1, DeferrableTriggerCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(regionShapeEClass, RegionShape.class, "RegionShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRegionShape_Placement(), this.getPlacement(), "placement", null, 0, -1, RegionShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRegionShape_SubvertexCompartment(), this.getSubvertexCompartment(), this.getSubvertexCompartment_RegionShape(), "subvertexCompartment", null, 0, 1, RegionShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(subvertexCompartmentEClass, SubvertexCompartment.class, "SubvertexCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubvertexCompartment_RegionShape(), this.getRegionShape(), this.getRegionShape_SubvertexCompartment(), "regionShape", null, 0, 1, SubvertexCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(transitionEdgeEClass, TransitionEdge.class, "TransitionEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(controlFlowEdgeEClass, ControlFlowEdge.class, "ControlFlowEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(activityGroupShapeEClass, ActivityGroupShape.class, "ActivityGroupShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(exceptionHandlerEdgeEClass, ExceptionHandlerEdge.class, "ExceptionHandlerEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExceptionHandlerEdge_TypeLabel(), this.getTypeLabel(), this.getTypeLabel_ExceptionHandlerEdge(), "typeLabel", null, 0, 1, ExceptionHandlerEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExceptionHandlerEdge_IconLabel(), this.getIconLabel(), this.getIconLabel_ExceptionHandlerEdge(), "iconLabel", null, 0, 1, ExceptionHandlerEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(typeLabelEClass, TypeLabel.class, "TypeLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeLabel_InteractionUseShape(), this.getInteractionUseShape(), this.getInteractionUseShape_TypeLabel(), "interactionUseShape", null, 0, 1, TypeLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTypeLabel_ExceptionHandlerEdge(), this.getExceptionHandlerEdge(), this.getExceptionHandlerEdge_TypeLabel(), "exceptionHandlerEdge", null, 0, 1, TypeLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(interactionUseShapeEClass, InteractionUseShape.class, "InteractionUseShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInteractionUseShape_TypeLabel(), this.getTypeLabel(), this.getTypeLabel_InteractionUseShape(), "typeLabel", null, 0, 1, InteractionUseShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(iconLabelEClass, IconLabel.class, "IconLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIconLabel_ExceptionHandlerEdge(), this.getExceptionHandlerEdge(), this.getExceptionHandlerEdge_IconLabel(), "exceptionHandlerEdge", null, 0, 1, IconLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(subpartitionCompartmentEClass, SubpartitionCompartment.class, "SubpartitionCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubpartitionCompartment_ActivityPartitionShape(), this.getActivityPartitionShape(), this.getActivityPartitionShape_SubpartitionCompartment(), "activityPartitionShape", null, 0, 1, SubpartitionCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(activityPartitionShapeEClass, ActivityPartitionShape.class, "ActivityPartitionShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActivityPartitionShape_IsVertical(), theDCPackage.getBoolean(), "isVertical", "true", 1, 1, ActivityPartitionShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getActivityPartitionShape_SubpartitionCompartment(), this.getSubpartitionCompartment(), this.getSubpartitionCompartment_ActivityPartitionShape(), "subpartitionCompartment", null, 0, 1, ActivityPartitionShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(structuredActivityNodeShapeEClass, StructuredActivityNodeShape.class, "StructuredActivityNodeShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(expansionRegionShapeEClass, ExpansionRegionShape.class, "ExpansionRegionShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpansionRegionShape_ExpansionNodeShape(), this.getExpansionNodeShape(), this.getExpansionNodeShape_ExpansionRegionShape(), "expansionNodeShape", null, 0, -1, ExpansionRegionShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(expansionNodeShapeEClass, ExpansionNodeShape.class, "ExpansionNodeShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpansionNodeShape_ExpansionRegionShape(), this.getExpansionRegionShape(), this.getExpansionRegionShape_ExpansionNodeShape(), "expansionRegionShape", null, 0, 1, ExpansionNodeShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(messageEdgeEClass, MessageEdge.class, "MessageEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(generalOrderingEdgeEClass, GeneralOrderingEdge.class, "GeneralOrderingEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(combinedFragmentShapeEClass, CombinedFragmentShape.class, "CombinedFragmentShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(interactionOperandShapeEClass, InteractionOperandShape.class, "InteractionOperandShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(executionSpecificationShapeEClass, ExecutionSpecificationShape.class, "ExecutionSpecificationShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(durationConstraintShapeEClass, DurationConstraintShape.class, "DurationConstraintShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(timeConstraintShapeEClass, TimeConstraintShape.class, "TimeConstraintShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(timeExpressionShapeEClass, TimeExpressionShape.class, "TimeExpressionShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(durationShapeEClass, DurationShape.class, "DurationShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEClass(pathEdgeEClass, PathEdge.class, "PathEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPathEdge_MessageLabel(), this.getMessageLabel(), this.getMessageLabel_PathEdge(), "messageLabel", null, 0, -1, PathEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEClass(messageLabelEClass, MessageLabel.class, "MessageLabel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMessageLabel_PathEdge(), this.getPathEdge(), this.getPathEdge_MessageLabel(), "pathEdge", null, 0, 1, MessageLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEClass(stateInvariantShapeEClass, StateInvariantShape.class, "StateInvariantShape", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStateInvariantShape_UseStateShape(), theDCPackage.getBoolean(), "useStateShape", "false", 1, 1, StateInvariantShape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		// Initialize enums and add enum literals
		initEEnum(compartmentLayoutEEnum, CompartmentLayout.class, "CompartmentLayout");
		addEEnumLiteral(compartmentLayoutEEnum, CompartmentLayout.LIST);
		addEEnumLiteral(compartmentLayoutEEnum, CompartmentLayout.DIAGRAM);
		initEEnum(placementEEnum, Placement.class, "Placement");
		addEEnumLiteral(placementEEnum, Placement.TOP);
		addEEnumLiteral(placementEEnum, Placement.RIGHT);
		addEEnumLiteral(placementEEnum, Placement.BOTTOM);
		addEEnumLiteral(placementEEnum, Placement.LEFT);
		// Create resource
		createResource(eNS_URI);
		// Create annotations
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// subsets
		createSubsetsAnnotations();
		// union
		createUnionAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL
		createOCLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/uml2/2.0.0/UML</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createUMLAnnotations() {
		String source = "http://www.eclipse.org/uml2/2.0.0/UML";
		addAnnotation(this, source, new String[]{ "originalName", "UMLDI" });
		addAnnotation(getUmlStyle__FontsizePositive__DiagnosticChain_Map(), source, new String[]{ "originalName", "fontsize_positive" });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";
		addAnnotation(this, source, new String[]{ "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL" });
	}

	/**
	 * Initializes the annotations for <b>subsets</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createSubsetsAnnotations() {
		String source = "subsets";
		addAnnotation(getUmlDiagram_TopUmlDiagramElement(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getUmlDiagramElement_UmlModelElement(), source, new String[]{}, new URI[]{ URI.createURI(DIPackage.eNS_URI).appendFragment("//DiagramElement/modelElement") });
		addAnnotation(getUmlDiagramElement_SharedUmlStyle(), source, new String[]{}, new URI[]{ URI.createURI(DIPackage.eNS_URI).appendFragment("//DiagramElement/sharedStyle") });
		addAnnotation(getUmlDiagramElement_LocalUmlStyle(), source, new String[]{}, new URI[]{ URI.createURI(DIPackage.eNS_URI).appendFragment("//DiagramElement/localStyle") });
		addAnnotation(getUmlDiagramElement_OwnedUmlDiagramElement(), source, new String[]{}, new URI[]{ URI.createURI(DIPackage.eNS_URI).appendFragment("//DiagramElement/ownedDiagramElement") });
		addAnnotation(getUmlDiagramElement_OwningUmlDiagramElement(), source, new String[]{}, new URI[]{ URI.createURI(DIPackage.eNS_URI).appendFragment("//DiagramElement/owningDiagramElement") });
		addAnnotation(getUmlDiagramElement_TargetUmlEdge(), source, new String[]{}, new URI[]{ URI.createURI(DIPackage.eNS_URI).appendFragment("//DiagramElement/targetEdge") });
		addAnnotation(getUmlDiagramElement_SourceUmlEdge(), source, new String[]{}, new URI[]{ URI.createURI(DIPackage.eNS_URI).appendFragment("//DiagramElement/sourceEdge") });
		addAnnotation(getUmlEdge_SourceUmlDiagramElement(), source, new String[]{}, new URI[]{ URI.createURI(DIPackage.eNS_URI).appendFragment("//Edge/sourceDiagramElement") });
		addAnnotation(getUmlEdge_TargetUmlDiagramElement(), source, new String[]{}, new URI[]{ URI.createURI(DIPackage.eNS_URI).appendFragment("//Edge/targetDiagramElement") });
		addAnnotation(getTopUmlDiagramElement_UmlDiagram(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getTopUmlDiagramElement_DiagramCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getTopUmlDiagramElement_MainLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getStereotypedDiagramElement_StereotypeLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getStereotypeLabel_StereotypedDiagramElement(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getDiagramCompartment_TopUmlDiagramElement(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getMainLabel_TopUmlDiagramElement(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getUmlShape_StereotypeCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getStereotypeCompartment_UmlShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getListCompartment_ListItemLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getListItemLabel_ListCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getClassifierShape_OwnedUseCaseCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getClassifierShape_UseCaseCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getTemplateableElementShape_TemplateParameterCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getTemplateParameterCompartment_TemplateableElementShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getOwnedUseCaseCompartment_ClassifierShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getUseCaseCompartment_ClassifierShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getElementWithPackagedElementsShape_PackagedElementCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getPackagedElementCompartment_ElementWithPackagedElementsShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getAttributeCompartment_ClassifierWithAttributesShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getClassifierWithAttributesShape_AttributeCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getOperationCompartment_ClassifierWithOperationsShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getClassifierWithOperationsShape_OperationCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getReceptionCompartment_ClassifierWithReceptionShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getClassifierWithReceptionsShape_ReceptionCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getLiteralCompartment_EnumerationShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getEnumerationShape_LiteralCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getRoleLabel_AssociationEdge(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getRoleLabel_InstanceSpecificationEdge(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getRoleLabel_RoleBindingEdge(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getAssociationEdge_EndMultiplicityLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getAssociationEdge_EndConstraintLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getAssociationEdge_EndRoleLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getMultiplicityLabel_PropertyEdge(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getMultiplicityLabel_ConnectorEdge(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getMultiplicityLabel_AssociationEdge(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getPropertyEdge_ConstraintLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getPropertyEdge_MultiplicityLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getConstraintLabel_AssociationEdge(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getConstraintLabel_GeneralizationSetEdge(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getConstraintLabel_ObjectNodeShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getConstraintLabel_LifelineShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getConstraintLabel_ActionShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getConstraintLabel_PropertyEdge(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getGeneralizationSetEdge_PowerLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getGeneralizationSetEdge_ConstraintLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getPowerLabel_GeneralizationSetEdge(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getObjectNodeShape_SelectionLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getObjectNodeShape_ConstraintLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getSelectionLabel_ObjectFlowEdge(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getSelectionLabel_ObjectNodeShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getObjectFlowEdge_TransformationLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getObjectFlowEdge_SelectionLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getActivityEdgeEdge_GuardLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getActivityEdgeEdge_WeightLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getGuardLabel_ActivityEdgeEdge(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getWeightLabel_ActivityEdgeEdge(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getTransformationLabel_ObjectFlowEdge(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getLifelineShape_SubfragmentShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getLifelineShape_NestingLifelineShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getLifelineShape_NestedLifelineShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getLifelineShape_ConstraintLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getInteractionFragmentShape_LifelineShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getActionShape_PinShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getActionShape_ConditionLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getPinShape_ActionShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getConnectorEdge_EndMultiplicityLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getInstanceSpecificationEdge_EndRoleLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getDependencyEdge_RoleLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getInstanceSpecificationShape_SlotCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getDeploymentTargetShape_DeployedArtifactCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getDeployedArtifactCompartment_DeploymentTargetShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getSlotCompartment_InstanceSpecificationShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getElementWithPortsShape_PortShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getElementWithStructureShape_StructureCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getStructureCompartment_ElementWithStructureShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getPortShape_ElementWithPortsShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getClassifierWithNestedClassifiersShape_NestedClassifierCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getNestedClassifierCompartment_ClassifierWithNestedClassifiersShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getBehavioredClassifierShape_OwnedBehaviorCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getOwnedBehaviorCompartment_BehavioredClassifierShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getInformationFlowEdge_ConveyedLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getConveyedLabel_InformationFlowEdge(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getArtifactShape_NestedArtifactCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getNestedArtifactCompartment_ArtifactShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getCollaborationShape_ReceptionCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getNodeShape_NestedNodeCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getNestedNodeCompartment_NodeShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getActivityShape_ParameterCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getActivityShape_PostConditionCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getActivityShape_PreConditionCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getActivityShape_ActivityParameterNodeShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getElementWithActivityNodesShape_ActivityNodeCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getActivityNodeCompartment_ElementWithActivityNodesShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getParameterCompartment_ActivityShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getPostConditionCompartment_ActivityShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getPreConditionCompartment_ActivityShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getActivityParameterNodeShape_ActivityShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getInteractionFragmentWithSubfragmentsShape_SubfragmentCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getSubfragmentCompartment_InteractionFragmentWithSubfragmentsShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getInteractionFragmentWithGatesShape_GateShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getGateShape_InteractionFragmentWithGatesShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getBaseStateShape_ConnectionPointShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getBaseStateShape_RegionCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getPseudostateShape_BaseStateShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getRegionCompartment_BaseStateShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getExtensionPointCompartment_UseCaseShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getUseCaseShape_ExtensionPointCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getInternalBehaviorCompartment_StateShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getStateShape_ConnectionPointReferenceShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getStateShape_InternalTransitionCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getStateShape_DeferrableTriggerCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getStateShape_InternalBehaviorCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getConnectionPointReferenceShape_StateShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getInternalTransitionCompartment_StateShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getDeferrableTriggerCompartment_StateShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getRegionShape_SubvertexCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getSubvertexCompartment_RegionShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getExceptionHandlerEdge_TypeLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getExceptionHandlerEdge_IconLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getTypeLabel_InteractionUseShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getTypeLabel_ExceptionHandlerEdge(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getInteractionUseShape_TypeLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getIconLabel_ExceptionHandlerEdge(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getSubpartitionCompartment_ActivityPartitionShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getActivityPartitionShape_SubpartitionCompartment(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getExpansionRegionShape_ExpansionNodeShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getExpansionNodeShape_ExpansionRegionShape(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
		addAnnotation(getPathEdge_MessageLabel(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/ownedUmlDiagramElement") });
		addAnnotation(getMessageLabel_PathEdge(), source, new String[]{}, new URI[]{ URI.createURI(eNS_URI).appendFragment("//UmlDiagramElement/owningUmlDiagramElement") });
	}

	/**
	 * Initializes the annotations for <b>union</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createUnionAnnotations() {
		String source = "union";
		addAnnotation(getUmlDiagramElement_OwnedUmlDiagramElement(), source, new String[]{});
		addAnnotation(getUmlDiagramElement_OwningUmlDiagramElement(), source, new String[]{});
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createOCLAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL";
		addAnnotation(getUmlStyle__FontsizePositive__DiagnosticChain_Map(), source, new String[]{ "body", "fontSize > 0" });
	}
} //UMLDIPackageImpl
