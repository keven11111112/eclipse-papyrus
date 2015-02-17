/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.services.controlmode.tests.control;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.commands.IParameter;
import org.eclipse.core.commands.ParameterValuesException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.core.sashwindows.di.util.DiUtils;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.services.controlmode.commands.ControlModeCommandParameterValues;
import org.eclipse.papyrus.infra.services.controlmode.tests.Messages;
import org.eclipse.papyrus.infra.services.handler.ControlCommandHandler;
import org.eclipse.papyrus.junit.utils.HandlerUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.uml2.uml.PackageableElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.osgi.framework.Bundle;

/**
 * Test of Control feature with Legacy model.
 * 
 * @author Gabriel Pascual
 *
 */
public class ControlLegacyModelTest extends AbstractControlModeTest {

	private static final String PROJECT_NAME = "ControlModeTestProject"; //$NON-NLS-1$

	private static final String SOURCE_PATH = "/model/ControlModeLegacyModelTest/"; //$NON-NLS-1$

	private static final String FILE_ROOT_NAME = "model"; //$NON-NLS-1$

	@Override
	protected void initTests(final Bundle bundle) throws CoreException, IOException {
		bot = new SWTWorkbenchBot();
		ProjectUtils.removeAllProjectFromTheWorkspace();
		IProject testProject = ProjectUtils.createProject(PROJECT_NAME);
		modelFile = PapyrusProjectUtils.copyPapyrusModel(testProject, bundle, SOURCE_PATH, FILE_ROOT_NAME);
		AbstractControlModeTest.bundle = bundle;
	}

	@After
	public void cleanUp() throws NotDefinedException, ParameterValuesException {

		// Set value to default
		IParameter dialogParameter = HandlerUtils.getCommand(this.COMMAND_ID).getParameter(ControlCommandHandler.CONTROLMODE_USE_DIALOG_PARAMETER);
		ControlModeCommandParameterValues controlModePlatformValues = (ControlModeCommandParameterValues) dialogParameter.getValues();
		controlModePlatformValues.put("showDialog", true);
	}

	@Ignore
	@Test
	public void testControlLegacyModel() {
		RunnableWithResult<?> runnableWithResult = new RunnableWithResult.Impl<Object>() {

			@Override
			public void run() {
				List<PackageableElement> elements = selectElementToControl();
				Assert.assertTrue(Messages.ControlModelTest_4, HandlerUtils.getActiveHandlerFor(COMMAND_ID).isEnabled());
				// Click "ok" with SWTBot
				Display.getDefault().asyncExec(new Runnable() {

					@Override
					public void run() {
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							fail(e.getLocalizedMessage());
						}


						bot.button("OK").click(); //$NON-NLS-1$

					}
				});
				controlAndSave(editor, model, elements, HandlerUtils.getCommand(COMMAND_ID));
				assertSashControl(elements);
			}


		};
		Display.getDefault().syncExec(runnableWithResult);
	}

	@Test
	public void testControlModelWithoutDialog() throws NotDefinedException, ParameterValuesException {
		IParameter dialogParameter = HandlerUtils.getCommand(this.COMMAND_ID).getParameter(ControlCommandHandler.CONTROLMODE_USE_DIALOG_PARAMETER);
		ControlModeCommandParameterValues controlModePlatformValues = (ControlModeCommandParameterValues) dialogParameter.getValues();
		controlModePlatformValues.put("showDialog", false);
		RunnableWithResult<?> runnableWithResult = new RunnableWithResult.Impl<Object>() {

			@Override
			public void run() {
				List<PackageableElement> elements = selectElementToControl();
				Assert.assertTrue(Messages.ControlModelTest_4, HandlerUtils.getActiveHandlerFor(COMMAND_ID).isEnabled());

				controlAndSave(editor, model, elements, HandlerUtils.getCommand(COMMAND_ID));
				assertSashControl(elements);
			}

		};
		Display.getDefault().syncExec(runnableWithResult);
	}

	/**
	 * Assert sash control.
	 *
	 * @param elements
	 *            the elements
	 */
	private void assertSashControl(List<PackageableElement> elements) {
		ModelSet modelSet = null;
		PackageableElement controledElement = elements.get(0);
		try {
			modelSet = ServiceUtilsForEObject.getInstance().getModelSet(controledElement);
		} catch (ServiceException e) {
			fail(e.getMessage());
		}
		Resource resource = modelSet.getAssociatedResource(controledElement, DiModel.DI_FILE_EXTENSION, true);
		assertFalse(resource.getContents().isEmpty());
		assertNotNull(DiUtils.lookupSashWindowsMngr(resource));
	}

}
