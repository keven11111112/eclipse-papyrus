/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfileFactory
 * @model kind="package"
 * @generated
 */
public interface BPMNProfilePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "BPMNProfile";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.omg.org/spec/BPMNProfile/20121112/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "BPMNProfile";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BPMNProfilePackage eINSTANCE = org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BaseElementImpl <em>Base Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BaseElementImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getBaseElement()
	 * @generated
	 */
	int BASE_ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_ELEMENT__ID = 0;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_ELEMENT__EXTENSION_VALUES = 1;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_ELEMENT__BASE_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_ELEMENT__DOCUMENTATION = 3;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_ELEMENT__EXTENSION_DEFINITIONS = 4;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_ELEMENT__OUTGOING = 5;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_ELEMENT__INCOMING = 6;

	/**
	 * The number of structural features of the '<em>Base Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_ELEMENT_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Base Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.FlowElementImpl <em>Flow Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.FlowElementImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getFlowElement()
	 * @generated
	 */
	int FLOW_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT__AUDITING = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT__MONITORING = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT__CATEGORY_VALUE_REF = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT__CONTAINER = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Flow Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Flow Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENT_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.FlowNodeImpl <em>Flow Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.FlowNodeImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getFlowNode()
	 * @generated
	 */
	int FLOW_NODE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_NODE__ID = FLOW_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_NODE__EXTENSION_VALUES = FLOW_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_NODE__BASE_ELEMENT = FLOW_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_NODE__DOCUMENTATION = FLOW_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_NODE__EXTENSION_DEFINITIONS = FLOW_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_NODE__OUTGOING = FLOW_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_NODE__INCOMING = FLOW_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_NODE__AUDITING = FLOW_ELEMENT__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_NODE__MONITORING = FLOW_ELEMENT__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_NODE__CATEGORY_VALUE_REF = FLOW_ELEMENT__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_NODE__CONTAINER = FLOW_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_NODE__BASE_ACTIVITY_NODE = FLOW_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Flow Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_NODE_FEATURE_COUNT = FLOW_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Flow Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_NODE_OPERATION_COUNT = FLOW_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.GatewayImpl <em>Gateway</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.GatewayImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getGateway()
	 * @generated
	 */
	int GATEWAY = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__ID = FLOW_NODE__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__EXTENSION_VALUES = FLOW_NODE__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__BASE_ELEMENT = FLOW_NODE__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__DOCUMENTATION = FLOW_NODE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__EXTENSION_DEFINITIONS = FLOW_NODE__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__OUTGOING = FLOW_NODE__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__INCOMING = FLOW_NODE__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__AUDITING = FLOW_NODE__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__MONITORING = FLOW_NODE__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__CATEGORY_VALUE_REF = FLOW_NODE__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__CONTAINER = FLOW_NODE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__BASE_ACTIVITY_NODE = FLOW_NODE__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Base Control Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__BASE_CONTROL_NODE = FLOW_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Activity Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__BASE_ACTIVITY_GROUP = FLOW_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Gateway</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY_FEATURE_COUNT = FLOW_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Gateway</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY_OPERATION_COUNT = FLOW_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.NonExclusiveGatewayImpl <em>Non Exclusive Gateway</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.NonExclusiveGatewayImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getNonExclusiveGateway()
	 * @generated
	 */
	int NON_EXCLUSIVE_GATEWAY = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EXCLUSIVE_GATEWAY__ID = GATEWAY__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EXCLUSIVE_GATEWAY__EXTENSION_VALUES = GATEWAY__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EXCLUSIVE_GATEWAY__BASE_ELEMENT = GATEWAY__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EXCLUSIVE_GATEWAY__DOCUMENTATION = GATEWAY__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EXCLUSIVE_GATEWAY__EXTENSION_DEFINITIONS = GATEWAY__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EXCLUSIVE_GATEWAY__OUTGOING = GATEWAY__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EXCLUSIVE_GATEWAY__INCOMING = GATEWAY__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EXCLUSIVE_GATEWAY__AUDITING = GATEWAY__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EXCLUSIVE_GATEWAY__MONITORING = GATEWAY__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EXCLUSIVE_GATEWAY__CATEGORY_VALUE_REF = GATEWAY__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EXCLUSIVE_GATEWAY__CONTAINER = GATEWAY__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EXCLUSIVE_GATEWAY__BASE_ACTIVITY_NODE = GATEWAY__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Base Control Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EXCLUSIVE_GATEWAY__BASE_CONTROL_NODE = GATEWAY__BASE_CONTROL_NODE;

	/**
	 * The feature id for the '<em><b>Base Activity Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EXCLUSIVE_GATEWAY__BASE_ACTIVITY_GROUP = GATEWAY__BASE_ACTIVITY_GROUP;

	/**
	 * The feature id for the '<em><b>Base Join Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EXCLUSIVE_GATEWAY__BASE_JOIN_NODE = GATEWAY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Fork Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EXCLUSIVE_GATEWAY__BASE_FORK_NODE = GATEWAY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Non Exclusive Gateway</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EXCLUSIVE_GATEWAY_FEATURE_COUNT = GATEWAY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Non Exclusive Gateway</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_EXCLUSIVE_GATEWAY_OPERATION_COUNT = GATEWAY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.InclusiveGatewayImpl <em>Inclusive Gateway</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.InclusiveGatewayImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getInclusiveGateway()
	 * @generated
	 */
	int INCLUSIVE_GATEWAY = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVE_GATEWAY__ID = NON_EXCLUSIVE_GATEWAY__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVE_GATEWAY__EXTENSION_VALUES = NON_EXCLUSIVE_GATEWAY__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVE_GATEWAY__BASE_ELEMENT = NON_EXCLUSIVE_GATEWAY__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVE_GATEWAY__DOCUMENTATION = NON_EXCLUSIVE_GATEWAY__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVE_GATEWAY__EXTENSION_DEFINITIONS = NON_EXCLUSIVE_GATEWAY__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVE_GATEWAY__OUTGOING = NON_EXCLUSIVE_GATEWAY__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVE_GATEWAY__INCOMING = NON_EXCLUSIVE_GATEWAY__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVE_GATEWAY__AUDITING = NON_EXCLUSIVE_GATEWAY__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVE_GATEWAY__MONITORING = NON_EXCLUSIVE_GATEWAY__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVE_GATEWAY__CATEGORY_VALUE_REF = NON_EXCLUSIVE_GATEWAY__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVE_GATEWAY__CONTAINER = NON_EXCLUSIVE_GATEWAY__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVE_GATEWAY__BASE_ACTIVITY_NODE = NON_EXCLUSIVE_GATEWAY__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Base Control Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVE_GATEWAY__BASE_CONTROL_NODE = NON_EXCLUSIVE_GATEWAY__BASE_CONTROL_NODE;

	/**
	 * The feature id for the '<em><b>Base Activity Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVE_GATEWAY__BASE_ACTIVITY_GROUP = NON_EXCLUSIVE_GATEWAY__BASE_ACTIVITY_GROUP;

	/**
	 * The feature id for the '<em><b>Base Join Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVE_GATEWAY__BASE_JOIN_NODE = NON_EXCLUSIVE_GATEWAY__BASE_JOIN_NODE;

	/**
	 * The feature id for the '<em><b>Base Fork Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVE_GATEWAY__BASE_FORK_NODE = NON_EXCLUSIVE_GATEWAY__BASE_FORK_NODE;

	/**
	 * The feature id for the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVE_GATEWAY__DEFAULT = NON_EXCLUSIVE_GATEWAY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Inclusive Gateway</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVE_GATEWAY_FEATURE_COUNT = NON_EXCLUSIVE_GATEWAY_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Inclusive Gatewaydefault</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVE_GATEWAY___INCLUSIVE_GATEWAYDEFAULT__DIAGNOSTICCHAIN_MAP = NON_EXCLUSIVE_GATEWAY_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Inclusive Gateway</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVE_GATEWAY_OPERATION_COUNT = NON_EXCLUSIVE_GATEWAY_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ExtensionAttributeValueImpl <em>Extension Attribute Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ExtensionAttributeValueImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getExtensionAttributeValue()
	 * @generated
	 */
	int EXTENSION_ATTRIBUTE_VALUE = 6;

	/**
	 * The feature id for the '<em><b>Base Slot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ATTRIBUTE_VALUE__BASE_SLOT = 0;

	/**
	 * The feature id for the '<em><b>Value Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ATTRIBUTE_VALUE__VALUE_REF = 1;

	/**
	 * The feature id for the '<em><b>Extension Attribute Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ATTRIBUTE_VALUE__EXTENSION_ATTRIBUTE_DEFINITION = 2;

	/**
	 * The number of structural features of the '<em>Extension Attribute Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ATTRIBUTE_VALUE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Extension Attribute Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ATTRIBUTE_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ExtensionAttributeDefinitionImpl <em>Extension Attribute Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ExtensionAttributeDefinitionImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getExtensionAttributeDefinition()
	 * @generated
	 */
	int EXTENSION_ATTRIBUTE_DEFINITION = 7;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ATTRIBUTE_DEFINITION__BASE_PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ATTRIBUTE_DEFINITION__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Is Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ATTRIBUTE_DEFINITION__IS_REFERENCE = 2;

	/**
	 * The number of structural features of the '<em>Extension Attribute Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ATTRIBUTE_DEFINITION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Extension Attribute Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ATTRIBUTE_DEFINITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DocumentationImpl <em>Documentation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.DocumentationImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getDocumentation()
	 * @generated
	 */
	int DOCUMENTATION = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__BASE_COMMENT = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__TEXT_FORMAT = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__TEXT = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Documentation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Documentation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ExtensionDefinitionImpl <em>Extension Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ExtensionDefinitionImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getExtensionDefinition()
	 * @generated
	 */
	int EXTENSION_DEFINITION = 9;

	/**
	 * The feature id for the '<em><b>Base Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_DEFINITION__BASE_STEREOTYPE = 0;

	/**
	 * The feature id for the '<em><b>Extension Attribute Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_DEFINITION__EXTENSION_ATTRIBUTE_DEFINITIONS = 1;

	/**
	 * The number of structural features of the '<em>Extension Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_DEFINITION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Extension Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_DEFINITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNArtifactImpl <em>BPMN Artifact</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNArtifactImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getBPMNArtifact()
	 * @generated
	 */
	int BPMN_ARTIFACT = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ARTIFACT__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ARTIFACT__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ARTIFACT__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ARTIFACT__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ARTIFACT__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ARTIFACT__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ARTIFACT__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The number of structural features of the '<em>BPMN Artifact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ARTIFACT_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>BPMN Artifact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ARTIFACT_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNAssociationImpl <em>BPMN Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNAssociationImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getBPMNAssociation()
	 * @generated
	 */
	int BPMN_ASSOCIATION = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ASSOCIATION__ID = BPMN_ARTIFACT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ASSOCIATION__EXTENSION_VALUES = BPMN_ARTIFACT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ASSOCIATION__BASE_ELEMENT = BPMN_ARTIFACT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ASSOCIATION__DOCUMENTATION = BPMN_ARTIFACT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ASSOCIATION__EXTENSION_DEFINITIONS = BPMN_ARTIFACT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ASSOCIATION__OUTGOING = BPMN_ARTIFACT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ASSOCIATION__INCOMING = BPMN_ARTIFACT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ASSOCIATION__BASE_DEPENDENCY = BPMN_ARTIFACT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Association Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ASSOCIATION__ASSOCIATION_DIRECTION = BPMN_ARTIFACT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ASSOCIATION__TARGET_REF = BPMN_ARTIFACT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ASSOCIATION__SOURCE_REF = BPMN_ARTIFACT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>BPMN Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ASSOCIATION_FEATURE_COUNT = BPMN_ARTIFACT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Association End</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ASSOCIATION___ASSOCIATION_END__DIAGNOSTICCHAIN_MAP = BPMN_ARTIFACT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>BPMN Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ASSOCIATION_OPERATION_COUNT = BPMN_ARTIFACT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.AuditingImpl <em>Auditing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.AuditingImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getAuditing()
	 * @generated
	 */
	int AUDITING = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDITING__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDITING__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDITING__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDITING__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDITING__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDITING__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDITING__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDITING__BASE_CLASS = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Auditing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDITING_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Auditing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDITING_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.MonitoringImpl <em>Monitoring</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.MonitoringImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getMonitoring()
	 * @generated
	 */
	int MONITORING = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING__BASE_CLASS = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Monitoring</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Monitoring</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.CategoryValueImpl <em>Category Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.CategoryValueImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getCategoryValue()
	 * @generated
	 */
	int CATEGORY_VALUE = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_VALUE__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_VALUE__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_VALUE__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_VALUE__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_VALUE__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_VALUE__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_VALUE__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Enumeration Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_VALUE__BASE_ENUMERATION_LITERAL = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Categorized Flow Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_VALUE__CATEGORIZED_FLOW_ELEMENTS = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Category Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_VALUE_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Category Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_VALUE_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.FlowElementsContainerImpl <em>Flow Elements Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.FlowElementsContainerImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getFlowElementsContainer()
	 * @generated
	 */
	int FLOW_ELEMENTS_CONTAINER = 15;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENTS_CONTAINER__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENTS_CONTAINER__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENTS_CONTAINER__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENTS_CONTAINER__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENTS_CONTAINER__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENTS_CONTAINER__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENTS_CONTAINER__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Lane Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENTS_CONTAINER__LANE_SETS = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Flow Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENTS_CONTAINER__FLOW_ELEMENTS = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Flow Elements Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENTS_CONTAINER_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Flow Elements Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ELEMENTS_CONTAINER_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.LaneSetImpl <em>Lane Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.LaneSetImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getLaneSet()
	 * @generated
	 */
	int LANE_SET = 16;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SET__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SET__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SET__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SET__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SET__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SET__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SET__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Activity Partition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SET__BASE_ACTIVITY_PARTITION = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lanes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SET__LANES = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parent Lane</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SET__PARENT_LANE = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Flow Elements Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SET__FLOW_ELEMENTS_CONTAINER = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Lane Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SET_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Lane Setlanes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SET___LANE_SETLANES__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Lane Setparent Lane</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SET___LANE_SETPARENT_LANE__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Lane Setflow Elements Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SET___LANE_SETFLOW_ELEMENTS_CONTAINER__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Lane Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SET___LANE_SET__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Lane Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SET_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.LaneImpl <em>Lane</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.LaneImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getLane()
	 * @generated
	 */
	int LANE = 17;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Activity Partition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__BASE_ACTIVITY_PARTITION = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>partition Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__PARTITION_ELEMENT = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Flow Node Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__FLOW_NODE_REFS = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Partition Element Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__PARTITION_ELEMENT_REF = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Child Lane Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__CHILD_LANE_SET = BASE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Lane Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__LANE_SET = BASE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Lane</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Lanelane Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE___LANELANE_SET__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Lanechild Lane Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE___LANECHILD_LANE_SET__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Lanepartition Element Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE___LANEPARTITION_ELEMENT_REF__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Laneflow Node Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE___LANEFLOW_NODE_REFS__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Lane</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.SequenceFlowImpl <em>Sequence Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.SequenceFlowImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getSequenceFlow()
	 * @generated
	 */
	int SEQUENCE_FLOW = 18;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__ID = FLOW_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__EXTENSION_VALUES = FLOW_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__BASE_ELEMENT = FLOW_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__DOCUMENTATION = FLOW_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__EXTENSION_DEFINITIONS = FLOW_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__OUTGOING = FLOW_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__INCOMING = FLOW_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__AUDITING = FLOW_ELEMENT__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__MONITORING = FLOW_ELEMENT__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__CATEGORY_VALUE_REF = FLOW_ELEMENT__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__CONTAINER = FLOW_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Control Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__BASE_CONTROL_FLOW = FLOW_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Immediate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__IS_IMMEDIATE = FLOW_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__CONDITION_EXPRESSION = FLOW_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Sequence Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW_FEATURE_COUNT = FLOW_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Sequence Flowcondition Expression</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW___SEQUENCE_FLOWCONDITION_EXPRESSION__DIAGNOSTICCHAIN_MAP = FLOW_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Sequence Flowsource Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW___SEQUENCE_FLOWSOURCE_REF__DIAGNOSTICCHAIN_MAP = FLOW_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Sequence Flowtarget Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW___SEQUENCE_FLOWTARGET_REF__DIAGNOSTICCHAIN_MAP = FLOW_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Sequence Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW_OPERATION_COUNT = FLOW_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNExpressionImpl <em>BPMN Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNExpressionImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getBPMNExpression()
	 * @generated
	 */
	int BPMN_EXPRESSION = 19;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EXPRESSION__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EXPRESSION__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EXPRESSION__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EXPRESSION__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EXPRESSION__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EXPRESSION__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EXPRESSION__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Opaque Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EXPRESSION__BASE_OPAQUE_EXPRESSION = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BPMN Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EXPRESSION_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>BPMN Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EXPRESSION_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.EventBasedGatewayImpl <em>Event Based Gateway</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.EventBasedGatewayImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getEventBasedGateway()
	 * @generated
	 */
	int EVENT_BASED_GATEWAY = 20;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BASED_GATEWAY__ID = GATEWAY__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BASED_GATEWAY__EXTENSION_VALUES = GATEWAY__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BASED_GATEWAY__BASE_ELEMENT = GATEWAY__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BASED_GATEWAY__DOCUMENTATION = GATEWAY__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BASED_GATEWAY__EXTENSION_DEFINITIONS = GATEWAY__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BASED_GATEWAY__OUTGOING = GATEWAY__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BASED_GATEWAY__INCOMING = GATEWAY__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BASED_GATEWAY__AUDITING = GATEWAY__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BASED_GATEWAY__MONITORING = GATEWAY__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BASED_GATEWAY__CATEGORY_VALUE_REF = GATEWAY__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BASED_GATEWAY__CONTAINER = GATEWAY__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BASED_GATEWAY__BASE_ACTIVITY_NODE = GATEWAY__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Base Control Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BASED_GATEWAY__BASE_CONTROL_NODE = GATEWAY__BASE_CONTROL_NODE;

	/**
	 * The feature id for the '<em><b>Base Activity Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BASED_GATEWAY__BASE_ACTIVITY_GROUP = GATEWAY__BASE_ACTIVITY_GROUP;

	/**
	 * The feature id for the '<em><b>Instantiate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BASED_GATEWAY__INSTANTIATE = GATEWAY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Event Gateway Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BASED_GATEWAY__EVENT_GATEWAY_TYPE = GATEWAY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Fork Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BASED_GATEWAY__BASE_FORK_NODE = GATEWAY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Structured Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BASED_GATEWAY__BASE_STRUCTURED_ACTIVITY_NODE = GATEWAY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Base Interruptible Activity Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BASED_GATEWAY__BASE_INTERRUPTIBLE_ACTIVITY_REGION = GATEWAY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Event Based Gateway</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BASED_GATEWAY_FEATURE_COUNT = GATEWAY_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Event Based Gateway</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_BASED_GATEWAY_OPERATION_COUNT = GATEWAY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ParallelGatewayImpl <em>Parallel Gateway</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ParallelGatewayImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getParallelGateway()
	 * @generated
	 */
	int PARALLEL_GATEWAY = 21;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_GATEWAY__ID = NON_EXCLUSIVE_GATEWAY__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_GATEWAY__EXTENSION_VALUES = NON_EXCLUSIVE_GATEWAY__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_GATEWAY__BASE_ELEMENT = NON_EXCLUSIVE_GATEWAY__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_GATEWAY__DOCUMENTATION = NON_EXCLUSIVE_GATEWAY__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_GATEWAY__EXTENSION_DEFINITIONS = NON_EXCLUSIVE_GATEWAY__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_GATEWAY__OUTGOING = NON_EXCLUSIVE_GATEWAY__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_GATEWAY__INCOMING = NON_EXCLUSIVE_GATEWAY__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_GATEWAY__AUDITING = NON_EXCLUSIVE_GATEWAY__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_GATEWAY__MONITORING = NON_EXCLUSIVE_GATEWAY__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_GATEWAY__CATEGORY_VALUE_REF = NON_EXCLUSIVE_GATEWAY__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_GATEWAY__CONTAINER = NON_EXCLUSIVE_GATEWAY__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_GATEWAY__BASE_ACTIVITY_NODE = NON_EXCLUSIVE_GATEWAY__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Base Control Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_GATEWAY__BASE_CONTROL_NODE = NON_EXCLUSIVE_GATEWAY__BASE_CONTROL_NODE;

	/**
	 * The feature id for the '<em><b>Base Activity Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_GATEWAY__BASE_ACTIVITY_GROUP = NON_EXCLUSIVE_GATEWAY__BASE_ACTIVITY_GROUP;

	/**
	 * The feature id for the '<em><b>Base Join Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_GATEWAY__BASE_JOIN_NODE = NON_EXCLUSIVE_GATEWAY__BASE_JOIN_NODE;

	/**
	 * The feature id for the '<em><b>Base Fork Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_GATEWAY__BASE_FORK_NODE = NON_EXCLUSIVE_GATEWAY__BASE_FORK_NODE;

	/**
	 * The number of structural features of the '<em>Parallel Gateway</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_GATEWAY_FEATURE_COUNT = NON_EXCLUSIVE_GATEWAY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Parallel Gateway</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_GATEWAY_OPERATION_COUNT = NON_EXCLUSIVE_GATEWAY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ComplexGatewayImpl <em>Complex Gateway</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ComplexGatewayImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getComplexGateway()
	 * @generated
	 */
	int COMPLEX_GATEWAY = 22;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_GATEWAY__ID = NON_EXCLUSIVE_GATEWAY__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_GATEWAY__EXTENSION_VALUES = NON_EXCLUSIVE_GATEWAY__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_GATEWAY__BASE_ELEMENT = NON_EXCLUSIVE_GATEWAY__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_GATEWAY__DOCUMENTATION = NON_EXCLUSIVE_GATEWAY__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_GATEWAY__EXTENSION_DEFINITIONS = NON_EXCLUSIVE_GATEWAY__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_GATEWAY__OUTGOING = NON_EXCLUSIVE_GATEWAY__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_GATEWAY__INCOMING = NON_EXCLUSIVE_GATEWAY__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_GATEWAY__AUDITING = NON_EXCLUSIVE_GATEWAY__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_GATEWAY__MONITORING = NON_EXCLUSIVE_GATEWAY__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_GATEWAY__CATEGORY_VALUE_REF = NON_EXCLUSIVE_GATEWAY__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_GATEWAY__CONTAINER = NON_EXCLUSIVE_GATEWAY__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_GATEWAY__BASE_ACTIVITY_NODE = NON_EXCLUSIVE_GATEWAY__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Base Control Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_GATEWAY__BASE_CONTROL_NODE = NON_EXCLUSIVE_GATEWAY__BASE_CONTROL_NODE;

	/**
	 * The feature id for the '<em><b>Base Activity Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_GATEWAY__BASE_ACTIVITY_GROUP = NON_EXCLUSIVE_GATEWAY__BASE_ACTIVITY_GROUP;

	/**
	 * The feature id for the '<em><b>Base Join Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_GATEWAY__BASE_JOIN_NODE = NON_EXCLUSIVE_GATEWAY__BASE_JOIN_NODE;

	/**
	 * The feature id for the '<em><b>Base Fork Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_GATEWAY__BASE_FORK_NODE = NON_EXCLUSIVE_GATEWAY__BASE_FORK_NODE;

	/**
	 * The feature id for the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_GATEWAY__DEFAULT = NON_EXCLUSIVE_GATEWAY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Activation Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_GATEWAY__ACTIVATION_CONDITION = NON_EXCLUSIVE_GATEWAY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Complex Gateway</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_GATEWAY_FEATURE_COUNT = NON_EXCLUSIVE_GATEWAY_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Complex Gatewaydefault</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_GATEWAY___COMPLEX_GATEWAYDEFAULT__DIAGNOSTICCHAIN_MAP = NON_EXCLUSIVE_GATEWAY_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Complex Gatewayactivation Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_GATEWAY___COMPLEX_GATEWAYACTIVATION_CONDITION__DIAGNOSTICCHAIN_MAP = NON_EXCLUSIVE_GATEWAY_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Complex Gatewayjoin Spec</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_GATEWAY___COMPLEX_GATEWAYJOIN_SPEC__DIAGNOSTICCHAIN_MAP = NON_EXCLUSIVE_GATEWAY_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Complex Gateway</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_GATEWAY_OPERATION_COUNT = NON_EXCLUSIVE_GATEWAY_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ExclusiveGatewayImpl <em>Exclusive Gateway</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ExclusiveGatewayImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getExclusiveGateway()
	 * @generated
	 */
	int EXCLUSIVE_GATEWAY = 23;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_GATEWAY__ID = GATEWAY__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_GATEWAY__EXTENSION_VALUES = GATEWAY__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_GATEWAY__BASE_ELEMENT = GATEWAY__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_GATEWAY__DOCUMENTATION = GATEWAY__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_GATEWAY__EXTENSION_DEFINITIONS = GATEWAY__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_GATEWAY__OUTGOING = GATEWAY__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_GATEWAY__INCOMING = GATEWAY__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_GATEWAY__AUDITING = GATEWAY__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_GATEWAY__MONITORING = GATEWAY__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_GATEWAY__CATEGORY_VALUE_REF = GATEWAY__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_GATEWAY__CONTAINER = GATEWAY__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_GATEWAY__BASE_ACTIVITY_NODE = GATEWAY__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Base Control Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_GATEWAY__BASE_CONTROL_NODE = GATEWAY__BASE_CONTROL_NODE;

	/**
	 * The feature id for the '<em><b>Base Activity Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_GATEWAY__BASE_ACTIVITY_GROUP = GATEWAY__BASE_ACTIVITY_GROUP;

	/**
	 * The feature id for the '<em><b>Base Decision Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_GATEWAY__BASE_DECISION_NODE = GATEWAY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Merge Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_GATEWAY__BASE_MERGE_NODE = GATEWAY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_GATEWAY__DEFAULT = GATEWAY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Exclusive Gateway</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_GATEWAY_FEATURE_COUNT = GATEWAY_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Exclusive Gatewaydefault</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_GATEWAY___EXCLUSIVE_GATEWAYDEFAULT__DIAGNOSTICCHAIN_MAP = GATEWAY_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Exclusive Gateway</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_GATEWAY_OPERATION_COUNT = GATEWAY_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.RootElementImpl <em>Root Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.RootElementImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getRootElement()
	 * @generated
	 */
	int ROOT_ELEMENT = 24;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_ELEMENT__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_ELEMENT__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_ELEMENT__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_ELEMENT__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_ELEMENT__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_ELEMENT__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_ELEMENT__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_ELEMENT__BASE_PACKAGEABLE_ELEMENT = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_ELEMENT__DEFINITION = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Root Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_ELEMENT_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Root Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_ELEMENT_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DefinitionsImpl <em>Definitions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.DefinitionsImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getDefinitions()
	 * @generated
	 */
	int DEFINITIONS = 25;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__BASE_PACKAGE = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__TARGET_NAMESPACE = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__EXPRESSION_LANGUAGE = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__TYPE_LANGUAGE = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Exporter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__EXPORTER = BASE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Exporter Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__EXPORTER_VERSION = BASE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__EXTENSIONS = BASE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__IMPORTS = BASE_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Relationships</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__RELATIONSHIPS = BASE_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Root Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__ROOT_ELEMENTS = BASE_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Definitions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The number of operations of the '<em>Definitions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNExtensionImpl <em>BPMN Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNExtensionImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getBPMNExtension()
	 * @generated
	 */
	int BPMN_EXTENSION = 26;

	/**
	 * The feature id for the '<em><b>Base Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EXTENSION__BASE_STEREOTYPE = 0;

	/**
	 * The feature id for the '<em><b>Must Understand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EXTENSION__MUST_UNDERSTAND = 1;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EXTENSION__DEFINITION = 2;

	/**
	 * The number of structural features of the '<em>BPMN Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EXTENSION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>BPMN Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EXTENSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ImportImpl <em>Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ImportImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getImport()
	 * @generated
	 */
	int IMPORT = 27;

	/**
	 * The feature id for the '<em><b>Base Package Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__BASE_PACKAGE_IMPORT = 0;

	/**
	 * The feature id for the '<em><b>Import Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__IMPORT_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__NAMESPACE = 3;

	/**
	 * The feature id for the '<em><b>Definitions</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__DEFINITIONS = 4;

	/**
	 * The number of structural features of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNRelationshipImpl <em>BPMN Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNRelationshipImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getBPMNRelationship()
	 * @generated
	 */
	int BPMN_RELATIONSHIP = 28;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_RELATIONSHIP__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_RELATIONSHIP__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_RELATIONSHIP__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_RELATIONSHIP__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_RELATIONSHIP__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_RELATIONSHIP__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_RELATIONSHIP__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_RELATIONSHIP__BASE_CONSTRAINT = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_RELATIONSHIP__TYPE = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_RELATIONSHIP__DIRECTION = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_RELATIONSHIP__TARGETS = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_RELATIONSHIP__SOURCES = BASE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_RELATIONSHIP__DEFINITION = BASE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>BPMN Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_RELATIONSHIP_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>BPMN Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_RELATIONSHIP_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.CallableElementImpl <em>Callable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.CallableElementImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getCallableElement()
	 * @generated
	 */
	int CALLABLE_ELEMENT = 30;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLABLE_ELEMENT__ID = ROOT_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLABLE_ELEMENT__EXTENSION_VALUES = ROOT_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLABLE_ELEMENT__BASE_ELEMENT = ROOT_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLABLE_ELEMENT__DOCUMENTATION = ROOT_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLABLE_ELEMENT__EXTENSION_DEFINITIONS = ROOT_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLABLE_ELEMENT__OUTGOING = ROOT_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLABLE_ELEMENT__INCOMING = ROOT_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLABLE_ELEMENT__BASE_PACKAGEABLE_ELEMENT = ROOT_ELEMENT__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLABLE_ELEMENT__DEFINITION = ROOT_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLABLE_ELEMENT__BASE_BEHAVIOR = ROOT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Io Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLABLE_ELEMENT__IO_SPECIFICATION = ROOT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Supported Interface Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLABLE_ELEMENT__SUPPORTED_INTERFACE_REFS = ROOT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Io Binding</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLABLE_ELEMENT__IO_BINDING = ROOT_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Callable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLABLE_ELEMENT_FEATURE_COUNT = ROOT_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Callable Eelementsupported Interface Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLABLE_ELEMENT___CALLABLE_EELEMENTSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP = ROOT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Callable Elementresources</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLABLE_ELEMENT___CALLABLE_ELEMENTRESOURCES__DIAGNOSTICCHAIN_MAP = ROOT_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Callable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLABLE_ELEMENT_OPERATION_COUNT = ROOT_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProcessImpl <em>BPMN Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProcessImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getBPMNProcess()
	 * @generated
	 */
	int BPMN_PROCESS = 29;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__ID = CALLABLE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__EXTENSION_VALUES = CALLABLE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__BASE_ELEMENT = CALLABLE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__DOCUMENTATION = CALLABLE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__EXTENSION_DEFINITIONS = CALLABLE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__OUTGOING = CALLABLE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__INCOMING = CALLABLE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__BASE_PACKAGEABLE_ELEMENT = CALLABLE_ELEMENT__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__DEFINITION = CALLABLE_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__BASE_BEHAVIOR = CALLABLE_ELEMENT__BASE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Io Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__IO_SPECIFICATION = CALLABLE_ELEMENT__IO_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Supported Interface Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__SUPPORTED_INTERFACE_REFS = CALLABLE_ELEMENT__SUPPORTED_INTERFACE_REFS;

	/**
	 * The feature id for the '<em><b>Io Binding</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__IO_BINDING = CALLABLE_ELEMENT__IO_BINDING;

	/**
	 * The feature id for the '<em><b>Lane Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__LANE_SETS = CALLABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Flow Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__FLOW_ELEMENTS = CALLABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Process Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__PROCESS_TYPE = CALLABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Closed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__IS_CLOSED = CALLABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__AUDITING = CALLABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Is Executable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__IS_EXECUTABLE = CALLABLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Definitional Collaboration Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__DEFINITIONAL_COLLABORATION_REF = CALLABLE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Base Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__BASE_ACTIVITY = CALLABLE_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Correlation Subscriptions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__CORRELATION_SUBSCRIPTIONS = CALLABLE_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__MONITORING = CALLABLE_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Supports</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__SUPPORTS = CALLABLE_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__PROPERTIES = CALLABLE_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS__RESOURCES = CALLABLE_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>BPMN Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS_FEATURE_COUNT = CALLABLE_ELEMENT_FEATURE_COUNT + 13;

	/**
	 * The operation id for the '<em>Callable Eelementsupported Interface Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS___CALLABLE_EELEMENTSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP = CALLABLE_ELEMENT___CALLABLE_EELEMENTSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Callable Elementresources</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS___CALLABLE_ELEMENTRESOURCES__DIAGNOSTICCHAIN_MAP = CALLABLE_ELEMENT___CALLABLE_ELEMENTRESOURCES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Processsupported Interface Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS___PROCESSSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP = CALLABLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Processsupports</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS___PROCESSSUPPORTS__DIAGNOSTICCHAIN_MAP = CALLABLE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Processproperties</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS___PROCESSPROPERTIES__DIAGNOSTICCHAIN_MAP = CALLABLE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Processlane Sets</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS___PROCESSLANE_SETS__DIAGNOSTICCHAIN_MAP = CALLABLE_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Processflow Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS___PROCESSFLOW_ELEMENTS__DIAGNOSTICCHAIN_MAP = CALLABLE_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>BPMN Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROCESS_OPERATION_COUNT = CALLABLE_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.InputOutputSpecificationImpl <em>Input Output Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.InputOutputSpecificationImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getInputOutputSpecification()
	 * @generated
	 */
	int INPUT_OUTPUT_SPECIFICATION = 31;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_SPECIFICATION__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_SPECIFICATION__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_SPECIFICATION__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_SPECIFICATION__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_SPECIFICATION__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_SPECIFICATION__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_SPECIFICATION__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_SPECIFICATION__BASE_BEHAVIOR = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_SPECIFICATION__BASE_ACTION = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Data Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_SPECIFICATION__DATA_INPUTS = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Data Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_SPECIFICATION__DATA_OUTPUTS = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Input Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_SPECIFICATION__INPUT_SETS = BASE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Output Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_SPECIFICATION__OUTPUT_SETS = BASE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Input Output Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_SPECIFICATION_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Input Output Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_SPECIFICATION_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ItemAwareElementImpl <em>Item Aware Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ItemAwareElementImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getItemAwareElement()
	 * @generated
	 */
	int ITEM_AWARE_ELEMENT = 33;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_AWARE_ELEMENT__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_AWARE_ELEMENT__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_AWARE_ELEMENT__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_AWARE_ELEMENT__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_AWARE_ELEMENT__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_AWARE_ELEMENT__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_AWARE_ELEMENT__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Data State</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_AWARE_ELEMENT__DATA_STATE = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Typed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_AWARE_ELEMENT__BASE_TYPED_ELEMENT = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Item Subject Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_AWARE_ELEMENT__ITEM_SUBJECT_REF = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Item Aware Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_AWARE_ELEMENT_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Item Aware Elementdata State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_AWARE_ELEMENT___ITEM_AWARE_ELEMENTDATA_STATE__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Item Aware Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_AWARE_ELEMENT_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataInputImpl <em>Data Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataInputImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getDataInput()
	 * @generated
	 */
	int DATA_INPUT = 32;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT__ID = ITEM_AWARE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT__EXTENSION_VALUES = ITEM_AWARE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT__BASE_ELEMENT = ITEM_AWARE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT__DOCUMENTATION = ITEM_AWARE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT__EXTENSION_DEFINITIONS = ITEM_AWARE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT__OUTGOING = ITEM_AWARE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT__INCOMING = ITEM_AWARE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Data State</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT__DATA_STATE = ITEM_AWARE_ELEMENT__DATA_STATE;

	/**
	 * The feature id for the '<em><b>Base Typed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT__BASE_TYPED_ELEMENT = ITEM_AWARE_ELEMENT__BASE_TYPED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Item Subject Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT__ITEM_SUBJECT_REF = ITEM_AWARE_ELEMENT__ITEM_SUBJECT_REF;

	/**
	 * The feature id for the '<em><b>Is Collection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT__IS_COLLECTION = ITEM_AWARE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Input Pin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT__BASE_INPUT_PIN = ITEM_AWARE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT__BASE_PARAMETER = ITEM_AWARE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Activity Parameter Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT__BASE_ACTIVITY_PARAMETER_NODE = ITEM_AWARE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Input Set Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT__INPUT_SET_REFS = ITEM_AWARE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Input Set With Optional</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT__INPUT_SET_WITH_OPTIONAL = ITEM_AWARE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Input Set With While Executing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT__INPUT_SET_WITH_WHILE_EXECUTING = ITEM_AWARE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Data Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_FEATURE_COUNT = ITEM_AWARE_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>Item Aware Elementdata State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT___ITEM_AWARE_ELEMENTDATA_STATE__DIAGNOSTICCHAIN_MAP = ITEM_AWARE_ELEMENT___ITEM_AWARE_ELEMENTDATA_STATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Data Input Association</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT___DATA_INPUT_ASSOCIATION__DIAGNOSTICCHAIN_MAP = ITEM_AWARE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Data Inputnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT___DATA_INPUTNOTATION__DIAGNOSTICCHAIN_MAP = ITEM_AWARE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Data Inputitem Subject Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT___DATA_INPUTITEM_SUBJECT_REF__DIAGNOSTICCHAIN_MAP = ITEM_AWARE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Data Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_OPERATION_COUNT = ITEM_AWARE_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataStateImpl <em>Data State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataStateImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getDataState()
	 * @generated
	 */
	int DATA_STATE = 34;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE__BASE_STATE = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ItemDefinitionImpl <em>Item Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ItemDefinitionImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getItemDefinition()
	 * @generated
	 */
	int ITEM_DEFINITION = 35;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_DEFINITION__ID = ROOT_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_DEFINITION__EXTENSION_VALUES = ROOT_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_DEFINITION__BASE_ELEMENT = ROOT_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_DEFINITION__DOCUMENTATION = ROOT_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_DEFINITION__EXTENSION_DEFINITIONS = ROOT_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_DEFINITION__OUTGOING = ROOT_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_DEFINITION__INCOMING = ROOT_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_DEFINITION__BASE_PACKAGEABLE_ELEMENT = ROOT_ELEMENT__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_DEFINITION__DEFINITION = ROOT_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Item Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_DEFINITION__ITEM_KIND = ROOT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Collection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_DEFINITION__IS_COLLECTION = ROOT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_DEFINITION__BASE_CLASS = ROOT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Structure Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_DEFINITION__STRUCTURE_REF = ROOT_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_DEFINITION__IMPORT = ROOT_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Item Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_DEFINITION_FEATURE_COUNT = ROOT_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Item Definitionstructure Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_DEFINITION___ITEM_DEFINITIONSTRUCTURE_REF__DIAGNOSTICCHAIN_MAP = ROOT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Item Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_DEFINITION_OPERATION_COUNT = ROOT_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.InputSetImpl <em>Input Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.InputSetImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getInputSet()
	 * @generated
	 */
	int INPUT_SET = 36;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SET__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SET__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SET__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SET__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SET__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SET__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SET__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Parameter Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SET__BASE_PARAMETER_SET = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Optional Input Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SET__OPTIONAL_INPUT_REFS = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>While Executing Input Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SET__WHILE_EXECUTING_INPUT_REFS = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Data Input Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SET__DATA_INPUT_REFS = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Input Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SET_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Input Setdata Input Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SET___INPUT_SETDATA_INPUT_REFS__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Input Setoptional Input Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SET___INPUT_SETOPTIONAL_INPUT_REFS__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Input Setwhile Executing Input Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SET___INPUT_SETWHILE_EXECUTING_INPUT_REFS__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Input Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SET_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataOutputImpl <em>Data Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataOutputImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getDataOutput()
	 * @generated
	 */
	int DATA_OUTPUT = 37;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT__ID = ITEM_AWARE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT__EXTENSION_VALUES = ITEM_AWARE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT__BASE_ELEMENT = ITEM_AWARE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT__DOCUMENTATION = ITEM_AWARE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT__EXTENSION_DEFINITIONS = ITEM_AWARE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT__OUTGOING = ITEM_AWARE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT__INCOMING = ITEM_AWARE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Data State</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT__DATA_STATE = ITEM_AWARE_ELEMENT__DATA_STATE;

	/**
	 * The feature id for the '<em><b>Base Typed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT__BASE_TYPED_ELEMENT = ITEM_AWARE_ELEMENT__BASE_TYPED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Item Subject Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT__ITEM_SUBJECT_REF = ITEM_AWARE_ELEMENT__ITEM_SUBJECT_REF;

	/**
	 * The feature id for the '<em><b>Base Output Pin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT__BASE_OUTPUT_PIN = ITEM_AWARE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Collection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT__IS_COLLECTION = ITEM_AWARE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT__BASE_PARAMETER = ITEM_AWARE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Activity Parameter Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT__BASE_ACTIVITY_PARAMETER_NODE = ITEM_AWARE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Output Set Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT__OUTPUT_SET_REFS = ITEM_AWARE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Output Set With Optional</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT__OUTPUT_SET_WITH_OPTIONAL = ITEM_AWARE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Output Set With While Executing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT__OUTPUT_SET_WITH_WHILE_EXECUTING = ITEM_AWARE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Data Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_FEATURE_COUNT = ITEM_AWARE_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>Item Aware Elementdata State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT___ITEM_AWARE_ELEMENTDATA_STATE__DIAGNOSTICCHAIN_MAP = ITEM_AWARE_ELEMENT___ITEM_AWARE_ELEMENTDATA_STATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Data Outputnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT___DATA_OUTPUTNOTATION__DIAGNOSTICCHAIN_MAP = ITEM_AWARE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Data Outputitem Subject Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT___DATA_OUTPUTITEM_SUBJECT_REF__DIAGNOSTICCHAIN_MAP = ITEM_AWARE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_OPERATION_COUNT = ITEM_AWARE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.OutputSetImpl <em>Output Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.OutputSetImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getOutputSet()
	 * @generated
	 */
	int OUTPUT_SET = 38;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SET__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SET__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SET__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SET__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SET__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SET__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SET__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Parameter Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SET__BASE_PARAMETER_SET = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Optional Output Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SET__OPTIONAL_OUTPUT_REFS = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>While Executing Output Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SET__WHILE_EXECUTING_OUTPUT_REFS = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Data Output Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SET__DATA_OUTPUT_REFS = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Output Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SET_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Output Setdata Output Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SET___OUTPUT_SETDATA_OUTPUT_REFS__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Output Setoptional Output Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SET___OUTPUT_SETOPTIONAL_OUTPUT_REFS__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Output Setwhile Executing Output Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SET___OUTPUT_SETWHILE_EXECUTING_OUTPUT_REFS__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Output Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SET_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNInterfaceImpl <em>BPMN Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNInterfaceImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getBPMNInterface()
	 * @generated
	 */
	int BPMN_INTERFACE = 39;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_INTERFACE__ID = ROOT_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_INTERFACE__EXTENSION_VALUES = ROOT_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_INTERFACE__BASE_ELEMENT = ROOT_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_INTERFACE__DOCUMENTATION = ROOT_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_INTERFACE__EXTENSION_DEFINITIONS = ROOT_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_INTERFACE__OUTGOING = ROOT_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_INTERFACE__INCOMING = ROOT_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_INTERFACE__BASE_PACKAGEABLE_ELEMENT = ROOT_ELEMENT__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_INTERFACE__DEFINITION = ROOT_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Base Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_INTERFACE__BASE_INTERFACE = ROOT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Implementation Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_INTERFACE__IMPLEMENTATION_REF = ROOT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_INTERFACE__OPERATIONS = ROOT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Callable Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_INTERFACE__CALLABLE_ELEMENTS = ROOT_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>BPMN Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_INTERFACE_FEATURE_COUNT = ROOT_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Interfaceoperationmultiplicity</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_INTERFACE___INTERFACEOPERATIONMULTIPLICITY__DIAGNOSTICCHAIN_MAP = ROOT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Interfaceowned Operation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_INTERFACE___INTERFACEOWNED_OPERATION__DIAGNOSTICCHAIN_MAP = ROOT_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>BPMN Interfacecallable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_INTERFACE___BPMN_INTERFACECALLABLE_ELEMENTS__DIAGNOSTICCHAIN_MAP = ROOT_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>BPMN Interfaceoperations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_INTERFACE___BPMN_INTERFACEOPERATIONS__DIAGNOSTICCHAIN_MAP = ROOT_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>BPMN Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_INTERFACE_OPERATION_COUNT = ROOT_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNOperationImpl <em>BPMN Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNOperationImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getBPMNOperation()
	 * @generated
	 */
	int BPMN_OPERATION = 40;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_OPERATION__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_OPERATION__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_OPERATION__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_OPERATION__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_OPERATION__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_OPERATION__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_OPERATION__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_OPERATION__BASE_OPERATION = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Implementation Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_OPERATION__IMPLEMENTATION_REF = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>In Message Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_OPERATION__IN_MESSAGE_REF = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Out Message Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_OPERATION__OUT_MESSAGE_REF = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Error Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_OPERATION__ERROR_REF = BASE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>BPMN Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_OPERATION_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>BPMN Operationowner</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_OPERATION___BPMN_OPERATIONOWNER__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>BPMN Operationin Message Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_OPERATION___BPMN_OPERATIONIN_MESSAGE_REF__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>BPMN Operationout Message Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_OPERATION___BPMN_OPERATIONOUT_MESSAGE_REF__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>BPMN Operationerror Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_OPERATION___BPMN_OPERATIONERROR_REFS__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>BPMN Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_OPERATION_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNMessageImpl <em>BPMN Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNMessageImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getBPMNMessage()
	 * @generated
	 */
	int BPMN_MESSAGE = 41;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_MESSAGE__ID = ITEM_DEFINITION__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_MESSAGE__EXTENSION_VALUES = ITEM_DEFINITION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_MESSAGE__BASE_ELEMENT = ITEM_DEFINITION__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_MESSAGE__DOCUMENTATION = ITEM_DEFINITION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_MESSAGE__EXTENSION_DEFINITIONS = ITEM_DEFINITION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_MESSAGE__OUTGOING = ITEM_DEFINITION__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_MESSAGE__INCOMING = ITEM_DEFINITION__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_MESSAGE__BASE_PACKAGEABLE_ELEMENT = ITEM_DEFINITION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_MESSAGE__DEFINITION = ITEM_DEFINITION__DEFINITION;

	/**
	 * The feature id for the '<em><b>Item Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_MESSAGE__ITEM_KIND = ITEM_DEFINITION__ITEM_KIND;

	/**
	 * The feature id for the '<em><b>Is Collection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_MESSAGE__IS_COLLECTION = ITEM_DEFINITION__IS_COLLECTION;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_MESSAGE__BASE_CLASS = ITEM_DEFINITION__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Structure Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_MESSAGE__STRUCTURE_REF = ITEM_DEFINITION__STRUCTURE_REF;

	/**
	 * The feature id for the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_MESSAGE__IMPORT = ITEM_DEFINITION__IMPORT;

	/**
	 * The feature id for the '<em><b>Item Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_MESSAGE__ITEM_REF = ITEM_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BPMN Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_MESSAGE_FEATURE_COUNT = ITEM_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Item Definitionstructure Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_MESSAGE___ITEM_DEFINITIONSTRUCTURE_REF__DIAGNOSTICCHAIN_MAP = ITEM_DEFINITION___ITEM_DEFINITIONSTRUCTURE_REF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Messageitem Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_MESSAGE___MESSAGEITEM_REF__DIAGNOSTICCHAIN_MAP = ITEM_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>BPMN Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_MESSAGE_OPERATION_COUNT = ITEM_DEFINITION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ErrorImpl <em>Error</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ErrorImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getError()
	 * @generated
	 */
	int ERROR = 42;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__ID = ITEM_DEFINITION__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__EXTENSION_VALUES = ITEM_DEFINITION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__BASE_ELEMENT = ITEM_DEFINITION__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__DOCUMENTATION = ITEM_DEFINITION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__EXTENSION_DEFINITIONS = ITEM_DEFINITION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__OUTGOING = ITEM_DEFINITION__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__INCOMING = ITEM_DEFINITION__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__BASE_PACKAGEABLE_ELEMENT = ITEM_DEFINITION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__DEFINITION = ITEM_DEFINITION__DEFINITION;

	/**
	 * The feature id for the '<em><b>Item Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__ITEM_KIND = ITEM_DEFINITION__ITEM_KIND;

	/**
	 * The feature id for the '<em><b>Is Collection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__IS_COLLECTION = ITEM_DEFINITION__IS_COLLECTION;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__BASE_CLASS = ITEM_DEFINITION__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Structure Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__STRUCTURE_REF = ITEM_DEFINITION__STRUCTURE_REF;

	/**
	 * The feature id for the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__IMPORT = ITEM_DEFINITION__IMPORT;

	/**
	 * The feature id for the '<em><b>Error Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR__ERROR_CODE = ITEM_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FEATURE_COUNT = ITEM_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Item Definitionstructure Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR___ITEM_DEFINITIONSTRUCTURE_REF__DIAGNOSTICCHAIN_MAP = ITEM_DEFINITION___ITEM_DEFINITIONSTRUCTURE_REF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_OPERATION_COUNT = ITEM_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.InputOutputBindingImpl <em>Input Output Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.InputOutputBindingImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getInputOutputBinding()
	 * @generated
	 */
	int INPUT_OUTPUT_BINDING = 43;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_BINDING__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_BINDING__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_BINDING__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_BINDING__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_BINDING__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_BINDING__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_BINDING__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Input Data Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_BINDING__INPUT_DATA_REF = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output Data Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_BINDING__OUTPUT_DATA_REF = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operation Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_BINDING__OPERATION_REF = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_BINDING__BASE_DEPENDENCY = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Input Output Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_BINDING_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Input Output Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OUTPUT_BINDING_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNCollaborationImpl <em>BPMN Collaboration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNCollaborationImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getBPMNCollaboration()
	 * @generated
	 */
	int BPMN_COLLABORATION = 44;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_COLLABORATION__ID = ROOT_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_COLLABORATION__EXTENSION_VALUES = ROOT_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_COLLABORATION__BASE_ELEMENT = ROOT_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_COLLABORATION__DOCUMENTATION = ROOT_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_COLLABORATION__EXTENSION_DEFINITIONS = ROOT_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_COLLABORATION__OUTGOING = ROOT_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_COLLABORATION__INCOMING = ROOT_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_COLLABORATION__BASE_PACKAGEABLE_ELEMENT = ROOT_ELEMENT__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_COLLABORATION__DEFINITION = ROOT_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Is Closed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_COLLABORATION__IS_CLOSED = ROOT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Participant Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_COLLABORATION__PARTICIPANT_ASSOCIATIONS = ROOT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Conversation Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_COLLABORATION__CONVERSATION_LINKS = ROOT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Message Flow Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_COLLABORATION__MESSAGE_FLOW_ASSOCIATIONS = ROOT_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Message Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_COLLABORATION__MESSAGE_FLOWS = ROOT_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Base Collaboration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_COLLABORATION__BASE_COLLABORATION = ROOT_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Conversations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_COLLABORATION__CONVERSATIONS = ROOT_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Correlation Keys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_COLLABORATION__CORRELATION_KEYS = ROOT_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Participants</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_COLLABORATION__PARTICIPANTS = ROOT_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>BPMN Collaboration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_COLLABORATION_FEATURE_COUNT = ROOT_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The operation id for the '<em>Collaborationparticipants</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_COLLABORATION___COLLABORATIONPARTICIPANTS__DIAGNOSTICCHAIN_MAP = ROOT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>BPMN Collaboration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_COLLABORATION_OPERATION_COUNT = ROOT_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ParticipantAssociationImpl <em>Participant Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ParticipantAssociationImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getParticipantAssociation()
	 * @generated
	 */
	int PARTICIPANT_ASSOCIATION = 45;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_ASSOCIATION__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_ASSOCIATION__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_ASSOCIATION__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_ASSOCIATION__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_ASSOCIATION__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_ASSOCIATION__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_ASSOCIATION__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_ASSOCIATION__BASE_DEPENDENCY = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inner Participant Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_ASSOCIATION__INNER_PARTICIPANT_REF = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outer Participant Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_ASSOCIATION__OUTER_PARTICIPANT_REF = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Participant Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_ASSOCIATION_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Participant Associationinner Participant Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_ASSOCIATION___PARTICIPANT_ASSOCIATIONINNER_PARTICIPANT_REF__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Participant Associationouter Participant Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_ASSOCIATION___PARTICIPANT_ASSOCIATIONOUTER_PARTICIPANT_REF__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Participant Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_ASSOCIATION_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ParticipantImpl <em>Participant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ParticipantImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getParticipant()
	 * @generated
	 */
	int PARTICIPANT = 46;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__BASE_PROPERTY = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Process Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__PROCESS_REF = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Participant Multiplicity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__PARTICIPANT_MULTIPLICITY = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Partner Entity Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__PARTNER_ENTITY_REF = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Partner Role Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__PARTNER_ROLE_REF = BASE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Interface Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__INTERFACE_REFS = BASE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Participant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Participantownership</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT___PARTICIPANTOWNERSHIP__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Participanttype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT___PARTICIPANTTYPE__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Participantmultiplicity Minimum</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT___PARTICIPANTMULTIPLICITY_MINIMUM__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Participantrealizationsupplier</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT___PARTICIPANTREALIZATIONSUPPLIER__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Participantprocess Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT___PARTICIPANTPROCESS_REF__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Participantmultiplicity Maximum</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT___PARTICIPANTMULTIPLICITY_MAXIMUM__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Participantpartner Entity Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT___PARTICIPANTPARTNER_ENTITY_REF__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Participantpartner Role Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT___PARTICIPANTPARTNER_ROLE_REF__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Participantinterface Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT___PARTICIPANTINTERFACE_REFS__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The number of operations of the '<em>Participant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.InteractionNodeImpl <em>Interaction Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.InteractionNodeImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getInteractionNode()
	 * @generated
	 */
	int INTERACTION_NODE = 47;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_NODE__BASE_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Outgoing Conversation Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_NODE__OUTGOING_CONVERSATION_LINKS = 1;

	/**
	 * The feature id for the '<em><b>Incoming Conversation Links</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_NODE__INCOMING_CONVERSATION_LINKS = 2;

	/**
	 * The number of structural features of the '<em>Interaction Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_NODE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Interaction Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ConversationLinkImpl <em>Conversation Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ConversationLinkImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getConversationLink()
	 * @generated
	 */
	int CONVERSATION_LINK = 48;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_LINK__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_LINK__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_LINK__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_LINK__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_LINK__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_LINK__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_LINK__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Collaboration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_LINK__COLLABORATION = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_LINK__BASE_DEPENDENCY = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_LINK__TARGET_REF = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_LINK__SOURCE_REF = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Conversation Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_LINK_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Conversation Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_LINK_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ParticipantMultiplicityImpl <em>Participant Multiplicity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ParticipantMultiplicityImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getParticipantMultiplicity()
	 * @generated
	 */
	int PARTICIPANT_MULTIPLICITY = 49;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_MULTIPLICITY__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_MULTIPLICITY__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_MULTIPLICITY__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_MULTIPLICITY__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_MULTIPLICITY__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_MULTIPLICITY__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_MULTIPLICITY__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Multiplicity Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_MULTIPLICITY__BASE_MULTIPLICITY_ELEMENT = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_MULTIPLICITY__MINIMUM = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_MULTIPLICITY__MAXIMUM = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Participant Multiplicity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_MULTIPLICITY_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Participant Multiplicity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_MULTIPLICITY_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.PartnerEntityImpl <em>Partner Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.PartnerEntityImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getPartnerEntity()
	 * @generated
	 */
	int PARTNER_ENTITY = 50;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ENTITY__ID = ROOT_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ENTITY__EXTENSION_VALUES = ROOT_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ENTITY__BASE_ELEMENT = ROOT_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ENTITY__DOCUMENTATION = ROOT_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ENTITY__EXTENSION_DEFINITIONS = ROOT_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ENTITY__OUTGOING = ROOT_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ENTITY__INCOMING = ROOT_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ENTITY__BASE_PACKAGEABLE_ELEMENT = ROOT_ELEMENT__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ENTITY__DEFINITION = ROOT_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ENTITY__BASE_INSTANCE_SPECIFICATION = ROOT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Participant Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ENTITY__PARTICIPANT_REF = ROOT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Partner Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ENTITY_FEATURE_COUNT = ROOT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Partner Entityparticipant Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ENTITY___PARTNER_ENTITYPARTICIPANT_REF__DIAGNOSTICCHAIN_MAP = ROOT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Partner Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ENTITY_OPERATION_COUNT = ROOT_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.PartnerRoleImpl <em>Partner Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.PartnerRoleImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getPartnerRole()
	 * @generated
	 */
	int PARTNER_ROLE = 51;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ROLE__ID = ROOT_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ROLE__EXTENSION_VALUES = ROOT_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ROLE__BASE_ELEMENT = ROOT_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ROLE__DOCUMENTATION = ROOT_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ROLE__EXTENSION_DEFINITIONS = ROOT_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ROLE__OUTGOING = ROOT_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ROLE__INCOMING = ROOT_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ROLE__BASE_PACKAGEABLE_ELEMENT = ROOT_ELEMENT__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ROLE__DEFINITION = ROOT_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ROLE__BASE_CLASS = ROOT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Participant Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ROLE__PARTICIPANT_REF = ROOT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Partner Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ROLE_FEATURE_COUNT = ROOT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Partner Roleparticipant Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ROLE___PARTNER_ROLEPARTICIPANT_REF__DIAGNOSTICCHAIN_MAP = ROOT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Partner Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_ROLE_OPERATION_COUNT = ROOT_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.MessageFlowAssociationImpl <em>Message Flow Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.MessageFlowAssociationImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getMessageFlowAssociation()
	 * @generated
	 */
	int MESSAGE_FLOW_ASSOCIATION = 52;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW_ASSOCIATION__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW_ASSOCIATION__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW_ASSOCIATION__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW_ASSOCIATION__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW_ASSOCIATION__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW_ASSOCIATION__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW_ASSOCIATION__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW_ASSOCIATION__BASE_DEPENDENCY = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inner Message Flow Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW_ASSOCIATION__INNER_MESSAGE_FLOW_REF = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outer Message Flow Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW_ASSOCIATION__OUTER_MESSAGE_FLOW_REF = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Message Flow Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW_ASSOCIATION_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Message Flow Associationinner Message Flow Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW_ASSOCIATION___MESSAGE_FLOW_ASSOCIATIONINNER_MESSAGE_FLOW_REF__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Message Flow Associationouter Message Flow Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW_ASSOCIATION___MESSAGE_FLOW_ASSOCIATIONOUTER_MESSAGE_FLOW_REF__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Message Flow Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW_ASSOCIATION_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.MessageFlowImpl <em>Message Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.MessageFlowImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getMessageFlow()
	 * @generated
	 */
	int MESSAGE_FLOW = 53;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Information Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW__BASE_INFORMATION_FLOW = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW__SOURCE_REF = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW__TARGET_REF = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Message Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW__MESSAGE_REF = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Message Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Message Flowsource Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW___MESSAGE_FLOWSOURCE_REF__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Message Flowtarget Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW___MESSAGE_FLOWTARGET_REF__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Message Flowmessage Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW___MESSAGE_FLOWMESSAGE_REF__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Message Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ConversationNodeImpl <em>Conversation Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ConversationNodeImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getConversationNode()
	 * @generated
	 */
	int CONVERSATION_NODE = 54;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_NODE__BASE_ELEMENT = INTERACTION_NODE__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Outgoing Conversation Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_NODE__OUTGOING_CONVERSATION_LINKS = INTERACTION_NODE__OUTGOING_CONVERSATION_LINKS;

	/**
	 * The feature id for the '<em><b>Incoming Conversation Links</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_NODE__INCOMING_CONVERSATION_LINKS = INTERACTION_NODE__INCOMING_CONVERSATION_LINKS;

	/**
	 * The feature id for the '<em><b>Base Information Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_NODE__BASE_INFORMATION_FLOW = INTERACTION_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Message Flow Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_NODE__MESSAGE_FLOW_REFS = INTERACTION_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Correlation Keys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_NODE__CORRELATION_KEYS = INTERACTION_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Participant Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_NODE__PARTICIPANT_REFS = INTERACTION_NODE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Conversation Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_NODE_FEATURE_COUNT = INTERACTION_NODE_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Conversation Nodeparticipant Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_NODE___CONVERSATION_NODEPARTICIPANT_REFS__DIAGNOSTICCHAIN_MAP = INTERACTION_NODE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Conversation Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_NODE_OPERATION_COUNT = INTERACTION_NODE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.CorrelationKeyImpl <em>Correlation Key</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.CorrelationKeyImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getCorrelationKey()
	 * @generated
	 */
	int CORRELATION_KEY = 55;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_KEY__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_KEY__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_KEY__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_KEY__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_KEY__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_KEY__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_KEY__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_KEY__BASE_CLASS = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Correlation Property Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_KEY__CORRELATION_PROPERTY_REF = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Correlation Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_KEY_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Correlation Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_KEY_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.CorrelationPropertyImpl <em>Correlation Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.CorrelationPropertyImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getCorrelationProperty()
	 * @generated
	 */
	int CORRELATION_PROPERTY = 56;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY__BASE_PROPERTY = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY__TYPE = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Correlation Property Retrieval Expression</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY__CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Correlation Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Correlation Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.CorrelationPropertyRetrievalExpressionImpl <em>Correlation Property Retrieval Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.CorrelationPropertyRetrievalExpressionImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getCorrelationPropertyRetrievalExpression()
	 * @generated
	 */
	int CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION = 57;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__BASE_DEPENDENCY = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Message Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_REF = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Message Path</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_PATH = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Correlation Property Retrieval Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Correlation Property Retrieval Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.FormalExpressionImpl <em>Formal Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.FormalExpressionImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getFormalExpression()
	 * @generated
	 */
	int FORMAL_EXPRESSION = 58;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_EXPRESSION__ID = BPMN_EXPRESSION__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_EXPRESSION__EXTENSION_VALUES = BPMN_EXPRESSION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_EXPRESSION__BASE_ELEMENT = BPMN_EXPRESSION__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_EXPRESSION__DOCUMENTATION = BPMN_EXPRESSION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_EXPRESSION__EXTENSION_DEFINITIONS = BPMN_EXPRESSION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_EXPRESSION__OUTGOING = BPMN_EXPRESSION__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_EXPRESSION__INCOMING = BPMN_EXPRESSION__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Opaque Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_EXPRESSION__BASE_OPAQUE_EXPRESSION = BPMN_EXPRESSION__BASE_OPAQUE_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Evaluates To Type Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_EXPRESSION__EVALUATES_TO_TYPE_REF = BPMN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Formal Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_EXPRESSION_FEATURE_COUNT = BPMN_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Formal Expressionevaluates To Type Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_EXPRESSION___FORMAL_EXPRESSIONEVALUATES_TO_TYPE_REF__DIAGNOSTICCHAIN_MAP = BPMN_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Formal Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMAL_EXPRESSION_OPERATION_COUNT = BPMN_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.CorrelationSubscriptionImpl <em>Correlation Subscription</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.CorrelationSubscriptionImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getCorrelationSubscription()
	 * @generated
	 */
	int CORRELATION_SUBSCRIPTION = 59;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_SUBSCRIPTION__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_SUBSCRIPTION__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_SUBSCRIPTION__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_SUBSCRIPTION__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_SUBSCRIPTION__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_SUBSCRIPTION__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_SUBSCRIPTION__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_SUBSCRIPTION__BASE_CLASS = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Correlation Key Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_SUBSCRIPTION__CORRELATION_KEY_REF = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Correlation Property Binding</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_SUBSCRIPTION__CORRELATION_PROPERTY_BINDING = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Correlation Subscription</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_SUBSCRIPTION_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Correlation Subscription</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_SUBSCRIPTION_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.CorrelationPropertyBindingImpl <em>Correlation Property Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.CorrelationPropertyBindingImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getCorrelationPropertyBinding()
	 * @generated
	 */
	int CORRELATION_PROPERTY_BINDING = 60;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_BINDING__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_BINDING__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_BINDING__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_BINDING__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_BINDING__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_BINDING__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_BINDING__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_BINDING__BASE_PROPERTY = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Path</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_BINDING__DATA_PATH = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Correlation Property Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_BINDING__CORRELATION_PROPERTY_REF = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Correlation Property Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_BINDING_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Correlation Property Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORRELATION_PROPERTY_BINDING_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNPropertyImpl <em>BPMN Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNPropertyImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getBPMNProperty()
	 * @generated
	 */
	int BPMN_PROPERTY = 61;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROPERTY__ID = ITEM_AWARE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROPERTY__EXTENSION_VALUES = ITEM_AWARE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROPERTY__BASE_ELEMENT = ITEM_AWARE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROPERTY__DOCUMENTATION = ITEM_AWARE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROPERTY__EXTENSION_DEFINITIONS = ITEM_AWARE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROPERTY__OUTGOING = ITEM_AWARE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROPERTY__INCOMING = ITEM_AWARE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Data State</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROPERTY__DATA_STATE = ITEM_AWARE_ELEMENT__DATA_STATE;

	/**
	 * The feature id for the '<em><b>Base Typed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROPERTY__BASE_TYPED_ELEMENT = ITEM_AWARE_ELEMENT__BASE_TYPED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Item Subject Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROPERTY__ITEM_SUBJECT_REF = ITEM_AWARE_ELEMENT__ITEM_SUBJECT_REF;

	/**
	 * The feature id for the '<em><b>Base Data Store Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROPERTY__BASE_DATA_STORE_NODE = ITEM_AWARE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uml Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROPERTY__UML_PROPERTY = ITEM_AWARE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>BPMN Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROPERTY_FEATURE_COUNT = ITEM_AWARE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Item Aware Elementdata State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROPERTY___ITEM_AWARE_ELEMENTDATA_STATE__DIAGNOSTICCHAIN_MAP = ITEM_AWARE_ELEMENT___ITEM_AWARE_ELEMENTDATA_STATE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Propertynotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROPERTY___PROPERTYNOTATION__DIAGNOSTICCHAIN_MAP = ITEM_AWARE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>BPMN Propertyapply</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROPERTY___BPMN_PROPERTYAPPLY__DIAGNOSTICCHAIN_MAP = ITEM_AWARE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>BPMN Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PROPERTY_OPERATION_COUNT = ITEM_AWARE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ResourceRoleImpl <em>Resource Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ResourceRoleImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getResourceRole()
	 * @generated
	 */
	int RESOURCE_ROLE = 62;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ROLE__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ROLE__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ROLE__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ROLE__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ROLE__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ROLE__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ROLE__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ROLE__BASE_PROPERTY = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Assignment Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ROLE__RESOURCE_ASSIGNMENT_EXPRESSION = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resource Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ROLE__RESOURCE_REF = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resource Parameter Bindings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ROLE__RESOURCE_PARAMETER_BINDINGS = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ROLE__PROCESS = BASE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Resource Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ROLE_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Resource Roleowner</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ROLE___RESOURCE_ROLEOWNER__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Resource Roleresource Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ROLE___RESOURCE_ROLERESOURCE_REF__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Resource Roleis Required</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ROLE___RESOURCE_ROLEIS_REQUIRED__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Resource Roleprocess</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ROLE___RESOURCE_ROLEPROCESS__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Resource Roleresource Parameter Bindings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ROLE___RESOURCE_ROLERESOURCE_PARAMETER_BINDINGS__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>Resource Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ROLE_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ResourceAssignmentExpressionImpl <em>Resource Assignment Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ResourceAssignmentExpressionImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getResourceAssignmentExpression()
	 * @generated
	 */
	int RESOURCE_ASSIGNMENT_EXPRESSION = 63;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ASSIGNMENT_EXPRESSION__ID = BPMN_EXPRESSION__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ASSIGNMENT_EXPRESSION__EXTENSION_VALUES = BPMN_EXPRESSION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ASSIGNMENT_EXPRESSION__BASE_ELEMENT = BPMN_EXPRESSION__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ASSIGNMENT_EXPRESSION__DOCUMENTATION = BPMN_EXPRESSION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ASSIGNMENT_EXPRESSION__EXTENSION_DEFINITIONS = BPMN_EXPRESSION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ASSIGNMENT_EXPRESSION__OUTGOING = BPMN_EXPRESSION__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ASSIGNMENT_EXPRESSION__INCOMING = BPMN_EXPRESSION__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Opaque Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ASSIGNMENT_EXPRESSION__BASE_OPAQUE_EXPRESSION = BPMN_EXPRESSION__BASE_OPAQUE_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ASSIGNMENT_EXPRESSION__EXPRESSION = BPMN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource Assignment Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ASSIGNMENT_EXPRESSION_FEATURE_COUNT = BPMN_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Resource Assignment Expressionexpression</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ASSIGNMENT_EXPRESSION___RESOURCE_ASSIGNMENT_EXPRESSIONEXPRESSION__DIAGNOSTICCHAIN_MAP = BPMN_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Resource Assignment Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ASSIGNMENT_EXPRESSION_OPERATION_COUNT = BPMN_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ResourceImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 64;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__ID = ITEM_DEFINITION__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__EXTENSION_VALUES = ITEM_DEFINITION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__BASE_ELEMENT = ITEM_DEFINITION__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DOCUMENTATION = ITEM_DEFINITION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__EXTENSION_DEFINITIONS = ITEM_DEFINITION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__OUTGOING = ITEM_DEFINITION__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__INCOMING = ITEM_DEFINITION__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__BASE_PACKAGEABLE_ELEMENT = ITEM_DEFINITION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__DEFINITION = ITEM_DEFINITION__DEFINITION;

	/**
	 * The feature id for the '<em><b>Item Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__ITEM_KIND = ITEM_DEFINITION__ITEM_KIND;

	/**
	 * The feature id for the '<em><b>Is Collection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__IS_COLLECTION = ITEM_DEFINITION__IS_COLLECTION;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__BASE_CLASS = ITEM_DEFINITION__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Structure Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__STRUCTURE_REF = ITEM_DEFINITION__STRUCTURE_REF;

	/**
	 * The feature id for the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__IMPORT = ITEM_DEFINITION__IMPORT;

	/**
	 * The feature id for the '<em><b>Resource Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__RESOURCE_PARAMETERS = ITEM_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = ITEM_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Item Definitionstructure Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE___ITEM_DEFINITIONSTRUCTURE_REF__DIAGNOSTICCHAIN_MAP = ITEM_DEFINITION___ITEM_DEFINITIONSTRUCTURE_REF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Resourceresource Parameters</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE___RESOURCERESOURCE_PARAMETERS__DIAGNOSTICCHAIN_MAP = ITEM_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = ITEM_DEFINITION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ResourceParameterImpl <em>Resource Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ResourceParameterImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getResourceParameter()
	 * @generated
	 */
	int RESOURCE_PARAMETER = 65;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER__BASE_PROPERTY = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER__TYPE = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER__IS_REQUIRED = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Resource Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Resource Parameterowner</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER___RESOURCE_PARAMETEROWNER__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Resource Parametertype</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER___RESOURCE_PARAMETERTYPE__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Resource Parameteris Required</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER___RESOURCE_PARAMETERIS_REQUIRED__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Resource Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ResourceParameterBindingImpl <em>Resource Parameter Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ResourceParameterBindingImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getResourceParameterBinding()
	 * @generated
	 */
	int RESOURCE_PARAMETER_BINDING = 66;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER_BINDING__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER_BINDING__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER_BINDING__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER_BINDING__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER_BINDING__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER_BINDING__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER_BINDING__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Slot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER_BINDING__BASE_SLOT = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER_BINDING__PARAMETER_REF = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER_BINDING__EXPRESSION = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Resource Parameter Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER_BINDING_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Resource Parameter Bindingexpression</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER_BINDING___RESOURCE_PARAMETER_BINDINGEXPRESSION__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Resource Parameter Bindingparameter Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER_BINDING___RESOURCE_PARAMETER_BINDINGPARAMETER_REF__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Resource Parameter Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER_BINDING_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.GlobalTaskImpl <em>Global Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.GlobalTaskImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getGlobalTask()
	 * @generated
	 */
	int GLOBAL_TASK = 68;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TASK__ID = CALLABLE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TASK__EXTENSION_VALUES = CALLABLE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TASK__BASE_ELEMENT = CALLABLE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TASK__DOCUMENTATION = CALLABLE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TASK__EXTENSION_DEFINITIONS = CALLABLE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TASK__OUTGOING = CALLABLE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TASK__INCOMING = CALLABLE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TASK__BASE_PACKAGEABLE_ELEMENT = CALLABLE_ELEMENT__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TASK__DEFINITION = CALLABLE_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TASK__BASE_BEHAVIOR = CALLABLE_ELEMENT__BASE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Io Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TASK__IO_SPECIFICATION = CALLABLE_ELEMENT__IO_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Supported Interface Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TASK__SUPPORTED_INTERFACE_REFS = CALLABLE_ELEMENT__SUPPORTED_INTERFACE_REFS;

	/**
	 * The feature id for the '<em><b>Io Binding</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TASK__IO_BINDING = CALLABLE_ELEMENT__IO_BINDING;

	/**
	 * The feature id for the '<em><b>Base Opaque Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TASK__BASE_OPAQUE_BEHAVIOR = CALLABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TASK__RESOURCES = CALLABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Global Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TASK_FEATURE_COUNT = CALLABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Callable Eelementsupported Interface Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TASK___CALLABLE_EELEMENTSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP = CALLABLE_ELEMENT___CALLABLE_EELEMENTSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Callable Elementresources</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TASK___CALLABLE_ELEMENTRESOURCES__DIAGNOSTICCHAIN_MAP = CALLABLE_ELEMENT___CALLABLE_ELEMENTRESOURCES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Global Tasksupported Interface Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TASK___GLOBAL_TASKSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP = CALLABLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Global Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_TASK_OPERATION_COUNT = CALLABLE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.GlobalScriptTaskImpl <em>Global Script Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.GlobalScriptTaskImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getGlobalScriptTask()
	 * @generated
	 */
	int GLOBAL_SCRIPT_TASK = 67;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK__ID = GLOBAL_TASK__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK__EXTENSION_VALUES = GLOBAL_TASK__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK__BASE_ELEMENT = GLOBAL_TASK__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK__DOCUMENTATION = GLOBAL_TASK__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK__EXTENSION_DEFINITIONS = GLOBAL_TASK__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK__OUTGOING = GLOBAL_TASK__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK__INCOMING = GLOBAL_TASK__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK__BASE_PACKAGEABLE_ELEMENT = GLOBAL_TASK__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK__DEFINITION = GLOBAL_TASK__DEFINITION;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK__BASE_BEHAVIOR = GLOBAL_TASK__BASE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Io Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK__IO_SPECIFICATION = GLOBAL_TASK__IO_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Supported Interface Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK__SUPPORTED_INTERFACE_REFS = GLOBAL_TASK__SUPPORTED_INTERFACE_REFS;

	/**
	 * The feature id for the '<em><b>Io Binding</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK__IO_BINDING = GLOBAL_TASK__IO_BINDING;

	/**
	 * The feature id for the '<em><b>Base Opaque Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK__BASE_OPAQUE_BEHAVIOR = GLOBAL_TASK__BASE_OPAQUE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK__RESOURCES = GLOBAL_TASK__RESOURCES;

	/**
	 * The feature id for the '<em><b>Script</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK__SCRIPT = GLOBAL_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Script Format</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK__SCRIPT_FORMAT = GLOBAL_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Global Script Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK_FEATURE_COUNT = GLOBAL_TASK_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Callable Eelementsupported Interface Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK___CALLABLE_EELEMENTSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP = GLOBAL_TASK___CALLABLE_EELEMENTSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Callable Elementresources</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK___CALLABLE_ELEMENTRESOURCES__DIAGNOSTICCHAIN_MAP = GLOBAL_TASK___CALLABLE_ELEMENTRESOURCES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Global Tasksupported Interface Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK___GLOBAL_TASKSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP = GLOBAL_TASK___GLOBAL_TASKSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Global Script Taskscript Format</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK___GLOBAL_SCRIPT_TASKSCRIPT_FORMAT__DIAGNOSTICCHAIN_MAP = GLOBAL_TASK_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Global Script Taskscript</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK___GLOBAL_SCRIPT_TASKSCRIPT__DIAGNOSTICCHAIN_MAP = GLOBAL_TASK_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Global Script Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SCRIPT_TASK_OPERATION_COUNT = GLOBAL_TASK_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.GlobalBusinessRuleTaskImpl <em>Global Business Rule Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.GlobalBusinessRuleTaskImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getGlobalBusinessRuleTask()
	 * @generated
	 */
	int GLOBAL_BUSINESS_RULE_TASK = 69;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_BUSINESS_RULE_TASK__ID = GLOBAL_TASK__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_BUSINESS_RULE_TASK__EXTENSION_VALUES = GLOBAL_TASK__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_BUSINESS_RULE_TASK__BASE_ELEMENT = GLOBAL_TASK__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_BUSINESS_RULE_TASK__DOCUMENTATION = GLOBAL_TASK__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_BUSINESS_RULE_TASK__EXTENSION_DEFINITIONS = GLOBAL_TASK__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_BUSINESS_RULE_TASK__OUTGOING = GLOBAL_TASK__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_BUSINESS_RULE_TASK__INCOMING = GLOBAL_TASK__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_BUSINESS_RULE_TASK__BASE_PACKAGEABLE_ELEMENT = GLOBAL_TASK__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_BUSINESS_RULE_TASK__DEFINITION = GLOBAL_TASK__DEFINITION;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_BUSINESS_RULE_TASK__BASE_BEHAVIOR = GLOBAL_TASK__BASE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Io Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_BUSINESS_RULE_TASK__IO_SPECIFICATION = GLOBAL_TASK__IO_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Supported Interface Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_BUSINESS_RULE_TASK__SUPPORTED_INTERFACE_REFS = GLOBAL_TASK__SUPPORTED_INTERFACE_REFS;

	/**
	 * The feature id for the '<em><b>Io Binding</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_BUSINESS_RULE_TASK__IO_BINDING = GLOBAL_TASK__IO_BINDING;

	/**
	 * The feature id for the '<em><b>Base Opaque Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_BUSINESS_RULE_TASK__BASE_OPAQUE_BEHAVIOR = GLOBAL_TASK__BASE_OPAQUE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_BUSINESS_RULE_TASK__RESOURCES = GLOBAL_TASK__RESOURCES;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_BUSINESS_RULE_TASK__IMPLEMENTATION = GLOBAL_TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Global Business Rule Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_BUSINESS_RULE_TASK_FEATURE_COUNT = GLOBAL_TASK_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Callable Eelementsupported Interface Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_BUSINESS_RULE_TASK___CALLABLE_EELEMENTSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP = GLOBAL_TASK___CALLABLE_EELEMENTSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Callable Elementresources</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_BUSINESS_RULE_TASK___CALLABLE_ELEMENTRESOURCES__DIAGNOSTICCHAIN_MAP = GLOBAL_TASK___CALLABLE_ELEMENTRESOURCES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Global Tasksupported Interface Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_BUSINESS_RULE_TASK___GLOBAL_TASKSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP = GLOBAL_TASK___GLOBAL_TASKSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Global Business Rule Taskimplementation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_BUSINESS_RULE_TASK___GLOBAL_BUSINESS_RULE_TASKIMPLEMENTATION__DIAGNOSTICCHAIN_MAP = GLOBAL_TASK_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Global Business Rule Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_BUSINESS_RULE_TASK_OPERATION_COUNT = GLOBAL_TASK_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.EventDefinitionImpl <em>Event Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.EventDefinitionImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getEventDefinition()
	 * @generated
	 */
	int EVENT_DEFINITION = 71;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DEFINITION__ID = ROOT_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DEFINITION__EXTENSION_VALUES = ROOT_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DEFINITION__BASE_ELEMENT = ROOT_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DEFINITION__DOCUMENTATION = ROOT_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DEFINITION__EXTENSION_DEFINITIONS = ROOT_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DEFINITION__OUTGOING = ROOT_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DEFINITION__INCOMING = ROOT_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DEFINITION__BASE_PACKAGEABLE_ELEMENT = ROOT_ELEMENT__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DEFINITION__DEFINITION = ROOT_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DEFINITION__BASE_EVENT = ROOT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Event Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DEFINITION_FEATURE_COUNT = ROOT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Event Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DEFINITION_OPERATION_COUNT = ROOT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.CompensateEventDefinitionImpl <em>Compensate Event Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.CompensateEventDefinitionImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getCompensateEventDefinition()
	 * @generated
	 */
	int COMPENSATE_EVENT_DEFINITION = 70;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATE_EVENT_DEFINITION__ID = EVENT_DEFINITION__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATE_EVENT_DEFINITION__EXTENSION_VALUES = EVENT_DEFINITION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATE_EVENT_DEFINITION__BASE_ELEMENT = EVENT_DEFINITION__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATE_EVENT_DEFINITION__DOCUMENTATION = EVENT_DEFINITION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATE_EVENT_DEFINITION__EXTENSION_DEFINITIONS = EVENT_DEFINITION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATE_EVENT_DEFINITION__OUTGOING = EVENT_DEFINITION__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATE_EVENT_DEFINITION__INCOMING = EVENT_DEFINITION__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATE_EVENT_DEFINITION__BASE_PACKAGEABLE_ELEMENT = EVENT_DEFINITION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATE_EVENT_DEFINITION__DEFINITION = EVENT_DEFINITION__DEFINITION;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATE_EVENT_DEFINITION__BASE_EVENT = EVENT_DEFINITION__BASE_EVENT;

	/**
	 * The feature id for the '<em><b>Wait For Completion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATE_EVENT_DEFINITION__WAIT_FOR_COMPLETION = EVENT_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Activity Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATE_EVENT_DEFINITION__ACTIVITY_REF = EVENT_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Call Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATE_EVENT_DEFINITION__BASE_CALL_EVENT = EVENT_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Compensate Event Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATE_EVENT_DEFINITION_FEATURE_COUNT = EVENT_DEFINITION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Compensate Event Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPENSATE_EVENT_DEFINITION_OPERATION_COUNT = EVENT_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNActivityImpl <em>BPMN Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNActivityImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getBPMNActivity()
	 * @generated
	 */
	int BPMN_ACTIVITY = 72;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__ID = FLOW_NODE__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__EXTENSION_VALUES = FLOW_NODE__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__BASE_ELEMENT = FLOW_NODE__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__DOCUMENTATION = FLOW_NODE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__EXTENSION_DEFINITIONS = FLOW_NODE__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__OUTGOING = FLOW_NODE__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__INCOMING = FLOW_NODE__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__AUDITING = FLOW_NODE__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__MONITORING = FLOW_NODE__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__CATEGORY_VALUE_REF = FLOW_NODE__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__CONTAINER = FLOW_NODE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__BASE_ACTIVITY_NODE = FLOW_NODE__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Is For Compensation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__IS_FOR_COMPENSATION = FLOW_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Start Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__START_QUANTITY = FLOW_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Completion Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__COMPLETION_QUANTITY = FLOW_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__BASE_ACTION = FLOW_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Activity Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__ACTIVITY_CLASS = FLOW_NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__PROPERTIES = FLOW_NODE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__DEFAULT = FLOW_NODE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Boundary Event Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__BOUNDARY_EVENT_REFS = FLOW_NODE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Data Input Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__DATA_INPUT_ASSOCIATIONS = FLOW_NODE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Data Output Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__DATA_OUTPUT_ASSOCIATIONS = FLOW_NODE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Loop Characteristics</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__LOOP_CHARACTERISTICS = FLOW_NODE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY__RESOURCES = FLOW_NODE_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>BPMN Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY_FEATURE_COUNT = FLOW_NODE_FEATURE_COUNT + 12;

	/**
	 * The operation id for the '<em>BPMN Activityresources</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP = FLOW_NODE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>BPMN Activitycontainer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP = FLOW_NODE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>BPMN Activityproperties</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP = FLOW_NODE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>BPMN Activitydefault</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP = FLOW_NODE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>BPMN Activityboundary Events Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP = FLOW_NODE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>BPMN Activityloop Characteristics</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP = FLOW_NODE_OPERATION_COUNT + 5;

	/**
	 * The number of operations of the '<em>BPMN Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ACTIVITY_OPERATION_COUNT = FLOW_NODE_OPERATION_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNEventImpl <em>BPMN Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNEventImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getBPMNEvent()
	 * @generated
	 */
	int BPMN_EVENT = 75;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT__ID = FLOW_NODE__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT__EXTENSION_VALUES = FLOW_NODE__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT__BASE_ELEMENT = FLOW_NODE__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT__DOCUMENTATION = FLOW_NODE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT__EXTENSION_DEFINITIONS = FLOW_NODE__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT__OUTGOING = FLOW_NODE__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT__INCOMING = FLOW_NODE__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT__AUDITING = FLOW_NODE__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT__MONITORING = FLOW_NODE__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT__CATEGORY_VALUE_REF = FLOW_NODE__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT__CONTAINER = FLOW_NODE__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT__BASE_ACTIVITY_NODE = FLOW_NODE__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Event Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT__EVENT_CLASS = FLOW_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>event Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT__EVENT_DEFINITIONS = FLOW_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT__PROPERTIES = FLOW_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Event Definition Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT__EVENT_DEFINITION_REFS = FLOW_NODE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>BPMN Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_FEATURE_COUNT = FLOW_NODE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>BPMN Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_OPERATION_COUNT = FLOW_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.CatchEventImpl <em>Catch Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.CatchEventImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getCatchEvent()
	 * @generated
	 */
	int CATCH_EVENT = 74;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EVENT__ID = BPMN_EVENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EVENT__EXTENSION_VALUES = BPMN_EVENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EVENT__BASE_ELEMENT = BPMN_EVENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EVENT__DOCUMENTATION = BPMN_EVENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EVENT__EXTENSION_DEFINITIONS = BPMN_EVENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EVENT__OUTGOING = BPMN_EVENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EVENT__INCOMING = BPMN_EVENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EVENT__AUDITING = BPMN_EVENT__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EVENT__MONITORING = BPMN_EVENT__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EVENT__CATEGORY_VALUE_REF = BPMN_EVENT__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EVENT__CONTAINER = BPMN_EVENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EVENT__BASE_ACTIVITY_NODE = BPMN_EVENT__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Event Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EVENT__EVENT_CLASS = BPMN_EVENT__EVENT_CLASS;

	/**
	 * The feature id for the '<em><b>event Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EVENT__EVENT_DEFINITIONS = BPMN_EVENT__EVENT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EVENT__PROPERTIES = BPMN_EVENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Event Definition Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EVENT__EVENT_DEFINITION_REFS = BPMN_EVENT__EVENT_DEFINITION_REFS;

	/**
	 * The feature id for the '<em><b>Parallel Multiple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EVENT__PARALLEL_MULTIPLE = BPMN_EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Accept Event Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EVENT__BASE_ACCEPT_EVENT_ACTION = BPMN_EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Initial Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EVENT__BASE_INITIAL_NODE = BPMN_EVENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Data Output Association</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EVENT__DATA_OUTPUT_ASSOCIATION = BPMN_EVENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Catch Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EVENT_FEATURE_COUNT = BPMN_EVENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Catch Eventevent Definitions Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EVENT___CATCH_EVENTEVENT_DEFINITIONS_REFS__DIAGNOSTICCHAIN_MAP = BPMN_EVENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Catch Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EVENT_OPERATION_COUNT = BPMN_EVENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BoundaryEventImpl <em>Boundary Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BoundaryEventImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getBoundaryEvent()
	 * @generated
	 */
	int BOUNDARY_EVENT = 73;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT__ID = CATCH_EVENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT__EXTENSION_VALUES = CATCH_EVENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT__BASE_ELEMENT = CATCH_EVENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT__DOCUMENTATION = CATCH_EVENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT__EXTENSION_DEFINITIONS = CATCH_EVENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT__OUTGOING = CATCH_EVENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT__INCOMING = CATCH_EVENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT__AUDITING = CATCH_EVENT__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT__MONITORING = CATCH_EVENT__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT__CATEGORY_VALUE_REF = CATCH_EVENT__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT__CONTAINER = CATCH_EVENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT__BASE_ACTIVITY_NODE = CATCH_EVENT__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Event Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT__EVENT_CLASS = CATCH_EVENT__EVENT_CLASS;

	/**
	 * The feature id for the '<em><b>event Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT__EVENT_DEFINITIONS = CATCH_EVENT__EVENT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT__PROPERTIES = CATCH_EVENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Event Definition Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT__EVENT_DEFINITION_REFS = CATCH_EVENT__EVENT_DEFINITION_REFS;

	/**
	 * The feature id for the '<em><b>Parallel Multiple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT__PARALLEL_MULTIPLE = CATCH_EVENT__PARALLEL_MULTIPLE;

	/**
	 * The feature id for the '<em><b>Base Accept Event Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT__BASE_ACCEPT_EVENT_ACTION = CATCH_EVENT__BASE_ACCEPT_EVENT_ACTION;

	/**
	 * The feature id for the '<em><b>Base Initial Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT__BASE_INITIAL_NODE = CATCH_EVENT__BASE_INITIAL_NODE;

	/**
	 * The feature id for the '<em><b>Data Output Association</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT__DATA_OUTPUT_ASSOCIATION = CATCH_EVENT__DATA_OUTPUT_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Cancel Activity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT__CANCEL_ACTIVITY = CATCH_EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attached To Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT__ATTACHED_TO_REF = CATCH_EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Boundary Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT_FEATURE_COUNT = CATCH_EVENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Catch Eventevent Definitions Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT___CATCH_EVENTEVENT_DEFINITIONS_REFS__DIAGNOSTICCHAIN_MAP = CATCH_EVENT___CATCH_EVENTEVENT_DEFINITIONS_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Boundary Eventattached To Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT___BOUNDARY_EVENTATTACHED_TO_REF__DIAGNOSTICCHAIN_MAP = CATCH_EVENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boundary Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDARY_EVENT_OPERATION_COUNT = CATCH_EVENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataAssociationImpl <em>Data Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataAssociationImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getDataAssociation()
	 * @generated
	 */
	int DATA_ASSOCIATION = 77;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ASSOCIATION__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ASSOCIATION__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ASSOCIATION__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ASSOCIATION__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ASSOCIATION__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ASSOCIATION__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ASSOCIATION__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Object Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ASSOCIATION__BASE_OBJECT_FLOW = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ASSOCIATION__SOURCE_REF = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ASSOCIATION__TARGET_REF = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ASSOCIATION__TRANSFORMATION = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Assignment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ASSOCIATION__ASSIGNMENT = BASE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Data Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ASSOCIATION_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Data Associationsource</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ASSOCIATION___DATA_ASSOCIATIONSOURCE__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Data Associationtransformation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ASSOCIATION___DATA_ASSOCIATIONTRANSFORMATION__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Data Associationtarget</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ASSOCIATION___DATA_ASSOCIATIONTARGET__DIAGNOSTICCHAIN_MAP = BASE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Data Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ASSOCIATION_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataOutputAssociationImpl <em>Data Output Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataOutputAssociationImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getDataOutputAssociation()
	 * @generated
	 */
	int DATA_OUTPUT_ASSOCIATION = 76;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_ASSOCIATION__ID = DATA_ASSOCIATION__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_ASSOCIATION__EXTENSION_VALUES = DATA_ASSOCIATION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_ASSOCIATION__BASE_ELEMENT = DATA_ASSOCIATION__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_ASSOCIATION__DOCUMENTATION = DATA_ASSOCIATION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_ASSOCIATION__EXTENSION_DEFINITIONS = DATA_ASSOCIATION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_ASSOCIATION__OUTGOING = DATA_ASSOCIATION__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_ASSOCIATION__INCOMING = DATA_ASSOCIATION__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Object Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_ASSOCIATION__BASE_OBJECT_FLOW = DATA_ASSOCIATION__BASE_OBJECT_FLOW;

	/**
	 * The feature id for the '<em><b>Source Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_ASSOCIATION__SOURCE_REF = DATA_ASSOCIATION__SOURCE_REF;

	/**
	 * The feature id for the '<em><b>Target Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_ASSOCIATION__TARGET_REF = DATA_ASSOCIATION__TARGET_REF;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_ASSOCIATION__TRANSFORMATION = DATA_ASSOCIATION__TRANSFORMATION;

	/**
	 * The feature id for the '<em><b>Assignment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_ASSOCIATION__ASSIGNMENT = DATA_ASSOCIATION__ASSIGNMENT;

	/**
	 * The number of structural features of the '<em>Data Output Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_ASSOCIATION_FEATURE_COUNT = DATA_ASSOCIATION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Data Associationsource</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_ASSOCIATION___DATA_ASSOCIATIONSOURCE__DIAGNOSTICCHAIN_MAP = DATA_ASSOCIATION___DATA_ASSOCIATIONSOURCE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Data Associationtransformation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_ASSOCIATION___DATA_ASSOCIATIONTRANSFORMATION__DIAGNOSTICCHAIN_MAP = DATA_ASSOCIATION___DATA_ASSOCIATIONTRANSFORMATION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Data Associationtarget</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_ASSOCIATION___DATA_ASSOCIATIONTARGET__DIAGNOSTICCHAIN_MAP = DATA_ASSOCIATION___DATA_ASSOCIATIONTARGET__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Data Output Associationsource</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_ASSOCIATION___DATA_OUTPUT_ASSOCIATIONSOURCE__DIAGNOSTICCHAIN_MAP = DATA_ASSOCIATION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Data Output Associationtarget</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_ASSOCIATION___DATA_OUTPUT_ASSOCIATIONTARGET__DIAGNOSTICCHAIN_MAP = DATA_ASSOCIATION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data Output Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OUTPUT_ASSOCIATION_OPERATION_COUNT = DATA_ASSOCIATION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.AssignmentImpl <em>Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.AssignmentImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getAssignment()
	 * @generated
	 */
	int ASSIGNMENT = 78;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__BASE_DEPENDENCY = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__FROM = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__TO = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataInputAssociationImpl <em>Data Input Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataInputAssociationImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getDataInputAssociation()
	 * @generated
	 */
	int DATA_INPUT_ASSOCIATION = 79;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_ASSOCIATION__ID = DATA_ASSOCIATION__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_ASSOCIATION__EXTENSION_VALUES = DATA_ASSOCIATION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_ASSOCIATION__BASE_ELEMENT = DATA_ASSOCIATION__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_ASSOCIATION__DOCUMENTATION = DATA_ASSOCIATION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_ASSOCIATION__EXTENSION_DEFINITIONS = DATA_ASSOCIATION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_ASSOCIATION__OUTGOING = DATA_ASSOCIATION__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_ASSOCIATION__INCOMING = DATA_ASSOCIATION__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Object Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_ASSOCIATION__BASE_OBJECT_FLOW = DATA_ASSOCIATION__BASE_OBJECT_FLOW;

	/**
	 * The feature id for the '<em><b>Source Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_ASSOCIATION__SOURCE_REF = DATA_ASSOCIATION__SOURCE_REF;

	/**
	 * The feature id for the '<em><b>Target Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_ASSOCIATION__TARGET_REF = DATA_ASSOCIATION__TARGET_REF;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_ASSOCIATION__TRANSFORMATION = DATA_ASSOCIATION__TRANSFORMATION;

	/**
	 * The feature id for the '<em><b>Assignment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_ASSOCIATION__ASSIGNMENT = DATA_ASSOCIATION__ASSIGNMENT;

	/**
	 * The number of structural features of the '<em>Data Input Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_ASSOCIATION_FEATURE_COUNT = DATA_ASSOCIATION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Data Associationsource</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_ASSOCIATION___DATA_ASSOCIATIONSOURCE__DIAGNOSTICCHAIN_MAP = DATA_ASSOCIATION___DATA_ASSOCIATIONSOURCE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Data Associationtransformation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_ASSOCIATION___DATA_ASSOCIATIONTRANSFORMATION__DIAGNOSTICCHAIN_MAP = DATA_ASSOCIATION___DATA_ASSOCIATIONTRANSFORMATION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Data Associationtarget</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_ASSOCIATION___DATA_ASSOCIATIONTARGET__DIAGNOSTICCHAIN_MAP = DATA_ASSOCIATION___DATA_ASSOCIATIONTARGET__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Data Input Associationsource</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_ASSOCIATION___DATA_INPUT_ASSOCIATIONSOURCE__DIAGNOSTICCHAIN_MAP = DATA_ASSOCIATION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Data Input Associationtarget</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_ASSOCIATION___DATA_INPUT_ASSOCIATIONTARGET__DIAGNOSTICCHAIN_MAP = DATA_ASSOCIATION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data Input Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_INPUT_ASSOCIATION_OPERATION_COUNT = DATA_ASSOCIATION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.LoopCharacteristicsImpl <em>Loop Characteristics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.LoopCharacteristicsImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getLoopCharacteristics()
	 * @generated
	 */
	int LOOP_CHARACTERISTICS = 80;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_CHARACTERISTICS__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_CHARACTERISTICS__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_CHARACTERISTICS__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_CHARACTERISTICS__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_CHARACTERISTICS__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_CHARACTERISTICS__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_CHARACTERISTICS__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Structured Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_CHARACTERISTICS__BASE_STRUCTURED_ACTIVITY_NODE = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Loop Characteristics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_CHARACTERISTICS_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Loop Characteristics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_CHARACTERISTICS_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.EscalationEventDefinitionImpl <em>Escalation Event Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.EscalationEventDefinitionImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getEscalationEventDefinition()
	 * @generated
	 */
	int ESCALATION_EVENT_DEFINITION = 81;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_EVENT_DEFINITION__ID = EVENT_DEFINITION__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_EVENT_DEFINITION__EXTENSION_VALUES = EVENT_DEFINITION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_EVENT_DEFINITION__BASE_ELEMENT = EVENT_DEFINITION__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_EVENT_DEFINITION__DOCUMENTATION = EVENT_DEFINITION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_EVENT_DEFINITION__EXTENSION_DEFINITIONS = EVENT_DEFINITION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_EVENT_DEFINITION__OUTGOING = EVENT_DEFINITION__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_EVENT_DEFINITION__INCOMING = EVENT_DEFINITION__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_EVENT_DEFINITION__BASE_PACKAGEABLE_ELEMENT = EVENT_DEFINITION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_EVENT_DEFINITION__DEFINITION = EVENT_DEFINITION__DEFINITION;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_EVENT_DEFINITION__BASE_EVENT = EVENT_DEFINITION__BASE_EVENT;

	/**
	 * The feature id for the '<em><b>Escalation Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_EVENT_DEFINITION__ESCALATION_REF = EVENT_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Call Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_EVENT_DEFINITION__BASE_CALL_EVENT = EVENT_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Escalation Event Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_EVENT_DEFINITION_FEATURE_COUNT = EVENT_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Escalation Event Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_EVENT_DEFINITION_OPERATION_COUNT = EVENT_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.EscalationImpl <em>Escalation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.EscalationImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getEscalation()
	 * @generated
	 */
	int ESCALATION = 82;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION__ID = ITEM_DEFINITION__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION__EXTENSION_VALUES = ITEM_DEFINITION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION__BASE_ELEMENT = ITEM_DEFINITION__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION__DOCUMENTATION = ITEM_DEFINITION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION__EXTENSION_DEFINITIONS = ITEM_DEFINITION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION__OUTGOING = ITEM_DEFINITION__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION__INCOMING = ITEM_DEFINITION__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION__BASE_PACKAGEABLE_ELEMENT = ITEM_DEFINITION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION__DEFINITION = ITEM_DEFINITION__DEFINITION;

	/**
	 * The feature id for the '<em><b>Item Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION__ITEM_KIND = ITEM_DEFINITION__ITEM_KIND;

	/**
	 * The feature id for the '<em><b>Is Collection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION__IS_COLLECTION = ITEM_DEFINITION__IS_COLLECTION;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION__BASE_CLASS = ITEM_DEFINITION__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Structure Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION__STRUCTURE_REF = ITEM_DEFINITION__STRUCTURE_REF;

	/**
	 * The feature id for the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION__IMPORT = ITEM_DEFINITION__IMPORT;

	/**
	 * The feature id for the '<em><b>Escalation Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION__ESCALATION_CODE = ITEM_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Escalation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_FEATURE_COUNT = ITEM_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Item Definitionstructure Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION___ITEM_DEFINITIONSTRUCTURE_REF__DIAGNOSTICCHAIN_MAP = ITEM_DEFINITION___ITEM_DEFINITIONSTRUCTURE_REF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Escalationstructure Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION___ESCALATIONSTRUCTURE_REF__DIAGNOSTICCHAIN_MAP = ITEM_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Escalation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_OPERATION_COUNT = ITEM_DEFINITION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.TimerEventDefinitionImpl <em>Timer Event Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.TimerEventDefinitionImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getTimerEventDefinition()
	 * @generated
	 */
	int TIMER_EVENT_DEFINITION = 83;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_EVENT_DEFINITION__ID = EVENT_DEFINITION__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_EVENT_DEFINITION__EXTENSION_VALUES = EVENT_DEFINITION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_EVENT_DEFINITION__BASE_ELEMENT = EVENT_DEFINITION__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_EVENT_DEFINITION__DOCUMENTATION = EVENT_DEFINITION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_EVENT_DEFINITION__EXTENSION_DEFINITIONS = EVENT_DEFINITION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_EVENT_DEFINITION__OUTGOING = EVENT_DEFINITION__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_EVENT_DEFINITION__INCOMING = EVENT_DEFINITION__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_EVENT_DEFINITION__BASE_PACKAGEABLE_ELEMENT = EVENT_DEFINITION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_EVENT_DEFINITION__DEFINITION = EVENT_DEFINITION__DEFINITION;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_EVENT_DEFINITION__BASE_EVENT = EVENT_DEFINITION__BASE_EVENT;

	/**
	 * The feature id for the '<em><b>Time Cycle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_EVENT_DEFINITION__TIME_CYCLE = EVENT_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Time Date</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_EVENT_DEFINITION__TIME_DATE = EVENT_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Time Duration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_EVENT_DEFINITION__TIME_DURATION = EVENT_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Change Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_EVENT_DEFINITION__BASE_CHANGE_EVENT = EVENT_DEFINITION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Timer Event Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_EVENT_DEFINITION_FEATURE_COUNT = EVENT_DEFINITION_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Timer Event Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_EVENT_DEFINITION_OPERATION_COUNT = EVENT_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.SignalEventDefinitionImpl <em>Signal Event Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.SignalEventDefinitionImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getSignalEventDefinition()
	 * @generated
	 */
	int SIGNAL_EVENT_DEFINITION = 84;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_EVENT_DEFINITION__ID = EVENT_DEFINITION__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_EVENT_DEFINITION__EXTENSION_VALUES = EVENT_DEFINITION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_EVENT_DEFINITION__BASE_ELEMENT = EVENT_DEFINITION__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_EVENT_DEFINITION__DOCUMENTATION = EVENT_DEFINITION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_EVENT_DEFINITION__EXTENSION_DEFINITIONS = EVENT_DEFINITION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_EVENT_DEFINITION__OUTGOING = EVENT_DEFINITION__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_EVENT_DEFINITION__INCOMING = EVENT_DEFINITION__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_EVENT_DEFINITION__BASE_PACKAGEABLE_ELEMENT = EVENT_DEFINITION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_EVENT_DEFINITION__DEFINITION = EVENT_DEFINITION__DEFINITION;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_EVENT_DEFINITION__BASE_EVENT = EVENT_DEFINITION__BASE_EVENT;

	/**
	 * The feature id for the '<em><b>Signal Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_EVENT_DEFINITION__SIGNAL_REF = EVENT_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Call Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_EVENT_DEFINITION__BASE_CALL_EVENT = EVENT_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Signal Event Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_EVENT_DEFINITION_FEATURE_COUNT = EVENT_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Signal Event Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_EVENT_DEFINITION_OPERATION_COUNT = EVENT_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNSignalImpl <em>BPMN Signal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNSignalImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getBPMNSignal()
	 * @generated
	 */
	int BPMN_SIGNAL = 85;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SIGNAL__ID = ITEM_DEFINITION__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SIGNAL__EXTENSION_VALUES = ITEM_DEFINITION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SIGNAL__BASE_ELEMENT = ITEM_DEFINITION__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SIGNAL__DOCUMENTATION = ITEM_DEFINITION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SIGNAL__EXTENSION_DEFINITIONS = ITEM_DEFINITION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SIGNAL__OUTGOING = ITEM_DEFINITION__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SIGNAL__INCOMING = ITEM_DEFINITION__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SIGNAL__BASE_PACKAGEABLE_ELEMENT = ITEM_DEFINITION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SIGNAL__DEFINITION = ITEM_DEFINITION__DEFINITION;

	/**
	 * The feature id for the '<em><b>Item Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SIGNAL__ITEM_KIND = ITEM_DEFINITION__ITEM_KIND;

	/**
	 * The feature id for the '<em><b>Is Collection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SIGNAL__IS_COLLECTION = ITEM_DEFINITION__IS_COLLECTION;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SIGNAL__BASE_CLASS = ITEM_DEFINITION__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Structure Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SIGNAL__STRUCTURE_REF = ITEM_DEFINITION__STRUCTURE_REF;

	/**
	 * The feature id for the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SIGNAL__IMPORT = ITEM_DEFINITION__IMPORT;

	/**
	 * The number of structural features of the '<em>BPMN Signal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SIGNAL_FEATURE_COUNT = ITEM_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Item Definitionstructure Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SIGNAL___ITEM_DEFINITIONSTRUCTURE_REF__DIAGNOSTICCHAIN_MAP = ITEM_DEFINITION___ITEM_DEFINITIONSTRUCTURE_REF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Signalstructure Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SIGNAL___BPMN_SIGNALSTRUCTURE_REF__DIAGNOSTICCHAIN_MAP = ITEM_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>BPMN Signal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SIGNAL_OPERATION_COUNT = ITEM_DEFINITION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ThrowEventImpl <em>Throw Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ThrowEventImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getThrowEvent()
	 * @generated
	 */
	int THROW_EVENT = 87;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_EVENT__ID = BPMN_EVENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_EVENT__EXTENSION_VALUES = BPMN_EVENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_EVENT__BASE_ELEMENT = BPMN_EVENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_EVENT__DOCUMENTATION = BPMN_EVENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_EVENT__EXTENSION_DEFINITIONS = BPMN_EVENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_EVENT__OUTGOING = BPMN_EVENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_EVENT__INCOMING = BPMN_EVENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_EVENT__AUDITING = BPMN_EVENT__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_EVENT__MONITORING = BPMN_EVENT__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_EVENT__CATEGORY_VALUE_REF = BPMN_EVENT__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_EVENT__CONTAINER = BPMN_EVENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_EVENT__BASE_ACTIVITY_NODE = BPMN_EVENT__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Event Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_EVENT__EVENT_CLASS = BPMN_EVENT__EVENT_CLASS;

	/**
	 * The feature id for the '<em><b>event Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_EVENT__EVENT_DEFINITIONS = BPMN_EVENT__EVENT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_EVENT__PROPERTIES = BPMN_EVENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Event Definition Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_EVENT__EVENT_DEFINITION_REFS = BPMN_EVENT__EVENT_DEFINITION_REFS;

	/**
	 * The feature id for the '<em><b>Base Call Operation Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_EVENT__BASE_CALL_OPERATION_ACTION = BPMN_EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Flow Final Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_EVENT__BASE_FLOW_FINAL_NODE = BPMN_EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Data Input Association</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_EVENT__DATA_INPUT_ASSOCIATION = BPMN_EVENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Throw Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_EVENT_FEATURE_COUNT = BPMN_EVENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Throw Eventevent Definition Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_EVENT___THROW_EVENTEVENT_DEFINITION_REFS__DIAGNOSTICCHAIN_MAP = BPMN_EVENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Throw Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROW_EVENT_OPERATION_COUNT = BPMN_EVENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.EndEventImpl <em>End Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.EndEventImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getEndEvent()
	 * @generated
	 */
	int END_EVENT = 86;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EVENT__ID = THROW_EVENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EVENT__EXTENSION_VALUES = THROW_EVENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EVENT__BASE_ELEMENT = THROW_EVENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EVENT__DOCUMENTATION = THROW_EVENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EVENT__EXTENSION_DEFINITIONS = THROW_EVENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EVENT__OUTGOING = THROW_EVENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EVENT__INCOMING = THROW_EVENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EVENT__AUDITING = THROW_EVENT__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EVENT__MONITORING = THROW_EVENT__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EVENT__CATEGORY_VALUE_REF = THROW_EVENT__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EVENT__CONTAINER = THROW_EVENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EVENT__BASE_ACTIVITY_NODE = THROW_EVENT__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Event Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EVENT__EVENT_CLASS = THROW_EVENT__EVENT_CLASS;

	/**
	 * The feature id for the '<em><b>event Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EVENT__EVENT_DEFINITIONS = THROW_EVENT__EVENT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EVENT__PROPERTIES = THROW_EVENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Event Definition Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EVENT__EVENT_DEFINITION_REFS = THROW_EVENT__EVENT_DEFINITION_REFS;

	/**
	 * The feature id for the '<em><b>Base Call Operation Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EVENT__BASE_CALL_OPERATION_ACTION = THROW_EVENT__BASE_CALL_OPERATION_ACTION;

	/**
	 * The feature id for the '<em><b>Base Flow Final Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EVENT__BASE_FLOW_FINAL_NODE = THROW_EVENT__BASE_FLOW_FINAL_NODE;

	/**
	 * The feature id for the '<em><b>Data Input Association</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EVENT__DATA_INPUT_ASSOCIATION = THROW_EVENT__DATA_INPUT_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Base Final Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EVENT__BASE_FINAL_NODE = THROW_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>End Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EVENT_FEATURE_COUNT = THROW_EVENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Throw Eventevent Definition Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EVENT___THROW_EVENTEVENT_DEFINITION_REFS__DIAGNOSTICCHAIN_MAP = THROW_EVENT___THROW_EVENTEVENT_DEFINITION_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>End Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EVENT_OPERATION_COUNT = THROW_EVENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.MessageEventDefinitionImpl <em>Message Event Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.MessageEventDefinitionImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getMessageEventDefinition()
	 * @generated
	 */
	int MESSAGE_EVENT_DEFINITION = 88;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EVENT_DEFINITION__ID = EVENT_DEFINITION__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EVENT_DEFINITION__EXTENSION_VALUES = EVENT_DEFINITION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EVENT_DEFINITION__BASE_ELEMENT = EVENT_DEFINITION__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EVENT_DEFINITION__DOCUMENTATION = EVENT_DEFINITION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EVENT_DEFINITION__EXTENSION_DEFINITIONS = EVENT_DEFINITION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EVENT_DEFINITION__OUTGOING = EVENT_DEFINITION__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EVENT_DEFINITION__INCOMING = EVENT_DEFINITION__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EVENT_DEFINITION__BASE_PACKAGEABLE_ELEMENT = EVENT_DEFINITION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EVENT_DEFINITION__DEFINITION = EVENT_DEFINITION__DEFINITION;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EVENT_DEFINITION__BASE_EVENT = EVENT_DEFINITION__BASE_EVENT;

	/**
	 * The feature id for the '<em><b>Message Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EVENT_DEFINITION__MESSAGE_REF = EVENT_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operation Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EVENT_DEFINITION__OPERATION_REF = EVENT_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Call Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EVENT_DEFINITION__BASE_CALL_EVENT = EVENT_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Message Event Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EVENT_DEFINITION_FEATURE_COUNT = EVENT_DEFINITION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Message Event Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_EVENT_DEFINITION_OPERATION_COUNT = EVENT_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.StartEventImpl <em>Start Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.StartEventImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getStartEvent()
	 * @generated
	 */
	int START_EVENT = 89;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT__ID = CATCH_EVENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT__EXTENSION_VALUES = CATCH_EVENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT__BASE_ELEMENT = CATCH_EVENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT__DOCUMENTATION = CATCH_EVENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT__EXTENSION_DEFINITIONS = CATCH_EVENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT__OUTGOING = CATCH_EVENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT__INCOMING = CATCH_EVENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT__AUDITING = CATCH_EVENT__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT__MONITORING = CATCH_EVENT__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT__CATEGORY_VALUE_REF = CATCH_EVENT__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT__CONTAINER = CATCH_EVENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT__BASE_ACTIVITY_NODE = CATCH_EVENT__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Event Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT__EVENT_CLASS = CATCH_EVENT__EVENT_CLASS;

	/**
	 * The feature id for the '<em><b>event Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT__EVENT_DEFINITIONS = CATCH_EVENT__EVENT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT__PROPERTIES = CATCH_EVENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Event Definition Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT__EVENT_DEFINITION_REFS = CATCH_EVENT__EVENT_DEFINITION_REFS;

	/**
	 * The feature id for the '<em><b>Parallel Multiple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT__PARALLEL_MULTIPLE = CATCH_EVENT__PARALLEL_MULTIPLE;

	/**
	 * The feature id for the '<em><b>Base Accept Event Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT__BASE_ACCEPT_EVENT_ACTION = CATCH_EVENT__BASE_ACCEPT_EVENT_ACTION;

	/**
	 * The feature id for the '<em><b>Base Initial Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT__BASE_INITIAL_NODE = CATCH_EVENT__BASE_INITIAL_NODE;

	/**
	 * The feature id for the '<em><b>Data Output Association</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT__DATA_OUTPUT_ASSOCIATION = CATCH_EVENT__DATA_OUTPUT_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Is Interrupting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT__IS_INTERRUPTING = CATCH_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Start Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT_FEATURE_COUNT = CATCH_EVENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Catch Eventevent Definitions Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT___CATCH_EVENTEVENT_DEFINITIONS_REFS__DIAGNOSTICCHAIN_MAP = CATCH_EVENT___CATCH_EVENTEVENT_DEFINITIONS_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Start Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_EVENT_OPERATION_COUNT = CATCH_EVENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ConditionalEventDefinitionImpl <em>Conditional Event Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ConditionalEventDefinitionImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getConditionalEventDefinition()
	 * @generated
	 */
	int CONDITIONAL_EVENT_DEFINITION = 90;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EVENT_DEFINITION__ID = EVENT_DEFINITION__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EVENT_DEFINITION__EXTENSION_VALUES = EVENT_DEFINITION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EVENT_DEFINITION__BASE_ELEMENT = EVENT_DEFINITION__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EVENT_DEFINITION__DOCUMENTATION = EVENT_DEFINITION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EVENT_DEFINITION__EXTENSION_DEFINITIONS = EVENT_DEFINITION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EVENT_DEFINITION__OUTGOING = EVENT_DEFINITION__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EVENT_DEFINITION__INCOMING = EVENT_DEFINITION__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EVENT_DEFINITION__BASE_PACKAGEABLE_ELEMENT = EVENT_DEFINITION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EVENT_DEFINITION__DEFINITION = EVENT_DEFINITION__DEFINITION;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EVENT_DEFINITION__BASE_EVENT = EVENT_DEFINITION__BASE_EVENT;

	/**
	 * The feature id for the '<em><b>Base Change Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EVENT_DEFINITION__BASE_CHANGE_EVENT = EVENT_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EVENT_DEFINITION__CONDITION = EVENT_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Conditional Event Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EVENT_DEFINITION_FEATURE_COUNT = EVENT_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Conditional Event Definitioncondition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EVENT_DEFINITION___CONDITIONAL_EVENT_DEFINITIONCONDITION__DIAGNOSTICCHAIN_MAP = EVENT_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Conditional Event Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EVENT_DEFINITION_OPERATION_COUNT = EVENT_DEFINITION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.LinkEventDefinitionImpl <em>Link Event Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.LinkEventDefinitionImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getLinkEventDefinition()
	 * @generated
	 */
	int LINK_EVENT_DEFINITION = 91;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_EVENT_DEFINITION__ID = EVENT_DEFINITION__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_EVENT_DEFINITION__EXTENSION_VALUES = EVENT_DEFINITION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_EVENT_DEFINITION__BASE_ELEMENT = EVENT_DEFINITION__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_EVENT_DEFINITION__DOCUMENTATION = EVENT_DEFINITION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_EVENT_DEFINITION__EXTENSION_DEFINITIONS = EVENT_DEFINITION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_EVENT_DEFINITION__OUTGOING = EVENT_DEFINITION__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_EVENT_DEFINITION__INCOMING = EVENT_DEFINITION__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_EVENT_DEFINITION__BASE_PACKAGEABLE_ELEMENT = EVENT_DEFINITION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_EVENT_DEFINITION__DEFINITION = EVENT_DEFINITION__DEFINITION;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_EVENT_DEFINITION__BASE_EVENT = EVENT_DEFINITION__BASE_EVENT;

	/**
	 * The feature id for the '<em><b>target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_EVENT_DEFINITION__TARGET = EVENT_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_EVENT_DEFINITION__SOURCE = EVENT_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Call Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_EVENT_DEFINITION__BASE_CALL_EVENT = EVENT_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Link Event Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_EVENT_DEFINITION_FEATURE_COUNT = EVENT_DEFINITION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Link Event Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_EVENT_DEFINITION_OPERATION_COUNT = EVENT_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ErrorEventDefinitionImpl <em>Error Event Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ErrorEventDefinitionImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getErrorEventDefinition()
	 * @generated
	 */
	int ERROR_EVENT_DEFINITION = 92;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_EVENT_DEFINITION__ID = EVENT_DEFINITION__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_EVENT_DEFINITION__EXTENSION_VALUES = EVENT_DEFINITION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_EVENT_DEFINITION__BASE_ELEMENT = EVENT_DEFINITION__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_EVENT_DEFINITION__DOCUMENTATION = EVENT_DEFINITION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_EVENT_DEFINITION__EXTENSION_DEFINITIONS = EVENT_DEFINITION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_EVENT_DEFINITION__OUTGOING = EVENT_DEFINITION__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_EVENT_DEFINITION__INCOMING = EVENT_DEFINITION__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_EVENT_DEFINITION__BASE_PACKAGEABLE_ELEMENT = EVENT_DEFINITION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_EVENT_DEFINITION__DEFINITION = EVENT_DEFINITION__DEFINITION;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_EVENT_DEFINITION__BASE_EVENT = EVENT_DEFINITION__BASE_EVENT;

	/**
	 * The feature id for the '<em><b>Error Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_EVENT_DEFINITION__ERROR_REF = EVENT_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Call Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_EVENT_DEFINITION__BASE_CALL_EVENT = EVENT_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Error Event Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_EVENT_DEFINITION_FEATURE_COUNT = EVENT_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Error Event Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_EVENT_DEFINITION_OPERATION_COUNT = EVENT_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.IntermediateCatchEventImpl <em>Intermediate Catch Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.IntermediateCatchEventImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getIntermediateCatchEvent()
	 * @generated
	 */
	int INTERMEDIATE_CATCH_EVENT = 93;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CATCH_EVENT__ID = CATCH_EVENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CATCH_EVENT__EXTENSION_VALUES = CATCH_EVENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CATCH_EVENT__BASE_ELEMENT = CATCH_EVENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CATCH_EVENT__DOCUMENTATION = CATCH_EVENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CATCH_EVENT__EXTENSION_DEFINITIONS = CATCH_EVENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CATCH_EVENT__OUTGOING = CATCH_EVENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CATCH_EVENT__INCOMING = CATCH_EVENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CATCH_EVENT__AUDITING = CATCH_EVENT__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CATCH_EVENT__MONITORING = CATCH_EVENT__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CATCH_EVENT__CATEGORY_VALUE_REF = CATCH_EVENT__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CATCH_EVENT__CONTAINER = CATCH_EVENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CATCH_EVENT__BASE_ACTIVITY_NODE = CATCH_EVENT__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Event Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CATCH_EVENT__EVENT_CLASS = CATCH_EVENT__EVENT_CLASS;

	/**
	 * The feature id for the '<em><b>event Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CATCH_EVENT__EVENT_DEFINITIONS = CATCH_EVENT__EVENT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CATCH_EVENT__PROPERTIES = CATCH_EVENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Event Definition Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CATCH_EVENT__EVENT_DEFINITION_REFS = CATCH_EVENT__EVENT_DEFINITION_REFS;

	/**
	 * The feature id for the '<em><b>Parallel Multiple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CATCH_EVENT__PARALLEL_MULTIPLE = CATCH_EVENT__PARALLEL_MULTIPLE;

	/**
	 * The feature id for the '<em><b>Base Accept Event Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CATCH_EVENT__BASE_ACCEPT_EVENT_ACTION = CATCH_EVENT__BASE_ACCEPT_EVENT_ACTION;

	/**
	 * The feature id for the '<em><b>Base Initial Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CATCH_EVENT__BASE_INITIAL_NODE = CATCH_EVENT__BASE_INITIAL_NODE;

	/**
	 * The feature id for the '<em><b>Data Output Association</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CATCH_EVENT__DATA_OUTPUT_ASSOCIATION = CATCH_EVENT__DATA_OUTPUT_ASSOCIATION;

	/**
	 * The number of structural features of the '<em>Intermediate Catch Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CATCH_EVENT_FEATURE_COUNT = CATCH_EVENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Catch Eventevent Definitions Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CATCH_EVENT___CATCH_EVENTEVENT_DEFINITIONS_REFS__DIAGNOSTICCHAIN_MAP = CATCH_EVENT___CATCH_EVENTEVENT_DEFINITIONS_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Intermediate Catch Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_CATCH_EVENT_OPERATION_COUNT = CATCH_EVENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.IntermediateThrowEventImpl <em>Intermediate Throw Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.IntermediateThrowEventImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getIntermediateThrowEvent()
	 * @generated
	 */
	int INTERMEDIATE_THROW_EVENT = 94;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_THROW_EVENT__ID = THROW_EVENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_THROW_EVENT__EXTENSION_VALUES = THROW_EVENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_THROW_EVENT__BASE_ELEMENT = THROW_EVENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_THROW_EVENT__DOCUMENTATION = THROW_EVENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_THROW_EVENT__EXTENSION_DEFINITIONS = THROW_EVENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_THROW_EVENT__OUTGOING = THROW_EVENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_THROW_EVENT__INCOMING = THROW_EVENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_THROW_EVENT__AUDITING = THROW_EVENT__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_THROW_EVENT__MONITORING = THROW_EVENT__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_THROW_EVENT__CATEGORY_VALUE_REF = THROW_EVENT__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_THROW_EVENT__CONTAINER = THROW_EVENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_THROW_EVENT__BASE_ACTIVITY_NODE = THROW_EVENT__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Event Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_THROW_EVENT__EVENT_CLASS = THROW_EVENT__EVENT_CLASS;

	/**
	 * The feature id for the '<em><b>event Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_THROW_EVENT__EVENT_DEFINITIONS = THROW_EVENT__EVENT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_THROW_EVENT__PROPERTIES = THROW_EVENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Event Definition Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_THROW_EVENT__EVENT_DEFINITION_REFS = THROW_EVENT__EVENT_DEFINITION_REFS;

	/**
	 * The feature id for the '<em><b>Base Call Operation Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_THROW_EVENT__BASE_CALL_OPERATION_ACTION = THROW_EVENT__BASE_CALL_OPERATION_ACTION;

	/**
	 * The feature id for the '<em><b>Base Flow Final Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_THROW_EVENT__BASE_FLOW_FINAL_NODE = THROW_EVENT__BASE_FLOW_FINAL_NODE;

	/**
	 * The feature id for the '<em><b>Data Input Association</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_THROW_EVENT__DATA_INPUT_ASSOCIATION = THROW_EVENT__DATA_INPUT_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Base Send Object Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_THROW_EVENT__BASE_SEND_OBJECT_ACTION = THROW_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Intermediate Throw Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_THROW_EVENT_FEATURE_COUNT = THROW_EVENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Throw Eventevent Definition Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_THROW_EVENT___THROW_EVENTEVENT_DEFINITION_REFS__DIAGNOSTICCHAIN_MAP = THROW_EVENT___THROW_EVENTEVENT_DEFINITION_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Intermediate Throw Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_THROW_EVENT_OPERATION_COUNT = THROW_EVENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.TerminateEventDefinitionImpl <em>Terminate Event Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.TerminateEventDefinitionImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getTerminateEventDefinition()
	 * @generated
	 */
	int TERMINATE_EVENT_DEFINITION = 95;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE_EVENT_DEFINITION__ID = EVENT_DEFINITION__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE_EVENT_DEFINITION__EXTENSION_VALUES = EVENT_DEFINITION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE_EVENT_DEFINITION__BASE_ELEMENT = EVENT_DEFINITION__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE_EVENT_DEFINITION__DOCUMENTATION = EVENT_DEFINITION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE_EVENT_DEFINITION__EXTENSION_DEFINITIONS = EVENT_DEFINITION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE_EVENT_DEFINITION__OUTGOING = EVENT_DEFINITION__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE_EVENT_DEFINITION__INCOMING = EVENT_DEFINITION__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE_EVENT_DEFINITION__BASE_PACKAGEABLE_ELEMENT = EVENT_DEFINITION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE_EVENT_DEFINITION__DEFINITION = EVENT_DEFINITION__DEFINITION;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE_EVENT_DEFINITION__BASE_EVENT = EVENT_DEFINITION__BASE_EVENT;

	/**
	 * The feature id for the '<em><b>Base Call Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE_EVENT_DEFINITION__BASE_CALL_EVENT = EVENT_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Terminate Event Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE_EVENT_DEFINITION_FEATURE_COUNT = EVENT_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Terminate Event Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINATE_EVENT_DEFINITION_OPERATION_COUNT = EVENT_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ImplicitThrowEventImpl <em>Implicit Throw Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ImplicitThrowEventImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getImplicitThrowEvent()
	 * @generated
	 */
	int IMPLICIT_THROW_EVENT = 96;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_THROW_EVENT__ID = THROW_EVENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_THROW_EVENT__EXTENSION_VALUES = THROW_EVENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_THROW_EVENT__BASE_ELEMENT = THROW_EVENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_THROW_EVENT__DOCUMENTATION = THROW_EVENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_THROW_EVENT__EXTENSION_DEFINITIONS = THROW_EVENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_THROW_EVENT__OUTGOING = THROW_EVENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_THROW_EVENT__INCOMING = THROW_EVENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_THROW_EVENT__AUDITING = THROW_EVENT__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_THROW_EVENT__MONITORING = THROW_EVENT__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_THROW_EVENT__CATEGORY_VALUE_REF = THROW_EVENT__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_THROW_EVENT__CONTAINER = THROW_EVENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_THROW_EVENT__BASE_ACTIVITY_NODE = THROW_EVENT__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Event Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_THROW_EVENT__EVENT_CLASS = THROW_EVENT__EVENT_CLASS;

	/**
	 * The feature id for the '<em><b>event Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_THROW_EVENT__EVENT_DEFINITIONS = THROW_EVENT__EVENT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_THROW_EVENT__PROPERTIES = THROW_EVENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Event Definition Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_THROW_EVENT__EVENT_DEFINITION_REFS = THROW_EVENT__EVENT_DEFINITION_REFS;

	/**
	 * The feature id for the '<em><b>Base Call Operation Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_THROW_EVENT__BASE_CALL_OPERATION_ACTION = THROW_EVENT__BASE_CALL_OPERATION_ACTION;

	/**
	 * The feature id for the '<em><b>Base Flow Final Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_THROW_EVENT__BASE_FLOW_FINAL_NODE = THROW_EVENT__BASE_FLOW_FINAL_NODE;

	/**
	 * The feature id for the '<em><b>Data Input Association</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_THROW_EVENT__DATA_INPUT_ASSOCIATION = THROW_EVENT__DATA_INPUT_ASSOCIATION;

	/**
	 * The number of structural features of the '<em>Implicit Throw Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_THROW_EVENT_FEATURE_COUNT = THROW_EVENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Throw Eventevent Definition Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_THROW_EVENT___THROW_EVENTEVENT_DEFINITION_REFS__DIAGNOSTICCHAIN_MAP = THROW_EVENT___THROW_EVENTEVENT_DEFINITION_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Implicit Throw Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICIT_THROW_EVENT_OPERATION_COUNT = THROW_EVENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.CancelEventDefinitionImpl <em>Cancel Event Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.CancelEventDefinitionImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getCancelEventDefinition()
	 * @generated
	 */
	int CANCEL_EVENT_DEFINITION = 97;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_EVENT_DEFINITION__ID = EVENT_DEFINITION__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_EVENT_DEFINITION__EXTENSION_VALUES = EVENT_DEFINITION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_EVENT_DEFINITION__BASE_ELEMENT = EVENT_DEFINITION__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_EVENT_DEFINITION__DOCUMENTATION = EVENT_DEFINITION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_EVENT_DEFINITION__EXTENSION_DEFINITIONS = EVENT_DEFINITION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_EVENT_DEFINITION__OUTGOING = EVENT_DEFINITION__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_EVENT_DEFINITION__INCOMING = EVENT_DEFINITION__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_EVENT_DEFINITION__BASE_PACKAGEABLE_ELEMENT = EVENT_DEFINITION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_EVENT_DEFINITION__DEFINITION = EVENT_DEFINITION__DEFINITION;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_EVENT_DEFINITION__BASE_EVENT = EVENT_DEFINITION__BASE_EVENT;

	/**
	 * The feature id for the '<em><b>Base Call Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_EVENT_DEFINITION__BASE_CALL_EVENT = EVENT_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cancel Event Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_EVENT_DEFINITION_FEATURE_COUNT = EVENT_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Cancel Event Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_EVENT_DEFINITION_OPERATION_COUNT = EVENT_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.TextAnnotationImpl <em>Text Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.TextAnnotationImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getTextAnnotation()
	 * @generated
	 */
	int TEXT_ANNOTATION = 98;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ANNOTATION__ID = BPMN_ARTIFACT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ANNOTATION__EXTENSION_VALUES = BPMN_ARTIFACT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ANNOTATION__BASE_ELEMENT = BPMN_ARTIFACT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ANNOTATION__DOCUMENTATION = BPMN_ARTIFACT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ANNOTATION__EXTENSION_DEFINITIONS = BPMN_ARTIFACT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ANNOTATION__OUTGOING = BPMN_ARTIFACT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ANNOTATION__INCOMING = BPMN_ARTIFACT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Comment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ANNOTATION__BASE_COMMENT = BPMN_ARTIFACT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ANNOTATION__TEXT_FORMAT = BPMN_ARTIFACT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ANNOTATION__TEXT = BPMN_ARTIFACT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Text Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ANNOTATION_FEATURE_COUNT = BPMN_ARTIFACT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Text Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ANNOTATION_OPERATION_COUNT = BPMN_ARTIFACT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.CategoryImpl <em>Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.CategoryImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getCategory()
	 * @generated
	 */
	int CATEGORY = 99;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__ID = ROOT_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__EXTENSION_VALUES = ROOT_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__BASE_ELEMENT = ROOT_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__DOCUMENTATION = ROOT_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__EXTENSION_DEFINITIONS = ROOT_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__OUTGOING = ROOT_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__INCOMING = ROOT_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__BASE_PACKAGEABLE_ELEMENT = ROOT_ELEMENT__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__DEFINITION = ROOT_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Base Enumeration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__BASE_ENUMERATION = ROOT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Category Value</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__CATEGORY_VALUE = ROOT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_FEATURE_COUNT = ROOT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_OPERATION_COUNT = ROOT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.GroupImpl <em>Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.GroupImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getGroup()
	 * @generated
	 */
	int GROUP = 100;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__ID = BPMN_ARTIFACT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__EXTENSION_VALUES = BPMN_ARTIFACT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__BASE_ELEMENT = BPMN_ARTIFACT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__DOCUMENTATION = BPMN_ARTIFACT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__EXTENSION_DEFINITIONS = BPMN_ARTIFACT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__OUTGOING = BPMN_ARTIFACT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__INCOMING = BPMN_ARTIFACT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Activity Partition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__BASE_ACTIVITY_PARTITION = BPMN_ARTIFACT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__CATEGORY_VALUE_REF = BPMN_ARTIFACT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE_COUNT = BPMN_ARTIFACT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_OPERATION_COUNT = BPMN_ARTIFACT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataObjectReferenceImpl <em>Data Object Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataObjectReferenceImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getDataObjectReference()
	 * @generated
	 */
	int DATA_OBJECT_REFERENCE = 101;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_REFERENCE__ID = FLOW_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_REFERENCE__EXTENSION_VALUES = FLOW_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_REFERENCE__BASE_ELEMENT = FLOW_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_REFERENCE__DOCUMENTATION = FLOW_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_REFERENCE__EXTENSION_DEFINITIONS = FLOW_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_REFERENCE__OUTGOING = FLOW_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_REFERENCE__INCOMING = FLOW_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_REFERENCE__AUDITING = FLOW_ELEMENT__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_REFERENCE__MONITORING = FLOW_ELEMENT__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_REFERENCE__CATEGORY_VALUE_REF = FLOW_ELEMENT__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_REFERENCE__CONTAINER = FLOW_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Data State</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_REFERENCE__DATA_STATE = FLOW_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Typed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_REFERENCE__BASE_TYPED_ELEMENT = FLOW_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Item Subject Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_REFERENCE__ITEM_SUBJECT_REF = FLOW_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Data Object Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_REFERENCE__DATA_OBJECT_REF = FLOW_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Base Data Store Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_REFERENCE__BASE_DATA_STORE_NODE = FLOW_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Data Object Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_REFERENCE_FEATURE_COUNT = FLOW_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Item Aware Elementdata State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_REFERENCE___ITEM_AWARE_ELEMENTDATA_STATE__DIAGNOSTICCHAIN_MAP = FLOW_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Data Object Refsourcetarget</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_REFERENCE___DATA_OBJECT_REFSOURCETARGET__DIAGNOSTICCHAIN_MAP = FLOW_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Data Object Refdata State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_REFERENCE___DATA_OBJECT_REFDATA_STATE__DIAGNOSTICCHAIN_MAP = FLOW_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Data Object Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_REFERENCE_OPERATION_COUNT = FLOW_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataObjectImpl <em>Data Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataObjectImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getDataObject()
	 * @generated
	 */
	int DATA_OBJECT = 102;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__ID = FLOW_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__EXTENSION_VALUES = FLOW_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__BASE_ELEMENT = FLOW_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__DOCUMENTATION = FLOW_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__EXTENSION_DEFINITIONS = FLOW_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__OUTGOING = FLOW_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__INCOMING = FLOW_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__AUDITING = FLOW_ELEMENT__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__MONITORING = FLOW_ELEMENT__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__CATEGORY_VALUE_REF = FLOW_ELEMENT__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__CONTAINER = FLOW_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Data State</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__DATA_STATE = FLOW_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Typed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__BASE_TYPED_ELEMENT = FLOW_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Item Subject Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__ITEM_SUBJECT_REF = FLOW_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Collection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__IS_COLLECTION = FLOW_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Base Data Store Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__BASE_DATA_STORE_NODE = FLOW_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Data Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_FEATURE_COUNT = FLOW_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Item Aware Elementdata State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT___ITEM_AWARE_ELEMENTDATA_STATE__DIAGNOSTICCHAIN_MAP = FLOW_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Data Objectdata State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT___DATA_OBJECTDATA_STATE__DIAGNOSTICCHAIN_MAP = FLOW_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_OPERATION_COUNT = FLOW_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataStoreImpl <em>Data Store</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataStoreImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getDataStore()
	 * @generated
	 */
	int DATA_STORE = 103;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__ID = ROOT_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__EXTENSION_VALUES = ROOT_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__BASE_ELEMENT = ROOT_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__DOCUMENTATION = ROOT_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__EXTENSION_DEFINITIONS = ROOT_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__OUTGOING = ROOT_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__INCOMING = ROOT_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__BASE_PACKAGEABLE_ELEMENT = ROOT_ELEMENT__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__DEFINITION = ROOT_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__CAPACITY = ROOT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Unlimited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__IS_UNLIMITED = ROOT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__BASE_CLASS = ROOT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Item Subject Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE__ITEM_SUBJECT_REF = ROOT_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Data Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_FEATURE_COUNT = ROOT_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Data Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_OPERATION_COUNT = ROOT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataStoreReferenceImpl <em>Data Store Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataStoreReferenceImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getDataStoreReference()
	 * @generated
	 */
	int DATA_STORE_REFERENCE = 104;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_REFERENCE__ID = FLOW_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_REFERENCE__EXTENSION_VALUES = FLOW_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_REFERENCE__BASE_ELEMENT = FLOW_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_REFERENCE__DOCUMENTATION = FLOW_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_REFERENCE__EXTENSION_DEFINITIONS = FLOW_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_REFERENCE__OUTGOING = FLOW_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_REFERENCE__INCOMING = FLOW_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_REFERENCE__AUDITING = FLOW_ELEMENT__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_REFERENCE__MONITORING = FLOW_ELEMENT__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_REFERENCE__CATEGORY_VALUE_REF = FLOW_ELEMENT__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_REFERENCE__CONTAINER = FLOW_ELEMENT__CONTAINER;

	/**
	 * The feature id for the '<em><b>Data State</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_REFERENCE__DATA_STATE = FLOW_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Typed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_REFERENCE__BASE_TYPED_ELEMENT = FLOW_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Item Subject Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_REFERENCE__ITEM_SUBJECT_REF = FLOW_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>data Store</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_REFERENCE__DATA_STORE = FLOW_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Base Data Store Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_REFERENCE__BASE_DATA_STORE_NODE = FLOW_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Data Store Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_REFERENCE_FEATURE_COUNT = FLOW_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Item Aware Elementdata State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_REFERENCE___ITEM_AWARE_ELEMENTDATA_STATE__DIAGNOSTICCHAIN_MAP = FLOW_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Data Store Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STORE_REFERENCE_OPERATION_COUNT = FLOW_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.TaskImpl <em>Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.TaskImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getTask()
	 * @generated
	 */
	int TASK = 106;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__ID = BPMN_ACTIVITY__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__EXTENSION_VALUES = BPMN_ACTIVITY__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__BASE_ELEMENT = BPMN_ACTIVITY__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__DOCUMENTATION = BPMN_ACTIVITY__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__EXTENSION_DEFINITIONS = BPMN_ACTIVITY__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__OUTGOING = BPMN_ACTIVITY__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__INCOMING = BPMN_ACTIVITY__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__AUDITING = BPMN_ACTIVITY__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__MONITORING = BPMN_ACTIVITY__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__CATEGORY_VALUE_REF = BPMN_ACTIVITY__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__CONTAINER = BPMN_ACTIVITY__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__BASE_ACTIVITY_NODE = BPMN_ACTIVITY__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Is For Compensation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__IS_FOR_COMPENSATION = BPMN_ACTIVITY__IS_FOR_COMPENSATION;

	/**
	 * The feature id for the '<em><b>Start Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__START_QUANTITY = BPMN_ACTIVITY__START_QUANTITY;

	/**
	 * The feature id for the '<em><b>Completion Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__COMPLETION_QUANTITY = BPMN_ACTIVITY__COMPLETION_QUANTITY;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__BASE_ACTION = BPMN_ACTIVITY__BASE_ACTION;

	/**
	 * The feature id for the '<em><b>Activity Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__ACTIVITY_CLASS = BPMN_ACTIVITY__ACTIVITY_CLASS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__PROPERTIES = BPMN_ACTIVITY__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__DEFAULT = BPMN_ACTIVITY__DEFAULT;

	/**
	 * The feature id for the '<em><b>Boundary Event Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__BOUNDARY_EVENT_REFS = BPMN_ACTIVITY__BOUNDARY_EVENT_REFS;

	/**
	 * The feature id for the '<em><b>Data Input Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__DATA_INPUT_ASSOCIATIONS = BPMN_ACTIVITY__DATA_INPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Data Output Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__DATA_OUTPUT_ASSOCIATIONS = BPMN_ACTIVITY__DATA_OUTPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Loop Characteristics</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__LOOP_CHARACTERISTICS = BPMN_ACTIVITY__LOOP_CHARACTERISTICS;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__RESOURCES = BPMN_ACTIVITY__RESOURCES;

	/**
	 * The feature id for the '<em><b>Io Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__IO_SPECIFICATION = BPMN_ACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_FEATURE_COUNT = BPMN_ACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>BPMN Activityresources</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP = BPMN_ACTIVITY___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitycontainer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP = BPMN_ACTIVITY___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityproperties</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP = BPMN_ACTIVITY___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitydefault</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP = BPMN_ACTIVITY___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityboundary Events Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP = BPMN_ACTIVITY___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityloop Characteristics</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP = BPMN_ACTIVITY___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_OPERATION_COUNT = BPMN_ACTIVITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.UserTaskImpl <em>User Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.UserTaskImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getUserTask()
	 * @generated
	 */
	int USER_TASK = 105;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__ID = TASK__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__EXTENSION_VALUES = TASK__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__BASE_ELEMENT = TASK__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__DOCUMENTATION = TASK__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__EXTENSION_DEFINITIONS = TASK__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__OUTGOING = TASK__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__INCOMING = TASK__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__AUDITING = TASK__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__MONITORING = TASK__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__CATEGORY_VALUE_REF = TASK__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__CONTAINER = TASK__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__BASE_ACTIVITY_NODE = TASK__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Is For Compensation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__IS_FOR_COMPENSATION = TASK__IS_FOR_COMPENSATION;

	/**
	 * The feature id for the '<em><b>Start Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__START_QUANTITY = TASK__START_QUANTITY;

	/**
	 * The feature id for the '<em><b>Completion Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__COMPLETION_QUANTITY = TASK__COMPLETION_QUANTITY;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__BASE_ACTION = TASK__BASE_ACTION;

	/**
	 * The feature id for the '<em><b>Activity Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__ACTIVITY_CLASS = TASK__ACTIVITY_CLASS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__PROPERTIES = TASK__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__DEFAULT = TASK__DEFAULT;

	/**
	 * The feature id for the '<em><b>Boundary Event Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__BOUNDARY_EVENT_REFS = TASK__BOUNDARY_EVENT_REFS;

	/**
	 * The feature id for the '<em><b>Data Input Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__DATA_INPUT_ASSOCIATIONS = TASK__DATA_INPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Data Output Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__DATA_OUTPUT_ASSOCIATIONS = TASK__DATA_OUTPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Loop Characteristics</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__LOOP_CHARACTERISTICS = TASK__LOOP_CHARACTERISTICS;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__RESOURCES = TASK__RESOURCES;

	/**
	 * The feature id for the '<em><b>Io Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__IO_SPECIFICATION = TASK__IO_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Opaque Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__BASE_OPAQUE_ACTION = TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__IMPLEMENTATION = TASK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Renderings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK__RENDERINGS = TASK_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>User Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK_FEATURE_COUNT = TASK_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>BPMN Activityresources</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitycontainer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityproperties</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitydefault</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityboundary Events Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityloop Characteristics</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>User Taskimplementation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK___USER_TASKIMPLEMENTATION__DIAGNOSTICCHAIN_MAP = TASK_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>User Taskrenderings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK___USER_TASKRENDERINGS__DIAGNOSTICCHAIN_MAP = TASK_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>User Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_TASK_OPERATION_COUNT = TASK_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.RenderingImpl <em>Rendering</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.RenderingImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getRendering()
	 * @generated
	 */
	int RENDERING = 107;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDERING__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDERING__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDERING__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDERING__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDERING__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDERING__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDERING__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDERING__BASE_IMAGE = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rendering</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDERING_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Rendering</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENDERING_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.PerformerImpl <em>Performer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.PerformerImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getPerformer()
	 * @generated
	 */
	int PERFORMER = 109;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER__ID = RESOURCE_ROLE__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER__EXTENSION_VALUES = RESOURCE_ROLE__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER__BASE_ELEMENT = RESOURCE_ROLE__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER__DOCUMENTATION = RESOURCE_ROLE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER__EXTENSION_DEFINITIONS = RESOURCE_ROLE__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER__OUTGOING = RESOURCE_ROLE__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER__INCOMING = RESOURCE_ROLE__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER__BASE_PROPERTY = RESOURCE_ROLE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Resource Assignment Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER__RESOURCE_ASSIGNMENT_EXPRESSION = RESOURCE_ROLE__RESOURCE_ASSIGNMENT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Resource Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER__RESOURCE_REF = RESOURCE_ROLE__RESOURCE_REF;

	/**
	 * The feature id for the '<em><b>Resource Parameter Bindings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER__RESOURCE_PARAMETER_BINDINGS = RESOURCE_ROLE__RESOURCE_PARAMETER_BINDINGS;

	/**
	 * The feature id for the '<em><b>Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER__PROCESS = RESOURCE_ROLE__PROCESS;

	/**
	 * The number of structural features of the '<em>Performer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER_FEATURE_COUNT = RESOURCE_ROLE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Resource Roleowner</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER___RESOURCE_ROLEOWNER__DIAGNOSTICCHAIN_MAP = RESOURCE_ROLE___RESOURCE_ROLEOWNER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Resource Roleresource Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER___RESOURCE_ROLERESOURCE_REF__DIAGNOSTICCHAIN_MAP = RESOURCE_ROLE___RESOURCE_ROLERESOURCE_REF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Resource Roleis Required</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER___RESOURCE_ROLEIS_REQUIRED__DIAGNOSTICCHAIN_MAP = RESOURCE_ROLE___RESOURCE_ROLEIS_REQUIRED__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Resource Roleprocess</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER___RESOURCE_ROLEPROCESS__DIAGNOSTICCHAIN_MAP = RESOURCE_ROLE___RESOURCE_ROLEPROCESS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Resource Roleresource Parameter Bindings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER___RESOURCE_ROLERESOURCE_PARAMETER_BINDINGS__DIAGNOSTICCHAIN_MAP = RESOURCE_ROLE___RESOURCE_ROLERESOURCE_PARAMETER_BINDINGS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Performer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMER_OPERATION_COUNT = RESOURCE_ROLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.HumanPerformerImpl <em>Human Performer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.HumanPerformerImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getHumanPerformer()
	 * @generated
	 */
	int HUMAN_PERFORMER = 108;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_PERFORMER__ID = PERFORMER__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_PERFORMER__EXTENSION_VALUES = PERFORMER__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_PERFORMER__BASE_ELEMENT = PERFORMER__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_PERFORMER__DOCUMENTATION = PERFORMER__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_PERFORMER__EXTENSION_DEFINITIONS = PERFORMER__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_PERFORMER__OUTGOING = PERFORMER__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_PERFORMER__INCOMING = PERFORMER__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_PERFORMER__BASE_PROPERTY = PERFORMER__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Resource Assignment Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_PERFORMER__RESOURCE_ASSIGNMENT_EXPRESSION = PERFORMER__RESOURCE_ASSIGNMENT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Resource Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_PERFORMER__RESOURCE_REF = PERFORMER__RESOURCE_REF;

	/**
	 * The feature id for the '<em><b>Resource Parameter Bindings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_PERFORMER__RESOURCE_PARAMETER_BINDINGS = PERFORMER__RESOURCE_PARAMETER_BINDINGS;

	/**
	 * The feature id for the '<em><b>Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_PERFORMER__PROCESS = PERFORMER__PROCESS;

	/**
	 * The number of structural features of the '<em>Human Performer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_PERFORMER_FEATURE_COUNT = PERFORMER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Resource Roleowner</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_PERFORMER___RESOURCE_ROLEOWNER__DIAGNOSTICCHAIN_MAP = PERFORMER___RESOURCE_ROLEOWNER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Resource Roleresource Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_PERFORMER___RESOURCE_ROLERESOURCE_REF__DIAGNOSTICCHAIN_MAP = PERFORMER___RESOURCE_ROLERESOURCE_REF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Resource Roleis Required</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_PERFORMER___RESOURCE_ROLEIS_REQUIRED__DIAGNOSTICCHAIN_MAP = PERFORMER___RESOURCE_ROLEIS_REQUIRED__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Resource Roleprocess</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_PERFORMER___RESOURCE_ROLEPROCESS__DIAGNOSTICCHAIN_MAP = PERFORMER___RESOURCE_ROLEPROCESS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Resource Roleresource Parameter Bindings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_PERFORMER___RESOURCE_ROLERESOURCE_PARAMETER_BINDINGS__DIAGNOSTICCHAIN_MAP = PERFORMER___RESOURCE_ROLERESOURCE_PARAMETER_BINDINGS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Human Performer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_PERFORMER_OPERATION_COUNT = PERFORMER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.GlobalUserTaskImpl <em>Global User Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.GlobalUserTaskImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getGlobalUserTask()
	 * @generated
	 */
	int GLOBAL_USER_TASK = 110;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK__ID = GLOBAL_TASK__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK__EXTENSION_VALUES = GLOBAL_TASK__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK__BASE_ELEMENT = GLOBAL_TASK__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK__DOCUMENTATION = GLOBAL_TASK__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK__EXTENSION_DEFINITIONS = GLOBAL_TASK__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK__OUTGOING = GLOBAL_TASK__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK__INCOMING = GLOBAL_TASK__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK__BASE_PACKAGEABLE_ELEMENT = GLOBAL_TASK__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK__DEFINITION = GLOBAL_TASK__DEFINITION;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK__BASE_BEHAVIOR = GLOBAL_TASK__BASE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Io Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK__IO_SPECIFICATION = GLOBAL_TASK__IO_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Supported Interface Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK__SUPPORTED_INTERFACE_REFS = GLOBAL_TASK__SUPPORTED_INTERFACE_REFS;

	/**
	 * The feature id for the '<em><b>Io Binding</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK__IO_BINDING = GLOBAL_TASK__IO_BINDING;

	/**
	 * The feature id for the '<em><b>Base Opaque Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK__BASE_OPAQUE_BEHAVIOR = GLOBAL_TASK__BASE_OPAQUE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK__RESOURCES = GLOBAL_TASK__RESOURCES;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK__IMPLEMENTATION = GLOBAL_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Renderings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK__RENDERINGS = GLOBAL_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Global User Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK_FEATURE_COUNT = GLOBAL_TASK_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Callable Eelementsupported Interface Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK___CALLABLE_EELEMENTSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP = GLOBAL_TASK___CALLABLE_EELEMENTSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Callable Elementresources</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK___CALLABLE_ELEMENTRESOURCES__DIAGNOSTICCHAIN_MAP = GLOBAL_TASK___CALLABLE_ELEMENTRESOURCES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Global Tasksupported Interface Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK___GLOBAL_TASKSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP = GLOBAL_TASK___GLOBAL_TASKSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Global User Taskrenderings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK___GLOBAL_USER_TASKRENDERINGS__DIAGNOSTICCHAIN_MAP = GLOBAL_TASK_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Global User Taskimplementation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK___GLOBAL_USER_TASKIMPLEMENTATION__DIAGNOSTICCHAIN_MAP = GLOBAL_TASK_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Global User Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_USER_TASK_OPERATION_COUNT = GLOBAL_TASK_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.GlobalManualTaskImpl <em>Global Manual Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.GlobalManualTaskImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getGlobalManualTask()
	 * @generated
	 */
	int GLOBAL_MANUAL_TASK = 111;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MANUAL_TASK__ID = GLOBAL_TASK__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MANUAL_TASK__EXTENSION_VALUES = GLOBAL_TASK__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MANUAL_TASK__BASE_ELEMENT = GLOBAL_TASK__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MANUAL_TASK__DOCUMENTATION = GLOBAL_TASK__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MANUAL_TASK__EXTENSION_DEFINITIONS = GLOBAL_TASK__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MANUAL_TASK__OUTGOING = GLOBAL_TASK__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MANUAL_TASK__INCOMING = GLOBAL_TASK__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MANUAL_TASK__BASE_PACKAGEABLE_ELEMENT = GLOBAL_TASK__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MANUAL_TASK__DEFINITION = GLOBAL_TASK__DEFINITION;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MANUAL_TASK__BASE_BEHAVIOR = GLOBAL_TASK__BASE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Io Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MANUAL_TASK__IO_SPECIFICATION = GLOBAL_TASK__IO_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Supported Interface Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MANUAL_TASK__SUPPORTED_INTERFACE_REFS = GLOBAL_TASK__SUPPORTED_INTERFACE_REFS;

	/**
	 * The feature id for the '<em><b>Io Binding</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MANUAL_TASK__IO_BINDING = GLOBAL_TASK__IO_BINDING;

	/**
	 * The feature id for the '<em><b>Base Opaque Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MANUAL_TASK__BASE_OPAQUE_BEHAVIOR = GLOBAL_TASK__BASE_OPAQUE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MANUAL_TASK__RESOURCES = GLOBAL_TASK__RESOURCES;

	/**
	 * The number of structural features of the '<em>Global Manual Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MANUAL_TASK_FEATURE_COUNT = GLOBAL_TASK_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Callable Eelementsupported Interface Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MANUAL_TASK___CALLABLE_EELEMENTSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP = GLOBAL_TASK___CALLABLE_EELEMENTSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Callable Elementresources</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MANUAL_TASK___CALLABLE_ELEMENTRESOURCES__DIAGNOSTICCHAIN_MAP = GLOBAL_TASK___CALLABLE_ELEMENTRESOURCES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Global Tasksupported Interface Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MANUAL_TASK___GLOBAL_TASKSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP = GLOBAL_TASK___GLOBAL_TASKSUPPORTED_INTERFACE_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Global Manual Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_MANUAL_TASK_OPERATION_COUNT = GLOBAL_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ManualTaskImpl <em>Manual Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ManualTaskImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getManualTask()
	 * @generated
	 */
	int MANUAL_TASK = 112;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__ID = TASK__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__EXTENSION_VALUES = TASK__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__BASE_ELEMENT = TASK__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__DOCUMENTATION = TASK__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__EXTENSION_DEFINITIONS = TASK__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__OUTGOING = TASK__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__INCOMING = TASK__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__AUDITING = TASK__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__MONITORING = TASK__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__CATEGORY_VALUE_REF = TASK__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__CONTAINER = TASK__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__BASE_ACTIVITY_NODE = TASK__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Is For Compensation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__IS_FOR_COMPENSATION = TASK__IS_FOR_COMPENSATION;

	/**
	 * The feature id for the '<em><b>Start Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__START_QUANTITY = TASK__START_QUANTITY;

	/**
	 * The feature id for the '<em><b>Completion Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__COMPLETION_QUANTITY = TASK__COMPLETION_QUANTITY;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__BASE_ACTION = TASK__BASE_ACTION;

	/**
	 * The feature id for the '<em><b>Activity Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__ACTIVITY_CLASS = TASK__ACTIVITY_CLASS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__PROPERTIES = TASK__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__DEFAULT = TASK__DEFAULT;

	/**
	 * The feature id for the '<em><b>Boundary Event Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__BOUNDARY_EVENT_REFS = TASK__BOUNDARY_EVENT_REFS;

	/**
	 * The feature id for the '<em><b>Data Input Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__DATA_INPUT_ASSOCIATIONS = TASK__DATA_INPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Data Output Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__DATA_OUTPUT_ASSOCIATIONS = TASK__DATA_OUTPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Loop Characteristics</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__LOOP_CHARACTERISTICS = TASK__LOOP_CHARACTERISTICS;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__RESOURCES = TASK__RESOURCES;

	/**
	 * The feature id for the '<em><b>Io Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__IO_SPECIFICATION = TASK__IO_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Opaque Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK__BASE_OPAQUE_ACTION = TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Manual Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK_FEATURE_COUNT = TASK_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>BPMN Activityresources</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitycontainer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityproperties</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitydefault</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityboundary Events Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityloop Characteristics</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Manual Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANUAL_TASK_OPERATION_COUNT = TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.PotentialOwnerImpl <em>Potential Owner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.PotentialOwnerImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getPotentialOwner()
	 * @generated
	 */
	int POTENTIAL_OWNER = 113;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_OWNER__ID = HUMAN_PERFORMER__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_OWNER__EXTENSION_VALUES = HUMAN_PERFORMER__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_OWNER__BASE_ELEMENT = HUMAN_PERFORMER__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_OWNER__DOCUMENTATION = HUMAN_PERFORMER__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_OWNER__EXTENSION_DEFINITIONS = HUMAN_PERFORMER__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_OWNER__OUTGOING = HUMAN_PERFORMER__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_OWNER__INCOMING = HUMAN_PERFORMER__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_OWNER__BASE_PROPERTY = HUMAN_PERFORMER__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Resource Assignment Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_OWNER__RESOURCE_ASSIGNMENT_EXPRESSION = HUMAN_PERFORMER__RESOURCE_ASSIGNMENT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Resource Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_OWNER__RESOURCE_REF = HUMAN_PERFORMER__RESOURCE_REF;

	/**
	 * The feature id for the '<em><b>Resource Parameter Bindings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_OWNER__RESOURCE_PARAMETER_BINDINGS = HUMAN_PERFORMER__RESOURCE_PARAMETER_BINDINGS;

	/**
	 * The feature id for the '<em><b>Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_OWNER__PROCESS = HUMAN_PERFORMER__PROCESS;

	/**
	 * The number of structural features of the '<em>Potential Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_OWNER_FEATURE_COUNT = HUMAN_PERFORMER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Resource Roleowner</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_OWNER___RESOURCE_ROLEOWNER__DIAGNOSTICCHAIN_MAP = HUMAN_PERFORMER___RESOURCE_ROLEOWNER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Resource Roleresource Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_OWNER___RESOURCE_ROLERESOURCE_REF__DIAGNOSTICCHAIN_MAP = HUMAN_PERFORMER___RESOURCE_ROLERESOURCE_REF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Resource Roleis Required</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_OWNER___RESOURCE_ROLEIS_REQUIRED__DIAGNOSTICCHAIN_MAP = HUMAN_PERFORMER___RESOURCE_ROLEIS_REQUIRED__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Resource Roleprocess</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_OWNER___RESOURCE_ROLEPROCESS__DIAGNOSTICCHAIN_MAP = HUMAN_PERFORMER___RESOURCE_ROLEPROCESS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Resource Roleresource Parameter Bindings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_OWNER___RESOURCE_ROLERESOURCE_PARAMETER_BINDINGS__DIAGNOSTICCHAIN_MAP = HUMAN_PERFORMER___RESOURCE_ROLERESOURCE_PARAMETER_BINDINGS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Potential Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POTENTIAL_OWNER_OPERATION_COUNT = HUMAN_PERFORMER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.SubConversationImpl <em>Sub Conversation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.SubConversationImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getSubConversation()
	 * @generated
	 */
	int SUB_CONVERSATION = 114;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONVERSATION__BASE_ELEMENT = CONVERSATION_NODE__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Outgoing Conversation Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONVERSATION__OUTGOING_CONVERSATION_LINKS = CONVERSATION_NODE__OUTGOING_CONVERSATION_LINKS;

	/**
	 * The feature id for the '<em><b>Incoming Conversation Links</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONVERSATION__INCOMING_CONVERSATION_LINKS = CONVERSATION_NODE__INCOMING_CONVERSATION_LINKS;

	/**
	 * The feature id for the '<em><b>Base Information Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONVERSATION__BASE_INFORMATION_FLOW = CONVERSATION_NODE__BASE_INFORMATION_FLOW;

	/**
	 * The feature id for the '<em><b>Message Flow Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONVERSATION__MESSAGE_FLOW_REFS = CONVERSATION_NODE__MESSAGE_FLOW_REFS;

	/**
	 * The feature id for the '<em><b>Correlation Keys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONVERSATION__CORRELATION_KEYS = CONVERSATION_NODE__CORRELATION_KEYS;

	/**
	 * The feature id for the '<em><b>Participant Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONVERSATION__PARTICIPANT_REFS = CONVERSATION_NODE__PARTICIPANT_REFS;

	/**
	 * The feature id for the '<em><b>Conversation Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONVERSATION__CONVERSATION_NODES = CONVERSATION_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sub Conversation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONVERSATION_FEATURE_COUNT = CONVERSATION_NODE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Conversation Nodeparticipant Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONVERSATION___CONVERSATION_NODEPARTICIPANT_REFS__DIAGNOSTICCHAIN_MAP = CONVERSATION_NODE___CONVERSATION_NODEPARTICIPANT_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Sub Conversationconnectedelements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONVERSATION___SUB_CONVERSATIONCONNECTEDELEMENTS__DIAGNOSTICCHAIN_MAP = CONVERSATION_NODE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Sub Conversation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_CONVERSATION_OPERATION_COUNT = CONVERSATION_NODE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.GlobalConversationImpl <em>Global Conversation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.GlobalConversationImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getGlobalConversation()
	 * @generated
	 */
	int GLOBAL_CONVERSATION = 115;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONVERSATION__ID = BPMN_COLLABORATION__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONVERSATION__EXTENSION_VALUES = BPMN_COLLABORATION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONVERSATION__BASE_ELEMENT = BPMN_COLLABORATION__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONVERSATION__DOCUMENTATION = BPMN_COLLABORATION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONVERSATION__EXTENSION_DEFINITIONS = BPMN_COLLABORATION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONVERSATION__OUTGOING = BPMN_COLLABORATION__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONVERSATION__INCOMING = BPMN_COLLABORATION__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONVERSATION__BASE_PACKAGEABLE_ELEMENT = BPMN_COLLABORATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONVERSATION__DEFINITION = BPMN_COLLABORATION__DEFINITION;

	/**
	 * The feature id for the '<em><b>Is Closed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONVERSATION__IS_CLOSED = BPMN_COLLABORATION__IS_CLOSED;

	/**
	 * The feature id for the '<em><b>Participant Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONVERSATION__PARTICIPANT_ASSOCIATIONS = BPMN_COLLABORATION__PARTICIPANT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Conversation Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONVERSATION__CONVERSATION_LINKS = BPMN_COLLABORATION__CONVERSATION_LINKS;

	/**
	 * The feature id for the '<em><b>Message Flow Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONVERSATION__MESSAGE_FLOW_ASSOCIATIONS = BPMN_COLLABORATION__MESSAGE_FLOW_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Message Flows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONVERSATION__MESSAGE_FLOWS = BPMN_COLLABORATION__MESSAGE_FLOWS;

	/**
	 * The feature id for the '<em><b>Base Collaboration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONVERSATION__BASE_COLLABORATION = BPMN_COLLABORATION__BASE_COLLABORATION;

	/**
	 * The feature id for the '<em><b>Conversations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONVERSATION__CONVERSATIONS = BPMN_COLLABORATION__CONVERSATIONS;

	/**
	 * The feature id for the '<em><b>Correlation Keys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONVERSATION__CORRELATION_KEYS = BPMN_COLLABORATION__CORRELATION_KEYS;

	/**
	 * The feature id for the '<em><b>Participants</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONVERSATION__PARTICIPANTS = BPMN_COLLABORATION__PARTICIPANTS;

	/**
	 * The number of structural features of the '<em>Global Conversation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONVERSATION_FEATURE_COUNT = BPMN_COLLABORATION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Collaborationparticipants</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONVERSATION___COLLABORATIONPARTICIPANTS__DIAGNOSTICCHAIN_MAP = BPMN_COLLABORATION___COLLABORATIONPARTICIPANTS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Global Conversationcontainedelements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONVERSATION___GLOBAL_CONVERSATIONCONTAINEDELEMENTS__DIAGNOSTICCHAIN_MAP = BPMN_COLLABORATION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Global Conversation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_CONVERSATION_OPERATION_COUNT = BPMN_COLLABORATION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.CallConversationImpl <em>Call Conversation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.CallConversationImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getCallConversation()
	 * @generated
	 */
	int CALL_CONVERSATION = 116;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_CONVERSATION__BASE_ELEMENT = CONVERSATION_NODE__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Outgoing Conversation Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_CONVERSATION__OUTGOING_CONVERSATION_LINKS = CONVERSATION_NODE__OUTGOING_CONVERSATION_LINKS;

	/**
	 * The feature id for the '<em><b>Incoming Conversation Links</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_CONVERSATION__INCOMING_CONVERSATION_LINKS = CONVERSATION_NODE__INCOMING_CONVERSATION_LINKS;

	/**
	 * The feature id for the '<em><b>Base Information Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_CONVERSATION__BASE_INFORMATION_FLOW = CONVERSATION_NODE__BASE_INFORMATION_FLOW;

	/**
	 * The feature id for the '<em><b>Message Flow Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_CONVERSATION__MESSAGE_FLOW_REFS = CONVERSATION_NODE__MESSAGE_FLOW_REFS;

	/**
	 * The feature id for the '<em><b>Correlation Keys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_CONVERSATION__CORRELATION_KEYS = CONVERSATION_NODE__CORRELATION_KEYS;

	/**
	 * The feature id for the '<em><b>Participant Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_CONVERSATION__PARTICIPANT_REFS = CONVERSATION_NODE__PARTICIPANT_REFS;

	/**
	 * The feature id for the '<em><b>collaboration Use</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_CONVERSATION__COLLABORATION_USE = CONVERSATION_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Called Collaboration Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_CONVERSATION__CALLED_COLLABORATION_REF = CONVERSATION_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Participant Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_CONVERSATION__PARTICIPANT_ASSOCIATIONS = CONVERSATION_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Call Conversation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_CONVERSATION_FEATURE_COUNT = CONVERSATION_NODE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Conversation Nodeparticipant Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_CONVERSATION___CONVERSATION_NODEPARTICIPANT_REFS__DIAGNOSTICCHAIN_MAP = CONVERSATION_NODE___CONVERSATION_NODEPARTICIPANT_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Call Conversationcalled Collaboration Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_CONVERSATION___CALL_CONVERSATIONCALLED_COLLABORATION_REF__DIAGNOSTICCHAIN_MAP = CONVERSATION_NODE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Call Conversationparticipant Associations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_CONVERSATION___CALL_CONVERSATIONPARTICIPANT_ASSOCIATIONS__DIAGNOSTICCHAIN_MAP = CONVERSATION_NODE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Call Conversation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_CONVERSATION_OPERATION_COUNT = CONVERSATION_NODE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ConversationImpl <em>Conversation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ConversationImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getConversation()
	 * @generated
	 */
	int CONVERSATION = 117;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION__BASE_ELEMENT = CONVERSATION_NODE__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Outgoing Conversation Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION__OUTGOING_CONVERSATION_LINKS = CONVERSATION_NODE__OUTGOING_CONVERSATION_LINKS;

	/**
	 * The feature id for the '<em><b>Incoming Conversation Links</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION__INCOMING_CONVERSATION_LINKS = CONVERSATION_NODE__INCOMING_CONVERSATION_LINKS;

	/**
	 * The feature id for the '<em><b>Base Information Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION__BASE_INFORMATION_FLOW = CONVERSATION_NODE__BASE_INFORMATION_FLOW;

	/**
	 * The feature id for the '<em><b>Message Flow Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION__MESSAGE_FLOW_REFS = CONVERSATION_NODE__MESSAGE_FLOW_REFS;

	/**
	 * The feature id for the '<em><b>Correlation Keys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION__CORRELATION_KEYS = CONVERSATION_NODE__CORRELATION_KEYS;

	/**
	 * The feature id for the '<em><b>Participant Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION__PARTICIPANT_REFS = CONVERSATION_NODE__PARTICIPANT_REFS;

	/**
	 * The number of structural features of the '<em>Conversation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_FEATURE_COUNT = CONVERSATION_NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Conversation Nodeparticipant Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION___CONVERSATION_NODEPARTICIPANT_REFS__DIAGNOSTICCHAIN_MAP = CONVERSATION_NODE___CONVERSATION_NODEPARTICIPANT_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Conversation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERSATION_OPERATION_COUNT = CONVERSATION_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.SubProcessImpl <em>Sub Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.SubProcessImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getSubProcess()
	 * @generated
	 */
	int SUB_PROCESS = 118;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__ID = BPMN_ACTIVITY__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__EXTENSION_VALUES = BPMN_ACTIVITY__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__BASE_ELEMENT = BPMN_ACTIVITY__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__DOCUMENTATION = BPMN_ACTIVITY__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__EXTENSION_DEFINITIONS = BPMN_ACTIVITY__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__OUTGOING = BPMN_ACTIVITY__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__INCOMING = BPMN_ACTIVITY__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__AUDITING = BPMN_ACTIVITY__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__MONITORING = BPMN_ACTIVITY__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__CATEGORY_VALUE_REF = BPMN_ACTIVITY__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__CONTAINER = BPMN_ACTIVITY__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__BASE_ACTIVITY_NODE = BPMN_ACTIVITY__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Is For Compensation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__IS_FOR_COMPENSATION = BPMN_ACTIVITY__IS_FOR_COMPENSATION;

	/**
	 * The feature id for the '<em><b>Start Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__START_QUANTITY = BPMN_ACTIVITY__START_QUANTITY;

	/**
	 * The feature id for the '<em><b>Completion Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__COMPLETION_QUANTITY = BPMN_ACTIVITY__COMPLETION_QUANTITY;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__BASE_ACTION = BPMN_ACTIVITY__BASE_ACTION;

	/**
	 * The feature id for the '<em><b>Activity Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__ACTIVITY_CLASS = BPMN_ACTIVITY__ACTIVITY_CLASS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__PROPERTIES = BPMN_ACTIVITY__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__DEFAULT = BPMN_ACTIVITY__DEFAULT;

	/**
	 * The feature id for the '<em><b>Boundary Event Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__BOUNDARY_EVENT_REFS = BPMN_ACTIVITY__BOUNDARY_EVENT_REFS;

	/**
	 * The feature id for the '<em><b>Data Input Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__DATA_INPUT_ASSOCIATIONS = BPMN_ACTIVITY__DATA_INPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Data Output Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__DATA_OUTPUT_ASSOCIATIONS = BPMN_ACTIVITY__DATA_OUTPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Loop Characteristics</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__LOOP_CHARACTERISTICS = BPMN_ACTIVITY__LOOP_CHARACTERISTICS;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__RESOURCES = BPMN_ACTIVITY__RESOURCES;

	/**
	 * The feature id for the '<em><b>Lane Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__LANE_SETS = BPMN_ACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Flow Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__FLOW_ELEMENTS = BPMN_ACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Triggered By Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__TRIGGERED_BY_EVENT = BPMN_ACTIVITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Structured Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__BASE_STRUCTURED_ACTIVITY_NODE = BPMN_ACTIVITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Has Lane Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__HAS_LANE_SETS = BPMN_ACTIVITY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Sub Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS_FEATURE_COUNT = BPMN_ACTIVITY_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>BPMN Activityresources</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP = BPMN_ACTIVITY___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitycontainer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP = BPMN_ACTIVITY___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityproperties</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP = BPMN_ACTIVITY___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitydefault</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP = BPMN_ACTIVITY___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityboundary Events Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP = BPMN_ACTIVITY___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityloop Characteristics</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP = BPMN_ACTIVITY___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Sub Processtriggered By Event</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS___SUB_PROCESSTRIGGERED_BY_EVENT__DIAGNOSTICCHAIN_MAP = BPMN_ACTIVITY_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Sub Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS_OPERATION_COUNT = BPMN_ACTIVITY_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.CallActivityImpl <em>Call Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.CallActivityImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getCallActivity()
	 * @generated
	 */
	int CALL_ACTIVITY = 119;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__ID = BPMN_ACTIVITY__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__EXTENSION_VALUES = BPMN_ACTIVITY__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__BASE_ELEMENT = BPMN_ACTIVITY__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__DOCUMENTATION = BPMN_ACTIVITY__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__EXTENSION_DEFINITIONS = BPMN_ACTIVITY__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__OUTGOING = BPMN_ACTIVITY__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__INCOMING = BPMN_ACTIVITY__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__AUDITING = BPMN_ACTIVITY__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__MONITORING = BPMN_ACTIVITY__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__CATEGORY_VALUE_REF = BPMN_ACTIVITY__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__CONTAINER = BPMN_ACTIVITY__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__BASE_ACTIVITY_NODE = BPMN_ACTIVITY__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Is For Compensation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__IS_FOR_COMPENSATION = BPMN_ACTIVITY__IS_FOR_COMPENSATION;

	/**
	 * The feature id for the '<em><b>Start Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__START_QUANTITY = BPMN_ACTIVITY__START_QUANTITY;

	/**
	 * The feature id for the '<em><b>Completion Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__COMPLETION_QUANTITY = BPMN_ACTIVITY__COMPLETION_QUANTITY;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__BASE_ACTION = BPMN_ACTIVITY__BASE_ACTION;

	/**
	 * The feature id for the '<em><b>Activity Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__ACTIVITY_CLASS = BPMN_ACTIVITY__ACTIVITY_CLASS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__PROPERTIES = BPMN_ACTIVITY__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__DEFAULT = BPMN_ACTIVITY__DEFAULT;

	/**
	 * The feature id for the '<em><b>Boundary Event Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__BOUNDARY_EVENT_REFS = BPMN_ACTIVITY__BOUNDARY_EVENT_REFS;

	/**
	 * The feature id for the '<em><b>Data Input Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__DATA_INPUT_ASSOCIATIONS = BPMN_ACTIVITY__DATA_INPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Data Output Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__DATA_OUTPUT_ASSOCIATIONS = BPMN_ACTIVITY__DATA_OUTPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Loop Characteristics</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__LOOP_CHARACTERISTICS = BPMN_ACTIVITY__LOOP_CHARACTERISTICS;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__RESOURCES = BPMN_ACTIVITY__RESOURCES;

	/**
	 * The feature id for the '<em><b>Base Call Behavior Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__BASE_CALL_BEHAVIOR_ACTION = BPMN_ACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Called Element Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY__CALLED_ELEMENT_REF = BPMN_ACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Call Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY_FEATURE_COUNT = BPMN_ACTIVITY_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>BPMN Activityresources</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP = BPMN_ACTIVITY___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitycontainer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP = BPMN_ACTIVITY___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityproperties</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP = BPMN_ACTIVITY___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitydefault</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP = BPMN_ACTIVITY___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityboundary Events Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP = BPMN_ACTIVITY___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityloop Characteristics</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP = BPMN_ACTIVITY___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Call Activitycalled Element Refvalues</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY___CALL_ACTIVITYCALLED_ELEMENT_REFVALUES__DIAGNOSTICCHAIN_MAP = BPMN_ACTIVITY_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Call Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ACTIVITY_OPERATION_COUNT = BPMN_ACTIVITY_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BusinessRuleTaskImpl <em>Business Rule Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BusinessRuleTaskImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getBusinessRuleTask()
	 * @generated
	 */
	int BUSINESS_RULE_TASK = 120;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__ID = TASK__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__EXTENSION_VALUES = TASK__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__BASE_ELEMENT = TASK__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__DOCUMENTATION = TASK__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__EXTENSION_DEFINITIONS = TASK__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__OUTGOING = TASK__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__INCOMING = TASK__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__AUDITING = TASK__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__MONITORING = TASK__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__CATEGORY_VALUE_REF = TASK__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__CONTAINER = TASK__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__BASE_ACTIVITY_NODE = TASK__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Is For Compensation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__IS_FOR_COMPENSATION = TASK__IS_FOR_COMPENSATION;

	/**
	 * The feature id for the '<em><b>Start Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__START_QUANTITY = TASK__START_QUANTITY;

	/**
	 * The feature id for the '<em><b>Completion Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__COMPLETION_QUANTITY = TASK__COMPLETION_QUANTITY;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__BASE_ACTION = TASK__BASE_ACTION;

	/**
	 * The feature id for the '<em><b>Activity Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__ACTIVITY_CLASS = TASK__ACTIVITY_CLASS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__PROPERTIES = TASK__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__DEFAULT = TASK__DEFAULT;

	/**
	 * The feature id for the '<em><b>Boundary Event Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__BOUNDARY_EVENT_REFS = TASK__BOUNDARY_EVENT_REFS;

	/**
	 * The feature id for the '<em><b>Data Input Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__DATA_INPUT_ASSOCIATIONS = TASK__DATA_INPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Data Output Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__DATA_OUTPUT_ASSOCIATIONS = TASK__DATA_OUTPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Loop Characteristics</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__LOOP_CHARACTERISTICS = TASK__LOOP_CHARACTERISTICS;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__RESOURCES = TASK__RESOURCES;

	/**
	 * The feature id for the '<em><b>Io Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__IO_SPECIFICATION = TASK__IO_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Opaque Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__BASE_OPAQUE_ACTION = TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK__IMPLEMENTATION = TASK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Business Rule Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK_FEATURE_COUNT = TASK_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>BPMN Activityresources</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitycontainer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityproperties</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitydefault</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityboundary Events Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityloop Characteristics</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Business Rule Taskimplementation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK___BUSINESS_RULE_TASKIMPLEMENTATION__DIAGNOSTICCHAIN_MAP = TASK_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Business Rule Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_RULE_TASK_OPERATION_COUNT = TASK_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ComplexBehaviorDefinitionImpl <em>Complex Behavior Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ComplexBehaviorDefinitionImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getComplexBehaviorDefinition()
	 * @generated
	 */
	int COMPLEX_BEHAVIOR_DEFINITION = 121;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_BEHAVIOR_DEFINITION__ID = BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_BEHAVIOR_DEFINITION__EXTENSION_VALUES = BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_BEHAVIOR_DEFINITION__BASE_ELEMENT = BASE_ELEMENT__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_BEHAVIOR_DEFINITION__DOCUMENTATION = BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_BEHAVIOR_DEFINITION__EXTENSION_DEFINITIONS = BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_BEHAVIOR_DEFINITION__OUTGOING = BASE_ELEMENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_BEHAVIOR_DEFINITION__INCOMING = BASE_ELEMENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_BEHAVIOR_DEFINITION__CONDITION = BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_BEHAVIOR_DEFINITION__EVENT = BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Control Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_BEHAVIOR_DEFINITION__BASE_CONTROL_FLOW = BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Complex Behavior Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_BEHAVIOR_DEFINITION_FEATURE_COUNT = BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Complex Behavior Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_BEHAVIOR_DEFINITION_OPERATION_COUNT = BASE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.AdHocSubProcessImpl <em>Ad Hoc Sub Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.AdHocSubProcessImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getAdHocSubProcess()
	 * @generated
	 */
	int AD_HOC_SUB_PROCESS = 122;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__ID = SUB_PROCESS__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__EXTENSION_VALUES = SUB_PROCESS__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__BASE_ELEMENT = SUB_PROCESS__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__DOCUMENTATION = SUB_PROCESS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__EXTENSION_DEFINITIONS = SUB_PROCESS__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__OUTGOING = SUB_PROCESS__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__INCOMING = SUB_PROCESS__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__AUDITING = SUB_PROCESS__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__MONITORING = SUB_PROCESS__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__CATEGORY_VALUE_REF = SUB_PROCESS__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__CONTAINER = SUB_PROCESS__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__BASE_ACTIVITY_NODE = SUB_PROCESS__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Is For Compensation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__IS_FOR_COMPENSATION = SUB_PROCESS__IS_FOR_COMPENSATION;

	/**
	 * The feature id for the '<em><b>Start Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__START_QUANTITY = SUB_PROCESS__START_QUANTITY;

	/**
	 * The feature id for the '<em><b>Completion Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__COMPLETION_QUANTITY = SUB_PROCESS__COMPLETION_QUANTITY;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__BASE_ACTION = SUB_PROCESS__BASE_ACTION;

	/**
	 * The feature id for the '<em><b>Activity Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__ACTIVITY_CLASS = SUB_PROCESS__ACTIVITY_CLASS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__PROPERTIES = SUB_PROCESS__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__DEFAULT = SUB_PROCESS__DEFAULT;

	/**
	 * The feature id for the '<em><b>Boundary Event Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__BOUNDARY_EVENT_REFS = SUB_PROCESS__BOUNDARY_EVENT_REFS;

	/**
	 * The feature id for the '<em><b>Data Input Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__DATA_INPUT_ASSOCIATIONS = SUB_PROCESS__DATA_INPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Data Output Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__DATA_OUTPUT_ASSOCIATIONS = SUB_PROCESS__DATA_OUTPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Loop Characteristics</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__LOOP_CHARACTERISTICS = SUB_PROCESS__LOOP_CHARACTERISTICS;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__RESOURCES = SUB_PROCESS__RESOURCES;

	/**
	 * The feature id for the '<em><b>Lane Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__LANE_SETS = SUB_PROCESS__LANE_SETS;

	/**
	 * The feature id for the '<em><b>Flow Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__FLOW_ELEMENTS = SUB_PROCESS__FLOW_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Triggered By Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__TRIGGERED_BY_EVENT = SUB_PROCESS__TRIGGERED_BY_EVENT;

	/**
	 * The feature id for the '<em><b>Base Structured Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__BASE_STRUCTURED_ACTIVITY_NODE = SUB_PROCESS__BASE_STRUCTURED_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Has Lane Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__HAS_LANE_SETS = SUB_PROCESS__HAS_LANE_SETS;

	/**
	 * The feature id for the '<em><b>Completion Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__COMPLETION_CONDITION = SUB_PROCESS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ordering</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__ORDERING = SUB_PROCESS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Cancel Remaining Instances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS__CANCEL_REMAINING_INSTANCES = SUB_PROCESS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Ad Hoc Sub Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS_FEATURE_COUNT = SUB_PROCESS_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>BPMN Activityresources</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP = SUB_PROCESS___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitycontainer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP = SUB_PROCESS___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityproperties</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP = SUB_PROCESS___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitydefault</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP = SUB_PROCESS___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityboundary Events Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP = SUB_PROCESS___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityloop Characteristics</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP = SUB_PROCESS___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Sub Processtriggered By Event</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS___SUB_PROCESSTRIGGERED_BY_EVENT__DIAGNOSTICCHAIN_MAP = SUB_PROCESS___SUB_PROCESSTRIGGERED_BY_EVENT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Ad Hoc Sub Processcancel Remaining Instances</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS___AD_HOC_SUB_PROCESSCANCEL_REMAINING_INSTANCES__DIAGNOSTICCHAIN_MAP = SUB_PROCESS_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Ad Hoc Sub Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AD_HOC_SUB_PROCESS_OPERATION_COUNT = SUB_PROCESS_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ScriptTaskImpl <em>Script Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ScriptTaskImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getScriptTask()
	 * @generated
	 */
	int SCRIPT_TASK = 123;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__ID = TASK__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__EXTENSION_VALUES = TASK__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__BASE_ELEMENT = TASK__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__DOCUMENTATION = TASK__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__EXTENSION_DEFINITIONS = TASK__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__OUTGOING = TASK__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__INCOMING = TASK__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__AUDITING = TASK__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__MONITORING = TASK__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__CATEGORY_VALUE_REF = TASK__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__CONTAINER = TASK__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__BASE_ACTIVITY_NODE = TASK__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Is For Compensation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__IS_FOR_COMPENSATION = TASK__IS_FOR_COMPENSATION;

	/**
	 * The feature id for the '<em><b>Start Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__START_QUANTITY = TASK__START_QUANTITY;

	/**
	 * The feature id for the '<em><b>Completion Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__COMPLETION_QUANTITY = TASK__COMPLETION_QUANTITY;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__BASE_ACTION = TASK__BASE_ACTION;

	/**
	 * The feature id for the '<em><b>Activity Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__ACTIVITY_CLASS = TASK__ACTIVITY_CLASS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__PROPERTIES = TASK__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__DEFAULT = TASK__DEFAULT;

	/**
	 * The feature id for the '<em><b>Boundary Event Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__BOUNDARY_EVENT_REFS = TASK__BOUNDARY_EVENT_REFS;

	/**
	 * The feature id for the '<em><b>Data Input Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__DATA_INPUT_ASSOCIATIONS = TASK__DATA_INPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Data Output Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__DATA_OUTPUT_ASSOCIATIONS = TASK__DATA_OUTPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Loop Characteristics</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__LOOP_CHARACTERISTICS = TASK__LOOP_CHARACTERISTICS;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__RESOURCES = TASK__RESOURCES;

	/**
	 * The feature id for the '<em><b>Io Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__IO_SPECIFICATION = TASK__IO_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Opaque Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__BASE_OPAQUE_ACTION = TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Script Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__SCRIPT_FORMAT = TASK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Script</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK__SCRIPT = TASK_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Script Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK_FEATURE_COUNT = TASK_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>BPMN Activityresources</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitycontainer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityproperties</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitydefault</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityboundary Events Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityloop Characteristics</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Script Taskscript Format</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK___SCRIPT_TASKSCRIPT_FORMAT__DIAGNOSTICCHAIN_MAP = TASK_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Script Taskscript</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK___SCRIPT_TASKSCRIPT__DIAGNOSTICCHAIN_MAP = TASK_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Script Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_TASK_OPERATION_COUNT = TASK_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.SendTaskImpl <em>Send Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.SendTaskImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getSendTask()
	 * @generated
	 */
	int SEND_TASK = 124;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__ID = TASK__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__EXTENSION_VALUES = TASK__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__BASE_ELEMENT = TASK__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__DOCUMENTATION = TASK__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__EXTENSION_DEFINITIONS = TASK__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__OUTGOING = TASK__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__INCOMING = TASK__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__AUDITING = TASK__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__MONITORING = TASK__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__CATEGORY_VALUE_REF = TASK__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__CONTAINER = TASK__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__BASE_ACTIVITY_NODE = TASK__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Is For Compensation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__IS_FOR_COMPENSATION = TASK__IS_FOR_COMPENSATION;

	/**
	 * The feature id for the '<em><b>Start Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__START_QUANTITY = TASK__START_QUANTITY;

	/**
	 * The feature id for the '<em><b>Completion Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__COMPLETION_QUANTITY = TASK__COMPLETION_QUANTITY;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__BASE_ACTION = TASK__BASE_ACTION;

	/**
	 * The feature id for the '<em><b>Activity Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__ACTIVITY_CLASS = TASK__ACTIVITY_CLASS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__PROPERTIES = TASK__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__DEFAULT = TASK__DEFAULT;

	/**
	 * The feature id for the '<em><b>Boundary Event Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__BOUNDARY_EVENT_REFS = TASK__BOUNDARY_EVENT_REFS;

	/**
	 * The feature id for the '<em><b>Data Input Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__DATA_INPUT_ASSOCIATIONS = TASK__DATA_INPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Data Output Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__DATA_OUTPUT_ASSOCIATIONS = TASK__DATA_OUTPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Loop Characteristics</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__LOOP_CHARACTERISTICS = TASK__LOOP_CHARACTERISTICS;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__RESOURCES = TASK__RESOURCES;

	/**
	 * The feature id for the '<em><b>Io Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__IO_SPECIFICATION = TASK__IO_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Message Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__MESSAGE_REF = TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Call Operation Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__BASE_CALL_OPERATION_ACTION = TASK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__IMPLEMENTATION = TASK_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Operation Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK__OPERATION_REF = TASK_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Send Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK_FEATURE_COUNT = TASK_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>BPMN Activityresources</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitycontainer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityproperties</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitydefault</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityboundary Events Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityloop Characteristics</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Send Taskoperation Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK___SEND_TASKOPERATION_REF__DIAGNOSTICCHAIN_MAP = TASK_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Send Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_TASK_OPERATION_COUNT = TASK_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.TransactionImpl <em>Transaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.TransactionImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getTransaction()
	 * @generated
	 */
	int TRANSACTION = 125;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__ID = SUB_PROCESS__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__EXTENSION_VALUES = SUB_PROCESS__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__BASE_ELEMENT = SUB_PROCESS__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__DOCUMENTATION = SUB_PROCESS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__EXTENSION_DEFINITIONS = SUB_PROCESS__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__OUTGOING = SUB_PROCESS__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__INCOMING = SUB_PROCESS__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__AUDITING = SUB_PROCESS__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__MONITORING = SUB_PROCESS__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__CATEGORY_VALUE_REF = SUB_PROCESS__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__CONTAINER = SUB_PROCESS__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__BASE_ACTIVITY_NODE = SUB_PROCESS__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Is For Compensation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__IS_FOR_COMPENSATION = SUB_PROCESS__IS_FOR_COMPENSATION;

	/**
	 * The feature id for the '<em><b>Start Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__START_QUANTITY = SUB_PROCESS__START_QUANTITY;

	/**
	 * The feature id for the '<em><b>Completion Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__COMPLETION_QUANTITY = SUB_PROCESS__COMPLETION_QUANTITY;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__BASE_ACTION = SUB_PROCESS__BASE_ACTION;

	/**
	 * The feature id for the '<em><b>Activity Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__ACTIVITY_CLASS = SUB_PROCESS__ACTIVITY_CLASS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__PROPERTIES = SUB_PROCESS__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__DEFAULT = SUB_PROCESS__DEFAULT;

	/**
	 * The feature id for the '<em><b>Boundary Event Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__BOUNDARY_EVENT_REFS = SUB_PROCESS__BOUNDARY_EVENT_REFS;

	/**
	 * The feature id for the '<em><b>Data Input Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__DATA_INPUT_ASSOCIATIONS = SUB_PROCESS__DATA_INPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Data Output Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__DATA_OUTPUT_ASSOCIATIONS = SUB_PROCESS__DATA_OUTPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Loop Characteristics</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__LOOP_CHARACTERISTICS = SUB_PROCESS__LOOP_CHARACTERISTICS;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__RESOURCES = SUB_PROCESS__RESOURCES;

	/**
	 * The feature id for the '<em><b>Lane Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__LANE_SETS = SUB_PROCESS__LANE_SETS;

	/**
	 * The feature id for the '<em><b>Flow Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__FLOW_ELEMENTS = SUB_PROCESS__FLOW_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Triggered By Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__TRIGGERED_BY_EVENT = SUB_PROCESS__TRIGGERED_BY_EVENT;

	/**
	 * The feature id for the '<em><b>Base Structured Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__BASE_STRUCTURED_ACTIVITY_NODE = SUB_PROCESS__BASE_STRUCTURED_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Has Lane Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__HAS_LANE_SETS = SUB_PROCESS__HAS_LANE_SETS;

	/**
	 * The feature id for the '<em><b>Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__METHOD = SUB_PROCESS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Transaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_FEATURE_COUNT = SUB_PROCESS_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>BPMN Activityresources</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP = SUB_PROCESS___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitycontainer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP = SUB_PROCESS___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityproperties</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP = SUB_PROCESS___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitydefault</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP = SUB_PROCESS___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityboundary Events Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP = SUB_PROCESS___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityloop Characteristics</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP = SUB_PROCESS___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Sub Processtriggered By Event</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION___SUB_PROCESSTRIGGERED_BY_EVENT__DIAGNOSTICCHAIN_MAP = SUB_PROCESS___SUB_PROCESSTRIGGERED_BY_EVENT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Transaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_OPERATION_COUNT = SUB_PROCESS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.StandardLoopCharacteristicsImpl <em>Standard Loop Characteristics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.StandardLoopCharacteristicsImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getStandardLoopCharacteristics()
	 * @generated
	 */
	int STANDARD_LOOP_CHARACTERISTICS = 126;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_LOOP_CHARACTERISTICS__ID = LOOP_CHARACTERISTICS__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_LOOP_CHARACTERISTICS__EXTENSION_VALUES = LOOP_CHARACTERISTICS__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_LOOP_CHARACTERISTICS__BASE_ELEMENT = LOOP_CHARACTERISTICS__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_LOOP_CHARACTERISTICS__DOCUMENTATION = LOOP_CHARACTERISTICS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_LOOP_CHARACTERISTICS__EXTENSION_DEFINITIONS = LOOP_CHARACTERISTICS__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_LOOP_CHARACTERISTICS__OUTGOING = LOOP_CHARACTERISTICS__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_LOOP_CHARACTERISTICS__INCOMING = LOOP_CHARACTERISTICS__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Structured Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_LOOP_CHARACTERISTICS__BASE_STRUCTURED_ACTIVITY_NODE = LOOP_CHARACTERISTICS__BASE_STRUCTURED_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Loop Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_LOOP_CHARACTERISTICS__LOOP_MAXIMUM = LOOP_CHARACTERISTICS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Loop Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_LOOP_CHARACTERISTICS__BASE_LOOP_NODE = LOOP_CHARACTERISTICS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Test Before</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_LOOP_CHARACTERISTICS__TEST_BEFORE = LOOP_CHARACTERISTICS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Loop Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_LOOP_CHARACTERISTICS__LOOP_CONDITION = LOOP_CHARACTERISTICS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Standard Loop Characteristics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_LOOP_CHARACTERISTICS_FEATURE_COUNT = LOOP_CHARACTERISTICS_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Standard Loop Characteristicstest Before</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_LOOP_CHARACTERISTICS___STANDARD_LOOP_CHARACTERISTICSTEST_BEFORE__DIAGNOSTICCHAIN_MAP = LOOP_CHARACTERISTICS_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Standard Loop Characteristicsloop Condition</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_LOOP_CHARACTERISTICS___STANDARD_LOOP_CHARACTERISTICSLOOP_CONDITION__DIAGNOSTICCHAIN_MAP = LOOP_CHARACTERISTICS_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Standard Loop Characteristics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_LOOP_CHARACTERISTICS_OPERATION_COUNT = LOOP_CHARACTERISTICS_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ReceiveTaskImpl <em>Receive Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ReceiveTaskImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getReceiveTask()
	 * @generated
	 */
	int RECEIVE_TASK = 127;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__ID = TASK__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__EXTENSION_VALUES = TASK__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__BASE_ELEMENT = TASK__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__DOCUMENTATION = TASK__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__EXTENSION_DEFINITIONS = TASK__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__OUTGOING = TASK__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__INCOMING = TASK__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__AUDITING = TASK__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__MONITORING = TASK__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__CATEGORY_VALUE_REF = TASK__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__CONTAINER = TASK__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__BASE_ACTIVITY_NODE = TASK__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Is For Compensation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__IS_FOR_COMPENSATION = TASK__IS_FOR_COMPENSATION;

	/**
	 * The feature id for the '<em><b>Start Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__START_QUANTITY = TASK__START_QUANTITY;

	/**
	 * The feature id for the '<em><b>Completion Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__COMPLETION_QUANTITY = TASK__COMPLETION_QUANTITY;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__BASE_ACTION = TASK__BASE_ACTION;

	/**
	 * The feature id for the '<em><b>Activity Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__ACTIVITY_CLASS = TASK__ACTIVITY_CLASS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__PROPERTIES = TASK__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__DEFAULT = TASK__DEFAULT;

	/**
	 * The feature id for the '<em><b>Boundary Event Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__BOUNDARY_EVENT_REFS = TASK__BOUNDARY_EVENT_REFS;

	/**
	 * The feature id for the '<em><b>Data Input Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__DATA_INPUT_ASSOCIATIONS = TASK__DATA_INPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Data Output Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__DATA_OUTPUT_ASSOCIATIONS = TASK__DATA_OUTPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Loop Characteristics</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__LOOP_CHARACTERISTICS = TASK__LOOP_CHARACTERISTICS;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__RESOURCES = TASK__RESOURCES;

	/**
	 * The feature id for the '<em><b>Io Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__IO_SPECIFICATION = TASK__IO_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Message Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__MESSAGE_REF = TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Accept Event Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__BASE_ACCEPT_EVENT_ACTION = TASK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__IMPLEMENTATION = TASK_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Instantiate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__INSTANTIATE = TASK_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Operation Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK__OPERATION_REF = TASK_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Receive Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK_FEATURE_COUNT = TASK_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>BPMN Activityresources</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitycontainer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityproperties</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitydefault</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityboundary Events Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityloop Characteristics</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Receive Taskoperation Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK___RECEIVE_TASKOPERATION_REF__DIAGNOSTICCHAIN_MAP = TASK_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Receive Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_TASK_OPERATION_COUNT = TASK_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ServiceTaskImpl <em>Service Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.ServiceTaskImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getServiceTask()
	 * @generated
	 */
	int SERVICE_TASK = 128;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__ID = TASK__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__EXTENSION_VALUES = TASK__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__BASE_ELEMENT = TASK__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__DOCUMENTATION = TASK__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__EXTENSION_DEFINITIONS = TASK__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__OUTGOING = TASK__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__INCOMING = TASK__INCOMING;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__AUDITING = TASK__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__MONITORING = TASK__MONITORING;

	/**
	 * The feature id for the '<em><b>category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__CATEGORY_VALUE_REF = TASK__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__CONTAINER = TASK__CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__BASE_ACTIVITY_NODE = TASK__BASE_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Is For Compensation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__IS_FOR_COMPENSATION = TASK__IS_FOR_COMPENSATION;

	/**
	 * The feature id for the '<em><b>Start Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__START_QUANTITY = TASK__START_QUANTITY;

	/**
	 * The feature id for the '<em><b>Completion Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__COMPLETION_QUANTITY = TASK__COMPLETION_QUANTITY;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__BASE_ACTION = TASK__BASE_ACTION;

	/**
	 * The feature id for the '<em><b>Activity Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__ACTIVITY_CLASS = TASK__ACTIVITY_CLASS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__PROPERTIES = TASK__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__DEFAULT = TASK__DEFAULT;

	/**
	 * The feature id for the '<em><b>Boundary Event Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__BOUNDARY_EVENT_REFS = TASK__BOUNDARY_EVENT_REFS;

	/**
	 * The feature id for the '<em><b>Data Input Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__DATA_INPUT_ASSOCIATIONS = TASK__DATA_INPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Data Output Associations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__DATA_OUTPUT_ASSOCIATIONS = TASK__DATA_OUTPUT_ASSOCIATIONS;

	/**
	 * The feature id for the '<em><b>Loop Characteristics</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__LOOP_CHARACTERISTICS = TASK__LOOP_CHARACTERISTICS;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__RESOURCES = TASK__RESOURCES;

	/**
	 * The feature id for the '<em><b>Io Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__IO_SPECIFICATION = TASK__IO_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Call Operation Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__BASE_CALL_OPERATION_ACTION = TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__IMPLEMENTATION = TASK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operation Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK__OPERATION_REF = TASK_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Service Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK_FEATURE_COUNT = TASK_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>BPMN Activityresources</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYRESOURCES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitycontainer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYCONTAINER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityproperties</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYPROPERTIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activitydefault</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYDEFAULT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityboundary Events Refs</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYBOUNDARY_EVENTS_REFS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>BPMN Activityloop Characteristics</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP = TASK___BPMN_ACTIVITYLOOP_CHARACTERISTICS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Service Taskinput Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK___SERVICE_TASKINPUT_SET__DIAGNOSTICCHAIN_MAP = TASK_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Service Taskoutput Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK___SERVICE_TASKOUTPUT_SET__DIAGNOSTICCHAIN_MAP = TASK_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Service Taskoperation Ref</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK___SERVICE_TASKOPERATION_REF__DIAGNOSTICCHAIN_MAP = TASK_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Service Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TASK_OPERATION_COUNT = TASK_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.MultiInstanceLoopCharacteristicsImpl <em>Multi Instance Loop Characteristics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.MultiInstanceLoopCharacteristicsImpl
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getMultiInstanceLoopCharacteristics()
	 * @generated
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS = 129;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS__ID = LOOP_CHARACTERISTICS__ID;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS__EXTENSION_VALUES = LOOP_CHARACTERISTICS__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS__BASE_ELEMENT = LOOP_CHARACTERISTICS__BASE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS__DOCUMENTATION = LOOP_CHARACTERISTICS__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS__EXTENSION_DEFINITIONS = LOOP_CHARACTERISTICS__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS__OUTGOING = LOOP_CHARACTERISTICS__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS__INCOMING = LOOP_CHARACTERISTICS__INCOMING;

	/**
	 * The feature id for the '<em><b>Base Structured Activity Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS__BASE_STRUCTURED_ACTIVITY_NODE = LOOP_CHARACTERISTICS__BASE_STRUCTURED_ACTIVITY_NODE;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS__BEHAVIOR = LOOP_CHARACTERISTICS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Loop Cardinality</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_CARDINALITY = LOOP_CHARACTERISTICS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Completion Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS__COMPLETION_CONDITION = LOOP_CHARACTERISTICS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Expansion Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS__BASE_EXPANSION_REGION = LOOP_CHARACTERISTICS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Sequential</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS__IS_SEQUENTIAL = LOOP_CHARACTERISTICS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Loop Data Input Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_DATA_INPUT_REF = LOOP_CHARACTERISTICS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Loop Data Output Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_DATA_OUTPUT_REF = LOOP_CHARACTERISTICS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Output Data Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS__OUTPUT_DATA_ITEM = LOOP_CHARACTERISTICS_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Input Data Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS__INPUT_DATA_ITEM = LOOP_CHARACTERISTICS_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>One Behavior Event Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS__ONE_BEHAVIOR_EVENT_REF = LOOP_CHARACTERISTICS_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>None Behavior Event Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS__NONE_BEHAVIOR_EVENT_REF = LOOP_CHARACTERISTICS_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Complex Behavior Definition</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS__COMPLEX_BEHAVIOR_DEFINITION = LOOP_CHARACTERISTICS_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Multi Instance Loop Characteristics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS_FEATURE_COUNT = LOOP_CHARACTERISTICS_FEATURE_COUNT + 12;

	/**
	 * The operation id for the '<em>Multiinstance Loop Characteristicstarget</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS___MULTIINSTANCE_LOOP_CHARACTERISTICSTARGET__DIAGNOSTICCHAIN_MAP = LOOP_CHARACTERISTICS_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Multi Instance Loop Characteristics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_INSTANCE_LOOP_CHARACTERISTICS_OPERATION_COUNT = LOOP_CHARACTERISTICS_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.AssociationDirection <em>Association Direction</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.AssociationDirection
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getAssociationDirection()
	 * @generated
	 */
	int ASSOCIATION_DIRECTION = 130;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGatewayType <em>Event Based Gateway Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGatewayType
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getEventBasedGatewayType()
	 * @generated
	 */
	int EVENT_BASED_GATEWAY_TYPE = 131;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.GatewayDirection <em>Gateway Direction</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.GatewayDirection
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getGatewayDirection()
	 * @generated
	 */
	int GATEWAY_DIRECTION = 132;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.RelationshipDirection <em>Relationship Direction</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.RelationshipDirection
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getRelationshipDirection()
	 * @generated
	 */
	int RELATIONSHIP_DIRECTION = 133;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ItemKind <em>Item Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ItemKind
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getItemKind()
	 * @generated
	 */
	int ITEM_KIND = 134;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ProcessType <em>Process Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ProcessType
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getProcessType()
	 * @generated
	 */
	int PROCESS_TYPE = 135;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.AdHocOrdering <em>Ad Hoc Ordering</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.AdHocOrdering
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getAdHocOrdering()
	 * @generated
	 */
	int AD_HOC_ORDERING = 136;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceBehavior <em>Multi Instance Behavior</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceBehavior
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.impl.BPMNProfilePackageImpl#getMultiInstanceBehavior()
	 * @generated
	 */
	int MULTI_INSTANCE_BEHAVIOR = 137;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InclusiveGateway <em>Inclusive Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inclusive Gateway</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InclusiveGateway
	 * @generated
	 */
	EClass getInclusiveGateway();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InclusiveGateway#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InclusiveGateway#getDefault()
	 * @see #getInclusiveGateway()
	 * @generated
	 */
	EReference getInclusiveGateway_Default();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InclusiveGateway#inclusiveGatewaydefault(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Inclusive Gatewaydefault</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Inclusive Gatewaydefault</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InclusiveGateway#inclusiveGatewaydefault(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getInclusiveGateway__InclusiveGatewaydefault__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.NonExclusiveGateway <em>Non Exclusive Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Non Exclusive Gateway</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.NonExclusiveGateway
	 * @generated
	 */
	EClass getNonExclusiveGateway();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.NonExclusiveGateway#getBase_JoinNode <em>Base Join Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Join Node</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.NonExclusiveGateway#getBase_JoinNode()
	 * @see #getNonExclusiveGateway()
	 * @generated
	 */
	EReference getNonExclusiveGateway_Base_JoinNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.NonExclusiveGateway#getBase_ForkNode <em>Base Fork Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Fork Node</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.NonExclusiveGateway#getBase_ForkNode()
	 * @see #getNonExclusiveGateway()
	 * @generated
	 */
	EReference getNonExclusiveGateway_Base_ForkNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Gateway <em>Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gateway</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Gateway
	 * @generated
	 */
	EClass getGateway();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Gateway#getBase_ControlNode <em>Base Control Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Control Node</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Gateway#getBase_ControlNode()
	 * @see #getGateway()
	 * @generated
	 */
	EReference getGateway_Base_ControlNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Gateway#getBase_ActivityGroup <em>Base Activity Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Activity Group</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Gateway#getBase_ActivityGroup()
	 * @see #getGateway()
	 * @generated
	 */
	EReference getGateway_Base_ActivityGroup();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.FlowNode <em>Flow Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow Node</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.FlowNode
	 * @generated
	 */
	EClass getFlowNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.FlowNode#getBase_ActivityNode <em>Base Activity Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Activity Node</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.FlowNode#getBase_ActivityNode()
	 * @see #getFlowNode()
	 * @generated
	 */
	EReference getFlowNode_Base_ActivityNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement <em>Flow Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow Element</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement
	 * @generated
	 */
	EClass getFlowElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement#getAuditing <em>Auditing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Auditing</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement#getAuditing()
	 * @see #getFlowElement()
	 * @generated
	 */
	EReference getFlowElement_Auditing();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement#getMonitoring <em>Monitoring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Monitoring</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement#getMonitoring()
	 * @see #getFlowElement()
	 * @generated
	 */
	EReference getFlowElement_Monitoring();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement#get_categoryValueRef <em>category Value Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>category Value Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement#get_categoryValueRef()
	 * @see #getFlowElement()
	 * @generated
	 */
	EReference getFlowElement__categoryValueRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.FlowElement#getContainer()
	 * @see #getFlowElement()
	 * @generated
	 */
	EReference getFlowElement_Container();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement <em>Base Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Element</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement
	 * @generated
	 */
	EClass getBaseElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement#getId()
	 * @see #getBaseElement()
	 * @generated
	 */
	EAttribute getBaseElement_Id();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement#getExtensionValues <em>Extension Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extension Values</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement#getExtensionValues()
	 * @see #getBaseElement()
	 * @generated
	 */
	EReference getBaseElement_ExtensionValues();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement#getBase_Element <em>Base Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Element</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement#getBase_Element()
	 * @see #getBaseElement()
	 * @generated
	 */
	EReference getBaseElement_Base_Element();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement#getDocumentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Documentation</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement#getDocumentation()
	 * @see #getBaseElement()
	 * @generated
	 */
	EReference getBaseElement_Documentation();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement#getExtensionDefinitions <em>Extension Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extension Definitions</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement#getExtensionDefinitions()
	 * @see #getBaseElement()
	 * @generated
	 */
	EReference getBaseElement_ExtensionDefinitions();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement#getOutgoing()
	 * @see #getBaseElement()
	 * @generated
	 */
	EReference getBaseElement_Outgoing();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement#getIncoming()
	 * @see #getBaseElement()
	 * @generated
	 */
	EReference getBaseElement_Incoming();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeValue <em>Extension Attribute Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Attribute Value</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeValue
	 * @generated
	 */
	EClass getExtensionAttributeValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeValue#getBase_Slot <em>Base Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Slot</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeValue#getBase_Slot()
	 * @see #getExtensionAttributeValue()
	 * @generated
	 */
	EReference getExtensionAttributeValue_Base_Slot();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeValue#getValueRef <em>Value Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeValue#getValueRef()
	 * @see #getExtensionAttributeValue()
	 * @generated
	 */
	EReference getExtensionAttributeValue_ValueRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeValue#getExtensionAttributeDefinition <em>Extension Attribute Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extension Attribute Definition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeValue#getExtensionAttributeDefinition()
	 * @see #getExtensionAttributeValue()
	 * @generated
	 */
	EReference getExtensionAttributeValue_ExtensionAttributeDefinition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeDefinition <em>Extension Attribute Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Attribute Definition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeDefinition
	 * @generated
	 */
	EClass getExtensionAttributeDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeDefinition#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeDefinition#getBase_Property()
	 * @see #getExtensionAttributeDefinition()
	 * @generated
	 */
	EReference getExtensionAttributeDefinition_Base_Property();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeDefinition#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeDefinition#getType()
	 * @see #getExtensionAttributeDefinition()
	 * @generated
	 */
	EAttribute getExtensionAttributeDefinition_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeDefinition#isReference <em>Is Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Reference</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeDefinition#isReference()
	 * @see #getExtensionAttributeDefinition()
	 * @generated
	 */
	EAttribute getExtensionAttributeDefinition_IsReference();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Documentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Documentation</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Documentation
	 * @generated
	 */
	EClass getDocumentation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Documentation#getBase_Comment <em>Base Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Comment</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Documentation#getBase_Comment()
	 * @see #getDocumentation()
	 * @generated
	 */
	EReference getDocumentation_Base_Comment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Documentation#getTextFormat <em>Text Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Format</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Documentation#getTextFormat()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_TextFormat();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Documentation#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Documentation#getText()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_Text();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionDefinition <em>Extension Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Definition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionDefinition
	 * @generated
	 */
	EClass getExtensionDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionDefinition#getBase_Stereotype <em>Base Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Stereotype</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionDefinition#getBase_Stereotype()
	 * @see #getExtensionDefinition()
	 * @generated
	 */
	EReference getExtensionDefinition_Base_Stereotype();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionDefinition#getExtensionAttributeDefinitions <em>Extension Attribute Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extension Attribute Definitions</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionDefinition#getExtensionAttributeDefinitions()
	 * @see #getExtensionDefinition()
	 * @generated
	 */
	EReference getExtensionDefinition_ExtensionAttributeDefinitions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation <em>BPMN Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPMN Association</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation
	 * @generated
	 */
	EClass getBPMNAssociation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation#getBase_Dependency()
	 * @see #getBPMNAssociation()
	 * @generated
	 */
	EReference getBPMNAssociation_Base_Dependency();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation#getAssociationDirection <em>Association Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Association Direction</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation#getAssociationDirection()
	 * @see #getBPMNAssociation()
	 * @generated
	 */
	EAttribute getBPMNAssociation_AssociationDirection();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation#getTargetRef <em>Target Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation#getTargetRef()
	 * @see #getBPMNAssociation()
	 * @generated
	 */
	EReference getBPMNAssociation_TargetRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation#getSourceRef <em>Source Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation#getSourceRef()
	 * @see #getBPMNAssociation()
	 * @generated
	 */
	EReference getBPMNAssociation_SourceRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation#AssociationEnd(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Association End</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Association End</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation#AssociationEnd(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNAssociation__AssociationEnd__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNArtifact <em>BPMN Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPMN Artifact</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNArtifact
	 * @generated
	 */
	EClass getBPMNArtifact();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Auditing <em>Auditing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Auditing</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Auditing
	 * @generated
	 */
	EClass getAuditing();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Auditing#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Auditing#getBase_Class()
	 * @see #getAuditing()
	 * @generated
	 */
	EReference getAuditing_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Monitoring <em>Monitoring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Monitoring</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Monitoring
	 * @generated
	 */
	EClass getMonitoring();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Monitoring#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Monitoring#getBase_Class()
	 * @see #getMonitoring()
	 * @generated
	 */
	EReference getMonitoring_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CategoryValue <em>Category Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category Value</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CategoryValue
	 * @generated
	 */
	EClass getCategoryValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CategoryValue#getBase_EnumerationLiteral <em>Base Enumeration Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Enumeration Literal</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CategoryValue#getBase_EnumerationLiteral()
	 * @see #getCategoryValue()
	 * @generated
	 */
	EReference getCategoryValue_Base_EnumerationLiteral();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CategoryValue#getCategorizedFlowElements <em>Categorized Flow Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Categorized Flow Elements</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CategoryValue#getCategorizedFlowElements()
	 * @see #getCategoryValue()
	 * @generated
	 */
	EReference getCategoryValue_CategorizedFlowElements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.FlowElementsContainer <em>Flow Elements Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow Elements Container</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.FlowElementsContainer
	 * @generated
	 */
	EClass getFlowElementsContainer();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.FlowElementsContainer#getLaneSets <em>Lane Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Lane Sets</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.FlowElementsContainer#getLaneSets()
	 * @see #getFlowElementsContainer()
	 * @generated
	 */
	EReference getFlowElementsContainer_LaneSets();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.FlowElementsContainer#getFlowElements <em>Flow Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Flow Elements</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.FlowElementsContainer#getFlowElements()
	 * @see #getFlowElementsContainer()
	 * @generated
	 */
	EReference getFlowElementsContainer_FlowElements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet <em>Lane Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lane Set</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet
	 * @generated
	 */
	EClass getLaneSet();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet#getBase_ActivityPartition <em>Base Activity Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Activity Partition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet#getBase_ActivityPartition()
	 * @see #getLaneSet()
	 * @generated
	 */
	EReference getLaneSet_Base_ActivityPartition();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet#getLanes <em>Lanes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Lanes</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet#getLanes()
	 * @see #getLaneSet()
	 * @generated
	 */
	EReference getLaneSet_Lanes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet#getParentLane <em>Parent Lane</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parent Lane</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet#getParentLane()
	 * @see #getLaneSet()
	 * @generated
	 */
	EReference getLaneSet_ParentLane();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet#getFlowElementsContainer <em>Flow Elements Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Flow Elements Container</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet#getFlowElementsContainer()
	 * @see #getLaneSet()
	 * @generated
	 */
	EReference getLaneSet_FlowElementsContainer();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet#LaneSetlanes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Lane Setlanes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Lane Setlanes</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet#LaneSetlanes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLaneSet__LaneSetlanes__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet#LaneSetparentLane(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Lane Setparent Lane</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Lane Setparent Lane</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet#LaneSetparentLane(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLaneSet__LaneSetparentLane__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet#LaneSetflowElementsContainer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Lane Setflow Elements Container</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Lane Setflow Elements Container</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet#LaneSetflowElementsContainer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLaneSet__LaneSetflowElementsContainer__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet#LaneSet(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Lane Set</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Lane Set</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet#LaneSet(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLaneSet__LaneSet__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Lane <em>Lane</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lane</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Lane
	 * @generated
	 */
	EClass getLane();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Lane#getBase_ActivityPartition <em>Base Activity Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Activity Partition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Lane#getBase_ActivityPartition()
	 * @see #getLane()
	 * @generated
	 */
	EReference getLane_Base_ActivityPartition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Lane#get_partitionElement <em>partition Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>partition Element</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Lane#get_partitionElement()
	 * @see #getLane()
	 * @generated
	 */
	EReference getLane__partitionElement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Lane#getFlowNodeRefs <em>Flow Node Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Flow Node Refs</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Lane#getFlowNodeRefs()
	 * @see #getLane()
	 * @generated
	 */
	EReference getLane_FlowNodeRefs();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Lane#getPartitionElementRef <em>Partition Element Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Partition Element Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Lane#getPartitionElementRef()
	 * @see #getLane()
	 * @generated
	 */
	EReference getLane_PartitionElementRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Lane#getChildLaneSet <em>Child Lane Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Child Lane Set</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Lane#getChildLaneSet()
	 * @see #getLane()
	 * @generated
	 */
	EReference getLane_ChildLaneSet();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Lane#getLaneSet <em>Lane Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lane Set</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Lane#getLaneSet()
	 * @see #getLane()
	 * @generated
	 */
	EReference getLane_LaneSet();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Lane#LanelaneSet(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Lanelane Set</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Lanelane Set</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Lane#LanelaneSet(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLane__LanelaneSet__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Lane#LanechildLaneSet(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Lanechild Lane Set</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Lanechild Lane Set</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Lane#LanechildLaneSet(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLane__LanechildLaneSet__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Lane#LanepartitionElementRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Lanepartition Element Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Lanepartition Element Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Lane#LanepartitionElementRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLane__LanepartitionElementRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Lane#LaneflowNodeRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Laneflow Node Refs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Laneflow Node Refs</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Lane#LaneflowNodeRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getLane__LaneflowNodeRefs__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow <em>Sequence Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Flow</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow
	 * @generated
	 */
	EClass getSequenceFlow();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow#getBase_ControlFlow <em>Base Control Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Control Flow</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow#getBase_ControlFlow()
	 * @see #getSequenceFlow()
	 * @generated
	 */
	EReference getSequenceFlow_Base_ControlFlow();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow#isImmediate <em>Is Immediate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Immediate</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow#isImmediate()
	 * @see #getSequenceFlow()
	 * @generated
	 */
	EAttribute getSequenceFlow_IsImmediate();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow#getConditionExpression <em>Condition Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Condition Expression</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow#getConditionExpression()
	 * @see #getSequenceFlow()
	 * @generated
	 */
	EReference getSequenceFlow_ConditionExpression();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow#SequenceFlowconditionExpression(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Sequence Flowcondition Expression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Sequence Flowcondition Expression</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow#SequenceFlowconditionExpression(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSequenceFlow__SequenceFlowconditionExpression__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow#SequenceFlowsourceRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Sequence Flowsource Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Sequence Flowsource Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow#SequenceFlowsourceRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSequenceFlow__SequenceFlowsourceRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow#SequenceFlowtargetRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Sequence Flowtarget Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Sequence Flowtarget Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow#SequenceFlowtargetRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSequenceFlow__SequenceFlowtargetRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNExpression <em>BPMN Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPMN Expression</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNExpression
	 * @generated
	 */
	EClass getBPMNExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNExpression#getBase_OpaqueExpression <em>Base Opaque Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Opaque Expression</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNExpression#getBase_OpaqueExpression()
	 * @see #getBPMNExpression()
	 * @generated
	 */
	EReference getBPMNExpression_Base_OpaqueExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGateway <em>Event Based Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Based Gateway</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGateway
	 * @generated
	 */
	EClass getEventBasedGateway();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGateway#isInstantiate <em>Instantiate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instantiate</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGateway#isInstantiate()
	 * @see #getEventBasedGateway()
	 * @generated
	 */
	EAttribute getEventBasedGateway_Instantiate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGateway#getEventGatewayType <em>Event Gateway Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event Gateway Type</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGateway#getEventGatewayType()
	 * @see #getEventBasedGateway()
	 * @generated
	 */
	EAttribute getEventBasedGateway_EventGatewayType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGateway#getBase_ForkNode <em>Base Fork Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Fork Node</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGateway#getBase_ForkNode()
	 * @see #getEventBasedGateway()
	 * @generated
	 */
	EReference getEventBasedGateway_Base_ForkNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGateway#getBase_StructuredActivityNode <em>Base Structured Activity Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Structured Activity Node</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGateway#getBase_StructuredActivityNode()
	 * @see #getEventBasedGateway()
	 * @generated
	 */
	EReference getEventBasedGateway_Base_StructuredActivityNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGateway#getBase_InterruptibleActivityRegion <em>Base Interruptible Activity Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Interruptible Activity Region</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGateway#getBase_InterruptibleActivityRegion()
	 * @see #getEventBasedGateway()
	 * @generated
	 */
	EReference getEventBasedGateway_Base_InterruptibleActivityRegion();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ParallelGateway <em>Parallel Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parallel Gateway</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ParallelGateway
	 * @generated
	 */
	EClass getParallelGateway();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ComplexGateway <em>Complex Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Gateway</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ComplexGateway
	 * @generated
	 */
	EClass getComplexGateway();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ComplexGateway#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ComplexGateway#getDefault()
	 * @see #getComplexGateway()
	 * @generated
	 */
	EReference getComplexGateway_Default();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ComplexGateway#getActivationCondition <em>Activation Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Activation Condition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ComplexGateway#getActivationCondition()
	 * @see #getComplexGateway()
	 * @generated
	 */
	EReference getComplexGateway_ActivationCondition();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ComplexGateway#complexGatewaydefault(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Complex Gatewaydefault</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Complex Gatewaydefault</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ComplexGateway#complexGatewaydefault(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getComplexGateway__ComplexGatewaydefault__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ComplexGateway#complexGatewayactivationCondition(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Complex Gatewayactivation Condition</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Complex Gatewayactivation Condition</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ComplexGateway#complexGatewayactivationCondition(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getComplexGateway__ComplexGatewayactivationCondition__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ComplexGateway#complexGatewayjoinSpec(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Complex Gatewayjoin Spec</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Complex Gatewayjoin Spec</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ComplexGateway#complexGatewayjoinSpec(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getComplexGateway__ComplexGatewayjoinSpec__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExclusiveGateway <em>Exclusive Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exclusive Gateway</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ExclusiveGateway
	 * @generated
	 */
	EClass getExclusiveGateway();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExclusiveGateway#getBase_DecisionNode <em>Base Decision Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Decision Node</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ExclusiveGateway#getBase_DecisionNode()
	 * @see #getExclusiveGateway()
	 * @generated
	 */
	EReference getExclusiveGateway_Base_DecisionNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExclusiveGateway#getBase_MergeNode <em>Base Merge Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Merge Node</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ExclusiveGateway#getBase_MergeNode()
	 * @see #getExclusiveGateway()
	 * @generated
	 */
	EReference getExclusiveGateway_Base_MergeNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExclusiveGateway#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ExclusiveGateway#getDefault()
	 * @see #getExclusiveGateway()
	 * @generated
	 */
	EReference getExclusiveGateway_Default();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ExclusiveGateway#exclusiveGatewaydefault(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Exclusive Gatewaydefault</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Exclusive Gatewaydefault</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ExclusiveGateway#exclusiveGatewaydefault(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getExclusiveGateway__ExclusiveGatewaydefault__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.RootElement <em>Root Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Element</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.RootElement
	 * @generated
	 */
	EClass getRootElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.RootElement#getBase_PackageableElement <em>Base Packageable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Packageable Element</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.RootElement#getBase_PackageableElement()
	 * @see #getRootElement()
	 * @generated
	 */
	EReference getRootElement_Base_PackageableElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.RootElement#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.RootElement#getDefinition()
	 * @see #getRootElement()
	 * @generated
	 */
	EReference getRootElement_Definition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Definitions <em>Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Definitions</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Definitions
	 * @generated
	 */
	EClass getDefinitions();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Definitions#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Definitions#getBase_Package()
	 * @see #getDefinitions()
	 * @generated
	 */
	EReference getDefinitions_Base_Package();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Definitions#getTargetNamespace <em>Target Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Namespace</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Definitions#getTargetNamespace()
	 * @see #getDefinitions()
	 * @generated
	 */
	EAttribute getDefinitions_TargetNamespace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Definitions#getExpressionLanguage <em>Expression Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression Language</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Definitions#getExpressionLanguage()
	 * @see #getDefinitions()
	 * @generated
	 */
	EAttribute getDefinitions_ExpressionLanguage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Definitions#getTypeLanguage <em>Type Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Language</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Definitions#getTypeLanguage()
	 * @see #getDefinitions()
	 * @generated
	 */
	EAttribute getDefinitions_TypeLanguage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Definitions#getExporter <em>Exporter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exporter</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Definitions#getExporter()
	 * @see #getDefinitions()
	 * @generated
	 */
	EAttribute getDefinitions_Exporter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Definitions#getExporterVersion <em>Exporter Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exporter Version</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Definitions#getExporterVersion()
	 * @see #getDefinitions()
	 * @generated
	 */
	EAttribute getDefinitions_ExporterVersion();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Definitions#getExtensions <em>Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extensions</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Definitions#getExtensions()
	 * @see #getDefinitions()
	 * @generated
	 */
	EReference getDefinitions_Extensions();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Definitions#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Imports</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Definitions#getImports()
	 * @see #getDefinitions()
	 * @generated
	 */
	EReference getDefinitions_Imports();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Definitions#getRelationships <em>Relationships</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Relationships</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Definitions#getRelationships()
	 * @see #getDefinitions()
	 * @generated
	 */
	EReference getDefinitions_Relationships();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Definitions#getRootElements <em>Root Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Root Elements</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Definitions#getRootElements()
	 * @see #getDefinitions()
	 * @generated
	 */
	EReference getDefinitions_RootElements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNExtension <em>BPMN Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPMN Extension</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNExtension
	 * @generated
	 */
	EClass getBPMNExtension();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNExtension#getBase_Stereotype <em>Base Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Stereotype</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNExtension#getBase_Stereotype()
	 * @see #getBPMNExtension()
	 * @generated
	 */
	EReference getBPMNExtension_Base_Stereotype();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNExtension#isMustUnderstand <em>Must Understand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Must Understand</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNExtension#isMustUnderstand()
	 * @see #getBPMNExtension()
	 * @generated
	 */
	EAttribute getBPMNExtension_MustUnderstand();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNExtension#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNExtension#getDefinition()
	 * @see #getBPMNExtension()
	 * @generated
	 */
	EReference getBPMNExtension_Definition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Import
	 * @generated
	 */
	EClass getImport();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Import#getBase_PackageImport <em>Base Package Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package Import</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Import#getBase_PackageImport()
	 * @see #getImport()
	 * @generated
	 */
	EReference getImport_Base_PackageImport();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Import#getImportType <em>Import Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import Type</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Import#getImportType()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_ImportType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Import#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Import#getLocation()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_Location();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Import#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Import#getNamespace()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_Namespace();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Import#getDefinitions <em>Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definitions</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Import#getDefinitions()
	 * @see #getImport()
	 * @generated
	 */
	EReference getImport_Definitions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNRelationship <em>BPMN Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPMN Relationship</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNRelationship
	 * @generated
	 */
	EClass getBPMNRelationship();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNRelationship#getBase_Constraint <em>Base Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Constraint</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNRelationship#getBase_Constraint()
	 * @see #getBPMNRelationship()
	 * @generated
	 */
	EReference getBPMNRelationship_Base_Constraint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNRelationship#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNRelationship#getType()
	 * @see #getBPMNRelationship()
	 * @generated
	 */
	EAttribute getBPMNRelationship_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNRelationship#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNRelationship#getDirection()
	 * @see #getBPMNRelationship()
	 * @generated
	 */
	EAttribute getBPMNRelationship_Direction();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNRelationship#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Targets</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNRelationship#getTargets()
	 * @see #getBPMNRelationship()
	 * @generated
	 */
	EReference getBPMNRelationship_Targets();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNRelationship#getSources <em>Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sources</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNRelationship#getSources()
	 * @see #getBPMNRelationship()
	 * @generated
	 */
	EReference getBPMNRelationship_Sources();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNRelationship#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNRelationship#getDefinition()
	 * @see #getBPMNRelationship()
	 * @generated
	 */
	EReference getBPMNRelationship_Definition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess <em>BPMN Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPMN Process</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess
	 * @generated
	 */
	EClass getBPMNProcess();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#getProcessType <em>Process Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Process Type</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#getProcessType()
	 * @see #getBPMNProcess()
	 * @generated
	 */
	EAttribute getBPMNProcess_ProcessType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#isClosed <em>Is Closed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Closed</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#isClosed()
	 * @see #getBPMNProcess()
	 * @generated
	 */
	EAttribute getBPMNProcess_IsClosed();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#getAuditing <em>Auditing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Auditing</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#getAuditing()
	 * @see #getBPMNProcess()
	 * @generated
	 */
	EReference getBPMNProcess_Auditing();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#isExecutable <em>Is Executable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Executable</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#isExecutable()
	 * @see #getBPMNProcess()
	 * @generated
	 */
	EAttribute getBPMNProcess_IsExecutable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#getDefinitionalCollaborationRef <em>Definitional Collaboration Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definitional Collaboration Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#getDefinitionalCollaborationRef()
	 * @see #getBPMNProcess()
	 * @generated
	 */
	EReference getBPMNProcess_DefinitionalCollaborationRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#getBase_Activity <em>Base Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Activity</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#getBase_Activity()
	 * @see #getBPMNProcess()
	 * @generated
	 */
	EReference getBPMNProcess_Base_Activity();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#getCorrelationSubscriptions <em>Correlation Subscriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Correlation Subscriptions</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#getCorrelationSubscriptions()
	 * @see #getBPMNProcess()
	 * @generated
	 */
	EReference getBPMNProcess_CorrelationSubscriptions();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#getMonitoring <em>Monitoring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Monitoring</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#getMonitoring()
	 * @see #getBPMNProcess()
	 * @generated
	 */
	EReference getBPMNProcess_Monitoring();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#getSupports <em>Supports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Supports</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#getSupports()
	 * @see #getBPMNProcess()
	 * @generated
	 */
	EReference getBPMNProcess_Supports();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Properties</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#getProperties()
	 * @see #getBPMNProcess()
	 * @generated
	 */
	EReference getBPMNProcess_Properties();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Resources</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#getResources()
	 * @see #getBPMNProcess()
	 * @generated
	 */
	EReference getBPMNProcess_Resources();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#ProcesssupportedInterfaceRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Processsupported Interface Refs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Processsupported Interface Refs</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#ProcesssupportedInterfaceRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNProcess__ProcesssupportedInterfaceRefs__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#Processsupports(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Processsupports</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Processsupports</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#Processsupports(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNProcess__Processsupports__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#Processproperties(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Processproperties</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Processproperties</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#Processproperties(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNProcess__Processproperties__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#ProcesslaneSets(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Processlane Sets</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Processlane Sets</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#ProcesslaneSets(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNProcess__ProcesslaneSets__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#ProcessflowElements(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Processflow Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Processflow Elements</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProcess#ProcessflowElements(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNProcess__ProcessflowElements__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CallableElement <em>Callable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Callable Element</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CallableElement
	 * @generated
	 */
	EClass getCallableElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CallableElement#getBase_Behavior <em>Base Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Behavior</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CallableElement#getBase_Behavior()
	 * @see #getCallableElement()
	 * @generated
	 */
	EReference getCallableElement_Base_Behavior();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CallableElement#getIoSpecification <em>Io Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Io Specification</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CallableElement#getIoSpecification()
	 * @see #getCallableElement()
	 * @generated
	 */
	EReference getCallableElement_IoSpecification();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CallableElement#getSupportedInterfaceRefs <em>Supported Interface Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Supported Interface Refs</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CallableElement#getSupportedInterfaceRefs()
	 * @see #getCallableElement()
	 * @generated
	 */
	EReference getCallableElement_SupportedInterfaceRefs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CallableElement#getIoBinding <em>Io Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Io Binding</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CallableElement#getIoBinding()
	 * @see #getCallableElement()
	 * @generated
	 */
	EReference getCallableElement_IoBinding();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CallableElement#CallableEelementsupportedInterfaceRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Callable Eelementsupported Interface Refs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Callable Eelementsupported Interface Refs</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CallableElement#CallableEelementsupportedInterfaceRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCallableElement__CallableEelementsupportedInterfaceRefs__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CallableElement#CallableElementresources(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Callable Elementresources</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Callable Elementresources</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CallableElement#CallableElementresources(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCallableElement__CallableElementresources__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification <em>Input Output Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Output Specification</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification
	 * @generated
	 */
	EClass getInputOutputSpecification();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification#getBase_Behavior <em>Base Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Behavior</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification#getBase_Behavior()
	 * @see #getInputOutputSpecification()
	 * @generated
	 */
	EReference getInputOutputSpecification_Base_Behavior();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification#getBase_Action <em>Base Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Action</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification#getBase_Action()
	 * @see #getInputOutputSpecification()
	 * @generated
	 */
	EReference getInputOutputSpecification_Base_Action();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification#getDataInputs <em>Data Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Data Inputs</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification#getDataInputs()
	 * @see #getInputOutputSpecification()
	 * @generated
	 */
	EReference getInputOutputSpecification_DataInputs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification#getDataOutputs <em>Data Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Data Outputs</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification#getDataOutputs()
	 * @see #getInputOutputSpecification()
	 * @generated
	 */
	EReference getInputOutputSpecification_DataOutputs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification#getInputSets <em>Input Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Input Sets</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification#getInputSets()
	 * @see #getInputOutputSpecification()
	 * @generated
	 */
	EReference getInputOutputSpecification_InputSets();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification#getOutputSets <em>Output Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Output Sets</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputSpecification#getOutputSets()
	 * @see #getInputOutputSpecification()
	 * @generated
	 */
	EReference getInputOutputSpecification_OutputSets();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataInput <em>Data Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Input</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataInput
	 * @generated
	 */
	EClass getDataInput();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataInput#isCollection <em>Is Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Collection</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataInput#isCollection()
	 * @see #getDataInput()
	 * @generated
	 */
	EAttribute getDataInput_IsCollection();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataInput#getBase_InputPin <em>Base Input Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Input Pin</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataInput#getBase_InputPin()
	 * @see #getDataInput()
	 * @generated
	 */
	EReference getDataInput_Base_InputPin();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataInput#getBase_Parameter <em>Base Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Parameter</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataInput#getBase_Parameter()
	 * @see #getDataInput()
	 * @generated
	 */
	EReference getDataInput_Base_Parameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataInput#getBase_ActivityParameterNode <em>Base Activity Parameter Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Activity Parameter Node</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataInput#getBase_ActivityParameterNode()
	 * @see #getDataInput()
	 * @generated
	 */
	EReference getDataInput_Base_ActivityParameterNode();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataInput#getInputSetRefs <em>Input Set Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Input Set Refs</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataInput#getInputSetRefs()
	 * @see #getDataInput()
	 * @generated
	 */
	EReference getDataInput_InputSetRefs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataInput#getInputSetWithOptional <em>Input Set With Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Input Set With Optional</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataInput#getInputSetWithOptional()
	 * @see #getDataInput()
	 * @generated
	 */
	EReference getDataInput_InputSetWithOptional();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataInput#getInputSetWithWhileExecuting <em>Input Set With While Executing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Input Set With While Executing</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataInput#getInputSetWithWhileExecuting()
	 * @see #getDataInput()
	 * @generated
	 */
	EReference getDataInput_InputSetWithWhileExecuting();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataInput#DataInputAssociation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Data Input Association</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Data Input Association</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataInput#DataInputAssociation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getDataInput__DataInputAssociation__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataInput#DataInputnotation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Data Inputnotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Data Inputnotation</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataInput#DataInputnotation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getDataInput__DataInputnotation__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataInput#DataInputitemSubjectRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Data Inputitem Subject Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Data Inputitem Subject Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataInput#DataInputitemSubjectRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getDataInput__DataInputitemSubjectRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ItemAwareElement <em>Item Aware Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item Aware Element</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ItemAwareElement
	 * @generated
	 */
	EClass getItemAwareElement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ItemAwareElement#getDataState <em>Data State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Data State</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ItemAwareElement#getDataState()
	 * @see #getItemAwareElement()
	 * @generated
	 */
	EReference getItemAwareElement_DataState();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ItemAwareElement#getBase_TypedElement <em>Base Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Typed Element</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ItemAwareElement#getBase_TypedElement()
	 * @see #getItemAwareElement()
	 * @generated
	 */
	EReference getItemAwareElement_Base_TypedElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ItemAwareElement#getItemSubjectRef <em>Item Subject Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Item Subject Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ItemAwareElement#getItemSubjectRef()
	 * @see #getItemAwareElement()
	 * @generated
	 */
	EReference getItemAwareElement_ItemSubjectRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ItemAwareElement#ItemAwareElementdataState(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Item Aware Elementdata State</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Item Aware Elementdata State</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ItemAwareElement#ItemAwareElementdataState(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getItemAwareElement__ItemAwareElementdataState__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataState <em>Data State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data State</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataState
	 * @generated
	 */
	EClass getDataState();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataState#getBase_State <em>Base State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base State</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataState#getBase_State()
	 * @see #getDataState()
	 * @generated
	 */
	EReference getDataState_Base_State();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ItemDefinition <em>Item Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item Definition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ItemDefinition
	 * @generated
	 */
	EClass getItemDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ItemDefinition#getItemKind <em>Item Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Item Kind</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ItemDefinition#getItemKind()
	 * @see #getItemDefinition()
	 * @generated
	 */
	EAttribute getItemDefinition_ItemKind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ItemDefinition#isCollection <em>Is Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Collection</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ItemDefinition#isCollection()
	 * @see #getItemDefinition()
	 * @generated
	 */
	EAttribute getItemDefinition_IsCollection();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ItemDefinition#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ItemDefinition#getBase_Class()
	 * @see #getItemDefinition()
	 * @generated
	 */
	EReference getItemDefinition_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ItemDefinition#getStructureRef <em>Structure Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Structure Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ItemDefinition#getStructureRef()
	 * @see #getItemDefinition()
	 * @generated
	 */
	EReference getItemDefinition_StructureRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ItemDefinition#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Import</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ItemDefinition#getImport()
	 * @see #getItemDefinition()
	 * @generated
	 */
	EReference getItemDefinition_Import();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ItemDefinition#ItemDefinitionstructureRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Item Definitionstructure Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Item Definitionstructure Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ItemDefinition#ItemDefinitionstructureRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getItemDefinition__ItemDefinitionstructureRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputSet <em>Input Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Set</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InputSet
	 * @generated
	 */
	EClass getInputSet();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputSet#getBase_ParameterSet <em>Base Parameter Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Parameter Set</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InputSet#getBase_ParameterSet()
	 * @see #getInputSet()
	 * @generated
	 */
	EReference getInputSet_Base_ParameterSet();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputSet#getOptionalInputRefs <em>Optional Input Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Optional Input Refs</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InputSet#getOptionalInputRefs()
	 * @see #getInputSet()
	 * @generated
	 */
	EReference getInputSet_OptionalInputRefs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputSet#getWhileExecutingInputRefs <em>While Executing Input Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>While Executing Input Refs</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InputSet#getWhileExecutingInputRefs()
	 * @see #getInputSet()
	 * @generated
	 */
	EReference getInputSet_WhileExecutingInputRefs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputSet#getDataInputRefs <em>Data Input Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Data Input Refs</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InputSet#getDataInputRefs()
	 * @see #getInputSet()
	 * @generated
	 */
	EReference getInputSet_DataInputRefs();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputSet#InputSetdataInputRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Input Setdata Input Refs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Input Setdata Input Refs</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InputSet#InputSetdataInputRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getInputSet__InputSetdataInputRefs__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputSet#InputSetoptionalInputRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Input Setoptional Input Refs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Input Setoptional Input Refs</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InputSet#InputSetoptionalInputRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getInputSet__InputSetoptionalInputRefs__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputSet#InputSetwhileExecutingInputRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Input Setwhile Executing Input Refs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Input Setwhile Executing Input Refs</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InputSet#InputSetwhileExecutingInputRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getInputSet__InputSetwhileExecutingInputRefs__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput <em>Data Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Output</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput
	 * @generated
	 */
	EClass getDataOutput();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#getBase_OutputPin <em>Base Output Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Output Pin</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#getBase_OutputPin()
	 * @see #getDataOutput()
	 * @generated
	 */
	EReference getDataOutput_Base_OutputPin();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#isCollection <em>Is Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Collection</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#isCollection()
	 * @see #getDataOutput()
	 * @generated
	 */
	EAttribute getDataOutput_IsCollection();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#getBase_Parameter <em>Base Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Parameter</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#getBase_Parameter()
	 * @see #getDataOutput()
	 * @generated
	 */
	EReference getDataOutput_Base_Parameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#getBase_ActivityParameterNode <em>Base Activity Parameter Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Activity Parameter Node</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#getBase_ActivityParameterNode()
	 * @see #getDataOutput()
	 * @generated
	 */
	EReference getDataOutput_Base_ActivityParameterNode();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#getOutputSetRefs <em>Output Set Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Output Set Refs</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#getOutputSetRefs()
	 * @see #getDataOutput()
	 * @generated
	 */
	EReference getDataOutput_OutputSetRefs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#getOutputSetWithOptional <em>Output Set With Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Output Set With Optional</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#getOutputSetWithOptional()
	 * @see #getDataOutput()
	 * @generated
	 */
	EReference getDataOutput_OutputSetWithOptional();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#getOutputSetWithWhileExecuting <em>Output Set With While Executing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Output Set With While Executing</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#getOutputSetWithWhileExecuting()
	 * @see #getDataOutput()
	 * @generated
	 */
	EReference getDataOutput_OutputSetWithWhileExecuting();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#DataOutputnotation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Data Outputnotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Data Outputnotation</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#DataOutputnotation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getDataOutput__DataOutputnotation__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#DataOutputitemSubjectRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Data Outputitem Subject Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Data Outputitem Subject Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#DataOutputitemSubjectRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getDataOutput__DataOutputitemSubjectRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet <em>Output Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Set</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet
	 * @generated
	 */
	EClass getOutputSet();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet#getBase_ParameterSet <em>Base Parameter Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Parameter Set</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet#getBase_ParameterSet()
	 * @see #getOutputSet()
	 * @generated
	 */
	EReference getOutputSet_Base_ParameterSet();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet#getOptionalOutputRefs <em>Optional Output Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Optional Output Refs</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet#getOptionalOutputRefs()
	 * @see #getOutputSet()
	 * @generated
	 */
	EReference getOutputSet_OptionalOutputRefs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet#getWhileExecutingOutputRefs <em>While Executing Output Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>While Executing Output Refs</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet#getWhileExecutingOutputRefs()
	 * @see #getOutputSet()
	 * @generated
	 */
	EReference getOutputSet_WhileExecutingOutputRefs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet#getDataOutputRefs <em>Data Output Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Data Output Refs</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet#getDataOutputRefs()
	 * @see #getOutputSet()
	 * @generated
	 */
	EReference getOutputSet_DataOutputRefs();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet#OutputSetdataOutputRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Output Setdata Output Refs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Output Setdata Output Refs</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet#OutputSetdataOutputRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOutputSet__OutputSetdataOutputRefs__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet#OutputSetoptionalOutputRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Output Setoptional Output Refs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Output Setoptional Output Refs</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet#OutputSetoptionalOutputRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOutputSet__OutputSetoptionalOutputRefs__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet#OutputSetwhileExecutingOutputRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Output Setwhile Executing Output Refs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Output Setwhile Executing Output Refs</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet#OutputSetwhileExecutingOutputRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOutputSet__OutputSetwhileExecutingOutputRefs__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNInterface <em>BPMN Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPMN Interface</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNInterface
	 * @generated
	 */
	EClass getBPMNInterface();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNInterface#getBase_Interface <em>Base Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Interface</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNInterface#getBase_Interface()
	 * @see #getBPMNInterface()
	 * @generated
	 */
	EReference getBPMNInterface_Base_Interface();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNInterface#getImplementationRef <em>Implementation Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Implementation Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNInterface#getImplementationRef()
	 * @see #getBPMNInterface()
	 * @generated
	 */
	EReference getBPMNInterface_ImplementationRef();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNInterface#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Operations</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNInterface#getOperations()
	 * @see #getBPMNInterface()
	 * @generated
	 */
	EReference getBPMNInterface_Operations();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNInterface#getCallableElements <em>Callable Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Callable Elements</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNInterface#getCallableElements()
	 * @see #getBPMNInterface()
	 * @generated
	 */
	EReference getBPMNInterface_CallableElements();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNInterface#Interfaceoperationmultiplicity(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Interfaceoperationmultiplicity</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Interfaceoperationmultiplicity</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNInterface#Interfaceoperationmultiplicity(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNInterface__Interfaceoperationmultiplicity__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNInterface#InterfaceownedOperation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Interfaceowned Operation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Interfaceowned Operation</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNInterface#InterfaceownedOperation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNInterface__InterfaceownedOperation__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNInterface#BPMNInterfacecallableElements(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>BPMN Interfacecallable Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>BPMN Interfacecallable Elements</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNInterface#BPMNInterfacecallableElements(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNInterface__BPMNInterfacecallableElements__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNInterface#BPMNInterfaceoperations(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>BPMN Interfaceoperations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>BPMN Interfaceoperations</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNInterface#BPMNInterfaceoperations(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNInterface__BPMNInterfaceoperations__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation <em>BPMN Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPMN Operation</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation
	 * @generated
	 */
	EClass getBPMNOperation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#getBase_Operation <em>Base Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Operation</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#getBase_Operation()
	 * @see #getBPMNOperation()
	 * @generated
	 */
	EReference getBPMNOperation_Base_Operation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#getImplementationRef <em>Implementation Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Implementation Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#getImplementationRef()
	 * @see #getBPMNOperation()
	 * @generated
	 */
	EReference getBPMNOperation_ImplementationRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#getInMessageRef <em>In Message Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>In Message Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#getInMessageRef()
	 * @see #getBPMNOperation()
	 * @generated
	 */
	EReference getBPMNOperation_InMessageRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#getOutMessageRef <em>Out Message Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Out Message Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#getOutMessageRef()
	 * @see #getBPMNOperation()
	 * @generated
	 */
	EReference getBPMNOperation_OutMessageRef();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#getErrorRef <em>Error Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Error Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#getErrorRef()
	 * @see #getBPMNOperation()
	 * @generated
	 */
	EReference getBPMNOperation_ErrorRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#BPMNOperationowner(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>BPMN Operationowner</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>BPMN Operationowner</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#BPMNOperationowner(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNOperation__BPMNOperationowner__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#BPMNOperationinMessageRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>BPMN Operationin Message Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>BPMN Operationin Message Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#BPMNOperationinMessageRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNOperation__BPMNOperationinMessageRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#BPMNOperationoutMessageRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>BPMN Operationout Message Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>BPMN Operationout Message Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#BPMNOperationoutMessageRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNOperation__BPMNOperationoutMessageRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#BPMNOperationerrorRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>BPMN Operationerror Refs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>BPMN Operationerror Refs</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#BPMNOperationerrorRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNOperation__BPMNOperationerrorRefs__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNMessage <em>BPMN Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPMN Message</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNMessage
	 * @generated
	 */
	EClass getBPMNMessage();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNMessage#getItemRef <em>Item Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Item Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNMessage#getItemRef()
	 * @see #getBPMNMessage()
	 * @generated
	 */
	EReference getBPMNMessage_ItemRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNMessage#MessageitemRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Messageitem Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Messageitem Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNMessage#MessageitemRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNMessage__MessageitemRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Error <em>Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Error
	 * @generated
	 */
	EClass getError();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Error#getErrorCode <em>Error Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error Code</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Error#getErrorCode()
	 * @see #getError()
	 * @generated
	 */
	EAttribute getError_ErrorCode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputBinding <em>Input Output Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Output Binding</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputBinding
	 * @generated
	 */
	EClass getInputOutputBinding();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputBinding#getInputDataRef <em>Input Data Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input Data Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputBinding#getInputDataRef()
	 * @see #getInputOutputBinding()
	 * @generated
	 */
	EReference getInputOutputBinding_InputDataRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputBinding#getOutputDataRef <em>Output Data Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Output Data Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputBinding#getOutputDataRef()
	 * @see #getInputOutputBinding()
	 * @generated
	 */
	EReference getInputOutputBinding_OutputDataRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputBinding#getOperationRef <em>Operation Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputBinding#getOperationRef()
	 * @see #getInputOutputBinding()
	 * @generated
	 */
	EReference getInputOutputBinding_OperationRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputBinding#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InputOutputBinding#getBase_Dependency()
	 * @see #getInputOutputBinding()
	 * @generated
	 */
	EReference getInputOutputBinding_Base_Dependency();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration <em>BPMN Collaboration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPMN Collaboration</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration
	 * @generated
	 */
	EClass getBPMNCollaboration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration#isClosed <em>Is Closed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Closed</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration#isClosed()
	 * @see #getBPMNCollaboration()
	 * @generated
	 */
	EAttribute getBPMNCollaboration_IsClosed();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration#getParticipantAssociations <em>Participant Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Participant Associations</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration#getParticipantAssociations()
	 * @see #getBPMNCollaboration()
	 * @generated
	 */
	EReference getBPMNCollaboration_ParticipantAssociations();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration#getConversationLinks <em>Conversation Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Conversation Links</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration#getConversationLinks()
	 * @see #getBPMNCollaboration()
	 * @generated
	 */
	EReference getBPMNCollaboration_ConversationLinks();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration#getMessageFlowAssociations <em>Message Flow Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Message Flow Associations</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration#getMessageFlowAssociations()
	 * @see #getBPMNCollaboration()
	 * @generated
	 */
	EReference getBPMNCollaboration_MessageFlowAssociations();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration#getMessageFlows <em>Message Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Message Flows</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration#getMessageFlows()
	 * @see #getBPMNCollaboration()
	 * @generated
	 */
	EReference getBPMNCollaboration_MessageFlows();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration#getBase_Collaboration <em>Base Collaboration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Collaboration</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration#getBase_Collaboration()
	 * @see #getBPMNCollaboration()
	 * @generated
	 */
	EReference getBPMNCollaboration_Base_Collaboration();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration#getConversations <em>Conversations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Conversations</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration#getConversations()
	 * @see #getBPMNCollaboration()
	 * @generated
	 */
	EReference getBPMNCollaboration_Conversations();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration#getCorrelationKeys <em>Correlation Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Correlation Keys</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration#getCorrelationKeys()
	 * @see #getBPMNCollaboration()
	 * @generated
	 */
	EReference getBPMNCollaboration_CorrelationKeys();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration#getParticipants <em>Participants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Participants</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration#getParticipants()
	 * @see #getBPMNCollaboration()
	 * @generated
	 */
	EReference getBPMNCollaboration_Participants();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration#Collaborationparticipants(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Collaborationparticipants</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Collaborationparticipants</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNCollaboration#Collaborationparticipants(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNCollaboration__Collaborationparticipants__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantAssociation <em>Participant Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Participant Association</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantAssociation
	 * @generated
	 */
	EClass getParticipantAssociation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantAssociation#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantAssociation#getBase_Dependency()
	 * @see #getParticipantAssociation()
	 * @generated
	 */
	EReference getParticipantAssociation_Base_Dependency();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantAssociation#getInnerParticipantRef <em>Inner Participant Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inner Participant Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantAssociation#getInnerParticipantRef()
	 * @see #getParticipantAssociation()
	 * @generated
	 */
	EReference getParticipantAssociation_InnerParticipantRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantAssociation#getOuterParticipantRef <em>Outer Participant Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outer Participant Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantAssociation#getOuterParticipantRef()
	 * @see #getParticipantAssociation()
	 * @generated
	 */
	EReference getParticipantAssociation_OuterParticipantRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantAssociation#ParticipantAssociationinnerParticipantRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Participant Associationinner Participant Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Participant Associationinner Participant Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantAssociation#ParticipantAssociationinnerParticipantRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getParticipantAssociation__ParticipantAssociationinnerParticipantRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantAssociation#ParticipantAssociationouterParticipantRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Participant Associationouter Participant Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Participant Associationouter Participant Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantAssociation#ParticipantAssociationouterParticipantRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getParticipantAssociation__ParticipantAssociationouterParticipantRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Participant <em>Participant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Participant</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Participant
	 * @generated
	 */
	EClass getParticipant();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Participant#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Participant#getBase_Property()
	 * @see #getParticipant()
	 * @generated
	 */
	EReference getParticipant_Base_Property();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Participant#getProcessRef <em>Process Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Process Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Participant#getProcessRef()
	 * @see #getParticipant()
	 * @generated
	 */
	EReference getParticipant_ProcessRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Participant#getParticipantMultiplicity <em>Participant Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Participant Multiplicity</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Participant#getParticipantMultiplicity()
	 * @see #getParticipant()
	 * @generated
	 */
	EReference getParticipant_ParticipantMultiplicity();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Participant#getPartnerEntityRef <em>Partner Entity Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Partner Entity Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Participant#getPartnerEntityRef()
	 * @see #getParticipant()
	 * @generated
	 */
	EReference getParticipant_PartnerEntityRef();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Participant#getPartnerRoleRef <em>Partner Role Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Partner Role Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Participant#getPartnerRoleRef()
	 * @see #getParticipant()
	 * @generated
	 */
	EReference getParticipant_PartnerRoleRef();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Participant#getInterfaceRefs <em>Interface Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Interface Refs</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Participant#getInterfaceRefs()
	 * @see #getParticipant()
	 * @generated
	 */
	EReference getParticipant_InterfaceRefs();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Participant#Participantownership(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Participantownership</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Participantownership</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Participant#Participantownership(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getParticipant__Participantownership__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Participant#Participanttype(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Participanttype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Participanttype</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Participant#Participanttype(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getParticipant__Participanttype__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Participant#ParticipantmultiplicityMinimum(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Participantmultiplicity Minimum</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Participantmultiplicity Minimum</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Participant#ParticipantmultiplicityMinimum(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getParticipant__ParticipantmultiplicityMinimum__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Participant#Participantrealizationsupplier(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Participantrealizationsupplier</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Participantrealizationsupplier</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Participant#Participantrealizationsupplier(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getParticipant__Participantrealizationsupplier__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Participant#ParticipantprocessRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Participantprocess Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Participantprocess Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Participant#ParticipantprocessRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getParticipant__ParticipantprocessRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Participant#ParticipantmultiplicityMaximum(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Participantmultiplicity Maximum</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Participantmultiplicity Maximum</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Participant#ParticipantmultiplicityMaximum(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getParticipant__ParticipantmultiplicityMaximum__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Participant#participantpartnerEntityRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Participantpartner Entity Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Participantpartner Entity Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Participant#participantpartnerEntityRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getParticipant__ParticipantpartnerEntityRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Participant#participantpartnerRoleRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Participantpartner Role Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Participantpartner Role Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Participant#participantpartnerRoleRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getParticipant__ParticipantpartnerRoleRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Participant#ParticipantinterfaceRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Participantinterface Refs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Participantinterface Refs</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Participant#ParticipantinterfaceRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getParticipant__ParticipantinterfaceRefs__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InteractionNode <em>Interaction Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interaction Node</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InteractionNode
	 * @generated
	 */
	EClass getInteractionNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InteractionNode#getBase_Element <em>Base Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Element</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InteractionNode#getBase_Element()
	 * @see #getInteractionNode()
	 * @generated
	 */
	EReference getInteractionNode_Base_Element();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InteractionNode#getOutgoingConversationLinks <em>Outgoing Conversation Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Conversation Links</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InteractionNode#getOutgoingConversationLinks()
	 * @see #getInteractionNode()
	 * @generated
	 */
	EReference getInteractionNode_OutgoingConversationLinks();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.InteractionNode#getIncomingConversationLinks <em>Incoming Conversation Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Incoming Conversation Links</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.InteractionNode#getIncomingConversationLinks()
	 * @see #getInteractionNode()
	 * @generated
	 */
	EReference getInteractionNode_IncomingConversationLinks();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ConversationLink <em>Conversation Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conversation Link</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ConversationLink
	 * @generated
	 */
	EClass getConversationLink();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ConversationLink#getCollaboration <em>Collaboration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Collaboration</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ConversationLink#getCollaboration()
	 * @see #getConversationLink()
	 * @generated
	 */
	EReference getConversationLink_Collaboration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ConversationLink#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ConversationLink#getBase_Dependency()
	 * @see #getConversationLink()
	 * @generated
	 */
	EReference getConversationLink_Base_Dependency();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ConversationLink#getTargetRef <em>Target Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ConversationLink#getTargetRef()
	 * @see #getConversationLink()
	 * @generated
	 */
	EReference getConversationLink_TargetRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ConversationLink#getSourceRef <em>Source Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ConversationLink#getSourceRef()
	 * @see #getConversationLink()
	 * @generated
	 */
	EReference getConversationLink_SourceRef();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantMultiplicity <em>Participant Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Participant Multiplicity</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantMultiplicity
	 * @generated
	 */
	EClass getParticipantMultiplicity();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantMultiplicity#getBase_MultiplicityElement <em>Base Multiplicity Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Multiplicity Element</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantMultiplicity#getBase_MultiplicityElement()
	 * @see #getParticipantMultiplicity()
	 * @generated
	 */
	EReference getParticipantMultiplicity_Base_MultiplicityElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantMultiplicity#getMinimum <em>Minimum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantMultiplicity#getMinimum()
	 * @see #getParticipantMultiplicity()
	 * @generated
	 */
	EAttribute getParticipantMultiplicity_Minimum();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantMultiplicity#getMaximum <em>Maximum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantMultiplicity#getMaximum()
	 * @see #getParticipantMultiplicity()
	 * @generated
	 */
	EAttribute getParticipantMultiplicity_Maximum();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.PartnerEntity <em>Partner Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partner Entity</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.PartnerEntity
	 * @generated
	 */
	EClass getPartnerEntity();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.PartnerEntity#getBase_InstanceSpecification <em>Base Instance Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Instance Specification</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.PartnerEntity#getBase_InstanceSpecification()
	 * @see #getPartnerEntity()
	 * @generated
	 */
	EReference getPartnerEntity_Base_InstanceSpecification();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.PartnerEntity#getParticipantRef <em>Participant Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Participant Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.PartnerEntity#getParticipantRef()
	 * @see #getPartnerEntity()
	 * @generated
	 */
	EReference getPartnerEntity_ParticipantRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.PartnerEntity#PartnerEntityparticipantRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Partner Entityparticipant Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Partner Entityparticipant Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.PartnerEntity#PartnerEntityparticipantRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getPartnerEntity__PartnerEntityparticipantRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.PartnerRole <em>Partner Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partner Role</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.PartnerRole
	 * @generated
	 */
	EClass getPartnerRole();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.PartnerRole#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.PartnerRole#getBase_Class()
	 * @see #getPartnerRole()
	 * @generated
	 */
	EReference getPartnerRole_Base_Class();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.PartnerRole#getParticipantRef <em>Participant Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Participant Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.PartnerRole#getParticipantRef()
	 * @see #getPartnerRole()
	 * @generated
	 */
	EReference getPartnerRole_ParticipantRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.PartnerRole#PartnerRoleparticipantRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Partner Roleparticipant Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Partner Roleparticipant Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.PartnerRole#PartnerRoleparticipantRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getPartnerRole__PartnerRoleparticipantRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlowAssociation <em>Message Flow Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Flow Association</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlowAssociation
	 * @generated
	 */
	EClass getMessageFlowAssociation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlowAssociation#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlowAssociation#getBase_Dependency()
	 * @see #getMessageFlowAssociation()
	 * @generated
	 */
	EReference getMessageFlowAssociation_Base_Dependency();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlowAssociation#getInnerMessageFlowRef <em>Inner Message Flow Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inner Message Flow Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlowAssociation#getInnerMessageFlowRef()
	 * @see #getMessageFlowAssociation()
	 * @generated
	 */
	EReference getMessageFlowAssociation_InnerMessageFlowRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlowAssociation#getOuterMessageFlowRef <em>Outer Message Flow Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outer Message Flow Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlowAssociation#getOuterMessageFlowRef()
	 * @see #getMessageFlowAssociation()
	 * @generated
	 */
	EReference getMessageFlowAssociation_OuterMessageFlowRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlowAssociation#MessageFlowAssociationinnerMessageFlowRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Message Flow Associationinner Message Flow Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Message Flow Associationinner Message Flow Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlowAssociation#MessageFlowAssociationinnerMessageFlowRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMessageFlowAssociation__MessageFlowAssociationinnerMessageFlowRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlowAssociation#MessageFlowAssociationouterMessageFlowRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Message Flow Associationouter Message Flow Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Message Flow Associationouter Message Flow Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlowAssociation#MessageFlowAssociationouterMessageFlowRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMessageFlowAssociation__MessageFlowAssociationouterMessageFlowRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow <em>Message Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Flow</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow
	 * @generated
	 */
	EClass getMessageFlow();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow#getBase_InformationFlow <em>Base Information Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Information Flow</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow#getBase_InformationFlow()
	 * @see #getMessageFlow()
	 * @generated
	 */
	EReference getMessageFlow_Base_InformationFlow();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow#getSourceRef <em>Source Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow#getSourceRef()
	 * @see #getMessageFlow()
	 * @generated
	 */
	EReference getMessageFlow_SourceRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow#getTargetRef <em>Target Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow#getTargetRef()
	 * @see #getMessageFlow()
	 * @generated
	 */
	EReference getMessageFlow_TargetRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow#getMessageRef <em>Message Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Message Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow#getMessageRef()
	 * @see #getMessageFlow()
	 * @generated
	 */
	EReference getMessageFlow_MessageRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow#MessageFlowsourceRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Message Flowsource Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Message Flowsource Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow#MessageFlowsourceRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMessageFlow__MessageFlowsourceRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow#MessageFlowtargetRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Message Flowtarget Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Message Flowtarget Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow#MessageFlowtargetRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMessageFlow__MessageFlowtargetRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow#MessageFlowmessageRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Message Flowmessage Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Message Flowmessage Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow#MessageFlowmessageRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMessageFlow__MessageFlowmessageRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ConversationNode <em>Conversation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conversation Node</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ConversationNode
	 * @generated
	 */
	EClass getConversationNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ConversationNode#getBase_InformationFlow <em>Base Information Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Information Flow</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ConversationNode#getBase_InformationFlow()
	 * @see #getConversationNode()
	 * @generated
	 */
	EReference getConversationNode_Base_InformationFlow();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ConversationNode#getMessageFlowRefs <em>Message Flow Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Message Flow Refs</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ConversationNode#getMessageFlowRefs()
	 * @see #getConversationNode()
	 * @generated
	 */
	EReference getConversationNode_MessageFlowRefs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ConversationNode#getCorrelationKeys <em>Correlation Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Correlation Keys</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ConversationNode#getCorrelationKeys()
	 * @see #getConversationNode()
	 * @generated
	 */
	EReference getConversationNode_CorrelationKeys();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ConversationNode#getParticipantRefs <em>Participant Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Participant Refs</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ConversationNode#getParticipantRefs()
	 * @see #getConversationNode()
	 * @generated
	 */
	EReference getConversationNode_ParticipantRefs();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ConversationNode#ConversationNodeparticipantRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Conversation Nodeparticipant Refs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Conversation Nodeparticipant Refs</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ConversationNode#ConversationNodeparticipantRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getConversationNode__ConversationNodeparticipantRefs__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationKey <em>Correlation Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Correlation Key</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationKey
	 * @generated
	 */
	EClass getCorrelationKey();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationKey#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationKey#getBase_Class()
	 * @see #getCorrelationKey()
	 * @generated
	 */
	EReference getCorrelationKey_Base_Class();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationKey#getCorrelationPropertyRef <em>Correlation Property Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Correlation Property Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationKey#getCorrelationPropertyRef()
	 * @see #getCorrelationKey()
	 * @generated
	 */
	EReference getCorrelationKey_CorrelationPropertyRef();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationProperty <em>Correlation Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Correlation Property</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationProperty
	 * @generated
	 */
	EClass getCorrelationProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationProperty#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationProperty#getBase_Property()
	 * @see #getCorrelationProperty()
	 * @generated
	 */
	EReference getCorrelationProperty_Base_Property();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationProperty#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationProperty#getType()
	 * @see #getCorrelationProperty()
	 * @generated
	 */
	EReference getCorrelationProperty_Type();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationProperty#getCorrelationPropertyRetrievalExpression <em>Correlation Property Retrieval Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Correlation Property Retrieval Expression</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationProperty#getCorrelationPropertyRetrievalExpression()
	 * @see #getCorrelationProperty()
	 * @generated
	 */
	EReference getCorrelationProperty_CorrelationPropertyRetrievalExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyRetrievalExpression <em>Correlation Property Retrieval Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Correlation Property Retrieval Expression</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyRetrievalExpression
	 * @generated
	 */
	EClass getCorrelationPropertyRetrievalExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyRetrievalExpression#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyRetrievalExpression#getBase_Dependency()
	 * @see #getCorrelationPropertyRetrievalExpression()
	 * @generated
	 */
	EReference getCorrelationPropertyRetrievalExpression_Base_Dependency();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyRetrievalExpression#getMessageRef <em>Message Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Message Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyRetrievalExpression#getMessageRef()
	 * @see #getCorrelationPropertyRetrievalExpression()
	 * @generated
	 */
	EReference getCorrelationPropertyRetrievalExpression_MessageRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyRetrievalExpression#getMessagePath <em>Message Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Message Path</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyRetrievalExpression#getMessagePath()
	 * @see #getCorrelationPropertyRetrievalExpression()
	 * @generated
	 */
	EReference getCorrelationPropertyRetrievalExpression_MessagePath();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.FormalExpression <em>Formal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Formal Expression</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.FormalExpression
	 * @generated
	 */
	EClass getFormalExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.FormalExpression#getEvaluatesToTypeRef <em>Evaluates To Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Evaluates To Type Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.FormalExpression#getEvaluatesToTypeRef()
	 * @see #getFormalExpression()
	 * @generated
	 */
	EReference getFormalExpression_EvaluatesToTypeRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.FormalExpression#FormalExpressionevaluatesToTypeRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Formal Expressionevaluates To Type Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Formal Expressionevaluates To Type Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.FormalExpression#FormalExpressionevaluatesToTypeRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getFormalExpression__FormalExpressionevaluatesToTypeRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationSubscription <em>Correlation Subscription</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Correlation Subscription</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationSubscription
	 * @generated
	 */
	EClass getCorrelationSubscription();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationSubscription#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationSubscription#getBase_Class()
	 * @see #getCorrelationSubscription()
	 * @generated
	 */
	EReference getCorrelationSubscription_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationSubscription#getCorrelationKeyRef <em>Correlation Key Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Correlation Key Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationSubscription#getCorrelationKeyRef()
	 * @see #getCorrelationSubscription()
	 * @generated
	 */
	EReference getCorrelationSubscription_CorrelationKeyRef();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationSubscription#getCorrelationPropertyBinding <em>Correlation Property Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Correlation Property Binding</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationSubscription#getCorrelationPropertyBinding()
	 * @see #getCorrelationSubscription()
	 * @generated
	 */
	EReference getCorrelationSubscription_CorrelationPropertyBinding();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyBinding <em>Correlation Property Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Correlation Property Binding</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyBinding
	 * @generated
	 */
	EClass getCorrelationPropertyBinding();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyBinding#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyBinding#getBase_Property()
	 * @see #getCorrelationPropertyBinding()
	 * @generated
	 */
	EReference getCorrelationPropertyBinding_Base_Property();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyBinding#getDataPath <em>Data Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Path</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyBinding#getDataPath()
	 * @see #getCorrelationPropertyBinding()
	 * @generated
	 */
	EReference getCorrelationPropertyBinding_DataPath();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyBinding#getCorrelationPropertyRef <em>Correlation Property Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Correlation Property Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationPropertyBinding#getCorrelationPropertyRef()
	 * @see #getCorrelationPropertyBinding()
	 * @generated
	 */
	EReference getCorrelationPropertyBinding_CorrelationPropertyRef();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProperty <em>BPMN Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPMN Property</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProperty
	 * @generated
	 */
	EClass getBPMNProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProperty#getBase_DataStoreNode <em>Base Data Store Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Store Node</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProperty#getBase_DataStoreNode()
	 * @see #getBPMNProperty()
	 * @generated
	 */
	EReference getBPMNProperty_Base_DataStoreNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProperty#getUmlProperty <em>Uml Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Uml Property</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProperty#getUmlProperty()
	 * @see #getBPMNProperty()
	 * @generated
	 */
	EReference getBPMNProperty_UmlProperty();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProperty#Propertynotation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Propertynotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Propertynotation</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProperty#Propertynotation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNProperty__Propertynotation__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProperty#BPMNPropertyapply(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>BPMN Propertyapply</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>BPMN Propertyapply</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProperty#BPMNPropertyapply(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNProperty__BPMNPropertyapply__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole <em>Resource Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Role</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole
	 * @generated
	 */
	EClass getResourceRole();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole#getBase_Property()
	 * @see #getResourceRole()
	 * @generated
	 */
	EReference getResourceRole_Base_Property();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole#getResourceAssignmentExpression <em>Resource Assignment Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource Assignment Expression</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole#getResourceAssignmentExpression()
	 * @see #getResourceRole()
	 * @generated
	 */
	EReference getResourceRole_ResourceAssignmentExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole#getResourceRef <em>Resource Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole#getResourceRef()
	 * @see #getResourceRole()
	 * @generated
	 */
	EReference getResourceRole_ResourceRef();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole#getResourceParameterBindings <em>Resource Parameter Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Resource Parameter Bindings</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole#getResourceParameterBindings()
	 * @see #getResourceRole()
	 * @generated
	 */
	EReference getResourceRole_ResourceParameterBindings();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole#getProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Process</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole#getProcess()
	 * @see #getResourceRole()
	 * @generated
	 */
	EReference getResourceRole_Process();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole#ResourceRoleowner(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Resource Roleowner</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Resource Roleowner</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole#ResourceRoleowner(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getResourceRole__ResourceRoleowner__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole#ResourceRoleresourceRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Resource Roleresource Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Resource Roleresource Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole#ResourceRoleresourceRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getResourceRole__ResourceRoleresourceRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole#ResourceRoleisRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Resource Roleis Required</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Resource Roleis Required</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole#ResourceRoleisRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getResourceRole__ResourceRoleisRequired__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole#ResourceRoleprocess(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Resource Roleprocess</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Resource Roleprocess</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole#ResourceRoleprocess(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getResourceRole__ResourceRoleprocess__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole#ResourceRoleresourceParameterBindings(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Resource Roleresource Parameter Bindings</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Resource Roleresource Parameter Bindings</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceRole#ResourceRoleresourceParameterBindings(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getResourceRole__ResourceRoleresourceParameterBindings__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceAssignmentExpression <em>Resource Assignment Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Assignment Expression</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceAssignmentExpression
	 * @generated
	 */
	EClass getResourceAssignmentExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceAssignmentExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceAssignmentExpression#getExpression()
	 * @see #getResourceAssignmentExpression()
	 * @generated
	 */
	EReference getResourceAssignmentExpression_Expression();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceAssignmentExpression#ResourceAssignmentExpressionexpression(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Resource Assignment Expressionexpression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Resource Assignment Expressionexpression</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceAssignmentExpression#ResourceAssignmentExpressionexpression(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getResourceAssignmentExpression__ResourceAssignmentExpressionexpression__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Resource#getResourceParameters <em>Resource Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Resource Parameters</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Resource#getResourceParameters()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_ResourceParameters();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Resource#ResourceresourceParameters(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Resourceresource Parameters</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Resourceresource Parameters</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Resource#ResourceresourceParameters(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getResource__ResourceresourceParameters__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameter <em>Resource Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Parameter</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameter
	 * @generated
	 */
	EClass getResourceParameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameter#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameter#getBase_Property()
	 * @see #getResourceParameter()
	 * @generated
	 */
	EReference getResourceParameter_Base_Property();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameter#getType()
	 * @see #getResourceParameter()
	 * @generated
	 */
	EReference getResourceParameter_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameter#isRequired <em>Is Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Required</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameter#isRequired()
	 * @see #getResourceParameter()
	 * @generated
	 */
	EAttribute getResourceParameter_IsRequired();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameter#ResourceParameterowner(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Resource Parameterowner</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Resource Parameterowner</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameter#ResourceParameterowner(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getResourceParameter__ResourceParameterowner__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameter#ResourceParametertype(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Resource Parametertype</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Resource Parametertype</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameter#ResourceParametertype(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getResourceParameter__ResourceParametertype__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameter#ResourceParameterisRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Resource Parameteris Required</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Resource Parameteris Required</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameter#ResourceParameterisRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getResourceParameter__ResourceParameterisRequired__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameterBinding <em>Resource Parameter Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Parameter Binding</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameterBinding
	 * @generated
	 */
	EClass getResourceParameterBinding();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameterBinding#getBase_Slot <em>Base Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Slot</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameterBinding#getBase_Slot()
	 * @see #getResourceParameterBinding()
	 * @generated
	 */
	EReference getResourceParameterBinding_Base_Slot();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameterBinding#getParameterRef <em>Parameter Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameterBinding#getParameterRef()
	 * @see #getResourceParameterBinding()
	 * @generated
	 */
	EReference getResourceParameterBinding_ParameterRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameterBinding#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameterBinding#getExpression()
	 * @see #getResourceParameterBinding()
	 * @generated
	 */
	EReference getResourceParameterBinding_Expression();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameterBinding#ResourceParameterBindingexpression(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Resource Parameter Bindingexpression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Resource Parameter Bindingexpression</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameterBinding#ResourceParameterBindingexpression(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getResourceParameterBinding__ResourceParameterBindingexpression__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameterBinding#ResourceParameterBindingparameterRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Resource Parameter Bindingparameter Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Resource Parameter Bindingparameter Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ResourceParameterBinding#ResourceParameterBindingparameterRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getResourceParameterBinding__ResourceParameterBindingparameterRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalScriptTask <em>Global Script Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global Script Task</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.GlobalScriptTask
	 * @generated
	 */
	EClass getGlobalScriptTask();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalScriptTask#getScript <em>Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Script</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.GlobalScriptTask#getScript()
	 * @see #getGlobalScriptTask()
	 * @generated
	 */
	EAttribute getGlobalScriptTask_Script();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalScriptTask#getScriptFormat <em>Script Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Script Format</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.GlobalScriptTask#getScriptFormat()
	 * @see #getGlobalScriptTask()
	 * @generated
	 */
	EAttribute getGlobalScriptTask_ScriptFormat();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalScriptTask#GlobalScriptTaskscriptFormat(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Global Script Taskscript Format</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Global Script Taskscript Format</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.GlobalScriptTask#GlobalScriptTaskscriptFormat(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getGlobalScriptTask__GlobalScriptTaskscriptFormat__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalScriptTask#GlobalScriptTaskscript(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Global Script Taskscript</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Global Script Taskscript</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.GlobalScriptTask#GlobalScriptTaskscript(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getGlobalScriptTask__GlobalScriptTaskscript__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalTask <em>Global Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global Task</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.GlobalTask
	 * @generated
	 */
	EClass getGlobalTask();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalTask#getBase_OpaqueBehavior <em>Base Opaque Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Opaque Behavior</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.GlobalTask#getBase_OpaqueBehavior()
	 * @see #getGlobalTask()
	 * @generated
	 */
	EReference getGlobalTask_Base_OpaqueBehavior();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalTask#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Resources</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.GlobalTask#getResources()
	 * @see #getGlobalTask()
	 * @generated
	 */
	EReference getGlobalTask_Resources();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalTask#GlobalTasksupportedInterfaceRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Global Tasksupported Interface Refs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Global Tasksupported Interface Refs</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.GlobalTask#GlobalTasksupportedInterfaceRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getGlobalTask__GlobalTasksupportedInterfaceRefs__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalBusinessRuleTask <em>Global Business Rule Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global Business Rule Task</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.GlobalBusinessRuleTask
	 * @generated
	 */
	EClass getGlobalBusinessRuleTask();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalBusinessRuleTask#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Implementation</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.GlobalBusinessRuleTask#getImplementation()
	 * @see #getGlobalBusinessRuleTask()
	 * @generated
	 */
	EAttribute getGlobalBusinessRuleTask_Implementation();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalBusinessRuleTask#GlobalBusinessRuleTaskimplementation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Global Business Rule Taskimplementation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Global Business Rule Taskimplementation</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.GlobalBusinessRuleTask#GlobalBusinessRuleTaskimplementation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getGlobalBusinessRuleTask__GlobalBusinessRuleTaskimplementation__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CompensateEventDefinition <em>Compensate Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compensate Event Definition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CompensateEventDefinition
	 * @generated
	 */
	EClass getCompensateEventDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CompensateEventDefinition#isWaitForCompletion <em>Wait For Completion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wait For Completion</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CompensateEventDefinition#isWaitForCompletion()
	 * @see #getCompensateEventDefinition()
	 * @generated
	 */
	EAttribute getCompensateEventDefinition_WaitForCompletion();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CompensateEventDefinition#getActivityRef <em>Activity Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Activity Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CompensateEventDefinition#getActivityRef()
	 * @see #getCompensateEventDefinition()
	 * @generated
	 */
	EReference getCompensateEventDefinition_ActivityRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CompensateEventDefinition#getBase_CallEvent <em>Base Call Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Call Event</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CompensateEventDefinition#getBase_CallEvent()
	 * @see #getCompensateEventDefinition()
	 * @generated
	 */
	EReference getCompensateEventDefinition_Base_CallEvent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.EventDefinition <em>Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Definition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.EventDefinition
	 * @generated
	 */
	EClass getEventDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.EventDefinition#getBase_Event <em>Base Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Event</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.EventDefinition#getBase_Event()
	 * @see #getEventDefinition()
	 * @generated
	 */
	EReference getEventDefinition_Base_Event();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity <em>BPMN Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPMN Activity</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity
	 * @generated
	 */
	EClass getBPMNActivity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#isForCompensation <em>Is For Compensation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is For Compensation</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#isForCompensation()
	 * @see #getBPMNActivity()
	 * @generated
	 */
	EAttribute getBPMNActivity_IsForCompensation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#getStartQuantity <em>Start Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Quantity</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#getStartQuantity()
	 * @see #getBPMNActivity()
	 * @generated
	 */
	EAttribute getBPMNActivity_StartQuantity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#getCompletionQuantity <em>Completion Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Completion Quantity</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#getCompletionQuantity()
	 * @see #getBPMNActivity()
	 * @generated
	 */
	EAttribute getBPMNActivity_CompletionQuantity();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#getBase_Action <em>Base Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Action</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#getBase_Action()
	 * @see #getBPMNActivity()
	 * @generated
	 */
	EReference getBPMNActivity_Base_Action();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#getActivityClass <em>Activity Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Activity Class</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#getActivityClass()
	 * @see #getBPMNActivity()
	 * @generated
	 */
	EReference getBPMNActivity_ActivityClass();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Properties</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#getProperties()
	 * @see #getBPMNActivity()
	 * @generated
	 */
	EReference getBPMNActivity_Properties();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#getDefault()
	 * @see #getBPMNActivity()
	 * @generated
	 */
	EReference getBPMNActivity_Default();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#getBoundaryEventRefs <em>Boundary Event Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Boundary Event Refs</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#getBoundaryEventRefs()
	 * @see #getBPMNActivity()
	 * @generated
	 */
	EReference getBPMNActivity_BoundaryEventRefs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#getDataInputAssociations <em>Data Input Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Data Input Associations</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#getDataInputAssociations()
	 * @see #getBPMNActivity()
	 * @generated
	 */
	EReference getBPMNActivity_DataInputAssociations();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#getDataOutputAssociations <em>Data Output Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Data Output Associations</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#getDataOutputAssociations()
	 * @see #getBPMNActivity()
	 * @generated
	 */
	EReference getBPMNActivity_DataOutputAssociations();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#getLoopCharacteristics <em>Loop Characteristics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Loop Characteristics</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#getLoopCharacteristics()
	 * @see #getBPMNActivity()
	 * @generated
	 */
	EReference getBPMNActivity_LoopCharacteristics();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Resources</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#getResources()
	 * @see #getBPMNActivity()
	 * @generated
	 */
	EReference getBPMNActivity_Resources();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#BPMNActivityresources(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>BPMN Activityresources</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>BPMN Activityresources</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#BPMNActivityresources(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNActivity__BPMNActivityresources__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#BPMNActivitycontainer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>BPMN Activitycontainer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>BPMN Activitycontainer</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#BPMNActivitycontainer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNActivity__BPMNActivitycontainer__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#BPMNActivityproperties(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>BPMN Activityproperties</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>BPMN Activityproperties</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#BPMNActivityproperties(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNActivity__BPMNActivityproperties__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#BPMNActivitydefault(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>BPMN Activitydefault</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>BPMN Activitydefault</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#BPMNActivitydefault(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNActivity__BPMNActivitydefault__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#BPMNActivityboundaryEventsRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>BPMN Activityboundary Events Refs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>BPMN Activityboundary Events Refs</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#BPMNActivityboundaryEventsRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNActivity__BPMNActivityboundaryEventsRefs__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#BPMNActivityloopCharacteristics(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>BPMN Activityloop Characteristics</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>BPMN Activityloop Characteristics</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity#BPMNActivityloopCharacteristics(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNActivity__BPMNActivityloopCharacteristics__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BoundaryEvent <em>Boundary Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boundary Event</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BoundaryEvent
	 * @generated
	 */
	EClass getBoundaryEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BoundaryEvent#isCancelActivity <em>Cancel Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cancel Activity</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BoundaryEvent#isCancelActivity()
	 * @see #getBoundaryEvent()
	 * @generated
	 */
	EAttribute getBoundaryEvent_CancelActivity();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BoundaryEvent#getAttachedToRef <em>Attached To Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attached To Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BoundaryEvent#getAttachedToRef()
	 * @see #getBoundaryEvent()
	 * @generated
	 */
	EReference getBoundaryEvent_AttachedToRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BoundaryEvent#boundaryEventattachedToRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Boundary Eventattached To Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Boundary Eventattached To Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BoundaryEvent#boundaryEventattachedToRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBoundaryEvent__BoundaryEventattachedToRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CatchEvent <em>Catch Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Catch Event</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CatchEvent
	 * @generated
	 */
	EClass getCatchEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CatchEvent#isParallelMultiple <em>Parallel Multiple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parallel Multiple</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CatchEvent#isParallelMultiple()
	 * @see #getCatchEvent()
	 * @generated
	 */
	EAttribute getCatchEvent_ParallelMultiple();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CatchEvent#getBase_AcceptEventAction <em>Base Accept Event Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Accept Event Action</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CatchEvent#getBase_AcceptEventAction()
	 * @see #getCatchEvent()
	 * @generated
	 */
	EReference getCatchEvent_Base_AcceptEventAction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CatchEvent#getBase_InitialNode <em>Base Initial Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Initial Node</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CatchEvent#getBase_InitialNode()
	 * @see #getCatchEvent()
	 * @generated
	 */
	EReference getCatchEvent_Base_InitialNode();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CatchEvent#getDataOutputAssociation <em>Data Output Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Data Output Association</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CatchEvent#getDataOutputAssociation()
	 * @see #getCatchEvent()
	 * @generated
	 */
	EReference getCatchEvent_DataOutputAssociation();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CatchEvent#catchEventeventDefinitionsRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Catch Eventevent Definitions Refs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Catch Eventevent Definitions Refs</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CatchEvent#catchEventeventDefinitionsRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCatchEvent__CatchEventeventDefinitionsRefs__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNEvent <em>BPMN Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPMN Event</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNEvent
	 * @generated
	 */
	EClass getBPMNEvent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNEvent#getEventClass <em>Event Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event Class</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNEvent#getEventClass()
	 * @see #getBPMNEvent()
	 * @generated
	 */
	EReference getBPMNEvent_EventClass();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNEvent#get_eventDefinitions <em>event Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>event Definitions</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNEvent#get_eventDefinitions()
	 * @see #getBPMNEvent()
	 * @generated
	 */
	EReference getBPMNEvent__eventDefinitions();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNEvent#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Properties</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNEvent#getProperties()
	 * @see #getBPMNEvent()
	 * @generated
	 */
	EReference getBPMNEvent_Properties();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNEvent#getEventDefinitionRefs <em>Event Definition Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Event Definition Refs</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNEvent#getEventDefinitionRefs()
	 * @see #getBPMNEvent()
	 * @generated
	 */
	EReference getBPMNEvent_EventDefinitionRefs();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutputAssociation <em>Data Output Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Output Association</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataOutputAssociation
	 * @generated
	 */
	EClass getDataOutputAssociation();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutputAssociation#dataOutputAssociationsource(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Data Output Associationsource</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Data Output Associationsource</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataOutputAssociation#dataOutputAssociationsource(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getDataOutputAssociation__DataOutputAssociationsource__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutputAssociation#dataOutputAssociationtarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Data Output Associationtarget</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Data Output Associationtarget</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataOutputAssociation#dataOutputAssociationtarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getDataOutputAssociation__DataOutputAssociationtarget__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation <em>Data Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Association</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation
	 * @generated
	 */
	EClass getDataAssociation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#getBase_ObjectFlow <em>Base Object Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Object Flow</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#getBase_ObjectFlow()
	 * @see #getDataAssociation()
	 * @generated
	 */
	EReference getDataAssociation_Base_ObjectFlow();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#getSourceRef <em>Source Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#getSourceRef()
	 * @see #getDataAssociation()
	 * @generated
	 */
	EReference getDataAssociation_SourceRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#getTargetRef <em>Target Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#getTargetRef()
	 * @see #getDataAssociation()
	 * @generated
	 */
	EReference getDataAssociation_TargetRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Transformation</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#getTransformation()
	 * @see #getDataAssociation()
	 * @generated
	 */
	EReference getDataAssociation_Transformation();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#getAssignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Assignment</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#getAssignment()
	 * @see #getDataAssociation()
	 * @generated
	 */
	EReference getDataAssociation_Assignment();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#DataAssociationsource(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Data Associationsource</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Data Associationsource</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#DataAssociationsource(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getDataAssociation__DataAssociationsource__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#DataAssociationtransformation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Data Associationtransformation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Data Associationtransformation</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#DataAssociationtransformation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getDataAssociation__DataAssociationtransformation__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#DataAssociationtarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Data Associationtarget</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Data Associationtarget</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataAssociation#DataAssociationtarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getDataAssociation__DataAssociationtarget__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Assignment
	 * @generated
	 */
	EClass getAssignment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Assignment#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Assignment#getBase_Dependency()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_Base_Dependency();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Assignment#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Assignment#getFrom()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_From();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Assignment#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Assignment#getTo()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_To();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataInputAssociation <em>Data Input Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Input Association</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataInputAssociation
	 * @generated
	 */
	EClass getDataInputAssociation();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataInputAssociation#dataInputAssociationsource(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Data Input Associationsource</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Data Input Associationsource</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataInputAssociation#dataInputAssociationsource(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getDataInputAssociation__DataInputAssociationsource__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataInputAssociation#dataInputAssociationtarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Data Input Associationtarget</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Data Input Associationtarget</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataInputAssociation#dataInputAssociationtarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getDataInputAssociation__DataInputAssociationtarget__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.LoopCharacteristics <em>Loop Characteristics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Characteristics</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.LoopCharacteristics
	 * @generated
	 */
	EClass getLoopCharacteristics();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.LoopCharacteristics#getBase_StructuredActivityNode <em>Base Structured Activity Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Structured Activity Node</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.LoopCharacteristics#getBase_StructuredActivityNode()
	 * @see #getLoopCharacteristics()
	 * @generated
	 */
	EReference getLoopCharacteristics_Base_StructuredActivityNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.EscalationEventDefinition <em>Escalation Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Escalation Event Definition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.EscalationEventDefinition
	 * @generated
	 */
	EClass getEscalationEventDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.EscalationEventDefinition#getEscalationRef <em>Escalation Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Escalation Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.EscalationEventDefinition#getEscalationRef()
	 * @see #getEscalationEventDefinition()
	 * @generated
	 */
	EReference getEscalationEventDefinition_EscalationRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.EscalationEventDefinition#getBase_CallEvent <em>Base Call Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Call Event</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.EscalationEventDefinition#getBase_CallEvent()
	 * @see #getEscalationEventDefinition()
	 * @generated
	 */
	EReference getEscalationEventDefinition_Base_CallEvent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Escalation <em>Escalation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Escalation</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Escalation
	 * @generated
	 */
	EClass getEscalation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Escalation#getEscalationCode <em>Escalation Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Escalation Code</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Escalation#getEscalationCode()
	 * @see #getEscalation()
	 * @generated
	 */
	EAttribute getEscalation_EscalationCode();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Escalation#EscalationstructureRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Escalationstructure Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Escalationstructure Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Escalation#EscalationstructureRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getEscalation__EscalationstructureRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.TimerEventDefinition <em>Timer Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timer Event Definition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.TimerEventDefinition
	 * @generated
	 */
	EClass getTimerEventDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.TimerEventDefinition#getTimeCycle <em>Time Cycle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Time Cycle</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.TimerEventDefinition#getTimeCycle()
	 * @see #getTimerEventDefinition()
	 * @generated
	 */
	EReference getTimerEventDefinition_TimeCycle();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.TimerEventDefinition#getTimeDate <em>Time Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Time Date</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.TimerEventDefinition#getTimeDate()
	 * @see #getTimerEventDefinition()
	 * @generated
	 */
	EReference getTimerEventDefinition_TimeDate();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.TimerEventDefinition#getTimeDuration <em>Time Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Time Duration</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.TimerEventDefinition#getTimeDuration()
	 * @see #getTimerEventDefinition()
	 * @generated
	 */
	EReference getTimerEventDefinition_TimeDuration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.TimerEventDefinition#getBase_ChangeEvent <em>Base Change Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Change Event</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.TimerEventDefinition#getBase_ChangeEvent()
	 * @see #getTimerEventDefinition()
	 * @generated
	 */
	EReference getTimerEventDefinition_Base_ChangeEvent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SignalEventDefinition <em>Signal Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Signal Event Definition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SignalEventDefinition
	 * @generated
	 */
	EClass getSignalEventDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SignalEventDefinition#getSignalRef <em>Signal Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signal Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SignalEventDefinition#getSignalRef()
	 * @see #getSignalEventDefinition()
	 * @generated
	 */
	EReference getSignalEventDefinition_SignalRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SignalEventDefinition#getBase_CallEvent <em>Base Call Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Call Event</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SignalEventDefinition#getBase_CallEvent()
	 * @see #getSignalEventDefinition()
	 * @generated
	 */
	EReference getSignalEventDefinition_Base_CallEvent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNSignal <em>BPMN Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPMN Signal</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNSignal
	 * @generated
	 */
	EClass getBPMNSignal();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNSignal#BPMNSignalstructureRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>BPMN Signalstructure Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>BPMN Signalstructure Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNSignal#BPMNSignalstructureRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBPMNSignal__BPMNSignalstructureRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.EndEvent <em>End Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End Event</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.EndEvent
	 * @generated
	 */
	EClass getEndEvent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.EndEvent#getBase_FinalNode <em>Base Final Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Final Node</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.EndEvent#getBase_FinalNode()
	 * @see #getEndEvent()
	 * @generated
	 */
	EReference getEndEvent_Base_FinalNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ThrowEvent <em>Throw Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Throw Event</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ThrowEvent
	 * @generated
	 */
	EClass getThrowEvent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ThrowEvent#getBase_CallOperationAction <em>Base Call Operation Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Call Operation Action</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ThrowEvent#getBase_CallOperationAction()
	 * @see #getThrowEvent()
	 * @generated
	 */
	EReference getThrowEvent_Base_CallOperationAction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ThrowEvent#getBase_FlowFinalNode <em>Base Flow Final Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Flow Final Node</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ThrowEvent#getBase_FlowFinalNode()
	 * @see #getThrowEvent()
	 * @generated
	 */
	EReference getThrowEvent_Base_FlowFinalNode();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ThrowEvent#getDataInputAssociation <em>Data Input Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Data Input Association</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ThrowEvent#getDataInputAssociation()
	 * @see #getThrowEvent()
	 * @generated
	 */
	EReference getThrowEvent_DataInputAssociation();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ThrowEvent#ThrowEventeventDefinitionRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Throw Eventevent Definition Refs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Throw Eventevent Definition Refs</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ThrowEvent#ThrowEventeventDefinitionRefs(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getThrowEvent__ThrowEventeventDefinitionRefs__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageEventDefinition <em>Message Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Event Definition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MessageEventDefinition
	 * @generated
	 */
	EClass getMessageEventDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageEventDefinition#getMessageRef <em>Message Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Message Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MessageEventDefinition#getMessageRef()
	 * @see #getMessageEventDefinition()
	 * @generated
	 */
	EReference getMessageEventDefinition_MessageRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageEventDefinition#getOperationRef <em>Operation Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MessageEventDefinition#getOperationRef()
	 * @see #getMessageEventDefinition()
	 * @generated
	 */
	EReference getMessageEventDefinition_OperationRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageEventDefinition#getBase_CallEvent <em>Base Call Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Call Event</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MessageEventDefinition#getBase_CallEvent()
	 * @see #getMessageEventDefinition()
	 * @generated
	 */
	EReference getMessageEventDefinition_Base_CallEvent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.StartEvent <em>Start Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start Event</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.StartEvent
	 * @generated
	 */
	EClass getStartEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.StartEvent#isInterrupting <em>Is Interrupting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Interrupting</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.StartEvent#isInterrupting()
	 * @see #getStartEvent()
	 * @generated
	 */
	EAttribute getStartEvent_IsInterrupting();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ConditionalEventDefinition <em>Conditional Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional Event Definition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ConditionalEventDefinition
	 * @generated
	 */
	EClass getConditionalEventDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ConditionalEventDefinition#getBase_ChangeEvent <em>Base Change Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Change Event</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ConditionalEventDefinition#getBase_ChangeEvent()
	 * @see #getConditionalEventDefinition()
	 * @generated
	 */
	EReference getConditionalEventDefinition_Base_ChangeEvent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ConditionalEventDefinition#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Condition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ConditionalEventDefinition#getCondition()
	 * @see #getConditionalEventDefinition()
	 * @generated
	 */
	EReference getConditionalEventDefinition_Condition();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ConditionalEventDefinition#conditionalEventDefinitioncondition(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Conditional Event Definitioncondition</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Conditional Event Definitioncondition</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ConditionalEventDefinition#conditionalEventDefinitioncondition(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getConditionalEventDefinition__ConditionalEventDefinitioncondition__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.LinkEventDefinition <em>Link Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Event Definition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.LinkEventDefinition
	 * @generated
	 */
	EClass getLinkEventDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.LinkEventDefinition#get_target <em>target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>target</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.LinkEventDefinition#get_target()
	 * @see #getLinkEventDefinition()
	 * @generated
	 */
	EReference getLinkEventDefinition__target();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.LinkEventDefinition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.LinkEventDefinition#getSource()
	 * @see #getLinkEventDefinition()
	 * @generated
	 */
	EReference getLinkEventDefinition_Source();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.LinkEventDefinition#getBase_CallEvent <em>Base Call Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Call Event</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.LinkEventDefinition#getBase_CallEvent()
	 * @see #getLinkEventDefinition()
	 * @generated
	 */
	EReference getLinkEventDefinition_Base_CallEvent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ErrorEventDefinition <em>Error Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Event Definition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ErrorEventDefinition
	 * @generated
	 */
	EClass getErrorEventDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ErrorEventDefinition#getErrorRef <em>Error Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Error Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ErrorEventDefinition#getErrorRef()
	 * @see #getErrorEventDefinition()
	 * @generated
	 */
	EReference getErrorEventDefinition_ErrorRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ErrorEventDefinition#getBase_CallEvent <em>Base Call Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Call Event</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ErrorEventDefinition#getBase_CallEvent()
	 * @see #getErrorEventDefinition()
	 * @generated
	 */
	EReference getErrorEventDefinition_Base_CallEvent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.IntermediateCatchEvent <em>Intermediate Catch Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Intermediate Catch Event</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.IntermediateCatchEvent
	 * @generated
	 */
	EClass getIntermediateCatchEvent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.IntermediateThrowEvent <em>Intermediate Throw Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Intermediate Throw Event</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.IntermediateThrowEvent
	 * @generated
	 */
	EClass getIntermediateThrowEvent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.IntermediateThrowEvent#getBase_SendObjectAction <em>Base Send Object Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Send Object Action</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.IntermediateThrowEvent#getBase_SendObjectAction()
	 * @see #getIntermediateThrowEvent()
	 * @generated
	 */
	EReference getIntermediateThrowEvent_Base_SendObjectAction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.TerminateEventDefinition <em>Terminate Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminate Event Definition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.TerminateEventDefinition
	 * @generated
	 */
	EClass getTerminateEventDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.TerminateEventDefinition#getBase_CallEvent <em>Base Call Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Call Event</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.TerminateEventDefinition#getBase_CallEvent()
	 * @see #getTerminateEventDefinition()
	 * @generated
	 */
	EReference getTerminateEventDefinition_Base_CallEvent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ImplicitThrowEvent <em>Implicit Throw Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implicit Throw Event</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ImplicitThrowEvent
	 * @generated
	 */
	EClass getImplicitThrowEvent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CancelEventDefinition <em>Cancel Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cancel Event Definition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CancelEventDefinition
	 * @generated
	 */
	EClass getCancelEventDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CancelEventDefinition#getBase_CallEvent <em>Base Call Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Call Event</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CancelEventDefinition#getBase_CallEvent()
	 * @see #getCancelEventDefinition()
	 * @generated
	 */
	EReference getCancelEventDefinition_Base_CallEvent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.TextAnnotation <em>Text Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Annotation</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.TextAnnotation
	 * @generated
	 */
	EClass getTextAnnotation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.TextAnnotation#getBase_Comment <em>Base Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Comment</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.TextAnnotation#getBase_Comment()
	 * @see #getTextAnnotation()
	 * @generated
	 */
	EReference getTextAnnotation_Base_Comment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.TextAnnotation#getTextFormat <em>Text Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Format</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.TextAnnotation#getTextFormat()
	 * @see #getTextAnnotation()
	 * @generated
	 */
	EAttribute getTextAnnotation_TextFormat();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.TextAnnotation#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.TextAnnotation#getText()
	 * @see #getTextAnnotation()
	 * @generated
	 */
	EAttribute getTextAnnotation_Text();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Category
	 * @generated
	 */
	EClass getCategory();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Category#getBase_Enumeration <em>Base Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Enumeration</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Category#getBase_Enumeration()
	 * @see #getCategory()
	 * @generated
	 */
	EReference getCategory_Base_Enumeration();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Category#getCategoryValue <em>Category Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Category Value</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Category#getCategoryValue()
	 * @see #getCategory()
	 * @generated
	 */
	EReference getCategory_CategoryValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Group
	 * @generated
	 */
	EClass getGroup();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Group#getBase_ActivityPartition <em>Base Activity Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Activity Partition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Group#getBase_ActivityPartition()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_Base_ActivityPartition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Group#get_categoryValueRef <em>category Value Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>category Value Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Group#get_categoryValueRef()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup__categoryValueRef();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataObjectReference <em>Data Object Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Object Reference</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataObjectReference
	 * @generated
	 */
	EClass getDataObjectReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataObjectReference#getDataObjectRef <em>Data Object Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Object Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataObjectReference#getDataObjectRef()
	 * @see #getDataObjectReference()
	 * @generated
	 */
	EReference getDataObjectReference_DataObjectRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataObjectReference#getBase_DataStoreNode <em>Base Data Store Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Store Node</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataObjectReference#getBase_DataStoreNode()
	 * @see #getDataObjectReference()
	 * @generated
	 */
	EReference getDataObjectReference_Base_DataStoreNode();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataObjectReference#DataObjectRefsourcetarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Data Object Refsourcetarget</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Data Object Refsourcetarget</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataObjectReference#DataObjectRefsourcetarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getDataObjectReference__DataObjectRefsourcetarget__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataObjectReference#DataObjectRefdataState(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Data Object Refdata State</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Data Object Refdata State</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataObjectReference#DataObjectRefdataState(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getDataObjectReference__DataObjectRefdataState__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataObject <em>Data Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Object</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataObject
	 * @generated
	 */
	EClass getDataObject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataObject#isCollection <em>Is Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Collection</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataObject#isCollection()
	 * @see #getDataObject()
	 * @generated
	 */
	EAttribute getDataObject_IsCollection();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataObject#getBase_DataStoreNode <em>Base Data Store Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Store Node</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataObject#getBase_DataStoreNode()
	 * @see #getDataObject()
	 * @generated
	 */
	EReference getDataObject_Base_DataStoreNode();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataObject#DataObjectdataState(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Data Objectdata State</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Data Objectdata State</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataObject#DataObjectdataState(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getDataObject__DataObjectdataState__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataStore <em>Data Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Store</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataStore
	 * @generated
	 */
	EClass getDataStore();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataStore#getCapacity <em>Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capacity</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataStore#getCapacity()
	 * @see #getDataStore()
	 * @generated
	 */
	EAttribute getDataStore_Capacity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataStore#isUnlimited <em>Is Unlimited</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Unlimited</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataStore#isUnlimited()
	 * @see #getDataStore()
	 * @generated
	 */
	EAttribute getDataStore_IsUnlimited();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataStore#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataStore#getBase_Class()
	 * @see #getDataStore()
	 * @generated
	 */
	EReference getDataStore_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataStore#getItemSubjectRef <em>Item Subject Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Item Subject Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataStore#getItemSubjectRef()
	 * @see #getDataStore()
	 * @generated
	 */
	EReference getDataStore_ItemSubjectRef();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataStoreReference <em>Data Store Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Store Reference</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataStoreReference
	 * @generated
	 */
	EClass getDataStoreReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataStoreReference#get_dataStore <em>data Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>data Store</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataStoreReference#get_dataStore()
	 * @see #getDataStoreReference()
	 * @generated
	 */
	EReference getDataStoreReference__dataStore();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataStoreReference#getBase_DataStoreNode <em>Base Data Store Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Store Node</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.DataStoreReference#getBase_DataStoreNode()
	 * @see #getDataStoreReference()
	 * @generated
	 */
	EReference getDataStoreReference_Base_DataStoreNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.UserTask <em>User Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Task</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.UserTask
	 * @generated
	 */
	EClass getUserTask();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.UserTask#getBase_OpaqueAction <em>Base Opaque Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Opaque Action</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.UserTask#getBase_OpaqueAction()
	 * @see #getUserTask()
	 * @generated
	 */
	EReference getUserTask_Base_OpaqueAction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.UserTask#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.UserTask#getImplementation()
	 * @see #getUserTask()
	 * @generated
	 */
	EAttribute getUserTask_Implementation();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.UserTask#getRenderings <em>Renderings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Renderings</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.UserTask#getRenderings()
	 * @see #getUserTask()
	 * @generated
	 */
	EReference getUserTask_Renderings();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.UserTask#UserTaskimplementation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>User Taskimplementation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>User Taskimplementation</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.UserTask#UserTaskimplementation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getUserTask__UserTaskimplementation__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.UserTask#UserTaskrenderings(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>User Taskrenderings</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>User Taskrenderings</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.UserTask#UserTaskrenderings(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getUserTask__UserTaskrenderings__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Task
	 * @generated
	 */
	EClass getTask();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Task#getIoSpecification <em>Io Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Io Specification</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Task#getIoSpecification()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_IoSpecification();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Rendering <em>Rendering</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rendering</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Rendering
	 * @generated
	 */
	EClass getRendering();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Rendering#getBase_Image <em>Base Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Image</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Rendering#getBase_Image()
	 * @see #getRendering()
	 * @generated
	 */
	EReference getRendering_Base_Image();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.HumanPerformer <em>Human Performer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Human Performer</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.HumanPerformer
	 * @generated
	 */
	EClass getHumanPerformer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Performer <em>Performer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Performer</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Performer
	 * @generated
	 */
	EClass getPerformer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalUserTask <em>Global User Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global User Task</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.GlobalUserTask
	 * @generated
	 */
	EClass getGlobalUserTask();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalUserTask#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Implementation</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.GlobalUserTask#getImplementation()
	 * @see #getGlobalUserTask()
	 * @generated
	 */
	EAttribute getGlobalUserTask_Implementation();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalUserTask#getRenderings <em>Renderings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Renderings</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.GlobalUserTask#getRenderings()
	 * @see #getGlobalUserTask()
	 * @generated
	 */
	EReference getGlobalUserTask_Renderings();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalUserTask#GlobalUserTaskrenderings(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Global User Taskrenderings</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Global User Taskrenderings</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.GlobalUserTask#GlobalUserTaskrenderings(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getGlobalUserTask__GlobalUserTaskrenderings__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalUserTask#GlobalUserTaskimplementation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Global User Taskimplementation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Global User Taskimplementation</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.GlobalUserTask#GlobalUserTaskimplementation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getGlobalUserTask__GlobalUserTaskimplementation__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalManualTask <em>Global Manual Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global Manual Task</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.GlobalManualTask
	 * @generated
	 */
	EClass getGlobalManualTask();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ManualTask <em>Manual Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Manual Task</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ManualTask
	 * @generated
	 */
	EClass getManualTask();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ManualTask#getBase_OpaqueAction <em>Base Opaque Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Opaque Action</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ManualTask#getBase_OpaqueAction()
	 * @see #getManualTask()
	 * @generated
	 */
	EReference getManualTask_Base_OpaqueAction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.PotentialOwner <em>Potential Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Potential Owner</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.PotentialOwner
	 * @generated
	 */
	EClass getPotentialOwner();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SubConversation <em>Sub Conversation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Conversation</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SubConversation
	 * @generated
	 */
	EClass getSubConversation();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SubConversation#getConversationNodes <em>Conversation Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Conversation Nodes</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SubConversation#getConversationNodes()
	 * @see #getSubConversation()
	 * @generated
	 */
	EReference getSubConversation_ConversationNodes();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SubConversation#SubConversationconnectedelements(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Sub Conversationconnectedelements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Sub Conversationconnectedelements</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SubConversation#SubConversationconnectedelements(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSubConversation__SubConversationconnectedelements__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalConversation <em>Global Conversation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global Conversation</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.GlobalConversation
	 * @generated
	 */
	EClass getGlobalConversation();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.GlobalConversation#GlobalConversationcontainedelements(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Global Conversationcontainedelements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Global Conversationcontainedelements</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.GlobalConversation#GlobalConversationcontainedelements(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getGlobalConversation__GlobalConversationcontainedelements__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CallConversation <em>Call Conversation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Conversation</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CallConversation
	 * @generated
	 */
	EClass getCallConversation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CallConversation#get_collaborationUse <em>collaboration Use</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>collaboration Use</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CallConversation#get_collaborationUse()
	 * @see #getCallConversation()
	 * @generated
	 */
	EReference getCallConversation__collaborationUse();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CallConversation#getCalledCollaborationRef <em>Called Collaboration Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Called Collaboration Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CallConversation#getCalledCollaborationRef()
	 * @see #getCallConversation()
	 * @generated
	 */
	EReference getCallConversation_CalledCollaborationRef();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CallConversation#getParticipantAssociations <em>Participant Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Participant Associations</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CallConversation#getParticipantAssociations()
	 * @see #getCallConversation()
	 * @generated
	 */
	EReference getCallConversation_ParticipantAssociations();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CallConversation#CallConversationcalledCollaborationRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Call Conversationcalled Collaboration Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Call Conversationcalled Collaboration Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CallConversation#CallConversationcalledCollaborationRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCallConversation__CallConversationcalledCollaborationRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CallConversation#CallConversationparticipantAssociations(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Call Conversationparticipant Associations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Call Conversationparticipant Associations</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CallConversation#CallConversationparticipantAssociations(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCallConversation__CallConversationparticipantAssociations__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Conversation <em>Conversation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conversation</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Conversation
	 * @generated
	 */
	EClass getConversation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SubProcess <em>Sub Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Process</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SubProcess
	 * @generated
	 */
	EClass getSubProcess();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SubProcess#isTriggeredByEvent <em>Triggered By Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Triggered By Event</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SubProcess#isTriggeredByEvent()
	 * @see #getSubProcess()
	 * @generated
	 */
	EAttribute getSubProcess_TriggeredByEvent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SubProcess#getBase_StructuredActivityNode <em>Base Structured Activity Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Structured Activity Node</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SubProcess#getBase_StructuredActivityNode()
	 * @see #getSubProcess()
	 * @generated
	 */
	EReference getSubProcess_Base_StructuredActivityNode();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SubProcess#getHasLaneSets <em>Has Lane Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Has Lane Sets</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SubProcess#getHasLaneSets()
	 * @see #getSubProcess()
	 * @generated
	 */
	EReference getSubProcess_HasLaneSets();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SubProcess#SubProcesstriggeredByEvent(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Sub Processtriggered By Event</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Sub Processtriggered By Event</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SubProcess#SubProcesstriggeredByEvent(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSubProcess__SubProcesstriggeredByEvent__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CallActivity <em>Call Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Activity</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CallActivity
	 * @generated
	 */
	EClass getCallActivity();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CallActivity#getBase_CallBehaviorAction <em>Base Call Behavior Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Call Behavior Action</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CallActivity#getBase_CallBehaviorAction()
	 * @see #getCallActivity()
	 * @generated
	 */
	EReference getCallActivity_Base_CallBehaviorAction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CallActivity#getCalledElementRef <em>Called Element Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Called Element Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CallActivity#getCalledElementRef()
	 * @see #getCallActivity()
	 * @generated
	 */
	EReference getCallActivity_CalledElementRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CallActivity#CallActivitycalledElementRefvalues(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Call Activitycalled Element Refvalues</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Call Activitycalled Element Refvalues</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.CallActivity#CallActivitycalledElementRefvalues(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getCallActivity__CallActivitycalledElementRefvalues__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BusinessRuleTask <em>Business Rule Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Business Rule Task</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BusinessRuleTask
	 * @generated
	 */
	EClass getBusinessRuleTask();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BusinessRuleTask#getBase_OpaqueAction <em>Base Opaque Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Opaque Action</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BusinessRuleTask#getBase_OpaqueAction()
	 * @see #getBusinessRuleTask()
	 * @generated
	 */
	EReference getBusinessRuleTask_Base_OpaqueAction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BusinessRuleTask#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BusinessRuleTask#getImplementation()
	 * @see #getBusinessRuleTask()
	 * @generated
	 */
	EAttribute getBusinessRuleTask_Implementation();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BusinessRuleTask#BusinessRuleTaskimplementation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Business Rule Taskimplementation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Business Rule Taskimplementation</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BusinessRuleTask#BusinessRuleTaskimplementation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBusinessRuleTask__BusinessRuleTaskimplementation__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ComplexBehaviorDefinition <em>Complex Behavior Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Behavior Definition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ComplexBehaviorDefinition
	 * @generated
	 */
	EClass getComplexBehaviorDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ComplexBehaviorDefinition#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Condition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ComplexBehaviorDefinition#getCondition()
	 * @see #getComplexBehaviorDefinition()
	 * @generated
	 */
	EReference getComplexBehaviorDefinition_Condition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ComplexBehaviorDefinition#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ComplexBehaviorDefinition#getEvent()
	 * @see #getComplexBehaviorDefinition()
	 * @generated
	 */
	EReference getComplexBehaviorDefinition_Event();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ComplexBehaviorDefinition#getBase_ControlFlow <em>Base Control Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Control Flow</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ComplexBehaviorDefinition#getBase_ControlFlow()
	 * @see #getComplexBehaviorDefinition()
	 * @generated
	 */
	EReference getComplexBehaviorDefinition_Base_ControlFlow();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.AdHocSubProcess <em>Ad Hoc Sub Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ad Hoc Sub Process</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.AdHocSubProcess
	 * @generated
	 */
	EClass getAdHocSubProcess();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.AdHocSubProcess#getCompletionCondition <em>Completion Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Completion Condition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.AdHocSubProcess#getCompletionCondition()
	 * @see #getAdHocSubProcess()
	 * @generated
	 */
	EReference getAdHocSubProcess_CompletionCondition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.AdHocSubProcess#getOrdering <em>Ordering</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ordering</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.AdHocSubProcess#getOrdering()
	 * @see #getAdHocSubProcess()
	 * @generated
	 */
	EAttribute getAdHocSubProcess_Ordering();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.AdHocSubProcess#isCancelRemainingInstances <em>Cancel Remaining Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cancel Remaining Instances</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.AdHocSubProcess#isCancelRemainingInstances()
	 * @see #getAdHocSubProcess()
	 * @generated
	 */
	EAttribute getAdHocSubProcess_CancelRemainingInstances();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.AdHocSubProcess#AdHocSubProcesscancelRemainingInstances(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Ad Hoc Sub Processcancel Remaining Instances</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Ad Hoc Sub Processcancel Remaining Instances</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.AdHocSubProcess#AdHocSubProcesscancelRemainingInstances(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getAdHocSubProcess__AdHocSubProcesscancelRemainingInstances__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ScriptTask <em>Script Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Script Task</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ScriptTask
	 * @generated
	 */
	EClass getScriptTask();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ScriptTask#getBase_OpaqueAction <em>Base Opaque Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Opaque Action</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ScriptTask#getBase_OpaqueAction()
	 * @see #getScriptTask()
	 * @generated
	 */
	EReference getScriptTask_Base_OpaqueAction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ScriptTask#getScriptFormat <em>Script Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Script Format</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ScriptTask#getScriptFormat()
	 * @see #getScriptTask()
	 * @generated
	 */
	EAttribute getScriptTask_ScriptFormat();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ScriptTask#getScript <em>Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Script</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ScriptTask#getScript()
	 * @see #getScriptTask()
	 * @generated
	 */
	EAttribute getScriptTask_Script();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ScriptTask#ScriptTaskscriptFormat(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Script Taskscript Format</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Script Taskscript Format</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ScriptTask#ScriptTaskscriptFormat(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getScriptTask__ScriptTaskscriptFormat__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ScriptTask#ScriptTaskscript(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Script Taskscript</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Script Taskscript</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ScriptTask#ScriptTaskscript(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getScriptTask__ScriptTaskscript__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SendTask <em>Send Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Send Task</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SendTask
	 * @generated
	 */
	EClass getSendTask();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SendTask#getMessageRef <em>Message Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Message Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SendTask#getMessageRef()
	 * @see #getSendTask()
	 * @generated
	 */
	EReference getSendTask_MessageRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SendTask#getBase_CallOperationAction <em>Base Call Operation Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Call Operation Action</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SendTask#getBase_CallOperationAction()
	 * @see #getSendTask()
	 * @generated
	 */
	EReference getSendTask_Base_CallOperationAction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SendTask#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SendTask#getImplementation()
	 * @see #getSendTask()
	 * @generated
	 */
	EAttribute getSendTask_Implementation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SendTask#getOperationRef <em>Operation Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SendTask#getOperationRef()
	 * @see #getSendTask()
	 * @generated
	 */
	EReference getSendTask_OperationRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SendTask#SendTaskoperationRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Send Taskoperation Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Send Taskoperation Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.SendTask#SendTaskoperationRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSendTask__SendTaskoperationRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Transaction <em>Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transaction</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Transaction
	 * @generated
	 */
	EClass getTransaction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.Transaction#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.Transaction#getMethod()
	 * @see #getTransaction()
	 * @generated
	 */
	EAttribute getTransaction_Method();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics <em>Standard Loop Characteristics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Standard Loop Characteristics</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics
	 * @generated
	 */
	EClass getStandardLoopCharacteristics();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics#getLoopMaximum <em>Loop Maximum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Loop Maximum</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics#getLoopMaximum()
	 * @see #getStandardLoopCharacteristics()
	 * @generated
	 */
	EAttribute getStandardLoopCharacteristics_LoopMaximum();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics#getBase_LoopNode <em>Base Loop Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Loop Node</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics#getBase_LoopNode()
	 * @see #getStandardLoopCharacteristics()
	 * @generated
	 */
	EReference getStandardLoopCharacteristics_Base_LoopNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics#isTestBefore <em>Test Before</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Before</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics#isTestBefore()
	 * @see #getStandardLoopCharacteristics()
	 * @generated
	 */
	EAttribute getStandardLoopCharacteristics_TestBefore();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics#getLoopCondition <em>Loop Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Loop Condition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics#getLoopCondition()
	 * @see #getStandardLoopCharacteristics()
	 * @generated
	 */
	EReference getStandardLoopCharacteristics_LoopCondition();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics#StandardLoopCharacteristicstestBefore(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Standard Loop Characteristicstest Before</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Standard Loop Characteristicstest Before</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics#StandardLoopCharacteristicstestBefore(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getStandardLoopCharacteristics__StandardLoopCharacteristicstestBefore__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics#StandardLoopCharacteristicsloopCondition(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Standard Loop Characteristicsloop Condition</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Standard Loop Characteristicsloop Condition</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.StandardLoopCharacteristics#StandardLoopCharacteristicsloopCondition(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getStandardLoopCharacteristics__StandardLoopCharacteristicsloopCondition__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ReceiveTask <em>Receive Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Receive Task</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ReceiveTask
	 * @generated
	 */
	EClass getReceiveTask();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ReceiveTask#getMessageRef <em>Message Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Message Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ReceiveTask#getMessageRef()
	 * @see #getReceiveTask()
	 * @generated
	 */
	EReference getReceiveTask_MessageRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ReceiveTask#getBase_AcceptEventAction <em>Base Accept Event Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Accept Event Action</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ReceiveTask#getBase_AcceptEventAction()
	 * @see #getReceiveTask()
	 * @generated
	 */
	EReference getReceiveTask_Base_AcceptEventAction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ReceiveTask#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ReceiveTask#getImplementation()
	 * @see #getReceiveTask()
	 * @generated
	 */
	EAttribute getReceiveTask_Implementation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ReceiveTask#isInstantiate <em>Instantiate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instantiate</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ReceiveTask#isInstantiate()
	 * @see #getReceiveTask()
	 * @generated
	 */
	EAttribute getReceiveTask_Instantiate();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ReceiveTask#getOperationRef <em>Operation Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ReceiveTask#getOperationRef()
	 * @see #getReceiveTask()
	 * @generated
	 */
	EReference getReceiveTask_OperationRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ReceiveTask#ReceiveTaskoperationRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Receive Taskoperation Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Receive Taskoperation Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ReceiveTask#ReceiveTaskoperationRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getReceiveTask__ReceiveTaskoperationRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ServiceTask <em>Service Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Task</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ServiceTask
	 * @generated
	 */
	EClass getServiceTask();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ServiceTask#getBase_CallOperationAction <em>Base Call Operation Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Call Operation Action</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ServiceTask#getBase_CallOperationAction()
	 * @see #getServiceTask()
	 * @generated
	 */
	EReference getServiceTask_Base_CallOperationAction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ServiceTask#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ServiceTask#getImplementation()
	 * @see #getServiceTask()
	 * @generated
	 */
	EAttribute getServiceTask_Implementation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ServiceTask#getOperationRef <em>Operation Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ServiceTask#getOperationRef()
	 * @see #getServiceTask()
	 * @generated
	 */
	EReference getServiceTask_OperationRef();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ServiceTask#ServiceTaskinputSet(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Service Taskinput Set</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Service Taskinput Set</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ServiceTask#ServiceTaskinputSet(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getServiceTask__ServiceTaskinputSet__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ServiceTask#ServiceTaskoutputSet(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Service Taskoutput Set</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Service Taskoutput Set</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ServiceTask#ServiceTaskoutputSet(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getServiceTask__ServiceTaskoutputSet__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ServiceTask#ServiceTaskoperationRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Service Taskoperation Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Service Taskoperation Ref</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ServiceTask#ServiceTaskoperationRef(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getServiceTask__ServiceTaskoperationRef__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics <em>Multi Instance Loop Characteristics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Instance Loop Characteristics</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics
	 * @generated
	 */
	EClass getMultiInstanceLoopCharacteristics();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getBehavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Behavior</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getBehavior()
	 * @see #getMultiInstanceLoopCharacteristics()
	 * @generated
	 */
	EAttribute getMultiInstanceLoopCharacteristics_Behavior();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getLoopCardinality <em>Loop Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Loop Cardinality</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getLoopCardinality()
	 * @see #getMultiInstanceLoopCharacteristics()
	 * @generated
	 */
	EReference getMultiInstanceLoopCharacteristics_LoopCardinality();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getCompletionCondition <em>Completion Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Completion Condition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getCompletionCondition()
	 * @see #getMultiInstanceLoopCharacteristics()
	 * @generated
	 */
	EReference getMultiInstanceLoopCharacteristics_CompletionCondition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getBase_ExpansionRegion <em>Base Expansion Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Expansion Region</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getBase_ExpansionRegion()
	 * @see #getMultiInstanceLoopCharacteristics()
	 * @generated
	 */
	EReference getMultiInstanceLoopCharacteristics_Base_ExpansionRegion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#isSequential <em>Is Sequential</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Sequential</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#isSequential()
	 * @see #getMultiInstanceLoopCharacteristics()
	 * @generated
	 */
	EAttribute getMultiInstanceLoopCharacteristics_IsSequential();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getLoopDataInputRef <em>Loop Data Input Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Loop Data Input Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getLoopDataInputRef()
	 * @see #getMultiInstanceLoopCharacteristics()
	 * @generated
	 */
	EReference getMultiInstanceLoopCharacteristics_LoopDataInputRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getLoopDataOutputRef <em>Loop Data Output Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Loop Data Output Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getLoopDataOutputRef()
	 * @see #getMultiInstanceLoopCharacteristics()
	 * @generated
	 */
	EReference getMultiInstanceLoopCharacteristics_LoopDataOutputRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getOutputDataItem <em>Output Data Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Output Data Item</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getOutputDataItem()
	 * @see #getMultiInstanceLoopCharacteristics()
	 * @generated
	 */
	EReference getMultiInstanceLoopCharacteristics_OutputDataItem();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getInputDataItem <em>Input Data Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input Data Item</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getInputDataItem()
	 * @see #getMultiInstanceLoopCharacteristics()
	 * @generated
	 */
	EReference getMultiInstanceLoopCharacteristics_InputDataItem();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getOneBehaviorEventRef <em>One Behavior Event Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>One Behavior Event Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getOneBehaviorEventRef()
	 * @see #getMultiInstanceLoopCharacteristics()
	 * @generated
	 */
	EReference getMultiInstanceLoopCharacteristics_OneBehaviorEventRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getNoneBehaviorEventRef <em>None Behavior Event Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>None Behavior Event Ref</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getNoneBehaviorEventRef()
	 * @see #getMultiInstanceLoopCharacteristics()
	 * @generated
	 */
	EReference getMultiInstanceLoopCharacteristics_NoneBehaviorEventRef();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getComplexBehaviorDefinition <em>Complex Behavior Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Complex Behavior Definition</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getComplexBehaviorDefinition()
	 * @see #getMultiInstanceLoopCharacteristics()
	 * @generated
	 */
	EReference getMultiInstanceLoopCharacteristics_ComplexBehaviorDefinition();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#MultiinstanceLoopCharacteristicstarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Multiinstance Loop Characteristicstarget</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Multiinstance Loop Characteristicstarget</em>' operation.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#MultiinstanceLoopCharacteristicstarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMultiInstanceLoopCharacteristics__MultiinstanceLoopCharacteristicstarget__DiagnosticChain_Map();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.bpmn.BPMNProfile.AssociationDirection <em>Association Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Association Direction</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.AssociationDirection
	 * @generated
	 */
	EEnum getAssociationDirection();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGatewayType <em>Event Based Gateway Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Event Based Gateway Type</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.EventBasedGatewayType
	 * @generated
	 */
	EEnum getEventBasedGatewayType();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.bpmn.BPMNProfile.GatewayDirection <em>Gateway Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Gateway Direction</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.GatewayDirection
	 * @generated
	 */
	EEnum getGatewayDirection();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.bpmn.BPMNProfile.RelationshipDirection <em>Relationship Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Relationship Direction</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.RelationshipDirection
	 * @generated
	 */
	EEnum getRelationshipDirection();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ItemKind <em>Item Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Item Kind</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ItemKind
	 * @generated
	 */
	EEnum getItemKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ProcessType <em>Process Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Process Type</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.ProcessType
	 * @generated
	 */
	EEnum getProcessType();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.bpmn.BPMNProfile.AdHocOrdering <em>Ad Hoc Ordering</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Ad Hoc Ordering</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.AdHocOrdering
	 * @generated
	 */
	EEnum getAdHocOrdering();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceBehavior <em>Multi Instance Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Multi Instance Behavior</em>'.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceBehavior
	 * @generated
	 */
	EEnum getMultiInstanceBehavior();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BPMNProfileFactory getBPMNProfileFactory();

} //BPMNProfilePackage
