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
 * This test case creates one Plug-in project with two dependencies.
 * After the project is created, the Plug-in will be reversed.
 *
 * Expected Model Explorer after the reverse:
 *
 * - model
 *		- Plug-in (PLUGIN_WITH_DEPS_PROJECT_NAME)
 *		- Bundle (org.eclipse.ui)
 *		- Bundle (org.eclipse.core.runtime)
 *
 */
public class TestPluginWithDependency extends AbstractADLTest {

	private static final String ECLIPSE_UI = "org.eclipse.ui";
	private static final String ECLIPSE_CORE_RUNTIME = "org.eclipse.core.runtime";

	@Before
	public void initializeWorkspace() {
		try {
			initModel();
			createReversiblePlugin(PLUGIN_WITH_DEPS_PROJECT_NAME);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		executeReverse(SIMPLE_REVERSE_DEPTH);
	}

	@Test
	public void testPluginWithDependencies() {
		// Three Components: The plug-in and the two dependencies
		assertEquals("The root uml model should have 3 packaged elements", 3, rootModel.getPackagedElements().size());

		// eclipse.ui
		PackageableElement element = rootModel.getPackagedElement(ECLIPSE_UI);

		assertTrue("The element " + ECLIPSE_UI + " in the UML model is not a Component", element instanceof Component);
		assertEquals("The element " + ECLIPSE_UI + " should have 1 applied stereotype", 1, element.getAppliedStereotypes().size());

		Stereotype stereotype = element.getAppliedStereotype(OSGIStereotypes.BUNDLE);
		assertNotNull("The Plugin stereotype has not been applied on element " + ECLIPSE_UI, stereotype);

		// eclipse.core.runtime
		element = rootModel.getPackagedElement(ECLIPSE_CORE_RUNTIME);

		assertTrue("The element " + ECLIPSE_CORE_RUNTIME + " in the UML model is not a Component", element instanceof Component);
		assertEquals("The element " + ECLIPSE_CORE_RUNTIME + " should have 1 applied stereotype", 1, element.getAppliedStereotypes().size());

		stereotype = element.getAppliedStereotype(OSGIStereotypes.BUNDLE);
		assertNotNull("The Plugin stereotype has not been applied on element " + ECLIPSE_UI, stereotype);

		// Plugin
		element = rootModel.getPackagedElement(PLUGIN_WITH_DEPS_PROJECT_NAME);

		assertTrue("The element " + PLUGIN_WITH_DEPS_PROJECT_NAME + " in the UML model is not a Component", element instanceof Component);
		assertEquals("The element " + PLUGIN_WITH_DEPS_PROJECT_NAME + " should have 1 applied stereotype", 1, element.getAppliedStereotypes().size());

		stereotype = element.getAppliedStereotype(ADL4Eclipse_Stereotypes.PLUGIN_STEREOTYPE);
		assertNotNull("The Plugin stereotype has not been applied on element " + ECLIPSE_UI, stereotype);
	}
}
