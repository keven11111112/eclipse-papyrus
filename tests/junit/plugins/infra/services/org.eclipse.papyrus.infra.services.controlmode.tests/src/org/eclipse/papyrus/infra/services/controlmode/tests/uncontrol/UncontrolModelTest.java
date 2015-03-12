/*******************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Juan Cadavid (CEA) juan.cadavid@cea.fr - Implementation initial and API 
 *     Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Bug 459427
 ******************************************************************************/
package org.eclipse.papyrus.infra.services.controlmode.tests.uncontrol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.core.resources.IFile;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.controlmode.tests.Messages;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.uml2.uml.Element;
import org.junit.Test;

/**
 * Test class for Uncontrol Mode with simple model.
 * 
 * @author Juan Cadavid
 *
 */
@PluginResource("model/UncontrolModeTest/ReintegrateTestModel.di")
public class UncontrolModelTest extends AbstractUncontrolModelTest {

	/**
	 * Test of uncontrol one submodel
	 */
	@Test
	public void testUncontrolOneSubmodel() {
		UncontrolModeAssertion uncontrolAssertion = new UncontrolModeAssertion(Messages.UncontrolModelTest_4);
		uncontrolAssertion.assertUncontrol();


		editorFixture.close(editor);
		openEditor();

		assertTrue("After have reloaded the editor, there is still controlled element.", getControlledElements().isEmpty());
	}

	/**
	 * Test of uncontrol one submodel
	 */
	@Test
	public void testDeleteSubmodel() {
		UncontrolModeAssertion uncontrolAssertion = new UncontrolModeAssertion(Messages.UncontrolModelTest_4) {
			/**
			 * @see org.eclipse.papyrus.infra.services.controlmode.tests.uncontrol.AbstractUncontrolModelTest.UncontrolModeAssertion#getCommandId()
			 *
			 * @return
			 */
			@Override
			protected String getCommandId() {
				return "org.eclipse.ui.edit.delete"; // $NON-NLS-1$
			}

			/**
			 * @see org.eclipse.papyrus.infra.services.controlmode.tests.uncontrol.AbstractUncontrolModelTest.UncontrolModeAssertion#assertBeforeSave()
			 *
			 */
			@Override
			protected void assertBeforeSave() {
				assertNull("The controlled element was not deleted.", getElementToUnControl().eResource());
				assertNull("The controlled element was not deleted.", getElementToUnControl().eContainer());
			}

			/**
			 * @see org.eclipse.papyrus.infra.services.controlmode.tests.uncontrol.AbstractUncontrolModelTest.UncontrolModeAssertion#assertAfterSave()
			 *
			 */
			@Override
			protected void assertAfterSave() {
				assertFalse("The fragment resource was not deleted.", editorFixture.getProject().getProject().getFile("Subpackage.uml").exists());
			}

		};
		uncontrolAssertion.assertUncontrol();


		editorFixture.close(editor);
		openEditor();

		assertTrue("After have reloaded the editor, there is still controlled element.", getControlledElements().isEmpty());
	}

	/**
	 * Test of uncontrol one submodel
	 * 
	 * @throws ServiceException
	 */
	@Test
	public void testUndoUncontrolOneSubmodel() throws ServiceException {
		UncontrolModeAssertion uncontrolAssertion = new UncontrolModeAssertion(Messages.UncontrolModelTest_4);
		uncontrolAssertion.assertUncontrol();

		undo();
		assertNotSame(model.eResource(), selectedElements.get(0).eResource());

		save();
		assertTrue(editorFixture.getProject().getProject().getFile(selectedElements.get(0).getName() + ".uml").exists());


		editorFixture.close(editor);
		openEditor();

		assertFalse("After have reloaded the editor, there is not controlled element.", getControlledElements().isEmpty());
	}

	/**
	 * Test of uncontrol several submodels containing in same resource.
	 */
	@Test
	@PluginResource("model/UncontrolModeSeveralFragments/model.di")
	public void testUncontrolSeveralSubmodels() {

		UncontrolModeAssertion uncontrolAssertion = new UncontrolModeAssertion(Messages.UncontrolModelTest_4) {

			@Override
			protected void assertAfterSave() {
				super.assertAfterSave();
				assertFalse(editorFixture.getProject().getProject().getFile("Package1.uml").exists());
			}
		};
		uncontrolAssertion.assertUncontrol();

		uncontrolAssertion = new UncontrolModeAssertion(Messages.UncontrolModelTest_4) {

			@Override
			protected Element getElementToUnControl() {
				return selectedElements.get(1);
			}

			@Override
			protected void assertAfterSave() {
				super.assertAfterSave();
				assertFalse(editorFixture.getProject().getProject().getFile("Package2.uml").exists());
			}
		};
		uncontrolAssertion.assertUncontrol();


		editorFixture.close(editor);
		openEditor();

		assertTrue("After have reloaded the editor, there are still controlled element.", getControlledElements().isEmpty());
	}

	/**
	 * Test of uncontrol several submodels containing in same resource.
	 * 
	 * @throws ServiceException
	 */
	@Test
	@PluginResource("model/UncontrolModeSeveralFragments/model.di")
	public void testUndoUncontrolSeveralSubmodels() throws ServiceException {

		UncontrolModeAssertion uncontrolAssertion = new UncontrolModeAssertion(Messages.UncontrolModelTest_4) {

			@Override
			protected void assertAfterSave() {
				super.assertAfterSave();
				assertFalse(editorFixture.getProject().getProject().getFile("Package1.uml").exists());
			}
		};
		uncontrolAssertion.assertUncontrol();

		uncontrolAssertion = new UncontrolModeAssertion(Messages.UncontrolModelTest_4) {

			@Override
			protected Element getElementToUnControl() {
				return selectedElements.get(1);
			}

			@Override
			protected void assertAfterSave() {
				super.assertAfterSave();
				assertFalse(editorFixture.getProject().getProject().getFile("Package2.uml").exists());
			}
		};
		uncontrolAssertion.assertUncontrol();


		undo();
		assertNotSame(model.eResource(), selectedElements.get(1).eResource());

		undo();
		assertNotSame(model.eResource(), selectedElements.get(0).eResource());

		save();
		assertTrue(editorFixture.getProject().getProject().getFile("Package1.uml").exists());
		assertTrue(editorFixture.getProject().getProject().getFile("Package2.uml").exists());


		editorFixture.close(editor);
		openEditor();

		assertFalse("After have reloaded the editor, there are not controlled elements.", getControlledElements().isEmpty());
	}

	/**
	 * Test of uncontrol several submodels containing in same resource.
	 */
	@Test
	@PluginResource("model/UncontrolModeSameResource/model.di")
	public void testUncontrolSeveralSubmodelsInSameResource() {

		UncontrolModeAssertion uncontrolAssertion = new UncontrolModeAssertion(Messages.UncontrolModelTest_4) {

			@Override
			protected void assertAfterSave() {
				super.assertAfterSave();
				assertTrue(editorFixture.getProject().getProject().getFile("SubModels.uml").exists());
			}
		};
		uncontrolAssertion.assertUncontrol();

		uncontrolAssertion = new UncontrolModeAssertion(Messages.UncontrolModelTest_4) {

			@Override
			protected Element getElementToUnControl() {
				return selectedElements.get(1);
			}

			@Override
			protected void assertAfterSave() {
				super.assertAfterSave();
				assertFalse(editorFixture.getProject().getProject().getFile("SubModels.uml").exists());
			}
		};
		uncontrolAssertion.assertUncontrol();


		editorFixture.close(editor);
		openEditor();

		assertTrue("After have reloaded the editor, there are still controlled element.", getControlledElements().isEmpty());
	}

	/**
	 * Test of uncontrol several submodels containing in same resource.
	 * 
	 * @throws ServiceException
	 */
	@Test
	@PluginResource("model/UncontrolModeSameResource/model.di")
	public void testUndoUncontrolSeveralSubmodelsInSameResource() throws ServiceException {

		UncontrolModeAssertion uncontrolAssertion = new UncontrolModeAssertion(Messages.UncontrolModelTest_4) {

			@Override
			protected void assertAfterSave() {
				super.assertAfterSave();

				IFile fragmentResource = editorFixture.getProject().getProject().getFile("SubModels.uml");
				assertTrue(fragmentResource.exists());
				assertEquals(1, editorFixture.getResourceSet().getResource(getURIFileInProject("SubModels.uml"), false).getContents().size());
			}
		};
		uncontrolAssertion.assertUncontrol();

		uncontrolAssertion = new UncontrolModeAssertion(Messages.UncontrolModelTest_4) {

			@Override
			protected Element getElementToUnControl() {
				return selectedElements.get(1);
			}

			@Override
			protected void assertAfterSave() {
				super.assertAfterSave();
				assertFalse(editorFixture.getProject().getProject().getFile("SubModels.uml").exists());
			}
		};
		uncontrolAssertion.assertUncontrol();


		undo();
		assertNotSame(model.eResource(), selectedElements.get(1).eResource());

		undo();
		assertNotSame(model.eResource(), selectedElements.get(0).eResource());

		save();
		assertTrue(editorFixture.getProject().getProject().getFile("SubModels.uml").exists());


		editorFixture.close(editor);
		openEditor();

		assertFalse("After have reloaded the editor, there are not controlled elements.", getControlledElements().isEmpty());
	}


	/**
	 * Test of uncontrol several submodels containing in same resource.
	 * 
	 * @throws ServiceException
	 */
	@Test
	@PluginResource("model/UncontrolModeSeveralFragments/model.di")
	public void testUndoUncontrolSeveralSubmodelsWithoutSave() throws ServiceException {

		UncontrolModeAssertion uncontrolAssertion = new UncontrolModeAssertion(Messages.UncontrolModelTest_4) {

			@Override
			protected void save() {
				// Not save
			}

		};
		uncontrolAssertion.assertUncontrol();

		uncontrolAssertion = new UncontrolModeAssertion(Messages.UncontrolModelTest_4) {

			@Override
			protected Element getElementToUnControl() {
				return selectedElements.get(1);
			}

		};
		uncontrolAssertion.assertUncontrol();


		undo();
		assertNotSame(model.eResource(), selectedElements.get(1).eResource());

		undo();
		assertNotSame(model.eResource(), selectedElements.get(0).eResource());

		assertFalse("After have reloaded the editor, there are not controlled elements.", getControlledElements().isEmpty());
		save();
		assertTrue(editorFixture.getProject().getProject().getFile("Package1.uml").exists());
		assertTrue(editorFixture.getProject().getProject().getFile("Package2.uml").exists());


		editorFixture.close(editor);
		openEditor();

		assertFalse("After have reloaded the editor, there are not controlled elements.", getControlledElements().isEmpty());
	}
}
