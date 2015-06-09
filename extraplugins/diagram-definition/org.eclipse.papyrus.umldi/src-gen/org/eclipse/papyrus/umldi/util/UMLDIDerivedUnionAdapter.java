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
package org.eclipse.papyrus.umldi.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.dd.di.DIPackage;
import org.eclipse.papyrus.umldi.AbstractionEdge;
import org.eclipse.papyrus.umldi.ActionShape;
import org.eclipse.papyrus.umldi.ActivityDiagram;
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
import org.eclipse.papyrus.umldi.ClassDiagram;
import org.eclipse.papyrus.umldi.ClassShape;
import org.eclipse.papyrus.umldi.CollaborationShape;
import org.eclipse.papyrus.umldi.CollaborationUseShape;
import org.eclipse.papyrus.umldi.CombinedFragmentShape;
import org.eclipse.papyrus.umldi.CommentShape;
import org.eclipse.papyrus.umldi.CommunicationDiagram;
import org.eclipse.papyrus.umldi.CommunicationPathEdge;
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
import org.eclipse.papyrus.umldi.DeviceShape;
import org.eclipse.papyrus.umldi.DurationConstraintShape;
import org.eclipse.papyrus.umldi.DurationObservationShape;
import org.eclipse.papyrus.umldi.DurationShape;
import org.eclipse.papyrus.umldi.ElementImportEdge;
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
import org.eclipse.papyrus.umldi.InteractionFragmentShape;
import org.eclipse.papyrus.umldi.InteractionOperandShape;
import org.eclipse.papyrus.umldi.InteractionOverviewDiagram;
import org.eclipse.papyrus.umldi.InteractionShape;
import org.eclipse.papyrus.umldi.InteractionUseShape;
import org.eclipse.papyrus.umldi.InterfaceRealizationEdge;
import org.eclipse.papyrus.umldi.InterfaceShape;
import org.eclipse.papyrus.umldi.InternalBehaviorCompartment;
import org.eclipse.papyrus.umldi.InternalTransitionCompartment;
import org.eclipse.papyrus.umldi.LifelineShape;
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
import org.eclipse.papyrus.umldi.StructureCompartment;
import org.eclipse.papyrus.umldi.StructuredActivityNodeShape;
import org.eclipse.papyrus.umldi.SubfragmentCompartment;
import org.eclipse.papyrus.umldi.SubpartitionCompartment;
import org.eclipse.papyrus.umldi.SubstitutionEdge;
import org.eclipse.papyrus.umldi.SubvertexCompartment;
import org.eclipse.papyrus.umldi.TemplateBindingEdge;
import org.eclipse.papyrus.umldi.TemplateParameterCompartment;
import org.eclipse.papyrus.umldi.TimeConstraintShape;
import org.eclipse.papyrus.umldi.TimeExpressionShape;
import org.eclipse.papyrus.umldi.TimeObservationShape;
import org.eclipse.papyrus.umldi.TimeObservationShape_TimeObservationShape;
import org.eclipse.papyrus.umldi.TimingDiagram;
import org.eclipse.papyrus.umldi.TransformationLabel;
import org.eclipse.papyrus.umldi.TransitionEdge;
import org.eclipse.papyrus.umldi.TypeLabel;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UsageEdge;
import org.eclipse.papyrus.umldi.UseCaseCompartment;
import org.eclipse.papyrus.umldi.UseCaseDiagram;
import org.eclipse.papyrus.umldi.UseCaseShape;
import org.eclipse.papyrus.umldi.WeightLabel;

/**
 * <!-- begin-user-doc -->
 * An adapter that propagates notifications for derived unions.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.umldi.UMLDIPackage
 * @generated
 */
public class UMLDIDerivedUnionAdapter extends AdapterImpl {

	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static UMLDIPackage modelPackage;

	/**
	 * Creates an instance of the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UMLDIDerivedUnionAdapter() {
		if(modelPackage == null) {
			modelPackage = UMLDIPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> with the appropriate model class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		Object notifier = notification.getNotifier();
		if(notifier instanceof EObject) {
			EClass eClass = ((EObject)notifier).eClass();
			if(eClass.eContainer() == modelPackage) {
				notifyChanged(notification, eClass);
			}
		}
	}

	/**
	 * Calls <code>notifyXXXChanged</code> for the corresponding class of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyChanged(Notification notification, EClass eClass) {
		switch(eClass.getClassifierID()) {
		case UMLDIPackage.STEREOTYPE_LABEL:
			notifyStereotypeLabelChanged(notification, eClass);
			break;
		case UMLDIPackage.MAIN_LABEL:
			notifyMainLabelChanged(notification, eClass);
			break;
		case UMLDIPackage.STEREOTYPE_COMPARTMENT:
			notifyStereotypeCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.LIST_ITEM_LABEL:
			notifyListItemLabelChanged(notification, eClass);
			break;
		case UMLDIPackage.CLASS_DIAGRAM:
			notifyClassDiagramChanged(notification, eClass);
			break;
		case UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT:
			notifyTemplateParameterCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.OWNED_USE_CASE_COMPARTMENT:
			notifyOwnedUseCaseCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.USE_CASE_COMPARTMENT:
			notifyUseCaseCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.PACKAGE_SHAPE:
			notifyPackageShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT:
			notifyPackagedElementCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.CONSTRAINT_SHAPE:
			notifyConstraintShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.ATTRIBUTE_COMPARTMENT:
			notifyAttributeCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.OPERATION_COMPARTMENT:
			notifyOperationCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.RECEPTION_COMPARTMENT:
			notifyReceptionCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.LITERAL_COMPARTMENT:
			notifyLiteralCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.ENUMERATION_SHAPE:
			notifyEnumerationShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.ROLE_LABEL:
			notifyRoleLabelChanged(notification, eClass);
			break;
		case UMLDIPackage.ASSOCIATION_EDGE:
			notifyAssociationEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.MULTIPLICITY_LABEL:
			notifyMultiplicityLabelChanged(notification, eClass);
			break;
		case UMLDIPackage.PROPERTY_EDGE:
			notifyPropertyEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.CONSTRAINT_LABEL:
			notifyConstraintLabelChanged(notification, eClass);
			break;
		case UMLDIPackage.GENERALIZATION_SET_EDGE:
			notifyGeneralizationSetEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.POWER_LABEL:
			notifyPowerLabelChanged(notification, eClass);
			break;
		case UMLDIPackage.OBJECT_NODE_SHAPE:
			notifyObjectNodeShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.ACTIVITY_NODE_SHAPE:
			notifyActivityNodeShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.SELECTION_LABEL:
			notifySelectionLabelChanged(notification, eClass);
			break;
		case UMLDIPackage.OBJECT_FLOW_EDGE:
			notifyObjectFlowEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.GUARD_LABEL:
			notifyGuardLabelChanged(notification, eClass);
			break;
		case UMLDIPackage.WEIGHT_LABEL:
			notifyWeightLabelChanged(notification, eClass);
			break;
		case UMLDIPackage.TRANSFORMATION_LABEL:
			notifyTransformationLabelChanged(notification, eClass);
			break;
		case UMLDIPackage.LIFELINE_SHAPE:
			notifyLifelineShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.INTERACTION_FRAGMENT_SHAPE:
			notifyInteractionFragmentShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.ACTION_SHAPE:
			notifyActionShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.PIN_SHAPE:
			notifyPinShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.CONNECTOR_EDGE:
			notifyConnectorEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_EDGE:
			notifyInstanceSpecificationEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.DEPENDENCY_EDGE:
			notifyDependencyEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_SHAPE:
			notifyInstanceSpecificationShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT:
			notifyDeployedArtifactCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.SLOT_COMPARTMENT:
			notifySlotCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.CLASS_SHAPE:
			notifyClassShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.STRUCTURE_COMPARTMENT:
			notifyStructureCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.PORT_SHAPE:
			notifyPortShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT:
			notifyNestedClassifierCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT:
			notifyOwnedBehaviorCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.INTERFACE_SHAPE:
			notifyInterfaceShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.DATA_TYPE_SHAPE:
			notifyDataTypeShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.PRIMITIVE_TYPE_SHAPE:
			notifyPrimitiveTypeShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.SIGNAL_SHAPE:
			notifySignalShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.MODEL_SHAPE:
			notifyModelShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.CONTAINMENT_EDGE:
			notifyContainmentEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.GENERALIZATION_EDGE:
			notifyGeneralizationEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.REALIZATION_EDGE:
			notifyRealizationEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.ABSTRACTION_EDGE:
			notifyAbstractionEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.INTERFACE_REALIZATION_EDGE:
			notifyInterfaceRealizationEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.USAGE_EDGE:
			notifyUsageEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.ELEMENT_IMPORT_EDGE:
			notifyElementImportEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.PACKAGE_IMPORT_EDGE:
			notifyPackageImportEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.PACKAGE_MERGE_EDGE:
			notifyPackageMergeEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.SUBSTITUTION_EDGE:
			notifySubstitutionEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.INFORMATION_FLOW_EDGE:
			notifyInformationFlowEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.CONVEYED_LABEL:
			notifyConveyedLabelChanged(notification, eClass);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_EDGE:
			notifyAssociationClassEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.COMMENT_SHAPE:
			notifyCommentShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.ATTACHMENT_EDGE:
			notifyAttachmentEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE:
			notifyAssociationClassShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.COMPONENT_SHAPE:
			notifyComponentShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.INFORMATION_ITEM_SHAPE:
			notifyInformationItemShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.REPRESENTATION_EDGE:
			notifyRepresentationEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.ASSOCIATION_SHAPE:
			notifyAssociationShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.DEPENDENCY_SHAPE:
			notifyDependencyShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE:
			notifyTimeObservationShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE_TIME_OBSERVATION_SHAPE:
			notifyTimeObservationShape_TimeObservationShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.DURATION_OBSERVATION_SHAPE:
			notifyDurationObservationShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.PACKAGE_DIAGRAM:
			notifyPackageDiagramChanged(notification, eClass);
			break;
		case UMLDIPackage.PROFILE_DIAGRAM:
			notifyProfileDiagramChanged(notification, eClass);
			break;
		case UMLDIPackage.COMPOSITE_STRUCTURE_DIAGRAM:
			notifyCompositeStructureDiagramChanged(notification, eClass);
			break;
		case UMLDIPackage.DEPLOYMENT_DIAGRAM:
			notifyDeploymentDiagramChanged(notification, eClass);
			break;
		case UMLDIPackage.COMPONENT_DIAGRAM:
			notifyComponentDiagramChanged(notification, eClass);
			break;
		case UMLDIPackage.OBJECT_DIAGRAM:
			notifyObjectDiagramChanged(notification, eClass);
			break;
		case UMLDIPackage.PROFILE_SHAPE:
			notifyProfileShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.PROFILE_APPLICATION_EDGE:
			notifyProfileApplicationEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.EXTENSION_EDGE:
			notifyExtensionEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.USE_CASE_DIAGRAM:
			notifyUseCaseDiagramChanged(notification, eClass);
			break;
		case UMLDIPackage.ARTIFACT_SHAPE:
			notifyArtifactShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT:
			notifyNestedArtifactCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.COMPONENT_REALIZATION_EDGE:
			notifyComponentRealizationEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.MANIFESTATION_EDGE:
			notifyManifestationEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.PROPERTY_SHAPE:
			notifyPropertyShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.COLLABORATION_SHAPE:
			notifyCollaborationShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.COLLABORATION_USE_SHAPE:
			notifyCollaborationUseShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.TEMPLATE_BINDING_EDGE:
			notifyTemplateBindingEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.STEREOTYPE_SHAPE:
			notifyStereotypeShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.NODE_SHAPE:
			notifyNodeShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.NESTED_NODE_COMPARTMENT:
			notifyNestedNodeCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.DEVICE_SHAPE:
			notifyDeviceShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE:
			notifyExecutionEnvironmentShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE:
			notifyActivityShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.ACTIVITY_NODE_COMPARTMENT:
			notifyActivityNodeCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.PARAMETER_COMPARTMENT:
			notifyParameterCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.POST_CONDITION_COMPARTMENT:
			notifyPostConditionCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.PRE_CONDITION_COMPARTMENT:
			notifyPreConditionCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.ACTIVITY_PARAMETER_NODE_SHAPE:
			notifyActivityParameterNodeShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.INTERACTION_SHAPE:
			notifyInteractionShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.SUBFRAGMENT_COMPARTMENT:
			notifySubfragmentCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.GATE_SHAPE:
			notifyGateShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE:
			notifyOpaqueBehaviorShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE:
			notifyFunctionBehaviorShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE:
			notifyStateMachineShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.PSEUDOSTATE_SHAPE:
			notifyPseudostateShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.REGION_COMPARTMENT:
			notifyRegionCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE:
			notifyProtocolStateMachineShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.DEPLOYMENT_SPECIFICATION_SHAPE:
			notifyDeploymentSpecificationShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.COMMUNICATION_PATH_EDGE:
			notifyCommunicationPathEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.DEPLOYMENT_EDGE:
			notifyDeploymentEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.ACTOR_SHAPE:
			notifyActorShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.EXTENSION_POINT_COMPARTMENT:
			notifyExtensionPointCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.USE_CASE_SHAPE:
			notifyUseCaseShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.INCLUDE_EDGE:
			notifyIncludeEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.EXTEND_EDGE:
			notifyExtendEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.STATE_MACHINE_DIAGRAM:
			notifyStateMachineDiagramChanged(notification, eClass);
			break;
		case UMLDIPackage.ACTIVITY_DIAGRAM:
			notifyActivityDiagramChanged(notification, eClass);
			break;
		case UMLDIPackage.SEQUENCE_DIAGRAM:
			notifySequenceDiagramChanged(notification, eClass);
			break;
		case UMLDIPackage.COMMUNICATION_DIAGRAM:
			notifyCommunicationDiagramChanged(notification, eClass);
			break;
		case UMLDIPackage.TIMING_DIAGRAM:
			notifyTimingDiagramChanged(notification, eClass);
			break;
		case UMLDIPackage.INTERACTION_OVERVIEW_DIAGRAM:
			notifyInteractionOverviewDiagramChanged(notification, eClass);
			break;
		case UMLDIPackage.INTERNAL_BEHAVIOR_COMPARTMENT:
			notifyInternalBehaviorCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.STATE_SHAPE:
			notifyStateShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.CONNECTION_POINT_REFERENCE_SHAPE:
			notifyConnectionPointReferenceShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.INTERNAL_TRANSITION_COMPARTMENT:
			notifyInternalTransitionCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.DEFERRABLE_TRIGGER_COMPARTMENT:
			notifyDeferrableTriggerCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.REGION_SHAPE:
			notifyRegionShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.SUBVERTEX_COMPARTMENT:
			notifySubvertexCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.TRANSITION_EDGE:
			notifyTransitionEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.CONTROL_FLOW_EDGE:
			notifyControlFlowEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.ACTIVITY_GROUP_SHAPE:
			notifyActivityGroupShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.EXCEPTION_HANDLER_EDGE:
			notifyExceptionHandlerEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.TYPE_LABEL:
			notifyTypeLabelChanged(notification, eClass);
			break;
		case UMLDIPackage.INTERACTION_USE_SHAPE:
			notifyInteractionUseShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.ICON_LABEL:
			notifyIconLabelChanged(notification, eClass);
			break;
		case UMLDIPackage.SUBPARTITION_COMPARTMENT:
			notifySubpartitionCompartmentChanged(notification, eClass);
			break;
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE:
			notifyActivityPartitionShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE:
			notifyStructuredActivityNodeShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.EXPANSION_REGION_SHAPE:
			notifyExpansionRegionShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.EXPANSION_NODE_SHAPE:
			notifyExpansionNodeShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.MESSAGE_EDGE:
			notifyMessageEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.GENERAL_ORDERING_EDGE:
			notifyGeneralOrderingEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE:
			notifyCombinedFragmentShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.INTERACTION_OPERAND_SHAPE:
			notifyInteractionOperandShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.EXECUTION_SPECIFICATION_SHAPE:
			notifyExecutionSpecificationShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.DURATION_CONSTRAINT_SHAPE:
			notifyDurationConstraintShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.TIME_CONSTRAINT_SHAPE:
			notifyTimeConstraintShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.TIME_EXPRESSION_SHAPE:
			notifyTimeExpressionShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.DURATION_SHAPE:
			notifyDurationShapeChanged(notification, eClass);
			break;
		case UMLDIPackage.PATH_EDGE:
			notifyPathEdgeChanged(notification, eClass);
			break;
		case UMLDIPackage.MESSAGE_LABEL:
			notifyMessageLabelChanged(notification, eClass);
			break;
		case UMLDIPackage.STATE_INVARIANT_SHAPE:
			notifyStateInvariantShapeChanged(notification, eClass);
			break;
		}
	}

	/**
	 * Does nothing; clients may override so that it does something.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @param derivedUnion
	 *        the derived union affected by the change.
	 * @generated
	 */
	public void notifyChanged(Notification notification, EClass eClass, EStructuralFeature derivedUnion) {
		// Do nothing.
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyClassDiagramChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ClassDiagram.class)) {
		case UMLDIPackage.CLASS_DIAGRAM__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.CLASS_DIAGRAM__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.CLASS_DIAGRAM__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.CLASS_DIAGRAM__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CLASS_DIAGRAM__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CLASS_DIAGRAM__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.CLASS_DIAGRAM__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.CLASS_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyStereotypeCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(StereotypeCompartment.class)) {
		case UMLDIPackage.STEREOTYPE_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.STEREOTYPE_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.STEREOTYPE_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.STEREOTYPE_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.STEREOTYPE_COMPARTMENT__LIST_ITEM_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_COMPARTMENT__UML_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPackageShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(PackageShape.class)) {
		case UMLDIPackage.PACKAGE_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.PACKAGE_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.PACKAGE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.PACKAGE_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.PACKAGE_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_SHAPE__PACKAGED_ELEMENT_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyConstraintShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ConstraintShape.class)) {
		case UMLDIPackage.CONSTRAINT_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.CONSTRAINT_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.CONSTRAINT_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.CONSTRAINT_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONSTRAINT_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONSTRAINT_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.CONSTRAINT_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.CONSTRAINT_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONSTRAINT_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONSTRAINT_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONSTRAINT_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONSTRAINT_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAttributeCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(AttributeCompartment.class)) {
		case UMLDIPackage.ATTRIBUTE_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.ATTRIBUTE_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.ATTRIBUTE_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.ATTRIBUTE_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ATTRIBUTE_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ATTRIBUTE_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.ATTRIBUTE_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.ATTRIBUTE_COMPARTMENT__LIST_ITEM_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ATTRIBUTE_COMPARTMENT__CLASSIFIER_WITH_ATTRIBUTES_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyOperationCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(OperationCompartment.class)) {
		case UMLDIPackage.OPERATION_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.OPERATION_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.OPERATION_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.OPERATION_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OPERATION_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OPERATION_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.OPERATION_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.OPERATION_COMPARTMENT__LIST_ITEM_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OPERATION_COMPARTMENT__CLASSIFIER_WITH_OPERATIONS_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyReceptionCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ReceptionCompartment.class)) {
		case UMLDIPackage.RECEPTION_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.RECEPTION_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.RECEPTION_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.RECEPTION_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.RECEPTION_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.RECEPTION_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.RECEPTION_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.RECEPTION_COMPARTMENT__LIST_ITEM_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.RECEPTION_COMPARTMENT__CLASSIFIER_WITH_RECEPTION_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyLiteralCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(LiteralCompartment.class)) {
		case UMLDIPackage.LITERAL_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.LITERAL_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.LITERAL_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.LITERAL_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.LITERAL_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.LITERAL_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.LITERAL_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.LITERAL_COMPARTMENT__LIST_ITEM_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.LITERAL_COMPARTMENT__ENUMERATION_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPackagedElementCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(PackagedElementCompartment.class)) {
		case UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT__ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyMainLabelChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(MainLabel.class)) {
		case UMLDIPackage.MAIN_LABEL__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.MAIN_LABEL__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.MAIN_LABEL__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.MAIN_LABEL__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MAIN_LABEL__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MAIN_LABEL__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.MAIN_LABEL__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.MAIN_LABEL__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPropertyEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(PropertyEdge.class)) {
		case UMLDIPackage.PROPERTY_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.PROPERTY_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.PROPERTY_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.PROPERTY_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROPERTY_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROPERTY_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.PROPERTY_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.PROPERTY_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROPERTY_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROPERTY_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROPERTY_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROPERTY_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROPERTY_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROPERTY_EDGE__CONSTRAINT_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROPERTY_EDGE__MULTIPLICITY_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyConstraintLabelChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ConstraintLabel.class)) {
		case UMLDIPackage.CONSTRAINT_LABEL__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.CONSTRAINT_LABEL__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.CONSTRAINT_LABEL__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.CONSTRAINT_LABEL__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONSTRAINT_LABEL__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONSTRAINT_LABEL__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.CONSTRAINT_LABEL__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.CONSTRAINT_LABEL__ASSOCIATION_EDGE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONSTRAINT_LABEL__GENERALIZATION_SET_EDGE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONSTRAINT_LABEL__OBJECT_NODE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONSTRAINT_LABEL__LIFELINE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONSTRAINT_LABEL__ACTION_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONSTRAINT_LABEL__PROPERTY_EDGE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyInstanceSpecificationEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(InstanceSpecificationEdge.class)) {
		case UMLDIPackage.INSTANCE_SPECIFICATION_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_EDGE__END_ROLE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyInstanceSpecificationShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(InstanceSpecificationShape.class)) {
		case UMLDIPackage.INSTANCE_SPECIFICATION_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INSTANCE_SPECIFICATION_SHAPE__SLOT_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDeployedArtifactCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(DeployedArtifactCompartment.class)) {
		case UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__LIST_ITEM_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT__DEPLOYMENT_TARGET_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySlotCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(SlotCompartment.class)) {
		case UMLDIPackage.SLOT_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.SLOT_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.SLOT_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.SLOT_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SLOT_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SLOT_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.SLOT_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.SLOT_COMPARTMENT__LIST_ITEM_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SLOT_COMPARTMENT__INSTANCE_SPECIFICATION_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyClassShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ClassShape.class)) {
		case UMLDIPackage.CLASS_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.CLASS_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.CLASS_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.CLASS_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CLASS_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CLASS_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.CLASS_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.CLASS_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CLASS_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CLASS_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CLASS_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CLASS_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CLASS_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CLASS_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CLASS_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CLASS_SHAPE__ATTRIBUTE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CLASS_SHAPE__OPERATION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CLASS_SHAPE__RECEPTION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CLASS_SHAPE__NESTED_CLASSIFIER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CLASS_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CLASS_SHAPE__STRUCTURE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CLASS_SHAPE__PORT_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyStructureCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(StructureCompartment.class)) {
		case UMLDIPackage.STRUCTURE_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.STRUCTURE_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.STRUCTURE_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.STRUCTURE_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STRUCTURE_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STRUCTURE_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.STRUCTURE_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.STRUCTURE_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STRUCTURE_COMPARTMENT__ELEMENT_WITH_STRUCTURE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPortShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(PortShape.class)) {
		case UMLDIPackage.PORT_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.PORT_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.PORT_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.PORT_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PORT_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PORT_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.PORT_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.PORT_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PORT_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PORT_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PORT_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PORT_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PORT_SHAPE__ELEMENT_WITH_PORTS_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyNestedClassifierCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(NestedClassifierCompartment.class)) {
		case UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__LIST_ITEM_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT__CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyOwnedBehaviorCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(OwnedBehaviorCompartment.class)) {
		case UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__LIST_ITEM_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT__BEHAVIORED_CLASSIFIER_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyInterfaceShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(InterfaceShape.class)) {
		case UMLDIPackage.INTERFACE_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.INTERFACE_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.INTERFACE_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.INTERFACE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERFACE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERFACE_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.INTERFACE_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.INTERFACE_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERFACE_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERFACE_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERFACE_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERFACE_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERFACE_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERFACE_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERFACE_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERFACE_SHAPE__ATTRIBUTE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERFACE_SHAPE__OPERATION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERFACE_SHAPE__RECEPTION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERFACE_SHAPE__NESTED_CLASSIFIER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDataTypeShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(DataTypeShape.class)) {
		case UMLDIPackage.DATA_TYPE_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.DATA_TYPE_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.DATA_TYPE_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.DATA_TYPE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DATA_TYPE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DATA_TYPE_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.DATA_TYPE_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.DATA_TYPE_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DATA_TYPE_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DATA_TYPE_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DATA_TYPE_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DATA_TYPE_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DATA_TYPE_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DATA_TYPE_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DATA_TYPE_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DATA_TYPE_SHAPE__ATTRIBUTE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DATA_TYPE_SHAPE__OPERATION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPrimitiveTypeShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(PrimitiveTypeShape.class)) {
		case UMLDIPackage.PRIMITIVE_TYPE_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.PRIMITIVE_TYPE_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.PRIMITIVE_TYPE_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.PRIMITIVE_TYPE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PRIMITIVE_TYPE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PRIMITIVE_TYPE_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.PRIMITIVE_TYPE_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.PRIMITIVE_TYPE_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PRIMITIVE_TYPE_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PRIMITIVE_TYPE_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PRIMITIVE_TYPE_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PRIMITIVE_TYPE_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PRIMITIVE_TYPE_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PRIMITIVE_TYPE_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PRIMITIVE_TYPE_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PRIMITIVE_TYPE_SHAPE__ATTRIBUTE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PRIMITIVE_TYPE_SHAPE__OPERATION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyEnumerationShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(EnumerationShape.class)) {
		case UMLDIPackage.ENUMERATION_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.ENUMERATION_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.ENUMERATION_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.ENUMERATION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ENUMERATION_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ENUMERATION_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.ENUMERATION_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.ENUMERATION_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ENUMERATION_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ENUMERATION_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ENUMERATION_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ENUMERATION_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ENUMERATION_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ENUMERATION_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ENUMERATION_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ENUMERATION_SHAPE__LITERAL_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyRoleLabelChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(RoleLabel.class)) {
		case UMLDIPackage.ROLE_LABEL__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.ROLE_LABEL__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.ROLE_LABEL__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.ROLE_LABEL__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ROLE_LABEL__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ROLE_LABEL__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.ROLE_LABEL__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.ROLE_LABEL__ASSOCIATION_EDGE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ROLE_LABEL__INSTANCE_SPECIFICATION_EDGE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ROLE_LABEL__ROLE_BINDING_EDGE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySignalShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(SignalShape.class)) {
		case UMLDIPackage.SIGNAL_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.SIGNAL_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.SIGNAL_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.SIGNAL_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SIGNAL_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SIGNAL_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.SIGNAL_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.SIGNAL_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SIGNAL_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SIGNAL_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SIGNAL_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SIGNAL_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SIGNAL_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SIGNAL_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SIGNAL_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SIGNAL_SHAPE__ATTRIBUTE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyModelShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ModelShape.class)) {
		case UMLDIPackage.MODEL_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.MODEL_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.MODEL_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.MODEL_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MODEL_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MODEL_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.MODEL_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.MODEL_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MODEL_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MODEL_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MODEL_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MODEL_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MODEL_SHAPE__PACKAGED_ELEMENT_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MODEL_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyContainmentEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ContainmentEdge.class)) {
		case UMLDIPackage.CONTAINMENT_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.CONTAINMENT_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.CONTAINMENT_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.CONTAINMENT_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONTAINMENT_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONTAINMENT_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.CONTAINMENT_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.CONTAINMENT_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONTAINMENT_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONTAINMENT_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONTAINMENT_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONTAINMENT_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONTAINMENT_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGeneralizationEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(GeneralizationEdge.class)) {
		case UMLDIPackage.GENERALIZATION_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.GENERALIZATION_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.GENERALIZATION_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.GENERALIZATION_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GENERALIZATION_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GENERALIZATION_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.GENERALIZATION_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.GENERALIZATION_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GENERALIZATION_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GENERALIZATION_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GENERALIZATION_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GENERALIZATION_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GENERALIZATION_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAssociationEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(AssociationEdge.class)) {
		case UMLDIPackage.ASSOCIATION_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.ASSOCIATION_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.ASSOCIATION_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.ASSOCIATION_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.ASSOCIATION_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_EDGE__END_MULTIPLICITY_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_EDGE__END_CONSTRAINT_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_EDGE__END_ROLE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyMultiplicityLabelChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(MultiplicityLabel.class)) {
		case UMLDIPackage.MULTIPLICITY_LABEL__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.MULTIPLICITY_LABEL__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.MULTIPLICITY_LABEL__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.MULTIPLICITY_LABEL__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MULTIPLICITY_LABEL__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MULTIPLICITY_LABEL__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.MULTIPLICITY_LABEL__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.MULTIPLICITY_LABEL__PROPERTY_EDGE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MULTIPLICITY_LABEL__CONNECTOR_EDGE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MULTIPLICITY_LABEL__ASSOCIATION_EDGE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyRealizationEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(RealizationEdge.class)) {
		case UMLDIPackage.REALIZATION_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.REALIZATION_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.REALIZATION_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.REALIZATION_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REALIZATION_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REALIZATION_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.REALIZATION_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.REALIZATION_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REALIZATION_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REALIZATION_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REALIZATION_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REALIZATION_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REALIZATION_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REALIZATION_EDGE__ROLE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAbstractionEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(AbstractionEdge.class)) {
		case UMLDIPackage.ABSTRACTION_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.ABSTRACTION_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.ABSTRACTION_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.ABSTRACTION_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ABSTRACTION_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ABSTRACTION_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.ABSTRACTION_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.ABSTRACTION_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ABSTRACTION_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ABSTRACTION_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ABSTRACTION_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ABSTRACTION_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ABSTRACTION_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ABSTRACTION_EDGE__ROLE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDependencyEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(DependencyEdge.class)) {
		case UMLDIPackage.DEPENDENCY_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.DEPENDENCY_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.DEPENDENCY_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.DEPENDENCY_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPENDENCY_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPENDENCY_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.DEPENDENCY_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.DEPENDENCY_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPENDENCY_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPENDENCY_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPENDENCY_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPENDENCY_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPENDENCY_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPENDENCY_EDGE__ROLE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyInterfaceRealizationEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(InterfaceRealizationEdge.class)) {
		case UMLDIPackage.INTERFACE_REALIZATION_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.INTERFACE_REALIZATION_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.INTERFACE_REALIZATION_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.INTERFACE_REALIZATION_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERFACE_REALIZATION_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERFACE_REALIZATION_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.INTERFACE_REALIZATION_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.INTERFACE_REALIZATION_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERFACE_REALIZATION_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERFACE_REALIZATION_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERFACE_REALIZATION_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERFACE_REALIZATION_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERFACE_REALIZATION_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERFACE_REALIZATION_EDGE__ROLE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyUsageEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(UsageEdge.class)) {
		case UMLDIPackage.USAGE_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.USAGE_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.USAGE_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.USAGE_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USAGE_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USAGE_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.USAGE_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.USAGE_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USAGE_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USAGE_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USAGE_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USAGE_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USAGE_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USAGE_EDGE__ROLE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyElementImportEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ElementImportEdge.class)) {
		case UMLDIPackage.ELEMENT_IMPORT_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.ELEMENT_IMPORT_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.ELEMENT_IMPORT_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.ELEMENT_IMPORT_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ELEMENT_IMPORT_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ELEMENT_IMPORT_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.ELEMENT_IMPORT_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.ELEMENT_IMPORT_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ELEMENT_IMPORT_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ELEMENT_IMPORT_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ELEMENT_IMPORT_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ELEMENT_IMPORT_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ELEMENT_IMPORT_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPackageImportEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(PackageImportEdge.class)) {
		case UMLDIPackage.PACKAGE_IMPORT_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_IMPORT_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.PACKAGE_IMPORT_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.PACKAGE_IMPORT_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_IMPORT_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_IMPORT_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.PACKAGE_IMPORT_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.PACKAGE_IMPORT_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_IMPORT_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_IMPORT_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_IMPORT_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_IMPORT_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_IMPORT_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPackageMergeEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(PackageMergeEdge.class)) {
		case UMLDIPackage.PACKAGE_MERGE_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_MERGE_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.PACKAGE_MERGE_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.PACKAGE_MERGE_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_MERGE_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_MERGE_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.PACKAGE_MERGE_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.PACKAGE_MERGE_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_MERGE_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_MERGE_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_MERGE_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_MERGE_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_MERGE_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySubstitutionEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(SubstitutionEdge.class)) {
		case UMLDIPackage.SUBSTITUTION_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.SUBSTITUTION_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.SUBSTITUTION_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.SUBSTITUTION_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SUBSTITUTION_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SUBSTITUTION_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.SUBSTITUTION_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.SUBSTITUTION_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SUBSTITUTION_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SUBSTITUTION_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SUBSTITUTION_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SUBSTITUTION_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SUBSTITUTION_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SUBSTITUTION_EDGE__ROLE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyInformationFlowEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(InformationFlowEdge.class)) {
		case UMLDIPackage.INFORMATION_FLOW_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.INFORMATION_FLOW_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.INFORMATION_FLOW_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.INFORMATION_FLOW_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INFORMATION_FLOW_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INFORMATION_FLOW_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.INFORMATION_FLOW_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.INFORMATION_FLOW_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INFORMATION_FLOW_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INFORMATION_FLOW_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INFORMATION_FLOW_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INFORMATION_FLOW_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INFORMATION_FLOW_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INFORMATION_FLOW_EDGE__CONVEYED_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyConveyedLabelChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ConveyedLabel.class)) {
		case UMLDIPackage.CONVEYED_LABEL__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.CONVEYED_LABEL__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.CONVEYED_LABEL__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.CONVEYED_LABEL__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONVEYED_LABEL__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONVEYED_LABEL__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.CONVEYED_LABEL__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.CONVEYED_LABEL__INFORMATION_FLOW_EDGE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAssociationClassEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(AssociationClassEdge.class)) {
		case UMLDIPackage.ASSOCIATION_CLASS_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_EDGE__END_MULTIPLICITY_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_EDGE__END_CONSTRAINT_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_EDGE__END_ROLE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGeneralizationSetEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(GeneralizationSetEdge.class)) {
		case UMLDIPackage.GENERALIZATION_SET_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.GENERALIZATION_SET_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.GENERALIZATION_SET_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.GENERALIZATION_SET_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GENERALIZATION_SET_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GENERALIZATION_SET_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.GENERALIZATION_SET_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.GENERALIZATION_SET_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GENERALIZATION_SET_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GENERALIZATION_SET_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GENERALIZATION_SET_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GENERALIZATION_SET_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GENERALIZATION_SET_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GENERALIZATION_SET_EDGE__POWER_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GENERALIZATION_SET_EDGE__CONSTRAINT_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPowerLabelChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(PowerLabel.class)) {
		case UMLDIPackage.POWER_LABEL__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.POWER_LABEL__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.POWER_LABEL__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.POWER_LABEL__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.POWER_LABEL__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.POWER_LABEL__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.POWER_LABEL__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.POWER_LABEL__GENERALIZATION_SET_EDGE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyConnectorEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ConnectorEdge.class)) {
		case UMLDIPackage.CONNECTOR_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.CONNECTOR_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.CONNECTOR_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.CONNECTOR_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONNECTOR_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONNECTOR_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.CONNECTOR_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.CONNECTOR_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONNECTOR_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONNECTOR_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONNECTOR_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONNECTOR_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONNECTOR_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONNECTOR_EDGE__END_MULTIPLICITY_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyCommentShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(CommentShape.class)) {
		case UMLDIPackage.COMMENT_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.COMMENT_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.COMMENT_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.COMMENT_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMMENT_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMMENT_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.COMMENT_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.COMMENT_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMMENT_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMMENT_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMMENT_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMMENT_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAttachmentEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(AttachmentEdge.class)) {
		case UMLDIPackage.ATTACHMENT_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.ATTACHMENT_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.ATTACHMENT_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.ATTACHMENT_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ATTACHMENT_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ATTACHMENT_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.ATTACHMENT_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.ATTACHMENT_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ATTACHMENT_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ATTACHMENT_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ATTACHMENT_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ATTACHMENT_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ATTACHMENT_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAssociationClassShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(AssociationClassShape.class)) {
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE__ATTRIBUTE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE__OPERATION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE__RECEPTION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE__NESTED_CLASSIFIER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE__STRUCTURE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE__PORT_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyComponentShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ComponentShape.class)) {
		case UMLDIPackage.COMPONENT_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.COMPONENT_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.COMPONENT_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.COMPONENT_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.COMPONENT_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_SHAPE__ATTRIBUTE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_SHAPE__OPERATION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_SHAPE__RECEPTION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_SHAPE__NESTED_CLASSIFIER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_SHAPE__STRUCTURE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_SHAPE__PORT_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_SHAPE__PACKAGED_ELEMENT_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyInformationItemShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(InformationItemShape.class)) {
		case UMLDIPackage.INFORMATION_ITEM_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.INFORMATION_ITEM_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.INFORMATION_ITEM_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.INFORMATION_ITEM_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INFORMATION_ITEM_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INFORMATION_ITEM_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.INFORMATION_ITEM_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.INFORMATION_ITEM_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INFORMATION_ITEM_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INFORMATION_ITEM_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INFORMATION_ITEM_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INFORMATION_ITEM_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INFORMATION_ITEM_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INFORMATION_ITEM_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INFORMATION_ITEM_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyRepresentationEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(RepresentationEdge.class)) {
		case UMLDIPackage.REPRESENTATION_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.REPRESENTATION_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.REPRESENTATION_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.REPRESENTATION_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REPRESENTATION_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REPRESENTATION_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.REPRESENTATION_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.REPRESENTATION_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REPRESENTATION_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REPRESENTATION_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REPRESENTATION_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REPRESENTATION_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REPRESENTATION_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyAssociationShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(AssociationShape.class)) {
		case UMLDIPackage.ASSOCIATION_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.ASSOCIATION_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.ASSOCIATION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.ASSOCIATION_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.ASSOCIATION_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ASSOCIATION_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDependencyShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(DependencyShape.class)) {
		case UMLDIPackage.DEPENDENCY_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.DEPENDENCY_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.DEPENDENCY_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.DEPENDENCY_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPENDENCY_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPENDENCY_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.DEPENDENCY_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.DEPENDENCY_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPENDENCY_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPENDENCY_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPENDENCY_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPENDENCY_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyTimeObservationShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(TimeObservationShape.class)) {
		case UMLDIPackage.TIME_OBSERVATION_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyTimeObservationShape_TimeObservationShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(TimeObservationShape_TimeObservationShape.class)) {
		case UMLDIPackage.TIME_OBSERVATION_SHAPE_TIME_OBSERVATION_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE_TIME_OBSERVATION_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE_TIME_OBSERVATION_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE_TIME_OBSERVATION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE_TIME_OBSERVATION_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE_TIME_OBSERVATION_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE_TIME_OBSERVATION_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE_TIME_OBSERVATION_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE_TIME_OBSERVATION_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE_TIME_OBSERVATION_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE_TIME_OBSERVATION_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_OBSERVATION_SHAPE_TIME_OBSERVATION_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDurationObservationShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(DurationObservationShape.class)) {
		case UMLDIPackage.DURATION_OBSERVATION_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.DURATION_OBSERVATION_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.DURATION_OBSERVATION_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.DURATION_OBSERVATION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DURATION_OBSERVATION_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DURATION_OBSERVATION_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.DURATION_OBSERVATION_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.DURATION_OBSERVATION_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DURATION_OBSERVATION_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DURATION_OBSERVATION_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DURATION_OBSERVATION_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DURATION_OBSERVATION_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPackageDiagramChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(PackageDiagram.class)) {
		case UMLDIPackage.PACKAGE_DIAGRAM__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_DIAGRAM__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.PACKAGE_DIAGRAM__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.PACKAGE_DIAGRAM__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_DIAGRAM__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PACKAGE_DIAGRAM__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.PACKAGE_DIAGRAM__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.PACKAGE_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyProfileDiagramChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ProfileDiagram.class)) {
		case UMLDIPackage.PROFILE_DIAGRAM__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.PROFILE_DIAGRAM__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.PROFILE_DIAGRAM__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.PROFILE_DIAGRAM__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROFILE_DIAGRAM__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROFILE_DIAGRAM__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.PROFILE_DIAGRAM__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.PROFILE_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyCompositeStructureDiagramChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(CompositeStructureDiagram.class)) {
		case UMLDIPackage.COMPOSITE_STRUCTURE_DIAGRAM__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.COMPOSITE_STRUCTURE_DIAGRAM__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.COMPOSITE_STRUCTURE_DIAGRAM__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.COMPOSITE_STRUCTURE_DIAGRAM__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPOSITE_STRUCTURE_DIAGRAM__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPOSITE_STRUCTURE_DIAGRAM__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.COMPOSITE_STRUCTURE_DIAGRAM__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.COMPOSITE_STRUCTURE_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDeploymentDiagramChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(DeploymentDiagram.class)) {
		case UMLDIPackage.DEPLOYMENT_DIAGRAM__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_DIAGRAM__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.DEPLOYMENT_DIAGRAM__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.DEPLOYMENT_DIAGRAM__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_DIAGRAM__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_DIAGRAM__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.DEPLOYMENT_DIAGRAM__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.DEPLOYMENT_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyComponentDiagramChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ComponentDiagram.class)) {
		case UMLDIPackage.COMPONENT_DIAGRAM__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_DIAGRAM__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.COMPONENT_DIAGRAM__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.COMPONENT_DIAGRAM__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_DIAGRAM__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_DIAGRAM__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.COMPONENT_DIAGRAM__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.COMPONENT_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyObjectDiagramChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ObjectDiagram.class)) {
		case UMLDIPackage.OBJECT_DIAGRAM__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_DIAGRAM__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.OBJECT_DIAGRAM__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.OBJECT_DIAGRAM__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_DIAGRAM__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_DIAGRAM__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.OBJECT_DIAGRAM__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.OBJECT_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyProfileShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ProfileShape.class)) {
		case UMLDIPackage.PROFILE_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.PROFILE_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.PROFILE_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.PROFILE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROFILE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROFILE_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.PROFILE_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.PROFILE_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROFILE_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROFILE_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROFILE_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROFILE_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROFILE_SHAPE__PACKAGED_ELEMENT_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROFILE_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyProfileApplicationEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ProfileApplicationEdge.class)) {
		case UMLDIPackage.PROFILE_APPLICATION_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.PROFILE_APPLICATION_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.PROFILE_APPLICATION_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.PROFILE_APPLICATION_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROFILE_APPLICATION_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROFILE_APPLICATION_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.PROFILE_APPLICATION_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.PROFILE_APPLICATION_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROFILE_APPLICATION_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROFILE_APPLICATION_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROFILE_APPLICATION_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROFILE_APPLICATION_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROFILE_APPLICATION_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyExtensionEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ExtensionEdge.class)) {
		case UMLDIPackage.EXTENSION_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.EXTENSION_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.EXTENSION_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.EXTENSION_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXTENSION_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXTENSION_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.EXTENSION_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.EXTENSION_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXTENSION_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXTENSION_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXTENSION_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXTENSION_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXTENSION_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXTENSION_EDGE__END_MULTIPLICITY_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXTENSION_EDGE__END_CONSTRAINT_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXTENSION_EDGE__END_ROLE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyUseCaseDiagramChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(UseCaseDiagram.class)) {
		case UMLDIPackage.USE_CASE_DIAGRAM__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.USE_CASE_DIAGRAM__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.USE_CASE_DIAGRAM__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.USE_CASE_DIAGRAM__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USE_CASE_DIAGRAM__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USE_CASE_DIAGRAM__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.USE_CASE_DIAGRAM__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.USE_CASE_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyArtifactShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ArtifactShape.class)) {
		case UMLDIPackage.ARTIFACT_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.ARTIFACT_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.ARTIFACT_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.ARTIFACT_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ARTIFACT_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ARTIFACT_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.ARTIFACT_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.ARTIFACT_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ARTIFACT_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ARTIFACT_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ARTIFACT_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ARTIFACT_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ARTIFACT_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ARTIFACT_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ARTIFACT_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ARTIFACT_SHAPE__ATTRIBUTE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ARTIFACT_SHAPE__OPERATION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ARTIFACT_SHAPE__NESTED_ARTIFACT_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyNestedArtifactCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(NestedArtifactCompartment.class)) {
		case UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__LIST_ITEM_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT__ARTIFACT_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyComponentRealizationEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ComponentRealizationEdge.class)) {
		case UMLDIPackage.COMPONENT_REALIZATION_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_REALIZATION_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.COMPONENT_REALIZATION_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.COMPONENT_REALIZATION_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_REALIZATION_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_REALIZATION_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.COMPONENT_REALIZATION_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.COMPONENT_REALIZATION_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_REALIZATION_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_REALIZATION_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_REALIZATION_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_REALIZATION_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_REALIZATION_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMPONENT_REALIZATION_EDGE__ROLE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyManifestationEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ManifestationEdge.class)) {
		case UMLDIPackage.MANIFESTATION_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.MANIFESTATION_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.MANIFESTATION_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.MANIFESTATION_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MANIFESTATION_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MANIFESTATION_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.MANIFESTATION_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.MANIFESTATION_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MANIFESTATION_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MANIFESTATION_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MANIFESTATION_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MANIFESTATION_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MANIFESTATION_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MANIFESTATION_EDGE__ROLE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPropertyShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(PropertyShape.class)) {
		case UMLDIPackage.PROPERTY_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.PROPERTY_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.PROPERTY_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.PROPERTY_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROPERTY_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROPERTY_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.PROPERTY_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.PROPERTY_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROPERTY_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROPERTY_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROPERTY_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROPERTY_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROPERTY_SHAPE__STRUCTURE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROPERTY_SHAPE__PORT_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROPERTY_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyCollaborationShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(CollaborationShape.class)) {
		case UMLDIPackage.COLLABORATION_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.COLLABORATION_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.COLLABORATION_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.COLLABORATION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COLLABORATION_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COLLABORATION_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.COLLABORATION_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.COLLABORATION_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COLLABORATION_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COLLABORATION_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COLLABORATION_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COLLABORATION_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COLLABORATION_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COLLABORATION_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COLLABORATION_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COLLABORATION_SHAPE__ATTRIBUTE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COLLABORATION_SHAPE__OPERATION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COLLABORATION_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COLLABORATION_SHAPE__STRUCTURE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COLLABORATION_SHAPE__RECEPTION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyCollaborationUseShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(CollaborationUseShape.class)) {
		case UMLDIPackage.COLLABORATION_USE_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.COLLABORATION_USE_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.COLLABORATION_USE_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.COLLABORATION_USE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COLLABORATION_USE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COLLABORATION_USE_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.COLLABORATION_USE_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.COLLABORATION_USE_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COLLABORATION_USE_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COLLABORATION_USE_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COLLABORATION_USE_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COLLABORATION_USE_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyTemplateBindingEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(TemplateBindingEdge.class)) {
		case UMLDIPackage.TEMPLATE_BINDING_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.TEMPLATE_BINDING_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.TEMPLATE_BINDING_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.TEMPLATE_BINDING_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TEMPLATE_BINDING_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TEMPLATE_BINDING_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.TEMPLATE_BINDING_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.TEMPLATE_BINDING_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TEMPLATE_BINDING_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TEMPLATE_BINDING_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TEMPLATE_BINDING_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TEMPLATE_BINDING_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TEMPLATE_BINDING_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyStereotypeShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(StereotypeShape.class)) {
		case UMLDIPackage.STEREOTYPE_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.STEREOTYPE_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.STEREOTYPE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.STEREOTYPE_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.STEREOTYPE_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_SHAPE__ATTRIBUTE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_SHAPE__OPERATION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_SHAPE__RECEPTION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_SHAPE__NESTED_CLASSIFIER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_SHAPE__STRUCTURE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_SHAPE__PORT_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyNodeShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(NodeShape.class)) {
		case UMLDIPackage.NODE_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.NODE_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.NODE_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.NODE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NODE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NODE_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.NODE_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.NODE_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NODE_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NODE_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NODE_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NODE_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NODE_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NODE_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NODE_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NODE_SHAPE__ATTRIBUTE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NODE_SHAPE__OPERATION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NODE_SHAPE__RECEPTION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NODE_SHAPE__NESTED_CLASSIFIER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NODE_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NODE_SHAPE__STRUCTURE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NODE_SHAPE__PORT_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NODE_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NODE_SHAPE__NESTED_NODE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyNestedNodeCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(NestedNodeCompartment.class)) {
		case UMLDIPackage.NESTED_NODE_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.NESTED_NODE_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.NESTED_NODE_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.NESTED_NODE_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NESTED_NODE_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NESTED_NODE_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.NESTED_NODE_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.NESTED_NODE_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NESTED_NODE_COMPARTMENT__LIST_ITEM_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.NESTED_NODE_COMPARTMENT__NODE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDeviceShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(DeviceShape.class)) {
		case UMLDIPackage.DEVICE_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.DEVICE_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.DEVICE_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.DEVICE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEVICE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEVICE_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.DEVICE_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.DEVICE_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEVICE_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEVICE_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEVICE_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEVICE_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEVICE_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEVICE_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEVICE_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEVICE_SHAPE__ATTRIBUTE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEVICE_SHAPE__OPERATION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEVICE_SHAPE__RECEPTION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEVICE_SHAPE__NESTED_CLASSIFIER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEVICE_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEVICE_SHAPE__STRUCTURE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEVICE_SHAPE__PORT_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEVICE_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEVICE_SHAPE__NESTED_NODE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyExecutionEnvironmentShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ExecutionEnvironmentShape.class)) {
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__ATTRIBUTE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__OPERATION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__RECEPTION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__NESTED_CLASSIFIER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__STRUCTURE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__PORT_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__DEPLOYED_ARTIFACT_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE__NESTED_NODE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyActivityShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ActivityShape.class)) {
		case UMLDIPackage.ACTIVITY_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__ATTRIBUTE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__OPERATION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__RECEPTION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__NESTED_CLASSIFIER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__STRUCTURE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__PORT_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_NODE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__POST_CONDITION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__PRE_CONDITION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_SHAPE__ACTIVITY_PARAMETER_NODE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyActivityNodeCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ActivityNodeCompartment.class)) {
		case UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_NODE_COMPARTMENT__ELEMENT_WITH_ACTIVITY_NODES_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyParameterCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ParameterCompartment.class)) {
		case UMLDIPackage.PARAMETER_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.PARAMETER_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.PARAMETER_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.PARAMETER_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PARAMETER_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PARAMETER_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.PARAMETER_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.PARAMETER_COMPARTMENT__LIST_ITEM_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PARAMETER_COMPARTMENT__ACTIVITY_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPostConditionCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(PostConditionCompartment.class)) {
		case UMLDIPackage.POST_CONDITION_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.POST_CONDITION_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.POST_CONDITION_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.POST_CONDITION_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.POST_CONDITION_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.POST_CONDITION_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.POST_CONDITION_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.POST_CONDITION_COMPARTMENT__LIST_ITEM_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.POST_CONDITION_COMPARTMENT__ACTIVITY_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPreConditionCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(PreConditionCompartment.class)) {
		case UMLDIPackage.PRE_CONDITION_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.PRE_CONDITION_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.PRE_CONDITION_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.PRE_CONDITION_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PRE_CONDITION_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PRE_CONDITION_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.PRE_CONDITION_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.PRE_CONDITION_COMPARTMENT__LIST_ITEM_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PRE_CONDITION_COMPARTMENT__ACTIVITY_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyStructuredActivityNodeShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(StructuredActivityNodeShape.class)) {
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__PIN_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__CONDITION_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE__ACTIVITY_NODE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyActivityParameterNodeShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ActivityParameterNodeShape.class)) {
		case UMLDIPackage.ACTIVITY_PARAMETER_NODE_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_PARAMETER_NODE_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.ACTIVITY_PARAMETER_NODE_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.ACTIVITY_PARAMETER_NODE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_PARAMETER_NODE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_PARAMETER_NODE_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.ACTIVITY_PARAMETER_NODE_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.ACTIVITY_PARAMETER_NODE_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_PARAMETER_NODE_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_PARAMETER_NODE_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_PARAMETER_NODE_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_PARAMETER_NODE_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_PARAMETER_NODE_SHAPE__SELECTION_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_PARAMETER_NODE_SHAPE__CONSTRAINT_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_PARAMETER_NODE_SHAPE__ACTIVITY_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyInteractionShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(InteractionShape.class)) {
		case UMLDIPackage.INTERACTION_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__ATTRIBUTE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__OPERATION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__RECEPTION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__NESTED_CLASSIFIER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__STRUCTURE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__PORT_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__LIFELINE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__GATE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_SHAPE__SUBFRAGMENT_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyInteractionFragmentShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(InteractionFragmentShape.class)) {
		case UMLDIPackage.INTERACTION_FRAGMENT_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_FRAGMENT_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.INTERACTION_FRAGMENT_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.INTERACTION_FRAGMENT_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_FRAGMENT_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_FRAGMENT_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.INTERACTION_FRAGMENT_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.INTERACTION_FRAGMENT_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_FRAGMENT_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_FRAGMENT_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_FRAGMENT_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_FRAGMENT_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_FRAGMENT_SHAPE__LIFELINE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySubfragmentCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(SubfragmentCompartment.class)) {
		case UMLDIPackage.SUBFRAGMENT_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.SUBFRAGMENT_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.SUBFRAGMENT_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.SUBFRAGMENT_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SUBFRAGMENT_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SUBFRAGMENT_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.SUBFRAGMENT_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.SUBFRAGMENT_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SUBFRAGMENT_COMPARTMENT__INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGateShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(GateShape.class)) {
		case UMLDIPackage.GATE_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.GATE_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.GATE_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.GATE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GATE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GATE_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.GATE_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.GATE_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GATE_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GATE_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GATE_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GATE_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GATE_SHAPE__INTERACTION_FRAGMENT_WITH_GATES_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyOpaqueBehaviorShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(OpaqueBehaviorShape.class)) {
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE__ATTRIBUTE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE__OPERATION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE__RECEPTION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE__NESTED_CLASSIFIER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE__STRUCTURE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE__PORT_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyFunctionBehaviorShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(FunctionBehaviorShape.class)) {
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE__ATTRIBUTE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE__OPERATION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE__RECEPTION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE__NESTED_CLASSIFIER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE__STRUCTURE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE__PORT_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyStateMachineShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(StateMachineShape.class)) {
		case UMLDIPackage.STATE_MACHINE_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE__ATTRIBUTE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE__OPERATION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE__RECEPTION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE__NESTED_CLASSIFIER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE__STRUCTURE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE__PORT_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE__CONNECTION_POINT_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_MACHINE_SHAPE__REGION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPseudostateShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(PseudostateShape.class)) {
		case UMLDIPackage.PSEUDOSTATE_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.PSEUDOSTATE_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.PSEUDOSTATE_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.PSEUDOSTATE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PSEUDOSTATE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PSEUDOSTATE_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.PSEUDOSTATE_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.PSEUDOSTATE_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PSEUDOSTATE_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PSEUDOSTATE_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PSEUDOSTATE_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PSEUDOSTATE_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PSEUDOSTATE_SHAPE__BASE_STATE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyRegionCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(RegionCompartment.class)) {
		case UMLDIPackage.REGION_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.REGION_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.REGION_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.REGION_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REGION_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REGION_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.REGION_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.REGION_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REGION_COMPARTMENT__BASE_STATE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyProtocolStateMachineShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ProtocolStateMachineShape.class)) {
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__ATTRIBUTE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__OPERATION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__RECEPTION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__NESTED_CLASSIFIER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__STRUCTURE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__PORT_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__CONNECTION_POINT_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE__REGION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDeploymentSpecificationShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(DeploymentSpecificationShape.class)) {
		case UMLDIPackage.DEPLOYMENT_SPECIFICATION_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_SPECIFICATION_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.DEPLOYMENT_SPECIFICATION_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.DEPLOYMENT_SPECIFICATION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_SPECIFICATION_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_SPECIFICATION_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.DEPLOYMENT_SPECIFICATION_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.DEPLOYMENT_SPECIFICATION_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_SPECIFICATION_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_SPECIFICATION_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_SPECIFICATION_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_SPECIFICATION_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_SPECIFICATION_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_SPECIFICATION_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_SPECIFICATION_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_SPECIFICATION_SHAPE__ATTRIBUTE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_SPECIFICATION_SHAPE__OPERATION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_SPECIFICATION_SHAPE__NESTED_ARTIFACT_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyCommunicationPathEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(CommunicationPathEdge.class)) {
		case UMLDIPackage.COMMUNICATION_PATH_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.COMMUNICATION_PATH_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.COMMUNICATION_PATH_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.COMMUNICATION_PATH_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMMUNICATION_PATH_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMMUNICATION_PATH_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.COMMUNICATION_PATH_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.COMMUNICATION_PATH_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMMUNICATION_PATH_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMMUNICATION_PATH_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMMUNICATION_PATH_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMMUNICATION_PATH_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMMUNICATION_PATH_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMMUNICATION_PATH_EDGE__END_MULTIPLICITY_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMMUNICATION_PATH_EDGE__END_CONSTRAINT_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMMUNICATION_PATH_EDGE__END_ROLE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDeploymentEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(DeploymentEdge.class)) {
		case UMLDIPackage.DEPLOYMENT_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.DEPLOYMENT_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.DEPLOYMENT_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.DEPLOYMENT_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.DEPLOYMENT_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEPLOYMENT_EDGE__ROLE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyActorShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ActorShape.class)) {
		case UMLDIPackage.ACTOR_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.ACTOR_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.ACTOR_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.ACTOR_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTOR_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTOR_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.ACTOR_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.ACTOR_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTOR_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTOR_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTOR_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTOR_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTOR_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTOR_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTOR_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTOR_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyExtensionPointCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ExtensionPointCompartment.class)) {
		case UMLDIPackage.EXTENSION_POINT_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.EXTENSION_POINT_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.EXTENSION_POINT_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.EXTENSION_POINT_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXTENSION_POINT_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXTENSION_POINT_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.EXTENSION_POINT_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.EXTENSION_POINT_COMPARTMENT__LIST_ITEM_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXTENSION_POINT_COMPARTMENT__USE_CASE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyUseCaseShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(UseCaseShape.class)) {
		case UMLDIPackage.USE_CASE_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.USE_CASE_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.USE_CASE_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.USE_CASE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USE_CASE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USE_CASE_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.USE_CASE_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.USE_CASE_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USE_CASE_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USE_CASE_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USE_CASE_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USE_CASE_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USE_CASE_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USE_CASE_SHAPE__OWNED_USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USE_CASE_SHAPE__USE_CASE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USE_CASE_SHAPE__OWNED_BEHAVIOR_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USE_CASE_SHAPE__EXTENSION_POINT_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyIncludeEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(IncludeEdge.class)) {
		case UMLDIPackage.INCLUDE_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.INCLUDE_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.INCLUDE_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.INCLUDE_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INCLUDE_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INCLUDE_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.INCLUDE_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.INCLUDE_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INCLUDE_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INCLUDE_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INCLUDE_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INCLUDE_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INCLUDE_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyExtendEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ExtendEdge.class)) {
		case UMLDIPackage.EXTEND_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.EXTEND_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.EXTEND_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.EXTEND_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXTEND_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXTEND_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.EXTEND_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.EXTEND_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXTEND_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXTEND_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXTEND_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXTEND_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXTEND_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyStateMachineDiagramChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(StateMachineDiagram.class)) {
		case UMLDIPackage.STATE_MACHINE_DIAGRAM__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.STATE_MACHINE_DIAGRAM__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.STATE_MACHINE_DIAGRAM__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.STATE_MACHINE_DIAGRAM__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_MACHINE_DIAGRAM__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_MACHINE_DIAGRAM__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.STATE_MACHINE_DIAGRAM__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.STATE_MACHINE_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyActivityDiagramChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ActivityDiagram.class)) {
		case UMLDIPackage.ACTIVITY_DIAGRAM__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_DIAGRAM__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.ACTIVITY_DIAGRAM__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.ACTIVITY_DIAGRAM__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_DIAGRAM__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_DIAGRAM__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.ACTIVITY_DIAGRAM__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.ACTIVITY_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySequenceDiagramChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(SequenceDiagram.class)) {
		case UMLDIPackage.SEQUENCE_DIAGRAM__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.SEQUENCE_DIAGRAM__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.SEQUENCE_DIAGRAM__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.SEQUENCE_DIAGRAM__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SEQUENCE_DIAGRAM__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SEQUENCE_DIAGRAM__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.SEQUENCE_DIAGRAM__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.SEQUENCE_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyCommunicationDiagramChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(CommunicationDiagram.class)) {
		case UMLDIPackage.COMMUNICATION_DIAGRAM__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.COMMUNICATION_DIAGRAM__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.COMMUNICATION_DIAGRAM__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.COMMUNICATION_DIAGRAM__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMMUNICATION_DIAGRAM__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMMUNICATION_DIAGRAM__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.COMMUNICATION_DIAGRAM__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.COMMUNICATION_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyTimingDiagramChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(TimingDiagram.class)) {
		case UMLDIPackage.TIMING_DIAGRAM__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.TIMING_DIAGRAM__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.TIMING_DIAGRAM__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.TIMING_DIAGRAM__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIMING_DIAGRAM__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIMING_DIAGRAM__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.TIMING_DIAGRAM__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.TIMING_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyInteractionOverviewDiagramChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(InteractionOverviewDiagram.class)) {
		case UMLDIPackage.INTERACTION_OVERVIEW_DIAGRAM__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_OVERVIEW_DIAGRAM__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.INTERACTION_OVERVIEW_DIAGRAM__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.INTERACTION_OVERVIEW_DIAGRAM__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_OVERVIEW_DIAGRAM__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_OVERVIEW_DIAGRAM__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.INTERACTION_OVERVIEW_DIAGRAM__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.INTERACTION_OVERVIEW_DIAGRAM__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyInternalBehaviorCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(InternalBehaviorCompartment.class)) {
		case UMLDIPackage.INTERNAL_BEHAVIOR_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.INTERNAL_BEHAVIOR_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.INTERNAL_BEHAVIOR_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.INTERNAL_BEHAVIOR_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERNAL_BEHAVIOR_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERNAL_BEHAVIOR_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.INTERNAL_BEHAVIOR_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.INTERNAL_BEHAVIOR_COMPARTMENT__LIST_ITEM_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERNAL_BEHAVIOR_COMPARTMENT__STATE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyStateShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(StateShape.class)) {
		case UMLDIPackage.STATE_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.STATE_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.STATE_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.STATE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.STATE_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.STATE_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_SHAPE__CONNECTION_POINT_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_SHAPE__REGION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_SHAPE__CONNECTION_POINT_REFERENCE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_SHAPE__INTERNAL_TRANSITION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_SHAPE__DEFERRABLE_TRIGGER_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_SHAPE__INTERNAL_BEHAVIOR_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyConnectionPointReferenceShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ConnectionPointReferenceShape.class)) {
		case UMLDIPackage.CONNECTION_POINT_REFERENCE_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.CONNECTION_POINT_REFERENCE_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.CONNECTION_POINT_REFERENCE_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.CONNECTION_POINT_REFERENCE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONNECTION_POINT_REFERENCE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONNECTION_POINT_REFERENCE_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.CONNECTION_POINT_REFERENCE_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.CONNECTION_POINT_REFERENCE_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONNECTION_POINT_REFERENCE_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONNECTION_POINT_REFERENCE_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONNECTION_POINT_REFERENCE_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONNECTION_POINT_REFERENCE_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONNECTION_POINT_REFERENCE_SHAPE__STATE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyInternalTransitionCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(InternalTransitionCompartment.class)) {
		case UMLDIPackage.INTERNAL_TRANSITION_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.INTERNAL_TRANSITION_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.INTERNAL_TRANSITION_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.INTERNAL_TRANSITION_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERNAL_TRANSITION_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERNAL_TRANSITION_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.INTERNAL_TRANSITION_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.INTERNAL_TRANSITION_COMPARTMENT__LIST_ITEM_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERNAL_TRANSITION_COMPARTMENT__STATE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDeferrableTriggerCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(DeferrableTriggerCompartment.class)) {
		case UMLDIPackage.DEFERRABLE_TRIGGER_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.DEFERRABLE_TRIGGER_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.DEFERRABLE_TRIGGER_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.DEFERRABLE_TRIGGER_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEFERRABLE_TRIGGER_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEFERRABLE_TRIGGER_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.DEFERRABLE_TRIGGER_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.DEFERRABLE_TRIGGER_COMPARTMENT__LIST_ITEM_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DEFERRABLE_TRIGGER_COMPARTMENT__STATE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyRegionShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(RegionShape.class)) {
		case UMLDIPackage.REGION_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.REGION_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.REGION_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.REGION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REGION_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REGION_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.REGION_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.REGION_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REGION_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REGION_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REGION_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REGION_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.REGION_SHAPE__SUBVERTEX_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyTransitionEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(TransitionEdge.class)) {
		case UMLDIPackage.TRANSITION_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.TRANSITION_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.TRANSITION_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.TRANSITION_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TRANSITION_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TRANSITION_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.TRANSITION_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.TRANSITION_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TRANSITION_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TRANSITION_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TRANSITION_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TRANSITION_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TRANSITION_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyWeightLabelChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(WeightLabel.class)) {
		case UMLDIPackage.WEIGHT_LABEL__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.WEIGHT_LABEL__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.WEIGHT_LABEL__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.WEIGHT_LABEL__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.WEIGHT_LABEL__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.WEIGHT_LABEL__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.WEIGHT_LABEL__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.WEIGHT_LABEL__ACTIVITY_EDGE_EDGE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyControlFlowEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ControlFlowEdge.class)) {
		case UMLDIPackage.CONTROL_FLOW_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.CONTROL_FLOW_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.CONTROL_FLOW_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.CONTROL_FLOW_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONTROL_FLOW_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONTROL_FLOW_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.CONTROL_FLOW_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.CONTROL_FLOW_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONTROL_FLOW_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONTROL_FLOW_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONTROL_FLOW_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONTROL_FLOW_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONTROL_FLOW_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONTROL_FLOW_EDGE__GUARD_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.CONTROL_FLOW_EDGE__WEIGHT_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyObjectFlowEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ObjectFlowEdge.class)) {
		case UMLDIPackage.OBJECT_FLOW_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_FLOW_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.OBJECT_FLOW_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.OBJECT_FLOW_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_FLOW_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_FLOW_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.OBJECT_FLOW_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.OBJECT_FLOW_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_FLOW_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_FLOW_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_FLOW_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_FLOW_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_FLOW_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_FLOW_EDGE__GUARD_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_FLOW_EDGE__WEIGHT_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_FLOW_EDGE__TRANSFORMATION_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_FLOW_EDGE__SELECTION_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyActivityGroupShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ActivityGroupShape.class)) {
		case UMLDIPackage.ACTIVITY_GROUP_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_GROUP_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.ACTIVITY_GROUP_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.ACTIVITY_GROUP_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_GROUP_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_GROUP_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.ACTIVITY_GROUP_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.ACTIVITY_GROUP_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_GROUP_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_GROUP_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_GROUP_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_GROUP_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyExceptionHandlerEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ExceptionHandlerEdge.class)) {
		case UMLDIPackage.EXCEPTION_HANDLER_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.EXCEPTION_HANDLER_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.EXCEPTION_HANDLER_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.EXCEPTION_HANDLER_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXCEPTION_HANDLER_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXCEPTION_HANDLER_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.EXCEPTION_HANDLER_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.EXCEPTION_HANDLER_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXCEPTION_HANDLER_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXCEPTION_HANDLER_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXCEPTION_HANDLER_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXCEPTION_HANDLER_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXCEPTION_HANDLER_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXCEPTION_HANDLER_EDGE__TYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXCEPTION_HANDLER_EDGE__ICON_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyTypeLabelChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(TypeLabel.class)) {
		case UMLDIPackage.TYPE_LABEL__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.TYPE_LABEL__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.TYPE_LABEL__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.TYPE_LABEL__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TYPE_LABEL__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TYPE_LABEL__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.TYPE_LABEL__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.TYPE_LABEL__INTERACTION_USE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TYPE_LABEL__EXCEPTION_HANDLER_EDGE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyIconLabelChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(IconLabel.class)) {
		case UMLDIPackage.ICON_LABEL__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.ICON_LABEL__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.ICON_LABEL__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.ICON_LABEL__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ICON_LABEL__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ICON_LABEL__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.ICON_LABEL__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.ICON_LABEL__EXCEPTION_HANDLER_EDGE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyActivityPartitionShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ActivityPartitionShape.class)) {
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE__SUBPARTITION_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyExpansionRegionShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ExpansionRegionShape.class)) {
		case UMLDIPackage.EXPANSION_REGION_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.EXPANSION_REGION_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.EXPANSION_REGION_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.EXPANSION_REGION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXPANSION_REGION_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXPANSION_REGION_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.EXPANSION_REGION_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.EXPANSION_REGION_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXPANSION_REGION_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXPANSION_REGION_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXPANSION_REGION_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXPANSION_REGION_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXPANSION_REGION_SHAPE__PIN_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXPANSION_REGION_SHAPE__CONDITION_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXPANSION_REGION_SHAPE__ACTIVITY_NODE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXPANSION_REGION_SHAPE__EXPANSION_NODE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyExpansionNodeShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ExpansionNodeShape.class)) {
		case UMLDIPackage.EXPANSION_NODE_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.EXPANSION_NODE_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.EXPANSION_NODE_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.EXPANSION_NODE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXPANSION_NODE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXPANSION_NODE_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.EXPANSION_NODE_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.EXPANSION_NODE_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXPANSION_NODE_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXPANSION_NODE_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXPANSION_NODE_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXPANSION_NODE_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXPANSION_NODE_SHAPE__SELECTION_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXPANSION_NODE_SHAPE__CONSTRAINT_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXPANSION_NODE_SHAPE__EXPANSION_REGION_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyLifelineShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(LifelineShape.class)) {
		case UMLDIPackage.LIFELINE_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.LIFELINE_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.LIFELINE_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.LIFELINE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.LIFELINE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.LIFELINE_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.LIFELINE_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.LIFELINE_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.LIFELINE_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.LIFELINE_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.LIFELINE_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.LIFELINE_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.LIFELINE_SHAPE__SUBFRAGMENT_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.LIFELINE_SHAPE__NESTING_LIFELINE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.LIFELINE_SHAPE__NESTED_LIFELINE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.LIFELINE_SHAPE__CONSTRAINT_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyExecutionSpecificationShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ExecutionSpecificationShape.class)) {
		case UMLDIPackage.EXECUTION_SPECIFICATION_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_SPECIFICATION_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.EXECUTION_SPECIFICATION_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.EXECUTION_SPECIFICATION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_SPECIFICATION_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_SPECIFICATION_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.EXECUTION_SPECIFICATION_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.EXECUTION_SPECIFICATION_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_SPECIFICATION_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_SPECIFICATION_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_SPECIFICATION_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_SPECIFICATION_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.EXECUTION_SPECIFICATION_SHAPE__LIFELINE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDurationConstraintShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(DurationConstraintShape.class)) {
		case UMLDIPackage.DURATION_CONSTRAINT_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.DURATION_CONSTRAINT_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.DURATION_CONSTRAINT_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.DURATION_CONSTRAINT_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DURATION_CONSTRAINT_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DURATION_CONSTRAINT_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.DURATION_CONSTRAINT_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.DURATION_CONSTRAINT_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DURATION_CONSTRAINT_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DURATION_CONSTRAINT_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DURATION_CONSTRAINT_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DURATION_CONSTRAINT_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyTimeConstraintShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(TimeConstraintShape.class)) {
		case UMLDIPackage.TIME_CONSTRAINT_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.TIME_CONSTRAINT_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.TIME_CONSTRAINT_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.TIME_CONSTRAINT_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_CONSTRAINT_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_CONSTRAINT_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.TIME_CONSTRAINT_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.TIME_CONSTRAINT_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_CONSTRAINT_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_CONSTRAINT_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_CONSTRAINT_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_CONSTRAINT_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyTimeExpressionShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(TimeExpressionShape.class)) {
		case UMLDIPackage.TIME_EXPRESSION_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.TIME_EXPRESSION_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.TIME_EXPRESSION_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.TIME_EXPRESSION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_EXPRESSION_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_EXPRESSION_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.TIME_EXPRESSION_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.TIME_EXPRESSION_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_EXPRESSION_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_EXPRESSION_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_EXPRESSION_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TIME_EXPRESSION_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyDurationShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(DurationShape.class)) {
		case UMLDIPackage.DURATION_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.DURATION_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.DURATION_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.DURATION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DURATION_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DURATION_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.DURATION_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.DURATION_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DURATION_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DURATION_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DURATION_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.DURATION_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPathEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(PathEdge.class)) {
		case UMLDIPackage.PATH_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.PATH_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.PATH_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.PATH_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PATH_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PATH_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.PATH_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.PATH_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PATH_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PATH_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PATH_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PATH_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PATH_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PATH_EDGE__MESSAGE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyMessageLabelChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(MessageLabel.class)) {
		case UMLDIPackage.MESSAGE_LABEL__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.MESSAGE_LABEL__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.MESSAGE_LABEL__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.MESSAGE_LABEL__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MESSAGE_LABEL__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MESSAGE_LABEL__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.MESSAGE_LABEL__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.MESSAGE_LABEL__PATH_EDGE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyStateInvariantShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(StateInvariantShape.class)) {
		case UMLDIPackage.STATE_INVARIANT_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.STATE_INVARIANT_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.STATE_INVARIANT_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.STATE_INVARIANT_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_INVARIANT_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_INVARIANT_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.STATE_INVARIANT_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.STATE_INVARIANT_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_INVARIANT_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_INVARIANT_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_INVARIANT_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_INVARIANT_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STATE_INVARIANT_SHAPE__LIFELINE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyMessageEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(MessageEdge.class)) {
		case UMLDIPackage.MESSAGE_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.MESSAGE_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.MESSAGE_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.MESSAGE_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MESSAGE_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MESSAGE_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.MESSAGE_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.MESSAGE_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MESSAGE_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MESSAGE_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MESSAGE_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MESSAGE_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.MESSAGE_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGeneralOrderingEdgeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(GeneralOrderingEdge.class)) {
		case UMLDIPackage.GENERAL_ORDERING_EDGE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.GENERAL_ORDERING_EDGE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.GENERAL_ORDERING_EDGE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.GENERAL_ORDERING_EDGE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GENERAL_ORDERING_EDGE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GENERAL_ORDERING_EDGE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.GENERAL_ORDERING_EDGE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.GENERAL_ORDERING_EDGE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GENERAL_ORDERING_EDGE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GENERAL_ORDERING_EDGE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GENERAL_ORDERING_EDGE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GENERAL_ORDERING_EDGE__SOURCE_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__SOURCE_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GENERAL_ORDERING_EDGE__TARGET_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.EDGE__TARGET_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyCombinedFragmentShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(CombinedFragmentShape.class)) {
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE__LIFELINE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE__GATE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE__SUBFRAGMENT_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyInteractionUseShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(InteractionUseShape.class)) {
		case UMLDIPackage.INTERACTION_USE_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_USE_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.INTERACTION_USE_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.INTERACTION_USE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_USE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_USE_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.INTERACTION_USE_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.INTERACTION_USE_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_USE_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_USE_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_USE_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_USE_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_USE_SHAPE__LIFELINE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_USE_SHAPE__GATE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_USE_SHAPE__TYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyInteractionOperandShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(InteractionOperandShape.class)) {
		case UMLDIPackage.INTERACTION_OPERAND_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_OPERAND_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.INTERACTION_OPERAND_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.INTERACTION_OPERAND_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_OPERAND_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_OPERAND_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.INTERACTION_OPERAND_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.INTERACTION_OPERAND_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_OPERAND_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_OPERAND_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_OPERAND_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_OPERAND_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_OPERAND_SHAPE__LIFELINE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.INTERACTION_OPERAND_SHAPE__SUBFRAGMENT_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyActionShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ActionShape.class)) {
		case UMLDIPackage.ACTION_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.ACTION_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.ACTION_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.ACTION_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTION_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTION_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.ACTION_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.ACTION_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTION_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTION_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTION_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTION_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTION_SHAPE__PIN_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTION_SHAPE__CONDITION_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyPinShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(PinShape.class)) {
		case UMLDIPackage.PIN_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.PIN_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.PIN_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.PIN_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PIN_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PIN_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.PIN_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.PIN_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PIN_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PIN_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PIN_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PIN_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PIN_SHAPE__SELECTION_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PIN_SHAPE__CONSTRAINT_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.PIN_SHAPE__ACTION_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySubpartitionCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(SubpartitionCompartment.class)) {
		case UMLDIPackage.SUBPARTITION_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.SUBPARTITION_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.SUBPARTITION_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.SUBPARTITION_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SUBPARTITION_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SUBPARTITION_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.SUBPARTITION_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.SUBPARTITION_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SUBPARTITION_COMPARTMENT__ACTIVITY_PARTITION_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyObjectNodeShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ObjectNodeShape.class)) {
		case UMLDIPackage.OBJECT_NODE_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_NODE_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.OBJECT_NODE_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.OBJECT_NODE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_NODE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_NODE_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.OBJECT_NODE_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.OBJECT_NODE_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_NODE_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_NODE_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_NODE_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_NODE_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_NODE_SHAPE__SELECTION_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OBJECT_NODE_SHAPE__CONSTRAINT_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySelectionLabelChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(SelectionLabel.class)) {
		case UMLDIPackage.SELECTION_LABEL__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.SELECTION_LABEL__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.SELECTION_LABEL__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.SELECTION_LABEL__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SELECTION_LABEL__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SELECTION_LABEL__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.SELECTION_LABEL__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.SELECTION_LABEL__OBJECT_FLOW_EDGE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SELECTION_LABEL__OBJECT_NODE_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyTransformationLabelChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(TransformationLabel.class)) {
		case UMLDIPackage.TRANSFORMATION_LABEL__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.TRANSFORMATION_LABEL__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.TRANSFORMATION_LABEL__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.TRANSFORMATION_LABEL__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TRANSFORMATION_LABEL__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TRANSFORMATION_LABEL__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.TRANSFORMATION_LABEL__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.TRANSFORMATION_LABEL__OBJECT_FLOW_EDGE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyGuardLabelChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(GuardLabel.class)) {
		case UMLDIPackage.GUARD_LABEL__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.GUARD_LABEL__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.GUARD_LABEL__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.GUARD_LABEL__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GUARD_LABEL__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.GUARD_LABEL__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.GUARD_LABEL__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.GUARD_LABEL__ACTIVITY_EDGE_EDGE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyActivityNodeShapeChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ActivityNodeShape.class)) {
		case UMLDIPackage.ACTIVITY_NODE_SHAPE__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_NODE_SHAPE__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.ACTIVITY_NODE_SHAPE__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.ACTIVITY_NODE_SHAPE__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_NODE_SHAPE__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_NODE_SHAPE__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.ACTIVITY_NODE_SHAPE__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.ACTIVITY_NODE_SHAPE__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_NODE_SHAPE__UML_DIAGRAM:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_NODE_SHAPE__DIAGRAM_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_NODE_SHAPE__MAIN_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.ACTIVITY_NODE_SHAPE__STEREOTYPE_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifySubvertexCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(SubvertexCompartment.class)) {
		case UMLDIPackage.SUBVERTEX_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.SUBVERTEX_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.SUBVERTEX_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.SUBVERTEX_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SUBVERTEX_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SUBVERTEX_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.SUBVERTEX_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.SUBVERTEX_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.SUBVERTEX_COMPARTMENT__REGION_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyTemplateParameterCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(TemplateParameterCompartment.class)) {
		case UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT__LIST_ITEM_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT__TEMPLATEABLE_ELEMENT_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyListItemLabelChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(ListItemLabel.class)) {
		case UMLDIPackage.LIST_ITEM_LABEL__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.LIST_ITEM_LABEL__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.LIST_ITEM_LABEL__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.LIST_ITEM_LABEL__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.LIST_ITEM_LABEL__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.LIST_ITEM_LABEL__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.LIST_ITEM_LABEL__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.LIST_ITEM_LABEL__STEREOTYPE_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.LIST_ITEM_LABEL__LIST_COMPARTMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyStereotypeLabelChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(StereotypeLabel.class)) {
		case UMLDIPackage.STEREOTYPE_LABEL__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_LABEL__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.STEREOTYPE_LABEL__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.STEREOTYPE_LABEL__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_LABEL__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.STEREOTYPE_LABEL__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.STEREOTYPE_LABEL__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.STEREOTYPE_LABEL__STEREOTYPED_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyOwnedUseCaseCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(OwnedUseCaseCompartment.class)) {
		case UMLDIPackage.OWNED_USE_CASE_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.OWNED_USE_CASE_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.OWNED_USE_CASE_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.OWNED_USE_CASE_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OWNED_USE_CASE_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OWNED_USE_CASE_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.OWNED_USE_CASE_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.OWNED_USE_CASE_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OWNED_USE_CASE_COMPARTMENT__LIST_ITEM_LABEL:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.OWNED_USE_CASE_COMPARTMENT__CLASSIFIER_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}

	/**
	 * Calls <code>notifyChanged</code> for each affected derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param notification
	 *        a description of the change.
	 * @param eClass
	 *        the Ecore class of the notifier.
	 * @generated
	 */
	protected void notifyUseCaseCompartmentChanged(Notification notification, EClass eClass) {
		switch(notification.getFeatureID(UseCaseCompartment.class)) {
		case UMLDIPackage.USE_CASE_COMPARTMENT__UML_MODEL_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__MODEL_ELEMENT);
			break;
		case UMLDIPackage.USE_CASE_COMPARTMENT__SHARED_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SHARED_STYLE);
			break;
		case UMLDIPackage.USE_CASE_COMPARTMENT__LOCAL_UML_STYLE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__LOCAL_STYLE);
			break;
		case UMLDIPackage.USE_CASE_COMPARTMENT__OWNED_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USE_CASE_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USE_CASE_COMPARTMENT__TARGET_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__TARGET_EDGE);
			break;
		case UMLDIPackage.USE_CASE_COMPARTMENT__SOURCE_UML_EDGE:
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__SOURCE_EDGE);
			break;
		case UMLDIPackage.USE_CASE_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNED_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT);
			break;
		case UMLDIPackage.USE_CASE_COMPARTMENT__CLASSIFIER_SHAPE:
			notifyChanged(notification, eClass, UMLDIPackage.Literals.UML_DIAGRAM_ELEMENT__OWNING_UML_DIAGRAM_ELEMENT);
			notifyChanged(notification, eClass, DIPackage.Literals.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT);
			break;
		}
	}
} //UMLDIDerivedUnionAdapter
