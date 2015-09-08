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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.umldi.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class UMLDIFactoryImpl extends EFactoryImpl implements UMLDIFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static UMLDIFactory init() {
		try {
			UMLDIFactory theUMLDIFactory = (UMLDIFactory)EPackage.Registry.INSTANCE.getEFactory(UMLDIPackage.eNS_URI);
			if(theUMLDIFactory != null) {
				return theUMLDIFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UMLDIFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UMLDIFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch(eClass.getClassifierID()) {
		case UMLDIPackage.UML_STYLE:
			return createUmlStyle();
		case UMLDIPackage.STEREOTYPE_LABEL:
			return createStereotypeLabel();
		case UMLDIPackage.MAIN_LABEL:
			return createMainLabel();
		case UMLDIPackage.STEREOTYPE_COMPARTMENT:
			return createStereotypeCompartment();
		case UMLDIPackage.LIST_ITEM_LABEL:
			return createListItemLabel();
		case UMLDIPackage.CLASS_DIAGRAM:
			return createClassDiagram();
		case UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT:
			return createTemplateParameterCompartment();
		case UMLDIPackage.OWNED_USE_CASE_COMPARTMENT:
			return createOwnedUseCaseCompartment();
		case UMLDIPackage.USE_CASE_COMPARTMENT:
			return createUseCaseCompartment();
		case UMLDIPackage.PACKAGE_SHAPE:
			return createPackageShape();
		case UMLDIPackage.PACKAGED_ELEMENT_COMPARTMENT:
			return createPackagedElementCompartment();
		case UMLDIPackage.CONSTRAINT_SHAPE:
			return createConstraintShape();
		case UMLDIPackage.ATTRIBUTE_COMPARTMENT:
			return createAttributeCompartment();
		case UMLDIPackage.OPERATION_COMPARTMENT:
			return createOperationCompartment();
		case UMLDIPackage.RECEPTION_COMPARTMENT:
			return createReceptionCompartment();
		case UMLDIPackage.LITERAL_COMPARTMENT:
			return createLiteralCompartment();
		case UMLDIPackage.ENUMERATION_SHAPE:
			return createEnumerationShape();
		case UMLDIPackage.ROLE_LABEL:
			return createRoleLabel();
		case UMLDIPackage.ASSOCIATION_EDGE:
			return createAssociationEdge();
		case UMLDIPackage.MULTIPLICITY_LABEL:
			return createMultiplicityLabel();
		case UMLDIPackage.PROPERTY_EDGE:
			return createPropertyEdge();
		case UMLDIPackage.CONSTRAINT_LABEL:
			return createConstraintLabel();
		case UMLDIPackage.GENERALIZATION_SET_EDGE:
			return createGeneralizationSetEdge();
		case UMLDIPackage.POWER_LABEL:
			return createPowerLabel();
		case UMLDIPackage.OBJECT_NODE_SHAPE:
			return createObjectNodeShape();
		case UMLDIPackage.ACTIVITY_NODE_SHAPE:
			return createActivityNodeShape();
		case UMLDIPackage.SELECTION_LABEL:
			return createSelectionLabel();
		case UMLDIPackage.OBJECT_FLOW_EDGE:
			return createObjectFlowEdge();
		case UMLDIPackage.GUARD_LABEL:
			return createGuardLabel();
		case UMLDIPackage.WEIGHT_LABEL:
			return createWeightLabel();
		case UMLDIPackage.TRANSFORMATION_LABEL:
			return createTransformationLabel();
		case UMLDIPackage.LIFELINE_SHAPE:
			return createLifelineShape();
		case UMLDIPackage.INTERACTION_FRAGMENT_SHAPE:
			return createInteractionFragmentShape();
		case UMLDIPackage.ACTION_SHAPE:
			return createActionShape();
		case UMLDIPackage.PIN_SHAPE:
			return createPinShape();
		case UMLDIPackage.CONNECTOR_EDGE:
			return createConnectorEdge();
		case UMLDIPackage.INSTANCE_SPECIFICATION_EDGE:
			return createInstanceSpecificationEdge();
		case UMLDIPackage.DEPENDENCY_EDGE:
			return createDependencyEdge();
		case UMLDIPackage.INSTANCE_SPECIFICATION_SHAPE:
			return createInstanceSpecificationShape();
		case UMLDIPackage.DEPLOYED_ARTIFACT_COMPARTMENT:
			return createDeployedArtifactCompartment();
		case UMLDIPackage.SLOT_COMPARTMENT:
			return createSlotCompartment();
		case UMLDIPackage.CLASS_SHAPE:
			return createClassShape();
		case UMLDIPackage.STRUCTURE_COMPARTMENT:
			return createStructureCompartment();
		case UMLDIPackage.PORT_SHAPE:
			return createPortShape();
		case UMLDIPackage.NESTED_CLASSIFIER_COMPARTMENT:
			return createNestedClassifierCompartment();
		case UMLDIPackage.OWNED_BEHAVIOR_COMPARTMENT:
			return createOwnedBehaviorCompartment();
		case UMLDIPackage.INTERFACE_SHAPE:
			return createInterfaceShape();
		case UMLDIPackage.DATA_TYPE_SHAPE:
			return createDataTypeShape();
		case UMLDIPackage.PRIMITIVE_TYPE_SHAPE:
			return createPrimitiveTypeShape();
		case UMLDIPackage.SIGNAL_SHAPE:
			return createSignalShape();
		case UMLDIPackage.MODEL_SHAPE:
			return createModelShape();
		case UMLDIPackage.CONTAINMENT_EDGE:
			return createContainmentEdge();
		case UMLDIPackage.GENERALIZATION_EDGE:
			return createGeneralizationEdge();
		case UMLDIPackage.REALIZATION_EDGE:
			return createRealizationEdge();
		case UMLDIPackage.ABSTRACTION_EDGE:
			return createAbstractionEdge();
		case UMLDIPackage.INTERFACE_REALIZATION_EDGE:
			return createInterfaceRealizationEdge();
		case UMLDIPackage.USAGE_EDGE:
			return createUsageEdge();
		case UMLDIPackage.ELEMENT_IMPORT_EDGE:
			return createElementImportEdge();
		case UMLDIPackage.PACKAGE_IMPORT_EDGE:
			return createPackageImportEdge();
		case UMLDIPackage.PACKAGE_MERGE_EDGE:
			return createPackageMergeEdge();
		case UMLDIPackage.SUBSTITUTION_EDGE:
			return createSubstitutionEdge();
		case UMLDIPackage.INFORMATION_FLOW_EDGE:
			return createInformationFlowEdge();
		case UMLDIPackage.CONVEYED_LABEL:
			return createConveyedLabel();
		case UMLDIPackage.ASSOCIATION_CLASS_EDGE:
			return createAssociationClassEdge();
		case UMLDIPackage.COMMENT_SHAPE:
			return createCommentShape();
		case UMLDIPackage.ATTACHMENT_EDGE:
			return createAttachmentEdge();
		case UMLDIPackage.ASSOCIATION_CLASS_SHAPE:
			return createAssociationClassShape();
		case UMLDIPackage.COMPONENT_SHAPE:
			return createComponentShape();
		case UMLDIPackage.INFORMATION_ITEM_SHAPE:
			return createInformationItemShape();
		case UMLDIPackage.REPRESENTATION_EDGE:
			return createRepresentationEdge();
		case UMLDIPackage.ASSOCIATION_SHAPE:
			return createAssociationShape();
		case UMLDIPackage.DEPENDENCY_SHAPE:
			return createDependencyShape();
		case UMLDIPackage.TIME_OBSERVATION_SHAPE:
			return createTimeObservationShape();
		case UMLDIPackage.TIME_OBSERVATION_SHAPE_TIME_OBSERVATION_SHAPE:
			return createTimeObservationShape_TimeObservationShape();
		case UMLDIPackage.DURATION_OBSERVATION_SHAPE:
			return createDurationObservationShape();
		case UMLDIPackage.PACKAGE_DIAGRAM:
			return createPackageDiagram();
		case UMLDIPackage.PROFILE_DIAGRAM:
			return createProfileDiagram();
		case UMLDIPackage.COMPOSITE_STRUCTURE_DIAGRAM:
			return createCompositeStructureDiagram();
		case UMLDIPackage.DEPLOYMENT_DIAGRAM:
			return createDeploymentDiagram();
		case UMLDIPackage.COMPONENT_DIAGRAM:
			return createComponentDiagram();
		case UMLDIPackage.OBJECT_DIAGRAM:
			return createObjectDiagram();
		case UMLDIPackage.PROFILE_SHAPE:
			return createProfileShape();
		case UMLDIPackage.PROFILE_APPLICATION_EDGE:
			return createProfileApplicationEdge();
		case UMLDIPackage.EXTENSION_EDGE:
			return createExtensionEdge();
		case UMLDIPackage.USE_CASE_DIAGRAM:
			return createUseCaseDiagram();
		case UMLDIPackage.ARTIFACT_SHAPE:
			return createArtifactShape();
		case UMLDIPackage.NESTED_ARTIFACT_COMPARTMENT:
			return createNestedArtifactCompartment();
		case UMLDIPackage.COMPONENT_REALIZATION_EDGE:
			return createComponentRealizationEdge();
		case UMLDIPackage.MANIFESTATION_EDGE:
			return createManifestationEdge();
		case UMLDIPackage.PROPERTY_SHAPE:
			return createPropertyShape();
		case UMLDIPackage.COLLABORATION_SHAPE:
			return createCollaborationShape();
		case UMLDIPackage.COLLABORATION_USE_SHAPE:
			return createCollaborationUseShape();
		case UMLDIPackage.TEMPLATE_BINDING_EDGE:
			return createTemplateBindingEdge();
		case UMLDIPackage.STEREOTYPE_SHAPE:
			return createStereotypeShape();
		case UMLDIPackage.NODE_SHAPE:
			return createNodeShape();
		case UMLDIPackage.NESTED_NODE_COMPARTMENT:
			return createNestedNodeCompartment();
		case UMLDIPackage.DEVICE_SHAPE:
			return createDeviceShape();
		case UMLDIPackage.EXECUTION_ENVIRONMENT_SHAPE:
			return createExecutionEnvironmentShape();
		case UMLDIPackage.ACTIVITY_SHAPE:
			return createActivityShape();
		case UMLDIPackage.ACTIVITY_NODE_COMPARTMENT:
			return createActivityNodeCompartment();
		case UMLDIPackage.PARAMETER_COMPARTMENT:
			return createParameterCompartment();
		case UMLDIPackage.POST_CONDITION_COMPARTMENT:
			return createPostConditionCompartment();
		case UMLDIPackage.PRE_CONDITION_COMPARTMENT:
			return createPreConditionCompartment();
		case UMLDIPackage.ACTIVITY_PARAMETER_NODE_SHAPE:
			return createActivityParameterNodeShape();
		case UMLDIPackage.INTERACTION_SHAPE:
			return createInteractionShape();
		case UMLDIPackage.SUBFRAGMENT_COMPARTMENT:
			return createSubfragmentCompartment();
		case UMLDIPackage.GATE_SHAPE:
			return createGateShape();
		case UMLDIPackage.OPAQUE_BEHAVIOR_SHAPE:
			return createOpaqueBehaviorShape();
		case UMLDIPackage.FUNCTION_BEHAVIOR_SHAPE:
			return createFunctionBehaviorShape();
		case UMLDIPackage.STATE_MACHINE_SHAPE:
			return createStateMachineShape();
		case UMLDIPackage.PSEUDOSTATE_SHAPE:
			return createPseudostateShape();
		case UMLDIPackage.REGION_COMPARTMENT:
			return createRegionCompartment();
		case UMLDIPackage.PROTOCOL_STATE_MACHINE_SHAPE:
			return createProtocolStateMachineShape();
		case UMLDIPackage.DEPLOYMENT_SPECIFICATION_SHAPE:
			return createDeploymentSpecificationShape();
		case UMLDIPackage.COMMUNICATION_PATH_EDGE:
			return createCommunicationPathEdge();
		case UMLDIPackage.DEPLOYMENT_EDGE:
			return createDeploymentEdge();
		case UMLDIPackage.ACTOR_SHAPE:
			return createActorShape();
		case UMLDIPackage.EXTENSION_POINT_COMPARTMENT:
			return createExtensionPointCompartment();
		case UMLDIPackage.USE_CASE_SHAPE:
			return createUseCaseShape();
		case UMLDIPackage.INCLUDE_EDGE:
			return createIncludeEdge();
		case UMLDIPackage.EXTEND_EDGE:
			return createExtendEdge();
		case UMLDIPackage.STATE_MACHINE_DIAGRAM:
			return createStateMachineDiagram();
		case UMLDIPackage.ACTIVITY_DIAGRAM:
			return createActivityDiagram();
		case UMLDIPackage.SEQUENCE_DIAGRAM:
			return createSequenceDiagram();
		case UMLDIPackage.COMMUNICATION_DIAGRAM:
			return createCommunicationDiagram();
		case UMLDIPackage.TIMING_DIAGRAM:
			return createTimingDiagram();
		case UMLDIPackage.INTERACTION_OVERVIEW_DIAGRAM:
			return createInteractionOverviewDiagram();
		case UMLDIPackage.INTERNAL_BEHAVIOR_COMPARTMENT:
			return createInternalBehaviorCompartment();
		case UMLDIPackage.STATE_SHAPE:
			return createStateShape();
		case UMLDIPackage.CONNECTION_POINT_REFERENCE_SHAPE:
			return createConnectionPointReferenceShape();
		case UMLDIPackage.INTERNAL_TRANSITION_COMPARTMENT:
			return createInternalTransitionCompartment();
		case UMLDIPackage.DEFERRABLE_TRIGGER_COMPARTMENT:
			return createDeferrableTriggerCompartment();
		case UMLDIPackage.REGION_SHAPE:
			return createRegionShape();
		case UMLDIPackage.SUBVERTEX_COMPARTMENT:
			return createSubvertexCompartment();
		case UMLDIPackage.TRANSITION_EDGE:
			return createTransitionEdge();
		case UMLDIPackage.CONTROL_FLOW_EDGE:
			return createControlFlowEdge();
		case UMLDIPackage.ACTIVITY_GROUP_SHAPE:
			return createActivityGroupShape();
		case UMLDIPackage.EXCEPTION_HANDLER_EDGE:
			return createExceptionHandlerEdge();
		case UMLDIPackage.TYPE_LABEL:
			return createTypeLabel();
		case UMLDIPackage.INTERACTION_USE_SHAPE:
			return createInteractionUseShape();
		case UMLDIPackage.ICON_LABEL:
			return createIconLabel();
		case UMLDIPackage.SUBPARTITION_COMPARTMENT:
			return createSubpartitionCompartment();
		case UMLDIPackage.ACTIVITY_PARTITION_SHAPE:
			return createActivityPartitionShape();
		case UMLDIPackage.STRUCTURED_ACTIVITY_NODE_SHAPE:
			return createStructuredActivityNodeShape();
		case UMLDIPackage.EXPANSION_REGION_SHAPE:
			return createExpansionRegionShape();
		case UMLDIPackage.EXPANSION_NODE_SHAPE:
			return createExpansionNodeShape();
		case UMLDIPackage.MESSAGE_EDGE:
			return createMessageEdge();
		case UMLDIPackage.GENERAL_ORDERING_EDGE:
			return createGeneralOrderingEdge();
		case UMLDIPackage.COMBINED_FRAGMENT_SHAPE:
			return createCombinedFragmentShape();
		case UMLDIPackage.INTERACTION_OPERAND_SHAPE:
			return createInteractionOperandShape();
		case UMLDIPackage.EXECUTION_SPECIFICATION_SHAPE:
			return createExecutionSpecificationShape();
		case UMLDIPackage.DURATION_CONSTRAINT_SHAPE:
			return createDurationConstraintShape();
		case UMLDIPackage.TIME_CONSTRAINT_SHAPE:
			return createTimeConstraintShape();
		case UMLDIPackage.TIME_EXPRESSION_SHAPE:
			return createTimeExpressionShape();
		case UMLDIPackage.DURATION_SHAPE:
			return createDurationShape();
		case UMLDIPackage.PATH_EDGE:
			return createPathEdge();
		case UMLDIPackage.MESSAGE_LABEL:
			return createMessageLabel();
		case UMLDIPackage.STATE_INVARIANT_SHAPE:
			return createStateInvariantShape();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch(eDataType.getClassifierID()) {
		case UMLDIPackage.COMPARTMENT_LAYOUT:
			return createCompartmentLayoutFromString(eDataType, initialValue);
		case UMLDIPackage.PLACEMENT:
			return createPlacementFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch(eDataType.getClassifierID()) {
		case UMLDIPackage.COMPARTMENT_LAYOUT:
			return convertCompartmentLayoutToString(eDataType, instanceValue);
		case UMLDIPackage.PLACEMENT:
			return convertPlacementToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UmlStyle createUmlStyle() {
		UmlStyleImpl umlStyle = new UmlStyleImpl();
		return umlStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MainLabel createMainLabel() {
		MainLabelImpl mainLabel = new MainLabelImpl();
		return mainLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ClassDiagram createClassDiagram() {
		ClassDiagramImpl classDiagram = new ClassDiagramImpl();
		return classDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StereotypeCompartment createStereotypeCompartment() {
		StereotypeCompartmentImpl stereotypeCompartment = new StereotypeCompartmentImpl();
		return stereotypeCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TemplateParameterCompartment createTemplateParameterCompartment() {
		TemplateParameterCompartmentImpl templateParameterCompartment = new TemplateParameterCompartmentImpl();
		return templateParameterCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ListItemLabel createListItemLabel() {
		ListItemLabelImpl listItemLabel = new ListItemLabelImpl();
		return listItemLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StereotypeLabel createStereotypeLabel() {
		StereotypeLabelImpl stereotypeLabel = new StereotypeLabelImpl();
		return stereotypeLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OwnedUseCaseCompartment createOwnedUseCaseCompartment() {
		OwnedUseCaseCompartmentImpl ownedUseCaseCompartment = new OwnedUseCaseCompartmentImpl();
		return ownedUseCaseCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UseCaseCompartment createUseCaseCompartment() {
		UseCaseCompartmentImpl useCaseCompartment = new UseCaseCompartmentImpl();
		return useCaseCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PackageShape createPackageShape() {
		PackageShapeImpl packageShape = new PackageShapeImpl();
		return packageShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PackagedElementCompartment createPackagedElementCompartment() {
		PackagedElementCompartmentImpl packagedElementCompartment = new PackagedElementCompartmentImpl();
		return packagedElementCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConstraintShape createConstraintShape() {
		ConstraintShapeImpl constraintShape = new ConstraintShapeImpl();
		return constraintShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AttributeCompartment createAttributeCompartment() {
		AttributeCompartmentImpl attributeCompartment = new AttributeCompartmentImpl();
		return attributeCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OperationCompartment createOperationCompartment() {
		OperationCompartmentImpl operationCompartment = new OperationCompartmentImpl();
		return operationCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ReceptionCompartment createReceptionCompartment() {
		ReceptionCompartmentImpl receptionCompartment = new ReceptionCompartmentImpl();
		return receptionCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LiteralCompartment createLiteralCompartment() {
		LiteralCompartmentImpl literalCompartment = new LiteralCompartmentImpl();
		return literalCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EnumerationShape createEnumerationShape() {
		EnumerationShapeImpl enumerationShape = new EnumerationShapeImpl();
		return enumerationShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RoleLabel createRoleLabel() {
		RoleLabelImpl roleLabel = new RoleLabelImpl();
		return roleLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AssociationEdge createAssociationEdge() {
		AssociationEdgeImpl associationEdge = new AssociationEdgeImpl();
		return associationEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MultiplicityLabel createMultiplicityLabel() {
		MultiplicityLabelImpl multiplicityLabel = new MultiplicityLabelImpl();
		return multiplicityLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PropertyEdge createPropertyEdge() {
		PropertyEdgeImpl propertyEdge = new PropertyEdgeImpl();
		return propertyEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConstraintLabel createConstraintLabel() {
		ConstraintLabelImpl constraintLabel = new ConstraintLabelImpl();
		return constraintLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GeneralizationSetEdge createGeneralizationSetEdge() {
		GeneralizationSetEdgeImpl generalizationSetEdge = new GeneralizationSetEdgeImpl();
		return generalizationSetEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PowerLabel createPowerLabel() {
		PowerLabelImpl powerLabel = new PowerLabelImpl();
		return powerLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ObjectNodeShape createObjectNodeShape() {
		ObjectNodeShapeImpl objectNodeShape = new ObjectNodeShapeImpl();
		return objectNodeShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ActivityNodeShape createActivityNodeShape() {
		ActivityNodeShapeImpl activityNodeShape = new ActivityNodeShapeImpl();
		return activityNodeShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SelectionLabel createSelectionLabel() {
		SelectionLabelImpl selectionLabel = new SelectionLabelImpl();
		return selectionLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ObjectFlowEdge createObjectFlowEdge() {
		ObjectFlowEdgeImpl objectFlowEdge = new ObjectFlowEdgeImpl();
		return objectFlowEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GuardLabel createGuardLabel() {
		GuardLabelImpl guardLabel = new GuardLabelImpl();
		return guardLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WeightLabel createWeightLabel() {
		WeightLabelImpl weightLabel = new WeightLabelImpl();
		return weightLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TransformationLabel createTransformationLabel() {
		TransformationLabelImpl transformationLabel = new TransformationLabelImpl();
		return transformationLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConnectorEdge createConnectorEdge() {
		ConnectorEdgeImpl connectorEdge = new ConnectorEdgeImpl();
		return connectorEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InstanceSpecificationEdge createInstanceSpecificationEdge() {
		InstanceSpecificationEdgeImpl instanceSpecificationEdge = new InstanceSpecificationEdgeImpl();
		return instanceSpecificationEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DependencyEdge createDependencyEdge() {
		DependencyEdgeImpl dependencyEdge = new DependencyEdgeImpl();
		return dependencyEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InstanceSpecificationShape createInstanceSpecificationShape() {
		InstanceSpecificationShapeImpl instanceSpecificationShape = new InstanceSpecificationShapeImpl();
		return instanceSpecificationShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeployedArtifactCompartment createDeployedArtifactCompartment() {
		DeployedArtifactCompartmentImpl deployedArtifactCompartment = new DeployedArtifactCompartmentImpl();
		return deployedArtifactCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SlotCompartment createSlotCompartment() {
		SlotCompartmentImpl slotCompartment = new SlotCompartmentImpl();
		return slotCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ClassShape createClassShape() {
		ClassShapeImpl classShape = new ClassShapeImpl();
		return classShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StructureCompartment createStructureCompartment() {
		StructureCompartmentImpl structureCompartment = new StructureCompartmentImpl();
		return structureCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PortShape createPortShape() {
		PortShapeImpl portShape = new PortShapeImpl();
		return portShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NestedClassifierCompartment createNestedClassifierCompartment() {
		NestedClassifierCompartmentImpl nestedClassifierCompartment = new NestedClassifierCompartmentImpl();
		return nestedClassifierCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OwnedBehaviorCompartment createOwnedBehaviorCompartment() {
		OwnedBehaviorCompartmentImpl ownedBehaviorCompartment = new OwnedBehaviorCompartmentImpl();
		return ownedBehaviorCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InterfaceShape createInterfaceShape() {
		InterfaceShapeImpl interfaceShape = new InterfaceShapeImpl();
		return interfaceShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DataTypeShape createDataTypeShape() {
		DataTypeShapeImpl dataTypeShape = new DataTypeShapeImpl();
		return dataTypeShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PrimitiveTypeShape createPrimitiveTypeShape() {
		PrimitiveTypeShapeImpl primitiveTypeShape = new PrimitiveTypeShapeImpl();
		return primitiveTypeShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SignalShape createSignalShape() {
		SignalShapeImpl signalShape = new SignalShapeImpl();
		return signalShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelShape createModelShape() {
		ModelShapeImpl modelShape = new ModelShapeImpl();
		return modelShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ContainmentEdge createContainmentEdge() {
		ContainmentEdgeImpl containmentEdge = new ContainmentEdgeImpl();
		return containmentEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GeneralizationEdge createGeneralizationEdge() {
		GeneralizationEdgeImpl generalizationEdge = new GeneralizationEdgeImpl();
		return generalizationEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RealizationEdge createRealizationEdge() {
		RealizationEdgeImpl realizationEdge = new RealizationEdgeImpl();
		return realizationEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AbstractionEdge createAbstractionEdge() {
		AbstractionEdgeImpl abstractionEdge = new AbstractionEdgeImpl();
		return abstractionEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InterfaceRealizationEdge createInterfaceRealizationEdge() {
		InterfaceRealizationEdgeImpl interfaceRealizationEdge = new InterfaceRealizationEdgeImpl();
		return interfaceRealizationEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UsageEdge createUsageEdge() {
		UsageEdgeImpl usageEdge = new UsageEdgeImpl();
		return usageEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ElementImportEdge createElementImportEdge() {
		ElementImportEdgeImpl elementImportEdge = new ElementImportEdgeImpl();
		return elementImportEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PackageImportEdge createPackageImportEdge() {
		PackageImportEdgeImpl packageImportEdge = new PackageImportEdgeImpl();
		return packageImportEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PackageMergeEdge createPackageMergeEdge() {
		PackageMergeEdgeImpl packageMergeEdge = new PackageMergeEdgeImpl();
		return packageMergeEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SubstitutionEdge createSubstitutionEdge() {
		SubstitutionEdgeImpl substitutionEdge = new SubstitutionEdgeImpl();
		return substitutionEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InformationFlowEdge createInformationFlowEdge() {
		InformationFlowEdgeImpl informationFlowEdge = new InformationFlowEdgeImpl();
		return informationFlowEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConveyedLabel createConveyedLabel() {
		ConveyedLabelImpl conveyedLabel = new ConveyedLabelImpl();
		return conveyedLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AssociationClassEdge createAssociationClassEdge() {
		AssociationClassEdgeImpl associationClassEdge = new AssociationClassEdgeImpl();
		return associationClassEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommentShape createCommentShape() {
		CommentShapeImpl commentShape = new CommentShapeImpl();
		return commentShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AttachmentEdge createAttachmentEdge() {
		AttachmentEdgeImpl attachmentEdge = new AttachmentEdgeImpl();
		return attachmentEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AssociationClassShape createAssociationClassShape() {
		AssociationClassShapeImpl associationClassShape = new AssociationClassShapeImpl();
		return associationClassShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ComponentShape createComponentShape() {
		ComponentShapeImpl componentShape = new ComponentShapeImpl();
		return componentShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InformationItemShape createInformationItemShape() {
		InformationItemShapeImpl informationItemShape = new InformationItemShapeImpl();
		return informationItemShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RepresentationEdge createRepresentationEdge() {
		RepresentationEdgeImpl representationEdge = new RepresentationEdgeImpl();
		return representationEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AssociationShape createAssociationShape() {
		AssociationShapeImpl associationShape = new AssociationShapeImpl();
		return associationShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DependencyShape createDependencyShape() {
		DependencyShapeImpl dependencyShape = new DependencyShapeImpl();
		return dependencyShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TimeObservationShape createTimeObservationShape() {
		TimeObservationShapeImpl timeObservationShape = new TimeObservationShapeImpl();
		return timeObservationShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TimeObservationShape_TimeObservationShape createTimeObservationShape_TimeObservationShape() {
		TimeObservationShape_TimeObservationShapeImpl timeObservationShape_TimeObservationShape = new TimeObservationShape_TimeObservationShapeImpl();
		return timeObservationShape_TimeObservationShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DurationObservationShape createDurationObservationShape() {
		DurationObservationShapeImpl durationObservationShape = new DurationObservationShapeImpl();
		return durationObservationShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PackageDiagram createPackageDiagram() {
		PackageDiagramImpl packageDiagram = new PackageDiagramImpl();
		return packageDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProfileDiagram createProfileDiagram() {
		ProfileDiagramImpl profileDiagram = new ProfileDiagramImpl();
		return profileDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CompositeStructureDiagram createCompositeStructureDiagram() {
		CompositeStructureDiagramImpl compositeStructureDiagram = new CompositeStructureDiagramImpl();
		return compositeStructureDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeploymentDiagram createDeploymentDiagram() {
		DeploymentDiagramImpl deploymentDiagram = new DeploymentDiagramImpl();
		return deploymentDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ComponentDiagram createComponentDiagram() {
		ComponentDiagramImpl componentDiagram = new ComponentDiagramImpl();
		return componentDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ObjectDiagram createObjectDiagram() {
		ObjectDiagramImpl objectDiagram = new ObjectDiagramImpl();
		return objectDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProfileShape createProfileShape() {
		ProfileShapeImpl profileShape = new ProfileShapeImpl();
		return profileShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProfileApplicationEdge createProfileApplicationEdge() {
		ProfileApplicationEdgeImpl profileApplicationEdge = new ProfileApplicationEdgeImpl();
		return profileApplicationEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExtensionEdge createExtensionEdge() {
		ExtensionEdgeImpl extensionEdge = new ExtensionEdgeImpl();
		return extensionEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UseCaseDiagram createUseCaseDiagram() {
		UseCaseDiagramImpl useCaseDiagram = new UseCaseDiagramImpl();
		return useCaseDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ArtifactShape createArtifactShape() {
		ArtifactShapeImpl artifactShape = new ArtifactShapeImpl();
		return artifactShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NestedArtifactCompartment createNestedArtifactCompartment() {
		NestedArtifactCompartmentImpl nestedArtifactCompartment = new NestedArtifactCompartmentImpl();
		return nestedArtifactCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ComponentRealizationEdge createComponentRealizationEdge() {
		ComponentRealizationEdgeImpl componentRealizationEdge = new ComponentRealizationEdgeImpl();
		return componentRealizationEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ManifestationEdge createManifestationEdge() {
		ManifestationEdgeImpl manifestationEdge = new ManifestationEdgeImpl();
		return manifestationEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PropertyShape createPropertyShape() {
		PropertyShapeImpl propertyShape = new PropertyShapeImpl();
		return propertyShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CollaborationShape createCollaborationShape() {
		CollaborationShapeImpl collaborationShape = new CollaborationShapeImpl();
		return collaborationShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CollaborationUseShape createCollaborationUseShape() {
		CollaborationUseShapeImpl collaborationUseShape = new CollaborationUseShapeImpl();
		return collaborationUseShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TemplateBindingEdge createTemplateBindingEdge() {
		TemplateBindingEdgeImpl templateBindingEdge = new TemplateBindingEdgeImpl();
		return templateBindingEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StereotypeShape createStereotypeShape() {
		StereotypeShapeImpl stereotypeShape = new StereotypeShapeImpl();
		return stereotypeShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NodeShape createNodeShape() {
		NodeShapeImpl nodeShape = new NodeShapeImpl();
		return nodeShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NestedNodeCompartment createNestedNodeCompartment() {
		NestedNodeCompartmentImpl nestedNodeCompartment = new NestedNodeCompartmentImpl();
		return nestedNodeCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeviceShape createDeviceShape() {
		DeviceShapeImpl deviceShape = new DeviceShapeImpl();
		return deviceShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExecutionEnvironmentShape createExecutionEnvironmentShape() {
		ExecutionEnvironmentShapeImpl executionEnvironmentShape = new ExecutionEnvironmentShapeImpl();
		return executionEnvironmentShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ActivityShape createActivityShape() {
		ActivityShapeImpl activityShape = new ActivityShapeImpl();
		return activityShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ActivityNodeCompartment createActivityNodeCompartment() {
		ActivityNodeCompartmentImpl activityNodeCompartment = new ActivityNodeCompartmentImpl();
		return activityNodeCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ParameterCompartment createParameterCompartment() {
		ParameterCompartmentImpl parameterCompartment = new ParameterCompartmentImpl();
		return parameterCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PostConditionCompartment createPostConditionCompartment() {
		PostConditionCompartmentImpl postConditionCompartment = new PostConditionCompartmentImpl();
		return postConditionCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PreConditionCompartment createPreConditionCompartment() {
		PreConditionCompartmentImpl preConditionCompartment = new PreConditionCompartmentImpl();
		return preConditionCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ActivityParameterNodeShape createActivityParameterNodeShape() {
		ActivityParameterNodeShapeImpl activityParameterNodeShape = new ActivityParameterNodeShapeImpl();
		return activityParameterNodeShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InteractionShape createInteractionShape() {
		InteractionShapeImpl interactionShape = new InteractionShapeImpl();
		return interactionShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InteractionFragmentShape createInteractionFragmentShape() {
		InteractionFragmentShapeImpl interactionFragmentShape = new InteractionFragmentShapeImpl();
		return interactionFragmentShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SubfragmentCompartment createSubfragmentCompartment() {
		SubfragmentCompartmentImpl subfragmentCompartment = new SubfragmentCompartmentImpl();
		return subfragmentCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GateShape createGateShape() {
		GateShapeImpl gateShape = new GateShapeImpl();
		return gateShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OpaqueBehaviorShape createOpaqueBehaviorShape() {
		OpaqueBehaviorShapeImpl opaqueBehaviorShape = new OpaqueBehaviorShapeImpl();
		return opaqueBehaviorShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FunctionBehaviorShape createFunctionBehaviorShape() {
		FunctionBehaviorShapeImpl functionBehaviorShape = new FunctionBehaviorShapeImpl();
		return functionBehaviorShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StateMachineShape createStateMachineShape() {
		StateMachineShapeImpl stateMachineShape = new StateMachineShapeImpl();
		return stateMachineShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PseudostateShape createPseudostateShape() {
		PseudostateShapeImpl pseudostateShape = new PseudostateShapeImpl();
		return pseudostateShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RegionCompartment createRegionCompartment() {
		RegionCompartmentImpl regionCompartment = new RegionCompartmentImpl();
		return regionCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProtocolStateMachineShape createProtocolStateMachineShape() {
		ProtocolStateMachineShapeImpl protocolStateMachineShape = new ProtocolStateMachineShapeImpl();
		return protocolStateMachineShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeploymentSpecificationShape createDeploymentSpecificationShape() {
		DeploymentSpecificationShapeImpl deploymentSpecificationShape = new DeploymentSpecificationShapeImpl();
		return deploymentSpecificationShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommunicationPathEdge createCommunicationPathEdge() {
		CommunicationPathEdgeImpl communicationPathEdge = new CommunicationPathEdgeImpl();
		return communicationPathEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeploymentEdge createDeploymentEdge() {
		DeploymentEdgeImpl deploymentEdge = new DeploymentEdgeImpl();
		return deploymentEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ActorShape createActorShape() {
		ActorShapeImpl actorShape = new ActorShapeImpl();
		return actorShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExtensionPointCompartment createExtensionPointCompartment() {
		ExtensionPointCompartmentImpl extensionPointCompartment = new ExtensionPointCompartmentImpl();
		return extensionPointCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UseCaseShape createUseCaseShape() {
		UseCaseShapeImpl useCaseShape = new UseCaseShapeImpl();
		return useCaseShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IncludeEdge createIncludeEdge() {
		IncludeEdgeImpl includeEdge = new IncludeEdgeImpl();
		return includeEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExtendEdge createExtendEdge() {
		ExtendEdgeImpl extendEdge = new ExtendEdgeImpl();
		return extendEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StateMachineDiagram createStateMachineDiagram() {
		StateMachineDiagramImpl stateMachineDiagram = new StateMachineDiagramImpl();
		return stateMachineDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ActivityDiagram createActivityDiagram() {
		ActivityDiagramImpl activityDiagram = new ActivityDiagramImpl();
		return activityDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SequenceDiagram createSequenceDiagram() {
		SequenceDiagramImpl sequenceDiagram = new SequenceDiagramImpl();
		return sequenceDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommunicationDiagram createCommunicationDiagram() {
		CommunicationDiagramImpl communicationDiagram = new CommunicationDiagramImpl();
		return communicationDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TimingDiagram createTimingDiagram() {
		TimingDiagramImpl timingDiagram = new TimingDiagramImpl();
		return timingDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InteractionOverviewDiagram createInteractionOverviewDiagram() {
		InteractionOverviewDiagramImpl interactionOverviewDiagram = new InteractionOverviewDiagramImpl();
		return interactionOverviewDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InternalBehaviorCompartment createInternalBehaviorCompartment() {
		InternalBehaviorCompartmentImpl internalBehaviorCompartment = new InternalBehaviorCompartmentImpl();
		return internalBehaviorCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StateShape createStateShape() {
		StateShapeImpl stateShape = new StateShapeImpl();
		return stateShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConnectionPointReferenceShape createConnectionPointReferenceShape() {
		ConnectionPointReferenceShapeImpl connectionPointReferenceShape = new ConnectionPointReferenceShapeImpl();
		return connectionPointReferenceShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InternalTransitionCompartment createInternalTransitionCompartment() {
		InternalTransitionCompartmentImpl internalTransitionCompartment = new InternalTransitionCompartmentImpl();
		return internalTransitionCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeferrableTriggerCompartment createDeferrableTriggerCompartment() {
		DeferrableTriggerCompartmentImpl deferrableTriggerCompartment = new DeferrableTriggerCompartmentImpl();
		return deferrableTriggerCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RegionShape createRegionShape() {
		RegionShapeImpl regionShape = new RegionShapeImpl();
		return regionShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SubvertexCompartment createSubvertexCompartment() {
		SubvertexCompartmentImpl subvertexCompartment = new SubvertexCompartmentImpl();
		return subvertexCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TransitionEdge createTransitionEdge() {
		TransitionEdgeImpl transitionEdge = new TransitionEdgeImpl();
		return transitionEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ControlFlowEdge createControlFlowEdge() {
		ControlFlowEdgeImpl controlFlowEdge = new ControlFlowEdgeImpl();
		return controlFlowEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ActivityGroupShape createActivityGroupShape() {
		ActivityGroupShapeImpl activityGroupShape = new ActivityGroupShapeImpl();
		return activityGroupShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExceptionHandlerEdge createExceptionHandlerEdge() {
		ExceptionHandlerEdgeImpl exceptionHandlerEdge = new ExceptionHandlerEdgeImpl();
		return exceptionHandlerEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TypeLabel createTypeLabel() {
		TypeLabelImpl typeLabel = new TypeLabelImpl();
		return typeLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IconLabel createIconLabel() {
		IconLabelImpl iconLabel = new IconLabelImpl();
		return iconLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ActionShape createActionShape() {
		ActionShapeImpl actionShape = new ActionShapeImpl();
		return actionShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PinShape createPinShape() {
		PinShapeImpl pinShape = new PinShapeImpl();
		return pinShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SubpartitionCompartment createSubpartitionCompartment() {
		SubpartitionCompartmentImpl subpartitionCompartment = new SubpartitionCompartmentImpl();
		return subpartitionCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ActivityPartitionShape createActivityPartitionShape() {
		ActivityPartitionShapeImpl activityPartitionShape = new ActivityPartitionShapeImpl();
		return activityPartitionShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StructuredActivityNodeShape createStructuredActivityNodeShape() {
		StructuredActivityNodeShapeImpl structuredActivityNodeShape = new StructuredActivityNodeShapeImpl();
		return structuredActivityNodeShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExpansionRegionShape createExpansionRegionShape() {
		ExpansionRegionShapeImpl expansionRegionShape = new ExpansionRegionShapeImpl();
		return expansionRegionShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExpansionNodeShape createExpansionNodeShape() {
		ExpansionNodeShapeImpl expansionNodeShape = new ExpansionNodeShapeImpl();
		return expansionNodeShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LifelineShape createLifelineShape() {
		LifelineShapeImpl lifelineShape = new LifelineShapeImpl();
		return lifelineShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExecutionSpecificationShape createExecutionSpecificationShape() {
		ExecutionSpecificationShapeImpl executionSpecificationShape = new ExecutionSpecificationShapeImpl();
		return executionSpecificationShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DurationConstraintShape createDurationConstraintShape() {
		DurationConstraintShapeImpl durationConstraintShape = new DurationConstraintShapeImpl();
		return durationConstraintShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TimeConstraintShape createTimeConstraintShape() {
		TimeConstraintShapeImpl timeConstraintShape = new TimeConstraintShapeImpl();
		return timeConstraintShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TimeExpressionShape createTimeExpressionShape() {
		TimeExpressionShapeImpl timeExpressionShape = new TimeExpressionShapeImpl();
		return timeExpressionShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DurationShape createDurationShape() {
		DurationShapeImpl durationShape = new DurationShapeImpl();
		return durationShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PathEdge createPathEdge() {
		PathEdgeImpl pathEdge = new PathEdgeImpl();
		return pathEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MessageLabel createMessageLabel() {
		MessageLabelImpl messageLabel = new MessageLabelImpl();
		return messageLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StateInvariantShape createStateInvariantShape() {
		StateInvariantShapeImpl stateInvariantShape = new StateInvariantShapeImpl();
		return stateInvariantShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MessageEdge createMessageEdge() {
		MessageEdgeImpl messageEdge = new MessageEdgeImpl();
		return messageEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GeneralOrderingEdge createGeneralOrderingEdge() {
		GeneralOrderingEdgeImpl generalOrderingEdge = new GeneralOrderingEdgeImpl();
		return generalOrderingEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CombinedFragmentShape createCombinedFragmentShape() {
		CombinedFragmentShapeImpl combinedFragmentShape = new CombinedFragmentShapeImpl();
		return combinedFragmentShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InteractionUseShape createInteractionUseShape() {
		InteractionUseShapeImpl interactionUseShape = new InteractionUseShapeImpl();
		return interactionUseShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InteractionOperandShape createInteractionOperandShape() {
		InteractionOperandShapeImpl interactionOperandShape = new InteractionOperandShapeImpl();
		return interactionOperandShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CompartmentLayout createCompartmentLayoutFromString(EDataType eDataType, String initialValue) {
		CompartmentLayout result = CompartmentLayout.get(initialValue);
		if(result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertCompartmentLayoutToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Placement createPlacementFromString(EDataType eDataType, String initialValue) {
		Placement result = Placement.get(initialValue);
		if(result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertPlacementToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UMLDIPackage getUMLDIPackage() {
		return (UMLDIPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UMLDIPackage getPackage() {
		return UMLDIPackage.eINSTANCE;
	}
} //UMLDIFactoryImpl
