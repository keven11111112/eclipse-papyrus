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
package SoaML;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see SoaML.SoaMLFactory
 * @model kind="package"
 * @generated
 */
public interface SoaMLPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "SoaML";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://Papyrus/SoaML/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "SoaML";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SoaMLPackage eINSTANCE = SoaML.impl.SoaMLPackageImpl.init();

	/**
	 * The meta object id for the '{@link SoaML.impl.ParticipantImpl <em>Participant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.ParticipantImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getParticipant()
	 * @generated
	 */
	int PARTICIPANT = 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Participant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>No Realized Used Interface</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT___NO_REALIZED_USED_INTERFACE__DIAGNOSTICCHAIN_MAP = 0;

	/**
	 * The operation id for the '<em>Port Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT___PORT_TYPES__DIAGNOSTICCHAIN_MAP = 1;

	/**
	 * The number of operations of the '<em>Participant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link SoaML.impl.AgentImpl <em>Agent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.AgentImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getAgent()
	 * @generated
	 */
	int AGENT = 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__BASE_CLASS = PARTICIPANT__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>Agent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_FEATURE_COUNT = PARTICIPANT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>No Realized Used Interface</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT___NO_REALIZED_USED_INTERFACE__DIAGNOSTICCHAIN_MAP = PARTICIPANT___NO_REALIZED_USED_INTERFACE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Port Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT___PORT_TYPES__DIAGNOSTICCHAIN_MAP = PARTICIPANT___PORT_TYPES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Is Active</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT___IS_ACTIVE__DIAGNOSTICCHAIN_MAP = PARTICIPANT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Agent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_OPERATION_COUNT = PARTICIPANT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link SoaML.impl.CollaborationImpl <em>Collaboration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.CollaborationImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getCollaboration()
	 * @generated
	 */
	int COLLABORATION = 2;

	/**
	 * The feature id for the '<em><b>Base Collaboration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLABORATION__BASE_COLLABORATION = 0;

	/**
	 * The feature id for the '<em><b>Is Strict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLABORATION__IS_STRICT = 1;

	/**
	 * The number of structural features of the '<em>Collaboration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLABORATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Collaboration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLABORATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SoaML.impl.MotivationElementImpl <em>Motivation Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.MotivationElementImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getMotivationElement()
	 * @generated
	 */
	int MOTIVATION_ELEMENT = 3;

	/**
	 * The number of structural features of the '<em>Motivation Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTIVATION_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Motivation Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTIVATION_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SoaML.impl.ProviderImpl <em>Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.ProviderImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getProvider()
	 * @generated
	 */
	int PROVIDER = 4;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDER__BASE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Base Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDER__BASE_INTERFACE = 1;

	/**
	 * The number of structural features of the '<em>Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SoaML.impl.FreeFormValueImpl <em>Free Form Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.FreeFormValueImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getFreeFormValue()
	 * @generated
	 */
	int FREE_FORM_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Base Value Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_FORM_VALUE__BASE_VALUE_SPECIFICATION = 0;

	/**
	 * The number of structural features of the '<em>Free Form Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_FORM_VALUE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Free Form Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_FORM_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SoaML.impl.MessageTypeImpl <em>Message Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.MessageTypeImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getMessageType()
	 * @generated
	 */
	int MESSAGE_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Base Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__BASE_SIGNAL = 0;

	/**
	 * The feature id for the '<em><b>Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__ENCODING = 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__BASE_CLASS = 2;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__BASE_DATA_TYPE = 3;

	/**
	 * The number of structural features of the '<em>Message Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>No Owned Behaviors</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE___NO_OWNED_BEHAVIORS__DIAGNOSTICCHAIN_MAP = 0;

	/**
	 * The operation id for the '<em>No Owned Operations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE___NO_OWNED_OPERATIONS__DIAGNOSTICCHAIN_MAP = 1;

	/**
	 * The operation id for the '<em>Public Attributes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE___PUBLIC_ATTRIBUTES__DIAGNOSTICCHAIN_MAP = 2;

	/**
	 * The number of operations of the '<em>Message Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link SoaML.impl.NodeDescriptorImpl <em>Node Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.NodeDescriptorImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getNodeDescriptor()
	 * @generated
	 */
	int NODE_DESCRIPTOR = 8;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_DESCRIPTOR__BASE_ARTIFACT = 0;

	/**
	 * The number of structural features of the '<em>Node Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_DESCRIPTOR_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Node Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_DESCRIPTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SoaML.impl.CategoryImpl <em>Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.CategoryImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getCategory()
	 * @generated
	 */
	int CATEGORY = 7;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__BASE_ARTIFACT = NODE_DESCRIPTOR__BASE_ARTIFACT;

	/**
	 * The number of structural features of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_FEATURE_COUNT = NODE_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_OPERATION_COUNT = NODE_DESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link SoaML.impl.MilestoneImpl <em>Milestone</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.MilestoneImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getMilestone()
	 * @generated
	 */
	int MILESTONE = 9;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILESTONE__SIGNAL = 0;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILESTONE__PROGRESS = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILESTONE__VALUE = 2;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILESTONE__BASE_COMMENT = 3;

	/**
	 * The number of structural features of the '<em>Milestone</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILESTONE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Milestone</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MILESTONE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SoaML.impl.FreeFormDescriptorImpl <em>Free Form Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.FreeFormDescriptorImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getFreeFormDescriptor()
	 * @generated
	 */
	int FREE_FORM_DESCRIPTOR = 10;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_FORM_DESCRIPTOR__BASE_PROPERTY = 0;

	/**
	 * The number of structural features of the '<em>Free Form Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_FORM_DESCRIPTOR_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Free Form Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_FORM_DESCRIPTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SoaML.impl.CategoryValueImpl <em>Category Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.CategoryValueImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getCategoryValue()
	 * @generated
	 */
	int CATEGORY_VALUE = 11;

	/**
	 * The feature id for the '<em><b>Base Value Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_VALUE__BASE_VALUE_SPECIFICATION = FREE_FORM_VALUE__BASE_VALUE_SPECIFICATION;

	/**
	 * The number of structural features of the '<em>Category Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_VALUE_FEATURE_COUNT = FREE_FORM_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Category Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_VALUE_OPERATION_COUNT = FREE_FORM_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link SoaML.impl.ServiceContractImpl <em>Service Contract</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.ServiceContractImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getServiceContract()
	 * @generated
	 */
	int SERVICE_CONTRACT = 12;

	/**
	 * The feature id for the '<em><b>Base Collaboration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CONTRACT__BASE_COLLABORATION = COLLABORATION__BASE_COLLABORATION;

	/**
	 * The feature id for the '<em><b>Is Strict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CONTRACT__IS_STRICT = COLLABORATION__IS_STRICT;

	/**
	 * The number of structural features of the '<em>Service Contract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CONTRACT_FEATURE_COUNT = COLLABORATION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Role Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CONTRACT___ROLE_TYPE__DIAGNOSTICCHAIN_MAP = COLLABORATION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Attached Behavior Compatibility</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CONTRACT___ATTACHED_BEHAVIOR_COMPATIBILITY__DIAGNOSTICCHAIN_MAP = COLLABORATION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Service Contract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CONTRACT_OPERATION_COUNT = COLLABORATION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link SoaML.impl.RequestImpl <em>Request</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.RequestImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getRequest()
	 * @generated
	 */
	int REQUEST = 13;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__BASE_PORT = 0;

	/**
	 * The number of structural features of the '<em>Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Request Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST___REQUEST_TYPE__DIAGNOSTICCHAIN_MAP = 0;

	/**
	 * The operation id for the '<em>Is Conjugated True</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST___IS_CONJUGATED_TRUE__DIAGNOSTICCHAIN_MAP = 1;

	/**
	 * The number of operations of the '<em>Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link SoaML.impl.ConsumerImpl <em>Consumer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.ConsumerImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getConsumer()
	 * @generated
	 */
	int CONSUMER = 14;

	/**
	 * The feature id for the '<em><b>Base Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUMER__BASE_INTERFACE = 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUMER__BASE_CLASS = 1;

	/**
	 * The number of structural features of the '<em>Consumer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUMER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Consumer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSUMER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SoaML.impl.CatalogImpl <em>Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.CatalogImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getCatalog()
	 * @generated
	 */
	int CATALOG = 15;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG__BASE_ARTIFACT = NODE_DESCRIPTOR__BASE_ARTIFACT;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG__BASE_PACKAGE = NODE_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG_FEATURE_COUNT = NODE_DESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG_OPERATION_COUNT = NODE_DESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link SoaML.impl.CapabilityImpl <em>Capability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.CapabilityImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getCapability()
	 * @generated
	 */
	int CAPABILITY = 16;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Capability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Capability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SoaML.impl.CategorizationImpl <em>Categorization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.CategorizationImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getCategorization()
	 * @generated
	 */
	int CATEGORIZATION = 17;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORIZATION__BASE_DEPENDENCY = 0;

	/**
	 * The number of structural features of the '<em>Categorization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORIZATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Categorization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORIZATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SoaML.impl.MotivationRealizationImpl <em>Motivation Realization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.MotivationRealizationImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getMotivationRealization()
	 * @generated
	 */
	int MOTIVATION_REALIZATION = 18;

	/**
	 * The feature id for the '<em><b>Base Realization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTIVATION_REALIZATION__BASE_REALIZATION = 0;

	/**
	 * The number of structural features of the '<em>Motivation Realization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTIVATION_REALIZATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Motivation Realization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOTIVATION_REALIZATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SoaML.impl.ServiceInterfaceImpl <em>Service Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.ServiceInterfaceImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getServiceInterface()
	 * @generated
	 */
	int SERVICE_INTERFACE = 19;

	/**
	 * The feature id for the '<em><b>Base Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE__BASE_INTERFACE = 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE__BASE_CLASS = 1;

	/**
	 * The number of structural features of the '<em>Service Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Parts Types Of Service Interface</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE___PARTS_TYPES_OF_SERVICE_INTERFACE__DIAGNOSTICCHAIN_MAP = 0;

	/**
	 * The number of operations of the '<em>Service Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_INTERFACE_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link SoaML.impl.ServicesArchitectureImpl <em>Services Architecture</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.ServicesArchitectureImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getServicesArchitecture()
	 * @generated
	 */
	int SERVICES_ARCHITECTURE = 20;

	/**
	 * The feature id for the '<em><b>Base Collaboration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICES_ARCHITECTURE__BASE_COLLABORATION = COLLABORATION__BASE_COLLABORATION;

	/**
	 * The feature id for the '<em><b>Is Strict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICES_ARCHITECTURE__IS_STRICT = COLLABORATION__IS_STRICT;

	/**
	 * The number of structural features of the '<em>Services Architecture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICES_ARCHITECTURE_FEATURE_COUNT = COLLABORATION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Participants Role Compatibility</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICES_ARCHITECTURE___PARTICIPANTS_ROLE_COMPATIBILITY__DIAGNOSTICCHAIN_MAP = COLLABORATION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Parts Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICES_ARCHITECTURE___PARTS_TYPES__DIAGNOSTICCHAIN_MAP = COLLABORATION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Services Architecture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICES_ARCHITECTURE_OPERATION_COUNT = COLLABORATION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link SoaML.impl.AttachmentImpl <em>Attachment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.AttachmentImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getAttachment()
	 * @generated
	 */
	int ATTACHMENT = 21;

	/**
	 * The feature id for the '<em><b>Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT__ENCODING = 0;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT__BASE_PROPERTY = 1;

	/**
	 * The feature id for the '<em><b>Mimetype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT__MIMETYPE = 2;

	/**
	 * The number of structural features of the '<em>Attachment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Attachment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SoaML.impl.CollaborationUseImpl <em>Collaboration Use</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.CollaborationUseImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getCollaborationUse()
	 * @generated
	 */
	int COLLABORATION_USE = 22;

	/**
	 * The feature id for the '<em><b>Base Collaboration Use</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLABORATION_USE__BASE_COLLABORATION_USE = 0;

	/**
	 * The feature id for the '<em><b>Is Strict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLABORATION_USE__IS_STRICT = 1;

	/**
	 * The number of structural features of the '<em>Collaboration Use</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLABORATION_USE_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Role Binding Client Supplier Compatibility</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLABORATION_USE___ROLE_BINDING_CLIENT_SUPPLIER_COMPATIBILITY__DIAGNOSTICCHAIN_MAP = 0;

	/**
	 * The number of operations of the '<em>Collaboration Use</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLABORATION_USE_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link SoaML.impl.ServiceChannelImpl <em>Service Channel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.ServiceChannelImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getServiceChannel()
	 * @generated
	 */
	int SERVICE_CHANNEL = 23;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CHANNEL__BASE_CONNECTOR = 0;

	/**
	 * The number of structural features of the '<em>Service Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CHANNEL_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Onlybinaryconnectorsallowed</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CHANNEL___ONLYBINARYCONNECTORSALLOWED__DIAGNOSTICCHAIN_MAP = 0;

	/**
	 * The operation id for the '<em>Service Channel End Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CHANNEL___SERVICE_CHANNEL_END_TYPES__DIAGNOSTICCHAIN_MAP = 1;

	/**
	 * The operation id for the '<em>Compatibility</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CHANNEL___COMPATIBILITY__DIAGNOSTICCHAIN_MAP = 2;

	/**
	 * The number of operations of the '<em>Service Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CHANNEL_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link SoaML.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.ServiceImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 24;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__BASE_PORT = 0;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Service Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE___SERVICE_TYPE__DIAGNOSTICCHAIN_MAP = 0;

	/**
	 * The operation id for the '<em>Is Conjugated False</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE___IS_CONJUGATED_FALSE__DIAGNOSTICCHAIN_MAP = 1;

	/**
	 * The number of operations of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link SoaML.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.PortImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 25;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__BASE_PORT = 0;

	/**
	 * The feature id for the '<em><b>Connector Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__CONNECTOR_REQUIRED = 1;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Connector Required</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT___CONNECTOR_REQUIRED__DIAGNOSTICCHAIN_MAP = 0;

	/**
	 * The number of operations of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link SoaML.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.PropertyImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 26;

	/**
	 * The feature id for the '<em><b>Is ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_ID = 0;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__BASE_PROPERTY = 1;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SoaML.impl.ExposeImpl <em>Expose</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SoaML.impl.ExposeImpl
	 * @see SoaML.impl.SoaMLPackageImpl#getExpose()
	 * @generated
	 */
	int EXPOSE = 27;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPOSE__BASE_DEPENDENCY = 0;

	/**
	 * The number of structural features of the '<em>Expose</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPOSE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Expose</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPOSE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link SoaML.Agent <em>Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Agent</em>'.
	 * @see SoaML.Agent
	 * @generated
	 */
	EClass getAgent();

	/**
	 * Returns the meta object for the '{@link SoaML.Agent#isActive(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Is Active</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Active</em>' operation.
	 * @see SoaML.Agent#isActive(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getAgent__IsActive__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link SoaML.Participant <em>Participant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Participant</em>'.
	 * @see SoaML.Participant
	 * @generated
	 */
	EClass getParticipant();

	/**
	 * Returns the meta object for the reference '{@link SoaML.Participant#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see SoaML.Participant#getBase_Class()
	 * @see #getParticipant()
	 * @generated
	 */
	EReference getParticipant_Base_Class();

	/**
	 * Returns the meta object for the '{@link SoaML.Participant#noRealizedUsedInterface(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>No Realized Used Interface</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>No Realized Used Interface</em>' operation.
	 * @see SoaML.Participant#noRealizedUsedInterface(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getParticipant__NoRealizedUsedInterface__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link SoaML.Participant#portTypes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Port Types</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Port Types</em>' operation.
	 * @see SoaML.Participant#portTypes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getParticipant__PortTypes__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link SoaML.Collaboration <em>Collaboration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collaboration</em>'.
	 * @see SoaML.Collaboration
	 * @generated
	 */
	EClass getCollaboration();

	/**
	 * Returns the meta object for the reference '{@link SoaML.Collaboration#getBase_Collaboration <em>Base Collaboration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Collaboration</em>'.
	 * @see SoaML.Collaboration#getBase_Collaboration()
	 * @see #getCollaboration()
	 * @generated
	 */
	EReference getCollaboration_Base_Collaboration();

	/**
	 * Returns the meta object for the attribute '{@link SoaML.Collaboration#isStrict <em>Is Strict</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Strict</em>'.
	 * @see SoaML.Collaboration#isStrict()
	 * @see #getCollaboration()
	 * @generated
	 */
	EAttribute getCollaboration_IsStrict();

	/**
	 * Returns the meta object for class '{@link SoaML.MotivationElement <em>Motivation Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Motivation Element</em>'.
	 * @see SoaML.MotivationElement
	 * @generated
	 */
	EClass getMotivationElement();

	/**
	 * Returns the meta object for class '{@link SoaML.Provider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Provider</em>'.
	 * @see SoaML.Provider
	 * @generated
	 */
	EClass getProvider();

	/**
	 * Returns the meta object for the reference '{@link SoaML.Provider#getBase_Interface <em>Base Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Interface</em>'.
	 * @see SoaML.Provider#getBase_Interface()
	 * @see #getProvider()
	 * @generated
	 */
	EReference getProvider_Base_Interface();

	/**
	 * Returns the meta object for the reference '{@link SoaML.Provider#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see SoaML.Provider#getBase_Class()
	 * @see #getProvider()
	 * @generated
	 */
	EReference getProvider_Base_Class();

	/**
	 * Returns the meta object for class '{@link SoaML.FreeFormValue <em>Free Form Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Free Form Value</em>'.
	 * @see SoaML.FreeFormValue
	 * @generated
	 */
	EClass getFreeFormValue();

	/**
	 * Returns the meta object for the reference '{@link SoaML.FreeFormValue#getBase_ValueSpecification <em>Base Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Value Specification</em>'.
	 * @see SoaML.FreeFormValue#getBase_ValueSpecification()
	 * @see #getFreeFormValue()
	 * @generated
	 */
	EReference getFreeFormValue_Base_ValueSpecification();

	/**
	 * Returns the meta object for class '{@link SoaML.MessageType <em>Message Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Type</em>'.
	 * @see SoaML.MessageType
	 * @generated
	 */
	EClass getMessageType();

	/**
	 * Returns the meta object for the reference '{@link SoaML.MessageType#getBase_Signal <em>Base Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Signal</em>'.
	 * @see SoaML.MessageType#getBase_Signal()
	 * @see #getMessageType()
	 * @generated
	 */
	EReference getMessageType_Base_Signal();

	/**
	 * Returns the meta object for the attribute '{@link SoaML.MessageType#getEncoding <em>Encoding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Encoding</em>'.
	 * @see SoaML.MessageType#getEncoding()
	 * @see #getMessageType()
	 * @generated
	 */
	EAttribute getMessageType_Encoding();

	/**
	 * Returns the meta object for the reference '{@link SoaML.MessageType#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see SoaML.MessageType#getBase_Class()
	 * @see #getMessageType()
	 * @generated
	 */
	EReference getMessageType_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link SoaML.MessageType#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see SoaML.MessageType#getBase_DataType()
	 * @see #getMessageType()
	 * @generated
	 */
	EReference getMessageType_Base_DataType();

	/**
	 * Returns the meta object for the '{@link SoaML.MessageType#noOwnedBehaviors(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>No Owned Behaviors</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>No Owned Behaviors</em>' operation.
	 * @see SoaML.MessageType#noOwnedBehaviors(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMessageType__NoOwnedBehaviors__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link SoaML.MessageType#noOwnedOperations(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>No Owned Operations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>No Owned Operations</em>' operation.
	 * @see SoaML.MessageType#noOwnedOperations(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMessageType__NoOwnedOperations__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link SoaML.MessageType#publicAttributes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Public Attributes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Public Attributes</em>' operation.
	 * @see SoaML.MessageType#publicAttributes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMessageType__PublicAttributes__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link SoaML.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category</em>'.
	 * @see SoaML.Category
	 * @generated
	 */
	EClass getCategory();

	/**
	 * Returns the meta object for class '{@link SoaML.NodeDescriptor <em>Node Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Descriptor</em>'.
	 * @see SoaML.NodeDescriptor
	 * @generated
	 */
	EClass getNodeDescriptor();

	/**
	 * Returns the meta object for the reference '{@link SoaML.NodeDescriptor#getBase_Artifact <em>Base Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Artifact</em>'.
	 * @see SoaML.NodeDescriptor#getBase_Artifact()
	 * @see #getNodeDescriptor()
	 * @generated
	 */
	EReference getNodeDescriptor_Base_Artifact();

	/**
	 * Returns the meta object for class '{@link SoaML.Milestone <em>Milestone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Milestone</em>'.
	 * @see SoaML.Milestone
	 * @generated
	 */
	EClass getMilestone();

	/**
	 * Returns the meta object for the reference '{@link SoaML.Milestone#getSignal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signal</em>'.
	 * @see SoaML.Milestone#getSignal()
	 * @see #getMilestone()
	 * @generated
	 */
	EReference getMilestone_Signal();

	/**
	 * Returns the meta object for the attribute '{@link SoaML.Milestone#getProgress <em>Progress</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Progress</em>'.
	 * @see SoaML.Milestone#getProgress()
	 * @see #getMilestone()
	 * @generated
	 */
	EAttribute getMilestone_Progress();

	/**
	 * Returns the meta object for the reference list '{@link SoaML.Milestone#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Value</em>'.
	 * @see SoaML.Milestone#getValue()
	 * @see #getMilestone()
	 * @generated
	 */
	EReference getMilestone_Value();

	/**
	 * Returns the meta object for the reference '{@link SoaML.Milestone#getBase_Comment <em>Base Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Comment</em>'.
	 * @see SoaML.Milestone#getBase_Comment()
	 * @see #getMilestone()
	 * @generated
	 */
	EReference getMilestone_Base_Comment();

	/**
	 * Returns the meta object for class '{@link SoaML.FreeFormDescriptor <em>Free Form Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Free Form Descriptor</em>'.
	 * @see SoaML.FreeFormDescriptor
	 * @generated
	 */
	EClass getFreeFormDescriptor();

	/**
	 * Returns the meta object for the reference '{@link SoaML.FreeFormDescriptor#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see SoaML.FreeFormDescriptor#getBase_Property()
	 * @see #getFreeFormDescriptor()
	 * @generated
	 */
	EReference getFreeFormDescriptor_Base_Property();

	/**
	 * Returns the meta object for class '{@link SoaML.CategoryValue <em>Category Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category Value</em>'.
	 * @see SoaML.CategoryValue
	 * @generated
	 */
	EClass getCategoryValue();

	/**
	 * Returns the meta object for class '{@link SoaML.ServiceContract <em>Service Contract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Contract</em>'.
	 * @see SoaML.ServiceContract
	 * @generated
	 */
	EClass getServiceContract();

	/**
	 * Returns the meta object for the '{@link SoaML.ServiceContract#RoleType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Role Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Role Type</em>' operation.
	 * @see SoaML.ServiceContract#RoleType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getServiceContract__RoleType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link SoaML.ServiceContract#AttachedBehaviorCompatibility(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Attached Behavior Compatibility</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Attached Behavior Compatibility</em>' operation.
	 * @see SoaML.ServiceContract#AttachedBehaviorCompatibility(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getServiceContract__AttachedBehaviorCompatibility__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link SoaML.Request <em>Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Request</em>'.
	 * @see SoaML.Request
	 * @generated
	 */
	EClass getRequest();

	/**
	 * Returns the meta object for the reference '{@link SoaML.Request#getBase_Port <em>Base Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Port</em>'.
	 * @see SoaML.Request#getBase_Port()
	 * @see #getRequest()
	 * @generated
	 */
	EReference getRequest_Base_Port();

	/**
	 * Returns the meta object for the '{@link SoaML.Request#requestType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Request Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Request Type</em>' operation.
	 * @see SoaML.Request#requestType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRequest__RequestType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link SoaML.Request#isConjugatedTrue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Is Conjugated True</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Conjugated True</em>' operation.
	 * @see SoaML.Request#isConjugatedTrue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRequest__IsConjugatedTrue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link SoaML.Consumer <em>Consumer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Consumer</em>'.
	 * @see SoaML.Consumer
	 * @generated
	 */
	EClass getConsumer();

	/**
	 * Returns the meta object for the reference '{@link SoaML.Consumer#getBase_Interface <em>Base Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Interface</em>'.
	 * @see SoaML.Consumer#getBase_Interface()
	 * @see #getConsumer()
	 * @generated
	 */
	EReference getConsumer_Base_Interface();

	/**
	 * Returns the meta object for the reference '{@link SoaML.Consumer#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see SoaML.Consumer#getBase_Class()
	 * @see #getConsumer()
	 * @generated
	 */
	EReference getConsumer_Base_Class();

	/**
	 * Returns the meta object for class '{@link SoaML.Catalog <em>Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Catalog</em>'.
	 * @see SoaML.Catalog
	 * @generated
	 */
	EClass getCatalog();

	/**
	 * Returns the meta object for the reference '{@link SoaML.Catalog#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see SoaML.Catalog#getBase_Package()
	 * @see #getCatalog()
	 * @generated
	 */
	EReference getCatalog_Base_Package();

	/**
	 * Returns the meta object for class '{@link SoaML.Capability <em>Capability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Capability</em>'.
	 * @see SoaML.Capability
	 * @generated
	 */
	EClass getCapability();

	/**
	 * Returns the meta object for the reference '{@link SoaML.Capability#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see SoaML.Capability#getBase_Class()
	 * @see #getCapability()
	 * @generated
	 */
	EReference getCapability_Base_Class();

	/**
	 * Returns the meta object for class '{@link SoaML.Categorization <em>Categorization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Categorization</em>'.
	 * @see SoaML.Categorization
	 * @generated
	 */
	EClass getCategorization();

	/**
	 * Returns the meta object for the reference '{@link SoaML.Categorization#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see SoaML.Categorization#getBase_Dependency()
	 * @see #getCategorization()
	 * @generated
	 */
	EReference getCategorization_Base_Dependency();

	/**
	 * Returns the meta object for class '{@link SoaML.MotivationRealization <em>Motivation Realization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Motivation Realization</em>'.
	 * @see SoaML.MotivationRealization
	 * @generated
	 */
	EClass getMotivationRealization();

	/**
	 * Returns the meta object for the reference '{@link SoaML.MotivationRealization#getBase_Realization <em>Base Realization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Realization</em>'.
	 * @see SoaML.MotivationRealization#getBase_Realization()
	 * @see #getMotivationRealization()
	 * @generated
	 */
	EReference getMotivationRealization_Base_Realization();

	/**
	 * Returns the meta object for class '{@link SoaML.ServiceInterface <em>Service Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Interface</em>'.
	 * @see SoaML.ServiceInterface
	 * @generated
	 */
	EClass getServiceInterface();

	/**
	 * Returns the meta object for the reference '{@link SoaML.ServiceInterface#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see SoaML.ServiceInterface#getBase_Class()
	 * @see #getServiceInterface()
	 * @generated
	 */
	EReference getServiceInterface_Base_Class();

	/**
	 * Returns the meta object for the '{@link SoaML.ServiceInterface#partsTypesOfServiceInterface(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Parts Types Of Service Interface</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Parts Types Of Service Interface</em>' operation.
	 * @see SoaML.ServiceInterface#partsTypesOfServiceInterface(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getServiceInterface__PartsTypesOfServiceInterface__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the reference '{@link SoaML.ServiceInterface#getBase_Interface <em>Base Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Interface</em>'.
	 * @see SoaML.ServiceInterface#getBase_Interface()
	 * @see #getServiceInterface()
	 * @generated
	 */
	EReference getServiceInterface_Base_Interface();

	/**
	 * Returns the meta object for class '{@link SoaML.ServicesArchitecture <em>Services Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Services Architecture</em>'.
	 * @see SoaML.ServicesArchitecture
	 * @generated
	 */
	EClass getServicesArchitecture();

	/**
	 * Returns the meta object for the '{@link SoaML.ServicesArchitecture#participantsRoleCompatibility(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Participants Role Compatibility</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Participants Role Compatibility</em>' operation.
	 * @see SoaML.ServicesArchitecture#participantsRoleCompatibility(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getServicesArchitecture__ParticipantsRoleCompatibility__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link SoaML.ServicesArchitecture#partsTypes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Parts Types</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Parts Types</em>' operation.
	 * @see SoaML.ServicesArchitecture#partsTypes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getServicesArchitecture__PartsTypes__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link SoaML.Attachment <em>Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attachment</em>'.
	 * @see SoaML.Attachment
	 * @generated
	 */
	EClass getAttachment();

	/**
	 * Returns the meta object for the attribute '{@link SoaML.Attachment#getEncoding <em>Encoding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Encoding</em>'.
	 * @see SoaML.Attachment#getEncoding()
	 * @see #getAttachment()
	 * @generated
	 */
	EAttribute getAttachment_Encoding();

	/**
	 * Returns the meta object for the reference '{@link SoaML.Attachment#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see SoaML.Attachment#getBase_Property()
	 * @see #getAttachment()
	 * @generated
	 */
	EReference getAttachment_Base_Property();

	/**
	 * Returns the meta object for the attribute '{@link SoaML.Attachment#getMimetype <em>Mimetype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mimetype</em>'.
	 * @see SoaML.Attachment#getMimetype()
	 * @see #getAttachment()
	 * @generated
	 */
	EAttribute getAttachment_Mimetype();

	/**
	 * Returns the meta object for class '{@link SoaML.CollaborationUse <em>Collaboration Use</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collaboration Use</em>'.
	 * @see SoaML.CollaborationUse
	 * @generated
	 */
	EClass getCollaborationUse();

	/**
	 * Returns the meta object for the reference '{@link SoaML.CollaborationUse#getBase_CollaborationUse <em>Base Collaboration Use</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Collaboration Use</em>'.
	 * @see SoaML.CollaborationUse#getBase_CollaborationUse()
	 * @see #getCollaborationUse()
	 * @generated
	 */
	EReference getCollaborationUse_Base_CollaborationUse();

	/**
	 * Returns the meta object for the attribute '{@link SoaML.CollaborationUse#isStrict <em>Is Strict</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Strict</em>'.
	 * @see SoaML.CollaborationUse#isStrict()
	 * @see #getCollaborationUse()
	 * @generated
	 */
	EAttribute getCollaborationUse_IsStrict();

	/**
	 * Returns the meta object for the '{@link SoaML.CollaborationUse#RoleBindingClientSupplierCompatibility(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Role Binding Client Supplier Compatibility</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Role Binding Client Supplier Compatibility</em>' operation.
	 * @see SoaML.CollaborationUse#RoleBindingClientSupplierCompatibility(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCollaborationUse__RoleBindingClientSupplierCompatibility__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link SoaML.ServiceChannel <em>Service Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Channel</em>'.
	 * @see SoaML.ServiceChannel
	 * @generated
	 */
	EClass getServiceChannel();

	/**
	 * Returns the meta object for the reference '{@link SoaML.ServiceChannel#getBase_Connector <em>Base Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Connector</em>'.
	 * @see SoaML.ServiceChannel#getBase_Connector()
	 * @see #getServiceChannel()
	 * @generated
	 */
	EReference getServiceChannel_Base_Connector();

	/**
	 * Returns the meta object for the '{@link SoaML.ServiceChannel#Onlybinaryconnectorsallowed(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Onlybinaryconnectorsallowed</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Onlybinaryconnectorsallowed</em>' operation.
	 * @see SoaML.ServiceChannel#Onlybinaryconnectorsallowed(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getServiceChannel__Onlybinaryconnectorsallowed__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link SoaML.ServiceChannel#serviceChannelEndTypes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Service Channel End Types</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Service Channel End Types</em>' operation.
	 * @see SoaML.ServiceChannel#serviceChannelEndTypes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getServiceChannel__ServiceChannelEndTypes__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link SoaML.ServiceChannel#Compatibility(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Compatibility</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Compatibility</em>' operation.
	 * @see SoaML.ServiceChannel#Compatibility(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getServiceChannel__Compatibility__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link SoaML.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see SoaML.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the reference '{@link SoaML.Service#getBase_Port <em>Base Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Port</em>'.
	 * @see SoaML.Service#getBase_Port()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Base_Port();

	/**
	 * Returns the meta object for the '{@link SoaML.Service#serviceType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Service Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Service Type</em>' operation.
	 * @see SoaML.Service#serviceType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getService__ServiceType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link SoaML.Service#isConjugatedFalse(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Is Conjugated False</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Conjugated False</em>' operation.
	 * @see SoaML.Service#isConjugatedFalse(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getService__IsConjugatedFalse__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link SoaML.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see SoaML.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the reference '{@link SoaML.Port#getBase_Port <em>Base Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Port</em>'.
	 * @see SoaML.Port#getBase_Port()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Base_Port();

	/**
	 * Returns the meta object for the attribute '{@link SoaML.Port#isConnectorRequired <em>Connector Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connector Required</em>'.
	 * @see SoaML.Port#isConnectorRequired()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_ConnectorRequired();

	/**
	 * Returns the meta object for the '{@link SoaML.Port#connectorRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Connector Required</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Connector Required</em>' operation.
	 * @see SoaML.Port#connectorRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getPort__ConnectorRequired__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link SoaML.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see SoaML.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link SoaML.Property#isID <em>Is ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is ID</em>'.
	 * @see SoaML.Property#isID()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsID();

	/**
	 * Returns the meta object for the reference '{@link SoaML.Property#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see SoaML.Property#getBase_Property()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_Base_Property();

	/**
	 * Returns the meta object for class '{@link SoaML.Expose <em>Expose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expose</em>'.
	 * @see SoaML.Expose
	 * @generated
	 */
	EClass getExpose();

	/**
	 * Returns the meta object for the reference '{@link SoaML.Expose#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see SoaML.Expose#getBase_Dependency()
	 * @see #getExpose()
	 * @generated
	 */
	EReference getExpose_Base_Dependency();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SoaMLFactory getSoaMLFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link SoaML.impl.AgentImpl <em>Agent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.AgentImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getAgent()
		 * @generated
		 */
		EClass AGENT = eINSTANCE.getAgent();

		/**
		 * The meta object literal for the '<em><b>Is Active</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation AGENT___IS_ACTIVE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getAgent__IsActive__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link SoaML.impl.ParticipantImpl <em>Participant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.ParticipantImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getParticipant()
		 * @generated
		 */
		EClass PARTICIPANT = eINSTANCE.getParticipant();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTICIPANT__BASE_CLASS = eINSTANCE.getParticipant_Base_Class();

		/**
		 * The meta object literal for the '<em><b>No Realized Used Interface</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARTICIPANT___NO_REALIZED_USED_INTERFACE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getParticipant__NoRealizedUsedInterface__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Port Types</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARTICIPANT___PORT_TYPES__DIAGNOSTICCHAIN_MAP = eINSTANCE.getParticipant__PortTypes__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link SoaML.impl.CollaborationImpl <em>Collaboration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.CollaborationImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getCollaboration()
		 * @generated
		 */
		EClass COLLABORATION = eINSTANCE.getCollaboration();

		/**
		 * The meta object literal for the '<em><b>Base Collaboration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLABORATION__BASE_COLLABORATION = eINSTANCE.getCollaboration_Base_Collaboration();

		/**
		 * The meta object literal for the '<em><b>Is Strict</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLABORATION__IS_STRICT = eINSTANCE.getCollaboration_IsStrict();

		/**
		 * The meta object literal for the '{@link SoaML.impl.MotivationElementImpl <em>Motivation Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.MotivationElementImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getMotivationElement()
		 * @generated
		 */
		EClass MOTIVATION_ELEMENT = eINSTANCE.getMotivationElement();

		/**
		 * The meta object literal for the '{@link SoaML.impl.ProviderImpl <em>Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.ProviderImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getProvider()
		 * @generated
		 */
		EClass PROVIDER = eINSTANCE.getProvider();

		/**
		 * The meta object literal for the '<em><b>Base Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROVIDER__BASE_INTERFACE = eINSTANCE.getProvider_Base_Interface();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROVIDER__BASE_CLASS = eINSTANCE.getProvider_Base_Class();

		/**
		 * The meta object literal for the '{@link SoaML.impl.FreeFormValueImpl <em>Free Form Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.FreeFormValueImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getFreeFormValue()
		 * @generated
		 */
		EClass FREE_FORM_VALUE = eINSTANCE.getFreeFormValue();

		/**
		 * The meta object literal for the '<em><b>Base Value Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FREE_FORM_VALUE__BASE_VALUE_SPECIFICATION = eINSTANCE.getFreeFormValue_Base_ValueSpecification();

		/**
		 * The meta object literal for the '{@link SoaML.impl.MessageTypeImpl <em>Message Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.MessageTypeImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getMessageType()
		 * @generated
		 */
		EClass MESSAGE_TYPE = eINSTANCE.getMessageType();

		/**
		 * The meta object literal for the '<em><b>Base Signal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_TYPE__BASE_SIGNAL = eINSTANCE.getMessageType_Base_Signal();

		/**
		 * The meta object literal for the '<em><b>Encoding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_TYPE__ENCODING = eINSTANCE.getMessageType_Encoding();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_TYPE__BASE_CLASS = eINSTANCE.getMessageType_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Base Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_TYPE__BASE_DATA_TYPE = eINSTANCE.getMessageType_Base_DataType();

		/**
		 * The meta object literal for the '<em><b>No Owned Behaviors</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MESSAGE_TYPE___NO_OWNED_BEHAVIORS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMessageType__NoOwnedBehaviors__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>No Owned Operations</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MESSAGE_TYPE___NO_OWNED_OPERATIONS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMessageType__NoOwnedOperations__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Public Attributes</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MESSAGE_TYPE___PUBLIC_ATTRIBUTES__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMessageType__PublicAttributes__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link SoaML.impl.CategoryImpl <em>Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.CategoryImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getCategory()
		 * @generated
		 */
		EClass CATEGORY = eINSTANCE.getCategory();

		/**
		 * The meta object literal for the '{@link SoaML.impl.NodeDescriptorImpl <em>Node Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.NodeDescriptorImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getNodeDescriptor()
		 * @generated
		 */
		EClass NODE_DESCRIPTOR = eINSTANCE.getNodeDescriptor();

		/**
		 * The meta object literal for the '<em><b>Base Artifact</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_DESCRIPTOR__BASE_ARTIFACT = eINSTANCE.getNodeDescriptor_Base_Artifact();

		/**
		 * The meta object literal for the '{@link SoaML.impl.MilestoneImpl <em>Milestone</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.MilestoneImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getMilestone()
		 * @generated
		 */
		EClass MILESTONE = eINSTANCE.getMilestone();

		/**
		 * The meta object literal for the '<em><b>Signal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MILESTONE__SIGNAL = eINSTANCE.getMilestone_Signal();

		/**
		 * The meta object literal for the '<em><b>Progress</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MILESTONE__PROGRESS = eINSTANCE.getMilestone_Progress();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MILESTONE__VALUE = eINSTANCE.getMilestone_Value();

		/**
		 * The meta object literal for the '<em><b>Base Comment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MILESTONE__BASE_COMMENT = eINSTANCE.getMilestone_Base_Comment();

		/**
		 * The meta object literal for the '{@link SoaML.impl.FreeFormDescriptorImpl <em>Free Form Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.FreeFormDescriptorImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getFreeFormDescriptor()
		 * @generated
		 */
		EClass FREE_FORM_DESCRIPTOR = eINSTANCE.getFreeFormDescriptor();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FREE_FORM_DESCRIPTOR__BASE_PROPERTY = eINSTANCE.getFreeFormDescriptor_Base_Property();

		/**
		 * The meta object literal for the '{@link SoaML.impl.CategoryValueImpl <em>Category Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.CategoryValueImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getCategoryValue()
		 * @generated
		 */
		EClass CATEGORY_VALUE = eINSTANCE.getCategoryValue();

		/**
		 * The meta object literal for the '{@link SoaML.impl.ServiceContractImpl <em>Service Contract</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.ServiceContractImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getServiceContract()
		 * @generated
		 */
		EClass SERVICE_CONTRACT = eINSTANCE.getServiceContract();

		/**
		 * The meta object literal for the '<em><b>Role Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SERVICE_CONTRACT___ROLE_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getServiceContract__RoleType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Attached Behavior Compatibility</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SERVICE_CONTRACT___ATTACHED_BEHAVIOR_COMPATIBILITY__DIAGNOSTICCHAIN_MAP = eINSTANCE.getServiceContract__AttachedBehaviorCompatibility__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link SoaML.impl.RequestImpl <em>Request</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.RequestImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getRequest()
		 * @generated
		 */
		EClass REQUEST = eINSTANCE.getRequest();

		/**
		 * The meta object literal for the '<em><b>Base Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUEST__BASE_PORT = eINSTANCE.getRequest_Base_Port();

		/**
		 * The meta object literal for the '<em><b>Request Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REQUEST___REQUEST_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRequest__RequestType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Is Conjugated True</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REQUEST___IS_CONJUGATED_TRUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRequest__IsConjugatedTrue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link SoaML.impl.ConsumerImpl <em>Consumer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.ConsumerImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getConsumer()
		 * @generated
		 */
		EClass CONSUMER = eINSTANCE.getConsumer();

		/**
		 * The meta object literal for the '<em><b>Base Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSUMER__BASE_INTERFACE = eINSTANCE.getConsumer_Base_Interface();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSUMER__BASE_CLASS = eINSTANCE.getConsumer_Base_Class();

		/**
		 * The meta object literal for the '{@link SoaML.impl.CatalogImpl <em>Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.CatalogImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getCatalog()
		 * @generated
		 */
		EClass CATALOG = eINSTANCE.getCatalog();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATALOG__BASE_PACKAGE = eINSTANCE.getCatalog_Base_Package();

		/**
		 * The meta object literal for the '{@link SoaML.impl.CapabilityImpl <em>Capability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.CapabilityImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getCapability()
		 * @generated
		 */
		EClass CAPABILITY = eINSTANCE.getCapability();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAPABILITY__BASE_CLASS = eINSTANCE.getCapability_Base_Class();

		/**
		 * The meta object literal for the '{@link SoaML.impl.CategorizationImpl <em>Categorization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.CategorizationImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getCategorization()
		 * @generated
		 */
		EClass CATEGORIZATION = eINSTANCE.getCategorization();

		/**
		 * The meta object literal for the '<em><b>Base Dependency</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATEGORIZATION__BASE_DEPENDENCY = eINSTANCE.getCategorization_Base_Dependency();

		/**
		 * The meta object literal for the '{@link SoaML.impl.MotivationRealizationImpl <em>Motivation Realization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.MotivationRealizationImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getMotivationRealization()
		 * @generated
		 */
		EClass MOTIVATION_REALIZATION = eINSTANCE.getMotivationRealization();

		/**
		 * The meta object literal for the '<em><b>Base Realization</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOTIVATION_REALIZATION__BASE_REALIZATION = eINSTANCE.getMotivationRealization_Base_Realization();

		/**
		 * The meta object literal for the '{@link SoaML.impl.ServiceInterfaceImpl <em>Service Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.ServiceInterfaceImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getServiceInterface()
		 * @generated
		 */
		EClass SERVICE_INTERFACE = eINSTANCE.getServiceInterface();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_INTERFACE__BASE_CLASS = eINSTANCE.getServiceInterface_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Parts Types Of Service Interface</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SERVICE_INTERFACE___PARTS_TYPES_OF_SERVICE_INTERFACE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getServiceInterface__PartsTypesOfServiceInterface__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Base Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_INTERFACE__BASE_INTERFACE = eINSTANCE.getServiceInterface_Base_Interface();

		/**
		 * The meta object literal for the '{@link SoaML.impl.ServicesArchitectureImpl <em>Services Architecture</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.ServicesArchitectureImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getServicesArchitecture()
		 * @generated
		 */
		EClass SERVICES_ARCHITECTURE = eINSTANCE.getServicesArchitecture();

		/**
		 * The meta object literal for the '<em><b>Participants Role Compatibility</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SERVICES_ARCHITECTURE___PARTICIPANTS_ROLE_COMPATIBILITY__DIAGNOSTICCHAIN_MAP = eINSTANCE.getServicesArchitecture__ParticipantsRoleCompatibility__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Parts Types</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SERVICES_ARCHITECTURE___PARTS_TYPES__DIAGNOSTICCHAIN_MAP = eINSTANCE.getServicesArchitecture__PartsTypes__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link SoaML.impl.AttachmentImpl <em>Attachment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.AttachmentImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getAttachment()
		 * @generated
		 */
		EClass ATTACHMENT = eINSTANCE.getAttachment();

		/**
		 * The meta object literal for the '<em><b>Encoding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHMENT__ENCODING = eINSTANCE.getAttachment_Encoding();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACHMENT__BASE_PROPERTY = eINSTANCE.getAttachment_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Mimetype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHMENT__MIMETYPE = eINSTANCE.getAttachment_Mimetype();

		/**
		 * The meta object literal for the '{@link SoaML.impl.CollaborationUseImpl <em>Collaboration Use</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.CollaborationUseImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getCollaborationUse()
		 * @generated
		 */
		EClass COLLABORATION_USE = eINSTANCE.getCollaborationUse();

		/**
		 * The meta object literal for the '<em><b>Base Collaboration Use</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLABORATION_USE__BASE_COLLABORATION_USE = eINSTANCE.getCollaborationUse_Base_CollaborationUse();

		/**
		 * The meta object literal for the '<em><b>Is Strict</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLABORATION_USE__IS_STRICT = eINSTANCE.getCollaborationUse_IsStrict();

		/**
		 * The meta object literal for the '<em><b>Role Binding Client Supplier Compatibility</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COLLABORATION_USE___ROLE_BINDING_CLIENT_SUPPLIER_COMPATIBILITY__DIAGNOSTICCHAIN_MAP = eINSTANCE.getCollaborationUse__RoleBindingClientSupplierCompatibility__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link SoaML.impl.ServiceChannelImpl <em>Service Channel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.ServiceChannelImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getServiceChannel()
		 * @generated
		 */
		EClass SERVICE_CHANNEL = eINSTANCE.getServiceChannel();

		/**
		 * The meta object literal for the '<em><b>Base Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_CHANNEL__BASE_CONNECTOR = eINSTANCE.getServiceChannel_Base_Connector();

		/**
		 * The meta object literal for the '<em><b>Onlybinaryconnectorsallowed</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SERVICE_CHANNEL___ONLYBINARYCONNECTORSALLOWED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getServiceChannel__Onlybinaryconnectorsallowed__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Service Channel End Types</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SERVICE_CHANNEL___SERVICE_CHANNEL_END_TYPES__DIAGNOSTICCHAIN_MAP = eINSTANCE.getServiceChannel__ServiceChannelEndTypes__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Compatibility</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SERVICE_CHANNEL___COMPATIBILITY__DIAGNOSTICCHAIN_MAP = eINSTANCE.getServiceChannel__Compatibility__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link SoaML.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.ServiceImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Base Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__BASE_PORT = eINSTANCE.getService_Base_Port();

		/**
		 * The meta object literal for the '<em><b>Service Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SERVICE___SERVICE_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getService__ServiceType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Is Conjugated False</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SERVICE___IS_CONJUGATED_FALSE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getService__IsConjugatedFalse__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link SoaML.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.PortImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Base Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__BASE_PORT = eINSTANCE.getPort_Base_Port();

		/**
		 * The meta object literal for the '<em><b>Connector Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__CONNECTOR_REQUIRED = eINSTANCE.getPort_ConnectorRequired();

		/**
		 * The meta object literal for the '<em><b>Connector Required</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PORT___CONNECTOR_REQUIRED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getPort__ConnectorRequired__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link SoaML.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.PropertyImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Is ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_ID = eINSTANCE.getProperty_IsID();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__BASE_PROPERTY = eINSTANCE.getProperty_Base_Property();

		/**
		 * The meta object literal for the '{@link SoaML.impl.ExposeImpl <em>Expose</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SoaML.impl.ExposeImpl
		 * @see SoaML.impl.SoaMLPackageImpl#getExpose()
		 * @generated
		 */
		EClass EXPOSE = eINSTANCE.getExpose();

		/**
		 * The meta object literal for the '<em><b>Base Dependency</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPOSE__BASE_DEPENDENCY = eINSTANCE.getExpose_Base_Dependency();

	}

} //SoaMLPackage
