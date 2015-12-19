/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.bpmn.BPMNProfile.AdHocOrdering;
import org.eclipse.papyrus.bpmn.BPMNProfile.AdHocSubProcess;
import org.eclipse.papyrus.bpmn.BPMNProfile.Assignment;
import org.eclipse.papyrus.bpmn.BPMNProfile.AssociationDirection;
import org.eclipse.papyrus.bpmn.BPMNProfile.Auditing;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNExpression;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNExtension;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNInterface;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNMessage;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfileFactory;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProperty;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNRelationship;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNSignal;
import org.eclipse.papyrus.bpmn.BPMNProfile.BoundaryEvent;
import org.eclipse.papyrus.bpmn.BPMNProfile.BusinessRuleTask;
import org.eclipse.papyrus.bpmn.BPMNProfile.CallActivity;
import org.eclipse.papyrus.bpmn.BPMNProfile.CallConversation;
import org.eclipse.papyrus.bpmn.BPMNProfile.CancelEventDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.Category;
import org.eclipse.papyrus.bpmn.BPMNProfile.CategoryValue;
import org.eclipse.papyrus.bpmn.BPMNProfile.CompensateEventDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.ComplexBehaviorDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.ComplexGateway;
import org.eclipse.papyrus.bpmn.BPMNProfile.ConditionalEventDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.Conversation;
import org.eclipse.papyrus.bpmn.BPMNProfile.ConversationLink;
import org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationKey;
import org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationProperty;
import org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyBinding;
import org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyRetrievalExpression;
import org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationSubscription;
import org.eclipse.papyrus.bpmn.BPMNProfile.DataInput;
import org.eclipse.papyrus.bpmn.BPMNProfile.DataInputAssociation;
import org.eclipse.papyrus.bpmn.BPMNProfile.DataObject;
import org.eclipse.papyrus.bpmn.BPMNProfile.DataObjectReference;
import org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput;
import org.eclipse.papyrus.bpmn.BPMNProfile.DataOutputAssociation;
import org.eclipse.papyrus.bpmn.BPMNProfile.DataState;
import org.eclipse.papyrus.bpmn.BPMNProfile.DataStore;
import org.eclipse.papyrus.bpmn.BPMNProfile.DataStoreReference;
import org.eclipse.papyrus.bpmn.BPMNProfile.Definitions;
import org.eclipse.papyrus.bpmn.BPMNProfile.Documentation;
import org.eclipse.papyrus.bpmn.BPMNProfile.EndEvent;
import org.eclipse.papyrus.bpmn.BPMNProfile.ErrorEventDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.Escalation;
import org.eclipse.papyrus.bpmn.BPMNProfile.EscalationEventDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGateway;
import org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGatewayType;
import org.eclipse.papyrus.bpmn.BPMNProfile.ExclusiveGateway;
import org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeValue;
import org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.FormalExpression;
import org.eclipse.papyrus.bpmn.BPMNProfile.GatewayDirection;
import org.eclipse.papyrus.bpmn.BPMNProfile.GlobalBusinessRuleTask;
import org.eclipse.papyrus.bpmn.BPMNProfile.GlobalConversation;
import org.eclipse.papyrus.bpmn.BPMNProfile.GlobalManualTask;
import org.eclipse.papyrus.bpmn.BPMNProfile.GlobalScriptTask;
import org.eclipse.papyrus.bpmn.BPMNProfile.GlobalTask;
import org.eclipse.papyrus.bpmn.BPMNProfile.GlobalUserTask;
import org.eclipse.papyrus.bpmn.BPMNProfile.Group;
import org.eclipse.papyrus.bpmn.BPMNProfile.HumanPerformer;
import org.eclipse.papyrus.bpmn.BPMNProfile.ImplicitThrowEvent;
import org.eclipse.papyrus.bpmn.BPMNProfile.Import;
import org.eclipse.papyrus.bpmn.BPMNProfile.InclusiveGateway;
import org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputBinding;
import org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification;
import org.eclipse.papyrus.bpmn.BPMNProfile.InputSet;
import org.eclipse.papyrus.bpmn.BPMNProfile.IntermediateCatchEvent;
import org.eclipse.papyrus.bpmn.BPMNProfile.IntermediateThrowEvent;
import org.eclipse.papyrus.bpmn.BPMNProfile.ItemDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.ItemKind;
import org.eclipse.papyrus.bpmn.BPMNProfile.Lane;
import org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet;
import org.eclipse.papyrus.bpmn.BPMNProfile.LinkEventDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.ManualTask;
import org.eclipse.papyrus.bpmn.BPMNProfile.MessageEventDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow;
import org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlowAssociation;
import org.eclipse.papyrus.bpmn.BPMNProfile.Monitoring;
import org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceBehavior;
import org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics;
import org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet;
import org.eclipse.papyrus.bpmn.BPMNProfile.ParallelGateway;
import org.eclipse.papyrus.bpmn.BPMNProfile.Participant;
import org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantAssociation;
import org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantMultiplicity;
import org.eclipse.papyrus.bpmn.BPMNProfile.PartnerEntity;
import org.eclipse.papyrus.bpmn.BPMNProfile.PartnerRole;
import org.eclipse.papyrus.bpmn.BPMNProfile.Performer;
import org.eclipse.papyrus.bpmn.BPMNProfile.PotentialOwner;
import org.eclipse.papyrus.bpmn.BPMNProfile.ProcessType;
import org.eclipse.papyrus.bpmn.BPMNProfile.ReceiveTask;
import org.eclipse.papyrus.bpmn.BPMNProfile.RelationshipDirection;
import org.eclipse.papyrus.bpmn.BPMNProfile.Rendering;
import org.eclipse.papyrus.bpmn.BPMNProfile.Resource;
import org.eclipse.papyrus.bpmn.BPMNProfile.ResourceAssignmentExpression;
import org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameter;
import org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameterBinding;
import org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole;
import org.eclipse.papyrus.bpmn.BPMNProfile.ScriptTask;
import org.eclipse.papyrus.bpmn.BPMNProfile.SendTask;
import org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow;
import org.eclipse.papyrus.bpmn.BPMNProfile.ServiceTask;
import org.eclipse.papyrus.bpmn.BPMNProfile.SignalEventDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics;
import org.eclipse.papyrus.bpmn.BPMNProfile.StartEvent;
import org.eclipse.papyrus.bpmn.BPMNProfile.SubConversation;
import org.eclipse.papyrus.bpmn.BPMNProfile.SubProcess;
import org.eclipse.papyrus.bpmn.BPMNProfile.Task;
import org.eclipse.papyrus.bpmn.BPMNProfile.TerminateEventDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.TextAnnotation;
import org.eclipse.papyrus.bpmn.BPMNProfile.TimerEventDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.Transaction;
import org.eclipse.papyrus.bpmn.BPMNProfile.UserTask;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BPMNProfileFactoryImpl extends EFactoryImpl implements BPMNProfileFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BPMNProfileFactory init() {
		try {
			BPMNProfileFactory theBPMNProfileFactory = (BPMNProfileFactory)EPackage.Registry.INSTANCE.getEFactory(BPMNProfilePackage.eNS_URI);
			if (theBPMNProfileFactory != null) {
				return theBPMNProfileFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BPMNProfileFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNProfileFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case BPMNProfilePackage.INCLUSIVE_GATEWAY: return createInclusiveGateway();
			case BPMNProfilePackage.EXTENSION_ATTRIBUTE_VALUE: return createExtensionAttributeValue();
			case BPMNProfilePackage.EXTENSION_ATTRIBUTE_DEFINITION: return createExtensionAttributeDefinition();
			case BPMNProfilePackage.DOCUMENTATION: return createDocumentation();
			case BPMNProfilePackage.EXTENSION_DEFINITION: return createExtensionDefinition();
			case BPMNProfilePackage.BPMN_ASSOCIATION: return createBPMNAssociation();
			case BPMNProfilePackage.AUDITING: return createAuditing();
			case BPMNProfilePackage.MONITORING: return createMonitoring();
			case BPMNProfilePackage.CATEGORY_VALUE: return createCategoryValue();
			case BPMNProfilePackage.LANE_SET: return createLaneSet();
			case BPMNProfilePackage.LANE: return createLane();
			case BPMNProfilePackage.SEQUENCE_FLOW: return createSequenceFlow();
			case BPMNProfilePackage.BPMN_EXPRESSION: return createBPMNExpression();
			case BPMNProfilePackage.EVENT_BASED_GATEWAY: return createEventBasedGateway();
			case BPMNProfilePackage.PARALLEL_GATEWAY: return createParallelGateway();
			case BPMNProfilePackage.COMPLEX_GATEWAY: return createComplexGateway();
			case BPMNProfilePackage.EXCLUSIVE_GATEWAY: return createExclusiveGateway();
			case BPMNProfilePackage.DEFINITIONS: return createDefinitions();
			case BPMNProfilePackage.BPMN_EXTENSION: return createBPMNExtension();
			case BPMNProfilePackage.IMPORT: return createImport();
			case BPMNProfilePackage.BPMN_RELATIONSHIP: return createBPMNRelationship();
			case BPMNProfilePackage.BPMN_PROCESS: return createBPMNProcess();
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION: return createInputOutputSpecification();
			case BPMNProfilePackage.DATA_INPUT: return createDataInput();
			case BPMNProfilePackage.DATA_STATE: return createDataState();
			case BPMNProfilePackage.ITEM_DEFINITION: return createItemDefinition();
			case BPMNProfilePackage.INPUT_SET: return createInputSet();
			case BPMNProfilePackage.DATA_OUTPUT: return createDataOutput();
			case BPMNProfilePackage.OUTPUT_SET: return createOutputSet();
			case BPMNProfilePackage.BPMN_INTERFACE: return createBPMNInterface();
			case BPMNProfilePackage.BPMN_OPERATION: return createBPMNOperation();
			case BPMNProfilePackage.BPMN_MESSAGE: return createBPMNMessage();
			case BPMNProfilePackage.ERROR: return createError();
			case BPMNProfilePackage.INPUT_OUTPUT_BINDING: return createInputOutputBinding();
			case BPMNProfilePackage.BPMN_COLLABORATION: return createBPMNCollaboration();
			case BPMNProfilePackage.PARTICIPANT_ASSOCIATION: return createParticipantAssociation();
			case BPMNProfilePackage.PARTICIPANT: return createParticipant();
			case BPMNProfilePackage.CONVERSATION_LINK: return createConversationLink();
			case BPMNProfilePackage.PARTICIPANT_MULTIPLICITY: return createParticipantMultiplicity();
			case BPMNProfilePackage.PARTNER_ENTITY: return createPartnerEntity();
			case BPMNProfilePackage.PARTNER_ROLE: return createPartnerRole();
			case BPMNProfilePackage.MESSAGE_FLOW_ASSOCIATION: return createMessageFlowAssociation();
			case BPMNProfilePackage.MESSAGE_FLOW: return createMessageFlow();
			case BPMNProfilePackage.CORRELATION_KEY: return createCorrelationKey();
			case BPMNProfilePackage.CORRELATION_PROPERTY: return createCorrelationProperty();
			case BPMNProfilePackage.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION: return createCorrelationPropertyRetrievalExpression();
			case BPMNProfilePackage.FORMAL_EXPRESSION: return createFormalExpression();
			case BPMNProfilePackage.CORRELATION_SUBSCRIPTION: return createCorrelationSubscription();
			case BPMNProfilePackage.CORRELATION_PROPERTY_BINDING: return createCorrelationPropertyBinding();
			case BPMNProfilePackage.BPMN_PROPERTY: return createBPMNProperty();
			case BPMNProfilePackage.RESOURCE_ROLE: return createResourceRole();
			case BPMNProfilePackage.RESOURCE_ASSIGNMENT_EXPRESSION: return createResourceAssignmentExpression();
			case BPMNProfilePackage.RESOURCE: return createResource();
			case BPMNProfilePackage.RESOURCE_PARAMETER: return createResourceParameter();
			case BPMNProfilePackage.RESOURCE_PARAMETER_BINDING: return createResourceParameterBinding();
			case BPMNProfilePackage.GLOBAL_SCRIPT_TASK: return createGlobalScriptTask();
			case BPMNProfilePackage.GLOBAL_TASK: return createGlobalTask();
			case BPMNProfilePackage.GLOBAL_BUSINESS_RULE_TASK: return createGlobalBusinessRuleTask();
			case BPMNProfilePackage.COMPENSATE_EVENT_DEFINITION: return createCompensateEventDefinition();
			case BPMNProfilePackage.BOUNDARY_EVENT: return createBoundaryEvent();
			case BPMNProfilePackage.DATA_OUTPUT_ASSOCIATION: return createDataOutputAssociation();
			case BPMNProfilePackage.ASSIGNMENT: return createAssignment();
			case BPMNProfilePackage.DATA_INPUT_ASSOCIATION: return createDataInputAssociation();
			case BPMNProfilePackage.ESCALATION_EVENT_DEFINITION: return createEscalationEventDefinition();
			case BPMNProfilePackage.ESCALATION: return createEscalation();
			case BPMNProfilePackage.TIMER_EVENT_DEFINITION: return createTimerEventDefinition();
			case BPMNProfilePackage.SIGNAL_EVENT_DEFINITION: return createSignalEventDefinition();
			case BPMNProfilePackage.BPMN_SIGNAL: return createBPMNSignal();
			case BPMNProfilePackage.END_EVENT: return createEndEvent();
			case BPMNProfilePackage.MESSAGE_EVENT_DEFINITION: return createMessageEventDefinition();
			case BPMNProfilePackage.START_EVENT: return createStartEvent();
			case BPMNProfilePackage.CONDITIONAL_EVENT_DEFINITION: return createConditionalEventDefinition();
			case BPMNProfilePackage.LINK_EVENT_DEFINITION: return createLinkEventDefinition();
			case BPMNProfilePackage.ERROR_EVENT_DEFINITION: return createErrorEventDefinition();
			case BPMNProfilePackage.INTERMEDIATE_CATCH_EVENT: return createIntermediateCatchEvent();
			case BPMNProfilePackage.INTERMEDIATE_THROW_EVENT: return createIntermediateThrowEvent();
			case BPMNProfilePackage.TERMINATE_EVENT_DEFINITION: return createTerminateEventDefinition();
			case BPMNProfilePackage.IMPLICIT_THROW_EVENT: return createImplicitThrowEvent();
			case BPMNProfilePackage.CANCEL_EVENT_DEFINITION: return createCancelEventDefinition();
			case BPMNProfilePackage.TEXT_ANNOTATION: return createTextAnnotation();
			case BPMNProfilePackage.CATEGORY: return createCategory();
			case BPMNProfilePackage.GROUP: return createGroup();
			case BPMNProfilePackage.DATA_OBJECT_REFERENCE: return createDataObjectReference();
			case BPMNProfilePackage.DATA_OBJECT: return createDataObject();
			case BPMNProfilePackage.DATA_STORE: return createDataStore();
			case BPMNProfilePackage.DATA_STORE_REFERENCE: return createDataStoreReference();
			case BPMNProfilePackage.USER_TASK: return createUserTask();
			case BPMNProfilePackage.TASK: return createTask();
			case BPMNProfilePackage.RENDERING: return createRendering();
			case BPMNProfilePackage.HUMAN_PERFORMER: return createHumanPerformer();
			case BPMNProfilePackage.PERFORMER: return createPerformer();
			case BPMNProfilePackage.GLOBAL_USER_TASK: return createGlobalUserTask();
			case BPMNProfilePackage.GLOBAL_MANUAL_TASK: return createGlobalManualTask();
			case BPMNProfilePackage.MANUAL_TASK: return createManualTask();
			case BPMNProfilePackage.POTENTIAL_OWNER: return createPotentialOwner();
			case BPMNProfilePackage.SUB_CONVERSATION: return createSubConversation();
			case BPMNProfilePackage.GLOBAL_CONVERSATION: return createGlobalConversation();
			case BPMNProfilePackage.CALL_CONVERSATION: return createCallConversation();
			case BPMNProfilePackage.CONVERSATION: return createConversation();
			case BPMNProfilePackage.SUB_PROCESS: return createSubProcess();
			case BPMNProfilePackage.CALL_ACTIVITY: return createCallActivity();
			case BPMNProfilePackage.BUSINESS_RULE_TASK: return createBusinessRuleTask();
			case BPMNProfilePackage.COMPLEX_BEHAVIOR_DEFINITION: return createComplexBehaviorDefinition();
			case BPMNProfilePackage.AD_HOC_SUB_PROCESS: return createAdHocSubProcess();
			case BPMNProfilePackage.SCRIPT_TASK: return createScriptTask();
			case BPMNProfilePackage.SEND_TASK: return createSendTask();
			case BPMNProfilePackage.TRANSACTION: return createTransaction();
			case BPMNProfilePackage.STANDARD_LOOP_CHARACTERISTICS: return createStandardLoopCharacteristics();
			case BPMNProfilePackage.RECEIVE_TASK: return createReceiveTask();
			case BPMNProfilePackage.SERVICE_TASK: return createServiceTask();
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS: return createMultiInstanceLoopCharacteristics();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case BPMNProfilePackage.ASSOCIATION_DIRECTION:
				return createAssociationDirectionFromString(eDataType, initialValue);
			case BPMNProfilePackage.EVENT_BASED_GATEWAY_TYPE:
				return createEventBasedGatewayTypeFromString(eDataType, initialValue);
			case BPMNProfilePackage.GATEWAY_DIRECTION:
				return createGatewayDirectionFromString(eDataType, initialValue);
			case BPMNProfilePackage.RELATIONSHIP_DIRECTION:
				return createRelationshipDirectionFromString(eDataType, initialValue);
			case BPMNProfilePackage.ITEM_KIND:
				return createItemKindFromString(eDataType, initialValue);
			case BPMNProfilePackage.PROCESS_TYPE:
				return createProcessTypeFromString(eDataType, initialValue);
			case BPMNProfilePackage.AD_HOC_ORDERING:
				return createAdHocOrderingFromString(eDataType, initialValue);
			case BPMNProfilePackage.MULTI_INSTANCE_BEHAVIOR:
				return createMultiInstanceBehaviorFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case BPMNProfilePackage.ASSOCIATION_DIRECTION:
				return convertAssociationDirectionToString(eDataType, instanceValue);
			case BPMNProfilePackage.EVENT_BASED_GATEWAY_TYPE:
				return convertEventBasedGatewayTypeToString(eDataType, instanceValue);
			case BPMNProfilePackage.GATEWAY_DIRECTION:
				return convertGatewayDirectionToString(eDataType, instanceValue);
			case BPMNProfilePackage.RELATIONSHIP_DIRECTION:
				return convertRelationshipDirectionToString(eDataType, instanceValue);
			case BPMNProfilePackage.ITEM_KIND:
				return convertItemKindToString(eDataType, instanceValue);
			case BPMNProfilePackage.PROCESS_TYPE:
				return convertProcessTypeToString(eDataType, instanceValue);
			case BPMNProfilePackage.AD_HOC_ORDERING:
				return convertAdHocOrderingToString(eDataType, instanceValue);
			case BPMNProfilePackage.MULTI_INSTANCE_BEHAVIOR:
				return convertMultiInstanceBehaviorToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InclusiveGateway createInclusiveGateway() {
		InclusiveGatewayImpl inclusiveGateway = new InclusiveGatewayImpl();
		return inclusiveGateway;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionAttributeValue createExtensionAttributeValue() {
		ExtensionAttributeValueImpl extensionAttributeValue = new ExtensionAttributeValueImpl();
		return extensionAttributeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionAttributeDefinition createExtensionAttributeDefinition() {
		ExtensionAttributeDefinitionImpl extensionAttributeDefinition = new ExtensionAttributeDefinitionImpl();
		return extensionAttributeDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Documentation createDocumentation() {
		DocumentationImpl documentation = new DocumentationImpl();
		return documentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionDefinition createExtensionDefinition() {
		ExtensionDefinitionImpl extensionDefinition = new ExtensionDefinitionImpl();
		return extensionDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNAssociation createBPMNAssociation() {
		BPMNAssociationImpl bpmnAssociation = new BPMNAssociationImpl();
		return bpmnAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Auditing createAuditing() {
		AuditingImpl auditing = new AuditingImpl();
		return auditing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Monitoring createMonitoring() {
		MonitoringImpl monitoring = new MonitoringImpl();
		return monitoring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CategoryValue createCategoryValue() {
		CategoryValueImpl categoryValue = new CategoryValueImpl();
		return categoryValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LaneSet createLaneSet() {
		LaneSetImpl laneSet = new LaneSetImpl();
		return laneSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lane createLane() {
		LaneImpl lane = new LaneImpl();
		return lane;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceFlow createSequenceFlow() {
		SequenceFlowImpl sequenceFlow = new SequenceFlowImpl();
		return sequenceFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNExpression createBPMNExpression() {
		BPMNExpressionImpl bpmnExpression = new BPMNExpressionImpl();
		return bpmnExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventBasedGateway createEventBasedGateway() {
		EventBasedGatewayImpl eventBasedGateway = new EventBasedGatewayImpl();
		return eventBasedGateway;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParallelGateway createParallelGateway() {
		ParallelGatewayImpl parallelGateway = new ParallelGatewayImpl();
		return parallelGateway;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexGateway createComplexGateway() {
		ComplexGatewayImpl complexGateway = new ComplexGatewayImpl();
		return complexGateway;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExclusiveGateway createExclusiveGateway() {
		ExclusiveGatewayImpl exclusiveGateway = new ExclusiveGatewayImpl();
		return exclusiveGateway;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Definitions createDefinitions() {
		DefinitionsImpl definitions = new DefinitionsImpl();
		return definitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNExtension createBPMNExtension() {
		BPMNExtensionImpl bpmnExtension = new BPMNExtensionImpl();
		return bpmnExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Import createImport() {
		ImportImpl import_ = new ImportImpl();
		return import_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNRelationship createBPMNRelationship() {
		BPMNRelationshipImpl bpmnRelationship = new BPMNRelationshipImpl();
		return bpmnRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNProcess createBPMNProcess() {
		BPMNProcessImpl bpmnProcess = new BPMNProcessImpl();
		return bpmnProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputOutputSpecification createInputOutputSpecification() {
		InputOutputSpecificationImpl inputOutputSpecification = new InputOutputSpecificationImpl();
		return inputOutputSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataInput createDataInput() {
		DataInputImpl dataInput = new DataInputImpl();
		return dataInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataState createDataState() {
		DataStateImpl dataState = new DataStateImpl();
		return dataState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemDefinition createItemDefinition() {
		ItemDefinitionImpl itemDefinition = new ItemDefinitionImpl();
		return itemDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputSet createInputSet() {
		InputSetImpl inputSet = new InputSetImpl();
		return inputSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataOutput createDataOutput() {
		DataOutputImpl dataOutput = new DataOutputImpl();
		return dataOutput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputSet createOutputSet() {
		OutputSetImpl outputSet = new OutputSetImpl();
		return outputSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNInterface createBPMNInterface() {
		BPMNInterfaceImpl bpmnInterface = new BPMNInterfaceImpl();
		return bpmnInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNOperation createBPMNOperation() {
		BPMNOperationImpl bpmnOperation = new BPMNOperationImpl();
		return bpmnOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNMessage createBPMNMessage() {
		BPMNMessageImpl bpmnMessage = new BPMNMessageImpl();
		return bpmnMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.papyrus.bpmn.BPMNProfile.Error createError() {
		ErrorImpl error = new ErrorImpl();
		return error;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputOutputBinding createInputOutputBinding() {
		InputOutputBindingImpl inputOutputBinding = new InputOutputBindingImpl();
		return inputOutputBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNCollaboration createBPMNCollaboration() {
		BPMNCollaborationImpl bpmnCollaboration = new BPMNCollaborationImpl();
		return bpmnCollaboration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParticipantAssociation createParticipantAssociation() {
		ParticipantAssociationImpl participantAssociation = new ParticipantAssociationImpl();
		return participantAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Participant createParticipant() {
		ParticipantImpl participant = new ParticipantImpl();
		return participant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConversationLink createConversationLink() {
		ConversationLinkImpl conversationLink = new ConversationLinkImpl();
		return conversationLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParticipantMultiplicity createParticipantMultiplicity() {
		ParticipantMultiplicityImpl participantMultiplicity = new ParticipantMultiplicityImpl();
		return participantMultiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartnerEntity createPartnerEntity() {
		PartnerEntityImpl partnerEntity = new PartnerEntityImpl();
		return partnerEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartnerRole createPartnerRole() {
		PartnerRoleImpl partnerRole = new PartnerRoleImpl();
		return partnerRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageFlowAssociation createMessageFlowAssociation() {
		MessageFlowAssociationImpl messageFlowAssociation = new MessageFlowAssociationImpl();
		return messageFlowAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageFlow createMessageFlow() {
		MessageFlowImpl messageFlow = new MessageFlowImpl();
		return messageFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorrelationKey createCorrelationKey() {
		CorrelationKeyImpl correlationKey = new CorrelationKeyImpl();
		return correlationKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorrelationProperty createCorrelationProperty() {
		CorrelationPropertyImpl correlationProperty = new CorrelationPropertyImpl();
		return correlationProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorrelationPropertyRetrievalExpression createCorrelationPropertyRetrievalExpression() {
		CorrelationPropertyRetrievalExpressionImpl correlationPropertyRetrievalExpression = new CorrelationPropertyRetrievalExpressionImpl();
		return correlationPropertyRetrievalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormalExpression createFormalExpression() {
		FormalExpressionImpl formalExpression = new FormalExpressionImpl();
		return formalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorrelationSubscription createCorrelationSubscription() {
		CorrelationSubscriptionImpl correlationSubscription = new CorrelationSubscriptionImpl();
		return correlationSubscription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorrelationPropertyBinding createCorrelationPropertyBinding() {
		CorrelationPropertyBindingImpl correlationPropertyBinding = new CorrelationPropertyBindingImpl();
		return correlationPropertyBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNProperty createBPMNProperty() {
		BPMNPropertyImpl bpmnProperty = new BPMNPropertyImpl();
		return bpmnProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRole createResourceRole() {
		ResourceRoleImpl resourceRole = new ResourceRoleImpl();
		return resourceRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceAssignmentExpression createResourceAssignmentExpression() {
		ResourceAssignmentExpressionImpl resourceAssignmentExpression = new ResourceAssignmentExpressionImpl();
		return resourceAssignmentExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource createResource() {
		ResourceImpl resource = new ResourceImpl();
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceParameter createResourceParameter() {
		ResourceParameterImpl resourceParameter = new ResourceParameterImpl();
		return resourceParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceParameterBinding createResourceParameterBinding() {
		ResourceParameterBindingImpl resourceParameterBinding = new ResourceParameterBindingImpl();
		return resourceParameterBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalScriptTask createGlobalScriptTask() {
		GlobalScriptTaskImpl globalScriptTask = new GlobalScriptTaskImpl();
		return globalScriptTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalTask createGlobalTask() {
		GlobalTaskImpl globalTask = new GlobalTaskImpl();
		return globalTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalBusinessRuleTask createGlobalBusinessRuleTask() {
		GlobalBusinessRuleTaskImpl globalBusinessRuleTask = new GlobalBusinessRuleTaskImpl();
		return globalBusinessRuleTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompensateEventDefinition createCompensateEventDefinition() {
		CompensateEventDefinitionImpl compensateEventDefinition = new CompensateEventDefinitionImpl();
		return compensateEventDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundaryEvent createBoundaryEvent() {
		BoundaryEventImpl boundaryEvent = new BoundaryEventImpl();
		return boundaryEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataOutputAssociation createDataOutputAssociation() {
		DataOutputAssociationImpl dataOutputAssociation = new DataOutputAssociationImpl();
		return dataOutputAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assignment createAssignment() {
		AssignmentImpl assignment = new AssignmentImpl();
		return assignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataInputAssociation createDataInputAssociation() {
		DataInputAssociationImpl dataInputAssociation = new DataInputAssociationImpl();
		return dataInputAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EscalationEventDefinition createEscalationEventDefinition() {
		EscalationEventDefinitionImpl escalationEventDefinition = new EscalationEventDefinitionImpl();
		return escalationEventDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Escalation createEscalation() {
		EscalationImpl escalation = new EscalationImpl();
		return escalation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimerEventDefinition createTimerEventDefinition() {
		TimerEventDefinitionImpl timerEventDefinition = new TimerEventDefinitionImpl();
		return timerEventDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SignalEventDefinition createSignalEventDefinition() {
		SignalEventDefinitionImpl signalEventDefinition = new SignalEventDefinitionImpl();
		return signalEventDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNSignal createBPMNSignal() {
		BPMNSignalImpl bpmnSignal = new BPMNSignalImpl();
		return bpmnSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndEvent createEndEvent() {
		EndEventImpl endEvent = new EndEventImpl();
		return endEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageEventDefinition createMessageEventDefinition() {
		MessageEventDefinitionImpl messageEventDefinition = new MessageEventDefinitionImpl();
		return messageEventDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartEvent createStartEvent() {
		StartEventImpl startEvent = new StartEventImpl();
		return startEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalEventDefinition createConditionalEventDefinition() {
		ConditionalEventDefinitionImpl conditionalEventDefinition = new ConditionalEventDefinitionImpl();
		return conditionalEventDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkEventDefinition createLinkEventDefinition() {
		LinkEventDefinitionImpl linkEventDefinition = new LinkEventDefinitionImpl();
		return linkEventDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorEventDefinition createErrorEventDefinition() {
		ErrorEventDefinitionImpl errorEventDefinition = new ErrorEventDefinitionImpl();
		return errorEventDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateCatchEvent createIntermediateCatchEvent() {
		IntermediateCatchEventImpl intermediateCatchEvent = new IntermediateCatchEventImpl();
		return intermediateCatchEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateThrowEvent createIntermediateThrowEvent() {
		IntermediateThrowEventImpl intermediateThrowEvent = new IntermediateThrowEventImpl();
		return intermediateThrowEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminateEventDefinition createTerminateEventDefinition() {
		TerminateEventDefinitionImpl terminateEventDefinition = new TerminateEventDefinitionImpl();
		return terminateEventDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplicitThrowEvent createImplicitThrowEvent() {
		ImplicitThrowEventImpl implicitThrowEvent = new ImplicitThrowEventImpl();
		return implicitThrowEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CancelEventDefinition createCancelEventDefinition() {
		CancelEventDefinitionImpl cancelEventDefinition = new CancelEventDefinitionImpl();
		return cancelEventDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextAnnotation createTextAnnotation() {
		TextAnnotationImpl textAnnotation = new TextAnnotationImpl();
		return textAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Category createCategory() {
		CategoryImpl category = new CategoryImpl();
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Group createGroup() {
		GroupImpl group = new GroupImpl();
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataObjectReference createDataObjectReference() {
		DataObjectReferenceImpl dataObjectReference = new DataObjectReferenceImpl();
		return dataObjectReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataObject createDataObject() {
		DataObjectImpl dataObject = new DataObjectImpl();
		return dataObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataStore createDataStore() {
		DataStoreImpl dataStore = new DataStoreImpl();
		return dataStore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataStoreReference createDataStoreReference() {
		DataStoreReferenceImpl dataStoreReference = new DataStoreReferenceImpl();
		return dataStoreReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserTask createUserTask() {
		UserTaskImpl userTask = new UserTaskImpl();
		return userTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task createTask() {
		TaskImpl task = new TaskImpl();
		return task;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rendering createRendering() {
		RenderingImpl rendering = new RenderingImpl();
		return rendering;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HumanPerformer createHumanPerformer() {
		HumanPerformerImpl humanPerformer = new HumanPerformerImpl();
		return humanPerformer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Performer createPerformer() {
		PerformerImpl performer = new PerformerImpl();
		return performer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalUserTask createGlobalUserTask() {
		GlobalUserTaskImpl globalUserTask = new GlobalUserTaskImpl();
		return globalUserTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalManualTask createGlobalManualTask() {
		GlobalManualTaskImpl globalManualTask = new GlobalManualTaskImpl();
		return globalManualTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManualTask createManualTask() {
		ManualTaskImpl manualTask = new ManualTaskImpl();
		return manualTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PotentialOwner createPotentialOwner() {
		PotentialOwnerImpl potentialOwner = new PotentialOwnerImpl();
		return potentialOwner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubConversation createSubConversation() {
		SubConversationImpl subConversation = new SubConversationImpl();
		return subConversation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalConversation createGlobalConversation() {
		GlobalConversationImpl globalConversation = new GlobalConversationImpl();
		return globalConversation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallConversation createCallConversation() {
		CallConversationImpl callConversation = new CallConversationImpl();
		return callConversation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Conversation createConversation() {
		ConversationImpl conversation = new ConversationImpl();
		return conversation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubProcess createSubProcess() {
		SubProcessImpl subProcess = new SubProcessImpl();
		return subProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallActivity createCallActivity() {
		CallActivityImpl callActivity = new CallActivityImpl();
		return callActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessRuleTask createBusinessRuleTask() {
		BusinessRuleTaskImpl businessRuleTask = new BusinessRuleTaskImpl();
		return businessRuleTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexBehaviorDefinition createComplexBehaviorDefinition() {
		ComplexBehaviorDefinitionImpl complexBehaviorDefinition = new ComplexBehaviorDefinitionImpl();
		return complexBehaviorDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdHocSubProcess createAdHocSubProcess() {
		AdHocSubProcessImpl adHocSubProcess = new AdHocSubProcessImpl();
		return adHocSubProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptTask createScriptTask() {
		ScriptTaskImpl scriptTask = new ScriptTaskImpl();
		return scriptTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SendTask createSendTask() {
		SendTaskImpl sendTask = new SendTaskImpl();
		return sendTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transaction createTransaction() {
		TransactionImpl transaction = new TransactionImpl();
		return transaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardLoopCharacteristics createStandardLoopCharacteristics() {
		StandardLoopCharacteristicsImpl standardLoopCharacteristics = new StandardLoopCharacteristicsImpl();
		return standardLoopCharacteristics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReceiveTask createReceiveTask() {
		ReceiveTaskImpl receiveTask = new ReceiveTaskImpl();
		return receiveTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceTask createServiceTask() {
		ServiceTaskImpl serviceTask = new ServiceTaskImpl();
		return serviceTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiInstanceLoopCharacteristics createMultiInstanceLoopCharacteristics() {
		MultiInstanceLoopCharacteristicsImpl multiInstanceLoopCharacteristics = new MultiInstanceLoopCharacteristicsImpl();
		return multiInstanceLoopCharacteristics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationDirection createAssociationDirectionFromString(EDataType eDataType, String initialValue) {
		AssociationDirection result = AssociationDirection.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAssociationDirectionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventBasedGatewayType createEventBasedGatewayTypeFromString(EDataType eDataType, String initialValue) {
		EventBasedGatewayType result = EventBasedGatewayType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEventBasedGatewayTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GatewayDirection createGatewayDirectionFromString(EDataType eDataType, String initialValue) {
		GatewayDirection result = GatewayDirection.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGatewayDirectionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationshipDirection createRelationshipDirectionFromString(EDataType eDataType, String initialValue) {
		RelationshipDirection result = RelationshipDirection.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRelationshipDirectionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemKind createItemKindFromString(EDataType eDataType, String initialValue) {
		ItemKind result = ItemKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertItemKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessType createProcessTypeFromString(EDataType eDataType, String initialValue) {
		ProcessType result = ProcessType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProcessTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdHocOrdering createAdHocOrderingFromString(EDataType eDataType, String initialValue) {
		AdHocOrdering result = AdHocOrdering.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAdHocOrderingToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiInstanceBehavior createMultiInstanceBehaviorFromString(EDataType eDataType, String initialValue) {
		MultiInstanceBehavior result = MultiInstanceBehavior.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMultiInstanceBehaviorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNProfilePackage getBPMNProfilePackage() {
		return (BPMNProfilePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BPMNProfilePackage getPackage() {
		return BPMNProfilePackage.eINSTANCE;
	}

} //BPMNProfileFactoryImpl
