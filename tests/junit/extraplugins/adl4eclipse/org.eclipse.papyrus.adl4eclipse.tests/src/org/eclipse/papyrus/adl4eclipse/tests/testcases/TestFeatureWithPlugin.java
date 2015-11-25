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

import java.util.List;

import org.eclipse.papyrus.adl4eclipse.org.ADL4Eclipse_Stereotypes;
import org.eclipse.papyrus.adl4eclipse.tests.AbstractADLTest;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This test case creates an empty Plug-in project and a Feature project.
 * The Plug-in project will be packaged in the Feature project.
 * After the projects creation, the feature will be reversed.
 *
 * Expected Model Explorer after the reverse:
 *
 * - model
 *		- Feature (FEATURE_WITH_PLUGINS_PROJECT_NAME)
 *		- Plug-in (EMPTY_PLUGIN_PROJECT_NAME)
 */
public class TestFeatureWithPlugin extends AbstractADLTest {

	@Before
	public void initializeWorkspace() {
		try {
			initModel();
			// Create an empty feature
			createReversiblePlugin(EMPTY_PLUGIN_PROJECT_NAME);

			// Create a feature with imported features
			createReversibleFeature(FEATURE_WITH_PLUGINS_PROJECT_NAME);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		executeReverse(SIMPLE_REVERSE_DEPTH);
	}

	@Test
	public void testTwoReversedProjects() {
		// Two elements: The feature and the plug-in
		assertEquals("The feature should be reversed", 2, rootModel.getPackagedElements().size());
	}

	@Test
	public void testFeatureExists() {
		PackageableElement feature = rootModel.getPackagedElement(FEATURE_WITH_PLUGINS_PROJECT_NAME);

		assertNotNull("The modeled feature should exist", feature);
		assertTrue("The element in the UML model should be a Component", feature instanceof Component);
		assertEquals("The feature should have one applied stereotype", 1, feature.getAppliedStereotypes().size());

		Stereotype featureStereotype = feature.getApplicableStereotype(ADL4Eclipse_Stereotypes.FEATURE_STEREOTYPE);

		assertNotNull("The Feature stereotype should be applied to the feature component", featureStereotype);
	}

	@Test
	public void testPluginExists() {
		PackageableElement plugin = rootModel.getPackagedElement(EMPTY_PLUGIN_PROJECT_NAME);

		assertNotNull("The modeled plug-in should exist", plugin);
		assertTrue("The plug-in in the UML model should be a Component", plugin instanceof Component);
		assertEquals("The plug-in should have one applied stereotype", 1, plugin.getAppliedStereotypes().size());

		Stereotype pluginStereotype = plugin.getApplicableStereotype(ADL4Eclipse_Stereotypes.FEATURE_STEREOTYPE);

		assertNotNull("The Plug-in stereotype should be applied to the plugin component", pluginStereotype);
	}

	@Test
	public void testFeatureStereotype() {
		PackageableElement feature = rootModel.getPackagedElement(FEATURE_WITH_PLUGINS_PROJECT_NAME);
		Stereotype featureStereotype = feature.getApplicableStereotype(ADL4Eclipse_Stereotypes.FEATURE_STEREOTYPE);

		// Plug-ins
		Object plugins = feature.getValue(featureStereotype, ADL4Eclipse_Stereotypes.FEATURE_PLUGINS_ATT);
		assertEquals("The plug-in list size should be equals to 1", 1, ((List<?>) plugins).size());

		// Included features
		Object includedFeatures = feature.getValue(featureStereotype, ADL4Eclipse_Stereotypes.FEATURE_FEATURE_DEPENDENCIES_ATT);
		assertEquals("The included feature list size should be equals to 0", 0, ((List<?>) includedFeatures).size());

		// ImportedFeatures
		Object importedFeatures = feature.getValue(featureStereotype, ADL4Eclipse_Stereotypes.FEATURE_INCLUDED_FEATURES_ATT);
		assertEquals("The imported feature list size should be equals to 0", 0, ((List<?>) importedFeatures).size());
	}
}
