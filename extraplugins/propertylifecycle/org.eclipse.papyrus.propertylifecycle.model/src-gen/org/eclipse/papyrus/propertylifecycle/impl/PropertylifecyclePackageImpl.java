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
package org.eclipse.papyrus.propertylifecycle.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.propertylifecycle.AbstractTrigger;
import org.eclipse.papyrus.propertylifecycle.AbstractValueProcessor;
import org.eclipse.papyrus.propertylifecycle.BasicTrigger;
import org.eclipse.papyrus.propertylifecycle.ElementContainer;
import org.eclipse.papyrus.propertylifecycle.ElementProperty;
import org.eclipse.papyrus.propertylifecycle.ElementTemplate;
import org.eclipse.papyrus.propertylifecycle.JavaProcessor;
import org.eclipse.papyrus.propertylifecycle.PropertylifecycleFactory;
import org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage;
import org.eclipse.papyrus.propertylifecycle.StrategyElement;
import org.eclipse.papyrus.propertylifecycle.StrategySet;
import org.eclipse.papyrus.propertylifecycle.StrategyTemplate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PropertylifecyclePackageImpl extends EPackageImpl implements PropertylifecyclePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass strategyTemplateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass strategySetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass strategyElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass elementTemplateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass elementContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass elementPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass abstractTriggerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass abstractValueProcessorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass javaProcessorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass basicTriggerEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.propertylifecycle.PropertylifecyclePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PropertylifecyclePackageImpl() {
		super(eNS_URI, PropertylifecycleFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>
	 * This method is used to initialize {@link PropertylifecyclePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PropertylifecyclePackage init() {
		if (isInited) {
			return (PropertylifecyclePackage) EPackage.Registry.INSTANCE.getEPackage(PropertylifecyclePackage.eNS_URI);
		}

		// Obtain or create and register package
		PropertylifecyclePackageImpl thePropertylifecyclePackage = (PropertylifecyclePackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PropertylifecyclePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PropertylifecyclePackageImpl());

		isInited = true;

		// Create package meta-data objects
		thePropertylifecyclePackage.createPackageContents();

		// Initialize created meta-data
		thePropertylifecyclePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePropertylifecyclePackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PropertylifecyclePackage.eNS_URI, thePropertylifecyclePackage);
		return thePropertylifecyclePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getStrategyTemplate() {
		return strategyTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getStrategyTemplate_Name() {
		return (EAttribute) strategyTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getStrategyTemplate_Decription() {
		return (EAttribute) strategyTemplateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getStrategyTemplate_Id() {
		return (EAttribute) strategyTemplateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getStrategySet() {
		return strategySetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getStrategySet_Strategies() {
		return (EReference) strategySetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getStrategyElement() {
		return strategyElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getStrategyElement_ElementContainers() {
		return (EReference) strategyElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getStrategyElement_ElementProperties() {
		return (EReference) strategyElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getElementTemplate() {
		return elementTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getElementTemplate_BaseType() {
		return (EAttribute) elementTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getElementTemplate_SpecializedType() {
		return (EAttribute) elementTemplateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getElementContainer() {
		return elementContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getElementContainer_ContainersContainer() {
		return (EReference) elementContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getElementProperty() {
		return elementPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getElementProperty_FeatureLabel() {
		return (EAttribute) elementPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getElementProperty_Priority() {
		return (EAttribute) elementPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getElementProperty_Triggers() {
		return (EReference) elementPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getElementProperty_ValueProcessor() {
		return (EReference) elementPropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getAbstractTrigger() {
		return abstractTriggerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getAbstractValueProcessor() {
		return abstractValueProcessorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getJavaProcessor() {
		return javaProcessorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getJavaProcessor_ClassName() {
		return (EAttribute) javaProcessorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getBasicTrigger() {
		return basicTriggerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getBasicTrigger_OnCreate() {
		return (EAttribute) basicTriggerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getBasicTrigger_OnDelete() {
		return (EAttribute) basicTriggerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getBasicTrigger_OnOpen() {
		return (EAttribute) basicTriggerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EAttribute getBasicTrigger_OnMove() {
		return (EAttribute) basicTriggerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public PropertylifecycleFactory getPropertylifecycleFactory() {
		return (PropertylifecycleFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) {
			return;
		}
		isCreated = true;

		// Create classes and their features
		strategyTemplateEClass = createEClass(STRATEGY_TEMPLATE);
		createEAttribute(strategyTemplateEClass, STRATEGY_TEMPLATE__NAME);
		createEAttribute(strategyTemplateEClass, STRATEGY_TEMPLATE__DECRIPTION);
		createEAttribute(strategyTemplateEClass, STRATEGY_TEMPLATE__ID);

		strategySetEClass = createEClass(STRATEGY_SET);
		createEReference(strategySetEClass, STRATEGY_SET__STRATEGIES);

		strategyElementEClass = createEClass(STRATEGY_ELEMENT);
		createEReference(strategyElementEClass, STRATEGY_ELEMENT__ELEMENT_CONTAINERS);
		createEReference(strategyElementEClass, STRATEGY_ELEMENT__ELEMENT_PROPERTIES);

		elementTemplateEClass = createEClass(ELEMENT_TEMPLATE);
		createEAttribute(elementTemplateEClass, ELEMENT_TEMPLATE__BASE_TYPE);
		createEAttribute(elementTemplateEClass, ELEMENT_TEMPLATE__SPECIALIZED_TYPE);

		elementContainerEClass = createEClass(ELEMENT_CONTAINER);
		createEReference(elementContainerEClass, ELEMENT_CONTAINER__CONTAINERS_CONTAINER);

		elementPropertyEClass = createEClass(ELEMENT_PROPERTY);
		createEAttribute(elementPropertyEClass, ELEMENT_PROPERTY__FEATURE_LABEL);
		createEAttribute(elementPropertyEClass, ELEMENT_PROPERTY__PRIORITY);
		createEReference(elementPropertyEClass, ELEMENT_PROPERTY__TRIGGERS);
		createEReference(elementPropertyEClass, ELEMENT_PROPERTY__VALUE_PROCESSOR);

		abstractTriggerEClass = createEClass(ABSTRACT_TRIGGER);

		abstractValueProcessorEClass = createEClass(ABSTRACT_VALUE_PROCESSOR);

		javaProcessorEClass = createEClass(JAVA_PROCESSOR);
		createEAttribute(javaProcessorEClass, JAVA_PROCESSOR__CLASS_NAME);

		basicTriggerEClass = createEClass(BASIC_TRIGGER);
		createEAttribute(basicTriggerEClass, BASIC_TRIGGER__ON_CREATE);
		createEAttribute(basicTriggerEClass, BASIC_TRIGGER__ON_DELETE);
		createEAttribute(basicTriggerEClass, BASIC_TRIGGER__ON_OPEN);
		createEAttribute(basicTriggerEClass, BASIC_TRIGGER__ON_MOVE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) {
			return;
		}
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		strategySetEClass.getESuperTypes().add(this.getStrategyTemplate());
		strategyElementEClass.getESuperTypes().add(this.getElementTemplate());
		strategyElementEClass.getESuperTypes().add(this.getStrategyTemplate());
		elementContainerEClass.getESuperTypes().add(this.getElementTemplate());
		javaProcessorEClass.getESuperTypes().add(this.getAbstractValueProcessor());
		basicTriggerEClass.getESuperTypes().add(this.getAbstractTrigger());

		// Initialize classes, features, and operations; add parameters
		initEClass(strategyTemplateEClass, StrategyTemplate.class, "StrategyTemplate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getStrategyTemplate_Name(), ecorePackage.getEString(), "name", null, 0, 1, StrategyTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getStrategyTemplate_Decription(), ecorePackage.getEString(), "decription", null, 0, 1, StrategyTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getStrategyTemplate_Id(), ecorePackage.getEString(), "id", null, 1, 1, StrategyTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(strategySetEClass, StrategySet.class, "StrategySet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getStrategySet_Strategies(), this.getStrategyElement(), null, "strategies", null, 1, -1, StrategySet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, //$NON-NLS-1$
				IS_ORDERED);

		initEClass(strategyElementEClass, StrategyElement.class, "StrategyElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getStrategyElement_ElementContainers(), this.getElementContainer(), null, "elementContainers", null, 0, -1, StrategyElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, //$NON-NLS-1$
				!IS_DERIVED, IS_ORDERED);
		initEReference(getStrategyElement_ElementProperties(), this.getElementProperty(), null, "elementProperties", null, 1, -1, StrategyElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, //$NON-NLS-1$
				!IS_DERIVED, IS_ORDERED);

		initEClass(elementTemplateEClass, ElementTemplate.class, "ElementTemplate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getElementTemplate_BaseType(), ecorePackage.getEString(), "baseType", null, 1, 1, ElementTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getElementTemplate_SpecializedType(), ecorePackage.getEString(), "specializedType", null, 0, 1, ElementTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(elementContainerEClass, ElementContainer.class, "ElementContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getElementContainer_ContainersContainer(), this.getElementContainer(), null, "containersContainer", null, 0, 1, ElementContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, //$NON-NLS-1$
				IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(elementPropertyEClass, ElementProperty.class, "ElementProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getElementProperty_FeatureLabel(), ecorePackage.getEString(), "featureLabel", null, 1, 1, ElementProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getElementProperty_Priority(), ecorePackage.getEIntegerObject(), "priority", "0", 1, 1, ElementProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(getElementProperty_Triggers(), this.getAbstractTrigger(), null, "triggers", null, 1, -1, ElementProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, //$NON-NLS-1$
				!IS_ORDERED);
		initEReference(getElementProperty_ValueProcessor(), this.getAbstractValueProcessor(), null, "valueProcessor", null, 1, 1, ElementProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, //$NON-NLS-1$
				!IS_DERIVED, !IS_ORDERED);

		initEClass(abstractTriggerEClass, AbstractTrigger.class, "AbstractTrigger", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(abstractValueProcessorEClass, AbstractValueProcessor.class, "AbstractValueProcessor", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(javaProcessorEClass, JavaProcessor.class, "JavaProcessor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getJavaProcessor_ClassName(), ecorePackage.getEString(), "className", null, 1, 1, JavaProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(basicTriggerEClass, BasicTrigger.class, "BasicTrigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getBasicTrigger_OnCreate(), ecorePackage.getEBoolean(), "onCreate", null, 1, 1, BasicTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBasicTrigger_OnDelete(), ecorePackage.getEBoolean(), "onDelete", null, 1, 1, BasicTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBasicTrigger_OnOpen(), ecorePackage.getEBoolean(), "onOpen", null, 1, 1, BasicTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getBasicTrigger_OnMove(), ecorePackage.getEBoolean(), "onMove", null, 1, 1, BasicTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} // PropertylifecyclePackageImpl
