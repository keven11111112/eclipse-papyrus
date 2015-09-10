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

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.adl4eclipse.org.ADL4Eclipse_Stereotypes;
import org.eclipse.papyrus.adl4eclipse.tests.AbstractADLTest;
import org.eclipse.papyrus.osgi.profile.OSGIStereotypes;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPluginWithPackages extends AbstractADLTest {

	@Before
	public void initWorkspace() {
		try {
			initModel();
			createReversiblePlugin(PLUGIN_WITH_PACKAGES_PROJECT_NAME);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		executeReverse(SIMPLE_REVERSE_DEPTH);
	}

	@Test
	public void testPluginWithPackages() {
		// One Components: The plug-in itself
		assertEquals("The root uml model should have 1 packaged elements", 1, rootModel.getPackagedElements().size());

		PackageableElement element = rootModel.getPackagedElement(PLUGIN_WITH_PACKAGES_PROJECT_NAME);
		assertTrue("The element " + PLUGIN_WITH_PACKAGES_PROJECT_NAME + " is not a component", element instanceof Component);

		Component plugin = (Component) element;

		Stereotype pluginStereotype = plugin.getAppliedStereotype(ADL4Eclipse_Stereotypes.PLUGIN_STEREOTYPE);
		assertNotNull("The plug-in's stereotype is null", pluginStereotype);

		// The reversed package and the dependency
		assertEquals("The plug-in should have two packaged element", 2, plugin.getPackagedElements().size());

		EList<PackageableElement> packagedElements = plugin.getPackagedElements();

		for (PackageableElement packageableElement : packagedElements) {
			if (packageableElement instanceof Dependency) {
				Stereotype depStereotype = packageableElement.getAppliedStereotype(OSGIStereotypes.PACKAGE_REFERENCE);
				assertNotNull("The dependency's stereotype is null", depStereotype);
			}

			if (packageableElement instanceof Package) {
				Stereotype packageStereotype = packageableElement.getAppliedStereotype(OSGIStereotypes.EXPORTED_PACKAGE_STEREOTYPE);
				assertNotNull("The package's stereotype is null", packageStereotype);
			}
		}

		// TODO: Check the stereotypes values
	}

}
