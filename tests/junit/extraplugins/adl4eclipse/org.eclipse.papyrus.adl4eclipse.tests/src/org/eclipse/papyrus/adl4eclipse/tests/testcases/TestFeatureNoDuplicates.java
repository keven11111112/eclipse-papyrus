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
import java.util.List;

import org.eclipse.papyrus.adl4eclipse.tests.AbstractADLTest;
import org.eclipse.uml2.uml.PackageableElement;
import org.junit.Assert;
import org.junit.Test;

/**
 * This test case creates two Feature projects (the main feature and an empty feature).
 * The empty feature project will be included and set a required in the Feature project.
 * After the projects creation, the main feature will be reversed.
 *
 * Expected Model Explorer after the reverse:
 *
 * - model
 *		- Feature (FEATURE_WITH_DUPLICATES_PROJECT_NAME)
 *		- Feature (EMPTY_FEATURE_PROJECT_NAME)
 *
 */
public class TestFeatureNoDuplicates extends AbstractADLTest {

	/**
	 * Checks if the Empty feature does not appear twice in the Model Explorer.
	 */
	@Test
	public void testNoDuplicates() {
		try {
			initModel();
			createReversibleFeature(EMPTY_FEATURE_PROJECT_NAME);
			createReversibleFeature(FEATURE_WITH_DUPLICATES_PROJECT_NAME);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		executeReverse(SIMPLE_REVERSE_DEPTH);

		// One element: The features package

		List<PackageableElement> features = rootModel.getPackagedElements();

		assertEquals("The features package should have 2 features", 2, features.size());
	}
}
