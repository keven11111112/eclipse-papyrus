/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 434993
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.tests.creation;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.IdentityCommand;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelUtils;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.rules.HouseKeeper;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;

/**
 * Test creation of UML elements (Creation / Undo / redo)
 */
public class CreateRelationshipTest extends AbstractPapyrusTest {

	@ClassRule
	public static final HouseKeeper.Static houseKeeper = new HouseKeeper.Static();
	
	private static IProject createProject;

	private static IFile copyPapyrusModel;

	private static IMultiDiagramEditor openPapyrusEditor;

	private static ModelSet modelset;

	private static UmlModel umlIModel;

	private static Model rootModel;

	private static TransactionalEditingDomain transactionalEditingDomain;

	private static Class testClass1;

	private static Class testClass2;
	
	private static Package testPackage1;
	
	private static Package testPackage2;

	/**
	 * Init test class
	 */
	@BeforeClass
	public static void initCreateElementTest() {

		// create Project
		createProject = houseKeeper.createProject("UMLServiceTypesTest");

		// import test model
		try {
			copyPapyrusModel = PapyrusProjectUtils.copyPapyrusModel(createProject, Platform.getBundle("org.eclipse.papyrus.uml.service.types"), "/resource/", "TestModel");
		} catch (CoreException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}

		// open project
		try {
			openPapyrusEditor = houseKeeper.openPapyrusEditor(copyPapyrusModel);
		} catch (Exception e1) {
			fail(e1.getMessage());
		}

		transactionalEditingDomain = (TransactionalEditingDomain)openPapyrusEditor.getAdapter(TransactionalEditingDomain.class);
		assertTrue("Impossible to init editing domain", transactionalEditingDomain instanceof TransactionalEditingDomain);

		// retrieve UML model from this editor
		try {
			modelset = ModelUtils.getModelSetChecked(openPapyrusEditor.getServicesRegistry());
			umlIModel = UmlUtils.getUmlModel(modelset);
			rootModel = (Model)umlIModel.lookupRoot();
		} catch (ServiceException e) {
			fail(e.getMessage());
		} catch (NotFoundException e) {
			fail(e.getMessage());
		} catch (ClassCastException e) {
			fail(e.getMessage());
		}
		try {
			initExistingElements();
		} catch (Exception e) {
			fail(e.getMessage());
		}

	}

	/**
	 * Init fields corresponding to element in the test model
	 */
	private static void initExistingElements() throws Exception {
		// existing test activity
		testClass1 = (Class)rootModel.getOwnedMember("TestClass");
		testClass2 = (Class)rootModel.getOwnedMember("TestClass2");
		testPackage1 = (Package)rootModel.getOwnedMember("TestPackage1");
		testPackage2 = (Package)rootModel.getOwnedMember("TestPackage2");
		Assert.assertNotNull("Impossible to find testClass", testClass1);
	}


	/* Depencency test cases */

	@Test
	public void testCreateDependencyBetweenClassesInPackage() throws Exception {
		runCreationLinkTest(testPackage1, testClass1, testClass2, UMLElementTypes.DEPENDENCY, true);
	}

	/*
	 * This test case will pass even though the container is set to a class. This is because container is altered 
	 */
	@Test
	public void testCreateDependencyBetweenClassesInClass() throws Exception {
		runCreationLinkTest(testClass1, testClass1, testClass2, UMLElementTypes.DEPENDENCY, true);
	}

	@Test 
	public void testCreateDependencyBetweenClassAndNullInPackage() throws Exception {
		runCreationLinkTest(testPackage1, testClass1, null, UMLElementTypes.DEPENDENCY, true);
	}

	@Test (expected=NullPointerException.class)
	public void testCreateDependencyBetweenNullAndClassInPackage() throws Exception {
		runCreationLinkTest(testPackage1, null, testClass2, UMLElementTypes.DEPENDENCY, false);
	}

	@Test 
	public void testCreateDependencyBetweenClassesInNull() throws Exception {
		runCreationLinkTest(null, testClass1, testClass2, UMLElementTypes.DEPENDENCY, true);
	}
		
	@Test
	public void testCreateDependencyBetweenClassAndNullInNull() throws Exception {
		runCreationLinkTest(null, testClass1, null, UMLElementTypes.DEPENDENCY, true);
	}


	/* Association test cases */
	
	@Test
	public void testCreateAssociationBetweenClassesInPackage() throws Exception {
		runCreationLinkTest(testPackage1, testClass1, testClass2, UMLElementTypes.ASSOCIATION, true);
	}

	@Test
	public void testCreateAssociationBetweenClassesInClass() throws Exception {
		runCreationLinkTest(testClass1, testClass1, testClass2, UMLElementTypes.ASSOCIATION, true);
	}

	
	@Test
	public void testCreateAssociationBetweenPackages() throws Exception {
		runCreationLinkTest(null, testPackage1, testPackage2, UMLElementTypes.ASSOCIATION, false);
	}
	
	@Test
	public void testCreateAssociationBetweenClasses() throws Exception {
		runCreationLinkTest(null, testClass1, testClass2, UMLElementTypes.ASSOCIATION, true);
	}

	@Test
	public void testCreateAssociationBetweenClasSAndNullInClass() throws Exception {
		runCreationLinkTest(testClass1, testClass2, null, UMLElementTypes.ASSOCIATION, true);
	}



	protected void runCreationLinkTest(EObject container, EObject source, EObject target, IHintedType hintedType, boolean canCreate) throws Exception {
		Assert.assertTrue("Editor should not be dirty before test", !openPapyrusEditor.isDirty());
		Command command = getCreateLinkCommand(container, source, target, hintedType, canCreate);

		// command has been tested when created. Runs the test if it is possible
		if(canCreate) {
			transactionalEditingDomain.getCommandStack().execute(command);
			transactionalEditingDomain.getCommandStack().undo();
			Assert.assertTrue("Editor should not be dirty after undo", !openPapyrusEditor.isDirty());
			transactionalEditingDomain.getCommandStack().redo();
			transactionalEditingDomain.getCommandStack().undo();
			// assert editor is not dirty
			Assert.assertTrue("Editor should not be dirty after undo", !openPapyrusEditor.isDirty());
		} 

	}

	/**
	 * Creates the relationship in the given owner element, between the source and target elements, undo and redo the action
	 *
	 * @param container
	 *        container of the new element
	 * @param source
	 *        the source of the relationship
	 * @param target
	 *        the target of the relationship
	 * @param hintedType
	 *        type of the new element
	 * @param canCreate
	 *        <code>true</code> if new element can be created in the specified owner
	 *        
	 * @return the command
	 */
	protected Command getCreateLinkCommand(EObject container, EObject source, EObject target, IHintedType hintedType, boolean canCreate) throws ServiceException {
		// getCommandprovider from any of the non null EObject 
		IElementEditService elementEditService = null;
		TransactionalEditingDomain transactionalEditingDomain = null;
		
		elementEditService = ElementEditServiceUtils.getCommandProvider(hintedType);
		
		if(source!=null) {
			 transactionalEditingDomain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(source);
		} else if(target!=null) {
			 transactionalEditingDomain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(target);
		} else if(container!=null) {
			 transactionalEditingDomain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(container);
		} else {
			fail("impossible to run the test with null parameters");
		}
		
		CreateRelationshipRequest request = new CreateRelationshipRequest(transactionalEditingDomain, container, source, target, hintedType);
		ICommand command = elementEditService.getEditCommand(request);
		// test if the command is enable and compare with the canCreate parameter
		boolean canExecute = command.canExecute();
		if(canExecute) {
			if (command instanceof ICompositeCommand) {
				ICompositeCommand compositeCommand = (ICompositeCommand)command;
				Iterator<ICommand> it = compositeCommand.iterator();
				while (it.hasNext() ) {
					ICommand subCommand = (ICommand) it.next();
					assertTrue("Command should be a CreateRelationshipCommand or IdentityCommand", subCommand instanceof CreateRelationshipCommand || subCommand instanceof IdentityCommand );
				}
			} else {
				assertTrue("Command should be a CreationCommand", command instanceof CreateRelationshipCommand);
			}
			
			
			// executable but was expected as not executable
			if(!canCreate) {
				fail("Creation command is executable but it was expected as not executable");
			} else {
				// command is executable, and it was expected to => run the creation
				Command emfCommand = new org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper(command);
				return emfCommand;
			}
		} else {
			if(canCreate) {
				fail("Creation command is not executable but it was expected to be executable");
			}
		}
		return null;
	}
}
