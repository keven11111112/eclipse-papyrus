/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.tests.regression;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorWithFlyOutPalette;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelUtils;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.gmfdiag.paletteconfiguration.tests.Activator;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.junit.utils.EditorUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.rules.HouseKeeper;
import org.eclipse.papyrus.uml.diagram.clazz.CreateClassDiagramCommand;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.osgi.framework.Bundle;

/**
 * Regression test for bug 457712
 */
public class Bug457712PaletteConfigurationRequiredProfile implements ITestConstants {

	public static final String RESOURCES_FOLDER = "/resources/";

	@ClassRule
	public static HouseKeeper.Static houseKeeper = new HouseKeeper.Static();

	protected static IProject createProject;

	protected static IMultiDiagramEditor openPapyrusEditor;

	protected static ModelSet modelset;

	protected static UmlModel umlIModel;

	protected static Model rootModel;

	protected static TransactionalEditingDomain transactionalEditingDomain;

	protected static IFile workspaceTestFile;

	private static IFile copyTestModel;

	private static Diagram classDiagram;

	private Profile testProfile;

	/**
	 * Init test class
	 */
	@BeforeClass
	public static void initCreateElementTest() {

		// create Project
		createProject = houseKeeper.createProject(BUG457712_PALETTE_CONFIGURATION);

		// import test model and profile
		try {
			Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
			PapyrusProjectUtils.copyPapyrusModel(createProject, bundle, RESOURCES_FOLDER, "TestPalette.profile");
			copyTestModel = PapyrusProjectUtils.copyPapyrusModel(createProject, bundle, RESOURCES_FOLDER, "Model");
		} catch (CoreException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}

		// open project
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				try {
					openPapyrusEditor = houseKeeper.cleanUpLater(EditorUtils.openPapyrusEditor(copyTestModel));
				} catch (PartInitException e) {
					fail(e.getMessage());
				}
			}
		});

		transactionalEditingDomain = (TransactionalEditingDomain) openPapyrusEditor.getAdapter(TransactionalEditingDomain.class);
		assertTrue("Impossible to init editing domain", transactionalEditingDomain instanceof TransactionalEditingDomain);

		// retrieve UML model from this editor
		try {
			modelset = ModelUtils.getModelSetChecked(openPapyrusEditor.getServicesRegistry());
			umlIModel = UmlUtils.getUmlModel(modelset);
			rootModel = (Model) umlIModel.lookupRoot();

			Assert.assertNotNull("root model should not be null", rootModel);

			ICreationCommand command = new CreateClassDiagramCommand();
			classDiagram = command.createDiagram(modelset, null, "DiagramToTest");
			modelset.save(new NullProgressMonitor());

			assertNotNull("There should be a class diagram for test", classDiagram);

		} catch (ServiceException e) {
			fail(e.getMessage());
		} catch (NotFoundException e) {
			fail(e.getMessage());
		} catch (ClassCastException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testNoProfileApplied() {
		// check the palette. tool to create a class with stereotype StoOnClass should not be present
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				// check with profile applied (it is already applied in the model). The drawer should be visible
				checkPaletteDrawer("TestPaletteNodesDrawer", true);
				checkPaletteDrawer("TestFakePaletteNodesDrawer", false);
				checkPaletteDrawer("TestNoProfilePaletteNodesDrawer", true);
			}
		});

	}

	protected void checkPaletteDrawer(String identifier, boolean isVisible) {
		IEditorPart part = openPapyrusEditor.getActiveEditor();
		if (part instanceof DiagramEditorWithFlyOutPalette) {
			PaletteViewer paletteViewer = (PaletteViewer) ((DiagramEditorWithFlyOutPalette) part).getAdapter(PaletteViewer.class);
			assertNotNull("There should be a palette viewer on active editor", paletteViewer);

			// will do a shortcut here, only test if test drawer is active or not. This may be enhanced by testing the tool itself
			List<?> drawers = paletteViewer.getPaletteRoot().getChildren();
			boolean isDisplayed = false;
			for (Object o : drawers) {

				if (o instanceof PaletteDrawer) {
					// check it does not have id: TestPaletteNodesDrawer
					if (identifier.equals(((PaletteDrawer) o).getId())) {
						if (!isVisible) {
							fail("the drawer for test palette should not be here as the profile TestPalette is not applied");
						}
						isDisplayed = true;
					}
				}

			}
			if (isVisible & !isDisplayed) {
				fail("the drawer for test palette was not there whereas the profile TestPalette is applied");
			}
		} else {
			fail("impossible to adapt into a  papyrus editor");
		}

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


}