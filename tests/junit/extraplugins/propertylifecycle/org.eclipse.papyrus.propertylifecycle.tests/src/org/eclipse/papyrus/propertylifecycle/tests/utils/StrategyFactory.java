/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.propertylifecycle.tests.utils;

import org.eclipse.papyrus.propertylifecycle.AbstractValueProcessor;
import org.eclipse.papyrus.propertylifecycle.BasicTrigger;
import org.eclipse.papyrus.propertylifecycle.ElementContainer;
import org.eclipse.papyrus.propertylifecycle.ElementProperty;
import org.eclipse.papyrus.propertylifecycle.JavaProcessor;
import org.eclipse.papyrus.propertylifecycle.PropertylifecycleFactory;
import org.eclipse.papyrus.propertylifecycle.StrategyElement;
import org.eclipse.papyrus.propertylifecycle.StrategySet;
import org.junit.Assert;
import org.junit.Test;

/**
 * Class used to facilitate the creation of the test strategies
 * 
 */
public class StrategyFactory {

	public static PropertylifecycleFactory strategyModelFactory = PropertylifecycleFactory.eINSTANCE;

	public StrategyFactory() {

	}

	/**
	 * Handle the creation of the strategySet containing the test strategies
	 *
	 * @param description
	 *            user informations about the set
	 * @param id
	 *            the unique id of the set
	 * @param name
	 *            the name of the set
	 * @return
	 * 		The {@link org.eclipse.papyrus.propertylifecycle.StrategySet StrategySet}
	 */
	public static StrategySet createStrategySet(String description, String id, String name) {
		StrategySet strategySet = strategyModelFactory.createStrategySet();
		Assert.assertNotNull("The strategySet should not be null", strategySet);

		strategySet.setDecription(description);
		strategySet.setId(id);
		Assert.assertNotNull("The strategySet ID should not be null", strategySet.getId());
		strategySet.setName(name);

		return strategySet;
	}

	/**
	 * Handle the creation of the core of the new strategy, allowing the manager to match it against the model's elements.
	 * For the strategy to be complete there still needs to specify the properties affected and their triggers and processors
	 *
	 * @param baseType
	 *            The base elementtype of the element this strategy will affect
	 * @param description
	 *            The user information explaining the strategy
	 * @param id
	 *            The unique id of the strategy
	 * @param name
	 *            The name of the strategy
	 * @param specializedType
	 *            The specialized elementtype, if any, of the element
	 * @return
	 * 		The created new strategy's {@link org.eclipse.papyrus.propertylifecycle.StrategyElement core}
	 */
	public StrategyElement createStrategy(String baseType, String description, String id, String name, String specializedType) {
		StrategyElement strategyElement = strategyModelFactory.createStrategyElement();
		Assert.assertNotNull("The strategyElement should not be null", strategyElement);

		strategyElement.setBaseType(baseType);
		Assert.assertNotNull("The strategyElement baseType should not be null", strategyElement.getBaseType());
		strategyElement.setDecription(description);
		strategyElement.setId(id);
		Assert.assertNotNull("The strategyElement id should not be null", strategyElement.getId());
		strategyElement.setName(name);
		strategyElement.setSpecializedType(specializedType);

		return strategyElement;
	}

	/**
	 * Handle the creation of the containers used to specify a more specific context to the application of the strategy
	 *
	 * @param baseType
	 *            The base elementtype of the container
	 * @param specializedType
	 *            The specialized elementtype, if any, of the container
	 * @param container
	 *            The container's container, if any
	 * @return
	 * 		The identified container {@link org.eclipse.papyrus.propertylifecycle.ElementContainer context} of the element affected by the strategy
	 */
	public ElementContainer createContainer(String baseType, String specializedType, ElementContainer container) {
		ElementContainer elementContainer = strategyModelFactory.createElementContainer();
		Assert.assertNotNull("The elementContainer should not be null", elementContainer);

		elementContainer.setBaseType(baseType);
		Assert.assertNotNull("The elementContainer baseType should not be null", elementContainer.getBaseType());
		elementContainer.setSpecializedType(specializedType);
		elementContainer.setContainersContainer(container);

		return elementContainer;
	}

	/**
	 * Handle the specification of the property to be affected by the strategy
	 *
	 * @param featureLabel
	 *            The label of the property
	 * @param priority
	 *            The priority in case of multiple strategies affecting the same property
	 * @param valueProcessor
	 *            The processor returning the new value of the property
	 * @return
	 * 		The property {@link org.eclipse.papyrus.propertylifecycle.ElementProperty specification}
	 */
	public ElementProperty createProperty(String featureLabel, Integer priority, AbstractValueProcessor valueProcessor) {
		ElementProperty elementProperty = strategyModelFactory.createElementProperty();
		Assert.assertNotNull("The elementProperty should not be null", elementProperty);

		elementProperty.setFeatureLabel(featureLabel);
		Assert.assertNotNull("The elementProperty featureLabel should not be null", elementProperty.getFeatureLabel());
		elementProperty.setPriority(priority);
		Assert.assertNotNull("The elementProperty should not be null", elementProperty.getPriority());

		elementProperty.setValueProcessor(valueProcessor);
		Assert.assertNotNull("The valueProcessor should not be null", elementProperty.getValueProcessor());
		Assert.assertNotNull("The processorPath should not be null nor empty", ((JavaProcessor) elementProperty.getValueProcessor()).getClassName() != null
				&& ((JavaProcessor) elementProperty.getValueProcessor()).getClassName() != "");
		elementProperty.getTriggers().add(createBasicTrigger());
		Assert.assertNotNull("The trigger list should not be empty", elementProperty.getTriggers().size() > 0);

		return elementProperty;
	}

	/**
	 * Handle the specification of the processor used for this property
	 *
	 * @param processorPath
	 *            The path of the processor used to call on it
	 * @return
	 * 		The {@link org.eclipse.papyrus.propertylifecycle.JavaProcessor processor}
	 */
	public JavaProcessor createJavaProcessor(String processorPath) {
		JavaProcessor javaProcessor = strategyModelFactory.createJavaProcessor();
		Assert.assertNotNull("The javaProcessor should not be null", javaProcessor);
		javaProcessor.setClassName(processorPath);

		return javaProcessor;
	}

	/**
	 * Handle the creation of the trigger used to apply the strategy based on the lifecycle
	 * 
	 * @return
	 * 		The {@link org.eclipse.papyrus.propertylifecycle.BasicTrigger trigger}
	 */
	public BasicTrigger createBasicTrigger() {
		BasicTrigger basicTrigger = strategyModelFactory.createBasicTrigger();
		Assert.assertNotNull("The basicTrigger should not be null", basicTrigger);
		basicTrigger.setOnCreate(true);
		basicTrigger.setOnMove(true);
		basicTrigger.setOnDelete(true);
		basicTrigger.setOnOpen(true);

		return basicTrigger;
	}

}
