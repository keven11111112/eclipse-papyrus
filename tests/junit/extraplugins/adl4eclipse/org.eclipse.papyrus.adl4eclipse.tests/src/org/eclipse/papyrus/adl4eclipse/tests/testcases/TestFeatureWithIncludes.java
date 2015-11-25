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
 * This test case creates two Feature projects (the main feature and an empty feature).
 * The empty feature project will be included in the Feature project.
 * After the projects creation, the main feature will be reversed.
 *
 * Expected Model Explorer after the reverse:
 *
 * - model
 *		- Features
 *			- Feature (FEATURE_WITH_INCLUDES_PROJECT_NAME)
 *			- Feature (EMPTY_FEATURE_PROJECT_NAME)
 *
 */
public class TestFeatureWithIncludes extends AbstractADLTest {

	@Before
	public void initializeWorkspace() {
		try {
			initModel();

			// Create an empty feature
			createReversibleFeature(EMPTY_FEATURE_PROJECT_NAME);

			// Create a feature with included features
			createReversibleFeature(FEATURE_WITH_INCLUDES_PROJECT_NAME);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		executeReverse(SIMPLE_REVERSE_DEPTH);
	}

	@Test
	public void testTwoChildren() {
		List<PackageableElement> packageableElements = rootModel.getPackagedElements();

		// Two children: "Architecture" and "Platform" packages
		assertEquals("The root model should have 2 packaged elements", 2, packageableElements.size());

		assertTrue("The reversed project should be a Component", packageableElements.get(0) instanceof Component);
		assertTrue("The reversed project should be a Component", packageableElements.get(1) instanceof Component);
	}

	@Test
	public void testFeatureExists() {
		PackageableElement feature = rootModel.getPackagedElement(FEATURE_WITH_INCLUDES_PROJECT_NAME);

		assertNotNull("The modeled feature should exist", feature);
		assertTrue("The element in the UML model should be a Component", feature instanceof Component);
		assertEquals("The feature should have one applied stereotype", 1, feature.getAppliedStereotypes().size());

		Stereotype featureStereotype = feature.getApplicableStereotype(ADL4Eclipse_Stereotypes.FEATURE_STEREOTYPE);

		assertNotNull("The Feature stereotype should be applied to the feature component", featureStereotype);
	}

	@Test
	public void testIncludedFeatureExists() {
		PackageableElement includedFeature = rootModel.getPackagedElement(FEATURE_WITH_INCLUDES_PROJECT_NAME);

		assertNotNull("The modeled included feature should exist", includedFeature);
		assertTrue("The included feature element in the UML model should be a Component", includedFeature instanceof Component);
		assertEquals("The feature should have one applied stereotype", 1, includedFeature.getAppliedStereotypes().size());

		Stereotype featureStereotype = includedFeature.getApplicableStereotype(ADL4Eclipse_Stereotypes.FEATURE_STEREOTYPE);

		assertNotNull("The Feature stereotype should be applied to the included feature component", featureStereotype);
	}

	@Test
	public void testFeatureStereotype() {
		PackageableElement feature = rootModel.getPackagedElement(FEATURE_WITH_INCLUDES_PROJECT_NAME);
		Stereotype featureStereotype = feature.getApplicableStereotype(ADL4Eclipse_Stereotypes.FEATURE_STEREOTYPE);

		// Plug-ins
		Object plugins = feature.getValue(featureStereotype, ADL4Eclipse_Stereotypes.FEATURE_PLUGINS_ATT);
		assertEquals("The plug-in list size should be equals to 0", 0, ((List<?>) plugins).size());

		// Included features
		Object includedFeatures = feature.getValue(featureStereotype, ADL4Eclipse_Stereotypes.FEATURE_FEATURE_DEPENDENCIES_ATT);
		assertEquals("The included feature list size should be equals to 0", 0, ((List<?>) includedFeatures).size());

		// ImportedFeatures
		Object importedFeatures = feature.getValue(featureStereotype, ADL4Eclipse_Stereotypes.FEATURE_INCLUDED_FEATURES_ATT);
		assertEquals("The imported feature list size should be equals to 1", 1, ((List<?>) importedFeatures).size());
	}

	@Test
	public void testIncludedFeatureStereotype() {
		PackageableElement includedFeature = rootModel.getPackagedElement(EMPTY_FEATURE_PROJECT_NAME);
		Stereotype featureStereotype = includedFeature.getApplicableStereotype(ADL4Eclipse_Stereotypes.FEATURE_STEREOTYPE);

		Object version = includedFeature.getValue(featureStereotype, "version");
		assertEquals("The imported feature version should correspond", "1.0.0.qualifier", version);

		Object label = includedFeature.getValue(featureStereotype, "label");
		assertEquals("The imported feature label should correspond", EMPTY_FEATURE_PROJECT_NAME, label);

		// Plug-ins
		Object plugins = includedFeature.getValue(featureStereotype, ADL4Eclipse_Stereotypes.FEATURE_PLUGINS_ATT);
		assertEquals("The plug-in list size should be equals to 0", 0, ((List<?>) plugins).size());

		// Included features
		Object includedFeatures = includedFeature.getValue(featureStereotype, ADL4Eclipse_Stereotypes.FEATURE_FEATURE_DEPENDENCIES_ATT);
		assertEquals("The included feature list size should be equals to 0", 0, ((List<?>) includedFeatures).size());

		// ImportedFeatures
		Object importedFeatures = includedFeature.getValue(featureStereotype, ADL4Eclipse_Stereotypes.FEATURE_INCLUDED_FEATURES_ATT);
		assertEquals("The imported feature list size should be equals to 0", 0, ((List<?>) importedFeatures).size());
	}
}
