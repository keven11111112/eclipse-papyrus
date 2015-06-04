/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Fadwa TMAR (CEA LIST) fadwa.tmar@cea.fr - Initial API and implementation
 *****************************************************************************/
package SoaML.util;

import SoaML.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see SoaML.SoaMLPackage
 * @generated
 */
public class SoaMLValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final SoaMLValidator INSTANCE = new SoaMLValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "SoaML";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Is Active' of 'Agent'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int AGENT__IS_ACTIVE = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'No Realized Used Interface' of 'Participant'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PARTICIPANT__NO_REALIZED_USED_INTERFACE = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Port Types' of 'Participant'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PARTICIPANT__PORT_TYPES = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'No Owned Behaviors' of 'Message Type'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MESSAGE_TYPE__NO_OWNED_BEHAVIORS = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'No Owned Operations' of 'Message Type'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MESSAGE_TYPE__NO_OWNED_OPERATIONS = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Public Attributes' of 'Message Type'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int MESSAGE_TYPE__PUBLIC_ATTRIBUTES = 6;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Role Type' of 'Service Contract'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SERVICE_CONTRACT__ROLE_TYPE = 7;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Attached Behavior Compatibility' of 'Service Contract'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SERVICE_CONTRACT__ATTACHED_BEHAVIOR_COMPATIBILITY = 8;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Request Type' of 'Request'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REQUEST__REQUEST_TYPE = 9;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Is Conjugated True' of 'Request'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int REQUEST__IS_CONJUGATED_TRUE = 10;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Parts Types Of Service Interface' of 'Service Interface'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SERVICE_INTERFACE__PARTS_TYPES_OF_SERVICE_INTERFACE = 11;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Participants Role Compatibility' of 'Services Architecture'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SERVICES_ARCHITECTURE__PARTICIPANTS_ROLE_COMPATIBILITY = 12;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Parts Types' of 'Services Architecture'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SERVICES_ARCHITECTURE__PARTS_TYPES = 13;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Role Binding Client Supplier Compatibility' of 'Collaboration Use'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COLLABORATION_USE__ROLE_BINDING_CLIENT_SUPPLIER_COMPATIBILITY = 14;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Onlybinaryconnectorsallowed' of 'Service Channel'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SERVICE_CHANNEL__ONLYBINARYCONNECTORSALLOWED = 15;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Service Channel End Types' of 'Service Channel'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SERVICE_CHANNEL__SERVICE_CHANNEL_END_TYPES = 16;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Compatibility' of 'Service Channel'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SERVICE_CHANNEL__COMPATIBILITY = 17;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Service Type' of 'Service'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SERVICE__SERVICE_TYPE = 18;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Is Conjugated False' of 'Service'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SERVICE__IS_CONJUGATED_FALSE = 19;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Connector Required' of 'Port'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PORT__CONNECTOR_REQUIRED = 20;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 20;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoaMLValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return SoaMLPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case SoaMLPackage.AGENT:
				return validateAgent((Agent)value, diagnostics, context);
			case SoaMLPackage.PARTICIPANT:
				return validateParticipant((Participant)value, diagnostics, context);
			case SoaMLPackage.COLLABORATION:
				return validateCollaboration((Collaboration)value, diagnostics, context);
			case SoaMLPackage.MOTIVATION_ELEMENT:
				return validateMotivationElement((MotivationElement)value, diagnostics, context);
			case SoaMLPackage.PROVIDER:
				return validateProvider((Provider)value, diagnostics, context);
			case SoaMLPackage.FREE_FORM_VALUE:
				return validateFreeFormValue((FreeFormValue)value, diagnostics, context);
			case SoaMLPackage.MESSAGE_TYPE:
				return validateMessageType((MessageType)value, diagnostics, context);
			case SoaMLPackage.CATEGORY:
				return validateCategory((Category)value, diagnostics, context);
			case SoaMLPackage.NODE_DESCRIPTOR:
				return validateNodeDescriptor((NodeDescriptor)value, diagnostics, context);
			case SoaMLPackage.MILESTONE:
				return validateMilestone((Milestone)value, diagnostics, context);
			case SoaMLPackage.FREE_FORM_DESCRIPTOR:
				return validateFreeFormDescriptor((FreeFormDescriptor)value, diagnostics, context);
			case SoaMLPackage.CATEGORY_VALUE:
				return validateCategoryValue((CategoryValue)value, diagnostics, context);
			case SoaMLPackage.SERVICE_CONTRACT:
				return validateServiceContract((ServiceContract)value, diagnostics, context);
			case SoaMLPackage.REQUEST:
				return validateRequest((Request)value, diagnostics, context);
			case SoaMLPackage.CONSUMER:
				return validateConsumer((Consumer)value, diagnostics, context);
			case SoaMLPackage.CATALOG:
				return validateCatalog((Catalog)value, diagnostics, context);
			case SoaMLPackage.CAPABILITY:
				return validateCapability((Capability)value, diagnostics, context);
			case SoaMLPackage.CATEGORIZATION:
				return validateCategorization((Categorization)value, diagnostics, context);
			case SoaMLPackage.MOTIVATION_REALIZATION:
				return validateMotivationRealization((MotivationRealization)value, diagnostics, context);
			case SoaMLPackage.SERVICE_INTERFACE:
				return validateServiceInterface((ServiceInterface)value, diagnostics, context);
			case SoaMLPackage.SERVICES_ARCHITECTURE:
				return validateServicesArchitecture((ServicesArchitecture)value, diagnostics, context);
			case SoaMLPackage.ATTACHMENT:
				return validateAttachment((Attachment)value, diagnostics, context);
			case SoaMLPackage.COLLABORATION_USE:
				return validateCollaborationUse((CollaborationUse)value, diagnostics, context);
			case SoaMLPackage.SERVICE_CHANNEL:
				return validateServiceChannel((ServiceChannel)value, diagnostics, context);
			case SoaMLPackage.SERVICE:
				return validateService((Service)value, diagnostics, context);
			case SoaMLPackage.PORT:
				return validatePort((Port)value, diagnostics, context);
			case SoaMLPackage.PROPERTY:
				return validateProperty((Property)value, diagnostics, context);
			case SoaMLPackage.EXPOSE:
				return validateExpose((Expose)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAgent(Agent agent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(agent, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(agent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(agent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(agent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(agent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(agent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(agent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(agent, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(agent, diagnostics, context);
		if (result || diagnostics != null) result &= validateParticipant_noRealizedUsedInterface(agent, diagnostics, context);
		if (result || diagnostics != null) result &= validateParticipant_portTypes(agent, diagnostics, context);
		if (result || diagnostics != null) result &= validateAgent_isActive(agent, diagnostics, context);
		return result;
	}

	/**
	 * Validates the isActive constraint of '<em>Agent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAgent_isActive(Agent agent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return agent.isActive(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParticipant(Participant participant, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(participant, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(participant, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(participant, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(participant, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(participant, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(participant, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(participant, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(participant, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(participant, diagnostics, context);
		if (result || diagnostics != null) result &= validateParticipant_noRealizedUsedInterface(participant, diagnostics, context);
		if (result || diagnostics != null) result &= validateParticipant_portTypes(participant, diagnostics, context);
		return result;
	}

	/**
	 * Validates the noRealizedUsedInterface constraint of '<em>Participant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParticipant_noRealizedUsedInterface(Participant participant, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return participant.noRealizedUsedInterface(diagnostics, context);
	}

	/**
	 * Validates the portTypes constraint of '<em>Participant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParticipant_portTypes(Participant participant, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return participant.portTypes(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollaboration(Collaboration collaboration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(collaboration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMotivationElement(MotivationElement motivationElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(motivationElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProvider(Provider provider, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(provider, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFreeFormValue(FreeFormValue freeFormValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(freeFormValue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessageType(MessageType messageType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(messageType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validateMessageType_noOwnedBehaviors(messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validateMessageType_noOwnedOperations(messageType, diagnostics, context);
		if (result || diagnostics != null) result &= validateMessageType_publicAttributes(messageType, diagnostics, context);
		return result;
	}

	/**
	 * Validates the noOwnedBehaviors constraint of '<em>Message Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessageType_noOwnedBehaviors(MessageType messageType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return messageType.noOwnedBehaviors(diagnostics, context);
	}

	/**
	 * Validates the noOwnedOperations constraint of '<em>Message Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessageType_noOwnedOperations(MessageType messageType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return messageType.noOwnedOperations(diagnostics, context);
	}

	/**
	 * Validates the publicAttributes constraint of '<em>Message Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMessageType_publicAttributes(MessageType messageType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return messageType.publicAttributes(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCategory(Category category, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(category, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNodeDescriptor(NodeDescriptor nodeDescriptor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(nodeDescriptor, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMilestone(Milestone milestone, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(milestone, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFreeFormDescriptor(FreeFormDescriptor freeFormDescriptor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(freeFormDescriptor, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCategoryValue(CategoryValue categoryValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(categoryValue, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateServiceContract(ServiceContract serviceContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(serviceContract, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(serviceContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(serviceContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(serviceContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(serviceContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(serviceContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(serviceContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(serviceContract, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(serviceContract, diagnostics, context);
		if (result || diagnostics != null) result &= validateServiceContract_RoleType(serviceContract, diagnostics, context);
		if (result || diagnostics != null) result &= validateServiceContract_AttachedBehaviorCompatibility(serviceContract, diagnostics, context);
		return result;
	}

	/**
	 * Validates the RoleType constraint of '<em>Service Contract</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateServiceContract_RoleType(ServiceContract serviceContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return serviceContract.RoleType(diagnostics, context);
	}

	/**
	 * Validates the AttachedBehaviorCompatibility constraint of '<em>Service Contract</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateServiceContract_AttachedBehaviorCompatibility(ServiceContract serviceContract, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return serviceContract.AttachedBehaviorCompatibility(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRequest(Request request, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(request, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(request, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(request, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(request, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(request, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(request, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(request, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(request, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(request, diagnostics, context);
		if (result || diagnostics != null) result &= validateRequest_requestType(request, diagnostics, context);
		if (result || diagnostics != null) result &= validateRequest_isConjugatedTrue(request, diagnostics, context);
		return result;
	}

	/**
	 * Validates the requestType constraint of '<em>Request</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRequest_requestType(Request request, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return request.requestType(diagnostics, context);
	}

	/**
	 * Validates the isConjugatedTrue constraint of '<em>Request</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRequest_isConjugatedTrue(Request request, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return request.isConjugatedTrue(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConsumer(Consumer consumer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(consumer, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCatalog(Catalog catalog, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(catalog, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCapability(Capability capability, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(capability, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCategorization(Categorization categorization, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(categorization, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMotivationRealization(MotivationRealization motivationRealization, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(motivationRealization, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateServiceInterface(ServiceInterface serviceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(serviceInterface, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(serviceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(serviceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(serviceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(serviceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(serviceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(serviceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(serviceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(serviceInterface, diagnostics, context);
		if (result || diagnostics != null) result &= validateServiceInterface_partsTypesOfServiceInterface(serviceInterface, diagnostics, context);
		return result;
	}

	/**
	 * Validates the partsTypesOfServiceInterface constraint of '<em>Service Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateServiceInterface_partsTypesOfServiceInterface(ServiceInterface serviceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return serviceInterface.partsTypesOfServiceInterface(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateServicesArchitecture(ServicesArchitecture servicesArchitecture, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(servicesArchitecture, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(servicesArchitecture, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(servicesArchitecture, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(servicesArchitecture, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(servicesArchitecture, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(servicesArchitecture, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(servicesArchitecture, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(servicesArchitecture, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(servicesArchitecture, diagnostics, context);
		if (result || diagnostics != null) result &= validateServicesArchitecture_participantsRoleCompatibility(servicesArchitecture, diagnostics, context);
		if (result || diagnostics != null) result &= validateServicesArchitecture_partsTypes(servicesArchitecture, diagnostics, context);
		return result;
	}

	/**
	 * Validates the participantsRoleCompatibility constraint of '<em>Services Architecture</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateServicesArchitecture_participantsRoleCompatibility(ServicesArchitecture servicesArchitecture, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return servicesArchitecture.participantsRoleCompatibility(diagnostics, context);
	}

	/**
	 * Validates the partsTypes constraint of '<em>Services Architecture</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateServicesArchitecture_partsTypes(ServicesArchitecture servicesArchitecture, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return servicesArchitecture.partsTypes(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttachment(Attachment attachment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attachment, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollaborationUse(CollaborationUse collaborationUse, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(collaborationUse, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(collaborationUse, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(collaborationUse, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(collaborationUse, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(collaborationUse, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(collaborationUse, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(collaborationUse, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(collaborationUse, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(collaborationUse, diagnostics, context);
		if (result || diagnostics != null) result &= validateCollaborationUse_RoleBindingClientSupplierCompatibility(collaborationUse, diagnostics, context);
		return result;
	}

	/**
	 * Validates the RoleBindingClientSupplierCompatibility constraint of '<em>Collaboration Use</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCollaborationUse_RoleBindingClientSupplierCompatibility(CollaborationUse collaborationUse, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return collaborationUse.RoleBindingClientSupplierCompatibility(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateServiceChannel(ServiceChannel serviceChannel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(serviceChannel, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(serviceChannel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(serviceChannel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(serviceChannel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(serviceChannel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(serviceChannel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(serviceChannel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(serviceChannel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(serviceChannel, diagnostics, context);
		if (result || diagnostics != null) result &= validateServiceChannel_Onlybinaryconnectorsallowed(serviceChannel, diagnostics, context);
		if (result || diagnostics != null) result &= validateServiceChannel_serviceChannelEndTypes(serviceChannel, diagnostics, context);
		if (result || diagnostics != null) result &= validateServiceChannel_Compatibility(serviceChannel, diagnostics, context);
		return result;
	}

	/**
	 * Validates the Onlybinaryconnectorsallowed constraint of '<em>Service Channel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateServiceChannel_Onlybinaryconnectorsallowed(ServiceChannel serviceChannel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return serviceChannel.Onlybinaryconnectorsallowed(diagnostics, context);
	}

	/**
	 * Validates the serviceChannelEndTypes constraint of '<em>Service Channel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateServiceChannel_serviceChannelEndTypes(ServiceChannel serviceChannel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return serviceChannel.serviceChannelEndTypes(diagnostics, context);
	}

	/**
	 * Validates the Compatibility constraint of '<em>Service Channel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateServiceChannel_Compatibility(ServiceChannel serviceChannel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return serviceChannel.Compatibility(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateService(Service service, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(service, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(service, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(service, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(service, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(service, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(service, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(service, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(service, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(service, diagnostics, context);
		if (result || diagnostics != null) result &= validateService_serviceType(service, diagnostics, context);
		if (result || diagnostics != null) result &= validateService_isConjugatedFalse(service, diagnostics, context);
		return result;
	}

	/**
	 * Validates the serviceType constraint of '<em>Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateService_serviceType(Service service, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return service.serviceType(diagnostics, context);
	}

	/**
	 * Validates the isConjugatedFalse constraint of '<em>Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateService_isConjugatedFalse(Service service, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return service.isConjugatedFalse(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePort(Port port, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(port, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(port, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(port, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(port, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(port, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(port, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(port, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(port, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(port, diagnostics, context);
		if (result || diagnostics != null) result &= validatePort_connectorRequired(port, diagnostics, context);
		return result;
	}

	/**
	 * Validates the connectorRequired constraint of '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePort_connectorRequired(Port port, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return port.connectorRequired(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProperty(Property property, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(property, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpose(Expose expose, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(expose, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //SoaMLValidator
