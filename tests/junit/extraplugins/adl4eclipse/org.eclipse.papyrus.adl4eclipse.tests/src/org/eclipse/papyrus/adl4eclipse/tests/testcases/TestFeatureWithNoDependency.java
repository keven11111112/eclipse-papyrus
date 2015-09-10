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
 * This test case creates one Feature project, reverses it and checks the model's values.
 *
 * Expected Model Explorer after the reverse:
 *
 * - model
 *		- Feature (EMPTY_FEATURE_PROJECT_NAME)
 *
 */
public class TestFeatureWithNoDependency extends AbstractADLTest {

	@Before
	public void initializeWorkspace() {
		try {
			initModel();
			// Create an empty feature
			createReversibleFeature(EMPTY_FEATURE_PROJECT_NAME);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		executeReverse(SIMPLE_REVERSE_DEPTH);
	}

	@Test
	public void testFeatureWithNoPlugin() {
		PackageableElement feature = rootModel.getPackagedElement(EMPTY_FEATURE_PROJECT_NAME);

		assertNotNull("The modeled feature should exist", feature);
		assertTrue("The element in the UML model should be a Component", feature instanceof Component);
		assertEquals("The feature should have one applied stereotype", 1, feature.getAppliedStereotypes().size());

		Stereotype stereotype = feature.getApplicableStereotype(ADL4Eclipse_Stereotypes.FEATURE_STEREOTYPE);

		assertNotNull("The Feature stereotype should be applied to the feature component", stereotype);

		// Description
		Object description = feature.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_DESCRIPTION_ATT);
		assertEquals("The feature should have a description", "EmptyFeature description.", description);

		// Copyright
		Object copyright = feature.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_COPYRIGHT_ATT);
		assertEquals("The feature should have a copyright", "EmptyFeature copyright.", copyright);

		// License
		Object license = feature.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_LICENSE_ATT);
		assertEquals("The feature should have a license", "EmptyFeature license.", license);

		// Provider
		Object provider = feature.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_PROVIDER_ATT);
		assertNull("The feature should not have any provider", provider);

		// URL
		Object url = feature.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_URL_ATT);
		assertNull("The feature should not have any url", url);

		// Plug-ins
		Object plugins = feature.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_PLUGINS_ATT);
		assertEquals("The plug-in list size should be equals to 0", 0, ((List<?>) plugins).size());

		// Included features
		Object includedFeatures = feature.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_FEATURE_DEPENDENCIES_ATT);
		assertEquals("The included feature list size should be equals to 0", 0, ((List<?>) includedFeatures).size());

		// ImportedFeatures
		Object importedFeatures = feature.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_INCLUDED_FEATURES_ATT);
		assertEquals("The imported feature list size should be equals to 0", 0, ((List<?>) importedFeatures).size());

		// Label
		Object label = feature.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_LABEL_ATT);
		assertEquals("The feature label should correspond", EMPTY_FEATURE_PROJECT_NAME, label);

		// Id
		Object id = feature.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_ID_ATT);
		assertEquals("The feature id should correspond", EMPTY_FEATURE_PROJECT_NAME, id);

		// Version
		Object version = feature.getValue(stereotype, ADL4Eclipse_Stereotypes.FEATURE_VERSION_ATT);
		assertEquals("The version should correspond", "1.0.0.qualifier", version);
	}
}
