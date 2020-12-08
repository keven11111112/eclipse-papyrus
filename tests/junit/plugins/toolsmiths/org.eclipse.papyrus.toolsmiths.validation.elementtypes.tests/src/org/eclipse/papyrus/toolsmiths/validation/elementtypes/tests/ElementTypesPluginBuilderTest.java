/*****************************************************************************
 * Copyright (c) 2019, 2020 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Nicolas FAUVERGUE (CEA LIST) nicolas.fauvergue@cea.fr - Initial API and implementation
 *   Christian W. Damus - bug 569357
 *
 *****************************************************************************/
package org.eclipse.papyrus.toolsmiths.validation.elementtypes.tests;

import static org.eclipse.papyrus.junit.matchers.MoreMatchers.greaterThanOrEqual;
import static org.eclipse.papyrus.junit.matchers.MoreMatchers.hasAtLeast;
import static org.eclipse.papyrus.junit.matchers.WorkspaceMatchers.isMarkerSeverity;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.toolsmiths.validation.elementtypes.tests.TestProjectFixture.Build;
import org.eclipse.papyrus.toolsmiths.validation.elementtypes.tests.TestProjectFixture.TestProject;
import org.junit.Rule;
import org.junit.Test;

/**
 * Test cases for the <em>Element Types Configurations</em> project builder configurations.
 */
public class ElementTypesPluginBuilderTest extends AbstractPapyrusTest {

	/**
	 * The project fixture to manage easily the project.
	 */
	@Rule
	public final TestProjectFixture fixture = new TestProjectFixture();

	/**
	 * Test the reporting of problems on the element types model resource.
	 */
	@Test
	@TestProject("org.eclipse.papyrus.toolsmiths.validation.elementtypes.example")
	@Build
	public void testModelValidation() {
		final List<IMarker> modelMarkers = fixture.getMarkers("resources/BookStore.elementtypesconfigurations"); //$NON-NLS-1$
		assertThat("The number of markers for model file is not correct", modelMarkers.size(), greaterThanOrEqual(2)); //$NON-NLS-1$
		assertThat("The severity of the model markesr is not correct", modelMarkers, everyItem(isMarkerSeverity(IMarker.SEVERITY_ERROR))); //$NON-NLS-1$
	}

	/**
	 * Test the reporting of problems on the bundle manifest.
	 */
	@Test
	@TestProject("org.eclipse.papyrus.toolsmiths.validation.elementtypes.example")
	@Build
	public void testDependencyValidation() {
		final List<IMarker> dependenciesMarkers = fixture.getMarkers("META-INF/MANIFEST.MF"); //$NON-NLS-1$
		assertThat("The number of markers for dependencies is not correct", dependenciesMarkers.size(), greaterThanOrEqual(5)); //$NON-NLS-1$
		assertThat("The number of warning markers for dependencies is not correct", dependenciesMarkers, hasAtLeast(2, isMarkerSeverity(IMarker.SEVERITY_WARNING))); //$NON-NLS-1$
		assertThat("The number of error markers for dependencies is not correct", dependenciesMarkers, hasAtLeast(3, isMarkerSeverity(IMarker.SEVERITY_ERROR))); //$NON-NLS-1$
	}

	/**
	 * Test the reporting of problems on the <tt>plugin.xml</tt> file.
	 */
	@Test
	@TestProject("org.eclipse.papyrus.toolsmiths.validation.elementtypes.example")
	@Build
	public void testExtensionsValidation() {
		final List<IMarker> extensionsMarkers = fixture.getMarkers("plugin.xml"); //$NON-NLS-1$
		assertThat("The number of markers for extensions is not correct", extensionsMarkers.size(), greaterThanOrEqual(1)); //$NON-NLS-1$
		assertThat("Missing extension should be a warning", extensionsMarkers, hasItem(isMarkerSeverity(IMarker.SEVERITY_WARNING))); //$NON-NLS-1$
	}

}
