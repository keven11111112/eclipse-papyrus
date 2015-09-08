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

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.papyrus.umldi.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.umldi.UMLDIPackage
 * @generated
 */
public class UMLDIValidator extends EObjectValidator {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final UMLDIValidator INSTANCE = new UMLDIValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic
	 * {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.papyrus.umldi";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Fontsize Positive' of 'Uml Style'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int UML_STYLE__FONTSIZE_POSITIVE = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Delegates evaluation of the given invariant expression against the object in the given context.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context, String validationDelegate, EOperation invariant, String expression, int severity, String source, int code) {
		return EObjectValidator.validate(eClass, eObject, diagnostics, context, validationDelegate, invariant, expression, severity, source, code);
	}

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UMLDIValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
		return UMLDIPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch(classifierID) {
		case UMLDIPackage.UML_DIAGRAM:
			return validateUmlDiagram((UmlDiagram)value, diagnostics, context);
		case UMLDIPackage.UML_DIAGRAM_ELEMENT:
			return validateUmlDiagramElement((UmlDiagramElement)value, diagnostics, context);
		case UMLDIPackage.UML_STYLE:
			return validateUmlStyle((UmlStyle)value, diagnostics, context);
		case UMLDIPackage.UML_EDGE:
			return validateUmlEdge((UmlEdge)value, diagnostics, context);
		case UMLDIPackage.TOP_UML_DIAGRAM_ELEMENT:
			return validateTopUmlDiagramElement((TopUmlDiagramElement)value, diagnostics, context);
		case UMLDIPackage.STEREOTYPED_DIAGRAM_ELEMENT:
			return validateStereotypedDiagramElement((StereotypedDiagramElement)value, diagnostics, context);
		case UMLDIPackage.STEREOTYPE_LABEL:
			return validateStereotypeLabel((StereotypeLabel)value, diagnostics, context);
		case UMLDIPackage.UML_LABEL:
			return validateUmlLabel((UmlLabel)value, diagnostics, context);
		case UMLDIPackage.DIAGRAM_COMPARTMENT:
			return validateDiagramCompartment((DiagramCompartment)value, diagnostics, context);
		case UMLDIPackage.UML_COMPARTMENT:
			return validateUmlCompartment((UmlCompartment)value, diagnostics, context);
		case UMLDIPackage.MAIN_LABEL:
			return validateMainLabel((MainLabel)value, diagnostics, context);
		case UMLDIPackage.UML_SHAPE:
			return validateUmlShape((UmlShape)value, diagnostics, context);
		case UMLDIPackage.STEREOTYPE_COMPARTMENT:
			return validateStereotypeCompartment((StereotypeCompartment)value, diagnostics, context);
		case UMLDIPackage.LIST_COMPARTMENT:
			return validateListCompartment((ListCompartment)value, diagnostics, context);
		case UMLDIPackage.LIST_ITEM_LABEL:
			return validateListItemLabel((ListItemLabel)value, diagnostics, context);
		case UMLDIPackage.CLASS_DIAGRAM:
			return validateClassDiagram((ClassDiagram)value, diagnostics, context);
		case UMLDIPackage.STRUCTURE_DIAGRAM:
			return validateStructureDiagram((StructureDiagram)value, diagnostics, context);
		case UMLDIPackage.CLASSIFIER_SHAPE:
			return validateClassifierShape((ClassifierShape)value, diagnostics, context);
		case UMLDIPackage.TEMPLATEABLE_ELEMENT_SHAPE:
			return validateTemplateableElementShape((TemplateableElementShape)value, diagnostics, context);
		case UMLDIPackage.ELEMENT_SHAPE:
			return validateElementShape((ElementShape)value, diagnostics, context);
		case UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT:
			return validateTemplateParameterCompartment((TemplateParameterCompartment)value, diagnostics, context);
		case UMLDIPackage.OWNED_USE_CASE_COMPARTMENT:
			return validateOwnedUseCaseCompartment((OwnedUseCaseCompartment)value, diagnostics, context);
		case UMLDIPackage.CLASSIFIER_COMPARTMENT:
			return validateClassifierCompartment((ClassifierCompartment)value, diagnostics, context);
		case UMLDIPackage.USE_CASE_COMPARTMENT:
			return validateUseCaseCompartment((UseCaseCompartment)value, diagnostics, context);
		case UMLDIPackage.PACKAGE_SHAPE:
			return validatePackageShape((PackageShape)value, diagnostics, context);
		case UMLDIPackage.ELEMENT_WITH_PACKAGED_ELEMENTS_SHAPE:
			return validateElementWithPackagedElementsShape((ElementWithPackagedElementsShape)value, diagnostics, context);
		case UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT:
			return validatePackagedElementCompartment((PackagedElementCompartment)value, diagnostics, context);
		case UMLDIPackage.CONSTRAINT_SHAPE:
			return validateConstraintShape((ConstraintShape)value, diagnostics, context);
		case UMLDIPackage.ATTRIBUTE_COMPARTMENT:
			return validateAttributeCompartment((AttributeCompartment)value, diagnostics, context);
		case UMLDIPackage.CLASSIFIER_WITH_ATTRIBUTES_SHAPE:
			return validateClassifierWithAttributesShape((ClassifierWithAttributesShape)value, diagnostics, context);
		case UMLDIPackage.OPERATION_COMPARTMENT:
			return validateOperationCompartment((OperationCompartment)value, diagnostics, context);
		case UMLDIPackage.CLASSIFIER_WITH_OPERATIONS_SHAPE:
			return validateClassifierWithOperationsShape((ClassifierWithOperationsShape)value, diagnostics, context);
		case UMLDIPackage.RECEPTION_COMPARTMENT:
			return validateReceptionCompartment((ReceptionCompartment)value, diagnostics, context);
		case UMLDIPackage.CLASSIFIER_WITH_RECEPTIONS_SHAPE:
			return validateClassifierWithReceptionsShape((ClassifierWithReceptionsShape)value, diagnostics, context);
		case UMLDIPackage.LITERAL_COMPARTMENT:
			return validateLiteralCompartment((LiteralCompartment)value, diagnostics, context);
		case UMLDIPackage.ENUMERATION_SHAPE:
			return validateEnumerationShape((EnumerationShape)value, diagnostics, context);
		case UMLDIPackage.ROLE_LABEL:
			return validateRoleLabel((RoleLabel)value, diagnostics, context);
		case UMLDIPackage.ASSOCIATION_EDGE:
			return validateAssociationEdge((AssociationEdge)value, diagnostics, context);
		case UMLDIPackage.ELEMENT_EDGE:
			return validateElementEdge((ElementEdge)value, diagnostics, context);
		case UMLDIPackage.MULTIPLICITY_LABEL:
			return validateMultiplicityLabel((MultiplicityLabel)value, diagnostics, context);
		case UMLDIPackage.PROPERTY_EDGE:
			return validatePropertyEdge((PropertyEdge)value, diagnostics, context);
		case UMLDIPackage.CONSTRAINT_LABEL:
			return validateConstraintLabel((ConstraintLabel)value, diagnostics, context);
		case UMLDIPackage.GENERALIZATION_SET_EDGE:
			return validateGeneralizationSetEdge((GeneralizationSetEdge)value, diagnostics, context);
		case UMLDIPackage.POWER_LABEL:
			return validatePowerLabel((PowerLabel)value, diagnostics, context);
		case UMLDIPackage.OBJECT_NODE_SHAPE:
			return validateObjectNodeShape((ObjectNodeShape)value, diagnostics, context);
		case UMLDIPackage.ACTIVITY_NODE_SHAPE:
			return validateActivityNodeShape((ActivityNodeShape)value, diagnostics, context);
		case UMLDIPackage.SELECTION_LABEL:
			return validateSelectionLabel((SelectionLabel)value, diagnostics, context);
		case UMLDIPackage.OBJECT_FLOW_EDGE:
			return validateObjectFlowEdge((ObjectFlowEdge)value, diagnostics, context);
		case UMLDIPackage.ACTIVITY_EDGE_EDGE:
			return validateActivityEdgeEdge((ActivityEdgeEdge)value, diagnostics, context);
		case UMLDIPackage.GUARD_LABEL:
			return validateGuardLabel((GuardLabel)value, diagnostics, context);
		case UMLDIPackage.WEIGHT_LABEL:
			return validateWeightLabel((WeightLabel)value, diagnostics, context);
		case UMLDIPackage.TRANSFORMATION_LABEL:
			return validateTransformationLabel((TransformationLabel)value, diagnostics, context);
		case UMLDIPackage.LIFELINE_SHAPE:
			return validateLifelineShape((LifelineShape)value, diagnostics, context);
		case UMLDIPackage.INTERACTION_FRAGMENT_SHAPE:
			return validateInteractionFragmentShape((InteractionFragmentShape)value, diagnostics, context);
		case UMLDIPackage.ACTION_SHAPE:
			return validateActionShape((ActionShape)value, diagnostics, context);
		case UMLDIPackage.PIN_SHAPE:
			return validatePinShape((PinShape)value, diagnostics, context);
		case UMLDIPackage.CONNECTOR_EDGE:
			return validateConnectorEdge((ConnectorEdge)value, diagnostics, context);
		case UMLDIPackage.INSTANCE_SPECIFICATION_EDGE:
			return validateInstanceSpecificationEdge((InstanceSpecificationEdge)value, diagnostics, context);
		case UMLDIPackage.DEPENDENCY_EDGE:
			return validateDependencyEdge((DependencyEdge)value, diagnostics, context);
		case UMLDIPackage.INSTANCE_SPECIFICATION_SHAPE:
			return validateInstanceSpecificationShape((InstanceSpecificationShape)value, diagnostics, context);
		case UMLDIPackage.DEPLOYMENT_TARGET_SHAPE:
			return validateDeploymentTargetShape((DeploymentTargetShape)value, diagnostics, context);
		case UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT:
			return validateDeployedArtifactCompartment((DeployedArtifactCompartment)value, diagnostics, context);
		case UMLDIPackage.SLOT_COMPARTMENT:
			return validateSlotCompartment((SlotCompartment)value, diagnostics, context);
		case UMLDIPackage.CLASS_SHAPE:
			return validateClassShape((ClassShape)value, diagnostics, context);
		case UMLDIPackage.ELEMENT_WITH_PORTS_SHAPE:
			return validateElementWithPortsShape((ElementWithPortsShape)value, diagnostics, context);
		case UMLDIPackage.ELEMENT_WITH_STRUCTURE_SHAPE:
			return validateElementWithStructureShape((ElementWithStructureShape)value, diagnostics, context);
		case UMLDIPackage.STRUCTURE_COMPARTMENT:
			return validateStructureCompartment((StructureCompartment)value, diagnostics, context);
		case UMLDIPackage.PORT_SHAPE:
			return validatePortShape((PortShape)value, diagnostics, context);
		case UMLDIPackage.CLASSIFIER_WITH_NESTED_CLASSIFIERS_SHAPE:
			return validateClassifierWithNestedClassifiersShape((ClassifierWithNestedClassifiersShape)value, diagnostics, context);
		case UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT:
			return validateNestedClassifierCompartment((NestedClassifierCompartment)value, diagnostics, context);
		case UMLDIPackage.BEHAVIORED_CLASSIFIER_SHAPE:
			return validateBehavioredClassifierShape((BehavioredClassifierShape)value, diagnostics, context);
		case UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT:
			return validateOwnedBehaviorCompartment((OwnedBehaviorCompartment)value, diagnostics, context);
		case UMLDIPackage.INTERFACE_SHAPE:
			return validateInterfaceShape((InterfaceShape)value, diagnostics, context);
		case UMLDIPackage.DATA_TYPE_SHAPE:
			return validateDataTypeShape((DataTypeShape)value, diagnostics, context);
		case UMLDIPackage.PRIMITIVE_TYPE_SHAPE:
			return validatePrimitiveTypeShape((PrimitiveTypeShape)value, diagnostics, context);
		case UMLDIPackage.SIGNAL_SHAPE:
			return validateSignalShape((SignalShape)value, diagnostics, context);
		case UMLDIPackage.MODEL_SHAPE:
			return validateModelShape((ModelShape)value, diagnostics, context);
		case UMLDIPackage.CONTAINMENT_EDGE:
			return validateContainmentEdge((ContainmentEdge)value, diagnostics, context);
		case UMLDIPackage.GENERALIZATION_EDGE:
			return validateGeneralizationEdge((GeneralizationEdge)value, diagnostics, context);
		case UMLDIPackage.REALIZATION_EDGE:
			return validateRealizationEdge((RealizationEdge)value, diagnostics, context);
		case UMLDIPackage.ABSTRACTION_EDGE:
			return validateAbstractionEdge((AbstractionEdge)value, diagnostics, context);
		case UMLDIPackage.INTERFACE_REALIZATION_EDGE:
			return validateInterfaceRealizationEdge((InterfaceRealizationEdge)value, diagnostics, context);
		case UMLDIPackage.USAGE_EDGE:
			return validateUsageEdge((UsageEdge)value, diagnostics, context);
		case UMLDIPackage.ELEMENT_IMPORT_EDGE:
			return validateElementImportEdge((ElementImportEdge)value, diagnostics, context);
		case UMLDIPackage.PACKAGE_IMPORT_EDGE:
			return validatePackageImportEdge((PackageImportEdge)value, diagnostics, context);
		case UMLDIPackage.PACKAGE_MERGE_EDGE:
			return validatePackageMergeEdge((PackageMergeEdge)value, diagnostics, context);
		case UMLDIPackage.SUBSTITUTION_EDGE:
			return validateSubstitutionEdge((SubstitutionEdge)value, diagnostics, context);
		case UMLDIPackage.INFORMATION_FLOW_EDGE:
			return validateInformationFlowEdge((InformationFlowEdge)value, diagnostics, context);
		case UMLDIPackage.CONVEYED_LABEL:
			return validateConveyedLabel((ConveyedLabel)value, diagnostics, context);
		case UMLDIPackage.ASSOCIATION_CLASS_EDGE:
			return validateAssociationClassEdge((AssociationClassEdge)value, diagnostics, context);
		case UMLDIPackage.COMMENT_SHAPE:
			return validateCommentShape((CommentShape)value, diagnostics, context);
		case UMLDIPackage.ATTACHMENT_EDGE:
			return validateAttachmentEdge((AttachmentEdge)value, diagnostics, context);
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE:
			return validateAssociationClassShape((AssociationClassShape)value, diagnostics, context);
		case UMLDIPackage.COMPONENT_SHAPE:
			return validateComponentShape((ComponentShape)value, diagnostics, context);
		case UMLDIPackage.INFORMATION_ITEM_SHAPE:
			return validateInformationItemShape((InformationItemShape)value, diagnostics, context);
		case UMLDIPackage.REPRESENTATION_EDGE:
			return validateRepresentationEdge((RepresentationEdge)value, diagnostics, context);
		case UMLDIPackage.ASSOCIATION_SHAPE:
			return validateAssociationShape((AssociationShape)value, diagnostics, context);
		case UMLDIPackage.DEPENDENCY_SHAPE:
			return validateDependencyShape((DependencyShape)value, diagnostics, context);
		case UMLDIPackage.TIME_OBSERVATION_SHAPE:
			return validateTimeObservationShape((TimeObservationShape)value, diagnostics, context);
		case UMLDIPackage.TIME_OBSERVATION_SHAPE_TIME_OBSERVATION_SHAPE:
			return validateTimeObservationShape_TimeObservationShape((TimeObservationShape_TimeObservationShape)value, diagnostics, context);
		case UMLDIPackage.DURATION_OBSERVATION_SHAPE:
			return validateDurationObservationShape((DurationObservationShape)value, diagnostics, context);
		case UMLDIPackage.PACKAGE_DIAGRAM:
			return validatePackageDiagram((PackageDiagram)value, diagnostics, context);
		case UMLDIPackage.PROFILE_DIAGRAM:
			return validateProfileDiagram((ProfileDiagram)value, diagnostics, context);
		case UMLDIPackage.COMPOSITE_STRUCTURE_DIAGRAM:
			return validateCompositeStructureDiagram((CompositeStructureDiagram)value, diagnostics, context);
		case UMLDIPackage.DEPLOYMENT_DIAGRAM:
			return validateDeploymentDiagram((DeploymentDiagram)value, diagnostics, context);
		case UMLDIPackage.COMPONENT_DIAGRAM:
			return validateComponentDiagram((ComponentDiagram)value, diagnostics, context);
		case UMLDIPackage.OBJECT_DIAGRAM:
			return validateObjectDiagram((ObjectDiagram)value, diagnostics, context);
		case UMLDIPackage.PROFILE_SHAPE:
			return validateProfileShape((ProfileShape)value, diagnostics, context);
		case UMLDIPackage.PROFILE_APPLICATION_EDGE:
			return validateProfileApplicationEdge((ProfileApplicationEdge)value, diagnostics, context);
		case UMLDIPackage.EXTENSION_EDGE:
			return validateExtensionEdge((ExtensionEdge)value, diagnostics, context);
		case UMLDIPackage.BEHAVIOR_DIAGRAM:
			return validateBehaviorDiagram((BehaviorDiagram)value, diagnostics, context);
		case UMLDIPackage.USE_CASE_DIAGRAM:
			return validateUseCaseDiagram((UseCaseDiagram)value, diagnostics, context);
		case UMLDIPackage.ARTIFACT_SHAPE:
			return validateArtifactShape((ArtifactShape)value, diagnostics, context);
		case UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT:
			return validateNestedArtifactCompartment((NestedArtifactCompartment)value, diagnostics, context);
		case UMLDIPackage.COMPONENT_REALIZATION_EDGE:
			return validateComponentRealizationEdge((ComponentRealizationEdge)value, diagnostics, context);
		case UMLDIPackage.MANIFESTATION_EDGE:
			return validateManifestationEdge((ManifestationEdge)value, diagnostics, context);
		case UMLDIPackage.PROPERTY_SHAPE:
			return validatePropertyShape((PropertyShape)value, diagnostics, context);
		case UMLDIPackage.COLLABORATION_SHAPE:
			return validateCollaborationShape((CollaborationShape)value, diagnostics, context);
		case UMLDIPackage.COLLABORATION_USE_SHAPE:
			return validateCollaborationUseShape((CollaborationUseShape)value, diagnostics, context);
		case UMLDIPackage.TEMPLATE_BINDING_EDGE:
			return validateTemplateBindingEdge((TemplateBindingEdge)value, diagnostics, context);
		case UMLDIPackage.STEREOTYPE_SHAPE:
			return validateStereotypeShape((StereotypeShape)value, diagnostics, context);
		case UMLDIPackage.NODE_SHAPE:
			return validateNodeShape((NodeShape)value, diagnostics, context);
		case UMLDIPackage.NESTED_NODE_COMPARTMENT:
			return validateNestedNodeCompartment((NestedNodeCompartment)value, diagnostics, context);
		case UMLDIPackage.DEVICE_SHAPE:
			return validateDeviceShape((DeviceShape)value, diagnostics, context);
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE:
			return validateExecutionEnvironmentShape((ExecutionEnvironmentShape)value, diagnostics, context);
		case UMLDIPackage.ACTIVITY_SHAPE:
			return validateActivityShape((ActivityShape)value, diagnostics, context);
		case UMLDIPackage.ELEMENT_WITH_ACTIVITY_NODES_SHAPE:
			return validateElementWithActivityNodesShape((ElementWithActivityNodesShape)value, diagnostics, context);
		case UMLDIPackage.ACTIVITY_NODE_COMPARTMENT:
			return validateActivityNodeCompartment((ActivityNodeCompartment)value, diagnostics, context);
		case UMLDIPackage.PARAMETER_COMPARTMENT:
			return validateParameterCompartment((ParameterCompartment)value, diagnostics, context);
		case UMLDIPackage.POST_CONDITION_COMPARTMENT:
			return validatePostConditionCompartment((PostConditionCompartment)value, diagnostics, context);
		case UMLDIPackage.PRE_CONDITION_COMPARTMENT:
			return validatePreConditionCompartment((PreConditionCompartment)value, diagnostics, context);
		case UMLDIPackage.ACTIVITY_PARAMETER_NODE_SHAPE:
			return validateActivityParameterNodeShape((ActivityParameterNodeShape)value, diagnostics, context);
		case UMLDIPackage.INTERACTION_SHAPE:
			return validateInteractionShape((InteractionShape)value, diagnostics, context);
		case UMLDIPackage.INTERACTION_FRAGMENT_WITH_SUBFRAGMENTS_SHAPE:
			return validateInteractionFragmentWithSubfragmentsShape((InteractionFragmentWithSubfragmentsShape)value, diagnostics, context);
		case UMLDIPackage.SUBFRAGMENT_COMPARTMENT:
			return validateSubfragmentCompartment((SubfragmentCompartment)value, diagnostics, context);
		case UMLDIPackage.INTERACTION_FRAGMENT_WITH_GATES_SHAPE:
			return validateInteractionFragmentWithGatesShape((InteractionFragmentWithGatesShape)value, diagnostics, context);
		case UMLDIPackage.GATE_SHAPE:
			return validateGateShape((GateShape)value, diagnostics, context);
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE:
			return validateOpaqueBehaviorShape((OpaqueBehaviorShape)value, diagnostics, context);
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE:
			return validateFunctionBehaviorShape((FunctionBehaviorShape)value, diagnostics, context);
		case UMLDIPackage.STATE_MACHINE_SHAPE:
			return validateStateMachineShape((StateMachineShape)value, diagnostics, context);
		case UMLDIPackage.BASE_STATE_SHAPE:
			return validateBaseStateShape((BaseStateShape)value, diagnostics, context);
		case UMLDIPackage.PSEUDOSTATE_SHAPE:
			return validatePseudostateShape((PseudostateShape)value, diagnostics, context);
		case UMLDIPackage.REGION_COMPARTMENT:
			return validateRegionCompartment((RegionCompartment)value, diagnostics, context);
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE:
			return validateProtocolStateMachineShape((ProtocolStateMachineShape)value, diagnostics, context);
		case UMLDIPackage.DEPLOYMENT_SPECIFICATION_SHAPE:
			return validateDeploymentSpecificationShape((DeploymentSpecificationShape)value, diagnostics, context);
		case UMLDIPackage.COMMUNICATION_PATH_EDGE:
			return validateCommunicationPathEdge((CommunicationPathEdge)value, diagnostics, context);
		case UMLDIPackage.DEPLOYMENT_EDGE:
			return validateDeploymentEdge((DeploymentEdge)value, diagnostics, context);
		case UMLDIPackage.ACTOR_SHAPE:
			return validateActorShape((ActorShape)value, diagnostics, context);
		case UMLDIPackage.EXTENSION_POINT_COMPARTMENT:
			return validateExtensionPointCompartment((ExtensionPointCompartment)value, diagnostics, context);
		case UMLDIPackage.USE_CASE_SHAPE:
			return validateUseCaseShape((UseCaseShape)value, diagnostics, context);
		case UMLDIPackage.INCLUDE_EDGE:
			return validateIncludeEdge((IncludeEdge)value, diagnostics, context);
		case UMLDIPackage.EXTEND_EDGE:
			return validateExtendEdge((ExtendEdge)value, diagnostics, context);
		case UMLDIPackage.STATE_MACHINE_DIAGRAM:
			return validateStateMachineDiagram((StateMachineDiagram)value, diagnostics, context);
		case UMLDIPackage.ACTIVITY_DIAGRAM:
			return validateActivityDiagram((ActivityDiagram)value, diagnostics, context);
		case UMLDIPackage.SEQUENCE_DIAGRAM:
			return validateSequenceDiagram((SequenceDiagram)value, diagnostics, context);
		case UMLDIPackage.INTERACTION_DIAGRAM:
			return validateInteractionDiagram((InteractionDiagram)value, diagnostics, context);
		case UMLDIPackage.COMMUNICATION_DIAGRAM:
			return validateCommunicationDiagram((CommunicationDiagram)value, diagnostics, context);
		case UMLDIPackage.TIMING_DIAGRAM:
			return validateTimingDiagram((TimingDiagram)value, diagnostics, context);
		case UMLDIPackage.INTERACTION_OVERVIEW_DIAGRAM:
			return validateInteractionOverviewDiagram((InteractionOverviewDiagram)value, diagnostics, context);
		case UMLDIPackage.INTERNAL_BEHAVIOR_COMPARTMENT:
			return validateInternalBehaviorCompartment((InternalBehaviorCompartment)value, diagnostics, context);
		case UMLDIPackage.STATE_SHAPE:
			return validateStateShape((StateShape)value, diagnostics, context);
		case UMLDIPackage.CONNECTION_POINT_REFERENCE_SHAPE:
			return validateConnectionPointReferenceShape((ConnectionPointReferenceShape)value, diagnostics, context);
		case UMLDIPackage.INTERNAL_TRANSITION_COMPARTMENT:
			return validateInternalTransitionCompartment((InternalTransitionCompartment)value, diagnostics, context);
		case UMLDIPackage.DEFERRABLE_TRIGGER_COMPARTMENT:
			return validateDeferrableTriggerCompartment((DeferrableTriggerCompartment)value, diagnostics, context);
		case UMLDIPackage.REGION_SHAPE:
			return validateRegionShape((RegionShape)value, diagnostics, context);
		case UMLDIPackage.SUBVERTEX_COMPARTMENT:
			return validateSubvertexCompartment((SubvertexCompartment)value, diagnostics, context);
		case UMLDIPackage.TRANSITION_EDGE:
			return validateTransitionEdge((TransitionEdge)value, diagnostics, context);
		case UMLDIPackage.CONTROL_FLOW_EDGE:
			return validateControlFlowEdge((ControlFlowEdge)value, diagnostics, context);
		case UMLDIPackage.ACTIVITY_GROUP_SHAPE:
			return validateActivityGroupShape((ActivityGroupShape)value, diagnostics, context);
		case UMLDIPackage.EXCEPTION_HANDLER_EDGE:
			return validateExceptionHandlerEdge((ExceptionHandlerEdge)value, diagnostics, context);
		case UMLDIPackage.TYPE_LABEL:
			return validateTypeLabel((TypeLabel)value, diagnostics, context);
		case UMLDIPackage.INTERACTION_USE_SHAPE:
			return validateInteractionUseShape((InteractionUseShape)value, diagnostics, context);
		case UMLDIPackage.ICON_LABEL:
			return validateIconLabel((IconLabel)value, diagnostics, context);
		case UMLDIPackage.SUBPARTITION_COMPARTMENT:
			return validateSubpartitionCompartment((SubpartitionCompartment)value, diagnostics, context);
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE:
			return validateActivityPartitionShape((ActivityPartitionShape)value, diagnostics, context);
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE:
			return validateStructuredActivityNodeShape((StructuredActivityNodeShape)value, diagnostics, context);
		case UMLDIPackage.EXPANSION_REGION_SHAPE:
			return validateExpansionRegionShape((ExpansionRegionShape)value, diagnostics, context);
		case UMLDIPackage.EXPANSION_NODE_SHAPE:
			return validateExpansionNodeShape((ExpansionNodeShape)value, diagnostics, context);
		case UMLDIPackage.MESSAGE_EDGE:
			return validateMessageEdge((MessageEdge)value, diagnostics, context);
		case UMLDIPackage.GENERAL_ORDERING_EDGE:
			return validateGeneralOrderingEdge((GeneralOrderingEdge)value, diagnostics, context);
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE:
			return validateCombinedFragmentShape((CombinedFragmentShape)value, diagnostics, context);
		case UMLDIPackage.INTERACTION_OPERAND_SHAPE:
			return validateInteractionOperandShape((InteractionOperandShape)value, diagnostics, context);
		case UMLDIPackage.EXECUTION_SPECIFICATION_SHAPE:
			return validateExecutionSpecificationShape((ExecutionSpecificationShape)value, diagnostics, context);
		case UMLDIPackage.DURATION_CONSTRAINT_SHAPE:
			return validateDurationConstraintShape((DurationConstraintShape)value, diagnostics, context);
		case UMLDIPackage.TIME_CONSTRAINT_SHAPE:
			return validateTimeConstraintShape((TimeConstraintShape)value, diagnostics, context);
		case UMLDIPackage.TIME_EXPRESSION_SHAPE:
			return validateTimeExpressionShape((TimeExpressionShape)value, diagnostics, context);
		case UMLDIPackage.DURATION_SHAPE:
			return validateDurationShape((DurationShape)value, diagnostics, context);
		case UMLDIPackage.PATH_EDGE:
			return validatePathEdge((PathEdge)value, diagnostics, context);
		case UMLDIPackage.MESSAGE_LABEL:
			return validateMessageLabel((MessageLabel)value, diagnostics, context);
		case UMLDIPackage.STATE_INVARIANT_SHAPE:
			return validateStateInvariantShape((StateInvariantShape)value, diagnostics, context);
		case UMLDIPackage.COMPARTMENT_LAYOUT:
			return validateCompartmentLayout((CompartmentLayout)value, diagnostics, context);
		case UMLDIPackage.PLACEMENT:
			return validatePlacement((Placement)value, diagnostics, context);
		default:
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateUmlDiagram(UmlDiagram umlDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(umlDiagram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateUmlDiagramElement(UmlDiagramElement umlDiagramElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(umlDiagramElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateUmlStyle(UmlStyle umlStyle, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if(!validate_NoCircularContainment(umlStyle, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(umlStyle, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryDataValueConforms(umlStyle, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(umlStyle, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(umlStyle, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryProxyResolves(umlStyle, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_UniqueID(umlStyle, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryKeyUnique(umlStyle, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(umlStyle, diagnostics, context);
		if(result || diagnostics != null)
			result &= validateUmlStyle_fontsizePositive(umlStyle, diagnostics, context);
		return result;
	}

	/**
	 * Validates the fontsizePositive constraint of '<em>Uml Style</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateUmlStyle_fontsizePositive(UmlStyle umlStyle, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return umlStyle.fontsizePositive(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateUmlEdge(UmlEdge umlEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(umlEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTopUmlDiagramElement(TopUmlDiagramElement topUmlDiagramElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(topUmlDiagramElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateStereotypedDiagramElement(StereotypedDiagramElement stereotypedDiagramElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(stereotypedDiagramElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDiagramCompartment(DiagramCompartment diagramCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(diagramCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateUmlCompartment(UmlCompartment umlCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(umlCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateElementWithPackagedElementsShape(ElementWithPackagedElementsShape elementWithPackagedElementsShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(elementWithPackagedElementsShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateUmlLabel(UmlLabel umlLabel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(umlLabel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateElementEdge(ElementEdge elementEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(elementEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateClassifierCompartment(ClassifierCompartment classifierCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(classifierCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateClassDiagram(ClassDiagram classDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(classDiagram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateStructureDiagram(StructureDiagram structureDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(structureDiagram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateClassifierShape(ClassifierShape classifierShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(classifierShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePackageShape(PackageShape packageShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(packageShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTemplateableElementShape(TemplateableElementShape templateableElementShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(templateableElementShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateElementShape(ElementShape elementShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(elementShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateStereotypeCompartment(StereotypeCompartment stereotypeCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(stereotypeCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateConstraintShape(ConstraintShape constraintShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(constraintShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateAttributeCompartment(AttributeCompartment attributeCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attributeCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateOperationCompartment(OperationCompartment operationCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(operationCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateReceptionCompartment(ReceptionCompartment receptionCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(receptionCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateLiteralCompartment(LiteralCompartment literalCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(literalCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePackagedElementCompartment(PackagedElementCompartment packagedElementCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(packagedElementCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePropertyEdge(PropertyEdge propertyEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(propertyEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateConstraintLabel(ConstraintLabel constraintLabel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(constraintLabel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateInstanceSpecificationEdge(InstanceSpecificationEdge instanceSpecificationEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(instanceSpecificationEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateInstanceSpecificationShape(InstanceSpecificationShape instanceSpecificationShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(instanceSpecificationShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDeploymentTargetShape(DeploymentTargetShape deploymentTargetShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(deploymentTargetShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDeployedArtifactCompartment(DeployedArtifactCompartment deployedArtifactCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(deployedArtifactCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateSlotCompartment(SlotCompartment slotCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(slotCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateClassShape(ClassShape classShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(classShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateElementWithPortsShape(ElementWithPortsShape elementWithPortsShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(elementWithPortsShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateElementWithStructureShape(ElementWithStructureShape elementWithStructureShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(elementWithStructureShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateStructureCompartment(StructureCompartment structureCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(structureCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePortShape(PortShape portShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(portShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateClassifierWithNestedClassifiersShape(ClassifierWithNestedClassifiersShape classifierWithNestedClassifiersShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(classifierWithNestedClassifiersShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateNestedClassifierCompartment(NestedClassifierCompartment nestedClassifierCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(nestedClassifierCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateBehavioredClassifierShape(BehavioredClassifierShape behavioredClassifierShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(behavioredClassifierShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateOwnedBehaviorCompartment(OwnedBehaviorCompartment ownedBehaviorCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(ownedBehaviorCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateClassifierWithReceptionsShape(ClassifierWithReceptionsShape classifierWithReceptionsShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(classifierWithReceptionsShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateClassifierWithAttributesShape(ClassifierWithAttributesShape classifierWithAttributesShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(classifierWithAttributesShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateClassifierWithOperationsShape(ClassifierWithOperationsShape classifierWithOperationsShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(classifierWithOperationsShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateInterfaceShape(InterfaceShape interfaceShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(interfaceShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDataTypeShape(DataTypeShape dataTypeShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dataTypeShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePrimitiveTypeShape(PrimitiveTypeShape primitiveTypeShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(primitiveTypeShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateEnumerationShape(EnumerationShape enumerationShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(enumerationShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateRoleLabel(RoleLabel roleLabel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(roleLabel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateSignalShape(SignalShape signalShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(signalShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateModelShape(ModelShape modelShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modelShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateContainmentEdge(ContainmentEdge containmentEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(containmentEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateGeneralizationEdge(GeneralizationEdge generalizationEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(generalizationEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateAssociationEdge(AssociationEdge associationEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(associationEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateMultiplicityLabel(MultiplicityLabel multiplicityLabel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(multiplicityLabel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateRealizationEdge(RealizationEdge realizationEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(realizationEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateAbstractionEdge(AbstractionEdge abstractionEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(abstractionEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDependencyEdge(DependencyEdge dependencyEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dependencyEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateInterfaceRealizationEdge(InterfaceRealizationEdge interfaceRealizationEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(interfaceRealizationEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateUsageEdge(UsageEdge usageEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(usageEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateElementImportEdge(ElementImportEdge elementImportEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(elementImportEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePackageImportEdge(PackageImportEdge packageImportEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(packageImportEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePackageMergeEdge(PackageMergeEdge packageMergeEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(packageMergeEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateSubstitutionEdge(SubstitutionEdge substitutionEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(substitutionEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateInformationFlowEdge(InformationFlowEdge informationFlowEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(informationFlowEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateConveyedLabel(ConveyedLabel conveyedLabel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(conveyedLabel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateAssociationClassEdge(AssociationClassEdge associationClassEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(associationClassEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateGeneralizationSetEdge(GeneralizationSetEdge generalizationSetEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(generalizationSetEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePowerLabel(PowerLabel powerLabel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(powerLabel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateConnectorEdge(ConnectorEdge connectorEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(connectorEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateCommentShape(CommentShape commentShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(commentShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateAttachmentEdge(AttachmentEdge attachmentEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attachmentEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateAssociationClassShape(AssociationClassShape associationClassShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(associationClassShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateComponentShape(ComponentShape componentShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(componentShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateInformationItemShape(InformationItemShape informationItemShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(informationItemShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateRepresentationEdge(RepresentationEdge representationEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(representationEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateAssociationShape(AssociationShape associationShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(associationShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDependencyShape(DependencyShape dependencyShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dependencyShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTimeObservationShape(TimeObservationShape timeObservationShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(timeObservationShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTimeObservationShape_TimeObservationShape(TimeObservationShape_TimeObservationShape timeObservationShape_TimeObservationShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(timeObservationShape_TimeObservationShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDurationObservationShape(DurationObservationShape durationObservationShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(durationObservationShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePackageDiagram(PackageDiagram packageDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(packageDiagram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateProfileDiagram(ProfileDiagram profileDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(profileDiagram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateCompositeStructureDiagram(CompositeStructureDiagram compositeStructureDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(compositeStructureDiagram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDeploymentDiagram(DeploymentDiagram deploymentDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(deploymentDiagram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateComponentDiagram(ComponentDiagram componentDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(componentDiagram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateObjectDiagram(ObjectDiagram objectDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(objectDiagram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateProfileShape(ProfileShape profileShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(profileShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateProfileApplicationEdge(ProfileApplicationEdge profileApplicationEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(profileApplicationEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateExtensionEdge(ExtensionEdge extensionEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(extensionEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateBehaviorDiagram(BehaviorDiagram behaviorDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(behaviorDiagram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateUseCaseDiagram(UseCaseDiagram useCaseDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(useCaseDiagram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateArtifactShape(ArtifactShape artifactShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(artifactShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateNestedArtifactCompartment(NestedArtifactCompartment nestedArtifactCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(nestedArtifactCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateComponentRealizationEdge(ComponentRealizationEdge componentRealizationEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(componentRealizationEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateManifestationEdge(ManifestationEdge manifestationEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(manifestationEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePropertyShape(PropertyShape propertyShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(propertyShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateCollaborationShape(CollaborationShape collaborationShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(collaborationShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateCollaborationUseShape(CollaborationUseShape collaborationUseShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(collaborationUseShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTemplateBindingEdge(TemplateBindingEdge templateBindingEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(templateBindingEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateStereotypeShape(StereotypeShape stereotypeShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(stereotypeShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateNodeShape(NodeShape nodeShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(nodeShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateNestedNodeCompartment(NestedNodeCompartment nestedNodeCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(nestedNodeCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDeviceShape(DeviceShape deviceShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(deviceShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateExecutionEnvironmentShape(ExecutionEnvironmentShape executionEnvironmentShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(executionEnvironmentShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateActivityShape(ActivityShape activityShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(activityShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateElementWithActivityNodesShape(ElementWithActivityNodesShape elementWithActivityNodesShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(elementWithActivityNodesShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateActivityNodeCompartment(ActivityNodeCompartment activityNodeCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(activityNodeCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateParameterCompartment(ParameterCompartment parameterCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parameterCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePostConditionCompartment(PostConditionCompartment postConditionCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(postConditionCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePreConditionCompartment(PreConditionCompartment preConditionCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(preConditionCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateStructuredActivityNodeShape(StructuredActivityNodeShape structuredActivityNodeShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(structuredActivityNodeShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateActivityParameterNodeShape(ActivityParameterNodeShape activityParameterNodeShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(activityParameterNodeShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateInteractionShape(InteractionShape interactionShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(interactionShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateInteractionFragmentWithSubfragmentsShape(InteractionFragmentWithSubfragmentsShape interactionFragmentWithSubfragmentsShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(interactionFragmentWithSubfragmentsShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateInteractionFragmentShape(InteractionFragmentShape interactionFragmentShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(interactionFragmentShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateSubfragmentCompartment(SubfragmentCompartment subfragmentCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subfragmentCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateInteractionFragmentWithGatesShape(InteractionFragmentWithGatesShape interactionFragmentWithGatesShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(interactionFragmentWithGatesShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateGateShape(GateShape gateShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(gateShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateOpaqueBehaviorShape(OpaqueBehaviorShape opaqueBehaviorShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(opaqueBehaviorShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateFunctionBehaviorShape(FunctionBehaviorShape functionBehaviorShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(functionBehaviorShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateStateMachineShape(StateMachineShape stateMachineShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(stateMachineShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateBaseStateShape(BaseStateShape baseStateShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(baseStateShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePseudostateShape(PseudostateShape pseudostateShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(pseudostateShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateRegionCompartment(RegionCompartment regionCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(regionCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateProtocolStateMachineShape(ProtocolStateMachineShape protocolStateMachineShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(protocolStateMachineShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDeploymentSpecificationShape(DeploymentSpecificationShape deploymentSpecificationShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(deploymentSpecificationShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateCommunicationPathEdge(CommunicationPathEdge communicationPathEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(communicationPathEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDeploymentEdge(DeploymentEdge deploymentEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(deploymentEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateActorShape(ActorShape actorShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(actorShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateExtensionPointCompartment(ExtensionPointCompartment extensionPointCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(extensionPointCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateUseCaseShape(UseCaseShape useCaseShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(useCaseShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateIncludeEdge(IncludeEdge includeEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(includeEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateExtendEdge(ExtendEdge extendEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(extendEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateStateMachineDiagram(StateMachineDiagram stateMachineDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(stateMachineDiagram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateActivityDiagram(ActivityDiagram activityDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(activityDiagram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateSequenceDiagram(SequenceDiagram sequenceDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(sequenceDiagram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateInteractionDiagram(InteractionDiagram interactionDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(interactionDiagram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateCommunicationDiagram(CommunicationDiagram communicationDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(communicationDiagram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTimingDiagram(TimingDiagram timingDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(timingDiagram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateInteractionOverviewDiagram(InteractionOverviewDiagram interactionOverviewDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(interactionOverviewDiagram, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateInternalBehaviorCompartment(InternalBehaviorCompartment internalBehaviorCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(internalBehaviorCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateStateShape(StateShape stateShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(stateShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateConnectionPointReferenceShape(ConnectionPointReferenceShape connectionPointReferenceShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(connectionPointReferenceShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateInternalTransitionCompartment(InternalTransitionCompartment internalTransitionCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(internalTransitionCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDeferrableTriggerCompartment(DeferrableTriggerCompartment deferrableTriggerCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(deferrableTriggerCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateRegionShape(RegionShape regionShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(regionShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTransitionEdge(TransitionEdge transitionEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(transitionEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateActivityEdgeEdge(ActivityEdgeEdge activityEdgeEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(activityEdgeEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateWeightLabel(WeightLabel weightLabel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(weightLabel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateControlFlowEdge(ControlFlowEdge controlFlowEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(controlFlowEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateObjectFlowEdge(ObjectFlowEdge objectFlowEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(objectFlowEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateActivityGroupShape(ActivityGroupShape activityGroupShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(activityGroupShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateExceptionHandlerEdge(ExceptionHandlerEdge exceptionHandlerEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(exceptionHandlerEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTypeLabel(TypeLabel typeLabel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(typeLabel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateIconLabel(IconLabel iconLabel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(iconLabel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateActivityPartitionShape(ActivityPartitionShape activityPartitionShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(activityPartitionShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateExpansionRegionShape(ExpansionRegionShape expansionRegionShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(expansionRegionShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateExpansionNodeShape(ExpansionNodeShape expansionNodeShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(expansionNodeShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateLifelineShape(LifelineShape lifelineShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(lifelineShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateExecutionSpecificationShape(ExecutionSpecificationShape executionSpecificationShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(executionSpecificationShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDurationConstraintShape(DurationConstraintShape durationConstraintShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(durationConstraintShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTimeConstraintShape(TimeConstraintShape timeConstraintShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(timeConstraintShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTimeExpressionShape(TimeExpressionShape timeExpressionShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(timeExpressionShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDurationShape(DurationShape durationShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(durationShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePathEdge(PathEdge pathEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(pathEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateMessageLabel(MessageLabel messageLabel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(messageLabel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateStateInvariantShape(StateInvariantShape stateInvariantShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(stateInvariantShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateMessageEdge(MessageEdge messageEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(messageEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateGeneralOrderingEdge(GeneralOrderingEdge generalOrderingEdge, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(generalOrderingEdge, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateCombinedFragmentShape(CombinedFragmentShape combinedFragmentShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(combinedFragmentShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateInteractionUseShape(InteractionUseShape interactionUseShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(interactionUseShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateInteractionOperandShape(InteractionOperandShape interactionOperandShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(interactionOperandShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateActionShape(ActionShape actionShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(actionShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePinShape(PinShape pinShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(pinShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateSubpartitionCompartment(SubpartitionCompartment subpartitionCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subpartitionCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateObjectNodeShape(ObjectNodeShape objectNodeShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(objectNodeShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateSelectionLabel(SelectionLabel selectionLabel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(selectionLabel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTransformationLabel(TransformationLabel transformationLabel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(transformationLabel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateGuardLabel(GuardLabel guardLabel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(guardLabel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateActivityNodeShape(ActivityNodeShape activityNodeShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(activityNodeShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateSubvertexCompartment(SubvertexCompartment subvertexCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subvertexCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePlacement(Placement placement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateCompartmentLayout(CompartmentLayout compartmentLayout, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTemplateParameterCompartment(TemplateParameterCompartment templateParameterCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(templateParameterCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateListCompartment(ListCompartment listCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(listCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateListItemLabel(ListItemLabel listItemLabel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(listItemLabel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateStereotypeLabel(StereotypeLabel stereotypeLabel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(stereotypeLabel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateOwnedUseCaseCompartment(OwnedUseCaseCompartment ownedUseCaseCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(ownedUseCaseCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateUseCaseCompartment(UseCaseCompartment useCaseCompartment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(useCaseCompartment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateUmlShape(UmlShape umlShape, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(umlShape, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateMainLabel(MainLabel mainLabel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mainLabel, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}
} //UMLDIValidator
