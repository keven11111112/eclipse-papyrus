/*****************************************************************************
 * Copyright (c) 2010, 2016 CEA LIST, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 431953 (fix test to prevent Model Repair dialog on unrecognized profile schema)
 *  Christian W. Damus (CEA) - bug 434993
 *  Christian W. Damus - bug 485220
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes.ui.tests;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSetRegistry;
import org.eclipse.papyrus.infra.extendedtypes.internal.ui.preferences.ExtendedTypesPreferences;
import org.eclipse.papyrus.infra.extendedtypes.tests.AbstractElementTypeTests;
import org.eclipse.papyrus.infra.extendedtypes.tests.ITestConstants;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;


/**
 * Tests for {@link ExtendedTypesRegistry}
 */
@SuppressWarnings("restriction")
public class ExtendedTypesRegistryTests extends AbstractElementTypeTests implements ITestConstants {

	protected static IFile workspaceTestFile;

	/**
	 * Init test class
	 */
	@BeforeClass
	public static void initCreateElementTest() {

		// import user extended types model
		try {
			Bundle bundle = FrameworkUtil.getBundle(ExtendedTypesRegistryTests.class);
			workspaceTestFile = PapyrusProjectUtils.copyIFile("/model/WorkspaceTest.extendedtypes", bundle, createProject, "/model/WorkspaceTest.extendedtypes");
			Assert.assertTrue(workspaceTestFile.isAccessible());
		} catch (CoreException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test workspace registration. Element type in the workspace, but element type set is not loaded
	 */
	@Test
	public final void testGetTypeRegisteredInWorkspaceNotLoaded() {
		checkPluginTypes();

		// no preference should be set for this test
		ExtendedTypesPreferences.unregisterWorkspaceDefinition(WORKSPACE_ELEMENT_TYPE_ID);

		// this should not be defined yet
		IElementType workspaceType = ElementTypeRegistry.getInstance().getType(WORKSPACE_ELEMENT_TYPE_TOOL);
		Assert.assertNull("Element type should not be registered yet", workspaceType);

	}

	/**
	 * Test workspace registration. Element type in the workspace, but element type set is not loaded
	 */
	@Test
	public final void testLoadUnloadWorkspaceSet() {
		// this should not be defined yet
		IElementType workspaceType = ElementTypeRegistry.getInstance().getType(WORKSPACE_ELEMENT_TYPE_TOOL);
		Assert.assertNull("Element type should not be registered yet", workspaceType);
		checkPluginTypes();

		// register
		ExtendedTypesPreferences.registerWorkspaceDefinition(WORKSPACE_ELEMENT_TYPE_ID, workspaceTestFile.getFullPath().toString());
		ExtendedElementTypeSetRegistry.getInstance().loadExtendedElementTypeSet(WORKSPACE_ELEMENT_TYPE_ID);

		workspaceType = ElementTypeRegistry.getInstance().getType(WORKSPACE_ELEMENT_TYPE_TOOL);
		Assert.assertNotNull("Element type should be registered", workspaceType);
		checkPluginTypes();

		// unregister
		ExtendedTypesPreferences.unregisterWorkspaceDefinition(WORKSPACE_ELEMENT_TYPE_ID);
		ExtendedElementTypeSetRegistry.getInstance().unload(WORKSPACE_ELEMENT_TYPE_ID);

		workspaceType = ElementTypeRegistry.getInstance().getType(WORKSPACE_ELEMENT_TYPE_TOOL);
		Assert.assertNull("Element type should not be registered anymore", workspaceType);
		checkPluginTypes();

	}

	/**
	 * Check always present element types are registered
	 */
	private void checkPluginTypes() {
		IElementType classType = ElementTypeRegistry.getInstance().getType(ORG_ECLIPSE_PAPYRUS_UML_CLASS);
		Assert.assertNotNull("Element type should be registered", classType);
		IElementType abstractClassType = ElementTypeRegistry.getInstance().getType(ABSTRACT_CLASS_TOOL);
		Assert.assertNotNull("Element type should be registered", abstractClassType);
	}
}
