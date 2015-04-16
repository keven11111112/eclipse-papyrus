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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.dd.di.Diagram;
import org.eclipse.papyrus.dd.di.DiagramElement;
import org.eclipse.papyrus.dd.di.Edge;
import org.eclipse.papyrus.dd.di.Shape;
import org.eclipse.papyrus.dd.di.Style;

import org.eclipse.papyrus.umldi.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.umldi.UMLDIPackage
 * @generated
 */
public class UMLDIAdapterFactory extends AdapterFactoryImpl {

	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UMLDIPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLDIAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = UMLDIPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UMLDISwitch<Adapter> modelSwitch = new UMLDISwitch<Adapter>() {
			@Override
			public Adapter caseUmlDiagram(UmlDiagram object) {
				return createUmlDiagramAdapter();
			}
			@Override
			public Adapter caseUmlDiagramElement(UmlDiagramElement object) {
				return createUmlDiagramElementAdapter();
			}
			@Override
			public Adapter caseUmlStyle(UmlStyle object) {
				return createUmlStyleAdapter();
			}
			@Override
			public Adapter caseUmlEdge(UmlEdge object) {
				return createUmlEdgeAdapter();
			}
			@Override
			public Adapter caseTopUmlDiagramElement(TopUmlDiagramElement object) {
				return createTopUmlDiagramElementAdapter();
			}
			@Override
			public Adapter caseDiagramCompartment(DiagramCompartment object) {
				return createDiagramCompartmentAdapter();
			}
			@Override
			public Adapter caseUmlCompartment(UmlCompartment object) {
				return createUmlCompartmentAdapter();
			}
			@Override
			public Adapter caseMainLabel(MainLabel object) {
				return createMainLabelAdapter();
			}
			@Override
			public Adapter caseUmlLabel(UmlLabel object) {
				return createUmlLabelAdapter();
			}
			@Override
			public Adapter caseUmlShape(UmlShape object) {
				return createUmlShapeAdapter();
			}
			@Override
			public Adapter caseClassDiagram(ClassDiagram object) {
				return createClassDiagramAdapter();
			}
			@Override
			public Adapter caseStructureDiagram(StructureDiagram object) {
				return createStructureDiagramAdapter();
			}
			@Override
			public Adapter caseClassifierShape(ClassifierShape object) {
				return createClassifierShapeAdapter();
			}
			@Override
			public Adapter caseTemplateableElementShape(TemplateableElementShape object) {
				return createTemplateableElementShapeAdapter();
			}
			@Override
			public Adapter caseElementShape(ElementShape object) {
				return createElementShapeAdapter();
			}
			@Override
			public Adapter caseTemplateParameterCompartment(TemplateParameterCompartment object) {
				return createTemplateParameterCompartmentAdapter();
			}
			@Override
			public Adapter caseListCompartment(ListCompartment object) {
				return createListCompartmentAdapter();
			}
			@Override
			public Adapter caseListItemLabel(ListItemLabel object) {
				return createListItemLabelAdapter();
			}
			@Override
			public Adapter caseOwnedUseCaseCompartment(OwnedUseCaseCompartment object) {
				return createOwnedUseCaseCompartmentAdapter();
			}
			@Override
			public Adapter caseClassifierCompartment(ClassifierCompartment object) {
				return createClassifierCompartmentAdapter();
			}
			@Override
			public Adapter caseUseCaseCompartment(UseCaseCompartment object) {
				return createUseCaseCompartmentAdapter();
			}
			@Override
			public Adapter casePackageShape(PackageShape object) {
				return createPackageShapeAdapter();
			}
			@Override
			public Adapter caseElementWithPackagedElementsShape(ElementWithPackagedElementsShape object) {
				return createElementWithPackagedElementsShapeAdapter();
			}
			@Override
			public Adapter casePackagedElementCompartment(PackagedElementCompartment object) {
				return createPackagedElementCompartmentAdapter();
			}
			@Override
			public Adapter caseConstraintShape(ConstraintShape object) {
				return createConstraintShapeAdapter();
			}
			@Override
			public Adapter caseElementWithBodyShape(ElementWithBodyShape object) {
				return createElementWithBodyShapeAdapter();
			}
			@Override
			public Adapter caseBodyLabel(BodyLabel object) {
				return createBodyLabelAdapter();
			}
			@Override
			public Adapter caseAttributeCompartment(AttributeCompartment object) {
				return createAttributeCompartmentAdapter();
			}
			@Override
			public Adapter caseClassifierWithAttributesShape(ClassifierWithAttributesShape object) {
				return createClassifierWithAttributesShapeAdapter();
			}
			@Override
			public Adapter caseOperationCompartment(OperationCompartment object) {
				return createOperationCompartmentAdapter();
			}
			@Override
			public Adapter caseClassifierWithOperationsShape(ClassifierWithOperationsShape object) {
				return createClassifierWithOperationsShapeAdapter();
			}
			@Override
			public Adapter caseReceptionCompartment(ReceptionCompartment object) {
				return createReceptionCompartmentAdapter();
			}
			@Override
			public Adapter caseClassifierWithReceptionsShape(ClassifierWithReceptionsShape object) {
				return createClassifierWithReceptionsShapeAdapter();
			}
			@Override
			public Adapter caseLiteralCompartment(LiteralCompartment object) {
				return createLiteralCompartmentAdapter();
			}
			@Override
			public Adapter caseEnumerationShape(EnumerationShape object) {
				return createEnumerationShapeAdapter();
			}
			@Override
			public Adapter caseRoleLabel(RoleLabel object) {
				return createRoleLabelAdapter();
			}
			@Override
			public Adapter caseAssociationEdge(AssociationEdge object) {
				return createAssociationEdgeAdapter();
			}
			@Override
			public Adapter caseElementEdge(ElementEdge object) {
				return createElementEdgeAdapter();
			}
			@Override
			public Adapter caseMultiplicityLabel(MultiplicityLabel object) {
				return createMultiplicityLabelAdapter();
			}
			@Override
			public Adapter casePropertyEdge(PropertyEdge object) {
				return createPropertyEdgeAdapter();
			}
			@Override
			public Adapter caseConstraintLabel(ConstraintLabel object) {
				return createConstraintLabelAdapter();
			}
			@Override
			public Adapter caseGeneralizationSetEdge(GeneralizationSetEdge object) {
				return createGeneralizationSetEdgeAdapter();
			}
			@Override
			public Adapter casePowerLabel(PowerLabel object) {
				return createPowerLabelAdapter();
			}
			@Override
			public Adapter caseObjectNodeShape(ObjectNodeShape object) {
				return createObjectNodeShapeAdapter();
			}
			@Override
			public Adapter caseActivityNodeShape(ActivityNodeShape object) {
				return createActivityNodeShapeAdapter();
			}
			@Override
			public Adapter caseSelectionLabel(SelectionLabel object) {
				return createSelectionLabelAdapter();
			}
			@Override
			public Adapter caseObjectFlowEdge(ObjectFlowEdge object) {
				return createObjectFlowEdgeAdapter();
			}
			@Override
			public Adapter caseActivityEdgeEdge(ActivityEdgeEdge object) {
				return createActivityEdgeEdgeAdapter();
			}
			@Override
			public Adapter caseRelationshipWithGuardEdge(RelationshipWithGuardEdge object) {
				return createRelationshipWithGuardEdgeAdapter();
			}
			@Override
			public Adapter caseGuardLabel(GuardLabel object) {
				return createGuardLabelAdapter();
			}
			@Override
			public Adapter caseWeightLabel(WeightLabel object) {
				return createWeightLabelAdapter();
			}
			@Override
			public Adapter caseTransformationLabel(TransformationLabel object) {
				return createTransformationLabelAdapter();
			}
			@Override
			public Adapter caseConnectorEdge(ConnectorEdge object) {
				return createConnectorEdgeAdapter();
			}
			@Override
			public Adapter caseInstanceSpecificationEdge(InstanceSpecificationEdge object) {
				return createInstanceSpecificationEdgeAdapter();
			}
			@Override
			public Adapter caseDependencyEdge(DependencyEdge object) {
				return createDependencyEdgeAdapter();
			}
			@Override
			public Adapter caseInstanceSpecificationShape(InstanceSpecificationShape object) {
				return createInstanceSpecificationShapeAdapter();
			}
			@Override
			public Adapter caseDeploymentTargetShape(DeploymentTargetShape object) {
				return createDeploymentTargetShapeAdapter();
			}
			@Override
			public Adapter caseDeployedArtifactCompartment(DeployedArtifactCompartment object) {
				return createDeployedArtifactCompartmentAdapter();
			}
			@Override
			public Adapter caseSlotCompartment(SlotCompartment object) {
				return createSlotCompartmentAdapter();
			}
			@Override
			public Adapter caseClassShape(ClassShape object) {
				return createClassShapeAdapter();
			}
			@Override
			public Adapter caseElementWithPortsShape(ElementWithPortsShape object) {
				return createElementWithPortsShapeAdapter();
			}
			@Override
			public Adapter caseElementWithInternalStructureShape(ElementWithInternalStructureShape object) {
				return createElementWithInternalStructureShapeAdapter();
			}
			@Override
			public Adapter caseInternalStructureCompartment(InternalStructureCompartment object) {
				return createInternalStructureCompartmentAdapter();
			}
			@Override
			public Adapter casePortShape(PortShape object) {
				return createPortShapeAdapter();
			}
			@Override
			public Adapter caseClassifierWithNestedClassifiersShape(ClassifierWithNestedClassifiersShape object) {
				return createClassifierWithNestedClassifiersShapeAdapter();
			}
			@Override
			public Adapter caseNestedClassifierCompartment(NestedClassifierCompartment object) {
				return createNestedClassifierCompartmentAdapter();
			}
			@Override
			public Adapter caseBehavioredClassifierShape(BehavioredClassifierShape object) {
				return createBehavioredClassifierShapeAdapter();
			}
			@Override
			public Adapter caseOwnedBehaviorCompartment(OwnedBehaviorCompartment object) {
				return createOwnedBehaviorCompartmentAdapter();
			}
			@Override
			public Adapter caseInterfaceShape(InterfaceShape object) {
				return createInterfaceShapeAdapter();
			}
			@Override
			public Adapter caseDataTypeShape(DataTypeShape object) {
				return createDataTypeShapeAdapter();
			}
			@Override
			public Adapter casePrimitiveTypeShape(PrimitiveTypeShape object) {
				return createPrimitiveTypeShapeAdapter();
			}
			@Override
			public Adapter caseSignalShape(SignalShape object) {
				return createSignalShapeAdapter();
			}
			@Override
			public Adapter caseModelShape(ModelShape object) {
				return createModelShapeAdapter();
			}
			@Override
			public Adapter caseContainmentEdge(ContainmentEdge object) {
				return createContainmentEdgeAdapter();
			}
			@Override
			public Adapter caseGeneralizationEdge(GeneralizationEdge object) {
				return createGeneralizationEdgeAdapter();
			}
			@Override
			public Adapter caseRealizationEdge(RealizationEdge object) {
				return createRealizationEdgeAdapter();
			}
			@Override
			public Adapter caseAbstractionEdge(AbstractionEdge object) {
				return createAbstractionEdgeAdapter();
			}
			@Override
			public Adapter caseInterfaceRealizationEdge(InterfaceRealizationEdge object) {
				return createInterfaceRealizationEdgeAdapter();
			}
			@Override
			public Adapter caseUsageEdge(UsageEdge object) {
				return createUsageEdgeAdapter();
			}
			@Override
			public Adapter caseElementImportEdge(ElementImportEdge object) {
				return createElementImportEdgeAdapter();
			}
			@Override
			public Adapter casePackageImportEdge(PackageImportEdge object) {
				return createPackageImportEdgeAdapter();
			}
			@Override
			public Adapter casePackageMergeEdge(PackageMergeEdge object) {
				return createPackageMergeEdgeAdapter();
			}
			@Override
			public Adapter caseSubstitutionEdge(SubstitutionEdge object) {
				return createSubstitutionEdgeAdapter();
			}
			@Override
			public Adapter caseInformationFlowEdge(InformationFlowEdge object) {
				return createInformationFlowEdgeAdapter();
			}
			@Override
			public Adapter caseConveyedLabel(ConveyedLabel object) {
				return createConveyedLabelAdapter();
			}
			@Override
			public Adapter caseAssociationClassEdge(AssociationClassEdge object) {
				return createAssociationClassEdgeAdapter();
			}
			@Override
			public Adapter caseCommentShape(CommentShape object) {
				return createCommentShapeAdapter();
			}
			@Override
			public Adapter caseAttachmentEdge(AttachmentEdge object) {
				return createAttachmentEdgeAdapter();
			}
			@Override
			public Adapter caseAssociationClassShape(AssociationClassShape object) {
				return createAssociationClassShapeAdapter();
			}
			@Override
			public Adapter caseComponentShape(ComponentShape object) {
				return createComponentShapeAdapter();
			}
			@Override
			public Adapter caseInformationItemShape(InformationItemShape object) {
				return createInformationItemShapeAdapter();
			}
			@Override
			public Adapter caseRepresentationEdge(RepresentationEdge object) {
				return createRepresentationEdgeAdapter();
			}
			@Override
			public Adapter caseAssociationShape(AssociationShape object) {
				return createAssociationShapeAdapter();
			}
			@Override
			public Adapter caseDependencyShape(DependencyShape object) {
				return createDependencyShapeAdapter();
			}
			@Override
			public Adapter caseTimeObservationShape(TimeObservationShape object) {
				return createTimeObservationShapeAdapter();
			}
			@Override
			public Adapter caseDurationObservationShape(DurationObservationShape object) {
				return createDurationObservationShapeAdapter();
			}
			@Override
			public Adapter casePackageDiagram(PackageDiagram object) {
				return createPackageDiagramAdapter();
			}
			@Override
			public Adapter caseProfileDiagram(ProfileDiagram object) {
				return createProfileDiagramAdapter();
			}
			@Override
			public Adapter caseCompositeStructureDiagram(CompositeStructureDiagram object) {
				return createCompositeStructureDiagramAdapter();
			}
			@Override
			public Adapter caseDeploymentDiagram(DeploymentDiagram object) {
				return createDeploymentDiagramAdapter();
			}
			@Override
			public Adapter caseComponentDiagram(ComponentDiagram object) {
				return createComponentDiagramAdapter();
			}
			@Override
			public Adapter caseObjectDiagram(ObjectDiagram object) {
				return createObjectDiagramAdapter();
			}
			@Override
			public Adapter caseProfileShape(ProfileShape object) {
				return createProfileShapeAdapter();
			}
			@Override
			public Adapter caseProfileApplicationEdge(ProfileApplicationEdge object) {
				return createProfileApplicationEdgeAdapter();
			}
			@Override
			public Adapter caseExtensionEdge(ExtensionEdge object) {
				return createExtensionEdgeAdapter();
			}
			@Override
			public Adapter caseBehaviorDiagram(BehaviorDiagram object) {
				return createBehaviorDiagramAdapter();
			}
			@Override
			public Adapter caseUseCaseDiagram(UseCaseDiagram object) {
				return createUseCaseDiagramAdapter();
			}
			@Override
			public Adapter caseArtifactShape(ArtifactShape object) {
				return createArtifactShapeAdapter();
			}
			@Override
			public Adapter caseNestedArtifactCompartment(NestedArtifactCompartment object) {
				return createNestedArtifactCompartmentAdapter();
			}
			@Override
			public Adapter caseComponentRealizationEdge(ComponentRealizationEdge object) {
				return createComponentRealizationEdgeAdapter();
			}
			@Override
			public Adapter caseManifestationEdge(ManifestationEdge object) {
				return createManifestationEdgeAdapter();
			}
			@Override
			public Adapter casePropertyShape(PropertyShape object) {
				return createPropertyShapeAdapter();
			}
			@Override
			public Adapter caseCollaborationShape(CollaborationShape object) {
				return createCollaborationShapeAdapter();
			}
			@Override
			public Adapter caseCollaborationUseShape(CollaborationUseShape object) {
				return createCollaborationUseShapeAdapter();
			}
			@Override
			public Adapter caseTemplateBindingEdge(TemplateBindingEdge object) {
				return createTemplateBindingEdgeAdapter();
			}
			@Override
			public Adapter caseStereotypeShape(StereotypeShape object) {
				return createStereotypeShapeAdapter();
			}
			@Override
			public Adapter caseNodeShape(NodeShape object) {
				return createNodeShapeAdapter();
			}
			@Override
			public Adapter caseNestedNodeCompartment(NestedNodeCompartment object) {
				return createNestedNodeCompartmentAdapter();
			}
			@Override
			public Adapter caseDeviceShape(DeviceShape object) {
				return createDeviceShapeAdapter();
			}
			@Override
			public Adapter caseExecutionEnvironmentShape(ExecutionEnvironmentShape object) {
				return createExecutionEnvironmentShapeAdapter();
			}
			@Override
			public Adapter caseActivityShape(ActivityShape object) {
				return createActivityShapeAdapter();
			}
			@Override
			public Adapter caseParameterCompartment(ParameterCompartment object) {
				return createParameterCompartmentAdapter();
			}
			@Override
			public Adapter casePostConditionCompartment(PostConditionCompartment object) {
				return createPostConditionCompartmentAdapter();
			}
			@Override
			public Adapter casePreConditionCompartment(PreConditionCompartment object) {
				return createPreConditionCompartmentAdapter();
			}
			@Override
			public Adapter caseContentCompartment(ContentCompartment object) {
				return createContentCompartmentAdapter();
			}
			@Override
			public Adapter caseStructuredActivityNodeShape(StructuredActivityNodeShape object) {
				return createStructuredActivityNodeShapeAdapter();
			}
			@Override
			public Adapter caseActionShape(ActionShape object) {
				return createActionShapeAdapter();
			}
			@Override
			public Adapter casePinShape(PinShape object) {
				return createPinShapeAdapter();
			}
			@Override
			public Adapter caseActivityGroupShape(ActivityGroupShape object) {
				return createActivityGroupShapeAdapter();
			}
			@Override
			public Adapter caseActivityParameterNodeShape(ActivityParameterNodeShape object) {
				return createActivityParameterNodeShapeAdapter();
			}
			@Override
			public Adapter caseInteractionShape(InteractionShape object) {
				return createInteractionShapeAdapter();
			}
			@Override
			public Adapter caseOpaqueBehaviorShape(OpaqueBehaviorShape object) {
				return createOpaqueBehaviorShapeAdapter();
			}
			@Override
			public Adapter caseFunctionBehaviorShape(FunctionBehaviorShape object) {
				return createFunctionBehaviorShapeAdapter();
			}
			@Override
			public Adapter caseStateMachineShape(StateMachineShape object) {
				return createStateMachineShapeAdapter();
			}
			@Override
			public Adapter caseBaseStateShape(BaseStateShape object) {
				return createBaseStateShapeAdapter();
			}
			@Override
			public Adapter casePseudostateShape(PseudostateShape object) {
				return createPseudostateShapeAdapter();
			}
			@Override
			public Adapter caseRegionCompartment(RegionCompartment object) {
				return createRegionCompartmentAdapter();
			}
			@Override
			public Adapter caseProtocolStateMachineShape(ProtocolStateMachineShape object) {
				return createProtocolStateMachineShapeAdapter();
			}
			@Override
			public Adapter caseDeploymentSpecificationShape(DeploymentSpecificationShape object) {
				return createDeploymentSpecificationShapeAdapter();
			}
			@Override
			public Adapter caseCommunicationPathEdge(CommunicationPathEdge object) {
				return createCommunicationPathEdgeAdapter();
			}
			@Override
			public Adapter caseDeploymentEdge(DeploymentEdge object) {
				return createDeploymentEdgeAdapter();
			}
			@Override
			public Adapter caseActorShape(ActorShape object) {
				return createActorShapeAdapter();
			}
			@Override
			public Adapter caseExtensionPointCompartment(ExtensionPointCompartment object) {
				return createExtensionPointCompartmentAdapter();
			}
			@Override
			public Adapter caseUseCaseShape(UseCaseShape object) {
				return createUseCaseShapeAdapter();
			}
			@Override
			public Adapter caseIncludeEdge(IncludeEdge object) {
				return createIncludeEdgeAdapter();
			}
			@Override
			public Adapter caseExtendEdge(ExtendEdge object) {
				return createExtendEdgeAdapter();
			}
			@Override
			public Adapter caseStateMachineDiagram(StateMachineDiagram object) {
				return createStateMachineDiagramAdapter();
			}
			@Override
			public Adapter caseActivityDiagram(ActivityDiagram object) {
				return createActivityDiagramAdapter();
			}
			@Override
			public Adapter caseSequenceDiagram(SequenceDiagram object) {
				return createSequenceDiagramAdapter();
			}
			@Override
			public Adapter caseInteractionDiagram(InteractionDiagram object) {
				return createInteractionDiagramAdapter();
			}
			@Override
			public Adapter caseCommunicationDiagram(CommunicationDiagram object) {
				return createCommunicationDiagramAdapter();
			}
			@Override
			public Adapter caseTimingDiagram(TimingDiagram object) {
				return createTimingDiagramAdapter();
			}
			@Override
			public Adapter caseInteractionOverviewDiagram(InteractionOverviewDiagram object) {
				return createInteractionOverviewDiagramAdapter();
			}
			@Override
			public Adapter caseInternalBehaviorCompartment(InternalBehaviorCompartment object) {
				return createInternalBehaviorCompartmentAdapter();
			}
			@Override
			public Adapter caseStateShape(StateShape object) {
				return createStateShapeAdapter();
			}
			@Override
			public Adapter caseConnectionPointReferenceShape(ConnectionPointReferenceShape object) {
				return createConnectionPointReferenceShapeAdapter();
			}
			@Override
			public Adapter caseInternalTransitionCompartment(InternalTransitionCompartment object) {
				return createInternalTransitionCompartmentAdapter();
			}
			@Override
			public Adapter caseDeferrableTriggerCompartment(DeferrableTriggerCompartment object) {
				return createDeferrableTriggerCompartmentAdapter();
			}
			@Override
			public Adapter caseRegionShape(RegionShape object) {
				return createRegionShapeAdapter();
			}
			@Override
			public Adapter caseSubvertexCompartment(SubvertexCompartment object) {
				return createSubvertexCompartmentAdapter();
			}
			@Override
			public Adapter caseTransitionEdge(TransitionEdge object) {
				return createTransitionEdgeAdapter();
			}
			@Override
			public Adapter caseControlFlowEdge(ControlFlowEdge object) {
				return createControlFlowEdgeAdapter();
			}
			@Override
			public Adapter caseExceptionHandlerEdge(ExceptionHandlerEdge object) {
				return createExceptionHandlerEdgeAdapter();
			}
			@Override
			public Adapter caseTypeLabel(TypeLabel object) {
				return createTypeLabelAdapter();
			}
			@Override
			public Adapter caseIconLabel(IconLabel object) {
				return createIconLabelAdapter();
			}
			@Override
			public Adapter caseSubPartitionCompartment(SubPartitionCompartment object) {
				return createSubPartitionCompartmentAdapter();
			}
			@Override
			public Adapter caseActivityPartitionShape(ActivityPartitionShape object) {
				return createActivityPartitionShapeAdapter();
			}
			@Override
			public Adapter caseExpansionRegionShape(ExpansionRegionShape object) {
				return createExpansionRegionShapeAdapter();
			}
			@Override
			public Adapter caseExpansionNodeShape(ExpansionNodeShape object) {
				return createExpansionNodeShapeAdapter();
			}
			@Override
			public Adapter caseDiagramElement(DiagramElement object) {
				return createDiagramElementAdapter();
			}
			@Override
			public Adapter caseShape(Shape object) {
				return createShapeAdapter();
			}
			@Override
			public Adapter caseDiagram(Diagram object) {
				return createDiagramAdapter();
			}
			@Override
			public Adapter caseStyle(Style object) {
				return createStyleAdapter();
			}
			@Override
			public Adapter caseEdge(Edge object) {
				return createEdgeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.UmlDiagram <em>Uml Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.UmlDiagram
	 * @generated
	 */
	public Adapter createUmlDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.UmlDiagramElement <em>Uml Diagram Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.UmlDiagramElement
	 * @generated
	 */
	public Adapter createUmlDiagramElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.UmlStyle <em>Uml Style</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.UmlStyle
	 * @generated
	 */
	public Adapter createUmlStyleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.UmlEdge <em>Uml Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.UmlEdge
	 * @generated
	 */
	public Adapter createUmlEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.TopUmlDiagramElement <em>Top Uml Diagram Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.TopUmlDiagramElement
	 * @generated
	 */
	public Adapter createTopUmlDiagramElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.DiagramCompartment <em>Diagram Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.DiagramCompartment
	 * @generated
	 */
	public Adapter createDiagramCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.UmlCompartment <em>Uml Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.UmlCompartment
	 * @generated
	 */
	public Adapter createUmlCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ElementWithPackagedElementsShape <em>Element With Packaged Elements Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ElementWithPackagedElementsShape
	 * @generated
	 */
	public Adapter createElementWithPackagedElementsShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.UmlLabel <em>Uml Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.UmlLabel
	 * @generated
	 */
	public Adapter createUmlLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ElementEdge <em>Element Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ElementEdge
	 * @generated
	 */
	public Adapter createElementEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.InternalStructureCompartment <em>Internal Structure Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.InternalStructureCompartment
	 * @generated
	 */
	public Adapter createInternalStructureCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ElementWithInternalStructureShape <em>Element With Internal Structure Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ElementWithInternalStructureShape
	 * @generated
	 */
	public Adapter createElementWithInternalStructureShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ClassifierCompartment <em>Classifier Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ClassifierCompartment
	 * @generated
	 */
	public Adapter createClassifierCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ClassDiagram <em>Class Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ClassDiagram
	 * @generated
	 */
	public Adapter createClassDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.StructureDiagram <em>Structure Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.StructureDiagram
	 * @generated
	 */
	public Adapter createStructureDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ClassifierShape <em>Classifier Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ClassifierShape
	 * @generated
	 */
	public Adapter createClassifierShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.PackageShape <em>Package Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.PackageShape
	 * @generated
	 */
	public Adapter createPackageShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.TemplateableElementShape <em>Templateable Element Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.TemplateableElementShape
	 * @generated
	 */
	public Adapter createTemplateableElementShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ElementShape <em>Element Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ElementShape
	 * @generated
	 */
	public Adapter createElementShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ConstraintShape <em>Constraint Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ConstraintShape
	 * @generated
	 */
	public Adapter createConstraintShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ElementWithBodyShape <em>Element With Body Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ElementWithBodyShape
	 * @generated
	 */
	public Adapter createElementWithBodyShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.AttributeCompartment <em>Attribute Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.AttributeCompartment
	 * @generated
	 */
	public Adapter createAttributeCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.OperationCompartment <em>Operation Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.OperationCompartment
	 * @generated
	 */
	public Adapter createOperationCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ReceptionCompartment <em>Reception Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ReceptionCompartment
	 * @generated
	 */
	public Adapter createReceptionCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.LiteralCompartment <em>Literal Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.LiteralCompartment
	 * @generated
	 */
	public Adapter createLiteralCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.PackagedElementCompartment <em>Packaged Element Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.PackagedElementCompartment
	 * @generated
	 */
	public Adapter createPackagedElementCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.PropertyEdge <em>Property Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.PropertyEdge
	 * @generated
	 */
	public Adapter createPropertyEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ConstraintLabel <em>Constraint Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ConstraintLabel
	 * @generated
	 */
	public Adapter createConstraintLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.InstanceSpecificationEdge <em>Instance Specification Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.InstanceSpecificationEdge
	 * @generated
	 */
	public Adapter createInstanceSpecificationEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.BodyLabel <em>Body Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.BodyLabel
	 * @generated
	 */
	public Adapter createBodyLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.InstanceSpecificationShape <em>Instance Specification Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.InstanceSpecificationShape
	 * @generated
	 */
	public Adapter createInstanceSpecificationShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.DeploymentTargetShape <em>Deployment Target Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.DeploymentTargetShape
	 * @generated
	 */
	public Adapter createDeploymentTargetShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.DeployedArtifactCompartment <em>Deployed Artifact Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.DeployedArtifactCompartment
	 * @generated
	 */
	public Adapter createDeployedArtifactCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.SlotCompartment <em>Slot Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.SlotCompartment
	 * @generated
	 */
	public Adapter createSlotCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ClassShape <em>Class Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ClassShape
	 * @generated
	 */
	public Adapter createClassShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ElementWithPortsShape <em>Element With Ports Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ElementWithPortsShape
	 * @generated
	 */
	public Adapter createElementWithPortsShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.PortShape <em>Port Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.PortShape
	 * @generated
	 */
	public Adapter createPortShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ClassifierWithNestedClassifiersShape <em>Classifier With Nested Classifiers Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ClassifierWithNestedClassifiersShape
	 * @generated
	 */
	public Adapter createClassifierWithNestedClassifiersShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.NestedClassifierCompartment <em>Nested Classifier Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.NestedClassifierCompartment
	 * @generated
	 */
	public Adapter createNestedClassifierCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.BehavioredClassifierShape <em>Behaviored Classifier Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.BehavioredClassifierShape
	 * @generated
	 */
	public Adapter createBehavioredClassifierShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.OwnedBehaviorCompartment <em>Owned Behavior Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.OwnedBehaviorCompartment
	 * @generated
	 */
	public Adapter createOwnedBehaviorCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ClassifierWithReceptionsShape <em>Classifier With Receptions Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ClassifierWithReceptionsShape
	 * @generated
	 */
	public Adapter createClassifierWithReceptionsShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ClassifierWithAttributesShape <em>Classifier With Attributes Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ClassifierWithAttributesShape
	 * @generated
	 */
	public Adapter createClassifierWithAttributesShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ClassifierWithOperationsShape <em>Classifier With Operations Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ClassifierWithOperationsShape
	 * @generated
	 */
	public Adapter createClassifierWithOperationsShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.InterfaceShape <em>Interface Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.InterfaceShape
	 * @generated
	 */
	public Adapter createInterfaceShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.DataTypeShape <em>Data Type Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.DataTypeShape
	 * @generated
	 */
	public Adapter createDataTypeShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.PrimitiveTypeShape <em>Primitive Type Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.PrimitiveTypeShape
	 * @generated
	 */
	public Adapter createPrimitiveTypeShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.EnumerationShape <em>Enumeration Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.EnumerationShape
	 * @generated
	 */
	public Adapter createEnumerationShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.RoleLabel <em>Role Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.RoleLabel
	 * @generated
	 */
	public Adapter createRoleLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.SignalShape <em>Signal Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.SignalShape
	 * @generated
	 */
	public Adapter createSignalShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ModelShape <em>Model Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ModelShape
	 * @generated
	 */
	public Adapter createModelShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ContainmentEdge <em>Containment Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ContainmentEdge
	 * @generated
	 */
	public Adapter createContainmentEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.GeneralizationEdge <em>Generalization Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.GeneralizationEdge
	 * @generated
	 */
	public Adapter createGeneralizationEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.AssociationEdge <em>Association Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.AssociationEdge
	 * @generated
	 */
	public Adapter createAssociationEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.MultiplicityLabel <em>Multiplicity Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.MultiplicityLabel
	 * @generated
	 */
	public Adapter createMultiplicityLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.RealizationEdge <em>Realization Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.RealizationEdge
	 * @generated
	 */
	public Adapter createRealizationEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.AbstractionEdge <em>Abstraction Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.AbstractionEdge
	 * @generated
	 */
	public Adapter createAbstractionEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.DependencyEdge <em>Dependency Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.DependencyEdge
	 * @generated
	 */
	public Adapter createDependencyEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.InterfaceRealizationEdge <em>Interface Realization Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.InterfaceRealizationEdge
	 * @generated
	 */
	public Adapter createInterfaceRealizationEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.UsageEdge <em>Usage Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.UsageEdge
	 * @generated
	 */
	public Adapter createUsageEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ElementImportEdge <em>Element Import Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ElementImportEdge
	 * @generated
	 */
	public Adapter createElementImportEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.PackageImportEdge <em>Package Import Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.PackageImportEdge
	 * @generated
	 */
	public Adapter createPackageImportEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.PackageMergeEdge <em>Package Merge Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.PackageMergeEdge
	 * @generated
	 */
	public Adapter createPackageMergeEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.SubstitutionEdge <em>Substitution Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.SubstitutionEdge
	 * @generated
	 */
	public Adapter createSubstitutionEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.InformationFlowEdge <em>Information Flow Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.InformationFlowEdge
	 * @generated
	 */
	public Adapter createInformationFlowEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ConveyedLabel <em>Conveyed Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ConveyedLabel
	 * @generated
	 */
	public Adapter createConveyedLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.AssociationClassEdge <em>Association Class Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.AssociationClassEdge
	 * @generated
	 */
	public Adapter createAssociationClassEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.GeneralizationSetEdge <em>Generalization Set Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.GeneralizationSetEdge
	 * @generated
	 */
	public Adapter createGeneralizationSetEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.PowerLabel <em>Power Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.PowerLabel
	 * @generated
	 */
	public Adapter createPowerLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ConnectorEdge <em>Connector Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ConnectorEdge
	 * @generated
	 */
	public Adapter createConnectorEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.CommentShape <em>Comment Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.CommentShape
	 * @generated
	 */
	public Adapter createCommentShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.AttachmentEdge <em>Attachment Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.AttachmentEdge
	 * @generated
	 */
	public Adapter createAttachmentEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.AssociationClassShape <em>Association Class Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.AssociationClassShape
	 * @generated
	 */
	public Adapter createAssociationClassShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ComponentShape <em>Component Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ComponentShape
	 * @generated
	 */
	public Adapter createComponentShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.InformationItemShape <em>Information Item Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.InformationItemShape
	 * @generated
	 */
	public Adapter createInformationItemShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.RepresentationEdge <em>Representation Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.RepresentationEdge
	 * @generated
	 */
	public Adapter createRepresentationEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.AssociationShape <em>Association Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.AssociationShape
	 * @generated
	 */
	public Adapter createAssociationShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.DependencyShape <em>Dependency Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.DependencyShape
	 * @generated
	 */
	public Adapter createDependencyShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.TimeObservationShape <em>Time Observation Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.TimeObservationShape
	 * @generated
	 */
	public Adapter createTimeObservationShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.DurationObservationShape <em>Duration Observation Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.DurationObservationShape
	 * @generated
	 */
	public Adapter createDurationObservationShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.PackageDiagram <em>Package Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.PackageDiagram
	 * @generated
	 */
	public Adapter createPackageDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ProfileDiagram <em>Profile Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ProfileDiagram
	 * @generated
	 */
	public Adapter createProfileDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.CompositeStructureDiagram <em>Composite Structure Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.CompositeStructureDiagram
	 * @generated
	 */
	public Adapter createCompositeStructureDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.DeploymentDiagram <em>Deployment Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.DeploymentDiagram
	 * @generated
	 */
	public Adapter createDeploymentDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ComponentDiagram <em>Component Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ComponentDiagram
	 * @generated
	 */
	public Adapter createComponentDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ObjectDiagram <em>Object Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ObjectDiagram
	 * @generated
	 */
	public Adapter createObjectDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ProfileShape <em>Profile Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ProfileShape
	 * @generated
	 */
	public Adapter createProfileShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ProfileApplicationEdge <em>Profile Application Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ProfileApplicationEdge
	 * @generated
	 */
	public Adapter createProfileApplicationEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ExtensionEdge <em>Extension Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ExtensionEdge
	 * @generated
	 */
	public Adapter createExtensionEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.BehaviorDiagram <em>Behavior Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.BehaviorDiagram
	 * @generated
	 */
	public Adapter createBehaviorDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.UseCaseDiagram <em>Use Case Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.UseCaseDiagram
	 * @generated
	 */
	public Adapter createUseCaseDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ArtifactShape <em>Artifact Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ArtifactShape
	 * @generated
	 */
	public Adapter createArtifactShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.NestedArtifactCompartment <em>Nested Artifact Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.NestedArtifactCompartment
	 * @generated
	 */
	public Adapter createNestedArtifactCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ComponentRealizationEdge <em>Component Realization Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ComponentRealizationEdge
	 * @generated
	 */
	public Adapter createComponentRealizationEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ManifestationEdge <em>Manifestation Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ManifestationEdge
	 * @generated
	 */
	public Adapter createManifestationEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.PropertyShape <em>Property Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.PropertyShape
	 * @generated
	 */
	public Adapter createPropertyShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.CollaborationShape <em>Collaboration Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.CollaborationShape
	 * @generated
	 */
	public Adapter createCollaborationShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.CollaborationUseShape <em>Collaboration Use Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.CollaborationUseShape
	 * @generated
	 */
	public Adapter createCollaborationUseShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.TemplateBindingEdge <em>Template Binding Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.TemplateBindingEdge
	 * @generated
	 */
	public Adapter createTemplateBindingEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.StereotypeShape <em>Stereotype Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.StereotypeShape
	 * @generated
	 */
	public Adapter createStereotypeShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.NodeShape <em>Node Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.NodeShape
	 * @generated
	 */
	public Adapter createNodeShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.NestedNodeCompartment <em>Nested Node Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.NestedNodeCompartment
	 * @generated
	 */
	public Adapter createNestedNodeCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.DeviceShape <em>Device Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.DeviceShape
	 * @generated
	 */
	public Adapter createDeviceShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ExecutionEnvironmentShape <em>Execution Environment Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ExecutionEnvironmentShape
	 * @generated
	 */
	public Adapter createExecutionEnvironmentShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ActivityShape <em>Activity Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ActivityShape
	 * @generated
	 */
	public Adapter createActivityShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ParameterCompartment <em>Parameter Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ParameterCompartment
	 * @generated
	 */
	public Adapter createParameterCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.PostConditionCompartment <em>Post Condition Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.PostConditionCompartment
	 * @generated
	 */
	public Adapter createPostConditionCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.PreConditionCompartment <em>Pre Condition Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.PreConditionCompartment
	 * @generated
	 */
	public Adapter createPreConditionCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ContentCompartment <em>Content Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ContentCompartment
	 * @generated
	 */
	public Adapter createContentCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.StructuredActivityNodeShape <em>Structured Activity Node Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.StructuredActivityNodeShape
	 * @generated
	 */
	public Adapter createStructuredActivityNodeShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ActivityParameterNodeShape <em>Activity Parameter Node Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ActivityParameterNodeShape
	 * @generated
	 */
	public Adapter createActivityParameterNodeShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.InteractionShape <em>Interaction Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.InteractionShape
	 * @generated
	 */
	public Adapter createInteractionShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.OpaqueBehaviorShape <em>Opaque Behavior Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.OpaqueBehaviorShape
	 * @generated
	 */
	public Adapter createOpaqueBehaviorShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.FunctionBehaviorShape <em>Function Behavior Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.FunctionBehaviorShape
	 * @generated
	 */
	public Adapter createFunctionBehaviorShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.StateMachineShape <em>State Machine Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.StateMachineShape
	 * @generated
	 */
	public Adapter createStateMachineShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.BaseStateShape <em>Base State Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.BaseStateShape
	 * @generated
	 */
	public Adapter createBaseStateShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.PseudostateShape <em>Pseudostate Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.PseudostateShape
	 * @generated
	 */
	public Adapter createPseudostateShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.RegionCompartment <em>Region Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.RegionCompartment
	 * @generated
	 */
	public Adapter createRegionCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ProtocolStateMachineShape <em>Protocol State Machine Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ProtocolStateMachineShape
	 * @generated
	 */
	public Adapter createProtocolStateMachineShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.DeploymentSpecificationShape <em>Deployment Specification Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.DeploymentSpecificationShape
	 * @generated
	 */
	public Adapter createDeploymentSpecificationShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.CommunicationPathEdge <em>Communication Path Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.CommunicationPathEdge
	 * @generated
	 */
	public Adapter createCommunicationPathEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.DeploymentEdge <em>Deployment Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.DeploymentEdge
	 * @generated
	 */
	public Adapter createDeploymentEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ActorShape <em>Actor Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ActorShape
	 * @generated
	 */
	public Adapter createActorShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ExtensionPointCompartment <em>Extension Point Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ExtensionPointCompartment
	 * @generated
	 */
	public Adapter createExtensionPointCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.UseCaseShape <em>Use Case Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.UseCaseShape
	 * @generated
	 */
	public Adapter createUseCaseShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.IncludeEdge <em>Include Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.IncludeEdge
	 * @generated
	 */
	public Adapter createIncludeEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ExtendEdge <em>Extend Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ExtendEdge
	 * @generated
	 */
	public Adapter createExtendEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.StateMachineDiagram <em>State Machine Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.StateMachineDiagram
	 * @generated
	 */
	public Adapter createStateMachineDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ActivityDiagram <em>Activity Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ActivityDiagram
	 * @generated
	 */
	public Adapter createActivityDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.SequenceDiagram <em>Sequence Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.SequenceDiagram
	 * @generated
	 */
	public Adapter createSequenceDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.InteractionDiagram <em>Interaction Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.InteractionDiagram
	 * @generated
	 */
	public Adapter createInteractionDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.CommunicationDiagram <em>Communication Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.CommunicationDiagram
	 * @generated
	 */
	public Adapter createCommunicationDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.TimingDiagram <em>Timing Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.TimingDiagram
	 * @generated
	 */
	public Adapter createTimingDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.InteractionOverviewDiagram <em>Interaction Overview Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.InteractionOverviewDiagram
	 * @generated
	 */
	public Adapter createInteractionOverviewDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.InternalBehaviorCompartment <em>Internal Behavior Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.InternalBehaviorCompartment
	 * @generated
	 */
	public Adapter createInternalBehaviorCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.StateShape <em>State Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.StateShape
	 * @generated
	 */
	public Adapter createStateShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ConnectionPointReferenceShape <em>Connection Point Reference Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ConnectionPointReferenceShape
	 * @generated
	 */
	public Adapter createConnectionPointReferenceShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.InternalTransitionCompartment <em>Internal Transition Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.InternalTransitionCompartment
	 * @generated
	 */
	public Adapter createInternalTransitionCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.DeferrableTriggerCompartment <em>Deferrable Trigger Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.DeferrableTriggerCompartment
	 * @generated
	 */
	public Adapter createDeferrableTriggerCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.RegionShape <em>Region Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.RegionShape
	 * @generated
	 */
	public Adapter createRegionShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.TransitionEdge <em>Transition Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.TransitionEdge
	 * @generated
	 */
	public Adapter createTransitionEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ActivityEdgeEdge <em>Activity Edge Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ActivityEdgeEdge
	 * @generated
	 */
	public Adapter createActivityEdgeEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.WeightLabel <em>Weight Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.WeightLabel
	 * @generated
	 */
	public Adapter createWeightLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ControlFlowEdge <em>Control Flow Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ControlFlowEdge
	 * @generated
	 */
	public Adapter createControlFlowEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ObjectFlowEdge <em>Object Flow Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ObjectFlowEdge
	 * @generated
	 */
	public Adapter createObjectFlowEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ActivityGroupShape <em>Activity Group Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ActivityGroupShape
	 * @generated
	 */
	public Adapter createActivityGroupShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ExceptionHandlerEdge <em>Exception Handler Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ExceptionHandlerEdge
	 * @generated
	 */
	public Adapter createExceptionHandlerEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.TypeLabel <em>Type Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.TypeLabel
	 * @generated
	 */
	public Adapter createTypeLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.IconLabel <em>Icon Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.IconLabel
	 * @generated
	 */
	public Adapter createIconLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.SubPartitionCompartment <em>Sub Partition Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.SubPartitionCompartment
	 * @generated
	 */
	public Adapter createSubPartitionCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ActivityPartitionShape <em>Activity Partition Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ActivityPartitionShape
	 * @generated
	 */
	public Adapter createActivityPartitionShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ExpansionRegionShape <em>Expansion Region Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ExpansionRegionShape
	 * @generated
	 */
	public Adapter createExpansionRegionShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ExpansionNodeShape <em>Expansion Node Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ExpansionNodeShape
	 * @generated
	 */
	public Adapter createExpansionNodeShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ActionShape <em>Action Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ActionShape
	 * @generated
	 */
	public Adapter createActionShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.PinShape <em>Pin Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.PinShape
	 * @generated
	 */
	public Adapter createPinShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ObjectNodeShape <em>Object Node Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ObjectNodeShape
	 * @generated
	 */
	public Adapter createObjectNodeShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.SelectionLabel <em>Selection Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.SelectionLabel
	 * @generated
	 */
	public Adapter createSelectionLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.TransformationLabel <em>Transformation Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.TransformationLabel
	 * @generated
	 */
	public Adapter createTransformationLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.GuardLabel <em>Guard Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.GuardLabel
	 * @generated
	 */
	public Adapter createGuardLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ActivityNodeShape <em>Activity Node Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ActivityNodeShape
	 * @generated
	 */
	public Adapter createActivityNodeShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.SubvertexCompartment <em>Subvertex Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.SubvertexCompartment
	 * @generated
	 */
	public Adapter createSubvertexCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.RelationshipWithGuardEdge <em>Relationship With Guard Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.RelationshipWithGuardEdge
	 * @generated
	 */
	public Adapter createRelationshipWithGuardEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.TemplateParameterCompartment <em>Template Parameter Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.TemplateParameterCompartment
	 * @generated
	 */
	public Adapter createTemplateParameterCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ListCompartment <em>List Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ListCompartment
	 * @generated
	 */
	public Adapter createListCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.ListItemLabel <em>List Item Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.ListItemLabel
	 * @generated
	 */
	public Adapter createListItemLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.OwnedUseCaseCompartment <em>Owned Use Case Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.OwnedUseCaseCompartment
	 * @generated
	 */
	public Adapter createOwnedUseCaseCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.UseCaseCompartment <em>Use Case Compartment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.UseCaseCompartment
	 * @generated
	 */
	public Adapter createUseCaseCompartmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.UmlShape <em>Uml Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.UmlShape
	 * @generated
	 */
	public Adapter createUmlShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.umldi.MainLabel <em>Main Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.umldi.MainLabel
	 * @generated
	 */
	public Adapter createMainLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.dd.di.DiagramElement <em>Diagram Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.dd.di.DiagramElement
	 * @generated
	 */
	public Adapter createDiagramElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.dd.di.Shape <em>Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.dd.di.Shape
	 * @generated
	 */
	public Adapter createShapeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.dd.di.Diagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.dd.di.Diagram
	 * @generated
	 */
	public Adapter createDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.dd.di.Style <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.dd.di.Style
	 * @generated
	 */
	public Adapter createStyleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.dd.di.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.dd.di.Edge
	 * @generated
	 */
	public Adapter createEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}
} //UMLDIAdapterFactory
