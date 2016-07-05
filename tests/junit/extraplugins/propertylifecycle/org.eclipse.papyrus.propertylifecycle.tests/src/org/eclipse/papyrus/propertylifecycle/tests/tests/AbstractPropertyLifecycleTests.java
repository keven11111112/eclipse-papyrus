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

package org.eclipse.papyrus.propertylifecycle.tests.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.OverrideableCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.papyrus.infra.core.resource.ModelException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelUtils;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.junit.utils.EditorUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.rules.HouseKeeper;
import org.eclipse.papyrus.propertylifecycle.StrategySet;
import org.eclipse.papyrus.propertylifecycle.preferences.utils.PropertyLifecyclePreferencesManager;
import org.eclipse.papyrus.propertylifecycle.tests.model.UMLTestModel;
import org.eclipse.papyrus.propertylifecycle.tests.strategies.StrategyTestModel;
import org.eclipse.papyrus.propertylifecycle.tests.utils.ITestConstants;
import org.eclipse.papyrus.uml.diagram.wizards.Activator;
import org.eclipse.papyrus.uml.tools.commands.ApplyProfileCommand;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Model;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.osgi.framework.Bundle;



public abstract class AbstractPropertyLifecycleTests extends AbstractPapyrusTest implements ITestConstants {

	@ClassRule
	public static HouseKeeper.Static houseKeeper = new HouseKeeper.Static();

	public static IProgressMonitor monitor = new NullProgressMonitor();

	public static ResourceSet umlResourceSet;

	public static ResourceSet strategyResourceSet;

	public static StrategySet strategyModel;

	public static Model umlModel;

	public static IProject lifecycleProject;

	public static IFile lifecycleModelFile;

	public static IMultiDiagramEditor openPapyrusEditor;

	public static TransactionalEditingDomain transactionalEditingDomain;

	// public static IClientContext papyrusContext;

	public static Package componentPackage;

	public static Component component_ComponentPacakge;

	public static Package classPackage;

	public static org.eclipse.uml2.uml.Class class_ClassPackage;

	public static Model subModel;

	public static Component component_subModel;

	public static org.eclipse.uml2.uml.Class class_subModel;

	public static Property property_class_subModel;

	public static ModelSet modelset;

	public static UmlModel umlIModel;

	public static Model rootModel;

	public static Resource umlModelResource;


	@BeforeClass
	public static void initProject() {

		// Create the project and its models
		lifecycleProject = houseKeeper.createProject(RESOURCES_PROJECTNAME);
		try {
			umlResourceSet = UMLTestModel.initUMLModel(lifecycleProject);
			strategyResourceSet = StrategyTestModel.initStrategyModel(lifecycleProject);
			Assert.assertNotNull("the modelResourceSet should not be null", umlResourceSet);
			Assert.assertNotNull("The strategyResourceSet should not be null", strategyResourceSet);

			umlModelResource = umlResourceSet.getResources().get(0);

			umlModel = (Model) umlModelResource.getContents().get(0);
			Diagnostic umlDiagnostic = Diagnostician.INSTANCE.validate(umlModel);
			Assert.assertTrue("The umlModel should be validated", umlDiagnostic.getSeverity() == Diagnostic.OK);
			strategyModel = (StrategySet) strategyResourceSet.getResources().get(0).getContents().get(0);
			Diagnostic strategyDiagnostic = Diagnostician.INSTANCE.validate(strategyModel);
			Assert.assertTrue("The strategyModel should be validated", strategyDiagnostic.getSeverity() == Diagnostic.OK);

			// Register the test strategies to call upon them during the tests
			PropertyLifecyclePreferencesManager preferenceManager = new PropertyLifecyclePreferencesManager();
			preferenceManager.registerCurrentPreferences(
					Collections.singleton(strategyResourceSet.getResources().get(0).getURI().toString()), null,
					strategyModel.getStrategies(), null);

			// Check created models and project
			checkExistingElements(umlModel);
			Assert.assertTrue(lifecycleProject.getFolder(RESOURCES_FOLDERNAME).exists());
			Assert.assertTrue(lifecycleProject.getFolder(RESOURCES_FOLDERNAME).getFile(RESOURCES_UMLMODELNAME).exists());
			Assert.assertTrue(lifecycleProject.getFolder(RESOURCES_FOLDERNAME).getFile(RESOURCES_STRATEGYMODELNAME).exists());

			// Create a new papyrus model
			ServicesRegistry registry = createServicesRegistry();
			Assert.assertNotNull("The service registry should not be null", registry);
			ModelSet modelSet = registry.getService(ModelSet.class);
			lifecycleModelFile = lifecycleProject.getFolder(RESOURCES_FOLDERNAME).getFile(RESOURCES_UMLMODELNAME);
			// modelSet.createsModels(lifecycleModelFile);
			modelSet.createModels(URI.createPlatformResourceURI(lifecycleModelFile.getFullPath().toString(), true));
			modelSet.save(monitor);
			lifecycleModelFile = lifecycleProject.getFolder(RESOURCES_FOLDERNAME).getFile(RESOURCES_DIMODELNAME);


		} catch (CoreException ce) {
			fail(ce.getMessage());
		} catch (IOException ioe) {
			fail(ioe.getMessage());
		} catch (ServiceException se) {
			fail(se.getMessage());
		}

		// Open the project
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				try {
					openPapyrusEditor = houseKeeper.cleanUpLater(EditorUtils.openPapyrusEditor(lifecycleModelFile));
				} catch (PartInitException pie) {
					fail(pie.getMessage());
				}
			}
		});

		// Get the transactional editing domain used to create the edit requests
		transactionalEditingDomain = openPapyrusEditor.getAdapter(TransactionalEditingDomain.class);
		assertTrue("Impossible to init editing domain", transactionalEditingDomain instanceof TransactionalEditingDomain);

		// Retrieve UML model from this editor
		try {
			modelset = ModelUtils.getModelSetChecked(openPapyrusEditor.getServicesRegistry());
			umlIModel = UmlUtils.getUmlModel(modelset);
			rootModel = (Model) umlIModel.lookupRoot();
			subModel = (Model) rootModel.getNestedPackage(SUBMODEL_NAME);

			Assert.assertNotNull("root model should not be null", rootModel);

		} catch (ServiceException e) {
			fail(e.getMessage());
		} catch (NotFoundException e) {
			fail(e.getMessage());
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}

		// Check the contents of the new project
		try {
			checkExistingElements(rootModel);
		} catch (Exception e) {
			fail(e.getMessage());
		}

		// try {
		// papyrusContext = org.eclipse.papyrus.infra.services.edit.internal.context.TypeContext.getContext();
		// } catch (ServiceException se) {
		// fail(se.getMessage());
		// }

	}

	protected static void checkExistingElements(Model lifecycleRootModel) {
		componentPackage = lifecycleRootModel.getNestedPackage(COMPONENT_PACKAGE_NAME);
		Assert.assertNotNull(COMPONENT_PACKAGE_NAME + ", should not be null", componentPackage);
		Assert.assertTrue(COMPONENT_PACKAGE_NAME + ", should be a package", componentPackage instanceof Package);

		classPackage = lifecycleRootModel.getNestedPackage(CLASS_PACKAGE_NAME);
		Assert.assertNotNull(CLASS_PACKAGE_NAME + ", should not be null", classPackage);
		Assert.assertTrue(CLASS_PACKAGE_NAME + ", should be a package", classPackage instanceof Package);

		Package subModelPackage = lifecycleRootModel.getNestedPackage(SUBMODEL_NAME);
		Assert.assertTrue("The subModel package should be a Model", subModelPackage instanceof Model);
		subModel = (Model) subModelPackage;

		component_ComponentPacakge = (Component) componentPackage.getPackagedElement(COMPONENT_NAME);
		Assert.assertNotNull(COMPONENT_NAME + ", should not be null", component_ComponentPacakge);

		class_ClassPackage = (org.eclipse.uml2.uml.Class) classPackage.getPackagedElement(CLASS_NAME);
		Assert.assertNotNull(CLASS_NAME + ", should not be null", class_ClassPackage);

		component_subModel = (Component) subModel.getPackagedElement(COMPONENT_NAME);
		Assert.assertNotNull(COMPONENT_NAME + ", should not be null", component_ComponentPacakge);
		class_subModel = (org.eclipse.uml2.uml.Class) subModel.getPackagedElement(CLASS_NAME);
		Assert.assertNotNull(CLASS_NAME + ", should not be null", class_ClassPackage);

		property_class_subModel = class_subModel.getAttribute(PROPERTY_CLASS_NAME, UMLFactory.eINSTANCE.createProperty().getType());
		Assert.assertNotNull("the property of the subModel's class should exist", property_class_subModel);
	}


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	protected static ServicesRegistry createServicesRegistry() {
		ServicesRegistry result = null;

		try {
			result = new ExtensionServicesRegistry(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID);
		} catch (ServiceException e) {
			// couldn't create the registry? Fatal problem
			Activator.log.error(e);
		}

		try {
			// have to create the model set and populate it with the DI model
			// before initializing other services that actually need the DI
			// model, such as the SashModel Manager service
			result.startServicesByClassKeys(ModelSet.class);
		} catch (ServiceException ex) {
			// Ignore this exception: some services may not have been loaded,
			// which is probably normal at this point
		}

		return result;
	}

}
