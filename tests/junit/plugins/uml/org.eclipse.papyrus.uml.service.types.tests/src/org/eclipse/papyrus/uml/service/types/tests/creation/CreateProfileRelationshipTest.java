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
 *  Patrik Nandorf (Ericsson AB) - Bug 425565
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.tests.creation;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelUtils;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.newchild.SetTargetAndRelationshipCommand;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.widgets.editors.ITreeSelectorDialog;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.rules.HouseKeeper;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;

/**
 * Test creation of UML elements (Creation / Undo / redo)
 */
public class CreateProfileRelationshipTest extends AbstractPapyrusTest {
	private static final boolean RESULT_EXPECTED = true;
	private static final boolean RESULT_NOT_EXPECTED = false;
	private static final boolean CAN_CREATE = true;
	private static final boolean CAN_NOT_CREATE = false;


	@ClassRule
	public static final HouseKeeper.Static houseKeeper = new HouseKeeper.Static();

	private static IProject createProject;

	private static IFile copyPapyrusModel;

	private static IMultiDiagramEditor openPapyrusEditor;

	private static ModelSet modelset;

	private static UmlModel umlIModel;

	private static Profile rootProfile;

	private static TransactionalEditingDomain transactionalEditingDomain;

	private static Stereotype testStereotype;
	private static PackageableElement importedElement;


	/**
	 * Init test class
	 */
	@BeforeClass
	public static void initCreateElementTest() {

		// create Project
		createProject = houseKeeper.createProject("UMLServiceTypesTest");

		// import test model
		try {
			copyPapyrusModel = PapyrusProjectUtils.copyPapyrusModel(createProject, Platform.getBundle("org.eclipse.papyrus.uml.service.types"), "/resource/", "testprofile.profile");
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
			rootProfile = (Profile)umlIModel.lookupRoot();
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
		testStereotype = (Stereotype)rootProfile.getOwnedMember("TestStereotype");
		Assert.assertNotNull("Impossible to find testStereotype", testStereotype);

		EList<ElementImport> elementImports = rootProfile.getElementImports();
		Assert.assertNotNull("Impossible to find elementImports", elementImports);
		
		ElementImport elementImport = elementImports.get(0);
		importedElement = elementImport.getImportedElement();
		Assert.assertNotNull("Impossible to find importedElement", importedElement);

		
	}



	/* EXTENSION test cases */

		@Test 
		public void testCreateExtensionBetweenStereotypeAndMetaClassInPackage() throws Exception {
			runCreationRelationshipTest(rootProfile, testStereotype, importedElement , UMLElementTypes.EXTENSION, CAN_CREATE, RESULT_EXPECTED);
		}


	/* CONNECTOR test cases */
	// TBD


	/* PROFILE_APPLICATION test cases */
	// TBD


	/* TEMPLATE_BINDING test cases */
	// TBD


	protected void runCreationRelationshipTest(EObject container, EObject source, EObject target, IHintedType hintedType, boolean canCreate, boolean resultExpected) throws Exception {
		Assert.assertTrue("Editor should not be dirty before test", !openPapyrusEditor.isDirty());
		Command command = getCreateRelationshipCommand(container, source, target, hintedType, canCreate);

		// command has been tested when created. Runs the test if it is possible
		if(canCreate) {
			transactionalEditingDomain.getCommandStack().execute(command);
			Collection<?> commandResult = command.getResult();

			if (commandResult.isEmpty() && resultExpected) {
				Assert.fail("Command should have a non-empty result");
			}	

			if (!commandResult.isEmpty() && !resultExpected) {
				Assert.fail("Command should have a empty result");
			}	

			Assert.assertTrue("Editor should be dirty after executed command", openPapyrusEditor.isDirty());
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
	protected Command getCreateRelationshipCommand(EObject container, EObject source, EObject target, IHintedType hintedType, boolean canCreate) throws ServiceException {
		// getCommandprovider from any of the non null EObject 
		TransactionalEditingDomain transactionalEditingDomain = null;

		if(source!=null) {
			transactionalEditingDomain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(source);
		} else if(target!=null) {
			transactionalEditingDomain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(target);
		} else if(container!=null) {
			transactionalEditingDomain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(container);
		} else {
			fail("impossible to run the test with null parameters");
		}

		ICommand command = buildWrappedRelationshipCommand(transactionalEditingDomain,hintedType,container,target,null);
		// test if the command is enable and compare with the canCreate parameter
		boolean canExecute = command.canExecute();
		if(canExecute) {			

			if (!(command instanceof SetTargetAndRelationshipCommand)) {
				assertTrue("Command should be a SetTargetAndRelationshipCommand", command instanceof SetTargetAndRelationshipCommand);
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


	/**
	 * 
	 * @param ted
	 * @param elementType
	 * @param container
	 * @param target
	 * @param reference
	 * @return
	 */
	protected ICommand buildWrappedRelationshipCommand(TransactionalEditingDomain ted, IElementType elementType, EObject container,EObject target, EReference reference) {
		IElementEditService serviceProvider = ElementEditServiceUtils.getCommandProvider(elementType);
		ITreeSelectorDialog dialog = new TestTargetSelectionDialog(target);
		SetTargetAndRelationshipCommand createGMFCommand = new SetTargetAndRelationshipCommand(ted, "Create "+elementType.getDisplayName(),serviceProvider,reference, container, elementType,dialog);
		return createGMFCommand;
	}

	class TestTargetSelectionDialog implements ITreeSelectorDialog {
		private EObject target;

		/**
		 * Constructor.
		 *
		 * @param target
		 */
		public TestTargetSelectionDialog(EObject target) {
			this.target = target;
		}

		/**
		 * @see org.eclipse.papyrus.infra.widgets.editors.ITreeSelectorDialog#setLabelProvider(org.eclipse.jface.viewers.ILabelProvider)
		 *
		 * @param provider
		 */
		@Override
		public void setLabelProvider(ILabelProvider provider) {
		}

		/**
		 * @see org.eclipse.papyrus.infra.widgets.editors.ITreeSelectorDialog#setContentProvider(org.eclipse.jface.viewers.ITreeContentProvider)
		 *
		 * @param provider
		 */
		@Override
		public void setContentProvider(ITreeContentProvider provider) {
		}

		/**
		 * @see org.eclipse.papyrus.infra.widgets.editors.ITreeSelectorDialog#setDescription(java.lang.String)
		 *
		 * @param description
		 */
		@Override
		public void setDescription(String description) {
		}

		/**
		 * @see org.eclipse.papyrus.infra.widgets.editors.ITreeSelectorDialog#setInput(java.lang.Object)
		 *
		 * @param input
		 */
		@Override
		public void setInput(Object input) {
		}

		/**
		 * @see org.eclipse.papyrus.infra.widgets.editors.ITreeSelectorDialog#setInitialElementSelections(java.util.List)
		 *
		 * @param selectedElements
		 */
		@Override
		public void setInitialElementSelections(List selectedElements) {
		}

		/**
		 * @see org.eclipse.papyrus.infra.widgets.editors.ITreeSelectorDialog#open()
		 *
		 * @return
		 */
		@Override
		public int open() {
			return Window.OK;
		}

		/**
		 * @see org.eclipse.papyrus.infra.widgets.editors.ITreeSelectorDialog#getResult()
		 *
		 * @return
		 */
		@Override
		public Object[] getResult() {
			return new Object[] { target };
		}

		/**
		 * @see org.eclipse.papyrus.infra.widgets.editors.ITreeSelectorDialog#setTitle(java.lang.String)
		 *
		 * @param label
		 */
		@Override
		public void setTitle(String label) {
		}
	}
}
