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

package org.eclipse.papyrus.propertylifecycle.tests.model;

import java.io.IOException;
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.papyrus.propertylifecycle.tests.Activator;
import org.eclipse.papyrus.propertylifecycle.tests.utils.ITestConstants;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.papyrus.uml.tools.utils.CustomUMLUtil.StereotypeApplicationHelper;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * Initialize the test model with elements before the application of the strategySet
 * 
 */
public class UMLTestModel implements ITestConstants {

	public static Model rootModel;

	public static Model initUMLModel() {
		createUMLModel();

		return rootModel;
	}

	public static ResourceSet initUMLModel(IProject parentProject) throws CoreException, IOException {
		createUMLModel();

		return saveUMLModel(rootModel, parentProject);
	}


	public static void createUMLModel() {
		rootModel = UMLFactory.eINSTANCE.createModel();
		rootModel.setName(ROOTMODEL_NAME);

		createClassSubPackage(rootModel);
		createComponentPackage(rootModel);
		createSubModel(rootModel);

	}

	private static ResourceSet saveUMLModel(Model rootModel, IProject parentProject) throws CoreException, IOException {
		ResourceSet umlResourceSet = new ResourceSetImpl();
		IFolder modelFolder = createRecursiveFolder(parentProject.getFolder(RESOURCES_FOLDERNAME));
		URI modelURI = URI.createPlatformResourceURI(modelFolder.getFullPath().toString() + "/" + RESOURCES_UMLMODELNAME, true);
		Resource modelResource = umlResourceSet.createResource(modelURI);
		modelResource.getContents().add(rootModel);

		try {
			Map<Object, Object> options = new HashMap<>();
			options.put(XMIResource.OPTION_ENCODING, RESOURCES_ENCODING);
			modelResource.save(options);

			// String filePath = "~/Desktop/";
			// String localPath = filePath.replaceFirst("^~", System.getProperty("user.home").replace("\\", "/"));
			// Resource desktopModelResource = modelResource;
			// desktopModelResource.setURI(CommonPlugin.resolve(URI.createFileURI(localPath + "desktop.uml")));
			// desktopModelResource.save(options);

			return umlResourceSet;
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



	private static Package createClassSubPackage(Model rootModel) {
		Package classPackage = rootModel.createNestedPackage(CLASS_PACKAGE_NAME);
		PackageableElement newClass = classPackage.createPackagedElement(CLASS_NAME, UMLFactory.eINSTANCE.createClass().eClass());
		Class beforeStrategyClass = (Class) newClass;
		beforeStrategyClass.createOwnedAttribute(PROPERTY_CLASS_NAME, UMLFactory.eINSTANCE.createProperty().getType());

		return classPackage;
	}


	private static Package createComponentPackage(Model rootModel) {
		Package componentPackage = rootModel.createNestedPackage(COMPONENT_PACKAGE_NAME);
		PackageableElement newComponent = componentPackage.createPackagedElement(COMPONENT_NAME, UMLFactory.eINSTANCE.createComponent().eClass());
		Component beforeStrategyComponent = (Component) newComponent;
		beforeStrategyComponent.createOwnedAttribute(PROPERTY_COMPONENT_NAME, UMLFactory.eINSTANCE.createProperty().getType());

		return componentPackage;
	}

	private static Package createSubModel(Model rootModel) {
		Model subModel = UMLFactory.eINSTANCE.createModel();
		Package subPackage = rootModel.createNestedPackage(SUBMODEL_NAME, subModel.eClass());

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource sysmlProfileResource = resourceSet.getResource(URI.createURI(SysmlResource.SYSML_PROFILE_URI), true);
		Profile sysmlProfile = (Profile) EcoreUtil.getObjectByType(sysmlProfileResource.getContents(), UMLPackage.Literals.PACKAGE);
		PackageUtil.applyProfile(subPackage, sysmlProfile, true);

		// TransactionalEditingDomain domain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
		// AbstractTransactionalCommand newCommand = new AbstractTransactionalCommand(domain, "ApplyProfile", Collections.EMPTY_LIST) {
		//
		// @Override
		// protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// if (PackageUtil.applyProfile((org.eclipse.uml2.uml.Package) subPackage, sysmlProfile, true)) {
		// return CommandResult.newOKCommandResult();
		// }
		// return CommandResult.newErrorCommandResult("Profile " + sysmlProfile.getName() + " could not be applied");
		// }
		// };
		// try {
		// newCommand.execute(new NullProgressMonitor(), null);
		// } catch (ExecutionException e) {
		// fail(e.getMessage());
		// }
		PackageableElement newComponent = subPackage.createPackagedElement(COMPONENT_NAME, UMLFactory.eINSTANCE.createComponent().eClass());
		// StereotypeApplicationHelper.INSTANCE.applyStereotype(newComponent, UMLPackage.eINSTANCE.getComponent());
		PackageableElement newClass = subPackage.createPackagedElement(CLASS_NAME, UMLFactory.eINSTANCE.createClass().eClass());
		Class beforeStrategyClass = (Class) newClass;
		beforeStrategyClass.createOwnedAttribute(PROPERTY_CLASS_NAME, UMLFactory.eINSTANCE.createProperty().getType());

		return subPackage;
	}

}
