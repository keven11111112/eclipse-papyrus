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

import org.eclipse.papyrus.adl4eclipse.tests.AbstractADLTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPluginWithExtension extends AbstractADLTest {

	private static final String ECLIPSE_UI = "org.eclipse.ui";

	@Before
	public void initWorkspace() {
		try {
			initModel();
			createReversiblePlugin(PLUGIN_WITH_EXTENSION_PROJECT_NAME);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		executeReverse(SIMPLE_REVERSE_DEPTH);

		// TODO: Fix the org.eclipse.debug.core.DebugException: com.sun.jdi.ClassNotLoadedException: Type has not been loaded occurred while retrieving component type of array.
		// This is thrown because ADL4Eclipse uses PDE to retrieve extension points. See ADL4EclipseUtils.findExtensionPointsForPlugin(String)
	}

	@Test
	public void testPluginWithExtension() {
		/*
		// Four Components: The plug-in and the three dependencies
		assertEquals("The root uml model should have 4 packaged elements", 4, rootModel.getPackagedElements().size());

		PackageableElement bundleElement = rootModel.getPackagedElement(ECLIPSE_UI);

		assertTrue("The bundle is not a Component", bundleElement instanceof Component);

		Component eclipseUI = (Component) bundleElement;
		Stereotype bundleStereotype = eclipseUI.getAppliedStereotype(OSGIStereotypes.BUNDLE);
		assertNotNull("The bundle's stereotype is null", bundleStereotype);

		assertEquals("The bundle should have only one packaged element", 1, eclipseUI.getPackagedElements().size());

		PackageableElement extensionPoint = eclipseUI.getPackagedElements().get(0);
		assertTrue("The extension point is not a Component", extensionPoint instanceof Component);

		PackageableElement pluginElement = rootModel.getPackagedElement(PLUGIN_WITH_EXTENSION_PROJECT_NAME);
		assertTrue("The plug-in is not a Component", pluginElement instanceof Component);

		Component plugin = (Component) pluginElement;
		Stereotype pluginStereotype = plugin.getAppliedStereotype(ADL4Eclipse_Stereotypes.PLUGIN_STEREOTYPE);
		assertNotNull("The plug-in's stereotype is null", pluginStereotype);

		EList<Element> ownedElements = plugin.getOwnedElements();
		EList<Port> ownedPorts = plugin.getOwnedPorts();

		// The 3 dependencies and the 3 properties
		assertEquals("The plug-in should have six owned elements", 6, ownedElements.size());
		assertEquals("The plug-in should have one port", 1, ownedPorts.size());

		Port port = ownedPorts.get(0);
		assertEquals("The port type should be the extension point", extensionPoint, port.getType());
		 */
	}

}
