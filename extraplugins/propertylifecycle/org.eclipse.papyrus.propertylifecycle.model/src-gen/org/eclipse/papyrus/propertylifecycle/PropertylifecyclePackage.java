/**
 * Copyright (c) 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 * Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.propertylifecycle;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecycleFactory
 * @model kind="package"
 * @generated
 */
public interface PropertylifecyclePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNAME = "propertylifecycle"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/infra/propertylifecycle/1.0"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eNS_PREFIX = "propertylifecycle"; //$NON-NLS-1$

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	String eCONTENT_TYPE = "org.eclipse.papyrus.infra.propertylifecycle"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	PropertylifecyclePackage eINSTANCE = org.eclipse.papyrus.propertylifecycle.impl.PropertylifecyclePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.propertylifecycle.impl.StrategyTemplateImpl <em>Strategy Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.propertylifecycle.impl.StrategyTemplateImpl
	 * @see org.eclipse.papyrus.propertylifecycle.impl.PropertylifecyclePackageImpl#getStrategyTemplate()
	 * @generated
	 */
	int STRATEGY_TEMPLATE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STRATEGY_TEMPLATE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Decription</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STRATEGY_TEMPLATE__DECRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STRATEGY_TEMPLATE__ID = 2;

	/**
	 * The number of structural features of the '<em>Strategy Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STRATEGY_TEMPLATE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Strategy Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STRATEGY_TEMPLATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.propertylifecycle.impl.StrategySetImpl <em>Strategy Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.propertylifecycle.impl.StrategySetImpl
	 * @see org.eclipse.papyrus.propertylifecycle.impl.PropertylifecyclePackageImpl#getStrategySet()
	 * @generated
	 */
	int STRATEGY_SET = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STRATEGY_SET__NAME = STRATEGY_TEMPLATE__NAME;

	/**
	 * The feature id for the '<em><b>Decription</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STRATEGY_SET__DECRIPTION = STRATEGY_TEMPLATE__DECRIPTION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STRATEGY_SET__ID = STRATEGY_TEMPLATE__ID;

	/**
	 * The feature id for the '<em><b>Strategies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STRATEGY_SET__STRATEGIES = STRATEGY_TEMPLATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Strategy Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STRATEGY_SET_FEATURE_COUNT = STRATEGY_TEMPLATE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Strategy Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STRATEGY_SET_OPERATION_COUNT = STRATEGY_TEMPLATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.propertylifecycle.impl.ElementTemplateImpl <em>Element Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.propertylifecycle.impl.ElementTemplateImpl
	 * @see org.eclipse.papyrus.propertylifecycle.impl.PropertylifecyclePackageImpl#getElementTemplate()
	 * @generated
	 */
	int ELEMENT_TEMPLATE = 3;

	/**
	 * The feature id for the '<em><b>Base Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TEMPLATE__BASE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Specialized Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TEMPLATE__SPECIALIZED_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Element Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TEMPLATE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Element Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TEMPLATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.propertylifecycle.impl.StrategyElementImpl <em>Strategy Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.propertylifecycle.impl.StrategyElementImpl
	 * @see org.eclipse.papyrus.propertylifecycle.impl.PropertylifecyclePackageImpl#getStrategyElement()
	 * @generated
	 */
	int STRATEGY_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Base Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STRATEGY_ELEMENT__BASE_TYPE = ELEMENT_TEMPLATE__BASE_TYPE;

	/**
	 * The feature id for the '<em><b>Specialized Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STRATEGY_ELEMENT__SPECIALIZED_TYPE = ELEMENT_TEMPLATE__SPECIALIZED_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STRATEGY_ELEMENT__NAME = ELEMENT_TEMPLATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Decription</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STRATEGY_ELEMENT__DECRIPTION = ELEMENT_TEMPLATE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STRATEGY_ELEMENT__ID = ELEMENT_TEMPLATE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Element Containers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STRATEGY_ELEMENT__ELEMENT_CONTAINERS = ELEMENT_TEMPLATE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Element Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STRATEGY_ELEMENT__ELEMENT_PROPERTIES = ELEMENT_TEMPLATE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Strategy Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STRATEGY_ELEMENT_FEATURE_COUNT = ELEMENT_TEMPLATE_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Strategy Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int STRATEGY_ELEMENT_OPERATION_COUNT = ELEMENT_TEMPLATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.propertylifecycle.impl.ElementContainerImpl <em>Element Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.propertylifecycle.impl.ElementContainerImpl
	 * @see org.eclipse.papyrus.propertylifecycle.impl.PropertylifecyclePackageImpl#getElementContainer()
	 * @generated
	 */
	int ELEMENT_CONTAINER = 4;

	/**
	 * The feature id for the '<em><b>Base Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CONTAINER__BASE_TYPE = ELEMENT_TEMPLATE__BASE_TYPE;

	/**
	 * The feature id for the '<em><b>Specialized Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CONTAINER__SPECIALIZED_TYPE = ELEMENT_TEMPLATE__SPECIALIZED_TYPE;

	/**
	 * The feature id for the '<em><b>Containers Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CONTAINER__CONTAINERS_CONTAINER = ELEMENT_TEMPLATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Element Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CONTAINER_FEATURE_COUNT = ELEMENT_TEMPLATE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Element Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CONTAINER_OPERATION_COUNT = ELEMENT_TEMPLATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.propertylifecycle.impl.ElementPropertyImpl <em>Element Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.propertylifecycle.impl.ElementPropertyImpl
	 * @see org.eclipse.papyrus.propertylifecycle.impl.PropertylifecyclePackageImpl#getElementProperty()
	 * @generated
	 */
	int ELEMENT_PROPERTY = 5;

	/**
	 * The feature id for the '<em><b>Feature Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ELEMENT_PROPERTY__FEATURE_LABEL = 0;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ELEMENT_PROPERTY__PRIORITY = 1;

	/**
	 * The feature id for the '<em><b>Triggers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ELEMENT_PROPERTY__TRIGGERS = 2;

	/**
	 * The feature id for the '<em><b>Value Processor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ELEMENT_PROPERTY__VALUE_PROCESSOR = 3;

	/**
	 * The number of structural features of the '<em>Element Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ELEMENT_PROPERTY_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Element Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ELEMENT_PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.propertylifecycle.impl.AbstractTriggerImpl <em>Abstract Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.propertylifecycle.impl.AbstractTriggerImpl
	 * @see org.eclipse.papyrus.propertylifecycle.impl.PropertylifecyclePackageImpl#getAbstractTrigger()
	 * @generated
	 */
	int ABSTRACT_TRIGGER = 6;

	/**
	 * The number of structural features of the '<em>Abstract Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TRIGGER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Abstract Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TRIGGER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.propertylifecycle.impl.AbstractValueProcessorImpl <em>Abstract Value Processor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.propertylifecycle.impl.AbstractValueProcessorImpl
	 * @see org.eclipse.papyrus.propertylifecycle.impl.PropertylifecyclePackageImpl#getAbstractValueProcessor()
	 * @generated
	 */
	int ABSTRACT_VALUE_PROCESSOR = 7;

	/**
	 * The number of structural features of the '<em>Abstract Value Processor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VALUE_PROCESSOR_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Abstract Value Processor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VALUE_PROCESSOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.propertylifecycle.impl.JavaProcessorImpl <em>Java Processor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.propertylifecycle.impl.JavaProcessorImpl
	 * @see org.eclipse.papyrus.propertylifecycle.impl.PropertylifecyclePackageImpl#getJavaProcessor()
	 * @generated
	 */
	int JAVA_PROCESSOR = 8;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int JAVA_PROCESSOR__CLASS_NAME = ABSTRACT_VALUE_PROCESSOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Java Processor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int JAVA_PROCESSOR_FEATURE_COUNT = ABSTRACT_VALUE_PROCESSOR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Java Processor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int JAVA_PROCESSOR_OPERATION_COUNT = ABSTRACT_VALUE_PROCESSOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.propertylifecycle.impl.BasicTriggerImpl <em>Basic Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.papyrus.propertylifecycle.impl.BasicTriggerImpl
	 * @see org.eclipse.papyrus.propertylifecycle.impl.PropertylifecyclePackageImpl#getBasicTrigger()
	 * @generated
	 */
	int BASIC_TRIGGER = 9;

	/**
	 * The feature id for the '<em><b>On Create</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int BASIC_TRIGGER__ON_CREATE = ABSTRACT_TRIGGER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>On Delete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int BASIC_TRIGGER__ON_DELETE = ABSTRACT_TRIGGER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>On Open</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int BASIC_TRIGGER__ON_OPEN = ABSTRACT_TRIGGER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>On Move</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int BASIC_TRIGGER__ON_MOVE = ABSTRACT_TRIGGER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Basic Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int BASIC_TRIGGER_FEATURE_COUNT = ABSTRACT_TRIGGER_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Basic Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int BASIC_TRIGGER_OPERATION_COUNT = ABSTRACT_TRIGGER_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.propertylifecycle.StrategyTemplate <em>Strategy Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Strategy Template</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.StrategyTemplate
	 * @generated
	 */
	EClass getStrategyTemplate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.propertylifecycle.StrategyTemplate#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.StrategyTemplate#getName()
	 * @see #getStrategyTemplate()
	 * @generated
	 */
	EAttribute getStrategyTemplate_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.propertylifecycle.StrategyTemplate#getDecription <em>Decription</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Decription</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.StrategyTemplate#getDecription()
	 * @see #getStrategyTemplate()
	 * @generated
	 */
	EAttribute getStrategyTemplate_Decription();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.propertylifecycle.StrategyTemplate#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.StrategyTemplate#getId()
	 * @see #getStrategyTemplate()
	 * @generated
	 */
	EAttribute getStrategyTemplate_Id();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.propertylifecycle.StrategySet <em>Strategy Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Strategy Set</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.StrategySet
	 * @generated
	 */
	EClass getStrategySet();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.propertylifecycle.StrategySet#getStrategies <em>Strategies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Strategies</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.StrategySet#getStrategies()
	 * @see #getStrategySet()
	 * @generated
	 */
	EReference getStrategySet_Strategies();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.propertylifecycle.StrategyElement <em>Strategy Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Strategy Element</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.StrategyElement
	 * @generated
	 */
	EClass getStrategyElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.propertylifecycle.StrategyElement#getElementContainers <em>Element Containers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Element Containers</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.StrategyElement#getElementContainers()
	 * @see #getStrategyElement()
	 * @generated
	 */
	EReference getStrategyElement_ElementContainers();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.propertylifecycle.StrategyElement#getElementProperties <em>Element Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Element Properties</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.StrategyElement#getElementProperties()
	 * @see #getStrategyElement()
	 * @generated
	 */
	EReference getStrategyElement_ElementProperties();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.propertylifecycle.ElementTemplate <em>Element Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Element Template</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.ElementTemplate
	 * @generated
	 */
	EClass getElementTemplate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.propertylifecycle.ElementTemplate#getBaseType <em>Base Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Base Type</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.ElementTemplate#getBaseType()
	 * @see #getElementTemplate()
	 * @generated
	 */
	EAttribute getElementTemplate_BaseType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.propertylifecycle.ElementTemplate#getSpecializedType <em>Specialized Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Specialized Type</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.ElementTemplate#getSpecializedType()
	 * @see #getElementTemplate()
	 * @generated
	 */
	EAttribute getElementTemplate_SpecializedType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.propertylifecycle.ElementContainer <em>Element Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Element Container</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.ElementContainer
	 * @generated
	 */
	EClass getElementContainer();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.propertylifecycle.ElementContainer#getContainersContainer <em>Containers Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference '<em>Containers Container</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.ElementContainer#getContainersContainer()
	 * @see #getElementContainer()
	 * @generated
	 */
	EReference getElementContainer_ContainersContainer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.propertylifecycle.ElementProperty <em>Element Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Element Property</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.ElementProperty
	 * @generated
	 */
	EClass getElementProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.propertylifecycle.ElementProperty#getFeatureLabel <em>Feature Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Feature Label</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.ElementProperty#getFeatureLabel()
	 * @see #getElementProperty()
	 * @generated
	 */
	EAttribute getElementProperty_FeatureLabel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.propertylifecycle.ElementProperty#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.ElementProperty#getPriority()
	 * @see #getElementProperty()
	 * @generated
	 */
	EAttribute getElementProperty_Priority();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.propertylifecycle.ElementProperty#getTriggers <em>Triggers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Triggers</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.ElementProperty#getTriggers()
	 * @see #getElementProperty()
	 * @generated
	 */
	EReference getElementProperty_Triggers();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.propertylifecycle.ElementProperty#getValueProcessor <em>Value Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference '<em>Value Processor</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.ElementProperty#getValueProcessor()
	 * @see #getElementProperty()
	 * @generated
	 */
	EReference getElementProperty_ValueProcessor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.propertylifecycle.AbstractTrigger <em>Abstract Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Abstract Trigger</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.AbstractTrigger
	 * @generated
	 */
	EClass getAbstractTrigger();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.propertylifecycle.AbstractValueProcessor <em>Abstract Value Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Abstract Value Processor</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.AbstractValueProcessor
	 * @generated
	 */
	EClass getAbstractValueProcessor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.propertylifecycle.JavaProcessor <em>Java Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Java Processor</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.JavaProcessor
	 * @generated
	 */
	EClass getJavaProcessor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.propertylifecycle.JavaProcessor#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.JavaProcessor#getClassName()
	 * @see #getJavaProcessor()
	 * @generated
	 */
	EAttribute getJavaProcessor_ClassName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.propertylifecycle.BasicTrigger <em>Basic Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Basic Trigger</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.BasicTrigger
	 * @generated
	 */
	EClass getBasicTrigger();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.propertylifecycle.BasicTrigger#isOnCreate <em>On Create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>On Create</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.BasicTrigger#isOnCreate()
	 * @see #getBasicTrigger()
	 * @generated
	 */
	EAttribute getBasicTrigger_OnCreate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.propertylifecycle.BasicTrigger#isOnDelete <em>On Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>On Delete</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.BasicTrigger#isOnDelete()
	 * @see #getBasicTrigger()
	 * @generated
	 */
	EAttribute getBasicTrigger_OnDelete();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.propertylifecycle.BasicTrigger#isOnOpen <em>On Open</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>On Open</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.BasicTrigger#isOnOpen()
	 * @see #getBasicTrigger()
	 * @generated
	 */
	EAttribute getBasicTrigger_OnOpen();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.propertylifecycle.BasicTrigger#isOnMove <em>On Move</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>On Move</em>'.
	 * @see org.eclipse.papyrus.propertylifecycle.BasicTrigger#isOnMove()
	 * @see #getBasicTrigger()
	 * @generated
	 */
	EAttribute getBasicTrigger_OnMove();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PropertylifecycleFactory getPropertylifecycleFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each operation of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.propertylifecycle.impl.StrategyTemplateImpl <em>Strategy Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.propertylifecycle.impl.StrategyTemplateImpl
		 * @see org.eclipse.papyrus.propertylifecycle.impl.PropertylifecyclePackageImpl#getStrategyTemplate()
		 * @generated
		 */
		EClass STRATEGY_TEMPLATE = eINSTANCE.getStrategyTemplate();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute STRATEGY_TEMPLATE__NAME = eINSTANCE.getStrategyTemplate_Name();

		/**
		 * The meta object literal for the '<em><b>Decription</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute STRATEGY_TEMPLATE__DECRIPTION = eINSTANCE.getStrategyTemplate_Decription();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute STRATEGY_TEMPLATE__ID = eINSTANCE.getStrategyTemplate_Id();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.propertylifecycle.impl.StrategySetImpl <em>Strategy Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.propertylifecycle.impl.StrategySetImpl
		 * @see org.eclipse.papyrus.propertylifecycle.impl.PropertylifecyclePackageImpl#getStrategySet()
		 * @generated
		 */
		EClass STRATEGY_SET = eINSTANCE.getStrategySet();

		/**
		 * The meta object literal for the '<em><b>Strategies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference STRATEGY_SET__STRATEGIES = eINSTANCE.getStrategySet_Strategies();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.propertylifecycle.impl.StrategyElementImpl <em>Strategy Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.propertylifecycle.impl.StrategyElementImpl
		 * @see org.eclipse.papyrus.propertylifecycle.impl.PropertylifecyclePackageImpl#getStrategyElement()
		 * @generated
		 */
		EClass STRATEGY_ELEMENT = eINSTANCE.getStrategyElement();

		/**
		 * The meta object literal for the '<em><b>Element Containers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference STRATEGY_ELEMENT__ELEMENT_CONTAINERS = eINSTANCE.getStrategyElement_ElementContainers();

		/**
		 * The meta object literal for the '<em><b>Element Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference STRATEGY_ELEMENT__ELEMENT_PROPERTIES = eINSTANCE.getStrategyElement_ElementProperties();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.propertylifecycle.impl.ElementTemplateImpl <em>Element Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.propertylifecycle.impl.ElementTemplateImpl
		 * @see org.eclipse.papyrus.propertylifecycle.impl.PropertylifecyclePackageImpl#getElementTemplate()
		 * @generated
		 */
		EClass ELEMENT_TEMPLATE = eINSTANCE.getElementTemplate();

		/**
		 * The meta object literal for the '<em><b>Base Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute ELEMENT_TEMPLATE__BASE_TYPE = eINSTANCE.getElementTemplate_BaseType();

		/**
		 * The meta object literal for the '<em><b>Specialized Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute ELEMENT_TEMPLATE__SPECIALIZED_TYPE = eINSTANCE.getElementTemplate_SpecializedType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.propertylifecycle.impl.ElementContainerImpl <em>Element Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.propertylifecycle.impl.ElementContainerImpl
		 * @see org.eclipse.papyrus.propertylifecycle.impl.PropertylifecyclePackageImpl#getElementContainer()
		 * @generated
		 */
		EClass ELEMENT_CONTAINER = eINSTANCE.getElementContainer();

		/**
		 * The meta object literal for the '<em><b>Containers Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference ELEMENT_CONTAINER__CONTAINERS_CONTAINER = eINSTANCE.getElementContainer_ContainersContainer();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.propertylifecycle.impl.ElementPropertyImpl <em>Element Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.propertylifecycle.impl.ElementPropertyImpl
		 * @see org.eclipse.papyrus.propertylifecycle.impl.PropertylifecyclePackageImpl#getElementProperty()
		 * @generated
		 */
		EClass ELEMENT_PROPERTY = eINSTANCE.getElementProperty();

		/**
		 * The meta object literal for the '<em><b>Feature Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute ELEMENT_PROPERTY__FEATURE_LABEL = eINSTANCE.getElementProperty_FeatureLabel();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute ELEMENT_PROPERTY__PRIORITY = eINSTANCE.getElementProperty_Priority();

		/**
		 * The meta object literal for the '<em><b>Triggers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference ELEMENT_PROPERTY__TRIGGERS = eINSTANCE.getElementProperty_Triggers();

		/**
		 * The meta object literal for the '<em><b>Value Processor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference ELEMENT_PROPERTY__VALUE_PROCESSOR = eINSTANCE.getElementProperty_ValueProcessor();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.propertylifecycle.impl.AbstractTriggerImpl <em>Abstract Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.propertylifecycle.impl.AbstractTriggerImpl
		 * @see org.eclipse.papyrus.propertylifecycle.impl.PropertylifecyclePackageImpl#getAbstractTrigger()
		 * @generated
		 */
		EClass ABSTRACT_TRIGGER = eINSTANCE.getAbstractTrigger();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.propertylifecycle.impl.AbstractValueProcessorImpl <em>Abstract Value Processor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.propertylifecycle.impl.AbstractValueProcessorImpl
		 * @see org.eclipse.papyrus.propertylifecycle.impl.PropertylifecyclePackageImpl#getAbstractValueProcessor()
		 * @generated
		 */
		EClass ABSTRACT_VALUE_PROCESSOR = eINSTANCE.getAbstractValueProcessor();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.propertylifecycle.impl.JavaProcessorImpl <em>Java Processor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.propertylifecycle.impl.JavaProcessorImpl
		 * @see org.eclipse.papyrus.propertylifecycle.impl.PropertylifecyclePackageImpl#getJavaProcessor()
		 * @generated
		 */
		EClass JAVA_PROCESSOR = eINSTANCE.getJavaProcessor();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute JAVA_PROCESSOR__CLASS_NAME = eINSTANCE.getJavaProcessor_ClassName();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.propertylifecycle.impl.BasicTriggerImpl <em>Basic Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @see org.eclipse.papyrus.propertylifecycle.impl.BasicTriggerImpl
		 * @see org.eclipse.papyrus.propertylifecycle.impl.PropertylifecyclePackageImpl#getBasicTrigger()
		 * @generated
		 */
		EClass BASIC_TRIGGER = eINSTANCE.getBasicTrigger();

		/**
		 * The meta object literal for the '<em><b>On Create</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute BASIC_TRIGGER__ON_CREATE = eINSTANCE.getBasicTrigger_OnCreate();

		/**
		 * The meta object literal for the '<em><b>On Delete</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute BASIC_TRIGGER__ON_DELETE = eINSTANCE.getBasicTrigger_OnDelete();

		/**
		 * The meta object literal for the '<em><b>On Open</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute BASIC_TRIGGER__ON_OPEN = eINSTANCE.getBasicTrigger_OnOpen();

		/**
		 * The meta object literal for the '<em><b>On Move</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EAttribute BASIC_TRIGGER__ON_MOVE = eINSTANCE.getBasicTrigger_OnMove();

	}

} // PropertylifecyclePackage
