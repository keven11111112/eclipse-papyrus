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
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestFeatureReverseTwice extends AbstractADLTest {

	@Before
	public void initializeWorkspace() {
		try {
			initModel();

			// Create a feature with imported features
			createReversibleFeature(EMPTY_FEATURE_PROJECT_NAME);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		executeReverse(SIMPLE_REVERSE_DEPTH);
		executeReverse(SIMPLE_REVERSE_DEPTH);
	}

	@Test
	public void testFeatureExists() {
		// Two elements: The feature
		assertEquals("The feature should be reversed", 1, rootModel.getPackagedElements().size());

		PackageableElement feature = rootModel.getPackagedElement(EMPTY_FEATURE_PROJECT_NAME);

		assertNotNull("The modeled feature should exist", feature);
		assertTrue("The element in the UML model should be a Component", feature instanceof Component);
		assertEquals("The feature should have one applied stereotype", 1, feature.getAppliedStereotypes().size());

		Stereotype featureStereotype = feature.getApplicableStereotype(ADL4Eclipse_Stereotypes.FEATURE_STEREOTYPE);

		assertNotNull("The Feature stereotype should be applied to the feature component", featureStereotype);
	}

}
