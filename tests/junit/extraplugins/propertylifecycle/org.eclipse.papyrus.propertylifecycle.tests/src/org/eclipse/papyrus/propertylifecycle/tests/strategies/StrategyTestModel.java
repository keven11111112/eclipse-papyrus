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

package org.eclipse.papyrus.propertylifecycle.tests.strategies;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.papyrus.propertylifecycle.ElementContainer;
import org.eclipse.papyrus.propertylifecycle.ElementProperty;
import org.eclipse.papyrus.propertylifecycle.JavaProcessor;
import org.eclipse.papyrus.propertylifecycle.StrategyElement;
import org.eclipse.papyrus.propertylifecycle.StrategySet;
import org.eclipse.papyrus.propertylifecycle.tests.Activator;
import org.eclipse.papyrus.propertylifecycle.tests.utils.ITestConstants;
import org.eclipse.papyrus.propertylifecycle.tests.utils.StrategyFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Initialize the test strategySet model
 * 
 */
public class StrategyTestModel implements ITestConstants {

	public static StrategySet strategySet;

	public static StrategyFactory strategyFactory = new StrategyFactory();

	public static StrategySet initStrategyModel() {
		strategySet = StrategyFactory.createStrategySet(STRATEGYSET_DESCRIPTION, STRATEGYSET_ID, STRATEGYSET_NAME);
		addStrategies(strategySet);

		return strategySet;
	}

	public static ResourceSet initStrategyModel(IProject parentProject) throws CoreException, IOException {
		strategySet = StrategyFactory.createStrategySet(STRATEGYSET_DESCRIPTION, STRATEGYSET_ID, STRATEGYSET_NAME);
		addStrategies(strategySet);

		return saveStrategyModel(strategySet, parentProject);
	}

	private static ResourceSet saveStrategyModel(StrategySet strategyModel, IProject parentProject) throws CoreException, IOException {
		ResourceSet strategyResourceSet = new ResourceSetImpl();
		String modelFileName = RESOURCES_STRATEGYMODELNAME;
		IFolder modelFolder = createRecursiveFolder(parentProject.getFolder(RESOURCES_FOLDERNAME));
		URI modelURI = CommonPlugin.resolve(URI.createFileURI(modelFolder.getFullPath().toString() + "/" + modelFileName));
		Resource modelResource = strategyResourceSet.createResource(modelURI);
		modelResource.getContents().add(strategyModel);

		try {
			Map<Object, Object> options = new HashMap<>();
			options.put(XMIResource.OPTION_ENCODING, RESOURCES_ENCODING);
			modelResource.save(options);
			// String filePath = "~/Desktop/";
			// String localPath = filePath.replaceFirst("^~", System.getProperty("user.home").replace("\\", "/"));
			// modelResource.setURI(CommonPlugin.resolve(URI.createFileURI(localPath + RESOURCES_UMLMODELNAME)));
			// modelResource.save(null);
			return strategyResourceSet;
		} catch (IOException ioe) {
			Activator.log.error(ioe);
		}

		return null;
	}

	public static IFolder createRecursiveFolder(IFolder folderToCreate) throws CoreException {
		if (folderToCreate.exists()) {
			return folderToCreate;
		}

		folderToCreate.create(true, true, new NullProgressMonitor());
		return folderToCreate;
	}

	protected static void addStrategies(StrategySet strategySet) {
		Collection<StrategyElement> strategies = new ArrayList<>();
		strategies.add(componentStrategy());
		strategies.add(classStrategy());
		strategies.add(propertyComponentStrategy());
		strategies.add(propertyClassStrategy());
		strategies.add(sysmlBlockStrategy());
		strategies.add(sysml14BlockStrategy());
		strategies.add(associationStrategy());

		strategySet.getStrategies().addAll(strategies);
		Assert.assertEquals("There should be 7 strategies created in the model", 7, strategySet.getStrategies().size());
	}

	/** The component strategy renames a Component when created */
	protected static StrategyElement componentStrategy() {
		StrategyElement componentStrategy = strategyFactory.createStrategy(STRATEGYELEMENT_BASETYPE_COMPONENT, STRATEGYELEMENT_DESCRIPTION_COMPONENT,
				STRATEGYELEMENT_ID_COMPONENT, STRATEGYELEMENT_NAME_COMPONENT, STRATEGYELEMENT_SPECIALIZEDTYPE_COMPONENT);
		JavaProcessor valueProcessor = strategyFactory.createJavaProcessor(ELEMENTPROPERTY_PROCESSORPATH_COMPONENT);
		ElementProperty componentProperty = strategyFactory.createProperty(STRATEGYPROPERTY_FEATURELABEL_COMPONENT, ELEMENTPROPERTY_PRIORITY_COMPONENT,
				valueProcessor);

		componentStrategy.getElementProperties().add(componentProperty);
		Assert.assertTrue("The properties should not be empty", componentStrategy.getElementProperties().size() > 0);

		return componentStrategy;
	}

	/** The class strategy renames a Class created inside a Model */
	protected static StrategyElement classStrategy() {
		StrategyElement classStrategy = strategyFactory.createStrategy(STRATEGYELEMENT_BASETYPE_CLASS, STRATEGYELEMENT_DESCRIPTION_CLASS,
				STRATEGYELEMENT_ID_CLASS, STRATEGYELEMENT_NAME_CLASS, STRATEGYELEMENT_SPECIALIZEDTYPE_CLASS);
		ElementContainer classContainer = strategyFactory.createContainer(STRATEGYCONTAINER_BASETYPE_CLASS, STRATEGYCONTAINER_SPECIALIZEDTYPE_CLASS,
				null);
		JavaProcessor valueProcessor = strategyFactory.createJavaProcessor(ELEMENTPROPERTY_PROCESSORPATH_CLASS);
		ElementProperty classProperty = strategyFactory.createProperty(STRATEGYPROPERTY_FEATURELABEL_CLASS, ELEMENTPROPERTY_PRIORITY_CLASS,
				valueProcessor);

		classStrategy.getElementContainers().add(classContainer);
		Assert.assertTrue("The containers should not be empty", classStrategy.getElementContainers().size() > 0);
		classStrategy.getElementProperties().add(classProperty);
		Assert.assertTrue("The properties should not be empty", classStrategy.getElementProperties().size() > 0);

		return classStrategy;
	}

	/** the property strategy renames a Property created inside a Class and when the Class changes its name afterwards */
	protected static StrategyElement propertyComponentStrategy() {
		StrategyElement propertyStrategy = strategyFactory.createStrategy(STRATEGYELEMENT_BASETYPE_PROPERTY, STRATEGYELEMENT_DESCRIPTION_PROPERTY,
				STRATEGYELEMENT_ID_COMPONENTPROPERTY, STRATEGYELEMENT_NAME_COMPONENTPROPERTY, STRATEGYELEMENT_SPECIALIZEDTYPE_PROPERTY);
		ElementContainer propertyContainer = strategyFactory.createContainer(STRATEGYCONTAINER_BASETYPE_COMPONENTPROPERTY, STRATEGYCONTAINER_SPECIALIZEDTYPE_PROPERTY,
				null);
		JavaProcessor valueProcessor = strategyFactory.createJavaProcessor(ELEMENTPROPERTY_PROCESSORPATH_PROPERTY);
		ElementProperty propertyProperty = strategyFactory.createProperty(STRATEGYPROPERTY_FEATURELABEL_PROPERTY, ELEMENTPROPERTY_PRIORITY_PROPERTY,
				valueProcessor);

		propertyStrategy.getElementContainers().add(propertyContainer);
		Assert.assertTrue("The containers should not be empty", propertyStrategy.getElementContainers().size() > 0);
		propertyStrategy.getElementProperties().add(propertyProperty);
		Assert.assertTrue("The properties should not be empty", propertyStrategy.getElementProperties().size() > 0);

		return propertyStrategy;
	}


	/** the property strategy renames a Property created inside a Class and when the Class changes its name afterwards */
	protected static StrategyElement propertyClassStrategy() {
		StrategyElement propertyStrategy = strategyFactory.createStrategy(STRATEGYELEMENT_BASETYPE_PROPERTY, STRATEGYELEMENT_DESCRIPTION_PROPERTY,
				STRATEGYELEMENT_ID_CLASSPROPERTY, STRATEGYELEMENT_NAME_CLASSPROPERTY, STRATEGYELEMENT_SPECIALIZEDTYPE_PROPERTY);
		ElementContainer propertyContainer = strategyFactory.createContainer(STRATEGYCONTAINER_BASETYPE_CLASSPROPERTY, STRATEGYCONTAINER_SPECIALIZEDTYPE_PROPERTY,
				null);
		JavaProcessor valueProcessor = strategyFactory.createJavaProcessor(ELEMENTPROPERTY_PROCESSORPATH_PROPERTY);
		ElementProperty propertyProperty = strategyFactory.createProperty(STRATEGYPROPERTY_FEATURELABEL_PROPERTY, ELEMENTPROPERTY_PRIORITY_CLASSPROPERTY,
				valueProcessor);

		propertyStrategy.getElementContainers().add(propertyContainer);
		Assert.assertTrue("The containers should not be empty", propertyStrategy.getElementContainers().size() > 0);
		propertyStrategy.getElementProperties().add(propertyProperty);
		Assert.assertTrue("The properties should not be empty", propertyStrategy.getElementProperties().size() > 0);

		return propertyStrategy;
	}


	/** the sysmlblock strategy renames a sysml Block when created */
	protected static StrategyElement sysmlBlockStrategy() {
		StrategyElement sysmlBlockStrategy = strategyFactory.createStrategy(STRATEGYELEMENT_BASETYPE_SYSMLBLOCK, STRATEGYELEMENT_DESCRIPTION_SYSMLBLOCK,
				STRATEGYELEMENT_ID_SYSMLBLOCK, STRATEGYELEMENT_NAME_SYSMLBLOCK, STRATEGYELEMENT_SPECIALIZEDTYPE_SYSMLBLOCK);
		JavaProcessor valueProcessor = strategyFactory.createJavaProcessor(ELEMENTPROPERTY_PROCESSORPATH_SYSMLBLOCK);
		ElementProperty sysmlBlockProperty = strategyFactory.createProperty(STRATEGYPROPERTY_FEATURELABEL_SYSMLBLOCK, ELEMENTPROPERTY_PRIORITY_SYSMLBLOCK,
				valueProcessor);

		Assert.assertTrue("The containers should be empty", sysmlBlockStrategy.getElementContainers().size() == 0);
		sysmlBlockStrategy.getElementProperties().add(sysmlBlockProperty);
		Assert.assertTrue("The properties should not be empty", sysmlBlockStrategy.getElementProperties().size() > 0);

		return sysmlBlockStrategy;
	}

	/** the sysml14block strategy renames a sysml14 Block when created */
	protected static StrategyElement sysml14BlockStrategy() {
		StrategyElement sysml14BlockStrategy = strategyFactory.createStrategy(STRATEGYELEMENT_BASETYPE_SYSML14BLOCK, STRATEGYELEMENT_DESCRIPTION_SYSML14BLOCK,
				STRATEGYELEMENT_ID_SYSML14BLOCK, STRATEGYELEMENT_NAME_SYSML14BLOCK, STRATEGYELEMENT_SPECIALIZEDTYPE_SYSML14BLOCK);
		JavaProcessor valueProcessor = strategyFactory.createJavaProcessor(ELEMENTPROPERTY_PROCESSORPATH_SYSML14BLOCK);
		ElementProperty sysml14BlockProperty = strategyFactory.createProperty(STRATEGYPROPERTY_FEATURELABEL_SYSML14BLOCK, ELEMENTPROPERTY_PRIORITY_SYSML14BLOCK,
				valueProcessor);

		Assert.assertTrue("The containers should be empty", sysml14BlockStrategy.getElementContainers().size() == 0);
		sysml14BlockStrategy.getElementProperties().add(sysml14BlockProperty);
		Assert.assertTrue("The properties should not be empty", sysml14BlockStrategy.getElementProperties().size() > 0);

		return sysml14BlockStrategy;
	}

	/** the association strategy renames an Association when created and when reoriented afterwards */
	protected static StrategyElement associationStrategy() {
		StrategyElement associationStrategy = strategyFactory.createStrategy(STRATEGYELEMENT_BASETYPE_ASSOCIATION, STRATEGYELEMENT_DESCRIPTION_ASSOCIATION,
				STRATEGYELEMENT_ID_ASSOCIATION, STRATEGYELEMENT_NAME_ASSOCIATION, STRATEGYELEMENT_SPECIALIZEDTYPE_ASSOCIATION);
		JavaProcessor valueProcessor = strategyFactory.createJavaProcessor(ELEMENTPROPERTY_PROCESSORPATH_ASSOCIATION);
		ElementProperty associationProperty = strategyFactory.createProperty(STRATEGYPROPERTY_FEATURELABEL_ASSOCIATION, ELEMENTPROPERTY_PRIORITY_ASSOCIATION,
				valueProcessor);

		Assert.assertTrue("The containers should be empty", associationStrategy.getElementContainers().size() == 0);
		associationStrategy.getElementProperties().add(associationProperty);
		Assert.assertTrue("The properties should not be empty", associationStrategy.getElementProperties().size() > 0);

		return associationStrategy;
	}

}
