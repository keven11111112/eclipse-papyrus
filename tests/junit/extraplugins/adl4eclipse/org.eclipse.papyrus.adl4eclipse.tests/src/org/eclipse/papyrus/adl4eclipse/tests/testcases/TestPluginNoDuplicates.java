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
import org.eclipse.papyrus.adl4eclipse.org.ADL4Eclipse_Stereotypes;
import org.eclipse.papyrus.adl4eclipse.tests.AbstractADLTest;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.Assert;
import org.junit.Test;

/**
 * This test case creates two Plug-in projects (one empty).
 * The empty Plug-in project will be set as required in the main Plug-in project.
 * After the projects creation, the main Plug-in will be reversed.
 *
 * Expected Model Explorer after the reverse:
 *
 * - model
 * 		-Plugins
 *			- Plug-in (PLUGIN_WITH_DUPLICATE_DEPS_PROJECT_NAME)
 *			- Plug-in (EMPTY_PLUGIN_PROJECT_NAME)
 *
 */
public class TestPluginNoDuplicates extends AbstractADLTest {

	/**
	 * Checks if the Empty plug-in does not appear twice in the Model Explorer.
	 */
	@Test
	public void testNoDuplicates() {
		try {
			initModel();
			createReversiblePlugin(EMPTY_PLUGIN_PROJECT_NAME);
			createReversiblePlugin(PLUGIN_WITH_DUPLICATE_DEPS_PROJECT_NAME);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		executeReverse(SIMPLE_REVERSE_DEPTH);

		// Two components: The empty and main plug-ins
		assertEquals("There should be only two element in the root uml model", 2, rootModel.getPackagedElements().size());

		PackageableElement mainPlugin = rootModel.getPackagedElement(PLUGIN_WITH_DUPLICATE_DEPS_PROJECT_NAME);
		PackageableElement emptyPlugin = rootModel.getPackagedElement(EMPTY_PLUGIN_PROJECT_NAME);

		assertNotNull("The main plug-in should exist", mainPlugin);
		assertNotNull("The empty plug-in should exist", emptyPlugin);

		Stereotype mainStereotype = mainPlugin.getAppliedStereotype(ADL4Eclipse_Stereotypes.PLUGIN_STEREOTYPE);
		Stereotype emptyStereotype = emptyPlugin.getApplicableStereotype(ADL4Eclipse_Stereotypes.PLUGIN_STEREOTYPE);

		assertNotNull("The main plug-in should have the Plugin stereotype", mainStereotype);
		assertNotNull("The empty plug-in should have the Plugin stereotype", emptyStereotype);
	}
}
