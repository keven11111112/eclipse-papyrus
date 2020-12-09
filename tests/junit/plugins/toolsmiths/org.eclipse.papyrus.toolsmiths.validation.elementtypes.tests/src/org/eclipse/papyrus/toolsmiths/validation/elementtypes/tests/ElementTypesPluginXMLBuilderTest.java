/*****************************************************************************
 * Copyright (c) 2020 Christian W. Damus, CEA LIST, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.toolsmiths.validation.elementtypes.tests;

import static org.eclipse.papyrus.junit.matchers.WorkspaceMatchers.isMarkerMessage;
import static org.eclipse.papyrus.junit.matchers.WorkspaceMatchers.isMarkerSeverity;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.toolsmiths.validation.elementtypes.tests.TestProjectFixture.Build;
import org.eclipse.papyrus.toolsmiths.validation.elementtypes.tests.TestProjectFixture.OverlayFile;
import org.eclipse.papyrus.toolsmiths.validation.elementtypes.tests.TestProjectFixture.TestProject;
import org.junit.Rule;
import org.junit.Test;

/**
 * Test cases for the <em>Element Types Configurations</em> validation of <tt>plugin.xml</tt>
 * in the project builder.
 */
@TestProject("org.eclipse.papyrus.toolsmiths.validation.elementtypes.example")
@Build
public class ElementTypesPluginXMLBuilderTest extends AbstractPapyrusTest {

	/**
	 * The project fixture to manage easily the project.
	 */
	@Rule
	public final TestProjectFixture fixture = new TestProjectFixture();

	/**
	 * Test the reporting of a missing extension point where the extension point is just entirely missing.
	 */
	@Test
	@OverlayFile(value = "bug569357-extensions/plugin-noExtension.xml", path = "plugin.xml")
	public void noExtension() {
		final List<IMarker> modelMarkers = fixture.getMarkers("plugin.xml"); //$NON-NLS-1$

		assertThat(modelMarkers, hasItem(both(isMarkerSeverity(IMarker.SEVERITY_WARNING)).and(isMarkerMessage(containsString("Missing extension"))))); //$NON-NLS-1$
	}

	/**
	 * Test the reporting of a missing client-context ID where the extension point is otherwise present.
	 */
	@Test
	@OverlayFile(value = "bug569357-extensions/plugin-noClientContext.xml", path = "plugin.xml")
	public void noClientContext() {
		final List<IMarker> modelMarkers = fixture.getMarkers("plugin.xml"); //$NON-NLS-1$

		assertThat(modelMarkers, hasItem(both(isMarkerSeverity(IMarker.SEVERITY_ERROR)).and(isMarkerMessage(containsString("client context ID"))))); //$NON-NLS-1$
	}

	/**
	 * Test that an extension that references a non-existent element types model file does not report
	 * an error from our builder because that is covered by the PDE Builder.
	 */
	@Test
	@OverlayFile(value = "bug569357-extensions/plugin-wrongPath.xml", path = "plugin.xml")
	public void noSuchModelFile() {
		final List<IMarker> modelMarkers = fixture.getMarkers("plugin.xml"); //$NON-NLS-1$

		assertThat(modelMarkers, not(hasItem(anything())));
	}

}
