/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
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
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.elementtypesconfigurations.tests;



import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.elementtypesconfigurations.preferences.ElementTypesPreferences;
import org.eclipse.papyrus.infra.elementtypesconfigurations.registries.ElementTypeSetConfigurationRegistry;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Tests for {@link ElementTypesConfigurationsRegistry}
 */
public class ElementTypesRegistryTests extends AbstractElementTypeTests implements ITestConstants {

	/**
	 * Test registration based on plugin declaration
	 */
	@Ignore
	@Test
	// transcoded from extended types framework
	public final void testGetTypeRegisteredInplugin() {
		// check standard class
		IElementType classType = ElementTypeRegistry.getInstance().getType(ORG_ECLIPSE_PAPYRUS_UML_CLASS);
		Assert.assertNotNull("Element type should be registered", classType);
		IElementType abstractClassType = ElementTypeRegistry.getInstance().getType(ABSTRACT_CLASS_TOOL);
		Assert.assertNotNull("Element type should be registered", abstractClassType);
	}

	/**
	 * Test workspace registration. Element type in the workspace, but element type set is not loaded
	 */
	@Ignore
	@Test
	// transcoded from extended types framework
	public final void testGetTypeRegisteredInWorkspaceNotLoaded() {
		checkPluginTypes();
		// no preference should be set for this test
		ElementTypesPreferences.unregisterWorkspaceDefinition(WORKSPACE_ELEMENT_TYPE_ID);
		// this should not be defined yet
		IElementType workspaceType = ElementTypeRegistry.getInstance().getType(WORKSPACE_ELEMENT_TYPE_TOOL);
		Assert.assertNull("Element type should not be registered yet", workspaceType);
	}

	/**
	 * Test workspace registration. Element type in the workspace, but element type set is not loaded
	 */
	@Ignore
	@Test
	// transcoded from extended types framework
	public final void testLoadUnloadWorkspaceSet() {
		// this should not be defined yet
		IElementType workspaceType = ElementTypeRegistry.getInstance().getType(WORKSPACE_ELEMENT_TYPE_TOOL);
		Assert.assertNull("Element type should not be registered yet", workspaceType);
		checkPluginTypes();
		// register
		System.out.println(WORKSPACE_ELEMENT_TYPE_ID + "=" + workspaceTestFile.getFullPath().toString());
		ElementTypesPreferences.registerWorkspaceDefinition(WORKSPACE_ELEMENT_TYPE_ID, workspaceTestFile.getFullPath().toString());
		ElementTypeSetConfigurationRegistry.getInstance().loadElementTypeSetConfiguration(WORKSPACE_ELEMENT_TYPE_ID);
		//
		workspaceType = ElementTypeRegistry.getInstance().getType(WORKSPACE_ELEMENT_TYPE_TOOL);
		Assert.assertNotNull("Element type should be registered", workspaceType);
		checkPluginTypes();
		// unregister
		ElementTypesPreferences.unregisterWorkspaceDefinition(WORKSPACE_ELEMENT_TYPE_ID);
		ElementTypeSetConfigurationRegistry.getInstance().unload(WORKSPACE_ELEMENT_TYPE_ID);
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
