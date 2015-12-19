/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.bpmn.BPMNProfile.AdHocSubProcess;
import org.eclipse.papyrus.bpmn.BPMNProfile.Assignment;
import org.eclipse.papyrus.bpmn.BPMNProfile.Auditing;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNArtifact;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNEvent;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNExpression;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNExtension;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNInterface;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNMessage;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProperty;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNRelationship;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNSignal;
import org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement;
import org.eclipse.papyrus.bpmn.BPMNProfile.BoundaryEvent;
import org.eclipse.papyrus.bpmn.BPMNProfile.BusinessRuleTask;
import org.eclipse.papyrus.bpmn.BPMNProfile.CallActivity;
import org.eclipse.papyrus.bpmn.BPMNProfile.CallConversation;
import org.eclipse.papyrus.bpmn.BPMNProfile.CallableElement;
import org.eclipse.papyrus.bpmn.BPMNProfile.CancelEventDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.CatchEvent;
import org.eclipse.papyrus.bpmn.BPMNProfile.Category;
import org.eclipse.papyrus.bpmn.BPMNProfile.CategoryValue;
import org.eclipse.papyrus.bpmn.BPMNProfile.CompensateEventDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.ComplexBehaviorDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.ComplexGateway;
import org.eclipse.papyrus.bpmn.BPMNProfile.ConditionalEventDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.Conversation;
import org.eclipse.papyrus.bpmn.BPMNProfile.ConversationLink;
import org.eclipse.papyrus.bpmn.BPMNProfile.ConversationNode;
import org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationKey;
import org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationProperty;
import org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyBinding;
import org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyRetrievalExpression;
import org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationSubscription;
import org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation;
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
import org.eclipse.papyrus.bpmn.BPMNProfile.EventDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.ExclusiveGateway;
import org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeValue;
import org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement;
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowElementsContainer;
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowNode;
import org.eclipse.papyrus.bpmn.BPMNProfile.FormalExpression;
import org.eclipse.papyrus.bpmn.BPMNProfile.Gateway;
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
import org.eclipse.papyrus.bpmn.BPMNProfile.InteractionNode;
import org.eclipse.papyrus.bpmn.BPMNProfile.IntermediateCatchEvent;
import org.eclipse.papyrus.bpmn.BPMNProfile.IntermediateThrowEvent;
import org.eclipse.papyrus.bpmn.BPMNProfile.ItemAwareElement;
import org.eclipse.papyrus.bpmn.BPMNProfile.ItemDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.Lane;
import org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet;
import org.eclipse.papyrus.bpmn.BPMNProfile.LinkEventDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.LoopCharacteristics;
import org.eclipse.papyrus.bpmn.BPMNProfile.ManualTask;
import org.eclipse.papyrus.bpmn.BPMNProfile.MessageEventDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow;
import org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlowAssociation;
import org.eclipse.papyrus.bpmn.BPMNProfile.Monitoring;
import org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics;
import org.eclipse.papyrus.bpmn.BPMNProfile.NonExclusiveGateway;
import org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet;
import org.eclipse.papyrus.bpmn.BPMNProfile.ParallelGateway;
import org.eclipse.papyrus.bpmn.BPMNProfile.Participant;
import org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantAssociation;
import org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantMultiplicity;
import org.eclipse.papyrus.bpmn.BPMNProfile.PartnerEntity;
import org.eclipse.papyrus.bpmn.BPMNProfile.PartnerRole;
import org.eclipse.papyrus.bpmn.BPMNProfile.Performer;
import org.eclipse.papyrus.bpmn.BPMNProfile.PotentialOwner;
import org.eclipse.papyrus.bpmn.BPMNProfile.ReceiveTask;
import org.eclipse.papyrus.bpmn.BPMNProfile.Rendering;
import org.eclipse.papyrus.bpmn.BPMNProfile.Resource;
import org.eclipse.papyrus.bpmn.BPMNProfile.ResourceAssignmentExpression;
import org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameter;
import org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameterBinding;
import org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole;
import org.eclipse.papyrus.bpmn.BPMNProfile.RootElement;
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
import org.eclipse.papyrus.bpmn.BPMNProfile.ThrowEvent;
import org.eclipse.papyrus.bpmn.BPMNProfile.TimerEventDefinition;
import org.eclipse.papyrus.bpmn.BPMNProfile.Transaction;
import org.eclipse.papyrus.bpmn.BPMNProfile.UserTask;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage
 * @generated
 */
public class BPMNProfileSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BPMNProfilePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNProfileSwitch() {
		if (modelPackage == null) {
			modelPackage = BPMNProfilePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case BPMNProfilePackage.INCLUSIVE_GATEWAY: {
				InclusiveGateway inclusiveGateway = (InclusiveGateway)theEObject;
				T result = caseInclusiveGateway(inclusiveGateway);
				if (result == null) result = caseNonExclusiveGateway(inclusiveGateway);
				if (result == null) result = caseGateway(inclusiveGateway);
				if (result == null) result = caseFlowNode(inclusiveGateway);
				if (result == null) result = caseFlowElement(inclusiveGateway);
				if (result == null) result = caseBaseElement(inclusiveGateway);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.NON_EXCLUSIVE_GATEWAY: {
				NonExclusiveGateway nonExclusiveGateway = (NonExclusiveGateway)theEObject;
				T result = caseNonExclusiveGateway(nonExclusiveGateway);
				if (result == null) result = caseGateway(nonExclusiveGateway);
				if (result == null) result = caseFlowNode(nonExclusiveGateway);
				if (result == null) result = caseFlowElement(nonExclusiveGateway);
				if (result == null) result = caseBaseElement(nonExclusiveGateway);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.GATEWAY: {
				Gateway gateway = (Gateway)theEObject;
				T result = caseGateway(gateway);
				if (result == null) result = caseFlowNode(gateway);
				if (result == null) result = caseFlowElement(gateway);
				if (result == null) result = caseBaseElement(gateway);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.FLOW_NODE: {
				FlowNode flowNode = (FlowNode)theEObject;
				T result = caseFlowNode(flowNode);
				if (result == null) result = caseFlowElement(flowNode);
				if (result == null) result = caseBaseElement(flowNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.FLOW_ELEMENT: {
				FlowElement flowElement = (FlowElement)theEObject;
				T result = caseFlowElement(flowElement);
				if (result == null) result = caseBaseElement(flowElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.BASE_ELEMENT: {
				BaseElement baseElement = (BaseElement)theEObject;
				T result = caseBaseElement(baseElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.EXTENSION_ATTRIBUTE_VALUE: {
				ExtensionAttributeValue extensionAttributeValue = (ExtensionAttributeValue)theEObject;
				T result = caseExtensionAttributeValue(extensionAttributeValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.EXTENSION_ATTRIBUTE_DEFINITION: {
				ExtensionAttributeDefinition extensionAttributeDefinition = (ExtensionAttributeDefinition)theEObject;
				T result = caseExtensionAttributeDefinition(extensionAttributeDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.DOCUMENTATION: {
				Documentation documentation = (Documentation)theEObject;
				T result = caseDocumentation(documentation);
				if (result == null) result = caseBaseElement(documentation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.EXTENSION_DEFINITION: {
				ExtensionDefinition extensionDefinition = (ExtensionDefinition)theEObject;
				T result = caseExtensionDefinition(extensionDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.BPMN_ASSOCIATION: {
				BPMNAssociation bpmnAssociation = (BPMNAssociation)theEObject;
				T result = caseBPMNAssociation(bpmnAssociation);
				if (result == null) result = caseBPMNArtifact(bpmnAssociation);
				if (result == null) result = caseBaseElement(bpmnAssociation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.BPMN_ARTIFACT: {
				BPMNArtifact bpmnArtifact = (BPMNArtifact)theEObject;
				T result = caseBPMNArtifact(bpmnArtifact);
				if (result == null) result = caseBaseElement(bpmnArtifact);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.AUDITING: {
				Auditing auditing = (Auditing)theEObject;
				T result = caseAuditing(auditing);
				if (result == null) result = caseBaseElement(auditing);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.MONITORING: {
				Monitoring monitoring = (Monitoring)theEObject;
				T result = caseMonitoring(monitoring);
				if (result == null) result = caseBaseElement(monitoring);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.CATEGORY_VALUE: {
				CategoryValue categoryValue = (CategoryValue)theEObject;
				T result = caseCategoryValue(categoryValue);
				if (result == null) result = caseBaseElement(categoryValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.FLOW_ELEMENTS_CONTAINER: {
				FlowElementsContainer flowElementsContainer = (FlowElementsContainer)theEObject;
				T result = caseFlowElementsContainer(flowElementsContainer);
				if (result == null) result = caseBaseElement(flowElementsContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.LANE_SET: {
				LaneSet laneSet = (LaneSet)theEObject;
				T result = caseLaneSet(laneSet);
				if (result == null) result = caseBaseElement(laneSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.LANE: {
				Lane lane = (Lane)theEObject;
				T result = caseLane(lane);
				if (result == null) result = caseBaseElement(lane);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.SEQUENCE_FLOW: {
				SequenceFlow sequenceFlow = (SequenceFlow)theEObject;
				T result = caseSequenceFlow(sequenceFlow);
				if (result == null) result = caseFlowElement(sequenceFlow);
				if (result == null) result = caseBaseElement(sequenceFlow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.BPMN_EXPRESSION: {
				BPMNExpression bpmnExpression = (BPMNExpression)theEObject;
				T result = caseBPMNExpression(bpmnExpression);
				if (result == null) result = caseBaseElement(bpmnExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.EVENT_BASED_GATEWAY: {
				EventBasedGateway eventBasedGateway = (EventBasedGateway)theEObject;
				T result = caseEventBasedGateway(eventBasedGateway);
				if (result == null) result = caseGateway(eventBasedGateway);
				if (result == null) result = caseFlowNode(eventBasedGateway);
				if (result == null) result = caseFlowElement(eventBasedGateway);
				if (result == null) result = caseBaseElement(eventBasedGateway);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.PARALLEL_GATEWAY: {
				ParallelGateway parallelGateway = (ParallelGateway)theEObject;
				T result = caseParallelGateway(parallelGateway);
				if (result == null) result = caseNonExclusiveGateway(parallelGateway);
				if (result == null) result = caseGateway(parallelGateway);
				if (result == null) result = caseFlowNode(parallelGateway);
				if (result == null) result = caseFlowElement(parallelGateway);
				if (result == null) result = caseBaseElement(parallelGateway);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.COMPLEX_GATEWAY: {
				ComplexGateway complexGateway = (ComplexGateway)theEObject;
				T result = caseComplexGateway(complexGateway);
				if (result == null) result = caseNonExclusiveGateway(complexGateway);
				if (result == null) result = caseGateway(complexGateway);
				if (result == null) result = caseFlowNode(complexGateway);
				if (result == null) result = caseFlowElement(complexGateway);
				if (result == null) result = caseBaseElement(complexGateway);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.EXCLUSIVE_GATEWAY: {
				ExclusiveGateway exclusiveGateway = (ExclusiveGateway)theEObject;
				T result = caseExclusiveGateway(exclusiveGateway);
				if (result == null) result = caseGateway(exclusiveGateway);
				if (result == null) result = caseFlowNode(exclusiveGateway);
				if (result == null) result = caseFlowElement(exclusiveGateway);
				if (result == null) result = caseBaseElement(exclusiveGateway);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.ROOT_ELEMENT: {
				RootElement rootElement = (RootElement)theEObject;
				T result = caseRootElement(rootElement);
				if (result == null) result = caseBaseElement(rootElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.DEFINITIONS: {
				Definitions definitions = (Definitions)theEObject;
				T result = caseDefinitions(definitions);
				if (result == null) result = caseBaseElement(definitions);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.BPMN_EXTENSION: {
				BPMNExtension bpmnExtension = (BPMNExtension)theEObject;
				T result = caseBPMNExtension(bpmnExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.IMPORT: {
				Import import_ = (Import)theEObject;
				T result = caseImport(import_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.BPMN_RELATIONSHIP: {
				BPMNRelationship bpmnRelationship = (BPMNRelationship)theEObject;
				T result = caseBPMNRelationship(bpmnRelationship);
				if (result == null) result = caseBaseElement(bpmnRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.BPMN_PROCESS: {
				BPMNProcess bpmnProcess = (BPMNProcess)theEObject;
				T result = caseBPMNProcess(bpmnProcess);
				if (result == null) result = caseCallableElement(bpmnProcess);
				if (result == null) result = caseFlowElementsContainer(bpmnProcess);
				if (result == null) result = caseRootElement(bpmnProcess);
				if (result == null) result = caseBaseElement(bpmnProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.CALLABLE_ELEMENT: {
				CallableElement callableElement = (CallableElement)theEObject;
				T result = caseCallableElement(callableElement);
				if (result == null) result = caseRootElement(callableElement);
				if (result == null) result = caseBaseElement(callableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.INPUT_OUTPUT_SPECIFICATION: {
				InputOutputSpecification inputOutputSpecification = (InputOutputSpecification)theEObject;
				T result = caseInputOutputSpecification(inputOutputSpecification);
				if (result == null) result = caseBaseElement(inputOutputSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.DATA_INPUT: {
				DataInput dataInput = (DataInput)theEObject;
				T result = caseDataInput(dataInput);
				if (result == null) result = caseItemAwareElement(dataInput);
				if (result == null) result = caseBaseElement(dataInput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.ITEM_AWARE_ELEMENT: {
				ItemAwareElement itemAwareElement = (ItemAwareElement)theEObject;
				T result = caseItemAwareElement(itemAwareElement);
				if (result == null) result = caseBaseElement(itemAwareElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.DATA_STATE: {
				DataState dataState = (DataState)theEObject;
				T result = caseDataState(dataState);
				if (result == null) result = caseBaseElement(dataState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.ITEM_DEFINITION: {
				ItemDefinition itemDefinition = (ItemDefinition)theEObject;
				T result = caseItemDefinition(itemDefinition);
				if (result == null) result = caseRootElement(itemDefinition);
				if (result == null) result = caseBaseElement(itemDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.INPUT_SET: {
				InputSet inputSet = (InputSet)theEObject;
				T result = caseInputSet(inputSet);
				if (result == null) result = caseBaseElement(inputSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.DATA_OUTPUT: {
				DataOutput dataOutput = (DataOutput)theEObject;
				T result = caseDataOutput(dataOutput);
				if (result == null) result = caseItemAwareElement(dataOutput);
				if (result == null) result = caseBaseElement(dataOutput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.OUTPUT_SET: {
				OutputSet outputSet = (OutputSet)theEObject;
				T result = caseOutputSet(outputSet);
				if (result == null) result = caseBaseElement(outputSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.BPMN_INTERFACE: {
				BPMNInterface bpmnInterface = (BPMNInterface)theEObject;
				T result = caseBPMNInterface(bpmnInterface);
				if (result == null) result = caseRootElement(bpmnInterface);
				if (result == null) result = caseBaseElement(bpmnInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.BPMN_OPERATION: {
				BPMNOperation bpmnOperation = (BPMNOperation)theEObject;
				T result = caseBPMNOperation(bpmnOperation);
				if (result == null) result = caseBaseElement(bpmnOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.BPMN_MESSAGE: {
				BPMNMessage bpmnMessage = (BPMNMessage)theEObject;
				T result = caseBPMNMessage(bpmnMessage);
				if (result == null) result = caseItemDefinition(bpmnMessage);
				if (result == null) result = caseRootElement(bpmnMessage);
				if (result == null) result = caseBaseElement(bpmnMessage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.ERROR: {
				org.eclipse.papyrus.bpmn.BPMNProfile.Error error = (org.eclipse.papyrus.bpmn.BPMNProfile.Error)theEObject;
				T result = caseError(error);
				if (result == null) result = caseItemDefinition(error);
				if (result == null) result = caseRootElement(error);
				if (result == null) result = caseBaseElement(error);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.INPUT_OUTPUT_BINDING: {
				InputOutputBinding inputOutputBinding = (InputOutputBinding)theEObject;
				T result = caseInputOutputBinding(inputOutputBinding);
				if (result == null) result = caseBaseElement(inputOutputBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.BPMN_COLLABORATION: {
				BPMNCollaboration bpmnCollaboration = (BPMNCollaboration)theEObject;
				T result = caseBPMNCollaboration(bpmnCollaboration);
				if (result == null) result = caseRootElement(bpmnCollaboration);
				if (result == null) result = caseBaseElement(bpmnCollaboration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.PARTICIPANT_ASSOCIATION: {
				ParticipantAssociation participantAssociation = (ParticipantAssociation)theEObject;
				T result = caseParticipantAssociation(participantAssociation);
				if (result == null) result = caseBaseElement(participantAssociation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.PARTICIPANT: {
				Participant participant = (Participant)theEObject;
				T result = caseParticipant(participant);
				if (result == null) result = caseBaseElement(participant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.INTERACTION_NODE: {
				InteractionNode interactionNode = (InteractionNode)theEObject;
				T result = caseInteractionNode(interactionNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.CONVERSATION_LINK: {
				ConversationLink conversationLink = (ConversationLink)theEObject;
				T result = caseConversationLink(conversationLink);
				if (result == null) result = caseBaseElement(conversationLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.PARTICIPANT_MULTIPLICITY: {
				ParticipantMultiplicity participantMultiplicity = (ParticipantMultiplicity)theEObject;
				T result = caseParticipantMultiplicity(participantMultiplicity);
				if (result == null) result = caseBaseElement(participantMultiplicity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.PARTNER_ENTITY: {
				PartnerEntity partnerEntity = (PartnerEntity)theEObject;
				T result = casePartnerEntity(partnerEntity);
				if (result == null) result = caseRootElement(partnerEntity);
				if (result == null) result = caseBaseElement(partnerEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.PARTNER_ROLE: {
				PartnerRole partnerRole = (PartnerRole)theEObject;
				T result = casePartnerRole(partnerRole);
				if (result == null) result = caseRootElement(partnerRole);
				if (result == null) result = caseBaseElement(partnerRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.MESSAGE_FLOW_ASSOCIATION: {
				MessageFlowAssociation messageFlowAssociation = (MessageFlowAssociation)theEObject;
				T result = caseMessageFlowAssociation(messageFlowAssociation);
				if (result == null) result = caseBaseElement(messageFlowAssociation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.MESSAGE_FLOW: {
				MessageFlow messageFlow = (MessageFlow)theEObject;
				T result = caseMessageFlow(messageFlow);
				if (result == null) result = caseBaseElement(messageFlow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.CONVERSATION_NODE: {
				ConversationNode conversationNode = (ConversationNode)theEObject;
				T result = caseConversationNode(conversationNode);
				if (result == null) result = caseInteractionNode(conversationNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.CORRELATION_KEY: {
				CorrelationKey correlationKey = (CorrelationKey)theEObject;
				T result = caseCorrelationKey(correlationKey);
				if (result == null) result = caseBaseElement(correlationKey);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.CORRELATION_PROPERTY: {
				CorrelationProperty correlationProperty = (CorrelationProperty)theEObject;
				T result = caseCorrelationProperty(correlationProperty);
				if (result == null) result = caseBaseElement(correlationProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION: {
				CorrelationPropertyRetrievalExpression correlationPropertyRetrievalExpression = (CorrelationPropertyRetrievalExpression)theEObject;
				T result = caseCorrelationPropertyRetrievalExpression(correlationPropertyRetrievalExpression);
				if (result == null) result = caseBaseElement(correlationPropertyRetrievalExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.FORMAL_EXPRESSION: {
				FormalExpression formalExpression = (FormalExpression)theEObject;
				T result = caseFormalExpression(formalExpression);
				if (result == null) result = caseBPMNExpression(formalExpression);
				if (result == null) result = caseBaseElement(formalExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.CORRELATION_SUBSCRIPTION: {
				CorrelationSubscription correlationSubscription = (CorrelationSubscription)theEObject;
				T result = caseCorrelationSubscription(correlationSubscription);
				if (result == null) result = caseBaseElement(correlationSubscription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.CORRELATION_PROPERTY_BINDING: {
				CorrelationPropertyBinding correlationPropertyBinding = (CorrelationPropertyBinding)theEObject;
				T result = caseCorrelationPropertyBinding(correlationPropertyBinding);
				if (result == null) result = caseBaseElement(correlationPropertyBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.BPMN_PROPERTY: {
				BPMNProperty bpmnProperty = (BPMNProperty)theEObject;
				T result = caseBPMNProperty(bpmnProperty);
				if (result == null) result = caseItemAwareElement(bpmnProperty);
				if (result == null) result = caseBaseElement(bpmnProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.RESOURCE_ROLE: {
				ResourceRole resourceRole = (ResourceRole)theEObject;
				T result = caseResourceRole(resourceRole);
				if (result == null) result = caseBaseElement(resourceRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.RESOURCE_ASSIGNMENT_EXPRESSION: {
				ResourceAssignmentExpression resourceAssignmentExpression = (ResourceAssignmentExpression)theEObject;
				T result = caseResourceAssignmentExpression(resourceAssignmentExpression);
				if (result == null) result = caseBPMNExpression(resourceAssignmentExpression);
				if (result == null) result = caseBaseElement(resourceAssignmentExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.RESOURCE: {
				Resource resource = (Resource)theEObject;
				T result = caseResource(resource);
				if (result == null) result = caseItemDefinition(resource);
				if (result == null) result = caseRootElement(resource);
				if (result == null) result = caseBaseElement(resource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.RESOURCE_PARAMETER: {
				ResourceParameter resourceParameter = (ResourceParameter)theEObject;
				T result = caseResourceParameter(resourceParameter);
				if (result == null) result = caseBaseElement(resourceParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.RESOURCE_PARAMETER_BINDING: {
				ResourceParameterBinding resourceParameterBinding = (ResourceParameterBinding)theEObject;
				T result = caseResourceParameterBinding(resourceParameterBinding);
				if (result == null) result = caseBaseElement(resourceParameterBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.GLOBAL_SCRIPT_TASK: {
				GlobalScriptTask globalScriptTask = (GlobalScriptTask)theEObject;
				T result = caseGlobalScriptTask(globalScriptTask);
				if (result == null) result = caseGlobalTask(globalScriptTask);
				if (result == null) result = caseCallableElement(globalScriptTask);
				if (result == null) result = caseRootElement(globalScriptTask);
				if (result == null) result = caseBaseElement(globalScriptTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.GLOBAL_TASK: {
				GlobalTask globalTask = (GlobalTask)theEObject;
				T result = caseGlobalTask(globalTask);
				if (result == null) result = caseCallableElement(globalTask);
				if (result == null) result = caseRootElement(globalTask);
				if (result == null) result = caseBaseElement(globalTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.GLOBAL_BUSINESS_RULE_TASK: {
				GlobalBusinessRuleTask globalBusinessRuleTask = (GlobalBusinessRuleTask)theEObject;
				T result = caseGlobalBusinessRuleTask(globalBusinessRuleTask);
				if (result == null) result = caseGlobalTask(globalBusinessRuleTask);
				if (result == null) result = caseCallableElement(globalBusinessRuleTask);
				if (result == null) result = caseRootElement(globalBusinessRuleTask);
				if (result == null) result = caseBaseElement(globalBusinessRuleTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.COMPENSATE_EVENT_DEFINITION: {
				CompensateEventDefinition compensateEventDefinition = (CompensateEventDefinition)theEObject;
				T result = caseCompensateEventDefinition(compensateEventDefinition);
				if (result == null) result = caseEventDefinition(compensateEventDefinition);
				if (result == null) result = caseRootElement(compensateEventDefinition);
				if (result == null) result = caseBaseElement(compensateEventDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.EVENT_DEFINITION: {
				EventDefinition eventDefinition = (EventDefinition)theEObject;
				T result = caseEventDefinition(eventDefinition);
				if (result == null) result = caseRootElement(eventDefinition);
				if (result == null) result = caseBaseElement(eventDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.BPMN_ACTIVITY: {
				BPMNActivity bpmnActivity = (BPMNActivity)theEObject;
				T result = caseBPMNActivity(bpmnActivity);
				if (result == null) result = caseFlowNode(bpmnActivity);
				if (result == null) result = caseFlowElement(bpmnActivity);
				if (result == null) result = caseBaseElement(bpmnActivity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.BOUNDARY_EVENT: {
				BoundaryEvent boundaryEvent = (BoundaryEvent)theEObject;
				T result = caseBoundaryEvent(boundaryEvent);
				if (result == null) result = caseCatchEvent(boundaryEvent);
				if (result == null) result = caseBPMNEvent(boundaryEvent);
				if (result == null) result = caseFlowNode(boundaryEvent);
				if (result == null) result = caseFlowElement(boundaryEvent);
				if (result == null) result = caseBaseElement(boundaryEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.CATCH_EVENT: {
				CatchEvent catchEvent = (CatchEvent)theEObject;
				T result = caseCatchEvent(catchEvent);
				if (result == null) result = caseBPMNEvent(catchEvent);
				if (result == null) result = caseFlowNode(catchEvent);
				if (result == null) result = caseFlowElement(catchEvent);
				if (result == null) result = caseBaseElement(catchEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.BPMN_EVENT: {
				BPMNEvent bpmnEvent = (BPMNEvent)theEObject;
				T result = caseBPMNEvent(bpmnEvent);
				if (result == null) result = caseFlowNode(bpmnEvent);
				if (result == null) result = caseFlowElement(bpmnEvent);
				if (result == null) result = caseBaseElement(bpmnEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.DATA_OUTPUT_ASSOCIATION: {
				DataOutputAssociation dataOutputAssociation = (DataOutputAssociation)theEObject;
				T result = caseDataOutputAssociation(dataOutputAssociation);
				if (result == null) result = caseDataAssociation(dataOutputAssociation);
				if (result == null) result = caseBaseElement(dataOutputAssociation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.DATA_ASSOCIATION: {
				DataAssociation dataAssociation = (DataAssociation)theEObject;
				T result = caseDataAssociation(dataAssociation);
				if (result == null) result = caseBaseElement(dataAssociation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.ASSIGNMENT: {
				Assignment assignment = (Assignment)theEObject;
				T result = caseAssignment(assignment);
				if (result == null) result = caseBaseElement(assignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.DATA_INPUT_ASSOCIATION: {
				DataInputAssociation dataInputAssociation = (DataInputAssociation)theEObject;
				T result = caseDataInputAssociation(dataInputAssociation);
				if (result == null) result = caseDataAssociation(dataInputAssociation);
				if (result == null) result = caseBaseElement(dataInputAssociation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.LOOP_CHARACTERISTICS: {
				LoopCharacteristics loopCharacteristics = (LoopCharacteristics)theEObject;
				T result = caseLoopCharacteristics(loopCharacteristics);
				if (result == null) result = caseBaseElement(loopCharacteristics);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.ESCALATION_EVENT_DEFINITION: {
				EscalationEventDefinition escalationEventDefinition = (EscalationEventDefinition)theEObject;
				T result = caseEscalationEventDefinition(escalationEventDefinition);
				if (result == null) result = caseEventDefinition(escalationEventDefinition);
				if (result == null) result = caseRootElement(escalationEventDefinition);
				if (result == null) result = caseBaseElement(escalationEventDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.ESCALATION: {
				Escalation escalation = (Escalation)theEObject;
				T result = caseEscalation(escalation);
				if (result == null) result = caseItemDefinition(escalation);
				if (result == null) result = caseRootElement(escalation);
				if (result == null) result = caseBaseElement(escalation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.TIMER_EVENT_DEFINITION: {
				TimerEventDefinition timerEventDefinition = (TimerEventDefinition)theEObject;
				T result = caseTimerEventDefinition(timerEventDefinition);
				if (result == null) result = caseEventDefinition(timerEventDefinition);
				if (result == null) result = caseRootElement(timerEventDefinition);
				if (result == null) result = caseBaseElement(timerEventDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.SIGNAL_EVENT_DEFINITION: {
				SignalEventDefinition signalEventDefinition = (SignalEventDefinition)theEObject;
				T result = caseSignalEventDefinition(signalEventDefinition);
				if (result == null) result = caseEventDefinition(signalEventDefinition);
				if (result == null) result = caseRootElement(signalEventDefinition);
				if (result == null) result = caseBaseElement(signalEventDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.BPMN_SIGNAL: {
				BPMNSignal bpmnSignal = (BPMNSignal)theEObject;
				T result = caseBPMNSignal(bpmnSignal);
				if (result == null) result = caseItemDefinition(bpmnSignal);
				if (result == null) result = caseRootElement(bpmnSignal);
				if (result == null) result = caseBaseElement(bpmnSignal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.END_EVENT: {
				EndEvent endEvent = (EndEvent)theEObject;
				T result = caseEndEvent(endEvent);
				if (result == null) result = caseThrowEvent(endEvent);
				if (result == null) result = caseBPMNEvent(endEvent);
				if (result == null) result = caseFlowNode(endEvent);
				if (result == null) result = caseFlowElement(endEvent);
				if (result == null) result = caseBaseElement(endEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.THROW_EVENT: {
				ThrowEvent throwEvent = (ThrowEvent)theEObject;
				T result = caseThrowEvent(throwEvent);
				if (result == null) result = caseBPMNEvent(throwEvent);
				if (result == null) result = caseFlowNode(throwEvent);
				if (result == null) result = caseFlowElement(throwEvent);
				if (result == null) result = caseBaseElement(throwEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.MESSAGE_EVENT_DEFINITION: {
				MessageEventDefinition messageEventDefinition = (MessageEventDefinition)theEObject;
				T result = caseMessageEventDefinition(messageEventDefinition);
				if (result == null) result = caseEventDefinition(messageEventDefinition);
				if (result == null) result = caseRootElement(messageEventDefinition);
				if (result == null) result = caseBaseElement(messageEventDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.START_EVENT: {
				StartEvent startEvent = (StartEvent)theEObject;
				T result = caseStartEvent(startEvent);
				if (result == null) result = caseCatchEvent(startEvent);
				if (result == null) result = caseBPMNEvent(startEvent);
				if (result == null) result = caseFlowNode(startEvent);
				if (result == null) result = caseFlowElement(startEvent);
				if (result == null) result = caseBaseElement(startEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.CONDITIONAL_EVENT_DEFINITION: {
				ConditionalEventDefinition conditionalEventDefinition = (ConditionalEventDefinition)theEObject;
				T result = caseConditionalEventDefinition(conditionalEventDefinition);
				if (result == null) result = caseEventDefinition(conditionalEventDefinition);
				if (result == null) result = caseRootElement(conditionalEventDefinition);
				if (result == null) result = caseBaseElement(conditionalEventDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.LINK_EVENT_DEFINITION: {
				LinkEventDefinition linkEventDefinition = (LinkEventDefinition)theEObject;
				T result = caseLinkEventDefinition(linkEventDefinition);
				if (result == null) result = caseEventDefinition(linkEventDefinition);
				if (result == null) result = caseRootElement(linkEventDefinition);
				if (result == null) result = caseBaseElement(linkEventDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.ERROR_EVENT_DEFINITION: {
				ErrorEventDefinition errorEventDefinition = (ErrorEventDefinition)theEObject;
				T result = caseErrorEventDefinition(errorEventDefinition);
				if (result == null) result = caseEventDefinition(errorEventDefinition);
				if (result == null) result = caseRootElement(errorEventDefinition);
				if (result == null) result = caseBaseElement(errorEventDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.INTERMEDIATE_CATCH_EVENT: {
				IntermediateCatchEvent intermediateCatchEvent = (IntermediateCatchEvent)theEObject;
				T result = caseIntermediateCatchEvent(intermediateCatchEvent);
				if (result == null) result = caseCatchEvent(intermediateCatchEvent);
				if (result == null) result = caseBPMNEvent(intermediateCatchEvent);
				if (result == null) result = caseFlowNode(intermediateCatchEvent);
				if (result == null) result = caseFlowElement(intermediateCatchEvent);
				if (result == null) result = caseBaseElement(intermediateCatchEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.INTERMEDIATE_THROW_EVENT: {
				IntermediateThrowEvent intermediateThrowEvent = (IntermediateThrowEvent)theEObject;
				T result = caseIntermediateThrowEvent(intermediateThrowEvent);
				if (result == null) result = caseThrowEvent(intermediateThrowEvent);
				if (result == null) result = caseBPMNEvent(intermediateThrowEvent);
				if (result == null) result = caseFlowNode(intermediateThrowEvent);
				if (result == null) result = caseFlowElement(intermediateThrowEvent);
				if (result == null) result = caseBaseElement(intermediateThrowEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.TERMINATE_EVENT_DEFINITION: {
				TerminateEventDefinition terminateEventDefinition = (TerminateEventDefinition)theEObject;
				T result = caseTerminateEventDefinition(terminateEventDefinition);
				if (result == null) result = caseEventDefinition(terminateEventDefinition);
				if (result == null) result = caseRootElement(terminateEventDefinition);
				if (result == null) result = caseBaseElement(terminateEventDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.IMPLICIT_THROW_EVENT: {
				ImplicitThrowEvent implicitThrowEvent = (ImplicitThrowEvent)theEObject;
				T result = caseImplicitThrowEvent(implicitThrowEvent);
				if (result == null) result = caseThrowEvent(implicitThrowEvent);
				if (result == null) result = caseBPMNEvent(implicitThrowEvent);
				if (result == null) result = caseFlowNode(implicitThrowEvent);
				if (result == null) result = caseFlowElement(implicitThrowEvent);
				if (result == null) result = caseBaseElement(implicitThrowEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.CANCEL_EVENT_DEFINITION: {
				CancelEventDefinition cancelEventDefinition = (CancelEventDefinition)theEObject;
				T result = caseCancelEventDefinition(cancelEventDefinition);
				if (result == null) result = caseEventDefinition(cancelEventDefinition);
				if (result == null) result = caseRootElement(cancelEventDefinition);
				if (result == null) result = caseBaseElement(cancelEventDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.TEXT_ANNOTATION: {
				TextAnnotation textAnnotation = (TextAnnotation)theEObject;
				T result = caseTextAnnotation(textAnnotation);
				if (result == null) result = caseBPMNArtifact(textAnnotation);
				if (result == null) result = caseBaseElement(textAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.CATEGORY: {
				Category category = (Category)theEObject;
				T result = caseCategory(category);
				if (result == null) result = caseRootElement(category);
				if (result == null) result = caseBaseElement(category);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.GROUP: {
				Group group = (Group)theEObject;
				T result = caseGroup(group);
				if (result == null) result = caseBPMNArtifact(group);
				if (result == null) result = caseBaseElement(group);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.DATA_OBJECT_REFERENCE: {
				DataObjectReference dataObjectReference = (DataObjectReference)theEObject;
				T result = caseDataObjectReference(dataObjectReference);
				if (result == null) result = caseFlowElement(dataObjectReference);
				if (result == null) result = caseItemAwareElement(dataObjectReference);
				if (result == null) result = caseBaseElement(dataObjectReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.DATA_OBJECT: {
				DataObject dataObject = (DataObject)theEObject;
				T result = caseDataObject(dataObject);
				if (result == null) result = caseFlowElement(dataObject);
				if (result == null) result = caseItemAwareElement(dataObject);
				if (result == null) result = caseBaseElement(dataObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.DATA_STORE: {
				DataStore dataStore = (DataStore)theEObject;
				T result = caseDataStore(dataStore);
				if (result == null) result = caseRootElement(dataStore);
				if (result == null) result = caseBaseElement(dataStore);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.DATA_STORE_REFERENCE: {
				DataStoreReference dataStoreReference = (DataStoreReference)theEObject;
				T result = caseDataStoreReference(dataStoreReference);
				if (result == null) result = caseFlowElement(dataStoreReference);
				if (result == null) result = caseItemAwareElement(dataStoreReference);
				if (result == null) result = caseBaseElement(dataStoreReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.USER_TASK: {
				UserTask userTask = (UserTask)theEObject;
				T result = caseUserTask(userTask);
				if (result == null) result = caseTask(userTask);
				if (result == null) result = caseBPMNActivity(userTask);
				if (result == null) result = caseFlowNode(userTask);
				if (result == null) result = caseFlowElement(userTask);
				if (result == null) result = caseBaseElement(userTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.TASK: {
				Task task = (Task)theEObject;
				T result = caseTask(task);
				if (result == null) result = caseBPMNActivity(task);
				if (result == null) result = caseFlowNode(task);
				if (result == null) result = caseFlowElement(task);
				if (result == null) result = caseBaseElement(task);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.RENDERING: {
				Rendering rendering = (Rendering)theEObject;
				T result = caseRendering(rendering);
				if (result == null) result = caseBaseElement(rendering);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.HUMAN_PERFORMER: {
				HumanPerformer humanPerformer = (HumanPerformer)theEObject;
				T result = caseHumanPerformer(humanPerformer);
				if (result == null) result = casePerformer(humanPerformer);
				if (result == null) result = caseResourceRole(humanPerformer);
				if (result == null) result = caseBaseElement(humanPerformer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.PERFORMER: {
				Performer performer = (Performer)theEObject;
				T result = casePerformer(performer);
				if (result == null) result = caseResourceRole(performer);
				if (result == null) result = caseBaseElement(performer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.GLOBAL_USER_TASK: {
				GlobalUserTask globalUserTask = (GlobalUserTask)theEObject;
				T result = caseGlobalUserTask(globalUserTask);
				if (result == null) result = caseGlobalTask(globalUserTask);
				if (result == null) result = caseCallableElement(globalUserTask);
				if (result == null) result = caseRootElement(globalUserTask);
				if (result == null) result = caseBaseElement(globalUserTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.GLOBAL_MANUAL_TASK: {
				GlobalManualTask globalManualTask = (GlobalManualTask)theEObject;
				T result = caseGlobalManualTask(globalManualTask);
				if (result == null) result = caseGlobalTask(globalManualTask);
				if (result == null) result = caseCallableElement(globalManualTask);
				if (result == null) result = caseRootElement(globalManualTask);
				if (result == null) result = caseBaseElement(globalManualTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.MANUAL_TASK: {
				ManualTask manualTask = (ManualTask)theEObject;
				T result = caseManualTask(manualTask);
				if (result == null) result = caseTask(manualTask);
				if (result == null) result = caseBPMNActivity(manualTask);
				if (result == null) result = caseFlowNode(manualTask);
				if (result == null) result = caseFlowElement(manualTask);
				if (result == null) result = caseBaseElement(manualTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.POTENTIAL_OWNER: {
				PotentialOwner potentialOwner = (PotentialOwner)theEObject;
				T result = casePotentialOwner(potentialOwner);
				if (result == null) result = caseHumanPerformer(potentialOwner);
				if (result == null) result = casePerformer(potentialOwner);
				if (result == null) result = caseResourceRole(potentialOwner);
				if (result == null) result = caseBaseElement(potentialOwner);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.SUB_CONVERSATION: {
				SubConversation subConversation = (SubConversation)theEObject;
				T result = caseSubConversation(subConversation);
				if (result == null) result = caseConversationNode(subConversation);
				if (result == null) result = caseInteractionNode(subConversation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.GLOBAL_CONVERSATION: {
				GlobalConversation globalConversation = (GlobalConversation)theEObject;
				T result = caseGlobalConversation(globalConversation);
				if (result == null) result = caseBPMNCollaboration(globalConversation);
				if (result == null) result = caseRootElement(globalConversation);
				if (result == null) result = caseBaseElement(globalConversation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.CALL_CONVERSATION: {
				CallConversation callConversation = (CallConversation)theEObject;
				T result = caseCallConversation(callConversation);
				if (result == null) result = caseConversationNode(callConversation);
				if (result == null) result = caseInteractionNode(callConversation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.CONVERSATION: {
				Conversation conversation = (Conversation)theEObject;
				T result = caseConversation(conversation);
				if (result == null) result = caseConversationNode(conversation);
				if (result == null) result = caseInteractionNode(conversation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.SUB_PROCESS: {
				SubProcess subProcess = (SubProcess)theEObject;
				T result = caseSubProcess(subProcess);
				if (result == null) result = caseBPMNActivity(subProcess);
				if (result == null) result = caseFlowElementsContainer(subProcess);
				if (result == null) result = caseFlowNode(subProcess);
				if (result == null) result = caseFlowElement(subProcess);
				if (result == null) result = caseBaseElement(subProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.CALL_ACTIVITY: {
				CallActivity callActivity = (CallActivity)theEObject;
				T result = caseCallActivity(callActivity);
				if (result == null) result = caseBPMNActivity(callActivity);
				if (result == null) result = caseFlowNode(callActivity);
				if (result == null) result = caseFlowElement(callActivity);
				if (result == null) result = caseBaseElement(callActivity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.BUSINESS_RULE_TASK: {
				BusinessRuleTask businessRuleTask = (BusinessRuleTask)theEObject;
				T result = caseBusinessRuleTask(businessRuleTask);
				if (result == null) result = caseTask(businessRuleTask);
				if (result == null) result = caseBPMNActivity(businessRuleTask);
				if (result == null) result = caseFlowNode(businessRuleTask);
				if (result == null) result = caseFlowElement(businessRuleTask);
				if (result == null) result = caseBaseElement(businessRuleTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.COMPLEX_BEHAVIOR_DEFINITION: {
				ComplexBehaviorDefinition complexBehaviorDefinition = (ComplexBehaviorDefinition)theEObject;
				T result = caseComplexBehaviorDefinition(complexBehaviorDefinition);
				if (result == null) result = caseBaseElement(complexBehaviorDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.AD_HOC_SUB_PROCESS: {
				AdHocSubProcess adHocSubProcess = (AdHocSubProcess)theEObject;
				T result = caseAdHocSubProcess(adHocSubProcess);
				if (result == null) result = caseSubProcess(adHocSubProcess);
				if (result == null) result = caseBPMNActivity(adHocSubProcess);
				if (result == null) result = caseFlowElementsContainer(adHocSubProcess);
				if (result == null) result = caseFlowNode(adHocSubProcess);
				if (result == null) result = caseFlowElement(adHocSubProcess);
				if (result == null) result = caseBaseElement(adHocSubProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.SCRIPT_TASK: {
				ScriptTask scriptTask = (ScriptTask)theEObject;
				T result = caseScriptTask(scriptTask);
				if (result == null) result = caseTask(scriptTask);
				if (result == null) result = caseBPMNActivity(scriptTask);
				if (result == null) result = caseFlowNode(scriptTask);
				if (result == null) result = caseFlowElement(scriptTask);
				if (result == null) result = caseBaseElement(scriptTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.SEND_TASK: {
				SendTask sendTask = (SendTask)theEObject;
				T result = caseSendTask(sendTask);
				if (result == null) result = caseTask(sendTask);
				if (result == null) result = caseBPMNActivity(sendTask);
				if (result == null) result = caseFlowNode(sendTask);
				if (result == null) result = caseFlowElement(sendTask);
				if (result == null) result = caseBaseElement(sendTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.TRANSACTION: {
				Transaction transaction = (Transaction)theEObject;
				T result = caseTransaction(transaction);
				if (result == null) result = caseSubProcess(transaction);
				if (result == null) result = caseBPMNActivity(transaction);
				if (result == null) result = caseFlowElementsContainer(transaction);
				if (result == null) result = caseFlowNode(transaction);
				if (result == null) result = caseFlowElement(transaction);
				if (result == null) result = caseBaseElement(transaction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.STANDARD_LOOP_CHARACTERISTICS: {
				StandardLoopCharacteristics standardLoopCharacteristics = (StandardLoopCharacteristics)theEObject;
				T result = caseStandardLoopCharacteristics(standardLoopCharacteristics);
				if (result == null) result = caseLoopCharacteristics(standardLoopCharacteristics);
				if (result == null) result = caseBaseElement(standardLoopCharacteristics);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.RECEIVE_TASK: {
				ReceiveTask receiveTask = (ReceiveTask)theEObject;
				T result = caseReceiveTask(receiveTask);
				if (result == null) result = caseTask(receiveTask);
				if (result == null) result = caseBPMNActivity(receiveTask);
				if (result == null) result = caseFlowNode(receiveTask);
				if (result == null) result = caseFlowElement(receiveTask);
				if (result == null) result = caseBaseElement(receiveTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.SERVICE_TASK: {
				ServiceTask serviceTask = (ServiceTask)theEObject;
				T result = caseServiceTask(serviceTask);
				if (result == null) result = caseTask(serviceTask);
				if (result == null) result = caseBPMNActivity(serviceTask);
				if (result == null) result = caseFlowNode(serviceTask);
				if (result == null) result = caseFlowElement(serviceTask);
				if (result == null) result = caseBaseElement(serviceTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BPMNProfilePackage.MULTI_INSTANCE_LOOP_CHARACTERISTICS: {
				MultiInstanceLoopCharacteristics multiInstanceLoopCharacteristics = (MultiInstanceLoopCharacteristics)theEObject;
				T result = caseMultiInstanceLoopCharacteristics(multiInstanceLoopCharacteristics);
				if (result == null) result = caseLoopCharacteristics(multiInstanceLoopCharacteristics);
				if (result == null) result = caseBaseElement(multiInstanceLoopCharacteristics);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inclusive Gateway</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inclusive Gateway</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInclusiveGateway(InclusiveGateway object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Non Exclusive Gateway</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Non Exclusive Gateway</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNonExclusiveGateway(NonExclusiveGateway object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gateway</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gateway</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGateway(Gateway object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowNode(FlowNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowElement(FlowElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBaseElement(BaseElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extension Attribute Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extension Attribute Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtensionAttributeValue(ExtensionAttributeValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extension Attribute Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extension Attribute Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtensionAttributeDefinition(ExtensionAttributeDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Documentation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Documentation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentation(Documentation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extension Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extension Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtensionDefinition(ExtensionDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BPMN Association</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BPMN Association</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBPMNAssociation(BPMNAssociation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BPMN Artifact</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BPMN Artifact</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBPMNArtifact(BPMNArtifact object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Auditing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Auditing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAuditing(Auditing object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Monitoring</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Monitoring</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMonitoring(Monitoring object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Category Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Category Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCategoryValue(CategoryValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Elements Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Elements Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowElementsContainer(FlowElementsContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lane Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lane Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLaneSet(LaneSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lane</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lane</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLane(Lane object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Flow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceFlow(SequenceFlow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BPMN Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BPMN Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBPMNExpression(BPMNExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Based Gateway</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Based Gateway</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventBasedGateway(EventBasedGateway object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parallel Gateway</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parallel Gateway</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParallelGateway(ParallelGateway object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complex Gateway</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complex Gateway</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplexGateway(ComplexGateway object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exclusive Gateway</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exclusive Gateway</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExclusiveGateway(ExclusiveGateway object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRootElement(RootElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Definitions</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Definitions</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefinitions(Definitions object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BPMN Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BPMN Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBPMNExtension(BPMNExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImport(Import object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BPMN Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BPMN Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBPMNRelationship(BPMNRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BPMN Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BPMN Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBPMNProcess(BPMNProcess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Callable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Callable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallableElement(CallableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Output Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Output Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputOutputSpecification(InputOutputSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Input</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Input</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataInput(DataInput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Item Aware Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Item Aware Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseItemAwareElement(ItemAwareElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataState(DataState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Item Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Item Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseItemDefinition(ItemDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputSet(InputSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Output</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Output</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataOutput(DataOutput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputSet(OutputSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BPMN Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BPMN Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBPMNInterface(BPMNInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BPMN Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BPMN Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBPMNOperation(BPMNOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BPMN Message</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BPMN Message</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBPMNMessage(BPMNMessage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseError(org.eclipse.papyrus.bpmn.BPMNProfile.Error object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Output Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Output Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputOutputBinding(InputOutputBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BPMN Collaboration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BPMN Collaboration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBPMNCollaboration(BPMNCollaboration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Participant Association</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Participant Association</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParticipantAssociation(ParticipantAssociation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Participant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Participant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParticipant(Participant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interaction Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interaction Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInteractionNode(InteractionNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conversation Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conversation Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConversationLink(ConversationLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Participant Multiplicity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Participant Multiplicity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParticipantMultiplicity(ParticipantMultiplicity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Partner Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Partner Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePartnerEntity(PartnerEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Partner Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Partner Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePartnerRole(PartnerRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Flow Association</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Flow Association</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageFlowAssociation(MessageFlowAssociation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Flow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageFlow(MessageFlow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conversation Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conversation Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConversationNode(ConversationNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Correlation Key</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Correlation Key</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCorrelationKey(CorrelationKey object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Correlation Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Correlation Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCorrelationProperty(CorrelationProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Correlation Property Retrieval Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Correlation Property Retrieval Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCorrelationPropertyRetrievalExpression(CorrelationPropertyRetrievalExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Formal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Formal Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormalExpression(FormalExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Correlation Subscription</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Correlation Subscription</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCorrelationSubscription(CorrelationSubscription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Correlation Property Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Correlation Property Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCorrelationPropertyBinding(CorrelationPropertyBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BPMN Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BPMN Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBPMNProperty(BPMNProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceRole(ResourceRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Assignment Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Assignment Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceAssignmentExpression(ResourceAssignmentExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResource(Resource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceParameter(ResourceParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Parameter Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Parameter Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceParameterBinding(ResourceParameterBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Global Script Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Global Script Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGlobalScriptTask(GlobalScriptTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Global Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Global Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGlobalTask(GlobalTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Global Business Rule Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Global Business Rule Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGlobalBusinessRuleTask(GlobalBusinessRuleTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compensate Event Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compensate Event Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompensateEventDefinition(CompensateEventDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventDefinition(EventDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BPMN Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BPMN Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBPMNActivity(BPMNActivity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boundary Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boundary Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoundaryEvent(BoundaryEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Catch Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Catch Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCatchEvent(CatchEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BPMN Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BPMN Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBPMNEvent(BPMNEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Output Association</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Output Association</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataOutputAssociation(DataOutputAssociation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Association</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Association</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataAssociation(DataAssociation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignment(Assignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Input Association</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Input Association</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataInputAssociation(DataInputAssociation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Characteristics</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Characteristics</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopCharacteristics(LoopCharacteristics object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Escalation Event Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Escalation Event Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEscalationEventDefinition(EscalationEventDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Escalation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Escalation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEscalation(Escalation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Timer Event Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Timer Event Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimerEventDefinition(TimerEventDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Signal Event Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Signal Event Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSignalEventDefinition(SignalEventDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BPMN Signal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BPMN Signal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBPMNSignal(BPMNSignal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndEvent(EndEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Throw Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Throw Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThrowEvent(ThrowEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message Event Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Event Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageEventDefinition(MessageEventDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Start Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Start Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStartEvent(StartEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditional Event Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional Event Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionalEventDefinition(ConditionalEventDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Event Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Event Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinkEventDefinition(LinkEventDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error Event Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error Event Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorEventDefinition(ErrorEventDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Intermediate Catch Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Intermediate Catch Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntermediateCatchEvent(IntermediateCatchEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Intermediate Throw Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Intermediate Throw Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntermediateThrowEvent(IntermediateThrowEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Terminate Event Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Terminate Event Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerminateEventDefinition(TerminateEventDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Implicit Throw Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Implicit Throw Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImplicitThrowEvent(ImplicitThrowEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cancel Event Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cancel Event Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCancelEventDefinition(CancelEventDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextAnnotation(TextAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Category</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCategory(Category object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGroup(Group object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Object Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Object Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataObjectReference(DataObjectReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataObject(DataObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Store</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Store</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataStore(DataStore object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Store Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Store Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataStoreReference(DataStoreReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUserTask(UserTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTask(Task object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rendering</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rendering</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRendering(Rendering object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Human Performer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Human Performer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHumanPerformer(HumanPerformer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Performer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Performer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePerformer(Performer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Global User Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Global User Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGlobalUserTask(GlobalUserTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Global Manual Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Global Manual Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGlobalManualTask(GlobalManualTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Manual Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Manual Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseManualTask(ManualTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Potential Owner</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Potential Owner</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePotentialOwner(PotentialOwner object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Conversation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Conversation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubConversation(SubConversation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Global Conversation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Global Conversation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGlobalConversation(GlobalConversation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Conversation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Conversation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallConversation(CallConversation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conversation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conversation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConversation(Conversation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubProcess(SubProcess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallActivity(CallActivity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Business Rule Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Business Rule Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBusinessRuleTask(BusinessRuleTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complex Behavior Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complex Behavior Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplexBehaviorDefinition(ComplexBehaviorDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ad Hoc Sub Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ad Hoc Sub Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdHocSubProcess(AdHocSubProcess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Script Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Script Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScriptTask(ScriptTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Send Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Send Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSendTask(SendTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transaction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transaction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransaction(Transaction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Standard Loop Characteristics</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Standard Loop Characteristics</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStandardLoopCharacteristics(StandardLoopCharacteristics object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Receive Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Receive Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReceiveTask(ReceiveTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceTask(ServiceTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multi Instance Loop Characteristics</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multi Instance Loop Characteristics</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiInstanceLoopCharacteristics(MultiInstanceLoopCharacteristics object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //BPMNProfileSwitch
