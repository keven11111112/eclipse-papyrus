/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thomas Daniellou (CEA LIST) - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.adl4eclipse.tests.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.papyrus.adl4eclipse.org.ADL4Eclipse_Stereotypes;
import org.eclipse.papyrus.adl4eclipse.tests.AbstractADLTest;
import org.eclipse.papyrus.osgi.profile.OSGIStereotypes;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This test case creates one Plug-in project, reverses it and checks the model's values.
 *
 * Expected Model Explorer after the reverse:
 *
 * - model
 * 		- Plugins
 *			- Plug-in (EMPTY_PLUGIN_PROJECT_NAME)
 *
 */
public class TestPluginWithNoDependency extends AbstractADLTest {

	/**
	 * Initializes the workspace by creating one Plug-in Project with no dependencies.
	 */
	@Before
	public void initWorkspace() {
		try {
			initModel();
			createReversiblePlugin(EMPTY_PLUGIN_PROJECT_NAME);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		executeReverse(SIMPLE_REVERSE_DEPTH);
	}

	@Test
	public void testPluginWithNoDependency() {
		// No dependency means only 1 stereotyped component (the plug-in) in the UML model
		assertEquals("There should be only one element in the root uml model", 1, rootModel.getPackagedElements().size());

		PackageableElement plugin = rootModel.getPackagedElement(EMPTY_PLUGIN_PROJECT_NAME);

		assertNotNull("The plugin should be in the root model", plugin);
		assertTrue("The element in the UML model should be a Component", plugin instanceof Component);
		assertEquals("The plugin should have one applied stereotype", 1, plugin.getAppliedStereotypes().size());

		Stereotype stereotype = plugin.getAppliedStereotype(ADL4Eclipse_Stereotypes.PLUGIN_STEREOTYPE);

		assertNotNull("The Plugin stereotype should be applied to the model component", stereotype);

		Object bundleActivator = plugin.getValue(stereotype, OSGIStereotypes.BUNDLE_ACTIVATOR_ATT);
		assertNull("The bundle activator should be null", bundleActivator);

		Object version = plugin.getValue(stereotype, OSGIStereotypes.BUNDLE_VERSION_ATT);
		assertEquals("The plugin version should correspond", "1.0.0.qualifier", version);

		Object symbolicName = plugin.getValue(stereotype, OSGIStereotypes.BUNDLE_SYMBOLICNAME_ATT);
		assertEquals("The symbolic name should correspond", EMPTY_PLUGIN_PROJECT_NAME, symbolicName);

		Object pluginName = plugin.getValue(stereotype, OSGIStereotypes.BUNDLE_NAME_ATT);
		assertEquals("The plugin name should correspond", EMPTY_PLUGIN_PROJECT_NAME, pluginName);

		Object requiredExecutionEnv = plugin.getValue(stereotype, OSGIStereotypes.BUNDLE_REQUIREDEXECUTIONENVIRONMENT_ATT);
		assertEquals("The required execution environment should correspond", "JavaSE-1.8", requiredExecutionEnv);
	}
}
