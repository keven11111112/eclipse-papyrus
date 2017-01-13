/*****************************************************************************
 * Copyright (c) 2017 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.migration.rsa.tests.regression;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.migration.rsa.tests.PostProcessor;
import org.eclipse.papyrus.migration.rsa.tests.regression.AbstractMigrationRegressionTest.TransformationExtensionClass;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Type;
import org.junit.Test;

/**
 * Specific regression tests for bugs in the post-processing phase of import.
 */
@TransformationExtensionClass(PostProcessor.class)
public class PostProcessingExtensionTest extends AbstractMigrationRegressionTest {

	/**
	 * Initializes me.
	 */
	public PostProcessingExtensionTest() {
		super();
	}

	/**
	 * @see <a href="http://eclip.se/505330">bug 505330</a>
	 */
	@Test
	@PluginResource("fragments/Blank Package.emx")
	public void postProcessExtensionsInvoked() throws Exception {
		assertThat(rootPackage.getName(), is("123 Blank Package"));

		Package fragment = rootPackage.getNestedPackage("123 Package - Fragment");
		assertThat("Fragment package not renamed", fragment, notNullValue());

		Type interface_ = fragment.getOwnedType("123 Interface2");
		assertThat("Interface in fragment not renamed", interface_, notNullValue());

		Type class_ = fragment.getOwnedType("123 Class2");
		assertThat("Class in fragment not renamed", class_, notNullValue());
	}

}
