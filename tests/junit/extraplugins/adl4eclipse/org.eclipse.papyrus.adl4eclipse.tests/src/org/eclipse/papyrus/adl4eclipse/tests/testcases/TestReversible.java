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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.papyrus.adl4eclipse.tests.AbstractADLTest;
import org.eclipse.papyrus.adltool.reversible.project.ReversibleProject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestReversible extends AbstractADLTest {
	private ReversibleProject emptyPlugin;
	private ReversibleProject secondEmptyPlugin;
	private ReversibleProject pluginWithDependencies;
	private ReversibleProject emptyFeature;

	@Before
	public void setUp() {
		try {
			emptyPlugin = createReversiblePlugin(EMPTY_PLUGIN_PROJECT_NAME);
			secondEmptyPlugin = createReversiblePlugin(EMPTY_PLUGIN_PROJECT_NAME);
			pluginWithDependencies = createReversiblePlugin(PLUGIN_WITH_DEPS_PROJECT_NAME);
			emptyFeature = createReversibleFeature(EMPTY_FEATURE_PROJECT_NAME);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		assertNotNull("The reversible project is null", emptyPlugin);
		assertNotNull("The second reversible project is null", secondEmptyPlugin);
		assertNotNull("The reversible plugin with dependencies is null", pluginWithDependencies);
		assertNotNull("The reversible empty feature project is null", emptyFeature);
	}

	@Test
	public void testEquals() {
		assertTrue("The reversible projects are not equals", emptyPlugin.equals(secondEmptyPlugin));
		assertTrue("The reversible project not equals to itself", emptyPlugin.equals(emptyPlugin));
		assertFalse("The reversible empty project equals to the reversible plugin with dependencies", emptyPlugin.equals(pluginWithDependencies));
		assertFalse("The reversible project equals null", emptyPlugin.equals(null));
		assertFalse("The reversible empty project equals the reversible empty feature project", emptyPlugin.equals(emptyFeature));
		assertFalse("The reversible empty project is equals to is project name", emptyPlugin.equals(EMPTY_PLUGIN_PROJECT_NAME));
	}

	@Test
	public void testSet() {
		Set<ReversibleProject> set = new HashSet<>();

		assertTrue("The reversible project was not added to the set", set.add(emptyPlugin));

		assertFalse("A duplicate reversible project should not be added to the set", set.add(secondEmptyPlugin));
		assertEquals("The set size should be 1", 1, set.size());

		assertTrue("The reversible plugin with dependencies project was not added to the set", set.add(pluginWithDependencies));
		assertEquals("The set size should be 2", 2, set.size());
	}

}
